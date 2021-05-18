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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.a.f;
import d.a.c.e.m.g;
import d.a.c.e.p.l;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes4.dex */
public class BottomMenuView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f15334e;

    /* renamed from: f  reason: collision with root package name */
    public a f15335f;

    /* renamed from: g  reason: collision with root package name */
    public View f15336g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f15337h;

    /* loaded from: classes4.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener {
        public static final int m = R.drawable.icon_card_morelist_n;

        /* renamed from: e  reason: collision with root package name */
        public int f15338e;

        /* renamed from: f  reason: collision with root package name */
        public TbPageContext<?> f15339f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f15340g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f15341h;

        /* renamed from: i  reason: collision with root package name */
        public BottomMenu f15342i;
        public boolean j;
        public a k;
        public b l;

        public MenuItemView(TbPageContext<?> tbPageContext) {
            super(tbPageContext.getPageActivity());
            this.f15338e = m;
            setGravity(17);
            setOnClickListener(this);
            LayoutInflater.from(getContext()).inflate(R.layout.bottom_menu_item, this);
            this.f15339f = tbPageContext;
            this.f15340g = (ImageView) findViewById(R.id.item_image);
            this.f15341h = (TextView) findViewById(R.id.item_text);
        }

        private b getSubMenuGenerator() {
            if (this.l == null) {
                b bVar = new b();
                this.l = bVar;
                bVar.a(this.k);
            }
            return this.l;
        }

        private void setMenuIcon(int i2) {
            this.f15338e = i2;
            if (this.j) {
                this.f15340g.setVisibility(0);
                this.f15340g.setImageResource(i2);
                SkinManager.setImageResource(this.f15340g, i2);
                return;
            }
            this.f15340g.setVisibility(8);
        }

        public void a(TbPageContext<?> tbPageContext, int i2) {
            setMenuIcon(this.f15338e);
            SkinManager.setViewTextColor(this.f15341h, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this, R.drawable.addresslist_item_bg);
        }

        public f getPageContext() {
            return this.f15339f;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.j) {
                getSubMenuGenerator().b(this, this.f15342i.submenu);
            }
            a aVar = this.k;
            if (aVar != null) {
                aVar.b(this, this.f15342i);
            }
        }

        public void setMenuData(BottomMenu bottomMenu) {
            if (bottomMenu == null) {
                return;
            }
            this.f15342i = bottomMenu;
            this.j = ListUtils.getCount(bottomMenu.submenu) > 0;
            this.f15341h.setText(bottomMenu.name);
            a(this.f15339f, 0);
        }

        public void setOnMenuItemClickListener(a aVar) {
            this.k = aVar;
        }
    }

    /* loaded from: classes4.dex */
    public static class SubMenuItemView extends LinearLayout {

        /* renamed from: e  reason: collision with root package name */
        public TextView f15343e;

        /* renamed from: f  reason: collision with root package name */
        public View f15344f;

        /* renamed from: g  reason: collision with root package name */
        public SubBottomMenu f15345g;

        public SubMenuItemView(Context context) {
            super(context);
            LayoutInflater.from(context).inflate(R.layout.bottom_submenu_item, this);
            setOrientation(1);
            this.f15343e = (TextView) findViewById(R.id.item_text);
            this.f15344f = findViewById(R.id.divider_line);
        }

        public SubBottomMenu getSubMenuData() {
            return this.f15345g;
        }

        public void setSubMenuData(SubBottomMenu subBottomMenu, int i2, boolean z) {
            if (subBottomMenu == null) {
                return;
            }
            this.f15345g = subBottomMenu;
            this.f15343e.setText(subBottomMenu.name);
            SkinManager.setViewTextColor(this.f15343e, R.color.CAM_X0106);
            SkinManager.setBackgroundResource(this, i2 == 0 ? R.drawable.bottom_menu_item_bg_corner_selector : R.drawable.bottom_menu_item_bg_selector);
            if (z) {
                this.f15344f.setVisibility(8);
                return;
            }
            this.f15344f.setVisibility(0);
            SkinManager.setBackgroundColor(this.f15344f, R.color.CAM_X0204);
        }
    }

    /* loaded from: classes4.dex */
    public interface a {
        void a(SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu);

        void b(MenuItemView menuItemView, BottomMenu bottomMenu);
    }

    /* loaded from: classes4.dex */
    public static class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public a f15346e;

        /* renamed from: f  reason: collision with root package name */
        public PopupWindow f15347f;

        /* renamed from: g  reason: collision with root package name */
        public RelativeLayout f15348g;

        /* renamed from: h  reason: collision with root package name */
        public final int[] f15349h = new int[2];

        public void a(a aVar) {
            this.f15346e = aVar;
        }

        public void b(MenuItemView menuItemView, List<SubBottomMenu> list) {
            if (menuItemView == null || ListUtils.isEmpty(list)) {
                return;
            }
            Activity pageActivity = menuItemView.getPageContext().getPageActivity();
            RelativeLayout relativeLayout = new RelativeLayout(pageActivity);
            this.f15348g = relativeLayout;
            relativeLayout.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0608));
            this.f15348g.setOnClickListener(this);
            LinearLayout linearLayout = new LinearLayout(pageActivity);
            linearLayout.setOrientation(1);
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                SubMenuItemView subMenuItemView = new SubMenuItemView(pageActivity);
                subMenuItemView.setSubMenuData(list.get(i2), i2, i2 == size + (-1));
                subMenuItemView.setOnClickListener(this);
                linearLayout.addView(subMenuItemView);
                i2++;
            }
            this.f15348g.addView(linearLayout);
            menuItemView.getLocationInWindow(this.f15349h);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.width = menuItemView.getWidth();
            layoutParams.addRule(12);
            layoutParams.leftMargin = this.f15349h[0];
            PopupWindow popupWindow = new PopupWindow(this.f15348g, -1, this.f15349h[1]);
            this.f15347f = popupWindow;
            popupWindow.setOutsideTouchable(true);
            this.f15347f.setFocusable(true);
            this.f15347f.setClippingEnabled(false);
            this.f15347f.setBackgroundDrawable(new ColorDrawable());
            this.f15347f.setSoftInputMode(16);
            g.m(this.f15347f, menuItemView, 51, 0, 0);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view instanceof SubMenuItemView) {
                g.c(this.f15347f);
                SubMenuItemView subMenuItemView = (SubMenuItemView) view;
                a aVar = this.f15346e;
                if (aVar != null) {
                    aVar.a(subMenuItemView, subMenuItemView.getSubMenuData());
                }
            } else if (view == this.f15348g) {
                g.c(this.f15347f);
            }
        }
    }

    public BottomMenuView(Context context) {
        this(context, null);
    }

    public void a(TbPageContext<?> tbPageContext, int i2) {
        LinearLayout linearLayout;
        if (i2 == this.f15334e || (linearLayout = this.f15337h) == null) {
            return;
        }
        this.f15334e = i2;
        int childCount = linearLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.f15337h.getChildAt(i3);
            if (childAt == null) {
                return;
            }
            if (childAt instanceof MenuItemView) {
                ((MenuItemView) childAt).a(tbPageContext, i2);
            } else {
                SkinManager.setBackgroundColor(childAt, R.color.CAM_X0204);
            }
        }
        SkinManager.setBackgroundColor(this.f15336g, R.color.CAM_X0204);
    }

    public void b(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        removeAllViews();
        this.f15336g = new View(getContext());
        this.f15336g.setLayoutParams(new LinearLayout.LayoutParams(-1, l.g(getContext(), R.dimen.tbds16)));
        this.f15336g.setBackgroundResource(R.drawable.bottom_view_shadow);
        addView(this.f15336g);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f15337h = linearLayout;
        linearLayout.setOrientation(0);
        this.f15337h.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        addView(this.f15337h);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemView menuItemView = new MenuItemView(tbPageContext);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            menuItemView.setLayoutParams(layoutParams);
            menuItemView.setMenuData(list.get(i2));
            menuItemView.setOnMenuItemClickListener(this.f15335f);
            this.f15337h.addView(menuItemView);
        }
    }

    public void setOnMenuItemClickListener(a aVar) {
        this.f15335f = aVar;
    }

    public BottomMenuView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomMenuView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f15334e = 3;
    }
}
