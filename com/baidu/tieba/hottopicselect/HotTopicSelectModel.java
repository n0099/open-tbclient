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
import com.repackage.a37;
import com.repackage.bh8;
import com.repackage.c37;
import com.repackage.d9;
import com.repackage.ni;
import com.repackage.za;
/* loaded from: classes3.dex */
public class HotTopicSelectModel extends BdBaseModel<HotTopicSelectActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FAIL_LOAD = 3;
    public static final int NORMAL_LOAD = 2;
    public static final int NO_LOADED_DATA = 1;
    public static final String TOPIC_SELECT_KEY = "topic_select_user";
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<HotTopicSelectActivity> a;
    public final c b;
    public boolean c;
    public boolean d;
    public za e;
    public CustomMessageListener f;
    public String g;
    public long h;
    public String i;
    public String j;
    public boolean k;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicSelectModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HotTopicSelectModel hotTopicSelectModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicSelectModel, Integer.valueOf(i)};
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
                        hotTopicSelectModel.H(hotTopicSelectModel.c, customResponsedMessage);
                        return;
                    } else if (resultStatus == 2) {
                        this.a.b.c0(hotSelectCacheResponseMessage.mUserData, hotSelectCacheResponseMessage.mBangData, hotSelectCacheResponseMessage.mVideoHotpicData);
                        return;
                    } else if (resultStatus != 3) {
                        return;
                    } else {
                        HotTopicSelectModel hotTopicSelectModel2 = this.a;
                        hotTopicSelectModel2.H(hotTopicSelectModel2.c, customResponsedMessage);
                        return;
                    }
                }
                HotTopicSelectModel hotTopicSelectModel3 = this.a;
                hotTopicSelectModel3.H(hotTopicSelectModel3.c, customResponsedMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicSelectModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(HotTopicSelectModel hotTopicSelectModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicSelectModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = hotTopicSelectModel;
        }

        @Override // com.repackage.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.d = false;
                boolean z = responsedMessage instanceof HotSelectSocketResponseMessage;
                if (!z && !(responsedMessage instanceof HotSelectHttpResponseMessage)) {
                    HotTopicSelectModel hotTopicSelectModel = this.a;
                    hotTopicSelectModel.H(hotTopicSelectModel.c, responsedMessage);
                } else if (responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof HotTopicSelectNetMessage)) {
                    if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                        if (responsedMessage instanceof HotSelectHttpResponseMessage) {
                            HotSelectHttpResponseMessage hotSelectHttpResponseMessage = (HotSelectHttpResponseMessage) responsedMessage;
                            if (this.a.c) {
                                this.a.b.N(hotSelectHttpResponseMessage.getSugTopic());
                                return;
                            } else {
                                this.a.b.c0(hotSelectHttpResponseMessage.getUserHisTopic(), hotSelectHttpResponseMessage.getBangTopic(), hotSelectHttpResponseMessage.getVideoTopic());
                                return;
                            }
                        } else if (z) {
                            HotSelectSocketResponseMessage hotSelectSocketResponseMessage = (HotSelectSocketResponseMessage) responsedMessage;
                            if (this.a.c) {
                                this.a.b.N(hotSelectSocketResponseMessage.getSugTopic());
                                return;
                            } else {
                                this.a.b.c0(hotSelectSocketResponseMessage.getUserHisTopic(), hotSelectSocketResponseMessage.getBangTopic(), hotSelectSocketResponseMessage.getVideoTopic());
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    HotTopicSelectModel hotTopicSelectModel2 = this.a;
                    hotTopicSelectModel2.H(hotTopicSelectModel2.c, responsedMessage);
                } else {
                    HotTopicSelectModel hotTopicSelectModel3 = this.a;
                    hotTopicSelectModel3.H(hotTopicSelectModel3.c, responsedMessage);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void N(c37 c37Var);

        void c0(c37 c37Var, c37 c37Var2, c37 c37Var3);

        void g0(String str);

        void k0(String str);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = false;
        this.d = false;
        this.h = 0L;
        this.i = "";
        this.j = "";
        D(cVar, "HotSelectCallBack is NullPointerException");
        D(tbPageContext, "HotTopicSelectActivity is  NullPointerException");
        this.a = tbPageContext;
        this.b = cVar;
    }

    public final void D(Object obj, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, obj, str) == null) && obj == null) {
            throw new NullPointerException(str);
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            sendMessage(new HotSelectCacheReqMessage());
        }
    }

    public String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.g : (String) invokeV.objValue;
    }

    public final HotTopicSelectNetMessage G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HotTopicSelectNetMessage hotTopicSelectNetMessage = new HotTopicSelectNetMessage();
            hotTopicSelectNetMessage.setFid(this.h);
            hotTopicSelectNetMessage.setFirstDir(this.i);
            hotTopicSelectNetMessage.setSecondDir(this.j);
            hotTopicSelectNetMessage.setVideoTopic(this.k);
            return hotTopicSelectNetMessage;
        }
        return (HotTopicSelectNetMessage) invokeV.objValue;
    }

    public final void H(boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, responsedMessage) == null) {
            if (responsedMessage == null || TextUtils.isEmpty(responsedMessage.getErrorString())) {
                if (z) {
                    this.b.g0("");
                } else {
                    this.b.k0(this.a.getString(R.string.obfuscated_res_0x7f0f0c37));
                }
            } else if (z) {
                this.b.g0("");
            } else {
                this.b.k0(responsedMessage.getErrorString());
            }
        }
    }

    public void I(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, intent) == null) || intent == null) {
            return;
        }
        intent.getIntExtra("from", HotSelectActivityConfig.FROM_PB);
        this.h = intent.getLongExtra("forum_id", 0L);
        this.i = intent.getStringExtra(IntentConfig.FORUM_FIRST_DIR);
        this.j = intent.getStringExtra(IntentConfig.FORUM_SECOND_DIR);
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f = new a(this, 2016491);
            bh8.b(2016491, a37.class);
            registerListener(this.f);
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.e = new b(this, CmdConfigHttp.CMD_HTTP_GET_HOTTOPIC_SELECT, 309416);
            bh8.h(309416, HotSelectSocketResponseMessage.class, false, false);
            bh8.c(309416, CmdConfigHttp.CMD_HTTP_GET_HOTTOPIC_SELECT, TbConfig.SET_HOTSELECT, HotSelectHttpResponseMessage.class, true, true, true, true);
            registerListener(this.e);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            K();
            J();
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.g = "";
            this.c = false;
            if (!ni.z()) {
                E();
            } else if (this.d) {
            } else {
                this.d = true;
                sendMessage(G());
            }
        }
    }

    public void N(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.g = str;
            this.c = true;
            if (!ni.z()) {
                this.b.g0("");
            } else if (this.d) {
            } else {
                this.d = true;
                HotTopicSelectNetMessage G = G();
                G.setPrefix(str);
                G.setVideoTopic(this.k);
                sendMessage(G);
            }
        }
    }

    public void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.g = str;
        }
    }

    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.k = z;
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
            MessageManager.getInstance().unRegisterListener(this.e);
            MessageManager.getInstance().unRegisterListener(this.f);
            MessageManager.getInstance().unRegisterTask(309416);
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_HTTP_GET_HOTTOPIC_SELECT);
            MessageManager.getInstance().unRegisterTask(2016491);
        }
    }
}
