package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.r6b;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes5.dex */
public class e7b implements m6b, r6b.c, mq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public e6b b;
    public q6b c;
    public SelectMusicModel d;
    public String e;

    @Override // com.baidu.tieba.m6b
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
        }
    }

    public e7b(e6b e6bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e6bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = e6bVar;
        this.a = e6bVar.a;
    }

    public final void a(String str) {
        e6b e6bVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (e6bVar = this.b) == null) {
            return;
        }
        if (e6bVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        e6b e6bVar2 = this.b;
        if (e6bVar2 != null) {
            e6bVar2.f(videoInfo);
        }
    }

    public void b() {
        e6b e6bVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (e6bVar = this.b) == null) {
            return;
        }
        if (e6bVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            e6b e6bVar2 = this.b;
            if (!e6bVar2.e) {
                y0(e6bVar2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        e6b e6bVar3 = this.b;
        selectMusicModel.R(e6bVar3.b, e6bVar3.d, f6b.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !e6bVar3.e);
    }

    @Override // com.baidu.tieba.mq6
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            e6b e6bVar = this.b;
            if (e6bVar != null) {
                e6bVar.i(true);
            }
            q6b q6bVar = this.c;
            if (q6bVar != null && q6bVar.f()) {
                this.c.e();
            }
        }
    }

    @Override // com.baidu.tieba.r6b.c
    public void onGenFilterVideoFail(int i, String str) {
        e6b e6bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) && (e6bVar = this.b) != null) {
            e6bVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.r6b.c
    public void onGenFilterVideoRecordError(int i, String str) {
        e6b e6bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && (e6bVar = this.b) != null) {
            e6bVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.r6b.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            e6b e6bVar = this.b;
            if (e6bVar != null) {
                e6bVar.e();
            }
            a(str);
        }
    }

    @Override // com.baidu.tieba.m6b
    public void y0(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048583, this, str, i, str2) == null) {
            e6b e6bVar = this.b;
            if (e6bVar != null && e6bVar.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0cdb);
                e6b e6bVar2 = this.b;
                if (e6bVar2 != null) {
                    e6bVar2.g(i, str2);
                }
            } else {
                e6b e6bVar3 = this.b;
                if (e6bVar3 != null) {
                    e6bVar3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        q6b q6bVar = new q6b(this.a.getActivity());
                        this.c = q6bVar;
                        q6bVar.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                e6b e6bVar4 = this.b;
                if (e6bVar4 != null) {
                    e6bVar4.e();
                }
                a(str);
            }
        }
    }
}
