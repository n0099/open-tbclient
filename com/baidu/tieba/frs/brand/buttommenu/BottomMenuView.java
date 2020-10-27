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
    private View fKv;
    private a iJC;
    private LinearLayout iJD;
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
        this.iJC = aVar;
    }

    public void a(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        if (!y.isEmpty(list)) {
            this.mPageContext = tbPageContext;
            removeAllViews();
            this.fKv = new View(getContext());
            this.fKv.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds16)));
            this.fKv.setBackgroundResource(R.drawable.bottom_view_shadow);
            addView(this.fKv);
            this.iJD = new LinearLayout(getContext());
            this.iJD.setOrientation(0);
            this.iJD.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            addView(this.iJD);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                MenuItemView menuItemView = new MenuItemView(tbPageContext);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                menuItemView.setLayoutParams(layoutParams);
                menuItemView.setMenuData(list.get(i));
                menuItemView.setOnMenuItemClickListener(this.iJC);
                this.iJD.addView(menuItemView);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType && this.iJD != null) {
            this.mSkinType = i;
            int childCount = this.iJD.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.iJD.getChildAt(i2);
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
            ap.setBackgroundColor(this.fKv, R.color.cp_bg_line_c);
        }
    }

    /* loaded from: classes22.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener {
        private static final int iJE = R.drawable.icon_card_morelist_n;
        private a iJC;
        private int iJF;
        private ImageView iJG;
        private TextView iJH;
        private BottomMenu iJI;
        private boolean iJJ;
        private b iJK;
        private TbPageContext<?> mPageContext;

        public MenuItemView(TbPageContext<?> tbPageContext) {
            super(tbPageContext.getPageActivity());
            this.iJF = iJE;
            setGravity(17);
            setOnClickListener(this);
            LayoutInflater.from(getContext()).inflate(R.layout.bottom_menu_item, this);
            this.mPageContext = tbPageContext;
            this.iJG = (ImageView) findViewById(R.id.item_image);
            this.iJH = (TextView) findViewById(R.id.item_text);
        }

        public void setOnMenuItemClickListener(a aVar) {
            this.iJC = aVar;
        }

        public void setMenuData(BottomMenu bottomMenu) {
            if (bottomMenu != null) {
                this.iJI = bottomMenu;
                this.iJJ = y.getCount(bottomMenu.submenu) > 0;
                this.iJH.setText(bottomMenu.name);
                onChangeSkinType(this.mPageContext, 0);
            }
        }

        public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
            setMenuIcon(this.iJF);
            ap.setViewTextColor(this.iJH, R.color.cp_cont_b);
            ap.setBackgroundResource(this, R.drawable.addresslist_item_bg);
        }

        private void setMenuIcon(int i) {
            this.iJF = i;
            if (this.iJJ) {
                this.iJG.setVisibility(0);
                this.iJG.setImageResource(i);
                ap.setImageResource(this.iJG, i);
                return;
            }
            this.iJG.setVisibility(8);
        }

        public e getPageContext() {
            return this.mPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.iJJ) {
                getSubMenuGenerator().a(this, this.iJI.submenu);
            }
            if (this.iJC != null) {
                this.iJC.a(this, this.iJI);
            }
        }

        private b getSubMenuGenerator() {
            if (this.iJK == null) {
                this.iJK = new b();
                this.iJK.setOnMenuItemClickListener(this.iJC);
            }
            return this.iJK;
        }
    }

    /* loaded from: classes22.dex */
    public static class b implements View.OnClickListener {
        private a iJC;
        private RelativeLayout iJL;
        private final int[] mLocation = new int[2];
        private PopupWindow mPopupWindow;

        public void setOnMenuItemClickListener(a aVar) {
            this.iJC = aVar;
        }

        public void a(MenuItemView menuItemView, List<SubBottomMenu> list) {
            if (menuItemView != null && !y.isEmpty(list)) {
                Activity pageActivity = menuItemView.getPageContext().getPageActivity();
                this.iJL = new RelativeLayout(pageActivity);
                this.iJL.setBackgroundColor(ap.getColor(R.color.cp_mask_b_alpha66));
                this.iJL.setOnClickListener(this);
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
                this.iJL.addView(linearLayout);
                menuItemView.getLocationInWindow(this.mLocation);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.width = menuItemView.getWidth();
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mLocation[0];
                this.mPopupWindow = new PopupWindow(this.iJL, -1, this.mLocation[1]);
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
                if (this.iJC != null) {
                    this.iJC.a(subMenuItemView, subMenuItemView.getSubMenuData());
                }
            } else if (view == this.iJL) {
                g.dismissPopupWindow(this.mPopupWindow);
            }
        }
    }

    /* loaded from: classes22.dex */
    public static class SubMenuItemView extends LinearLayout {
        private View dZZ;
        private SubBottomMenu iJM;
        private TextView mTitleView;

        public SubMenuItemView(Context context) {
            super(context);
            LayoutInflater.from(context).inflate(R.layout.bottom_submenu_item, this);
            setOrientation(1);
            this.mTitleView = (TextView) findViewById(R.id.item_text);
            this.dZZ = findViewById(R.id.divider_line);
        }

        public void setSubMenuData(SubBottomMenu subBottomMenu, int i, boolean z) {
            if (subBottomMenu != null) {
                this.iJM = subBottomMenu;
                this.mTitleView.setText(subBottomMenu.name);
                ap.setViewTextColor(this.mTitleView, R.color.cp_cont_f);
                ap.setBackgroundResource(this, i == 0 ? R.drawable.bottom_menu_item_bg_corner_selector : R.drawable.bottom_menu_item_bg_selector);
                if (z) {
                    this.dZZ.setVisibility(8);
                    return;
                }
                this.dZZ.setVisibility(0);
                ap.setBackgroundColor(this.dZZ, R.color.cp_bg_line_c);
            }
        }

        public SubBottomMenu getSubMenuData() {
            return this.iJM;
        }
    }
}
