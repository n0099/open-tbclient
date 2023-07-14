package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class ci8 implements IAdBaseAsyncController.a, ImagePagerAdapter.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public List<String> c;
    public hz9 d;
    public List<AdvertAppInfo> e;
    public boolean f;
    public zx9 g;
    public boolean h;
    public long i;
    public int j;
    public boolean k;
    public Map<String, ImageUrlData> l;
    public TbPageContext<?> m;

    public ci8(List<String> list, String str, String str2, boolean z, boolean z2, TbPageContext<?> tbPageContext, DragImageView.h hVar, @Nullable Map<String, ImageUrlData> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), tbPageContext, hVar, map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = false;
        this.c = list;
        this.a = str;
        this.b = str2;
        this.f = z2;
        this.m = tbPageContext;
        try {
            hz9 hz9Var = (hz9) uy9.m().i(IAdBaseAsyncController.Type.PIC_PAGE, this);
            this.d = hz9Var;
            if (hz9Var != null) {
                hz9Var.h(tbPageContext, hVar, z);
            }
        } catch (ClassCastException e) {
            if (s05.e()) {
                throw new RuntimeException(e);
            }
        }
        this.l = map;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i)) == null) {
            if (i >= this.c.size()) {
                return null;
            }
            String str = (String) g09.d(this.c, i);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            boolean z = true;
            if (i != this.c.size() - 1) {
                z = false;
            }
            this.k = z;
            hz9 hz9Var = this.d;
            if (hz9Var != null) {
                view2 = hz9Var.b(str, z);
            } else {
                view2 = null;
            }
            if (view2 == null) {
                return null;
            }
            if (view2.getParent() != null && (view2.getParent() instanceof ViewGroup)) {
                ((ViewGroup) view2.getParent()).removeView(view2);
            }
            viewGroup.addView(view2);
            AdvertAppInfo d = this.d.d(str);
            if (d != null && (this.m.getPageActivity() instanceof vj0)) {
                d.s = xj0.b(d.s, (vj0) this.m.getPageActivity(), view2);
            }
            return view2;
        }
        return (View) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.recapp.async.IAdBaseAsyncController.a
    public void b(@Nullable List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.e = list;
            if (!this.h) {
                return;
            }
            f(list);
        }
    }

    public void g(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, advertAppInfo) == null) {
            e(advertAppInfo, g09.i(this.c), true);
            zx9 zx9Var = this.g;
            if (zx9Var != null) {
                zx9Var.a(null);
            }
        }
    }

    public boolean h(int i) {
        InterceptResult invokeI;
        hz9 hz9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            String str = (String) g09.d(this.c, i);
            if (TextUtils.isEmpty(str) || (hz9Var = this.d) == null || !hz9Var.f(str)) {
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void m(int i) {
        hz9 hz9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            String str = (String) g09.d(this.c, i);
            if (!TextUtils.isEmpty(str) && (hz9Var = this.d) != null) {
                hz9Var.j(str);
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public void c(ViewGroup viewGroup, int i) {
        hz9 hz9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i) != null) || i >= this.c.size()) {
            return;
        }
        String str = (String) g09.d(this.c, i);
        if (!TextUtils.isEmpty(str) && (hz9Var = this.d) != null) {
            hz9Var.o(str);
        }
    }

    public void o(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            this.i = j - 1;
            this.j = i;
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            hz9 hz9Var = this.d;
            if (hz9Var == null) {
                return 0;
            }
            return hz9Var.getAdCount();
        }
        return invokeV.intValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    public void k() {
        hz9 hz9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (hz9Var = this.d) != null) {
            hz9Var.onDestroy();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.h = true;
            f(this.e);
        }
    }

    public final void e(@NonNull AdvertAppInfo advertAppInfo, int i, boolean z) {
        int i2;
        hz9 hz9Var;
        hz9 hz9Var2;
        hz9 hz9Var3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048580, this, new Object[]{advertAppInfo, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || !this.f) {
            return;
        }
        if (i < 0 && (hz9Var3 = this.d) != null) {
            hz9Var3.k(advertAppInfo);
            return;
        }
        boolean z2 = false;
        int i3 = g09.i(this.c);
        String f = xx9.f(advertAppInfo);
        if (i >= i3) {
            String str = (String) g09.d(this.c, i3 - 1);
            if (this.d != null && (xx9.j(str) || (!z && this.d.n()))) {
                this.d.k(advertAppInfo);
                return;
            } else if (StringUtils.isNotNull(str) && str.startsWith("####mLiveRoomPageProvider")) {
                TiebaStatic.log(new StatisticItem("c15097").param("obj_type", "a008"));
                hz9 hz9Var4 = this.d;
                if (hz9Var4 != null) {
                    hz9Var4.k(advertAppInfo);
                    return;
                }
                return;
            } else {
                this.k = true;
                i = i3;
                z2 = true;
            }
        }
        if (z2) {
            i2 = this.j + d();
        } else {
            i2 = (int) (i + this.i);
        }
        advertAppInfo.position = i2;
        if (xx9.l(advertAppInfo) && (hz9Var2 = this.d) != null) {
            if (i >= i3) {
                hz9Var2.k(advertAppInfo);
            }
            String str2 = (String) g09.d(this.c, i);
            if (!TextUtils.isEmpty(str2)) {
                this.d.e(str2, advertAppInfo);
                return;
            }
            return;
        }
        g09.b(this.c, f, i);
        String str3 = (String) g09.d(this.c, i);
        if (!TextUtils.isEmpty(str3) && (hz9Var = this.d) != null) {
            hz9Var.e(str3, advertAppInfo);
        }
    }

    public final void f(List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, list) == null) && !g09.e(list) && !g09.e(this.c)) {
            Iterator<AdvertAppInfo> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AdvertAppInfo next = it.next();
                if (next != null) {
                    if (d() == s46.a().c() - 1 && s46.a().g()) {
                        if (!i()) {
                            break;
                        } else if (wg.e(next.f, -1) - 1 <= g09.i(this.c)) {
                            g(next);
                            break;
                        }
                    }
                    e(next, wg.e(next.f, -1) - 1, false);
                    it.remove();
                }
            }
            zx9 zx9Var = this.g;
            if (zx9Var != null) {
                zx9Var.a(null);
            }
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            List<String> list = this.c;
            String str = (String) g09.d(list, list.size() - 1);
            Map<String, ImageUrlData> map = this.l;
            if (map != null && str != null) {
                imageUrlData = map.get(str);
            } else {
                imageUrlData = null;
            }
            if (imageUrlData != null && imageUrlData.overAllIndex == this.j) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void n(@Nullable zx9 zx9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, zx9Var) != null) || !this.f) {
            return;
        }
        AdvertAppInfo.w.set(true);
        this.h = false;
        this.g = zx9Var;
        hz9 hz9Var = this.d;
        if (hz9Var != null) {
            hz9Var.l();
        }
        ix5 ix5Var = new ix5();
        ix5Var.c = this.a;
        ix5Var.d = this.b;
        hz9 hz9Var2 = this.d;
        if (hz9Var2 != null) {
            hz9Var2.g(ix5Var);
        }
    }
}
