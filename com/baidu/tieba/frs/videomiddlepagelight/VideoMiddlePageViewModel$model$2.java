package com.baidu.tieba.frs.videomiddlepagelight;

import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import java.util.List;
import kotlin.collections.n;
import kotlin.e;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.p;
@e
/* loaded from: classes2.dex */
final class VideoMiddlePageViewModel$model$2 extends Lambda implements kotlin.jvm.a.a<VideoMiddleModel> {
    final /* synthetic */ VideoMiddlePageViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoMiddlePageViewModel$model$2(VideoMiddlePageViewModel videoMiddlePageViewModel) {
        super(0);
        this.this$0 = videoMiddlePageViewModel;
    }

    @e
    /* loaded from: classes2.dex */
    public static final class a implements VideoMiddleModel.a {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void p(List<? extends BaseCardInfo> list, boolean z) {
            p.o(list, "newData");
            VideoMiddlePageViewModel$model$2.this.this$0.cMS().setValue(false);
            VideoMiddlePageViewModel$model$2.this.this$0.cMT().setValue(Boolean.valueOf(z));
            VideoMiddlePageViewModel$model$2.this.this$0.cv(n.q(list));
            VideoMiddlePageViewModel$model$2.this.this$0.cMU().setValue("");
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.a
        public void vz(String str) {
            p.o(str, "errMsg");
            VideoMiddlePageViewModel$model$2.this.this$0.cMS().setValue(false);
            VideoMiddlePageViewModel$model$2.this.this$0.cMU().setValue(str);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.a.a
    public final VideoMiddleModel invoke() {
        return new VideoMiddleModel(this.this$0.getPageContext(), new a());
    }
}
