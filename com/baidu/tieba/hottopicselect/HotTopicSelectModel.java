package com.baidu.tieba.hottopicselect;

import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
import d.a.c.e.p.j;
/* loaded from: classes5.dex */
public class HotTopicSelectModel extends BdBaseModel<HotTopicSelectActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FAIL_LOAD = 3;
    public static final int NORMAL_LOAD = 2;
    public static final int NO_LOADED_DATA = 1;
    public static final String TOPIC_SELECT_KEY = "topic_select_user";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<HotTopicSelectActivity> f17223e;

    /* renamed from: f  reason: collision with root package name */
    public final c f17224f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17225g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f17226h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.c.c.g.a f17227i;
    public CustomMessageListener j;
    public String k;
    public long l;
    public String m;
    public String n;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicSelectModel f17228a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HotTopicSelectModel hotTopicSelectModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicSelectModel, Integer.valueOf(i2)};
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
            this.f17228a = hotTopicSelectModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof HotSelectCacheResponseMessage)) {
                    HotSelectCacheResponseMessage hotSelectCacheResponseMessage = (HotSelectCacheResponseMessage) customResponsedMessage;
                    int resultStatus = hotSelectCacheResponseMessage.getResultStatus();
                    if (resultStatus == 1) {
                        HotTopicSelectModel hotTopicSelectModel = this.f17228a;
                        hotTopicSelectModel.E(hotTopicSelectModel.f17225g, customResponsedMessage);
                        return;
                    } else if (resultStatus == 2) {
                        this.f17228a.f17224f.onHotSelectDataNoSearchSuccess(hotSelectCacheResponseMessage.mUserData, hotSelectCacheResponseMessage.mBangData);
                        return;
                    } else if (resultStatus != 3) {
                        return;
                    } else {
                        HotTopicSelectModel hotTopicSelectModel2 = this.f17228a;
                        hotTopicSelectModel2.E(hotTopicSelectModel2.f17225g, customResponsedMessage);
                        return;
                    }
                }
                HotTopicSelectModel hotTopicSelectModel3 = this.f17228a;
                hotTopicSelectModel3.E(hotTopicSelectModel3.f17225g, customResponsedMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicSelectModel f17229a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(HotTopicSelectModel hotTopicSelectModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicSelectModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f17229a = hotTopicSelectModel;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f17229a.f17226h = false;
                boolean z = responsedMessage instanceof HotSelectSocketResponseMessage;
                if (!z && !(responsedMessage instanceof HotSelectHttpResponseMessage)) {
                    HotTopicSelectModel hotTopicSelectModel = this.f17229a;
                    hotTopicSelectModel.E(hotTopicSelectModel.f17225g, responsedMessage);
                } else if (responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof HotTopicSelectNetMessage)) {
                    if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                        if (responsedMessage instanceof HotSelectHttpResponseMessage) {
                            HotSelectHttpResponseMessage hotSelectHttpResponseMessage = (HotSelectHttpResponseMessage) responsedMessage;
                            if (this.f17229a.f17225g) {
                                this.f17229a.f17224f.onHotSelectDataSearchSuccess(hotSelectHttpResponseMessage.getSugTopic());
                                return;
                            } else {
                                this.f17229a.f17224f.onHotSelectDataNoSearchSuccess(hotSelectHttpResponseMessage.getUserHisTopic(), hotSelectHttpResponseMessage.getBangTopic());
                                return;
                            }
                        } else if (z) {
                            HotSelectSocketResponseMessage hotSelectSocketResponseMessage = (HotSelectSocketResponseMessage) responsedMessage;
                            if (this.f17229a.f17225g) {
                                this.f17229a.f17224f.onHotSelectDataSearchSuccess(hotSelectSocketResponseMessage.getSugTopic());
                                return;
                            } else {
                                this.f17229a.f17224f.onHotSelectDataNoSearchSuccess(hotSelectSocketResponseMessage.getUserHisTopic(), hotSelectSocketResponseMessage.getBangTopic());
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    HotTopicSelectModel hotTopicSelectModel2 = this.f17229a;
                    hotTopicSelectModel2.E(hotTopicSelectModel2.f17225g, responsedMessage);
                } else {
                    HotTopicSelectModel hotTopicSelectModel3 = this.f17229a;
                    hotTopicSelectModel3.E(hotTopicSelectModel3.f17225g, responsedMessage);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void onHotSelectDataNoSearchFailed(String str);

        void onHotSelectDataNoSearchSuccess(d.a.s0.h1.c cVar, d.a.s0.h1.c cVar2);

        void onHotSelectDataSearchFailed(String str);

        void onHotSelectDataSearchSuccess(d.a.s0.h1.c cVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicSelectModel(TbPageContext tbPageContext, c cVar) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, cVar};
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
        this.f17225g = false;
        this.f17226h = false;
        this.l = 0L;
        this.m = "";
        this.n = "";
        A(cVar, "HotSelectCallBack is NullPointerException");
        A(tbPageContext, "HotTopicSelectActivity is  NullPointerException");
        this.f17223e = tbPageContext;
        this.f17224f = cVar;
    }

    public final void A(Object obj, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, obj, str) == null) && obj == null) {
            throw new NullPointerException(str);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            sendMessage(new HotSelectCacheReqMessage());
        }
    }

    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public final HotTopicSelectNetMessage D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HotTopicSelectNetMessage hotTopicSelectNetMessage = new HotTopicSelectNetMessage();
            hotTopicSelectNetMessage.setFid(this.l);
            hotTopicSelectNetMessage.setFirstDir(this.m);
            hotTopicSelectNetMessage.setSecondDir(this.n);
            return hotTopicSelectNetMessage;
        }
        return (HotTopicSelectNetMessage) invokeV.objValue;
    }

    public final void E(boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, responsedMessage) == null) {
            if (responsedMessage == null || TextUtils.isEmpty(responsedMessage.getErrorString())) {
                if (z) {
                    this.f17224f.onHotSelectDataSearchFailed("");
                } else {
                    this.f17224f.onHotSelectDataNoSearchFailed(this.f17223e.getString(R.string.neterror));
                }
            } else if (z) {
                this.f17224f.onHotSelectDataSearchFailed("");
            } else {
                this.f17224f.onHotSelectDataNoSearchFailed(responsedMessage.getErrorString());
            }
        }
    }

    public void F(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, intent) == null) || intent == null) {
            return;
        }
        intent.getIntExtra("from", HotSelectActivityConfig.FROM_PB);
        this.l = intent.getLongExtra("forum_id", 0L);
        this.m = intent.getStringExtra(IntentConfig.FORUM_FIRST_DIR);
        this.n = intent.getStringExtra(IntentConfig.FORUM_SECOND_DIR);
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.j = new a(this, 2016491);
            d.a.s0.h3.d0.a.b(2016491, d.a.s0.h1.a.class);
            registerListener(this.j);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f17227i = new b(this, CmdConfigHttp.CMD_HTTP_GET_HOTTOPIC_SELECT, 309416);
            d.a.s0.h3.d0.a.h(309416, HotSelectSocketResponseMessage.class, false, false);
            d.a.s0.h3.d0.a.c(309416, CmdConfigHttp.CMD_HTTP_GET_HOTTOPIC_SELECT, TbConfig.SET_HOTSELECT, HotSelectHttpResponseMessage.class, true, true, true, true);
            registerListener(this.f17227i);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            H();
            G();
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.k = "";
            this.f17225g = false;
            if (!j.z()) {
                B();
            } else if (this.f17226h) {
            } else {
                this.f17226h = true;
                sendMessage(D());
            }
        }
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.k = str;
            this.f17225g = true;
            if (!j.z()) {
                this.f17224f.onHotSelectDataSearchFailed("");
            } else if (this.f17226h) {
            } else {
                this.f17226h = true;
                HotTopicSelectNetMessage D = D();
                D.setPrefix(str);
                sendMessage(D);
            }
        }
    }

    public void L(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.k = str;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f17227i);
            MessageManager.getInstance().unRegisterListener(this.j);
            MessageManager.getInstance().unRegisterTask(309416);
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_HTTP_GET_HOTTOPIC_SELECT);
            MessageManager.getInstance().unRegisterTask(2016491);
        }
    }
}
