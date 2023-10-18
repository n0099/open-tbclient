package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.uoa;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes6.dex */
public class hpa implements poa, uoa.c, ho6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public hoa b;
    public toa c;
    public SelectMusicModel d;
    public String e;

    @Override // com.baidu.tieba.poa
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    public hpa(hoa hoaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hoaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = hoaVar;
        this.a = hoaVar.a;
    }

    public final void a(String str) {
        hoa hoaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || (hoaVar = this.b) == null) {
            return;
        }
        if (hoaVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        this.e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.e);
        videoInfo.setThumbPath(this.b.c);
        hoa hoaVar2 = this.b;
        if (hoaVar2 != null) {
            hoaVar2.f(videoInfo);
        }
    }

    @Override // com.baidu.tieba.poa
    public void D0(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i, str2) == null) {
            hoa hoaVar = this.b;
            if (hoaVar != null && hoaVar.b()) {
                this.b.c();
                this.b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0cbb);
                hoa hoaVar2 = this.b;
                if (hoaVar2 != null) {
                    hoaVar2.g(i, str2);
                }
            } else {
                hoa hoaVar3 = this.b;
                if (hoaVar3 != null) {
                    hoaVar3.h();
                }
                if (!StringUtils.isNull(this.b.f)) {
                    if (!StringHelper.equals(str, this.b.b)) {
                        this.b.g = str;
                    }
                    if (this.c == null) {
                        toa toaVar = new toa(this.a.getActivity());
                        this.c = toaVar;
                        toaVar.i(this);
                    }
                    this.c.g(str, this.b.f);
                    return;
                }
                hoa hoaVar4 = this.b;
                if (hoaVar4 != null) {
                    hoaVar4.e();
                }
                a(str);
            }
        }
    }

    public void b() {
        hoa hoaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (hoaVar = this.b) == null) {
            return;
        }
        if (hoaVar.b()) {
            this.b.c();
            this.b = null;
            return;
        }
        if (StringUtils.isNull(this.b.d)) {
            hoa hoaVar2 = this.b;
            if (!hoaVar2.e) {
                D0(hoaVar2.b, -4399, "");
                return;
            }
        }
        if (this.d == null) {
            this.d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.d;
        hoa hoaVar3 = this.b;
        selectMusicModel.Q(hoaVar3.b, hoaVar3.d, ioa.f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !hoaVar3.e);
    }

    @Override // com.baidu.tieba.ho6
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            hoa hoaVar = this.b;
            if (hoaVar != null) {
                hoaVar.i(true);
            }
            toa toaVar = this.c;
            if (toaVar != null && toaVar.f()) {
                this.c.e();
            }
        }
    }

    @Override // com.baidu.tieba.uoa.c
    public void onGenFilterVideoFail(int i, String str) {
        hoa hoaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && (hoaVar = this.b) != null) {
            hoaVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.uoa.c
    public void onGenFilterVideoRecordError(int i, String str) {
        hoa hoaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) && (hoaVar = this.b) != null) {
            hoaVar.d(i, str);
        }
    }

    @Override // com.baidu.tieba.uoa.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            hoa hoaVar = this.b;
            if (hoaVar != null) {
                hoaVar.e();
            }
            a(str);
        }
    }
}
