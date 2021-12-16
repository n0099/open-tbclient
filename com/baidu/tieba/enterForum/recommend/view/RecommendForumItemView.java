package com.baidu.tieba.enterForum.recommend.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.s0.u0.k.c.b;
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
/* loaded from: classes12.dex */
public class RecommendForumItemView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f44092e;

    /* renamed from: f  reason: collision with root package name */
    public View f44093f;

    /* renamed from: g  reason: collision with root package name */
    public BarImageView f44094g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f44095h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f44096i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f44097j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f44098k;
    public TBSpecificationBtn l;
    public a m;
    public b n;

    /* loaded from: classes12.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        statisticItem.param("obj_type", String.valueOf(bVar.f24261h));
        statisticItem.param("fid", bVar.f24255b);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        TiebaStatic.log(statisticItem);
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.recommend_forum_item_layout, this);
            View rootView = getRootView();
            this.f44092e = rootView.findViewById(R.id.view_top);
            this.f44093f = rootView.findViewById(R.id.view_bottom);
            this.f44094g = (BarImageView) rootView.findViewById(R.id.forum_image);
            this.f44095h = (TextView) rootView.findViewById(R.id.forum_name);
            this.f44096i = (TextView) rootView.findViewById(R.id.forum_attention);
            this.f44097j = (TextView) rootView.findViewById(R.id.forum_thread);
            this.f44098k = (TextView) rootView.findViewById(R.id.forum_introduce);
            this.l = (TBSpecificationBtn) rootView.findViewById(R.id.forum_like_button);
            c.a.r0.s.i0.n.b bVar = new c.a.r0.s.i0.n.b();
            bVar.r(R.color.CAM_X0302);
            this.l.setConfig(bVar);
            this.l.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            this.f44094g.setPlaceHolder(1);
            this.f44094g.setOnClickListener(this);
            this.l.setOnClickListener(this);
            rootView.setOnClickListener(this);
        }
    }

    public void onBindData(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || bVar == null) {
            return;
        }
        this.n = bVar;
        this.f44094g.startLoad(bVar.a, 15, false);
        this.f44094g.setStrokeColorResId(R.color.CAM_X0201);
        this.f44094g.setStrokeWith(3);
        this.f44094g.setShowOval(true);
        String str = bVar.f24256c;
        if (l.isEmpty(str)) {
            str = "";
        }
        this.f44095h.setText(str);
        String numFormatOverWan = StringHelper.numFormatOverWan(bVar.f24258e);
        TextView textView = this.f44096i;
        textView.setText("关注 " + numFormatOverWan);
        String numFormatOverWan2 = StringHelper.numFormatOverWan((long) bVar.f24259f);
        TextView textView2 = this.f44097j;
        textView2.setText("贴子 " + numFormatOverWan2);
        if (!l.isEmpty(bVar.f24260g)) {
            this.f44098k.setText(bVar.f24260g);
        } else {
            this.f44098k.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
        }
        updateLikeState(bVar.f24257d);
        DrawableSelector.make().tlRadius(m.f(getContext(), R.dimen.tbds10)).trRadius(m.f(getContext(), R.dimen.tbds10)).defaultColor(R.color.CAM_X0901).into(this.f44092e);
        TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0901).setShapeRadius(m.f(getContext(), R.dimen.tbds10)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.NO_TOP).setShadowRadius(m.f(getContext(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(m.f(getContext(), R.dimen.tbds5)).into(this.f44093f);
        a(bVar);
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setViewTextColor(this.f44095h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f44096i, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f44097j, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f44098k, R.color.CAM_X0107);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            if (view == this.l) {
                b bVar = this.n;
                if (bVar.f24257d) {
                    this.m.b(bVar);
                    return;
                } else {
                    this.m.a(bVar);
                    return;
                }
            }
            this.m.b(this.n);
        }
    }

    public void setForumItemClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || aVar == null) {
            return;
        }
        this.m = aVar;
    }

    public void updateLikeState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                c.a.r0.s.i0.n.b bVar = new c.a.r0.s.i0.n.b();
                bVar.s(R.color.CAM_X0109);
                this.l.setConfig(bVar);
                this.l.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
                this.l.setClickState(false);
            } else {
                c.a.r0.s.i0.n.b bVar2 = new c.a.r0.s.i0.n.b();
                bVar2.r(R.color.CAM_X0302);
                this.l.setConfig(bVar2);
                this.l.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
                this.l.setClickState(true);
            }
            this.n.f24257d = z;
        }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b(context);
    }
}
