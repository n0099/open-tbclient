package com.baidu.tieba.card.ala;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.ab8;
import com.baidu.tieba.ej;
import com.baidu.tieba.fb8;
import com.baidu.tieba.gh;
import com.baidu.tieba.k26;
import com.baidu.tieba.ma8;
import com.baidu.tieba.play.TbVideoView;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.view.AudioAnimationView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class AlaVideoContainer extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable A;
    public View a;
    public k26 b;
    public TbVideoViewContainer c;
    public ma8 d;
    public TbImageView e;
    public View f;
    public TextView g;
    public TBLottieAnimationView h;
    public TextView i;
    public FrameLayout j;
    public Animation k;
    public AudioAnimationView l;
    public View m;
    public TextView n;
    public View o;
    public TextView p;
    public View.OnClickListener q;
    public LinearLayout r;
    public TextView s;
    public int t;
    public TbImageView.g u;
    public View.OnClickListener v;
    public fb8 w;
    public Runnable x;
    public TbVideoViewContainer.a y;
    public Runnable z;

    /* loaded from: classes3.dex */
    public class a implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaVideoContainer a;

        public a(AlaVideoContainer alaVideoContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaVideoContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaVideoContainer;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.a.e != null) {
                this.a.e.setDefaultBgResource(0);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaVideoContainer a;

        public b(AlaVideoContainer alaVideoContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaVideoContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaVideoContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2.getId() == this.a.a.getId()) {
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    if (this.a.q != null) {
                        this.a.q.onClick(view2);
                        return;
                    }
                    return;
                }
                ej.K(this.a.getContext(), this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0c92));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements fb8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaVideoContainer a;

        public c(AlaVideoContainer alaVideoContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaVideoContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaVideoContainer;
        }

        @Override // com.baidu.tieba.fb8
        public void changeRenderViewMode(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // com.baidu.tieba.fb8
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.fb8
        public View getMainView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // com.baidu.tieba.fb8
        public boolean isFullScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.fb8
        public boolean isPlaying() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.fb8
        public boolean onBackPress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.fb8
        public boolean onBackground(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                return false;
            }
            return invokeZ.booleanValue;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048585, this, i, i2, obj)) == null) {
                gh.a().post(this.a.A);
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048586, this, i, i2, obj)) == null) {
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                if (this.a.d != null) {
                    this.a.d.setLooping(true);
                    this.a.d.setVolume(0.0f, 0.0f);
                }
                this.a.l.g();
                this.a.j.setVisibility(8);
                this.a.e.setVisibility(8);
                gh.a().postDelayed(this.a.x, 3000L);
                gh.a().removeCallbacks(this.a.A);
            }
        }

        @Override // com.baidu.tieba.fb8
        public void onScroll() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            }
        }

        @Override // com.baidu.tieba.play.TbVideoViewContainer.a
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            }
        }

        @Override // com.baidu.tieba.fb8
        public boolean onVolumeUp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.fb8
        public void setAfterClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            }
        }

        @Override // com.baidu.tieba.fb8
        public void setData(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, threadData) == null) {
            }
        }

        @Override // com.baidu.tieba.fb8
        public void setFrom(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.fb8
        public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            }
        }

        @Override // com.baidu.tieba.fb8
        public void setStageType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.fb8
        public void setStatistic(ab8 ab8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, ab8Var) == null) {
            }
        }

        @Override // com.baidu.tieba.fb8
        public void setUniqueId(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            }
        }

        @Override // com.baidu.tieba.fb8
        public void startPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            }
        }

        @Override // com.baidu.tieba.fb8
        public void stopPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaVideoContainer a;

        public d(AlaVideoContainer alaVideoContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaVideoContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaVideoContainer;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f == null) {
                return;
            }
            this.a.f.startAnimation(this.a.k);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements TbVideoViewContainer.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaVideoContainer a;

        public e(AlaVideoContainer alaVideoContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaVideoContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaVideoContainer;
        }

        @Override // com.baidu.tieba.play.TbVideoViewContainer.a
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.p();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaVideoContainer a;

        public f(AlaVideoContainer alaVideoContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaVideoContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaVideoContainer;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.p();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaVideoContainer a;

        public g(AlaVideoContainer alaVideoContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaVideoContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaVideoContainer;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.m.setVisibility(0);
                this.a.j.setVisibility(8);
                gh.a().postDelayed(this.a.z, 2000L);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaVideoContainer(Context context) {
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
        this.t = 3;
        this.u = new a(this);
        this.v = new b(this);
        this.w = new c(this);
        this.x = new d(this);
        this.y = new e(this);
        this.z = new f(this);
        this.A = new g(this);
        n();
    }

    public k26 getController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (k26) invokeV.objValue;
    }

    public ma8 getVideoView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : (ma8) invokeV.objValue;
    }

    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public void m() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (tBLottieAnimationView = this.h) == null) {
            return;
        }
        tBLottieAnimationView.cancelAnimation();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0112, (ViewGroup) this, true);
            View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f092515);
            this.a = findViewById;
            findViewById.setOnClickListener(this.v);
            TbVideoViewContainer tbVideoViewContainer = (TbVideoViewContainer) inflate.findViewById(R.id.obfuscated_res_0x7f092594);
            this.c = tbVideoViewContainer;
            TbVideoView control = tbVideoViewContainer.getControl();
            this.d = control;
            control.setStageType(null);
            ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
            layoutParams.height = (this.c.getWidth() * 9) / 16;
            this.c.setLayoutParams(layoutParams);
            this.d.setOperableVideoContainer(this.w);
            this.d.setOnSurfaceDestroyedListener(this.y);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090f0d);
            this.e = tbImageView;
            tbImageView.setDrawCorner(true);
            this.e.setPlaceHolder(3);
            this.e.setEvent(this.u);
            this.e.setGifIconSupport(false);
            this.e.setConrers(15);
            this.e.setRadius(ej.f(getContext(), R.dimen.tbds10));
            this.e.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            this.e.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.e.setBorderSurroundContent(true);
            this.e.setDrawBorder(true);
            this.f = inflate.findViewById(R.id.obfuscated_res_0x7f0912ad);
            this.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092419);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) inflate.findViewById(R.id.obfuscated_res_0x7f090efa);
            this.h = tBLottieAnimationView;
            tBLottieAnimationView.loop(true);
            this.j = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091299);
            this.k = AnimationUtils.loadAnimation(getContext(), R.anim.obfuscated_res_0x7f01014d);
            AudioAnimationView audioAnimationView = (AudioAnimationView) inflate.findViewById(R.id.obfuscated_res_0x7f0919fb);
            this.l = audioAnimationView;
            audioAnimationView.setCertainColumnCount(4);
            this.l.setColumnColor(R.color.CAM_X0302);
            this.m = inflate.findViewById(R.id.obfuscated_res_0x7f09128b);
            this.n = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092520);
            this.o = inflate.findViewById(R.id.obfuscated_res_0x7f091298);
            this.p = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09253c);
            this.r = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0913e0);
            this.s = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09234d);
            this.b = new k26(this);
            this.i = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0919ed);
            o(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || i == this.t) {
            return;
        }
        this.t = i;
        TextView textView = this.g;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
        }
        SkinManager.setLottieAnimation(this.h, R.raw.obfuscated_res_0x7f110007);
        SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this.m, R.color.black_alpha80);
        SkinManager.setBackgroundColor(this.c, R.color.black_alpha100);
        SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this.o, R.color.black_alpha80);
        SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0101);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onAttachedToWindow();
            q();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDetachedFromWindow();
            m();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.e.setVisibility(0);
            this.h.setVisibility(0);
            this.j.setVisibility(8);
            View view2 = this.f;
            if (view2 != null) {
                view2.clearAnimation();
            }
            this.l.f();
            this.m.setVisibility(8);
            this.o.setVisibility(8);
            gh.a().removeCallbacks(this.x);
            gh.a().removeCallbacks(this.z);
            gh.a().removeCallbacks(this.A);
        }
    }

    public void q() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (tBLottieAnimationView = this.h) == null) {
            return;
        }
        tBLottieAnimationView.playAnimation();
    }

    public void setLigvingLogLayoutVisible(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.r.setVisibility(i);
        }
    }

    public void setLivingLogLeftDrawable(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.s.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
        }
    }

    public void setLivingLogText(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.s.setText(i);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) {
            this.q = onClickListener;
        }
    }

    public void setPlayCount(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || (textView = this.i) == null) {
            return;
        }
        textView.setText(str);
    }

    public void setTitle(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || (textView = this.g) == null) {
            return;
        }
        textView.setText(str);
    }

    public void setVideoStatsData(ab8 ab8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ab8Var) == null) {
            this.d.setVideoStatData(ab8Var);
        }
    }

    public void setVideoThumbnail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.e.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.e.K(str, 10, false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
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
        this.t = 3;
        this.u = new a(this);
        this.v = new b(this);
        this.w = new c(this);
        this.x = new d(this);
        this.y = new e(this);
        this.z = new f(this);
        this.A = new g(this);
        n();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
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
        this.t = 3;
        this.u = new a(this);
        this.v = new b(this);
        this.w = new c(this);
        this.x = new d(this);
        this.y = new e(this);
        this.z = new f(this);
        this.A = new g(this);
        n();
    }
}
