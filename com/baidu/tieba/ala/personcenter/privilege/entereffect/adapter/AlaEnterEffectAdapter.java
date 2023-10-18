package com.baidu.tieba.ala.personcenter.privilege.entereffect.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.ala.utils.AlaStringHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import com.baidu.tieba.lh;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class AlaEnterEffectAdapter extends lh<AlaEnterEffectData, ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;

    /* loaded from: classes5.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;
        public TextView b;
        public TextView c;
        public TextView d;
        public ImageView e;
        public ProgressBar f;
        public View g;
        public View h;
        public TextView i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view2) {
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
            a();
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TbImageView tbImageView = (TbImageView) getView().findViewById(R.id.obfuscated_res_0x7f0901e9);
                this.a = tbImageView;
                tbImageView.setAutoChangeStyle(false);
                this.b = (TextView) getView().findViewById(R.id.obfuscated_res_0x7f0901ef);
                this.c = (TextView) getView().findViewById(R.id.obfuscated_res_0x7f0901f0);
                this.d = (TextView) getView().findViewById(R.id.obfuscated_res_0x7f0901f1);
                this.e = (ImageView) getView().findViewById(R.id.obfuscated_res_0x7f0901e6);
                this.f = (ProgressBar) getView().findViewById(R.id.obfuscated_res_0x7f0901ed);
                this.g = getView().findViewById(R.id.obfuscated_res_0x7f0901f8);
                this.h = getView().findViewById(R.id.obfuscated_res_0x7f0901ea);
                this.i = (TextView) getView().findViewById(R.id.obfuscated_res_0x7f0901e3);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaEnterEffectAdapter(Context context) {
        super(context, AlaEnterEffectData.TYPE_ENTER_EFFECT_DATA);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.a = context;
        this.b = TbadkCoreApplication.getInst().getSkinType();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: t */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            return new ViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d00f6, (ViewGroup) null));
        }
        return (ViewHolder) invokeL.objValue;
    }

    public final void s(ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewHolder) != null) || viewHolder == null) {
            return;
        }
        SkinManager.setBackgroundResource(viewHolder.getView(), R.color.CAM_X0201);
        SkinManager.setViewTextColor(viewHolder.d, R.color.CAM_X0109, 1, this.b);
        SkinManager.setViewTextColor(viewHolder.b, R.color.CAM_X0105, 1, this.b);
        viewHolder.g.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, AlaEnterEffectData alaEnterEffectData, ViewHolder viewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, alaEnterEffectData, viewHolder})) == null) {
            viewHolder.a.startLoad(alaEnterEffectData.thumbnail_url, 10, false);
            viewHolder.b.setText(alaEnterEffectData.name);
            if (alaEnterEffectData.isUsing()) {
                SkinManager.setViewTextColor(viewHolder.c, R.color.obfuscated_res_0x7f0607bf, 1, this.b);
                SkinManager.setBackgroundResource(viewHolder.c, R.drawable.obfuscated_res_0x7f0801f2, this.b);
                viewHolder.c.setText(this.a.getString(R.string.obfuscated_res_0x7f0f024b));
                viewHolder.a.setAlpha(1.0f);
            } else if (alaEnterEffectData.isOwn) {
                SkinManager.setViewTextColor(viewHolder.c, R.color.CAM_X0302, 1, this.b);
                SkinManager.setBackgroundResource(viewHolder.c, R.drawable.obfuscated_res_0x7f0801f0, this.b);
                viewHolder.c.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0244));
                viewHolder.a.setAlpha(1.0f);
            } else {
                SkinManager.setViewTextColor(viewHolder.c, R.color.CAM_X0109, 1, this.b);
                SkinManager.setBackgroundResource(viewHolder.c, R.drawable.obfuscated_res_0x7f0801ef, this.b);
                viewHolder.c.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0243));
                viewHolder.a.setAlpha(0.7f);
            }
            viewHolder.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0252, StringHelper.formatDayTime((alaEnterEffectData.end_time * 1000) - System.currentTimeMillis())));
            int i2 = alaEnterEffectData.downLoadStatus;
            if (i2 == 100) {
                viewHolder.e.setVisibility(0);
                viewHolder.f.setVisibility(8);
            } else if (i2 == 102) {
                viewHolder.e.setVisibility(8);
                viewHolder.f.setVisibility(0);
            } else {
                viewHolder.e.setVisibility(8);
                viewHolder.f.setVisibility(8);
            }
            viewHolder.h.setBackgroundColor(Color.parseColor(alaEnterEffectData.color));
            SkinManager.setViewTextColor(viewHolder.i, R.color.CAM_X0109, 1, this.b);
            if (2 == alaEnterEffectData.categoryType) {
                SkinManager.setViewTextColor(viewHolder.i, R.color.CAM_X0305, 1, this.b);
                viewHolder.i.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0249, AlaStringHelper.formatLowercasekDou((float) alaEnterEffectData.price), alaEnterEffectData.time));
                Drawable moneyIcon = CurrencySwitchUtil.getMoneyIcon();
                int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8);
                moneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                viewHolder.i.setCompoundDrawablePadding(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224));
                viewHolder.i.setCompoundDrawables(moneyIcon, null, null, null);
            } else {
                viewHolder.i.setText(alaEnterEffectData.obtain_way);
                viewHolder.i.setCompoundDrawables(null, null, null, null);
            }
            s(viewHolder);
            return viewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
