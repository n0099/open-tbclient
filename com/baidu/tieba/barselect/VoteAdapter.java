package com.baidu.tieba.barselect;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import c.a.r0.x.b.d;
import c.a.r0.x.b.f;
import c.a.r0.x.e.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class VoteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f49809a;

    /* renamed from: b  reason: collision with root package name */
    public f f49810b;

    /* renamed from: c  reason: collision with root package name */
    public List<d> f49811c;

    /* renamed from: d  reason: collision with root package name */
    public int f49812d;

    public VoteAdapter(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f49812d = -1;
        this.f49809a = tbPageContext;
    }

    public int getFirstNotAllowPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f49812d : invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<d> list = this.f49811c;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            List<d> list = this.f49811c;
            if (list == null || list.size() <= i2 || this.f49811c.get(i2).i() != 1 || i2 != 0) {
                return 0;
            }
            return a.f28296c;
        }
        return invokeI.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048579, this, viewHolder, i2) == null) && (viewHolder instanceof VoteViewHolder)) {
            ((VoteViewHolder) viewHolder).setData(i2, this.f49810b);
        }
    }

    public void setFirstNotAllowPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f49812d = i2;
        }
    }

    public void setVoteData(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.f49810b = fVar;
            if (fVar != null) {
                this.f49811c = fVar.b();
            }
            this.f49812d = -1;
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.tieba.barselect.VoteViewHolder' to match base method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i2)) == null) {
            VoteCandidateCard voteCandidateCard = new VoteCandidateCard(this.f49809a.getPageActivity());
            voteCandidateCard.setVoteAdaPter(this);
            return new VoteViewHolder(voteCandidateCard);
        }
        return (VoteViewHolder) invokeLI.objValue;
    }
}
