package com.baidu.tieba.hottopic.view;

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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Formatter;
import java.util.Locale;
/* loaded from: classes4.dex */
public class TopicVideoControllerView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f17272e;

    /* renamed from: f  reason: collision with root package name */
    public MediaController.MediaPlayerControl f17273f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17274g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17275h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f17276i;
    public boolean j;
    public SeekBar k;
    public StringBuilder l;
    public Formatter m;
    public Handler n;
    public SeekBar.OnSeekBarChangeListener o;

    /* loaded from: classes4.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TopicVideoControllerView f17277a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TopicVideoControllerView topicVideoControllerView, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicVideoControllerView, looper};
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
            this.f17277a = topicVideoControllerView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1 && !this.f17277a.f17276i && this.f17277a.j && this.f17277a.f17273f != null && this.f17277a.f17273f.isPlaying()) {
                sendMessageDelayed(obtainMessage(1), this.f17277a.f17272e - (this.f17277a.p() % this.f17277a.f17272e));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicVideoControllerView f17278e;

        public b(TopicVideoControllerView topicVideoControllerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicVideoControllerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17278e = topicVideoControllerView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && z) {
                int duration = (int) ((this.f17278e.f17273f.getDuration() * i2) / 10000);
                this.f17278e.f17273f.seekTo(duration);
                if (this.f17278e.f17274g != null) {
                    this.f17278e.f17274g.setText(this.f17278e.r(duration));
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                this.f17278e.f17276i = true;
                this.f17278e.n.removeMessages(1);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) {
                this.f17278e.f17276i = false;
                this.f17278e.p();
                this.f17278e.n.sendEmptyMessage(1);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicVideoControllerView(Context context) {
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
        this.f17272e = 50;
        this.f17276i = false;
        this.j = true;
        this.n = new a(this, Looper.getMainLooper());
        this.o = new b(this);
        k(context);
    }

    public int getCurProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            SeekBar seekBar = this.k;
            if (seekBar != null) {
                return seekBar.getProgress();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void j() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (handler = this.n) == null) {
            return;
        }
        handler.removeMessages(1);
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.topic_video_controller, (ViewGroup) null);
            addView(inflate, -1, (int) context.getResources().getDimension(R.dimen.ds80));
            this.f17274g = (TextView) inflate.findViewById(R.id.progress_textview_cur_time);
            this.f17275h = (TextView) inflate.findViewById(R.id.progress_textview_duration);
            SeekBar seekBar = (SeekBar) inflate.findViewById(R.id.topic_video_controller_seekBar);
            this.k = seekBar;
            seekBar.setOnSeekBarChangeListener(this.o);
            this.l = new StringBuilder();
            this.m = new Formatter(this.l, Locale.getDefault());
        }
    }

    public void l(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            this.j = false;
            this.n.removeMessages(1);
            this.k.setProgress(0);
            TextView textView = this.f17274g;
            if (textView != null) {
                textView.setText(r(i2));
            }
            TextView textView2 = this.f17275h;
            if (textView2 != null) {
                textView2.setText(r(n(i3)));
            }
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            SkinManager.setViewTextColor(this.f17274g, R.color.CAM_X0101, 1);
            SkinManager.setViewTextColor(this.f17275h, R.color.CAM_X0101, 1);
            this.k.setProgressDrawable(SkinManager.getSkinDrawable(null, R.drawable.topic_video_seekbar));
            this.k.setThumb(SkinManager.getSkinDrawable(null, R.drawable.topic_video_seekbar_thumb));
            this.k.setThumbOffset(0);
        }
    }

    public final int n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? (int) (Math.ceil((i2 * 1.0f) / 1000.0f) * 1000.0d) : invokeI.intValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.j = false;
            this.n.removeMessages(1);
            this.k.setProgress(0);
            TextView textView = this.f17274g;
            if (textView != null) {
                textView.setText(r(0));
            }
        }
    }

    public final int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            MediaController.MediaPlayerControl mediaPlayerControl = this.f17273f;
            if (mediaPlayerControl == null || this.f17276i) {
                return 0;
            }
            int currentPosition = mediaPlayerControl.getCurrentPosition();
            int duration = this.f17273f.getDuration();
            SeekBar seekBar = this.k;
            if (seekBar != null && duration > 0) {
                seekBar.setProgress((int) ((currentPosition * 10000) / duration));
            }
            TextView textView = this.f17275h;
            if (textView != null && duration > 0) {
                textView.setText(r(n(duration)));
            }
            TextView textView2 = this.f17274g;
            if (textView2 != null) {
                textView2.setText(r(currentPosition));
            }
            return currentPosition;
        }
        return invokeV.intValue;
    }

    public void q() {
        MediaController.MediaPlayerControl mediaPlayerControl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (mediaPlayerControl = this.f17273f) == null) {
            return;
        }
        int duration = ((mediaPlayerControl.getDuration() / 200) / 50) * 50;
        this.f17272e = duration;
        if (duration < 50) {
            this.f17272e = 50;
        }
        this.j = true;
        this.n.removeMessages(1);
        Handler handler = this.n;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f17272e - (this.f17273f.getCurrentPosition() % this.f17272e));
    }

    public final String r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            int i3 = i2 / 1000;
            int i4 = i3 % 60;
            int i5 = (i3 / 60) % 60;
            int i6 = i3 / 3600;
            this.l.setLength(0);
            return i6 > 0 ? this.m.format("%d:%02d:%02d", Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(i4)).toString() : this.m.format("%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4)).toString();
        }
        return (String) invokeI.objValue;
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, mediaPlayerControl) == null) {
            this.f17273f = mediaPlayerControl;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicVideoControllerView(Context context, AttributeSet attributeSet) {
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
        this.f17272e = 50;
        this.f17276i = false;
        this.j = true;
        this.n = new a(this, Looper.getMainLooper());
        this.o = new b(this);
        k(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicVideoControllerView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f17272e = 50;
        this.f17276i = false;
        this.j = true;
        this.n = new a(this, Looper.getMainLooper());
        this.o = new b(this);
        k(context);
    }
}
