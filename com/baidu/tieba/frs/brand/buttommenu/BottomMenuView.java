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
    public int f15299e;

    /* renamed from: f  reason: collision with root package name */
    public a f15300f;

    /* renamed from: g  reason: collision with root package name */
    public View f15301g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f15302h;

    /* loaded from: classes4.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener {
        public static final int m = R.drawable.icon_card_morelist_n;

        /* renamed from: e  reason: collision with root package name */
        public int f15303e;

        /* renamed from: f  reason: collision with root package name */
        public TbPageContext<?> f15304f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f15305g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f15306h;

        /* renamed from: i  reason: collision with root package name */
        public BottomMenu f15307i;
        public boolean j;
        public a k;
        public b l;

        public MenuItemView(TbPageContext<?> tbPageContext) {
            super(tbPageContext.getPageActivity());
            this.f15303e = m;
            setGravity(17);
            setOnClickListener(this);
            LayoutInflater.from(getContext()).inflate(R.layout.bottom_menu_item, this);
            this.f15304f = tbPageContext;
            this.f15305g = (ImageView) findViewById(R.id.item_image);
            this.f15306h = (TextView) findViewById(R.id.item_text);
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
            this.f15303e = i2;
            if (this.j) {
                this.f15305g.setVisibility(0);
                this.f15305g.setImageResource(i2);
                SkinManager.setImageResource(this.f15305g, i2);
                return;
            }
            this.f15305g.setVisibility(8);
        }

        public void a(TbPageContext<?> tbPageContext, int i2) {
            setMenuIcon(this.f15303e);
            SkinManager.setViewTextColor(this.f15306h, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this, R.drawable.addresslist_item_bg);
        }

        public f getPageContext() {
            return this.f15304f;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.j) {
                getSubMenuGenerator().b(this, this.f15307i.submenu);
            }
            a aVar = this.k;
            if (aVar != null) {
                aVar.b(this, this.f15307i);
            }
        }

        public void setMenuData(BottomMenu bottomMenu) {
            if (bottomMenu == null) {
                return;
            }
            this.f15307i = bottomMenu;
            this.j = ListUtils.getCount(bottomMenu.submenu) > 0;
            this.f15306h.setText(bottomMenu.name);
            a(this.f15304f, 0);
        }

        public void setOnMenuItemClickListener(a aVar) {
            this.k = aVar;
        }
    }

    /* loaded from: classes4.dex */
    public static class SubMenuItemView extends LinearLayout {

        /* renamed from: e  reason: collision with root package name */
        public TextView f15308e;

        /* renamed from: f  reason: collision with root package name */
        public View f15309f;

        /* renamed from: g  reason: collision with root package name */
        public SubBottomMenu f15310g;

        public SubMenuItemView(Context context) {
            super(context);
            LayoutInflater.from(context).inflate(R.layout.bottom_submenu_item, this);
            setOrientation(1);
            this.f15308e = (TextView) findViewById(R.id.item_text);
            this.f15309f = findViewById(R.id.divider_line);
        }

        public SubBottomMenu getSubMenuData() {
            return this.f15310g;
        }

        public void setSubMenuData(SubBottomMenu subBottomMenu, int i2, boolean z) {
            if (subBottomMenu == null) {
                return;
            }
            this.f15310g = subBottomMenu;
            this.f15308e.setText(subBottomMenu.name);
            SkinManager.setViewTextColor(this.f15308e, R.color.CAM_X0106);
            SkinManager.setBackgroundResource(this, i2 == 0 ? R.drawable.bottom_menu_item_bg_corner_selector : R.drawable.bottom_menu_item_bg_selector);
            if (z) {
                this.f15309f.setVisibility(8);
                return;
            }
            this.f15309f.setVisibility(0);
            SkinManager.setBackgroundColor(this.f15309f, R.color.CAM_X0204);
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
        public a f15311e;

        /* renamed from: f  reason: collision with root package name */
        public PopupWindow f15312f;

        /* renamed from: g  reason: collision with root package name */
        public RelativeLayout f15313g;

        /* renamed from: h  reason: collision with root package name */
        public final int[] f15314h = new int[2];

        public void a(a aVar) {
            this.f15311e = aVar;
        }

        public void b(MenuItemView menuItemView, List<SubBottomMenu> list) {
            if (menuItemView == null || ListUtils.isEmpty(list)) {
                return;
            }
            Activity pageActivity = menuItemView.getPageContext().getPageActivity();
            RelativeLayout relativeLayout = new RelativeLayout(pageActivity);
            this.f15313g = relativeLayout;
            relativeLayout.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0608));
            this.f15313g.setOnClickListener(this);
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
            this.f15313g.addView(linearLayout);
            menuItemView.getLocationInWindow(this.f15314h);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.width = menuItemView.getWidth();
            layoutParams.addRule(12);
            layoutParams.leftMargin = this.f15314h[0];
            PopupWindow popupWindow = new PopupWindow(this.f15313g, -1, this.f15314h[1]);
            this.f15312f = popupWindow;
            popupWindow.setOutsideTouchable(true);
            this.f15312f.setFocusable(true);
            this.f15312f.setClippingEnabled(false);
            this.f15312f.setBackgroundDrawable(new ColorDrawable());
            this.f15312f.setSoftInputMode(16);
            g.m(this.f15312f, menuItemView, 51, 0, 0);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view instanceof SubMenuItemView) {
                g.c(this.f15312f);
                SubMenuItemView subMenuItemView = (SubMenuItemView) view;
                a aVar = this.f15311e;
                if (aVar != null) {
                    aVar.a(subMenuItemView, subMenuItemView.getSubMenuData());
                }
            } else if (view == this.f15313g) {
                g.c(this.f15312f);
            }
        }
    }

    public BottomMenuView(Context context) {
        this(context, null);
    }

    public void a(TbPageContext<?> tbPageContext, int i2) {
        LinearLayout linearLayout;
        if (i2 == this.f15299e || (linearLayout = this.f15302h) == null) {
            return;
        }
        this.f15299e = i2;
        int childCount = linearLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.f15302h.getChildAt(i3);
            if (childAt == null) {
                return;
            }
            if (childAt instanceof MenuItemView) {
                ((MenuItemView) childAt).a(tbPageContext, i2);
            } else {
                SkinManager.setBackgroundColor(childAt, R.color.CAM_X0204);
            }
        }
        SkinManager.setBackgroundColor(this.f15301g, R.color.CAM_X0204);
    }

    public void b(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        removeAllViews();
        this.f15301g = new View(getContext());
        this.f15301g.setLayoutParams(new LinearLayout.LayoutParams(-1, l.g(getContext(), R.dimen.tbds16)));
        this.f15301g.setBackgroundResource(R.drawable.bottom_view_shadow);
        addView(this.f15301g);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f15302h = linearLayout;
        linearLayout.setOrientation(0);
        this.f15302h.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        addView(this.f15302h);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemView menuItemView = new MenuItemView(tbPageContext);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            menuItemView.setLayoutParams(layoutParams);
            menuItemView.setMenuData(list.get(i2));
            menuItemView.setOnMenuItemClickListener(this.f15300f);
            this.f15302h.addView(menuItemView);
        }
    }

    public void setOnMenuItemClickListener(a aVar) {
        this.f15300f = aVar;
    }

    public BottomMenuView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomMenuView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f15299e = 3;
    }
}
