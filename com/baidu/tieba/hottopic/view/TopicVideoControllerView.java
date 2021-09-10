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
/* loaded from: classes7.dex */
public class TopicVideoControllerView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long PROGRESS_MAX = 10000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f52775e;

    /* renamed from: f  reason: collision with root package name */
    public MediaController.MediaPlayerControl f52776f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f52777g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f52778h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f52779i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f52780j;
    public SeekBar k;
    public StringBuilder l;
    public Formatter m;
    public Handler n;
    public SeekBar.OnSeekBarChangeListener o;

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TopicVideoControllerView f52781a;

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
            this.f52781a = topicVideoControllerView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1 && !this.f52781a.f52779i && this.f52781a.f52780j && this.f52781a.f52776f != null && this.f52781a.f52776f.isPlaying()) {
                sendMessageDelayed(obtainMessage(1), this.f52781a.f52775e - (this.f52781a.l() % this.f52781a.f52775e));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicVideoControllerView f52782e;

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
            this.f52782e = topicVideoControllerView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && z) {
                int duration = (int) ((this.f52782e.f52776f.getDuration() * i2) / 10000);
                this.f52782e.f52776f.seekTo(duration);
                if (this.f52782e.f52777g != null) {
                    this.f52782e.f52777g.setText(this.f52782e.m(duration));
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                this.f52782e.f52779i = true;
                this.f52782e.n.removeMessages(1);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) {
                this.f52782e.f52779i = false;
                this.f52782e.l();
                this.f52782e.n.sendEmptyMessage(1);
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
        this.f52775e = 50;
        this.f52779i = false;
        this.f52780j = true;
        this.n = new a(this, Looper.getMainLooper());
        this.o = new b(this);
        j(context);
    }

    public void destroy() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (handler = this.n) == null) {
            return;
        }
        handler.removeMessages(1);
    }

    public int getCurProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            SeekBar seekBar = this.k;
            if (seekBar != null) {
                return seekBar.getProgress();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void initCurTimeAndDuration(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            this.f52780j = false;
            this.n.removeMessages(1);
            this.k.setProgress(0);
            TextView textView = this.f52777g;
            if (textView != null) {
                textView.setText(m(i2));
            }
            TextView textView2 = this.f52778h;
            if (textView2 != null) {
                textView2.setText(m(k(i3)));
            }
        }
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.topic_video_controller, (ViewGroup) null);
            addView(inflate, -1, (int) context.getResources().getDimension(R.dimen.ds80));
            this.f52777g = (TextView) inflate.findViewById(R.id.progress_textview_cur_time);
            this.f52778h = (TextView) inflate.findViewById(R.id.progress_textview_duration);
            SeekBar seekBar = (SeekBar) inflate.findViewById(R.id.topic_video_controller_seekBar);
            this.k = seekBar;
            seekBar.setOnSeekBarChangeListener(this.o);
            this.l = new StringBuilder();
            this.m = new Formatter(this.l, Locale.getDefault());
        }
    }

    public final int k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? (int) (Math.ceil((i2 * 1.0f) / 1000.0f) * 1000.0d) : invokeI.intValue;
    }

    public final int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            MediaController.MediaPlayerControl mediaPlayerControl = this.f52776f;
            if (mediaPlayerControl == null || this.f52779i) {
                return 0;
            }
            int currentPosition = mediaPlayerControl.getCurrentPosition();
            int duration = this.f52776f.getDuration();
            SeekBar seekBar = this.k;
            if (seekBar != null && duration > 0) {
                seekBar.setProgress((int) ((currentPosition * 10000) / duration));
            }
            TextView textView = this.f52778h;
            if (textView != null && duration > 0) {
                textView.setText(m(k(duration)));
            }
            TextView textView2 = this.f52777g;
            if (textView2 != null) {
                textView2.setText(m(currentPosition));
            }
            return currentPosition;
        }
        return invokeV.intValue;
    }

    public final String m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            int i3 = i2 / 1000;
            int i4 = i3 % 60;
            int i5 = (i3 / 60) % 60;
            int i6 = i3 / 3600;
            this.l.setLength(0);
            return i6 > 0 ? this.m.format("%d:%02d:%02d", Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(i4)).toString() : this.m.format("%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4)).toString();
        }
        return (String) invokeI.objValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            SkinManager.setViewTextColor(this.f52777g, R.color.CAM_X0101, 1);
            SkinManager.setViewTextColor(this.f52778h, R.color.CAM_X0101, 1);
            this.k.setProgressDrawable(SkinManager.getSkinDrawable(null, R.drawable.topic_video_seekbar));
            this.k.setThumb(SkinManager.getSkinDrawable(null, R.drawable.topic_video_seekbar_thumb));
            this.k.setThumbOffset(0);
        }
    }

    public void resetProgress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f52780j = false;
            this.n.removeMessages(1);
            this.k.setProgress(0);
            TextView textView = this.f52777g;
            if (textView != null) {
                textView.setText(m(0));
            }
        }
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, mediaPlayerControl) == null) {
            this.f52776f = mediaPlayerControl;
        }
    }

    public void showProgress() {
        MediaController.MediaPlayerControl mediaPlayerControl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (mediaPlayerControl = this.f52776f) == null) {
            return;
        }
        int duration = ((mediaPlayerControl.getDuration() / 200) / 50) * 50;
        this.f52775e = duration;
        if (duration < 50) {
            this.f52775e = 50;
        }
        this.f52780j = true;
        this.n.removeMessages(1);
        Handler handler = this.n;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f52775e - (this.f52776f.getCurrentPosition() % this.f52775e));
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
        this.f52775e = 50;
        this.f52779i = false;
        this.f52780j = true;
        this.n = new a(this, Looper.getMainLooper());
        this.o = new b(this);
        j(context);
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
        this.f52775e = 50;
        this.f52779i = false;
        this.f52780j = true;
        this.n = new a(this, Looper.getMainLooper());
        this.o = new b(this);
        j(context);
    }
}
