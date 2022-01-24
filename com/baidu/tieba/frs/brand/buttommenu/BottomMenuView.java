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
import c.a.d.a.f;
import c.a.d.f.m.g;
import c.a.d.f.p.n;
import c.a.t0.e1.c1;
import c.a.t0.e1.d1;
import c.a.t0.e1.e1;
import c.a.t0.e1.f1;
import c.a.t0.e1.g1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes12.dex */
public class BottomMenuView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f43251e;

    /* renamed from: f  reason: collision with root package name */
    public a f43252f;

    /* renamed from: g  reason: collision with root package name */
    public View f43253g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f43254h;

    /* loaded from: classes12.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public static final int m;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f43255e;

        /* renamed from: f  reason: collision with root package name */
        public TbPageContext<?> f43256f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f43257g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f43258h;

        /* renamed from: i  reason: collision with root package name */
        public BottomMenu f43259i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f43260j;
        public a k;
        public b l;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1768630160, "Lcom/baidu/tieba/frs/brand/buttommenu/BottomMenuView$MenuItemView;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1768630160, "Lcom/baidu/tieba/frs/brand/buttommenu/BottomMenuView$MenuItemView;");
                    return;
                }
            }
            m = e1.icon_card_morelist_n;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MenuItemView(TbPageContext<?> tbPageContext) {
            super(tbPageContext.getPageActivity());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f43255e = m;
            setGravity(17);
            setOnClickListener(this);
            LayoutInflater.from(getContext()).inflate(g1.bottom_menu_item, this);
            this.f43256f = tbPageContext;
            this.f43257g = (ImageView) findViewById(f1.item_image);
            this.f43258h = (TextView) findViewById(f1.item_text);
        }

        private b getSubMenuGenerator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                if (this.l == null) {
                    b bVar = new b();
                    this.l = bVar;
                    bVar.a(this.k);
                }
                return this.l;
            }
            return (b) invokeV.objValue;
        }

        private void setMenuIcon(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(65539, this, i2) == null) {
                this.f43255e = i2;
                if (this.f43260j) {
                    this.f43257g.setVisibility(0);
                    this.f43257g.setImageResource(i2);
                    SkinManager.setImageResource(this.f43257g, i2);
                    return;
                }
                this.f43257g.setVisibility(8);
            }
        }

        public f getPageContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f43256f : (f) invokeV.objValue;
        }

        public void onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) {
                setMenuIcon(this.f43255e);
                SkinManager.setViewTextColor(this.f43258h, c1.CAM_X0105);
                SkinManager.setBackgroundResource(this, e1.addresslist_item_bg);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
                if (this.f43260j) {
                    getSubMenuGenerator().b(this, this.f43259i.submenu);
                }
                a aVar = this.k;
                if (aVar != null) {
                    aVar.b(this, this.f43259i);
                }
            }
        }

        public void setMenuData(BottomMenu bottomMenu) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, bottomMenu) == null) || bottomMenu == null) {
                return;
            }
            this.f43259i = bottomMenu;
            this.f43260j = ListUtils.getCount(bottomMenu.submenu) > 0;
            this.f43258h.setText(bottomMenu.name);
            onChangeSkinType(this.f43256f, 0);
        }

        public void setOnMenuItemClickListener(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                this.k = aVar;
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class SubMenuItemView extends LinearLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public TextView f43261e;

        /* renamed from: f  reason: collision with root package name */
        public View f43262f;

        /* renamed from: g  reason: collision with root package name */
        public SubBottomMenu f43263g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SubMenuItemView(Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            LayoutInflater.from(context).inflate(g1.bottom_submenu_item, this);
            setOrientation(1);
            this.f43261e = (TextView) findViewById(f1.item_text);
            this.f43262f = findViewById(f1.divider_line);
        }

        public SubBottomMenu getSubMenuData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f43263g : (SubBottomMenu) invokeV.objValue;
        }

        public void setSubMenuData(SubBottomMenu subBottomMenu, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{subBottomMenu, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || subBottomMenu == null) {
                return;
            }
            this.f43263g = subBottomMenu;
            this.f43261e.setText(subBottomMenu.name);
            SkinManager.setViewTextColor(this.f43261e, c1.CAM_X0106);
            SkinManager.setBackgroundResource(this, i2 == 0 ? e1.bottom_menu_item_bg_corner_selector : e1.bottom_menu_item_bg_selector);
            if (z) {
                this.f43262f.setVisibility(8);
                return;
            }
            this.f43262f.setVisibility(0);
            SkinManager.setBackgroundColor(this.f43262f, c1.CAM_X0204);
        }
    }

    /* loaded from: classes12.dex */
    public interface a {
        void a(SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu);

        void b(MenuItemView menuItemView, BottomMenu bottomMenu);
    }

    /* loaded from: classes12.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public a f43264e;

        /* renamed from: f  reason: collision with root package name */
        public PopupWindow f43265f;

        /* renamed from: g  reason: collision with root package name */
        public RelativeLayout f43266g;

        /* renamed from: h  reason: collision with root package name */
        public final int[] f43267h;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43267h = new int[2];
        }

        public void a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f43264e = aVar;
            }
        }

        public void b(MenuItemView menuItemView, List<SubBottomMenu> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, menuItemView, list) == null) || menuItemView == null || ListUtils.isEmpty(list)) {
                return;
            }
            Activity pageActivity = menuItemView.getPageContext().getPageActivity();
            RelativeLayout relativeLayout = new RelativeLayout(pageActivity);
            this.f43266g = relativeLayout;
            relativeLayout.setBackgroundColor(SkinManager.getColor(c1.CAM_X0608));
            this.f43266g.setOnClickListener(this);
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
            this.f43266g.addView(linearLayout);
            menuItemView.getLocationInWindow(this.f43267h);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.width = menuItemView.getWidth();
            layoutParams.addRule(12);
            layoutParams.leftMargin = this.f43267h[0];
            PopupWindow popupWindow = new PopupWindow(this.f43266g, -1, this.f43267h[1]);
            this.f43265f = popupWindow;
            popupWindow.setOutsideTouchable(true);
            this.f43265f.setFocusable(true);
            this.f43265f.setClippingEnabled(false);
            this.f43265f.setBackgroundDrawable(new ColorDrawable());
            this.f43265f.setSoftInputMode(16);
            g.m(this.f43265f, menuItemView, 51, 0, 0);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
                if (view instanceof SubMenuItemView) {
                    g.c(this.f43265f);
                    SubMenuItemView subMenuItemView = (SubMenuItemView) view;
                    a aVar = this.f43264e;
                    if (aVar != null) {
                        aVar.a(subMenuItemView, subMenuItemView.getSubMenuData());
                    }
                } else if (view == this.f43266g) {
                    g.c(this.f43265f);
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BottomMenuView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, tbPageContext, i2) == null) || i2 == this.f43251e || (linearLayout = this.f43254h) == null) {
            return;
        }
        this.f43251e = i2;
        int childCount = linearLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.f43254h.getChildAt(i3);
            if (childAt == null) {
                return;
            }
            if (childAt instanceof MenuItemView) {
                ((MenuItemView) childAt).onChangeSkinType(tbPageContext, i2);
            } else {
                SkinManager.setBackgroundColor(childAt, c1.CAM_X0204);
            }
        }
        SkinManager.setBackgroundColor(this.f43253g, c1.CAM_X0204);
    }

    public void setOnMenuItemClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f43252f = aVar;
        }
    }

    public void showMenu(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, tbPageContext) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        removeAllViews();
        this.f43253g = new View(getContext());
        this.f43253g.setLayoutParams(new LinearLayout.LayoutParams(-1, n.f(getContext(), d1.tbds16)));
        this.f43253g.setBackgroundResource(e1.bottom_view_shadow);
        addView(this.f43253g);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f43254h = linearLayout;
        linearLayout.setOrientation(0);
        this.f43254h.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        addView(this.f43254h);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemView menuItemView = new MenuItemView(tbPageContext);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            menuItemView.setLayoutParams(layoutParams);
            menuItemView.setMenuData(list.get(i2));
            menuItemView.setOnMenuItemClickListener(this.f43252f);
            this.f43254h.addView(menuItemView);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BottomMenuView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomMenuView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f43251e = 3;
    }
}
