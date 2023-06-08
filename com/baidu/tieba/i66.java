package com.baidu.tieba;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.ad.incentivevideo.net.GetIncentiveVideoTaskModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class i66 extends in6<m66> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public View j;
    public BarImageView k;
    public TextView l;
    public TextView m;
    public TBSpecificationBtn n;
    public View o;
    public View p;
    public m66 q;

    @Override // com.baidu.tieba.in6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.ad_incentive_video_view : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i66(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        x(h());
    }

    public final String r(m66 m66Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, m66Var)) == null) {
            if (m66Var == null) {
                return "";
            }
            int i = m66Var.b;
            if ((i != 3 && i != 2 && i != 4 && i != 5) || !(getContext() instanceof d95)) {
                return "";
            }
            return ((d95) getContext()).w0();
        }
        return (String) invokeL.objValue;
    }

    public final String t(m66 m66Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, m66Var)) == null) {
            if (m66Var == null) {
                return "";
            }
            int i = m66Var.b;
            if ((i != 3 && i != 2 && i != 4 && i != 5) || !(getContext() instanceof d95)) {
                return "";
            }
            return ((d95) getContext()).r1();
        }
        return (String) invokeL.objValue;
    }

    public final void u(m66 m66Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, m66Var) == null) && !m66Var.f()) {
            m66Var.l(true);
            int i = m66Var.b;
            if (i != 3 && i != 2) {
                if (i == 1) {
                    h66.i().m(2);
                    return;
                } else if (i == 4 || i == 5) {
                    h66.i().m(4);
                    return;
                } else {
                    return;
                }
            }
            h66.i().m(3);
        }
    }

    public final void A(m66 m66Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, m66Var) != null) || m66Var == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.i.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.j.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.o.getLayoutParams();
        int i = m66Var.b;
        if (i != 3 && i != 2 && i != 1) {
            if (i == 4) {
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams2.leftMargin = vi.g(this.c, R.dimen.M_W_X007);
                layoutParams2.rightMargin = vi.g(this.c, R.dimen.M_W_X007);
                View view2 = this.j;
                view2.setPadding(view2.getPaddingLeft(), vi.g(this.c, R.dimen.M_H_X004), this.j.getPaddingRight(), vi.g(this.c, R.dimen.M_H_X004));
                this.o.setVisibility(0);
                layoutParams3.height = vi.g(this.c, R.dimen.tbds16);
                this.p.setVisibility(8);
                return;
            } else if (i == 5) {
                layoutParams.leftMargin = vi.g(this.c, R.dimen.M_W_X021);
                layoutParams.rightMargin = vi.g(this.c, R.dimen.M_W_X007);
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                View view3 = this.j;
                view3.setPadding(view3.getPaddingLeft(), vi.g(this.c, R.dimen.M_H_X004), this.j.getPaddingRight(), vi.g(this.c, R.dimen.M_H_X004));
                this.o.setVisibility(8);
                this.p.setVisibility(0);
                return;
            } else {
                return;
            }
        }
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        layoutParams2.leftMargin = 0;
        layoutParams2.rightMargin = 0;
        View view4 = this.j;
        view4.setPadding(view4.getPaddingLeft(), vi.g(this.c, R.dimen.M_H_X004), vi.g(this.c, R.dimen.M_H_X004), vi.g(this.c, R.dimen.M_H_X004));
        this.o.setVisibility(0);
        layoutParams3.height = vi.g(this.c, R.dimen.tbds21);
        this.p.setVisibility(8);
    }

    public final int s(m66 m66Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, m66Var)) == null) {
            if (m66Var == null) {
                return 0;
            }
            int i = m66Var.b;
            if (i == 1) {
                return 1;
            }
            if (i != 3 && i != 2) {
                if (i != 4 && i != 5) {
                    return 0;
                }
                return 3;
            }
            return 2;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.in6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            m66 m66Var = this.q;
            if (m66Var != null) {
                int i2 = m66Var.b;
                if (i2 != 3 && i2 != 2 && i2 != 1) {
                    o75.d(this.o).f(R.color.CAM_X0204);
                } else {
                    o75.d(this.o).f(R.color.transparent);
                }
            } else {
                o75.d(this.o).f(R.color.CAM_X0204);
            }
            o75.d(this.p).f(R.color.CAM_X0203);
            o75 d = o75.d(this.j);
            d.n(0);
            d.o(R.string.J_X06);
            d.f(R.color.CAM_X0201);
            o75.d(this.l).w(R.color.CAM_X0107);
            o75.d(this.m).w(R.color.CAM_X0109);
            la5 la5Var = new la5();
            la5Var.t(R.color.CAM_X0304);
            this.n.setConfig(la5Var);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            h66.i().v(this.q.b);
            h66.i().t();
            new GetIncentiveVideoTaskModel(this.c, this.q.b).c0();
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_NO_AD_CARD_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", s(this.q)).param("fid", r(this.q)).param("tid", t(this.q)));
        }
    }

    public final void x(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            this.o = view2.findViewById(R.id.ad_incentive_video_divide_top);
            this.p = view2.findViewById(R.id.ad_incentive_video_divide_bottom);
            this.i = view2.findViewById(R.id.ad_incentive_video_layout);
            this.j = view2.findViewById(R.id.ad_incentive_video_content_layout);
            this.k = (BarImageView) view2.findViewById(R.id.ad_incentive_video_icon);
            this.l = (TextView) view2.findViewById(R.id.ad_incentive_video_title);
            this.m = (TextView) view2.findViewById(R.id.ad_incentive_video_content);
            this.n = (TBSpecificationBtn) view2.findViewById(R.id.ad_incentive_video_btn);
            this.i.setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in6
    /* renamed from: y */
    public void i(m66 m66Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, m66Var) != null) || m66Var == null) {
            return;
        }
        this.q = m66Var;
        u(m66Var);
        z(m66Var);
        A(m66Var);
        this.l.setText(m66Var.getTitle());
        this.m.setText(m66Var.d());
        this.n.setText(m66Var.c());
        j(this.b, TbadkCoreApplication.getInst().getSkinType());
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_NO_AD_CARD_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", s(m66Var)).param("fid", r(m66Var)).param("tid", t(m66Var)));
    }

    public final void z(m66 m66Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, m66Var) == null) {
            this.k.setShowOval(true);
            this.k.setAutoChangeStyle(true);
            this.k.setStrokeWith(vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.k.setStrokeColorResId(R.color.CAM_X0401);
            this.k.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.k.setPlaceHolder(1);
            this.k.N(m66Var.e(), 10, false);
        }
    }
}
