package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.cv9;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.event.PersonPolymericEventController;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.vq9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.Profile.NicknameInfo;
/* loaded from: classes5.dex */
public class dv9 extends bv9 implements fw9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity b;
    public BaseFragment c;
    public TbPageContext d;
    public final View e;
    public final BdUniqueId f;
    public long g;
    public String h;
    public cv9 i;
    public final PersonPolymericModel j;
    public final av9 k;
    public final BlackListModel l;
    public hv9 m;
    public ws6 n;
    public PersonPolymericEventController o;
    public ev9 p;
    public int q;
    public boolean r;
    public final cv9.e s;
    public CustomMessageListener t;

    public fv9 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (fv9) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements cv9.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv9 a;

        public a(dv9 dv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv9Var;
        }

        @Override // com.baidu.tieba.cv9.e
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.b();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(dv9 dv9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv9Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.a();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements vq9.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv9 a;

        public c(dv9 dv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv9Var;
        }

        @Override // com.baidu.tieba.vq9.c
        public void a(int i, String str, ImageUploadResult imageUploadResult) {
            ImageUploadResult.PicDetailedInfo picDetailedInfo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, imageUploadResult) == null) && i == 0 && imageUploadResult != null) {
                String str2 = null;
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null && (picDetailedInfo = picinfo.bigPic) != null) {
                    str2 = picDetailedInfo.picUrl;
                }
                gv9.a(str2, this.a.q());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dv9(BaseFragment baseFragment, View view2, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, view2, bdUniqueId, Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = 3;
        this.r = false;
        this.s = new a(this);
        this.t = new b(this, 2921424);
        this.c = baseFragment;
        BaseFragmentActivity baseFragmentActivity = baseFragment.getBaseFragmentActivity();
        this.b = baseFragmentActivity;
        this.e = view2;
        this.f = bdUniqueId;
        this.g = j;
        this.h = str;
        this.d = baseFragmentActivity.getPageContext();
        MessageManager.getInstance().registerListener(this.t);
        this.k = new av9(this.c.getPageContext(), bdUniqueId);
        cv9 cv9Var = new cv9(this.c.getPageContext(), view2, z);
        this.i = cv9Var;
        cv9Var.s(this.s);
        this.o = new PersonPolymericEventController(this.d, this);
        PersonPolymericModel personPolymericModel = new PersonPolymericModel(this.b, bdUniqueId, z);
        this.j = personPolymericModel;
        personPolymericModel.e0(new xv9(z));
        this.j.c0(this);
        this.j.d0(this.k);
        this.l = new BlackListModel(this.b.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.h)) {
            hv9 hv9Var = new hv9(this.c, this, this.f, this.g, z);
            this.m = hv9Var;
            hv9Var.j(TbadkCoreApplication.getInst().getSkinType());
            this.m.i(this.o);
        }
        this.p = new ev9(this.d, this.k, this.l, bdUniqueId);
        b();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!TbadkCoreApplication.isLogin() && this.a) {
                this.i.B();
            } else if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                this.j.Z(this.g, this.h);
            } else {
                this.i.m();
                BdUtilHelper.showToast(this.d.getContext(), this.d.getString(R.string.data_load_error));
                ArrayList arrayList = new ArrayList();
                qv9 qv9Var = new qv9();
                qv9Var.a = this.a;
                arrayList.add(qv9Var);
                this.i.l();
                this.i.u(arrayList);
                this.i.z();
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!TbadkCoreApplication.isLogin() && this.a) {
                this.i.B();
            } else if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                xt9.d().m(System.currentTimeMillis());
                this.i.x(false, -1);
                this.i.C(true);
                this.j.a0(this.g);
                this.j.Z(this.g, this.h);
            } else {
                this.i.m();
                this.i.r(8);
                this.i.y(this.c.getString(R.string.obfuscated_res_0x7f0f0e29), true);
            }
        }
    }

    @Override // com.baidu.tieba.fw9
    public void d(iv9 iv9Var) {
        NicknameInfo nicknameInfo;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iv9Var) == null) {
            if (iv9Var != null && iv9Var.j() != null && !StringUtils.isNull(this.h)) {
                this.g = iv9Var.j().getUserIdLong();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.g)));
                if (this.g == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                    z = true;
                } else {
                    z = false;
                }
                this.a = z;
            }
            this.i.m();
            ev9 ev9Var = this.p;
            if (ev9Var != null) {
                ev9Var.h(iv9Var);
            }
            if (iv9Var != null) {
                this.i.j(iv9Var);
            }
            hv9 hv9Var = this.m;
            if (hv9Var != null) {
                hv9Var.n(iv9Var);
            } else {
                hv9 hv9Var2 = new hv9(this.c, this, this.f, this.g, this.a);
                this.m = hv9Var2;
                hv9Var2.j(TbadkCoreApplication.getInst().getSkinType());
                this.m.i(this.o);
                this.m.n(iv9Var);
            }
            if (this.r && iv9Var != null && (nicknameInfo = iv9Var.A) != null && nicknameInfo.left_days != null && iv9Var.j() != null) {
                PersonChangeData personChangeData = new PersonChangeData();
                personChangeData.setMem(iv9Var.j().getIsMem());
                personChangeData.setNickNameLeftDays(iv9Var.A.left_days.intValue());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            new vq9().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new c(this));
        }
    }

    public cv9 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.i;
        }
        return (cv9) invokeV.objValue;
    }

    public ev9 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.p;
        }
        return (ev9) invokeV.objValue;
    }

    public yu9 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.m;
        }
        return (yu9) invokeV.objValue;
    }

    public PersonPolymericModel p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.j;
        }
        return (PersonPolymericModel) invokeV.objValue;
    }

    public List<bn> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.j.Y() == null) {
                return null;
            }
            return this.j.Y().k();
        }
        return (List) invokeV.objValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.t);
            hv9 hv9Var = this.m;
            if (hv9Var != null) {
                hv9Var.k();
            }
            PersonPolymericModel personPolymericModel = this.j;
            if (personPolymericModel != null) {
                personPolymericModel.destroy();
            }
        }
    }

    public void u() {
        hv9 hv9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (hv9Var = this.m) != null) {
            hv9Var.m();
        }
    }

    public boolean j(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || di.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
                return false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.b).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return invokeL.booleanValue;
    }

    public iv9 o(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            if (z) {
                this.r = z;
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    this.j.Z(this.g, this.h);
                }
            }
            return this.j.Y();
        }
        return (iv9) invokeZ.objValue;
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048588, this, i) != null) || this.q == i) {
            return;
        }
        hv9 hv9Var = this.m;
        if (hv9Var != null) {
            hv9Var.j(i);
        }
        this.q = i;
    }

    public void t(boolean z) {
        hv9 hv9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && (hv9Var = this.m) != null) {
            hv9Var.l(z);
        }
    }

    public void x(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, postWriteCallBackData) == null) {
            if (this.n == null) {
                this.n = new ws6(this.b.getPageContext(), (NavigationBarCoverTip) this.b.findViewById(R.id.obfuscated_res_0x7f091901));
            }
            this.n.l(postWriteCallBackData);
        }
    }
}
