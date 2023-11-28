package com.baidu.tieba.im.biz.aibot.backgroundslice;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.im.biz.aibot.data.AibotChatDetail;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fH\u0016J\u0016\u0010\u001b\u001a\u00020\u00142\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u001dH\u0007R*\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/backgroundslice/AibotBgAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/baidu/tieba/im/biz/aibot/backgroundslice/AibotBgHolder;", "slice", "Lcom/baidu/tieba/im/biz/aibot/backgroundslice/BackgroundSlice;", "(Lcom/baidu/tieba/im/biz/aibot/backgroundslice/BackgroundSlice;)V", "bots", "Ljava/util/ArrayList;", "Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail$BotList;", "Lkotlin/collections/ArrayList;", "getBots", "()Ljava/util/ArrayList;", "setBots", "(Ljava/util/ArrayList;)V", "getItemCount", "", "getPositionByUk", "uk", "", "onBindViewHolder", "", "holderAibot", CriusAttrConstants.POSITION, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", IntentConfig.DATAS, "", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AibotBgAdapter extends RecyclerView.Adapter<AibotBgHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BackgroundSlice a;
    public ArrayList<AibotChatDetail.BotList> b;

    public AibotBgAdapter(BackgroundSlice slice) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {slice};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(slice, "slice");
        this.a = slice;
        this.b = new ArrayList<>();
    }

    public final int n(String uk) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uk)) == null) {
            Intrinsics.checkNotNullParameter(uk, "uk");
            int i = 0;
            int i2 = 0;
            for (Object obj : this.b) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                if (Intrinsics.areEqual(uk, ((AibotChatDetail.BotList) obj).getUk())) {
                    i = i2;
                }
                i2 = i3;
            }
            return i;
        }
        return invokeL.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b.size();
        }
        return invokeV.intValue;
    }

    public final ArrayList<AibotChatDetail.BotList> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (ArrayList) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onBindViewHolder(AibotBgHolder holderAibot, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, holderAibot, i) == null) {
            Intrinsics.checkNotNullParameter(holderAibot, "holderAibot");
            AibotChatDetail.BotList botList = this.b.get(i);
            Intrinsics.checkNotNullExpressionValue(botList, "bots[position]");
            BackgroundSlice backgroundSlice = this.a;
            String background = botList.getBackground();
            View a = holderAibot.a();
            Intrinsics.checkNotNullExpressionValue(a, "holderAibot.bg");
            backgroundSlice.v0(background, a);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public AibotBgHolder onCreateViewHolder(ViewGroup parent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, parent, i)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.obfuscated_res_0x7f0d017d, parent, false);
            Intrinsics.checkNotNullExpressionValue(root, "root");
            return new AibotBgHolder(root);
        }
        return (AibotBgHolder) invokeLI.objValue;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void setData(List<AibotChatDetail.BotList> datas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, datas) == null) {
            Intrinsics.checkNotNullParameter(datas, "datas");
            if (!this.b.isEmpty()) {
                return;
            }
            if (!datas.isEmpty()) {
                this.b.addAll(datas);
            }
            notifyDataSetChanged();
        }
    }
}
