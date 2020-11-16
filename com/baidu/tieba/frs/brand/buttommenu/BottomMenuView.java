package com.baidu.tieba.frs.brand.buttommenu;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes21.dex */
public class BottomMenuView extends LinearLayout {
    private View fPU;
    private a iQm;
    private LinearLayout iQn;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    /* loaded from: classes21.dex */
    public interface a {
        void a(MenuItemView menuItemView, BottomMenu bottomMenu);

        void a(SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu);
    }

    public BottomMenuView(Context context) {
        this(context, null);
    }

    public BottomMenuView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomMenuView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
    }

    public void setOnMenuItemClickListener(a aVar) {
        this.iQm = aVar;
    }

    public void a(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        if (!y.isEmpty(list)) {
            this.mPageContext = tbPageContext;
            removeAllViews();
            this.fPU = new View(getContext());
            this.fPU.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds16)));
            this.fPU.setBackgroundResource(R.drawable.bottom_view_shadow);
            addView(this.fPU);
            this.iQn = new LinearLayout(getContext());
            this.iQn.setOrientation(0);
            this.iQn.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            addView(this.iQn);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                MenuItemView menuItemView = new MenuItemView(tbPageContext);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                menuItemView.setLayoutParams(layoutParams);
                menuItemView.setMenuData(list.get(i));
                menuItemView.setOnMenuItemClickListener(this.iQm);
                this.iQn.addView(menuItemView);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType && this.iQn != null) {
            this.mSkinType = i;
            int childCount = this.iQn.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.iQn.getChildAt(i2);
                if (childAt != null) {
                    if (childAt instanceof MenuItemView) {
                        ((MenuItemView) childAt).onChangeSkinType(tbPageContext, i);
                    } else {
                        ap.setBackgroundColor(childAt, R.color.CAM_X0204);
                    }
                } else {
                    return;
                }
            }
            ap.setBackgroundColor(this.fPU, R.color.CAM_X0204);
        }
    }

    /* loaded from: classes21.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener {
        private static final int iQo = R.drawable.icon_card_morelist_n;
        private a iQm;
        private int iQp;
        private ImageView iQq;
        private TextView iQr;
        private BottomMenu iQs;
        private boolean iQt;
        private b iQu;
        private TbPageContext<?> mPageContext;

        public MenuItemView(TbPageContext<?> tbPageContext) {
            super(tbPageContext.getPageActivity());
            this.iQp = iQo;
            setGravity(17);
            setOnClickListener(this);
            LayoutInflater.from(getContext()).inflate(R.layout.bottom_menu_item, this);
            this.mPageContext = tbPageContext;
            this.iQq = (ImageView) findViewById(R.id.item_image);
            this.iQr = (TextView) findViewById(R.id.item_text);
        }

        public void setOnMenuItemClickListener(a aVar) {
            this.iQm = aVar;
        }

        public void setMenuData(BottomMenu bottomMenu) {
            if (bottomMenu != null) {
                this.iQs = bottomMenu;
                this.iQt = y.getCount(bottomMenu.submenu) > 0;
                this.iQr.setText(bottomMenu.name);
                onChangeSkinType(this.mPageContext, 0);
            }
        }

        public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
            setMenuIcon(this.iQp);
            ap.setViewTextColor(this.iQr, R.color.CAM_X0105);
            ap.setBackgroundResource(this, R.drawable.addresslist_item_bg);
        }

        private void setMenuIcon(int i) {
            this.iQp = i;
            if (this.iQt) {
                this.iQq.setVisibility(0);
                this.iQq.setImageResource(i);
                ap.setImageResource(this.iQq, i);
                return;
            }
            this.iQq.setVisibility(8);
        }

        public e getPageContext() {
            return this.mPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.iQt) {
                getSubMenuGenerator().a(this, this.iQs.submenu);
            }
            if (this.iQm != null) {
                this.iQm.a(this, this.iQs);
            }
        }

        private b getSubMenuGenerator() {
            if (this.iQu == null) {
                this.iQu = new b();
                this.iQu.setOnMenuItemClickListener(this.iQm);
            }
            return this.iQu;
        }
    }

    /* loaded from: classes21.dex */
    public static class b implements View.OnClickListener {
        private a iQm;
        private RelativeLayout iQv;
        private final int[] mLocation = new int[2];
        private PopupWindow mPopupWindow;

        public void setOnMenuItemClickListener(a aVar) {
            this.iQm = aVar;
        }

        public void a(MenuItemView menuItemView, List<SubBottomMenu> list) {
            if (menuItemView != null && !y.isEmpty(list)) {
                Activity pageActivity = menuItemView.getPageContext().getPageActivity();
                this.iQv = new RelativeLayout(pageActivity);
                this.iQv.setBackgroundColor(ap.getColor(R.color.CAM_X0608));
                this.iQv.setOnClickListener(this);
                LinearLayout linearLayout = new LinearLayout(pageActivity);
                linearLayout.setOrientation(1);
                int size = list.size();
                int i = 0;
                while (i < size) {
                    SubMenuItemView subMenuItemView = new SubMenuItemView(pageActivity);
                    subMenuItemView.setSubMenuData(list.get(i), i, i == size + (-1));
                    subMenuItemView.setOnClickListener(this);
                    linearLayout.addView(subMenuItemView);
                    i++;
                }
                this.iQv.addView(linearLayout);
                menuItemView.getLocationInWindow(this.mLocation);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.width = menuItemView.getWidth();
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mLocation[0];
                this.mPopupWindow = new PopupWindow(this.iQv, -1, this.mLocation[1]);
                this.mPopupWindow.setOutsideTouchable(true);
                this.mPopupWindow.setFocusable(true);
                this.mPopupWindow.setClippingEnabled(false);
                this.mPopupWindow.setBackgroundDrawable(new ColorDrawable());
                this.mPopupWindow.setSoftInputMode(16);
                g.showPopupWindowAtLocation(this.mPopupWindow, menuItemView, 51, 0, 0);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view instanceof SubMenuItemView) {
                g.dismissPopupWindow(this.mPopupWindow);
                SubMenuItemView subMenuItemView = (SubMenuItemView) view;
                if (this.iQm != null) {
                    this.iQm.a(subMenuItemView, subMenuItemView.getSubMenuData());
                }
            } else if (view == this.iQv) {
                g.dismissPopupWindow(this.mPopupWindow);
            }
        }
    }

    /* loaded from: classes21.dex */
    public static class SubMenuItemView extends LinearLayout {
        private View eej;
        private SubBottomMenu iQw;
        private TextView mTitleView;

        public SubMenuItemView(Context context) {
            super(context);
            LayoutInflater.from(context).inflate(R.layout.bottom_submenu_item, this);
            setOrientation(1);
            this.mTitleView = (TextView) findViewById(R.id.item_text);
            this.eej = findViewById(R.id.divider_line);
        }

        public void setSubMenuData(SubBottomMenu subBottomMenu, int i, boolean z) {
            if (subBottomMenu != null) {
                this.iQw = subBottomMenu;
                this.mTitleView.setText(subBottomMenu.name);
                ap.setViewTextColor(this.mTitleView, R.color.CAM_X0106);
                ap.setBackgroundResource(this, i == 0 ? R.drawable.bottom_menu_item_bg_corner_selector : R.drawable.bottom_menu_item_bg_selector);
                if (z) {
                    this.eej.setVisibility(8);
                    return;
                }
                this.eej.setVisibility(0);
                ap.setBackgroundColor(this.eej, R.color.CAM_X0204);
            }
        }

        public SubBottomMenu getSubMenuData() {
            return this.iQw;
        }
    }
}
