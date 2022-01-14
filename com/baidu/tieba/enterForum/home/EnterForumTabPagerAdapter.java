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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class EnterForumTabPagerAdapter extends FragmentPagerAdapter implements c.a.s0.g1.o.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<a> f42563e;

    /* renamed from: f  reason: collision with root package name */
    public int f42564f;

    /* renamed from: g  reason: collision with root package name */
    public BaseFragment f42565g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f42566h;

    /* renamed from: i  reason: collision with root package name */
    public FragmentManager f42567i;

    /* loaded from: classes12.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Fragment a;

        /* renamed from: b  reason: collision with root package name */
        public String f42568b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f42569c;

        /* renamed from: d  reason: collision with root package name */
        public String f42570d;

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
    public EnterForumTabPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentManager};
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
        this.f42564f = -1;
        this.f42567i = fragmentManager;
        this.f42563e = new ArrayList();
    }

    public void add(a aVar) {
        List<a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (list = this.f42563e) == null || aVar == null) {
            return;
        }
        list.add(aVar);
        notifyDataSetChanged();
    }

    public void addAll(List<a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || this.f42563e == null || list == null || list.size() <= 0) {
            return;
        }
        this.f42563e.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<a> list = this.f42563e;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            BaseFragment baseFragment = this.f42565g;
            if (baseFragment instanceof BaseFragment) {
                return baseFragment.getCurrentPageKey();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            List<a> list = this.f42563e;
            if (list == null || i2 < 0 || i2 >= list.size() || this.f42563e.get(i2) == null) {
                return null;
            }
            return this.f42563e.get(i2).a;
        }
        return (Fragment) invokeI.objValue;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            List<a> list = this.f42563e;
            if (list != null && i2 >= 0 && i2 < list.size() && this.f42563e.get(i2) != null) {
                return this.f42563e.get(i2).hashCode();
            }
            return super.getItemId(i2);
        }
        return invokeI.longValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) ? this.f42567i.getFragments().contains(obj) ? -1 : -2 : invokeL.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            List<a> list = this.f42563e;
            if (list == null || i2 < 0 || i2 >= list.size() || this.f42563e.get(i2) == null) {
                return null;
            }
            return this.f42563e.get(i2).f42568b;
        }
        return (CharSequence) invokeI.objValue;
    }

    public void setPrimary(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f42566h = z;
        }
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048587, this, viewGroup, i2, obj) == null) {
            super.setPrimaryItem(viewGroup, i2, obj);
            if (!this.f42566h || (i3 = this.f42564f) == i2) {
                return;
            }
            if (i3 != -1) {
                ((BaseFragment) getItem(i3)).setPrimary(false);
            }
            this.f42564f = i2;
            if (obj instanceof BaseFragment) {
                BaseFragment baseFragment = (BaseFragment) obj;
                baseFragment.setPrimary(true);
                this.f42565g = baseFragment;
            }
        }
    }

    @Override // c.a.s0.g1.o.a
    public boolean showRedDot(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            List<a> list = this.f42563e;
            if (list == null || i2 < 0 || i2 >= list.size() || this.f42563e.get(i2) == null || !(this.f42563e.get(i2).a instanceof EnterForumTabFeedFragment)) {
                return false;
            }
            return this.f42563e.get(i2).f42569c;
        }
        return invokeI.booleanValue;
    }

    public void add(a aVar, int i2) {
        List<a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, i2) == null) || (list = this.f42563e) == null || aVar == null || i2 < 0 || i2 > list.size() || aVar.a.isAdded()) {
            return;
        }
        this.f42563e.add(i2, aVar);
        notifyDataSetChanged();
    }

    public void addAll(List<a> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, list, i2) == null) || this.f42563e == null || list == null || list.size() <= 0 || i2 < 0 || i2 > this.f42563e.size()) {
            return;
        }
        this.f42563e.addAll(i2, list);
        notifyDataSetChanged();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterForumTabPagerAdapter(FragmentManager fragmentManager, List<a> list) {
        super(fragmentManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentManager, list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((FragmentManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f42564f = -1;
        this.f42567i = fragmentManager;
        this.f42563e = list;
    }
}
