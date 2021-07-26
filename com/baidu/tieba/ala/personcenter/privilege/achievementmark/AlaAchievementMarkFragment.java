package com.baidu.tieba.ala.personcenter.privilege.achievementmark;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.widget.multicolumn.absView.AbsFragment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.message.AlaAchievementMarkResponsedMessage;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaPersonCenterPrivilegeMarkModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.j;
import d.a.p0.f0.g;
import d.a.q0.v.j.g.c.a;
import d.a.q0.v.j.g.c.d.a;
/* loaded from: classes4.dex */
public class AlaAchievementMarkFragment extends AbsFragment {
    public static /* synthetic */ Interceptable $ic;
    public static final String l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.v.j.g.c.d.a f14328e;

    /* renamed from: f  reason: collision with root package name */
    public AlaPersonCenterPrivilegeMarkModel f14329f;

    /* renamed from: g  reason: collision with root package name */
    public g f14330g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.v.j.g.c.a f14331h;

    /* renamed from: i  reason: collision with root package name */
    public AlaPersonCenterPrivilegeMarkModel.b f14332i;
    public View.OnClickListener j;
    public a.c k;

    /* loaded from: classes4.dex */
    public class a implements a.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaAchievementMarkFragment f14333a;

        public a(AlaAchievementMarkFragment alaAchievementMarkFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaAchievementMarkFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14333a = alaAchievementMarkFragment;
        }

        @Override // d.a.q0.v.j.g.c.a.i
        public void a(boolean z, d.a.q0.v.j.g.c.c.b bVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZL(1048576, this, z, bVar) == null) && z) {
                this.f14333a.Q0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AlaPersonCenterPrivilegeMarkModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaAchievementMarkFragment f14334a;

        public b(AlaAchievementMarkFragment alaAchievementMarkFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaAchievementMarkFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14334a = alaAchievementMarkFragment;
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaPersonCenterPrivilegeMarkModel.b
        public void a(int i2, String str, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, obj) == null) {
                this.f14334a.l();
                if (i2 != 0 && !StringUtils.isNull(str)) {
                    if (this.f14334a.f14328e != null) {
                        if (j.z()) {
                            this.f14334a.f14328e.h(R.drawable.pic_live_empty04, R.string.ala_net_data_error_fail_tip, false, null);
                        } else {
                            this.f14334a.f14328e.h(R.drawable.pic_live_empty03, R.string.ala_net_fail_tip, true, this.f14334a.j);
                        }
                        this.f14334a.f14328e.g(null, null);
                    }
                } else if (obj == null) {
                    this.f14334a.f14328e.g(null, null);
                } else if (obj instanceof AlaAchievementMarkResponsedMessage) {
                    AlaAchievementMarkResponsedMessage alaAchievementMarkResponsedMessage = (AlaAchievementMarkResponsedMessage) obj;
                    if (this.f14334a.f14328e != null) {
                        this.f14334a.f14328e.d();
                        this.f14334a.f14328e.g(alaAchievementMarkResponsedMessage.getAlaUserInfoData(), alaAchievementMarkResponsedMessage.getList());
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaAchievementMarkFragment f14335e;

        public c(AlaAchievementMarkFragment alaAchievementMarkFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaAchievementMarkFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14335e = alaAchievementMarkFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    this.f14335e.Q0();
                    return;
                }
                AlaAchievementMarkFragment alaAchievementMarkFragment = this.f14335e;
                alaAchievementMarkFragment.showToast(alaAchievementMarkFragment.getResources().getString(R.string.no_network_guide));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaAchievementMarkFragment f14336a;

        public d(AlaAchievementMarkFragment alaAchievementMarkFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaAchievementMarkFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14336a = alaAchievementMarkFragment;
        }

        @Override // d.a.q0.v.j.g.c.d.a.c
        public void a(d.a.q0.v.j.g.c.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-782850346, "Lcom/baidu/tieba/ala/personcenter/privilege/achievementmark/AlaAchievementMarkFragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-782850346, "Lcom/baidu/tieba/ala/personcenter/privilege/achievementmark/AlaAchievementMarkFragment;");
                return;
            }
        }
        l = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_achievement_mark_fragment_title);
    }

    public AlaAchievementMarkFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f14332i = new b(this);
        this.j = new c(this);
        this.k = new d(this);
    }

    public final void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f14329f == null) {
                this.f14329f = new AlaPersonCenterPrivilegeMarkModel(BdUniqueId.gen(), this.f14332i);
            }
            this.f14329f.y();
        }
    }

    public final void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f14330g == null) {
                this.f14330g = new g(getPageContext().getPageActivity(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
            }
            d.a.q0.v.j.g.c.d.a aVar = this.f14328e;
            if (aVar == null || aVar.c() == null) {
                return;
            }
            this.f14330g.attachView(this.f14328e.c(), false);
        }
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsFragment
    public int getPageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsFragment
    public String getTabTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? l : (String) invokeV.objValue;
    }

    public final void l() {
        d.a.q0.v.j.g.c.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f14330g == null || (aVar = this.f14328e) == null || aVar.c() == null) {
            return;
        }
        this.f14330g.dettachView(this.f14328e.c());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.onChangeSkinType(i2);
            g gVar = this.f14330g;
            if (gVar != null) {
                gVar.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f14328e = new d.a.q0.v.j.g.c.d.a(getPageContext(), this.k);
            R0();
            Q0();
            this.f14331h = new d.a.q0.v.j.g.c.a(getPageContext(), new a(this));
            return this.f14328e.c();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            AlaPersonCenterPrivilegeMarkModel alaPersonCenterPrivilegeMarkModel = this.f14329f;
            if (alaPersonCenterPrivilegeMarkModel != null) {
                alaPersonCenterPrivilegeMarkModel.destory();
            }
            d.a.q0.v.j.g.c.a aVar = this.f14331h;
            if (aVar != null) {
                aVar.p();
            }
            l();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                TiebaStatic.log("c13334");
            }
        }
    }
}
