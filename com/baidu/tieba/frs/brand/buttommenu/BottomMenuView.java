package com.baidu.tieba.frs.brand.buttommenu;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.base.f;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes2.dex */
public class BottomMenuView extends LinearLayout {
    private View gde;
    private a jiL;
    private LinearLayout jiM;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    /* loaded from: classes2.dex */
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
        this.jiL = aVar;
    }

    public void a(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        if (!x.isEmpty(list)) {
            this.mPageContext = tbPageContext;
            removeAllViews();
            this.gde = new View(getContext());
            this.gde.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds16)));
            this.gde.setBackgroundResource(R.drawable.bottom_view_shadow);
            addView(this.gde);
            this.jiM = new LinearLayout(getContext());
            this.jiM.setOrientation(0);
            this.jiM.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            addView(this.jiM);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                MenuItemView menuItemView = new MenuItemView(tbPageContext);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                menuItemView.setLayoutParams(layoutParams);
                menuItemView.setMenuData(list.get(i));
                menuItemView.setOnMenuItemClickListener(this.jiL);
                this.jiM.addView(menuItemView);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType && this.jiM != null) {
            this.mSkinType = i;
            int childCount = this.jiM.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.jiM.getChildAt(i2);
                if (childAt != null) {
                    if (childAt instanceof MenuItemView) {
                        ((MenuItemView) childAt).onChangeSkinType(tbPageContext, i);
                    } else {
                        ao.setBackgroundColor(childAt, R.color.CAM_X0204);
                    }
                } else {
                    return;
                }
            }
            ao.setBackgroundColor(this.gde, R.color.CAM_X0204);
        }
    }

    /* loaded from: classes2.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener {
        private static final int jiN = R.drawable.icon_card_morelist_n;
        private a jiL;
        private int jiO;
        private ImageView jiP;
        private TextView jiQ;
        private BottomMenu jiR;
        private boolean jiS;
        private b jiT;
        private TbPageContext<?> mPageContext;

        public MenuItemView(TbPageContext<?> tbPageContext) {
            super(tbPageContext.getPageActivity());
            this.jiO = jiN;
            setGravity(17);
            setOnClickListener(this);
            LayoutInflater.from(getContext()).inflate(R.layout.bottom_menu_item, this);
            this.mPageContext = tbPageContext;
            this.jiP = (ImageView) findViewById(R.id.item_image);
            this.jiQ = (TextView) findViewById(R.id.item_text);
        }

        public void setOnMenuItemClickListener(a aVar) {
            this.jiL = aVar;
        }

        public void setMenuData(BottomMenu bottomMenu) {
            if (bottomMenu != null) {
                this.jiR = bottomMenu;
                this.jiS = x.getCount(bottomMenu.submenu) > 0;
                this.jiQ.setText(bottomMenu.name);
                onChangeSkinType(this.mPageContext, 0);
            }
        }

        public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
            setMenuIcon(this.jiO);
            ao.setViewTextColor(this.jiQ, R.color.CAM_X0105);
            ao.setBackgroundResource(this, R.drawable.addresslist_item_bg);
        }

        private void setMenuIcon(int i) {
            this.jiO = i;
            if (this.jiS) {
                this.jiP.setVisibility(0);
                this.jiP.setImageResource(i);
                ao.setImageResource(this.jiP, i);
                return;
            }
            this.jiP.setVisibility(8);
        }

        public f getPageContext() {
            return this.mPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.jiS) {
                getSubMenuGenerator().a(this, this.jiR.submenu);
            }
            if (this.jiL != null) {
                this.jiL.a(this, this.jiR);
            }
        }

        private b getSubMenuGenerator() {
            if (this.jiT == null) {
                this.jiT = new b();
                this.jiT.setOnMenuItemClickListener(this.jiL);
            }
            return this.jiT;
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements View.OnClickListener {
        private a jiL;
        private RelativeLayout jiU;
        private final int[] jiV = new int[2];
        private PopupWindow mPopupWindow;

        public void setOnMenuItemClickListener(a aVar) {
            this.jiL = aVar;
        }

        public void a(MenuItemView menuItemView, List<SubBottomMenu> list) {
            if (menuItemView != null && !x.isEmpty(list)) {
                Activity pageActivity = menuItemView.getPageContext().getPageActivity();
                this.jiU = new RelativeLayout(pageActivity);
                this.jiU.setBackgroundColor(ao.getColor(R.color.CAM_X0608));
                this.jiU.setOnClickListener(this);
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
                this.jiU.addView(linearLayout);
                menuItemView.getLocationInWindow(this.jiV);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.width = menuItemView.getWidth();
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.jiV[0];
                this.mPopupWindow = new PopupWindow(this.jiU, -1, this.jiV[1]);
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
                if (this.jiL != null) {
                    this.jiL.a(subMenuItemView, subMenuItemView.getSubMenuData());
                }
            } else if (view == this.jiU) {
                g.dismissPopupWindow(this.mPopupWindow);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class SubMenuItemView extends LinearLayout {
        private View epB;
        private SubBottomMenu jiW;
        private TextView mTitleView;

        public SubMenuItemView(Context context) {
            super(context);
            LayoutInflater.from(context).inflate(R.layout.bottom_submenu_item, this);
            setOrientation(1);
            this.mTitleView = (TextView) findViewById(R.id.item_text);
            this.epB = findViewById(R.id.divider_line);
        }

        public void setSubMenuData(SubBottomMenu subBottomMenu, int i, boolean z) {
            if (subBottomMenu != null) {
                this.jiW = subBottomMenu;
                this.mTitleView.setText(subBottomMenu.name);
                ao.setViewTextColor(this.mTitleView, R.color.CAM_X0106);
                ao.setBackgroundResource(this, i == 0 ? R.drawable.bottom_menu_item_bg_corner_selector : R.drawable.bottom_menu_item_bg_selector);
                if (z) {
                    this.epB.setVisibility(8);
                    return;
                }
                this.epB.setVisibility(0);
                ao.setBackgroundColor(this.epB, R.color.CAM_X0204);
            }
        }

        public SubBottomMenu getSubMenuData() {
            return this.jiW;
        }
    }
}
