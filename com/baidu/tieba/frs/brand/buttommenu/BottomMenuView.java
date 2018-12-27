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
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes6.dex */
public class BottomMenuView extends LinearLayout {
    private View byS;
    private a dQO;
    private LinearLayout dQP;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    /* loaded from: classes6.dex */
    public interface a {
        void a(MenuItemView menuItemView, BottomMenu bottomMenu);

        void a(SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void gY(boolean z);
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
        this.dQO = aVar;
    }

    public void a(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        if (!v.I(list)) {
            this.mPageContext = tbPageContext;
            removeAllViews();
            this.byS = new View(getContext());
            this.byS.setLayoutParams(new LinearLayout.LayoutParams(-1, l.h(getContext(), e.C0210e.tbds1)));
            al.j(this.byS, e.d.cp_bg_line_b);
            addView(this.byS);
            this.dQP = new LinearLayout(getContext());
            this.dQP.setOrientation(0);
            this.dQP.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            addView(this.dQP);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                MenuItemView menuItemView = new MenuItemView(tbPageContext);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                menuItemView.setLayoutParams(layoutParams);
                menuItemView.setMenuData(list.get(i));
                menuItemView.setOnMenuItemClickListener(this.dQO);
                this.dQP.addView(menuItemView);
                if (i < size - 1) {
                    View view = new View(getContext());
                    view.setLayoutParams(new LinearLayout.LayoutParams(l.h(getContext(), e.C0210e.tbds1), l.h(getContext(), e.C0210e.tbds116)));
                    this.dQP.addView(view);
                    al.j(view, e.d.cp_bg_line_b);
                }
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType && this.dQP != null) {
            this.mSkinType = i;
            int childCount = this.dQP.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.dQP.getChildAt(i2);
                if (childAt != null) {
                    if (childAt instanceof MenuItemView) {
                        ((MenuItemView) childAt).d(tbPageContext, i);
                    } else {
                        al.j(childAt, e.d.cp_bg_line_b);
                    }
                } else {
                    return;
                }
            }
            al.j(this.byS, e.d.cp_bg_line_b);
        }
    }

    /* loaded from: classes6.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener, b {
        private static final int dQQ = e.f.icon_tabbar_frs_more_s;
        private static final int dQR = e.f.icon_tabbar_frs_more_n;
        private a dQO;
        private int dQS;
        private ImageView dQT;
        private TextView dQU;
        private BottomMenu dQV;
        private boolean dQW;
        private c dQX;
        private TbPageContext<?> mPageContext;

        public MenuItemView(TbPageContext<?> tbPageContext) {
            super(tbPageContext.getPageActivity());
            this.dQS = dQR;
            setGravity(17);
            setOnClickListener(this);
            LayoutInflater.from(getContext()).inflate(e.h.bottom_menu_item, this);
            this.mPageContext = tbPageContext;
            this.dQT = (ImageView) findViewById(e.g.item_image);
            this.dQU = (TextView) findViewById(e.g.item_text);
        }

        public void setOnMenuItemClickListener(a aVar) {
            this.dQO = aVar;
        }

        public void setMenuData(BottomMenu bottomMenu) {
            if (bottomMenu != null) {
                this.dQV = bottomMenu;
                this.dQW = v.H(bottomMenu.submenu) > 0;
                this.dQU.setText(bottomMenu.name);
                d(this.mPageContext, 0);
            }
        }

        public void d(TbPageContext<?> tbPageContext, int i) {
            setMenuIcon(this.dQS);
            al.h(this.dQU, e.d.cp_cont_f);
            al.i(this, e.f.addresslist_item_bg);
        }

        private void setMenuIcon(int i) {
            this.dQS = i;
            if (this.dQW) {
                this.dQT.setVisibility(0);
                this.dQT.setImageResource(i);
                al.c(this.dQT, i);
                return;
            }
            this.dQT.setVisibility(8);
        }

        public com.baidu.adp.base.e getPageContext() {
            return this.mPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.dQW) {
                getSubMenuGenerator().a(this, this.dQV.submenu);
            }
            if (this.dQO != null) {
                this.dQO.a(this, this.dQV);
            }
        }

        private c getSubMenuGenerator() {
            if (this.dQX == null) {
                this.dQX = new c();
                this.dQX.setOnMenuItemClickListener(this.dQO);
                this.dQX.a(this);
            }
            return this.dQX;
        }

        @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.b
        public void gY(boolean z) {
            setMenuIcon(z ? dQQ : dQR);
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements View.OnClickListener {
        private a dQO;
        private b dQY;
        private RelativeLayout dQZ;
        private final int[] dRa = new int[2];
        private PopupWindow mPopupWindow;

        public void setOnMenuItemClickListener(a aVar) {
            this.dQO = aVar;
        }

        public void a(b bVar) {
            this.dQY = bVar;
        }

        public void a(MenuItemView menuItemView, List<SubBottomMenu> list) {
            if (menuItemView != null && !v.I(list)) {
                Activity pageActivity = menuItemView.getPageContext().getPageActivity();
                this.dQZ = new RelativeLayout(pageActivity);
                this.dQZ.setBackgroundColor(al.getColor(e.d.black_alpha30));
                this.dQZ.setOnClickListener(this);
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
                this.dQZ.addView(linearLayout);
                menuItemView.getLocationInWindow(this.dRa);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.width = menuItemView.getWidth();
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.dRa[0];
                this.mPopupWindow = new PopupWindow(this.dQZ, -1, this.dRa[1]);
                this.mPopupWindow.setOutsideTouchable(true);
                this.mPopupWindow.setFocusable(true);
                this.mPopupWindow.setClippingEnabled(false);
                this.mPopupWindow.setBackgroundDrawable(new ColorDrawable());
                this.mPopupWindow.setSoftInputMode(16);
                g.showPopupWindowAtLocation(this.mPopupWindow, menuItemView, 51, 0, 0);
                this.mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.c.1
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        if (c.this.dQY != null) {
                            c.this.dQY.gY(false);
                        }
                    }
                });
                if (this.dQY != null) {
                    this.dQY.gY(true);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view instanceof SubMenuItemView) {
                g.a(this.mPopupWindow);
                SubMenuItemView subMenuItemView = (SubMenuItemView) view;
                if (this.dQO != null) {
                    this.dQO.a(subMenuItemView, subMenuItemView.getSubMenuData());
                }
            } else if (view == this.dQZ) {
                g.a(this.mPopupWindow);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class SubMenuItemView extends LinearLayout {
        private SubBottomMenu dRc;
        private View mDividerView;
        private TextView mTitleView;

        public SubMenuItemView(Context context) {
            super(context);
            LayoutInflater.from(context).inflate(e.h.bottom_submenu_item, this);
            setOrientation(1);
            this.mTitleView = (TextView) findViewById(e.g.item_text);
            this.mDividerView = findViewById(e.g.divider_line);
        }

        public void setSubMenuData(SubBottomMenu subBottomMenu, int i, boolean z) {
            if (subBottomMenu != null) {
                this.dRc = subBottomMenu;
                this.mTitleView.setText(subBottomMenu.name);
                al.h(this.mTitleView, e.d.cp_cont_f);
                al.i(this, i == 0 ? e.f.bottom_menu_item_bg_corner_selector : e.f.bottom_menu_item_bg_selector);
                if (z) {
                    this.mDividerView.setVisibility(8);
                    return;
                }
                this.mDividerView.setVisibility(0);
                al.j(this.mDividerView, e.d.cp_bg_line_b);
            }
        }

        public SubBottomMenu getSubMenuData() {
            return this.dRc;
        }
    }
}
