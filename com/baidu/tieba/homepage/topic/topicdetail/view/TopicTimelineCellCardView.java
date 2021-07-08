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
import d.a.c.e.p.l;
import d.a.p0.e1.k.a.c.e;
/* loaded from: classes4.dex */
public class TopicTimelineCellCardView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f16938e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f16939f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16940g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16941h;

    /* renamed from: i  reason: collision with root package name */
    public int f16942i;
    public int j;
    public e k;

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
        this.f16938e = 3;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.card_topic_timeline_cell_view, (ViewGroup) this, true);
            this.f16939f = (LinearLayout) findViewById(R.id.card_topic_timeline_cell_date);
            this.f16940g = (TextView) findViewById(R.id.card_topic_timeline_cell_time);
            this.f16941h = (TextView) findViewById(R.id.card_topic_timeline_cell_title);
            this.f16942i = l.g(context, R.dimen.tbds340);
            this.j = l.g(context, R.dimen.tbds230);
            setOnClickListener(this);
            b();
        }
    }

    public void b() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f16938e) {
            return;
        }
        this.f16938e = skinType;
        SkinManager.setViewTextColor(this.f16940g, R.color.cp_cont_m);
        SkinManager.setBackgroundResource(this.f16941h, R.drawable.topic_timeline_shade_bg);
        SkinManager.setViewTextColor(this.f16941h, R.color.CAM_X0106);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) || this.k == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13353").param("tid", this.k.f55782b).param("topic_id", this.k.f55781a).param("obj_locate", this.k.f55786f + 1));
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getContext()).createNormalCfg(String.valueOf(this.k.f55782b), "", "")));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            setMeasuredDimension(this.f16942i, this.j);
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
            this.k = eVar;
            this.f16940g.setText(eVar.f55784d);
            this.f16941h.setText(eVar.f55783c);
            if (StringUtils.isNull(eVar.f55785e)) {
                int i2 = eVar.f55786f;
                if (i2 == 0) {
                    SkinManager.setBackgroundResource(this.f16939f, R.drawable.topic_timeline_bg_one);
                    return;
                } else if (i2 == 1) {
                    SkinManager.setBackgroundResource(this.f16939f, R.drawable.topic_timeline_bg_two);
                    return;
                } else {
                    SkinManager.setBackgroundResource(this.f16939f, R.drawable.topic_timeline_bg_three);
                    return;
                }
            }
            try {
                GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(R.drawable.topic_timeline_bg);
                gradientDrawable.setColor(Color.parseColor(eVar.f55785e));
                this.f16939f.setBackgroundDrawable(gradientDrawable);
            } catch (Exception unused) {
                int i3 = eVar.f55786f;
                if (i3 == 0) {
                    SkinManager.setBackgroundResource(this.f16939f, R.drawable.topic_timeline_bg_one);
                } else if (i3 == 1) {
                    SkinManager.setBackgroundResource(this.f16939f, R.drawable.topic_timeline_bg_two);
                } else {
                    SkinManager.setBackgroundResource(this.f16939f, R.drawable.topic_timeline_bg_three);
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
        this.f16938e = 3;
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
        this.f16938e = 3;
        a(context);
    }
}
