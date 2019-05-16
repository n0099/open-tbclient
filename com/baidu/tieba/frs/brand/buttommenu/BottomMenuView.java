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
import com.baidu.tieba.R;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes4.dex */
public class BottomMenuView extends LinearLayout {
    private View cSY;
    private a fvC;
    private LinearLayout fvD;
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
        this.fvC = aVar;
    }

    public void a(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        if (!v.aa(list)) {
            this.mPageContext = tbPageContext;
            removeAllViews();
            this.cSY = new View(getContext());
            this.cSY.setLayoutParams(new LinearLayout.LayoutParams(-1, l.g(getContext(), R.dimen.tbds16)));
            this.cSY.setBackgroundResource(R.drawable.bottom_view_shadow);
            addView(this.cSY);
            this.fvD = new LinearLayout(getContext());
            this.fvD.setOrientation(0);
            this.fvD.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            addView(this.fvD);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                MenuItemView menuItemView = new MenuItemView(tbPageContext);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                menuItemView.setLayoutParams(layoutParams);
                menuItemView.setMenuData(list.get(i));
                menuItemView.setOnMenuItemClickListener(this.fvC);
                this.fvD.addView(menuItemView);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType && this.fvD != null) {
            this.mSkinType = i;
            int childCount = this.fvD.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.fvD.getChildAt(i2);
                if (childAt != null) {
                    if (childAt instanceof MenuItemView) {
                        ((MenuItemView) childAt).onChangeSkinType(tbPageContext, i);
                    } else {
                        al.l(childAt, R.color.cp_bg_line_b);
                    }
                } else {
                    return;
                }
            }
            al.l(this.cSY, R.color.cp_bg_line_b);
        }
    }

    /* loaded from: classes4.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener {
        private a fvC;
        private int fvE;
        private ImageView fvF;
        private TextView fvG;
        private BottomMenu fvH;
        private boolean fvI;
        private b fvJ;
        private TbPageContext<?> mPageContext;

        public MenuItemView(TbPageContext<?> tbPageContext) {
            super(tbPageContext.getPageActivity());
            this.fvE = R.drawable.icon_card_morelist_n;
            setGravity(17);
            setOnClickListener(this);
            LayoutInflater.from(getContext()).inflate(R.layout.bottom_menu_item, this);
            this.mPageContext = tbPageContext;
            this.fvF = (ImageView) findViewById(R.id.item_image);
            this.fvG = (TextView) findViewById(R.id.item_text);
        }

        public void setOnMenuItemClickListener(a aVar) {
            this.fvC = aVar;
        }

        public void setMenuData(BottomMenu bottomMenu) {
            if (bottomMenu != null) {
                this.fvH = bottomMenu;
                this.fvI = v.Z(bottomMenu.submenu) > 0;
                this.fvG.setText(bottomMenu.name);
                onChangeSkinType(this.mPageContext, 0);
            }
        }

        public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
            setMenuIcon(this.fvE);
            al.j(this.fvG, R.color.cp_cont_b);
            al.k(this, R.drawable.addresslist_item_bg);
        }

        private void setMenuIcon(int i) {
            this.fvE = i;
            if (this.fvI) {
                this.fvF.setVisibility(0);
                this.fvF.setImageResource(i);
                al.c(this.fvF, i);
                return;
            }
            this.fvF.setVisibility(8);
        }

        public e getPageContext() {
            return this.mPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.fvI) {
                getSubMenuGenerator().a(this, this.fvH.submenu);
            }
            if (this.fvC != null) {
                this.fvC.a(this, this.fvH);
            }
        }

        private b getSubMenuGenerator() {
            if (this.fvJ == null) {
                this.fvJ = new b();
                this.fvJ.setOnMenuItemClickListener(this.fvC);
            }
            return this.fvJ;
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements View.OnClickListener {
        private PopupWindow aOK;
        private a fvC;
        private RelativeLayout fvK;
        private final int[] fvL = new int[2];

        public void setOnMenuItemClickListener(a aVar) {
            this.fvC = aVar;
        }

        public void a(MenuItemView menuItemView, List<SubBottomMenu> list) {
            if (menuItemView != null && !v.aa(list)) {
                Activity pageActivity = menuItemView.getPageContext().getPageActivity();
                this.fvK = new RelativeLayout(pageActivity);
                this.fvK.setBackgroundColor(al.getColor(R.color.cp_mask_f));
                this.fvK.setOnClickListener(this);
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
                this.fvK.addView(linearLayout);
                menuItemView.getLocationInWindow(this.fvL);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.width = menuItemView.getWidth();
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.fvL[0];
                this.aOK = new PopupWindow(this.fvK, -1, this.fvL[1]);
                this.aOK.setOutsideTouchable(true);
                this.aOK.setFocusable(true);
                this.aOK.setClippingEnabled(false);
                this.aOK.setBackgroundDrawable(new ColorDrawable());
                this.aOK.setSoftInputMode(16);
                g.showPopupWindowAtLocation(this.aOK, menuItemView, 51, 0, 0);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view instanceof SubMenuItemView) {
                g.a(this.aOK);
                SubMenuItemView subMenuItemView = (SubMenuItemView) view;
                if (this.fvC != null) {
                    this.fvC.a(subMenuItemView, subMenuItemView.getSubMenuData());
                }
            } else if (view == this.fvK) {
                g.a(this.aOK);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class SubMenuItemView extends LinearLayout {
        private View bpR;
        private SubBottomMenu fvM;
        private TextView mTitleView;

        public SubMenuItemView(Context context) {
            super(context);
            LayoutInflater.from(context).inflate(R.layout.bottom_submenu_item, this);
            setOrientation(1);
            this.mTitleView = (TextView) findViewById(R.id.item_text);
            this.bpR = findViewById(R.id.divider_line);
        }

        public void setSubMenuData(SubBottomMenu subBottomMenu, int i, boolean z) {
            if (subBottomMenu != null) {
                this.fvM = subBottomMenu;
                this.mTitleView.setText(subBottomMenu.name);
                al.j(this.mTitleView, R.color.cp_cont_f);
                al.k(this, i == 0 ? R.drawable.bottom_menu_item_bg_corner_selector : R.drawable.bottom_menu_item_bg_selector);
                if (z) {
                    this.bpR.setVisibility(8);
                    return;
                }
                this.bpR.setVisibility(0);
                al.l(this.bpR, R.color.cp_bg_line_b);
            }
        }

        public SubBottomMenu getSubMenuData() {
            return this.fvM;
        }
    }
}
