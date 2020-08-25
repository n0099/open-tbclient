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
/* loaded from: classes16.dex */
public class BottomMenuView extends LinearLayout {
    private View fmE;
    private a iaY;
    private LinearLayout iaZ;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    /* loaded from: classes16.dex */
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
        this.iaY = aVar;
    }

    public void a(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        if (!y.isEmpty(list)) {
            this.mPageContext = tbPageContext;
            removeAllViews();
            this.fmE = new View(getContext());
            this.fmE.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds16)));
            this.fmE.setBackgroundResource(R.drawable.bottom_view_shadow);
            addView(this.fmE);
            this.iaZ = new LinearLayout(getContext());
            this.iaZ.setOrientation(0);
            this.iaZ.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            addView(this.iaZ);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                MenuItemView menuItemView = new MenuItemView(tbPageContext);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                menuItemView.setLayoutParams(layoutParams);
                menuItemView.setMenuData(list.get(i));
                menuItemView.setOnMenuItemClickListener(this.iaY);
                this.iaZ.addView(menuItemView);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType && this.iaZ != null) {
            this.mSkinType = i;
            int childCount = this.iaZ.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.iaZ.getChildAt(i2);
                if (childAt != null) {
                    if (childAt instanceof MenuItemView) {
                        ((MenuItemView) childAt).onChangeSkinType(tbPageContext, i);
                    } else {
                        ap.setBackgroundColor(childAt, R.color.cp_bg_line_c);
                    }
                } else {
                    return;
                }
            }
            ap.setBackgroundColor(this.fmE, R.color.cp_bg_line_c);
        }
    }

    /* loaded from: classes16.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener {
        private static final int iba = R.drawable.icon_card_morelist_n;
        private a iaY;
        private int ibb;
        private ImageView ibc;
        private TextView ibd;
        private BottomMenu ibe;
        private boolean ibf;
        private b ibg;
        private TbPageContext<?> mPageContext;

        public MenuItemView(TbPageContext<?> tbPageContext) {
            super(tbPageContext.getPageActivity());
            this.ibb = iba;
            setGravity(17);
            setOnClickListener(this);
            LayoutInflater.from(getContext()).inflate(R.layout.bottom_menu_item, this);
            this.mPageContext = tbPageContext;
            this.ibc = (ImageView) findViewById(R.id.item_image);
            this.ibd = (TextView) findViewById(R.id.item_text);
        }

        public void setOnMenuItemClickListener(a aVar) {
            this.iaY = aVar;
        }

        public void setMenuData(BottomMenu bottomMenu) {
            if (bottomMenu != null) {
                this.ibe = bottomMenu;
                this.ibf = y.getCount(bottomMenu.submenu) > 0;
                this.ibd.setText(bottomMenu.name);
                onChangeSkinType(this.mPageContext, 0);
            }
        }

        public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
            setMenuIcon(this.ibb);
            ap.setViewTextColor(this.ibd, R.color.cp_cont_b);
            ap.setBackgroundResource(this, R.drawable.addresslist_item_bg);
        }

        private void setMenuIcon(int i) {
            this.ibb = i;
            if (this.ibf) {
                this.ibc.setVisibility(0);
                this.ibc.setImageResource(i);
                ap.setImageResource(this.ibc, i);
                return;
            }
            this.ibc.setVisibility(8);
        }

        public e getPageContext() {
            return this.mPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.ibf) {
                getSubMenuGenerator().a(this, this.ibe.submenu);
            }
            if (this.iaY != null) {
                this.iaY.a(this, this.ibe);
            }
        }

        private b getSubMenuGenerator() {
            if (this.ibg == null) {
                this.ibg = new b();
                this.ibg.setOnMenuItemClickListener(this.iaY);
            }
            return this.ibg;
        }
    }

    /* loaded from: classes16.dex */
    public static class b implements View.OnClickListener {
        private a iaY;
        private RelativeLayout ibh;
        private final int[] mLocation = new int[2];
        private PopupWindow mPopupWindow;

        public void setOnMenuItemClickListener(a aVar) {
            this.iaY = aVar;
        }

        public void a(MenuItemView menuItemView, List<SubBottomMenu> list) {
            if (menuItemView != null && !y.isEmpty(list)) {
                Activity pageActivity = menuItemView.getPageContext().getPageActivity();
                this.ibh = new RelativeLayout(pageActivity);
                this.ibh.setBackgroundColor(ap.getColor(R.color.cp_mask_b_alpha66));
                this.ibh.setOnClickListener(this);
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
                this.ibh.addView(linearLayout);
                menuItemView.getLocationInWindow(this.mLocation);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.width = menuItemView.getWidth();
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mLocation[0];
                this.mPopupWindow = new PopupWindow(this.ibh, -1, this.mLocation[1]);
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
                if (this.iaY != null) {
                    this.iaY.a(subMenuItemView, subMenuItemView.getSubMenuData());
                }
            } else if (view == this.ibh) {
                g.dismissPopupWindow(this.mPopupWindow);
            }
        }
    }

    /* loaded from: classes16.dex */
    public static class SubMenuItemView extends LinearLayout {
        private View dDx;
        private SubBottomMenu ibi;
        private TextView mTitleView;

        public SubMenuItemView(Context context) {
            super(context);
            LayoutInflater.from(context).inflate(R.layout.bottom_submenu_item, this);
            setOrientation(1);
            this.mTitleView = (TextView) findViewById(R.id.item_text);
            this.dDx = findViewById(R.id.divider_line);
        }

        public void setSubMenuData(SubBottomMenu subBottomMenu, int i, boolean z) {
            if (subBottomMenu != null) {
                this.ibi = subBottomMenu;
                this.mTitleView.setText(subBottomMenu.name);
                ap.setViewTextColor(this.mTitleView, R.color.cp_cont_f);
                ap.setBackgroundResource(this, i == 0 ? R.drawable.bottom_menu_item_bg_corner_selector : R.drawable.bottom_menu_item_bg_selector);
                if (z) {
                    this.dDx.setVisibility(8);
                    return;
                }
                this.dDx.setVisibility(0);
                ap.setBackgroundColor(this.dDx, R.color.cp_bg_line_c);
            }
        }

        public SubBottomMenu getSubMenuData() {
            return this.ibi;
        }
    }
}
