package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.v1b;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes6.dex */
public class i2b implements q1b, v1b.c, xp6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public i1b b;
    public u1b c;
    public SelectMusicModel d;
    public String e;

    @Override // com.baidu.tieba.q1b
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    public i2b(i1b i1bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i1bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = i1bVar;
        this.a = i1bVar.a;
    }

    public final void a(String str) {
        i1b i1bVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || (i1bVar = this.b) == null) {
            return;
        }
        if (i1bVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        i1b i1bVar2 = this.b;
        if (i1bVar2 != null) {
            i1bVar2.f(videoInfo);
        }
    }

    @Override // com.baidu.tieba.q1b
    public void A0(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i, str2) == null) {
            i1b i1bVar = this.b;
            if (i1bVar != null && i1bVar.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0ccd);
                i1b i1bVar2 = this.b;
                if (i1bVar2 != null) {
                    i1bVar2.g(i, str2);
                }
            } else {
                i1b i1bVar3 = this.b;
                if (i1bVar3 != null) {
                    i1bVar3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        u1b u1bVar = new u1b(this.a.getActivity());
                        this.c = u1bVar;
                        u1bVar.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                i1b i1bVar4 = this.b;
                if (i1bVar4 != null) {
                    i1bVar4.e();
                }
                a(str);
            }
        }
    }

    public void b() {
        i1b i1bVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (i1bVar = this.b) == null) {
            return;
        }
        if (i1bVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            i1b i1bVar2 = this.b;
            if (!i1bVar2.e) {
                A0(i1bVar2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        i1b i1bVar3 = this.b;
        selectMusicModel.R(i1bVar3.b, i1bVar3.d, j1b.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !i1bVar3.e);
    }

    @Override // com.baidu.tieba.xp6
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            i1b i1bVar = this.b;
            if (i1bVar != null) {
                i1bVar.i(true);
            }
            u1b u1bVar = this.c;
            if (u1bVar != null && u1bVar.f()) {
                this.c.e();
            }
        }
    }

    @Override // com.baidu.tieba.v1b.c
    public void onGenFilterVideoFail(int i, String str) {
        i1b i1bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && (i1bVar = this.b) != null) {
            i1bVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.v1b.c
    public void onGenFilterVideoRecordError(int i, String str) {
        i1b i1bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) && (i1bVar = this.b) != null) {
            i1bVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.v1b.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            i1b i1bVar = this.b;
            if (i1bVar != null) {
                i1bVar.e();
            }
            a(str);
        }
    }
}
