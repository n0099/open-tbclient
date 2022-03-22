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
import c.a.d.o.e.a;
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
/* loaded from: classes5.dex */
public class AlaEnterEffectAdapter extends a<AlaEnterEffectData, ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context i;
    public int j;

    /* loaded from: classes5.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f31493b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f31494c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f31495d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f31496e;

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f31497f;

        /* renamed from: g  reason: collision with root package name */
        public View f31498g;

        /* renamed from: h  reason: collision with root package name */
        public View f31499h;
        public TextView i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
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
            c();
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TbImageView tbImageView = (TbImageView) b().findViewById(R.id.obfuscated_res_0x7f0901cf);
                this.a = tbImageView;
                tbImageView.setAutoChangeStyle(false);
                this.f31493b = (TextView) b().findViewById(R.id.obfuscated_res_0x7f0901d5);
                this.f31494c = (TextView) b().findViewById(R.id.obfuscated_res_0x7f0901d6);
                this.f31495d = (TextView) b().findViewById(R.id.obfuscated_res_0x7f0901d7);
                this.f31496e = (ImageView) b().findViewById(R.id.obfuscated_res_0x7f0901cc);
                this.f31497f = (ProgressBar) b().findViewById(R.id.obfuscated_res_0x7f0901d3);
                this.f31498g = b().findViewById(R.id.obfuscated_res_0x7f0901df);
                this.f31499h = b().findViewById(R.id.obfuscated_res_0x7f0901d0);
                this.i = (TextView) b().findViewById(R.id.obfuscated_res_0x7f0901c9);
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
        this.i = context;
        this.j = TbadkCoreApplication.getInst().getSkinType();
    }

    public final void Z(ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewHolder) == null) || viewHolder == null) {
            return;
        }
        SkinManager.setBackgroundResource(viewHolder.b(), R.color.CAM_X0201);
        SkinManager.setViewTextColor(viewHolder.f31495d, R.color.CAM_X0109, 1, this.j);
        SkinManager.setViewTextColor(viewHolder.f31493b, R.color.CAM_X0105, 1, this.j);
        if (this.j == 1) {
            viewHolder.f31498g.setVisibility(0);
        } else {
            viewHolder.f31498g.setVisibility(8);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: a0 */
    public ViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) ? new ViewHolder(LayoutInflater.from(this.i).inflate(R.layout.obfuscated_res_0x7f0d00f2, (ViewGroup) null)) : (ViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: b0 */
    public View S(int i, View view, ViewGroup viewGroup, AlaEnterEffectData alaEnterEffectData, ViewHolder viewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view, viewGroup, alaEnterEffectData, viewHolder})) == null) {
            viewHolder.a.J(alaEnterEffectData.thumbnail_url, 10, false);
            viewHolder.f31493b.setText(alaEnterEffectData.name);
            if (alaEnterEffectData.isUsing()) {
                SkinManager.setViewTextColor(viewHolder.f31494c, R.color.obfuscated_res_0x7f060774, 1, this.j);
                SkinManager.setBackgroundResource(viewHolder.f31494c, R.drawable.obfuscated_res_0x7f0801d6, this.j);
                viewHolder.f31494c.setText(this.i.getString(R.string.obfuscated_res_0x7f0f0211));
                viewHolder.a.setAlpha(1.0f);
            } else if (alaEnterEffectData.isOwn) {
                SkinManager.setViewTextColor(viewHolder.f31494c, R.color.CAM_X0302, 1, this.j);
                SkinManager.setBackgroundResource(viewHolder.f31494c, R.drawable.obfuscated_res_0x7f0801d4, this.j);
                viewHolder.f31494c.setText(this.i.getString(R.string.obfuscated_res_0x7f0f020a));
                viewHolder.a.setAlpha(1.0f);
            } else {
                SkinManager.setViewTextColor(viewHolder.f31494c, R.color.CAM_X0109, 1, this.j);
                SkinManager.setBackgroundResource(viewHolder.f31494c, R.drawable.obfuscated_res_0x7f0801d3, this.j);
                viewHolder.f31494c.setText(this.i.getString(R.string.obfuscated_res_0x7f0f0209));
                viewHolder.a.setAlpha(0.7f);
            }
            viewHolder.f31495d.setText(this.i.getResources().getString(R.string.obfuscated_res_0x7f0f0218, StringHelper.formatDayTime((alaEnterEffectData.end_time * 1000) - System.currentTimeMillis())));
            int i2 = alaEnterEffectData.downLoadStatus;
            if (i2 == 100) {
                viewHolder.f31496e.setVisibility(0);
                viewHolder.f31497f.setVisibility(8);
            } else if (i2 == 102) {
                viewHolder.f31496e.setVisibility(8);
                viewHolder.f31497f.setVisibility(0);
            } else {
                viewHolder.f31496e.setVisibility(8);
                viewHolder.f31497f.setVisibility(8);
            }
            viewHolder.f31499h.setBackgroundColor(Color.parseColor(alaEnterEffectData.color));
            SkinManager.setViewTextColor(viewHolder.i, R.color.CAM_X0109, 1, this.j);
            if (2 == alaEnterEffectData.categoryType) {
                SkinManager.setViewTextColor(viewHolder.i, R.color.CAM_X0305, 1, this.j);
                viewHolder.i.setText(this.i.getString(R.string.obfuscated_res_0x7f0f020f, AlaStringHelper.formatLowercasekDou((float) alaEnterEffectData.price), alaEnterEffectData.time));
                Drawable moneyIcon = CurrencySwitchUtil.getMoneyIcon();
                int dimensionPixelSize = this.i.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8);
                moneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                viewHolder.i.setCompoundDrawablePadding(this.i.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224));
                viewHolder.i.setCompoundDrawables(moneyIcon, null, null, null);
            } else {
                viewHolder.i.setText(alaEnterEffectData.obtain_way);
                viewHolder.i.setCompoundDrawables(null, null, null, null);
            }
            Z(viewHolder);
            return viewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }
}
