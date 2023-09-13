package com.baidu.tieba.im.biz.aibot.sugslice;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.impersonal.databinding.ImSugItemLayoutBinding;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/sugslice/SugViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/baidu/tieba/impersonal/databinding/ImSugItemLayoutBinding;", "(Lcom/baidu/tieba/impersonal/databinding/ImSugItemLayoutBinding;)V", "iconSugItem", "Landroid/widget/ImageView;", "getIconSugItem", "()Landroid/widget/ImageView;", "iconSugItem$delegate", "Lkotlin/Lazy;", "textSugItem", "Landroid/widget/TextView;", "getTextSugItem", "()Landroid/widget/TextView;", "textSugItem$delegate", "tipSugItem", "Landroid/view/View;", "getTipSugItem", "()Landroid/view/View;", "tipSugItem$delegate", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SugViewHolder extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SugViewHolder(final ImSugItemLayoutBinding binding) {
        super(binding.getRoot());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {binding};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.a = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>(binding) { // from class: com.baidu.tieba.im.biz.aibot.sugslice.SugViewHolder$iconSugItem$2
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ ImSugItemLayoutBinding $binding;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {binding};
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
                this.$binding = binding;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    ImageView imageView = this.$binding.d;
                    Intrinsics.checkNotNullExpressionValue(imageView, "binding.sugItemIcon");
                    return imageView;
                }
                return (ImageView) invokeV.objValue;
            }
        });
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(binding) { // from class: com.baidu.tieba.im.biz.aibot.sugslice.SugViewHolder$textSugItem$2
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ ImSugItemLayoutBinding $binding;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {binding};
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
                this.$binding = binding;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    TextView textView = this.$binding.f;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.sugItemText");
                    return textView;
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.c = LazyKt__LazyJVMKt.lazy(new Function0<View>(binding) { // from class: com.baidu.tieba.im.biz.aibot.sugslice.SugViewHolder$tipSugItem$2
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ ImSugItemLayoutBinding $binding;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {binding};
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
                this.$binding = binding;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    View view2 = this.$binding.e;
                    Intrinsics.checkNotNullExpressionValue(view2, "binding.sugItemRedTip");
                    return view2;
                }
                return (View) invokeV.objValue;
            }
        });
    }

    public final ImageView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (ImageView) this.a.getValue();
        }
        return (ImageView) invokeV.objValue;
    }

    public final TextView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (TextView) this.b.getValue();
        }
        return (TextView) invokeV.objValue;
    }

    public final View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (View) this.c.getValue();
        }
        return (View) invokeV.objValue;
    }
}
