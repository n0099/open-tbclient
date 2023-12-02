package com.baidu.tbadk.editortools.meme.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.editortools.meme.list.GeneratedErrorData;
import com.baidu.tbadk.editortools.meme.list.GeneratedLoadedData;
import com.baidu.tbadk.editortools.meme.list.GeneratedLoadingData;
import com.baidu.tbadk.editortools.meme.list.MemeData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.by9;
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
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\t\b\u0016\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0001>B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0002J\b\u0010 \u001a\u00020\u001bH\u0002J\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u00020\u001bH\u0002J\b\u0010%\u001a\u00020\u001bH\u0002J\b\u0010&\u001a\u00020\u001bH\u0002J\n\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\u001bH\u0002J\b\u0010*\u001a\u00020\u0012H\u0014J\b\u0010+\u001a\u00020\u0012H\u0014J\u0010\u0010,\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\u0010\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u0012H\u0016J\u0012\u0010/\u001a\u00020\u001b2\n\b\u0002\u00100\u001a\u0004\u0018\u000101J\u001e\u00102\u001a\u00020\u001b2\n\b\u0002\u00103\u001a\u0004\u0018\u0001012\n\b\u0002\u00100\u001a\u0004\u0018\u000101J\u0010\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u001eH\u0016J\u0012\u00106\u001a\u00020\u001b2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0012\u00109\u001a\u00020\u001b2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\"\u00109\u001a\u00020\u001b2\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\u0012H\u0016R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/baidu/tbadk/editortools/meme/view/AigcImageView;", "Landroid/widget/FrameLayout;", "Lcom/baidu/tieba/pb/intercept/IImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "delegateEvent", "com/baidu/tbadk/editortools/meme/view/AigcImageView$delegateEvent$1", "Lcom/baidu/tbadk/editortools/meme/view/AigcImageView$delegateEvent$1;", "imageView", "Lcom/baidu/tbadk/widget/TbImageView;", "getImageView", "()Lcom/baidu/tbadk/widget/TbImageView;", "imageView$delegate", "Lkotlin/Lazy;", "isImageLoaded", "", "isLoadingFinished", "loadingView", "Lcom/baidu/tbadk/editortools/meme/view/SpriteMemeGenerateView;", "getLoadingView", "()Lcom/baidu/tbadk/editortools/meme/view/SpriteMemeGenerateView;", "loadingView$delegate", "onLoadingFinish", "Lkotlin/Function0;", "", "addCornerFlags", "corner", "", "addImageView", "addLoadingView", "bindData", "memeData", "Lcom/baidu/tbadk/editortools/meme/list/MemeData;", "changeSkin", "displayError", "displayLoading", "getBdImage", "Lcom/baidu/adp/widget/ImageView/BdImage;", "hideLoading", "isHideLoading", "isOnFinishedLoadingHide", "resetTimer", "setDrawCorner", "isDraw", "setOnImageClickListener", "imageClickListener", "Landroid/view/View$OnClickListener;", "setOnLoadingClickListener", "loadingClickListener", "setRadiusById", "radiiStringId", "setScaleType", "scaleType", "Landroid/widget/ImageView$ScaleType;", "startLoad", "url", "", "type", "showLoading", "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class AigcImageView extends FrameLayout implements by9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;
    public final Lazy b;
    public boolean c;
    public boolean d;
    public final a e;
    public final Function0<Unit> f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1562951310, "Lcom/baidu/tbadk/editortools/meme/view/AigcImageView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1562951310, "Lcom/baidu/tbadk/editortools/meme/view/AigcImageView;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AigcImageView(Context context) {
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

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public static final class a implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AigcImageView a;

        public a(AigcImageView aigcImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aigcImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aigcImageView;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
                if (z) {
                    this.a.c = true;
                    if (!this.a.m()) {
                        return;
                    }
                    this.a.l();
                    return;
                }
                this.a.c = false;
                this.a.j();
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.c = false;
            this.a.j();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AigcImageView(final Context context, AttributeSet attributeSet) {
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
        this.a = LazyKt__LazyJVMKt.lazy(new Function0<SpriteMemeGenerateView>(context) { // from class: com.baidu.tbadk.editortools.meme.view.AigcImageView$loadingView$2
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ Context $context;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {context};
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
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SpriteMemeGenerateView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new SpriteMemeGenerateView(this.$context, null, 2, null);
                }
                return (SpriteMemeGenerateView) invokeV.objValue;
            }
        });
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<TbImageView>(context) { // from class: com.baidu.tbadk.editortools.meme.view.AigcImageView$imageView$2
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ Context $context;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {context};
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
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TbImageView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new TbImageView(this.$context);
                }
                return (TbImageView) invokeV.objValue;
            }
        });
        this.e = new a(this);
        this.f = new Function0<Unit>(this) { // from class: com.baidu.tbadk.editortools.meme.view.AigcImageView$onLoadingFinish$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AigcImageView this$0;

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

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                    return;
                }
                this.this$0.d = true;
                if (!this.this$0.n() || !this.this$0.m()) {
                    return;
                }
                this.this$0.l();
            }
        };
        f();
        g();
    }

    public /* synthetic */ AigcImageView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static /* synthetic */ void setOnImageClickListener$default(AigcImageView aigcImageView, View.OnClickListener onClickListener, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                onClickListener = null;
            }
            aigcImageView.setOnImageClickListener(onClickListener);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOnImageClickListener");
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            getImageView().addCornerFlags(i);
        }
    }

    public void o(SpriteMemeGenerateView loadingView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, loadingView) == null) {
            Intrinsics.checkNotNullParameter(loadingView, "loadingView");
            long nextLong = Random.Default.nextLong(500L, 1501L);
            loadingView.j(nextLong, nextLong / 90, 90);
        }
    }

    public void setDrawCorner(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            getImageView().setDrawCorner(z);
        }
    }

    public final void setOnImageClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) {
            getImageView().setOnClickListener(onClickListener);
        }
    }

    public void setRadiusById(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            getImageView().setRadiusById(i);
        }
    }

    @Override // com.baidu.tieba.by9
    public void setScaleType(ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, scaleType) == null) {
            getImageView().setScaleType(scaleType);
        }
    }

    @Override // com.baidu.tieba.by9
    public void startLoad(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            startLoad(str, 10, false);
        }
    }

    public final void setOnLoadingClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, onClickListener, onClickListener2) == null) {
            getLoadingView().setClickListener(onClickListener, onClickListener2);
        }
    }

    private final TbImageView getImageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            return (TbImageView) this.b.getValue();
        }
        return (TbImageView) invokeV.objValue;
    }

    private final SpriteMemeGenerateView getLoadingView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            return (SpriteMemeGenerateView) this.a.getValue();
        }
        return (SpriteMemeGenerateView) invokeV.objValue;
    }

    public BdImage getBdImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return getImageView().getBdImage();
        }
        return (BdImage) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            getLoadingView().e();
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            getLoadingView().setVisibility(0);
            getImageView().setVisibility(8);
            getLoadingView().d(new GeneratedErrorData());
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            getLoadingView().setVisibility(8);
            getImageView().setVisibility(0);
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.c && this.d) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static /* synthetic */ void setOnLoadingClickListener$default(AigcImageView aigcImageView, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                onClickListener = null;
            }
            if ((i & 2) != 0) {
                onClickListener2 = null;
            }
            aigcImageView.setOnLoadingClickListener(onClickListener, onClickListener2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOnLoadingClickListener");
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            getImageView().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(getImageView());
            getImageView().setEvent(this.e);
            getImageView().setPlaceHolder(1);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            getLoadingView().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(getLoadingView());
            getLoadingView().setOnLoadingFinish(this.f);
            getLoadingView().setVisibility(8);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            getLoadingView().setVisibility(0);
            getImageView().setVisibility(8);
            getImageView().reset();
            getLoadingView().d(new GeneratedLoadingData());
        }
    }

    public final void h(MemeData memeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, memeData) == null) {
            Intrinsics.checkNotNullParameter(memeData, "memeData");
            if (memeData instanceof GeneratedLoadingData) {
                k();
            } else if (memeData instanceof GeneratedErrorData) {
                j();
            } else if (memeData instanceof GeneratedLoadedData) {
                startLoad(memeData.getImgUrl());
            } else if (!Intrinsics.areEqual(getImageView().getUrl(), memeData.getImgUrl())) {
                this.d = false;
                o(getLoadingView());
                k();
                startLoad(memeData.getImgUrl());
            }
            i();
        }
    }

    @Override // com.baidu.tieba.by9
    public void startLoad(String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.c = false;
            getImageView().startLoad(str, i, z);
        }
    }
}
