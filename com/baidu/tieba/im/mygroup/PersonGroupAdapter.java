package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f17599c = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int[] f17600a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<PersonalGroupFragment> f17601b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1416329187, "Lcom/baidu/tieba/im/mygroup/PersonGroupAdapter;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1416329187, "Lcom/baidu/tieba/im/mygroup/PersonGroupAdapter;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personGroupActivity, Boolean.valueOf(z)};
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
        this.f17601b = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.f17601b.add(personalGroupFragment);
        if (z) {
            this.f17600a = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.f17601b.add(personalGroupFragment2);
            this.f17600a = new int[]{0, 1};
        }
        f17599c = this.f17600a.length;
        Iterator<PersonalGroupFragment> it = this.f17601b.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.f17601b.size());
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f17599c : invokeV.intValue;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 >= f17599c || i2 < 0) {
                return null;
            }
            return this.f17601b.get(i2);
        }
        return (Fragment) invokeI.objValue;
    }

    public int i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f17600a[i2] : invokeI.intValue;
    }
}
