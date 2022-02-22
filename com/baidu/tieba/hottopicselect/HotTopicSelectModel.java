package com.baidu.tieba.hottopicselect;

import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.d.f.p.l;
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
/* loaded from: classes12.dex */
public class HotTopicSelectModel extends BdBaseModel<HotTopicSelectActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FAIL_LOAD = 3;
    public static final int NORMAL_LOAD = 2;
    public static final int NO_LOADED_DATA = 1;
    public static final String TOPIC_SELECT_KEY = "topic_select_user";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<HotTopicSelectActivity> f44943e;

    /* renamed from: f  reason: collision with root package name */
    public final c f44944f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f44945g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f44946h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.d.c.g.a f44947i;

    /* renamed from: j  reason: collision with root package name */
    public CustomMessageListener f44948j;
    public String k;
    public long l;
    public String m;
    public String n;
    public boolean o;

    /* loaded from: classes12.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicSelectModel a;

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
            this.a = hotTopicSelectModel;
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
                        HotTopicSelectModel hotTopicSelectModel = this.a;
                        hotTopicSelectModel.E(hotTopicSelectModel.f44945g, customResponsedMessage);
                        return;
                    } else if (resultStatus == 2) {
                        this.a.f44944f.onHotSelectDataNoSearchSuccess(hotSelectCacheResponseMessage.mUserData, hotSelectCacheResponseMessage.mBangData, hotSelectCacheResponseMessage.mVideoHotpicData);
                        return;
                    } else if (resultStatus != 3) {
                        return;
                    } else {
                        HotTopicSelectModel hotTopicSelectModel2 = this.a;
                        hotTopicSelectModel2.E(hotTopicSelectModel2.f44945g, customResponsedMessage);
                        return;
                    }
                }
                HotTopicSelectModel hotTopicSelectModel3 = this.a;
                hotTopicSelectModel3.E(hotTopicSelectModel3.f44945g, customResponsedMessage);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicSelectModel a;

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
            this.a = hotTopicSelectModel;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.f44946h = false;
                boolean z = responsedMessage instanceof HotSelectSocketResponseMessage;
                if (!z && !(responsedMessage instanceof HotSelectHttpResponseMessage)) {
                    HotTopicSelectModel hotTopicSelectModel = this.a;
                    hotTopicSelectModel.E(hotTopicSelectModel.f44945g, responsedMessage);
                } else if (responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof HotTopicSelectNetMessage)) {
                    if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                        if (responsedMessage instanceof HotSelectHttpResponseMessage) {
                            HotSelectHttpResponseMessage hotSelectHttpResponseMessage = (HotSelectHttpResponseMessage) responsedMessage;
                            if (this.a.f44945g) {
                                this.a.f44944f.onHotSelectDataSearchSuccess(hotSelectHttpResponseMessage.getSugTopic());
                                return;
                            } else {
                                this.a.f44944f.onHotSelectDataNoSearchSuccess(hotSelectHttpResponseMessage.getUserHisTopic(), hotSelectHttpResponseMessage.getBangTopic(), hotSelectHttpResponseMessage.getVideoTopic());
                                return;
                            }
                        } else if (z) {
                            HotSelectSocketResponseMessage hotSelectSocketResponseMessage = (HotSelectSocketResponseMessage) responsedMessage;
                            if (this.a.f44945g) {
                                this.a.f44944f.onHotSelectDataSearchSuccess(hotSelectSocketResponseMessage.getSugTopic());
                                return;
                            } else {
                                this.a.f44944f.onHotSelectDataNoSearchSuccess(hotSelectSocketResponseMessage.getUserHisTopic(), hotSelectSocketResponseMessage.getBangTopic(), hotSelectSocketResponseMessage.getVideoTopic());
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    HotTopicSelectModel hotTopicSelectModel2 = this.a;
                    hotTopicSelectModel2.E(hotTopicSelectModel2.f44945g, responsedMessage);
                } else {
                    HotTopicSelectModel hotTopicSelectModel3 = this.a;
                    hotTopicSelectModel3.E(hotTopicSelectModel3.f44945g, responsedMessage);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface c {
        void onHotSelectDataNoSearchFailed(String str);

        void onHotSelectDataNoSearchSuccess(c.a.u0.s1.c cVar, c.a.u0.s1.c cVar2, c.a.u0.s1.c cVar3);

        void onHotSelectDataSearchFailed(String str);

        void onHotSelectDataSearchSuccess(c.a.u0.s1.c cVar);
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
        this.f44945g = false;
        this.f44946h = false;
        this.l = 0L;
        this.m = "";
        this.n = "";
        A(cVar, "HotSelectCallBack is NullPointerException");
        A(tbPageContext, "HotTopicSelectActivity is  NullPointerException");
        this.f44943e = tbPageContext;
        this.f44944f = cVar;
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
            hotTopicSelectNetMessage.setVideoTopic(this.o);
            return hotTopicSelectNetMessage;
        }
        return (HotTopicSelectNetMessage) invokeV.objValue;
    }

    public final void E(boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, responsedMessage) == null) {
            if (responsedMessage == null || TextUtils.isEmpty(responsedMessage.getErrorString())) {
                if (z) {
                    this.f44944f.onHotSelectDataSearchFailed("");
                } else {
                    this.f44944f.onHotSelectDataNoSearchFailed(this.f44943e.getString(R.string.neterror));
                }
            } else if (z) {
                this.f44944f.onHotSelectDataSearchFailed("");
            } else {
                this.f44944f.onHotSelectDataNoSearchFailed(responsedMessage.getErrorString());
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
            this.f44948j = new a(this, 2016491);
            c.a.u0.z3.g0.a.b(2016491, c.a.u0.s1.a.class);
            registerListener(this.f44948j);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f44947i = new b(this, CmdConfigHttp.CMD_HTTP_GET_HOTTOPIC_SELECT, 309416);
            c.a.u0.z3.g0.a.h(309416, HotSelectSocketResponseMessage.class, false, false);
            c.a.u0.z3.g0.a.c(309416, CmdConfigHttp.CMD_HTTP_GET_HOTTOPIC_SELECT, TbConfig.SET_HOTSELECT, HotSelectHttpResponseMessage.class, true, true, true, true);
            registerListener(this.f44947i);
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
            this.f44945g = false;
            if (!l.z()) {
                B();
            } else if (this.f44946h) {
            } else {
                this.f44946h = true;
                sendMessage(D());
            }
        }
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.k = str;
            this.f44945g = true;
            if (!l.z()) {
                this.f44944f.onHotSelectDataSearchFailed("");
            } else if (this.f44946h) {
            } else {
                this.f44946h = true;
                HotTopicSelectNetMessage D = D();
                D.setPrefix(str);
                D.setVideoTopic(this.o);
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

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.o = z;
        }
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

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f44947i);
            MessageManager.getInstance().unRegisterListener(this.f44948j);
            MessageManager.getInstance().unRegisterTask(309416);
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_HTTP_GET_HOTTOPIC_SELECT);
            MessageManager.getInstance().unRegisterTask(2016491);
        }
    }
}
