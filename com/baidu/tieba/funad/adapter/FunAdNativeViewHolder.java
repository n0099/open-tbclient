package com.baidu.tieba.funad.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.j3.i0.o;
import c.a.r0.x0.a;
import c.a.r0.y0.b;
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
import com.fun.ad.sdk.ChannelNativeAds_6;
import com.fun.ad.sdk.FunNativeAd;
/* loaded from: classes7.dex */
public class FunAdNativeViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final BdUniqueId f51832a;

    /* renamed from: b  reason: collision with root package name */
    public final Activity f51833b;

    /* renamed from: c  reason: collision with root package name */
    public final FunAbsAdView f51834c;

    /* renamed from: d  reason: collision with root package name */
    public String f51835d;

    /* renamed from: e  reason: collision with root package name */
    public String f51836e;

    /* renamed from: f  reason: collision with root package name */
    public String f51837f;
    public o funAdData;

    /* loaded from: classes7.dex */
    public class a implements a.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f51838a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f51839b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdNativeViewHolder f51840c;

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
            this.f51840c = funAdNativeViewHolder;
            this.f51838a = oVar;
            this.f51839b = i2;
        }

        @Override // c.a.r0.x0.a.i
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param(TiebaStatic.Params.RESOURCE_ID, this.f51840c.getStatisticResourceId()).param("obj_type", this.f51840c.getObjType()).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_TO, str2).param(TiebaStatic.Params.OBJ_PARAM2, str3);
                b.a(param, this.f51838a);
                b.D(0, FunAdRecordHttpMessage.CLICK_AD_RECORD, this.f51840c.getObjType(), this.f51838a);
                TiebaStatic.log(param);
            }
        }

        @Override // c.a.r0.x0.a.i
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // c.a.r0.x0.a.i
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param(TiebaStatic.Params.RESOURCE_ID, this.f51840c.getStatisticResourceId()).param("obj_type", this.f51840c.getObjType()).param("obj_locate", 1);
                b.a(param, this.f51838a);
                b.D(1, FunAdRecordHttpMessage.SHOW_AD_RECORD, this.f51840c.getObjType(), this.f51838a);
                TiebaStatic.log(param);
            }
        }

        @Override // c.a.r0.x0.a.i
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW);
                statisticItem.param("obj_source", 6).param(TiebaStatic.Params.RESOURCE_ID, this.f51840c.getStatisticResourceId()).param("obj_type", this.f51840c.getObjType()).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_TO, str2).param(TiebaStatic.Params.OBJ_PARAM2, str3);
                if ("a006".equals(this.f51840c.getObjType())) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, this.f51839b);
                }
                b.a(statisticItem, this.f51838a);
                b.D(0, FunAdRecordHttpMessage.SHOW_AD_RECORD, this.f51840c.getObjType(), this.f51838a);
                TiebaStatic.log(statisticItem);
            }
        }

        @Override // c.a.r0.x0.a.i
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
        this.f51832a = bdUniqueId;
        this.f51834c = funAbsAdView;
        this.f51833b = activity;
    }

    public final boolean a(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, funNativeAd)) == null) {
            if (funNativeAd == null || funNativeAd.getChannelNativeAds_6() == null) {
                return false;
            }
            ChannelNativeAds_6 channelNativeAds_6 = funNativeAd.getChannelNativeAds_6();
            return (channelNativeAds_6.gdtNative == null && channelNativeAds_6.csjNative == null) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public FunAbsAdView getFunAdNativeView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f51834c : (FunAbsAdView) invokeV.objValue;
    }

    public String getObjType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "personalize".equals(this.f51837f) ? "a002" : this.f51832a == AdvertAppInfo.B4 ? "a006" : "a005" : (String) invokeV.objValue;
    }

    public String getStatisticResourceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "pb".equals(this.f51837f) ? this.f51832a == AdvertAppInfo.C4 ? "2" : "1" : "" : (String) invokeV.objValue;
    }

    public void setFeedBackListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) || this.f51834c.getFeedBackView() == null) {
            return;
        }
        this.f51834c.getFeedBackView().setOnClickListener(onClickListener);
        this.f51834c.setFeedBackListener(onClickListener);
    }

    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f51837f = str;
        }
    }

    public void setSceneKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f51836e = str;
        }
    }

    public void setSid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f51835d = str;
        }
    }

    public void showNativeAd(@NonNull o oVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, oVar, i2) == null) {
            this.funAdData = oVar;
            Object d2 = oVar.d();
            if (d2 == null) {
                d2 = c.a.r0.x0.a.i().j(this.f51833b, this.f51835d);
                oVar.l(d2);
                if (!TextUtils.isEmpty(this.f51836e) && d2 != null) {
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
                    c.a.r0.x0.d.a.f().a(this.f51836e, funAdHistoryData);
                }
            }
            Object obj = d2;
            if (obj == null) {
                this.f51834c.hideOrShowView(8);
                if ("a006".equals(getObjType())) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FRS_FLOOR_SHOW).param("obj_source", 6).param("obj_type", getObjType()).param("obj_locate", 1).param(TiebaStatic.Params.OBJ_PARAM3, i2));
                    return;
                }
                return;
            }
            if ("a006".equals(getObjType())) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FRS_FLOOR_SHOW).param("obj_source", 6).param("obj_type", getObjType()).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_PARAM3, i2));
            }
            this.f51834c.hideOrShowView(0);
            this.f51834c.inflateFunAd(oVar, this.f51833b);
            this.f51834c.hideShowByType(this.f51832a);
            FunNativeAd funNativeAd2 = (FunNativeAd) obj;
            FrameLayout gdtAdContainer = this.f51834c.getGdtAdContainer(funNativeAd2);
            c.a.r0.x0.a.i().x(this.f51833b, obj, new a(this, oVar, i2), gdtAdContainer, this.f51834c.getClickViews(), this.f51834c.getCreativeViews(), this.f51834c.getLogItem());
            if (!a(funNativeAd2) || gdtAdContainer == null || gdtAdContainer.getChildCount() <= 1) {
                return;
            }
            gdtAdContainer.removeViewAt(gdtAdContainer.getChildCount() - 1);
        }
    }
}
