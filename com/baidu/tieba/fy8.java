package com.baidu.tieba;

import android.opengl.Matrix;
import android.os.Handler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface;
import com.baidu.ugc.editvideo.record.processor.MultiMediaPreProcessor;
/* loaded from: classes4.dex */
public class fy8 extends BaseOutputSurface {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float[] a;
    public MultiMediaData b;

    public fy8(int i, int i2, boolean z, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new float[16];
        this.b = new MultiMediaData();
        init(i, i2, z, handler);
        this.mFullScreenEXT.setMirror(true);
        Matrix.orthoM(this.a, 0, 0.0f, i, 0.0f, i2, -1.0f, 1.0f);
    }

    public void a(int i, int i2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f)}) == null) {
            MultiMediaData multiMediaData = this.b;
            multiMediaData.type = 1;
            multiMediaData.width = i;
            multiMediaData.height = i2;
            multiMediaData.rotation = f;
            if (((f == 90.0f || f == 270.0f) ? (i2 * 1.0f) / i : (i * 1.0f) / i2) <= (this.mVideoWidth * 1.0f) / this.mVideoHeight) {
                this.b.scaleType = "center_crop";
            } else {
                this.b.scaleType = "center_inside";
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface
    public void drawImage(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.drawImage(i);
            if (this.mFullScreenEXT == null) {
                return;
            }
            float[] fArr = new float[16];
            Matrix.setIdentityM(fArr, 0);
            Matrix.multiplyMM(fArr, 0, this.a, 0, MultiMediaPreProcessor.calculateModelView(this.b, this.mVideoWidth, this.mVideoHeight, 0, 0), 0);
            this.mFullScreenEXT.setVertexPoint(fArr);
            this.mFullScreenEXT.setAngle(180.0f);
            this.mFullScreenEXT.drawFrame(this.mTextureId, this.mSTMatrix);
            Matrix.setIdentityM(fArr, 0);
            this.mFullScreenEXT.setVertexPoint(fArr);
        }
    }
}
