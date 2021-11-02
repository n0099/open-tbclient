package com.baidu.tieba.funad.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.l3.j0.o;
import b.a.r0.y0.a;
import b.a.r0.z0.b;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
import com.baidu.tieba.funAd.strategy.FunAdHistoryData;
import com.baidu.tieba.funad.view.FunAbsAdView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.ChannelNativeAds;
import com.fun.ad.sdk.FunNativeAd;
/* loaded from: classes9.dex */
public class FunAdNativeViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final BdUniqueId f49199a;

    /* renamed from: b  reason: collision with root package name */
    public final Activity f49200b;

    /* renamed from: c  reason: collision with root package name */
    public final FunAbsAdView f49201c;

    /* renamed from: d  reason: collision with root package name */
    public String f49202d;

    /* renamed from: e  reason: collision with root package name */
    public String f49203e;

    /* renamed from: f  reason: collision with root package name */
    public String f49204f;
    public o funAdData;

    /* loaded from: classes9.dex */
    public class a implements a.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f49205a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f49206b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdNativeViewHolder f49207c;

        public a(FunAdNativeViewHolder funAdNativeViewHolder, o oVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {funAdNativeViewHolder, oVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49207c = funAdNativeViewHolder;
            this.f49205a = oVar;
            this.f49206b = i2;
        }

        @Override // b.a.r0.y0.a.i
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param(TiebaStatic.Params.RESOURCE_ID, this.f49207c.getStatisticResourceId()).param("obj_type", this.f49207c.getObjType()).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_TO, str2).param(TiebaStatic.Params.OBJ_PARAM2, str3);
                b.a(param, this.f49205a);
                b.D(0, FunAdRecordHttpMessage.CLICK_AD_RECORD, this.f49207c.getObjType(), this.f49205a);
                TiebaStatic.log(param);
            }
        }

        @Override // b.a.r0.y0.a.i
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // b.a.r0.y0.a.i
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param(TiebaStatic.Params.RESOURCE_ID, this.f49207c.getStatisticResourceId()).param("obj_type", this.f49207c.getObjType()).param("obj_locate", 1);
                b.a(param, this.f49205a);
                b.D(1, FunAdRecordHttpMessage.SHOW_AD_RECORD, this.f49207c.getObjType(), this.f49205a);
                TiebaStatic.log(param);
            }
        }

        @Override // b.a.r0.y0.a.i
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW);
                statisticItem.param("obj_source", 6).param(TiebaStatic.Params.RESOURCE_ID, this.f49207c.getStatisticResourceId()).param("obj_type", this.f49207c.getObjType()).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_TO, str2).param(TiebaStatic.Params.OBJ_PARAM2, str3);
                if ("a006".equals(this.f49207c.getObjType())) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, this.f49206b);
                }
                b.a(statisticItem, this.f49205a);
                b.D(0, FunAdRecordHttpMessage.SHOW_AD_RECORD, this.f49207c.getObjType(), this.f49205a);
                TiebaStatic.log(statisticItem);
            }
        }

        @Override // b.a.r0.y0.a.i
        public void onRewardedVideo(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunAdNativeViewHolder(@NonNull FunAbsAdView funAbsAdView, @NonNull Activity activity, @NonNull BdUniqueId bdUniqueId) {
        super(funAbsAdView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {funAbsAdView, activity, bdUniqueId};
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
        this.f49199a = bdUniqueId;
        this.f49201c = funAbsAdView;
        this.f49200b = activity;
    }

    public final boolean a(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, funNativeAd)) == null) {
            if (funNativeAd == null || funNativeAd.getChannelNativeAds() == null) {
                return false;
            }
            ChannelNativeAds channelNativeAds = funNativeAd.getChannelNativeAds();
            return (channelNativeAds.gdtNative == null && channelNativeAds.csjNative == null) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public FunAbsAdView getFunAdNativeView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f49201c : (FunAbsAdView) invokeV.objValue;
    }

    public String getObjType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "personalize".equals(this.f49204f) ? "a002" : this.f49199a == AdvertAppInfo.C4 ? "a006" : "a005" : (String) invokeV.objValue;
    }

    public String getStatisticResourceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "pb".equals(this.f49204f) ? this.f49199a == AdvertAppInfo.D4 ? "2" : "1" : "" : (String) invokeV.objValue;
    }

    public void setFeedBackListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) || this.f49201c.getFeedBackView() == null) {
            return;
        }
        this.f49201c.getFeedBackView().setOnClickListener(onClickListener);
        this.f49201c.setFeedBackListener(onClickListener);
    }

    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f49204f = str;
        }
    }

    public void setSceneKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f49203e = str;
        }
    }

    public void setSid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f49202d = str;
        }
    }

    public void showNativeAd(@NonNull o oVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, oVar, i2) == null) {
            this.funAdData = oVar;
            Object d2 = oVar.d();
            if (d2 == null) {
                d2 = b.a.r0.y0.a.i().j(this.f49200b, this.f49202d);
                oVar.l(d2);
                if (!TextUtils.isEmpty(this.f49203e) && d2 != null) {
                    FunAdHistoryData funAdHistoryData = new FunAdHistoryData();
                    StringBuilder sb = new StringBuilder();
                    FunNativeAd funNativeAd = (FunNativeAd) d2;
                    sb.append(b.i(funNativeAd));
                    sb.append("_");
                    sb.append(funNativeAd.getTitle());
                    sb.append("_");
                    sb.append(funNativeAd.getDescription());
                    funAdHistoryData.setFunAdKey(sb.toString());
                    funAdHistoryData.setShowTime(System.currentTimeMillis() / 1000);
                    b.a.r0.y0.e.a.f().a(this.f49203e, funAdHistoryData);
                }
            }
            Object obj = d2;
            if (obj == null) {
                this.f49201c.hideOrShowView(8);
                if ("a006".equals(getObjType())) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FRS_FLOOR_SHOW).param("obj_source", 6).param("obj_type", getObjType()).param("obj_locate", 1).param(TiebaStatic.Params.OBJ_PARAM3, i2));
                    return;
                }
                return;
            }
            if ("a006".equals(getObjType())) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FRS_FLOOR_SHOW).param("obj_source", 6).param("obj_type", getObjType()).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_PARAM3, i2));
            }
            this.f49201c.hideOrShowView(0);
            this.f49201c.inflateFunAd(oVar, this.f49200b);
            this.f49201c.hideShowByType(this.f49199a);
            FunNativeAd funNativeAd2 = (FunNativeAd) obj;
            FrameLayout gdtAdContainer = this.f49201c.getGdtAdContainer(funNativeAd2);
            b.a.r0.y0.a.i().x(this.f49200b, obj, new a(this, oVar, i2), gdtAdContainer, this.f49201c.getClickViews(), this.f49201c.getCreativeViews(), this.f49201c.getLogItem());
            if (!a(funNativeAd2) || gdtAdContainer == null || gdtAdContainer.getChildCount() <= 1) {
                return;
            }
            gdtAdContainer.removeViewAt(gdtAdContainer.getChildCount() - 1);
        }
    }
}
