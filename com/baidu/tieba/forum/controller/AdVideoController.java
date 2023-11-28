package com.baidu.tieba.forum.controller;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.ar6;
import com.baidu.tieba.bk7;
import com.baidu.tieba.ck7;
import com.baidu.tieba.du7;
import com.baidu.tieba.eo7;
import com.baidu.tieba.fo7;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.forum.view.BottomWebView;
import com.baidu.tieba.forum.viewmodel.BottomViewModel;
import com.baidu.tieba.ki7;
import com.baidu.tieba.kj6;
import com.baidu.tieba.nj6;
import com.baidu.tieba.oj7;
import com.baidu.tieba.pf1;
import com.baidu.tieba.pt7;
import com.baidu.tieba.se7;
import com.baidu.tieba.sh7;
import com.baidu.tieba.ue7;
import com.baidu.tieba.v05;
import com.baidu.tieba.wj7;
import com.baidu.tieba.wq6;
import com.baidu.tieba.xh7;
import com.baidu.tieba.xq6;
import com.baidu.tieba.zua;
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
public final class AdVideoController extends sh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity b;
    public se7 c;
    public zua d;
    public ForumData e;
    public BottomWebView f;
    public ue7 g;
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
                if (this.a.J()) {
                    kj6 a = nj6.a();
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
                        jSONObject.put("networkStatus", eo7.a());
                        kj6 a = nj6.a();
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
    public static final class c extends ar6<wj7> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdVideoController b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AdVideoController adVideoController, Class<wj7> cls) {
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
        @Override // com.baidu.tieba.ar6
        public void onEvent(wj7 event) {
            ki7 value;
            ForumData forumData;
            String id;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (Intrinsics.areEqual(xh7.a(this.b.A()), event.a()) && (value = ((BottomViewModel) new ViewModelProvider(this.b.A()).get(BottomViewModel.class)).a().getValue()) != null) {
                    AdVideoController adVideoController = this.b;
                    BusinessPromot b = value.b();
                    if (b != null) {
                        adVideoController.d = new zua();
                        zua zuaVar = adVideoController.d;
                        Intrinsics.checkNotNull(zuaVar);
                        zuaVar.t(b);
                    }
                    adVideoController.e = new ForumData();
                    ForumData forumData2 = adVideoController.e;
                    Intrinsics.checkNotNull(forumData2);
                    forumData2.parserProtobuf(value.d());
                    if (!adVideoController.K(adVideoController.d, adVideoController.e) && (forumData = adVideoController.e) != null && (id = forumData.getId()) != null) {
                        Intrinsics.checkNotNullExpressionValue(id, "id");
                        adVideoController.D(id);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends ar6<oj7> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdVideoController b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AdVideoController adVideoController, Class<oj7> cls) {
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
        @Override // com.baidu.tieba.ar6
        public void onEvent(oj7 event) {
            se7 se7Var;
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                se7 se7Var2 = this.b.c;
                se7 se7Var3 = null;
                if (se7Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("forumAdVideoController");
                    se7Var = null;
                } else {
                    se7Var = se7Var2;
                }
                se7Var.n(event.a().b(), event.a().c(), event.a().d(), event.a().a());
                se7 se7Var4 = this.b.c;
                if (se7Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("forumAdVideoController");
                    se7Var4 = null;
                }
                zua zuaVar = this.b.d;
                ForumData forumData = this.b.e;
                ForumData forumData2 = this.b.e;
                if (forumData2 != null) {
                    str = forumData2.getId();
                } else {
                    str = null;
                }
                se7Var4.o(zuaVar, forumData, JavaTypesHelper.toLong(str, 0L));
                zua zuaVar2 = this.b.d;
                ForumData forumData3 = this.b.e;
                if (forumData3 != null) {
                    str2 = forumData3.getId();
                } else {
                    str2 = null;
                }
                if (bk7.e(zuaVar2, str2)) {
                    se7 se7Var5 = this.b.c;
                    if (se7Var5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("forumAdVideoController");
                    } else {
                        se7Var3 = se7Var5;
                    }
                    se7Var3.q();
                }
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

    public final void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            long a2 = ck7.b.a().a(str);
            this.m = a2;
            if (a2 > 0) {
                YunDialogManager.onShow(this.b, v05.q);
            } else {
                H(str);
            }
        }
    }

    public final void H(final String str) {
        pf1<pt7> a2;
        pt7 pt7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && (a2 = new du7().a()) != null && (pt7Var = a2.get()) != null) {
            pt7Var.a(str, new Function1<Long, Unit>(this, str) { // from class: com.baidu.tieba.forum.controller.AdVideoController$runFrsYunDialogAfterGetLastVisitTime$1
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
                    if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                        YunDialogManager.onShow(this.this$0.A(), v05.q);
                        if (this.this$0.J()) {
                            kj6 a3 = nj6.a();
                            BottomWebView bottomWebView = this.this$0.f;
                            if (bottomWebView == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                                bottomWebView = null;
                            }
                            a3.i(bottomWebView, "frsPage.bannerPromptEnd", new JSONObject());
                        }
                        this.this$0.m = j;
                        ck7.b.a().b(this.$fid, j);
                    }
                }
            });
        }
    }

    public final void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.h = z;
            this.l = z;
        }
    }

    public final FragmentActivity A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (FragmentActivity) invokeV.objValue;
    }

    public final boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    public final boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.j;
        }
        return invokeV.booleanValue;
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            xq6.b().b(new wq6(f(), Reflection.getOrCreateKotlinClass(wj7.class)), new c(this, wj7.class));
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            xq6.b().b(new wq6(f(), Reflection.getOrCreateKotlinClass(oj7.class)), new d(this, oj7.class));
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            o(this.o);
            o(this.n);
        }
    }

    public final boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.k) {
                return true;
            }
            if (!C() && !R0()) {
                return this.l;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public final long i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.m;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.sh7
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.l();
        }
    }

    @Override // com.baidu.tieba.sh7
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.m();
            se7 se7Var = this.c;
            if (se7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forumAdVideoController");
                se7Var = null;
            }
            se7Var.l();
        }
    }

    @Override // com.baidu.tieba.sh7
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.n();
            se7 se7Var = this.c;
            if (se7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forumAdVideoController");
                se7Var = null;
            }
            se7Var.m();
        }
    }

    public final boolean K(zua zuaVar, ForumData forumData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, zuaVar, forumData)) == null) {
            if (!B()) {
                if (zuaVar != null && !StringUtils.isNull(zuaVar.r()) && forumData != null) {
                    boolean e = bk7.e(zuaVar, forumData.getId());
                    this.j = e;
                    I(e);
                    return this.j;
                }
                ue7 ue7Var = new ue7(fo7.a(this.b));
                this.g = ue7Var;
                if (ue7Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFrsDialogADController");
                    ue7Var = null;
                }
                boolean j = ue7Var.j(zuaVar, forumData);
                this.i = j;
                I(j);
                return this.i;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.sh7
    public void k(Bundle bundle, ActivityForumBinding binding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, bundle, binding) == null) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            super.k(bundle, binding);
            BottomWebView bottomWebView = binding.d;
            Intrinsics.checkNotNullExpressionValue(bottomWebView, "binding.bottomWeb");
            this.f = bottomWebView;
            this.c = new se7(this.b);
            F();
            E();
            G();
        }
    }
}
