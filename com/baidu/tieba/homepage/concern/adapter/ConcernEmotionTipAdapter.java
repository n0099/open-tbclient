package com.baidu.tieba.homepage.concern.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.cp7;
import com.baidu.tieba.vm;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ConcernEmotionTipAdapter extends vm<cp7, ConcernEmotionTipViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* loaded from: classes4.dex */
    public static class ConcernEmotionTipViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NoDataView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConcernEmotionTipViewHolder(View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
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
            NoDataView a = NoDataViewFactory.a(view2.getContext(), view2, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NOPOST), NoDataViewFactory.e.d(null, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f045e)), null);
            this.a = a;
            a.setVisibility(0);
        }

        public void a(TbPageContext<?> tbPageContext, int i, NoDataViewFactory.ImgType imgType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, tbPageContext, i, imgType) == null) {
                this.a.setImgOption(NoDataViewFactory.d.a(imgType));
                this.a.f(tbPageContext, i);
                SkinManager.setBackgroundColor(this.a, R.color.CAM_X0202);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernEmotionTipAdapter(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getContext(), cp7.g);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernEmotionTipAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getContext(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vm
    /* renamed from: s */
    public ConcernEmotionTipViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            return new ConcernEmotionTipViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0202, viewGroup, false));
        }
        return (ConcernEmotionTipViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vm
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, cp7 cp7Var, ConcernEmotionTipViewHolder concernEmotionTipViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, cp7Var, concernEmotionTipViewHolder})) == null) {
            String str = cp7Var.b;
            if (str != null) {
                concernEmotionTipViewHolder.a.setTextOption(NoDataViewFactory.e.d(null, str));
            }
            if (cp7Var.getType() == cp7.f) {
                if (cp7Var.a == 2) {
                    concernEmotionTipViewHolder.a.setTextOption(NoDataViewFactory.e.d(null, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f045f)));
                } else {
                    concernEmotionTipViewHolder.a.setTextOption(NoDataViewFactory.e.d(null, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f045e)));
                }
            }
            int i2 = cp7Var.a;
            if (i2 != 2) {
                if (i2 == 3) {
                    concernEmotionTipViewHolder.a(this.a, TbadkCoreApplication.getInst().getSkinType(), NoDataViewFactory.ImgType.NOPOST);
                }
            } else {
                concernEmotionTipViewHolder.a(this.a, TbadkCoreApplication.getInst().getSkinType(), NoDataViewFactory.ImgType.NOFOLLOW);
            }
            SkinManager.setBackgroundColor(viewGroup, R.color.CAM_X0202);
            return concernEmotionTipViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
