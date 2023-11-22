package com.baidu.tieba.forum.controller;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.b87;
import com.baidu.tieba.bh7;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.cx4;
import com.baidu.tieba.ew4;
import com.baidu.tieba.fh7;
import com.baidu.tieba.fi7;
import com.baidu.tieba.forum.ForumActivity;
import com.baidu.tieba.forum.controller.LinkageController;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.forum.strategy.FullWebLayoutStrategy;
import com.baidu.tieba.forum.strategy.NonFullWebLayoutStrategy;
import com.baidu.tieba.forum.viewmodel.BottomViewModel;
import com.baidu.tieba.forum.viewmodel.ForumViewModel;
import com.baidu.tieba.forum.viewmodel.TopViewModel;
import com.baidu.tieba.forum.widget.TbLinkageScrollView;
import com.baidu.tieba.fx4;
import com.baidu.tieba.hh7;
import com.baidu.tieba.km7;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.mh7;
import com.baidu.tieba.mq6;
import com.baidu.tieba.ne7;
import com.baidu.tieba.nl7;
import com.baidu.tieba.nq6;
import com.baidu.tieba.oe7;
import com.baidu.tieba.pe7;
import com.baidu.tieba.pg7;
import com.baidu.tieba.qd;
import com.baidu.tieba.qe7;
import com.baidu.tieba.qg7;
import com.baidu.tieba.qq6;
import com.baidu.tieba.re7;
import com.baidu.tieba.sm7;
import com.baidu.tieba.ue7;
import com.baidu.tieba.ug7;
import com.baidu.tieba.um7;
import com.baidu.tieba.yg7;
import com.baidu.tieba.yk7;
import com.baidu.tieba.zg7;
import com.baidu.tieba.zk7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;
import tbclient.FrsBottomSmartBgColor;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.ForumInfo;
import tbclient.FrsPage.FrsBottom;
@Metadata(d1 = {"\u0000©\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e*\u0003\u000f+.\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010=\u001a\u00020\u00172\u0006\u0010>\u001a\u00020?H\u0002J\u0006\u0010@\u001a\u00020\u0017J\u000e\u0010A\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010B\u001a\u00020CJ\u0006\u0010D\u001a\u00020CJ\b\u0010E\u001a\u00020\u0017H\u0002J\u0010\u0010F\u001a\u00020\u00172\u0006\u0010G\u001a\u00020'H\u0016J\u0010\u0010H\u001a\u00020\u00172\u0006\u0010I\u001a\u00020JH\u0016J\u001a\u0010K\u001a\u00020\u00172\b\u0010L\u001a\u0004\u0018\u00010M2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010N\u001a\u00020\u0017H\u0016J4\u0010O\u001a\u00020\u00172\u0006\u0010P\u001a\u00020\u00122\u0010\b\u0002\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0010\b\u0002\u0010R\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0002J\b\u0010S\u001a\u00020\u0017H\u0002J\b\u0010T\u001a\u00020\u0017H\u0002J\u0006\u0010U\u001a\u00020CJ\u0006\u0010V\u001a\u00020\u0017J\b\u0010W\u001a\u00020\u0017H\u0002J\u0018\u0010X\u001a\u00020\u00172\u0006\u0010Y\u001a\u00020\b2\u0006\u0010Z\u001a\u00020\bH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0004\n\u0002\u0010,R\u0010\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010/R\u001a\u00100\u001a\u000201X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00170<X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Lcom/baidu/tieba/forum/controller/LinkageController;", "Lcom/baidu/tieba/forum/controller/BaseActivityController;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "adBusinessHeadHeight", "", "adBusinessHeadOffsetY", "adheadControl", "Lcom/baidu/tieba/forum/tab/FrsHeadAdControl;", "binding", "Lcom/baidu/tieba/forum/databinding/ActivityForumBinding;", "bubbleClickListener", "com/baidu/tieba/forum/controller/LinkageController$bubbleClickListener$1", "Lcom/baidu/tieba/forum/controller/LinkageController$bubbleClickListener$1;", "cachedH5HeightWrapper", "Lcom/baidu/tieba/forum/event/H5HeightEvent$H5HeightWrapper;", "guideBubble", "Lcom/baidu/tieba/forum/data/GuideBubbleData;", "initPositionInvoke", "Lkotlin/Function0;", "", "layoutStrategy", "Lcom/baidu/tieba/forum/strategy/ILinkageLayoutStrategy;", "linkageStatisticListener", "Lcom/baidu/tieba/forum/controller/LinkageStatisticController;", "getLinkageStatisticListener", "()Lcom/baidu/tieba/forum/controller/LinkageStatisticController;", "linkageStatisticListener$delegate", "Lkotlin/Lazy;", "linkageTouchController", "Lcom/baidu/tieba/forum/controller/LinkageTouchController;", "linkageView", "Lcom/baidu/tieba/forum/view/LinkageView;", "mBottomData", "Lcom/baidu/tieba/forum/data/BottomData;", "screenWidthDp", "", "secondFloorExt", "Lcom/baidu/tieba/forum/widget/SecondFloorExt;", "secondFloorTranslateListener", "com/baidu/tieba/forum/controller/LinkageController$secondFloorTranslateListener$1", "Lcom/baidu/tieba/forum/controller/LinkageController$secondFloorTranslateListener$1;", "stateChangeListener", "com/baidu/tieba/forum/controller/LinkageController$stateChangeListener$1", "Lcom/baidu/tieba/forum/controller/LinkageController$stateChangeListener$1;", "tempTime", "", "getTempTime", "()J", "setTempTime", "(J)V", "tempTimeInterval", "getTempTimeInterval", "()I", "setTempTimeInterval", "(I)V", "topContentVisibleHeightChangeListener", "Lkotlin/Function1;", "anchorToChatroom", "params", "Lorg/json/JSONObject;", "enableTopSheetScroll", "initAdHeadView", "isTopScrollState", "", "isfetchNotifyTime", "notifyWriteBtnOpacity", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", MissionEvent.MESSAGE_DESTROY, "processLayoutStrategy", "wrapper", "afterInflated", "afterInitPosInvoke", "registerBubbleLiveEvent", "registerH5Events", "scrollToTop", "scrollToTopAndDisableTopSheetScroll", "showBubbleAfterPosAnchored", "updateHeadOpacity", "offsetY", NativeConstants.OPACITY, "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class LinkageController extends pg7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity b;
    public km7 c;
    public ActivityForumBinding d;
    public nl7 e;
    public int f;
    public fi7.a g;
    public zk7 h;
    public fh7 i;
    public zg7 j;
    public sm7 k;
    public float l;
    public float m;
    public long n;
    public int o;
    public final g p;
    public final Lazy q;
    public final a r;
    public mh7 s;
    public Function0<Unit> t;
    public final Function1<Integer, Unit> u;
    public final i v;

    /* loaded from: classes6.dex */
    public static final class f extends qq6<fi7> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkageController b;

        /* loaded from: classes6.dex */
        public static final class a implements Function0<Unit> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LinkageController a;
            public final /* synthetic */ fi7 b;

            public a(LinkageController linkageController, fi7 fi7Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {linkageController, fi7Var};
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
                this.b = fi7Var;
            }

            public static final void b(LinkageController this$0, fi7 event) {
                String str;
                ForumInfo e;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(65537, null, this$0, event) == null) {
                    Intrinsics.checkNotNullParameter(this$0, "this$0");
                    Intrinsics.checkNotNullParameter(event, "$event");
                    fh7 value = ((BottomViewModel) new ViewModelProvider(this$0.F()).get(BottomViewModel.class)).a().getValue();
                    if (value != null && (e = value.e()) != null) {
                        str = e.name;
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        str = FileUtils.UNKNOW;
                    }
                    TbLog hybridLog = HybridLog.getInstance();
                    hybridLog.d("LinkageController", "吧: " + str + " | 准备展现，是否是FE通知 -> " + event.a());
                    ug7.g(this$0.F()).H();
                }
            }

            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    SafeHandler inst = SafeHandler.getInst();
                    final LinkageController linkageController = this.a;
                    final fi7 fi7Var = this.b;
                    inst.post(new Runnable() { // from class: com.baidu.tieba.gf7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                LinkageController.f.a.b(LinkageController.this, fi7Var);
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
        public f(LinkageController linkageController, Class<fi7> cls) {
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
        @Override // com.baidu.tieba.qq6
        public void onEvent(fi7 event) {
            ForumActivity forumActivity;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                FragmentActivity F = this.b.F();
                BdUniqueId bdUniqueId = null;
                if (F instanceof ForumActivity) {
                    forumActivity = (ForumActivity) F;
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
                this.b.M(event.c(), new a(this.b, event), this.b.t);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class a implements ne7 {
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

        @Override // com.baidu.tieba.ne7
        public void a(qe7 data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                this.a.D(new JSONObject());
                ue7 c = data.c();
                if (c == null) {
                    return;
                }
                int c2 = c.c();
                if (c2 != 0) {
                    if (c2 != 1) {
                        if (c2 == 2) {
                            this.a.G().r();
                            return;
                        }
                        return;
                    }
                    this.a.G().q();
                    return;
                }
                this.a.G().o();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements nl7.a {
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

        @Override // com.baidu.tieba.nl7.a
        public void a(float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) != null) {
                return;
            }
            ActivityForumBinding activityForumBinding = this.a.d;
            if (activityForumBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityForumBinding = null;
            }
            activityForumBinding.q.scrollTo((int) f, (int) f2);
            this.a.p.a(Math.abs(f2));
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements Function0<Unit> {
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

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.V();
            this.a.K();
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
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
            km7 km7Var = this.a.c;
            if (km7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linkageView");
                km7Var = null;
            }
            km7Var.i();
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes6.dex */
    public static final class e extends qq6<b87> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkageController b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(LinkageController linkageController, Class<b87> cls) {
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
        @Override // com.baidu.tieba.qq6
        public void onEvent(b87 event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (Intrinsics.areEqual(event.a(), this.b.F())) {
                    if (event.c()) {
                        this.b.T();
                    } else {
                        this.b.E();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class g extends um7 {
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

        @Override // com.baidu.tieba.tm7
        public void a(float f) {
            float f2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
                float abs = Math.abs(f);
                nl7 nl7Var = this.a.e;
                ActivityForumBinding activityForumBinding = null;
                if (nl7Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adheadControl");
                    nl7Var = null;
                }
                if (abs > nl7Var.n()) {
                    f2 = 1.0f;
                } else {
                    nl7 nl7Var2 = this.a.e;
                    if (nl7Var2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adheadControl");
                        nl7Var2 = null;
                    }
                    f2 = abs / nl7Var2.n();
                }
                km7 km7Var = this.a.c;
                if (km7Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("linkageView");
                    km7Var = null;
                }
                nl7 nl7Var3 = this.a.e;
                if (nl7Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adheadControl");
                    nl7Var3 = null;
                }
                km7.l(km7Var, new qe7(nl7Var3.m(f2), pe7.b(0).a(), null, 4, null), false, 2, null);
                ActivityForumBinding activityForumBinding2 = this.a.d;
                if (activityForumBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityForumBinding2 = null;
                }
                TbImageView tbImageView = activityForumBinding2.u;
                ActivityForumBinding activityForumBinding3 = this.a.d;
                if (activityForumBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityForumBinding = activityForumBinding3;
                }
                tbImageView.setTranslationY((-(activityForumBinding.u.getHeight() - this.a.l)) + f);
                this.a.W(abs, f2);
            }
        }

        @Override // com.baidu.tieba.tm7
        public void b(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
                ActivityForumBinding activityForumBinding = this.a.d;
                nl7 nl7Var = null;
                if (activityForumBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityForumBinding = null;
                }
                TbImageView tbImageView = activityForumBinding.u;
                ActivityForumBinding activityForumBinding2 = this.a.d;
                if (activityForumBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityForumBinding2 = null;
                }
                tbImageView.setTranslationY(-(activityForumBinding2.u.getHeight() - this.a.l));
                float abs = Math.abs(f);
                this.a.W(abs, 0.0f);
                nl7 nl7Var2 = this.a.e;
                if (nl7Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adheadControl");
                    nl7Var2 = null;
                }
                if (abs >= nl7Var2.o()) {
                    nl7 nl7Var3 = this.a.e;
                    if (nl7Var3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adheadControl");
                    } else {
                        nl7Var = nl7Var3;
                    }
                    nl7Var.z();
                }
                this.a.V();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class h implements ne7 {
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

        @Override // com.baidu.tieba.ne7
        public void a(qe7 data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                this.a.r.a(data);
                km7 km7Var = this.a.c;
                km7 km7Var2 = null;
                if (km7Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("linkageView");
                    km7Var = null;
                }
                km7Var.h();
                km7 km7Var3 = this.a.c;
                if (km7Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("linkageView");
                } else {
                    km7Var2 = km7Var3;
                }
                km7Var2.d();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class i implements yk7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.yk7
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tieba.yk7
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public i() {
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

        @Override // com.baidu.tieba.yk7
        public void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                yk7.a.a(this, i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class j implements Function1<Integer, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkageController a;

        public j(LinkageController linkageController) {
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

        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                ((TopViewModel) new ViewModelProvider(this.a.F()).get(TopViewModel.class)).a().postValue(Integer.valueOf(i));
                this.a.K();
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            a(num.intValue());
            return Unit.INSTANCE;
        }
    }

    public LinkageController(FragmentActivity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.b = activity;
        this.f = activity.getResources().getConfiguration().screenWidthDp;
        this.o = 48;
        this.p = new g(this);
        this.q = LazyKt__LazyJVMKt.lazy(new Function0<yg7>(this) { // from class: com.baidu.tieba.forum.controller.LinkageController$linkageStatisticListener$2
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
            public final yg7 invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return ug7.f(this.this$0.F());
                }
                return (yg7) invokeV.objValue;
            }
        });
        this.r = new a(this);
        this.t = new c(this);
        this.u = new j(this);
        this.v = new i();
    }

    @Override // com.baidu.tieba.pg7
    public void j(Configuration newConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, newConfig) == null) {
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            int i2 = this.f;
            int i3 = newConfig.screenWidthDp;
            if (i2 != i3) {
                this.f = i3;
                final fi7.a aVar = this.g;
                if (aVar != null) {
                    ActivityForumBinding activityForumBinding = this.d;
                    ActivityForumBinding activityForumBinding2 = null;
                    if (activityForumBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityForumBinding = null;
                    }
                    WebView innerWebView = activityForumBinding.d.getInnerWebView();
                    if (innerWebView != null) {
                        innerWebView.scrollTo(0, 0);
                    }
                    ActivityForumBinding activityForumBinding3 = this.d;
                    if (activityForumBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityForumBinding3 = null;
                    }
                    activityForumBinding3.m.scrollTo(0, 0);
                    ActivityForumBinding activityForumBinding4 = this.d;
                    if (activityForumBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityForumBinding2 = activityForumBinding4;
                    }
                    NavigationBar navigationBar = activityForumBinding2.p;
                    Intrinsics.checkNotNullExpressionValue(navigationBar, "binding.navBar");
                    bh7.a(navigationBar, 0.0f);
                    SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.gg7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                LinkageController.L(LinkageController.this, aVar);
                            }
                        }
                    }, 50L);
                }
            }
        }
    }

    public static final void L(LinkageController this$0, fi7.a this_run) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, this_run) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this_run, "$this_run");
            N(this$0, this_run, new d(this$0), null, 4, null);
        }
    }

    public static final void P(LinkageController this$0, mh7 mh7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, this$0, mh7Var) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.s = mh7Var;
            if (mh7Var != null && this$0.t != null) {
                this$0.V();
            }
        }
    }

    public static final void Q(LinkageController this$0, fh7 fh7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, this$0, fh7Var) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.i = fh7Var;
        }
    }

    public final void D(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            ug7.c(this.b).q("frsPageNa.anchorToChatroom", jSONObject);
        }
    }

    @Override // com.baidu.tieba.pg7
    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            super.i(i2);
            km7 km7Var = this.c;
            if (km7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linkageView");
                km7Var = null;
            }
            km7Var.f(i2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.forum.controller.LinkageController */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void N(LinkageController linkageController, fi7.a aVar, Function0 function0, Function0 function02, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function0 = null;
        }
        if ((i2 & 4) != 0) {
            function02 = null;
        }
        linkageController.M(aVar, function0, function02);
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            km7 km7Var = this.c;
            if (km7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linkageView");
                km7Var = null;
            }
            km7Var.e();
        }
    }

    public final FragmentActivity F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (FragmentActivity) invokeV.objValue;
    }

    public final yg7 G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return (yg7) this.q.getValue();
        }
        return (yg7) invokeV.objValue;
    }

    public final boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            zk7 zk7Var = this.h;
            if (zk7Var != null && zk7Var.L() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.n < this.o) {
                return false;
            }
            this.n = currentTimeMillis;
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void K() {
        zk7 zk7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (zk7Var = this.h) != null) {
            ActivityForumBinding activityForumBinding = this.d;
            if (activityForumBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityForumBinding = null;
            }
            OvalActionButton ovalActionButton = activityForumBinding.k;
            Intrinsics.checkNotNullExpressionValue(ovalActionButton, "binding.frsPostForumButton");
            qg7.a(ovalActionButton, zk7Var.M());
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            nq6.b().b(new mq6(f(), Reflection.getOrCreateKotlinClass(fi7.class)), new f(this, fi7.class));
        }
    }

    public final boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            km7 km7Var = this.c;
            if (km7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linkageView");
                km7Var = null;
            }
            return km7Var.i();
        }
        return invokeV.booleanValue;
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            km7 km7Var = this.c;
            if (km7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linkageView");
                km7Var = null;
            }
            km7Var.j();
        }
    }

    public final void H(zk7 layoutStrategy) {
        ActivityHead activityHead;
        ActivityHead activityHead2;
        Long l;
        long longValue;
        String str;
        ForumInfo e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, layoutStrategy) == null) {
            Intrinsics.checkNotNullParameter(layoutStrategy, "layoutStrategy");
            fh7 fh7Var = this.i;
            if (fh7Var != null) {
                nl7 nl7Var = null;
                if (fh7Var != null) {
                    activityHead = fh7Var.a();
                } else {
                    activityHead = null;
                }
                if (activityHead != null) {
                    cx4 cx4Var = new cx4();
                    fh7 fh7Var2 = this.i;
                    if (fh7Var2 != null) {
                        activityHead2 = fh7Var2.a();
                    } else {
                        activityHead2 = null;
                    }
                    fh7 fh7Var3 = this.i;
                    if (fh7Var3 != null && (e2 = fh7Var3.e()) != null) {
                        l = e2.id;
                    } else {
                        l = null;
                    }
                    if (l == null) {
                        longValue = 0;
                    } else {
                        longValue = l.longValue();
                    }
                    cx4Var.d(activityHead2, longValue);
                    ew4 a2 = cx4Var.a();
                    if (a2 != null && !qd.isEmpty(a2.b) && !qd.isEmpty(a2.a) && a2.c >= 0 && this.l > 0.0f) {
                        ActivityForumBinding activityForumBinding = this.d;
                        if (activityForumBinding == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            activityForumBinding = null;
                        }
                        activityForumBinding.u.setPlaceHolder(2);
                        nl7 nl7Var2 = this.e;
                        if (nl7Var2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adheadControl");
                            nl7Var2 = null;
                        }
                        ActivityForumBinding activityForumBinding2 = this.d;
                        if (activityForumBinding2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            activityForumBinding2 = null;
                        }
                        TbImageView tbImageView = activityForumBinding2.u;
                        Intrinsics.checkNotNullExpressionValue(tbImageView, "binding.topHeadAdvancedBg");
                        nl7Var2.x(tbImageView, (int) this.l, BdUtilHelper.getEquipmentWidth(this.b));
                        ActivityForumBinding activityForumBinding3 = this.d;
                        if (activityForumBinding3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            activityForumBinding3 = null;
                        }
                        TbImageView tbImageView2 = activityForumBinding3.u;
                        ActivityForumBinding activityForumBinding4 = this.d;
                        if (activityForumBinding4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            activityForumBinding4 = null;
                        }
                        tbImageView2.setTranslationY(-(activityForumBinding4.u.getHeight() - ((int) this.l)));
                        ActivityForumBinding activityForumBinding5 = this.d;
                        if (activityForumBinding5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            activityForumBinding5 = null;
                        }
                        activityForumBinding5.v.setVisibility(0);
                        ActivityForumBinding activityForumBinding6 = this.d;
                        if (activityForumBinding6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            activityForumBinding6 = null;
                        }
                        ViewGroup.LayoutParams layoutParams = activityForumBinding6.v.getLayoutParams();
                        layoutParams.height = (int) this.l;
                        ActivityForumBinding activityForumBinding7 = this.d;
                        if (activityForumBinding7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            activityForumBinding7 = null;
                        }
                        activityForumBinding7.v.setLayoutParams(layoutParams);
                        fx4 fx4Var = (fx4) ListUtils.getItem(cx4Var.b(), 0);
                        if (fx4Var != null) {
                            str = fx4Var.d();
                        } else {
                            str = "";
                        }
                        ActivityForumBinding activityForumBinding8 = this.d;
                        if (activityForumBinding8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            activityForumBinding8 = null;
                        }
                        activityForumBinding8.v.setTranslationY(this.m);
                        ActivityForumBinding activityForumBinding9 = this.d;
                        if (activityForumBinding9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            activityForumBinding9 = null;
                        }
                        activityForumBinding9.v.startLoad(str, 10, false);
                        ActivityForumBinding activityForumBinding10 = this.d;
                        if (activityForumBinding10 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            activityForumBinding10 = null;
                        }
                        FrameLayout frameLayout = activityForumBinding10.q;
                        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.rootContainer");
                        sm7 sm7Var = new sm7(frameLayout, layoutStrategy.H());
                        this.k = sm7Var;
                        sm7Var.b(this.p);
                        ActivityForumBinding activityForumBinding11 = this.d;
                        if (activityForumBinding11 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            activityForumBinding11 = null;
                        }
                        TbLinkageScrollView tbLinkageScrollView = activityForumBinding11.m;
                        Intrinsics.checkNotNullExpressionValue(tbLinkageScrollView, "binding.linkageView");
                        sm7Var.d(tbLinkageScrollView);
                        nl7 nl7Var3 = this.e;
                        if (nl7Var3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adheadControl");
                            nl7Var3 = null;
                        }
                        nl7Var3.j(a2, (ViewGroup) this.b.getWindow().getDecorView());
                        nl7 nl7Var4 = this.e;
                        if (nl7Var4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adheadControl");
                            nl7Var4 = null;
                        }
                        nl7Var4.w(true);
                        nl7 nl7Var5 = this.e;
                        if (nl7Var5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adheadControl");
                        } else {
                            nl7Var = nl7Var5;
                        }
                        nl7Var.y(new b(this));
                        return;
                    }
                    nl7 nl7Var6 = this.e;
                    if (nl7Var6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adheadControl");
                    } else {
                        nl7Var = nl7Var6;
                    }
                    nl7Var.w(false);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.baidu.tieba.forum.strategy.FullWebLayoutStrategy */
    /* JADX WARN: Multi-variable type inference failed */
    public final void M(fi7.a aVar, Function0<Unit> function0, Function0<Unit> function02) {
        String str;
        NonFullWebLayoutStrategy nonFullWebLayoutStrategy;
        FrsBottom f2;
        FrsBottomSmartBgColor frsBottomSmartBgColor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar, function0, function02) == null) {
            this.l = (float) aVar.b();
            this.m = (float) aVar.c();
            fh7 value = ((BottomViewModel) new ViewModelProvider(this.b).get(BottomViewModel.class)).a().getValue();
            nl7 nl7Var = null;
            if (value != null && (f2 = value.f()) != null && (frsBottomSmartBgColor = f2.frs_smart_bg_color) != null) {
                str = frsBottomSmartBgColor.theme_color;
            } else {
                str = null;
            }
            double d2 = aVar.d();
            ActivityForumBinding activityForumBinding = this.d;
            if (activityForumBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityForumBinding = null;
            }
            if (d2 > activityForumBinding.m.getHeight()) {
                ActivityForumBinding activityForumBinding2 = this.d;
                if (activityForumBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityForumBinding2 = null;
                }
                FullWebLayoutStrategy fullWebLayoutStrategy = new FullWebLayoutStrategy(activityForumBinding2, aVar);
                fullWebLayoutStrategy.C(function02);
                fullWebLayoutStrategy.a0(this.v);
                nonFullWebLayoutStrategy = fullWebLayoutStrategy;
            } else {
                ActivityForumBinding activityForumBinding3 = this.d;
                if (activityForumBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityForumBinding3 = null;
                }
                NonFullWebLayoutStrategy nonFullWebLayoutStrategy2 = new NonFullWebLayoutStrategy(activityForumBinding3, aVar);
                nonFullWebLayoutStrategy2.C(function02);
                nonFullWebLayoutStrategy2.a0(this.v);
                nonFullWebLayoutStrategy = nonFullWebLayoutStrategy2;
            }
            nonFullWebLayoutStrategy.P(str);
            km7 km7Var = this.c;
            km7 km7Var2 = km7Var;
            if (km7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linkageView");
                km7Var2 = null;
            }
            km7Var2.b(nonFullWebLayoutStrategy, function0);
            nonFullWebLayoutStrategy.Q(this.u);
            nonFullWebLayoutStrategy.D(G());
            H(nonFullWebLayoutStrategy);
            zg7 zg7Var = this.j;
            if (zg7Var != null) {
                zg7Var.e();
            }
            zg7 zg7Var2 = new zg7(this.b, nonFullWebLayoutStrategy.i(), nonFullWebLayoutStrategy);
            this.j = zg7Var2;
            zg7Var2.d();
            this.h = nonFullWebLayoutStrategy;
            nl7 nl7Var2 = this.e;
            if (nl7Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adheadControl");
            } else {
                nl7Var = nl7Var2;
            }
            nl7Var.C();
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ((BottomViewModel) new ViewModelProvider(this.b).get(BottomViewModel.class)).c().observe(this.b, new Observer() { // from class: com.baidu.tieba.qf7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        LinkageController.P(LinkageController.this, (mh7) obj);
                    }
                }
            });
            ((BottomViewModel) new ViewModelProvider(this.b).get(BottomViewModel.class)).a().observe(this.b, new Observer() { // from class: com.baidu.tieba.tf7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        LinkageController.Q(LinkageController.this, (fh7) obj);
                    }
                }
            });
        }
    }

    public final void V() {
        int h2;
        final int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            final mh7 mh7Var = this.s;
            if (mh7Var != null) {
                oe7.a b2 = pe7.b(mh7Var.b());
                b2.d(new h(this));
                final oe7 a2 = b2.a();
                hh7 value = ((ForumViewModel) new ViewModelProvider(this.b).get(ForumViewModel.class)).c().getValue();
                if (value == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(value, "ViewModelProvider(activi…mLiveData.value ?: return");
                int b3 = mh7Var.b();
                if (b3 != 0) {
                    if (b3 != 1) {
                        if (b3 != 2) {
                            i2 = 0;
                            final long d2 = value.d();
                            final String e2 = value.e();
                            re7.a.a(String.valueOf(d2), mh7Var.b(), new Function1<Integer, Unit>(this, i2, d2, e2, mh7Var, a2) { // from class: com.baidu.tieba.forum.controller.LinkageController$showBubbleAfterPosAnchored$1$1
                                public static /* synthetic */ Interceptable $ic;
                                public final /* synthetic */ oe7 $config;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ long $fid;
                                public final /* synthetic */ String $fname;
                                public final /* synthetic */ int $frequencyLimit;
                                public final /* synthetic */ mh7 $this_run;
                                public final /* synthetic */ LinkageController this$0;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, Integer.valueOf(i2), Long.valueOf(d2), e2, mh7Var, a2};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            super(((Integer) newInitContext.callArgs[0]).intValue());
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                    this.$frequencyLimit = i2;
                                    this.$fid = d2;
                                    this.$fname = e2;
                                    this.$this_run = mh7Var;
                                    this.$config = a2;
                                }

                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                    invoke(num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(int i3) {
                                    Interceptable interceptable2 = $ic;
                                    if ((interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3) == null) && !this.this$0.F().isFinishing() && !this.this$0.F().isDestroyed()) {
                                        int i4 = this.$frequencyLimit;
                                        if (i4 == 0 || i3 < i4) {
                                            ue7 ue7Var = new ue7(String.valueOf(this.$fid), this.$fname, this.$this_run.b());
                                            km7 km7Var = this.this$0.c;
                                            if (km7Var == null) {
                                                Intrinsics.throwUninitializedPropertyAccessException("linkageView");
                                                km7Var = null;
                                            }
                                            km7Var.k(new qe7(this.$this_run.a(), this.$config, ue7Var), true);
                                            re7.a.c(String.valueOf(this.$fid), this.$this_run.b(), i3 + 1);
                                        }
                                    }
                                }
                            });
                        } else {
                            h2 = value.j();
                        }
                    } else {
                        h2 = value.n();
                    }
                } else {
                    h2 = value.h();
                }
                i2 = h2;
                final long d22 = value.d();
                final String e22 = value.e();
                re7.a.a(String.valueOf(d22), mh7Var.b(), new Function1<Integer, Unit>(this, i2, d22, e22, mh7Var, a2) { // from class: com.baidu.tieba.forum.controller.LinkageController$showBubbleAfterPosAnchored$1$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ oe7 $config;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ long $fid;
                    public final /* synthetic */ String $fname;
                    public final /* synthetic */ int $frequencyLimit;
                    public final /* synthetic */ mh7 $this_run;
                    public final /* synthetic */ LinkageController this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = objArr;
                            Object[] objArr = {this, Integer.valueOf(i2), Long.valueOf(d22), e22, mh7Var, a2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.$frequencyLimit = i2;
                        this.$fid = d22;
                        this.$fname = e22;
                        this.$this_run = mh7Var;
                        this.$config = a2;
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i3) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3) == null) && !this.this$0.F().isFinishing() && !this.this$0.F().isDestroyed()) {
                            int i4 = this.$frequencyLimit;
                            if (i4 == 0 || i3 < i4) {
                                ue7 ue7Var = new ue7(String.valueOf(this.$fid), this.$fname, this.$this_run.b());
                                km7 km7Var = this.this$0.c;
                                if (km7Var == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("linkageView");
                                    km7Var = null;
                                }
                                km7Var.k(new qe7(this.$this_run.a(), this.$config, ue7Var), true);
                                re7.a.c(String.valueOf(this.$fid), this.$this_run.b(), i3 + 1);
                            }
                        }
                    }
                });
            }
            this.s = null;
        }
    }

    public final void W(float f2, float f3) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            ActivityForumBinding activityForumBinding = this.d;
            ActivityForumBinding activityForumBinding2 = null;
            if (activityForumBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityForumBinding = null;
            }
            float f4 = 1.0f - f3;
            activityForumBinding.p.setAlpha(f4);
            ActivityForumBinding activityForumBinding3 = this.d;
            if (activityForumBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityForumBinding3 = null;
            }
            ViewGroup.LayoutParams layoutParams = activityForumBinding3.v.getLayoutParams();
            float f5 = 2;
            layoutParams.height = (int) (this.l + (f2 * f3 * f5));
            ActivityForumBinding activityForumBinding4 = this.d;
            if (activityForumBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityForumBinding4 = null;
            }
            activityForumBinding4.v.setLayoutParams(layoutParams);
            ActivityForumBinding activityForumBinding5 = this.d;
            if (activityForumBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityForumBinding5 = null;
            }
            activityForumBinding5.v.setAlpha(f4);
            ActivityForumBinding activityForumBinding6 = this.d;
            if (activityForumBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityForumBinding2 = activityForumBinding6;
            }
            TbImageView tbImageView = activityForumBinding2.u;
            float f6 = f5 * f3;
            if (f6 > 1.0f) {
                f6 = 1.0f;
            }
            tbImageView.setAlpha(f6);
            if (!J()) {
                boolean z2 = false;
                if (f3 == 0.0f) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    if (f3 == 1.0f) {
                        z2 = true;
                    }
                    if (!z2) {
                        return;
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NativeConstants.OPACITY, Float.valueOf(1 - f3));
            ug7.c(this.b).q("frsPageNa.secondFloor", jSONObject);
        }
    }

    @Override // com.baidu.tieba.pg7
    public void k(Bundle bundle, ActivityForumBinding binding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, bundle, binding) == null) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            super.k(bundle, binding);
            this.d = binding;
            this.c = new km7(binding);
            this.e = new nl7(this.b);
            R();
            O();
            nq6.b().b(new mq6(f(), Reflection.getOrCreateKotlinClass(b87.class)), new e(this, b87.class));
        }
    }

    @Override // com.baidu.tieba.pg7
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.l();
            km7 km7Var = this.c;
            nl7 nl7Var = null;
            if (km7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linkageView");
                km7Var = null;
            }
            km7Var.g();
            nl7 nl7Var2 = this.e;
            if (nl7Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adheadControl");
            } else {
                nl7Var = nl7Var2;
            }
            nl7Var.u();
            sm7 sm7Var = this.k;
            if (sm7Var != null) {
                sm7Var.e();
            }
            sm7 sm7Var2 = this.k;
            if (sm7Var2 != null) {
                sm7Var2.f(this.p);
            }
            zg7 zg7Var = this.j;
            if (zg7Var != null) {
                zg7Var.e();
            }
        }
    }
}
