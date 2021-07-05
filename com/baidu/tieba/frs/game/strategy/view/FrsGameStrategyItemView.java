package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.b2;
import d.a.s0.a0.b;
import d.a.s0.h3.n0.d;
/* loaded from: classes5.dex */
public class FrsGameStrategyItemView extends b<d.a.s0.u0.r1.a.a.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public View n;
    public TbImageView o;
    public ImageView p;
    public TextView q;
    public TextView r;
    public TextView s;

    /* loaded from: classes5.dex */
    public static class FrsGameStrategyItemViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public FrsGameStrategyItemView f15674a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FrsGameStrategyItemViewHolder(FrsGameStrategyItemView frsGameStrategyItemView) {
            super(frsGameStrategyItemView.l());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameStrategyItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15674a = frsGameStrategyItemView;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsGameStrategyItemView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = tbPageContext;
        this.n = l();
        s();
    }

    @Override // d.a.s0.a0.b
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.frs_game_strategy_item_layout : invokeV.intValue;
    }

    @Override // d.a.s0.a0.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.n, R.drawable.addresslist_item_bg);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TbImageView tbImageView = (TbImageView) this.n.findViewById(R.id.frs_game_left_image);
            this.o = tbImageView;
            tbImageView.setDefaultResource(R.drawable.icon_morenpic);
            this.p = (ImageView) this.n.findViewById(R.id.frs_game_video_icon);
            this.q = (TextView) this.n.findViewById(R.id.frs_game_strategy_title);
            this.r = (TextView) this.n.findViewById(R.id.frs_game_strategy_scan_info);
            this.s = (TextView) this.n.findViewById(R.id.frs_game_strategy_info_source);
            n(this.m, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.a0.b
    /* renamed from: t */
    public void m(d.a.s0.u0.r1.a.a.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) || bVar == null || bVar.getThreadData() == null) {
            return;
        }
        b2 threadData = bVar.getThreadData();
        this.q.setText(threadData.getTitle());
        d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.d(threadData.c0())) {
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0108);
        } else {
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0105);
        }
        String numberUniformFormat = StringHelper.numberUniformFormat(threadData.w1());
        String formatTimeShort = StringHelper.getFormatTimeShort(threadData.G());
        if (!StringUtils.isNull(numberUniformFormat) && !StringUtils.isNull(formatTimeShort)) {
            this.r.setText(String.format(this.f57033g.getString(R.string.frs_game_strategy_scan_info), numberUniformFormat, formatTimeShort));
        }
        String str = null;
        if (threadData.j1() == 40) {
            this.p.setVisibility(0);
            if (threadData.l1() != null) {
                str = threadData.l1().thumbnail_url;
            }
        } else {
            this.p.setVisibility(8);
            if (threadData.z0() != null && threadData.z0().size() >= 1) {
                str = threadData.z0().get(0).getOriginalUrl();
            }
        }
        this.o.M(str, 10, false);
        if (!StringUtils.isNull(threadData.Y())) {
            this.s.setText(threadData.Y());
            this.s.setVisibility(0);
            return;
        }
        this.s.setVisibility(8);
    }
}
