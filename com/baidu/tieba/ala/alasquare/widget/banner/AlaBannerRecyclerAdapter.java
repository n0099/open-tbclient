package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.r0.a0.f.i.h.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes10.dex */
public class AlaBannerRecyclerAdapter<T> extends RecyclerView.Adapter<AlaBannerViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<T> a;

    /* renamed from: b  reason: collision with root package name */
    public Context f42931b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.a0.f.i.h.a f42932c;

    /* renamed from: d  reason: collision with root package name */
    public b f42933d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42934e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f42935f;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaBannerRecyclerAdapter f42936e;

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
            this.f42936e = alaBannerRecyclerAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f42936e.f42933d == null) {
                return;
            }
            this.f42936e.f42933d.a(view.getTag());
        }
    }

    public AlaBannerRecyclerAdapter(Context context, c.a.r0.a0.f.i.h.a aVar, boolean z) {
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
        this.f42935f = new a(this);
        this.f42931b = context;
        this.f42932c = aVar;
        this.f42934e = z;
    }

    public final int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? ListUtils.getCount(this.a) != 0 ? i2 % ListUtils.getCount(this.a) : i2 : invokeI.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (ListUtils.isEmpty(this.a) || ListUtils.getCount(this.a) == 1) {
                return ListUtils.getCount(this.a);
            }
            return this.f42934e ? ListUtils.getCount(this.a) * 3 : ListUtils.getCount(this.a);
        }
        return invokeV.intValue;
    }

    public int getRealItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ListUtils.getCount(this.a) : invokeV.intValue;
    }

    public void setData(List<T> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.a = list;
        }
    }

    public void setOnBannerClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f42933d = bVar;
        }
    }

    public void setViewHolderAdapter(c.a.r0.a0.f.i.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(AlaBannerViewHolder alaBannerViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, alaBannerViewHolder, i2) == null) || getItemCount() == 0 || alaBannerViewHolder == 0) {
            return;
        }
        Object item = ListUtils.getItem(this.a, b(i2));
        if (item != null) {
            alaBannerViewHolder.bindData(i2, item);
            alaBannerViewHolder.itemView.setTag(item);
            alaBannerViewHolder.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            alaBannerViewHolder.itemView.setOnClickListener(this.f42935f);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public AlaBannerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i2)) == null) {
            c.a.r0.a0.f.i.h.a aVar = this.f42932c;
            if (aVar != null) {
                return aVar.a(viewGroup, i2);
            }
            return null;
        }
        return (AlaBannerViewHolder) invokeLI.objValue;
    }
}
