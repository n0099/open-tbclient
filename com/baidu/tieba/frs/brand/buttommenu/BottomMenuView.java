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
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes4.dex */
public class BottomMenuView extends LinearLayout {
    private View cKK;
    private a ffB;
    private LinearLayout ffC;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    /* loaded from: classes4.dex */
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
        this.ffB = aVar;
    }

    public void a(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        if (!v.T(list)) {
            this.mPageContext = tbPageContext;
            removeAllViews();
            this.cKK = new View(getContext());
            this.cKK.setLayoutParams(new LinearLayout.LayoutParams(-1, l.h(getContext(), d.e.tbds16)));
            this.cKK.setBackgroundResource(d.f.bottom_view_shadow);
            addView(this.cKK);
            this.ffC = new LinearLayout(getContext());
            this.ffC.setOrientation(0);
            this.ffC.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            addView(this.ffC);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                MenuItemView menuItemView = new MenuItemView(tbPageContext);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                menuItemView.setLayoutParams(layoutParams);
                menuItemView.setMenuData(list.get(i));
                menuItemView.setOnMenuItemClickListener(this.ffB);
                this.ffC.addView(menuItemView);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType && this.ffC != null) {
            this.mSkinType = i;
            int childCount = this.ffC.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.ffC.getChildAt(i2);
                if (childAt != null) {
                    if (childAt instanceof MenuItemView) {
                        ((MenuItemView) childAt).onChangeSkinType(tbPageContext, i);
                    } else {
                        al.l(childAt, d.C0277d.cp_bg_line_b);
                    }
                } else {
                    return;
                }
            }
            al.l(this.cKK, d.C0277d.cp_bg_line_b);
        }
    }

    /* loaded from: classes4.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener {
        private static final int ffD = d.f.icon_card_morelist_n;
        private a ffB;
        private int ffE;
        private ImageView ffF;
        private TextView ffG;
        private BottomMenu ffH;
        private boolean ffI;
        private b ffJ;
        private TbPageContext<?> mPageContext;

        public MenuItemView(TbPageContext<?> tbPageContext) {
            super(tbPageContext.getPageActivity());
            this.ffE = ffD;
            setGravity(17);
            setOnClickListener(this);
            LayoutInflater.from(getContext()).inflate(d.h.bottom_menu_item, this);
            this.mPageContext = tbPageContext;
            this.ffF = (ImageView) findViewById(d.g.item_image);
            this.ffG = (TextView) findViewById(d.g.item_text);
        }

        public void setOnMenuItemClickListener(a aVar) {
            this.ffB = aVar;
        }

        public void setMenuData(BottomMenu bottomMenu) {
            if (bottomMenu != null) {
                this.ffH = bottomMenu;
                this.ffI = v.S(bottomMenu.submenu) > 0;
                this.ffG.setText(bottomMenu.name);
                onChangeSkinType(this.mPageContext, 0);
            }
        }

        public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
            setMenuIcon(this.ffE);
            al.j(this.ffG, d.C0277d.cp_cont_b);
            al.k(this, d.f.addresslist_item_bg);
        }

        private void setMenuIcon(int i) {
            this.ffE = i;
            if (this.ffI) {
                this.ffF.setVisibility(0);
                this.ffF.setImageResource(i);
                al.c(this.ffF, i);
                return;
            }
            this.ffF.setVisibility(8);
        }

        public e getPageContext() {
            return this.mPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.ffI) {
                getSubMenuGenerator().a(this, this.ffH.submenu);
            }
            if (this.ffB != null) {
                this.ffB.a(this, this.ffH);
            }
        }

        private b getSubMenuGenerator() {
            if (this.ffJ == null) {
                this.ffJ = new b();
                this.ffJ.setOnMenuItemClickListener(this.ffB);
            }
            return this.ffJ;
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements View.OnClickListener {
        private PopupWindow aMJ;
        private a ffB;
        private RelativeLayout ffK;
        private final int[] ffL = new int[2];

        public void setOnMenuItemClickListener(a aVar) {
            this.ffB = aVar;
        }

        public void a(MenuItemView menuItemView, List<SubBottomMenu> list) {
            if (menuItemView != null && !v.T(list)) {
                Activity pageActivity = menuItemView.getPageContext().getPageActivity();
                this.ffK = new RelativeLayout(pageActivity);
                this.ffK.setBackgroundColor(al.getColor(d.C0277d.cp_mask_f));
                this.ffK.setOnClickListener(this);
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
                this.ffK.addView(linearLayout);
                menuItemView.getLocationInWindow(this.ffL);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.width = menuItemView.getWidth();
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.ffL[0];
                this.aMJ = new PopupWindow(this.ffK, -1, this.ffL[1]);
                this.aMJ.setOutsideTouchable(true);
                this.aMJ.setFocusable(true);
                this.aMJ.setClippingEnabled(false);
                this.aMJ.setBackgroundDrawable(new ColorDrawable());
                this.aMJ.setSoftInputMode(16);
                g.showPopupWindowAtLocation(this.aMJ, menuItemView, 51, 0, 0);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view instanceof SubMenuItemView) {
                g.a(this.aMJ);
                SubMenuItemView subMenuItemView = (SubMenuItemView) view;
                if (this.ffB != null) {
                    this.ffB.a(subMenuItemView, subMenuItemView.getSubMenuData());
                }
            } else if (view == this.ffK) {
                g.a(this.aMJ);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class SubMenuItemView extends LinearLayout {
        private View bjK;
        private SubBottomMenu ffM;
        private TextView mTitleView;

        public SubMenuItemView(Context context) {
            super(context);
            LayoutInflater.from(context).inflate(d.h.bottom_submenu_item, this);
            setOrientation(1);
            this.mTitleView = (TextView) findViewById(d.g.item_text);
            this.bjK = findViewById(d.g.divider_line);
        }

        public void setSubMenuData(SubBottomMenu subBottomMenu, int i, boolean z) {
            if (subBottomMenu != null) {
                this.ffM = subBottomMenu;
                this.mTitleView.setText(subBottomMenu.name);
                al.j(this.mTitleView, d.C0277d.cp_cont_f);
                al.k(this, i == 0 ? d.f.bottom_menu_item_bg_corner_selector : d.f.bottom_menu_item_bg_selector);
                if (z) {
                    this.bjK.setVisibility(8);
                    return;
                }
                this.bjK.setVisibility(0);
                al.l(this.bjK, d.C0277d.cp_bg_line_b);
            }
        }

        public SubBottomMenu getSubMenuData() {
            return this.ffM;
        }
    }
}
