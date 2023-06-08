package com.baidu.tieba.hottopicselect;

import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.a68;
import com.baidu.tieba.jb;
import com.baidu.tieba.k9;
import com.baidu.tieba.rx9;
import com.baidu.tieba.y58;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
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
    public jb e;
    public CustomMessageListener f;
    public String g;
    public long h;
    public String i;
    public String j;
    public boolean k;

    /* loaded from: classes6.dex */
    public interface c {
        void J0(a68 a68Var);

        void R0(a68 a68Var, a68 a68Var2, a68 a68Var3);

        void g1(String str);

        void n1(String str);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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

    /* loaded from: classes6.dex */
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
                    if (resultStatus != 1) {
                        if (resultStatus != 2) {
                            if (resultStatus == 3) {
                                HotTopicSelectModel hotTopicSelectModel = this.a;
                                hotTopicSelectModel.c0(hotTopicSelectModel.c, customResponsedMessage);
                                return;
                            }
                            return;
                        }
                        this.a.b.R0(hotSelectCacheResponseMessage.mUserData, hotSelectCacheResponseMessage.mBangData, hotSelectCacheResponseMessage.mVideoHotpicData);
                        return;
                    }
                    HotTopicSelectModel hotTopicSelectModel2 = this.a;
                    hotTopicSelectModel2.c0(hotTopicSelectModel2.c, customResponsedMessage);
                    return;
                }
                HotTopicSelectModel hotTopicSelectModel3 = this.a;
                hotTopicSelectModel3.c0(hotTopicSelectModel3.c, customResponsedMessage);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends jb {
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

        @Override // com.baidu.tieba.jb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) {
                return;
            }
            this.a.d = false;
            boolean z = responsedMessage instanceof HotSelectSocketResponseMessage;
            if (!z && !(responsedMessage instanceof HotSelectHttpResponseMessage)) {
                HotTopicSelectModel hotTopicSelectModel = this.a;
                hotTopicSelectModel.c0(hotTopicSelectModel.c, responsedMessage);
            } else if (responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof HotTopicSelectNetMessage)) {
                if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                    if (responsedMessage instanceof HotSelectHttpResponseMessage) {
                        HotSelectHttpResponseMessage hotSelectHttpResponseMessage = (HotSelectHttpResponseMessage) responsedMessage;
                        if (this.a.c) {
                            this.a.b.J0(hotSelectHttpResponseMessage.getSugTopic());
                            return;
                        } else {
                            this.a.b.R0(hotSelectHttpResponseMessage.getUserHisTopic(), hotSelectHttpResponseMessage.getBangTopic(), hotSelectHttpResponseMessage.getVideoTopic());
                            return;
                        }
                    } else if (z) {
                        HotSelectSocketResponseMessage hotSelectSocketResponseMessage = (HotSelectSocketResponseMessage) responsedMessage;
                        if (this.a.c) {
                            this.a.b.J0(hotSelectSocketResponseMessage.getSugTopic());
                            return;
                        } else {
                            this.a.b.R0(hotSelectSocketResponseMessage.getUserHisTopic(), hotSelectSocketResponseMessage.getBangTopic(), hotSelectSocketResponseMessage.getVideoTopic());
                            return;
                        }
                    } else {
                        return;
                    }
                }
                HotTopicSelectModel hotTopicSelectModel2 = this.a;
                hotTopicSelectModel2.c0(hotTopicSelectModel2.c, responsedMessage);
            } else {
                HotTopicSelectModel hotTopicSelectModel3 = this.a;
                hotTopicSelectModel3.c0(hotTopicSelectModel3.c, responsedMessage);
            }
        }
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
                super((k9) newInitContext.callArgs[0]);
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
        Y(cVar, "HotSelectCallBack is NullPointerException");
        Y(tbPageContext, "HotTopicSelectActivity is  NullPointerException");
        this.a = tbPageContext;
        this.b = cVar;
    }

    public final void c0(boolean z, ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, responsedMessage) == null) {
            if (responsedMessage != null && !TextUtils.isEmpty(responsedMessage.getErrorString())) {
                if (z) {
                    this.b.g1("");
                } else {
                    this.b.n1(responsedMessage.getErrorString());
                }
            } else if (z) {
                this.b.g1("");
            } else {
                this.b.n1(this.a.getString(R.string.obfuscated_res_0x7f0f0def));
            }
        }
    }

    public void j0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.g = str;
        }
    }

    public void k0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.k = z;
        }
    }

    public final void Y(Object obj, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, obj, str) != null) || obj != null) {
            return;
        }
        throw new NullPointerException(str);
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            sendMessage(new HotSelectCacheReqMessage());
        }
    }

    public String a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public final HotTopicSelectNetMessage b0() {
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

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f = new a(this, 2016491);
            rx9.b(2016491, y58.class);
            registerListener(this.f);
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            f0();
            e0();
        }
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.g = "";
            this.c = false;
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                Z();
            } else if (!this.d) {
                this.d = true;
                sendMessage(b0());
            }
        }
    }

    public void d0(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, intent) != null) || intent == null) {
            return;
        }
        intent.getIntExtra("from", HotSelectActivityConfig.FROM_PB);
        this.h = intent.getLongExtra("forum_id", 0L);
        this.i = intent.getStringExtra(IntentConfig.FORUM_FIRST_DIR);
        this.j = intent.getStringExtra(IntentConfig.FORUM_SECOND_DIR);
    }

    public void i0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.g = str;
            this.c = true;
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.b.g1("");
            } else if (!this.d) {
                this.d = true;
                HotTopicSelectNetMessage b0 = b0();
                b0.setPrefix(str);
                b0.setVideoTopic(this.k);
                sendMessage(b0);
            }
        }
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.e = new b(this, CmdConfigHttp.CMD_HTTP_GET_HOTTOPIC_SELECT, 309416);
            rx9.h(309416, HotSelectSocketResponseMessage.class, false, false);
            rx9.c(309416, CmdConfigHttp.CMD_HTTP_GET_HOTTOPIC_SELECT, TbConfig.SET_HOTSELECT, HotSelectHttpResponseMessage.class, true, true, true, true);
            registerListener(this.e);
        }
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
