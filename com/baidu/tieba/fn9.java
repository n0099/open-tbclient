package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.pb.godreply.LookMoreHttpResMessage;
import com.baidu.tieba.pb.pb.godreply.LookMoreReqMessage;
import com.baidu.tieba.pb.pb.godreply.LookMoreSocketResMessage;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class fn9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbModel a;
    public b b;
    public final BdUniqueId c;
    public final NetMessageListener d;

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i, String str, String str2);

        void onSuccess(List<tha> list);
    }

    /* loaded from: classes5.dex */
    public class a extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fn9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(fn9 fn9Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fn9Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = fn9Var;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() != null && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag() != this.a.c) {
                return;
            }
            if (responsedMessage instanceof LookMoreHttpResMessage) {
                LookMoreHttpResMessage lookMoreHttpResMessage = (LookMoreHttpResMessage) responsedMessage;
                List<tha> data = lookMoreHttpResMessage.getData();
                String errorString = lookMoreHttpResMessage.getErrorString();
                int error = lookMoreHttpResMessage.getError();
                if (error == 0) {
                    if (!ListUtils.isEmpty(data)) {
                        this.a.b.onSuccess(data);
                        return;
                    }
                    return;
                }
                this.a.b.a(error, errorString, "");
            } else if (responsedMessage instanceof LookMoreSocketResMessage) {
                LookMoreSocketResMessage lookMoreSocketResMessage = (LookMoreSocketResMessage) responsedMessage;
                List<tha> data2 = lookMoreSocketResMessage.getData();
                String errorString2 = lookMoreSocketResMessage.getErrorString();
                int error2 = lookMoreSocketResMessage.getError();
                if (error2 == 0) {
                    if (data2 != null) {
                        this.a.b.onSuccess(data2);
                        return;
                    }
                    return;
                }
                this.a.b.a(error2, errorString2, "");
            }
        }
    }

    public fn9(PbModel pbModel, BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbModel, baseFragmentActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new a(this, CmdConfigHttp.CMD_PB_GOD_MORE, 309446);
        this.a = pbModel;
        this.c = BdUniqueId.gen();
        e();
        this.d.setTag(baseFragmentActivity.getUniqueId());
        MessageManager.getInstance().registerListener(this.d);
        this.b = null;
    }

    public void f(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.b = bVar;
        }
    }

    public void c(List<Long> list) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, list) == null) && (pbModel = this.a) != null && pbModel.r1() != null) {
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst());
            LookMoreReqMessage lookMoreReqMessage = new LookMoreReqMessage();
            lookMoreReqMessage.setKz(Long.valueOf(JavaTypesHelper.toLong(this.a.b, 0L)));
            lookMoreReqMessage.setPost_id(list);
            lookMoreReqMessage.setSt_type(JavaTypesHelper.toInt(this.a.mStType, 0));
            lookMoreReqMessage.setWith_floor(1);
            lookMoreReqMessage.setScr_w(equipmentWidth);
            lookMoreReqMessage.setScr_h(equipmentHeight);
            lookMoreReqMessage.setTag(this.c);
            MessageManager.getInstance().sendMessage(lookMoreReqMessage);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.d);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PB_GOD_MORE, bha.a(TbConfig.PB_MORE_GOD_REPLY_URL, 309446));
            tbHttpMessageTask.setResponsedClass(LookMoreHttpResMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            bha.f(309446, LookMoreSocketResMessage.class, false);
        }
    }
}
