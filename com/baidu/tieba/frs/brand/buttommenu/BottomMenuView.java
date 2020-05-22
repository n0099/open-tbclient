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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes9.dex */
public class BottomMenuView extends LinearLayout {
    private View eLg;
    private a htV;
    private LinearLayout htW;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    /* loaded from: classes9.dex */
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
        this.htV = aVar;
    }

    public void a(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        if (!v.isEmpty(list)) {
            this.mPageContext = tbPageContext;
            removeAllViews();
            this.eLg = new View(getContext());
            this.eLg.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds16)));
            this.eLg.setBackgroundResource(R.drawable.bottom_view_shadow);
            addView(this.eLg);
            this.htW = new LinearLayout(getContext());
            this.htW.setOrientation(0);
            this.htW.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            addView(this.htW);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                MenuItemView menuItemView = new MenuItemView(tbPageContext);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                menuItemView.setLayoutParams(layoutParams);
                menuItemView.setMenuData(list.get(i));
                menuItemView.setOnMenuItemClickListener(this.htV);
                this.htW.addView(menuItemView);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType && this.htW != null) {
            this.mSkinType = i;
            int childCount = this.htW.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.htW.getChildAt(i2);
                if (childAt != null) {
                    if (childAt instanceof MenuItemView) {
                        ((MenuItemView) childAt).onChangeSkinType(tbPageContext, i);
                    } else {
                        am.setBackgroundColor(childAt, R.color.cp_bg_line_c);
                    }
                } else {
                    return;
                }
            }
            am.setBackgroundColor(this.eLg, R.color.cp_bg_line_c);
        }
    }

    /* loaded from: classes9.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener {
        private a htV;
        private int htX;
        private ImageView htY;
        private TextView htZ;
        private BottomMenu hua;
        private boolean hub;
        private b huc;
        private TbPageContext<?> mPageContext;

        public MenuItemView(TbPageContext<?> tbPageContext) {
            super(tbPageContext.getPageActivity());
            this.htX = R.drawable.icon_card_morelist_n;
            setGravity(17);
            setOnClickListener(this);
            LayoutInflater.from(getContext()).inflate(R.layout.bottom_menu_item, this);
            this.mPageContext = tbPageContext;
            this.htY = (ImageView) findViewById(R.id.item_image);
            this.htZ = (TextView) findViewById(R.id.item_text);
        }

        public void setOnMenuItemClickListener(a aVar) {
            this.htV = aVar;
        }

        public void setMenuData(BottomMenu bottomMenu) {
            if (bottomMenu != null) {
                this.hua = bottomMenu;
                this.hub = v.getCount(bottomMenu.submenu) > 0;
                this.htZ.setText(bottomMenu.name);
                onChangeSkinType(this.mPageContext, 0);
            }
        }

        public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
            setMenuIcon(this.htX);
            am.setViewTextColor(this.htZ, (int) R.color.cp_cont_b);
            am.setBackgroundResource(this, R.drawable.addresslist_item_bg);
        }

        private void setMenuIcon(int i) {
            this.htX = i;
            if (this.hub) {
                this.htY.setVisibility(0);
                this.htY.setImageResource(i);
                am.setImageResource(this.htY, i);
                return;
            }
            this.htY.setVisibility(8);
        }

        public e getPageContext() {
            return this.mPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.hub) {
                getSubMenuGenerator().a(this, this.hua.submenu);
            }
            if (this.htV != null) {
                this.htV.a(this, this.hua);
            }
        }

        private b getSubMenuGenerator() {
            if (this.huc == null) {
                this.huc = new b();
                this.huc.setOnMenuItemClickListener(this.htV);
            }
            return this.huc;
        }
    }

    /* loaded from: classes9.dex */
    public static class b implements View.OnClickListener {
        private a htV;
        private RelativeLayout hud;
        private final int[] mLocation = new int[2];
        private PopupWindow mPopupWindow;

        public void setOnMenuItemClickListener(a aVar) {
            this.htV = aVar;
        }

        public void a(MenuItemView menuItemView, List<SubBottomMenu> list) {
            if (menuItemView != null && !v.isEmpty(list)) {
                Activity pageActivity = menuItemView.getPageContext().getPageActivity();
                this.hud = new RelativeLayout(pageActivity);
                this.hud.setBackgroundColor(am.getColor(R.color.cp_mask_b_alpha66));
                this.hud.setOnClickListener(this);
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
                this.hud.addView(linearLayout);
                menuItemView.getLocationInWindow(this.mLocation);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.width = menuItemView.getWidth();
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mLocation[0];
                this.mPopupWindow = new PopupWindow(this.hud, -1, this.mLocation[1]);
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
                if (this.htV != null) {
                    this.htV.a(subMenuItemView, subMenuItemView.getSubMenuData());
                }
            } else if (view == this.hud) {
                g.dismissPopupWindow(this.mPopupWindow);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class SubMenuItemView extends LinearLayout {
        private View diS;
        private SubBottomMenu hue;
        private TextView mTitleView;

        public SubMenuItemView(Context context) {
            super(context);
            LayoutInflater.from(context).inflate(R.layout.bottom_submenu_item, this);
            setOrientation(1);
            this.mTitleView = (TextView) findViewById(R.id.item_text);
            this.diS = findViewById(R.id.divider_line);
        }

        public void setSubMenuData(SubBottomMenu subBottomMenu, int i, boolean z) {
            if (subBottomMenu != null) {
                this.hue = subBottomMenu;
                this.mTitleView.setText(subBottomMenu.name);
                am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_f);
                am.setBackgroundResource(this, i == 0 ? R.drawable.bottom_menu_item_bg_corner_selector : R.drawable.bottom_menu_item_bg_selector);
                if (z) {
                    this.diS.setVisibility(8);
                    return;
                }
                this.diS.setVisibility(0);
                am.setBackgroundColor(this.diS, R.color.cp_bg_line_c);
            }
        }

        public SubBottomMenu getSubMenuData() {
            return this.hue;
        }
    }
}
