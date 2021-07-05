package com.baidu.tieba.enterForum.home;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class EnterForumTabPagerAdapter extends FragmentPagerAdapter implements d.a.r0.b1.n.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<a> f14651e;

    /* renamed from: f  reason: collision with root package name */
    public int f14652f;

    /* renamed from: g  reason: collision with root package name */
    public BaseFragment f14653g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f14654h;

    /* renamed from: i  reason: collision with root package name */
    public FragmentManager f14655i;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Fragment f14656a;

        /* renamed from: b  reason: collision with root package name */
        public String f14657b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f14658c;

        /* renamed from: d  reason: collision with root package name */
        public String f14659d;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterForumTabPagerAdapter(FragmentManager fragmentManager, List<a> list) {
        super(fragmentManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentManager, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((FragmentManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14652f = -1;
        this.f14655i = fragmentManager;
        this.f14651e = list;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BaseFragment baseFragment = this.f14653g;
            if (baseFragment instanceof BaseFragment) {
                return baseFragment.getCurrentPageKey();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f14654h = z;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<a> list = this.f14651e;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            List<a> list = this.f14651e;
            if (list == null || i2 < 0 || i2 >= list.size() || this.f14651e.get(i2) == null) {
                return null;
            }
            return this.f14651e.get(i2).f14656a;
        }
        return (Fragment) invokeI.objValue;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            List<a> list = this.f14651e;
            if (list != null && i2 >= 0 && i2 < list.size() && this.f14651e.get(i2) != null) {
                return this.f14651e.get(i2).hashCode();
            }
            return super.getItemId(i2);
        }
        return invokeI.longValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) ? this.f14655i.getFragments().contains(obj) ? -1 : -2 : invokeL.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            List<a> list = this.f14651e;
            if (list == null || i2 < 0 || i2 >= list.size() || this.f14651e.get(i2) == null) {
                return null;
            }
            return this.f14651e.get(i2).f14657b;
        }
        return (CharSequence) invokeI.objValue;
    }

    @Override // d.a.r0.b1.n.a
    public boolean h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            List<a> list = this.f14651e;
            if (list == null || i2 < 0 || i2 >= list.size() || this.f14651e.get(i2) == null || !(this.f14651e.get(i2).f14656a instanceof EnterForumTabFeedFragment)) {
                return false;
            }
            return this.f14651e.get(i2).f14658c;
        }
        return invokeI.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup, i2, obj) == null) {
            super.setPrimaryItem(viewGroup, i2, obj);
            if (!this.f14654h || (i3 = this.f14652f) == i2) {
                return;
            }
            if (i3 != -1) {
                ((BaseFragment) getItem(i3)).setPrimary(false);
            }
            this.f14652f = i2;
            if (obj instanceof BaseFragment) {
                BaseFragment baseFragment = (BaseFragment) obj;
                baseFragment.setPrimary(true);
                this.f14653g = baseFragment;
            }
        }
    }
}
