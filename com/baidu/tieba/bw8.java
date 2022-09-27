package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.ov8;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes3.dex */
public class bw8 implements jv8, ov8.c, s36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public bv8 b;
    public nv8 c;
    public SelectMusicModel d;
    public String e;

    public bw8(bv8 bv8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bv8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = bv8Var;
        this.a = bv8Var.a;
    }

    public final void a(String str) {
        bv8 bv8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (bv8Var = this.b) == null) {
            return;
        }
        if (bv8Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        bv8 bv8Var2 = this.b;
        if (bv8Var2 != null) {
            bv8Var2.f(videoInfo);
        }
    }

    public void b() {
        bv8 bv8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bv8Var = this.b) == null) {
            return;
        }
        if (bv8Var.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            bv8 bv8Var2 = this.b;
            if (!bv8Var2.e) {
                q1(bv8Var2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        bv8 bv8Var3 = this.b;
        selectMusicModel.C(bv8Var3.b, bv8Var3.d, cv8.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !bv8Var3.e);
    }

    @Override // com.baidu.tieba.s36
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            bv8 bv8Var = this.b;
            if (bv8Var != null) {
                bv8Var.i(true);
            }
            nv8 nv8Var = this.c;
            if (nv8Var == null || !nv8Var.f()) {
                return;
            }
            this.c.e();
        }
    }

    @Override // com.baidu.tieba.ov8.c
    public void onGenFilterVideoFail(int i, String str) {
        bv8 bv8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) || (bv8Var = this.b) == null) {
            return;
        }
        bv8Var.d(i, str);
    }

    @Override // com.baidu.tieba.ov8.c
    public void onGenFilterVideoRecordError(int i, String str) {
        bv8 bv8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) || (bv8Var = this.b) == null) {
            return;
        }
        bv8Var.d(i, str);
    }

    @Override // com.baidu.tieba.ov8.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            bv8 bv8Var = this.b;
            if (bv8Var != null) {
                bv8Var.e();
            }
            a(str);
        }
    }

    @Override // com.baidu.tieba.jv8
    public void q1(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i, str2) == null) {
            bv8 bv8Var = this.b;
            if (bv8Var != null && bv8Var.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0af9);
                bv8 bv8Var2 = this.b;
                if (bv8Var2 != null) {
                    bv8Var2.g(i, str2);
                }
            } else {
                bv8 bv8Var3 = this.b;
                if (bv8Var3 != null) {
                    bv8Var3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        nv8 nv8Var = new nv8(this.a.getActivity());
                        this.c = nv8Var;
                        nv8Var.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                bv8 bv8Var4 = this.b;
                if (bv8Var4 != null) {
                    bv8Var4.e();
                }
                a(str);
            }
        }
    }

    @Override // com.baidu.tieba.jv8
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }
}
