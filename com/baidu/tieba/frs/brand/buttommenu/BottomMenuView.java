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
import com.baidu.tieba.d;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes2.dex */
public class BottomMenuView extends LinearLayout {
    private View bkE;
    private a drY;
    private LinearLayout drZ;
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
        this.drY = aVar;
    }

    public void a(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        if (!w.z(list)) {
            this.mPageContext = tbPageContext;
            removeAllViews();
            this.bkE = new View(getContext());
            this.bkE.setLayoutParams(new LinearLayout.LayoutParams(-1, l.f(getContext(), d.e.tbds1)));
            am.j(this.bkE, d.C0140d.cp_bg_line_b);
            addView(this.bkE);
            this.drZ = new LinearLayout(getContext());
            this.drZ.setOrientation(0);
            this.drZ.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            addView(this.drZ);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                MenuItemView menuItemView = new MenuItemView(tbPageContext);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                menuItemView.setLayoutParams(layoutParams);
                menuItemView.setMenuData(list.get(i));
                menuItemView.setOnMenuItemClickListener(this.drY);
                this.drZ.addView(menuItemView);
                if (i < size - 1) {
                    View view = new View(getContext());
                    view.setLayoutParams(new LinearLayout.LayoutParams(l.f(getContext(), d.e.tbds1), l.f(getContext(), d.e.tbds116)));
                    this.drZ.addView(view);
                    am.j(view, d.C0140d.cp_bg_line_b);
                }
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType && this.drZ != null) {
            this.mSkinType = i;
            int childCount = this.drZ.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.drZ.getChildAt(i2);
                if (childAt != null) {
                    if (childAt instanceof MenuItemView) {
                        ((MenuItemView) childAt).d(tbPageContext, i);
                    } else {
                        am.j(childAt, d.C0140d.cp_bg_line_b);
                    }
                } else {
                    return;
                }
            }
            am.j(this.bkE, d.C0140d.cp_bg_line_b);
        }
    }

    /* loaded from: classes2.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener, b {
        private static final int dsa = d.f.icon_tabbar_frs_more_s;
        private static final int dsb = d.f.icon_tabbar_frs_more_n;
        private a drY;
        private int dsc;
        private ImageView dsd;
        private TextView dse;
        private BottomMenu dsf;
        private boolean dsg;
        private c dsh;
        private TbPageContext<?> mPageContext;

        public MenuItemView(TbPageContext<?> tbPageContext) {
            super(tbPageContext.getPageActivity());
            this.dsc = dsb;
            setGravity(17);
            setOnClickListener(this);
            LayoutInflater.from(getContext()).inflate(d.h.bottom_menu_item, this);
            this.mPageContext = tbPageContext;
            this.dsd = (ImageView) findViewById(d.g.item_image);
            this.dse = (TextView) findViewById(d.g.item_text);
        }

        public void setOnMenuItemClickListener(a aVar) {
            this.drY = aVar;
        }

        public void setMenuData(BottomMenu bottomMenu) {
            if (bottomMenu != null) {
                this.dsf = bottomMenu;
                this.dsg = w.y(bottomMenu.submenu) > 0;
                this.dse.setText(bottomMenu.name);
                d(this.mPageContext, 0);
            }
        }

        public void d(TbPageContext<?> tbPageContext, int i) {
            setMenuIcon(this.dsc);
            am.h(this.dse, d.C0140d.cp_cont_f);
            am.i(this, d.f.addresslist_item_bg);
        }

        private void setMenuIcon(int i) {
            this.dsc = i;
            if (this.dsg) {
                this.dsd.setVisibility(0);
                this.dsd.setImageResource(i);
                am.c(this.dsd, i);
                return;
            }
            this.dsd.setVisibility(8);
        }

        public e getPageContext() {
            return this.mPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.dsg) {
                getSubMenuGenerator().a(this, this.dsf.submenu);
            }
            if (this.drY != null) {
                this.drY.a(this, this.dsf);
            }
        }

        private c getSubMenuGenerator() {
            if (this.dsh == null) {
                this.dsh = new c();
                this.dsh.setOnMenuItemClickListener(this.drY);
                this.dsh.a(this);
            }
            return this.dsh;
        }

        @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.b
        public void fV(boolean z) {
            setMenuIcon(z ? dsa : dsb);
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements View.OnClickListener {
        private PopupWindow biQ;
        private a drY;
        private b dsi;
        private RelativeLayout dsj;
        private final int[] dsk = new int[2];

        public void setOnMenuItemClickListener(a aVar) {
            this.drY = aVar;
        }

        public void a(b bVar) {
            this.dsi = bVar;
        }

        public void a(MenuItemView menuItemView, List<SubBottomMenu> list) {
            if (menuItemView != null && !w.z(list)) {
                Activity pageActivity = menuItemView.getPageContext().getPageActivity();
                this.dsj = new RelativeLayout(pageActivity);
                this.dsj.setBackgroundColor(am.getColor(d.C0140d.black_alpha30));
                this.dsj.setOnClickListener(this);
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
                this.dsj.addView(linearLayout);
                menuItemView.getLocationInWindow(this.dsk);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.width = menuItemView.getWidth();
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.dsk[0];
                this.biQ = new PopupWindow(this.dsj, -1, this.dsk[1]);
                this.biQ.setOutsideTouchable(true);
                this.biQ.setFocusable(true);
                this.biQ.setClippingEnabled(false);
                this.biQ.setBackgroundDrawable(new ColorDrawable());
                this.biQ.setSoftInputMode(16);
                g.showPopupWindowAtLocation(this.biQ, menuItemView, 51, 0, 0);
                this.biQ.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.c.1
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        if (c.this.dsi != null) {
                            c.this.dsi.fV(false);
                        }
                    }
                });
                if (this.dsi != null) {
                    this.dsi.fV(true);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view instanceof SubMenuItemView) {
                g.a(this.biQ);
                SubMenuItemView subMenuItemView = (SubMenuItemView) view;
                if (this.drY != null) {
                    this.drY.a(subMenuItemView, subMenuItemView.getSubMenuData());
                }
            } else if (view == this.dsj) {
                g.a(this.biQ);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class SubMenuItemView extends LinearLayout {
        private View cUP;
        private SubBottomMenu dsm;
        private TextView mTitleView;

        public SubMenuItemView(Context context) {
            super(context);
            LayoutInflater.from(context).inflate(d.h.bottom_submenu_item, this);
            setOrientation(1);
            this.mTitleView = (TextView) findViewById(d.g.item_text);
            this.cUP = findViewById(d.g.divider_line);
        }

        public void setSubMenuData(SubBottomMenu subBottomMenu, int i, boolean z) {
            if (subBottomMenu != null) {
                this.dsm = subBottomMenu;
                this.mTitleView.setText(subBottomMenu.name);
                am.h(this.mTitleView, d.C0140d.cp_cont_f);
                am.i(this, i == 0 ? d.f.bottom_menu_item_bg_corner_selector : d.f.bottom_menu_item_bg_selector);
                if (z) {
                    this.cUP.setVisibility(8);
                    return;
                }
                this.cUP.setVisibility(0);
                am.j(this.cUP, d.C0140d.cp_bg_line_b);
            }
        }

        public SubBottomMenu getSubMenuData() {
            return this.dsm;
        }
    }
}
