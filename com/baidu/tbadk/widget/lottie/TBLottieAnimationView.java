package com.baidu.tbadk.widget.lottie;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.f;
import c.a.e.e.p.k;
import c.a.q0.f1.k.b;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class TBLottieAnimationView extends LottieAnimationView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String INTERNEL_STORAGE_DIRECTORY;
    public static final String JSON_FILE = "data.json";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.f1.k.b f48749e;

    /* renamed from: f  reason: collision with root package name */
    public String f48750f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48751g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f48752h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f48753i;

    /* renamed from: j  reason: collision with root package name */
    public b.a f48754j;

    /* loaded from: classes6.dex */
    public class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TBLottieAnimationView f48755a;

        public a(TBLottieAnimationView tBLottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBLottieAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48755a = tBLottieAnimationView;
        }

        @Override // c.a.q0.f1.k.b.a
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) && z && !k.isEmpty(str)) {
                this.f48755a.setAnimationDir(str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements LottieListener<LottieComposition> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f48756a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TBLottieAnimationView f48757b;

        public b(TBLottieAnimationView tBLottieAnimationView, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBLottieAnimationView, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48757b = tBLottieAnimationView;
            this.f48756a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(LottieComposition lottieComposition) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, lottieComposition) == null) || lottieComposition == null) {
                return;
            }
            this.f48757b.setComposition(lottieComposition);
            if (this.f48756a) {
                this.f48757b.playAnimation();
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TBLottieAnimationView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f48751g = false;
        this.f48752h = false;
        this.f48753i = false;
        this.f48754j = new a(this);
    }

    public static boolean checkInternalTempDir(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            File file = new File(str);
            if (file.exists()) {
                return true;
            }
            try {
                return file.mkdirs();
            } catch (Exception e2) {
                TiebaStatic.file(e2, k.join("FileHelper", ".", "CheckTempDir", " ", str));
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static InputStream getAnimationInputStream(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2)) == null) {
            String animationPath = getAnimationPath();
            if (checkInternalTempDir(animationPath)) {
                String str3 = animationPath + str + "/";
                if (new File(str3).exists()) {
                    File file = new File(str3 + str2);
                    if (file.exists()) {
                        return f.x(file);
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return (InputStream) invokeLL.objValue;
    }

    public static String getAnimationPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            return INTERNEL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/animation/";
        }
        return (String) invokeV.objValue;
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || k.isEmpty(str)) {
            return;
        }
        c.a.q0.f1.k.a aVar = new c.a.q0.f1.k.a();
        aVar.d(str);
        aVar.c(getFristLoadInternal());
        setImageAssetDelegate(aVar);
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || k.isEmpty(str)) {
            return;
        }
        boolean z = this.f48751g;
        cancelAnimation();
        InputStream animationInputStream = getAnimationInputStream(str, JSON_FILE);
        if (animationInputStream == null) {
            return;
        }
        LottieCompositionFactory.fromJsonInputStream(animationInputStream, str).addListener(new b(this, z));
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void cancelAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.cancelAnimation();
            this.f48751g = false;
        }
    }

    public void disableRestoreInstanceStateJustOnce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f48753i = true;
        }
    }

    public boolean getFristLoadInternal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f48752h : invokeV.booleanValue;
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, parcelable) == null) {
            if (!this.f48753i) {
                super.onRestoreInstanceState(parcelable);
            }
            this.f48753i = false;
        }
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void pauseAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.pauseAnimation();
            this.f48751g = false;
        }
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void playAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.playAnimation();
            this.f48751g = true;
        }
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void resumeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.resumeAnimation();
            this.f48751g = true;
        }
    }

    public void setAnimationDir(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || k.isEmpty(str)) {
            return;
        }
        a(str);
        b(str);
    }

    public void setAnimationUrl(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || k.isEmpty(str) || str.equals(this.f48750f)) {
            return;
        }
        this.f48750f = str;
        c.a.q0.f1.k.b bVar = new c.a.q0.f1.k.b(getAnimationPath(), str, this.f48754j);
        this.f48749e = bVar;
        bVar.execute(new Void[0]);
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void setComposition(@NonNull LottieComposition lottieComposition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, lottieComposition) == null) {
            super.setComposition(lottieComposition);
            if (this.f48751g) {
                playAnimation();
            }
        }
    }

    public void setFirstLoadInternal(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f48752h = z;
        }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f48751g = false;
        this.f48752h = false;
        this.f48753i = false;
        this.f48754j = new a(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TBLottieAnimationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f48751g = false;
        this.f48752h = false;
        this.f48753i = false;
        this.f48754j = new a(this);
    }
}
