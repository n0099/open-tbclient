package com.baidu.tieba.frs.videomiddlepagelight;

import androidx.lifecycle.ViewModelProviders;
import com.baidu.tbadk.TbPageContext;
import kotlin.e;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.p;
@e
/* loaded from: classes2.dex */
final class VideoMiddlePageLightActivity$viewModel$2 extends Lambda implements kotlin.jvm.a.a<VideoMiddlePageViewModel> {
    final /* synthetic */ VideoMiddlePageLightActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoMiddlePageLightActivity$viewModel$2(VideoMiddlePageLightActivity videoMiddlePageLightActivity) {
        super(0);
        this.this$0 = videoMiddlePageLightActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.a.a
    public final VideoMiddlePageViewModel invoke() {
        TbPageContext pageContext = this.this$0.getPageContext();
        p.n(pageContext, "pageContext");
        return (VideoMiddlePageViewModel) ViewModelProviders.of(this.this$0, new VideoMiddlePageViewModelFactory(pageContext)).get(VideoMiddlePageViewModel.class);
    }
}
