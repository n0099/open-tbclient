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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class VideoControllerView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long PROGRESS_MAX = 10000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f49235e;

    /* renamed from: f  reason: collision with root package name */
    public int f49236f;

    /* renamed from: g  reason: collision with root package name */
    public MediaController.MediaPlayerControl f49237g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f49238h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f49239i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f49240j;
    public boolean k;
    public SeekBar l;
    public d m;
    public c n;
    public SeekBar.OnSeekBarChangeListener o;
    public int p;
    public int q;
    public Handler r;
    public SeekBar.OnSeekBarChangeListener s;

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoControllerView f49241a;

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
            this.f49241a = videoControllerView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1 && !this.f49241a.f49240j && this.f49241a.k && this.f49241a.f49237g != null) {
                int o = this.f49241a.o();
                if (this.f49241a.m != null) {
                    this.f49241a.m.a(o);
                }
                sendMessageDelayed(obtainMessage(1), this.f49241a.f49236f - (o % this.f49241a.f49236f));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoControllerView f49242e;

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
            this.f49242e = videoControllerView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && z) {
                this.f49242e.q = (int) ((this.f49242e.f49237g.getDuration() * i2) / 10000);
                if (this.f49242e.f49238h != null) {
                    this.f49242e.f49238h.setText(StringHelper.stringForVideoTime(this.f49242e.q));
                }
                if (this.f49242e.n != null) {
                    this.f49242e.n.a();
                }
                if (this.f49242e.o != null) {
                    this.f49242e.o.onProgressChanged(seekBar, this.f49242e.q, z);
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                this.f49242e.f49240j = true;
                if (this.f49242e.o != null) {
                    this.f49242e.o.onStartTrackingTouch(seekBar);
                }
                this.f49242e.r.removeMessages(1);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) {
                this.f49242e.f49237g.seekTo(this.f49242e.q);
                this.f49242e.f49240j = false;
                this.f49242e.r.sendEmptyMessageDelayed(1, 500L);
                if (this.f49242e.o != null) {
                    this.f49242e.o.onStopTrackingTouch(seekBar);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes7.dex */
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
        this.f49236f = 50;
        this.f49240j = false;
        this.k = true;
        this.q = 0;
        this.r = new a(this, Looper.getMainLooper());
        this.s = new b(this);
        n(context);
    }

    public void destroy() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (handler = this.r) == null) {
            return;
        }
        handler.removeMessages(1);
    }

    public int getCurProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            SeekBar seekBar = this.l;
            if (seekBar != null) {
                return seekBar.getProgress();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public View getLayout(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? LayoutInflater.from(context).inflate(R.layout.ad_video_controller, (ViewGroup) null) : (View) invokeL.objValue;
    }

    public String getProgressTime(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            return StringHelper.stringForVideoTime(i2);
        }
        return (String) invokeI.objValue;
    }

    public int getSeekPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.q : invokeV.intValue;
    }

    public void initCurTimeAndDuration(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            this.p = i3;
            this.k = false;
            this.r.removeMessages(1);
            this.l.setProgress((int) (((i2 * 1.0f) / i3) * 10000.0f));
            TextView textView = this.f49238h;
            if (textView != null) {
                textView.setText(StringHelper.stringForVideoTime(i2));
            }
            TextView textView2 = this.f49239i;
            if (textView2 != null) {
                textView2.setText(StringHelper.stringForVideoTime(this.p));
            }
        }
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.f49235e = context;
            View layout = getLayout(context);
            addView(layout, -1, (int) context.getResources().getDimension(R.dimen.ds80));
            this.f49238h = (TextView) layout.findViewById(R.id.textview_cur_time);
            this.f49239i = (TextView) layout.findViewById(R.id.textview_duration);
            SeekBar seekBar = (SeekBar) layout.findViewById(R.id.pb_video_controller_seekBar);
            this.l = seekBar;
            seekBar.setOnSeekBarChangeListener(this.s);
        }
    }

    public final int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            MediaController.MediaPlayerControl mediaPlayerControl = this.f49237g;
            if (mediaPlayerControl == null || this.f49240j) {
                return 0;
            }
            int currentPosition = mediaPlayerControl.getCurrentPosition();
            int duration = this.f49237g.getDuration();
            if (currentPosition > duration) {
                currentPosition = duration;
            }
            SeekBar seekBar = this.l;
            if (seekBar != null) {
                if (duration > 0) {
                    seekBar.setProgress((int) ((currentPosition * 10000) / duration));
                }
                this.f49237g.getBufferPercentage();
            }
            TextView textView = this.f49238h;
            if (textView != null) {
                textView.setText(StringHelper.stringForVideoTime(currentPosition));
            }
            return currentPosition;
        }
        return invokeV.intValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            SkinManager.setViewTextColor(this.f49238h, R.color.CAM_X0101, 1);
            SkinManager.setViewTextColor(this.f49239i, R.color.CAM_X0101, 1);
            this.l.setProgressDrawable(SkinManager.getSkinDrawable(null, R.drawable.video_seekbar));
            this.l.setThumb(SkinManager.getSkinDrawable(null, R.drawable.video_seekbar_thumb));
            this.l.setThumbOffset(0);
        }
    }

    public void resetProgress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.k = false;
            this.r.removeMessages(1);
            this.l.setProgress(0);
            TextView textView = this.f49238h;
            if (textView != null) {
                textView.setText(StringHelper.stringForVideoTime(0));
            }
        }
    }

    public void seekToPlayer(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f49237g.seekTo(i2);
        }
    }

    public void setCurrentDuration(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            if (!z) {
                Handler handler = this.r;
                if (handler != null) {
                    handler.removeMessages(1);
                }
            } else {
                this.f49237g.seekTo(i2);
                TextView textView = this.f49238h;
                if (textView != null) {
                    textView.setText(StringHelper.stringForVideoTime(i2));
                }
                showProgress();
            }
            if (this.f49237g.isPlaying()) {
                return;
            }
            this.l.setProgress((int) (((i2 * 1.0f) / this.p) * 10000.0f));
        }
    }

    public void setOnDragingListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.n = cVar;
        }
    }

    public void setOnProgressUpdatedListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            this.m = dVar;
        }
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onSeekBarChangeListener) == null) {
            this.o = onSeekBarChangeListener;
        }
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, mediaPlayerControl) == null) {
            this.f49237g = mediaPlayerControl;
        }
    }

    public void showProgress() {
        MediaController.MediaPlayerControl mediaPlayerControl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (mediaPlayerControl = this.f49237g) == null) {
            return;
        }
        int duration = ((mediaPlayerControl.getDuration() / 200) / 50) * 50;
        this.f49236f = duration;
        if (duration < 50) {
            this.f49236f = 50;
        } else if (duration > 500) {
            this.f49236f = 500;
        }
        this.k = true;
        this.r.removeMessages(1);
        Handler handler = this.r;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f49236f - (this.f49237g.getCurrentPosition() % this.f49236f));
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
        this.f49236f = 50;
        this.f49240j = false;
        this.k = true;
        this.q = 0;
        this.r = new a(this, Looper.getMainLooper());
        this.s = new b(this);
        n(context);
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
        this.f49236f = 50;
        this.f49240j = false;
        this.k = true;
        this.q = 0;
        this.r = new a(this, Looper.getMainLooper());
        this.s = new b(this);
        n(context);
    }
}
