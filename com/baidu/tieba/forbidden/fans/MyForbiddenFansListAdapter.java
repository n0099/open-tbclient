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
import d.a.d.e.p.l;
import d.a.q0.r0.a.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class MyForbiddenFansListAdapter extends RecyclerView.Adapter<FansViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f15249a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f15250b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f15251c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f15252d;

    /* loaded from: classes4.dex */
    public static class FansViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f15253a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f15254b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f15255c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15256d;

        /* renamed from: e  reason: collision with root package name */
        public View f15257e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FansViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15253a = view.findViewById(R.id.container_forbidden_item);
            ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.view_fans_photo);
            this.f15254b = clickableHeaderImageView;
            clickableHeaderImageView.setRadius(l.g(view.getContext(), R.dimen.ds90));
            this.f15254b.setAutoChangeStyle(true);
            this.f15254b.setClickable(false);
            this.f15255c = (TextView) view.findViewById(R.id.view_fans_name);
            this.f15256d = (TextView) view.findViewById(R.id.view_fans_remove);
            this.f15257e = view.findViewById(R.id.line_divider);
        }
    }

    public MyForbiddenFansListAdapter(Context context) {
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
        this.f15251c = null;
        this.f15252d = null;
        this.f15249a = context;
    }

    public final void d(FansViewHolder fansViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fansViewHolder) == null) {
            SkinManager.setViewTextColor(fansViewHolder.f15255c, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(fansViewHolder.f15257e, R.color.CAM_X0204);
            SkinManager.setViewTextColor(fansViewHolder.f15256d, R.color.btn_color_remove);
            SkinManager.setBackgroundResource(fansViewHolder.f15256d, R.drawable.btn_transparent_focus_border_bg);
        }
    }

    public boolean e(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            if (j != 0 && !ListUtils.isEmpty(this.f15250b)) {
                Iterator<a> it = this.f15250b.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null && next.f62390a == j) {
                        this.f15250b.remove(next);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15250b : (ArrayList) invokeV.objValue;
    }

    public final a g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? (a) ListUtils.getItem(this.f15250b, i2) : (a) invokeI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ListUtils.getCount(this.f15250b) : invokeV.intValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ListUtils.isEmpty(this.f15250b) : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public void onBindViewHolder(FansViewHolder fansViewHolder, int i2) {
        a g2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, fansViewHolder, i2) == null) || fansViewHolder == null || (g2 = g(i2)) == null) {
            return;
        }
        fansViewHolder.f15254b.M(g2.f62393d, 12, false);
        fansViewHolder.f15255c.setText(g2.f62392c);
        fansViewHolder.f15256d.setOnClickListener(this.f15251c);
        fansViewHolder.f15256d.setTag(g2);
        fansViewHolder.f15253a.setOnClickListener(this.f15252d);
        fansViewHolder.f15253a.setTag(g2);
        d(fansViewHolder);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j */
    public FansViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, viewGroup, i2)) == null) ? new FansViewHolder(LayoutInflater.from(this.f15249a).inflate(R.layout.forbidden_fans_item, (ViewGroup) null)) : (FansViewHolder) invokeLI.objValue;
    }

    public void k(ArrayList<a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) {
            this.f15250b = arrayList;
        }
    }

    public void l(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            this.f15252d = onClickListener;
        }
    }

    public void m(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.f15251c = onClickListener;
        }
    }
}
