package com.baidu.tieba.enterForum.recommend.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.r0.n0.k.c.b;
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
/* loaded from: classes7.dex */
public class RecommendForumItemView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f50303e;

    /* renamed from: f  reason: collision with root package name */
    public View f50304f;

    /* renamed from: g  reason: collision with root package name */
    public BarImageView f50305g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f50306h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f50307i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f50308j;
    public TextView k;
    public TBSpecificationBtn l;
    public a m;
    public b n;

    /* loaded from: classes7.dex */
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
        statisticItem.param("obj_type", String.valueOf(bVar.f22665h));
        statisticItem.param("fid", bVar.f22659b);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        TiebaStatic.log(statisticItem);
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.recommend_forum_item_layout, this);
            View rootView = getRootView();
            this.f50303e = rootView.findViewById(R.id.view_top);
            this.f50304f = rootView.findViewById(R.id.view_bottom);
            this.f50305g = (BarImageView) rootView.findViewById(R.id.forum_image);
            this.f50306h = (TextView) rootView.findViewById(R.id.forum_name);
            this.f50307i = (TextView) rootView.findViewById(R.id.forum_attention);
            this.f50308j = (TextView) rootView.findViewById(R.id.forum_thread);
            this.k = (TextView) rootView.findViewById(R.id.forum_introduce);
            this.l = (TBSpecificationBtn) rootView.findViewById(R.id.forum_like_button);
            c.a.q0.s.f0.n.b bVar = new c.a.q0.s.f0.n.b();
            bVar.q(R.color.CAM_X0302);
            this.l.setConfig(bVar);
            this.l.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            this.f50305g.setPlaceHolder(1);
            this.f50305g.setOnClickListener(this);
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
        this.f50305g.startLoad(bVar.f22658a, 15, false);
        this.f50305g.setStrokeColorResId(R.color.CAM_X0201);
        this.f50305g.setStrokeWith(3);
        this.f50305g.setShowOval(true);
        String str = bVar.f22660c;
        if (k.isEmpty(str)) {
            str = "";
        }
        this.f50306h.setText(str);
        String numFormatOverWan = StringHelper.numFormatOverWan(bVar.f22662e);
        TextView textView = this.f50307i;
        textView.setText("关注 " + numFormatOverWan);
        String numFormatOverWan2 = StringHelper.numFormatOverWan((long) bVar.f22663f);
        TextView textView2 = this.f50308j;
        textView2.setText("贴子 " + numFormatOverWan2);
        if (!k.isEmpty(bVar.f22664g)) {
            this.k.setText(bVar.f22664g);
        } else {
            this.k.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
        }
        updateLikeState(bVar.f22661d);
        DrawableSelector.make().tlRadius(l.g(getContext(), R.dimen.tbds10)).trRadius(l.g(getContext(), R.dimen.tbds10)).defaultColor(R.color.CAM_X0901).into(this.f50303e);
        TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0901).setShapeRadius(l.g(getContext(), R.dimen.tbds10)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.NO_TOP).setShadowRadius(l.g(getContext(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(getContext(), R.dimen.tbds5)).into(this.f50304f);
        a(bVar);
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setViewTextColor(this.f50306h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f50307i, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f50308j, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0107);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            if (view == this.l) {
                b bVar = this.n;
                if (bVar.f22661d) {
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
                c.a.q0.s.f0.n.b bVar = new c.a.q0.s.f0.n.b();
                bVar.r(R.color.CAM_X0109);
                this.l.setConfig(bVar);
                this.l.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
                this.l.setClickState(false);
            } else {
                c.a.q0.s.f0.n.b bVar2 = new c.a.q0.s.f0.n.b();
                bVar2.q(R.color.CAM_X0302);
                this.l.setConfig(bVar2);
                this.l.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
                this.l.setClickState(true);
            }
            this.n.f22661d = z;
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
