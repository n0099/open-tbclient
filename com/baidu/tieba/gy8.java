package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.tx8;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes4.dex */
public class gy8 implements ox8, tx8.c, w56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public gx8 b;
    public sx8 c;
    public SelectMusicModel d;
    public String e;

    @Override // com.baidu.tieba.ox8
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    public gy8(gx8 gx8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gx8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = gx8Var;
        this.a = gx8Var.a;
    }

    public final void a(String str) {
        gx8 gx8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (gx8Var = this.b) == null) {
            return;
        }
        if (gx8Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        gx8 gx8Var2 = this.b;
        if (gx8Var2 != null) {
            gx8Var2.f(videoInfo);
        }
    }

    public void b() {
        gx8 gx8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (gx8Var = this.b) == null) {
            return;
        }
        if (gx8Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            gx8 gx8Var2 = this.b;
            if (!gx8Var2.e) {
                o1(gx8Var2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        gx8 gx8Var3 = this.b;
        selectMusicModel.C(gx8Var3.b, gx8Var3.d, hx8.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !gx8Var3.e);
    }

    @Override // com.baidu.tieba.w56
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            gx8 gx8Var = this.b;
            if (gx8Var != null) {
                gx8Var.i(true);
            }
            sx8 sx8Var = this.c;
            if (sx8Var != null && sx8Var.f()) {
                this.c.e();
            }
        }
    }

    @Override // com.baidu.tieba.ox8
    public void o1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i, str2) == null) {
            gx8 gx8Var = this.b;
            if (gx8Var != null && gx8Var.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0b16);
                gx8 gx8Var2 = this.b;
                if (gx8Var2 != null) {
                    gx8Var2.g(i, str2);
                }
            } else {
                gx8 gx8Var3 = this.b;
                if (gx8Var3 != null) {
                    gx8Var3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        sx8 sx8Var = new sx8(this.a.getActivity());
                        this.c = sx8Var;
                        sx8Var.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                gx8 gx8Var4 = this.b;
                if (gx8Var4 != null) {
                    gx8Var4.e();
                }
                a(str);
            }
        }
    }

    @Override // com.baidu.tieba.tx8.c
    public void onGenFilterVideoFail(int i, String str) {
        gx8 gx8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && (gx8Var = this.b) != null) {
            gx8Var.d(i, str);
        }
    }

    @Override // com.baidu.tieba.tx8.c
    public void onGenFilterVideoRecordError(int i, String str) {
        gx8 gx8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) && (gx8Var = this.b) != null) {
            gx8Var.d(i, str);
        }
    }

    @Override // com.baidu.tieba.tx8.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            gx8 gx8Var = this.b;
            if (gx8Var != null) {
                gx8Var.e();
            }
            a(str);
        }
    }
}
