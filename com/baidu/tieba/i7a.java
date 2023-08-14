package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.sprite.FunnySpriteResDownloadUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes6.dex */
public final class i7a extends sk1<ao5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static final class a implements ao5 {
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

        @Override // com.baidu.tieba.ao5
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return FunnySpriteResDownloadUtil.j("funny_sprite_chat_baseboard", null, false, 6, null);
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.ao5
        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return FunnySpriteResDownloadUtil.j("funny_sprite_chat_wall", null, false, 6, null);
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.ao5
        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return FunnySpriteResDownloadUtil.j("funny_sprite_chat_light", null, false, 6, null);
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.ao5
        public as6 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                as6 as6Var = new as6();
                as6Var.d(FunnySpriteResDownloadUtil.j("personal_chat_sprite_stage", null, false, 6, null));
                as6Var.c(true);
                if (StringsKt__StringsJVMKt.endsWith$default(as6Var.a(), DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, false, 2, null)) {
                    as6Var.e(1);
                } else if (StringsKt__StringsJVMKt.endsWith$default(as6Var.a(), ".webp", false, 2, null)) {
                    as6Var.e(2);
                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalStateException("unsupported file path " + as6Var.a());
                }
                return as6Var;
            }
            return (as6) invokeV.objValue;
        }
    }

    public i7a() {
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
    @Override // com.baidu.tieba.sk1
    /* renamed from: a */
    public ao5 createService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a();
        }
        return (ao5) invokeV.objValue;
    }
}
