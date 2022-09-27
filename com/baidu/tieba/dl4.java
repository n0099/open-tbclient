package com.baidu.tieba;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.videoplayer.SwanVideoView;
import com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout;
import com.baidu.swan.videoplayer.media.video.view.MediaGestureMode;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class dl4 implements MediaGestureLayout.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public MediaGestureLayout b;
    public MediaGestureLayout.c c;

    public dl4(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        g(context);
    }

    @Override // com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.b
    public void a(MotionEvent motionEvent) {
        MediaGestureLayout.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) || (cVar = this.c) == null) {
            return;
        }
        cVar.a(motionEvent);
    }

    @Override // com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.b
    public void b(MotionEvent motionEvent, MediaGestureMode mediaGestureMode) {
        MediaGestureLayout.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent, mediaGestureMode) == null) || (cVar = this.c) == null) {
            return;
        }
        cVar.b(motionEvent, mediaGestureMode);
    }

    @Override // com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.b
    public void c(int i) {
        MediaGestureLayout.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || (cVar = this.c) == null) {
            return;
        }
        cVar.c(i);
    }

    public void d(SwanVideoView swanVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, swanVideoView) == null) {
            this.b.h(swanVideoView);
        }
    }

    public void e(al4 al4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, al4Var) == null) {
            this.b.g(al4Var);
        }
    }

    public ViewGroup f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : (ViewGroup) invokeV.objValue;
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.a = context;
            MediaGestureLayout mediaGestureLayout = new MediaGestureLayout(context);
            this.b = mediaGestureLayout;
            mediaGestureLayout.setMediaGestureListener(this);
        }
    }

    public void h(MediaGestureLayout.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            this.c = cVar;
        }
    }

    @Override // com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.b
    public void onDoubleTap(MotionEvent motionEvent) {
        MediaGestureLayout.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent) == null) || (cVar = this.c) == null) {
            return;
        }
        cVar.onDoubleTap(motionEvent);
    }
}
