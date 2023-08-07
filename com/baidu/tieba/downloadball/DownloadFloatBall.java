package com.baidu.tieba.downloadball;

import android.app.Activity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.edgefloat.foldclose.FoldCloseEdgeFloat;
import com.baidu.tieba.era;
import com.baidu.tieba.mx9;
import com.baidu.tieba.pqa;
import com.baidu.tieba.view.progressball.ProgressBall;
import com.baidu.tieba.yv6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020,H\u0002J\b\u0010.\u001a\u00020,H\u0002J\b\u0010/\u001a\u00020,H\u0002J\u0006\u00100\u001a\u000201J\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u000203J\u000e\u00105\u001a\u0002012\u0006\u00106\u001a\u00020\u0011J\u000e\u00107\u001a\u0002012\u0006\u00108\u001a\u000203J\u001e\u00109\u001a\u0002012\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u0002032\u0006\u00108\u001a\u000203R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R(\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010#\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u001b\u001a\u0004\b(\u0010)¨\u0006<"}, d2 = {"Lcom/baidu/tieba/downloadball/DownloadFloatBall;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "PAGE_NO_SUPPORT_LIST", "", "", "getPAGE_NO_SUPPORT_LIST", "()Ljava/util/List;", "UNFOLD_TEXT_MAX_LENGHT", "", "getUNFOLD_TEXT_MAX_LENGHT", "()I", "UNFOLD_TEXT_MAX_LINES", "getUNFOLD_TEXT_MAX_LINES", "downloadBallData", "Lcom/baidu/tieba/downloadball/DownloadFloatBallData;", "getDownloadBallData", "()Lcom/baidu/tieba/downloadball/DownloadFloatBallData;", "setDownloadBallData", "(Lcom/baidu/tieba/downloadball/DownloadFloatBallData;)V", "foldCloseEdgeFloat", "Lcom/baidu/tieba/edgefloat/foldclose/FoldCloseEdgeFloat;", "getFoldCloseEdgeFloat", "()Lcom/baidu/tieba/edgefloat/foldclose/FoldCloseEdgeFloat;", "foldCloseEdgeFloat$delegate", "Lkotlin/Lazy;", "value", "Landroid/view/View$OnClickListener;", "onCloseClickListener", "getOnCloseClickListener", "()Landroid/view/View$OnClickListener;", "setOnCloseClickListener", "(Landroid/view/View$OnClickListener;)V", "onOtherClickListener", "getOnOtherClickListener", "setOnOtherClickListener", "progressBall", "Lcom/baidu/tieba/view/progressball/ProgressBall;", "getProgressBall", "()Lcom/baidu/tieba/view/progressball/ProgressBall;", "progressBall$delegate", "getDownloadingData", "Lcom/baidu/tieba/view/progressball/ProgressBallData;", "getFullProgressData", "getPauseData", "getProgressBallData", "hide", "", "isFolded", "", "isShowing", "setData", "data", "show", "isStart", "statistic", "key", "isClose", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DownloadFloatBall {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final int b;
    public final List<String> c;
    public final Lazy d;
    public final Lazy e;
    public yv6 f;
    public View.OnClickListener g;
    public View.OnClickListener h;

    public DownloadFloatBall(final Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
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
        this.a = 2;
        this.b = 2;
        this.c = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"LogoActivity", "ImageViewerActivity", "InterestGuideActivity", "TBWebViewActivity", "NewWriteActivity", "NewSquareSearchActivity", "VideoPlayActivity", "FrsVideoTabPlayActivity", "VideoRecommentPlayActivity", "AlbumFloatActivity", "SelectForumActivity", "NewSubPbActivity", "PbCommentFloatActivity", "TbFileVideoActivity", "TbEditVideoActivity", "WorkPublishActivity", "SelectClassDialogActivity", "SelectTagActivity", "PbFullScreenEditorActivity", "GiftTabActivity", "AtListActivity", "TBWebContainerActivity"});
        this.d = LazyKt__LazyJVMKt.lazy(DownloadFloatBall$progressBall$2.INSTANCE);
        this.e = LazyKt__LazyJVMKt.lazy(new Function0<FoldCloseEdgeFloat>(activity, this) { // from class: com.baidu.tieba.downloadball.DownloadFloatBall$foldCloseEdgeFloat$2
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ Activity $activity;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DownloadFloatBall this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {activity, this};
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
                this.$activity = activity;
                this.this$0 = this;
            }

            /* loaded from: classes5.dex */
            public static final class a implements pqa {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DownloadFloatBall a;

                public a(DownloadFloatBall downloadFloatBall) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {downloadFloatBall};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = downloadFloatBall;
                }

                @Override // com.baidu.tieba.pqa
                public void a(boolean z) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                        DownloadFloatBall downloadFloatBall = this.a;
                        downloadFloatBall.m(downloadFloatBall.b());
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FoldCloseEdgeFloat invoke() {
                InterceptResult invokeV;
                ProgressBall h;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    Activity activity2 = this.$activity;
                    h = this.this$0.h();
                    FoldCloseEdgeFloat.a aVar = new FoldCloseEdgeFloat.a(activity2, h);
                    aVar.d(this.this$0.f());
                    FoldCloseEdgeFloat a2 = aVar.a();
                    a2.m(new a(this.this$0));
                    return a2;
                }
                return (FoldCloseEdgeFloat) invokeV.objValue;
            }
        });
        this.f = new yv6();
    }

    public final void m(yv6 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.f = data;
            h().b(i());
        }
    }

    public final void n(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.g = onClickListener;
            d().l(this.g);
        }
    }

    public final void o(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) {
            this.h = onClickListener;
            d().n(this.h);
        }
    }

    public final void p(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048590, this, z) != null) || l()) {
            return;
        }
        d().o();
        q(TbadkCoreStatisticKey.DOWNLOAD_FLOAT_BALL_SHOW, false, z);
    }

    public final yv6 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (yv6) invokeV.objValue;
    }

    public final FoldCloseEdgeFloat d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (FoldCloseEdgeFloat) this.e.getValue();
        }
        return (FoldCloseEdgeFloat) invokeV.objValue;
    }

    public final List<String> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public final ProgressBall h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return (ProgressBall) this.d.getValue();
        }
        return (ProgressBall) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d().h();
        }
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return d().i();
        }
        return invokeV.booleanValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return d().j();
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0037: INVOKE  (r4v1 int A[REMOVE]) = (r0v2 com.baidu.tieba.era) type: VIRTUAL call: com.baidu.tieba.era.e():int), ('%' char)] */
    public final era c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            era eraVar = new era();
            String c = this.f.c();
            if (c == null) {
                c = "";
            }
            eraVar.h(c);
            eraVar.j(R.drawable.progress_ball_dynamic);
            eraVar.l(Math.min(Math.max(this.f.f(), 0), 100));
            StringBuilder sb = new StringBuilder();
            sb.append(eraVar.e());
            sb.append('%');
            eraVar.m(new SpannableString(sb.toString()));
            eraVar.f().setSpan(new AbsoluteSizeSpan(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X06)), 0, eraVar.f().length() - 1, 17);
            return eraVar;
        }
        return (era) invokeV.objValue;
    }

    public final era e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            era eraVar = new era();
            String c = this.f.c();
            if (c == null) {
                c = "";
            }
            eraVar.h(c);
            eraVar.i(R.color.CAM_X0302);
            eraVar.l(100);
            eraVar.m(new SpannableString(this.f.b()));
            return eraVar;
        }
        return (era) invokeV.objValue;
    }

    public final era g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            era eraVar = new era();
            String c = this.f.c();
            if (c == null) {
                c = "";
            }
            eraVar.h(c);
            eraVar.i(R.color.CAM_X0305);
            eraVar.l(Math.min(Math.max(this.f.f(), 0), 100));
            eraVar.m(new SpannableString(this.f.b()));
            return eraVar;
        }
        return (era) invokeV.objValue;
    }

    public final era i() {
        InterceptResult invokeV;
        era e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f.a() == 7) {
                e = g();
            } else if (this.f.a() == 1) {
                e = c();
            } else {
                e = e();
            }
            if (!k() && !TextUtils.isEmpty(this.f.g())) {
                e.m(new SpannableString(this.f.g()));
                e.n(this.b);
                e.k(this.a);
            }
            return e;
        }
        return (era) invokeV.objValue;
    }

    public final void q(String key, boolean z, boolean z2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{key, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            Intrinsics.checkNotNullParameter(key, "key");
            StatisticItem statisticItem = new StatisticItem(key);
            statisticItem.param("obj_source", this.f.d());
            int i2 = 2;
            if (mx9.i(this.f.e())) {
                i = 4;
            } else {
                if (!z2) {
                    int a = this.f.a();
                    if (a != 0) {
                        if (a != 1) {
                            if (a != 3) {
                                if (a != 7) {
                                    i = 5;
                                } else {
                                    i = 2;
                                }
                            }
                        }
                    }
                    i = 3;
                }
                i = 1;
            }
            statisticItem.param("obj_param1", i);
            if (z) {
                i2 = 3;
            } else if (k()) {
                i2 = 1;
            }
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, i2);
            TiebaStatic.log(statisticItem);
        }
    }
}
