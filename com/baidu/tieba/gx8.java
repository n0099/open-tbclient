package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialBarFeedActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.immessagecenter.StrangerListActivityConfig;
import com.baidu.tieba.immessagecenter.im.chat.notify.MessageAggregationListAdapter;
import com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgChatCenterSliceView;
import com.baidu.tieba.immessagecenter.msgtab.ui.vm.MsgChatCenterSliceViewModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class gx8 implements AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final BdUniqueId b;
    public final MsgChatCenterSliceView c;
    public final MessageAggregationListAdapter d;
    public final MsgChatCenterSliceViewModel e;

    public gx8(Context context, BdUniqueId uniqueId, MsgChatCenterSliceView sliceView, MessageAggregationListAdapter messageAggregationListAdapter, MsgChatCenterSliceViewModel viewModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, uniqueId, sliceView, messageAggregationListAdapter, viewModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(sliceView, "sliceView");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.a = context;
        this.b = uniqueId;
        this.c = sliceView;
        this.d = messageAggregationListAdapter;
        this.e = viewModel;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        boolean z;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || i < 0) {
            return;
        }
        MessageAggregationListAdapter messageAggregationListAdapter = this.d;
        String str3 = null;
        if (messageAggregationListAdapter != null) {
            imMessageCenterShowItemData = messageAggregationListAdapter.getItem(i);
        } else {
            imMessageCenterShowItemData = null;
        }
        if (imMessageCenterShowItemData != null && imMessageCenterShowItemData.getDataType() == 2) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a).createNormalCfg(imMessageCenterShowItemData.getForumName(), FrsActivityConfig.FRS_FROM_IM_REC_FORUM)));
            lz8.a.f(imMessageCenterShowItemData);
            return;
        }
        if (imMessageCenterShowItemData != null) {
            lz8.a.d(imMessageCenterShowItemData, this.a);
        }
        StatisticItem statisticItem = new StatisticItem("c13720");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        if (imMessageCenterShowItemData != null) {
            str = imMessageCenterShowItemData.getOwnerName();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            nz8.a(imMessageCenterShowItemData, this.a, this.b);
            statisticItem.param("obj_type", 6);
        } else if (Intrinsics.areEqual(str, "5")) {
            TiebaStatic.log("c12931");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialBarFeedActivityConfig(this.a)));
        } else if (Intrinsics.areEqual(str, "8")) {
            long j2 = JavaTypesHelper.toLong(imMessageCenterShowItemData.getFriendId(), 0L);
            OfficalBarChatActivityConfig officalBarChatActivityConfig = new OfficalBarChatActivityConfig(this.a, j2, imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0, imMessageCenterShowItemData.getUserType());
            lz8.a.g(j2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, officalBarChatActivityConfig));
        } else if (Intrinsics.areEqual(str, "7")) {
            TiebaStatic.log(new StatisticItem("c12614"));
            statisticItem.param("obj_type", 6);
            lz8.a.e(imMessageCenterShowItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(this.a)));
            return;
        } else if (Intrinsics.areEqual(str, "9")) {
            this.c.W(imMessageCenterShowItemData);
            if (imMessageCenterShowItemData.getAtInfoData() != null) {
                imMessageCenterShowItemData.setAtInfoData(null);
            }
            imMessageCenterShowItemData.setUnReadCount(0);
            this.e.B(false);
            this.e.o().V(JavaTypesHelper.toLong(imMessageCenterShowItemData.getFriendId(), 0L));
            this.e.E(null, imMessageCenterShowItemData, 2);
            lz8.a.c(imMessageCenterShowItemData);
            this.e.o().J();
        } else {
            nz8.a(imMessageCenterShowItemData, this.a, this.b);
            statisticItem.param("obj_type", 6);
        }
        if (imMessageCenterShowItemData != null) {
            str2 = imMessageCenterShowItemData.getFriendName();
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            if (imMessageCenterShowItemData != null) {
                str3 = imMessageCenterShowItemData.getFriendName();
            }
            if (Intrinsics.areEqual(str3, this.a.getString(R.string.obfuscated_res_0x7f0f0cd9))) {
                statisticItem.param("obj_type", 8);
            } else if (Intrinsics.areEqual(str3, this.a.getString(R.string.obfuscated_res_0x7f0f0cdc))) {
                statisticItem.param("obj_type", 9);
            } else if (Intrinsics.areEqual(str3, this.a.getString(R.string.obfuscated_res_0x7f0f0cda))) {
                statisticItem.param("obj_type", 10);
            } else if (Intrinsics.areEqual(str3, this.a.getString(R.string.obfuscated_res_0x7f0f0cd5))) {
                statisticItem.param("obj_type", 4);
            } else if (Intrinsics.areEqual(str3, this.a.getString(R.string.obfuscated_res_0x7f0f0cd7))) {
                statisticItem.param("obj_type", 5);
            }
        }
        TiebaStatic.log(statisticItem);
        if (imMessageCenterShowItemData != null) {
            lz8.a.b(imMessageCenterShowItemData, this.a);
        }
    }
}
