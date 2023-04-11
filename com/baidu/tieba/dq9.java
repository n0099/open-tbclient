package com.baidu.tieba;

import android.app.Activity;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailThemeData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Pendant;
/* loaded from: classes4.dex */
public class dq9 extends za {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final uo9 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dq9(MainTabActivity mainTabActivity, jo9 jo9Var) {
        super(CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, jo9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mainTabActivity;
        this.b = mainTabActivity.e;
    }

    public final void a() {
        uo9 uo9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (uo9Var = this.b) != null && uo9Var.a() != null && this.a.A == 1) {
            this.b.a().d();
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            MainTabActivity mainTabActivity = this.a;
            if (currentActivity == mainTabActivity && mainTabActivity.B.intValue() != 1) {
                this.b.a().f();
            }
        }
    }

    public final void b(ProfileHttpResponseMessage profileHttpResponseMessage) {
        boolean z;
        boolean z2;
        uo9 uo9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, profileHttpResponseMessage) == null) {
            boolean z3 = true;
            if (profileHttpResponseMessage != null && profileHttpResponseMessage.GetUser() != null) {
                this.a.A = profileHttpResponseMessage.GetUser().my_like_num.intValue();
                if (this.a.A == 1 && (uo9Var = this.b) != null && uo9Var.a() != null) {
                    this.b.a().d();
                    this.b.a().f();
                }
                a();
                ProfileVirtualImageInfo.getInstance().parseProto(profileHttpResponseMessage.GetUser().virtual_image_info);
                TbSingleton.getInstance().setUserSmallTheme(new SmallTailThemeData(profileHttpResponseMessage.GetUser().theme_tail));
                d(profileHttpResponseMessage.GetUser().pendant);
            }
            if (profileHttpResponseMessage != null && profileHttpResponseMessage.getMemberBlockInfo() != null) {
                MainTabActivity mainTabActivity = this.a;
                if (profileHttpResponseMessage.getMemberBlockInfo().is_permanent_ban.intValue() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                mainTabActivity.L = z;
                MainTabActivity mainTabActivity2 = this.a;
                if (profileHttpResponseMessage.getMemberBlockInfo().is_auto_pay.intValue() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                mainTabActivity2.M = z2;
                TbSingleton tbSingleton = TbSingleton.getInstance();
                if (profileHttpResponseMessage.getMemberBlockInfo().is_ban.intValue() != 1) {
                    z3 = false;
                }
                tbSingleton.setUserBan(z3);
            }
        }
    }

    public final void c(ProfileSocketResponseMessage profileSocketResponseMessage) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, profileSocketResponseMessage) == null) {
            boolean z3 = true;
            if (profileSocketResponseMessage != null && profileSocketResponseMessage.GetUser() != null) {
                this.a.A = profileSocketResponseMessage.GetUser().my_like_num.intValue();
                if (this.a.A == 1) {
                    uo9 uo9Var = this.b;
                    if (uo9Var != null && uo9Var.a() != null) {
                        this.b.a().d();
                    }
                    a();
                }
                ProfileVirtualImageInfo.getInstance().parseProto(profileSocketResponseMessage.GetUser().virtual_image_info);
                TbSingleton.getInstance().setUserSmallTheme(new SmallTailThemeData(profileSocketResponseMessage.GetUser().theme_tail));
                d(profileSocketResponseMessage.GetUser().pendant);
            }
            if (profileSocketResponseMessage != null && profileSocketResponseMessage.getMemberBlockInfo() != null) {
                MainTabActivity mainTabActivity = this.a;
                if (profileSocketResponseMessage.getMemberBlockInfo().is_permanent_ban.intValue() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                mainTabActivity.L = z;
                MainTabActivity mainTabActivity2 = this.a;
                if (profileSocketResponseMessage.getMemberBlockInfo().is_auto_pay.intValue() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                mainTabActivity2.M = z2;
                TbSingleton tbSingleton = TbSingleton.getInstance();
                if (profileSocketResponseMessage.getMemberBlockInfo().is_ban.intValue() != 1) {
                    z3 = false;
                }
                tbSingleton.setUserBan(z3);
            }
        }
    }

    public final void d(Pendant pendant) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pendant) == null) {
            UserPendantData userPendantData = new UserPendantData();
            userPendantData.parserProtobuf(pendant);
            TbSingleton.getInstance().setUserPendantData(userPendantData);
        }
    }

    @Override // com.baidu.tieba.za
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, responsedMessage) == null) {
            boolean z = responsedMessage instanceof ProfileSocketResponseMessage;
            if (!z && !(responsedMessage instanceof ProfileHttpResponseMessage)) {
                return;
            }
            if (z) {
                c((ProfileSocketResponseMessage) responsedMessage);
            }
            if (responsedMessage instanceof ProfileHttpResponseMessage) {
                b((ProfileHttpResponseMessage) responsedMessage);
            }
        }
    }
}
