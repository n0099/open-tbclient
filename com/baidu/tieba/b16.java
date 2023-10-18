package com.baidu.tieba;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
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
/* loaded from: classes5.dex */
public class b16 extends cj6<f16> {
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
    public f16 q;

    @Override // com.baidu.tieba.cj6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.ad_incentive_video_view : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b16(TbPageContext<?> tbPageContext) {
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
        y(i());
    }

    public final String o(f16 f16Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, f16Var)) == null) {
            if (f16Var == null) {
                return "";
            }
            int i = f16Var.b;
            if ((i != 3 && i != 2 && i != 4 && i != 5) || !(c() instanceof o35)) {
                return "";
            }
            return ((o35) c()).t0();
        }
        return (String) invokeL.objValue;
    }

    public final String u(f16 f16Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, f16Var)) == null) {
            if (f16Var == null) {
                return "";
            }
            int i = f16Var.b;
            if ((i != 3 && i != 2 && i != 4 && i != 5) || !(c() instanceof o35)) {
                return "";
            }
            return ((o35) c()).l1();
        }
        return (String) invokeL.objValue;
    }

    public final void x(f16 f16Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, f16Var) == null) && !f16Var.f()) {
            f16Var.l(true);
            int i = f16Var.b;
            if (i != 3 && i != 2) {
                if (i == 1) {
                    a16.i().m(2);
                    return;
                } else if (i == 4 || i == 5) {
                    a16.i().m(4);
                    return;
                } else {
                    return;
                }
            }
            a16.i().m(3);
        }
    }

    public final void A(f16 f16Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, f16Var) == null) {
            this.k.setShowOval(true);
            this.k.setAutoChangeStyle(true);
            this.k.setStrokeWith(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.k.setStrokeColorResId(R.color.CAM_X0401);
            this.k.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.k.setPlaceHolder(1);
            this.k.startLoad(f16Var.e(), 10, false);
        }
    }

    public final void B(f16 f16Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f16Var) != null) || f16Var == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.i.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.j.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.o.getLayoutParams();
        int i = f16Var.b;
        if (i != 3 && i != 2 && i != 1) {
            if (i == 4) {
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams2.leftMargin = BdUtilHelper.getDimens(this.c, R.dimen.M_W_X007);
                layoutParams2.rightMargin = BdUtilHelper.getDimens(this.c, R.dimen.M_W_X007);
                View view2 = this.j;
                view2.setPadding(view2.getPaddingLeft(), BdUtilHelper.getDimens(this.c, R.dimen.M_H_X004), this.j.getPaddingRight(), BdUtilHelper.getDimens(this.c, R.dimen.M_H_X004));
                this.o.setVisibility(0);
                layoutParams3.height = BdUtilHelper.getDimens(this.c, R.dimen.tbds16);
                this.p.setVisibility(8);
                return;
            } else if (i == 5) {
                layoutParams.leftMargin = BdUtilHelper.getDimens(this.c, R.dimen.M_W_X021);
                layoutParams.rightMargin = BdUtilHelper.getDimens(this.c, R.dimen.M_W_X007);
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                View view3 = this.j;
                view3.setPadding(view3.getPaddingLeft(), BdUtilHelper.getDimens(this.c, R.dimen.M_H_X004), this.j.getPaddingRight(), BdUtilHelper.getDimens(this.c, R.dimen.M_H_X004));
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
        view4.setPadding(view4.getPaddingLeft(), BdUtilHelper.getDimens(this.c, R.dimen.M_H_X004), BdUtilHelper.getDimens(this.c, R.dimen.M_H_X004), BdUtilHelper.getDimens(this.c, R.dimen.M_H_X004));
        this.o.setVisibility(0);
        layoutParams3.height = BdUtilHelper.getDimens(this.c, R.dimen.tbds21);
        this.p.setVisibility(8);
    }

    public final int t(f16 f16Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, f16Var)) == null) {
            if (f16Var == null) {
                return 0;
            }
            int i = f16Var.b;
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

    @Override // com.baidu.tieba.cj6
    public void k(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            f16 f16Var = this.q;
            if (f16Var != null) {
                int i2 = f16Var.b;
                if (i2 != 3 && i2 != 2 && i2 != 1) {
                    EMManager.from(this.o).setBackGroundColor(R.color.CAM_X0204);
                } else {
                    EMManager.from(this.o).setBackGroundColor(R.color.transparent);
                }
            } else {
                EMManager.from(this.o).setBackGroundColor(R.color.CAM_X0204);
            }
            EMManager.from(this.p).setBackGroundColor(R.color.CAM_X0203);
            EMManager.from(this.j).setCardType(0).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.l).setTextColor(R.color.CAM_X0107);
            EMManager.from(this.m).setTextColor(R.color.CAM_X0109);
            a55 a55Var = new a55();
            a55Var.u(R.color.CAM_X0304);
            this.n.setConfig(a55Var);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            a16.i().v(this.q.b);
            a16.i().t();
            new GetIncentiveVideoTaskModel(this.c, this.q.b).V();
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_NO_AD_CARD_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", t(this.q)).param("fid", o(this.q)).param("tid", u(this.q)));
        }
    }

    public final void y(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
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
    @Override // com.baidu.tieba.cj6
    /* renamed from: z */
    public void j(f16 f16Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, f16Var) != null) || f16Var == null) {
            return;
        }
        this.q = f16Var;
        x(f16Var);
        A(f16Var);
        B(f16Var);
        this.l.setText(f16Var.getTitle());
        this.m.setText(f16Var.d());
        this.n.setText(f16Var.c());
        k(this.b, TbadkCoreApplication.getInst().getSkinType());
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_NO_AD_CARD_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", t(f16Var)).param("fid", o(f16Var)).param("tid", u(f16Var)));
    }
}
