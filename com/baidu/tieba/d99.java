package com.baidu.tieba;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.lv4;
import com.baidu.tieba.write.write.WriteMultiImgsActivity;
import com.baidu.tieba.write.write.sticker.view.StickerLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class d99 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public lv4 b;
    public t89 c;
    public s89 d;
    public BdBaseViewPager e;
    public StickerLayout f;
    public TextView g;
    public FragmentTabWidget h;
    public TbPageContext<WriteMultiImgsActivity> i;
    public int j;
    public LinearLayout k;
    public List<String> l;
    public WriteImagesInfo m;
    public hc9 n;
    public NavigationBar o;
    public ArrayList<FragmentTabIndicator> p;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d99 a;

        public a(d99 d99Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d99Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d99Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.i != null && this.a.i.getPageActivity() != null) {
                this.a.i.getPageActivity().setResult(0);
                this.a.i.getPageActivity().finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements y89 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d99 a;

        public b(d99 d99Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d99Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d99Var;
        }

        @Override // com.baidu.tieba.y89
        public void a(Bitmap bitmap, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, bitmap, z) == null) {
                if (this.a.n != null && this.a.n.c(bitmap)) {
                    return;
                }
                this.a.i(bitmap);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements FragmentTabWidget.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d99 a;

        public c(d99 d99Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d99Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d99Var;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.b
        public void onTabSelectionChanged(int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                d99 d99Var = this.a;
                if (i == d99Var.j) {
                    return;
                }
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            StickerLayout stickerLayout = d99Var.f;
                            if (stickerLayout != null) {
                                stickerLayout.e();
                            }
                            this.a.c.k().setVisibility(8);
                            this.a.d.k().setVisibility(0);
                        }
                    } else {
                        StickerLayout stickerLayout2 = d99Var.f;
                        if (stickerLayout2 != null) {
                            stickerLayout2.e();
                        }
                        this.a.c.k().setVisibility(8);
                        this.a.d.k().setVisibility(0);
                    }
                } else {
                    d99Var.c.k().setVisibility(0);
                    this.a.d.k().setVisibility(8);
                    if (ListUtils.isEmpty(this.a.l)) {
                        if (this.a.n != null) {
                            this.a.n.b();
                        }
                    } else {
                        d99 d99Var2 = this.a;
                        d99Var2.c.m(d99Var2.l);
                    }
                }
                d99 d99Var3 = this.a;
                d99Var3.j = i;
                d99Var3.h.setCurrentTab(this.a.j, true, true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d99 a;

        public d(d99 d99Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d99Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d99Var;
        }

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                if (this.a.b != null) {
                    this.a.b.dismiss();
                }
                this.a.j(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d99 a;

        public e(d99 d99Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d99Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d99Var;
        }

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                if (this.a.b != null) {
                    this.a.b.dismiss();
                }
                this.a.j(false);
            }
        }
    }

    public d99(TbPageContext<WriteMultiImgsActivity> tbPageContext, hc9 hc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, hc9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.e = null;
        this.g = null;
        this.j = 0;
        this.p = new ArrayList<>();
        this.i = tbPageContext;
        this.n = hc9Var;
        this.k = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.obfuscated_res_0x7f0d096b, (ViewGroup) null);
        m();
    }

    public void a(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.l = list;
            this.c.m(list);
        }
    }

    public final void j(boolean z) {
        TbPageContext<WriteMultiImgsActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (tbPageContext = this.i) != null && tbPageContext.getOrignalPage() != null) {
            this.i.getOrignalPage().y1(z, this.m);
        }
    }

    public void p(WriteImagesInfo writeImagesInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, writeImagesInfo) == null) {
            this.m = writeImagesInfo;
        }
    }

    public void k(boolean z, WriteImagesInfo writeImagesInfo) {
        TbPageContext<WriteMultiImgsActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048580, this, z, writeImagesInfo) == null) && (tbPageContext = this.i) != null && tbPageContext.getOrignalPage() != null) {
            this.i.getOrignalPage().y1(z, writeImagesInfo);
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) || this.a == i) {
            return;
        }
        this.a = i;
        SkinManager.setBackgroundResource(this.k, R.color.CAM_X0205);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.o.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.o.onChangeSkinType(this.i, i);
        SkinManager.setNavbarTitleColor(this.g, R.color.CAM_X0302, R.color.s_navbar_title_color);
        this.f.setRemoveRes(R.drawable.icon_sticker_delete);
        this.c.n();
        this.d.l();
        Iterator<FragmentTabIndicator> it = this.p.iterator();
        while (it.hasNext()) {
            FragmentTabIndicator next = it.next();
            if (next != null) {
                next.e(i);
            }
        }
        this.h.setDiverColor(SkinManager.getColor(R.color.CAM_X0107));
    }

    public void i(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
            this.f.setVisibility(0);
            try {
                Matrix matrix = new Matrix();
                matrix.postScale(0.6f, 0.6f);
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                th.printStackTrace();
            }
            this.f.b(bitmap, this.n);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.h = (FragmentTabWidget) this.k.findViewById(R.id.obfuscated_res_0x7f0920e8);
            Resources resources = this.i.getResources();
            String[] stringArray = resources.getStringArray(R.array.obfuscated_res_0x7f03000f);
            this.p.clear();
            for (int i = 0; i < stringArray.length; i++) {
                FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.i.getContext());
                fragmentTabIndicator.setText(stringArray[i]);
                fragmentTabIndicator.setTextColorResId(R.color.CAM_X0105);
                fragmentTabIndicator.setTextSize(0, resources.getDimension(R.dimen.obfuscated_res_0x7f07032f));
                fragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
                this.h.addView(fragmentTabIndicator, i);
                this.p.add(fragmentTabIndicator);
            }
            this.h.setDiverColor(SkinManager.getColor(R.color.CAM_X0107));
            this.h.setCurrentTab(this.j, true, false);
            this.h.setDviderRectWidth(yi.g(this.i.getContext(), R.dimen.obfuscated_res_0x7f070258));
            this.h.setTabSelectionListener(new c(this));
        }
    }

    public final void m() {
        Resources resources;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.e = (BdBaseViewPager) this.k.findViewById(R.id.obfuscated_res_0x7f09277f);
            this.f = (StickerLayout) this.k.findViewById(R.id.obfuscated_res_0x7f092052);
            if (this.i.getResources() == null) {
                resources = TbadkCoreApplication.getInst().getResources();
            } else {
                resources = this.i.getResources();
            }
            NavigationBar navigationBar = (NavigationBar) this.k.findViewById(R.id.obfuscated_res_0x7f09277e);
            this.o = navigationBar;
            navigationBar.setCenterTextTitle(resources.getString(R.string.obfuscated_res_0x7f0f0efe));
            this.o.showBottomLine();
            this.g = this.o.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(R.string.obfuscated_res_0x7f0f0518));
            this.o.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            FrameLayout frameLayout = (FrameLayout) this.k.findViewById(R.id.obfuscated_res_0x7f0908a0);
            t89 t89Var = new t89(this.i);
            this.c = t89Var;
            t89Var.o(new b(this));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.setMargins(0, yi.g(this.i.getContext(), R.dimen.obfuscated_res_0x7f070215), 0, 0);
            this.c.k().setLayoutParams(layoutParams);
            frameLayout.addView(this.c.k());
            s89 s89Var = new s89(this.i);
            this.d = s89Var;
            frameLayout.addView(s89Var.k());
            this.d.k().setVisibility(8);
            l();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.c.l();
        }
    }

    public void o() {
        StickerLayout stickerLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (stickerLayout = this.f) != null) {
            stickerLayout.f(null);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.b == null) {
                lv4 lv4Var = new lv4(this.i.getPageActivity());
                this.b = lv4Var;
                lv4Var.setMessageId(R.string.obfuscated_res_0x7f0f0d89);
                this.b.setPositiveButton(R.string.alert_yes_button, new d(this));
                this.b.setNegativeButton(R.string.obfuscated_res_0x7f0f037c, new e(this));
                this.b.create(this.i);
            }
            this.b.show();
        }
    }
}
