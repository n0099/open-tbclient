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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.im.biz.aibot.data.AibotChatDetail;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.immessagecenter.slice.Slice;
import com.baidu.tieba.impersonal.databinding.ImSugSliceLayoutBinding;
import com.baidu.tieba.jc8;
import com.baidu.tieba.nqa;
import com.baidu.tieba.oc8;
import com.baidu.tieba.qc8;
import com.baidu.tieba.zc8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
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
import org.json.JSONObject;
@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f*\u0001%\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001FB#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010-\u001a\u00020.H\u0002J\u0006\u0010/\u001a\u00020.J\b\u00100\u001a\u00020\u0012H\u0002J\u0016\u00101\u001a\u00020.2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0007J\u0010\u00102\u001a\u00020.2\u0006\u00103\u001a\u00020\u001aH\u0016J\b\u00104\u001a\u00020.H\u0016J\"\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010<\u001a\u00020.H\u0016J\u0010\u0010=\u001a\u00020.2\u0006\u0010>\u001a\u00020\"H\u0016J\u0018\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020\u001a2\u0006\u0010A\u001a\u00020\u0012H\u0016J\u001c\u0010B\u001a\u00020.2\b\u0010C\u001a\u0004\u0018\u00010\u00072\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u0010\u0010D\u001a\u00020.2\u0006\u0010E\u001a\u00020\u001aH\u0002R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u0006G"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/sugslice/AibotSugSlice;", "Lcom/baidu/tieba/immessagecenter/slice/Slice;", "Lcom/baidu/tieba/im/biz/aibot/IPageChangeNotify;", "pageContent", "Lcom/baidu/tbadk/TbPageContext;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "sugContainer", "Landroid/view/View;", "processor", "Lcom/baidu/tieba/im/base/core/uilist/AbilityProcessor;", "(Lcom/baidu/tbadk/TbPageContext;Landroid/view/View;Lcom/baidu/tieba/im/base/core/uilist/AbilityProcessor;)V", "adapter", "Lcom/baidu/tieba/im/biz/aibot/sugslice/ImSugAdapter;", "getAdapter", "()Lcom/baidu/tieba/im/biz/aibot/sugslice/ImSugAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "changePageNeedShowDefaultSug", "", "currTopicInfo", "Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail$TopicInfo;", "getCurrTopicInfo", "()Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail$TopicInfo;", "setCurrTopicInfo", "(Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail$TopicInfo;)V", "fadingDuration", "", "getFadingDuration", "()I", "fadingDuration$delegate", "items", "", "Lcom/baidu/tieba/im/lib/socket/msg/data/AbilityItem;", "mChatDetail", "Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail;", "mPageState", "onNotifyUpdateSug", "com/baidu/tieba/im/biz/aibot/sugslice/AibotSugSlice$onNotifyUpdateSug$1", "Lcom/baidu/tieba/im/biz/aibot/sugslice/AibotSugSlice$onNotifyUpdateSug$1;", "getProcessor", "()Lcom/baidu/tieba/im/base/core/uilist/AbilityProcessor;", "rootViewBinding", "Lcom/baidu/tieba/impersonal/databinding/ImSugSliceLayoutBinding;", "getSugContainer", "()Landroid/view/View;", "executeShowSugAnimation", "", "hideSug", "isChatPageState", "notifySugUI", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", MissionEvent.MESSAGE_DESTROY, "onSetChatDetail", "chatDetail", "onSetPageState", "state", "refreshPage", "onViewCreated", "view", "processTopicSugInfo", "index", "Companion", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AibotSugSlice extends Slice implements qc8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<BaseFragmentActivity> j;
    public final View k;
    public final jc8 l;
    public final Lazy m;
    public ImSugSliceLayoutBinding n;
    public List<AbilityItem> o;
    public int p;
    public boolean q;
    public AibotChatDetail r;
    public final Lazy s;
    public AibotChatDetail.TopicInfo t;
    public final a u;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-839077656, "Lcom/baidu/tieba/im/biz/aibot/sugslice/AibotSugSlice;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-839077656, "Lcom/baidu/tieba/im/biz/aibot/sugslice/AibotSugSlice;");
        }
    }

    /* loaded from: classes6.dex */
    public static final class a extends zc8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AibotSugSlice c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AibotSugSlice aibotSugSlice) {
            super("aibot.updateSugList");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aibotSugSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = aibotSugSlice;
        }

        @Override // com.baidu.tieba.hz4.c
        public void a(String data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                int i = 0;
                oc8.a.a("AibotSugSlice onNotifyUpdateSug");
                if (this.c.j0()) {
                    return;
                }
                try {
                    i = new JSONObject(data).optInt("index");
                } catch (Exception e) {
                    if (!TbadkApplication.getInst().isDebugMode()) {
                        oc8 oc8Var = oc8.a;
                        oc8Var.a("AibotSugSlice AibotSugSlice" + e.getMessage());
                    } else {
                        throw new IllegalArgumentException("index解析异常 " + e.getMessage());
                    }
                }
                this.c.l0(i);
            }
        }
    }

    public AibotSugSlice(TbPageContext<BaseFragmentActivity> pageContent, View sugContainer, jc8 processor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContent, sugContainer, processor};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
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
        this.p = 2;
        this.s = LazyKt__LazyJVMKt.lazy(new Function0<AibotSugAdapter>(this) { // from class: com.baidu.tieba.im.biz.aibot.sugslice.AibotSugSlice$adapter$2
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
                return new AibotSugAdapter(pageActivity, this.this$0.h0());
            }
        });
        this.u = new a(this);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void k0(List<AbilityItem> items) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, items) == null) {
            Intrinsics.checkNotNullParameter(items, "items");
            try {
                this.o = items;
                e0().l(items);
                e0().notifyDataSetChanged();
                d0();
            } catch (Exception e) {
                BdLog.detailException("CustomException Aibot Sug 绑定数据", e, false);
            }
        }
    }

    @Override // com.baidu.tieba.qc8
    public void A1(int i, boolean z) {
        AibotChatDetail aibotChatDetail;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) != null) || this.p == i) {
            return;
        }
        i0();
        this.p = i;
        if (this.q && j0() && (aibotChatDetail = this.r) != null) {
            Intrinsics.checkNotNull(aibotChatDetail);
            List<AbilityItem> defaultSug = aibotChatDetail.getDefaultSug();
            if (defaultSug != null) {
                k0(defaultSug);
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void X(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, view2, bundle) == null) {
            super.X(view2, bundle);
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
            imSugSliceLayoutBinding3.b.setAdapter(e0());
            ImSugSliceLayoutBinding imSugSliceLayoutBinding4 = this.n;
            if (imSugSliceLayoutBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootViewBinding");
            } else {
                imSugSliceLayoutBinding2 = imSugSliceLayoutBinding4;
            }
            imSugSliceLayoutBinding2.b.addItemDecoration(new ImSugDecoration(R.dimen.M_W_X007, R.dimen.M_W_X004));
        }
    }

    @Override // com.baidu.tieba.qc8
    public void B(AibotChatDetail chatDetail) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatDetail) == null) {
            Intrinsics.checkNotNullParameter(chatDetail, "chatDetail");
            this.r = chatDetail;
            List<AbilityItem> defaultSug = chatDetail.getDefaultSug();
            if (defaultSug != null && !defaultSug.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (!z && j0()) {
                k0(chatDetail.getDefaultSug());
                this.q = true;
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void onChangeSkinType(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            super.onChangeSkinType(i);
            List<AbilityItem> list = this.o;
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                try {
                    ImSugAdapter e0 = e0();
                    List<AbilityItem> list2 = this.o;
                    Intrinsics.checkNotNull(list2);
                    e0.notifyItemRangeChanged(0, list2.size());
                } catch (Exception e) {
                    BdLog.detailException("CustomException Aibot Sug 适配日夜间", e, false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public View R(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, inflater, container, bundle)) == null) {
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

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.k.setVisibility(0);
            nqa.d(this.k, g0());
        }
    }

    public final ImSugAdapter e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return (ImSugAdapter) this.s.getValue();
        }
        return (ImSugAdapter) invokeV.objValue;
    }

    public final AibotChatDetail.TopicInfo f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.t;
        }
        return (AibotChatDetail.TopicInfo) invokeV.objValue;
    }

    public final int g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return ((Number) this.m.getValue()).intValue();
        }
        return invokeV.intValue;
    }

    public final jc8 h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.l;
        }
        return (jc8) invokeV.objValue;
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.k.setVisibility(8);
        }
    }

    public final boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.p == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice, com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            zc8.b.b(this.u);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice, com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.r();
            zc8.b.a(this.u);
        }
    }

    public final void l0(int i) {
        AibotChatDetail aibotChatDetail;
        boolean z;
        List<AbilityItem> sugList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i) == null) && (aibotChatDetail = this.r) != null) {
            List<AibotChatDetail.TopicInfo> topicInfo = aibotChatDetail.getTopicInfo();
            if (topicInfo != null && !topicInfo.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (!z && i >= 0 && i < aibotChatDetail.getTopicInfo().size()) {
                AibotChatDetail.TopicInfo topicInfo2 = aibotChatDetail.getTopicInfo().get(i);
                this.t = topicInfo2;
                if (topicInfo2 != null && (sugList = topicInfo2.getSugList()) != null && !sugList.isEmpty()) {
                    k0(sugList);
                }
            }
        }
    }
}
