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
import d.b.b.a.f;
import d.b.b.e.m.g;
import d.b.b.e.p.l;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes4.dex */
public class BottomMenuView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f16165e;

    /* renamed from: f  reason: collision with root package name */
    public a f16166f;

    /* renamed from: g  reason: collision with root package name */
    public View f16167g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f16168h;

    /* loaded from: classes4.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener {
        public static final int m = R.drawable.icon_card_morelist_n;

        /* renamed from: e  reason: collision with root package name */
        public int f16169e;

        /* renamed from: f  reason: collision with root package name */
        public TbPageContext<?> f16170f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f16171g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f16172h;
        public BottomMenu i;
        public boolean j;
        public a k;
        public b l;

        public MenuItemView(TbPageContext<?> tbPageContext) {
            super(tbPageContext.getPageActivity());
            this.f16169e = m;
            setGravity(17);
            setOnClickListener(this);
            LayoutInflater.from(getContext()).inflate(R.layout.bottom_menu_item, this);
            this.f16170f = tbPageContext;
            this.f16171g = (ImageView) findViewById(R.id.item_image);
            this.f16172h = (TextView) findViewById(R.id.item_text);
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
            this.f16169e = i;
            if (this.j) {
                this.f16171g.setVisibility(0);
                this.f16171g.setImageResource(i);
                SkinManager.setImageResource(this.f16171g, i);
                return;
            }
            this.f16171g.setVisibility(8);
        }

        public void a(TbPageContext<?> tbPageContext, int i) {
            setMenuIcon(this.f16169e);
            SkinManager.setViewTextColor(this.f16172h, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this, R.drawable.addresslist_item_bg);
        }

        public f getPageContext() {
            return this.f16170f;
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
            this.f16172h.setText(bottomMenu.name);
            a(this.f16170f, 0);
        }

        public void setOnMenuItemClickListener(a aVar) {
            this.k = aVar;
        }
    }

    /* loaded from: classes4.dex */
    public static class SubMenuItemView extends LinearLayout {

        /* renamed from: e  reason: collision with root package name */
        public TextView f16173e;

        /* renamed from: f  reason: collision with root package name */
        public View f16174f;

        /* renamed from: g  reason: collision with root package name */
        public SubBottomMenu f16175g;

        public SubMenuItemView(Context context) {
            super(context);
            LayoutInflater.from(context).inflate(R.layout.bottom_submenu_item, this);
            setOrientation(1);
            this.f16173e = (TextView) findViewById(R.id.item_text);
            this.f16174f = findViewById(R.id.divider_line);
        }

        public SubBottomMenu getSubMenuData() {
            return this.f16175g;
        }

        public void setSubMenuData(SubBottomMenu subBottomMenu, int i, boolean z) {
            if (subBottomMenu == null) {
                return;
            }
            this.f16175g = subBottomMenu;
            this.f16173e.setText(subBottomMenu.name);
            SkinManager.setViewTextColor(this.f16173e, R.color.CAM_X0106);
            SkinManager.setBackgroundResource(this, i == 0 ? R.drawable.bottom_menu_item_bg_corner_selector : R.drawable.bottom_menu_item_bg_selector);
            if (z) {
                this.f16174f.setVisibility(8);
                return;
            }
            this.f16174f.setVisibility(0);
            SkinManager.setBackgroundColor(this.f16174f, R.color.CAM_X0204);
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
        public a f16176e;

        /* renamed from: f  reason: collision with root package name */
        public PopupWindow f16177f;

        /* renamed from: g  reason: collision with root package name */
        public RelativeLayout f16178g;

        /* renamed from: h  reason: collision with root package name */
        public final int[] f16179h = new int[2];

        public void a(a aVar) {
            this.f16176e = aVar;
        }

        public void b(MenuItemView menuItemView, List<SubBottomMenu> list) {
            if (menuItemView == null || ListUtils.isEmpty(list)) {
                return;
            }
            Activity pageActivity = menuItemView.getPageContext().getPageActivity();
            RelativeLayout relativeLayout = new RelativeLayout(pageActivity);
            this.f16178g = relativeLayout;
            relativeLayout.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0608));
            this.f16178g.setOnClickListener(this);
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
            this.f16178g.addView(linearLayout);
            menuItemView.getLocationInWindow(this.f16179h);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.width = menuItemView.getWidth();
            layoutParams.addRule(12);
            layoutParams.leftMargin = this.f16179h[0];
            PopupWindow popupWindow = new PopupWindow(this.f16178g, -1, this.f16179h[1]);
            this.f16177f = popupWindow;
            popupWindow.setOutsideTouchable(true);
            this.f16177f.setFocusable(true);
            this.f16177f.setClippingEnabled(false);
            this.f16177f.setBackgroundDrawable(new ColorDrawable());
            this.f16177f.setSoftInputMode(16);
            g.m(this.f16177f, menuItemView, 51, 0, 0);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view instanceof SubMenuItemView) {
                g.c(this.f16177f);
                SubMenuItemView subMenuItemView = (SubMenuItemView) view;
                a aVar = this.f16176e;
                if (aVar != null) {
                    aVar.a(subMenuItemView, subMenuItemView.getSubMenuData());
                }
            } else if (view == this.f16178g) {
                g.c(this.f16177f);
            }
        }
    }

    public BottomMenuView(Context context) {
        this(context, null);
    }

    public void a(TbPageContext<?> tbPageContext, int i) {
        LinearLayout linearLayout;
        if (i == this.f16165e || (linearLayout = this.f16168h) == null) {
            return;
        }
        this.f16165e = i;
        int childCount = linearLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.f16168h.getChildAt(i2);
            if (childAt == null) {
                return;
            }
            if (childAt instanceof MenuItemView) {
                ((MenuItemView) childAt).a(tbPageContext, i);
            } else {
                SkinManager.setBackgroundColor(childAt, R.color.CAM_X0204);
            }
        }
        SkinManager.setBackgroundColor(this.f16167g, R.color.CAM_X0204);
    }

    public void b(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        removeAllViews();
        this.f16167g = new View(getContext());
        this.f16167g.setLayoutParams(new LinearLayout.LayoutParams(-1, l.g(getContext(), R.dimen.tbds16)));
        this.f16167g.setBackgroundResource(R.drawable.bottom_view_shadow);
        addView(this.f16167g);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f16168h = linearLayout;
        linearLayout.setOrientation(0);
        this.f16168h.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        addView(this.f16168h);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            MenuItemView menuItemView = new MenuItemView(tbPageContext);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            menuItemView.setLayoutParams(layoutParams);
            menuItemView.setMenuData(list.get(i));
            menuItemView.setOnMenuItemClickListener(this.f16166f);
            this.f16168h.addView(menuItemView);
        }
    }

    public void setOnMenuItemClickListener(a aVar) {
        this.f16166f = aVar;
    }

    public BottomMenuView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomMenuView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16165e = 3;
    }
}
