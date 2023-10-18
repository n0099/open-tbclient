package com.baidu.tieba.enterForum.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.viewholder.LikeForumCreateViewHolder;
import com.baidu.tieba.enterForum.viewholder.LikeForumItemViewHolder;
import com.baidu.tieba.mv6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class LikeForumItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<mv6> b;
    public ViewEventCenter c;
    public View.OnClickListener d;
    public b e;

    /* loaded from: classes5.dex */
    public interface b {
        boolean a(Object obj, RecyclerView.ViewHolder viewHolder);
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LikeForumItemAdapter a;

        public a(LikeForumItemAdapter likeForumItemAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {likeForumItemAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = likeForumItemAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.d != null) {
                this.a.d.onClick(view2);
            }
        }
    }

    public LikeForumItemAdapter(TbPageContext tbPageContext, List<mv6> list, ViewEventCenter viewEventCenter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, list, viewEventCenter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.b = list;
        this.c = viewEventCenter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i == getItemCount() - 1) {
                return 1;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public void n(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.d = onClickListener;
        }
    }

    public void o(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.e = bVar;
        }
    }

    public void p(List<mv6> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.b = list;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<mv6> list = this.b;
            if (list == null) {
                return 1;
            }
            return 1 + list.size();
        }
        return invokeV.intValue;
    }

    public List<mv6> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<mv6> list = this.b;
            if (list == null) {
                return new ArrayList();
            }
            return list;
        }
        return (List) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, viewHolder, i) == null) {
            if (i == getItemCount() - 1) {
                if (viewHolder instanceof LikeForumCreateViewHolder) {
                    ((LikeForumCreateViewHolder) viewHolder).a();
                    return;
                }
                return;
            }
            List<mv6> list = this.b;
            if (list != null && list.size() >= i && (viewHolder instanceof LikeForumItemViewHolder)) {
                ((LikeForumItemViewHolder) viewHolder).e(this.b.get(i));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i)) == null) {
            if (i == 1) {
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0605, viewGroup, false);
                inflate.setOnClickListener(new a(this));
                return new LikeForumCreateViewHolder(inflate);
            }
            LikeForumItemViewHolder likeForumItemViewHolder = new LikeForumItemViewHolder(this.a, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d05b3, viewGroup, false), this.c);
            likeForumItemViewHolder.h(this.e);
            return likeForumItemViewHolder;
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }
}
