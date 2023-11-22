package com.baidu.tieba.forum.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.ag6;
import com.baidu.tieba.bj6;
import com.baidu.tieba.ej6;
import com.baidu.tieba.fh7;
import com.baidu.tieba.forum.controller.BottomController;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.forum.hybrid.biz.AcitvityHeadJumpBiz;
import com.baidu.tieba.forum.hybrid.biz.AdVideoLocationBiz;
import com.baidu.tieba.forum.hybrid.biz.BusinessPromotBiz;
import com.baidu.tieba.forum.hybrid.biz.ChatRoomSocketBiz;
import com.baidu.tieba.forum.hybrid.biz.FollowStateBiz;
import com.baidu.tieba.forum.hybrid.biz.FrsSignStateBiz;
import com.baidu.tieba.forum.hybrid.biz.H5HeightStateBiz;
import com.baidu.tieba.forum.hybrid.biz.SharePageBiz;
import com.baidu.tieba.forum.hybrid.biz.ShowBubbleStateBiz;
import com.baidu.tieba.forum.hybrid.manager.InteractLayer;
import com.baidu.tieba.forum.view.BottomWebView;
import com.baidu.tieba.forum.viewmodel.BottomViewModel;
import com.baidu.tieba.gqa;
import com.baidu.tieba.jj6;
import com.baidu.tieba.ki7;
import com.baidu.tieba.pg7;
import com.baidu.tieba.th7;
import com.baidu.tieba.ug7;
import com.baidu.tieba.xl7;
import com.baidu.tieba.yl7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tbclient.FrsPage.BusinessPromot;
import tbclient.FrsPage.ForumInfo;
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\"\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\u00132\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u0013H\u0016J\b\u0010'\u001a\u00020\u0013H\u0016J\b\u0010(\u001a\u00020\u0013H\u0002J\u0006\u0010)\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \f*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/baidu/tieba/forum/controller/BottomController;", "Lcom/baidu/tieba/forum/controller/BaseActivityController;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "bottomWebView", "Lcom/baidu/tieba/forum/view/BottomWebView;", ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME, "", "host", "kotlin.jvm.PlatformType", "interactLayer", "Lcom/baidu/tieba/forum/hybrid/manager/InteractLayer;", "rootContainer", "Landroid/widget/FrameLayout;", "testUrl", "dispatchJsEvent", "", "eventName", "params", "Lorg/json/JSONObject;", "getRootView", "Landroid/view/ViewGroup;", "initData", "injectBizData", "onActivityResultOK", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "binding", "Lcom/baidu/tieba/forum/databinding/ActivityForumBinding;", MissionEvent.MESSAGE_DESTROY, "onResume", "registerBiz", "reload", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BottomController extends pg7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity b;
    public final String c;
    public String d;
    public String e;
    public BottomWebView f;
    public FrameLayout g;
    public final InteractLayer h;

    public BottomController(FragmentActivity activity) {
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
        this.c = TbSingleton.getFRSWebViewHost();
        this.d = "";
        this.e = this.c + "mo/q/hybrid-main-frs/mainPage?needNotify=1&customfullscreen=1&nonavigationbar=1";
        this.h = new InteractLayer();
    }

    public static final boolean A(BottomController this$0, WebView webView, String url) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, this$0, webView, url)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<?> a = yl7.a(this$0.b);
            Intrinsics.checkNotNullExpressionValue(url, "url");
            if (urlManager.dealOneLinkWithOutJumpWebView(a, new String[]{url}) != 3) {
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static final Object v(BottomController this$0) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            return this$0.d;
        }
        return invokeL.objValue;
    }

    public static final Object w(MutableLiveData data) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "$data");
            fh7 fh7Var = (fh7) data.getValue();
            if (fh7Var != null) {
                return th7.a(fh7Var);
            }
            return null;
        }
        return invokeL.objValue;
    }

    public static final Object y(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            if (i == -1) {
                i = 2;
            }
            return Integer.valueOf(i);
        }
        return invokeI.objValue;
    }

    public static final void t(BottomController this$0, fh7 fh7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, fh7Var) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (fh7Var != null) {
                PrintStream printStream = System.out;
                printStream.println("通知H5渲染数据 -> " + System.currentTimeMillis());
                this$0.h.e(fh7Var);
                bj6 a = ej6.a();
                BottomWebView bottomWebView = this$0.f;
                if (bottomWebView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                    bottomWebView = null;
                }
                a.i(bottomWebView, "frsPageNa.frsPageRes", new JSONObject());
                ug7.j(this$0.b).q();
            }
        }
    }

    public static final Object x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return Integer.valueOf(xl7.a());
        }
        return invokeV.objValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            BottomWebView bottomWebView = this.f;
            if (bottomWebView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView = null;
            }
            bottomWebView.loadUrl(this.e);
        }
    }

    @Override // com.baidu.tieba.pg7
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.l();
            this.h.d();
        }
    }

    @Override // com.baidu.tieba.pg7
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.n();
            bj6 a = ej6.a();
            BottomWebView bottomWebView = this.f;
            if (bottomWebView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView = null;
            }
            a.d(bottomWebView, CommonTbJsBridge.RE_SHOW, null);
        }
    }

    public final ViewGroup r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            FrameLayout frameLayout = this.g;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
                return null;
            }
            return frameLayout;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ((BottomViewModel) new ViewModelProvider(this.b).get(BottomViewModel.class)).a().observe(this.b, new Observer() { // from class: com.baidu.tieba.yf7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        BottomController.t(BottomController.this, (fh7) obj);
                    }
                }
            });
            u();
        }
    }

    public static final Object z(MutableLiveData data, BottomController this$0) {
        InterceptResult invokeLL;
        BusinessPromot businessPromot;
        int i;
        ForumInfo e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, data, this$0)) == null) {
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            gqa gqaVar = new gqa();
            fh7 fh7Var = (fh7) data.getValue();
            Long l = null;
            if (fh7Var != null) {
                businessPromot = fh7Var.c();
            } else {
                businessPromot = null;
            }
            gqaVar.t(businessPromot);
            if (!ug7.b(this$0.b).y() && !ug7.b(this$0.b).M0()) {
                fh7 fh7Var2 = (fh7) data.getValue();
                if (fh7Var2 != null && (e = fh7Var2.e()) != null) {
                    l = e.id;
                }
                if (!ki7.e(gqaVar, String.valueOf(l))) {
                    i = 0;
                    return Integer.valueOf(i);
                }
            }
            i = 1;
            return Integer.valueOf(i);
        }
        return invokeLL.objValue;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.b instanceof BaseFragmentActivity)) {
            InteractLayer interactLayer = this.h;
            TbPageContext<BaseFragmentActivity> pageContext = ((BaseFragmentActivity) this.b).getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "activity.pageContext");
            BottomWebView bottomWebView = this.f;
            BottomWebView bottomWebView2 = null;
            if (bottomWebView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView = null;
            }
            interactLayer.f(new FollowStateBiz(pageContext, bottomWebView));
            InteractLayer interactLayer2 = this.h;
            TbPageContext<BaseFragmentActivity> pageContext2 = ((BaseFragmentActivity) this.b).getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext2, "activity.pageContext");
            BottomWebView bottomWebView3 = this.f;
            if (bottomWebView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView3 = null;
            }
            interactLayer2.f(new H5HeightStateBiz(pageContext2, bottomWebView3));
            InteractLayer interactLayer3 = this.h;
            TbPageContext<BaseFragmentActivity> pageContext3 = ((BaseFragmentActivity) this.b).getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext3, "activity.pageContext");
            BottomWebView bottomWebView4 = this.f;
            if (bottomWebView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView4 = null;
            }
            interactLayer3.f(new AdVideoLocationBiz(pageContext3, bottomWebView4));
            InteractLayer interactLayer4 = this.h;
            TbPageContext<BaseFragmentActivity> pageContext4 = ((BaseFragmentActivity) this.b).getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext4, "activity.pageContext");
            BottomWebView bottomWebView5 = this.f;
            if (bottomWebView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView5 = null;
            }
            interactLayer4.f(new AcitvityHeadJumpBiz(pageContext4, bottomWebView5));
            InteractLayer interactLayer5 = this.h;
            TbPageContext<BaseFragmentActivity> pageContext5 = ((BaseFragmentActivity) this.b).getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext5, "activity.pageContext");
            BottomWebView bottomWebView6 = this.f;
            if (bottomWebView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView6 = null;
            }
            interactLayer5.f(new ShowBubbleStateBiz(pageContext5, bottomWebView6));
            InteractLayer interactLayer6 = this.h;
            TbPageContext<BaseFragmentActivity> pageContext6 = ((BaseFragmentActivity) this.b).getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext6, "activity.pageContext");
            BottomWebView bottomWebView7 = this.f;
            if (bottomWebView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView7 = null;
            }
            interactLayer6.f(new FrsSignStateBiz(pageContext6, bottomWebView7, new BottomController$registerBiz$1(this)));
            InteractLayer interactLayer7 = this.h;
            TbPageContext<BaseFragmentActivity> pageContext7 = ((BaseFragmentActivity) this.b).getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext7, "activity.pageContext");
            BottomWebView bottomWebView8 = this.f;
            if (bottomWebView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView8 = null;
            }
            interactLayer7.f(new ChatRoomSocketBiz(pageContext7, bottomWebView8));
            InteractLayer interactLayer8 = this.h;
            TbPageContext<BaseFragmentActivity> pageContext8 = ((BaseFragmentActivity) this.b).getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext8, "activity.pageContext");
            BottomWebView bottomWebView9 = this.f;
            if (bottomWebView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView9 = null;
            }
            interactLayer8.f(new BusinessPromotBiz(pageContext8, bottomWebView9));
            InteractLayer interactLayer9 = this.h;
            TbPageContext<BaseFragmentActivity> pageContext9 = ((BaseFragmentActivity) this.b).getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext9, "activity.pageContext");
            BottomWebView bottomWebView10 = this.f;
            if (bottomWebView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
            } else {
                bottomWebView2 = bottomWebView10;
            }
            interactLayer9.f(new SharePageBiz(pageContext9, bottomWebView2));
        }
    }

    @Override // com.baidu.tieba.pg7
    public void g(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, intent) == null) {
            this.h.c(i, intent);
        }
    }

    @Override // com.baidu.tieba.pg7
    public void k(Bundle bundle, ActivityForumBinding binding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, bundle, binding) == null) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            super.k(bundle, binding);
            BottomWebView bottomWebView = binding.d;
            Intrinsics.checkNotNullExpressionValue(bottomWebView, "binding.bottomWeb");
            this.f = bottomWebView;
            FrameLayout frameLayout = binding.q;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.rootContainer");
            this.g = frameLayout;
            BottomWebView bottomWebView2 = this.f;
            BottomWebView bottomWebView3 = null;
            if (bottomWebView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView2 = null;
            }
            bottomWebView2.setNestedScrollingEnabled(true);
            BottomWebView bottomWebView4 = this.f;
            if (bottomWebView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView4 = null;
            }
            bottomWebView4.setScrollBarEnabled(1, false);
            BottomWebView bottomWebView5 = this.f;
            if (bottomWebView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView5 = null;
            }
            bottomWebView5.setInterceptParentCls(SwipeBackLayout.class);
            s();
            B();
            Bundle extras = this.b.getIntent().getExtras();
            if (extras == null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
            } else {
                bundle = extras;
            }
            String string = bundle.getString("name");
            if (string == null) {
                string = "";
            }
            this.d = string;
            this.e += "&forumName=" + this.d;
            BottomWebView bottomWebView6 = this.f;
            if (bottomWebView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView6 = null;
            }
            bottomWebView6.loadUrl(this.e);
            BottomWebView bottomWebView7 = this.f;
            if (bottomWebView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
            } else {
                bottomWebView3 = bottomWebView7;
            }
            bottomWebView3.setOnLoadUrlListener(new jj6() { // from class: com.baidu.tieba.sf7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.jj6
                public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, webView, str)) == null) ? BottomController.A(BottomController.this, webView, str) : invokeLL.booleanValue;
                }
            });
        }
    }

    public final void q(String eventName, JSONObject params) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, eventName, params) == null) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(params, "params");
            bj6 a = ej6.a();
            BottomWebView bottomWebView = this.f;
            if (bottomWebView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView = null;
            }
            a.i(bottomWebView, eventName, params);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            final MutableLiveData<fh7> a = ((BottomViewModel) new ViewModelProvider(this.b).get(BottomViewModel.class)).a();
            BottomWebView bottomWebView = this.f;
            BottomWebView bottomWebView2 = null;
            if (bottomWebView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView = null;
            }
            bottomWebView.I(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME, new ag6() { // from class: com.baidu.tieba.of7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ag6, java.util.concurrent.Callable
                public final Object call() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? BottomController.v(BottomController.this) : invokeV.objValue;
                }
            });
            BottomWebView bottomWebView3 = this.f;
            if (bottomWebView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView3 = null;
            }
            bottomWebView3.I("frsPageRes", new ag6() { // from class: com.baidu.tieba.kf7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ag6, java.util.concurrent.Callable
                public final Object call() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? BottomController.w(MutableLiveData.this) : invokeV.objValue;
                }
            });
            BottomWebView bottomWebView4 = this.f;
            if (bottomWebView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView4 = null;
            }
            bottomWebView4.I("networkStatus", new ag6() { // from class: com.baidu.tieba.ef7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ag6, java.util.concurrent.Callable
                public final Object call() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? BottomController.x() : invokeV.objValue;
                }
            });
            final int autoPlaySwitch = TbadkCoreApplication.getInst().getAutoPlaySwitch();
            BottomWebView bottomWebView5 = this.f;
            if (bottomWebView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
                bottomWebView5 = null;
            }
            bottomWebView5.I("videoAutoPlay", new ag6() { // from class: com.baidu.tieba.ig7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ag6, java.util.concurrent.Callable
                public final Object call() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? BottomController.y(autoPlaySwitch) : invokeV.objValue;
                }
            });
            BottomWebView bottomWebView6 = this.f;
            if (bottomWebView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomWebView");
            } else {
                bottomWebView2 = bottomWebView6;
            }
            bottomWebView2.I("bannerPrompt", new ag6() { // from class: com.baidu.tieba.dg7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ag6, java.util.concurrent.Callable
                public final Object call() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? BottomController.z(MutableLiveData.this, this) : invokeV.objValue;
                }
            });
        }
    }
}
