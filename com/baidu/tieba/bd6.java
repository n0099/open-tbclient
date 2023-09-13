package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.refresh.LoadAnimStrategy;
import com.baidu.live.business.view.emotion.EmotionStrategy;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bd6 {
    public static /* synthetic */ Interceptable $ic;
    public static bd6 a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? i == 4 ? "dark" : "day" : (String) invokeI.objValue;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final bd6 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-922592809, "Lcom/baidu/tieba/bd6$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-922592809, "Lcom/baidu/tieba/bd6$b;");
                    return;
                }
            }
            a = new bd6(null);
        }
    }

    public bd6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static bd6 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                a = b.a;
            }
            return a;
        }
        return (bd6) invokeV.objValue;
    }

    public /* synthetic */ bd6(a aVar) {
        this();
    }

    public void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            if (!LiveFeedPageSdk.getInstance().isInit()) {
                LoadAnimStrategy.getInstance().pullDownLottieResId = R.raw.lottie_common_pull_refresh;
                LoadAnimStrategy.getInstance().pullDownLottieResId1 = R.raw.lottie_common_pull_refresh_1;
                LoadAnimStrategy.getInstance().pullDownLottieResId2 = R.raw.lottie_common_pull_refresh_2;
                LoadAnimStrategy.getInstance().pullDownLottieResId3 = R.raw.lottie_common_pull_refresh_1;
                LoadAnimStrategy.getInstance().pullEndFrame = 15;
                LoadAnimStrategy.getInstance().loopStartFrame = 15;
                LoadAnimStrategy.getInstance().loopEndFrame = 30;
                LoadAnimStrategy.getInstance().lottieTotalFrame = 30;
                LoadAnimStrategy.getInstance().setLoadMoreAnimStrategy("live_feed_page_load_more.json", "live_feed_page_load_more.json", "live_feed_page_load_more.json", "live_feed_page_load_more.json");
                LoadAnimStrategy.getInstance().setLoadingLottieResId(R.raw.lottie_full_screen_refresh, R.raw.lottie_full_screen_refresh_1, R.raw.lottie_full_screen_refresh_2, R.raw.lottie_full_screen_refresh_1, "", 67.0f, 67.0f);
                EmotionStrategy.getInstance().setEmptyImageRes(R.drawable.new_pic_emotion_05, R.drawable.new_pic_emotion_05, R.drawable.new_pic_emotion_05, R.drawable.new_pic_emotion_05, 125.0f, 125.0f);
                EmotionStrategy.getInstance().setErrorImageRes(R.drawable.new_pic_emotion_05, R.drawable.new_pic_emotion_05, R.drawable.new_pic_emotion_05, R.drawable.new_pic_emotion_05, 125.0f, 125.0f);
                EmotionStrategy.getInstance().setNetworkImageRes(R.drawable.new_pic_emotion_08, R.drawable.new_pic_emotion_08, R.drawable.new_pic_emotion_08, R.drawable.new_pic_emotion_08, 125.0f, 125.0f);
                EmotionStrategy.getInstance().setPlaceHolderRes(R.drawable.obfuscated_res_0x7f080f44, R.drawable.obfuscated_res_0x7f080f45, R.drawable.obfuscated_res_0x7f080f43, R.drawable.obfuscated_res_0x7f080f44);
                LiveFeedPageSdk.getInstance().initNetWork(new w79());
                LiveFeedPageSdk.getInstance().initHostInfo("tieba", b(TbadkCoreApplication.getInst().getSkinType()));
                LiveFeedPageSdk.getInstance().initInvoke(new cd6());
                LiveFeedPageSdk.getInstance().setInit();
            }
            LiveFeedPageSdk.getInstance().setContext(context);
            if (LiveFeedPageSdk.getInstance().getInvoker() != null && !TextUtils.isEmpty(LiveFeedPageSdk.getInstance().getInvoker().getUIMode())) {
                LiveFeedPageSdk.getInstance().updateUiMode(LiveFeedPageSdk.getInstance().getInvoker().getUIMode());
            }
        }
    }
}
