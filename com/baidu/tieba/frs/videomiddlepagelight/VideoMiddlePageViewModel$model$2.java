package com.baidu.tieba.frs.videomiddlepagelight;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/tieba/frs/videomiddlepage/VideoMiddleModel;", "invoke"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class VideoMiddlePageViewModel$model$2 extends Lambda implements Function0<VideoMiddleModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ VideoMiddlePageViewModel this$0;

    /* loaded from: classes9.dex */
    public static final class a implements VideoMiddleModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageViewModel$model$2 f49956a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(VideoMiddlePageViewModel$model$2 videoMiddlePageViewModel$model$2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageViewModel$model$2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49956a = videoMiddlePageViewModel$model$2;
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f49956a.this$0.isLoading().setValue(Boolean.FALSE);
                this.f49956a.this$0.getLoadErrorMsg().setValue(str);
            }
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.b
        public void b(List<? extends BaseCardInfo> list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, z) == null) {
                this.f49956a.this$0.isLoading().setValue(Boolean.FALSE);
                this.f49956a.this$0.getHasMore().setValue(Boolean.valueOf(z));
                this.f49956a.this$0.addData(CollectionsKt___CollectionsKt.toMutableList((Collection) list));
                this.f49956a.this$0.getLoadErrorMsg().setValue("");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoMiddlePageViewModel$model$2(VideoMiddlePageViewModel videoMiddlePageViewModel) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {videoMiddlePageViewModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.this$0 = videoMiddlePageViewModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final VideoMiddleModel invoke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new VideoMiddleModel(this.this$0.getPageContext(), new a(this)) : (VideoMiddleModel) invokeV.objValue;
    }
}
