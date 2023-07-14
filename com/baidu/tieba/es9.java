package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.ds9;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.personPolymeric.event.PersonPolymericEventController;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.wn9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.Profile.NicknameInfo;
/* loaded from: classes5.dex */
public class es9 extends cs9 implements gt9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity b;
    public BaseFragment c;
    public TbPageContext d;
    public final View e;
    public final BdUniqueId f;
    public long g;
    public String h;
    public ds9 i;
    public final PersonPolymericModel j;
    public final bs9 k;
    public final BlackListModel l;
    public is9 m;
    public gu6 n;
    public PersonPolymericEventController o;
    public fs9 p;
    public int q;
    public boolean r;
    public final ds9.e s;
    public CustomMessageListener t;

    public gs9 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (gs9) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements ds9.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ es9 a;

        public a(es9 es9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {es9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = es9Var;
        }

        @Override // com.baidu.tieba.ds9.e
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ es9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(es9 es9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {es9Var, Integer.valueOf(i)};
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
            this.a = es9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.b();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements wn9.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ es9 a;

        public c(es9 es9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {es9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = es9Var;
        }

        @Override // com.baidu.tieba.wn9.c
        public void a(int i, String str, ImageUploadResult imageUploadResult) {
            ImageUploadResult.PicDetailedInfo picDetailedInfo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, imageUploadResult) == null) && i == 0 && imageUploadResult != null) {
                String str2 = null;
                ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
                if (picinfo != null && (picDetailedInfo = picinfo.bigPic) != null) {
                    str2 = picDetailedInfo.picUrl;
                }
                hs9.a(str2, this.a.q());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public es9(BaseFragment baseFragment, View view2, BdUniqueId bdUniqueId, long j, boolean z, boolean z2, String str) {
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
        this.k = new bs9(this.c.getPageContext(), bdUniqueId);
        ds9 ds9Var = new ds9(this.c.getPageContext(), view2, z);
        this.i = ds9Var;
        ds9Var.s(this.s);
        this.o = new PersonPolymericEventController(this.d, this);
        PersonPolymericModel personPolymericModel = new PersonPolymericModel(this.b, bdUniqueId, z);
        this.j = personPolymericModel;
        personPolymericModel.m0(new ys9(z));
        this.j.k0(this);
        this.j.l0(this.k);
        this.l = new BlackListModel(this.b.getPageContext(), bdUniqueId);
        if (StringUtils.isNull(this.h)) {
            is9 is9Var = new is9(this.c, this, this.f, this.g, z);
            this.m = is9Var;
            is9Var.j(TbadkCoreApplication.getInst().getSkinType());
            this.m.i(this.o);
        }
        this.p = new fs9(this.d, this.k, this.l, bdUniqueId);
        a();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!TbadkCoreApplication.isLogin() && this.a) {
                this.i.B();
            } else if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                yq9.d().m(System.currentTimeMillis());
                this.i.x(false, -1);
                this.i.C(true);
                this.j.i0(this.g);
                this.j.h0(this.g, this.h);
            } else {
                this.i.m();
                this.i.r(8);
                this.i.y(this.c.getString(R.string.obfuscated_res_0x7f0f0e1f), true);
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!TbadkCoreApplication.isLogin() && this.a) {
                this.i.B();
            } else if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                this.j.h0(this.g, this.h);
            } else {
                this.i.m();
                yi.R(this.d.getContext(), this.d.getString(R.string.data_load_error));
                ArrayList arrayList = new ArrayList();
                rs9 rs9Var = new rs9();
                rs9Var.a = this.a;
                arrayList.add(rs9Var);
                this.i.l();
                this.i.u(arrayList);
                this.i.z();
            }
        }
    }

    @Override // com.baidu.tieba.gt9
    public void d(js9 js9Var) {
        NicknameInfo nicknameInfo;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, js9Var) == null) {
            if (js9Var != null && js9Var.j() != null && !StringUtils.isNull(this.h)) {
                this.g = js9Var.j().getUserIdLong();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921443, Long.valueOf(this.g)));
                if (this.g == wg.g(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                    z = true;
                } else {
                    z = false;
                }
                this.a = z;
            }
            this.i.m();
            fs9 fs9Var = this.p;
            if (fs9Var != null) {
                fs9Var.h(js9Var);
            }
            if (js9Var != null) {
                this.i.j(js9Var);
            }
            is9 is9Var = this.m;
            if (is9Var != null) {
                is9Var.n(js9Var);
            } else {
                is9 is9Var2 = new is9(this.c, this, this.f, this.g, this.a);
                this.m = is9Var2;
                is9Var2.j(TbadkCoreApplication.getInst().getSkinType());
                this.m.i(this.o);
                this.m.n(js9Var);
            }
            if (this.r && js9Var != null && (nicknameInfo = js9Var.A) != null && nicknameInfo.left_days != null && js9Var.j() != null) {
                PersonChangeData personChangeData = new PersonChangeData();
                personChangeData.setMem(js9Var.j().getIsMem());
                personChangeData.setNickNameLeftDays(js9Var.A.left_days.intValue());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921061, personChangeData));
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            new wn9().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new c(this));
        }
    }

    public ds9 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.i;
        }
        return (ds9) invokeV.objValue;
    }

    public fs9 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.p;
        }
        return (fs9) invokeV.objValue;
    }

    public zr9 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.m;
        }
        return (zr9) invokeV.objValue;
    }

    public PersonPolymericModel p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.j;
        }
        return (PersonPolymericModel) invokeV.objValue;
    }

    public List<yn> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.j.g0() == null) {
                return null;
            }
            return this.j.g0().k();
        }
        return (List) invokeV.objValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.t);
            is9 is9Var = this.m;
            if (is9Var != null) {
                is9Var.k();
            }
            PersonPolymericModel personPolymericModel = this.j;
            if (personPolymericModel != null) {
                personPolymericModel.destroy();
            }
        }
    }

    public void u() {
        is9 is9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (is9Var = this.m) != null) {
            is9Var.m();
        }
    }

    public boolean j(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || xi.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            if (!da5.p().l(da5.t(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
                return false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.b).createNormalConfig("from_person", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return invokeL.booleanValue;
    }

    public js9 o(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            if (z) {
                this.r = z;
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    this.j.h0(this.g, this.h);
                }
            }
            return this.j.g0();
        }
        return (js9) invokeZ.objValue;
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048588, this, i) != null) || this.q == i) {
            return;
        }
        is9 is9Var = this.m;
        if (is9Var != null) {
            is9Var.j(i);
        }
        this.q = i;
    }

    public void t(boolean z) {
        is9 is9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && (is9Var = this.m) != null) {
            is9Var.l(z);
        }
    }

    public void x(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, postWriteCallBackData) == null) {
            if (this.n == null) {
                this.n = new gu6(this.b.getPageContext(), (NavigationBarCoverTip) this.b.findViewById(R.id.obfuscated_res_0x7f0918c9));
            }
            this.n.l(postWriteCallBackData);
        }
    }
}
