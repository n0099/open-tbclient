package com.baidu.tieba.enterForum.recommend.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.p0.w0.m.c.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class RecommendForumItemView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public View f31949b;

    /* renamed from: c  reason: collision with root package name */
    public BarImageView f31950c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f31951d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f31952e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f31953f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f31954g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f31955h;
    public a i;
    public b j;

    /* loaded from: classes5.dex */
    public interface a {
        void a(b bVar);

        void b(b bVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendForumItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        b(context);
    }

    public final void a(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13374");
        statisticItem.param("obj_type", String.valueOf(bVar.f19504h));
        statisticItem.param("fid", bVar.f19498b);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        TiebaStatic.log(statisticItem);
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0724, this);
            View rootView = getRootView();
            this.a = rootView.findViewById(R.id.obfuscated_res_0x7f0923de);
            this.f31949b = rootView.findViewById(R.id.obfuscated_res_0x7f0923b1);
            this.f31950c = (BarImageView) rootView.findViewById(R.id.obfuscated_res_0x7f090a4c);
            this.f31951d = (TextView) rootView.findViewById(R.id.obfuscated_res_0x7f090a67);
            this.f31952e = (TextView) rootView.findViewById(R.id.obfuscated_res_0x7f090a1c);
            this.f31953f = (TextView) rootView.findViewById(R.id.obfuscated_res_0x7f090a8f);
            this.f31954g = (TextView) rootView.findViewById(R.id.obfuscated_res_0x7f090a55);
            this.f31955h = (TBSpecificationBtn) rootView.findViewById(R.id.obfuscated_res_0x7f090a5a);
            c.a.o0.r.l0.n.b bVar = new c.a.o0.r.l0.n.b();
            bVar.r(R.color.CAM_X0302);
            this.f31955h.setConfig(bVar);
            this.f31955h.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f029b));
            this.f31950c.setPlaceHolder(1);
            this.f31950c.setOnClickListener(this);
            this.f31955h.setOnClickListener(this);
            rootView.setOnClickListener(this);
        }
    }

    public void c(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || bVar == null) {
            return;
        }
        this.j = bVar;
        this.f31950c.J(bVar.a, 15, false);
        this.f31950c.setStrokeColorResId(R.color.CAM_X0201);
        this.f31950c.setStrokeWith(3);
        this.f31950c.setShowOval(true);
        String str = bVar.f19499c;
        if (m.isEmpty(str)) {
            str = "";
        }
        this.f31951d.setText(str);
        String numFormatOverWan = StringHelper.numFormatOverWan(bVar.f19501e);
        TextView textView = this.f31952e;
        textView.setText("关注 " + numFormatOverWan);
        String numFormatOverWan2 = StringHelper.numFormatOverWan((long) bVar.f19502f);
        TextView textView2 = this.f31953f;
        textView2.setText("贴子 " + numFormatOverWan2);
        if (!m.isEmpty(bVar.f19503g)) {
            this.f31954g.setText(bVar.f19503g);
        } else {
            this.f31954g.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f43));
        }
        e(bVar.f19500d);
        DrawableSelector.make().tlRadius(n.f(getContext(), R.dimen.tbds10)).trRadius(n.f(getContext(), R.dimen.tbds10)).defaultColor(R.color.CAM_X0901).into(this.a);
        TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0901).setShapeRadius(n.f(getContext(), R.dimen.tbds10)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.NO_TOP).setShadowRadius(n.f(getContext(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(n.f(getContext(), R.dimen.tbds5)).into(this.f31949b);
        a(bVar);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setViewTextColor(this.f31951d, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f31952e, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f31953f, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f31954g, (int) R.color.CAM_X0107);
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                c.a.o0.r.l0.n.b bVar = new c.a.o0.r.l0.n.b();
                bVar.t(R.color.CAM_X0109);
                this.f31955h.setConfig(bVar);
                this.f31955h.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f68));
                this.f31955h.setClickState(false);
            } else {
                c.a.o0.r.l0.n.b bVar2 = new c.a.o0.r.l0.n.b();
                bVar2.r(R.color.CAM_X0302);
                this.f31955h.setConfig(bVar2);
                this.f31955h.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f029b));
                this.f31955h.setClickState(true);
            }
            this.j.f19500d = z;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (view == this.f31955h) {
                b bVar = this.j;
                if (bVar.f19500d) {
                    this.i.b(bVar);
                    return;
                } else {
                    this.i.a(bVar);
                    return;
                }
            }
            this.i.b(this.j);
        }
    }

    public void setForumItemClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) || aVar == null) {
            return;
        }
        this.i = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendForumItemView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b(context);
    }
}
