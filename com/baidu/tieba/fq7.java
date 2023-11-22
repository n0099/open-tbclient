package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.module.frs.Frs$From;
import com.baidu.tbadk.module.frs.FrsService;
import com.baidu.tieba.frs.voiceroom.VoiceRoomListActivity;
import com.baidu.tieba.frs.voiceroom.VoiceRoomStat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes6.dex */
public final class fq7 extends bg1<FrsService> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static final class a implements FrsService {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.module.frs.FrsService
        public void navToVoiceRoom(TbPageContext<?> tbPageContext, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, tbPageContext, j) == null) {
                Intrinsics.checkNotNullParameter(tbPageContext, "tbPageContext");
                navToVoiceRoom(tbPageContext, "bdtiebalive://video/mixlive?room_id=" + j);
            }
        }

        @Override // com.baidu.tbadk.module.frs.FrsService
        public void shareForum(Context context, Object data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, context, data) == null) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(data, "data");
                x38.d(context, data);
            }
        }

        @Override // com.baidu.tbadk.module.frs.FrsService
        public void statStartRoomEvent(Long l, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, l, str) == null) {
                VoiceRoomStat.d(l, str);
            }
        }

        @Override // com.baidu.tbadk.module.frs.FrsService
        public void navToVoiceRoom(TbPageContext<?> tbPageContext, long j, Map<String, String> extParams) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{tbPageContext, Long.valueOf(j), extParams}) == null) {
                Intrinsics.checkNotNullParameter(tbPageContext, "tbPageContext");
                Intrinsics.checkNotNullParameter(extParams, "extParams");
                navToVoiceRoom(tbPageContext, String.valueOf(j), extParams);
            }
        }

        @Override // com.baidu.tbadk.module.frs.FrsService
        public void navToVoiceRoom(TbPageContext<?> tbPageContext, String scheme) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, scheme) == null) {
                Intrinsics.checkNotNullParameter(tbPageContext, "tbPageContext");
                Intrinsics.checkNotNullParameter(scheme, "scheme");
                UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{scheme});
            }
        }

        @Override // com.baidu.tbadk.module.frs.FrsService
        public void navToVoiceRoom(TbPageContext<?> tbPageContext, String str, Map<String, String> extParams) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, tbPageContext, str, extParams) == null) {
                Intrinsics.checkNotNullParameter(tbPageContext, "tbPageContext");
                Intrinsics.checkNotNullParameter(extParams, "extParams");
                StringBuilder sb = new StringBuilder();
                sb.append("bdtiebalive://video/mixlive?room_id=" + str);
                for (Map.Entry<String, String> entry : extParams.entrySet()) {
                    if (!Intrinsics.areEqual(entry.getKey(), "room_id")) {
                        sb.append('&' + entry.getKey() + '=' + entry.getValue());
                    }
                }
                if (!StringsKt__StringsKt.contains$default((CharSequence) sb, (CharSequence) "&source=", false, 2, (Object) null)) {
                    sb.append("&source=source_audio_unknown");
                }
                UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{sb.toString()});
            }
        }

        @Override // com.baidu.tbadk.module.frs.FrsService
        public void navToVoiceRoomList(Context context, Frs$From from, Long l, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048580, this, context, from, l, str) == null) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(from, "from");
                VoiceRoomListActivity.a.a(context, from, l, str);
            }
        }
    }

    public fq7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bg1
    /* renamed from: a */
    public FrsService createService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a();
        }
        return (FrsService) invokeV.objValue;
    }
}
