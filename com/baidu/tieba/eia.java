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
import com.baidu.tieba.d55;
import com.baidu.tieba.write.write.WriteMultiImgsActivity;
import com.baidu.tieba.write.write.sticker.view.StickerLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class eia {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public d55 b;
    public oha c;
    public nha d;
    public BdBaseViewPager e;
    public StickerLayout f;
    public TextView g;
    public FragmentTabWidget h;
    public TbPageContext<WriteMultiImgsActivity> i;
    public int j;
    public LinearLayout k;
    public List<String> l;
    public WriteImagesInfo m;
    public kla n;
    public NavigationBar o;
    public ArrayList<FragmentTabIndicator> p;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eia a;

        public a(eia eiaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eiaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eiaVar;
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

    /* loaded from: classes5.dex */
    public class b implements zha {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eia a;

        public b(eia eiaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eiaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eiaVar;
        }

        @Override // com.baidu.tieba.zha
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

    /* loaded from: classes5.dex */
    public class c implements FragmentTabWidget.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eia a;

        public c(eia eiaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eiaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eiaVar;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
        public void onTabSelectionChanged(int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                eia eiaVar = this.a;
                if (i == eiaVar.j) {
                    return;
                }
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            StickerLayout stickerLayout = eiaVar.f;
                            if (stickerLayout != null) {
                                stickerLayout.e();
                            }
                            this.a.c.x().setVisibility(8);
                            this.a.d.x().setVisibility(0);
                        }
                    } else {
                        StickerLayout stickerLayout2 = eiaVar.f;
                        if (stickerLayout2 != null) {
                            stickerLayout2.e();
                        }
                        this.a.c.x().setVisibility(8);
                        this.a.d.x().setVisibility(0);
                    }
                } else {
                    eiaVar.c.x().setVisibility(0);
                    this.a.d.x().setVisibility(8);
                    if (ListUtils.isEmpty(this.a.l)) {
                        if (this.a.n != null) {
                            this.a.n.b();
                        }
                    } else {
                        eia eiaVar2 = this.a;
                        eiaVar2.c.z(eiaVar2.l);
                    }
                }
                eia eiaVar3 = this.a;
                eiaVar3.j = i;
                eiaVar3.h.setCurrentTab(this.a.j, true, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements d55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eia a;

        public d(eia eiaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eiaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eiaVar;
        }

        @Override // com.baidu.tieba.d55.e
        public void onClick(d55 d55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d55Var) == null) {
                if (this.a.b != null) {
                    this.a.b.dismiss();
                }
                this.a.j(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements d55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eia a;

        public e(eia eiaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eiaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eiaVar;
        }

        @Override // com.baidu.tieba.d55.e
        public void onClick(d55 d55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d55Var) == null) {
                if (this.a.b != null) {
                    this.a.b.dismiss();
                }
                this.a.j(false);
            }
        }
    }

    public eia(TbPageContext<WriteMultiImgsActivity> tbPageContext, kla klaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, klaVar};
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
        this.n = klaVar;
        this.k = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0a08, (ViewGroup) null);
        m();
    }

    public void a(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.l = list;
            this.c.z(list);
        }
    }

    public final void j(boolean z) {
        TbPageContext<WriteMultiImgsActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (tbPageContext = this.i) != null && tbPageContext.getOrignalPage() != null) {
            this.i.getOrignalPage().z1(z, this.m);
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
            this.i.getOrignalPage().z1(z, writeImagesInfo);
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
        this.c.a();
        this.d.a();
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
            this.h = (FragmentTabWidget) this.k.findViewById(R.id.obfuscated_res_0x7f0922ac);
            Resources resources = this.i.getResources();
            String[] stringArray = resources.getStringArray(R.array.obfuscated_res_0x7f030010);
            this.p.clear();
            for (int i = 0; i < stringArray.length; i++) {
                FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.i.getContext());
                fragmentTabIndicator.setText(stringArray[i]);
                fragmentTabIndicator.setTextColorResId(R.color.CAM_X0105);
                fragmentTabIndicator.setTextSize(0, resources.getDimension(R.dimen.obfuscated_res_0x7f070454));
                fragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
                this.h.addView(fragmentTabIndicator, i);
                this.p.add(fragmentTabIndicator);
            }
            this.h.setDiverColor(SkinManager.getColor(R.color.CAM_X0107));
            this.h.setCurrentTab(this.j, true, false);
            this.h.setDviderRectWidth(wi.g(this.i.getContext(), R.dimen.obfuscated_res_0x7f070258));
            this.h.setTabSelectionListener(new c(this));
        }
    }

    public final void m() {
        Resources resources;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.e = (BdBaseViewPager) this.k.findViewById(R.id.obfuscated_res_0x7f09299d);
            this.f = (StickerLayout) this.k.findViewById(R.id.obfuscated_res_0x7f09220c);
            if (this.i.getResources() == null) {
                resources = TbadkCoreApplication.getInst().getResources();
            } else {
                resources = this.i.getResources();
            }
            NavigationBar navigationBar = (NavigationBar) this.k.findViewById(R.id.obfuscated_res_0x7f09299c);
            this.o = navigationBar;
            navigationBar.setCenterTextTitle(resources.getString(R.string.obfuscated_res_0x7f0f106f));
            this.o.showBottomLine();
            this.g = this.o.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(R.string.obfuscated_res_0x7f0f05a1));
            this.o.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            FrameLayout frameLayout = (FrameLayout) this.k.findViewById(R.id.obfuscated_res_0x7f09095c);
            oha ohaVar = new oha(this.i);
            this.c = ohaVar;
            ohaVar.A(new b(this));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.setMargins(0, wi.g(this.i.getContext(), R.dimen.obfuscated_res_0x7f070215), 0, 0);
            this.c.x().setLayoutParams(layoutParams);
            frameLayout.addView(this.c.x());
            nha nhaVar = new nha(this.i);
            this.d = nhaVar;
            frameLayout.addView(nhaVar.x());
            this.d.x().setVisibility(8);
            l();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.c.y();
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
                d55 d55Var = new d55(this.i.getPageActivity());
                this.b = d55Var;
                d55Var.setMessageId(R.string.obfuscated_res_0x7f0f0ed2);
                this.b.setPositiveButton(R.string.alert_yes_button, new d(this));
                this.b.setNegativeButton(R.string.obfuscated_res_0x7f0f03ca, new e(this));
                this.b.create(this.i);
            }
            this.b.show();
        }
    }
}
