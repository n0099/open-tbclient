package com.baidu.tieba;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.pb.PbPageRequestMessage;
import com.baidu.tieba.pb.pb.main.pbPageHttpResponseMessage;
import com.baidu.tieba.pb.pb.main.pbPageSocketResponseMessage;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class if8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final b a;
    public static String b = "";
    public static String c = "";
    public static final wb d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static final class a extends wb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a() {
            super(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr = newInitContext.callArgs;
                    super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.wb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                boolean z = responsedMessage instanceof pbPageSocketResponseMessage;
                if ((!z && !(responsedMessage instanceof pbPageHttpResponseMessage)) || responsedMessage.getOrginalMessage().getTag().getId() != cb8.a.a().getId() || responsedMessage.hasError()) {
                    return;
                }
                if (responsedMessage.getOrginalMessage().getSelf() instanceof PbPageRequestMessage) {
                    b bVar = if8.a;
                    Object self = responsedMessage.getOrginalMessage().getSelf();
                    if (self != null) {
                        if8.c = String.valueOf(((PbPageRequestMessage) self).get_kz());
                        b bVar2 = if8.a;
                        Object self2 = responsedMessage.getOrginalMessage().getSelf();
                        if (self2 != null) {
                            String schemeUrl = ((PbPageRequestMessage) self2).getSchemeUrl();
                            Intrinsics.checkNotNullExpressionValue(schemeUrl, "responsedMessage.orginal…RequestMessage).schemeUrl");
                            if8.b = schemeUrl;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.pb.PbPageRequestMessage");
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.pb.PbPageRequestMessage");
                    }
                }
                if (z) {
                    b bVar3 = if8.a;
                    u98 pbData = ((pbPageSocketResponseMessage) responsedMessage).getPbData();
                    Intrinsics.checkNotNullExpressionValue(pbData, "responsedMessage.pbData");
                    bVar3.a(pbData);
                }
                if (responsedMessage instanceof pbPageHttpResponseMessage) {
                    b bVar4 = if8.a;
                    u98 pbData2 = ((pbPageHttpResponseMessage) responsedMessage).getPbData();
                    Intrinsics.checkNotNullExpressionValue(pbData2, "responsedMessage.pbData");
                    bVar4.a(pbData2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                MessageManager.getInstance().registerListener(if8.d);
            }
        }

        public final void a(u98 pbData) {
            boolean z;
            TbPageContext currentPageContext;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pbData) == null) {
                Intrinsics.checkNotNullParameter(pbData, "pbData");
                if (if8.b.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if (pbData.v0()) {
                        ArrayList arrayList = new ArrayList();
                        VideoItemData videoItemData = new VideoItemData();
                        videoItemData.thread_id = if8.c;
                        arrayList.add(videoItemData);
                        new VideoRecommentPlayActivityConfig(TbadkCoreApplication.getInst(), arrayList, null, VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE).start();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(TbadkCoreApplication.getInst()).createNormalCfg(if8.c, "0", 1, "allthread")));
                    return;
                }
                if (pbData.v0()) {
                    String T = ej.T(if8.b, Intrinsics.stringPlus("obj_param1=", BdUniDispatchSchemeController.PARAM_VIDEO));
                    Intrinsics.checkNotNullExpressionValue(T, "urlAddParam(schemeUrl, \"…Controller.PARAM_VIDEO}\")");
                    if8.b = T;
                    String T2 = ej.T(if8.b, Intrinsics.stringPlus(BdUniDispatchSchemeController.PARAMS_IS_VIDEO, "=true"));
                    Intrinsics.checkNotNullExpressionValue(T2, "urlAddParam(schemeUrl, \"…r.PARAMS_IS_VIDEO}=true\")");
                    if8.b = T2;
                } else {
                    String T3 = ej.T(if8.b, Intrinsics.stringPlus("obj_param1=", BdUniDispatchSchemeController.PARAM_PB_NORMAL));
                    Intrinsics.checkNotNullExpressionValue(T3, "urlAddParam(schemeUrl,\n …roller.PARAM_PB_NORMAL}\")");
                    if8.b = T3;
                    String T4 = ej.T(if8.b, Intrinsics.stringPlus(BdUniDispatchSchemeController.PARAMS_IS_VIDEO, "=false"));
                    Intrinsics.checkNotNullExpressionValue(T4, "urlAddParam(schemeUrl, \"….PARAMS_IS_VIDEO}=false\")");
                    if8.b = T4;
                }
                if (t9.f().b() instanceof TbPageContextSupport) {
                    Activity b = t9.f().b();
                    if (b != null) {
                        currentPageContext = ((TbPageContextSupport) b).getPageContext();
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.TbPageContextSupport");
                    }
                } else {
                    currentPageContext = TbadkCoreApplication.getInst().getCurrentPageContext(h99.a());
                }
                UrlManager.getInstance().dealOneLink(currentPageContext, new String[]{if8.b});
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947851694, "Lcom/baidu/tieba/if8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947851694, "Lcom/baidu/tieba/if8;");
                return;
            }
        }
        a = new b(null);
        d = new a();
    }
}
