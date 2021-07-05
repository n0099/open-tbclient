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
import d.a.c.e.p.l;
import d.a.s0.r0.a.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class MyForbiddenFansListAdapter extends RecyclerView.Adapter<FansViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f15162a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f15163b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f15164c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f15165d;

    /* loaded from: classes5.dex */
    public static class FansViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f15166a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f15167b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f15168c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15169d;

        /* renamed from: e  reason: collision with root package name */
        public View f15170e;

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
            this.f15166a = view.findViewById(R.id.container_forbidden_item);
            ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.view_fans_photo);
            this.f15167b = clickableHeaderImageView;
            clickableHeaderImageView.setRadius(l.g(view.getContext(), R.dimen.ds90));
            this.f15167b.setAutoChangeStyle(true);
            this.f15167b.setClickable(false);
            this.f15168c = (TextView) view.findViewById(R.id.view_fans_name);
            this.f15169d = (TextView) view.findViewById(R.id.view_fans_remove);
            this.f15170e = view.findViewById(R.id.line_divider);
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
        this.f15164c = null;
        this.f15165d = null;
        this.f15162a = context;
    }

    public final void d(FansViewHolder fansViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fansViewHolder) == null) {
            SkinManager.setViewTextColor(fansViewHolder.f15168c, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(fansViewHolder.f15170e, R.color.CAM_X0204);
            SkinManager.setViewTextColor(fansViewHolder.f15169d, R.color.btn_color_remove);
            SkinManager.setBackgroundResource(fansViewHolder.f15169d, R.drawable.btn_transparent_focus_border_bg);
        }
    }

    public boolean e(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            if (j != 0 && !ListUtils.isEmpty(this.f15163b)) {
                Iterator<a> it = this.f15163b.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null && next.f64998a == j) {
                        this.f15163b.remove(next);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ListUtils.getCount(this.f15163b) : invokeV.intValue;
    }

    public ArrayList<a> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15163b : (ArrayList) invokeV.objValue;
    }

    public final a n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? (a) ListUtils.getItem(this.f15163b, i2) : (a) invokeI.objValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ListUtils.isEmpty(this.f15163b) : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public void onBindViewHolder(FansViewHolder fansViewHolder, int i2) {
        a n;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, fansViewHolder, i2) == null) || fansViewHolder == null || (n = n(i2)) == null) {
            return;
        }
        fansViewHolder.f15167b.M(n.f65001d, 12, false);
        fansViewHolder.f15168c.setText(n.f65000c);
        fansViewHolder.f15169d.setOnClickListener(this.f15164c);
        fansViewHolder.f15169d.setTag(n);
        fansViewHolder.f15166a.setOnClickListener(this.f15165d);
        fansViewHolder.f15166a.setTag(n);
        d(fansViewHolder);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q */
    public FansViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, viewGroup, i2)) == null) ? new FansViewHolder(LayoutInflater.from(this.f15162a).inflate(R.layout.forbidden_fans_item, (ViewGroup) null)) : (FansViewHolder) invokeLI.objValue;
    }

    public void r(ArrayList<a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, arrayList) == null) {
            this.f15163b = arrayList;
        }
    }

    public void s(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.f15165d = onClickListener;
        }
    }

    public void t(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.f15164c = onClickListener;
        }
    }
}
