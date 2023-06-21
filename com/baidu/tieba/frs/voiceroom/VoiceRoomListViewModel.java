package com.baidu.tieba.frs.voiceroom;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.cx4;
import com.baidu.tieba.dx4;
import com.baidu.tieba.frs.voiceroom.data.VoiceRoomWrapper;
import com.baidu.tieba.ws7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013R \u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_roomList", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/tbadk/base/mvvm/vo/RequestResult;", "", "Lcom/baidu/tieba/frs/voiceroom/data/VoiceRoomWrapper;", "repository", "Lcom/baidu/tieba/frs/voiceroom/data/VoiceRoomRepository;", "roomList", "Landroidx/lifecycle/LiveData;", "getRoomList", "()Landroidx/lifecycle/LiveData;", "requestRoomList", "", "tbPageContext", "Lcom/baidu/tbadk/TbPageContext;", "callFrom", "", "fid", "frs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VoiceRoomListViewModel extends ViewModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ws7 a;
    public final MutableLiveData<dx4<List<VoiceRoomWrapper>>> b;

    /* loaded from: classes5.dex */
    public static final class a implements cx4<List<? extends VoiceRoomWrapper>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VoiceRoomListViewModel a;

        public a(VoiceRoomListViewModel voiceRoomListViewModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceRoomListViewModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = voiceRoomListViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.tieba.dx4<? extends java.util.List<com.baidu.tieba.frs.voiceroom.data.VoiceRoomWrapper>>] */
        @Override // com.baidu.tieba.cx4
        public void a(dx4<? extends List<? extends VoiceRoomWrapper>> result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, result) == null) {
                Intrinsics.checkNotNullParameter(result, "result");
                this.a.b.setValue(result);
            }
        }
    }

    public VoiceRoomListViewModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ws7();
        this.b = new MutableLiveData<>();
    }

    public final LiveData<dx4<List<VoiceRoomWrapper>>> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (LiveData) invokeV.objValue;
    }

    public final void c(TbPageContext<?> tbPageContext, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{tbPageContext, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            Intrinsics.checkNotNullParameter(tbPageContext, "tbPageContext");
            this.a.a(tbPageContext, j, j2, new a(this));
        }
    }
}
