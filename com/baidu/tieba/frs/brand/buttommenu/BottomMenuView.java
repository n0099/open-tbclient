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
/* loaded from: classes22.dex */
public class BottomMenuView extends LinearLayout {
    private View fYd;
    private a jbd;
    private LinearLayout jbe;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    /* loaded from: classes22.dex */
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
        this.jbd = aVar;
    }

    public void a(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        if (!y.isEmpty(list)) {
            this.mPageContext = tbPageContext;
            removeAllViews();
            this.fYd = new View(getContext());
            this.fYd.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds16)));
            this.fYd.setBackgroundResource(R.drawable.bottom_view_shadow);
            addView(this.fYd);
            this.jbe = new LinearLayout(getContext());
            this.jbe.setOrientation(0);
            this.jbe.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            addView(this.jbe);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                MenuItemView menuItemView = new MenuItemView(tbPageContext);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                menuItemView.setLayoutParams(layoutParams);
                menuItemView.setMenuData(list.get(i));
                menuItemView.setOnMenuItemClickListener(this.jbd);
                this.jbe.addView(menuItemView);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType && this.jbe != null) {
            this.mSkinType = i;
            int childCount = this.jbe.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.jbe.getChildAt(i2);
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
            ap.setBackgroundColor(this.fYd, R.color.CAM_X0204);
        }
    }

    /* loaded from: classes22.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener {
        private static final int jbf = R.drawable.icon_card_morelist_n;
        private a jbd;
        private int jbg;
        private ImageView jbh;
        private TextView jbi;
        private BottomMenu jbj;
        private boolean jbk;
        private b jbl;
        private TbPageContext<?> mPageContext;

        public MenuItemView(TbPageContext<?> tbPageContext) {
            super(tbPageContext.getPageActivity());
            this.jbg = jbf;
            setGravity(17);
            setOnClickListener(this);
            LayoutInflater.from(getContext()).inflate(R.layout.bottom_menu_item, this);
            this.mPageContext = tbPageContext;
            this.jbh = (ImageView) findViewById(R.id.item_image);
            this.jbi = (TextView) findViewById(R.id.item_text);
        }

        public void setOnMenuItemClickListener(a aVar) {
            this.jbd = aVar;
        }

        public void setMenuData(BottomMenu bottomMenu) {
            if (bottomMenu != null) {
                this.jbj = bottomMenu;
                this.jbk = y.getCount(bottomMenu.submenu) > 0;
                this.jbi.setText(bottomMenu.name);
                onChangeSkinType(this.mPageContext, 0);
            }
        }

        public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
            setMenuIcon(this.jbg);
            ap.setViewTextColor(this.jbi, R.color.CAM_X0105);
            ap.setBackgroundResource(this, R.drawable.addresslist_item_bg);
        }

        private void setMenuIcon(int i) {
            this.jbg = i;
            if (this.jbk) {
                this.jbh.setVisibility(0);
                this.jbh.setImageResource(i);
                ap.setImageResource(this.jbh, i);
                return;
            }
            this.jbh.setVisibility(8);
        }

        public e getPageContext() {
            return this.mPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.jbk) {
                getSubMenuGenerator().a(this, this.jbj.submenu);
            }
            if (this.jbd != null) {
                this.jbd.a(this, this.jbj);
            }
        }

        private b getSubMenuGenerator() {
            if (this.jbl == null) {
                this.jbl = new b();
                this.jbl.setOnMenuItemClickListener(this.jbd);
            }
            return this.jbl;
        }
    }

    /* loaded from: classes22.dex */
    public static class b implements View.OnClickListener {
        private a jbd;
        private RelativeLayout jbm;
        private final int[] mLocation = new int[2];
        private PopupWindow mPopupWindow;

        public void setOnMenuItemClickListener(a aVar) {
            this.jbd = aVar;
        }

        public void a(MenuItemView menuItemView, List<SubBottomMenu> list) {
            if (menuItemView != null && !y.isEmpty(list)) {
                Activity pageActivity = menuItemView.getPageContext().getPageActivity();
                this.jbm = new RelativeLayout(pageActivity);
                this.jbm.setBackgroundColor(ap.getColor(R.color.CAM_X0608));
                this.jbm.setOnClickListener(this);
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
                this.jbm.addView(linearLayout);
                menuItemView.getLocationInWindow(this.mLocation);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.width = menuItemView.getWidth();
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mLocation[0];
                this.mPopupWindow = new PopupWindow(this.jbm, -1, this.mLocation[1]);
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
                if (this.jbd != null) {
                    this.jbd.a(subMenuItemView, subMenuItemView.getSubMenuData());
                }
            } else if (view == this.jbm) {
                g.dismissPopupWindow(this.mPopupWindow);
            }
        }
    }

    /* loaded from: classes22.dex */
    public static class SubMenuItemView extends LinearLayout {
        private View elk;
        private SubBottomMenu jbn;
        private TextView mTitleView;

        public SubMenuItemView(Context context) {
            super(context);
            LayoutInflater.from(context).inflate(R.layout.bottom_submenu_item, this);
            setOrientation(1);
            this.mTitleView = (TextView) findViewById(R.id.item_text);
            this.elk = findViewById(R.id.divider_line);
        }

        public void setSubMenuData(SubBottomMenu subBottomMenu, int i, boolean z) {
            if (subBottomMenu != null) {
                this.jbn = subBottomMenu;
                this.mTitleView.setText(subBottomMenu.name);
                ap.setViewTextColor(this.mTitleView, R.color.CAM_X0106);
                ap.setBackgroundResource(this, i == 0 ? R.drawable.bottom_menu_item_bg_corner_selector : R.drawable.bottom_menu_item_bg_selector);
                if (z) {
                    this.elk.setVisibility(8);
                    return;
                }
                this.elk.setVisibility(0);
                ap.setBackgroundColor(this.elk, R.color.CAM_X0204);
            }
        }

        public SubBottomMenu getSubMenuData() {
            return this.jbn;
        }
    }
}
