package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.tda;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes5.dex */
public class gea implements oda, tda.c, sr6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public gda b;
    public sda c;
    public SelectMusicModel d;
    public String e;

    @Override // com.baidu.tieba.oda
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    public gea(gda gdaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gdaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = gdaVar;
        this.a = gdaVar.a;
    }

    public final void a(String str) {
        gda gdaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (gdaVar = this.b) == null) {
            return;
        }
        if (gdaVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        gda gdaVar2 = this.b;
        if (gdaVar2 != null) {
            gdaVar2.f(videoInfo);
        }
    }

    public void b() {
        gda gdaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (gdaVar = this.b) == null) {
            return;
        }
        if (gdaVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            gda gdaVar2 = this.b;
            if (!gdaVar2.e) {
                o1(gdaVar2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        gda gdaVar3 = this.b;
        selectMusicModel.X(gdaVar3.b, gdaVar3.d, hda.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !gdaVar3.e);
    }

    @Override // com.baidu.tieba.sr6
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            gda gdaVar = this.b;
            if (gdaVar != null) {
                gdaVar.i(true);
            }
            sda sdaVar = this.c;
            if (sdaVar != null && sdaVar.f()) {
                this.c.e();
            }
        }
    }

    @Override // com.baidu.tieba.oda
    public void o1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i, str2) == null) {
            gda gdaVar = this.b;
            if (gdaVar != null && gdaVar.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c82);
                gda gdaVar2 = this.b;
                if (gdaVar2 != null) {
                    gdaVar2.g(i, str2);
                }
            } else {
                gda gdaVar3 = this.b;
                if (gdaVar3 != null) {
                    gdaVar3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        sda sdaVar = new sda(this.a.getActivity());
                        this.c = sdaVar;
                        sdaVar.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                gda gdaVar4 = this.b;
                if (gdaVar4 != null) {
                    gdaVar4.e();
                }
                a(str);
            }
        }
    }

    @Override // com.baidu.tieba.tda.c
    public void onGenFilterVideoFail(int i, String str) {
        gda gdaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && (gdaVar = this.b) != null) {
            gdaVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.tda.c
    public void onGenFilterVideoRecordError(int i, String str) {
        gda gdaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) && (gdaVar = this.b) != null) {
            gdaVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.tda.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            gda gdaVar = this.b;
            if (gdaVar != null) {
                gdaVar.e();
            }
            a(str);
        }
    }
}
