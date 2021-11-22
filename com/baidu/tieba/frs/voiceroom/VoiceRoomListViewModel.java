package com.baidu.tieba.frs.voiceroom;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import b.a.r0.x0.d3.e.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.voiceroom.data.VoiceRoomWrapper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\b\u001a\u00020\u00072\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR(\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R%\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\u00138F@\u0006¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/baidu/tbadk/TbPageContext;", "tbPageContext", "", "callFrom", "fid", "", "requestRoomList", "(Lcom/baidu/tbadk/TbPageContext;JJ)V", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/tbadk/base/mvvm/vo/RequestResult;", "", "Lcom/baidu/tieba/frs/voiceroom/data/VoiceRoomWrapper;", "_roomList", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/tieba/frs/voiceroom/data/VoiceRoomRepository;", "repository", "Lcom/baidu/tieba/frs/voiceroom/data/VoiceRoomRepository;", "Landroidx/lifecycle/LiveData;", "getRoomList", "()Landroidx/lifecycle/LiveData;", "roomList", "<init>", "()V", "frs_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class VoiceRoomListViewModel extends ViewModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d f50090a;

    /* renamed from: b  reason: collision with root package name */
    public final MutableLiveData<b.a.q0.h.b.b.a<List<VoiceRoomWrapper>>> f50091b;

    /* loaded from: classes9.dex */
    public static final class a implements b.a.q0.h.b.a.a<List<? extends VoiceRoomWrapper>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VoiceRoomListViewModel f50092a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(VoiceRoomListViewModel voiceRoomListViewModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceRoomListViewModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50092a = voiceRoomListViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [b.a.q0.h.b.b.a<? extends java.util.List<com.baidu.tieba.frs.voiceroom.data.VoiceRoomWrapper>>] */
        @Override // b.a.q0.h.b.a.a
        public void a(b.a.q0.h.b.b.a<? extends List<? extends VoiceRoomWrapper>> aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f50092a.f50091b.setValue(aVar);
            }
        }
    }

    public VoiceRoomListViewModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50090a = new d();
        this.f50091b = new MutableLiveData<>();
    }

    public final LiveData<b.a.q0.h.b.b.a<List<VoiceRoomWrapper>>> getRoomList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f50091b : (LiveData) invokeV.objValue;
    }

    public final void requestRoomList(TbPageContext<?> tbPageContext, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{tbPageContext, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.f50090a.a(tbPageContext, j, j2, new a(this));
        }
    }
}
