package com.baidu.tieba.ala.personcenter.privilege.achievementmark;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.j;
import b.a.q0.g0.g;
import b.a.r0.w.l.g.c.c.a;
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
/* loaded from: classes8.dex */
public class AlaAchievementMarkFragment extends AbsFragment {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MARK_STATUS_EXPIRED = 3;
    public static final int MARK_STATUS_UNLOCKED = 0;
    public static final int MARK_STATUS_UNWEARED = 2;
    public static final int MARK_STATUS_WEARED = 1;
    public static final String l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.w.l.g.c.c.a f48053e;

    /* renamed from: f  reason: collision with root package name */
    public AlaPersonCenterPrivilegeMarkModel f48054f;

    /* renamed from: g  reason: collision with root package name */
    public g f48055g;

    /* renamed from: h  reason: collision with root package name */
    public AchievementMarkDialog f48056h;

    /* renamed from: i  reason: collision with root package name */
    public AlaPersonCenterPrivilegeMarkModel.b f48057i;
    public View.OnClickListener j;
    public a.c k;

    /* loaded from: classes8.dex */
    public class a implements AchievementMarkDialog.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaAchievementMarkFragment f48058a;

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
            this.f48058a = alaAchievementMarkFragment;
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.AchievementMarkDialog.i
        public void a(boolean z, b.a.r0.w.l.g.c.b.b bVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZL(1048576, this, z, bVar) == null) && z) {
                this.f48058a.g();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements AlaPersonCenterPrivilegeMarkModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaAchievementMarkFragment f48059a;

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
            this.f48059a = alaAchievementMarkFragment;
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaPersonCenterPrivilegeMarkModel.b
        public void a(int i2, String str, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, obj) == null) {
                this.f48059a.hideLoadingView();
                if (i2 != 0 && !StringUtils.isNull(str)) {
                    if (this.f48059a.f48053e != null) {
                        if (j.z()) {
                            this.f48059a.f48053e.h(R.drawable.pic_live_empty04, R.string.ala_net_data_error_fail_tip, false, null);
                        } else {
                            this.f48059a.f48053e.h(R.drawable.pic_live_empty03, R.string.ala_net_fail_tip, true, this.f48059a.j);
                        }
                        this.f48059a.f48053e.g(null, null);
                    }
                } else if (obj == null) {
                    this.f48059a.f48053e.g(null, null);
                } else if (obj instanceof AlaAchievementMarkResponsedMessage) {
                    AlaAchievementMarkResponsedMessage alaAchievementMarkResponsedMessage = (AlaAchievementMarkResponsedMessage) obj;
                    if (this.f48059a.f48053e != null) {
                        this.f48059a.f48053e.d();
                        this.f48059a.f48053e.g(alaAchievementMarkResponsedMessage.getAlaUserInfoData(), alaAchievementMarkResponsedMessage.getList());
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaAchievementMarkFragment f48060e;

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
            this.f48060e = alaAchievementMarkFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    this.f48060e.g();
                    return;
                }
                AlaAchievementMarkFragment alaAchievementMarkFragment = this.f48060e;
                alaAchievementMarkFragment.showToast(alaAchievementMarkFragment.getResources().getString(R.string.no_network_guide));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // b.a.r0.w.l.g.c.c.a.c
        public void a(b.a.r0.w.l.g.c.b.b bVar) {
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
        this.f48057i = new b(this);
        this.j = new c(this);
        this.k = new d(this);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f48054f == null) {
                this.f48054f = new AlaPersonCenterPrivilegeMarkModel(BdUniqueId.gen(), this.f48057i);
            }
            this.f48054f.y();
        }
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsFragment
    public int getPageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsFragment
    public String getTabTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? l : (String) invokeV.objValue;
    }

    public final void hideLoadingView() {
        b.a.r0.w.l.g.c.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f48055g == null || (aVar = this.f48053e) == null || aVar.c() == null) {
            return;
        }
        this.f48055g.dettachView(this.f48053e.c());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            super.onChangeSkinType(i2);
            g gVar = this.f48055g;
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
            this.f48053e = new b.a.r0.w.l.g.c.c.a(getPageContext(), this.k);
            showLoadingView();
            g();
            this.f48056h = new AchievementMarkDialog(getPageContext(), new a(this));
            return this.f48053e.c();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            AlaPersonCenterPrivilegeMarkModel alaPersonCenterPrivilegeMarkModel = this.f48054f;
            if (alaPersonCenterPrivilegeMarkModel != null) {
                alaPersonCenterPrivilegeMarkModel.destory();
            }
            AchievementMarkDialog achievementMarkDialog = this.f48056h;
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
            if (this.f48055g == null) {
                this.f48055g = new g(getPageContext().getPageActivity(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
            }
            b.a.r0.w.l.g.c.c.a aVar = this.f48053e;
            if (aVar == null || aVar.c() == null) {
                return;
            }
            this.f48055g.attachView(this.f48053e.c(), false);
        }
    }
}
