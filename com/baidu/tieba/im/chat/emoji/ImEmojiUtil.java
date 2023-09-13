package com.baidu.tieba.im.chat.emoji;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.afx.AlphaVideo;
import com.baidu.searchbox.afx.callback.ErrorInfo;
import com.baidu.searchbox.afx.callback.OnVideoEndedListener;
import com.baidu.searchbox.afx.callback.OnVideoErrorListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.ge8;
import com.baidu.tieba.he8;
import com.baidu.tieba.ie8;
import com.baidu.tieba.im.chat.emoji.ImEmojiUtil;
import com.baidu.tieba.rd8;
import com.baidu.tieba.vl;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Random;
/* loaded from: classes6.dex */
public class ImEmojiUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 1;
    public static int b = 2;
    public static int c = 3;
    public static int d = 4;
    public static final HashMap<Integer, String> e;
    public static boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ FrameLayout b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ TbRichTextView d;
        public final /* synthetic */ ie8 e;
        public final /* synthetic */ int f;
        public final /* synthetic */ ie8 g;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        public a(ImageView imageView, FrameLayout frameLayout, Context context, TbRichTextView tbRichTextView, ie8 ie8Var, int i, ie8 ie8Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageView, frameLayout, context, tbRichTextView, ie8Var, Integer.valueOf(i), ie8Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageView;
            this.b = frameLayout;
            this.c = context;
            this.d = tbRichTextView;
            this.e = ie8Var;
            this.f = i;
            this.g = ie8Var2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.animate().cancel();
                this.b.removeView(this.a);
                Context context = this.c;
                FrameLayout frameLayout = this.b;
                TbRichTextView tbRichTextView = this.d;
                ie8 ie8Var = this.e;
                int i = this.f;
                if (ie8Var.a <= this.g.a) {
                    z = true;
                } else {
                    z = false;
                }
                ImEmojiUtil.h(context, frameLayout, tbRichTextView, ie8Var, i, z);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                this.a.animate().setDuration(500L).rotationBy(-1080.0f).start();
                this.a.animate().setDuration(500L).scaleY(2.0f).start();
                this.a.animate().setDuration(500L).scaleX(2.0f).start();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements he8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView a;
        public final /* synthetic */ TbRichText b;
        public final /* synthetic */ Vibrator c;

        public b(TbRichTextView tbRichTextView, TbRichText tbRichText, Vibrator vibrator) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView, tbRichText, vibrator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbRichTextView;
            this.b = tbRichText;
            this.c = vibrator;
        }

        @Override // com.baidu.tieba.he8
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.setText(this.b);
                this.c.cancel();
            }
        }

        @Override // com.baidu.tieba.he8
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.setText(new TbRichText(rd8.c("#(黑头瞪眼)", 0)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ he8 a;

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(long j, long j2, he8 he8Var) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), he8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = he8Var;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a();
                cancel();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1427343322, "Lcom/baidu/tieba/im/chat/emoji/ImEmojiUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1427343322, "Lcom/baidu/tieba/im/chat/emoji/ImEmojiUtil;");
                return;
            }
        }
        e = new HashMap<Integer, String>() { // from class: com.baidu.tieba.im.chat.emoji.ImEmojiUtil.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                put(Integer.valueOf(ImEmojiUtil.a), "huaji_afx.mp4");
                put(Integer.valueOf(ImEmojiUtil.b), "champagne_afx.mp4");
                put(Integer.valueOf(ImEmojiUtil.c), "boom_afx.mp4");
                put(Integer.valueOf(ImEmojiUtil.d), "black_face.mp4");
            }
        };
    }

    public static /* synthetic */ void b(ImageView imageView, ValueAnimator valueAnimator) {
        ie8 ie8Var = (ie8) valueAnimator.getAnimatedValue();
        imageView.setX(ie8Var.a);
        imageView.setY(ie8Var.b);
    }

    public static /* synthetic */ void g(AlphaVideo alphaVideo, PopupWindow popupWindow) {
        alphaVideo.destroy();
        popupWindow.dismiss();
    }

    public static /* synthetic */ void c(AlphaVideo alphaVideo, PopupWindow popupWindow, he8 he8Var, CountDownTimer countDownTimer) {
        alphaVideo.destroy();
        popupWindow.dismiss();
        if (he8Var != null) {
            countDownTimer.start();
            he8Var.b();
        }
    }

    public static /* synthetic */ void d(AlphaVideo alphaVideo, Vibrator vibrator, PopupWindow popupWindow) {
        alphaVideo.destroy();
        vibrator.cancel();
        popupWindow.dismiss();
        f = false;
    }

    public static /* synthetic */ boolean f(ErrorInfo errorInfo) {
        f = false;
        return false;
    }

    public static void h(Context context, FrameLayout frameLayout, TbRichTextView tbRichTextView, ie8 ie8Var, int i, boolean z) {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{context, frameLayout, tbRichTextView, ie8Var, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (i != c && i != d) {
                return;
            }
            int i2 = (int) (context.getResources().getDisplayMetrics().widthPixels * 0.8f);
            Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
            vibrator.vibrate(500L);
            if (tbRichTextView != null) {
                b bVar2 = new b(tbRichTextView, tbRichTextView.getRichText(), vibrator);
                ie8Var.b += tbRichTextView.getTextView().getHeight() / 2.0f;
                bVar = bVar2;
            } else {
                bVar = null;
            }
            j(context, frameLayout, ie8Var, i, i2, i2, bVar, z);
        }
    }

    public static void i(Context context, FrameLayout frameLayout, TbRichTextView tbRichTextView, int i, ie8 ie8Var, ie8 ie8Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, frameLayout, tbRichTextView, Integer.valueOf(i), ie8Var, ie8Var2}) == null) {
            ValueAnimator ofObject = ValueAnimator.ofObject(new ge8(new ie8(Math.min(ie8Var.a, ie8Var2.a) + (Math.abs(ie8Var.a - ie8Var2.a) / 2.0f), Math.min(ie8Var2.b, ie8Var.b) - 100.0f)), ie8Var, ie8Var2);
            final ImageView imageView = new ImageView(context);
            ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ce8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        ImEmojiUtil.b(imageView, valueAnimator);
                    }
                }
            });
            ofObject.addListener(new a(imageView, frameLayout, context, tbRichTextView, ie8Var2, i, ie8Var));
            ofObject.setDuration(500L);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds60), BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds60));
            imageView.setX(ie8Var.a);
            imageView.setY(ie8Var.b);
            WebPManager.setMaskDrawable(imageView, R.drawable.icon_mask_emoji_firecrackers, WebPManager.ResourceStateType.NORMAL);
            frameLayout.addView(imageView, layoutParams);
            ofObject.start();
        }
    }

    public static void j(Context context, FrameLayout frameLayout, ie8 ie8Var, int i, int i2, int i3, final he8 he8Var, boolean z) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{context, frameLayout, ie8Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), he8Var, Boolean.valueOf(z)}) == null) {
            String str = e.get(Integer.valueOf(i));
            if (!TextUtils.isEmpty(str) && BdBaseApplication.getInst().getResHashMap().containsKey(str)) {
                final PopupWindow popupWindow = new PopupWindow();
                FrameLayout frameLayout2 = new FrameLayout(context);
                frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                final AlphaVideo alphaVideo = new AlphaVideo(context);
                alphaVideo.setLayoutParams(new FrameLayout.LayoutParams(i2, i3));
                alphaVideo.setSourcePath(vl.b(str));
                final c cVar = null;
                if (he8Var != null) {
                    cVar = new c(1000L, 1000L, he8Var);
                }
                alphaVideo.setOnVideoEndedListener(new OnVideoEndedListener() { // from class: com.baidu.tieba.ae8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.searchbox.afx.callback.OnVideoEndedListener
                    public final void onVideoEnded() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ImEmojiUtil.c(AlphaVideo.this, popupWindow, he8Var, cVar);
                        }
                    }
                });
                if (!z) {
                    alphaVideo.setRotationY(-180.0f);
                }
                frameLayout2.addView(alphaVideo);
                popupWindow.setContentView(frameLayout2);
                popupWindow.setHeight(-2);
                popupWindow.setWidth(-2);
                popupWindow.setClippingEnabled(false);
                GreyUtil.grey(popupWindow);
                if (i == d) {
                    int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
                    if (!z) {
                        i4 = (context.getResources().getDisplayMetrics().widthPixels - i2) + dimens;
                    } else {
                        i4 = -dimens;
                    }
                } else if (i == c) {
                    i4 = (int) (ie8Var.a - (i2 / 2));
                } else {
                    i4 = 0;
                }
                popupWindow.showAtLocation(frameLayout, 0, i4, ((int) ie8Var.b) - (i3 / 2));
                alphaVideo.play();
            }
        }
    }

    public static void k(Context context, FrameLayout frameLayout, int i, TbRichTextView tbRichTextView, TbRichTextView tbRichTextView2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{context, frameLayout, Integer.valueOf(i), tbRichTextView, tbRichTextView2}) == null) && context != null && frameLayout != null && tbRichTextView != null && tbRichTextView2 != null) {
            String str = e.get(Integer.valueOf(i));
            if (!TextUtils.isEmpty(str) && BdBaseApplication.getInst().getResHashMap().containsKey(str)) {
                Rect rect = new Rect();
                tbRichTextView.getTextView().getGlobalVisibleRect(rect);
                ie8 ie8Var = new ie8(rect.left, rect.top);
                tbRichTextView2.getTextView().getGlobalVisibleRect(rect);
                i(context, frameLayout, tbRichTextView2, i, ie8Var, new ie8(rect.left, rect.top));
            }
        }
    }

    public static void m(Context context, FrameLayout frameLayout, int i, TbRichTextView tbRichTextView, TbRichTextView tbRichTextView2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{context, frameLayout, Integer.valueOf(i), tbRichTextView, tbRichTextView2}) == null) && context != null && frameLayout != null) {
            int i2 = 0;
            if (d == i) {
                k(context, frameLayout, i, tbRichTextView, tbRichTextView2);
                i2 = 4;
            } else if (c == i) {
                o(context, frameLayout, i, tbRichTextView);
                i2 = 3;
            } else if (b == i) {
                l(context, frameLayout, i, tbRichTextView);
                i2 = 2;
            } else if (a == i) {
                n(context, frameLayout, i);
                i2 = 1;
            }
            if (i2 != 0) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_SEND_EASTER_EGG_EMOJI);
                statisticItem.addParam("obj_param1", i2);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public static void l(Context context, View view2, int i, View view3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLIL(65548, null, context, view2, i, view3) == null) && context != null && view2 != null) {
            String str = e.get(Integer.valueOf(i));
            if (TextUtils.isEmpty(str) || !BdBaseApplication.getInst().getResHashMap().containsKey(str) || f) {
                return;
            }
            f = true;
            final Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
            final PopupWindow popupWindow = new PopupWindow();
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            final AlphaVideo alphaVideo = new AlphaVideo(context);
            int i2 = context.getResources().getDisplayMetrics().widthPixels;
            alphaVideo.setLayoutParams(new FrameLayout.LayoutParams(i2, i2));
            Rect rect = new Rect();
            view3.getGlobalVisibleRect(rect);
            if (rect.left <= i2 / 2) {
                alphaVideo.setRotationY(-180.0f);
            }
            alphaVideo.setSourcePath(vl.b(str));
            alphaVideo.setOnVideoEndedListener(new OnVideoEndedListener() { // from class: com.baidu.tieba.ee8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.searchbox.afx.callback.OnVideoEndedListener
                public final void onVideoEnded() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ImEmojiUtil.d(AlphaVideo.this, vibrator, popupWindow);
                    }
                }
            });
            SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.be8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        vibrator.vibrate(100L);
                    }
                }
            }, 560L);
            alphaVideo.setOnVideoErrorListener(new OnVideoErrorListener() { // from class: com.baidu.tieba.de8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.searchbox.afx.callback.OnVideoErrorListener
                public final boolean onError(ErrorInfo errorInfo) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, errorInfo)) == null) ? ImEmojiUtil.f(errorInfo) : invokeL.booleanValue;
                }
            });
            frameLayout.addView(alphaVideo);
            popupWindow.setContentView(frameLayout);
            popupWindow.setHeight(-2);
            popupWindow.setWidth(-2);
            popupWindow.setClippingEnabled(false);
            GreyUtil.grey(popupWindow);
            popupWindow.showAtLocation(view2, 0, 0, (int) (context.getResources().getDisplayMetrics().heightPixels * 0.1f));
            alphaVideo.play();
        }
    }

    public static void n(Context context, View view2, int i) {
        float f2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65550, null, context, view2, i) == null) && context != null && view2 != null) {
            String str = e.get(Integer.valueOf(i));
            if (!TextUtils.isEmpty(str) && BdBaseApplication.getInst().getResHashMap().containsKey(str)) {
                final PopupWindow popupWindow = new PopupWindow();
                FrameLayout frameLayout = new FrameLayout(context);
                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                final AlphaVideo alphaVideo = new AlphaVideo(context);
                int i2 = (int) (context.getResources().getDisplayMetrics().widthPixels * 0.8f);
                alphaVideo.setLayoutParams(new FrameLayout.LayoutParams(i2, i2));
                alphaVideo.setSourcePath(vl.b(str));
                alphaVideo.setOnVideoEndedListener(new OnVideoEndedListener() { // from class: com.baidu.tieba.fe8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.searchbox.afx.callback.OnVideoEndedListener
                    public final void onVideoEnded() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ImEmojiUtil.g(AlphaVideo.this, popupWindow);
                        }
                    }
                });
                frameLayout.addView(alphaVideo);
                popupWindow.setContentView(frameLayout);
                popupWindow.setHeight(-2);
                popupWindow.setWidth(-2);
                popupWindow.setClippingEnabled(false);
                GreyUtil.grey(popupWindow);
                int i3 = (int) (0.35f * context.getResources().getDisplayMetrics().widthPixels);
                int i4 = (int) (context.getResources().getDisplayMetrics().heightPixels * 0.2f);
                Random random = new Random();
                ie8 ie8Var = new ie8(i3 + random.nextInt((((int) (f2 * 0.3f)) + i3) - i3), i4 + random.nextInt((i4 + i4) - i4));
                int i5 = i2 / 2;
                popupWindow.showAtLocation(view2, 0, (int) (ie8Var.a - i5), ((int) ie8Var.b) - i5);
                alphaVideo.play();
            }
        }
    }

    public static void o(Context context, FrameLayout frameLayout, int i, TbRichTextView tbRichTextView) {
        Rect rect;
        float f2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLIL(65551, null, context, frameLayout, i, tbRichTextView) == null) && context != null && frameLayout != null && tbRichTextView != null) {
            String str = e.get(Integer.valueOf(i));
            if (!TextUtils.isEmpty(str) && BdBaseApplication.getInst().getResHashMap().containsKey(str)) {
                tbRichTextView.getTextView().getGlobalVisibleRect(new Rect());
                ie8 ie8Var = new ie8(rect.left, rect.top);
                int i2 = (int) (0.35f * context.getResources().getDisplayMetrics().widthPixels);
                int i3 = (int) (context.getResources().getDisplayMetrics().heightPixels * 0.2f);
                Random random = new Random();
                i(context, frameLayout, null, i, ie8Var, new ie8(i2 + random.nextInt((((int) (f2 * 0.3f)) + i2) - i2), i3 + random.nextInt((i3 + i3) - i3)));
            }
        }
    }
}
