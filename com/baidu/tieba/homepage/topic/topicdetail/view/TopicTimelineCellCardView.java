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
import com.baidu.tieba.i77;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class TopicTimelineCellCardView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public LinearLayout b;
    public TextView c;
    public TextView d;
    public int e;
    public int f;
    public i77 g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicTimelineCellCardView(Context context) {
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
        this.a = 3;
        a(context);
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
        this.a = 3;
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicTimelineCellCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 3;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d01bf, (ViewGroup) this, true);
            this.b = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0905a9);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f0905aa);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f0905ab);
            this.e = yi.g(context, R.dimen.tbds340);
            this.f = yi.g(context, R.dimen.tbds230);
            setOnClickListener(this);
            b();
        }
    }

    public void b() {
        int skinType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.a = skinType;
        SkinManager.setViewTextColor(this.c, (int) R.color.cp_cont_m);
        SkinManager.setBackgroundResource(this.d, R.drawable.topic_timeline_shade_bg);
        SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0106);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) != null) || this.g == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13353").param("tid", this.g.b).param("topic_id", this.g.a).param("obj_locate", this.g.f + 1));
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getContext()).createNormalCfg(String.valueOf(this.g.b), "", "")));
    }

    public void setData(i77 i77Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, i77Var) == null) {
            if (i77Var == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.g = i77Var;
            this.c.setText(i77Var.d);
            this.d.setText(i77Var.c);
            if (StringUtils.isNull(i77Var.e)) {
                int i = i77Var.f;
                if (i == 0) {
                    SkinManager.setBackgroundResource(this.b, R.drawable.topic_timeline_bg_one);
                    return;
                } else if (i == 1) {
                    SkinManager.setBackgroundResource(this.b, R.drawable.topic_timeline_bg_two);
                    return;
                } else {
                    SkinManager.setBackgroundResource(this.b, R.drawable.topic_timeline_bg_three);
                    return;
                }
            }
            try {
                GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(R.drawable.obfuscated_res_0x7f081274);
                gradientDrawable.setColor(Color.parseColor(i77Var.e));
                this.b.setBackgroundDrawable(gradientDrawable);
            } catch (Exception unused) {
                int i2 = i77Var.f;
                if (i2 == 0) {
                    SkinManager.setBackgroundResource(this.b, R.drawable.topic_timeline_bg_one);
                } else if (i2 == 1) {
                    SkinManager.setBackgroundResource(this.b, R.drawable.topic_timeline_bg_two);
                } else {
                    SkinManager.setBackgroundResource(this.b, R.drawable.topic_timeline_bg_three);
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            super.onMeasure(i, i2);
            setMeasuredDimension(this.e, this.f);
        }
    }
}
