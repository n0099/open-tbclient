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
import androidx.core.view.InputDeviceCompat;
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

    /* renamed from: e  reason: collision with root package name */
    public Context f13776e;

    /* renamed from: f  reason: collision with root package name */
    public int f13777f;

    /* renamed from: g  reason: collision with root package name */
    public MediaController.MediaPlayerControl f13778g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f13779h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f13780i;
    public boolean j;
    public boolean k;
    public SeekBar l;
    public d m;
    public c n;
    public SeekBar.OnSeekBarChangeListener o;
    public int p;
    public int q;
    public Handler r;
    public SeekBar.OnSeekBarChangeListener s;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoControllerView f13781a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoControllerView videoControllerView, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoControllerView, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13781a = videoControllerView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1 && !this.f13781a.j && this.f13781a.k && this.f13781a.f13778g != null) {
                int r = this.f13781a.r();
                if (this.f13781a.m != null) {
                    this.f13781a.m.a(r);
                }
                sendMessageDelayed(obtainMessage(1), this.f13781a.f13777f - (r % this.f13781a.f13777f));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoControllerView f13782e;

        public b(VideoControllerView videoControllerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoControllerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13782e = videoControllerView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && z) {
                this.f13782e.q = (int) ((this.f13782e.f13778g.getDuration() * i2) / 10000);
                if (this.f13782e.f13779h != null) {
                    this.f13782e.f13779h.setText(StringHelper.stringForVideoTime(this.f13782e.q));
                }
                if (this.f13782e.n != null) {
                    this.f13782e.n.a();
                }
                if (this.f13782e.o != null) {
                    this.f13782e.o.onProgressChanged(seekBar, this.f13782e.q, z);
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                this.f13782e.j = true;
                if (this.f13782e.o != null) {
                    this.f13782e.o.onStartTrackingTouch(seekBar);
                }
                this.f13782e.r.removeMessages(1);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) {
                this.f13782e.f13778g.seekTo(this.f13782e.q);
                this.f13782e.j = false;
                this.f13782e.r.sendEmptyMessageDelayed(1, 500L);
                if (this.f13782e.o != null) {
                    this.f13782e.o.onStopTrackingTouch(seekBar);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(int i2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13777f = 50;
        this.j = false;
        this.k = true;
        this.q = 0;
        this.r = new a(this, Looper.getMainLooper());
        this.s = new b(this);
        o(context);
    }

    public int getCurProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            SeekBar seekBar = this.l;
            if (seekBar != null) {
                return seekBar.getProgress();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getSeekPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.q : invokeV.intValue;
    }

    public View n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? LayoutInflater.from(context).inflate(R.layout.ad_video_controller, (ViewGroup) null) : (View) invokeL.objValue;
    }

    public final void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.f13776e = context;
            View n = n(context);
            addView(n, -1, (int) context.getResources().getDimension(R.dimen.ds80));
            this.f13779h = (TextView) n.findViewById(R.id.textview_cur_time);
            this.f13780i = (TextView) n.findViewById(R.id.textview_duration);
            SeekBar seekBar = (SeekBar) n.findViewById(R.id.pb_video_controller_seekBar);
            this.l = seekBar;
            seekBar.setOnSeekBarChangeListener(this.s);
        }
    }

    public void p(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            this.p = i3;
            this.k = false;
            this.r.removeMessages(1);
            this.l.setProgress((int) (((i2 * 1.0f) / i3) * 10000.0f));
            TextView textView = this.f13779h;
            if (textView != null) {
                textView.setText(StringHelper.stringForVideoTime(i2));
            }
            TextView textView2 = this.f13780i;
            if (textView2 != null) {
                textView2.setText(StringHelper.stringForVideoTime(this.p));
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.k = false;
            this.r.removeMessages(1);
            this.l.setProgress(0);
            TextView textView = this.f13779h;
            if (textView != null) {
                textView.setText(StringHelper.stringForVideoTime(0));
            }
        }
    }

    public final int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            MediaController.MediaPlayerControl mediaPlayerControl = this.f13778g;
            if (mediaPlayerControl == null || this.j) {
                return 0;
            }
            int currentPosition = mediaPlayerControl.getCurrentPosition();
            int duration = this.f13778g.getDuration();
            if (currentPosition > duration) {
                currentPosition = duration;
            }
            SeekBar seekBar = this.l;
            if (seekBar != null) {
                if (duration > 0) {
                    seekBar.setProgress((int) ((currentPosition * 10000) / duration));
                }
                this.f13778g.getBufferPercentage();
            }
            TextView textView = this.f13779h;
            if (textView != null) {
                textView.setText(StringHelper.stringForVideoTime(currentPosition));
            }
            return currentPosition;
        }
        return invokeV.intValue;
    }

    public void s() {
        MediaController.MediaPlayerControl mediaPlayerControl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (mediaPlayerControl = this.f13778g) == null) {
            return;
        }
        int duration = ((mediaPlayerControl.getDuration() / 200) / 50) * 50;
        this.f13777f = duration;
        if (duration < 50) {
            this.f13777f = 50;
        } else if (duration > 500) {
            this.f13777f = 500;
        }
        this.k = true;
        this.r.removeMessages(1);
        Handler handler = this.r;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f13777f - (this.f13778g.getCurrentPosition() % this.f13777f));
    }

    public void setCurrentDuration(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            if (!z) {
                Handler handler = this.r;
                if (handler != null) {
                    handler.removeMessages(1);
                }
            } else {
                this.f13778g.seekTo(i2);
                TextView textView = this.f13779h;
                if (textView != null) {
                    textView.setText(StringHelper.stringForVideoTime(i2));
                }
                s();
            }
            if (this.f13778g.isPlaying()) {
                return;
            }
            this.l.setProgress((int) (((i2 * 1.0f) / this.p) * 10000.0f));
        }
    }

    public void setOnDragingListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.n = cVar;
        }
    }

    public void setOnProgressUpdatedListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
            this.m = dVar;
        }
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onSeekBarChangeListener) == null) {
            this.o = onSeekBarChangeListener;
        }
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, mediaPlayerControl) == null) {
            this.f13778g = mediaPlayerControl;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f13777f = 50;
        this.j = false;
        this.k = true;
        this.q = 0;
        this.r = new a(this, Looper.getMainLooper());
        this.s = new b(this);
        o(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoControllerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f13777f = 50;
        this.j = false;
        this.k = true;
        this.q = 0;
        this.r = new a(this, Looper.getMainLooper());
        this.s = new b(this);
        o(context);
    }
}
