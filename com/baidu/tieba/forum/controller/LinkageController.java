package com.baidu.tieba.forum.controller;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.ap7;
import com.baidu.tieba.ar6;
import com.baidu.tieba.br6;
import com.baidu.tieba.ci7;
import com.baidu.tieba.er6;
import com.baidu.tieba.ff7;
import com.baidu.tieba.forum.ForumActivity;
import com.baidu.tieba.forum.ForumLog;
import com.baidu.tieba.forum.controller.LinkageController;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.forum.secondfloor.SecondFloorVisitHelper;
import com.baidu.tieba.forum.strategy.BaseLayoutStrategy;
import com.baidu.tieba.forum.strategy.FullWebLayoutStrategy;
import com.baidu.tieba.forum.strategy.NonFullWebLayoutStrategy;
import com.baidu.tieba.forum.viewmodel.BottomViewModel;
import com.baidu.tieba.forum.viewmodel.ForumViewModel;
import com.baidu.tieba.forum.viewmodel.TopViewModel;
import com.baidu.tieba.forum.widget.TbLinkageScrollView;
import com.baidu.tieba.forum.widget.TbNestedScrollView;
import com.baidu.tieba.gf7;
import com.baidu.tieba.gi7;
import com.baidu.tieba.hf7;
import com.baidu.tieba.hi7;
import com.baidu.tieba.hp7;
import com.baidu.tieba.if7;
import com.baidu.tieba.im.dispatcher.AiBotChatDispatcher;
import com.baidu.tieba.jf7;
import com.baidu.tieba.ji7;
import com.baidu.tieba.jn7;
import com.baidu.tieba.lm7;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.mf7;
import com.baidu.tieba.om7;
import com.baidu.tieba.pi7;
import com.baidu.tieba.pm7;
import com.baidu.tieba.s87;
import com.baidu.tieba.si7;
import com.baidu.tieba.xh7;
import com.baidu.tieba.xi7;
import com.baidu.tieba.zj7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.DelayTB;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;
import tbclient.FrsBottomSmartBgColor;
import tbclient.FrsPage.ForumInfo;
import tbclient.FrsPage.FrsBottom;
@Metadata(d1 = {"\u0000·\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r*\u0001\f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020\u0014H\u0002J\u0006\u00104\u001a\u00020\u0014J\u0012\u00105\u001a\u00020\u00142\b\b\u0002\u00106\u001a\u000207H\u0002J\u0006\u00108\u001a\u00020\u0014J\b\u00109\u001a\u00020\u0014H\u0002J\u0006\u0010:\u001a\u00020;J\b\u0010<\u001a\u00020\u0014H\u0002J\b\u0010=\u001a\u00020\u0014H\u0002J\"\u0010>\u001a\u00020\u00142\u0006\u0010?\u001a\u00020\"2\u0006\u0010@\u001a\u00020\"2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010C\u001a\u00020;H\u0016J\u0010\u0010D\u001a\u00020\u00142\u0006\u0010E\u001a\u00020\"H\u0016J\u0010\u0010F\u001a\u00020\u00142\u0006\u0010G\u001a\u00020HH\u0016J\u001a\u0010I\u001a\u00020\u00142\b\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010L\u001a\u00020\u0014H\u0016J\b\u0010M\u001a\u00020\u0014H\u0016J4\u0010N\u001a\u00020\u00142\u0006\u0010O\u001a\u00020\u000f2\u0010\b\u0002\u0010P\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u0010\b\u0002\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0002J\b\u0010R\u001a\u00020\u0014H\u0002J\b\u0010S\u001a\u00020\u0014H\u0002J\u0006\u0010T\u001a\u00020;J\u0006\u0010U\u001a\u00020\u0014J\b\u0010V\u001a\u00020\u0014H\u0002J\u0006\u0010W\u001a\u00020\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010#\u001a\f\u0012\u0006\b\u0001\u0012\u00020%\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R>\u0010&\u001a2\u0012\u0013\u0012\u00110(¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110,¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00140'X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00140/X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/baidu/tieba/forum/controller/LinkageController;", "Lcom/baidu/tieba/forum/controller/BaseActivityController;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "TAG", "", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "binding", "Lcom/baidu/tieba/forum/databinding/ActivityForumBinding;", "bubbleClickListener", "com/baidu/tieba/forum/controller/LinkageController$bubbleClickListener$1", "Lcom/baidu/tieba/forum/controller/LinkageController$bubbleClickListener$1;", "cachedH5HeightWrapper", "Lcom/baidu/tieba/forum/event/H5HeightEvent$H5HeightWrapper;", "guideBubble", "Lcom/baidu/tieba/forum/data/GuideBubbleData;", "initPositionInvoke", "Lkotlin/Function0;", "", "layoutStrategy", "Lcom/baidu/tieba/forum/strategy/ILinkageLayoutStrategy;", "linkageStatisticListener", "Lcom/baidu/tieba/forum/controller/LinkageStatisticController;", "getLinkageStatisticListener", "()Lcom/baidu/tieba/forum/controller/LinkageStatisticController;", "linkageStatisticListener$delegate", "Lkotlin/Lazy;", "linkageTouchController", "Lcom/baidu/tieba/forum/controller/LinkageTouchController;", "linkageView", "Lcom/baidu/tieba/forum/view/LinkageView;", "screenWidthDp", "", "secondFloorController", "Lcom/baidu/tieba/forum/secondfloor/SecondFloorController;", "Lcom/baidu/tieba/forum/secondfloor/ISecondFloorData;", "setViewVisibilityByOpacity", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", NativeConstants.OPACITY, "topContentVisibleHeightChangeListener", "Lkotlin/Function1;", "anchorToChatroom", "params", "Lorg/json/JSONObject;", "checkNeedShowShake", "enableTopSheetScroll", "expandSecondFloorInternal", DelayTB.DELAY, "", "hideSecondFloor", "initSecondFloor", "isTopScrollState", "", "notifyRefreshBtnOpacity", "notifyWriteBtnOpacity", "onActivityResultOK", AiBotChatDispatcher.AI_SINGLE_REQUEST_CODE, "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", MissionEvent.MESSAGE_DESTROY, "onResume", "processLayoutStrategy", "wrapper", "afterInflated", "afterInitPosInvoke", "registerBubbleLiveEvent", "registerH5Events", "scrollToTop", "scrollToTopAndDisableTopSheetScroll", "showBubbleAfterPosAnchored", "showSecondFloor", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class LinkageController extends xh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity b;
    public final String c;
    public ap7 d;
    public ActivityForumBinding e;
    public int f;
    public zj7.a g;
    public jn7 h;
    public hi7 i;
    public om7<? extends lm7> j;
    public final Lazy k;
    public final a l;
    public xi7 m;
    public Function0<Unit> n;
    public final Function1<Integer, Unit> o;
    public final Function2<View, Float, Unit> p;

    /* loaded from: classes6.dex */
    public static final class f extends er6<zj7> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkageController b;

        /* loaded from: classes6.dex */
        public static final class a implements Function0<Unit> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LinkageController a;
            public final /* synthetic */ zj7 b;

            public a(LinkageController linkageController, zj7 zj7Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {linkageController, zj7Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = linkageController;
                this.b = zj7Var;
            }

            public static final void b(LinkageController this$0, zj7 event) {
                String str;
                ForumInfo d;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(65537, null, this$0, event) == null) {
                    Intrinsics.checkNotNullParameter(this$0, "this$0");
                    Intrinsics.checkNotNullParameter(event, "$event");
                    pi7 value = ((BottomViewModel) new ViewModelProvider(this$0.I()).get(BottomViewModel.class)).a().getValue();
                    if (value != null && (d = value.d()) != null) {
                        str = d.name;
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        str = FileUtils.UNKNOW;
                    }
                    TbLog b = ForumLog.b.b();
                    String str2 = this$0.c;
                    b.i(str2, "吧: " + str + " | 准备展现，是否是FE通知 -> " + event.a());
                    ci7.i(this$0.I()).J();
                    this$0.E();
                }
            }

            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    SafeHandler inst = SafeHandler.getInst();
                    final LinkageController linkageController = this.a;
                    final zj7 zj7Var = this.b;
                    inst.post(new Runnable() { // from class: com.baidu.tieba.mg7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                LinkageController.f.a.b(LinkageController.this, zj7Var);
                            }
                        }
                    });
                }
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(LinkageController linkageController, Class<zj7> cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linkageController, cls};
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
            this.b = linkageController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.er6
        public void onEvent(zj7 event) {
            ForumActivity forumActivity;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                FragmentActivity I = this.b.I();
                BdUniqueId bdUniqueId = null;
                if (I instanceof ForumActivity) {
                    forumActivity = (ForumActivity) I;
                } else {
                    forumActivity = null;
                }
                if (forumActivity != null) {
                    bdUniqueId = forumActivity.getUniqueId();
                }
                if (bdUniqueId == null || !Intrinsics.areEqual(bdUniqueId, event.b())) {
                    return;
                }
                this.b.g = event.c();
                this.b.Q(event.c(), new a(this.b, event), this.b.n);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class a implements ff7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkageController a;

        public a(LinkageController linkageController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linkageController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = linkageController;
        }

        @Override // com.baidu.tieba.ff7
        public void a(if7 data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                this.a.D(new JSONObject());
                mf7 c = data.c();
                if (c == null) {
                    return;
                }
                int c2 = c.c();
                if (c2 != 0) {
                    if (c2 != 1) {
                        if (c2 == 2) {
                            this.a.J().s();
                            return;
                        }
                        return;
                    }
                    this.a.J().q();
                    return;
                }
                this.a.J().p();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements Function0<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkageController a;

        public b(LinkageController linkageController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linkageController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = linkageController;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.Y();
            this.a.O();
            this.a.N();
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements hp7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkageController a;

        public c(LinkageController linkageController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linkageController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = linkageController;
        }

        @Override // com.baidu.tieba.hp7
        public void a(MotionEvent e) {
            om7 om7Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, e) == null) {
                Intrinsics.checkNotNullParameter(e, "e");
                if (e.getAction() == 0 && (om7Var = this.a.j) != null) {
                    om7Var.h();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements Function0<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkageController a;

        public d(LinkageController linkageController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linkageController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = linkageController;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            ap7 ap7Var = this.a.d;
            if (ap7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linkageView");
                ap7Var = null;
            }
            ap7Var.i();
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes6.dex */
    public static final class e extends er6<s87> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkageController b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(LinkageController linkageController, Class<s87> cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linkageController, cls};
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
            this.b = linkageController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.er6
        public void onEvent(s87 event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (Intrinsics.areEqual(event.a(), this.b.I())) {
                    if (event.c()) {
                        this.b.X();
                    } else {
                        this.b.F();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class g implements ff7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkageController a;

        public g(LinkageController linkageController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linkageController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = linkageController;
        }

        @Override // com.baidu.tieba.ff7
        public void a(if7 data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                this.a.l.a(data);
                ap7 ap7Var = this.a.d;
                ap7 ap7Var2 = null;
                if (ap7Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("linkageView");
                    ap7Var = null;
                }
                ap7Var.h();
                ap7 ap7Var3 = this.a.d;
                if (ap7Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("linkageView");
                } else {
                    ap7Var2 = ap7Var3;
                }
                ap7Var2.d();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class h implements Function1<Integer, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkageController a;

        public h(LinkageController linkageController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linkageController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = linkageController;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            a(num.intValue());
            return Unit.INSTANCE;
        }

        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                ((TopViewModel) new ViewModelProvider(this.a.I()).get(TopViewModel.class)).a().postValue(Integer.valueOf(i));
                this.a.O();
                this.a.N();
            }
        }
    }

    public LinkageController(FragmentActivity activity) {
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
        this.c = "LinkageController";
        this.f = activity.getResources().getConfiguration().screenWidthDp;
        this.k = LazyKt__LazyJVMKt.lazy(new Function0<gi7>(this) { // from class: com.baidu.tieba.forum.controller.LinkageController$linkageStatisticListener$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LinkageController this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final gi7 invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return ci7.h(this.this$0.I());
                }
                return (gi7) invokeV.objValue;
            }
        });
        this.l = new a(this);
        this.n = new b(this);
        this.o = new h(this);
        this.p = LinkageController$setViewVisibilityByOpacity$1.INSTANCE;
    }

    @Override // com.baidu.tieba.xh7
    public void j(Configuration newConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, newConfig) == null) {
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            int i = this.f;
            int i2 = newConfig.screenWidthDp;
            if (i != i2) {
                this.f = i2;
                final zj7.a aVar = this.g;
                if (aVar != null) {
                    ActivityForumBinding activityForumBinding = this.e;
                    ActivityForumBinding activityForumBinding2 = null;
                    if (activityForumBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityForumBinding = null;
                    }
                    WebView innerWebView = activityForumBinding.d.getInnerWebView();
                    if (innerWebView != null) {
                        innerWebView.scrollTo(0, 0);
                    }
                    ActivityForumBinding activityForumBinding3 = this.e;
                    if (activityForumBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityForumBinding3 = null;
                    }
                    activityForumBinding3.m.scrollTo(0, 0);
                    ActivityForumBinding activityForumBinding4 = this.e;
                    if (activityForumBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityForumBinding2 = activityForumBinding4;
                    }
                    NavigationBar navigationBar = activityForumBinding2.p;
                    Intrinsics.checkNotNullExpressionValue(navigationBar, "binding.navBar");
                    ji7.a(navigationBar, 0.0f);
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.lg7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                LinkageController.P(LinkageController.this, aVar);
                            }
                        }
                    }, 50L);
                }
            }
        }
    }

    public static final void T(LinkageController this$0, xi7 xi7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, this$0, xi7Var) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.m = xi7Var;
            if (xi7Var != null && this$0.n != null) {
                this$0.Y();
            }
        }
    }

    public static final void H(LinkageController this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            om7<? extends lm7> om7Var = this$0.j;
            if (om7Var != null) {
                om7Var.f();
            }
        }
    }

    public final void D(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            ci7.c(this.b).p("frsPageNa.anchorToChatroom", jSONObject);
        }
    }

    public final void G(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            if (j == 0) {
                om7<? extends lm7> om7Var = this.j;
                if (om7Var != null) {
                    om7Var.f();
                    return;
                }
                return;
            }
            SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yg7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        LinkageController.H(LinkageController.this);
                    }
                }
            }, j);
        }
    }

    @Override // com.baidu.tieba.xh7
    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            super.i(i);
            ap7 ap7Var = this.d;
            if (ap7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linkageView");
                ap7Var = null;
            }
            ap7Var.f(i);
            om7<? extends lm7> om7Var = this.j;
            if (om7Var != null) {
                om7Var.k();
            }
        }
    }

    public static final void P(LinkageController this$0, zj7.a this_run) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, this$0, this_run) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this_run, "$this_run");
            ForumLog.b.b().i(this$0.c, "onConfigurationChanged 重建布局");
            R(this$0, this_run, new d(this$0), null, 4, null);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.forum.controller.LinkageController */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void R(LinkageController linkageController, zj7.a aVar, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        if ((i & 4) != 0) {
            function02 = null;
        }
        linkageController.Q(aVar, function0, function02);
    }

    public final void E() {
        Boolean bool;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !TbadkCoreApplication.isLogin() || SharedPrefHelper.getInstance().getBoolean("key_frs_ai_second_floor_shake", false)) {
            return;
        }
        om7<? extends lm7> om7Var = this.j;
        if (om7Var != null) {
            bool = Boolean.valueOf(om7Var.g());
        } else {
            bool = null;
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            SharedPrefHelper.getInstance().putBoolean("key_frs_ai_second_floor_shake", bool.booleanValue());
        }
    }

    public final void Z() {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            ActivityForumBinding activityForumBinding = this.e;
            ap7 ap7Var = null;
            if (activityForumBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityForumBinding = null;
            }
            TbLinkageScrollView tbLinkageScrollView = activityForumBinding.m;
            Intrinsics.checkNotNullExpressionValue(tbLinkageScrollView, "binding.linkageView");
            TbNestedScrollView.E(tbLinkageScrollView, 0, 0, null, 6, null);
            ap7 ap7Var2 = this.d;
            if (ap7Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linkageView");
            } else {
                ap7Var = ap7Var2;
            }
            if (ap7Var.h()) {
                j = 50;
            } else {
                j = 0;
            }
            G(j);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ap7 ap7Var = this.d;
            if (ap7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linkageView");
                ap7Var = null;
            }
            ap7Var.e();
        }
    }

    public final FragmentActivity I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (FragmentActivity) invokeV.objValue;
    }

    public final gi7 J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return (gi7) this.k.getValue();
        }
        return (gi7) invokeV.objValue;
    }

    public final void K() {
        om7<? extends lm7> om7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (om7Var = this.j) != null) {
            om7Var.e();
        }
    }

    public final boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            jn7 jn7Var = this.h;
            if (jn7Var != null && jn7Var.M() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void N() {
        jn7 jn7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (jn7Var = this.h) != null) {
            Function2<View, Float, Unit> function2 = this.p;
            ActivityForumBinding activityForumBinding = this.e;
            if (activityForumBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityForumBinding = null;
            }
            FRSRefreshButton fRSRefreshButton = activityForumBinding.l;
            Intrinsics.checkNotNullExpressionValue(fRSRefreshButton, "binding.frsRefreshForumButton");
            function2.invoke(fRSRefreshButton, Float.valueOf(jn7Var.I()));
        }
    }

    public final void O() {
        jn7 jn7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (jn7Var = this.h) != null) {
            Function2<View, Float, Unit> function2 = this.p;
            ActivityForumBinding activityForumBinding = this.e;
            if (activityForumBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityForumBinding = null;
            }
            OvalActionButton ovalActionButton = activityForumBinding.k;
            Intrinsics.checkNotNullExpressionValue(ovalActionButton, "binding.frsPostForumButton");
            function2.invoke(ovalActionButton, Float.valueOf(jn7Var.I()));
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            ((BottomViewModel) new ViewModelProvider(this.b).get(BottomViewModel.class)).c().observe(this.b, new Observer() { // from class: com.baidu.tieba.kh7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        LinkageController.T(LinkageController.this, (xi7) obj);
                    }
                }
            });
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            br6.b().b(new ar6(f(), Reflection.getOrCreateKotlinClass(zj7.class)), new f(this, zj7.class));
        }
    }

    public final boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ap7 ap7Var = this.d;
            if (ap7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linkageView");
                ap7Var = null;
            }
            return ap7Var.i();
        }
        return invokeV.booleanValue;
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ap7 ap7Var = this.d;
            if (ap7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linkageView");
                ap7Var = null;
            }
            ap7Var.j();
        }
    }

    @Override // com.baidu.tieba.xh7
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            om7<? extends lm7> om7Var = this.j;
            boolean z = false;
            if (om7Var != null && om7Var.j()) {
                z = true;
            }
            if (z) {
                return true;
            }
            return super.h();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.xh7
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.l();
            ap7 ap7Var = this.d;
            if (ap7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linkageView");
                ap7Var = null;
            }
            ap7Var.g();
            om7<? extends lm7> om7Var = this.j;
            if (om7Var != null) {
                om7Var.l();
            }
            hi7 hi7Var = this.i;
            if (hi7Var != null) {
                hi7Var.e();
            }
        }
    }

    @Override // com.baidu.tieba.xh7
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.n();
            om7<? extends lm7> om7Var = this.j;
            if (om7Var != null) {
                om7Var.m();
            }
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            om7<? extends lm7> om7Var = this.j;
            if (om7Var != null) {
                om7Var.l();
            }
            FragmentActivity fragmentActivity = this.b;
            ActivityForumBinding activityForumBinding = this.e;
            om7<? extends lm7> om7Var2 = null;
            ActivityForumBinding activityForumBinding2 = null;
            if (activityForumBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityForumBinding = null;
            }
            om7<? extends lm7> b2 = pm7.b(fragmentActivity, activityForumBinding, this.h, pm7.d(this.b));
            if (b2 != null) {
                ActivityForumBinding activityForumBinding3 = this.e;
                if (activityForumBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityForumBinding2 = activityForumBinding3;
                }
                activityForumBinding2.t.I(new c(this));
                om7Var2 = b2;
            }
            this.j = om7Var2;
        }
    }

    public final void Q(zj7.a aVar, Function0<Unit> function0, Function0<Unit> function02) {
        String str;
        BaseLayoutStrategy nonFullWebLayoutStrategy;
        FrsBottom e2;
        FrsBottomSmartBgColor frsBottomSmartBgColor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, aVar, function0, function02) == null) {
            pi7 value = ((BottomViewModel) new ViewModelProvider(this.b).get(BottomViewModel.class)).a().getValue();
            ap7 ap7Var = null;
            if (value != null && (e2 = value.e()) != null && (frsBottomSmartBgColor = e2.frs_smart_bg_color) != null) {
                str = frsBottomSmartBgColor.theme_color;
            } else {
                str = null;
            }
            double b2 = aVar.b();
            ActivityForumBinding activityForumBinding = this.e;
            if (activityForumBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityForumBinding = null;
            }
            if (b2 > activityForumBinding.m.getHeight()) {
                ActivityForumBinding activityForumBinding2 = this.e;
                if (activityForumBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityForumBinding2 = null;
                }
                nonFullWebLayoutStrategy = new FullWebLayoutStrategy(activityForumBinding2, aVar);
                nonFullWebLayoutStrategy.E(function02);
            } else {
                ActivityForumBinding activityForumBinding3 = this.e;
                if (activityForumBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityForumBinding3 = null;
                }
                nonFullWebLayoutStrategy = new NonFullWebLayoutStrategy(activityForumBinding3, aVar);
                nonFullWebLayoutStrategy.E(function02);
            }
            ForumLog.b.b().i(this.c, "prepare layout strategy: " + nonFullWebLayoutStrategy);
            nonFullWebLayoutStrategy.R(str);
            ap7 ap7Var2 = this.d;
            if (ap7Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linkageView");
            } else {
                ap7Var = ap7Var2;
            }
            ap7Var.b(nonFullWebLayoutStrategy, function0);
            nonFullWebLayoutStrategy.S(this.o);
            nonFullWebLayoutStrategy.N(J());
            hi7 hi7Var = this.i;
            if (hi7Var != null) {
                hi7Var.e();
            }
            hi7 hi7Var2 = new hi7(this.b, nonFullWebLayoutStrategy.i(), nonFullWebLayoutStrategy);
            this.i = hi7Var2;
            hi7Var2.d();
            this.h = nonFullWebLayoutStrategy;
            L();
        }
    }

    public final void Y() {
        int k;
        final int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            final xi7 xi7Var = this.m;
            if (xi7Var != null) {
                gf7.a b2 = hf7.b(xi7Var.b());
                b2.d(new g(this));
                final gf7 a2 = b2.a();
                si7 value = ((ForumViewModel) new ViewModelProvider(this.b).get(ForumViewModel.class)).c().getValue();
                if (value == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(value, "ViewModelProvider(activi…mLiveData.value ?: return");
                int b3 = xi7Var.b();
                if (b3 != 0) {
                    if (b3 != 1) {
                        if (b3 != 2) {
                            i = 0;
                            final long f2 = value.f();
                            final String g2 = value.g();
                            jf7.a.a(String.valueOf(f2), xi7Var.b(), new Function1<Integer, Unit>(this, i, f2, g2, xi7Var, a2) { // from class: com.baidu.tieba.forum.controller.LinkageController$showBubbleAfterPosAnchored$1$1
                                public static /* synthetic */ Interceptable $ic;
                                public final /* synthetic */ gf7 $config;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ long $fid;
                                public final /* synthetic */ String $fname;
                                public final /* synthetic */ int $frequencyLimit;
                                public final /* synthetic */ xi7 $this_run;
                                public final /* synthetic */ LinkageController this$0;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, Integer.valueOf(i), Long.valueOf(f2), g2, xi7Var, a2};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            super(((Integer) newInitContext.callArgs[0]).intValue());
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                    this.$frequencyLimit = i;
                                    this.$fid = f2;
                                    this.$fname = g2;
                                    this.$this_run = xi7Var;
                                    this.$config = a2;
                                }

                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                    invoke(num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(int i2) {
                                    Interceptable interceptable2 = $ic;
                                    if ((interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && !this.this$0.I().isFinishing() && !this.this$0.I().isDestroyed()) {
                                        int i3 = this.$frequencyLimit;
                                        if (i3 == 0 || i2 < i3) {
                                            mf7 mf7Var = new mf7(String.valueOf(this.$fid), this.$fname, this.$this_run.b());
                                            ap7 ap7Var = this.this$0.d;
                                            if (ap7Var == null) {
                                                Intrinsics.throwUninitializedPropertyAccessException("linkageView");
                                                ap7Var = null;
                                            }
                                            ap7Var.k(new if7(this.$this_run.a(), this.$config, mf7Var), true);
                                            jf7.a.c(String.valueOf(this.$fid), this.$this_run.b(), i2 + 1);
                                        }
                                    }
                                }
                            });
                        } else {
                            k = value.n();
                        }
                    } else {
                        k = value.r();
                    }
                } else {
                    k = value.k();
                }
                i = k;
                final long f22 = value.f();
                final String g22 = value.g();
                jf7.a.a(String.valueOf(f22), xi7Var.b(), new Function1<Integer, Unit>(this, i, f22, g22, xi7Var, a2) { // from class: com.baidu.tieba.forum.controller.LinkageController$showBubbleAfterPosAnchored$1$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ gf7 $config;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ long $fid;
                    public final /* synthetic */ String $fname;
                    public final /* synthetic */ int $frequencyLimit;
                    public final /* synthetic */ xi7 $this_run;
                    public final /* synthetic */ LinkageController this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = objArr;
                            Object[] objArr = {this, Integer.valueOf(i), Long.valueOf(f22), g22, xi7Var, a2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.$frequencyLimit = i;
                        this.$fid = f22;
                        this.$fname = g22;
                        this.$this_run = xi7Var;
                        this.$config = a2;
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i2) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && !this.this$0.I().isFinishing() && !this.this$0.I().isDestroyed()) {
                            int i3 = this.$frequencyLimit;
                            if (i3 == 0 || i2 < i3) {
                                mf7 mf7Var = new mf7(String.valueOf(this.$fid), this.$fname, this.$this_run.b());
                                ap7 ap7Var = this.this$0.d;
                                if (ap7Var == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("linkageView");
                                    ap7Var = null;
                                }
                                ap7Var.k(new if7(this.$this_run.a(), this.$config, mf7Var), true);
                                jf7.a.c(String.valueOf(this.$fid), this.$this_run.b(), i2 + 1);
                            }
                        }
                    }
                });
            }
            this.m = null;
        }
    }

    @Override // com.baidu.tieba.xh7
    public void g(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048594, this, i, i2, intent) == null) {
            super.g(i, i2, intent);
            om7<? extends lm7> om7Var = this.j;
            if (om7Var != null) {
                om7Var.i(i, i2, intent);
            }
        }
    }

    @Override // com.baidu.tieba.xh7
    public void k(Bundle bundle, ActivityForumBinding binding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, bundle, binding) == null) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            super.k(bundle, binding);
            this.e = binding;
            this.d = new ap7(binding);
            SecondFloorVisitHelper.a.d();
            U();
            S();
            br6.b().b(new ar6(f(), Reflection.getOrCreateKotlinClass(s87.class)), new e(this, s87.class));
        }
    }
}
