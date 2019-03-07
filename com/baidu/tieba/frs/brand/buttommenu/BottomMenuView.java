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
    private View cKN;
    private a ffC;
    private LinearLayout ffD;
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
        this.ffC = aVar;
    }

    public void a(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        if (!v.T(list)) {
            this.mPageContext = tbPageContext;
            removeAllViews();
            this.cKN = new View(getContext());
            this.cKN.setLayoutParams(new LinearLayout.LayoutParams(-1, l.h(getContext(), d.e.tbds16)));
            this.cKN.setBackgroundResource(d.f.bottom_view_shadow);
            addView(this.cKN);
            this.ffD = new LinearLayout(getContext());
            this.ffD.setOrientation(0);
            this.ffD.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            addView(this.ffD);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                MenuItemView menuItemView = new MenuItemView(tbPageContext);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                menuItemView.setLayoutParams(layoutParams);
                menuItemView.setMenuData(list.get(i));
                menuItemView.setOnMenuItemClickListener(this.ffC);
                this.ffD.addView(menuItemView);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType && this.ffD != null) {
            this.mSkinType = i;
            int childCount = this.ffD.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.ffD.getChildAt(i2);
                if (childAt != null) {
                    if (childAt instanceof MenuItemView) {
                        ((MenuItemView) childAt).onChangeSkinType(tbPageContext, i);
                    } else {
                        al.l(childAt, d.C0236d.cp_bg_line_b);
                    }
                } else {
                    return;
                }
            }
            al.l(this.cKN, d.C0236d.cp_bg_line_b);
        }
    }

    /* loaded from: classes4.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener {
        private static final int ffE = d.f.icon_card_morelist_n;
        private a ffC;
        private int ffF;
        private ImageView ffG;
        private TextView ffH;
        private BottomMenu ffI;
        private boolean ffJ;
        private b ffK;
        private TbPageContext<?> mPageContext;

        public MenuItemView(TbPageContext<?> tbPageContext) {
            super(tbPageContext.getPageActivity());
            this.ffF = ffE;
            setGravity(17);
            setOnClickListener(this);
            LayoutInflater.from(getContext()).inflate(d.h.bottom_menu_item, this);
            this.mPageContext = tbPageContext;
            this.ffG = (ImageView) findViewById(d.g.item_image);
            this.ffH = (TextView) findViewById(d.g.item_text);
        }

        public void setOnMenuItemClickListener(a aVar) {
            this.ffC = aVar;
        }

        public void setMenuData(BottomMenu bottomMenu) {
            if (bottomMenu != null) {
                this.ffI = bottomMenu;
                this.ffJ = v.S(bottomMenu.submenu) > 0;
                this.ffH.setText(bottomMenu.name);
                onChangeSkinType(this.mPageContext, 0);
            }
        }

        public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
            setMenuIcon(this.ffF);
            al.j(this.ffH, d.C0236d.cp_cont_b);
            al.k(this, d.f.addresslist_item_bg);
        }

        private void setMenuIcon(int i) {
            this.ffF = i;
            if (this.ffJ) {
                this.ffG.setVisibility(0);
                this.ffG.setImageResource(i);
                al.c(this.ffG, i);
                return;
            }
            this.ffG.setVisibility(8);
        }

        public e getPageContext() {
            return this.mPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.ffJ) {
                getSubMenuGenerator().a(this, this.ffI.submenu);
            }
            if (this.ffC != null) {
                this.ffC.a(this, this.ffI);
            }
        }

        private b getSubMenuGenerator() {
            if (this.ffK == null) {
                this.ffK = new b();
                this.ffK.setOnMenuItemClickListener(this.ffC);
            }
            return this.ffK;
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements View.OnClickListener {
        private PopupWindow aMI;
        private a ffC;
        private RelativeLayout ffL;
        private final int[] ffM = new int[2];

        public void setOnMenuItemClickListener(a aVar) {
            this.ffC = aVar;
        }

        public void a(MenuItemView menuItemView, List<SubBottomMenu> list) {
            if (menuItemView != null && !v.T(list)) {
                Activity pageActivity = menuItemView.getPageContext().getPageActivity();
                this.ffL = new RelativeLayout(pageActivity);
                this.ffL.setBackgroundColor(al.getColor(d.C0236d.cp_mask_f));
                this.ffL.setOnClickListener(this);
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
                this.ffL.addView(linearLayout);
                menuItemView.getLocationInWindow(this.ffM);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.width = menuItemView.getWidth();
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.ffM[0];
                this.aMI = new PopupWindow(this.ffL, -1, this.ffM[1]);
                this.aMI.setOutsideTouchable(true);
                this.aMI.setFocusable(true);
                this.aMI.setClippingEnabled(false);
                this.aMI.setBackgroundDrawable(new ColorDrawable());
                this.aMI.setSoftInputMode(16);
                g.showPopupWindowAtLocation(this.aMI, menuItemView, 51, 0, 0);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view instanceof SubMenuItemView) {
                g.a(this.aMI);
                SubMenuItemView subMenuItemView = (SubMenuItemView) view;
                if (this.ffC != null) {
                    this.ffC.a(subMenuItemView, subMenuItemView.getSubMenuData());
                }
            } else if (view == this.ffL) {
                g.a(this.aMI);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class SubMenuItemView extends LinearLayout {
        private View bjJ;
        private SubBottomMenu ffN;
        private TextView mTitleView;

        public SubMenuItemView(Context context) {
            super(context);
            LayoutInflater.from(context).inflate(d.h.bottom_submenu_item, this);
            setOrientation(1);
            this.mTitleView = (TextView) findViewById(d.g.item_text);
            this.bjJ = findViewById(d.g.divider_line);
        }

        public void setSubMenuData(SubBottomMenu subBottomMenu, int i, boolean z) {
            if (subBottomMenu != null) {
                this.ffN = subBottomMenu;
                this.mTitleView.setText(subBottomMenu.name);
                al.j(this.mTitleView, d.C0236d.cp_cont_f);
                al.k(this, i == 0 ? d.f.bottom_menu_item_bg_corner_selector : d.f.bottom_menu_item_bg_selector);
                if (z) {
                    this.bjJ.setVisibility(8);
                    return;
                }
                this.bjJ.setVisibility(0);
                al.l(this.bjJ, d.C0236d.cp_bg_line_b);
            }
        }

        public SubBottomMenu getSubMenuData() {
            return this.ffN;
        }
    }
}
