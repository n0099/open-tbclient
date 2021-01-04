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
    private View ghM;
    private a jns;
    private LinearLayout jnt;
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
        this.jns = aVar;
    }

    public void a(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        if (!x.isEmpty(list)) {
            this.mPageContext = tbPageContext;
            removeAllViews();
            this.ghM = new View(getContext());
            this.ghM.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds16)));
            this.ghM.setBackgroundResource(R.drawable.bottom_view_shadow);
            addView(this.ghM);
            this.jnt = new LinearLayout(getContext());
            this.jnt.setOrientation(0);
            this.jnt.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            addView(this.jnt);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                MenuItemView menuItemView = new MenuItemView(tbPageContext);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                menuItemView.setLayoutParams(layoutParams);
                menuItemView.setMenuData(list.get(i));
                menuItemView.setOnMenuItemClickListener(this.jns);
                this.jnt.addView(menuItemView);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType && this.jnt != null) {
            this.mSkinType = i;
            int childCount = this.jnt.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.jnt.getChildAt(i2);
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
            ao.setBackgroundColor(this.ghM, R.color.CAM_X0204);
        }
    }

    /* loaded from: classes2.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener {
        private static final int jnu = R.drawable.icon_card_morelist_n;
        private b jnA;
        private a jns;
        private int jnv;
        private ImageView jnw;
        private TextView jnx;
        private BottomMenu jny;
        private boolean jnz;
        private TbPageContext<?> mPageContext;

        public MenuItemView(TbPageContext<?> tbPageContext) {
            super(tbPageContext.getPageActivity());
            this.jnv = jnu;
            setGravity(17);
            setOnClickListener(this);
            LayoutInflater.from(getContext()).inflate(R.layout.bottom_menu_item, this);
            this.mPageContext = tbPageContext;
            this.jnw = (ImageView) findViewById(R.id.item_image);
            this.jnx = (TextView) findViewById(R.id.item_text);
        }

        public void setOnMenuItemClickListener(a aVar) {
            this.jns = aVar;
        }

        public void setMenuData(BottomMenu bottomMenu) {
            if (bottomMenu != null) {
                this.jny = bottomMenu;
                this.jnz = x.getCount(bottomMenu.submenu) > 0;
                this.jnx.setText(bottomMenu.name);
                onChangeSkinType(this.mPageContext, 0);
            }
        }

        public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
            setMenuIcon(this.jnv);
            ao.setViewTextColor(this.jnx, R.color.CAM_X0105);
            ao.setBackgroundResource(this, R.drawable.addresslist_item_bg);
        }

        private void setMenuIcon(int i) {
            this.jnv = i;
            if (this.jnz) {
                this.jnw.setVisibility(0);
                this.jnw.setImageResource(i);
                ao.setImageResource(this.jnw, i);
                return;
            }
            this.jnw.setVisibility(8);
        }

        public f getPageContext() {
            return this.mPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.jnz) {
                getSubMenuGenerator().a(this, this.jny.submenu);
            }
            if (this.jns != null) {
                this.jns.a(this, this.jny);
            }
        }

        private b getSubMenuGenerator() {
            if (this.jnA == null) {
                this.jnA = new b();
                this.jnA.setOnMenuItemClickListener(this.jns);
            }
            return this.jnA;
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements View.OnClickListener {
        private RelativeLayout jnB;
        private final int[] jnC = new int[2];
        private a jns;
        private PopupWindow mPopupWindow;

        public void setOnMenuItemClickListener(a aVar) {
            this.jns = aVar;
        }

        public void a(MenuItemView menuItemView, List<SubBottomMenu> list) {
            if (menuItemView != null && !x.isEmpty(list)) {
                Activity pageActivity = menuItemView.getPageContext().getPageActivity();
                this.jnB = new RelativeLayout(pageActivity);
                this.jnB.setBackgroundColor(ao.getColor(R.color.CAM_X0608));
                this.jnB.setOnClickListener(this);
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
                this.jnB.addView(linearLayout);
                menuItemView.getLocationInWindow(this.jnC);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.width = menuItemView.getWidth();
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.jnC[0];
                this.mPopupWindow = new PopupWindow(this.jnB, -1, this.jnC[1]);
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
                if (this.jns != null) {
                    this.jns.a(subMenuItemView, subMenuItemView.getSubMenuData());
                }
            } else if (view == this.jnB) {
                g.dismissPopupWindow(this.mPopupWindow);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class SubMenuItemView extends LinearLayout {
        private View eup;
        private SubBottomMenu jnD;
        private TextView mTitleView;

        public SubMenuItemView(Context context) {
            super(context);
            LayoutInflater.from(context).inflate(R.layout.bottom_submenu_item, this);
            setOrientation(1);
            this.mTitleView = (TextView) findViewById(R.id.item_text);
            this.eup = findViewById(R.id.divider_line);
        }

        public void setSubMenuData(SubBottomMenu subBottomMenu, int i, boolean z) {
            if (subBottomMenu != null) {
                this.jnD = subBottomMenu;
                this.mTitleView.setText(subBottomMenu.name);
                ao.setViewTextColor(this.mTitleView, R.color.CAM_X0106);
                ao.setBackgroundResource(this, i == 0 ? R.drawable.bottom_menu_item_bg_corner_selector : R.drawable.bottom_menu_item_bg_selector);
                if (z) {
                    this.eup.setVisibility(8);
                    return;
                }
                this.eup.setVisibility(0);
                ao.setBackgroundColor(this.eup, R.color.CAM_X0204);
            }
        }

        public SubBottomMenu getSubMenuData() {
            return this.jnD;
        }
    }
}
