package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.te9;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes4.dex */
public class gf9 implements oe9, te9.c, hh6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public ge9 b;
    public se9 c;
    public SelectMusicModel d;
    public String e;

    @Override // com.baidu.tieba.oe9
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    public gf9(ge9 ge9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ge9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = ge9Var;
        this.a = ge9Var.a;
    }

    public final void a(String str) {
        ge9 ge9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (ge9Var = this.b) == null) {
            return;
        }
        if (ge9Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        ge9 ge9Var2 = this.b;
        if (ge9Var2 != null) {
            ge9Var2.f(videoInfo);
        }
    }

    public void b() {
        ge9 ge9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (ge9Var = this.b) == null) {
            return;
        }
        if (ge9Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            ge9 ge9Var2 = this.b;
            if (!ge9Var2.e) {
                o1(ge9Var2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        ge9 ge9Var3 = this.b;
        selectMusicModel.Q(ge9Var3.b, ge9Var3.d, he9.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !ge9Var3.e);
    }

    @Override // com.baidu.tieba.hh6
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ge9 ge9Var = this.b;
            if (ge9Var != null) {
                ge9Var.i(true);
            }
            se9 se9Var = this.c;
            if (se9Var != null && se9Var.f()) {
                this.c.e();
            }
        }
    }

    @Override // com.baidu.tieba.oe9
    public void o1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i, str2) == null) {
            ge9 ge9Var = this.b;
            if (ge9Var != null && ge9Var.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0b9f);
                ge9 ge9Var2 = this.b;
                if (ge9Var2 != null) {
                    ge9Var2.g(i, str2);
                }
            } else {
                ge9 ge9Var3 = this.b;
                if (ge9Var3 != null) {
                    ge9Var3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        se9 se9Var = new se9(this.a.getActivity());
                        this.c = se9Var;
                        se9Var.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                ge9 ge9Var4 = this.b;
                if (ge9Var4 != null) {
                    ge9Var4.e();
                }
                a(str);
            }
        }
    }

    @Override // com.baidu.tieba.te9.c
    public void onGenFilterVideoFail(int i, String str) {
        ge9 ge9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && (ge9Var = this.b) != null) {
            ge9Var.d(i, str);
        }
    }

    @Override // com.baidu.tieba.te9.c
    public void onGenFilterVideoRecordError(int i, String str) {
        ge9 ge9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) && (ge9Var = this.b) != null) {
            ge9Var.d(i, str);
        }
    }

    @Override // com.baidu.tieba.te9.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            ge9 ge9Var = this.b;
            if (ge9Var != null) {
                ge9Var.e();
            }
            a(str);
        }
    }
}
