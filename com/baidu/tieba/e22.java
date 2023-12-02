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
import com.baidu.tieba.sc3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class e22 extends y12<LottieAnimationView, f22> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public String i;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.y12
    /* renamed from: a0 */
    public void T(@NonNull LottieAnimationView lottieAnimationView, @NonNull f22 f22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, lottieAnimationView, f22Var) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f22 a;
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

        public a(e22 e22Var, f22 f22Var, JSONObject jSONObject, LottieAnimationView lottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e22Var, f22Var, jSONObject, lottieAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f22Var;
            this.b = jSONObject;
            this.c = lottieAnimationView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                f22 f22Var = this.a;
                rl3.d(f22Var.c, f22Var.b, "animateview", "ended", this.b);
                k32.i("Component-AnimationView", "progress: " + this.c.getProgress());
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                k32.i("Component-AnimationView", "onAnimationRepeat ");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e22(@Nullable Context context, @NonNull f22 f22Var, @NonNull String str) {
        super(context, f22Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, f22Var, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (z12) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = str;
    }

    public static void b0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("json", str);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str2);
            } catch (Exception e) {
                if (a22.h) {
                    e.printStackTrace();
                }
            }
            String jSONObject2 = jSONObject.toString();
            if (a22.h && TextUtils.isEmpty(jSONObject2)) {
                Log.d("Component-AnimationView", "reportLottieAnimationCrash: empty");
                return;
            }
            if (a22.h) {
                Log.d("Component-AnimationView", "reportLottieAnimationCrash: " + jSONObject2);
            }
            sc3.b bVar = new sc3.b(10009);
            bVar.i(jSONObject2);
            bVar.h(k63.h0());
            bVar.m();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.a22
    @NonNull
    /* renamed from: V */
    public LottieAnimationView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            return new LottieAnimationView(context);
        }
        return (LottieAnimationView) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.y12
    /* renamed from: X */
    public void Q(@NonNull LottieAnimationView lottieAnimationView, @NonNull f22 f22Var, @NonNull c32 c32Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, lottieAnimationView, f22Var, c32Var) == null) {
            super.D(lottieAnimationView, f22Var, c32Var);
            Y(lottieAnimationView, f22Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.y12
    /* renamed from: Z */
    public void S(@NonNull LottieAnimationView lottieAnimationView, @NonNull f22 f22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, lottieAnimationView, f22Var) == null) {
            if (a22.h) {
                Log.d("Component-AnimationView", "renderBackground");
            }
            lottieAnimationView.setColorFilter(new PorterDuffColorFilter(f22Var.k, PorterDuff.Mode.ADD));
        }
    }

    public final void U(@NonNull LottieAnimationView lottieAnimationView, @NonNull f22 f22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, lottieAnimationView, f22Var) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, f22Var.c);
                jSONObject.put("vtype", "ended");
                jSONObject2.putOpt("animationViewId", f22Var.b);
                jSONObject.put("data", jSONObject2.toString());
            } catch (JSONException e) {
                if (a22.h) {
                    e.printStackTrace();
                }
            }
            lottieAnimationView.addAnimatorListener(new a(this, f22Var, jSONObject, lottieAnimationView));
        }
    }

    public final void Y(@NonNull LottieAnimationView lottieAnimationView, @NonNull f22 f22Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, lottieAnimationView, f22Var) != null) || !t()) {
            return;
        }
        if (a22.h) {
            Log.d("Component-AnimationView", "renderAction");
        }
        String str = f22Var.w;
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
    @Override // com.baidu.tieba.a22
    /* renamed from: W */
    public void B(@NonNull LottieAnimationView lottieAnimationView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, lottieAnimationView) == null) {
            super.B(lottieAnimationView);
            try {
                f22 f22Var = (f22) n();
                lottieAnimationView.loop(f22Var.u);
                lottieAnimationView.enableMergePathsForKitKatAndAbove(true);
                lottieAnimationView.setImageAssetDelegate(new d22(f22Var.t));
                lottieAnimationView.setAnimationFromJson(this.i, f22Var.b);
                if (f22Var.v) {
                    lottieAnimationView.playAnimation();
                }
                if (!f22Var.u) {
                    U(lottieAnimationView, f22Var);
                }
            } catch (Exception unused) {
                b0(this.i, k63.h0());
            }
        }
    }
}
