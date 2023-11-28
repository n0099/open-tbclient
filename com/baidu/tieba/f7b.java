package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.s6b;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes5.dex */
public class f7b implements n6b, s6b.c, iq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public f6b b;
    public r6b c;
    public SelectMusicModel d;
    public String e;

    @Override // com.baidu.tieba.n6b
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
        }
    }

    public f7b(f6b f6bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f6bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = f6bVar;
        this.a = f6bVar.a;
    }

    public final void a(String str) {
        f6b f6bVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (f6bVar = this.b) == null) {
            return;
        }
        if (f6bVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        f6b f6bVar2 = this.b;
        if (f6bVar2 != null) {
            f6bVar2.f(videoInfo);
        }
    }

    public void b() {
        f6b f6bVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (f6bVar = this.b) == null) {
            return;
        }
        if (f6bVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            f6b f6bVar2 = this.b;
            if (!f6bVar2.e) {
                y0(f6bVar2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        f6b f6bVar3 = this.b;
        selectMusicModel.R(f6bVar3.b, f6bVar3.d, g6b.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !f6bVar3.e);
    }

    @Override // com.baidu.tieba.iq6
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            f6b f6bVar = this.b;
            if (f6bVar != null) {
                f6bVar.i(true);
            }
            r6b r6bVar = this.c;
            if (r6bVar != null && r6bVar.f()) {
                this.c.e();
            }
        }
    }

    @Override // com.baidu.tieba.s6b.c
    public void onGenFilterVideoFail(int i, String str) {
        f6b f6bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) && (f6bVar = this.b) != null) {
            f6bVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.s6b.c
    public void onGenFilterVideoRecordError(int i, String str) {
        f6b f6bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && (f6bVar = this.b) != null) {
            f6bVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.s6b.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            f6b f6bVar = this.b;
            if (f6bVar != null) {
                f6bVar.e();
            }
            a(str);
        }
    }

    @Override // com.baidu.tieba.n6b
    public void y0(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048583, this, str, i, str2) == null) {
            f6b f6bVar = this.b;
            if (f6bVar != null && f6bVar.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0cdb);
                f6b f6bVar2 = this.b;
                if (f6bVar2 != null) {
                    f6bVar2.g(i, str2);
                }
            } else {
                f6b f6bVar3 = this.b;
                if (f6bVar3 != null) {
                    f6bVar3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        r6b r6bVar = new r6b(this.a.getActivity());
                        this.c = r6bVar;
                        r6bVar.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                f6b f6bVar4 = this.b;
                if (f6bVar4 != null) {
                    f6bVar4.e();
                }
                a(str);
            }
        }
    }
}
