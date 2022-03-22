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
import c.a.p0.q1.l.b.c.e;
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
/* loaded from: classes5.dex */
public class TopicTimelineCellCardView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f33548b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33549c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33550d;

    /* renamed from: e  reason: collision with root package name */
    public int f33551e;

    /* renamed from: f  reason: collision with root package name */
    public int f33552f;

    /* renamed from: g  reason: collision with root package name */
    public e f33553g;

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

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d01c2, (ViewGroup) this, true);
            this.f33548b = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090585);
            this.f33549c = (TextView) findViewById(R.id.obfuscated_res_0x7f090586);
            this.f33550d = (TextView) findViewById(R.id.obfuscated_res_0x7f090587);
            this.f33551e = n.f(context, R.dimen.tbds340);
            this.f33552f = n.f(context, R.dimen.tbds230);
            setOnClickListener(this);
            b();
        }
    }

    public void b() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.a = skinType;
        SkinManager.setViewTextColor(this.f33549c, (int) R.color.cp_cont_m);
        SkinManager.setBackgroundResource(this.f33550d, R.drawable.topic_timeline_shade_bg);
        SkinManager.setViewTextColor(this.f33550d, (int) R.color.CAM_X0106);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) || this.f33553g == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13353").param("tid", this.f33553g.f17569b).param("topic_id", this.f33553g.a).param("obj_locate", this.f33553g.f17573f + 1));
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getContext()).createNormalCfg(String.valueOf(this.f33553g.f17569b), "", "")));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            super.onMeasure(i, i2);
            setMeasuredDimension(this.f33551e, this.f33552f);
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
            this.f33553g = eVar;
            this.f33549c.setText(eVar.f17571d);
            this.f33550d.setText(eVar.f17570c);
            if (StringUtils.isNull(eVar.f17572e)) {
                int i = eVar.f17573f;
                if (i == 0) {
                    SkinManager.setBackgroundResource(this.f33548b, R.drawable.topic_timeline_bg_one);
                    return;
                } else if (i == 1) {
                    SkinManager.setBackgroundResource(this.f33548b, R.drawable.topic_timeline_bg_two);
                    return;
                } else {
                    SkinManager.setBackgroundResource(this.f33548b, R.drawable.topic_timeline_bg_three);
                    return;
                }
            }
            try {
                GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(R.drawable.obfuscated_res_0x7f0811f6);
                gradientDrawable.setColor(Color.parseColor(eVar.f17572e));
                this.f33548b.setBackgroundDrawable(gradientDrawable);
            } catch (Exception unused) {
                int i2 = eVar.f17573f;
                if (i2 == 0) {
                    SkinManager.setBackgroundResource(this.f33548b, R.drawable.topic_timeline_bg_one);
                } else if (i2 == 1) {
                    SkinManager.setBackgroundResource(this.f33548b, R.drawable.topic_timeline_bg_two);
                } else {
                    SkinManager.setBackgroundResource(this.f33548b, R.drawable.topic_timeline_bg_three);
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
}
