package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.tu9;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes4.dex */
public class gv9 implements ou9, tu9.c, vj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public gu9 b;
    public su9 c;
    public SelectMusicModel d;
    public String e;

    @Override // com.baidu.tieba.ou9
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    public gv9(gu9 gu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gu9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = gu9Var;
        this.a = gu9Var.a;
    }

    public final void a(String str) {
        gu9 gu9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (gu9Var = this.b) == null) {
            return;
        }
        if (gu9Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        gu9 gu9Var2 = this.b;
        if (gu9Var2 != null) {
            gu9Var2.f(videoInfo);
        }
    }

    public void b() {
        gu9 gu9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (gu9Var = this.b) == null) {
            return;
        }
        if (gu9Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            gu9 gu9Var2 = this.b;
            if (!gu9Var2.e) {
                p1(gu9Var2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        gu9 gu9Var3 = this.b;
        selectMusicModel.T(gu9Var3.b, gu9Var3.d, hu9.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !gu9Var3.e);
    }

    @Override // com.baidu.tieba.vj6
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            gu9 gu9Var = this.b;
            if (gu9Var != null) {
                gu9Var.i(true);
            }
            su9 su9Var = this.c;
            if (su9Var != null && su9Var.f()) {
                this.c.e();
            }
        }
    }

    @Override // com.baidu.tieba.tu9.c
    public void onGenFilterVideoFail(int i, String str) {
        gu9 gu9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) && (gu9Var = this.b) != null) {
            gu9Var.d(i, str);
        }
    }

    @Override // com.baidu.tieba.tu9.c
    public void onGenFilterVideoRecordError(int i, String str) {
        gu9 gu9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && (gu9Var = this.b) != null) {
            gu9Var.d(i, str);
        }
    }

    @Override // com.baidu.tieba.tu9.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            gu9 gu9Var = this.b;
            if (gu9Var != null) {
                gu9Var.e();
            }
            a(str);
        }
    }

    @Override // com.baidu.tieba.ou9
    public void p1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i, str2) == null) {
            gu9 gu9Var = this.b;
            if (gu9Var != null && gu9Var.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0ba8);
                gu9 gu9Var2 = this.b;
                if (gu9Var2 != null) {
                    gu9Var2.g(i, str2);
                }
            } else {
                gu9 gu9Var3 = this.b;
                if (gu9Var3 != null) {
                    gu9Var3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        su9 su9Var = new su9(this.a.getActivity());
                        this.c = su9Var;
                        su9Var.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                gu9 gu9Var4 = this.b;
                if (gu9Var4 != null) {
                    gu9Var4.e();
                }
                a(str);
            }
        }
    }
}
