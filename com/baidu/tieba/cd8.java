package com.baidu.tieba;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class cd8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;
    public ImageView b;
    public VideoLoadingProgressView c;
    public ObjectAnimator d;
    public ObjectAnimator e;
    public ObjectAnimator f;

    public cd8(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = viewGroup;
        this.b = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f090312);
        this.c = (VideoLoadingProgressView) viewGroup.findViewById(R.id.obfuscated_res_0x7f090313);
        d();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.d.cancel();
            this.e.cancel();
            this.f.cancel();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a();
            this.a.setVisibility(8);
            this.c.h();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a();
            this.e.start();
            this.f.start();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a();
            this.c.j();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a();
            this.b.setAlpha(1.0f);
            this.c.setAlpha(1.0f);
            this.a.setVisibility(0);
            this.c.l();
            this.d.start();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.d = ObjectAnimator.ofFloat(this.b, Key.ALPHA, 1.0f, 0.5f);
            this.e = ObjectAnimator.ofFloat(this.b, Key.ALPHA, 0.5f, 0.0f);
            this.f = ObjectAnimator.ofFloat(this.c, Key.ALPHA, 1.0f, 0.0f);
            this.d.setDuration(50L);
            this.e.setDuration(50L);
            this.f.setDuration(50L);
        }
    }

    public void f(VideoLoadingProgressView.c cVar) {
        VideoLoadingProgressView videoLoadingProgressView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) && (videoLoadingProgressView = this.c) != null) {
            videoLoadingProgressView.setLoadingAnimationListener(cVar);
        }
    }
}
