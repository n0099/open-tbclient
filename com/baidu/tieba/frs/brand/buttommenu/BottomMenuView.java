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
    private View cUD;
    private a fBn;
    private LinearLayout fBo;
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
        this.fBn = aVar;
    }

    public void a(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        if (!v.aa(list)) {
            this.mPageContext = tbPageContext;
            removeAllViews();
            this.cUD = new View(getContext());
            this.cUD.setLayoutParams(new LinearLayout.LayoutParams(-1, l.g(getContext(), R.dimen.tbds16)));
            this.cUD.setBackgroundResource(R.drawable.bottom_view_shadow);
            addView(this.cUD);
            this.fBo = new LinearLayout(getContext());
            this.fBo.setOrientation(0);
            this.fBo.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            addView(this.fBo);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                MenuItemView menuItemView = new MenuItemView(tbPageContext);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                menuItemView.setLayoutParams(layoutParams);
                menuItemView.setMenuData(list.get(i));
                menuItemView.setOnMenuItemClickListener(this.fBn);
                this.fBo.addView(menuItemView);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType && this.fBo != null) {
            this.mSkinType = i;
            int childCount = this.fBo.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.fBo.getChildAt(i2);
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
            am.l(this.cUD, R.color.cp_bg_line_b);
        }
    }

    /* loaded from: classes4.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener {
        private a fBn;
        private int fBp;
        private ImageView fBq;
        private TextView fBr;
        private BottomMenu fBs;
        private boolean fBt;
        private b fBu;
        private TbPageContext<?> mPageContext;

        public MenuItemView(TbPageContext<?> tbPageContext) {
            super(tbPageContext.getPageActivity());
            this.fBp = R.drawable.icon_card_morelist_n;
            setGravity(17);
            setOnClickListener(this);
            LayoutInflater.from(getContext()).inflate(R.layout.bottom_menu_item, this);
            this.mPageContext = tbPageContext;
            this.fBq = (ImageView) findViewById(R.id.item_image);
            this.fBr = (TextView) findViewById(R.id.item_text);
        }

        public void setOnMenuItemClickListener(a aVar) {
            this.fBn = aVar;
        }

        public void setMenuData(BottomMenu bottomMenu) {
            if (bottomMenu != null) {
                this.fBs = bottomMenu;
                this.fBt = v.Z(bottomMenu.submenu) > 0;
                this.fBr.setText(bottomMenu.name);
                onChangeSkinType(this.mPageContext, 0);
            }
        }

        public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
            setMenuIcon(this.fBp);
            am.j(this.fBr, R.color.cp_cont_b);
            am.k(this, R.drawable.addresslist_item_bg);
        }

        private void setMenuIcon(int i) {
            this.fBp = i;
            if (this.fBt) {
                this.fBq.setVisibility(0);
                this.fBq.setImageResource(i);
                am.c(this.fBq, i);
                return;
            }
            this.fBq.setVisibility(8);
        }

        public e getPageContext() {
            return this.mPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.fBt) {
                getSubMenuGenerator().a(this, this.fBs.submenu);
            }
            if (this.fBn != null) {
                this.fBn.a(this, this.fBs);
            }
        }

        private b getSubMenuGenerator() {
            if (this.fBu == null) {
                this.fBu = new b();
                this.fBu.setOnMenuItemClickListener(this.fBn);
            }
            return this.fBu;
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements View.OnClickListener {
        private PopupWindow aPu;
        private a fBn;
        private RelativeLayout fBv;
        private final int[] fBw = new int[2];

        public void setOnMenuItemClickListener(a aVar) {
            this.fBn = aVar;
        }

        public void a(MenuItemView menuItemView, List<SubBottomMenu> list) {
            if (menuItemView != null && !v.aa(list)) {
                Activity pageActivity = menuItemView.getPageContext().getPageActivity();
                this.fBv = new RelativeLayout(pageActivity);
                this.fBv.setBackgroundColor(am.getColor(R.color.cp_mask_f));
                this.fBv.setOnClickListener(this);
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
                this.fBv.addView(linearLayout);
                menuItemView.getLocationInWindow(this.fBw);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.width = menuItemView.getWidth();
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.fBw[0];
                this.aPu = new PopupWindow(this.fBv, -1, this.fBw[1]);
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
                if (this.fBn != null) {
                    this.fBn.a(subMenuItemView, subMenuItemView.getSubMenuData());
                }
            } else if (view == this.fBv) {
                g.a(this.aPu);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class SubMenuItemView extends LinearLayout {
        private View bqE;
        private SubBottomMenu fBx;
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
                this.fBx = subBottomMenu;
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
            return this.fBx;
        }
    }
}
