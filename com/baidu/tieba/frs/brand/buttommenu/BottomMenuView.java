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
    private View bjZ;
    private a dpl;
    private LinearLayout dpm;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    /* loaded from: classes2.dex */
    public interface a {
        void a(MenuItemView menuItemView, BottomMenu bottomMenu);

        void a(SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void fT(boolean z);
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
        this.dpl = aVar;
    }

    public void a(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        if (!w.A(list)) {
            this.mPageContext = tbPageContext;
            removeAllViews();
            this.bjZ = new View(getContext());
            this.bjZ.setLayoutParams(new LinearLayout.LayoutParams(-1, l.e(getContext(), d.e.tbds1)));
            am.j(this.bjZ, d.C0142d.cp_bg_line_b);
            addView(this.bjZ);
            this.dpm = new LinearLayout(getContext());
            this.dpm.setOrientation(0);
            this.dpm.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            addView(this.dpm);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                MenuItemView menuItemView = new MenuItemView(tbPageContext);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                menuItemView.setLayoutParams(layoutParams);
                menuItemView.setMenuData(list.get(i));
                menuItemView.setOnMenuItemClickListener(this.dpl);
                this.dpm.addView(menuItemView);
                if (i < size - 1) {
                    View view = new View(getContext());
                    view.setLayoutParams(new LinearLayout.LayoutParams(l.e(getContext(), d.e.tbds1), l.e(getContext(), d.e.tbds116)));
                    this.dpm.addView(view);
                    am.j(view, d.C0142d.cp_bg_line_b);
                }
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType && this.dpm != null) {
            this.mSkinType = i;
            int childCount = this.dpm.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.dpm.getChildAt(i2);
                if (childAt != null) {
                    if (childAt instanceof MenuItemView) {
                        ((MenuItemView) childAt).d(tbPageContext, i);
                    } else {
                        am.j(childAt, d.C0142d.cp_bg_line_b);
                    }
                } else {
                    return;
                }
            }
            am.j(this.bjZ, d.C0142d.cp_bg_line_b);
        }
    }

    /* loaded from: classes2.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener, b {
        private static final int dpn = d.f.icon_tabbar_frs_more_s;
        private static final int dpo = d.f.icon_tabbar_frs_more_n;
        private a dpl;
        private int dpp;
        private ImageView dpq;
        private TextView dpr;
        private BottomMenu dps;
        private boolean dpt;
        private c dpu;
        private TbPageContext<?> mPageContext;

        public MenuItemView(TbPageContext<?> tbPageContext) {
            super(tbPageContext.getPageActivity());
            this.dpp = dpo;
            setGravity(17);
            setOnClickListener(this);
            LayoutInflater.from(getContext()).inflate(d.i.bottom_menu_item, this);
            this.mPageContext = tbPageContext;
            this.dpq = (ImageView) findViewById(d.g.item_image);
            this.dpr = (TextView) findViewById(d.g.item_text);
        }

        public void setOnMenuItemClickListener(a aVar) {
            this.dpl = aVar;
        }

        public void setMenuData(BottomMenu bottomMenu) {
            if (bottomMenu != null) {
                this.dps = bottomMenu;
                this.dpt = w.z(bottomMenu.submenu) > 0;
                this.dpr.setText(bottomMenu.name);
                d(this.mPageContext, 0);
            }
        }

        public void d(TbPageContext<?> tbPageContext, int i) {
            setMenuIcon(this.dpp);
            am.h(this.dpr, d.C0142d.cp_cont_f);
            am.i(this, d.f.addresslist_item_bg);
        }

        private void setMenuIcon(int i) {
            this.dpp = i;
            if (this.dpt) {
                this.dpq.setVisibility(0);
                this.dpq.setImageResource(i);
                am.c(this.dpq, i);
                return;
            }
            this.dpq.setVisibility(8);
        }

        public e getPageContext() {
            return this.mPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.dpt) {
                getSubMenuGenerator().a(this, this.dps.submenu);
            }
            if (this.dpl != null) {
                this.dpl.a(this, this.dps);
            }
        }

        private c getSubMenuGenerator() {
            if (this.dpu == null) {
                this.dpu = new c();
                this.dpu.setOnMenuItemClickListener(this.dpl);
                this.dpu.a(this);
            }
            return this.dpu;
        }

        @Override // com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.b
        public void fT(boolean z) {
            setMenuIcon(z ? dpn : dpo);
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements View.OnClickListener {
        private PopupWindow bil;
        private a dpl;
        private b dpv;
        private RelativeLayout dpw;
        private final int[] dpx = new int[2];

        public void setOnMenuItemClickListener(a aVar) {
            this.dpl = aVar;
        }

        public void a(b bVar) {
            this.dpv = bVar;
        }

        public void a(MenuItemView menuItemView, List<SubBottomMenu> list) {
            if (menuItemView != null && !w.A(list)) {
                Activity pageActivity = menuItemView.getPageContext().getPageActivity();
                this.dpw = new RelativeLayout(pageActivity);
                this.dpw.setBackgroundColor(am.getColor(d.C0142d.black_alpha30));
                this.dpw.setOnClickListener(this);
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
                this.dpw.addView(linearLayout);
                menuItemView.getLocationInWindow(this.dpx);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.width = menuItemView.getWidth();
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.dpx[0];
                this.bil = new PopupWindow(this.dpw, -1, this.dpx[1]);
                this.bil.setOutsideTouchable(true);
                this.bil.setFocusable(true);
                this.bil.setClippingEnabled(false);
                this.bil.setBackgroundDrawable(new ColorDrawable());
                this.bil.setSoftInputMode(16);
                g.showPopupWindowAtLocation(this.bil, menuItemView, 51, 0, 0);
                this.bil.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.brand.buttommenu.BottomMenuView.c.1
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        if (c.this.dpv != null) {
                            c.this.dpv.fT(false);
                        }
                    }
                });
                if (this.dpv != null) {
                    this.dpv.fT(true);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view instanceof SubMenuItemView) {
                g.a(this.bil);
                SubMenuItemView subMenuItemView = (SubMenuItemView) view;
                if (this.dpl != null) {
                    this.dpl.a(subMenuItemView, subMenuItemView.getSubMenuData());
                }
            } else if (view == this.dpw) {
                g.a(this.bil);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class SubMenuItemView extends LinearLayout {
        private View cSc;
        private SubBottomMenu dpz;
        private TextView mTitleView;

        public SubMenuItemView(Context context) {
            super(context);
            LayoutInflater.from(context).inflate(d.i.bottom_submenu_item, this);
            setOrientation(1);
            this.mTitleView = (TextView) findViewById(d.g.item_text);
            this.cSc = findViewById(d.g.divider_line);
        }

        public void setSubMenuData(SubBottomMenu subBottomMenu, int i, boolean z) {
            if (subBottomMenu != null) {
                this.dpz = subBottomMenu;
                this.mTitleView.setText(subBottomMenu.name);
                am.h(this.mTitleView, d.C0142d.cp_cont_f);
                am.i(this, i == 0 ? d.f.bottom_menu_item_bg_corner_selector : d.f.bottom_menu_item_bg_selector);
                if (z) {
                    this.cSc.setVisibility(8);
                    return;
                }
                this.cSc.setVisibility(0);
                am.j(this.cSc, d.C0142d.cp_bg_line_b);
            }
        }

        public SubBottomMenu getSubMenuData() {
            return this.dpz;
        }
    }
}
