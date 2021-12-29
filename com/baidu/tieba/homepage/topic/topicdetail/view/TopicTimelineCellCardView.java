package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.t0.o1.k.b.c.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class TopicTimelineCellCardView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f46230e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f46231f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f46232g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f46233h;

    /* renamed from: i  reason: collision with root package name */
    public int f46234i;

    /* renamed from: j  reason: collision with root package name */
    public int f46235j;

    /* renamed from: k  reason: collision with root package name */
    public e f46236k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicTimelineCellCardView(Context context) {
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
        this.f46230e = 3;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.card_topic_timeline_cell_view, (ViewGroup) this, true);
            this.f46231f = (LinearLayout) findViewById(R.id.card_topic_timeline_cell_date);
            this.f46232g = (TextView) findViewById(R.id.card_topic_timeline_cell_time);
            this.f46233h = (TextView) findViewById(R.id.card_topic_timeline_cell_title);
            this.f46234i = n.f(context, R.dimen.tbds340);
            this.f46235j = n.f(context, R.dimen.tbds230);
            setOnClickListener(this);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f46230e) {
            return;
        }
        this.f46230e = skinType;
        SkinManager.setViewTextColor(this.f46232g, R.color.cp_cont_m);
        SkinManager.setBackgroundResource(this.f46233h, R.drawable.topic_timeline_shade_bg);
        SkinManager.setViewTextColor(this.f46233h, R.color.CAM_X0106);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) || this.f46236k == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13353").param("tid", this.f46236k.f21257b).param("topic_id", this.f46236k.a).param("obj_locate", this.f46236k.f21261f + 1));
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getContext()).createNormalCfg(String.valueOf(this.f46236k.f21257b), "", "")));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            setMeasuredDimension(this.f46234i, this.f46235j);
        }
    }

    public void setData(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            if (eVar == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.f46236k = eVar;
            this.f46232g.setText(eVar.f21259d);
            this.f46233h.setText(eVar.f21258c);
            if (StringUtils.isNull(eVar.f21260e)) {
                int i2 = eVar.f21261f;
                if (i2 == 0) {
                    SkinManager.setBackgroundResource(this.f46231f, R.drawable.topic_timeline_bg_one);
                    return;
                } else if (i2 == 1) {
                    SkinManager.setBackgroundResource(this.f46231f, R.drawable.topic_timeline_bg_two);
                    return;
                } else {
                    SkinManager.setBackgroundResource(this.f46231f, R.drawable.topic_timeline_bg_three);
                    return;
                }
            }
            try {
                GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(R.drawable.topic_timeline_bg);
                gradientDrawable.setColor(Color.parseColor(eVar.f21260e));
                this.f46231f.setBackgroundDrawable(gradientDrawable);
            } catch (Exception unused) {
                int i3 = eVar.f21261f;
                if (i3 == 0) {
                    SkinManager.setBackgroundResource(this.f46231f, R.drawable.topic_timeline_bg_one);
                } else if (i3 == 1) {
                    SkinManager.setBackgroundResource(this.f46231f, R.drawable.topic_timeline_bg_two);
                } else {
                    SkinManager.setBackgroundResource(this.f46231f, R.drawable.topic_timeline_bg_three);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicTimelineCellCardView(Context context, AttributeSet attributeSet) {
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
        this.f46230e = 3;
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicTimelineCellCardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f46230e = 3;
        a(context);
    }
}
