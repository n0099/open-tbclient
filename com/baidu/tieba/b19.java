package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.UiUtils;
import com.baidu.android.imsdk.chatmessage.request.IMEmojiReplyDetailListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.b19;
import com.baidu.tieba.im.lib.socket.msg.data.EmojiData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.data.EmojiDetailUserInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.MsgContentMergeUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class b19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<BaseFragmentActivity> a;
    public final EmojiData b;
    public final long c;
    public final BdUniqueId d;
    public FastRequest e;
    public volatile long f;

    /* loaded from: classes5.dex */
    public static final class a implements uk5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b19 a;
        public final /* synthetic */ x09 b;

        /* renamed from: com.baidu.tieba.b19$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0236a extends FastRequest.b<MsgContentMergeUtil.Result> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ x09 d;
            public final /* synthetic */ int e;

            public C0236a(x09 x09Var, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {x09Var, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = x09Var;
                this.e = i;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.net.FastRequest.b
            /* renamed from: l */
            public void f(int i, String errMsg, MsgContentMergeUtil.Result result) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, errMsg, result) == null) {
                    Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                    this.d.onFailure(i, errMsg);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.net.FastRequest.b
            /* renamed from: m */
            public void i(MsgContentMergeUtil.Result result) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, result) == null) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    ArrayList arrayList = new ArrayList();
                    Map<String, Object> userInfo = result.getUserInfo();
                    if (userInfo != null) {
                        for (Map.Entry<String, Object> entry : userInfo.entrySet()) {
                            arrayList.add(DataExt.toEntity(DataExt.toMap(entry.getValue()), EmojiDetailUserInfo.class));
                        }
                    }
                    x09 x09Var = this.d;
                    boolean z = true;
                    if (this.e != 1) {
                        z = false;
                    }
                    x09Var.a(z, arrayList);
                }
            }
        }

        public a(b19 b19Var, x09 x09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b19Var, x09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b19Var;
            this.b = x09Var;
        }

        public static final void b(x09 callback, int i, String errorMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(65537, null, callback, i, errorMsg) == null) {
                Intrinsics.checkNotNullParameter(callback, "$callback");
                Intrinsics.checkNotNullParameter(errorMsg, "$errorMsg");
                callback.onFailure(i, errorMsg);
            }
        }

        public static final void c(b19 this$0) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, null, this$0) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                FastRequest fastRequest = this$0.e;
                if (fastRequest != null) {
                    fastRequest.Q();
                }
            }
        }

        @Override // com.baidu.tieba.uk5
        public void a(int i, List<? extends IMEmojiReplyDetailListener.IMEmojiReplyReactionDetail> details) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, details) == null) {
                Intrinsics.checkNotNullParameter(details, "details");
                if (this.a.e == null) {
                    b19 b19Var = this.a;
                    b19Var.e = new FastRequest(b19Var.a, CmdConfigHttp.CMD_GET_CHAT_ROOM_INIT_INFO, TbConfig.GET_CHAT_ROOM_INIT_INFO);
                    FastRequest fastRequest = this.a.e;
                    Intrinsics.checkNotNull(fastRequest);
                    fastRequest.setUniqueId(this.a.d);
                }
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(details, 10));
                for (IMEmojiReplyDetailListener.IMEmojiReplyReactionDetail iMEmojiReplyReactionDetail : details) {
                    arrayList.add(iMEmojiReplyReactionDetail.bduk);
                }
                this.a.f = ((IMEmojiReplyDetailListener.IMEmojiReplyReactionDetail) CollectionsKt___CollectionsKt.last((List<? extends Object>) details)).sortTimeUs;
                FastRequest fastRequest2 = this.a.e;
                Intrinsics.checkNotNull(fastRequest2);
                fastRequest2.P("scene", "2");
                fastRequest2.P("chatroom_id", String.valueOf(this.a.c));
                fastRequest2.P("uks", DataExt.toJson(arrayList));
                fastRequest2.X(2000);
                fastRequest2.S(2000);
                fastRequest2.Z(1);
                fastRequest2.R(new C0236a(this.b, i));
                final b19 b19Var2 = this.a;
                UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.a19
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            b19.a.c(b19.this);
                        }
                    }
                });
            }
        }

        @Override // com.baidu.tieba.uk5
        public void onFailure(final int i, final String errorMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, errorMsg) == null) {
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                final x09 x09Var = this.b;
                UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.z09
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            b19.a.b(x09.this, i, errorMsg);
                        }
                    }
                });
            }
        }
    }

    public b19(TbPageContext<BaseFragmentActivity> pageContext, EmojiData emoji, long j, BdUniqueId uniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext, emoji, Long.valueOf(j), uniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        this.a = pageContext;
        this.b = emoji;
        this.c = j;
        this.d = uniqueId;
        this.f = 1L;
    }

    public final void g(x09 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, callback) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            hk5.b().p(this.a.getPageActivity(), this.c, this.b.getMsgId(), this.b.getContent(), this.f, 20, new a(this, callback));
        }
    }
}
