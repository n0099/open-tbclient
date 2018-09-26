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
/* loaded from: classes2.dex */
public class BottomMenuView extends LinearLayout {
    private View bqy;
    private a dyl;
    private LinearLayout dym;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    /* loaded from: classes2.dex */
    public interface a {
        void a(MenuItemView menuItemView, BottomMenu bottomMenu);

        void a(SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void gs(boolean z);
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
        this.dyl = aVar;
    }

    public void a(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        if (!v.z(list)) {
            this.mPageContext = tbPageContext;
            removeAllViews();
            this.bqy = new View(getContext());
            this.bqy.setLayoutParams(new LinearLayout.LayoutParams(-1, l.h(getContext(), e.C0141e.tbds1)));
            al.j(this.bqy, e.d.cp_bg_line_b);
            addView(this.bqy);
            this.dym = new LinearLayout(getContext());
            this.dym.setOrientation(0);
            this.dym.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            addView(this.dym);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                MenuItemView menuItemView = new MenuItemView(tbPageContext);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                menuItemView.setLayoutParams(layoutParams);
                menuItemView.setMenuData(list.get(i));
                menuItemView.setOnMenuItemClickListener(this.dyl);
                this.dym.addView(menuItemView);
                if (i < size - 1) {
                    View view = new View(getContext());
                    view.setLayoutParams(new LinearLayout.LayoutParams(l.h(getContext(), e.C0141e.tbds1), l.h(getContext(), e.C0141e.tbds116)));
                    this.dym.addView(view);
                    al.j(view, e.d.cp_bg_line_b);
                }
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType && this.dym != null) {
            this.mSkinType = i;
            int childCount = this.dym.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.dym.getChildAt(i2);
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
            al.j(this.bqy, e.d.cp_bg_line_b);
        }
    }

    /* loaded from: classes2.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener, b {
        private static final int dyn = e.f.icon_tabbar_frs_more_s;
        private static final int dyo = e.f.icon_tabbar_frs_more_n;
        private a dyl;
        private int dyp;
        private ImageView dyq;
        private TextView dyr;
        private BottomMenu dys;
        private boolean dyt;
        private c dyu;
        private TbPageContext<?> mPageContext;

        public MenuItemView(TbPageContext<?> tbPageContext) {
            super(tbPageContext.getPageActivity());
            this.dyp = dyo;
            setGravity(17);
            setOnClickListener(this);
            LayoutInflater.from(getContext()).inflate(e.h.bottom_menu_item, this);
            this.mPageContext = tbPageContext;
            this.dyq = (ImageView) findViewById(e.g.item_image);
            this.dyr = (TextView) findViewById(e.g.item_text);
        }

        public void setOnMenuItemClickListener(a aVar) {
            this.dyl = aVar;
        }

        public void setMenuData(BottomMenu bottomMenu) {
            if (bottomMenu != null) {
                this.dys = bottomMenu;
                this.dyt = v.y(bottomMenu.submenu) > 0;
                this.dyr.setText(bottomMenu.name);
                d(this.mPageContext, 0);
            }
        }

        public void d(TbPageContext<?> tbPageContext, int i) {
            setMenuIcon(this.dyp);
            al.h(this.dyr, e.d.cp_cont_f);
            al.i(this, e.f.addresslist_item_bg);
        }

        private void setMenuIcon(int i) {
            this.dyp = i;
            if (this.dyt) {
                this.dyq.setVisibility(0);
                this.dyq.setImageResource(i);
                al.c(this.dyq, i);
                return;
            }
            this.dyq.setVisibility(8);
        }

        public com.baidu.adp.base.e getPageContext() {
            return this.mPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.dyt) {
                getSubMenuGenerator().a(this, this.dys.submenu);
            }
            if (this.dyl != null) {
                this.dyl.a(this, this.dys);
            }
        }

        private c getSubMenuGenerator() {
            if (this.dyu == null) {
                this.dyu = new c();
                this.dyu.setOnMenuItemClickListener(this.dyl);
                this.dyu.a(this);
            }
            return this.dyu;
        }

        @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.b
        public void gs(boolean z) {
            setMenuIcon(z ? dyn : dyo);
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements View.OnClickListener {
        private PopupWindow boG;
        private a dyl;
        private b dyv;
        private RelativeLayout dyw;
        private final int[] dyx = new int[2];

        public void setOnMenuItemClickListener(a aVar) {
            this.dyl = aVar;
        }

        public void a(b bVar) {
            this.dyv = bVar;
        }

        public void a(MenuItemView menuItemView, List<SubBottomMenu> list) {
            if (menuItemView != null && !v.z(list)) {
                Activity pageActivity = menuItemView.getPageContext().getPageActivity();
                this.dyw = new RelativeLayout(pageActivity);
                this.dyw.setBackgroundColor(al.getColor(e.d.black_alpha30));
                this.dyw.setOnClickListener(this);
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
                this.dyw.addView(linearLayout);
                menuItemView.getLocationInWindow(this.dyx);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.width = menuItemView.getWidth();
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.dyx[0];
                this.boG = new PopupWindow(this.dyw, -1, this.dyx[1]);
                this.boG.setOutsideTouchable(true);
                this.boG.setFocusable(true);
                this.boG.setClippingEnabled(false);
                this.boG.setBackgroundDrawable(new ColorDrawable());
                this.boG.setSoftInputMode(16);
                g.showPopupWindowAtLocation(this.boG, menuItemView, 51, 0, 0);
                this.boG.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.c.1
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        if (c.this.dyv != null) {
                            c.this.dyv.gs(false);
                        }
                    }
                });
                if (this.dyv != null) {
                    this.dyv.gs(true);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view instanceof SubMenuItemView) {
                g.a(this.boG);
                SubMenuItemView subMenuItemView = (SubMenuItemView) view;
                if (this.dyl != null) {
                    this.dyl.a(subMenuItemView, subMenuItemView.getSubMenuData());
                }
            } else if (view == this.dyw) {
                g.a(this.boG);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class SubMenuItemView extends LinearLayout {
        private View daE;
        private SubBottomMenu dyz;
        private TextView mTitleView;

        public SubMenuItemView(Context context) {
            super(context);
            LayoutInflater.from(context).inflate(e.h.bottom_submenu_item, this);
            setOrientation(1);
            this.mTitleView = (TextView) findViewById(e.g.item_text);
            this.daE = findViewById(e.g.divider_line);
        }

        public void setSubMenuData(SubBottomMenu subBottomMenu, int i, boolean z) {
            if (subBottomMenu != null) {
                this.dyz = subBottomMenu;
                this.mTitleView.setText(subBottomMenu.name);
                al.h(this.mTitleView, e.d.cp_cont_f);
                al.i(this, i == 0 ? e.f.bottom_menu_item_bg_corner_selector : e.f.bottom_menu_item_bg_selector);
                if (z) {
                    this.daE.setVisibility(8);
                    return;
                }
                this.daE.setVisibility(0);
                al.j(this.daE, e.d.cp_bg_line_b);
            }
        }

        public SubBottomMenu getSubMenuData() {
            return this.dyz;
        }
    }
}
