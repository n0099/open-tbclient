package com.baidu.tieba.ala.personcenter.privilege.entereffect;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.baidu.ala.widget.multicolumn.absView.AbsFragment;
import com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class AlaPrivilegeFragmentAdapter extends AbsTabPagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinkedList<AbsFragment> f14282a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaPrivilegeFragmentAdapter(FragmentManager fragmentManager, LinkedList<AbsFragment> linkedList) {
        super(fragmentManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentManager, linkedList};
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
        this.f14282a = new LinkedList<>();
        if (ListUtils.isEmpty(linkedList)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f14282a)) {
            this.f14282a.clear();
        }
        this.f14282a.addAll(linkedList);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ListUtils.getCount(this.f14282a) : invokeV.intValue;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? (AbsFragment) ListUtils.getItem(this.f14282a, i2) : (Fragment) invokeI.objValue;
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public int getPageType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? i2 : invokeI.intValue;
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public String getTabTitle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? (i2 < 0 || i2 >= this.f14282a.size()) ? "" : this.f14282a.get(i2).getTabTitle() : (String) invokeI.objValue;
    }
}
