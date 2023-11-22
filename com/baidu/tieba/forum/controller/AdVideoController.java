package com.baidu.tieba.forum.controller;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.ai7;
import com.baidu.tieba.bj6;
import com.baidu.tieba.dr7;
import com.baidu.tieba.ej6;
import com.baidu.tieba.fe7;
import com.baidu.tieba.fh7;
import com.baidu.tieba.forum.controller.AdVideoController;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.forum.view.BottomWebView;
import com.baidu.tieba.forum.viewmodel.BottomViewModel;
import com.baidu.tieba.gqa;
import com.baidu.tieba.he7;
import com.baidu.tieba.ki7;
import com.baidu.tieba.li7;
import com.baidu.tieba.mq6;
import com.baidu.tieba.nq6;
import com.baidu.tieba.of1;
import com.baidu.tieba.pg7;
import com.baidu.tieba.qq6;
import com.baidu.tieba.s05;
import com.baidu.tieba.sr7;
import com.baidu.tieba.xl7;
import com.baidu.tieba.yl7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;
import tbclient.FrsPage.BusinessPromot;
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001c\u001a\u00020\u0010J\u0006\u0010\u001d\u001a\u00020\u0012J\u0006\u0010\u001e\u001a\u00020\u0010J\u0006\u0010\u001f\u001a\u00020\u0010J\u001a\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020!H\u0016J\b\u0010'\u001a\u00020!H\u0016J\b\u0010(\u001a\u00020!H\u0016J\u0010\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020!H\u0002J\b\u0010-\u001a\u00020!H\u0002J\b\u0010.\u001a\u00020!H\u0002J\u0010\u0010/\u001a\u00020!2\u0006\u0010*\u001a\u00020+H\u0002J\u000e\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020\u0010J\b\u00102\u001a\u00020\u0010H\u0002J\u001a\u00103\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/baidu/tieba/forum/controller/AdVideoController;", "Lcom/baidu/tieba/forum/controller/BaseActivityController;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "bottomWebView", "Lcom/baidu/tieba/forum/view/BottomWebView;", "businessPromot", "Lcom/baidu/tieba/tbadkCore/FrsBusinessPromot;", "forumAdVideoController", "Lcom/baidu/tieba/forum/ad/ForumAdVideoController;", "forumData", "Lcom/baidu/tbadk/core/data/ForumData;", "isLighthouseComplete", "", "lastVisitTime", "", "mFrsDialogADController", "Lcom/baidu/tieba/forum/ad/ForumDialogADController;", "mFrsLighthouseCompleteListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mIsDialogHadShow", "mIsFrsADDialogShowed", "mIsFrsAdVideoDialogShowed", "mIsNeedStartVideo", "mNetWorkChangedListener", "getIsDialogHadShow", "getLastVisitTime", "isDialogVideoHadShow", "isFrsADDialogShowed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "binding", "Lcom/baidu/tieba/forum/databinding/ActivityForumBinding;", MissionEvent.MESSAGE_DESTROY, MissionEvent.MESSAGE_PAUSE, "onResume", "prepareYunDialogLogic", "fid", "", "registerAdDataEvent", "registerAdLocationEvent", "registerMessageListener", "runFrsYunDialogAfterGetLastVisitTime", "setIsDialogHadShow", "hadShow", "shouldAutoPlayHeadVideo", "showAdDialog", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AdVideoController extends pg7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity b;
    public fe7 c;
    public gqa d;
    public ForumData e;
    public BottomWebView f;
    public he7 g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public long m;
    public final CustomMessageListener n;
    public CustomMessageListener o;

    /* loaded from: classes6.dex */
    public static final class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdVideoController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AdVideoController adVideoController) {
            super(2921682);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adVideoController};
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
            this.a = adVideoController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (!(responsedMessage.getData() instanceof Integer)) {
                    return;
                }
                this.a.k = true;
                if (this.a.G()) {
                    bj6 a = ej6.a();
                    BottomWebView bottomWebView = this.a.f;
                    if (bottomWebView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                        bottomWebView = null;
                    }
                    a.i(bottomWebView, "frsPage.bannerPromptEnd", new JSONObject());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdVideoController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AdVideoController adVideoController) {
            super(2000994);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adVideoController};
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
            this.a = adVideoController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            CustomResponsedMessage<?> customResponsedMessage2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                    z = true;
                } else {
                    z = false;
                }
                BottomWebView bottomWebView = null;
                if (z) {
                    customResponsedMessage2 = customResponsedMessage;
                } else {
                    customResponsedMessage2 = null;
                }
                if (customResponsedMessage2 != null) {
                    if (!(!customResponsedMessage.hasError())) {
                        customResponsedMessage2 = null;
                    }
                    if (customResponsedMessage2 != null) {
                        AdVideoController adVideoController = this.a;
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("networkStatus", xl7.a());
                        bj6 a = ej6.a();
                        BottomWebView bottomWebView2 = adVideoController.f;
                        if (bottomWebView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                        } else {
                            bottomWebView = bottomWebView2;
                        }
                        a.i(bottomWebView, "frsPageNa.netWorkChange", jSONObject);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends qq6<ai7> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdVideoController b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AdVideoController adVideoController, Class<ai7> cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adVideoController, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = adVideoController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qq6
        public void onEvent(ai7 event) {
            fe7 fe7Var;
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                fe7 fe7Var2 = this.b.c;
                fe7 fe7Var3 = null;
                if (fe7Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("forumAdVideoController");
                    fe7Var = null;
                } else {
                    fe7Var = fe7Var2;
                }
                fe7Var.n(event.a().b(), event.a().c(), event.a().d(), event.a().a());
                fe7 fe7Var4 = this.b.c;
                if (fe7Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("forumAdVideoController");
                    fe7Var4 = null;
                }
                gqa gqaVar = this.b.d;
                ForumData forumData = this.b.e;
                ForumData forumData2 = this.b.e;
                if (forumData2 != null) {
                    str = forumData2.getId();
                } else {
                    str = null;
                }
                fe7Var4.o(gqaVar, forumData, JavaTypesHelper.toLong(str, 0L));
                gqa gqaVar2 = this.b.d;
                ForumData forumData3 = this.b.e;
                if (forumData3 != null) {
                    str2 = forumData3.getId();
                } else {
                    str2 = null;
                }
                if (!ki7.e(gqaVar2, str2)) {
                    return;
                }
                fe7 fe7Var5 = this.b.c;
                if (fe7Var5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("forumAdVideoController");
                } else {
                    fe7Var3 = fe7Var5;
                }
                fe7Var3.q();
            }
        }
    }

    public AdVideoController(FragmentActivity activity) {
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
        this.m = -1L;
        this.n = new a(this);
        this.o = new b(this);
    }

    public static final void B(AdVideoController this$0, fh7 fh7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, fh7Var) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            BusinessPromot c2 = fh7Var.c();
            if (c2 != null) {
                gqa gqaVar = new gqa();
                this$0.d = gqaVar;
                Intrinsics.checkNotNull(gqaVar);
                gqaVar.t(c2);
            }
            ForumData forumData = new ForumData();
            this$0.e = forumData;
            Intrinsics.checkNotNull(forumData);
            forumData.parserProtobuf(fh7Var.e());
            if (!this$0.H(this$0.d, this$0.e)) {
                ForumData forumData2 = this$0.e;
                Intrinsics.checkNotNull(forumData2);
                String id = forumData2.getId();
                Intrinsics.checkNotNullExpressionValue(id, "forumData!!.id");
                this$0.z(id);
            }
        }
    }

    public final boolean H(gqa gqaVar, ForumData forumData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, gqaVar, forumData)) == null) {
            if (!x()) {
                if (gqaVar != null && !StringUtils.isNull(gqaVar.r()) && forumData != null) {
                    boolean e = ki7.e(gqaVar, forumData.getId());
                    this.j = e;
                    F(e);
                    return this.j;
                }
                he7 he7Var = new he7(yl7.a(this.b));
                this.g = he7Var;
                if (he7Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFrsDialogADController");
                    he7Var = null;
                }
                boolean j = he7Var.j(gqaVar, forumData);
                this.i = j;
                F(j);
                return this.i;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void E(final String str) {
        of1<dr7> a2;
        dr7 dr7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (a2 = new sr7().a()) != null && (dr7Var = a2.get()) != null) {
            dr7Var.a(str, new Function1<Long, Unit>(this, str) { // from class: com.baidu.tieba.forum.controller.AdVideoController$runFrsYunDialogAfterGetLastVisitTime$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String $fid;
                public final /* synthetic */ AdVideoController this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.$fid = str;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                    invoke(l.longValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) != null) {
                        return;
                    }
                    this.this$0.m = j;
                    li7.b.a().b(this.$fid, j);
                    YunDialogManager.onShow(this.this$0.w(), s05.q);
                    if (this.this$0.G()) {
                        bj6 a3 = ej6.a();
                        BottomWebView bottomWebView = this.this$0.f;
                        if (bottomWebView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                            bottomWebView = null;
                        }
                        a3.i(bottomWebView, "frsPage.bannerPromptEnd", new JSONObject());
                    }
                }
            });
        }
    }

    public final void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.h = z;
            this.l = z;
        }
    }

    public final void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            long a2 = li7.b.a().a(str);
            this.m = a2;
            if (a2 > 0) {
                YunDialogManager.onShow(this.b, s05.q);
            } else {
                E(str);
            }
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ((BottomViewModel) new ViewModelProvider(this.b).get(BottomViewModel.class)).a().observe(this.b, new Observer() { // from class: com.baidu.tieba.cf7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        AdVideoController.B(AdVideoController.this, (fh7) obj);
                    }
                }
            });
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            nq6.b().b(new mq6(f(), Reflection.getOrCreateKotlinClass(ai7.class)), new c(this, ai7.class));
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().registerListener(this.o);
            MessageManager.getInstance().registerListener(this.n);
        }
    }

    public final boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.k) {
                return true;
            }
            if (!y() && !M0()) {
                return this.l;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public final long W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.m;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.pg7
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.l();
            MessageManager.getInstance().unRegisterListener(this.o);
            MessageManager.getInstance().unRegisterListener(this.n);
        }
    }

    @Override // com.baidu.tieba.pg7
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.m();
            fe7 fe7Var = this.c;
            if (fe7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forumAdVideoController");
                fe7Var = null;
            }
            fe7Var.l();
        }
    }

    @Override // com.baidu.tieba.pg7
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.n();
            fe7 fe7Var = this.c;
            if (fe7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forumAdVideoController");
                fe7Var = null;
            }
            fe7Var.m();
        }
    }

    public final FragmentActivity w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.b;
        }
        return (FragmentActivity) invokeV.objValue;
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.j;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.pg7
    public void k(Bundle bundle, ActivityForumBinding binding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bundle, binding) == null) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            super.k(bundle, binding);
            BottomWebView bottomWebView = binding.d;
            Intrinsics.checkNotNullExpressionValue(bottomWebView, "binding.bottomWeb");
            this.f = bottomWebView;
            this.c = new fe7(this.b);
            C();
            A();
            D();
        }
    }
}
