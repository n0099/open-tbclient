package com.baidu.tbadk.editortools.meme.view;

import android.content.Context;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.editortools.meme.model.SpriteMemeReplyData;
import com.baidu.tbadk.editortools.meme.view.SpriteMemeReplyView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkcore.databinding.SpriteMemeReplyViewBinding;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020$J\b\u0010(\u001a\u00020$H\u0002J\u0006\u0010)\u001a\u00020\u0016J\u0006\u0010*\u001a\u00020$J\u0006\u0010+\u001a\u00020$J\b\u0010,\u001a\u00020$H\u0002J\u000e\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020\u001cJ\u000e\u0010/\u001a\u00020$2\u0006\u0010.\u001a\u00020\u001cR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/baidu/tbadk/editortools/meme/view/SpriteMemeReplyView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/baidu/tieba/tbadkcore/databinding/SpriteMemeReplyViewBinding;", "getBinding", "()Lcom/baidu/tieba/tbadkcore/databinding/SpriteMemeReplyViewBinding;", "binding$delegate", "Lkotlin/Lazy;", "clickCallback", "Lcom/baidu/tbadk/editortools/meme/model/SpriteMemeReplyData$Callback;", "getClickCallback", "()Lcom/baidu/tbadk/editortools/meme/model/SpriteMemeReplyData$Callback;", "setClickCallback", "(Lcom/baidu/tbadk/editortools/meme/model/SpriteMemeReplyData$Callback;)V", "lottieInited", "", "getLottieInited", "()Z", "setLottieInited", "(Z)V", "rightBtnContent", "", "getRightBtnContent", "()Ljava/lang/String;", "setRightBtnContent", "(Ljava/lang/String;)V", "viewScene", "Lcom/baidu/tbadk/editortools/meme/model/SpriteMemeReplyData$SPRITE_SCENE;", "bindData", "", "data", "Lcom/baidu/tbadk/editortools/meme/model/SpriteMemeReplyData;", "cancelLottieAnimation", "initLottie", "isLottieAnimating", "onChangeSkinType", "playLottieAnimation", "setOnclickListener", "updateBtnContent", "text", "updateTitleContent", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SpriteMemeReplyView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;
    public SpriteMemeReplyData.SPRITE_SCENE b;
    public SpriteMemeReplyData.a c;
    public String d;
    public boolean e;

    /* loaded from: classes5.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(529820179, "Lcom/baidu/tbadk/editortools/meme/view/SpriteMemeReplyView$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(529820179, "Lcom/baidu/tbadk/editortools/meme/view/SpriteMemeReplyView$a;");
                    return;
                }
            }
            int[] iArr = new int[SpriteMemeReplyData.SPRITE_SCENE.values().length];
            iArr[SpriteMemeReplyData.SPRITE_SCENE.SCENE_REPLY_REFRESH.ordinal()] = 1;
            iArr[SpriteMemeReplyData.SPRITE_SCENE.SCENE_PB.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpriteMemeReplyView(Context context) {
        this(context, null, 0, 6, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpriteMemeReplyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* loaded from: classes5.dex */
    public static final class b implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpriteMemeReplyView a;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, v) == null) {
                Intrinsics.checkNotNullParameter(v, "v");
            }
        }

        public b(SpriteMemeReplyView spriteMemeReplyView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spriteMemeReplyView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = spriteMemeReplyView;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v) == null) {
                Intrinsics.checkNotNullParameter(v, "v");
                this.a.b();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpriteMemeReplyView(final Context context, AttributeSet attributeSet, int i) {
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
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = LazyKt__LazyJVMKt.lazy(new Function0<SpriteMemeReplyViewBinding>(context, this) { // from class: com.baidu.tbadk.editortools.meme.view.SpriteMemeReplyView$binding$2
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ Context $context;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SpriteMemeReplyView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {context, this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.$context = context;
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SpriteMemeReplyViewBinding invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    SpriteMemeReplyViewBinding c = SpriteMemeReplyViewBinding.c(LayoutInflater.from(this.$context), this.this$0, true);
                    Intrinsics.checkNotNullExpressionValue(c, "inflate(LayoutInflater.from(context), this, true)");
                    return c;
                }
                return (SpriteMemeReplyViewBinding) invokeV.objValue;
            }
        });
        this.b = SpriteMemeReplyData.SPRITE_SCENE.SCENE_REPLY_DEFAULT;
        g();
    }

    public /* synthetic */ SpriteMemeReplyView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final SpriteMemeReplyViewBinding getBinding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            return (SpriteMemeReplyViewBinding) this.a.getValue();
        }
        return (SpriteMemeReplyViewBinding) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            getBinding().c.cancelAnimation();
            getBinding().c.setProgress(0.0f);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.e) {
            return;
        }
        this.e = true;
        TBLottieAnimationView tBLottieAnimationView = getBinding().c;
        tBLottieAnimationView.setImageAssetsFolder("lottie_sprite_reply_thread");
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.bot_reply_thread_lottie);
        tBLottieAnimationView.addOnAttachStateChangeListener(new b(this));
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return getBinding().c.isAnimating();
        }
        return invokeV.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            getBinding().c.playAnimation();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            getBinding().e.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.dg5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        SpriteMemeReplyView.h(SpriteMemeReplyView.this, view2);
                    }
                }
            });
            getBinding().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.eg5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        SpriteMemeReplyView.i(SpriteMemeReplyView.this, view2);
                    }
                }
            });
        }
    }

    public final SpriteMemeReplyData.a getClickCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return (SpriteMemeReplyData.a) invokeV.objValue;
    }

    public final boolean getLottieInited() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public final String getRightBtnContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public static final void h(SpriteMemeReplyView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            SpriteMemeReplyData.a aVar = this$0.c;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    public static final void i(SpriteMemeReplyView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            SpriteMemeReplyData.a aVar = this$0.c;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public final void a(SpriteMemeReplyData data) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.b = data.e();
            this.d = data.a();
            this.c = data.b();
            if (data.f().length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z && TextUtils.isEmpty(data.a())) {
                getBinding().b.setVisibility(8);
            } else {
                getBinding().b.setVisibility(0);
            }
            if (data.f().length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                getBinding().g.setVisibility(0);
                if (data.c()) {
                    getBinding().g.setText(data.f());
                }
            } else {
                getBinding().g.setVisibility(8);
            }
            if (!TextUtils.isEmpty(data.a())) {
                getBinding().e.setVisibility(0);
                getBinding().d.setText(data.a());
            } else {
                getBinding().e.setVisibility(8);
            }
            ViewGroup.LayoutParams layoutParams = getBinding().g.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).weight = 1.0f;
                Layout layout = getBinding().g.getLayout();
                if (layout != null) {
                    if (layout.getEllipsisCount(layout.getLineCount() - 1) > 0) {
                        layoutParams.width = 0;
                    } else {
                        layoutParams.width = -2;
                    }
                }
                getBinding().g.setLayoutParams(layoutParams);
            }
            c();
            if (data.d()) {
                if (!d()) {
                    f();
                }
            } else if (d()) {
                b();
            }
            e();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            EMManager.from(getBinding().g).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X09);
            EMManager.from(getBinding().d).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0302).setTextSize(R.dimen.T_X09);
            int i = a.$EnumSwitchMapping$0[this.b.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    getBinding().e.setVisibility(8);
                } else {
                    WebPManager.setPureDrawable(getBinding().f, R.drawable.bot_reply_thread_arrow, R.color.CAM_X0302, null);
                    getBinding().e.setVisibility(0);
                }
            } else {
                WebPManager.setPureDrawable(getBinding().f, R.drawable.bot_reply_thread_refresh, R.color.CAM_X0302, null);
                getBinding().e.setVisibility(0);
            }
            SkinManager.setBackgroundResource(getBinding().b, R.drawable.bot_reply_thread_bg);
        }
    }

    public final void setClickCallback(SpriteMemeReplyData.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.c = aVar;
        }
    }

    public final void setLottieInited(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.e = z;
        }
    }

    public final void setRightBtnContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.d = str;
        }
    }
}
