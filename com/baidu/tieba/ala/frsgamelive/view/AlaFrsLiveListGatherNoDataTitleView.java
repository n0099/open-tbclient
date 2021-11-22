package com.baidu.tieba.ala.frsgamelive.view;

import android.view.View;
import android.widget.TextView;
import b.a.r0.b0.b;
import b.a.r0.w.g.b.a;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class AlaFrsLiveListGatherNoDataTitleView extends b<a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView m;
    public TextView n;
    public TbPageContext o;
    public int p;

    /* loaded from: classes8.dex */
    public static class AlaFrsLiveListNoDataViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AlaFrsLiveListGatherNoDataTitleView mView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AlaFrsLiveListNoDataViewHolder(AlaFrsLiveListGatherNoDataTitleView alaFrsLiveListGatherNoDataTitleView) {
            super(alaFrsLiveListGatherNoDataTitleView.i());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaFrsLiveListGatherNoDataTitleView};
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
            this.mView = alaFrsLiveListGatherNoDataTitleView;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaFrsLiveListGatherNoDataTitleView(TbPageContext<?> tbPageContext) {
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
        this.p = 3;
        this.o = tbPageContext;
        View i4 = i();
        this.m = (TextView) i4.findViewById(R.id.frs_game_live_recommand1);
        this.n = (TextView) i4.findViewById(R.id.frs_game_live_recommand2);
        k(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.ala_frs_game_live_no_data_view : invokeV.intValue;
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.p == i2) {
            return;
        }
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0109);
        this.p = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: o */
    public void j(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            k(this.o, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
        }
    }
}
