package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.ola;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes5.dex */
public class bma implements jla, ola.c, er6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public bla b;
    public nla c;
    public SelectMusicModel d;
    public String e;

    @Override // com.baidu.tieba.jla
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    public bma(bla blaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {blaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = blaVar;
        this.a = blaVar.a;
    }

    public final void a(String str) {
        bla blaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (blaVar = this.b) == null) {
            return;
        }
        if (blaVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        bla blaVar2 = this.b;
        if (blaVar2 != null) {
            blaVar2.f(videoInfo);
        }
    }

    public void b() {
        bla blaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (blaVar = this.b) == null) {
            return;
        }
        if (blaVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            bla blaVar2 = this.b;
            if (!blaVar2.e) {
                l1(blaVar2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        bla blaVar3 = this.b;
        selectMusicModel.Q(blaVar3.b, blaVar3.d, cla.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !blaVar3.e);
    }

    @Override // com.baidu.tieba.er6
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            bla blaVar = this.b;
            if (blaVar != null) {
                blaVar.i(true);
            }
            nla nlaVar = this.c;
            if (nlaVar != null && nlaVar.f()) {
                this.c.e();
            }
        }
    }

    @Override // com.baidu.tieba.jla
    public void l1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i, str2) == null) {
            bla blaVar = this.b;
            if (blaVar != null && blaVar.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c8f);
                bla blaVar2 = this.b;
                if (blaVar2 != null) {
                    blaVar2.g(i, str2);
                }
            } else {
                bla blaVar3 = this.b;
                if (blaVar3 != null) {
                    blaVar3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        nla nlaVar = new nla(this.a.getActivity());
                        this.c = nlaVar;
                        nlaVar.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                bla blaVar4 = this.b;
                if (blaVar4 != null) {
                    blaVar4.e();
                }
                a(str);
            }
        }
    }

    @Override // com.baidu.tieba.ola.c
    public void onGenFilterVideoFail(int i, String str) {
        bla blaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && (blaVar = this.b) != null) {
            blaVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.ola.c
    public void onGenFilterVideoRecordError(int i, String str) {
        bla blaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) && (blaVar = this.b) != null) {
            blaVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.ola.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            bla blaVar = this.b;
            if (blaVar != null) {
                blaVar.e();
            }
            a(str);
        }
    }
}
