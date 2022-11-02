package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.bq8;
import com.baidu.tieba.qo6;
import com.baidu.tieba.z26;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class FrsGameStrategyItemView extends z26<qo6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public View j;
    public TbImageView k;
    public ImageView l;
    public TextView m;
    public TextView n;
    public TextView o;

    @Override // com.baidu.tieba.z26
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d030e : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public static class FrsGameStrategyItemViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FrsGameStrategyItemView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FrsGameStrategyItemViewHolder(FrsGameStrategyItemView frsGameStrategyItemView) {
            super(frsGameStrategyItemView.k());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameStrategyItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsGameStrategyItemView;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = tbPageContext;
        this.j = k();
        r();
    }

    @Override // com.baidu.tieba.z26
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.j, R.drawable.addresslist_item_bg);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TbImageView tbImageView = (TbImageView) this.j.findViewById(R.id.obfuscated_res_0x7f090b40);
            this.k = tbImageView;
            tbImageView.setDefaultResource(R.drawable.obfuscated_res_0x7f08089a);
            this.l = (ImageView) this.j.findViewById(R.id.obfuscated_res_0x7f090b53);
            this.m = (TextView) this.j.findViewById(R.id.obfuscated_res_0x7f090b4f);
            this.n = (TextView) this.j.findViewById(R.id.obfuscated_res_0x7f090b4e);
            this.o = (TextView) this.j.findViewById(R.id.obfuscated_res_0x7f090b4d);
            m(this.i, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.z26
    /* renamed from: s */
    public void l(qo6 qo6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, qo6Var) == null) && qo6Var != null && qo6Var.getThreadData() != null) {
            ThreadData threadData = qo6Var.getThreadData();
            this.m.setText(threadData.getTitle());
            bq8 readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.d(threadData.getId())) {
                SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0108);
            } else {
                SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0105);
            }
            String numberUniformFormat = StringHelper.numberUniformFormat(threadData.getView_num());
            String formatTimeShort = StringHelper.getFormatTimeShort(threadData.getAuditTime());
            if (!StringUtils.isNull(numberUniformFormat) && !StringUtils.isNull(formatTimeShort)) {
                this.n.setText(String.format(this.c.getString(R.string.obfuscated_res_0x7f0f071f), numberUniformFormat, formatTimeShort));
            }
            String str = null;
            if (threadData.getThreadType() == 40) {
                this.l.setVisibility(0);
                if (threadData.getThreadVideoInfo() != null) {
                    str = threadData.getThreadVideoInfo().thumbnail_url;
                }
            } else {
                this.l.setVisibility(8);
                if (threadData.getMedias() != null && threadData.getMedias().size() >= 1) {
                    str = threadData.getMedias().get(0).getOriginalUrl();
                }
            }
            this.k.K(str, 10, false);
            if (!StringUtils.isNull(threadData.getGameInformationSource())) {
                this.o.setText(threadData.getGameInformationSource());
                this.o.setVisibility(0);
                return;
            }
            this.o.setVisibility(8);
        }
    }
}
