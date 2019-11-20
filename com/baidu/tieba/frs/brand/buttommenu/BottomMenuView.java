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
    private View ddZ;
    private a fBA;
    private LinearLayout fBB;
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
        this.fBA = aVar;
    }

    public void a(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        if (!v.isEmpty(list)) {
            this.mPageContext = tbPageContext;
            removeAllViews();
            this.ddZ = new View(getContext());
            this.ddZ.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds16)));
            this.ddZ.setBackgroundResource(R.drawable.bottom_view_shadow);
            addView(this.ddZ);
            this.fBB = new LinearLayout(getContext());
            this.fBB.setOrientation(0);
            this.fBB.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            addView(this.fBB);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                MenuItemView menuItemView = new MenuItemView(tbPageContext);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                menuItemView.setLayoutParams(layoutParams);
                menuItemView.setMenuData(list.get(i));
                menuItemView.setOnMenuItemClickListener(this.fBA);
                this.fBB.addView(menuItemView);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType && this.fBB != null) {
            this.mSkinType = i;
            int childCount = this.fBB.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.fBB.getChildAt(i2);
                if (childAt != null) {
                    if (childAt instanceof MenuItemView) {
                        ((MenuItemView) childAt).onChangeSkinType(tbPageContext, i);
                    } else {
                        am.setBackgroundColor(childAt, R.color.cp_bg_line_c);
                    }
                } else {
                    return;
                }
            }
            am.setBackgroundColor(this.ddZ, R.color.cp_bg_line_c);
        }
    }

    /* loaded from: classes4.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener {
        private a fBA;
        private int fBC;
        private ImageView fBD;
        private TextView fBE;
        private BottomMenu fBF;
        private boolean fBG;
        private b fBH;
        private TbPageContext<?> mPageContext;

        public MenuItemView(TbPageContext<?> tbPageContext) {
            super(tbPageContext.getPageActivity());
            this.fBC = R.drawable.icon_card_morelist_n;
            setGravity(17);
            setOnClickListener(this);
            LayoutInflater.from(getContext()).inflate(R.layout.bottom_menu_item, this);
            this.mPageContext = tbPageContext;
            this.fBD = (ImageView) findViewById(R.id.item_image);
            this.fBE = (TextView) findViewById(R.id.item_text);
        }

        public void setOnMenuItemClickListener(a aVar) {
            this.fBA = aVar;
        }

        public void setMenuData(BottomMenu bottomMenu) {
            if (bottomMenu != null) {
                this.fBF = bottomMenu;
                this.fBG = v.getCount(bottomMenu.submenu) > 0;
                this.fBE.setText(bottomMenu.name);
                onChangeSkinType(this.mPageContext, 0);
            }
        }

        public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
            setMenuIcon(this.fBC);
            am.setViewTextColor(this.fBE, (int) R.color.cp_cont_b);
            am.setBackgroundResource(this, R.drawable.addresslist_item_bg);
        }

        private void setMenuIcon(int i) {
            this.fBC = i;
            if (this.fBG) {
                this.fBD.setVisibility(0);
                this.fBD.setImageResource(i);
                am.setImageResource(this.fBD, i);
                return;
            }
            this.fBD.setVisibility(8);
        }

        public e getPageContext() {
            return this.mPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.fBG) {
                getSubMenuGenerator().a(this, this.fBF.submenu);
            }
            if (this.fBA != null) {
                this.fBA.a(this, this.fBF);
            }
        }

        private b getSubMenuGenerator() {
            if (this.fBH == null) {
                this.fBH = new b();
                this.fBH.setOnMenuItemClickListener(this.fBA);
            }
            return this.fBH;
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements View.OnClickListener {
        private a fBA;
        private RelativeLayout fBI;
        private final int[] fBJ = new int[2];
        private PopupWindow mPopupWindow;

        public void setOnMenuItemClickListener(a aVar) {
            this.fBA = aVar;
        }

        public void a(MenuItemView menuItemView, List<SubBottomMenu> list) {
            if (menuItemView != null && !v.isEmpty(list)) {
                Activity pageActivity = menuItemView.getPageContext().getPageActivity();
                this.fBI = new RelativeLayout(pageActivity);
                this.fBI.setBackgroundColor(am.getColor(R.color.cp_mask_b_alpha66));
                this.fBI.setOnClickListener(this);
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
                this.fBI.addView(linearLayout);
                menuItemView.getLocationInWindow(this.fBJ);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.width = menuItemView.getWidth();
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.fBJ[0];
                this.mPopupWindow = new PopupWindow(this.fBI, -1, this.fBJ[1]);
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
                if (this.fBA != null) {
                    this.fBA.a(subMenuItemView, subMenuItemView.getSubMenuData());
                }
            } else if (view == this.fBI) {
                g.dismissPopupWindow(this.mPopupWindow);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class SubMenuItemView extends LinearLayout {
        private View bIW;
        private SubBottomMenu fBK;
        private TextView mTitleView;

        public SubMenuItemView(Context context) {
            super(context);
            LayoutInflater.from(context).inflate(R.layout.bottom_submenu_item, this);
            setOrientation(1);
            this.mTitleView = (TextView) findViewById(R.id.item_text);
            this.bIW = findViewById(R.id.divider_line);
        }

        public void setSubMenuData(SubBottomMenu subBottomMenu, int i, boolean z) {
            if (subBottomMenu != null) {
                this.fBK = subBottomMenu;
                this.mTitleView.setText(subBottomMenu.name);
                am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_f);
                am.setBackgroundResource(this, i == 0 ? R.drawable.bottom_menu_item_bg_corner_selector : R.drawable.bottom_menu_item_bg_selector);
                if (z) {
                    this.bIW.setVisibility(8);
                    return;
                }
                this.bIW.setVisibility(0);
                am.setBackgroundColor(this.bIW, R.color.cp_bg_line_c);
            }
        }

        public SubBottomMenu getSubMenuData() {
            return this.fBK;
        }
    }
}
