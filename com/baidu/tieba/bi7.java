package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.PublishProgressData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.view.PublishProgressView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.vcode.VcodeTool;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.forum.viewmodel.BottomViewModel;
import com.baidu.tieba.forum.viewmodel.ForumViewModel;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.WriteMsgHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.FeedKV;
import tbclient.FeedLayout;
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.PageData;
import tbclient.LayoutFactory;
/* loaded from: classes5.dex */
public final class bi7 extends xh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity b;
    public ForumData c;
    public final int d;
    public PublishProgressView e;
    public final CustomMessageListener f;
    public final CustomMessageListener g;
    public final HttpMessageListener h;
    public final CustomMessageListener i;

    /* loaded from: classes5.dex */
    public static final class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bi7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(bi7 bi7Var) {
            super(CmdConfigHttp.CMD_GET_MY_POST);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bi7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bi7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(HttpResponsedMessage responsedMessage) {
            boolean z;
            String errorString;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (responsedMessage.getOrginalMessage() != null) {
                    Object extra = responsedMessage.getOrginalMessage().getExtra();
                    if (extra instanceof RequestGetMyPostNetMessage) {
                        z = ((RequestGetMyPostNetMessage) extra).showErrorToast();
                        JSONObject jSONObject = new JSONObject();
                        if (!(responsedMessage instanceof GetMyPostHttpResponseMessage)) {
                            GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                            if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                                errorString = this.a.x().getResources().getString(R.string.obfuscated_res_0x7f0f0e70);
                            } else {
                                errorString = getMyPostHttpResponseMessage.getErrorString();
                            }
                            if ((responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage) && (requestGetMyPostNetMessage = (RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()) != null) {
                                jSONObject = this.a.y(requestGetMyPostNetMessage);
                            }
                            if (!z && getMyPostHttpResponseMessage.getError() != 0) {
                                return;
                            }
                            bi7 bi7Var = this.a;
                            int error = getMyPostHttpResponseMessage.getError();
                            Intrinsics.checkNotNullExpressionValue(errorString, "errorString");
                            bi7Var.A(error, errorString, getMyPostHttpResponseMessage.getResponseData(), jSONObject);
                            return;
                        }
                        return;
                    }
                }
                z = true;
                JSONObject jSONObject2 = new JSONObject();
                if (!(responsedMessage instanceof GetMyPostHttpResponseMessage)) {
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bi7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(bi7 bi7Var) {
            super(2001378);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bi7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bi7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (responsedMessage.getData() instanceof WriteData) {
                    WriteData writeData = (WriteData) responsedMessage.getData();
                    Intrinsics.checkNotNull(writeData);
                    String forumId = writeData.getForumId();
                    ForumData forumData = this.a.c;
                    if (forumData == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("forumData");
                        forumData = null;
                    }
                    if (StringHelper.equals(forumId, forumData.getId())) {
                        bi7 bi7Var = this.a;
                        WriteData writeData2 = (WriteData) responsedMessage.getData();
                        Intrinsics.checkNotNull(writeData2);
                        bi7Var.C(writeData2.getTabId());
                        MessageManager.getInstance().abortResponsedMessage(responsedMessage);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bi7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(bi7 bi7Var) {
            super(2001383);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bi7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bi7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (!(responsedMessage.getData() instanceof PostWriteCallBackData)) {
                    return;
                }
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) responsedMessage.getData();
                this.a.I(postWriteCallBackData);
                if (!this.a.B(postWriteCallBackData)) {
                    this.a.w(postWriteCallBackData);
                } else if (this.a.x() instanceof TbPageContextSupport) {
                    yb5.c(((TbPageContextSupport) this.a.x()).getPageContext(), postWriteCallBackData, 1);
                } else {
                    yb5.c(TbadkApplication.getInst().getCurrentPageContext(this.a.x()), postWriteCallBackData, 1);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bi7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(bi7 bi7Var) {
            super(2921526);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bi7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bi7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responseMessage) {
            PublishProgressData publishProgressData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responseMessage) == null) {
                Intrinsics.checkNotNullParameter(responseMessage, "responseMessage");
                if (responseMessage.getData() == null || !(responseMessage.getData() instanceof PublishProgressData) || (publishProgressData = (PublishProgressData) responseMessage.getData()) == null || WriteMsgHolder.isFromVideoHotTopic() || WriteMsgHolder.getCurrentWriteActivityFromTag() == null) {
                    return;
                }
                PublishProgressView publishProgressView = this.a.e;
                if (publishProgressView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("publishProgressView");
                    publishProgressView = null;
                }
                publishProgressView.c(publishProgressData);
            }
        }
    }

    public bi7(FragmentActivity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.b = activity;
        this.d = 1000;
        this.f = new c(this);
        this.g = new d(this);
        this.h = new a(this);
        this.i = new b(this);
    }

    public final boolean w(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || rd.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
                return false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.b).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return invokeL.booleanValue;
    }

    public static final void G(bi7 this$0, pi7 pi7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, pi7Var) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ForumData forumData = new ForumData();
            this$0.c = forumData;
            if (forumData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forumData");
                forumData = null;
            }
            forumData.parserProtobuf(pi7Var.d());
        }
    }

    @Override // com.baidu.tieba.xh7
    public void k(Bundle bundle, ActivityForumBinding binding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bundle, binding) == null) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            super.k(bundle, binding);
            PublishProgressView publishProgressView = binding.i;
            Intrinsics.checkNotNullExpressionValue(publishProgressView, "binding.forumPublishProgressView");
            this.e = publishProgressView;
            F();
            H();
        }
    }

    public static final void J(long j, long j2, long j3, bi7 this$0) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), this$0}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            if (TbImageHelper.getInstance().isShowBigImage()) {
                i = 2;
            } else {
                i = 1;
            }
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setParams(j, j2, j3, equipmentWidth, equipmentHeight, f, i);
            si7 value = ((ForumViewModel) new ViewModelProvider(this$0.b).get(ForumViewModel.class)).c().getValue();
            if (value != null) {
                requestGetMyPostNetMessage.setFrsCommonInfo(value.j());
            }
            requestGetMyPostNetMessage.setIsNewFrs(1);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    public final boolean B(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void C(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (i == 0) {
                i = ci7.m(this.b).C();
            }
            if (ci7.m(this.b).y(i) != null) {
                ci7.m(this.b).L(i);
            }
        }
    }

    public final void A(int i, String str, GetMyPostResIdl getMyPostResIdl, JSONObject jSONObject) {
        DataRes dataRes;
        PageData pageData;
        LayoutFactory layoutFactory;
        a97 a97Var;
        FeedLayout feedLayout;
        List<FeedKV> business_info;
        String str2;
        Integer intOrNull;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, getMyPostResIdl, jSONObject}) == null) {
            if (i != 0) {
                BdUtilHelper.showToast(this.b, str);
            } else if (getMyPostResIdl != null && (dataRes = getMyPostResIdl.data) != null && (pageData = dataRes.page_data) != null && (layoutFactory = pageData.feed) != null && (a97Var = j77.a().get(layoutFactory.layout)) != null) {
                sb7<?> templateData = a97Var.b(layoutFactory);
                int i2 = 0;
                if (Intrinsics.areEqual(layoutFactory.layout, "feed") && (feedLayout = layoutFactory.feed) != null && (business_info = feedLayout.business_info) != null) {
                    Intrinsics.checkNotNullExpressionValue(business_info, "business_info");
                    Map<String, String> b2 = i97.b(business_info);
                    if (b2 != null && (str2 = b2.get("inner_tab_id")) != null && (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str2)) != null) {
                        i2 = intOrNull.intValue();
                    }
                }
                Intrinsics.checkNotNullExpressionValue(templateData, "templateData");
                D(templateData, jSONObject, i2);
            }
        }
    }

    public final void D(sb7<?> sb7Var, JSONObject jSONObject, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, sb7Var, jSONObject, i) == null) {
            if (i == 0) {
                i = ci7.m(this.b).C();
            }
            zn7 y = ci7.m(this.b).y(i);
            if (y != null) {
                ci7.m(this.b).L(i);
                if (y.a() instanceof ao7) {
                    ((ao7) y.a()).U0(sb7Var, jSONObject);
                }
            }
        }
    }

    public final void E(gy4 gy4Var, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, gy4Var, jSONObject) == null) {
            int tabId = gy4Var.getTabId();
            if (tabId == 0) {
                tabId = ci7.m(this.b).C();
            }
            zn7 y = ci7.m(this.b).y(tabId);
            if (y != null) {
                ci7.m(this.b).L(tabId);
                if (y.a() instanceof ao7) {
                    ((ao7) y.a()).C2(gy4Var, jSONObject);
                }
            }
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ((BottomViewModel) new ViewModelProvider(this.b).get(BottomViewModel.class)).a().observe(this.b, new Observer() { // from class: com.baidu.tieba.bh7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        bi7.G(bi7.this, (pi7) obj);
                    }
                }
            });
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            o(this.f);
            o(this.h);
            o(this.g);
            this.i.setSelfListener(true);
            o(this.i);
        }
    }

    @Override // com.baidu.tieba.xh7
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.l();
        }
    }

    public final FragmentActivity x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.b;
        }
        return (FragmentActivity) invokeV.objValue;
    }

    public final void I(PostWriteCallBackData postWriteCallBackData) {
        String str;
        String str2;
        String str3;
        int i;
        UserData s;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, postWriteCallBackData) == null) && postWriteCallBackData != null) {
            final long j = JavaTypesHelper.toLong(postWriteCallBackData.getPostId(), 0L);
            final long j2 = JavaTypesHelper.toLong(postWriteCallBackData.getThreadId(), 0L);
            ForumData forumData = this.c;
            if (forumData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forumData");
                forumData = null;
            }
            final long j3 = JavaTypesHelper.toLong(forumData.getId(), 0L);
            if (j != 0 && j2 != 0 && j3 != 0) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.ch7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            bi7.J(j2, j, j3, this);
                        }
                    }
                }, this.d);
                return;
            }
            WriteData writeData = postWriteCallBackData.writeDataForVideo;
            if (writeData != null) {
                writeData.setForumId(null);
                writeData.setForumName(null);
                gy4 gy4Var = new gy4();
                gy4Var.parseFromWriteData(writeData);
                String forumId = writeData.getForumId();
                if (forumId == null) {
                    str = "";
                } else {
                    str = forumId;
                }
                String threadId = writeData.getThreadId();
                if (threadId == null) {
                    str2 = "";
                } else {
                    str2 = threadId;
                }
                String repostId = writeData.getRepostId();
                if (repostId == null) {
                    str3 = "";
                } else {
                    str3 = repostId;
                }
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    i = 2;
                } else {
                    i = 1;
                }
                JSONObject z = z(str, str2, str3, i, "", "0");
                si7 value = ((ForumViewModel) new ViewModelProvider(this.b).get(ForumViewModel.class)).c().getValue();
                if (value != null && (s = value.s()) != null) {
                    gy4Var.setIsManager(s.getIs_manager());
                }
                E(gy4Var, z);
            }
        }
    }

    @Override // com.baidu.tieba.xh7
    public void g(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, intent) == null) {
            super.g(i, i2, intent);
            VcodeTool.tryProcessActivityResultOnWriteScene(i, i2, intent);
        }
    }

    public final JSONObject y(RequestGetMyPostNetMessage requestGetMyPostNetMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, requestGetMyPostNetMessage)) == null) {
            return z(String.valueOf(requestGetMyPostNetMessage.getForumId()), String.valueOf(requestGetMyPostNetMessage.getThreadId()), String.valueOf(requestGetMyPostNetMessage.getPostId()), requestGetMyPostNetMessage.getQType(), requestGetMyPostNetMessage.getFrom(), String.valueOf(requestGetMyPostNetMessage.getCallFrom()));
        }
        return (JSONObject) invokeL.objValue;
    }

    public final JSONObject z(String str, String str2, String str3, int i, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{str, str2, str3, Integer.valueOf(i), str4, str5})) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("forum_id", str);
                jSONObject.put("thread_id", str2);
                jSONObject.put("post_id", str3);
                jSONObject.put("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
                jSONObject.put("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
                jSONObject.put("scr_dip", Float.valueOf(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density));
                jSONObject.put("q_type", i);
                if (str4 == null) {
                    str4 = "";
                }
                jSONObject.put("bfrom", str4);
                jSONObject.put(IntentConfig.CALL_FROM, str5);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeCommon.objValue;
    }
}
