package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.pla;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes5.dex */
public class cma implements kla, pla.c, fr6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public cla b;
    public ola c;
    public SelectMusicModel d;
    public String e;

    @Override // com.baidu.tieba.kla
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    public cma(cla claVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {claVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = claVar;
        this.a = claVar.a;
    }

    public final void a(String str) {
        cla claVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (claVar = this.b) == null) {
            return;
        }
        if (claVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        cla claVar2 = this.b;
        if (claVar2 != null) {
            claVar2.f(videoInfo);
        }
    }

    public void b() {
        cla claVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (claVar = this.b) == null) {
            return;
        }
        if (claVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            cla claVar2 = this.b;
            if (!claVar2.e) {
                l1(claVar2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        cla claVar3 = this.b;
        selectMusicModel.Q(claVar3.b, claVar3.d, dla.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !claVar3.e);
    }

    @Override // com.baidu.tieba.fr6
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            cla claVar = this.b;
            if (claVar != null) {
                claVar.i(true);
            }
            ola olaVar = this.c;
            if (olaVar != null && olaVar.f()) {
                this.c.e();
            }
        }
    }

    @Override // com.baidu.tieba.kla
    public void l1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i, str2) == null) {
            cla claVar = this.b;
            if (claVar != null && claVar.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c8f);
                cla claVar2 = this.b;
                if (claVar2 != null) {
                    claVar2.g(i, str2);
                }
            } else {
                cla claVar3 = this.b;
                if (claVar3 != null) {
                    claVar3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        ola olaVar = new ola(this.a.getActivity());
                        this.c = olaVar;
                        olaVar.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                cla claVar4 = this.b;
                if (claVar4 != null) {
                    claVar4.e();
                }
                a(str);
            }
        }
    }

    @Override // com.baidu.tieba.pla.c
    public void onGenFilterVideoFail(int i, String str) {
        cla claVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && (claVar = this.b) != null) {
            claVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.pla.c
    public void onGenFilterVideoRecordError(int i, String str) {
        cla claVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) && (claVar = this.b) != null) {
            claVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.pla.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            cla claVar = this.b;
            if (claVar != null) {
                claVar.e();
            }
            a(str);
        }
    }
}
