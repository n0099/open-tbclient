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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.afx.AlphaVideo;
import com.baidu.searchbox.afx.callback.OnVideoEndedListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.emoji.ImEmojiUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c67;
import com.repackage.i67;
import com.repackage.j67;
import com.repackage.k67;
import com.repackage.qi;
import com.repackage.rg;
import com.repackage.u57;
import java.util.HashMap;
import java.util.Random;
/* loaded from: classes3.dex */
public class ImEmojiUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 1;
    public static int b = 2;
    public static int c = 3;
    public static int d = 4;
    public static final HashMap<Integer, String> e;
    public static boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ FrameLayout b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ TbRichTextView d;
        public final /* synthetic */ k67 e;
        public final /* synthetic */ int f;
        public final /* synthetic */ k67 g;

        public a(ImageView imageView, FrameLayout frameLayout, Context context, TbRichTextView tbRichTextView, k67 k67Var, int i, k67 k67Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageView, frameLayout, context, tbRichTextView, k67Var, Integer.valueOf(i), k67Var2};
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
            this.e = k67Var;
            this.f = i;
            this.g = k67Var2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.animate().cancel();
                this.b.removeView(this.a);
                Context context = this.c;
                FrameLayout frameLayout = this.b;
                TbRichTextView tbRichTextView = this.d;
                k67 k67Var = this.e;
                ImEmojiUtil.h(context, frameLayout, tbRichTextView, k67Var, this.f, k67Var.a <= this.g.a);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
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

    /* loaded from: classes3.dex */
    public static class b implements j67 {
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

        @Override // com.repackage.j67
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.setText(this.b);
                this.c.cancel();
            }
        }

        @Override // com.repackage.j67
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.setText(new TbRichText(u57.c("#(黑头瞪眼)", 0)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j67 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(long j, long j2, j67 j67Var) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), j67Var};
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
            this.a = j67Var;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a();
                cancel();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
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
        k67 k67Var = (k67) valueAnimator.getAnimatedValue();
        imageView.setX(k67Var.a);
        imageView.setY(k67Var.b);
    }

    public static /* synthetic */ void c(AlphaVideo alphaVideo, PopupWindow popupWindow, j67 j67Var, CountDownTimer countDownTimer) {
        alphaVideo.destroy();
        popupWindow.dismiss();
        if (j67Var != null) {
            countDownTimer.start();
            j67Var.b();
        }
    }

    public static /* synthetic */ void f(AlphaVideo alphaVideo, Vibrator vibrator, PopupWindow popupWindow) {
        alphaVideo.destroy();
        vibrator.cancel();
        popupWindow.dismiss();
        f = false;
    }

    public static /* synthetic */ void g(AlphaVideo alphaVideo, PopupWindow popupWindow) {
        alphaVideo.destroy();
        popupWindow.dismiss();
    }

    public static void h(Context context, FrameLayout frameLayout, TbRichTextView tbRichTextView, k67 k67Var, int i, boolean z) {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{context, frameLayout, tbRichTextView, k67Var, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (i == c || i == d) {
                int i2 = (int) (context.getResources().getDisplayMetrics().widthPixels * 0.8f);
                Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
                vibrator.vibrate(500L);
                if (tbRichTextView != null) {
                    b bVar2 = new b(tbRichTextView, tbRichTextView.getRichText(), vibrator);
                    k67Var.b += tbRichTextView.getTextView().getHeight() / 2.0f;
                    bVar = bVar2;
                } else {
                    bVar = null;
                }
                j(context, frameLayout, k67Var, i, i2, i2, bVar, z);
            }
        }
    }

    public static void i(Context context, FrameLayout frameLayout, TbRichTextView tbRichTextView, int i, k67 k67Var, k67 k67Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, frameLayout, tbRichTextView, Integer.valueOf(i), k67Var, k67Var2}) == null) {
            ValueAnimator ofObject = ValueAnimator.ofObject(new i67(new k67(Math.min(k67Var.a, k67Var2.a) + (Math.abs(k67Var.a - k67Var2.a) / 2.0f), Math.min(k67Var2.b, k67Var.b) - 100.0f)), k67Var, k67Var2);
            final ImageView imageView = new ImageView(context);
            ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.repackage.h67
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
            ofObject.addListener(new a(imageView, frameLayout, context, tbRichTextView, k67Var2, i, k67Var));
            ofObject.setDuration(500L);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds60), qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds60));
            imageView.setX(k67Var.a);
            imageView.setY(k67Var.b);
            WebPManager.setMaskDrawable(imageView, R.drawable.obfuscated_res_0x7f0807cc, WebPManager.ResourceStateType.NORMAL);
            frameLayout.addView(imageView, layoutParams);
            ofObject.start();
        }
    }

    public static void j(Context context, FrameLayout frameLayout, k67 k67Var, int i, int i2, int i3, final j67 j67Var, boolean z) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{context, frameLayout, k67Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), j67Var, Boolean.valueOf(z)}) == null) {
            final PopupWindow popupWindow = new PopupWindow();
            FrameLayout frameLayout2 = new FrameLayout(context);
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            final AlphaVideo alphaVideo = new AlphaVideo(context);
            alphaVideo.setLayoutParams(new FrameLayout.LayoutParams(i2, i3));
            alphaVideo.setSourceAssets(e.get(Integer.valueOf(i)));
            final c cVar = j67Var != null ? new c(1000L, 1000L, j67Var) : null;
            alphaVideo.setOnVideoEndedListener(new OnVideoEndedListener() { // from class: com.repackage.g67
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.searchbox.afx.callback.OnVideoEndedListener
                public final void onVideoEnded() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ImEmojiUtil.c(AlphaVideo.this, popupWindow, j67Var, cVar);
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
            if (i == d) {
                int f2 = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds90);
                i4 = !z ? (context.getResources().getDisplayMetrics().widthPixels - i2) + f2 : -f2;
            } else {
                i4 = i == c ? (int) (k67Var.a - (i2 / 2)) : 0;
            }
            popupWindow.showAtLocation(frameLayout, 0, i4, ((int) k67Var.b) - (i3 / 2));
            alphaVideo.play();
        }
    }

    public static void k(Context context, FrameLayout frameLayout, int i, TbRichTextView tbRichTextView, TbRichTextView tbRichTextView2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{context, frameLayout, Integer.valueOf(i), tbRichTextView, tbRichTextView2}) == null) || context == null || frameLayout == null || tbRichTextView == null || tbRichTextView2 == null || TextUtils.isEmpty(e.get(Integer.valueOf(i)))) {
            return;
        }
        Rect rect = new Rect();
        tbRichTextView.getTextView().getGlobalVisibleRect(rect);
        k67 k67Var = new k67(rect.left, rect.top);
        tbRichTextView2.getTextView().getGlobalVisibleRect(rect);
        i(context, frameLayout, tbRichTextView2, i, k67Var, new k67(rect.left, rect.top));
    }

    public static void l(Context context, View view2, int i, View view3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLIL(65548, null, context, view2, i, view3) == null) || context == null || view2 == null || f) {
            return;
        }
        f = true;
        String str = e.get(Integer.valueOf(i));
        if (TextUtils.isEmpty(str)) {
            return;
        }
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
        alphaVideo.setSourceAssets(str);
        alphaVideo.setOnVideoEndedListener(new OnVideoEndedListener() { // from class: com.repackage.f67
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.searchbox.afx.callback.OnVideoEndedListener
            public final void onVideoEnded() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    ImEmojiUtil.f(AlphaVideo.this, vibrator, popupWindow);
                }
            }
        });
        rg.a().postDelayed(new Runnable() { // from class: com.repackage.e67
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
        alphaVideo.setOnVideoErrorListener(c67.a);
        frameLayout.addView(alphaVideo);
        popupWindow.setContentView(frameLayout);
        popupWindow.setHeight(-2);
        popupWindow.setWidth(-2);
        popupWindow.setClippingEnabled(false);
        popupWindow.showAtLocation(view2, 0, 0, (int) (context.getResources().getDisplayMetrics().heightPixels * 0.1f));
        alphaVideo.play();
    }

    public static void m(Context context, FrameLayout frameLayout, int i, TbRichTextView tbRichTextView, TbRichTextView tbRichTextView2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{context, frameLayout, Integer.valueOf(i), tbRichTextView, tbRichTextView2}) == null) || context == null || frameLayout == null) {
            return;
        }
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

    public static void n(Context context, View view2, int i) {
        float f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65550, null, context, view2, i) == null) || context == null || view2 == null) {
            return;
        }
        String str = e.get(Integer.valueOf(i));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final PopupWindow popupWindow = new PopupWindow();
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        final AlphaVideo alphaVideo = new AlphaVideo(context);
        int i2 = (int) (context.getResources().getDisplayMetrics().widthPixels * 0.8f);
        alphaVideo.setLayoutParams(new FrameLayout.LayoutParams(i2, i2));
        alphaVideo.setSourceAssets(str);
        alphaVideo.setOnVideoEndedListener(new OnVideoEndedListener() { // from class: com.repackage.d67
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
        int i3 = (int) (0.35f * context.getResources().getDisplayMetrics().widthPixels);
        int i4 = (int) (context.getResources().getDisplayMetrics().heightPixels * 0.2f);
        Random random = new Random();
        k67 k67Var = new k67(i3 + random.nextInt((((int) (f2 * 0.3f)) + i3) - i3), i4 + random.nextInt((i4 + i4) - i4));
        int i5 = i2 / 2;
        popupWindow.showAtLocation(view2, 0, (int) (k67Var.a - i5), ((int) k67Var.b) - i5);
        alphaVideo.play();
    }

    public static void o(Context context, FrameLayout frameLayout, int i, TbRichTextView tbRichTextView) {
        Rect rect;
        float f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLIL(65551, null, context, frameLayout, i, tbRichTextView) == null) || context == null || frameLayout == null || tbRichTextView == null || TextUtils.isEmpty(e.get(Integer.valueOf(i)))) {
            return;
        }
        tbRichTextView.getTextView().getGlobalVisibleRect(new Rect());
        k67 k67Var = new k67(rect.left, rect.top);
        int i2 = (int) (0.35f * context.getResources().getDisplayMetrics().widthPixels);
        int i3 = (int) (context.getResources().getDisplayMetrics().heightPixels * 0.2f);
        Random random = new Random();
        i(context, frameLayout, null, i, k67Var, new k67(i2 + random.nextInt((((int) (f2 * 0.3f)) + i2) - i2), i3 + random.nextInt((i3 + i3) - i3)));
    }
}
