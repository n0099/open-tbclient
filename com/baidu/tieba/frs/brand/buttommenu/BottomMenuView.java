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
    private a ffo;
    private LinearLayout ffp;
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
        this.ffo = aVar;
    }

    public void a(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        if (!v.T(list)) {
            this.mPageContext = tbPageContext;
            removeAllViews();
            this.cKN = new View(getContext());
            this.cKN.setLayoutParams(new LinearLayout.LayoutParams(-1, l.h(getContext(), d.e.tbds16)));
            this.cKN.setBackgroundResource(d.f.bottom_view_shadow);
            addView(this.cKN);
            this.ffp = new LinearLayout(getContext());
            this.ffp.setOrientation(0);
            this.ffp.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            addView(this.ffp);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                MenuItemView menuItemView = new MenuItemView(tbPageContext);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                menuItemView.setLayoutParams(layoutParams);
                menuItemView.setMenuData(list.get(i));
                menuItemView.setOnMenuItemClickListener(this.ffo);
                this.ffp.addView(menuItemView);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType && this.ffp != null) {
            this.mSkinType = i;
            int childCount = this.ffp.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.ffp.getChildAt(i2);
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
            al.l(this.cKN, d.C0277d.cp_bg_line_b);
        }
    }

    /* loaded from: classes4.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener {
        private static final int ffq = d.f.icon_card_morelist_n;
        private a ffo;
        private int ffr;
        private ImageView ffs;
        private TextView fft;
        private BottomMenu ffu;
        private boolean ffv;
        private b ffw;
        private TbPageContext<?> mPageContext;

        public MenuItemView(TbPageContext<?> tbPageContext) {
            super(tbPageContext.getPageActivity());
            this.ffr = ffq;
            setGravity(17);
            setOnClickListener(this);
            LayoutInflater.from(getContext()).inflate(d.h.bottom_menu_item, this);
            this.mPageContext = tbPageContext;
            this.ffs = (ImageView) findViewById(d.g.item_image);
            this.fft = (TextView) findViewById(d.g.item_text);
        }

        public void setOnMenuItemClickListener(a aVar) {
            this.ffo = aVar;
        }

        public void setMenuData(BottomMenu bottomMenu) {
            if (bottomMenu != null) {
                this.ffu = bottomMenu;
                this.ffv = v.S(bottomMenu.submenu) > 0;
                this.fft.setText(bottomMenu.name);
                onChangeSkinType(this.mPageContext, 0);
            }
        }

        public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
            setMenuIcon(this.ffr);
            al.j(this.fft, d.C0277d.cp_cont_b);
            al.k(this, d.f.addresslist_item_bg);
        }

        private void setMenuIcon(int i) {
            this.ffr = i;
            if (this.ffv) {
                this.ffs.setVisibility(0);
                this.ffs.setImageResource(i);
                al.c(this.ffs, i);
                return;
            }
            this.ffs.setVisibility(8);
        }

        public e getPageContext() {
            return this.mPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.ffv) {
                getSubMenuGenerator().a(this, this.ffu.submenu);
            }
            if (this.ffo != null) {
                this.ffo.a(this, this.ffu);
            }
        }

        private b getSubMenuGenerator() {
            if (this.ffw == null) {
                this.ffw = new b();
                this.ffw.setOnMenuItemClickListener(this.ffo);
            }
            return this.ffw;
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements View.OnClickListener {
        private PopupWindow aMN;
        private a ffo;
        private RelativeLayout ffx;
        private final int[] ffy = new int[2];

        public void setOnMenuItemClickListener(a aVar) {
            this.ffo = aVar;
        }

        public void a(MenuItemView menuItemView, List<SubBottomMenu> list) {
            if (menuItemView != null && !v.T(list)) {
                Activity pageActivity = menuItemView.getPageContext().getPageActivity();
                this.ffx = new RelativeLayout(pageActivity);
                this.ffx.setBackgroundColor(al.getColor(d.C0277d.cp_mask_f));
                this.ffx.setOnClickListener(this);
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
                this.ffx.addView(linearLayout);
                menuItemView.getLocationInWindow(this.ffy);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.width = menuItemView.getWidth();
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.ffy[0];
                this.aMN = new PopupWindow(this.ffx, -1, this.ffy[1]);
                this.aMN.setOutsideTouchable(true);
                this.aMN.setFocusable(true);
                this.aMN.setClippingEnabled(false);
                this.aMN.setBackgroundDrawable(new ColorDrawable());
                this.aMN.setSoftInputMode(16);
                g.showPopupWindowAtLocation(this.aMN, menuItemView, 51, 0, 0);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view instanceof SubMenuItemView) {
                g.a(this.aMN);
                SubMenuItemView subMenuItemView = (SubMenuItemView) view;
                if (this.ffo != null) {
                    this.ffo.a(subMenuItemView, subMenuItemView.getSubMenuData());
                }
            } else if (view == this.ffx) {
                g.a(this.aMN);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class SubMenuItemView extends LinearLayout {
        private View bjO;
        private SubBottomMenu ffz;
        private TextView mTitleView;

        public SubMenuItemView(Context context) {
            super(context);
            LayoutInflater.from(context).inflate(d.h.bottom_submenu_item, this);
            setOrientation(1);
            this.mTitleView = (TextView) findViewById(d.g.item_text);
            this.bjO = findViewById(d.g.divider_line);
        }

        public void setSubMenuData(SubBottomMenu subBottomMenu, int i, boolean z) {
            if (subBottomMenu != null) {
                this.ffz = subBottomMenu;
                this.mTitleView.setText(subBottomMenu.name);
                al.j(this.mTitleView, d.C0277d.cp_cont_f);
                al.k(this, i == 0 ? d.f.bottom_menu_item_bg_corner_selector : d.f.bottom_menu_item_bg_selector);
                if (z) {
                    this.bjO.setVisibility(8);
                    return;
                }
                this.bjO.setVisibility(0);
                al.l(this.bjO, d.C0277d.cp_bg_line_b);
            }
        }

        public SubBottomMenu getSubMenuData() {
            return this.ffz;
        }
    }
}
