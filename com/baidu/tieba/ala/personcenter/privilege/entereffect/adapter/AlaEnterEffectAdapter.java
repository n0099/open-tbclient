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
import c.a.d.n.e.a;
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
/* loaded from: classes12.dex */
public class AlaEnterEffectAdapter extends a<AlaEnterEffectData, ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context m;
    public int n;

    /* loaded from: classes12.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView mDescriptionView;
        public ImageView mDownloadImage;
        public TbImageView mEffectImage;
        public TextView mEffectNameView;
        public View mHeaderCover;
        public View mHeaderLayout;
        public ProgressBar mLoadingView;
        public TextView mTimeLimitView;
        public TextView mUseStatusView;

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
                TbImageView tbImageView = (TbImageView) getView().findViewById(R.id.ala_enter_effect_img);
                this.mEffectImage = tbImageView;
                tbImageView.setAutoChangeStyle(false);
                this.mEffectNameView = (TextView) getView().findViewById(R.id.ala_enter_effect_name);
                this.mUseStatusView = (TextView) getView().findViewById(R.id.ala_enter_effect_status);
                this.mTimeLimitView = (TextView) getView().findViewById(R.id.ala_enter_effect_time_limit);
                this.mDownloadImage = (ImageView) getView().findViewById(R.id.ala_enter_effect_download_img);
                this.mLoadingView = (ProgressBar) getView().findViewById(R.id.ala_enter_effect_loading);
                this.mHeaderCover = getView().findViewById(R.id.ala_header_cover);
                this.mHeaderLayout = getView().findViewById(R.id.ala_enter_effect_img_layout);
                this.mDescriptionView = (TextView) getView().findViewById(R.id.ala_enter_effect_description);
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

    public final void Z(ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewHolder) == null) || viewHolder == null) {
            return;
        }
        SkinManager.setBackgroundResource(viewHolder.getView(), R.color.CAM_X0201);
        SkinManager.setViewTextColor(viewHolder.mTimeLimitView, R.color.CAM_X0109, 1, this.n);
        SkinManager.setViewTextColor(viewHolder.mEffectNameView, R.color.CAM_X0105, 1, this.n);
        if (this.n == 1) {
            viewHolder.mHeaderCover.setVisibility(0);
        } else {
            viewHolder.mHeaderCover.setVisibility(8);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: a0 */
    public ViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) ? new ViewHolder(LayoutInflater.from(this.m).inflate(R.layout.ala_enter_effect_item_layout, (ViewGroup) null)) : (ViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: b0 */
    public View S(int i2, View view, ViewGroup viewGroup, AlaEnterEffectData alaEnterEffectData, ViewHolder viewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, alaEnterEffectData, viewHolder})) == null) {
            viewHolder.mEffectImage.startLoad(alaEnterEffectData.thumbnail_url, 10, false);
            viewHolder.mEffectNameView.setText(alaEnterEffectData.name);
            if (alaEnterEffectData.isUsing()) {
                SkinManager.setViewTextColor(viewHolder.mUseStatusView, R.color.live_cp_other_b, 1, this.n);
                SkinManager.setBackgroundResource(viewHolder.mUseStatusView, R.drawable.ala_enter_effect_use_bg, this.n);
                viewHolder.mUseStatusView.setText(this.m.getString(R.string.ala_enter_effect_use));
                viewHolder.mEffectImage.setAlpha(1.0f);
            } else if (alaEnterEffectData.isOwn) {
                SkinManager.setViewTextColor(viewHolder.mUseStatusView, R.color.CAM_X0302, 1, this.n);
                SkinManager.setBackgroundResource(viewHolder.mUseStatusView, R.drawable.ala_enter_effect_own_bg, this.n);
                viewHolder.mUseStatusView.setText(this.m.getString(R.string.ala_enter_effect_own));
                viewHolder.mEffectImage.setAlpha(1.0f);
            } else {
                SkinManager.setViewTextColor(viewHolder.mUseStatusView, R.color.CAM_X0109, 1, this.n);
                SkinManager.setBackgroundResource(viewHolder.mUseStatusView, R.drawable.ala_enter_effect_not_own_bg, this.n);
                viewHolder.mUseStatusView.setText(this.m.getString(R.string.ala_enter_effect_not_own));
                viewHolder.mEffectImage.setAlpha(0.7f);
            }
            viewHolder.mTimeLimitView.setText(this.m.getResources().getString(R.string.ala_left_time, StringHelper.formatDayTime((alaEnterEffectData.end_time * 1000) - System.currentTimeMillis())));
            int i3 = alaEnterEffectData.downLoadStatus;
            if (i3 == 100) {
                viewHolder.mDownloadImage.setVisibility(0);
                viewHolder.mLoadingView.setVisibility(8);
            } else if (i3 == 102) {
                viewHolder.mDownloadImage.setVisibility(8);
                viewHolder.mLoadingView.setVisibility(0);
            } else {
                viewHolder.mDownloadImage.setVisibility(8);
                viewHolder.mLoadingView.setVisibility(8);
            }
            viewHolder.mHeaderLayout.setBackgroundColor(Color.parseColor(alaEnterEffectData.color));
            SkinManager.setViewTextColor(viewHolder.mDescriptionView, R.color.CAM_X0109, 1, this.n);
            if (2 == alaEnterEffectData.categoryType) {
                SkinManager.setViewTextColor(viewHolder.mDescriptionView, R.color.CAM_X0305, 1, this.n);
                viewHolder.mDescriptionView.setText(this.m.getString(R.string.ala_enter_effect_tdou_des, AlaStringHelper.formatLowercasekDou((float) alaEnterEffectData.price), alaEnterEffectData.time));
                Drawable moneyIcon = CurrencySwitchUtil.getMoneyIcon();
                int dimensionPixelSize = this.m.getResources().getDimensionPixelSize(R.dimen.ds24);
                moneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                viewHolder.mDescriptionView.setCompoundDrawablePadding(this.m.getResources().getDimensionPixelSize(R.dimen.ds4));
                viewHolder.mDescriptionView.setCompoundDrawables(moneyIcon, null, null, null);
            } else {
                viewHolder.mDescriptionView.setText(alaEnterEffectData.obtain_way);
                viewHolder.mDescriptionView.setCompoundDrawables(null, null, null, null);
            }
            Z(viewHolder);
            return viewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
