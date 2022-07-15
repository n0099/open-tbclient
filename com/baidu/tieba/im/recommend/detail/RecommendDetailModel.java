package com.baidu.tieba.im.recommend.detail;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bb;
import com.repackage.d9;
import com.repackage.s77;
import com.repackage.za;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes3.dex */
public class RecommendDetailModel extends BdBaseModel<RecommendDetailActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACCEPT_MSG_SWITCH = 1;
    public static final int NEGLECT_MSG_SWITCH = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<RecommendDetailActivity> a;
    public RecommendDetailActivity b;
    public e c;
    public boolean d;
    public boolean e;
    public boolean f;
    public long g;
    public za h;
    public CustomMessageListener i;

    /* loaded from: classes3.dex */
    public class a extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendDetailModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RecommendDetailModel recommendDetailModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendDetailModel, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recommendDetailModel;
        }

        @Override // com.repackage.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.f = true;
                if (this.a.a == null || this.a.c == null) {
                    return;
                }
                if (responsedMessage == null) {
                    this.a.c.onFailed(this.a.a.getString(R.string.obfuscated_res_0x7f0f0c2b));
                } else if (responsedMessage.getError() != 0) {
                    if (TextUtils.isEmpty(responsedMessage.getErrorString())) {
                        this.a.c.onFailed(this.a.a.getString(R.string.obfuscated_res_0x7f0f0c2b));
                    } else {
                        this.a.c.onFailed(responsedMessage.getErrorString());
                    }
                } else {
                    if (responsedMessage instanceof RecommendDetailHttpResponseMessage) {
                        RecommendDetailHttpResponseMessage recommendDetailHttpResponseMessage = (RecommendDetailHttpResponseMessage) responsedMessage;
                        if (recommendDetailHttpResponseMessage.getDetailInfo() != null) {
                            this.a.e = true;
                            this.a.c.W(recommendDetailHttpResponseMessage.getDetailInfo(), true);
                        }
                    }
                    if (responsedMessage instanceof RecommendDetailSocketResponseMessage) {
                        RecommendDetailSocketResponseMessage recommendDetailSocketResponseMessage = (RecommendDetailSocketResponseMessage) responsedMessage;
                        if (recommendDetailSocketResponseMessage.getDetailInfo() != null) {
                            this.a.e = true;
                            this.a.c.W(recommendDetailSocketResponseMessage.getDetailInfo(), true);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends bb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendDetailModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(RecommendDetailModel recommendDetailModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendDetailModel, Integer.valueOf(i)};
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
            this.a = recommendDetailModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage)) {
                ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                Message<?> orginalMessage = responseUpdateMaskInfoMessage.getOrginalMessage();
                if (orginalMessage instanceof RequestUpdateMaskInfoMessage) {
                    RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                    if (requestUpdateMaskInfoMessage.getMaskType() != 6 || this.a.a == null || this.a.c == null) {
                        return;
                    }
                    if (responseUpdateMaskInfoMessage.getError() != 0) {
                        if (StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString())) {
                            this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c2b);
                        } else {
                            this.a.a.showToast(responseUpdateMaskInfoMessage.getErrorString());
                        }
                        if (requestUpdateMaskInfoMessage.getMute()) {
                            this.a.b.D1(requestUpdateMaskInfoMessage.isMuteNotifications());
                            return;
                        } else if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                            this.a.c.W0(false);
                            return;
                        } else {
                            this.a.c.w1(false);
                            return;
                        }
                    }
                    if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                        this.a.c.W0(true);
                    } else {
                        this.a.c.w1(true);
                    }
                    if (requestUpdateMaskInfoMessage.getMaskType() == 6) {
                        this.a.K(requestUpdateMaskInfoMessage.isMuteNotifications());
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendDetailModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(RecommendDetailModel recommendDetailModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendDetailModel, Integer.valueOf(i)};
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
            this.a = recommendDetailModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserInfoBigVip)) {
                    this.a.N();
                    return;
                }
                UserInfoBigVip userInfoBigVip = (UserInfoBigVip) customResponsedMessage.getData();
                if (this.a.c != null && userInfoBigVip != null) {
                    this.a.e = true;
                    this.a.c.W(userInfoBigVip, false);
                }
                this.a.N();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ RecommendDetailModel b;

        public d(RecommendDetailModel recommendDetailModel, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendDetailModel, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = recommendDetailModel;
            this.a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                s77.j().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.b.g), this.a);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void W(UserInfoBigVip userInfoBigVip, boolean z);

        void W0(boolean z);

        void onFailed(String str);

        void w1(boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendDetailModel(TbPageContext<RecommendDetailActivity> tbPageContext, e eVar, RecommendDetailActivity recommendDetailActivity) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, eVar, recommendDetailActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        this.e = false;
        this.f = false;
        this.h = new a(this, CmdConfigHttp.CMD_GET_RECOMMEND_DETAIL, 303025);
        this.i = new c(this, 2001306);
        this.a = tbPageContext;
        this.b = recommendDetailActivity;
        this.c = eVar;
        MessageManager.getInstance().registerListener(this.h);
        MessageManager.getInstance().registerListener(this.i);
        L();
    }

    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : invokeV.booleanValue;
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f : invokeV.booleanValue;
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            boolean I = I();
            O(z);
            new d(this, !z).execute(new Void[0]);
            if (I != I()) {
                MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
            }
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            registerListener(new b(this, 104102));
        }
    }

    public void M(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.g = j;
            sendMessage(new CustomMessage(2001306, Long.valueOf(j)));
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            RecommendDetailRequestMessage recommendDetailRequestMessage = new RecommendDetailRequestMessage();
            recommendDetailRequestMessage.setUserId(this.g);
            sendMessage(recommendDetailRequestMessage);
        }
    }

    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.d = z;
        }
    }

    public void P(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
            if (i == 1) {
                if (z) {
                    requestUpdateMaskInfoMessage.setMute(false);
                    requestUpdateMaskInfoMessage.setIsMask(0);
                } else {
                    requestUpdateMaskInfoMessage.setIsMask(1);
                }
            } else if (i == 2) {
                requestUpdateMaskInfoMessage.setMute(true);
                requestUpdateMaskInfoMessage.setMuteNotifications(z);
            }
            requestUpdateMaskInfoMessage.setMaskType(6);
            requestUpdateMaskInfoMessage.setG_id(this.g);
            requestUpdateMaskInfoMessage.setCallFrom(2);
            sendMessage(requestUpdateMaskInfoMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.i);
            MessageManager.getInstance().unRegisterListener(this.h);
        }
    }
}
