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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
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
/* loaded from: classes5.dex */
public class BottomMenuView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public a f32409b;

    /* renamed from: c  reason: collision with root package name */
    public View f32410c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f32411d;

    /* loaded from: classes5.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: i */
        public static final int icon_card_morelist_n = 2131232430;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public TbPageContext<?> f32412b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f32413c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f32414d;

        /* renamed from: e  reason: collision with root package name */
        public BottomMenu f32415e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f32416f;

        /* renamed from: g  reason: collision with root package name */
        public a f32417g;

        /* renamed from: h  reason: collision with root package name */
        public b f32418h;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1768630160, "Lcom/baidu/tieba/frs/brand/buttommenu/BottomMenuView$MenuItemView;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1768630160, "Lcom/baidu/tieba/frs/brand/buttommenu/BottomMenuView$MenuItemView;");
            }
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = icon_card_morelist_n;
            setGravity(17);
            setOnClickListener(this);
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d015d, this);
            this.f32412b = tbPageContext;
            this.f32413c = (ImageView) findViewById(R.id.obfuscated_res_0x7f090f7c);
            this.f32414d = (TextView) findViewById(R.id.obfuscated_res_0x7f090fa9);
        }

        private b getSubMenuGenerator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                if (this.f32418h == null) {
                    b bVar = new b();
                    this.f32418h = bVar;
                    bVar.a(this.f32417g);
                }
                return this.f32418h;
            }
            return (b) invokeV.objValue;
        }

        private void setMenuIcon(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(65539, this, i) == null) {
                this.a = i;
                if (this.f32416f) {
                    this.f32413c.setVisibility(0);
                    this.f32413c.setImageResource(i);
                    SkinManager.setImageResource(this.f32413c, i);
                    return;
                }
                this.f32413c.setVisibility(8);
            }
        }

        public void a(TbPageContext<?> tbPageContext, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, tbPageContext, i) == null) {
                setMenuIcon(this.a);
                SkinManager.setViewTextColor(this.f32414d, (int) R.color.CAM_X0105);
                SkinManager.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            }
        }

        public f getPageContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32412b : (f) invokeV.objValue;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
                if (this.f32416f) {
                    getSubMenuGenerator().b(this, this.f32415e.submenu);
                }
                a aVar = this.f32417g;
                if (aVar != null) {
                    aVar.b(this, this.f32415e);
                }
            }
        }

        public void setMenuData(BottomMenu bottomMenu) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, bottomMenu) == null) || bottomMenu == null) {
                return;
            }
            this.f32415e = bottomMenu;
            this.f32416f = ListUtils.getCount(bottomMenu.submenu) > 0;
            this.f32414d.setText(bottomMenu.name);
            a(this.f32412b, 0);
        }

        public void setOnMenuItemClickListener(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                this.f32417g = aVar;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class SubMenuItemView extends LinearLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public View f32419b;

        /* renamed from: c  reason: collision with root package name */
        public SubBottomMenu f32420c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SubMenuItemView(Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d015e, this);
            setOrientation(1);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f090fa9);
            this.f32419b = findViewById(R.id.obfuscated_res_0x7f0907f4);
        }

        public SubBottomMenu getSubMenuData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f32420c : (SubBottomMenu) invokeV.objValue;
        }

        public void setSubMenuData(SubBottomMenu subBottomMenu, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{subBottomMenu, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || subBottomMenu == null) {
                return;
            }
            this.f32420c = subBottomMenu;
            this.a.setText(subBottomMenu.name);
            SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0106);
            SkinManager.setBackgroundResource(this, i == 0 ? R.drawable.bottom_menu_item_bg_corner_selector : R.drawable.bottom_menu_item_bg_selector);
            if (z) {
                this.f32419b.setVisibility(8);
                return;
            }
            this.f32419b.setVisibility(0);
            SkinManager.setBackgroundColor(this.f32419b, R.color.CAM_X0204);
        }
    }

    /* loaded from: classes5.dex */
    public interface a {
        void a(SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu);

        void b(MenuItemView menuItemView, BottomMenu bottomMenu);
    }

    /* loaded from: classes5.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public a a;

        /* renamed from: b  reason: collision with root package name */
        public PopupWindow f32421b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f32422c;

        /* renamed from: d  reason: collision with root package name */
        public final int[] f32423d;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32423d = new int[2];
        }

        public void a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a = aVar;
            }
        }

        public void b(MenuItemView menuItemView, List<SubBottomMenu> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, menuItemView, list) == null) || menuItemView == null || ListUtils.isEmpty(list)) {
                return;
            }
            Activity pageActivity = menuItemView.getPageContext().getPageActivity();
            RelativeLayout relativeLayout = new RelativeLayout(pageActivity);
            this.f32422c = relativeLayout;
            relativeLayout.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0608));
            this.f32422c.setOnClickListener(this);
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
            this.f32422c.addView(linearLayout);
            menuItemView.getLocationInWindow(this.f32423d);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.width = menuItemView.getWidth();
            layoutParams.addRule(12);
            layoutParams.leftMargin = this.f32423d[0];
            PopupWindow popupWindow = new PopupWindow(this.f32422c, -1, this.f32423d[1]);
            this.f32421b = popupWindow;
            popupWindow.setOutsideTouchable(true);
            this.f32421b.setFocusable(true);
            this.f32421b.setClippingEnabled(false);
            this.f32421b.setBackgroundDrawable(new ColorDrawable());
            this.f32421b.setSoftInputMode(16);
            g.m(this.f32421b, menuItemView, 51, 0, 0);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
                if (view instanceof SubMenuItemView) {
                    g.c(this.f32421b);
                    SubMenuItemView subMenuItemView = (SubMenuItemView) view;
                    a aVar = this.a;
                    if (aVar != null) {
                        aVar.a(subMenuItemView, subMenuItemView.getSubMenuData());
                    }
                } else if (view == this.f32422c) {
                    g.c(this.f32421b);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void a(TbPageContext<?> tbPageContext, int i) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, tbPageContext, i) == null) || i == this.a || (linearLayout = this.f32411d) == null) {
            return;
        }
        this.a = i;
        int childCount = linearLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.f32411d.getChildAt(i2);
            if (childAt == null) {
                return;
            }
            if (childAt instanceof MenuItemView) {
                ((MenuItemView) childAt).a(tbPageContext, i);
            } else {
                SkinManager.setBackgroundColor(childAt, R.color.CAM_X0204);
            }
        }
        SkinManager.setBackgroundColor(this.f32410c, R.color.CAM_X0204);
    }

    public void b(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, tbPageContext) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        removeAllViews();
        this.f32410c = new View(getContext());
        this.f32410c.setLayoutParams(new LinearLayout.LayoutParams(-1, n.f(getContext(), R.dimen.tbds16)));
        this.f32410c.setBackgroundResource(R.drawable.bottom_view_shadow);
        addView(this.f32410c);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f32411d = linearLayout;
        linearLayout.setOrientation(0);
        this.f32411d.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        addView(this.f32411d);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            MenuItemView menuItemView = new MenuItemView(tbPageContext);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            menuItemView.setLayoutParams(layoutParams);
            menuItemView.setMenuData(list.get(i));
            menuItemView.setOnMenuItemClickListener(this.f32409b);
            this.f32411d.addView(menuItemView);
        }
    }

    public void setOnMenuItemClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f32409b = aVar;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomMenuView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 3;
    }
}
