package com.baidu.tieba.frs.videomiddlepagelight;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.tbadk.TbPageContext;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001d\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageViewModelFactory;", "androidx/lifecycle/ViewModelProvider$Factory", "Landroidx/lifecycle/ViewModel;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/baidu/tbadk/TbPageContext;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "getPageContext", "()Lcom/baidu/tbadk/TbPageContext;", "<init>", "(Lcom/baidu/tbadk/TbPageContext;)V", "frsExtra_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class VideoMiddlePageViewModelFactory implements ViewModelProvider.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<?> f16715a;

    public VideoMiddlePageViewModelFactory(TbPageContext<?> tbPageContext) {
        this.f16715a = tbPageContext;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> cls) {
        if (cls.isAssignableFrom(VideoMiddlePageViewModel.class)) {
            return new VideoMiddlePageViewModel(this.f16715a);
        }
        throw new RuntimeException("ViewModel create fail!:" + cls.getName());
    }
}
