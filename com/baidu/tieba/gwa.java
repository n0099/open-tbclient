package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.view.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.view.cloudmusic.model.CloudMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gwa implements hwa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CloudMusicModel a;
    public final iwa b;

    /* loaded from: classes6.dex */
    public class a implements owa<CloudMusicData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gwa a;

        public a(gwa gwaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gwaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gwaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.owa
        /* renamed from: b */
        public void a(CloudMusicData cloudMusicData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cloudMusicData) == null) {
                this.a.b.C0(false);
                if (cloudMusicData != null) {
                    this.a.b.p(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        this.a.b.p(true);
                        return;
                    } else {
                        this.a.b.R(cloudMusicData);
                        return;
                    }
                }
                this.a.b.p(true);
            }
        }
    }

    public gwa(CloudMusicModel cloudMusicModel, iwa iwaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cloudMusicModel, iwaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cloudMusicModel;
        this.b = iwaVar;
        iwaVar.Y0(this);
    }

    @Override // com.baidu.tieba.hwa
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.hwa
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.C0(true);
            this.a.N(new a(this));
        }
    }
}
