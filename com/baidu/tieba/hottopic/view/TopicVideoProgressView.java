package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class TopicVideoProgressView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f52637e;

    /* renamed from: f  reason: collision with root package name */
    public MediaController.MediaPlayerControl f52638f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f52639g;

    /* renamed from: h  reason: collision with root package name */
    public View f52640h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f52641i;

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TopicVideoProgressView f52642a;

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
            this.f52642a = topicVideoProgressView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1 && this.f52642a.f52639g && this.f52642a.f52638f != null && this.f52642a.f52638f.isPlaying()) {
                sendMessageDelayed(obtainMessage(1), this.f52642a.f52637e - (this.f52642a.f() % this.f52642a.f52637e));
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
        this.f52637e = 50;
        this.f52639g = true;
        this.f52641i = new a(this, Looper.getMainLooper());
        e(context);
    }

    public void destroy() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (handler = this.f52641i) == null) {
            return;
        }
        handler.removeMessages(1);
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            View view = new View(context);
            this.f52640h = view;
            view.setBackgroundColor(getResources().getColor(R.color.CAM_X0303));
            addView(this.f52640h, 0, (int) context.getResources().getDimension(R.dimen.ds6));
            setBackgroundColor(getResources().getColor(R.color.CAM_X0204));
        }
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            MediaController.MediaPlayerControl mediaPlayerControl = this.f52638f;
            if (mediaPlayerControl == null || this.f52640h == null) {
                return 0;
            }
            int currentPosition = mediaPlayerControl.getCurrentPosition();
            int duration = this.f52638f.getDuration();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f52640h.getLayoutParams();
            if ((layoutParams instanceof RelativeLayout.LayoutParams) && duration > 0) {
                layoutParams.width = (int) (((getWidth() * 1.0f) * currentPosition) / duration);
                this.f52640h.setLayoutParams(layoutParams);
            }
            return currentPosition;
        }
        return invokeV.intValue;
    }

    public void initProgress() {
        RelativeLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f52639g = false;
            this.f52641i.removeMessages(1);
            View view = this.f52640h;
            if (view == null || (layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams()) == null) {
                return;
            }
            layoutParams.width = 0;
            this.f52640h.setLayoutParams(layoutParams);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f52640h, R.color.CAM_X0303);
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
            this.f52638f = mediaPlayerControl;
        }
    }

    public void showProgress() {
        MediaController.MediaPlayerControl mediaPlayerControl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (mediaPlayerControl = this.f52638f) == null) {
            return;
        }
        int duration = ((mediaPlayerControl.getDuration() / 200) / 50) * 50;
        this.f52637e = duration;
        if (duration < 50) {
            this.f52637e = 50;
        }
        this.f52639g = true;
        this.f52641i.removeMessages(1);
        Handler handler = this.f52641i;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f52637e - (this.f52638f.getCurrentPosition() % this.f52637e));
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
        this.f52637e = 50;
        this.f52639g = true;
        this.f52641i = new a(this, Looper.getMainLooper());
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
        this.f52637e = 50;
        this.f52639g = true;
        this.f52641i = new a(this, Looper.getMainLooper());
        e(context);
    }
}
