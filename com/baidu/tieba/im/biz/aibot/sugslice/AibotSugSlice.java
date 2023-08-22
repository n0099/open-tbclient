package com.baidu.tieba.im.biz.aibot.sugslice;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.CustomRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.immessagecenter.slice.Slice;
import com.baidu.tieba.impersonal.databinding.ImSugSliceLayoutBinding;
import com.baidu.tieba.nb8;
import com.baidu.tieba.poa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0006\u0010 \u001a\u00020\u001fJ\u0016\u0010!\u001a\u00020\u001f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0007J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u0011H\u0016J\"\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u001c\u0010+\u001a\u00020\u001f2\b\u0010,\u001a\u0004\u0018\u00010\u00062\b\u0010)\u001a\u0004\u0018\u00010*H\u0016R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006-"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/sugslice/AibotSugSlice;", "Lcom/baidu/tieba/immessagecenter/slice/Slice;", "pageContent", "Lcom/baidu/tbadk/TbPageContext;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "sugContainer", "Landroid/view/View;", "processor", "Lcom/baidu/tieba/im/base/core/uilist/AbilityProcessor;", "(Lcom/baidu/tbadk/TbPageContext;Landroid/view/View;Lcom/baidu/tieba/im/base/core/uilist/AbilityProcessor;)V", "adapter", "Lcom/baidu/tieba/im/biz/aibot/sugslice/ImSugAdapter;", "getAdapter", "()Lcom/baidu/tieba/im/biz/aibot/sugslice/ImSugAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "fadingDuration", "", "getFadingDuration", "()I", "fadingDuration$delegate", "items", "", "Lcom/baidu/tieba/im/lib/socket/msg/data/AbilityItem;", "getProcessor", "()Lcom/baidu/tieba/im/base/core/uilist/AbilityProcessor;", "rootViewBinding", "Lcom/baidu/tieba/impersonal/databinding/ImSugSliceLayoutBinding;", "getSugContainer", "()Landroid/view/View;", "executeShowSugAnimation", "", "hideSug", "notifySugUI", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AibotSugSlice extends Slice {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<BaseFragmentActivity> j;
    public final View k;
    public final nb8 l;
    public final Lazy m;
    public ImSugSliceLayoutBinding n;
    public List<AbilityItem> o;
    public final Lazy p;

    public AibotSugSlice(TbPageContext<BaseFragmentActivity> pageContent, View sugContainer, nb8 processor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContent, sugContainer, processor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContent, "pageContent");
        Intrinsics.checkNotNullParameter(sugContainer, "sugContainer");
        Intrinsics.checkNotNullParameter(processor, "processor");
        this.j = pageContent;
        this.k = sugContainer;
        this.l = processor;
        this.m = LazyKt__LazyJVMKt.lazy(AibotSugSlice$fadingDuration$2.INSTANCE);
        this.p = LazyKt__LazyJVMKt.lazy(new Function0<AibotSugAdapter>(this) { // from class: com.baidu.tieba.im.biz.aibot.sugslice.AibotSugSlice$adapter$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AibotSugSlice this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
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
            public final AibotSugAdapter invoke() {
                InterceptResult invokeV;
                TbPageContext tbPageContext;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (AibotSugAdapter) invokeV.objValue;
                }
                tbPageContext = this.this$0.j;
                Activity pageActivity = tbPageContext.getPageActivity();
                Intrinsics.checkNotNullExpressionValue(pageActivity, "pageContent.pageActivity");
                return new AibotSugAdapter(pageActivity, this.this$0.c0());
            }
        });
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void e0(List<AbilityItem> items) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, items) == null) {
            Intrinsics.checkNotNullParameter(items, "items");
            try {
                this.o = items;
                a0().l(items);
                a0().notifyDataSetChanged();
                Z();
            } catch (Exception e) {
                BdLog.detailException("CustomException Aibot Sug 绑定数据", e, false);
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public View P(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, inflater, container, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Intrinsics.checkNotNullParameter(container, "container");
            ImSugSliceLayoutBinding it = ImSugSliceLayoutBinding.c(inflater, container, false);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this.n = it;
            CustomRecyclerView root = it.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "inflate(inflater, contai…nding = it\n        }.root");
            return root;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void V(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, bundle) == null) {
            super.V(view2, bundle);
            Activity pageActivity = this.j.getPageActivity();
            Intrinsics.checkNotNullExpressionValue(pageActivity, "pageContent.pageActivity");
            SugLayoutManager sugLayoutManager = new SugLayoutManager(pageActivity, 0, false);
            ImSugSliceLayoutBinding imSugSliceLayoutBinding = this.n;
            ImSugSliceLayoutBinding imSugSliceLayoutBinding2 = null;
            if (imSugSliceLayoutBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootViewBinding");
                imSugSliceLayoutBinding = null;
            }
            imSugSliceLayoutBinding.b.setLayoutManager(sugLayoutManager);
            ImSugSliceLayoutBinding imSugSliceLayoutBinding3 = this.n;
            if (imSugSliceLayoutBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootViewBinding");
                imSugSliceLayoutBinding3 = null;
            }
            imSugSliceLayoutBinding3.b.setAdapter(a0());
            ImSugSliceLayoutBinding imSugSliceLayoutBinding4 = this.n;
            if (imSugSliceLayoutBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootViewBinding");
            } else {
                imSugSliceLayoutBinding2 = imSugSliceLayoutBinding4;
            }
            imSugSliceLayoutBinding2.b.addItemDecoration(new ImSugDecoration(R.dimen.M_W_X007, R.dimen.M_W_X004));
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.k.setVisibility(0);
            poa.d(this.k, b0());
        }
    }

    public final ImSugAdapter a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return (ImSugAdapter) this.p.getValue();
        }
        return (ImSugAdapter) invokeV.objValue;
    }

    public final int b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ((Number) this.m.getValue()).intValue();
        }
        return invokeV.intValue;
    }

    public final nb8 c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l;
        }
        return (nb8) invokeV.objValue;
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.k.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void onChangeSkinType(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            super.onChangeSkinType(i);
            List<AbilityItem> list = this.o;
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                try {
                    ImSugAdapter a0 = a0();
                    List<AbilityItem> list2 = this.o;
                    Intrinsics.checkNotNull(list2);
                    a0.notifyItemRangeChanged(0, list2.size());
                } catch (Exception e) {
                    BdLog.detailException("CustomException Aibot Sug 适配日夜间", e, false);
                }
            }
        }
    }
}
