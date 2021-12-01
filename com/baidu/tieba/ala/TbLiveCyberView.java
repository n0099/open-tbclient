package com.baidu.tieba.ala;

import android.content.Context;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.k;
import c.a.r0.h4.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberVideoView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.TbLiveCyberView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class TbLiveCyberView extends CyberVideoView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TB_FREE_HOST = "https://gss3.baidu.com/6LZ0ej3k1Qd3ote6lo7D0j9wehsv";
    public static final String TB_HOST = "http://tb-video.bdstatic.com";
    public transient /* synthetic */ FieldHolder $fh;
    public String J;
    public PowerManager.WakeLock K;
    public b L;
    public final CustomMessageListener M;

    /* loaded from: classes10.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbLiveCyberView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TbLiveCyberView tbLiveCyberView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbLiveCyberView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbLiveCyberView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.a.stop();
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        void onError();

        void onPrepared();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbLiveCyberView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.M = new a(this, 2001011);
        k(context);
    }

    public String getOriginUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.J : (String) invokeV.objValue;
    }

    public final String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (!k.isEmpty(str) && h.d().e()) {
                if (str.contains("http://tb-video.bdstatic.com")) {
                    return str.replace("http://tb-video.bdstatic.com", "https://gss3.baidu.com/6LZ0ej3k1Qd3ote6lo7D0j9wehsv");
                }
                return str.contains(UrlSchemaHelper.SCHEMA_TYPE_HTTP) ? str.replace(UrlSchemaHelper.SCHEMA_TYPE_HTTP, UrlSchemaHelper.SCHEMA_TYPE_HTTPS) : str;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            try {
                PowerManager powerManager = (PowerManager) TbadkCoreApplication.getInst().getContext().getSystemService("power");
                if (powerManager != null) {
                    PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(536870922, "TbBVideoView_WakeLock");
                    this.K = newWakeLock;
                    newWakeLock.setReferenceCounted(false);
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            new WeakReference(TbadkCoreApplication.getInst());
            SkinManager.setBackgroundResource(this, R.color.black_alpha100);
            setOnErrorListener(new CyberPlayerManager.OnErrorListener() { // from class: c.a.r0.a0.b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public final boolean onError(int i2, int i3, Object obj) {
                    InterceptResult invokeIIL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048576, this, i2, i3, obj)) == null) ? TbLiveCyberView.this.l(i2, i3, obj) : invokeIIL.booleanValue;
                }
            });
            setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: c.a.r0.a0.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
                public final void onPrepared() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        TbLiveCyberView.this.m();
                    }
                }
            });
        }
    }

    public /* synthetic */ boolean l(int i2, int i3, Object obj) {
        b bVar = this.L;
        if (bVar != null) {
            bVar.onError();
            return false;
        }
        return false;
    }

    public /* synthetic */ void m() {
        b bVar = this.L;
        if (bVar != null) {
            bVar.onPrepared();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.M);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetachedFromWindow();
            try {
                if (this.K != null && this.K.isHeld()) {
                    this.K.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            MessageManager.getInstance().unRegisterListener(this.M);
        }
    }

    public void setOuterListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.L = bVar;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView
    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || k.isEmpty(str)) {
            return;
        }
        this.J = str;
        super.setVideoPath(j(str));
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || TextUtils.isEmpty(this.J)) {
            return;
        }
        super.start();
        if (getCyberPlayer() != null) {
            getCyberPlayer().muteOrUnmuteAudio(true);
        }
        try {
            if (this.K == null || this.K.isHeld()) {
                return;
            }
            this.K.acquire();
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            try {
                if (this.K != null && this.K.isHeld()) {
                    this.K.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            stopPlayback();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbLiveCyberView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.M = new a(this, 2001011);
        k(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbLiveCyberView(Context context) {
        super(context, 1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.M = new a(this, 2001011);
        k(context);
    }
}
