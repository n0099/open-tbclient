package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TopicDetailActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.homepage.topic.topictab.view.CellTopicLinearLayout;
import com.baidu.tieba.homepage.topic.topictab.view.TopicPkView;
import com.baidu.tieba.memberCenter.memberpay.MemberPayResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class g48 extends in6<d48> {
    public static /* synthetic */ Interceptable $ic;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;
    public final View i;
    public int j;
    public CellTopicLinearLayout k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public RelativeLayout p;
    public TbImageView q;
    public View r;
    public TopicPkView s;
    public ThreadGodReplyLayout t;
    public View u;
    public RelativeLayout v;
    public HeadImageView w;
    public d48 x;
    public final int y;

    @Override // com.baidu.tieba.in6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01f0 : invokeV.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947744062, "Lcom/baidu/tieba/g48;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947744062, "Lcom/baidu/tieba/g48;");
                return;
            }
        }
        z = vi.l(TbadkCoreApplication.getInst()) - ((vi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + vi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g48(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = 3;
        this.y = vi.g(getContext(), R.dimen.M_W_X005);
        View h = h();
        this.k = (CellTopicLinearLayout) h.findViewById(R.id.obfuscated_res_0x7f090674);
        this.v = (RelativeLayout) h.findViewById(R.id.obfuscated_res_0x7f090676);
        this.l = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090671);
        this.m = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090675);
        this.n = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090672);
        this.o = (TextView) h.findViewById(R.id.obfuscated_res_0x7f09066b);
        this.p = (RelativeLayout) h.findViewById(R.id.obfuscated_res_0x7f09066e);
        this.q = (TbImageView) h.findViewById(R.id.obfuscated_res_0x7f09066d);
        this.r = h.findViewById(R.id.obfuscated_res_0x7f090670);
        this.s = (TopicPkView) h.findViewById(R.id.obfuscated_res_0x7f090673);
        this.t = (ThreadGodReplyLayout) h.findViewById(R.id.obfuscated_res_0x7f09066c);
        this.u = h.findViewById(R.id.obfuscated_res_0x7f09066f);
        this.i = h.findViewById(R.id.obfuscated_res_0x7f09066a);
        HeadImageView headImageView = (HeadImageView) h.findViewById(R.id.user_avatar);
        this.w = headImageView;
        headImageView.setIsRound(true);
        this.w.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.w.setDefaultResource(17170445);
        this.w.setPlaceHolder(1);
        t(this.v);
        t(this.o);
        t(this.t);
        t(this.i);
        t(this.q);
        t(this.u);
        int g = vi.g(getContext(), R.dimen.tbds11);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.s.getLayoutParams();
        layoutParams.leftMargin = g;
        layoutParams.rightMargin = g;
        this.s.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.q.getLayoutParams();
        layoutParams2.height = ((vi.l(getContext()) - vi.g(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.q.setLayoutParams(layoutParams2);
        this.q.setRadiusById(R.string.J_X05);
        this.q.setConrers(15);
        this.q.setDrawCorner(true);
        this.q.setPlaceHolder(3);
    }

    public final void t(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, view2) == null) && (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            int i = this.y;
            marginLayoutParams.leftMargin = i;
            marginLayoutParams.rightMargin = i;
            view2.setLayoutParams(marginLayoutParams);
        }
    }

    @Override // com.baidu.tieba.in6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            this.s.q();
            this.t.l();
            if (i == this.j) {
                return;
            }
            this.j = i;
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0105);
            this.q.setSkinType(this.j);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        d48 d48Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, view2) != null) || (d48Var = this.x) == null) {
            return;
        }
        if (d48Var.Z != 1) {
            TiebaStatic.log(new StatisticItem("c13351").param("topic_id", this.x.S).param("obj_locate", this.x.R));
        }
        if (this.x.Z == 1) {
            TiebaStatic.log(new StatisticItem("c13449").param("topic_id", this.x.S));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TopicDetailActivityConfig(getContext(), this.x.S)));
    }

    public CellTopicLinearLayout r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.k;
        }
        return (CellTopicLinearLayout) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in6
    /* renamed from: s */
    public void i(d48 d48Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, d48Var) != null) || d48Var == null) {
            return;
        }
        this.x = d48Var;
        if (d48Var.Z == 0) {
            this.w.setVisibility(8);
            this.l.setVisibility(0);
            this.n.setVisibility(0);
            this.l.setText(String.valueOf(d48Var.R));
            int i = d48Var.R;
            if (i == 1) {
                SkinManager.setBackgroundResource(this.l, R.drawable.topic_rank_one_bg);
            } else if (i == 2) {
                SkinManager.setBackgroundResource(this.l, R.drawable.topic_rank_two_bg);
            } else if (i == 3) {
                SkinManager.setBackgroundResource(this.l, R.drawable.topic_rank_three_bg);
            } else {
                SkinManager.setBackgroundResource(this.l, R.drawable.topic_rank_other_bg);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            int g = vi.g(getContext(), R.dimen.tbds16);
            layoutParams.addRule(1, R.id.obfuscated_res_0x7f090671);
            layoutParams.setMargins(g, 0, g, 0);
            ThreadCardUtils.cutAndSetTextByMaxLine(this.o, d48Var.U, R.string.check_detail, R.dimen.tbds17, 2, z, true);
            if (d48Var.V == 0) {
                this.n.setText(MemberPayResult.VipPayPrivilegeData.NEW_TIP_TEXT);
            } else {
                this.n.setText(String.format(this.b.getString(R.string.obfuscated_res_0x7f0f1683), StringHelper.numberUniformFormat(d48Var.V)));
            }
            if (d48Var.Y == null) {
                this.t.setVisibility(8);
            } else {
                this.t.setVisibility(0);
                this.t.setData(d48Var.Y);
            }
        } else {
            this.w.setVisibility(0);
            this.l.setVisibility(8);
            this.n.setVisibility(8);
            this.t.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            int g2 = vi.g(getContext(), R.dimen.tbds30);
            int g3 = vi.g(getContext(), R.dimen.tbds16);
            layoutParams2.addRule(1, R.id.user_avatar);
            layoutParams2.setMargins(g2, 0, g3, 0);
            this.m.setTextSize(0, vi.g(this.c, R.dimen.tbds40));
            o75 d = o75.d(this.m);
            d.w(R.color.CAM_X0105);
            d.C(R.string.F_X01);
            if (StringUtils.isNull(d48Var.U)) {
                this.o.setVisibility(8);
            } else {
                this.o.setVisibility(0);
                ThreadCardUtils.setAbstractStyleAb(this.o);
                ThreadCardUtils.cutAndSetTextByMaxLine(this.o, d48Var.U, R.string.check_detail, R.dimen.tbds17, 2, z, true, false);
            }
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1);
        }
        String str = d48Var.f1092T;
        if (str.length() > 14) {
            str = str.substring(0, 13) + "...";
        }
        this.m.setText(String.format(this.b.getString(R.string.obfuscated_res_0x7f0f0516), str));
        if (StringUtils.isNull(d48Var.W)) {
            this.p.setVisibility(8);
            this.s.setUserColor(R.color.CAM_X0109);
        } else {
            this.p.setVisibility(0);
            this.q.setPlaceHolder(3);
            this.q.N(d48Var.W, 10, false);
            this.s.setUserColor(R.color.CAM_X0101);
        }
        if (!StringUtils.isNull(d48Var.a0)) {
            this.w.setVisibility(0);
            this.w.N(d48Var.a0, 10, false);
        }
        if (d48Var.X == null) {
            this.r.setVisibility(8);
            this.s.setVisibility(8);
            this.u.setVisibility(8);
            return;
        }
        this.r.setVisibility(0);
        this.s.setVisibility(0);
        this.s.setData(d48Var.X);
        this.u.setVisibility(0);
    }
}
