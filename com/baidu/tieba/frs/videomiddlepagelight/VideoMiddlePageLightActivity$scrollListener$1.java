package com.baidu.tieba.frs.videomiddlepagelight;

import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.m.e;
import c.a.d.f.p.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.videomiddlepagelight.VideoMiddlePageLightActivity;
import com.baidu.tieba.frs.videomiddlepagelight.VideoMiddlePageLightActivity$scrollListener$1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageLightActivity$scrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "frsExtra_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class VideoMiddlePageLightActivity$scrollListener$1 extends RecyclerView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ VideoMiddlePageLightActivity a;

    public VideoMiddlePageLightActivity$scrollListener$1(VideoMiddlePageLightActivity videoMiddlePageLightActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {videoMiddlePageLightActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = videoMiddlePageLightActivity;
    }

    public static final void a(VideoMiddlePageLightActivity this$0) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.isForbidOnceListAutoScroll = true;
            VideoMiddlePageViewModel viewModel = this$0.getViewModel();
            bdTypeRecyclerView = this$0.recyclerView;
            if (bdTypeRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                bdTypeRecyclerView = null;
            }
            viewModel.playVideoAtPosition(bdTypeRecyclerView.getFirstCompletelyVisiblePosition());
        }
    }

    public static final void b(VideoMiddlePageLightActivity this$0) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.isForbidOnceListAutoScroll = true;
            VideoMiddlePageViewModel viewModel = this$0.getViewModel();
            bdTypeRecyclerView = this$0.recyclerView;
            if (bdTypeRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                bdTypeRecyclerView = null;
            }
            viewModel.playVideoAtPosition(bdTypeRecyclerView.getLastCompletelyVisiblePosition());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView rv, int i2) {
        boolean z;
        BdTypeRecyclerView bdTypeRecyclerView;
        BdTypeRecyclerView bdTypeRecyclerView2;
        BdTypeRecyclerView bdTypeRecyclerView3;
        BdTypeRecyclerView bdTypeRecyclerView4;
        BdTypeRecyclerView bdTypeRecyclerView5;
        BdTypeRecyclerView bdTypeRecyclerView6;
        BdTypeRecyclerView bdTypeRecyclerView7;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, rv, i2) == null) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            super.onScrollStateChanged(rv, i2);
            z = this.a.isNeedTwiceScroll;
            if (!z || i2 != 0) {
                Integer value = this.a.getViewModel().getCurPlayingVideoPos().getValue();
                BdTypeRecyclerView bdTypeRecyclerView8 = null;
                if (value != null && i2 == 0) {
                    bdTypeRecyclerView2 = this.a.recyclerView;
                    if (bdTypeRecyclerView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        bdTypeRecyclerView2 = null;
                    }
                    if (bdTypeRecyclerView2.getFirstCompletelyVisiblePosition() == -1) {
                        bdTypeRecyclerView5 = this.a.recyclerView;
                        if (bdTypeRecyclerView5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                            bdTypeRecyclerView5 = null;
                        }
                        if (bdTypeRecyclerView5.getFirstVisiblePosition() != -1) {
                            bdTypeRecyclerView6 = this.a.recyclerView;
                            if (bdTypeRecyclerView6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                                bdTypeRecyclerView6 = null;
                            }
                            int firstVisiblePosition = bdTypeRecyclerView6.getFirstVisiblePosition();
                            Integer value2 = this.a.getViewModel().getCurPlayingVideoPos().getValue();
                            if (value2 == null || firstVisiblePosition != value2.intValue()) {
                                this.a.isForbidOnceListAutoScroll = true;
                                VideoMiddlePageViewModel viewModel = this.a.getViewModel();
                                bdTypeRecyclerView7 = this.a.recyclerView;
                                if (bdTypeRecyclerView7 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                                    bdTypeRecyclerView7 = null;
                                }
                                viewModel.playVideoAtPosition(bdTypeRecyclerView7.getFirstVisiblePosition());
                            }
                        }
                    } else {
                        int intValue = value.intValue();
                        bdTypeRecyclerView3 = this.a.recyclerView;
                        if (bdTypeRecyclerView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                            bdTypeRecyclerView3 = null;
                        }
                        if (intValue < bdTypeRecyclerView3.getFirstCompletelyVisiblePosition()) {
                            e a = e.a();
                            final VideoMiddlePageLightActivity videoMiddlePageLightActivity = this.a;
                            a.post(new Runnable() { // from class: c.a.t0.e1.c3.j
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                @Override // java.lang.Runnable
                                public final void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        VideoMiddlePageLightActivity$scrollListener$1.a(VideoMiddlePageLightActivity.this);
                                    }
                                }
                            });
                        } else {
                            int intValue2 = value.intValue();
                            bdTypeRecyclerView4 = this.a.recyclerView;
                            if (bdTypeRecyclerView4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                                bdTypeRecyclerView4 = null;
                            }
                            if (intValue2 > bdTypeRecyclerView4.getLastCompletelyVisiblePosition()) {
                                e a2 = e.a();
                                final VideoMiddlePageLightActivity videoMiddlePageLightActivity2 = this.a;
                                a2.post(new Runnable() { // from class: c.a.t0.e1.c3.e
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                            VideoMiddlePageLightActivity$scrollListener$1.b(VideoMiddlePageLightActivity.this);
                                        }
                                    }
                                });
                            }
                        }
                    }
                }
                bdTypeRecyclerView = this.a.recyclerView;
                if (bdTypeRecyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                } else {
                    bdTypeRecyclerView8 = bdTypeRecyclerView;
                }
                if (bdTypeRecyclerView8.canScrollVertically(1)) {
                    return;
                }
                if (Intrinsics.areEqual(this.a.getViewModel().getHasMore().getValue(), Boolean.FALSE) && Intrinsics.areEqual(this.a.getViewModel().isLoading().getValue(), Boolean.FALSE)) {
                    this.a.showToast(R.string.no_more_video_content);
                    return;
                } else if (l.z()) {
                    this.a.showToast(R.string.hard_loading);
                    this.a.getViewModel().loadData();
                    return;
                } else {
                    this.a.showToast(R.string.neterror);
                    return;
                }
            }
            this.a.isNeedTwiceScroll = false;
            VideoMiddlePageLightActivity videoMiddlePageLightActivity3 = this.a;
            i3 = videoMiddlePageLightActivity3.twiceScrollToPosition;
            videoMiddlePageLightActivity3.scrollCurPlayingVideoToTop(i3);
        }
    }
}
