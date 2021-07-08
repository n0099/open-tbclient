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
import d.a.c.k.e.a;
/* loaded from: classes4.dex */
public class AlaEnterEffectAdapter extends a<AlaEnterEffectData, ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context m;
    public int n;

    /* loaded from: classes4.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f14322a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f14323b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14324c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14325d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f14326e;

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f14327f;

        /* renamed from: g  reason: collision with root package name */
        public View f14328g;

        /* renamed from: h  reason: collision with root package name */
        public View f14329h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f14330i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
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
            b();
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TbImageView tbImageView = (TbImageView) a().findViewById(R.id.ala_enter_effect_img);
                this.f14322a = tbImageView;
                tbImageView.setAutoChangeStyle(false);
                this.f14323b = (TextView) a().findViewById(R.id.ala_enter_effect_name);
                this.f14324c = (TextView) a().findViewById(R.id.ala_enter_effect_status);
                this.f14325d = (TextView) a().findViewById(R.id.ala_enter_effect_time_limit);
                this.f14326e = (ImageView) a().findViewById(R.id.ala_enter_effect_download_img);
                this.f14327f = (ProgressBar) a().findViewById(R.id.ala_enter_effect_loading);
                this.f14328g = a().findViewById(R.id.ala_header_cover);
                this.f14329h = a().findViewById(R.id.ala_enter_effect_img_layout);
                this.f14330i = (TextView) a().findViewById(R.id.ala_enter_effect_description);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = context;
        this.n = TbadkCoreApplication.getInst().getSkinType();
    }

    public final void f0(ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewHolder) == null) || viewHolder == null) {
            return;
        }
        SkinManager.setBackgroundResource(viewHolder.a(), R.color.CAM_X0201);
        SkinManager.setViewTextColor(viewHolder.f14325d, R.color.CAM_X0109, 1, this.n);
        SkinManager.setViewTextColor(viewHolder.f14323b, R.color.CAM_X0105, 1, this.n);
        if (this.n == 1) {
            viewHolder.f14328g.setVisibility(0);
        } else {
            viewHolder.f14328g.setVisibility(8);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public ViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) ? new ViewHolder(LayoutInflater.from(this.m).inflate(R.layout.ala_enter_effect_item_layout, (ViewGroup) null)) : (ViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public View X(int i2, View view, ViewGroup viewGroup, AlaEnterEffectData alaEnterEffectData, ViewHolder viewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, alaEnterEffectData, viewHolder})) == null) {
            viewHolder.f14322a.M(alaEnterEffectData.thumbnail_url, 10, false);
            viewHolder.f14323b.setText(alaEnterEffectData.name);
            if (alaEnterEffectData.isUsing()) {
                SkinManager.setViewTextColor(viewHolder.f14324c, R.color.live_cp_other_b, 1, this.n);
                SkinManager.setBackgroundResource(viewHolder.f14324c, R.drawable.ala_enter_effect_use_bg, this.n);
                viewHolder.f14324c.setText(this.m.getString(R.string.ala_enter_effect_use));
                viewHolder.f14322a.setAlpha(1.0f);
            } else if (alaEnterEffectData.isOwn) {
                SkinManager.setViewTextColor(viewHolder.f14324c, R.color.CAM_X0302, 1, this.n);
                SkinManager.setBackgroundResource(viewHolder.f14324c, R.drawable.ala_enter_effect_own_bg, this.n);
                viewHolder.f14324c.setText(this.m.getString(R.string.ala_enter_effect_own));
                viewHolder.f14322a.setAlpha(1.0f);
            } else {
                SkinManager.setViewTextColor(viewHolder.f14324c, R.color.CAM_X0109, 1, this.n);
                SkinManager.setBackgroundResource(viewHolder.f14324c, R.drawable.ala_enter_effect_not_own_bg, this.n);
                viewHolder.f14324c.setText(this.m.getString(R.string.ala_enter_effect_not_own));
                viewHolder.f14322a.setAlpha(0.7f);
            }
            viewHolder.f14325d.setText(this.m.getResources().getString(R.string.ala_left_time, StringHelper.formatDayTime((alaEnterEffectData.end_time * 1000) - System.currentTimeMillis())));
            int i3 = alaEnterEffectData.downLoadStatus;
            if (i3 == 100) {
                viewHolder.f14326e.setVisibility(0);
                viewHolder.f14327f.setVisibility(8);
            } else if (i3 == 102) {
                viewHolder.f14326e.setVisibility(8);
                viewHolder.f14327f.setVisibility(0);
            } else {
                viewHolder.f14326e.setVisibility(8);
                viewHolder.f14327f.setVisibility(8);
            }
            viewHolder.f14329h.setBackgroundColor(Color.parseColor(alaEnterEffectData.color));
            SkinManager.setViewTextColor(viewHolder.f14330i, R.color.CAM_X0109, 1, this.n);
            if (2 == alaEnterEffectData.categoryType) {
                SkinManager.setViewTextColor(viewHolder.f14330i, R.color.CAM_X0305, 1, this.n);
                viewHolder.f14330i.setText(this.m.getString(R.string.ala_enter_effect_tdou_des, AlaStringHelper.formatLowercasekDou((float) alaEnterEffectData.price), alaEnterEffectData.time));
                Drawable moneyIcon = CurrencySwitchUtil.getMoneyIcon();
                int dimensionPixelSize = this.m.getResources().getDimensionPixelSize(R.dimen.ds24);
                moneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                viewHolder.f14330i.setCompoundDrawablePadding(this.m.getResources().getDimensionPixelSize(R.dimen.ds4));
                viewHolder.f14330i.setCompoundDrawables(moneyIcon, null, null, null);
            } else {
                viewHolder.f14330i.setText(alaEnterEffectData.obtain_way);
                viewHolder.f14330i.setCompoundDrawables(null, null, null, null);
            }
            f0(viewHolder);
            return viewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }
}
