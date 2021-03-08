package com.baidu.tieba.frs.brand.buttommenu;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.base.f;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes2.dex */
public class BottomMenuView extends LinearLayout {
    private View ghb;
    private a jqp;
    private LinearLayout jqq;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    /* loaded from: classes2.dex */
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
        this.jqp = aVar;
    }

    public void a(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        if (!y.isEmpty(list)) {
            this.mPageContext = tbPageContext;
            removeAllViews();
            this.ghb = new View(getContext());
            this.ghb.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds16)));
            this.ghb.setBackgroundResource(R.drawable.bottom_view_shadow);
            addView(this.ghb);
            this.jqq = new LinearLayout(getContext());
            this.jqq.setOrientation(0);
            this.jqq.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            addView(this.jqq);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                MenuItemView menuItemView = new MenuItemView(tbPageContext);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                menuItemView.setLayoutParams(layoutParams);
                menuItemView.setMenuData(list.get(i));
                menuItemView.setOnMenuItemClickListener(this.jqp);
                this.jqq.addView(menuItemView);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType && this.jqq != null) {
            this.mSkinType = i;
            int childCount = this.jqq.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.jqq.getChildAt(i2);
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
            ap.setBackgroundColor(this.ghb, R.color.CAM_X0204);
        }
    }

    /* loaded from: classes2.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener {
        private static final int jqr = R.drawable.icon_card_morelist_n;
        private a jqp;
        private int jqs;
        private ImageView jqt;
        private TextView jqu;
        private BottomMenu jqv;
        private boolean jqw;
        private b jqx;
        private TbPageContext<?> mPageContext;

        public MenuItemView(TbPageContext<?> tbPageContext) {
            super(tbPageContext.getPageActivity());
            this.jqs = jqr;
            setGravity(17);
            setOnClickListener(this);
            LayoutInflater.from(getContext()).inflate(R.layout.bottom_menu_item, this);
            this.mPageContext = tbPageContext;
            this.jqt = (ImageView) findViewById(R.id.item_image);
            this.jqu = (TextView) findViewById(R.id.item_text);
        }

        public void setOnMenuItemClickListener(a aVar) {
            this.jqp = aVar;
        }

        public void setMenuData(BottomMenu bottomMenu) {
            if (bottomMenu != null) {
                this.jqv = bottomMenu;
                this.jqw = y.getCount(bottomMenu.submenu) > 0;
                this.jqu.setText(bottomMenu.name);
                onChangeSkinType(this.mPageContext, 0);
            }
        }

        public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
            setMenuIcon(this.jqs);
            ap.setViewTextColor(this.jqu, R.color.CAM_X0105);
            ap.setBackgroundResource(this, R.drawable.addresslist_item_bg);
        }

        private void setMenuIcon(int i) {
            this.jqs = i;
            if (this.jqw) {
                this.jqt.setVisibility(0);
                this.jqt.setImageResource(i);
                ap.setImageResource(this.jqt, i);
                return;
            }
            this.jqt.setVisibility(8);
        }

        public f getPageContext() {
            return this.mPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.jqw) {
                getSubMenuGenerator().a(this, this.jqv.submenu);
            }
            if (this.jqp != null) {
                this.jqp.a(this, this.jqv);
            }
        }

        private b getSubMenuGenerator() {
            if (this.jqx == null) {
                this.jqx = new b();
                this.jqx.setOnMenuItemClickListener(this.jqp);
            }
            return this.jqx;
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements View.OnClickListener {
        private a jqp;
        private RelativeLayout jqy;
        private final int[] jqz = new int[2];
        private PopupWindow mPopupWindow;

        public void setOnMenuItemClickListener(a aVar) {
            this.jqp = aVar;
        }

        public void a(MenuItemView menuItemView, List<SubBottomMenu> list) {
            if (menuItemView != null && !y.isEmpty(list)) {
                Activity pageActivity = menuItemView.getPageContext().getPageActivity();
                this.jqy = new RelativeLayout(pageActivity);
                this.jqy.setBackgroundColor(ap.getColor(R.color.CAM_X0608));
                this.jqy.setOnClickListener(this);
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
                this.jqy.addView(linearLayout);
                menuItemView.getLocationInWindow(this.jqz);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.width = menuItemView.getWidth();
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.jqz[0];
                this.mPopupWindow = new PopupWindow(this.jqy, -1, this.jqz[1]);
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
                if (this.jqp != null) {
                    this.jqp.a(subMenuItemView, subMenuItemView.getSubMenuData());
                }
            } else if (view == this.jqy) {
                g.dismissPopupWindow(this.mPopupWindow);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class SubMenuItemView extends LinearLayout {
        private View etk;
        private SubBottomMenu jqA;
        private TextView mTitleView;

        public SubMenuItemView(Context context) {
            super(context);
            LayoutInflater.from(context).inflate(R.layout.bottom_submenu_item, this);
            setOrientation(1);
            this.mTitleView = (TextView) findViewById(R.id.item_text);
            this.etk = findViewById(R.id.divider_line);
        }

        public void setSubMenuData(SubBottomMenu subBottomMenu, int i, boolean z) {
            if (subBottomMenu != null) {
                this.jqA = subBottomMenu;
                this.mTitleView.setText(subBottomMenu.name);
                ap.setViewTextColor(this.mTitleView, R.color.CAM_X0106);
                ap.setBackgroundResource(this, i == 0 ? R.drawable.bottom_menu_item_bg_corner_selector : R.drawable.bottom_menu_item_bg_selector);
                if (z) {
                    this.etk.setVisibility(8);
                    return;
                }
                this.etk.setVisibility(0);
                ap.setBackgroundColor(this.etk, R.color.CAM_X0204);
            }
        }

        public SubBottomMenu getSubMenuData() {
            return this.jqA;
        }
    }
}
