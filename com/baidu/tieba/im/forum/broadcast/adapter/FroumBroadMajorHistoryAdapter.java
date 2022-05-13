package com.baidu.tieba.im.forum.broadcast.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.i67;
import com.repackage.mi;
import com.repackage.vm4;
import com.repackage.yu4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class FroumBroadMajorHistoryAdapter extends RecyclerView.Adapter<FroumBroadMajorHistoryItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public List<i67> b;
    public vm4<i67> c;

    /* loaded from: classes3.dex */
    public static class FroumBroadMajorHistoryItemViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public TextView c;
        public TextView d;
        public TextView e;
        public TextView f;
        public TextView g;
        public TextView h;
        public TextView i;
        public LinearLayout j;
        public LinearLayout k;
        public LinearLayout l;
        public LinearLayout m;
        public BarImageView n;
        public TbImageView o;
        public View p;
        public View q;
        public View r;
        public TBSpecificationBtn s;
        public RelativeLayout t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FroumBroadMajorHistoryItemViewHolder(View view2) {
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
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090339);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a5e);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09033a);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090335);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919a0);
            this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919d8);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09072f);
            this.j = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090336);
            this.k = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090337);
            this.n = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f090a1b);
            this.o = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090fe2);
            this.p = view2.findViewById(R.id.obfuscated_res_0x7f090a1e);
            this.l = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090a1d);
            this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a1c);
            this.s = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f090a3c);
            this.m = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090a62);
            this.t = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906d4);
            this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090338);
            this.r = view2.findViewById(R.id.obfuscated_res_0x7f090362);
            this.q = view2.findViewById(R.id.obfuscated_res_0x7f090cd5);
        }
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i67 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ FroumBroadMajorHistoryAdapter c;

        public a(FroumBroadMajorHistoryAdapter froumBroadMajorHistoryAdapter, i67 i67Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {froumBroadMajorHistoryAdapter, i67Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = froumBroadMajorHistoryAdapter;
            this.a = i67Var;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.c.c == null) {
                return;
            }
            vm4 vm4Var = this.c.c;
            i67 i67Var = this.a;
            int i = this.b;
            vm4Var.a(view2, i67Var, i, i);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i67 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ FroumBroadMajorHistoryAdapter c;

        public b(FroumBroadMajorHistoryAdapter froumBroadMajorHistoryAdapter, i67 i67Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {froumBroadMajorHistoryAdapter, i67Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = froumBroadMajorHistoryAdapter;
            this.a = i67Var;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.c.c == null) {
                return;
            }
            vm4 vm4Var = this.c.c;
            i67 i67Var = this.a;
            int i = this.b;
            vm4Var.a(view2, i67Var, i, i);
        }
    }

    public FroumBroadMajorHistoryAdapter(Context context) {
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
        this.a = context;
        this.b = new ArrayList();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public void onBindViewHolder(@NonNull FroumBroadMajorHistoryItemViewHolder froumBroadMajorHistoryItemViewHolder, int i) {
        i67 i67Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, froumBroadMajorHistoryItemViewHolder, i) == null) || (i67Var = this.b.get(i)) == null) {
            return;
        }
        if (i == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.a.getLayoutParams();
            layoutParams.topMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.tbds62);
            froumBroadMajorHistoryItemViewHolder.a.setLayoutParams(layoutParams);
        }
        if (TimeHelper.isSameYear(i67Var.g() * 1000)) {
            froumBroadMajorHistoryItemViewHolder.a.setText(StringHelper.getDateStringMHH(i67Var.g() * 1000));
        } else {
            froumBroadMajorHistoryItemViewHolder.a.setText(StringHelper.getDateStringYMH(i67Var.g() * 1000));
        }
        if (StringUtils.isNull(i67Var.f())) {
            froumBroadMajorHistoryItemViewHolder.t.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.i.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.i.setText(i67Var.k());
        } else {
            froumBroadMajorHistoryItemViewHolder.t.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.i.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.c.setText(i67Var.k());
            froumBroadMajorHistoryItemViewHolder.o.setConrers(15);
            froumBroadMajorHistoryItemViewHolder.o.setRadius(mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            froumBroadMajorHistoryItemViewHolder.o.setDrawCorner(true);
            froumBroadMajorHistoryItemViewHolder.o.setPlaceHolder(2);
            froumBroadMajorHistoryItemViewHolder.o.K(i67Var.f(), 10, false);
            froumBroadMajorHistoryItemViewHolder.o.setGifIconSupport(false);
        }
        if (StringUtils.isNull(i67Var.c())) {
            froumBroadMajorHistoryItemViewHolder.d.setVisibility(8);
        } else {
            froumBroadMajorHistoryItemViewHolder.d.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.d.setText(i67Var.c());
        }
        froumBroadMajorHistoryItemViewHolder.b.setText(i67Var.e().forum_name);
        froumBroadMajorHistoryItemViewHolder.n.setShowOval(true);
        froumBroadMajorHistoryItemViewHolder.n.setAutoChangeStyle(true);
        froumBroadMajorHistoryItemViewHolder.n.setStrokeWith(mi.f(this.a, R.dimen.tbds1));
        froumBroadMajorHistoryItemViewHolder.n.setStrokeColorResId(R.color.CAM_X0401);
        froumBroadMajorHistoryItemViewHolder.n.setShowOuterBorder(false);
        froumBroadMajorHistoryItemViewHolder.n.setShowInnerBorder(true);
        froumBroadMajorHistoryItemViewHolder.n.setPlaceHolder(1);
        froumBroadMajorHistoryItemViewHolder.n.K(i67Var.e().avatar, 10, false);
        froumBroadMajorHistoryItemViewHolder.e.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0656, StringHelper.numberUniformFormatExtraWithRoundVote(i67Var.h())));
        froumBroadMajorHistoryItemViewHolder.f.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0657, StringHelper.numberUniformFormatExtraWithRoundVote(i67Var.i())));
        int parseFloat = (int) (Float.parseFloat(i67Var.d()) * 100.0f);
        if (parseFloat < 0) {
            parseFloat = 0;
        } else if (parseFloat > 100) {
            parseFloat = 100;
        }
        if (!StringUtils.isNull(i67Var.d())) {
            froumBroadMajorHistoryItemViewHolder.g.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0652, Integer.valueOf(parseFloat), "%"));
        } else {
            froumBroadMajorHistoryItemViewHolder.g.setText("0%");
        }
        if (i67Var.j() == null) {
            froumBroadMajorHistoryItemViewHolder.l.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.s.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.h.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0655));
            if (i67Var.a() == 1 || i67Var.a() == 6) {
                froumBroadMajorHistoryItemViewHolder.m.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.p.setVisibility(8);
            } else {
                froumBroadMajorHistoryItemViewHolder.m.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.p.setVisibility(0);
            }
        } else if (i67Var.j().is_deleted.intValue() == 1) {
            froumBroadMajorHistoryItemViewHolder.l.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.s.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.h.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0655));
            if (i67Var.a() == 1 || i67Var.a() == 6) {
                froumBroadMajorHistoryItemViewHolder.m.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.p.setVisibility(8);
            } else {
                froumBroadMajorHistoryItemViewHolder.m.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.p.setVisibility(0);
            }
        } else if (i67Var.a() == 1) {
            froumBroadMajorHistoryItemViewHolder.m.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.p.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.l.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.s.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.h.setText(this.a.getString(R.string.obfuscated_res_0x7f0f1520));
        } else if (i67Var.a() == 6) {
            froumBroadMajorHistoryItemViewHolder.m.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.p.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.l.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.s.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.h.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0651));
            froumBroadMajorHistoryItemViewHolder.s.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0519));
            froumBroadMajorHistoryItemViewHolder.s.setTextSize(R.dimen.tbds34);
            yu4 yu4Var = new yu4();
            yu4Var.r(R.color.CAM_X0302);
            froumBroadMajorHistoryItemViewHolder.s.setConfig(yu4Var);
            froumBroadMajorHistoryItemViewHolder.s.setOnClickListener(new a(this, i67Var, i));
        } else if (i67Var.a() == 10) {
            froumBroadMajorHistoryItemViewHolder.m.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.p.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.l.setVisibility(8);
        }
        froumBroadMajorHistoryItemViewHolder.k.setOnClickListener(new b(this, i67Var, i));
        f(froumBroadMajorHistoryItemViewHolder, i67Var, i);
    }

    public final void f(FroumBroadMajorHistoryItemViewHolder froumBroadMajorHistoryItemViewHolder, i67 i67Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, froumBroadMajorHistoryItemViewHolder, i67Var, i) == null) {
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.a, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.c, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.d, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.e, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.g, (int) R.color.CAM_X0107);
            SkinManager.setBackgroundColor(froumBroadMajorHistoryItemViewHolder.p, R.color.CAM_X0203);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.i, (int) R.color.CAM_X0105);
            TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0601, R.color.CAM_X0606).blRadius(mi.f(this.a, R.dimen.tbds21)).brRadius(mi.f(this.a, R.dimen.tbds21)).into(froumBroadMajorHistoryItemViewHolder.q);
            if (TbadkCoreApplication.getInst().getSkinType() != 0) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.k.getLayoutParams();
                layoutParams.leftMargin = mi.f(this.a, R.dimen.tbds21);
                layoutParams.rightMargin = mi.f(this.a, R.dimen.tbds21);
                layoutParams.topMargin = mi.f(this.a, R.dimen.tbds21);
                froumBroadMajorHistoryItemViewHolder.k.setLayoutParams(layoutParams);
                froumBroadMajorHistoryItemViewHolder.k.setPadding(0, 0, 0, this.a.getResources().getDimensionPixelOffset(R.dimen.tbds54));
                froumBroadMajorHistoryItemViewHolder.r.setVisibility(8);
                TBSelector.makeDrawableSelector().setShape(0).cornerRadius(mi.f(this.a, R.dimen.tbds31)).defaultColor(R.color.CAM_X0205).into(froumBroadMajorHistoryItemViewHolder.k);
            } else {
                if (i != 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.a.getLayoutParams();
                    layoutParams2.topMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.tbds57);
                    froumBroadMajorHistoryItemViewHolder.a.setLayoutParams(layoutParams2);
                }
                froumBroadMajorHistoryItemViewHolder.k.setPadding(this.a.getResources().getDimensionPixelOffset(R.dimen.tbds23), this.a.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.a.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.a.getResources().getDimensionPixelOffset(R.dimen.tbds75));
                froumBroadMajorHistoryItemViewHolder.r.setVisibility(0);
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(mi.f(this.a, R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(mi.f(this.a, R.dimen.tbds10)).setOffsetX(0).setOffsetY(mi.f(this.a, R.dimen.tbds5)).into(froumBroadMajorHistoryItemViewHolder.r);
            }
            if (i67Var.j() == null) {
                SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.h, (int) R.color.CAM_X0109);
            } else if (i67Var.j().is_deleted.intValue() == 1) {
                SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.h, (int) R.color.CAM_X0109);
            } else if (i67Var.a() == 1) {
                SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.h, (int) R.color.CAM_X0107);
            } else if (i67Var.a() == 6) {
                SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.h, (int) R.color.CAM_X0301);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: g */
    public FroumBroadMajorHistoryItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) ? new FroumBroadMajorHistoryItemViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d02a1, viewGroup, false)) : (FroumBroadMajorHistoryItemViewHolder) invokeLI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<i67> list = this.b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void h(vm4<i67> vm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, vm4Var) == null) {
            this.c = vm4Var;
        }
    }

    public void i(List<i67> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || list == null) {
            return;
        }
        this.b = list;
        notifyDataSetChanged();
    }
}
