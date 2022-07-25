package com.baidu.tieba.ad.play;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class VideoControllerView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public MediaController.MediaPlayerControl b;
    public TextView c;
    public TextView d;
    public boolean e;
    public boolean f;
    public SeekBar g;
    public int h;
    public int i;
    public Handler j;
    public SeekBar.OnSeekBarChangeListener k;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoControllerView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoControllerView videoControllerView, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoControllerView, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoControllerView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1 && !this.a.e && this.a.f && this.a.b != null) {
                sendMessageDelayed(obtainMessage(1), this.a.a - (this.a.o() % this.a.a));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoControllerView a;

        public b(VideoControllerView videoControllerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoControllerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoControllerView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && z) {
                this.a.i = (int) ((this.a.b.getDuration() * i) / 10000);
                if (this.a.c != null) {
                    this.a.c.setText(StringHelper.stringForVideoTime(this.a.i));
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                this.a.e = true;
                this.a.j.removeMessages(1);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) {
                this.a.b.seekTo(this.a.i);
                this.a.e = false;
                this.a.j.sendEmptyMessageDelayed(1, 500L);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoControllerView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 50;
        this.e = false;
        this.f = true;
        this.i = 0;
        this.j = new a(this, Looper.getMainLooper());
        this.k = new b(this);
        l(context);
    }

    public View k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d006e, (ViewGroup) null) : (View) invokeL.objValue;
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            View k = k(context);
            addView(k, -1, (int) context.getResources().getDimension(R.dimen.obfuscated_res_0x7f070275));
            this.c = (TextView) k.findViewById(R.id.obfuscated_res_0x7f091ffd);
            this.d = (TextView) k.findViewById(R.id.obfuscated_res_0x7f091ffe);
            SeekBar seekBar = (SeekBar) k.findViewById(R.id.obfuscated_res_0x7f091788);
            this.g = seekBar;
            seekBar.setOnSeekBarChangeListener(this.k);
        }
    }

    public void m(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.h = i2;
            this.f = false;
            this.j.removeMessages(1);
            this.g.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
            TextView textView = this.c;
            if (textView != null) {
                textView.setText(StringHelper.stringForVideoTime(i));
            }
            TextView textView2 = this.d;
            if (textView2 != null) {
                textView2.setText(StringHelper.stringForVideoTime(this.h));
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f = false;
            this.j.removeMessages(1);
            this.g.setProgress(0);
            TextView textView = this.c;
            if (textView != null) {
                textView.setText(StringHelper.stringForVideoTime(0));
            }
        }
    }

    public final int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            MediaController.MediaPlayerControl mediaPlayerControl = this.b;
            if (mediaPlayerControl == null || this.e) {
                return 0;
            }
            int currentPosition = mediaPlayerControl.getCurrentPosition();
            int duration = this.b.getDuration();
            if (currentPosition > duration) {
                currentPosition = duration;
            }
            SeekBar seekBar = this.g;
            if (seekBar != null && duration > 0) {
                seekBar.setProgress((int) ((currentPosition * 10000) / duration));
            }
            TextView textView = this.c;
            if (textView != null) {
                textView.setText(StringHelper.stringForVideoTime(currentPosition));
            }
            return currentPosition;
        }
        return invokeV.intValue;
    }

    public void p() {
        MediaController.MediaPlayerControl mediaPlayerControl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (mediaPlayerControl = this.b) == null) {
            return;
        }
        int duration = ((mediaPlayerControl.getDuration() / 200) / 50) * 50;
        this.a = duration;
        if (duration < 50) {
            this.a = 50;
        } else if (duration > 500) {
            this.a = 500;
        }
        this.f = true;
        this.j.removeMessages(1);
        Handler handler = this.j;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.a - (this.b.getCurrentPosition() % this.a));
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, mediaPlayerControl) == null) {
            this.b = mediaPlayerControl;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 50;
        this.e = false;
        this.f = true;
        this.i = 0;
        this.j = new a(this, Looper.getMainLooper());
        this.k = new b(this);
        l(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 50;
        this.e = false;
        this.f = true;
        this.i = 0;
        this.j = new a(this, Looper.getMainLooper());
        this.k = new b(this);
        l(context);
    }
}
