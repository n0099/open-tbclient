package com.baidu.tbadk.widget.lottie;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.permissionhelper.context.ContextCompat;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ad;
import com.baidu.tieba.kv5;
import com.baidu.tieba.lv5;
import com.baidu.tieba.mv5;
import com.baidu.tieba.wc;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class TBLottieAnimationView extends LottieAnimationView implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DIR_ANIMATION = "animation";
    public static final String INTERNEL_STORAGE_DIRECTORY;
    public static final String JSON_FILE = "data.json";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean ignoreComposition;
    public boolean isFirstLoadInternal;
    public boolean isResume;
    public boolean isSettingForPlay;
    public Lifecycle lifecycle;
    public boolean lifecycleEnable;
    public boolean mDisableRestoreInstanceState;
    public mv5.a mLoadCallback;
    public mv5 mLoader;
    public String mUrl;

    /* loaded from: classes5.dex */
    public class a implements mv5.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBLottieAnimationView a;

        public a(TBLottieAnimationView tBLottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBLottieAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBLottieAnimationView;
        }

        @Override // com.baidu.tieba.mv5.a
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) && z && !ad.isEmpty(str)) {
                this.a.setAnimationDir(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements LottieListener<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBLottieAnimationView a;

        public b(TBLottieAnimationView tBLottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBLottieAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBLottieAnimationView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                BdLog.e(th);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements LottieListener<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBLottieAnimationView a;

        public c(TBLottieAnimationView tBLottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBLottieAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBLottieAnimationView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.a.setVisibility(8);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements LottieListener<LottieComposition> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ TBLottieAnimationView b;

        public d(TBLottieAnimationView tBLottieAnimationView, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBLottieAnimationView, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tBLottieAnimationView;
            this.a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(LottieComposition lottieComposition) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, lottieComposition) != null) || lottieComposition == null) {
                return;
            }
            try {
                TBLottieAnimationView.super.setComposition(lottieComposition);
                this.b.ignoreComposition = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (this.a) {
                this.b.playAnimation();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBLottieAnimationView a;

        public e(TBLottieAnimationView tBLottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBLottieAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBLottieAnimationView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.playAnimation();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1543336711, "Lcom/baidu/tbadk/widget/lottie/TBLottieAnimationView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1543336711, "Lcom/baidu/tbadk/widget/lottie/TBLottieAnimationView;");
                return;
            }
        }
        INTERNEL_STORAGE_DIRECTORY = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();
    }

    private boolean checkPermission() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (ContextCompat.checkPermissionGranted(getContext(), "android.permission.WRITE_EXTERNAL_STORAGE")) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            setFailureListener(new b(this));
        }
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void cancelAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.cancelAnimation();
            this.isSettingForPlay = false;
        }
    }

    public void disableRestoreInstanceStateJustOnce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mDisableRestoreInstanceState = true;
        }
    }

    public boolean getFristLoadInternal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.isFirstLoadInternal;
        }
        return invokeV.booleanValue;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Lifecycle lifecycle;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (lifecycle = this.lifecycle) != null) {
            lifecycle.removeObserver(this);
            this.lifecycle = null;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || !this.lifecycleEnable) {
            return;
        }
        pauseAnimation();
        this.isResume = false;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || !this.lifecycleEnable) {
            return;
        }
        this.isResume = true;
        playAnimation();
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void pauseAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.pauseAnimation();
            this.isSettingForPlay = false;
        }
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void playAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.lifecycleEnable && !this.isResume) {
                return;
            }
            super.playAnimation();
            this.isSettingForPlay = true;
        }
    }

    public void postPlayAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            post(new e(this));
        }
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void resumeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.resumeAnimation();
            this.isSettingForPlay = true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TBLottieAnimationView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isSettingForPlay = false;
        this.isFirstLoadInternal = false;
        this.mDisableRestoreInstanceState = false;
        this.ignoreComposition = false;
        this.isResume = true;
        this.mLoadCallback = new a(this);
        init();
    }

    public static boolean checkInternalTempDir(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            File file = new File(str);
            if (file.exists()) {
                return true;
            }
            try {
                return file.mkdirs();
            } catch (Exception e2) {
                TiebaStatic.file(e2, ad.join("FileHelper", ".", "CheckTempDir", " ", str));
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TBLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.isSettingForPlay = false;
        this.isFirstLoadInternal = false;
        this.mDisableRestoreInstanceState = false;
        this.ignoreComposition = false;
        this.isResume = true;
        this.mLoadCallback = new a(this);
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TBLottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.isSettingForPlay = false;
        this.isFirstLoadInternal = false;
        this.mDisableRestoreInstanceState = false;
        this.ignoreComposition = false;
        this.isResume = true;
        this.mLoadCallback = new a(this);
        init();
    }

    private void dealImageAsset(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65544, this, str) != null) || ad.isEmpty(str)) {
            return;
        }
        lv5 lv5Var = new lv5();
        lv5Var.d(str);
        lv5Var.c(getFristLoadInternal());
        setImageAssetDelegate(lv5Var);
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, parcelable) == null) {
            if (!this.mDisableRestoreInstanceState) {
                super.onRestoreInstanceState(parcelable);
            }
            this.mDisableRestoreInstanceState = false;
        }
    }

    public void setAnimationDir(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, str) != null) || ad.isEmpty(str)) {
            return;
        }
        dealImageAsset(str);
        dealJsonFile(str);
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void setComposition(@NonNull LottieComposition lottieComposition) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, lottieComposition) != null) || this.ignoreComposition) {
            return;
        }
        try {
            super.setComposition(lottieComposition);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (this.isSettingForPlay) {
            playAnimation();
        }
    }

    public void setFirstLoadInternal(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.isFirstLoadInternal = z;
        }
    }

    public void setLifecycleEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.lifecycleEnable = z;
            Lifecycle lifecycle = this.lifecycle;
            if (lifecycle != null) {
                lifecycle.removeObserver(this);
            }
            if (z) {
                Lifecycle a2 = kv5.a(getContext());
                this.lifecycle = a2;
                if (a2 != null) {
                    a2.addObserver(this);
                }
            }
        }
    }

    private void dealJsonFile(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65545, this, str) != null) || ad.isEmpty(str)) {
            return;
        }
        boolean z = this.isSettingForPlay;
        cancelAnimation();
        InputStream animationInputStream = getAnimationInputStream(str, JSON_FILE);
        if (animationInputStream == null) {
            setVisibility(8);
        } else {
            LottieCompositionFactory.fromJsonInputStream(animationInputStream, str).addListener(new d(this, z)).addFailureListener(new c(this));
        }
    }

    public void setAnimationUrl(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, str) == null) && !ad.isEmpty(str) && !str.equals(this.mUrl)) {
            this.mUrl = str;
            mv5 mv5Var = new mv5(getAnimationPath(), str, this.mLoadCallback);
            this.mLoader = mv5Var;
            mv5Var.execute(new Void[0]);
        }
    }

    public static InputStream getAnimationInputStream(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, str2)) == null) {
            String animationPath = getAnimationPath();
            if (!checkInternalTempDir(animationPath)) {
                return null;
            }
            String str3 = animationPath + str + "/";
            if (!new File(str3).exists()) {
                return null;
            }
            File file = new File(str3 + str2);
            if (!file.exists() || file.length() <= 0) {
                return null;
            }
            return wc.v(file);
        }
        return (InputStream) invokeLL.objValue;
    }

    public static String getAnimationPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return INTERNEL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/animation/";
        }
        return (String) invokeV.objValue;
    }
}
