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
    private View cVw;
    private a fDa;
    private LinearLayout fDb;
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
        this.fDa = aVar;
    }

    public void a(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        if (!v.aa(list)) {
            this.mPageContext = tbPageContext;
            removeAllViews();
            this.cVw = new View(getContext());
            this.cVw.setLayoutParams(new LinearLayout.LayoutParams(-1, l.g(getContext(), R.dimen.tbds16)));
            this.cVw.setBackgroundResource(R.drawable.bottom_view_shadow);
            addView(this.cVw);
            this.fDb = new LinearLayout(getContext());
            this.fDb.setOrientation(0);
            this.fDb.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            addView(this.fDb);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                MenuItemView menuItemView = new MenuItemView(tbPageContext);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                menuItemView.setLayoutParams(layoutParams);
                menuItemView.setMenuData(list.get(i));
                menuItemView.setOnMenuItemClickListener(this.fDa);
                this.fDb.addView(menuItemView);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType && this.fDb != null) {
            this.mSkinType = i;
            int childCount = this.fDb.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.fDb.getChildAt(i2);
                if (childAt != null) {
                    if (childAt instanceof MenuItemView) {
                        ((MenuItemView) childAt).onChangeSkinType(tbPageContext, i);
                    } else {
                        am.l(childAt, R.color.cp_bg_line_c);
                    }
                } else {
                    return;
                }
            }
            am.l(this.cVw, R.color.cp_bg_line_c);
        }
    }

    /* loaded from: classes4.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener {
        private a fDa;
        private int fDc;
        private ImageView fDd;
        private TextView fDe;
        private BottomMenu fDf;
        private boolean fDg;
        private b fDh;
        private TbPageContext<?> mPageContext;

        public MenuItemView(TbPageContext<?> tbPageContext) {
            super(tbPageContext.getPageActivity());
            this.fDc = R.drawable.icon_card_morelist_n;
            setGravity(17);
            setOnClickListener(this);
            LayoutInflater.from(getContext()).inflate(R.layout.bottom_menu_item, this);
            this.mPageContext = tbPageContext;
            this.fDd = (ImageView) findViewById(R.id.item_image);
            this.fDe = (TextView) findViewById(R.id.item_text);
        }

        public void setOnMenuItemClickListener(a aVar) {
            this.fDa = aVar;
        }

        public void setMenuData(BottomMenu bottomMenu) {
            if (bottomMenu != null) {
                this.fDf = bottomMenu;
                this.fDg = v.Z(bottomMenu.submenu) > 0;
                this.fDe.setText(bottomMenu.name);
                onChangeSkinType(this.mPageContext, 0);
            }
        }

        public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
            setMenuIcon(this.fDc);
            am.j(this.fDe, R.color.cp_cont_b);
            am.k(this, R.drawable.addresslist_item_bg);
        }

        private void setMenuIcon(int i) {
            this.fDc = i;
            if (this.fDg) {
                this.fDd.setVisibility(0);
                this.fDd.setImageResource(i);
                am.c(this.fDd, i);
                return;
            }
            this.fDd.setVisibility(8);
        }

        public e getPageContext() {
            return this.mPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.fDg) {
                getSubMenuGenerator().a(this, this.fDf.submenu);
            }
            if (this.fDa != null) {
                this.fDa.a(this, this.fDf);
            }
        }

        private b getSubMenuGenerator() {
            if (this.fDh == null) {
                this.fDh = new b();
                this.fDh.setOnMenuItemClickListener(this.fDa);
            }
            return this.fDh;
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements View.OnClickListener {
        private PopupWindow aPS;
        private a fDa;
        private RelativeLayout fDi;
        private final int[] fDj = new int[2];

        public void setOnMenuItemClickListener(a aVar) {
            this.fDa = aVar;
        }

        public void a(MenuItemView menuItemView, List<SubBottomMenu> list) {
            if (menuItemView != null && !v.aa(list)) {
                Activity pageActivity = menuItemView.getPageContext().getPageActivity();
                this.fDi = new RelativeLayout(pageActivity);
                this.fDi.setBackgroundColor(am.getColor(R.color.cp_mask_b_alpha66));
                this.fDi.setOnClickListener(this);
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
                this.fDi.addView(linearLayout);
                menuItemView.getLocationInWindow(this.fDj);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.width = menuItemView.getWidth();
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.fDj[0];
                this.aPS = new PopupWindow(this.fDi, -1, this.fDj[1]);
                this.aPS.setOutsideTouchable(true);
                this.aPS.setFocusable(true);
                this.aPS.setClippingEnabled(false);
                this.aPS.setBackgroundDrawable(new ColorDrawable());
                this.aPS.setSoftInputMode(16);
                g.showPopupWindowAtLocation(this.aPS, menuItemView, 51, 0, 0);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view instanceof SubMenuItemView) {
                g.a(this.aPS);
                SubMenuItemView subMenuItemView = (SubMenuItemView) view;
                if (this.fDa != null) {
                    this.fDa.a(subMenuItemView, subMenuItemView.getSubMenuData());
                }
            } else if (view == this.fDi) {
                g.a(this.aPS);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class SubMenuItemView extends LinearLayout {
        private View brc;
        private SubBottomMenu fDk;
        private TextView mTitleView;

        public SubMenuItemView(Context context) {
            super(context);
            LayoutInflater.from(context).inflate(R.layout.bottom_submenu_item, this);
            setOrientation(1);
            this.mTitleView = (TextView) findViewById(R.id.item_text);
            this.brc = findViewById(R.id.divider_line);
        }

        public void setSubMenuData(SubBottomMenu subBottomMenu, int i, boolean z) {
            if (subBottomMenu != null) {
                this.fDk = subBottomMenu;
                this.mTitleView.setText(subBottomMenu.name);
                am.j(this.mTitleView, R.color.cp_cont_f);
                am.k(this, i == 0 ? R.drawable.bottom_menu_item_bg_corner_selector : R.drawable.bottom_menu_item_bg_selector);
                if (z) {
                    this.brc.setVisibility(8);
                    return;
                }
                this.brc.setVisibility(0);
                am.l(this.brc, R.color.cp_bg_line_c);
            }
        }

        public SubBottomMenu getSubMenuData() {
            return this.fDk;
        }
    }
}
