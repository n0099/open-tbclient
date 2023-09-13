package com.baidu.tieba;

import android.animation.Animator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tieba.ph3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b72 extends u62<LottieAnimationView, c72> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public String i;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.u62
    /* renamed from: Y */
    public void R(@NonNull LottieAnimationView lottieAnimationView, @NonNull c72 c72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, lottieAnimationView, c72Var) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c72 a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ LottieAnimationView c;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        public a(b72 b72Var, c72 c72Var, JSONObject jSONObject, LottieAnimationView lottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b72Var, c72Var, jSONObject, lottieAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c72Var;
            this.b = jSONObject;
            this.c = lottieAnimationView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                c72 c72Var = this.a;
                oq3.d(c72Var.c, c72Var.b, "animateview", "ended", this.b);
                h82.i("Component-AnimationView", "progress: " + this.c.getProgress());
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                h82.i("Component-AnimationView", "onAnimationRepeat ");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b72(@Nullable Context context, @NonNull c72 c72Var, @NonNull String str) {
        super(context, c72Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, c72Var, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (v62) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = str;
    }

    public static void Z(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("json", str);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str2);
            } catch (Exception e) {
                if (w62.h) {
                    e.printStackTrace();
                }
            }
            String jSONObject2 = jSONObject.toString();
            if (w62.h && TextUtils.isEmpty(jSONObject2)) {
                Log.d("Component-AnimationView", "reportLottieAnimationCrash: empty");
                return;
            }
            if (w62.h) {
                Log.d("Component-AnimationView", "reportLottieAnimationCrash: " + jSONObject2);
            }
            ph3.b bVar = new ph3.b(10009);
            bVar.i(jSONObject2);
            bVar.h(hb3.g0());
            bVar.m();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.w62
    @NonNull
    /* renamed from: T */
    public LottieAnimationView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            return new LottieAnimationView(context);
        }
        return (LottieAnimationView) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.u62
    /* renamed from: V */
    public void O(@NonNull LottieAnimationView lottieAnimationView, @NonNull c72 c72Var, @NonNull z72 z72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, lottieAnimationView, c72Var, z72Var) == null) {
            super.C(lottieAnimationView, c72Var, z72Var);
            W(lottieAnimationView, c72Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.u62
    /* renamed from: X */
    public void Q(@NonNull LottieAnimationView lottieAnimationView, @NonNull c72 c72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, lottieAnimationView, c72Var) == null) {
            if (w62.h) {
                Log.d("Component-AnimationView", "renderBackground");
            }
            lottieAnimationView.setColorFilter(new PorterDuffColorFilter(c72Var.k, PorterDuff.Mode.ADD));
        }
    }

    public final void S(@NonNull LottieAnimationView lottieAnimationView, @NonNull c72 c72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, lottieAnimationView, c72Var) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, c72Var.c);
                jSONObject.put("vtype", "ended");
                jSONObject2.putOpt("animationViewId", c72Var.b);
                jSONObject.put("data", jSONObject2.toString());
            } catch (JSONException e) {
                if (w62.h) {
                    e.printStackTrace();
                }
            }
            lottieAnimationView.addAnimatorListener(new a(this, c72Var, jSONObject, lottieAnimationView));
        }
    }

    public final void W(@NonNull LottieAnimationView lottieAnimationView, @NonNull c72 c72Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, lottieAnimationView, c72Var) != null) || !t()) {
            return;
        }
        if (w62.h) {
            Log.d("Component-AnimationView", "renderAction");
        }
        String str = c72Var.w;
        if (TextUtils.equals(str, "play")) {
            lottieAnimationView.resumeAnimation();
        } else if (TextUtils.equals(str, DownloadStatisticConstants.UBC_TYPE_PAUSE)) {
            lottieAnimationView.pauseAnimation();
        } else if (TextUtils.equals(str, "stop")) {
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setProgress(0.0f);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.w62
    /* renamed from: U */
    public void A(@NonNull LottieAnimationView lottieAnimationView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, lottieAnimationView) == null) {
            super.A(lottieAnimationView);
            try {
                c72 c72Var = (c72) n();
                lottieAnimationView.loop(c72Var.u);
                lottieAnimationView.enableMergePathsForKitKatAndAbove(true);
                lottieAnimationView.setImageAssetDelegate(new a72(c72Var.t));
                lottieAnimationView.setAnimationFromJson(this.i, c72Var.b);
                if (c72Var.v) {
                    lottieAnimationView.playAnimation();
                }
                if (!c72Var.u) {
                    S(lottieAnimationView, c72Var);
                }
            } catch (Exception unused) {
                Z(this.i, hb3.g0());
            }
        }
    }
}
