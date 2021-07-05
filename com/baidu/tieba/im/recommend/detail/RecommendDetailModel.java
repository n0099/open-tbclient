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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes5.dex */
public class RecommendDetailModel extends BdBaseModel<RecommendDetailActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<RecommendDetailActivity> f17617e;

    /* renamed from: f  reason: collision with root package name */
    public d f17618f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17619g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f17620h;

    /* renamed from: i  reason: collision with root package name */
    public long f17621i;
    public d.a.c.c.g.a j;
    public CustomMessageListener k;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendDetailModel f17622a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RecommendDetailModel recommendDetailModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendDetailModel, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17622a = recommendDetailModel;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f17622a.f17620h = true;
                if (this.f17622a.f17617e == null || this.f17622a.f17618f == null) {
                    return;
                }
                if (responsedMessage == null) {
                    this.f17622a.f17618f.onFailed(this.f17622a.f17617e.getString(R.string.neterror));
                } else if (responsedMessage.getError() != 0) {
                    if (TextUtils.isEmpty(responsedMessage.getErrorString())) {
                        this.f17622a.f17618f.onFailed(this.f17622a.f17617e.getString(R.string.neterror));
                    } else {
                        this.f17622a.f17618f.onFailed(responsedMessage.getErrorString());
                    }
                } else {
                    if (responsedMessage instanceof RecommendDetailHttpResponseMessage) {
                        RecommendDetailHttpResponseMessage recommendDetailHttpResponseMessage = (RecommendDetailHttpResponseMessage) responsedMessage;
                        if (recommendDetailHttpResponseMessage.getDetailInfo() != null) {
                            this.f17622a.f17619g = true;
                            this.f17622a.f17618f.onSuccess(recommendDetailHttpResponseMessage.getDetailInfo(), true);
                        }
                    }
                    if (responsedMessage instanceof RecommendDetailSocketResponseMessage) {
                        RecommendDetailSocketResponseMessage recommendDetailSocketResponseMessage = (RecommendDetailSocketResponseMessage) responsedMessage;
                        if (recommendDetailSocketResponseMessage.getDetailInfo() != null) {
                            this.f17622a.f17619g = true;
                            this.f17622a.f17618f.onSuccess(recommendDetailSocketResponseMessage.getDetailInfo(), true);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends d.a.c.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendDetailModel f17623a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(RecommendDetailModel recommendDetailModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendDetailModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17623a = recommendDetailModel;
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
                    if (requestUpdateMaskInfoMessage.getMaskType() != 6 || this.f17623a.f17617e == null || this.f17623a.f17618f == null) {
                        return;
                    }
                    if (responseUpdateMaskInfoMessage.getError() != 0) {
                        if (StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString())) {
                            this.f17623a.f17617e.showToast(R.string.neterror);
                        } else {
                            this.f17623a.f17617e.showToast(responseUpdateMaskInfoMessage.getErrorString());
                        }
                        if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                            this.f17623a.f17618f.onAcceptMsg(false);
                        } else {
                            this.f17623a.f17618f.onUnAcceptMsg(false);
                        }
                    } else if (requestUpdateMaskInfoMessage.getIsMask() == 0) {
                        this.f17623a.f17618f.onAcceptMsg(true);
                    } else {
                        this.f17623a.f17618f.onUnAcceptMsg(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendDetailModel f17624a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(RecommendDetailModel recommendDetailModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendDetailModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17624a = recommendDetailModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserInfoBigVip)) {
                    this.f17624a.F();
                    return;
                }
                UserInfoBigVip userInfoBigVip = (UserInfoBigVip) customResponsedMessage.getData();
                if (this.f17624a.f17618f != null && userInfoBigVip != null) {
                    this.f17624a.f17619g = true;
                    this.f17624a.f17618f.onSuccess(userInfoBigVip, false);
                }
                this.f17624a.F();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void onAcceptMsg(boolean z);

        void onFailed(String str);

        void onSuccess(UserInfoBigVip userInfoBigVip, boolean z);

        void onUnAcceptMsg(boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendDetailModel(TbPageContext<RecommendDetailActivity> tbPageContext, d dVar) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17619g = false;
        this.f17620h = false;
        this.j = new a(this, CmdConfigHttp.CMD_GET_RECOMMEND_DETAIL, 303025);
        this.k = new c(this, 2001306);
        this.f17617e = tbPageContext;
        this.f17618f = dVar;
        MessageManager.getInstance().registerListener(this.j);
        MessageManager.getInstance().registerListener(this.k);
        D();
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17619g : invokeV.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f17620h : invokeV.booleanValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            registerListener(new b(this, 104102));
        }
    }

    public void E(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.f17621i = j;
            sendMessage(new CustomMessage(2001306, Long.valueOf(j)));
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            RecommendDetailRequestMessage recommendDetailRequestMessage = new RecommendDetailRequestMessage();
            recommendDetailRequestMessage.setUserId(this.f17621i);
            sendMessage(recommendDetailRequestMessage);
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
            if (z) {
                requestUpdateMaskInfoMessage.setIsMask(0);
            } else {
                requestUpdateMaskInfoMessage.setIsMask(1);
            }
            requestUpdateMaskInfoMessage.setMaskType(6);
            requestUpdateMaskInfoMessage.setG_id(this.f17621i);
            requestUpdateMaskInfoMessage.setCallFrom(2);
            sendMessage(requestUpdateMaskInfoMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.k);
            MessageManager.getInstance().unRegisterListener(this.j);
        }
    }
}
