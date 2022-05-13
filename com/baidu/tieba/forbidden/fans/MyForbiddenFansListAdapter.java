package com.baidu.tieba.forbidden.fans;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.mi;
import com.repackage.u96;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class MyForbiddenFansListAdapter extends RecyclerView.Adapter<FansViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ArrayList<u96> b;
    public View.OnClickListener c;
    public View.OnClickListener d;

    /* loaded from: classes3.dex */
    public static class FansViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public ClickableHeaderImageView b;
        public TextView c;
        public TextView d;
        public View e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FansViewHolder(View view2) {
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
            this.a = view2.findViewById(R.id.obfuscated_res_0x7f0906d3);
            ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view2.findViewById(R.id.obfuscated_res_0x7f0923ee);
            this.b = clickableHeaderImageView;
            clickableHeaderImageView.setRadius(mi.f(view2.getContext(), R.dimen.obfuscated_res_0x7f07030b));
            this.b.setAutoChangeStyle(true);
            this.b.setClickable(false);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923ed);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923ef);
            this.e = view2.findViewById(R.id.obfuscated_res_0x7f091263);
        }
    }

    public MyForbiddenFansListAdapter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.a = context;
    }

    public final void d(FansViewHolder fansViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fansViewHolder) == null) {
            SkinManager.setViewTextColor(fansViewHolder.c, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundColor(fansViewHolder.e, R.color.CAM_X0204);
            SkinManager.setViewTextColor(fansViewHolder.d, (int) R.color.btn_color_remove);
            SkinManager.setBackgroundResource(fansViewHolder.d, R.drawable.btn_transparent_focus_border_bg);
        }
    }

    public boolean e(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            if (j != 0 && !ListUtils.isEmpty(this.b)) {
                Iterator<u96> it = this.b.iterator();
                while (it.hasNext()) {
                    u96 next = it.next();
                    if (next != null && next.a == j) {
                        this.b.remove(next);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public ArrayList<u96> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (ArrayList) invokeV.objValue;
    }

    public final u96 g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? (u96) ListUtils.getItem(this.b, i) : (u96) invokeI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ListUtils.getCount(this.b) : invokeV.intValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ListUtils.isEmpty(this.b) : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public void onBindViewHolder(FansViewHolder fansViewHolder, int i) {
        u96 g;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, fansViewHolder, i) == null) || fansViewHolder == null || (g = g(i)) == null) {
            return;
        }
        fansViewHolder.b.K(g.d, 12, false);
        fansViewHolder.c.setText(g.c);
        fansViewHolder.d.setOnClickListener(this.c);
        fansViewHolder.d.setTag(g);
        fansViewHolder.a.setOnClickListener(this.d);
        fansViewHolder.a.setTag(g);
        d(fansViewHolder);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j */
    public FansViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, viewGroup, i)) == null) ? new FansViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d029d, (ViewGroup) null)) : (FansViewHolder) invokeLI.objValue;
    }

    public void k(ArrayList<u96> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) {
            this.b = arrayList;
        }
    }

    public void l(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            this.d = onClickListener;
        }
    }

    public void m(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.c = onClickListener;
        }
    }
}
