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
import d.b.c.a.f;
import d.b.c.e.m.g;
import d.b.c.e.p.l;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes4.dex */
public class BottomMenuView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f15827e;

    /* renamed from: f  reason: collision with root package name */
    public a f15828f;

    /* renamed from: g  reason: collision with root package name */
    public View f15829g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f15830h;

    /* loaded from: classes4.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener {
        public static final int m = R.drawable.icon_card_morelist_n;

        /* renamed from: e  reason: collision with root package name */
        public int f15831e;

        /* renamed from: f  reason: collision with root package name */
        public TbPageContext<?> f15832f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f15833g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f15834h;
        public BottomMenu i;
        public boolean j;
        public a k;
        public b l;

        public MenuItemView(TbPageContext<?> tbPageContext) {
            super(tbPageContext.getPageActivity());
            this.f15831e = m;
            setGravity(17);
            setOnClickListener(this);
            LayoutInflater.from(getContext()).inflate(R.layout.bottom_menu_item, this);
            this.f15832f = tbPageContext;
            this.f15833g = (ImageView) findViewById(R.id.item_image);
            this.f15834h = (TextView) findViewById(R.id.item_text);
        }

        private b getSubMenuGenerator() {
            if (this.l == null) {
                b bVar = new b();
                this.l = bVar;
                bVar.a(this.k);
            }
            return this.l;
        }

        private void setMenuIcon(int i) {
            this.f15831e = i;
            if (this.j) {
                this.f15833g.setVisibility(0);
                this.f15833g.setImageResource(i);
                SkinManager.setImageResource(this.f15833g, i);
                return;
            }
            this.f15833g.setVisibility(8);
        }

        public void a(TbPageContext<?> tbPageContext, int i) {
            setMenuIcon(this.f15831e);
            SkinManager.setViewTextColor(this.f15834h, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this, R.drawable.addresslist_item_bg);
        }

        public f getPageContext() {
            return this.f15832f;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.j) {
                getSubMenuGenerator().b(this, this.i.submenu);
            }
            a aVar = this.k;
            if (aVar != null) {
                aVar.b(this, this.i);
            }
        }

        public void setMenuData(BottomMenu bottomMenu) {
            if (bottomMenu == null) {
                return;
            }
            this.i = bottomMenu;
            this.j = ListUtils.getCount(bottomMenu.submenu) > 0;
            this.f15834h.setText(bottomMenu.name);
            a(this.f15832f, 0);
        }

        public void setOnMenuItemClickListener(a aVar) {
            this.k = aVar;
        }
    }

    /* loaded from: classes4.dex */
    public static class SubMenuItemView extends LinearLayout {

        /* renamed from: e  reason: collision with root package name */
        public TextView f15835e;

        /* renamed from: f  reason: collision with root package name */
        public View f15836f;

        /* renamed from: g  reason: collision with root package name */
        public SubBottomMenu f15837g;

        public SubMenuItemView(Context context) {
            super(context);
            LayoutInflater.from(context).inflate(R.layout.bottom_submenu_item, this);
            setOrientation(1);
            this.f15835e = (TextView) findViewById(R.id.item_text);
            this.f15836f = findViewById(R.id.divider_line);
        }

        public SubBottomMenu getSubMenuData() {
            return this.f15837g;
        }

        public void setSubMenuData(SubBottomMenu subBottomMenu, int i, boolean z) {
            if (subBottomMenu == null) {
                return;
            }
            this.f15837g = subBottomMenu;
            this.f15835e.setText(subBottomMenu.name);
            SkinManager.setViewTextColor(this.f15835e, R.color.CAM_X0106);
            SkinManager.setBackgroundResource(this, i == 0 ? R.drawable.bottom_menu_item_bg_corner_selector : R.drawable.bottom_menu_item_bg_selector);
            if (z) {
                this.f15836f.setVisibility(8);
                return;
            }
            this.f15836f.setVisibility(0);
            SkinManager.setBackgroundColor(this.f15836f, R.color.CAM_X0204);
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
        public a f15838e;

        /* renamed from: f  reason: collision with root package name */
        public PopupWindow f15839f;

        /* renamed from: g  reason: collision with root package name */
        public RelativeLayout f15840g;

        /* renamed from: h  reason: collision with root package name */
        public final int[] f15841h = new int[2];

        public void a(a aVar) {
            this.f15838e = aVar;
        }

        public void b(MenuItemView menuItemView, List<SubBottomMenu> list) {
            if (menuItemView == null || ListUtils.isEmpty(list)) {
                return;
            }
            Activity pageActivity = menuItemView.getPageContext().getPageActivity();
            RelativeLayout relativeLayout = new RelativeLayout(pageActivity);
            this.f15840g = relativeLayout;
            relativeLayout.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0608));
            this.f15840g.setOnClickListener(this);
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
            this.f15840g.addView(linearLayout);
            menuItemView.getLocationInWindow(this.f15841h);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.width = menuItemView.getWidth();
            layoutParams.addRule(12);
            layoutParams.leftMargin = this.f15841h[0];
            PopupWindow popupWindow = new PopupWindow(this.f15840g, -1, this.f15841h[1]);
            this.f15839f = popupWindow;
            popupWindow.setOutsideTouchable(true);
            this.f15839f.setFocusable(true);
            this.f15839f.setClippingEnabled(false);
            this.f15839f.setBackgroundDrawable(new ColorDrawable());
            this.f15839f.setSoftInputMode(16);
            g.m(this.f15839f, menuItemView, 51, 0, 0);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view instanceof SubMenuItemView) {
                g.c(this.f15839f);
                SubMenuItemView subMenuItemView = (SubMenuItemView) view;
                a aVar = this.f15838e;
                if (aVar != null) {
                    aVar.a(subMenuItemView, subMenuItemView.getSubMenuData());
                }
            } else if (view == this.f15840g) {
                g.c(this.f15839f);
            }
        }
    }

    public BottomMenuView(Context context) {
        this(context, null);
    }

    public void a(TbPageContext<?> tbPageContext, int i) {
        LinearLayout linearLayout;
        if (i == this.f15827e || (linearLayout = this.f15830h) == null) {
            return;
        }
        this.f15827e = i;
        int childCount = linearLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.f15830h.getChildAt(i2);
            if (childAt == null) {
                return;
            }
            if (childAt instanceof MenuItemView) {
                ((MenuItemView) childAt).a(tbPageContext, i);
            } else {
                SkinManager.setBackgroundColor(childAt, R.color.CAM_X0204);
            }
        }
        SkinManager.setBackgroundColor(this.f15829g, R.color.CAM_X0204);
    }

    public void b(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        removeAllViews();
        this.f15829g = new View(getContext());
        this.f15829g.setLayoutParams(new LinearLayout.LayoutParams(-1, l.g(getContext(), R.dimen.tbds16)));
        this.f15829g.setBackgroundResource(R.drawable.bottom_view_shadow);
        addView(this.f15829g);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f15830h = linearLayout;
        linearLayout.setOrientation(0);
        this.f15830h.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        addView(this.f15830h);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            MenuItemView menuItemView = new MenuItemView(tbPageContext);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            menuItemView.setLayoutParams(layoutParams);
            menuItemView.setMenuData(list.get(i));
            menuItemView.setOnMenuItemClickListener(this.f15828f);
            this.f15830h.addView(menuItemView);
        }
    }

    public void setOnMenuItemClickListener(a aVar) {
        this.f15828f = aVar;
    }

    public BottomMenuView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomMenuView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15827e = 3;
    }
}
