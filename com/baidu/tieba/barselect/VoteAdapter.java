package com.baidu.tieba.barselect;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.tieba.hi6;
import com.baidu.tieba.ji6;
import com.baidu.tieba.qi6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class VoteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public ji6 b;
    public List<hi6> c;
    public int d;

    public VoteAdapter(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = -1;
        this.a = tbPageContext;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            List<hi6> list = this.c;
            if (list != null && list.size() > i && this.c.get(i).i() == 1 && i == 0) {
                return qi6.c;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.d = i;
        }
    }

    public void o(ji6 ji6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ji6Var) == null) {
            this.b = ji6Var;
            if (ji6Var != null) {
                this.c = ji6Var.b();
            }
            this.d = -1;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<hi6> list = this.c;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m */
    public VoteViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i)) == null) {
            VoteCandidateCard voteCandidateCard = new VoteCandidateCard(this.a.getPageActivity());
            voteCandidateCard.setVoteAdaPter(this);
            return new VoteViewHolder(voteCandidateCard);
        }
        return (VoteViewHolder) invokeLI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048582, this, viewHolder, i) == null) && (viewHolder instanceof VoteViewHolder)) {
            ((VoteViewHolder) viewHolder).a(i, this.b);
        }
    }
}
