package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.SingleTextImageAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextGenImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.utility.tag.MaxHeightRecycleView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class ev7 extends SingleTextImageAdapter<TextGenImageMsg> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ev7(@NonNull TbPageContext<?> tbPageContext, @NonNull BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    public void E(@NonNull FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, frameLayout) == null) {
            super.E(frameLayout);
            MaxHeightRecycleView f = ov7.f(this.mContext);
            frameLayout.addView(f);
            Context context = this.mContext;
            frameLayout.setTag(R.id.obfuscated_res_0x7f09226b, ww7.c(context, f, hi.g(context, R.dimen.M_W_X004)));
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.SingleTextImageAdapter
    public void W(long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str}) == null) {
            TiebaStatic.log(new StatisticItem("c15135").param("obj_type", 2).param("fid", j2).param("room_id", j).param("fname", str).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.SingleTextImageAdapter
    public void X(long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str}) == null) {
            TiebaStatic.log(new StatisticItem("c15135").param("obj_type", 1).param("fid", j2).param("room_id", j).param("fname", str).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    /* renamed from: Y */
    public void M(int i, @NonNull TextGenImageMsg textGenImageMsg, @NonNull FrameLayout frameLayout, @NonNull List<Object> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), textGenImageMsg, frameLayout, list, Integer.valueOf(i2)}) == null) {
            super.M(i, textGenImageMsg, frameLayout, list, i2);
            qx7 qx7Var = (qx7) frameLayout.getTag(R.id.obfuscated_res_0x7f09226b);
            if (qx7Var != null && textGenImageMsg.getSubSkillConfig() != null && !textGenImageMsg.getSubSkillConfig().a.isEmpty()) {
                frameLayout.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(textGenImageMsg);
                qx7Var.d(arrayList);
                return;
            }
            frameLayout.setVisibility(8);
        }
    }
}
