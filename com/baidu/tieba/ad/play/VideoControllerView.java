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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class VideoControllerView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long PROGRESS_MAX = 10000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f41764e;

    /* renamed from: f  reason: collision with root package name */
    public MediaController.MediaPlayerControl f41765f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f41766g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f41767h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f41768i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f41769j;
    public SeekBar k;
    public int l;
    public int m;
    public Handler n;
    public SeekBar.OnSeekBarChangeListener o;

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1 && !this.a.f41768i && this.a.f41769j && this.a.f41765f != null) {
                sendMessageDelayed(obtainMessage(1), this.a.f41764e - (this.a.l() % this.a.f41764e));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoControllerView f41770e;

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
            this.f41770e = videoControllerView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && z) {
                this.f41770e.m = (int) ((this.f41770e.f41765f.getDuration() * i2) / 10000);
                if (this.f41770e.f41766g != null) {
                    this.f41770e.f41766g.setText(StringHelper.stringForVideoTime(this.f41770e.m));
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                this.f41770e.f41768i = true;
                this.f41770e.n.removeMessages(1);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) {
                this.f41770e.f41765f.seekTo(this.f41770e.m);
                this.f41770e.f41768i = false;
                this.f41770e.n.sendEmptyMessageDelayed(1, 500L);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41764e = 50;
        this.f41768i = false;
        this.f41769j = true;
        this.m = 0;
        this.n = new a(this, Looper.getMainLooper());
        this.o = new b(this);
        k(context);
    }

    public View getLayout(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? LayoutInflater.from(context).inflate(R.layout.ad_video_controller, (ViewGroup) null) : (View) invokeL.objValue;
    }

    public void initCurTimeAndDuration(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            this.l = i3;
            this.f41769j = false;
            this.n.removeMessages(1);
            this.k.setProgress((int) (((i2 * 1.0f) / i3) * 10000.0f));
            TextView textView = this.f41766g;
            if (textView != null) {
                textView.setText(StringHelper.stringForVideoTime(i2));
            }
            TextView textView2 = this.f41767h;
            if (textView2 != null) {
                textView2.setText(StringHelper.stringForVideoTime(this.l));
            }
        }
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            View layout = getLayout(context);
            addView(layout, -1, (int) context.getResources().getDimension(R.dimen.ds80));
            this.f41766g = (TextView) layout.findViewById(R.id.textview_cur_time);
            this.f41767h = (TextView) layout.findViewById(R.id.textview_duration);
            SeekBar seekBar = (SeekBar) layout.findViewById(R.id.pb_video_controller_seekBar);
            this.k = seekBar;
            seekBar.setOnSeekBarChangeListener(this.o);
        }
    }

    public final int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            MediaController.MediaPlayerControl mediaPlayerControl = this.f41765f;
            if (mediaPlayerControl == null || this.f41768i) {
                return 0;
            }
            int currentPosition = mediaPlayerControl.getCurrentPosition();
            int duration = this.f41765f.getDuration();
            if (currentPosition > duration) {
                currentPosition = duration;
            }
            SeekBar seekBar = this.k;
            if (seekBar != null && duration > 0) {
                seekBar.setProgress((int) ((currentPosition * 10000) / duration));
            }
            TextView textView = this.f41766g;
            if (textView != null) {
                textView.setText(StringHelper.stringForVideoTime(currentPosition));
            }
            return currentPosition;
        }
        return invokeV.intValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            SkinManager.setViewTextColor(this.f41766g, R.color.CAM_X0101, 1);
            SkinManager.setViewTextColor(this.f41767h, R.color.CAM_X0101, 1);
            this.k.setProgressDrawable(SkinManager.getSkinDrawable(null, R.drawable.video_seekbar));
            this.k.setThumb(SkinManager.getSkinDrawable(null, R.drawable.video_seekbar_thumb));
            this.k.setThumbOffset(0);
        }
    }

    public void resetProgress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f41769j = false;
            this.n.removeMessages(1);
            this.k.setProgress(0);
            TextView textView = this.f41766g;
            if (textView != null) {
                textView.setText(StringHelper.stringForVideoTime(0));
            }
        }
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, mediaPlayerControl) == null) {
            this.f41765f = mediaPlayerControl;
        }
    }

    public void showProgress() {
        MediaController.MediaPlayerControl mediaPlayerControl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (mediaPlayerControl = this.f41765f) == null) {
            return;
        }
        int duration = ((mediaPlayerControl.getDuration() / 200) / 50) * 50;
        this.f41764e = duration;
        if (duration < 50) {
            this.f41764e = 50;
        } else if (duration > 500) {
            this.f41764e = 500;
        }
        this.f41769j = true;
        this.n.removeMessages(1);
        Handler handler = this.n;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f41764e - (this.f41765f.getCurrentPosition() % this.f41764e));
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
        this.f41764e = 50;
        this.f41768i = false;
        this.f41769j = true;
        this.m = 0;
        this.n = new a(this, Looper.getMainLooper());
        this.o = new b(this);
        k(context);
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
        this.f41764e = 50;
        this.f41768i = false;
        this.f41769j = true;
        this.m = 0;
        this.n = new a(this, Looper.getMainLooper());
        this.o = new b(this);
        k(context);
    }
}
