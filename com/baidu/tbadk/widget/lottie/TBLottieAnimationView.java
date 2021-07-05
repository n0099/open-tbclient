package com.baidu.tbadk.widget.lottie;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
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
import d.a.c.e.p.f;
import d.a.c.e.p.k;
import d.a.r0.b1.k.b;
import java.io.File;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class TBLottieAnimationView extends LottieAnimationView {
    public static /* synthetic */ Interceptable $ic;
    public static final String k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.r0.b1.k.b f13403e;

    /* renamed from: f  reason: collision with root package name */
    public String f13404f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13405g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13406h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13407i;
    public b.a j;

    /* loaded from: classes4.dex */
    public class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TBLottieAnimationView f13408a;

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
            this.f13408a = tBLottieAnimationView;
        }

        @Override // d.a.r0.b1.k.b.a
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) && z && !k.isEmpty(str)) {
                this.f13408a.setAnimationDir(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements LottieListener<LottieComposition> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f13409a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TBLottieAnimationView f13410b;

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
            this.f13410b = tBLottieAnimationView;
            this.f13409a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(LottieComposition lottieComposition) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, lottieComposition) == null) || lottieComposition == null) {
                return;
            }
            this.f13410b.setComposition(lottieComposition);
            if (this.f13409a) {
                this.f13410b.playAnimation();
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
        k = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();
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
        this.f13405g = false;
        this.f13406h = false;
        this.f13407i = false;
        this.j = new a(this);
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
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

    public static String getAnimationPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            return k + "/" + TbConfig.getTempDirName() + "/animation/";
        }
        return (String) invokeV.objValue;
    }

    public static InputStream n(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2)) == null) {
            String animationPath = getAnimationPath();
            if (a(animationPath)) {
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

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || k.isEmpty(str)) {
            return;
        }
        d.a.r0.b1.k.a aVar = new d.a.r0.b1.k.a();
        aVar.d(str);
        aVar.c(getFristLoadInternal());
        setImageAssetDelegate(aVar);
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void cancelAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.cancelAnimation();
            this.f13405g = false;
        }
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || k.isEmpty(str)) {
            return;
        }
        boolean z = this.f13405g;
        cancelAnimation();
        InputStream n = n(str, "data.json");
        if (n == null) {
            return;
        }
        LottieCompositionFactory.fromJsonInputStream(n, str).addListener(new b(this, z));
    }

    public boolean getFristLoadInternal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13406h : invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f13407i = true;
        }
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, parcelable) == null) {
            if (!this.f13407i) {
                super.onRestoreInstanceState(parcelable);
            }
            this.f13407i = false;
        }
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void pauseAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.pauseAnimation();
            this.f13405g = false;
        }
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void playAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.playAnimation();
            this.f13405g = true;
        }
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void resumeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.resumeAnimation();
            this.f13405g = true;
        }
    }

    public void setAnimationDir(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || k.isEmpty(str)) {
            return;
        }
        b(str);
        g(str);
    }

    public void setAnimationUrl(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || k.isEmpty(str) || str.equals(this.f13404f)) {
            return;
        }
        this.f13404f = str;
        d.a.r0.b1.k.b bVar = new d.a.r0.b1.k.b(getAnimationPath(), str, this.j);
        this.f13403e = bVar;
        bVar.execute(new Void[0]);
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void setComposition(@NonNull LottieComposition lottieComposition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, lottieComposition) == null) {
            super.setComposition(lottieComposition);
            if (this.f13405g) {
                playAnimation();
            }
        }
    }

    public void setFirstLoadInternal(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f13406h = z;
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
        this.f13405g = false;
        this.f13406h = false;
        this.f13407i = false;
        this.j = new a(this);
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
        this.f13405g = false;
        this.f13406h = false;
        this.f13407i = false;
        this.j = new a(this);
    }
}
