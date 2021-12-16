package com.baidu.tieba.ala.personcenter.privilege.achievementmark;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.k;
import c.a.r0.g0.g;
import c.a.s0.a0.l.g.c.c.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.widget.multicolumn.absView.AbsFragment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.AchievementMarkDialog;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.message.AlaAchievementMarkResponsedMessage;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaPersonCenterPrivilegeMarkModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class AlaAchievementMarkFragment extends AbsFragment {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MARK_STATUS_EXPIRED = 3;
    public static final int MARK_STATUS_UNLOCKED = 0;
    public static final int MARK_STATUS_UNWEARED = 2;
    public static final int MARK_STATUS_WEARED = 1;
    public static final String l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.s0.a0.l.g.c.c.a f43507e;

    /* renamed from: f  reason: collision with root package name */
    public AlaPersonCenterPrivilegeMarkModel f43508f;

    /* renamed from: g  reason: collision with root package name */
    public g f43509g;

    /* renamed from: h  reason: collision with root package name */
    public AchievementMarkDialog f43510h;

    /* renamed from: i  reason: collision with root package name */
    public AlaPersonCenterPrivilegeMarkModel.b f43511i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f43512j;

    /* renamed from: k  reason: collision with root package name */
    public a.c f43513k;

    /* loaded from: classes11.dex */
    public class a implements AchievementMarkDialog.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaAchievementMarkFragment a;

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
            this.a = alaAchievementMarkFragment;
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.AchievementMarkDialog.i
        public void a(boolean z, c.a.s0.a0.l.g.c.b.b bVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZL(1048576, this, z, bVar) == null) && z) {
                this.a.i();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements AlaPersonCenterPrivilegeMarkModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaAchievementMarkFragment a;

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
            this.a = alaAchievementMarkFragment;
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaPersonCenterPrivilegeMarkModel.b
        public void a(int i2, String str, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, obj) == null) {
                this.a.hideLoadingView();
                if (i2 != 0 && !StringUtils.isNull(str)) {
                    if (this.a.f43507e != null) {
                        if (k.z()) {
                            this.a.f43507e.h(R.drawable.pic_live_empty04, R.string.ala_net_data_error_fail_tip, false, null);
                        } else {
                            this.a.f43507e.h(R.drawable.pic_live_empty03, R.string.ala_net_fail_tip, true, this.a.f43512j);
                        }
                        this.a.f43507e.g(null, null);
                    }
                } else if (obj == null) {
                    this.a.f43507e.g(null, null);
                } else if (obj instanceof AlaAchievementMarkResponsedMessage) {
                    AlaAchievementMarkResponsedMessage alaAchievementMarkResponsedMessage = (AlaAchievementMarkResponsedMessage) obj;
                    if (this.a.f43507e != null) {
                        this.a.f43507e.d();
                        this.a.f43507e.g(alaAchievementMarkResponsedMessage.getAlaUserInfoData(), alaAchievementMarkResponsedMessage.getList());
                    }
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaAchievementMarkFragment f43514e;

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
            this.f43514e = alaAchievementMarkFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (k.z()) {
                    this.f43514e.i();
                    return;
                }
                AlaAchievementMarkFragment alaAchievementMarkFragment = this.f43514e;
                alaAchievementMarkFragment.showToast(alaAchievementMarkFragment.getResources().getString(R.string.no_network_guide));
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaAchievementMarkFragment a;

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
            this.a = alaAchievementMarkFragment;
        }

        @Override // c.a.s0.a0.l.g.c.c.a.c
        public void a(c.a.s0.a0.l.g.c.b.b bVar) {
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
        this.f43511i = new b(this);
        this.f43512j = new c(this);
        this.f43513k = new d(this);
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsFragment
    public int getPageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsFragment
    public String getTabTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? l : (String) invokeV.objValue;
    }

    public final void hideLoadingView() {
        c.a.s0.a0.l.g.c.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f43509g == null || (aVar = this.f43507e) == null || aVar.c() == null) {
            return;
        }
        this.f43509g.dettachView(this.f43507e.c());
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f43508f == null) {
                this.f43508f = new AlaPersonCenterPrivilegeMarkModel(BdUniqueId.gen(), this.f43511i);
            }
            this.f43508f.y();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            super.onChangeSkinType(i2);
            g gVar = this.f43509g;
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f43507e = new c.a.s0.a0.l.g.c.c.a(getPageContext(), this.f43513k);
            showLoadingView();
            i();
            this.f43510h = new AchievementMarkDialog(getPageContext(), new a(this));
            return this.f43507e.c();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            AlaPersonCenterPrivilegeMarkModel alaPersonCenterPrivilegeMarkModel = this.f43508f;
            if (alaPersonCenterPrivilegeMarkModel != null) {
                alaPersonCenterPrivilegeMarkModel.destory();
            }
            AchievementMarkDialog achievementMarkDialog = this.f43510h;
            if (achievementMarkDialog != null) {
                achievementMarkDialog.onDestroy();
            }
            hideLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                TiebaStatic.log("c13334");
            }
        }
    }

    public final void showLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.f43509g == null) {
                this.f43509g = new g(getPageContext().getPageActivity(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
            }
            c.a.s0.a0.l.g.c.c.a aVar = this.f43507e;
            if (aVar == null || aVar.c() == null) {
                return;
            }
            this.f43509g.attachView(this.f43507e.c(), false);
        }
    }
}
