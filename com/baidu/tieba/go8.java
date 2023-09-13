package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.SingleTextImageAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.TaskInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextGenImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.utility.tag.MaxHeightRecycleView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class go8 extends SingleTextImageAdapter<TextGenImageMsg> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextGenImageMsg a;
        public final /* synthetic */ go8 b;

        public a(go8 go8Var, TextGenImageMsg textGenImageMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go8Var, textGenImageMsg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = go8Var;
            this.a = textGenImageMsg;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            TaskInfo taskInfo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f090e99 && (taskInfo = this.a.getTaskInfo()) != null && taskInfo.isComplete()) {
                this.b.d0(view2.getContext(), this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public go8(@NonNull TbPageContext<?> tbPageContext, @NonNull BdUniqueId bdUniqueId) {
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
    public void M(@NonNull FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, frameLayout) == null) {
            super.M(frameLayout);
            MaxHeightRecycleView g = zo8.g(this.mContext);
            frameLayout.addView(g);
            Context context = this.mContext;
            frameLayout.setTag(R.id.obfuscated_res_0x7f092437, er8.c(context, g, BdUtilHelper.getDimens(context, R.dimen.M_W_X004)));
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.SingleTextImageAdapter
    public void h0(long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str}) == null) {
            TiebaStatic.log(new StatisticItem("c15135").param("obj_type", 2).param("fid", j2).param("room_id", j).param("fname", str).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.SingleTextImageAdapter
    public void i0(long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str}) == null) {
            TiebaStatic.log(new StatisticItem("c15135").param("obj_type", 1).param("fid", j2).param("room_id", j).param("fname", str).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter
    /* renamed from: k0 */
    public void T(int i, @NonNull TextGenImageMsg textGenImageMsg, @NonNull FrameLayout frameLayout, @NonNull List<Object> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), textGenImageMsg, frameLayout, list, Integer.valueOf(i2)}) == null) {
            super.T(i, textGenImageMsg, frameLayout, list, i2);
            fs8 fs8Var = (fs8) frameLayout.getTag(R.id.obfuscated_res_0x7f092437);
            if (fs8Var != null && textGenImageMsg.getSubSkillConfig() != null && !textGenImageMsg.getSubSkillConfig().a.isEmpty()) {
                frameLayout.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(textGenImageMsg);
                fs8Var.d(arrayList);
                return;
            }
            frameLayout.setVisibility(8);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter.SingleTextImageAdapter
    /* renamed from: l0 */
    public void g0(int i, @NonNull ViewGroup viewGroup, @NonNull TextGenImageMsg textGenImageMsg, @NonNull SingleTextImageAdapter.Holder holder, @NonNull List<Object> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), viewGroup, textGenImageMsg, holder, list, Integer.valueOf(i2)}) == null) {
            super.U(i, viewGroup, textGenImageMsg, holder, list, i2);
            holder.a(new a(this, textGenImageMsg));
        }
    }
}
