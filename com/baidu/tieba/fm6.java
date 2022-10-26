package com.baidu.tieba;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.xa8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class fm6 extends p16 implements n26, zo5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView A;
    public ImageView B;
    public TbVideoViewContainer C;
    public TextView D;
    public View E;
    public hb8 F;
    public ThreadData G;
    public View H;
    public TextView I;
    public int J;
    public int K;
    public int L;
    public boolean M;
    public String N;
    public xa8 O;
    public Animation P;
    public fu6 Q;
    public TbImageView R;
    public String S;
    public String T;
    public String U;
    public View V;
    public int W;
    public Handler X;
    public pb8 Y;
    public VideoLoadingProgressView.c Z;
    public String a0;
    public TbImageView.g b0;
    public ViewTreeObserver.OnGlobalLayoutListener c0;
    public Runnable d0;
    public Runnable e0;
    public TbVideoViewContainer.a f0;
    public View.OnClickListener g0;
    public final View.OnClickListener h0;
    public ThreadCommentAndPraiseInfoLayout i;
    public final View.OnClickListener i0;
    public ThreadSourceShareAndPraiseLayout j;
    public xa8.b j0;
    public ThreadUserInfoLayout k;
    public ThreadGodReplyLayout l;
    public HeadPendantClickableView m;
    public View n;
    public TextView o;
    public FrameLayout p;
    public LinearLayout q;
    public Animation.AnimationListener q0;
    public ThreadSkinView r;
    public TextView s;
    public LinearLayout t;
    public View u;
    public TextView v;
    public TbPageContext w;
    public RelativeLayout x;
    public LinearLayout y;
    public TextView z;

    @Override // com.baidu.tieba.p16
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? R.layout.obfuscated_res_0x7f0d0194 : invokeV.intValue;
    }

    /* loaded from: classes4.dex */
    public class a extends pl5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(fm6 fm6Var, int i, String str, String str2) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fm6Var, Integer.valueOf(i), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = str2;
        }

        @Override // com.baidu.tieba.pl5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                zo4.x(TbadkCoreApplication.getInst().getApplicationContext(), false, this.h);
                TiebaStatic.log(new StatisticItem("c12841").param("obj_source", "2"));
            }
        }

        @Override // com.baidu.tieba.pl5, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0304));
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fm6 a;

        public b(fm6 fm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fm6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.C != null && this.a.C.getControl() != null && !this.a.C.getControl().isPlaying()) {
                this.a.Z(true, 1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fm6 a;

        public c(fm6 fm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fm6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.V();
            this.a.Z(true, 4);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements TbVideoViewContainer.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fm6 a;

        public d(fm6 fm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fm6Var;
        }

        @Override // com.baidu.tieba.play.TbVideoViewContainer.a
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.stopPlay();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fm6 a;

        public e(fm6 fm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fm6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.G != null && !StringUtils.isNull(this.a.G.getForum_name())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.w.getPageActivity()).createNormalCfg(this.a.G.getForum_name(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                if (this.a.i0 != null) {
                    this.a.i0.onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fm6 a;

        public f(fm6 fm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fm6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.e() != null) {
                this.a.e().a(view2, this.a.G);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fm6 a;

        public g(fm6 fm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fm6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.G != null && this.a.e() != null) {
                this.a.e().a(view2, this.a.G);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements xa8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fm6 a;

        public h(fm6 fm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fm6Var;
        }

        @Override // com.baidu.tieba.xa8.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.X();
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fm6 a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }

        public i(fm6 fm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fm6Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animation) == null) && this.a.L == 3 && this.a.A != null) {
                this.a.A.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fm6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(fm6 fm6Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fm6Var, looper};
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
            this.a = fm6Var;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i != 202) {
                    if (i != 203) {
                        return;
                    }
                    this.a.L();
                    return;
                }
                this.a.M();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements pb8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fm6 a;

        @Override // com.baidu.tieba.pb8
        public void changeRenderViewMode(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // com.baidu.tieba.pb8
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.pb8
        public View getMainView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // com.baidu.tieba.pb8
        public boolean isFullScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.pb8
        public boolean isPlaying() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.pb8
        public boolean onBackPress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.pb8
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

        @Override // com.baidu.tieba.pb8
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

        @Override // com.baidu.tieba.pb8
        public boolean onVolumeUp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.pb8
        public void setAfterClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            }
        }

        @Override // com.baidu.tieba.pb8
        public void setData(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, threadData) == null) {
            }
        }

        @Override // com.baidu.tieba.pb8
        public void setFrom(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.pb8
        public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            }
        }

        @Override // com.baidu.tieba.pb8
        public void setStageType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.pb8
        public void setStatistic(kb8 kb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, kb8Var) == null) {
            }
        }

        @Override // com.baidu.tieba.pb8
        public void setUniqueId(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            }
        }

        @Override // com.baidu.tieba.pb8
        public void startPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            }
        }

        @Override // com.baidu.tieba.pb8
        public void stopPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            }
        }

        public k(fm6 fm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fm6Var;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.a.C.getControl().start();
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeIIL = interceptable.invokeIIL(1048585, this, i, i2, obj)) != null) {
                return invokeIIL.booleanValue;
            }
            this.a.V();
            this.a.Z(true, 4);
            this.a.M = false;
            return true;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048586, this, i, i2, obj)) == null) {
                if (i == 3) {
                    this.a.Z(false, 3);
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                if (this.a.C != null && this.a.C.getControl() != null) {
                    this.a.C.getControl().setVolume(0.0f, 0.0f);
                }
                this.a.d0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements VideoLoadingProgressView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fm6 a;

        public l(fm6 fm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fm6Var;
        }

        @Override // com.baidu.tieba.play.VideoLoadingProgressView.c
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.d0();
        }
    }

    /* loaded from: classes4.dex */
    public class m implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fm6 a;

        public m(fm6 fm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fm6Var;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
            FrameLayout frameLayout;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (frameLayout = this.a.p) != null) {
                frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(this.a.c0);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            FrameLayout frameLayout;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) && (frameLayout = this.a.p) != null) {
                frameLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this.a.c0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fm6 a;

        public n(fm6 fm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fm6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (threadCommentAndPraiseInfoLayout = this.a.i) != null) {
                threadCommentAndPraiseInfoLayout.changeSelectStatus();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements ThreadCommentAndPraiseInfoLayout.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fm6 a;

        public o(fm6 fm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fm6Var;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.m
        public void a(boolean z) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(1048576, this, z) != null) || this.a.V == null) {
                return;
            }
            View view2 = this.a.V;
            if (z) {
                i = R.color.CAM_X0201;
            } else {
                i = R.color.transparent;
            }
            SkinManager.setBackgroundColor(view2, i);
        }
    }

    /* loaded from: classes4.dex */
    public class p implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fm6 a;

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public p(fm6 fm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fm6Var;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.a.A != null) {
                this.a.A.setDefaultBgResource(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fm6 a;

        public q(fm6 fm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fm6Var;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            FrameLayout frameLayout;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (frameLayout = this.a.p) != null && frameLayout.getLayoutParams() != null && this.a.p.getVisibility() != 8) {
                this.a.p.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                ViewGroup.LayoutParams layoutParams = this.a.p.getLayoutParams();
                if (this.a.p.getWidth() <= 0) {
                    return;
                }
                layoutParams.height = (int) (this.a.p.getWidth() * 0.5625d);
                this.a.p.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadData a;
        public final /* synthetic */ fm6 b;

        public r(fm6 fm6Var, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fm6Var, threadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fm6Var;
            this.a = threadData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.b.w != null) {
                    this.b.b.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(this.b.b.getContext(), "", this.a.iconLink, true)));
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fm6(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.J = 3;
        this.K = 0;
        this.L = 1;
        this.M = false;
        this.X = new j(this, Looper.getMainLooper());
        this.Y = new k(this);
        this.Z = new l(this);
        this.b0 = new p(this);
        this.c0 = new q(this);
        this.d0 = new b(this);
        this.e0 = new c(this);
        this.f0 = new d(this);
        this.g0 = new e(this);
        this.h0 = new f(this);
        this.i0 = new g(this);
        this.j0 = new h(this);
        this.q0 = new i(this);
        o(bdUniqueId);
        this.h = 3;
        this.w = tbPageContext;
        View k2 = k();
        this.u = k2.findViewById(R.id.divider_line);
        this.x = (RelativeLayout) k2.findViewById(R.id.obfuscated_res_0x7f09129b);
        this.R = (TbImageView) k2.findViewById(R.id.obfuscated_res_0x7f090bd0);
        this.y = (LinearLayout) k2.findViewById(R.id.obfuscated_res_0x7f0924fc);
        this.x.setOnClickListener(this);
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) this.x.findViewById(R.id.obfuscated_res_0x7f09055b);
        this.m = headPendantClickableView;
        if (headPendantClickableView.getHeadView() != null) {
            this.m.getHeadView().setIsRound(true);
            this.m.getHeadView().setDrawBorder(false);
            this.m.getHeadView().setDefaultResource(17170445);
            this.m.getHeadView().setRadius(fj.f(this.w.getPageActivity(), R.dimen.obfuscated_res_0x7f070266));
        }
        this.m.setHasPendantStyle();
        if (this.m.getPendantView() != null) {
            this.m.getPendantView().setIsRound(true);
            this.m.getPendantView().setDrawBorder(false);
        }
        TextView textView = (TextView) k2.findViewById(R.id.obfuscated_res_0x7f092190);
        this.o = textView;
        textView.setVisibility(8);
        this.o.setOnClickListener(this.g0);
        hb8 hb8Var = new hb8((ViewGroup) k2.findViewById(R.id.obfuscated_res_0x7f090302));
        this.F = hb8Var;
        hb8Var.f(this.Z);
        this.z = (TextView) k2.findViewById(R.id.obfuscated_res_0x7f092136);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = (ThreadCommentAndPraiseInfoLayout) k2.findViewById(R.id.obfuscated_res_0x7f09210e);
        this.i = threadCommentAndPraiseInfoLayout;
        threadCommentAndPraiseInfoLayout.setForumAfterClickListener(this.i0);
        ThreadUserInfoLayout threadUserInfoLayout = (ThreadUserInfoLayout) k2.findViewById(R.id.obfuscated_res_0x7f090543);
        this.k = threadUserInfoLayout;
        threadUserInfoLayout.setFrom(3);
        this.n = k2.findViewById(R.id.obfuscated_res_0x7f090809);
        if (this.i.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.i.setLayoutParams(layoutParams);
        }
        this.i.setOnClickListener(this);
        this.i.setReplyTimeVisible(false);
        this.i.setShowPraiseNum(true);
        this.i.setNeedAddPraiseIcon(true);
        this.i.setNeedAddReplyIcon(true);
        this.i.setIsBarViewVisible(false);
        this.i.setShareVisible(true);
        this.i.setShareReportFrom(1);
        this.i.setStType("frs_page");
        this.i.setFrom(2);
        this.i.S = 3;
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) k2.findViewById(R.id.obfuscated_res_0x7f092111);
        this.j = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.b.setOnClickListener(this);
        this.j.setFrom(2);
        this.j.setShareReportFrom(1);
        this.j.setSourceFromForPb(3);
        this.j.setStType("frs_page");
        this.j.setHideBarName(true);
        FrameLayout frameLayout = (FrameLayout) k2.findViewById(R.id.obfuscated_res_0x7f090ade);
        this.p = frameLayout;
        frameLayout.setOnClickListener(this);
        this.p.addOnAttachStateChangeListener(new m(this));
        TbImageView tbImageView = (TbImageView) k2.findViewById(R.id.obfuscated_res_0x7f090ea2);
        this.A = tbImageView;
        tbImageView.setPageId(f());
        this.A.setDrawCorner(true);
        this.A.setPlaceHolder(3);
        this.A.setEvent(this.b0);
        this.A.setGifIconSupport(false);
        this.B = (ImageView) k2.findViewById(R.id.obfuscated_res_0x7f090ea3);
        TbVideoViewContainer tbVideoViewContainer = new TbVideoViewContainer(getContext());
        this.C = tbVideoViewContainer;
        tbVideoViewContainer.getControl().setStageType("2003");
        Y();
        this.C.getControl().setContinuePlayEnable(true);
        this.C.getControl().setOperableVideoContainer(this.Y);
        this.C.getControl().setOnSurfaceDestroyedListener(this.f0);
        xa8 xa8Var = new xa8();
        this.O = xa8Var;
        xa8Var.l(this.C.getControl());
        this.O.i(this.j0);
        this.H = k2.findViewById(R.id.obfuscated_res_0x7f0902ff);
        this.D = (TextView) k2.findViewById(R.id.obfuscated_res_0x7f090301);
        this.E = k2.findViewById(R.id.obfuscated_res_0x7f090300);
        this.q = (LinearLayout) k2.findViewById(R.id.obfuscated_res_0x7f0924fc);
        this.r = (ThreadSkinView) k2.findViewById(R.id.obfuscated_res_0x7f090c17);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.w.getPageActivity(), R.anim.obfuscated_res_0x7f01006a);
        this.P = loadAnimation;
        loadAnimation.setAnimationListener(this.q0);
        this.s = (TextView) k2.findViewById(R.id.obfuscated_res_0x7f09213b);
        this.I = (TextView) k2.findViewById(R.id.obfuscated_res_0x7f09213c);
        this.t = (LinearLayout) k2.findViewById(R.id.obfuscated_res_0x7f09086a);
        fu6 fu6Var = new fu6(tbPageContext, this.x);
        this.Q = fu6Var;
        fu6Var.d(f());
        ThreadGodReplyLayout threadGodReplyLayout = (ThreadGodReplyLayout) k2.findViewById(R.id.obfuscated_res_0x7f09053f);
        this.l = threadGodReplyLayout;
        threadGodReplyLayout.setOnClickListener(this);
        View findViewById = k2.findViewById(R.id.obfuscated_res_0x7f09219d);
        this.V = findViewById;
        findViewById.setOnClickListener(new n(this));
        this.i.setOnSelectStatusChangeListener(new o(this));
        this.v = (TextView) k2.findViewById(R.id.obfuscated_res_0x7f09161b);
    }

    public int G(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            return yo5.c().b(this.T, i2);
        }
        return invokeI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.p16
    /* renamed from: S */
    public void l(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, threadData) == null) {
            this.G = threadData;
            T();
        }
    }

    public void U(BdUniqueId bdUniqueId) {
        ThreadUserInfoLayout threadUserInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, bdUniqueId) == null) && bdUniqueId != null && this.i != null && (threadUserInfoLayout = this.k) != null) {
            threadUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.n26
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.a0 = str;
        }
    }

    public void a0(kb8 kb8Var) {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, kb8Var) == null) && (tbVideoViewContainer = this.C) != null && tbVideoViewContainer.getControl() != null) {
            this.C.getControl().setVideoStatData(kb8Var);
        }
    }

    @Override // com.baidu.tieba.zo5
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.T = str;
        }
    }

    @Override // com.baidu.tieba.n26
    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.h = i2;
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.i;
            if (threadCommentAndPraiseInfoLayout != null) {
                threadCommentAndPraiseInfoLayout.S = i2;
                threadCommentAndPraiseInfoLayout.setFrom(2);
            }
            ThreadUserInfoLayout threadUserInfoLayout = this.k;
            if (threadUserInfoLayout != null) {
                threadUserInfoLayout.setFrom(3);
            }
        }
    }

    public String H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.N;
        }
        return (String) invokeV.objValue;
    }

    public View I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.p;
        }
        return (View) invokeV.objValue;
    }

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.M;
        }
        return invokeV.booleanValue;
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.X.removeMessages(202);
            this.X.removeMessages(203);
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            hh.a().removeCallbacks(this.d0);
            hh.a().removeCallbacks(this.e0);
        }
    }

    public final void Y() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (tbVideoViewContainer = this.C) != null && tbVideoViewContainer.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.p.addView(this.C, 0);
            this.C.setLayoutParams(layoutParams);
        }
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            TbVideoViewContainer tbVideoViewContainer = this.C;
            if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null) {
                return this.C.getControl().getCurrentPosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            TbVideoViewContainer tbVideoViewContainer = this.C;
            if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null) {
                return this.C.getControl().isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void K(Rect rect) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, rect) == null) && this.G != null) {
            if (this.W == 501) {
                str = "frs_tab";
            } else {
                str = "frs";
            }
            String str2 = str;
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.G);
            arrayList.add(videoItemData);
            String str3 = null;
            if (this.G.getBaijiahaoData() != null) {
                str3 = this.G.getBaijiahaoData().oriUgcNid;
            }
            String str4 = str3;
            Activity pageActivity = this.b.getPageActivity();
            ThreadData threadData = this.G;
            uh5.d(pageActivity, arrayList, str4, false, 0, rect, "from_nani_video", "frs_page", null, str2, "", false, threadData.isJumpToFrsVideoTabPlay, threadData.getFid());
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (k().getParent() == null) {
                stopPlay();
                return;
            }
            this.X.removeMessages(203);
            int currentPosition = this.C.getControl().getCurrentPosition();
            if (currentPosition != this.K) {
                this.K = currentPosition;
                Z(false, 3);
            } else {
                Z(false, 2);
            }
            this.X.sendEmptyMessageDelayed(203, 3000L);
        }
    }

    public final void M() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.X.removeMessages(202);
            if (this.C.getControl().getCurrentPosition() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Z(false, 3);
                this.X.sendEmptyMessageDelayed(203, 3000L);
                return;
            }
            this.X.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public final void d0() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (tbVideoViewContainer = this.C) != null && tbVideoViewContainer.getControl() != null && this.M) {
            try {
                this.C.getControl().start();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.X.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            W();
            V();
            Z(true, 1);
            TbVideoViewContainer tbVideoViewContainer = this.C;
            if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null) {
                this.C.getControl().stopPlayback();
                xa8 xa8Var = this.O;
                if (xa8Var != null) {
                    xa8Var.n();
                }
            }
            this.M = false;
        }
    }

    public final void N(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            if (this.G != null) {
                StatisticItem statisticItem = new StatisticItem("c11100");
                statisticItem.param("tid", this.G.getId());
                statisticItem.param("fid", this.G.getFid() + "");
                TiebaStatic.log(statisticItem);
            }
            if (e() != null) {
                e().a(view2, this.G);
            }
            if (view2 == this.p) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    fj.M(this.w.getPageActivity(), R.string.obfuscated_res_0x7f0f0ca3);
                } else {
                    K(ThreadCardUtils.computeViewArea(this.p));
                }
            }
        }
    }

    public final void c0(ThreadData threadData) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048599, this, threadData) != null) || (tbImageView = this.R) == null) {
            return;
        }
        if (threadData == null) {
            tbImageView.setVisibility(8);
        } else if (!StringUtils.isNull(threadData.iconPicUrl)) {
            fu6 fu6Var = this.Q;
            if (fu6Var != null && fu6Var.b() && (this.R.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.R.getLayoutParams();
                layoutParams.rightMargin = fj.f(this.w.getContext(), R.dimen.tbds106);
                this.R.setLayoutParams(layoutParams);
            }
            this.R.setVisibility(0);
            this.R.setImageDrawable(null);
            this.R.L(threadData.iconPicUrl, 10, false);
            this.R.setOnClickListener(new r(this, threadData));
        } else {
            this.R.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, view2) == null) {
            if (view2 != this.x && view2 != this.i.getCommentNumView() && view2 != this.y) {
                if (view2 == this.p) {
                    ThreadData threadData = this.G;
                    boolean z = false;
                    if (threadData != null && threadData.getThreadVideoInfo() != null && this.G.getThreadVideoInfo().is_vertical.intValue() == 1) {
                        z = true;
                    }
                    if (z) {
                        O(view2);
                    } else if (UtilHelper.isGotoVideoMiddlePage()) {
                        N(this.p);
                    } else {
                        P(this.p);
                    }
                } else {
                    ThreadGodReplyLayout threadGodReplyLayout = this.l;
                    if (view2 == threadGodReplyLayout) {
                        P(threadGodReplyLayout);
                    }
                }
            } else {
                P(this.x);
            }
            ThreadData threadData2 = this.G;
            if (threadData2 != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, threadData2));
            }
        }
    }

    public final void O(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            if (e() != null) {
                e().a(view2, this.G);
            }
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                fj.M(this.w.getPageActivity(), R.string.obfuscated_res_0x7f0f0ca3);
            } else {
                K(ThreadCardUtils.computeViewArea(this.p));
            }
        }
    }

    public void b0(int i2) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048598, this, i2) != null) || (threadData = this.G) == null) {
            return;
        }
        if (i2 == 1) {
            this.i.setVisibility(8);
            this.j.g(this.G);
            this.n.setVisibility(8);
            return;
        }
        this.i.setData(threadData);
        this.n.setVisibility(8);
        this.j.setVisibility(8);
    }

    public final void P(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            ThreadData threadData = this.G;
            if (threadData != null) {
                if (threadData.isFloor5Video()) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM).param("fid", String.valueOf(this.G.getFid())).param("obj_type", 2));
                } else {
                    StatisticItem statisticItem = new StatisticItem("c11100");
                    statisticItem.param("tid", this.G.getId());
                    statisticItem.param("fid", this.G.getFid() + "");
                    TiebaStatic.log(statisticItem);
                }
                if (this.G.getAuthor() != null && this.G.getAuthor().getGodUserData() != null && this.G.getAuthor().getGodUserData().getType() == 2) {
                    TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", this.G.getId()));
                }
            }
            if (e() != null) {
                e().a(view2, this.G);
            }
            ThreadData threadData2 = this.G;
            if (threadData2 != null) {
                a26.a(threadData2.getId());
                SkinManager.setViewTextColor(this.z, R.color.CAM_X0109, 1);
                fi5.b(this.G.getId());
                String str = null;
                String valueOf = String.valueOf(this.G.getFid());
                OriginalForumInfo originalForumInfo = this.G.mOriginalForumInfo;
                if (originalForumInfo != null) {
                    valueOf = originalForumInfo.id;
                    str = valueOf;
                }
                String str2 = "floor5";
                if (this.G.getLastReadPid() > 0 && to8.c()) {
                    PbActivityConfig createHistoryCfg = new PbActivityConfig(this.w.getPageActivity()).createHistoryCfg(this.G.getTid(), String.valueOf(this.G.getLastReadPid()), false, true, "frs_page");
                    if (this.W == 501) {
                        str2 = "frs_tab";
                    } else if (!this.G.isFloor5Video()) {
                        str2 = "frs";
                    }
                    createHistoryCfg.setVideo_source(str2);
                    createHistoryCfg.setFromSmartFrs(this.G.isSmartFrsThread());
                    createHistoryCfg.setSmartFrsPosition(this.G.getSmartFrsPosition());
                    createHistoryCfg.setForumId(valueOf);
                    createHistoryCfg.setFromForumId(str);
                    createHistoryCfg.setStartFrom(this.h);
                    if (view2 == this.l) {
                        createHistoryCfg.setJumpGodReply(true);
                    }
                    this.w.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                    return;
                }
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.w.getPageActivity()).createFromThreadCfg(this.G, this.a0, "frs_page", 18003, true, false, false);
                if (this.W == 501) {
                    str2 = "frs_tab";
                } else if (!this.G.isFloor5Video()) {
                    str2 = "frs";
                }
                createFromThreadCfg.setVideo_source(str2);
                createFromThreadCfg.setFromSmartFrs(this.G.isSmartFrsThread());
                createFromThreadCfg.setSmartFrsPosition(this.G.getSmartFrsPosition());
                createFromThreadCfg.setForumId(valueOf);
                createFromThreadCfg.setFromForumId(str);
                createFromThreadCfg.setStartFrom(this.h);
                if (view2 == this.l) {
                    createFromThreadCfg.setJumpGodReply(true);
                }
                this.w.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
            }
        }
    }

    public final void Q() {
        TbVideoViewContainer tbVideoViewContainer;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            W();
            V();
            if (this.A != null && this.p != null && (tbVideoViewContainer = this.C) != null && tbVideoViewContainer.getControl() != null) {
                if (jq4.c().g() && (threadData = this.G) != null && threadData.getThreadVideoInfo() != null) {
                    this.p.setVisibility(0);
                    this.A.setPlaceHolder(3);
                    this.A.L(this.G.getThreadVideoInfo().thumbnail_url, 10, false);
                    stopPlay();
                    String str = this.G.getThreadVideoInfo().video_url;
                    this.N = str;
                    if (StringUtils.isNull(str)) {
                        Z(true, 4);
                        TiebaStatic.log(new StatisticItem("c12026").param("tid", this.G.getId()));
                    }
                    this.C.getControl().setThreadDataForStatistic(this.G);
                    return;
                }
                this.p.setVisibility(8);
            }
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            ThreadData threadData = this.G;
            if (threadData != null && threadData.getAuthor() != null) {
                this.x.setVisibility(0);
                this.x.setOnClickListener(this);
                Q();
                if (!StringUtils.isNull(this.S) && !StringUtils.isNull(this.U)) {
                    this.G.setSpecUrl(this.S, this.U);
                }
                boolean z = true;
                this.G.parserSpecTitleForFrsAndPb(false, true);
                SpannableStringBuilder span_str = this.G.getSpan_str();
                if (this.G.canShowNaniTail() && !StringUtils.isNull(this.G.getTid())) {
                    String str = ux4.k().q("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.G.getTid();
                    span_str.append((CharSequence) this.G.generateNaniTail(new a(this, 2, str, str)));
                }
                this.z.setOnTouchListener(new pz8(span_str));
                this.z.setText(span_str);
                this.Q.a(this.G);
                c0(this.G);
                this.k.j(this.G);
                if (this.k.getHeaderImg() != null) {
                    if (this.k.getIsSimpleThread()) {
                        this.k.getHeaderImg().setVisibility(8);
                        this.m.setVisibility(8);
                    } else if (this.G.getAuthor() != null && this.G.getAuthor().getPendantData() != null && !StringUtils.isNull(this.G.getAuthor().getPendantData().getImgUrl())) {
                        this.k.getHeaderImg().setVisibility(4);
                        this.m.setVisibility(0);
                        this.m.setData(this.G);
                    } else {
                        this.m.setVisibility(8);
                        this.k.getHeaderImg().setVisibility(0);
                        this.k.getHeaderImg().setData(this.G);
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
                layoutParams.rightMargin = 0;
                this.i.setLayoutParams(layoutParams);
                this.k.setUserAfterClickListener(this.h0);
                b0(G(1));
                this.s.setText(StringHelper.stringForVideoTime(this.G.getThreadVideoInfo().video_duration.intValue() * 1000));
                this.I.setText(String.format(this.w.getResources().getString(R.string.obfuscated_res_0x7f0f0eba), StringHelper.numFormatOverWan(this.G.getThreadVideoInfo().play_count.intValue())));
                this.l.setData(this.G.getTopAgreePost());
                this.l.k();
                if (a26.k(this.G.getId())) {
                    SkinManager.setViewTextColor(this.z, R.color.CAM_X0109, 1);
                    a26.l(this.l.getGodReplyContent(), this.G.getId(), R.color.CAM_X0106, R.color.CAM_X0109);
                } else {
                    SkinManager.setViewTextColor(this.z, R.color.CAM_X0105, 1);
                }
                ThreadData threadData2 = this.G;
                if ((threadData2 == null || threadData2.getThreadVideoInfo() == null || this.G.getThreadVideoInfo().is_vertical.intValue() != 1) ? false : false) {
                    this.v.setVisibility(0);
                } else {
                    this.v.setVisibility(8);
                }
                if ((bh6.f().i() || ah6.h().j()) && this.i.isInFrsAllThread()) {
                    this.V.setVisibility(0);
                    if (!this.G.isMarkToDel() && !this.G.isMarkToMove() && !this.G.isTransportThread()) {
                        this.V.setBackgroundResource(R.color.transparent);
                    } else {
                        SkinManager.setBackgroundColor(this.V, R.color.CAM_X0201);
                    }
                } else {
                    this.V.setVisibility(8);
                }
                m(this.w, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.x.setVisibility(8);
        }
    }

    public final void X() {
        ThreadData threadData;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (threadData = this.G) != null && threadData.getThreadVideoInfo() != null) {
            if (this.G.isFloor5Video()) {
                str = "floor5";
            } else {
                str = "frs";
            }
            if (this.W == 501) {
                str = "frs_tab";
            }
            kb8 kb8Var = new kb8();
            kb8Var.a = str;
            kb8Var.c = this.G.getTid();
            kb8Var.d = this.G.getFid() + "";
            kb8Var.e = TbadkCoreApplication.getCurrentAccount();
            ThreadData threadData2 = this.G;
            kb8Var.f = threadData2.mRecomSource;
            String str2 = threadData2.mRecomAbTag;
            kb8Var.l = str2;
            kb8Var.g = str2;
            kb8Var.h = threadData2.mRecomWeight;
            kb8Var.i = "";
            kb8Var.m = threadData2.getThreadVideoInfo().video_md5;
            za8.e(this.G.getThreadVideoInfo().video_md5, "", "1", kb8Var, this.C.getControl().getPcdnState());
        }
    }

    public void startPlay() {
        ThreadData threadData;
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && !this.M && (threadData = this.G) != null && threadData.getThreadVideoInfo() != null && (tbVideoViewContainer = this.C) != null && tbVideoViewContainer.getControl() != null) {
            this.C.getControl().stopPlayback();
            if (ui5.d() && TbadkCoreApplication.getInst().canAutoPlaySwitch()) {
                Z(true, 2);
                if (StringUtils.isNull(this.N)) {
                    TiebaStatic.log(new StatisticItem("c12619").param("obj_locate", "frs").param("tid", this.G.getId()));
                    this.N = this.G.getThreadVideoInfo().video_url;
                }
                this.M = true;
                this.C.getControl().setVideoPath(this.N, this.G.getId());
                xa8 xa8Var = this.O;
                if (xa8Var != null) {
                    xa8Var.m();
                }
                X();
            }
        }
    }

    public final void Z(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && this.B != null && this.A != null && this.H != null && this.F != null && this.E != null && this.D != null) {
            if (!z && this.L == i2) {
                return;
            }
            this.L = i2;
            hh.a().removeCallbacks(this.e0);
            hh.a().removeCallbacks(this.d0);
            if (i2 == 2) {
                this.B.setVisibility(8);
                this.P.cancel();
                this.A.clearAnimation();
                this.A.setVisibility(0);
                this.H.setVisibility(0);
                this.t.setVisibility(0);
                this.F.g();
                this.E.setVisibility(8);
                this.D.setVisibility(8);
                hh.a().postDelayed(this.e0, 60000L);
            } else if (i2 == 3) {
                this.B.setVisibility(8);
                this.A.startAnimation(this.P);
                this.H.setVisibility(8);
                this.t.setVisibility(8);
                this.F.c();
                this.E.setVisibility(8);
                this.D.setVisibility(8);
                ThreadData threadData = this.G;
                if (threadData != null && threadData.getThreadVideoInfo() != null) {
                    this.G.getThreadVideoInfo().video_length.intValue();
                    this.G.getThreadVideoInfo().video_duration.intValue();
                    this.G.getTid();
                }
            } else if (i2 == 4) {
                this.B.setVisibility(8);
                this.A.startAnimation(this.P);
                this.H.setVisibility(8);
                this.F.b();
                this.E.setVisibility(0);
                this.D.setVisibility(0);
                hh.a().postDelayed(this.d0, 2000L);
            } else {
                this.B.setVisibility(0);
                this.t.setVisibility(0);
                this.P.cancel();
                this.A.clearAnimation();
                this.A.setVisibility(0);
                this.H.setVisibility(0);
                this.F.b();
                this.E.setVisibility(8);
                this.D.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.p16
    public void m(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048605, this, tbPageContext, i2) == null) && this.J != i2) {
            SkinManager.setBackgroundResource(this.x, R.drawable.addresslist_item_bg);
            SkinManager.setImageResource(this.B, R.drawable.obfuscated_res_0x7f08039a);
            SkinManager.setViewTextColor(this.D, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.I, (int) R.color.CAM_X0101);
            SkinManager.setBackgroundColor(this.E, R.color.common_color_10014);
            SkinManager.setBackgroundColor(this.u, R.color.CAM_X0204);
            if (this.D != null) {
                this.D.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f080ada), (Drawable) null, (Drawable) null);
            }
            ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.j;
            if (threadSourceShareAndPraiseLayout != null && threadSourceShareAndPraiseLayout.getVisibility() == 0) {
                this.j.f();
            }
            this.i.onChangeSkinType();
            this.J = i2;
            this.k.h();
            HeadPendantClickableView headPendantClickableView = this.m;
            if (headPendantClickableView != null && headPendantClickableView.getHeadView() != null && (this.m.getHeadView() instanceof TbImageView)) {
                this.m.getHeadView().setPlaceHolder(1);
            }
            this.A.setPlaceHolder(3);
            this.Q.c();
        }
    }
}
