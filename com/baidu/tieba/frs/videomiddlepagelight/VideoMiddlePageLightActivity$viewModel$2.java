package com.baidu.tieba.frs.videomiddlepagelight;

import androidx.lifecycle.ViewModelProviders;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageViewModel;", "invoke"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class VideoMiddlePageLightActivity$viewModel$2 extends Lambda implements Function0<VideoMiddlePageViewModel> {
    public final /* synthetic */ VideoMiddlePageLightActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoMiddlePageLightActivity$viewModel$2(VideoMiddlePageLightActivity videoMiddlePageLightActivity) {
        super(0);
        this.this$0 = videoMiddlePageLightActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final VideoMiddlePageViewModel invoke() {
        VideoMiddlePageLightActivity videoMiddlePageLightActivity = this.this$0;
        TbPageContext<BaseFragmentActivity> pageContext = videoMiddlePageLightActivity.getPageContext();
        Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
        return (VideoMiddlePageViewModel) ViewModelProviders.of(videoMiddlePageLightActivity, new VideoMiddlePageViewModelFactory(pageContext)).get(VideoMiddlePageViewModel.class);
    }
}
