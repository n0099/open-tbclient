package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.q7a;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes5.dex */
public class d8a implements l7a, q7a.c, ir6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public d7a b;
    public p7a c;
    public SelectMusicModel d;
    public String e;

    @Override // com.baidu.tieba.l7a
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    public d8a(d7a d7aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d7aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = d7aVar;
        this.a = d7aVar.a;
    }

    public final void a(String str) {
        d7a d7aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (d7aVar = this.b) == null) {
            return;
        }
        if (d7aVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        d7a d7aVar2 = this.b;
        if (d7aVar2 != null) {
            d7aVar2.f(videoInfo);
        }
    }

    public void b() {
        d7a d7aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (d7aVar = this.b) == null) {
            return;
        }
        if (d7aVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            d7a d7aVar2 = this.b;
            if (!d7aVar2.e) {
                o1(d7aVar2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        d7a d7aVar3 = this.b;
        selectMusicModel.X(d7aVar3.b, d7aVar3.d, e7a.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !d7aVar3.e);
    }

    @Override // com.baidu.tieba.ir6
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d7a d7aVar = this.b;
            if (d7aVar != null) {
                d7aVar.i(true);
            }
            p7a p7aVar = this.c;
            if (p7aVar != null && p7aVar.f()) {
                this.c.e();
            }
        }
    }

    @Override // com.baidu.tieba.l7a
    public void o1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i, str2) == null) {
            d7a d7aVar = this.b;
            if (d7aVar != null && d7aVar.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c78);
                d7a d7aVar2 = this.b;
                if (d7aVar2 != null) {
                    d7aVar2.g(i, str2);
                }
            } else {
                d7a d7aVar3 = this.b;
                if (d7aVar3 != null) {
                    d7aVar3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        p7a p7aVar = new p7a(this.a.getActivity());
                        this.c = p7aVar;
                        p7aVar.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                d7a d7aVar4 = this.b;
                if (d7aVar4 != null) {
                    d7aVar4.e();
                }
                a(str);
            }
        }
    }

    @Override // com.baidu.tieba.q7a.c
    public void onGenFilterVideoFail(int i, String str) {
        d7a d7aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && (d7aVar = this.b) != null) {
            d7aVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.q7a.c
    public void onGenFilterVideoRecordError(int i, String str) {
        d7a d7aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) && (d7aVar = this.b) != null) {
            d7aVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.q7a.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            d7a d7aVar = this.b;
            if (d7aVar != null) {
                d7aVar.e();
            }
            a(str);
        }
    }
}
