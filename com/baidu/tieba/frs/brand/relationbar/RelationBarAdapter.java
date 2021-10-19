package com.baidu.tieba.frs.brand.relationbar;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.OriForumInfo;
/* loaded from: classes7.dex */
public class RelationBarAdapter extends RecyclerView.Adapter<RelationBarHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f51069a;

    /* renamed from: b  reason: collision with root package name */
    public List<OriForumInfo> f51070b;

    public RelationBarAdapter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51069a = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ListUtils.getCount(this.f51070b) : invokeV.intValue;
    }

    public void setData(List<OriForumInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f51070b = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RelationBarHolder relationBarHolder, int i2) {
        OriForumInfo oriForumInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, relationBarHolder, i2) == null) || (oriForumInfo = (OriForumInfo) ListUtils.getItem(this.f51070b, i2)) == null) {
            return;
        }
        RelationBarCellView relationBarCellView = (RelationBarCellView) relationBarHolder.getRelationBarCellView();
        relationBarCellView.setData(oriForumInfo);
        relationBarCellView.onChangeSkinType();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RelationBarHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i2)) == null) ? new RelationBarHolder(new RelationBarCellView(this.f51069a)) : (RelationBarHolder) invokeLI.objValue;
    }
}
