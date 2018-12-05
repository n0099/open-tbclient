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
    private View byP;
    private a dOa;
    private LinearLayout dOb;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    /* loaded from: classes6.dex */
    public interface a {
        void a(MenuItemView menuItemView, BottomMenu bottomMenu);

        void a(SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void gV(boolean z);
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
        this.dOa = aVar;
    }

    public void a(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        if (!v.I(list)) {
            this.mPageContext = tbPageContext;
            removeAllViews();
            this.byP = new View(getContext());
            this.byP.setLayoutParams(new LinearLayout.LayoutParams(-1, l.h(getContext(), e.C0210e.tbds1)));
            al.j(this.byP, e.d.cp_bg_line_b);
            addView(this.byP);
            this.dOb = new LinearLayout(getContext());
            this.dOb.setOrientation(0);
            this.dOb.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            addView(this.dOb);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                MenuItemView menuItemView = new MenuItemView(tbPageContext);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                menuItemView.setLayoutParams(layoutParams);
                menuItemView.setMenuData(list.get(i));
                menuItemView.setOnMenuItemClickListener(this.dOa);
                this.dOb.addView(menuItemView);
                if (i < size - 1) {
                    View view = new View(getContext());
                    view.setLayoutParams(new LinearLayout.LayoutParams(l.h(getContext(), e.C0210e.tbds1), l.h(getContext(), e.C0210e.tbds116)));
                    this.dOb.addView(view);
                    al.j(view, e.d.cp_bg_line_b);
                }
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType && this.dOb != null) {
            this.mSkinType = i;
            int childCount = this.dOb.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.dOb.getChildAt(i2);
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
            al.j(this.byP, e.d.cp_bg_line_b);
        }
    }

    /* loaded from: classes6.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener, b {
        private static final int dOc = e.f.icon_tabbar_frs_more_s;
        private static final int dOd = e.f.icon_tabbar_frs_more_n;
        private a dOa;
        private int dOe;
        private ImageView dOf;
        private TextView dOg;
        private BottomMenu dOh;
        private boolean dOi;
        private c dOj;
        private TbPageContext<?> mPageContext;

        public MenuItemView(TbPageContext<?> tbPageContext) {
            super(tbPageContext.getPageActivity());
            this.dOe = dOd;
            setGravity(17);
            setOnClickListener(this);
            LayoutInflater.from(getContext()).inflate(e.h.bottom_menu_item, this);
            this.mPageContext = tbPageContext;
            this.dOf = (ImageView) findViewById(e.g.item_image);
            this.dOg = (TextView) findViewById(e.g.item_text);
        }

        public void setOnMenuItemClickListener(a aVar) {
            this.dOa = aVar;
        }

        public void setMenuData(BottomMenu bottomMenu) {
            if (bottomMenu != null) {
                this.dOh = bottomMenu;
                this.dOi = v.H(bottomMenu.submenu) > 0;
                this.dOg.setText(bottomMenu.name);
                d(this.mPageContext, 0);
            }
        }

        public void d(TbPageContext<?> tbPageContext, int i) {
            setMenuIcon(this.dOe);
            al.h(this.dOg, e.d.cp_cont_f);
            al.i(this, e.f.addresslist_item_bg);
        }

        private void setMenuIcon(int i) {
            this.dOe = i;
            if (this.dOi) {
                this.dOf.setVisibility(0);
                this.dOf.setImageResource(i);
                al.c(this.dOf, i);
                return;
            }
            this.dOf.setVisibility(8);
        }

        public com.baidu.adp.base.e getPageContext() {
            return this.mPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.dOi) {
                getSubMenuGenerator().a(this, this.dOh.submenu);
            }
            if (this.dOa != null) {
                this.dOa.a(this, this.dOh);
            }
        }

        private c getSubMenuGenerator() {
            if (this.dOj == null) {
                this.dOj = new c();
                this.dOj.setOnMenuItemClickListener(this.dOa);
                this.dOj.a(this);
            }
            return this.dOj;
        }

        @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.b
        public void gV(boolean z) {
            setMenuIcon(z ? dOc : dOd);
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements View.OnClickListener {
        private a dOa;
        private b dOk;
        private RelativeLayout dOl;
        private final int[] dOm = new int[2];
        private PopupWindow mPopupWindow;

        public void setOnMenuItemClickListener(a aVar) {
            this.dOa = aVar;
        }

        public void a(b bVar) {
            this.dOk = bVar;
        }

        public void a(MenuItemView menuItemView, List<SubBottomMenu> list) {
            if (menuItemView != null && !v.I(list)) {
                Activity pageActivity = menuItemView.getPageContext().getPageActivity();
                this.dOl = new RelativeLayout(pageActivity);
                this.dOl.setBackgroundColor(al.getColor(e.d.black_alpha30));
                this.dOl.setOnClickListener(this);
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
                this.dOl.addView(linearLayout);
                menuItemView.getLocationInWindow(this.dOm);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.width = menuItemView.getWidth();
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.dOm[0];
                this.mPopupWindow = new PopupWindow(this.dOl, -1, this.dOm[1]);
                this.mPopupWindow.setOutsideTouchable(true);
                this.mPopupWindow.setFocusable(true);
                this.mPopupWindow.setClippingEnabled(false);
                this.mPopupWindow.setBackgroundDrawable(new ColorDrawable());
                this.mPopupWindow.setSoftInputMode(16);
                g.showPopupWindowAtLocation(this.mPopupWindow, menuItemView, 51, 0, 0);
                this.mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.c.1
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        if (c.this.dOk != null) {
                            c.this.dOk.gV(false);
                        }
                    }
                });
                if (this.dOk != null) {
                    this.dOk.gV(true);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view instanceof SubMenuItemView) {
                g.a(this.mPopupWindow);
                SubMenuItemView subMenuItemView = (SubMenuItemView) view;
                if (this.dOa != null) {
                    this.dOa.a(subMenuItemView, subMenuItemView.getSubMenuData());
                }
            } else if (view == this.dOl) {
                g.a(this.mPopupWindow);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class SubMenuItemView extends LinearLayout {
        private SubBottomMenu dOo;
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
                this.dOo = subBottomMenu;
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
            return this.dOo;
        }
    }
}
