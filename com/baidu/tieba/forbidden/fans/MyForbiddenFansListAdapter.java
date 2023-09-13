package com.baidu.tieba.forbidden.fans;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.if7;
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
    public ArrayList<if7> b;
    public View.OnClickListener c;
    public View.OnClickListener d;

    /* loaded from: classes5.dex */
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
            this.a = view2.findViewById(R.id.obfuscated_res_0x7f0907b0);
            ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view2.findViewById(R.id.obfuscated_res_0x7f0929a6);
            this.b = clickableHeaderImageView;
            clickableHeaderImageView.setRadius(BdUtilHelper.getDimens(view2.getContext(), R.dimen.obfuscated_res_0x7f070426));
            this.b.setAutoChangeStyle(true);
            this.b.setClickable(false);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0929a5);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0929a7);
            this.e = view2.findViewById(R.id.obfuscated_res_0x7f09153a);
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

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ListUtils.getCount(this.b);
        }
        return invokeV.intValue;
    }

    public ArrayList<if7> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return ListUtils.isEmpty(this.b);
        }
        return invokeV.booleanValue;
    }

    public final void l(FansViewHolder fansViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fansViewHolder) == null) {
            SkinManager.setViewTextColor(fansViewHolder.c, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundColor(fansViewHolder.e, R.color.CAM_X0204);
            SkinManager.setViewTextColor(fansViewHolder.d, (int) R.color.btn_color_remove);
            SkinManager.setBackgroundResource(fansViewHolder.d, R.drawable.btn_transparent_focus_border_bg);
        }
    }

    public final if7 o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return (if7) ListUtils.getItem(this.b, i);
        }
        return (if7) invokeI.objValue;
    }

    public void s(ArrayList<if7> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, arrayList) == null) {
            this.b = arrayList;
        }
    }

    public void t(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.d = onClickListener;
        }
    }

    public void u(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.c = onClickListener;
        }
    }

    public boolean m(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            if (j == 0 || ListUtils.isEmpty(this.b)) {
                return false;
            }
            if7 if7Var = null;
            Iterator<if7> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if7 next = it.next();
                if (next != null && next.a == j) {
                    if7Var = next;
                    break;
                }
            }
            if (if7Var != null) {
                this.b.remove(if7Var);
            }
            if (if7Var == null) {
                return false;
            }
            return true;
        }
        return invokeJ.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: r */
    public FansViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, viewGroup, i)) == null) {
            return new FansViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d02ef, (ViewGroup) null));
        }
        return (FansViewHolder) invokeLI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q */
    public void onBindViewHolder(FansViewHolder fansViewHolder, int i) {
        if7 o;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, fansViewHolder, i) != null) || fansViewHolder == null || (o = o(i)) == null) {
            return;
        }
        fansViewHolder.b.startLoad(o.d, 12, false);
        fansViewHolder.c.setText(o.c);
        fansViewHolder.d.setOnClickListener(this.c);
        fansViewHolder.d.setTag(o);
        fansViewHolder.a.setOnClickListener(this.d);
        fansViewHolder.a.setTag(o);
        l(fansViewHolder);
    }
}
