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
import com.baidu.adp.lib.util.BdUtilHelper;
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
import com.baidu.tieba.fc8;
import com.baidu.tieba.mz4;
import com.baidu.tieba.x95;
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
    public List<fc8> b;
    public mz4<fc8> c;

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
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090370);
            this.b = (TextView) view2.findViewById(R.id.forum_name);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090371);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09036c);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091d91);
            this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091ddb);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090827);
            this.j = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09036d);
            this.k = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09036e);
            this.n = (BarImageView) view2.findViewById(R.id.forum_avatar);
            this.o = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091212);
            this.p = view2.findViewById(R.id.obfuscated_res_0x7f090bb2);
            this.l = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090bb1);
            this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090bb0);
            this.s = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f090bd1);
            this.m = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090bfd);
            this.t = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0907b8);
            this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09036f);
            this.r = view2.findViewById(R.id.obfuscated_res_0x7f0903d9);
            this.q = view2.findViewById(R.id.obfuscated_res_0x7f090e6d);
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fc8 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ FroumBroadMajorHistoryAdapter c;

        public a(FroumBroadMajorHistoryAdapter froumBroadMajorHistoryAdapter, fc8 fc8Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {froumBroadMajorHistoryAdapter, fc8Var, Integer.valueOf(i)};
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
            this.a = fc8Var;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.c.c != null) {
                mz4 mz4Var = this.c.c;
                fc8 fc8Var = this.a;
                int i = this.b;
                mz4Var.d(view2, fc8Var, i, i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fc8 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ FroumBroadMajorHistoryAdapter c;

        public b(FroumBroadMajorHistoryAdapter froumBroadMajorHistoryAdapter, fc8 fc8Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {froumBroadMajorHistoryAdapter, fc8Var, Integer.valueOf(i)};
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
            this.a = fc8Var;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.c.c != null) {
                mz4 mz4Var = this.c.c;
                fc8 fc8Var = this.a;
                int i = this.b;
                mz4Var.d(view2, fc8Var, i, i);
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

    public void p(mz4<fc8> mz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, mz4Var) == null) {
            this.c = mz4Var;
        }
    }

    public void q(List<fc8> list) {
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
            List<fc8> list = this.b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m */
    public void onBindViewHolder(@NonNull FroumBroadMajorHistoryItemViewHolder froumBroadMajorHistoryItemViewHolder, int i) {
        fc8 fc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, froumBroadMajorHistoryItemViewHolder, i) != null) || (fc8Var = this.b.get(i)) == null) {
            return;
        }
        if (i == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.a.getLayoutParams();
            layoutParams.topMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.tbds62);
            froumBroadMajorHistoryItemViewHolder.a.setLayoutParams(layoutParams);
        }
        if (TimeHelper.isSameYear(fc8Var.g() * 1000)) {
            froumBroadMajorHistoryItemViewHolder.a.setText(StringHelper.getDateStringMHH(fc8Var.g() * 1000));
        } else {
            froumBroadMajorHistoryItemViewHolder.a.setText(StringHelper.getDateStringYMH(fc8Var.g() * 1000));
        }
        if (StringUtils.isNull(fc8Var.f())) {
            froumBroadMajorHistoryItemViewHolder.t.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.i.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.i.setText(fc8Var.k());
        } else {
            froumBroadMajorHistoryItemViewHolder.t.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.i.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.c.setText(fc8Var.k());
            froumBroadMajorHistoryItemViewHolder.o.setConrers(15);
            froumBroadMajorHistoryItemViewHolder.o.setRadius(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            froumBroadMajorHistoryItemViewHolder.o.setDrawCorner(true);
            froumBroadMajorHistoryItemViewHolder.o.setPlaceHolder(2);
            froumBroadMajorHistoryItemViewHolder.o.startLoad(fc8Var.f(), 10, false);
            froumBroadMajorHistoryItemViewHolder.o.setGifIconSupport(false);
        }
        if (StringUtils.isNull(fc8Var.c())) {
            froumBroadMajorHistoryItemViewHolder.d.setVisibility(8);
        } else {
            froumBroadMajorHistoryItemViewHolder.d.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.d.setText(fc8Var.c());
        }
        froumBroadMajorHistoryItemViewHolder.b.setText(fc8Var.e().forum_name);
        froumBroadMajorHistoryItemViewHolder.n.setShowOval(true);
        froumBroadMajorHistoryItemViewHolder.n.setAutoChangeStyle(true);
        froumBroadMajorHistoryItemViewHolder.n.setStrokeWith(BdUtilHelper.getDimens(this.a, R.dimen.tbds1));
        froumBroadMajorHistoryItemViewHolder.n.setStrokeColorResId(R.color.CAM_X0401);
        froumBroadMajorHistoryItemViewHolder.n.setShowOuterBorder(false);
        froumBroadMajorHistoryItemViewHolder.n.setShowInnerBorder(true);
        froumBroadMajorHistoryItemViewHolder.n.setPlaceHolder(1);
        froumBroadMajorHistoryItemViewHolder.n.startLoad(fc8Var.e().avatar, 10, false);
        froumBroadMajorHistoryItemViewHolder.e.setText(this.a.getString(R.string.obfuscated_res_0x7f0f077f, StringHelper.numberUniformFormatExtraWithRoundVote(fc8Var.h())));
        froumBroadMajorHistoryItemViewHolder.f.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0780, StringHelper.numberUniformFormatExtraWithRoundVote(fc8Var.i())));
        int parseFloat = (int) (Float.parseFloat(fc8Var.d()) * 100.0f);
        if (parseFloat < 0) {
            parseFloat = 0;
        } else if (parseFloat > 100) {
            parseFloat = 100;
        }
        if (!StringUtils.isNull(fc8Var.d())) {
            froumBroadMajorHistoryItemViewHolder.g.setText(this.a.getString(R.string.obfuscated_res_0x7f0f077b, Integer.valueOf(parseFloat), "%"));
        } else {
            froumBroadMajorHistoryItemViewHolder.g.setText("0%");
        }
        if (fc8Var.j() != null) {
            if (fc8Var.j().is_deleted.intValue() == 1) {
                froumBroadMajorHistoryItemViewHolder.l.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.s.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.h.setText(this.a.getString(R.string.obfuscated_res_0x7f0f077e));
                if (fc8Var.a() != 1 && fc8Var.a() != 6) {
                    froumBroadMajorHistoryItemViewHolder.m.setVisibility(0);
                    froumBroadMajorHistoryItemViewHolder.p.setVisibility(0);
                } else {
                    froumBroadMajorHistoryItemViewHolder.m.setVisibility(8);
                    froumBroadMajorHistoryItemViewHolder.p.setVisibility(8);
                }
            } else if (fc8Var.a() == 1) {
                froumBroadMajorHistoryItemViewHolder.m.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.p.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.l.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.s.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.h.setText(this.a.getString(R.string.video_review_state));
            } else if (fc8Var.a() == 6) {
                froumBroadMajorHistoryItemViewHolder.m.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.p.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.l.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.s.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.h.setText(this.a.getString(R.string.obfuscated_res_0x7f0f077a));
                froumBroadMajorHistoryItemViewHolder.s.setText(this.a.getString(R.string.obfuscated_res_0x7f0f060e));
                froumBroadMajorHistoryItemViewHolder.s.setTextSize(R.dimen.tbds34);
                x95 x95Var = new x95();
                x95Var.u(R.color.CAM_X0302);
                froumBroadMajorHistoryItemViewHolder.s.setConfig(x95Var);
                froumBroadMajorHistoryItemViewHolder.s.setOnClickListener(new a(this, fc8Var, i));
            } else if (fc8Var.a() == 10) {
                froumBroadMajorHistoryItemViewHolder.m.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.p.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.l.setVisibility(8);
            }
        } else {
            froumBroadMajorHistoryItemViewHolder.l.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.s.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.h.setText(this.a.getString(R.string.obfuscated_res_0x7f0f077e));
            if (fc8Var.a() != 1 && fc8Var.a() != 6) {
                froumBroadMajorHistoryItemViewHolder.m.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.p.setVisibility(0);
            } else {
                froumBroadMajorHistoryItemViewHolder.m.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.p.setVisibility(8);
            }
        }
        froumBroadMajorHistoryItemViewHolder.k.setOnClickListener(new b(this, fc8Var, i));
        n(froumBroadMajorHistoryItemViewHolder, fc8Var, i);
    }

    public final void n(FroumBroadMajorHistoryItemViewHolder froumBroadMajorHistoryItemViewHolder, fc8 fc8Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, froumBroadMajorHistoryItemViewHolder, fc8Var, i) == null) {
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.a, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.c, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.d, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.e, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.g, (int) R.color.CAM_X0107);
            SkinManager.setBackgroundColor(froumBroadMajorHistoryItemViewHolder.p, R.color.CAM_X0203);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.i, (int) R.color.CAM_X0105);
            TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0601, R.color.CAM_X0606).blRadius(BdUtilHelper.getDimens(this.a, R.dimen.tbds21)).brRadius(BdUtilHelper.getDimens(this.a, R.dimen.tbds21)).into(froumBroadMajorHistoryItemViewHolder.q);
            if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                if (i != 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.a.getLayoutParams();
                    layoutParams.topMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.tbds57);
                    froumBroadMajorHistoryItemViewHolder.a.setLayoutParams(layoutParams);
                }
                froumBroadMajorHistoryItemViewHolder.k.setPadding(this.a.getResources().getDimensionPixelOffset(R.dimen.tbds23), this.a.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.a.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.a.getResources().getDimensionPixelOffset(R.dimen.tbds75));
                froumBroadMajorHistoryItemViewHolder.r.setVisibility(0);
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(BdUtilHelper.getDimens(this.a, R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(BdUtilHelper.getDimens(this.a, R.dimen.tbds10)).setOffsetX(0).setOffsetY(BdUtilHelper.getDimens(this.a, R.dimen.tbds5)).into(froumBroadMajorHistoryItemViewHolder.r);
            } else {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.k.getLayoutParams();
                layoutParams2.leftMargin = BdUtilHelper.getDimens(this.a, R.dimen.tbds21);
                layoutParams2.rightMargin = BdUtilHelper.getDimens(this.a, R.dimen.tbds21);
                layoutParams2.topMargin = BdUtilHelper.getDimens(this.a, R.dimen.tbds21);
                froumBroadMajorHistoryItemViewHolder.k.setLayoutParams(layoutParams2);
                froumBroadMajorHistoryItemViewHolder.k.setPadding(0, 0, 0, this.a.getResources().getDimensionPixelOffset(R.dimen.tbds54));
                froumBroadMajorHistoryItemViewHolder.r.setVisibility(8);
                TBSelector.makeDrawableSelector().setShape(0).cornerRadius(BdUtilHelper.getDimens(this.a, R.dimen.tbds31)).defaultColor(R.color.CAM_X0205).into(froumBroadMajorHistoryItemViewHolder.k);
            }
            if (fc8Var.j() != null) {
                if (fc8Var.j().is_deleted.intValue() == 1) {
                    SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.h, (int) R.color.CAM_X0109);
                    return;
                } else if (fc8Var.a() == 1) {
                    SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.h, (int) R.color.CAM_X0107);
                    return;
                } else if (fc8Var.a() == 6) {
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
    /* renamed from: o */
    public FroumBroadMajorHistoryItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i)) == null) {
            return new FroumBroadMajorHistoryItemViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d02ec, viewGroup, false));
        }
        return (FroumBroadMajorHistoryItemViewHolder) invokeLI.objValue;
    }
}
