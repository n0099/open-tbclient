package com.baidu.tieba.enterForum.callback;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.enterForum.adapter.LikeForumItemAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.j46;
import com.repackage.r46;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LikeForumDragCallBack extends ItemTouchHelper.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public j46 a;
    public LikeForumItemAdapter b;
    public String c;
    public String d;
    public boolean e;

    public LikeForumDragCallBack(LikeForumItemAdapter likeForumItemAdapter, j46 j46Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {likeForumItemAdapter, j46Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = false;
        this.b = likeForumItemAdapter;
        this.a = j46Var;
    }

    public final String a(List<r46> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < list.size(); i++) {
                r46 r46Var = list.get(i);
                if (r46Var != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("forum_id", r46Var.getId());
                        jSONObject.put("sort_value", String.valueOf(r46Var.v()));
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONArray.toString();
        }
        return (String) invokeL.objValue;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, viewHolder) == null) {
            super.clearView(recyclerView, viewHolder);
            j46 j46Var = this.a;
            if (j46Var == null || !this.e) {
                return;
            }
            j46Var.a(this.c, this.d);
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, recyclerView, viewHolder)) == null) {
            if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                return ItemTouchHelper.Callback.makeMovementFlags(15, 0);
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? super.isItemViewSwipeEnabled() : invokeV.booleanValue;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, recyclerView, viewHolder, viewHolder2)) == null) {
            this.e = false;
            this.c = a(this.b.e());
            int adapterPosition = viewHolder.getAdapterPosition();
            int adapterPosition2 = viewHolder2.getAdapterPosition();
            if (adapterPosition2 == this.b.getItemCount() - 1 || adapterPosition == adapterPosition2) {
                return false;
            }
            if (adapterPosition < adapterPosition2) {
                int i = adapterPosition;
                while (i < adapterPosition2) {
                    int i2 = i + 1;
                    Collections.swap(this.b.e(), i, i2);
                    this.e = true;
                    i = i2;
                }
            } else {
                for (int i3 = adapterPosition; i3 > adapterPosition2; i3--) {
                    Collections.swap(this.b.e(), i3, i3 - 1);
                    this.e = true;
                }
            }
            this.d = a(this.b.e());
            this.b.notifyItemMoved(adapterPosition, adapterPosition2);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, viewHolder, i) == null) {
            super.onSelectedChanged(viewHolder, i);
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, viewHolder, i) == null) {
        }
    }
}
