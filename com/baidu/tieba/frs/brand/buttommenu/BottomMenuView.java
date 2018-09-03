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
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.f;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes2.dex */
public class BottomMenuView extends LinearLayout {
    private View bkJ;
    private a drV;
    private LinearLayout drW;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    /* loaded from: classes2.dex */
    public interface a {
        void a(MenuItemView menuItemView, BottomMenu bottomMenu);

        void a(SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void fV(boolean z);
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
        this.drV = aVar;
    }

    public void a(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        if (!w.z(list)) {
            this.mPageContext = tbPageContext;
            removeAllViews();
            this.bkJ = new View(getContext());
            this.bkJ.setLayoutParams(new LinearLayout.LayoutParams(-1, l.f(getContext(), f.e.tbds1)));
            am.j(this.bkJ, f.d.cp_bg_line_b);
            addView(this.bkJ);
            this.drW = new LinearLayout(getContext());
            this.drW.setOrientation(0);
            this.drW.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            addView(this.drW);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                MenuItemView menuItemView = new MenuItemView(tbPageContext);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                menuItemView.setLayoutParams(layoutParams);
                menuItemView.setMenuData(list.get(i));
                menuItemView.setOnMenuItemClickListener(this.drV);
                this.drW.addView(menuItemView);
                if (i < size - 1) {
                    View view = new View(getContext());
                    view.setLayoutParams(new LinearLayout.LayoutParams(l.f(getContext(), f.e.tbds1), l.f(getContext(), f.e.tbds116)));
                    this.drW.addView(view);
                    am.j(view, f.d.cp_bg_line_b);
                }
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType && this.drW != null) {
            this.mSkinType = i;
            int childCount = this.drW.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.drW.getChildAt(i2);
                if (childAt != null) {
                    if (childAt instanceof MenuItemView) {
                        ((MenuItemView) childAt).d(tbPageContext, i);
                    } else {
                        am.j(childAt, f.d.cp_bg_line_b);
                    }
                } else {
                    return;
                }
            }
            am.j(this.bkJ, f.d.cp_bg_line_b);
        }
    }

    /* loaded from: classes2.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener, b {
        private static final int drX = f.C0146f.icon_tabbar_frs_more_s;
        private static final int drY = f.C0146f.icon_tabbar_frs_more_n;
        private a drV;
        private int drZ;
        private ImageView dsa;
        private TextView dsb;
        private BottomMenu dsc;
        private boolean dsd;
        private c dse;
        private TbPageContext<?> mPageContext;

        public MenuItemView(TbPageContext<?> tbPageContext) {
            super(tbPageContext.getPageActivity());
            this.drZ = drY;
            setGravity(17);
            setOnClickListener(this);
            LayoutInflater.from(getContext()).inflate(f.h.bottom_menu_item, this);
            this.mPageContext = tbPageContext;
            this.dsa = (ImageView) findViewById(f.g.item_image);
            this.dsb = (TextView) findViewById(f.g.item_text);
        }

        public void setOnMenuItemClickListener(a aVar) {
            this.drV = aVar;
        }

        public void setMenuData(BottomMenu bottomMenu) {
            if (bottomMenu != null) {
                this.dsc = bottomMenu;
                this.dsd = w.y(bottomMenu.submenu) > 0;
                this.dsb.setText(bottomMenu.name);
                d(this.mPageContext, 0);
            }
        }

        public void d(TbPageContext<?> tbPageContext, int i) {
            setMenuIcon(this.drZ);
            am.h(this.dsb, f.d.cp_cont_f);
            am.i(this, f.C0146f.addresslist_item_bg);
        }

        private void setMenuIcon(int i) {
            this.drZ = i;
            if (this.dsd) {
                this.dsa.setVisibility(0);
                this.dsa.setImageResource(i);
                am.c(this.dsa, i);
                return;
            }
            this.dsa.setVisibility(8);
        }

        public e getPageContext() {
            return this.mPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.dsd) {
                getSubMenuGenerator().a(this, this.dsc.submenu);
            }
            if (this.drV != null) {
                this.drV.a(this, this.dsc);
            }
        }

        private c getSubMenuGenerator() {
            if (this.dse == null) {
                this.dse = new c();
                this.dse.setOnMenuItemClickListener(this.drV);
                this.dse.a(this);
            }
            return this.dse;
        }

        @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.b
        public void fV(boolean z) {
            setMenuIcon(z ? drX : drY);
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements View.OnClickListener {
        private PopupWindow biW;
        private a drV;
        private b dsf;
        private RelativeLayout dsg;
        private final int[] dsh = new int[2];

        public void setOnMenuItemClickListener(a aVar) {
            this.drV = aVar;
        }

        public void a(b bVar) {
            this.dsf = bVar;
        }

        public void a(MenuItemView menuItemView, List<SubBottomMenu> list) {
            if (menuItemView != null && !w.z(list)) {
                Activity pageActivity = menuItemView.getPageContext().getPageActivity();
                this.dsg = new RelativeLayout(pageActivity);
                this.dsg.setBackgroundColor(am.getColor(f.d.black_alpha30));
                this.dsg.setOnClickListener(this);
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
                this.dsg.addView(linearLayout);
                menuItemView.getLocationInWindow(this.dsh);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.width = menuItemView.getWidth();
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.dsh[0];
                this.biW = new PopupWindow(this.dsg, -1, this.dsh[1]);
                this.biW.setOutsideTouchable(true);
                this.biW.setFocusable(true);
                this.biW.setClippingEnabled(false);
                this.biW.setBackgroundDrawable(new ColorDrawable());
                this.biW.setSoftInputMode(16);
                g.showPopupWindowAtLocation(this.biW, menuItemView, 51, 0, 0);
                this.biW.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.c.1
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        if (c.this.dsf != null) {
                            c.this.dsf.fV(false);
                        }
                    }
                });
                if (this.dsf != null) {
                    this.dsf.fV(true);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view instanceof SubMenuItemView) {
                g.a(this.biW);
                SubMenuItemView subMenuItemView = (SubMenuItemView) view;
                if (this.drV != null) {
                    this.drV.a(subMenuItemView, subMenuItemView.getSubMenuData());
                }
            } else if (view == this.dsg) {
                g.a(this.biW);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class SubMenuItemView extends LinearLayout {
        private View cUL;
        private SubBottomMenu dsj;
        private TextView mTitleView;

        public SubMenuItemView(Context context) {
            super(context);
            LayoutInflater.from(context).inflate(f.h.bottom_submenu_item, this);
            setOrientation(1);
            this.mTitleView = (TextView) findViewById(f.g.item_text);
            this.cUL = findViewById(f.g.divider_line);
        }

        public void setSubMenuData(SubBottomMenu subBottomMenu, int i, boolean z) {
            if (subBottomMenu != null) {
                this.dsj = subBottomMenu;
                this.mTitleView.setText(subBottomMenu.name);
                am.h(this.mTitleView, f.d.cp_cont_f);
                am.i(this, i == 0 ? f.C0146f.bottom_menu_item_bg_corner_selector : f.C0146f.bottom_menu_item_bg_selector);
                if (z) {
                    this.cUL.setVisibility(8);
                    return;
                }
                this.cUL.setVisibility(0);
                am.j(this.cUL, f.d.cp_bg_line_b);
            }
        }

        public SubBottomMenu getSubMenuData() {
            return this.dsj;
        }
    }
}
