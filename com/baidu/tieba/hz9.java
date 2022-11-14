package com.baidu.tieba;

import android.content.Context;
import android.graphics.Matrix;
import android.view.WindowManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.webrtc.TextureBufferImpl;
import org.webrtc.VideoFrame;
/* compiled from: CameraSession.java */
/* loaded from: classes4.dex */
public final /* synthetic */ class hz9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static VideoFrame.TextureBuffer a(TextureBufferImpl textureBufferImpl, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{textureBufferImpl, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            Matrix matrix = new Matrix();
            matrix.preTranslate(0.5f, 0.5f);
            if (z) {
                matrix.preScale(-1.0f, 1.0f);
            }
            matrix.preRotate(i);
            matrix.preTranslate(-0.5f, -0.5f);
            return textureBufferImpl.applyTransformMatrix(matrix, textureBufferImpl.getWidth(), textureBufferImpl.getHeight());
        }
        return (VideoFrame.TextureBuffer) invokeCommon.objValue;
    }

    public static int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
            if (rotation != 1) {
                if (rotation != 2) {
                    if (rotation != 3) {
                        return 0;
                    }
                    return 270;
                }
                return 180;
            }
            return 90;
        }
        return invokeL.intValue;
    }
}
