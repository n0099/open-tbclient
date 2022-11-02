package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.cy5;
import com.baidu.tieba.dy5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaBannerRecyclerAdapter<T> extends RecyclerView.Adapter<AlaBannerViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<T> a;
    public Context b;
    public cy5 c;
    public dy5 d;
    public boolean e;
    public View.OnClickListener f;

    public void j(cy5 cy5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cy5Var) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaBannerRecyclerAdapter a;

        public a(AlaBannerRecyclerAdapter alaBannerRecyclerAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaBannerRecyclerAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaBannerRecyclerAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.d != null) {
                this.a.d.a(view2.getTag());
            }
        }
    }

    public AlaBannerRecyclerAdapter(Context context, cy5 cy5Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cy5Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new a(this);
        this.b = context;
        this.c = cy5Var;
        this.e = z;
    }

    public final int f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (ListUtils.getCount(this.a) != 0) {
                return i % ListUtils.getCount(this.a);
            }
            return i;
        }
        return invokeI.intValue;
    }

    public void i(dy5 dy5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dy5Var) == null) {
            this.d = dy5Var;
        }
    }

    public void setData(List<T> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.a = list;
        }
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ListUtils.getCount(this.a);
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onBindViewHolder(AlaBannerViewHolder alaBannerViewHolder, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, alaBannerViewHolder, i) == null) && getItemCount() != 0 && alaBannerViewHolder != 0) {
            Object item = ListUtils.getItem(this.a, f(i));
            if (item != null) {
                alaBannerViewHolder.a(i, item);
                alaBannerViewHolder.itemView.setTag(item);
                alaBannerViewHolder.c(TbadkCoreApplication.getInst().getSkinType());
                alaBannerViewHolder.itemView.setOnClickListener(this.f);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!ListUtils.isEmpty(this.a) && ListUtils.getCount(this.a) != 1) {
                if (this.e) {
                    return ListUtils.getCount(this.a) * 3;
                }
                return ListUtils.getCount(this.a);
            }
            return ListUtils.getCount(this.a);
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public AlaBannerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i)) == null) {
            cy5 cy5Var = this.c;
            if (cy5Var != null) {
                return cy5Var.a(viewGroup, i);
            }
            return null;
        }
        return (AlaBannerViewHolder) invokeLI.objValue;
    }
}
