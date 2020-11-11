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
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes22.dex */
public class BottomMenuView extends LinearLayout {
    private View fQl;
    private LinearLayout iPA;
    private a iPz;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    /* loaded from: classes22.dex */
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
        this.iPz = aVar;
    }

    public void a(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        if (!y.isEmpty(list)) {
            this.mPageContext = tbPageContext;
            removeAllViews();
            this.fQl = new View(getContext());
            this.fQl.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds16)));
            this.fQl.setBackgroundResource(R.drawable.bottom_view_shadow);
            addView(this.fQl);
            this.iPA = new LinearLayout(getContext());
            this.iPA.setOrientation(0);
            this.iPA.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            addView(this.iPA);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                MenuItemView menuItemView = new MenuItemView(tbPageContext);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                menuItemView.setLayoutParams(layoutParams);
                menuItemView.setMenuData(list.get(i));
                menuItemView.setOnMenuItemClickListener(this.iPz);
                this.iPA.addView(menuItemView);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType && this.iPA != null) {
            this.mSkinType = i;
            int childCount = this.iPA.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.iPA.getChildAt(i2);
                if (childAt != null) {
                    if (childAt instanceof MenuItemView) {
                        ((MenuItemView) childAt).onChangeSkinType(tbPageContext, i);
                    } else {
                        ap.setBackgroundColor(childAt, R.color.cp_bg_line_c);
                    }
                } else {
                    return;
                }
            }
            ap.setBackgroundColor(this.fQl, R.color.cp_bg_line_c);
        }
    }

    /* loaded from: classes22.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener {
        private static final int iPB = R.drawable.icon_card_morelist_n;
        private int iPC;
        private ImageView iPD;
        private TextView iPE;
        private BottomMenu iPF;
        private boolean iPG;
        private b iPH;
        private a iPz;
        private TbPageContext<?> mPageContext;

        public MenuItemView(TbPageContext<?> tbPageContext) {
            super(tbPageContext.getPageActivity());
            this.iPC = iPB;
            setGravity(17);
            setOnClickListener(this);
            LayoutInflater.from(getContext()).inflate(R.layout.bottom_menu_item, this);
            this.mPageContext = tbPageContext;
            this.iPD = (ImageView) findViewById(R.id.item_image);
            this.iPE = (TextView) findViewById(R.id.item_text);
        }

        public void setOnMenuItemClickListener(a aVar) {
            this.iPz = aVar;
        }

        public void setMenuData(BottomMenu bottomMenu) {
            if (bottomMenu != null) {
                this.iPF = bottomMenu;
                this.iPG = y.getCount(bottomMenu.submenu) > 0;
                this.iPE.setText(bottomMenu.name);
                onChangeSkinType(this.mPageContext, 0);
            }
        }

        public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
            setMenuIcon(this.iPC);
            ap.setViewTextColor(this.iPE, R.color.cp_cont_b);
            ap.setBackgroundResource(this, R.drawable.addresslist_item_bg);
        }

        private void setMenuIcon(int i) {
            this.iPC = i;
            if (this.iPG) {
                this.iPD.setVisibility(0);
                this.iPD.setImageResource(i);
                ap.setImageResource(this.iPD, i);
                return;
            }
            this.iPD.setVisibility(8);
        }

        public e getPageContext() {
            return this.mPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.iPG) {
                getSubMenuGenerator().a(this, this.iPF.submenu);
            }
            if (this.iPz != null) {
                this.iPz.a(this, this.iPF);
            }
        }

        private b getSubMenuGenerator() {
            if (this.iPH == null) {
                this.iPH = new b();
                this.iPH.setOnMenuItemClickListener(this.iPz);
            }
            return this.iPH;
        }
    }

    /* loaded from: classes22.dex */
    public static class b implements View.OnClickListener {
        private RelativeLayout iPI;
        private a iPz;
        private final int[] mLocation = new int[2];
        private PopupWindow mPopupWindow;

        public void setOnMenuItemClickListener(a aVar) {
            this.iPz = aVar;
        }

        public void a(MenuItemView menuItemView, List<SubBottomMenu> list) {
            if (menuItemView != null && !y.isEmpty(list)) {
                Activity pageActivity = menuItemView.getPageContext().getPageActivity();
                this.iPI = new RelativeLayout(pageActivity);
                this.iPI.setBackgroundColor(ap.getColor(R.color.cp_mask_b_alpha66));
                this.iPI.setOnClickListener(this);
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
                this.iPI.addView(linearLayout);
                menuItemView.getLocationInWindow(this.mLocation);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.width = menuItemView.getWidth();
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mLocation[0];
                this.mPopupWindow = new PopupWindow(this.iPI, -1, this.mLocation[1]);
                this.mPopupWindow.setOutsideTouchable(true);
                this.mPopupWindow.setFocusable(true);
                this.mPopupWindow.setClippingEnabled(false);
                this.mPopupWindow.setBackgroundDrawable(new ColorDrawable());
                this.mPopupWindow.setSoftInputMode(16);
                g.showPopupWindowAtLocation(this.mPopupWindow, menuItemView, 51, 0, 0);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view instanceof SubMenuItemView) {
                g.dismissPopupWindow(this.mPopupWindow);
                SubMenuItemView subMenuItemView = (SubMenuItemView) view;
                if (this.iPz != null) {
                    this.iPz.a(subMenuItemView, subMenuItemView.getSubMenuData());
                }
            } else if (view == this.iPI) {
                g.dismissPopupWindow(this.mPopupWindow);
            }
        }
    }

    /* loaded from: classes22.dex */
    public static class SubMenuItemView extends LinearLayout {
        private View efQ;
        private SubBottomMenu iPJ;
        private TextView mTitleView;

        public SubMenuItemView(Context context) {
            super(context);
            LayoutInflater.from(context).inflate(R.layout.bottom_submenu_item, this);
            setOrientation(1);
            this.mTitleView = (TextView) findViewById(R.id.item_text);
            this.efQ = findViewById(R.id.divider_line);
        }

        public void setSubMenuData(SubBottomMenu subBottomMenu, int i, boolean z) {
            if (subBottomMenu != null) {
                this.iPJ = subBottomMenu;
                this.mTitleView.setText(subBottomMenu.name);
                ap.setViewTextColor(this.mTitleView, R.color.cp_cont_f);
                ap.setBackgroundResource(this, i == 0 ? R.drawable.bottom_menu_item_bg_corner_selector : R.drawable.bottom_menu_item_bg_selector);
                if (z) {
                    this.efQ.setVisibility(8);
                    return;
                }
                this.efQ.setVisibility(0);
                ap.setBackgroundColor(this.efQ, R.color.cp_bg_line_c);
            }
        }

        public SubBottomMenu getSubMenuData() {
            return this.iPJ;
        }
    }
}
