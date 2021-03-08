package com.baidu.tieba.frs.videomiddlepagelight;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.tbadk.TbPageContext;
import kotlin.e;
import kotlin.jvm.internal.p;
@e
/* loaded from: classes2.dex */
public final class VideoMiddlePageViewModelFactory implements ViewModelProvider.Factory {
    private final TbPageContext<?> pageContext;

    public VideoMiddlePageViewModelFactory(TbPageContext<?> tbPageContext) {
        p.p(tbPageContext, "pageContext");
        this.pageContext = tbPageContext;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> cls) {
        p.p(cls, "modelClass");
        if (cls.isAssignableFrom(VideoMiddlePageViewModel.class)) {
            return new VideoMiddlePageViewModel(this.pageContext);
        }
        throw new RuntimeException("ViewModel create fail!:" + cls.getName());
    }
}
