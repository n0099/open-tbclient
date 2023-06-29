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
import com.baidu.tieba.pa5;
import com.baidu.tieba.q98;
import com.baidu.tieba.xi;
import com.baidu.tieba.zz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class FroumBroadMajorHistoryAdapter extends RecyclerView.Adapter<FroumBroadMajorHistoryItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public List<q98> b;
    public zz4<q98> c;

    /* loaded from: classes6.dex */
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
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09036f);
            this.b = (TextView) view2.findViewById(R.id.forum_name);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090370);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09036b);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091d5b);
            this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091da5);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090817);
            this.j = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09036c);
            this.k = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09036d);
            this.n = (BarImageView) view2.findViewById(R.id.forum_avatar);
            this.o = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0911ed);
            this.p = view2.findViewById(R.id.obfuscated_res_0x7f090b96);
            this.l = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090b95);
            this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b94);
            this.s = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f090bb5);
            this.m = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090bdf);
            this.t = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0907a8);
            this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09036e);
            this.r = view2.findViewById(R.id.obfuscated_res_0x7f0903d8);
            this.q = view2.findViewById(R.id.obfuscated_res_0x7f090e4d);
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q98 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ FroumBroadMajorHistoryAdapter c;

        public a(FroumBroadMajorHistoryAdapter froumBroadMajorHistoryAdapter, q98 q98Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {froumBroadMajorHistoryAdapter, q98Var, Integer.valueOf(i)};
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
            this.a = q98Var;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.c.c != null) {
                zz4 zz4Var = this.c.c;
                q98 q98Var = this.a;
                int i = this.b;
                zz4Var.d(view2, q98Var, i, i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q98 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ FroumBroadMajorHistoryAdapter c;

        public b(FroumBroadMajorHistoryAdapter froumBroadMajorHistoryAdapter, q98 q98Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {froumBroadMajorHistoryAdapter, q98Var, Integer.valueOf(i)};
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
            this.a = q98Var;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.c.c != null) {
                zz4 zz4Var = this.c.c;
                q98 q98Var = this.a;
                int i = this.b;
                zz4Var.d(view2, q98Var, i, i);
            }
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

    public void o(zz4<q98> zz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, zz4Var) == null) {
            this.c = zz4Var;
        }
    }

    public void p(List<q98> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, list) == null) && list != null) {
            this.b = list;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<q98> list = this.b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l */
    public void onBindViewHolder(@NonNull FroumBroadMajorHistoryItemViewHolder froumBroadMajorHistoryItemViewHolder, int i) {
        q98 q98Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, froumBroadMajorHistoryItemViewHolder, i) != null) || (q98Var = this.b.get(i)) == null) {
            return;
        }
        if (i == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.a.getLayoutParams();
            layoutParams.topMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.tbds62);
            froumBroadMajorHistoryItemViewHolder.a.setLayoutParams(layoutParams);
        }
        if (TimeHelper.isSameYear(q98Var.g() * 1000)) {
            froumBroadMajorHistoryItemViewHolder.a.setText(StringHelper.getDateStringMHH(q98Var.g() * 1000));
        } else {
            froumBroadMajorHistoryItemViewHolder.a.setText(StringHelper.getDateStringYMH(q98Var.g() * 1000));
        }
        if (StringUtils.isNull(q98Var.f())) {
            froumBroadMajorHistoryItemViewHolder.t.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.i.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.i.setText(q98Var.k());
        } else {
            froumBroadMajorHistoryItemViewHolder.t.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.i.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.c.setText(q98Var.k());
            froumBroadMajorHistoryItemViewHolder.o.setConrers(15);
            froumBroadMajorHistoryItemViewHolder.o.setRadius(xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            froumBroadMajorHistoryItemViewHolder.o.setDrawCorner(true);
            froumBroadMajorHistoryItemViewHolder.o.setPlaceHolder(2);
            froumBroadMajorHistoryItemViewHolder.o.N(q98Var.f(), 10, false);
            froumBroadMajorHistoryItemViewHolder.o.setGifIconSupport(false);
        }
        if (StringUtils.isNull(q98Var.c())) {
            froumBroadMajorHistoryItemViewHolder.d.setVisibility(8);
        } else {
            froumBroadMajorHistoryItemViewHolder.d.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.d.setText(q98Var.c());
        }
        froumBroadMajorHistoryItemViewHolder.b.setText(q98Var.e().forum_name);
        froumBroadMajorHistoryItemViewHolder.n.setShowOval(true);
        froumBroadMajorHistoryItemViewHolder.n.setAutoChangeStyle(true);
        froumBroadMajorHistoryItemViewHolder.n.setStrokeWith(xi.g(this.a, R.dimen.tbds1));
        froumBroadMajorHistoryItemViewHolder.n.setStrokeColorResId(R.color.CAM_X0401);
        froumBroadMajorHistoryItemViewHolder.n.setShowOuterBorder(false);
        froumBroadMajorHistoryItemViewHolder.n.setShowInnerBorder(true);
        froumBroadMajorHistoryItemViewHolder.n.setPlaceHolder(1);
        froumBroadMajorHistoryItemViewHolder.n.N(q98Var.e().avatar, 10, false);
        froumBroadMajorHistoryItemViewHolder.e.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0775, StringHelper.numberUniformFormatExtraWithRoundVote(q98Var.h())));
        froumBroadMajorHistoryItemViewHolder.f.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0776, StringHelper.numberUniformFormatExtraWithRoundVote(q98Var.i())));
        int parseFloat = (int) (Float.parseFloat(q98Var.d()) * 100.0f);
        if (parseFloat < 0) {
            parseFloat = 0;
        } else if (parseFloat > 100) {
            parseFloat = 100;
        }
        if (!StringUtils.isNull(q98Var.d())) {
            froumBroadMajorHistoryItemViewHolder.g.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0771, Integer.valueOf(parseFloat), "%"));
        } else {
            froumBroadMajorHistoryItemViewHolder.g.setText("0%");
        }
        if (q98Var.j() != null) {
            if (q98Var.j().is_deleted.intValue() == 1) {
                froumBroadMajorHistoryItemViewHolder.l.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.s.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.h.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0774));
                if (q98Var.a() != 1 && q98Var.a() != 6) {
                    froumBroadMajorHistoryItemViewHolder.m.setVisibility(0);
                    froumBroadMajorHistoryItemViewHolder.p.setVisibility(0);
                } else {
                    froumBroadMajorHistoryItemViewHolder.m.setVisibility(8);
                    froumBroadMajorHistoryItemViewHolder.p.setVisibility(8);
                }
            } else if (q98Var.a() == 1) {
                froumBroadMajorHistoryItemViewHolder.m.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.p.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.l.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.s.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.h.setText(this.a.getString(R.string.video_review_state));
            } else if (q98Var.a() == 6) {
                froumBroadMajorHistoryItemViewHolder.m.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.p.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.l.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.s.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.h.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0770));
                froumBroadMajorHistoryItemViewHolder.s.setText(this.a.getString(R.string.obfuscated_res_0x7f0f060b));
                froumBroadMajorHistoryItemViewHolder.s.setTextSize(R.dimen.tbds34);
                pa5 pa5Var = new pa5();
                pa5Var.t(R.color.CAM_X0302);
                froumBroadMajorHistoryItemViewHolder.s.setConfig(pa5Var);
                froumBroadMajorHistoryItemViewHolder.s.setOnClickListener(new a(this, q98Var, i));
            } else if (q98Var.a() == 10) {
                froumBroadMajorHistoryItemViewHolder.m.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.p.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.l.setVisibility(8);
            }
        } else {
            froumBroadMajorHistoryItemViewHolder.l.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.s.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.h.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0774));
            if (q98Var.a() != 1 && q98Var.a() != 6) {
                froumBroadMajorHistoryItemViewHolder.m.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.p.setVisibility(0);
            } else {
                froumBroadMajorHistoryItemViewHolder.m.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.p.setVisibility(8);
            }
        }
        froumBroadMajorHistoryItemViewHolder.k.setOnClickListener(new b(this, q98Var, i));
        m(froumBroadMajorHistoryItemViewHolder, q98Var, i);
    }

    public final void m(FroumBroadMajorHistoryItemViewHolder froumBroadMajorHistoryItemViewHolder, q98 q98Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, froumBroadMajorHistoryItemViewHolder, q98Var, i) == null) {
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.a, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.c, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.d, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.e, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.g, (int) R.color.CAM_X0107);
            SkinManager.setBackgroundColor(froumBroadMajorHistoryItemViewHolder.p, R.color.CAM_X0203);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.i, (int) R.color.CAM_X0105);
            TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0601, R.color.CAM_X0606).blRadius(xi.g(this.a, R.dimen.tbds21)).brRadius(xi.g(this.a, R.dimen.tbds21)).into(froumBroadMajorHistoryItemViewHolder.q);
            if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                if (i != 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.a.getLayoutParams();
                    layoutParams.topMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.tbds57);
                    froumBroadMajorHistoryItemViewHolder.a.setLayoutParams(layoutParams);
                }
                froumBroadMajorHistoryItemViewHolder.k.setPadding(this.a.getResources().getDimensionPixelOffset(R.dimen.tbds23), this.a.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.a.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.a.getResources().getDimensionPixelOffset(R.dimen.tbds75));
                froumBroadMajorHistoryItemViewHolder.r.setVisibility(0);
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(xi.g(this.a, R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(xi.g(this.a, R.dimen.tbds10)).setOffsetX(0).setOffsetY(xi.g(this.a, R.dimen.tbds5)).into(froumBroadMajorHistoryItemViewHolder.r);
            } else {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.k.getLayoutParams();
                layoutParams2.leftMargin = xi.g(this.a, R.dimen.tbds21);
                layoutParams2.rightMargin = xi.g(this.a, R.dimen.tbds21);
                layoutParams2.topMargin = xi.g(this.a, R.dimen.tbds21);
                froumBroadMajorHistoryItemViewHolder.k.setLayoutParams(layoutParams2);
                froumBroadMajorHistoryItemViewHolder.k.setPadding(0, 0, 0, this.a.getResources().getDimensionPixelOffset(R.dimen.tbds54));
                froumBroadMajorHistoryItemViewHolder.r.setVisibility(8);
                TBSelector.makeDrawableSelector().setShape(0).cornerRadius(xi.g(this.a, R.dimen.tbds31)).defaultColor(R.color.CAM_X0205).into(froumBroadMajorHistoryItemViewHolder.k);
            }
            if (q98Var.j() != null) {
                if (q98Var.j().is_deleted.intValue() == 1) {
                    SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.h, (int) R.color.CAM_X0109);
                    return;
                } else if (q98Var.a() == 1) {
                    SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.h, (int) R.color.CAM_X0107);
                    return;
                } else if (q98Var.a() == 6) {
                    SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.h, (int) R.color.CAM_X0301);
                    return;
                } else {
                    return;
                }
            }
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.h, (int) R.color.CAM_X0109);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: n */
    public FroumBroadMajorHistoryItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i)) == null) {
            return new FroumBroadMajorHistoryItemViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d02e0, viewGroup, false));
        }
        return (FroumBroadMajorHistoryItemViewHolder) invokeLI.objValue;
    }
}
