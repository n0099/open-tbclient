package com.baidu.tbadk.editortools.meme.view;

import android.content.Context;
import android.graphics.Outline;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.meme.list.GeneratedErrorData;
import com.baidu.tbadk.editortools.meme.list.GeneratedLoadingData;
import com.baidu.tbadk.editortools.meme.list.MemeData;
import com.baidu.tbadk.editortools.meme.view.SpriteMemeGenerateView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkcore.databinding.SpriteMemeGenerateViewLayoutBinding;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0015J\b\u0010\u0019\u001a\u00020\u0015H\u0002J\u0006\u0010\u001a\u001a\u00020\u0015J \u0010\u001b\u001a\u00020\u00152\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0007J\b\u0010\u001f\u001a\u00020\u0015H\u0002J\b\u0010 \u001a\u00020\u0015H\u0002R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/baidu/tbadk/editortools/meme/view/SpriteMemeGenerateView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/baidu/tieba/tbadkcore/databinding/SpriteMemeGenerateViewLayoutBinding;", "getBinding", "()Lcom/baidu/tieba/tbadkcore/databinding/SpriteMemeGenerateViewLayoutBinding;", "binding$delegate", "Lkotlin/Lazy;", "countDownTimer", "Lcom/baidu/tbadk/editortools/meme/view/SpriteMemeGenerateView$SafeCountDownTimer;", "getCountDownTimer", "()Lcom/baidu/tbadk/editortools/meme/view/SpriteMemeGenerateView$SafeCountDownTimer;", "countDownTimer$delegate", "progress", "", "bindData", "", "memeData", "Lcom/baidu/tbadk/editortools/meme/list/MemeData;", "changeSkin", "initDesc", "initRootView", "setClickListener", "loadingClickListener", "Landroid/view/View$OnClickListener;", "imageClickListener", "showErrorStatus", "showLoadingStatus", "Companion", "SafeCountDownTimer", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SpriteMemeGenerateView extends ConstraintLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public final Lazy b;
    public final Lazy c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1754067005, "Lcom/baidu/tbadk/editortools/meme/view/SpriteMemeGenerateView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1754067005, "Lcom/baidu/tbadk/editortools/meme/view/SpriteMemeGenerateView;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpriteMemeGenerateView(Context context) {
        this(context, null, 2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (DefaultConstructorMarker) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @JvmOverloads
    public final void setClickListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setClickListener$default(this, null, null, 3, null);
        }
    }

    @JvmOverloads
    public final void setClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            setClickListener$default(this, onClickListener, null, 2, null);
        }
    }

    /* loaded from: classes5.dex */
    public static final class a extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final WeakReference<SpriteMemeGenerateView> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SpriteMemeGenerateView spriteMemeGenerateView, long j, long j2, int i) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spriteMemeGenerateView, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(spriteMemeGenerateView, "spriteMemeGenerateView");
            this.a = i;
            this.b = new WeakReference<>(spriteMemeGenerateView);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            SpriteMemeGenerateView spriteMemeGenerateView;
            SpriteMemeGenerateViewLayoutBinding binding;
            TbCircleProgressBar tbCircleProgressBar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (spriteMemeGenerateView = this.b.get()) != null && (binding = spriteMemeGenerateView.getBinding()) != null && (tbCircleProgressBar = binding.d) != null) {
                tbCircleProgressBar.setProgress(this.a);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            SpriteMemeGenerateView spriteMemeGenerateView;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) != null) || (spriteMemeGenerateView = this.b.get()) == null) {
                return;
            }
            spriteMemeGenerateView.a++;
            spriteMemeGenerateView.getBinding().d.setProgress(spriteMemeGenerateView.a);
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends ViewOutlineProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view2, Outline outline) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, outline) == null) && view2 != null && view2.getWidth() != 0 && view2.getHeight() != 0 && outline != null) {
                outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), UtilHelper.getDimenPixelSize(R.dimen.tbds21));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpriteMemeGenerateView(final Context context, AttributeSet attributeSet) {
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
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<SpriteMemeGenerateViewLayoutBinding>(context, this) { // from class: com.baidu.tbadk.editortools.meme.view.SpriteMemeGenerateView$binding$2
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ Context $context;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SpriteMemeGenerateView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {context, this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
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
            public final SpriteMemeGenerateViewLayoutBinding invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return SpriteMemeGenerateViewLayoutBinding.b(LayoutInflater.from(this.$context), this.this$0);
                }
                return (SpriteMemeGenerateViewLayoutBinding) invokeV.objValue;
            }
        });
        this.c = LazyKt__LazyJVMKt.lazy(new Function0<a>(this) { // from class: com.baidu.tbadk.editortools.meme.view.SpriteMemeGenerateView$countDownTimer$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SpriteMemeGenerateView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SpriteMemeGenerateView.a invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new SpriteMemeGenerateView.a(this.this$0, 3000L, 33L, 90);
                }
                return (SpriteMemeGenerateView.a) invokeV.objValue;
            }
        });
        f();
        e();
    }

    public /* synthetic */ SpriteMemeGenerateView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final void d(MemeData memeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, memeData) == null) {
            Intrinsics.checkNotNullParameter(memeData, "memeData");
            if (memeData instanceof GeneratedLoadingData) {
                i();
            } else if (memeData instanceof GeneratedErrorData) {
                h();
            } else if (!GlobalBuildConfig.isDebug()) {
            } else {
                throw new RuntimeException("Wrong Data Type");
            }
        }
    }

    @JvmOverloads
    public final void setClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, onClickListener, onClickListener2) == null) {
            getBinding().d.setOnClickListener(onClickListener);
            getBinding().c.setOnClickListener(onClickListener2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SpriteMemeGenerateViewLayoutBinding getBinding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            return (SpriteMemeGenerateViewLayoutBinding) this.b.getValue();
        }
        return (SpriteMemeGenerateViewLayoutBinding) invokeV.objValue;
    }

    private final a getCountDownTimer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            return (a) this.c.getValue();
        }
        return (a) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            EMManager.from(this).setBackGroundColor(R.color.CAM_X0209);
            setClipToOutline(true);
            setOutlineProvider(new b());
        }
    }

    public static /* synthetic */ void setClickListener$default(SpriteMemeGenerateView spriteMemeGenerateView, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, int i, Object obj) {
        if ((i & 1) != 0) {
            onClickListener = null;
        }
        if ((i & 2) != 0) {
            onClickListener2 = null;
        }
        spriteMemeGenerateView.setClickListener(onClickListener, onClickListener2);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            getBinding().b.setText(getContext().getString(R.string.generate_desc));
            EMManager.from(getBinding().b).setTextSize(R.dimen.T_X10).setTextColor(R.color.CAM_X0110);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            getBinding().d.setVisibility(0);
            getBinding().b.setVisibility(0);
            getBinding().c.setVisibility(8);
            this.a = 0;
            getBinding().d.setProgress(0);
            getCountDownTimer().start();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            getBinding().d.setVisibility(8);
            getBinding().c.setVisibility(0);
            getBinding().b.setVisibility(8);
            getCountDownTimer().cancel();
            this.a = 0;
            getBinding().c.setImageDrawable(SkinManager.getDrawable(R.drawable.meme_pic_fail));
        }
    }
}
