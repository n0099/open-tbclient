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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes4.dex */
public class BottomMenuView extends LinearLayout {
    private View cUw;
    private LinearLayout fAA;
    private a fAz;
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
        this.fAz = aVar;
    }

    public void a(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        if (!v.aa(list)) {
            this.mPageContext = tbPageContext;
            removeAllViews();
            this.cUw = new View(getContext());
            this.cUw.setLayoutParams(new LinearLayout.LayoutParams(-1, l.g(getContext(), R.dimen.tbds16)));
            this.cUw.setBackgroundResource(R.drawable.bottom_view_shadow);
            addView(this.cUw);
            this.fAA = new LinearLayout(getContext());
            this.fAA.setOrientation(0);
            this.fAA.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            addView(this.fAA);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                MenuItemView menuItemView = new MenuItemView(tbPageContext);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                menuItemView.setLayoutParams(layoutParams);
                menuItemView.setMenuData(list.get(i));
                menuItemView.setOnMenuItemClickListener(this.fAz);
                this.fAA.addView(menuItemView);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType && this.fAA != null) {
            this.mSkinType = i;
            int childCount = this.fAA.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.fAA.getChildAt(i2);
                if (childAt != null) {
                    if (childAt instanceof MenuItemView) {
                        ((MenuItemView) childAt).onChangeSkinType(tbPageContext, i);
                    } else {
                        am.l(childAt, R.color.cp_bg_line_b);
                    }
                } else {
                    return;
                }
            }
            am.l(this.cUw, R.color.cp_bg_line_b);
        }
    }

    /* loaded from: classes4.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener {
        private int fAB;
        private ImageView fAC;
        private TextView fAD;
        private BottomMenu fAE;
        private boolean fAF;
        private b fAG;
        private a fAz;
        private TbPageContext<?> mPageContext;

        public MenuItemView(TbPageContext<?> tbPageContext) {
            super(tbPageContext.getPageActivity());
            this.fAB = R.drawable.icon_card_morelist_n;
            setGravity(17);
            setOnClickListener(this);
            LayoutInflater.from(getContext()).inflate(R.layout.bottom_menu_item, this);
            this.mPageContext = tbPageContext;
            this.fAC = (ImageView) findViewById(R.id.item_image);
            this.fAD = (TextView) findViewById(R.id.item_text);
        }

        public void setOnMenuItemClickListener(a aVar) {
            this.fAz = aVar;
        }

        public void setMenuData(BottomMenu bottomMenu) {
            if (bottomMenu != null) {
                this.fAE = bottomMenu;
                this.fAF = v.Z(bottomMenu.submenu) > 0;
                this.fAD.setText(bottomMenu.name);
                onChangeSkinType(this.mPageContext, 0);
            }
        }

        public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
            setMenuIcon(this.fAB);
            am.j(this.fAD, R.color.cp_cont_b);
            am.k(this, R.drawable.addresslist_item_bg);
        }

        private void setMenuIcon(int i) {
            this.fAB = i;
            if (this.fAF) {
                this.fAC.setVisibility(0);
                this.fAC.setImageResource(i);
                am.c(this.fAC, i);
                return;
            }
            this.fAC.setVisibility(8);
        }

        public e getPageContext() {
            return this.mPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.fAF) {
                getSubMenuGenerator().a(this, this.fAE.submenu);
            }
            if (this.fAz != null) {
                this.fAz.a(this, this.fAE);
            }
        }

        private b getSubMenuGenerator() {
            if (this.fAG == null) {
                this.fAG = new b();
                this.fAG.setOnMenuItemClickListener(this.fAz);
            }
            return this.fAG;
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements View.OnClickListener {
        private PopupWindow aPu;
        private RelativeLayout fAH;
        private final int[] fAI = new int[2];
        private a fAz;

        public void setOnMenuItemClickListener(a aVar) {
            this.fAz = aVar;
        }

        public void a(MenuItemView menuItemView, List<SubBottomMenu> list) {
            if (menuItemView != null && !v.aa(list)) {
                Activity pageActivity = menuItemView.getPageContext().getPageActivity();
                this.fAH = new RelativeLayout(pageActivity);
                this.fAH.setBackgroundColor(am.getColor(R.color.cp_mask_f));
                this.fAH.setOnClickListener(this);
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
                this.fAH.addView(linearLayout);
                menuItemView.getLocationInWindow(this.fAI);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.width = menuItemView.getWidth();
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.fAI[0];
                this.aPu = new PopupWindow(this.fAH, -1, this.fAI[1]);
                this.aPu.setOutsideTouchable(true);
                this.aPu.setFocusable(true);
                this.aPu.setClippingEnabled(false);
                this.aPu.setBackgroundDrawable(new ColorDrawable());
                this.aPu.setSoftInputMode(16);
                g.showPopupWindowAtLocation(this.aPu, menuItemView, 51, 0, 0);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view instanceof SubMenuItemView) {
                g.a(this.aPu);
                SubMenuItemView subMenuItemView = (SubMenuItemView) view;
                if (this.fAz != null) {
                    this.fAz.a(subMenuItemView, subMenuItemView.getSubMenuData());
                }
            } else if (view == this.fAH) {
                g.a(this.aPu);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class SubMenuItemView extends LinearLayout {
        private View bqE;
        private SubBottomMenu fAJ;
        private TextView mTitleView;

        public SubMenuItemView(Context context) {
            super(context);
            LayoutInflater.from(context).inflate(R.layout.bottom_submenu_item, this);
            setOrientation(1);
            this.mTitleView = (TextView) findViewById(R.id.item_text);
            this.bqE = findViewById(R.id.divider_line);
        }

        public void setSubMenuData(SubBottomMenu subBottomMenu, int i, boolean z) {
            if (subBottomMenu != null) {
                this.fAJ = subBottomMenu;
                this.mTitleView.setText(subBottomMenu.name);
                am.j(this.mTitleView, R.color.cp_cont_f);
                am.k(this, i == 0 ? R.drawable.bottom_menu_item_bg_corner_selector : R.drawable.bottom_menu_item_bg_selector);
                if (z) {
                    this.bqE.setVisibility(8);
                    return;
                }
                this.bqE.setVisibility(0);
                am.l(this.bqE, R.color.cp_bg_line_b);
            }
        }

        public SubBottomMenu getSubMenuData() {
            return this.fAJ;
        }
    }
}
