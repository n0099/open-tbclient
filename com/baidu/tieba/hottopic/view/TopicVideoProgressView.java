package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import c.a.r0.p1.b;
import c.a.r0.p1.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class TopicVideoProgressView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f45734e;

    /* renamed from: f  reason: collision with root package name */
    public MediaController.MediaPlayerControl f45735f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f45736g;

    /* renamed from: h  reason: collision with root package name */
    public View f45737h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f45738i;

    /* loaded from: classes10.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopicVideoProgressView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TopicVideoProgressView topicVideoProgressView, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicVideoProgressView, looper};
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
            this.a = topicVideoProgressView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1 && this.a.f45736g && this.a.f45735f != null && this.a.f45735f.isPlaying()) {
                sendMessageDelayed(obtainMessage(1), this.a.f45734e - (this.a.f() % this.a.f45734e));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicVideoProgressView(Context context) {
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
        this.f45734e = 50;
        this.f45736g = true;
        this.f45738i = new a(this, Looper.getMainLooper());
        e(context);
    }

    public void destroy() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (handler = this.f45738i) == null) {
            return;
        }
        handler.removeMessages(1);
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            View view = new View(context);
            this.f45737h = view;
            view.setBackgroundColor(getResources().getColor(b.CAM_X0303));
            addView(this.f45737h, 0, (int) context.getResources().getDimension(c.ds6));
            setBackgroundColor(getResources().getColor(b.CAM_X0204));
        }
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            MediaController.MediaPlayerControl mediaPlayerControl = this.f45735f;
            if (mediaPlayerControl == null || this.f45737h == null) {
                return 0;
            }
            int currentPosition = mediaPlayerControl.getCurrentPosition();
            int duration = this.f45735f.getDuration();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f45737h.getLayoutParams();
            if ((layoutParams instanceof RelativeLayout.LayoutParams) && duration > 0) {
                layoutParams.width = (int) (((getWidth() * 1.0f) * currentPosition) / duration);
                this.f45737h.setLayoutParams(layoutParams);
            }
            return currentPosition;
        }
        return invokeV.intValue;
    }

    public void initProgress() {
        RelativeLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f45736g = false;
            this.f45738i.removeMessages(1);
            View view = this.f45737h;
            if (view == null || (layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams()) == null) {
                return;
            }
            layoutParams.width = 0;
            this.f45737h.setLayoutParams(layoutParams);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            SkinManager.setBackgroundColor(this, b.CAM_X0204);
            SkinManager.setBackgroundColor(this.f45737h, b.CAM_X0303);
        }
    }

    public void resetProgress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            initProgress();
        }
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, mediaPlayerControl) == null) {
            this.f45735f = mediaPlayerControl;
        }
    }

    public void showProgress() {
        MediaController.MediaPlayerControl mediaPlayerControl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (mediaPlayerControl = this.f45735f) == null) {
            return;
        }
        int duration = ((mediaPlayerControl.getDuration() / 200) / 50) * 50;
        this.f45734e = duration;
        if (duration < 50) {
            this.f45734e = 50;
        }
        this.f45736g = true;
        this.f45738i.removeMessages(1);
        Handler handler = this.f45738i;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f45734e - (this.f45735f.getCurrentPosition() % this.f45734e));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicVideoProgressView(Context context, AttributeSet attributeSet) {
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
        this.f45734e = 50;
        this.f45736g = true;
        this.f45738i = new a(this, Looper.getMainLooper());
        e(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicVideoProgressView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f45734e = 50;
        this.f45736g = true;
        this.f45738i = new a(this, Looper.getMainLooper());
        e(context);
    }
}
