package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.q0.r.r.e2;
import c.a.r0.f0.b;
import c.a.r0.y3.q0.d;
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
/* loaded from: classes5.dex */
public class FrsGameStrategyItemView extends b<c.a.r0.d1.u1.a.a.b> {
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
        public FrsGameStrategyItemView mView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FrsGameStrategyItemViewHolder(FrsGameStrategyItemView frsGameStrategyItemView) {
            super(frsGameStrategyItemView.j());
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
            this.mView = frsGameStrategyItemView;
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
        this.n = j();
        p();
    }

    @Override // c.a.r0.f0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.frs_game_strategy_item_layout : invokeV.intValue;
    }

    @Override // c.a.r0.f0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.n, R.drawable.addresslist_item_bg);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TbImageView tbImageView = (TbImageView) this.n.findViewById(R.id.frs_game_left_image);
            this.o = tbImageView;
            tbImageView.setDefaultResource(R.drawable.icon_morenpic);
            this.p = (ImageView) this.n.findViewById(R.id.frs_game_video_icon);
            this.q = (TextView) this.n.findViewById(R.id.frs_game_strategy_title);
            this.r = (TextView) this.n.findViewById(R.id.frs_game_strategy_scan_info);
            this.s = (TextView) this.n.findViewById(R.id.frs_game_strategy_info_source);
            l(this.m, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.f0.b
    /* renamed from: q */
    public void k(c.a.r0.d1.u1.a.a.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) || bVar == null || bVar.getThreadData() == null) {
            return;
        }
        e2 threadData = bVar.getThreadData();
        this.q.setText(threadData.getTitle());
        d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.d(threadData.h0())) {
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0108);
        } else {
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0105);
        }
        String numberUniformFormat = StringHelper.numberUniformFormat(threadData.F1());
        String formatTimeShort = StringHelper.getFormatTimeShort(threadData.I());
        if (!StringUtils.isNull(numberUniformFormat) && !StringUtils.isNull(formatTimeShort)) {
            this.r.setText(String.format(this.f17262g.getString(R.string.frs_game_strategy_scan_info), numberUniformFormat, formatTimeShort));
        }
        String str = null;
        if (threadData.s1() == 40) {
            this.p.setVisibility(0);
            if (threadData.u1() != null) {
                str = threadData.u1().thumbnail_url;
            }
        } else {
            this.p.setVisibility(8);
            if (threadData.G0() != null && threadData.G0().size() >= 1) {
                str = threadData.G0().get(0).getOriginalUrl();
            }
        }
        this.o.startLoad(str, 10, false);
        if (!StringUtils.isNull(threadData.d0())) {
            this.s.setText(threadData.d0());
            this.s.setVisibility(0);
            return;
        }
        this.s.setVisibility(8);
    }
}
