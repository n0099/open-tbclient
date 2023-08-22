package com.baidu.tieba.barselect;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.tieba.lh6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class VoteViewHolder extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VoteCandidateCard a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoteViewHolder(View view2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
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
        if (view2 instanceof VoteCandidateCard) {
            this.a = (VoteCandidateCard) view2;
        }
    }

    public void b(int i, lh6 lh6Var) {
        VoteCandidateCard voteCandidateCard;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048576, this, i, lh6Var) == null) && (voteCandidateCard = this.a) != null) {
            voteCandidateCard.setData(i, lh6Var);
        }
    }
}
