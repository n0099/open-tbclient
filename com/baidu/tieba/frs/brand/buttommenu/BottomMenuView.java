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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes16.dex */
public class BottomMenuView extends LinearLayout {
    private View fbk;
    private a hMR;
    private LinearLayout hMS;
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
        this.hMR = aVar;
    }

    public void a(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        if (!x.isEmpty(list)) {
            this.mPageContext = tbPageContext;
            removeAllViews();
            this.fbk = new View(getContext());
            this.fbk.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds16)));
            this.fbk.setBackgroundResource(R.drawable.bottom_view_shadow);
            addView(this.fbk);
            this.hMS = new LinearLayout(getContext());
            this.hMS.setOrientation(0);
            this.hMS.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            addView(this.hMS);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                MenuItemView menuItemView = new MenuItemView(tbPageContext);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                menuItemView.setLayoutParams(layoutParams);
                menuItemView.setMenuData(list.get(i));
                menuItemView.setOnMenuItemClickListener(this.hMR);
                this.hMS.addView(menuItemView);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType && this.hMS != null) {
            this.mSkinType = i;
            int childCount = this.hMS.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.hMS.getChildAt(i2);
                if (childAt != null) {
                    if (childAt instanceof MenuItemView) {
                        ((MenuItemView) childAt).onChangeSkinType(tbPageContext, i);
                    } else {
                        ao.setBackgroundColor(childAt, R.color.cp_bg_line_c);
                    }
                } else {
                    return;
                }
            }
            ao.setBackgroundColor(this.fbk, R.color.cp_bg_line_c);
        }
    }

    /* loaded from: classes16.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener {
        private static final int hMT = R.drawable.icon_card_morelist_n;
        private a hMR;
        private int hMU;
        private ImageView hMV;
        private TextView hMW;
        private BottomMenu hMX;
        private boolean hMY;
        private b hMZ;
        private TbPageContext<?> mPageContext;

        public MenuItemView(TbPageContext<?> tbPageContext) {
            super(tbPageContext.getPageActivity());
            this.hMU = hMT;
            setGravity(17);
            setOnClickListener(this);
            LayoutInflater.from(getContext()).inflate(R.layout.bottom_menu_item, this);
            this.mPageContext = tbPageContext;
            this.hMV = (ImageView) findViewById(R.id.item_image);
            this.hMW = (TextView) findViewById(R.id.item_text);
        }

        public void setOnMenuItemClickListener(a aVar) {
            this.hMR = aVar;
        }

        public void setMenuData(BottomMenu bottomMenu) {
            if (bottomMenu != null) {
                this.hMX = bottomMenu;
                this.hMY = x.getCount(bottomMenu.submenu) > 0;
                this.hMW.setText(bottomMenu.name);
                onChangeSkinType(this.mPageContext, 0);
            }
        }

        public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
            setMenuIcon(this.hMU);
            ao.setViewTextColor(this.hMW, R.color.cp_cont_b);
            ao.setBackgroundResource(this, R.drawable.addresslist_item_bg);
        }

        private void setMenuIcon(int i) {
            this.hMU = i;
            if (this.hMY) {
                this.hMV.setVisibility(0);
                this.hMV.setImageResource(i);
                ao.setImageResource(this.hMV, i);
                return;
            }
            this.hMV.setVisibility(8);
        }

        public e getPageContext() {
            return this.mPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.hMY) {
                getSubMenuGenerator().a(this, this.hMX.submenu);
            }
            if (this.hMR != null) {
                this.hMR.a(this, this.hMX);
            }
        }

        private b getSubMenuGenerator() {
            if (this.hMZ == null) {
                this.hMZ = new b();
                this.hMZ.setOnMenuItemClickListener(this.hMR);
            }
            return this.hMZ;
        }
    }

    /* loaded from: classes16.dex */
    public static class b implements View.OnClickListener {
        private a hMR;
        private RelativeLayout hNa;
        private final int[] mLocation = new int[2];
        private PopupWindow mPopupWindow;

        public void setOnMenuItemClickListener(a aVar) {
            this.hMR = aVar;
        }

        public void a(MenuItemView menuItemView, List<SubBottomMenu> list) {
            if (menuItemView != null && !x.isEmpty(list)) {
                Activity pageActivity = menuItemView.getPageContext().getPageActivity();
                this.hNa = new RelativeLayout(pageActivity);
                this.hNa.setBackgroundColor(ao.getColor(R.color.cp_mask_b_alpha66));
                this.hNa.setOnClickListener(this);
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
                this.hNa.addView(linearLayout);
                menuItemView.getLocationInWindow(this.mLocation);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.width = menuItemView.getWidth();
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mLocation[0];
                this.mPopupWindow = new PopupWindow(this.hNa, -1, this.mLocation[1]);
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
                if (this.hMR != null) {
                    this.hMR.a(subMenuItemView, subMenuItemView.getSubMenuData());
                }
            } else if (view == this.hNa) {
                g.dismissPopupWindow(this.mPopupWindow);
            }
        }
    }

    /* loaded from: classes16.dex */
    public static class SubMenuItemView extends LinearLayout {
        private View dty;
        private SubBottomMenu hNb;
        private TextView mTitleView;

        public SubMenuItemView(Context context) {
            super(context);
            LayoutInflater.from(context).inflate(R.layout.bottom_submenu_item, this);
            setOrientation(1);
            this.mTitleView = (TextView) findViewById(R.id.item_text);
            this.dty = findViewById(R.id.divider_line);
        }

        public void setSubMenuData(SubBottomMenu subBottomMenu, int i, boolean z) {
            if (subBottomMenu != null) {
                this.hNb = subBottomMenu;
                this.mTitleView.setText(subBottomMenu.name);
                ao.setViewTextColor(this.mTitleView, R.color.cp_cont_f);
                ao.setBackgroundResource(this, i == 0 ? R.drawable.bottom_menu_item_bg_corner_selector : R.drawable.bottom_menu_item_bg_selector);
                if (z) {
                    this.dty.setVisibility(8);
                    return;
                }
                this.dty.setVisibility(0);
                ao.setBackgroundColor(this.dty, R.color.cp_bg_line_c);
            }
        }

        public SubBottomMenu getSubMenuData() {
            return this.hNb;
        }
    }
}
