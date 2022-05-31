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
import com.repackage.b9;
import com.repackage.li;
import com.repackage.og;
import java.util.List;
import tbclient.BottomMenu;
import tbclient.SubBottomMenu;
/* loaded from: classes3.dex */
public class BottomMenuView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public a b;
    public View c;
    public LinearLayout d;

    /* loaded from: classes3.dex */
    public static class MenuItemView extends LinearLayout implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: i */
        public static final int icon_card_morelist_n = 2131232409;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public TbPageContext<?> b;
        public ImageView c;
        public TextView d;
        public BottomMenu e;
        public boolean f;
        public a g;
        public b h;

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
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d015a, this);
            this.b = tbPageContext;
            this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f090f48);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f090f75);
        }

        private b getSubMenuGenerator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                if (this.h == null) {
                    b bVar = new b();
                    this.h = bVar;
                    bVar.a(this.g);
                }
                return this.h;
            }
            return (b) invokeV.objValue;
        }

        private void setMenuIcon(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(65539, this, i) == null) {
                this.a = i;
                if (this.f) {
                    this.c.setVisibility(0);
                    this.c.setImageResource(i);
                    SkinManager.setImageResource(this.c, i);
                    return;
                }
                this.c.setVisibility(8);
            }
        }

        public void a(TbPageContext<?> tbPageContext, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, tbPageContext, i) == null) {
                setMenuIcon(this.a);
                SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
                SkinManager.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            }
        }

        public b9 getPageContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (b9) invokeV.objValue;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
                if (this.f) {
                    getSubMenuGenerator().b(this, this.e.submenu);
                }
                a aVar = this.g;
                if (aVar != null) {
                    aVar.b(this, this.e);
                }
            }
        }

        public void setMenuData(BottomMenu bottomMenu) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, bottomMenu) == null) || bottomMenu == null) {
                return;
            }
            this.e = bottomMenu;
            this.f = ListUtils.getCount(bottomMenu.submenu) > 0;
            this.d.setText(bottomMenu.name);
            a(this.b, 0);
        }

        public void setOnMenuItemClickListener(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                this.g = aVar;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class SubMenuItemView extends LinearLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public View b;
        public SubBottomMenu c;

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
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d015b, this);
            setOrientation(1);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f090f75);
            this.b = findViewById(R.id.obfuscated_res_0x7f0907d8);
        }

        public SubBottomMenu getSubMenuData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : (SubBottomMenu) invokeV.objValue;
        }

        public void setSubMenuData(SubBottomMenu subBottomMenu, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{subBottomMenu, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || subBottomMenu == null) {
                return;
            }
            this.c = subBottomMenu;
            this.a.setText(subBottomMenu.name);
            SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0106);
            SkinManager.setBackgroundResource(this, i == 0 ? R.drawable.bottom_menu_item_bg_corner_selector : R.drawable.bottom_menu_item_bg_selector);
            if (z) {
                this.b.setVisibility(8);
                return;
            }
            this.b.setVisibility(0);
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0204);
        }
    }

    /* loaded from: classes3.dex */
    public interface a {
        void a(SubMenuItemView subMenuItemView, SubBottomMenu subBottomMenu);

        void b(MenuItemView menuItemView, BottomMenu bottomMenu);
    }

    /* loaded from: classes3.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public a a;
        public PopupWindow b;
        public RelativeLayout c;
        public final int[] d;

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
            this.d = new int[2];
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
            this.c = relativeLayout;
            relativeLayout.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0608));
            this.c.setOnClickListener(this);
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
            this.c.addView(linearLayout);
            menuItemView.getLocationInWindow(this.d);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.width = menuItemView.getWidth();
            layoutParams.addRule(12);
            layoutParams.leftMargin = this.d[0];
            PopupWindow popupWindow = new PopupWindow(this.c, -1, this.d[1]);
            this.b = popupWindow;
            popupWindow.setOutsideTouchable(true);
            this.b.setFocusable(true);
            this.b.setClippingEnabled(false);
            this.b.setBackgroundDrawable(new ColorDrawable());
            this.b.setSoftInputMode(16);
            og.m(this.b, menuItemView, 51, 0, 0);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
                if (view2 instanceof SubMenuItemView) {
                    og.c(this.b);
                    SubMenuItemView subMenuItemView = (SubMenuItemView) view2;
                    a aVar = this.a;
                    if (aVar != null) {
                        aVar.a(subMenuItemView, subMenuItemView.getSubMenuData());
                    }
                } else if (view2 == this.c) {
                    og.c(this.b);
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
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, tbPageContext, i) == null) || i == this.a || (linearLayout = this.d) == null) {
            return;
        }
        this.a = i;
        int childCount = linearLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.d.getChildAt(i2);
            if (childAt == null) {
                return;
            }
            if (childAt instanceof MenuItemView) {
                ((MenuItemView) childAt).a(tbPageContext, i);
            } else {
                SkinManager.setBackgroundColor(childAt, R.color.CAM_X0204);
            }
        }
        SkinManager.setBackgroundColor(this.c, R.color.CAM_X0204);
    }

    public void b(List<BottomMenu> list, TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, tbPageContext) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        removeAllViews();
        this.c = new View(getContext());
        this.c.setLayoutParams(new LinearLayout.LayoutParams(-1, li.f(getContext(), R.dimen.tbds16)));
        this.c.setBackgroundResource(R.drawable.bottom_view_shadow);
        addView(this.c);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.d = linearLayout;
        linearLayout.setOrientation(0);
        this.d.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        addView(this.d);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            MenuItemView menuItemView = new MenuItemView(tbPageContext);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            menuItemView.setLayoutParams(layoutParams);
            menuItemView.setMenuData(list.get(i));
            menuItemView.setOnMenuItemClickListener(this.b);
            this.d.addView(menuItemView);
        }
    }

    public void setOnMenuItemClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.b = aVar;
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
