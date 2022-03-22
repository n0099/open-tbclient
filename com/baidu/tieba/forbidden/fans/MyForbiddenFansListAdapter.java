package com.baidu.tieba.forbidden.fans;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.n;
import c.a.p0.b1.a.a;
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
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class MyForbiddenFansListAdapter extends RecyclerView.Adapter<FansViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f32176b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f32177c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f32178d;

    /* loaded from: classes5.dex */
    public static class FansViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f32179b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f32180c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f32181d;

        /* renamed from: e  reason: collision with root package name */
        public View f32182e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FansViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
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
            this.a = view.findViewById(R.id.obfuscated_res_0x7f0906cf);
            ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.obfuscated_res_0x7f0923bf);
            this.f32179b = clickableHeaderImageView;
            clickableHeaderImageView.setRadius(n.f(view.getContext(), R.dimen.obfuscated_res_0x7f070301));
            this.f32179b.setAutoChangeStyle(true);
            this.f32179b.setClickable(false);
            this.f32180c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0923be);
            this.f32181d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0923c0);
            this.f32182e = view.findViewById(R.id.obfuscated_res_0x7f091260);
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
        this.f32177c = null;
        this.f32178d = null;
        this.a = context;
    }

    public final void d(FansViewHolder fansViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fansViewHolder) == null) {
            SkinManager.setViewTextColor(fansViewHolder.f32180c, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundColor(fansViewHolder.f32182e, R.color.CAM_X0204);
            SkinManager.setViewTextColor(fansViewHolder.f32181d, (int) R.color.btn_color_remove);
            SkinManager.setBackgroundResource(fansViewHolder.f32181d, R.drawable.btn_transparent_focus_border_bg);
        }
    }

    public boolean e(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            if (j != 0 && !ListUtils.isEmpty(this.f32176b)) {
                Iterator<a> it = this.f32176b.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null && next.a == j) {
                        this.f32176b.remove(next);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public ArrayList<a> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32176b : (ArrayList) invokeV.objValue;
    }

    public final a g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? (a) ListUtils.getItem(this.f32176b, i) : (a) invokeI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ListUtils.getCount(this.f32176b) : invokeV.intValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ListUtils.isEmpty(this.f32176b) : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public void onBindViewHolder(FansViewHolder fansViewHolder, int i) {
        a g2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, fansViewHolder, i) == null) || fansViewHolder == null || (g2 = g(i)) == null) {
            return;
        }
        fansViewHolder.f32179b.J(g2.f12463d, 12, false);
        fansViewHolder.f32180c.setText(g2.f12462c);
        fansViewHolder.f32181d.setOnClickListener(this.f32177c);
        fansViewHolder.f32181d.setTag(g2);
        fansViewHolder.a.setOnClickListener(this.f32178d);
        fansViewHolder.a.setTag(g2);
        d(fansViewHolder);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j */
    public FansViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, viewGroup, i)) == null) ? new FansViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d02a4, (ViewGroup) null)) : (FansViewHolder) invokeLI.objValue;
    }

    public void k(ArrayList<a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) {
            this.f32176b = arrayList;
        }
    }

    public void l(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            this.f32178d = onClickListener;
        }
    }

    public void m(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.f32177c = onClickListener;
        }
    }
}
