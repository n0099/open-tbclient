package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.v.d.h.a.b;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaBannerRecyclerAdapter<T> extends RecyclerView.Adapter<AlaBannerViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<T> f14227a;

    /* renamed from: b  reason: collision with root package name */
    public Context f14228b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.q0.v.d.h.a.a f14229c;

    /* renamed from: d  reason: collision with root package name */
    public b f14230d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14231e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f14232f;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaBannerRecyclerAdapter f14233e;

        public a(AlaBannerRecyclerAdapter alaBannerRecyclerAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaBannerRecyclerAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14233e = alaBannerRecyclerAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14233e.f14230d == null) {
                return;
            }
            this.f14233e.f14230d.a(view.getTag());
        }
    }

    public AlaBannerRecyclerAdapter(Context context, d.a.q0.v.d.h.a.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14232f = new a(this);
        this.f14228b = context;
        this.f14229c = aVar;
        this.f14231e = z;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ListUtils.getCount(this.f14227a) : invokeV.intValue;
    }

    public final int f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? ListUtils.getCount(this.f14227a) != 0 ? i2 % ListUtils.getCount(this.f14227a) : i2 : invokeI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onBindViewHolder(AlaBannerViewHolder alaBannerViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, alaBannerViewHolder, i2) == null) || getItemCount() == 0 || alaBannerViewHolder == 0) {
            return;
        }
        Object item = ListUtils.getItem(this.f14227a, f(i2));
        if (item != null) {
            alaBannerViewHolder.a(i2, item);
            alaBannerViewHolder.itemView.setTag(item);
            alaBannerViewHolder.c(TbadkCoreApplication.getInst().getSkinType());
            alaBannerViewHolder.itemView.setOnClickListener(this.f14232f);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (ListUtils.isEmpty(this.f14227a) || ListUtils.getCount(this.f14227a) == 1) {
                return ListUtils.getCount(this.f14227a);
            }
            return this.f14231e ? ListUtils.getCount(this.f14227a) * 3 : ListUtils.getCount(this.f14227a);
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public AlaBannerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i2)) == null) {
            d.a.q0.v.d.h.a.a aVar = this.f14229c;
            if (aVar != null) {
                return aVar.a(viewGroup, i2);
            }
            return null;
        }
        return (AlaBannerViewHolder) invokeLI.objValue;
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f14230d = bVar;
        }
    }

    public void j(d.a.q0.v.d.h.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
        }
    }

    public void setData(List<T> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.f14227a = list;
        }
    }
}
