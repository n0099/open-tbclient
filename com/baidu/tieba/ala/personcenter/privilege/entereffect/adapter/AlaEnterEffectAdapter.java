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
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bn;
/* loaded from: classes3.dex */
public class AlaEnterEffectAdapter extends bn<AlaEnterEffectData, ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;

    /* loaded from: classes3.dex */
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
                TbImageView tbImageView = (TbImageView) getView().findViewById(R.id.obfuscated_res_0x7f0901d3);
                this.a = tbImageView;
                tbImageView.setAutoChangeStyle(false);
                this.b = (TextView) getView().findViewById(R.id.obfuscated_res_0x7f0901d9);
                this.c = (TextView) getView().findViewById(R.id.obfuscated_res_0x7f0901da);
                this.d = (TextView) getView().findViewById(R.id.obfuscated_res_0x7f0901db);
                this.e = (ImageView) getView().findViewById(R.id.obfuscated_res_0x7f0901d0);
                this.f = (ProgressBar) getView().findViewById(R.id.obfuscated_res_0x7f0901d7);
                this.g = getView().findViewById(R.id.obfuscated_res_0x7f0901e2);
                this.h = getView().findViewById(R.id.obfuscated_res_0x7f0901d4);
                this.i = (TextView) getView().findViewById(R.id.obfuscated_res_0x7f0901cd);
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

    public final void s(ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewHolder) == null) || viewHolder == null) {
            return;
        }
        SkinManager.setBackgroundResource(viewHolder.getView(), R.color.CAM_X0201);
        SkinManager.setViewTextColor(viewHolder.d, R.color.CAM_X0109, 1, this.b);
        SkinManager.setViewTextColor(viewHolder.b, R.color.CAM_X0105, 1, this.b);
        if (this.b == 1) {
            viewHolder.g.setVisibility(0);
        } else {
            viewHolder.g.setVisibility(8);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: t */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) ? new ViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d00eb, (ViewGroup) null)) : (ViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, AlaEnterEffectData alaEnterEffectData, ViewHolder viewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, alaEnterEffectData, viewHolder})) == null) {
            viewHolder.a.K(alaEnterEffectData.thumbnail_url, 10, false);
            viewHolder.b.setText(alaEnterEffectData.name);
            if (alaEnterEffectData.isUsing()) {
                SkinManager.setViewTextColor(viewHolder.c, R.color.obfuscated_res_0x7f060784, 1, this.b);
                SkinManager.setBackgroundResource(viewHolder.c, R.drawable.obfuscated_res_0x7f0801d5, this.b);
                viewHolder.c.setText(this.a.getString(R.string.obfuscated_res_0x7f0f021a));
                viewHolder.a.setAlpha(1.0f);
            } else if (alaEnterEffectData.isOwn) {
                SkinManager.setViewTextColor(viewHolder.c, R.color.CAM_X0302, 1, this.b);
                SkinManager.setBackgroundResource(viewHolder.c, R.drawable.obfuscated_res_0x7f0801d3, this.b);
                viewHolder.c.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0213));
                viewHolder.a.setAlpha(1.0f);
            } else {
                SkinManager.setViewTextColor(viewHolder.c, R.color.CAM_X0109, 1, this.b);
                SkinManager.setBackgroundResource(viewHolder.c, R.drawable.obfuscated_res_0x7f0801d2, this.b);
                viewHolder.c.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0212));
                viewHolder.a.setAlpha(0.7f);
            }
            viewHolder.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0221, StringHelper.formatDayTime((alaEnterEffectData.end_time * 1000) - System.currentTimeMillis())));
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
                viewHolder.i.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0218, AlaStringHelper.formatLowercasekDou((float) alaEnterEffectData.price), alaEnterEffectData.time));
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
