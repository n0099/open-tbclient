package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.q17;
import com.baidu.tieba.view.cloudmusic.MusicPlayer;
import com.baidu.tieba.view.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.view.cloudmusic.model.CloudMusicListModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes6.dex */
public class iia implements mia {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CloudMusicListModel a;
    public final nia b;
    public MusicPlayer c;

    /* loaded from: classes6.dex */
    public class b implements q17.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList a;
        public final /* synthetic */ int b;
        public final /* synthetic */ iia c;

        /* loaded from: classes6.dex */
        public class a implements MusicPlayer.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ b b;

            public a(b bVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = str;
            }

            @Override // com.baidu.tieba.view.cloudmusic.MusicPlayer.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.c.c.f();
                    if (this.a.startsWith("/")) {
                        File file = new File(this.a);
                        if (file.exists()) {
                            file.delete();
                        }
                        q17.h().e();
                        b bVar = this.b;
                        bVar.c.b(bVar.a, bVar.b);
                    }
                }
            }
        }

        public b(iia iiaVar, CloudMusicData.MusicTagList.MusicList musicList, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iiaVar, musicList, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = iiaVar;
            this.a = musicList;
            this.b = i;
        }

        @Override // com.baidu.tieba.q17.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.c.b.n0(this.b);
            }
        }

        @Override // com.baidu.tieba.q17.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.c.b.r0(this.b);
            }
        }

        @Override // com.baidu.tieba.q17.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.c.c.e(str, this.a, new a(this, str));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements ria<CloudMusicData.MusicTagList> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iia a;

        public a(iia iiaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iiaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iiaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ria
        /* renamed from: b */
        public void a(CloudMusicData.MusicTagList musicTagList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, musicTagList) == null) {
                this.a.b.M(false);
                if (ListUtils.isEmpty(musicTagList.music_list) && musicTagList.page.pn == 1) {
                    this.a.b.o(true);
                } else {
                    this.a.b.o(false);
                    this.a.b.K0(musicTagList);
                }
                if (musicTagList.page.has_more == 0) {
                    this.a.b.O();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements MusicPlayer.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList b;
        public final /* synthetic */ int c;
        public final /* synthetic */ iia d;

        public c(iia iiaVar, String str, CloudMusicData.MusicTagList.MusicList musicList, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iiaVar, str, musicList, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = iiaVar;
            this.a = str;
            this.b = musicList;
            this.c = i;
        }

        @Override // com.baidu.tieba.view.cloudmusic.MusicPlayer.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.c.f();
                if (this.a.startsWith("/")) {
                    File file = new File(this.a);
                    if (file.exists()) {
                        file.delete();
                    }
                    q17.h().e();
                    this.d.b(this.b, this.c);
                }
            }
        }
    }

    public iia(CloudMusicListModel cloudMusicListModel, nia niaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cloudMusicListModel, niaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cloudMusicListModel;
        this.b = niaVar;
        niaVar.h0(this);
        this.c = MusicPlayer.c();
    }

    @Override // com.baidu.tieba.mia
    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.b.M(true);
            this.a.W(i, new a(this));
        }
    }

    @Override // com.baidu.tieba.mia
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.mia
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.Y();
        }
    }

    @Override // com.baidu.tieba.mia
    public void b(CloudMusicData.MusicTagList.MusicList musicList, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, musicList, i) == null) && musicList != null && !TextUtils.isEmpty(musicList.resource)) {
            String g = q17.h().g(musicList.resource);
            if (TextUtils.isEmpty(g)) {
                this.b.b1(i);
                q17.h().f(String.valueOf(musicList.music_id), musicList.resource, new b(this, musicList, i));
                return;
            }
            this.c.e(g, musicList, new c(this, g, musicList, i));
        }
    }

    @Override // com.baidu.tieba.mia
    public void d(CloudMusicData.MusicTagList musicTagList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, musicTagList) == null) {
            if (ListUtils.isEmpty(musicTagList.music_list)) {
                this.b.o(true);
            } else {
                this.b.o(false);
                this.b.K0(musicTagList);
            }
            if (musicTagList.page.has_more == 0) {
                this.b.O();
            }
        }
    }
}
