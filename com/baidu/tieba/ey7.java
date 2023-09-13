package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.voiceroom.data.VoiceRoomListNetModel;
import com.baidu.tieba.frs.voiceroom.data.VoiceRoomWrapper;
import com.baidu.tieba.gw4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class ey7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final VoiceRoomListNetModel a;

    /* loaded from: classes5.dex */
    public static final class a implements NetModel.k<cy7, dy7> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw4<List<VoiceRoomWrapper>> a;

        public a(fw4<List<VoiceRoomWrapper>> fw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw4Var;
        }

        @Override // com.baidu.tbadk.mvc.model.NetModel.l
        public void G(MvcHttpResponsedMessage<dy7> mvcHttpResponsedMessage, MvcHttpMessage<cy7, dy7> mvcHttpMessage, MvcNetMessage<cy7, dy7> mvcNetMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) && mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
                if (mvcHttpResponsedMessage.getError() == 0) {
                    this.a.a(new gw4.c(mvcHttpResponsedMessage.getData().a()));
                    return;
                }
                fw4<List<VoiceRoomWrapper>> fw4Var = this.a;
                String errorString = mvcHttpResponsedMessage.getErrorString();
                Intrinsics.checkNotNullExpressionValue(errorString, "responsedMessage.errorString");
                fw4Var.a(new gw4.a(errorString, null, 2, null));
            }
        }

        @Override // com.baidu.tbadk.mvc.model.NetModel.m
        public void v(MvcSocketResponsedMessage<dy7, ?> mvcSocketResponsedMessage, MvcSocketMessage<cy7, dy7> mvcSocketMessage, MvcNetMessage<cy7, dy7> mvcNetMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) && mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
                if (mvcSocketResponsedMessage.getError() == 0) {
                    this.a.a(new gw4.c(mvcSocketResponsedMessage.getData().a()));
                    return;
                }
                fw4<List<VoiceRoomWrapper>> fw4Var = this.a;
                String errorString = mvcSocketResponsedMessage.getErrorString();
                Intrinsics.checkNotNullExpressionValue(errorString, "responsedMessage.errorString");
                fw4Var.a(new gw4.a(errorString, null, 2, null));
            }
        }
    }

    public ey7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new VoiceRoomListNetModel();
    }

    public final void a(TbPageContext<?> tbPageContext, long j, long j2, fw4<List<VoiceRoomWrapper>> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{tbPageContext, Long.valueOf(j), Long.valueOf(j2), callback}) == null) {
            Intrinsics.checkNotNullParameter(tbPageContext, "tbPageContext");
            Intrinsics.checkNotNullParameter(callback, "callback");
            cy7 cy7Var = new cy7(j, j2);
            this.a.setUniqueId(tbPageContext.getUniqueId());
            this.a.p0(cy7Var);
            this.a.o0(new a(callback));
            this.a.loadData();
            callback.a(new gw4.b(null, 1, null));
        }
    }
}
