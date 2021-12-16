package com.baidu.tieba.funad.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.e1.a;
import c.a.s0.f1.b;
import c.a.s0.v3.j0.o;
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
/* loaded from: classes12.dex */
public class FunAdNativeViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;

    /* renamed from: b  reason: collision with root package name */
    public final Activity f45412b;

    /* renamed from: c  reason: collision with root package name */
    public final FunAbsAdView f45413c;

    /* renamed from: d  reason: collision with root package name */
    public String f45414d;

    /* renamed from: e  reason: collision with root package name */
    public String f45415e;

    /* renamed from: f  reason: collision with root package name */
    public String f45416f;
    public o funAdData;

    /* loaded from: classes12.dex */
    public class a implements a.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f45417b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdNativeViewHolder f45418c;

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
            this.f45418c = funAdNativeViewHolder;
            this.a = oVar;
            this.f45417b = i2;
        }

        @Override // c.a.s0.e1.a.i
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param(TiebaStatic.Params.RESOURCE_ID, this.f45418c.getStatisticResourceId()).param("obj_type", this.f45418c.getObjType()).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_TO, str2).param(TiebaStatic.Params.OBJ_PARAM2, str3);
                b.a(param, this.a);
                b.D(0, FunAdRecordHttpMessage.CLICK_AD_RECORD, this.f45418c.getObjType(), this.a);
                TiebaStatic.log(param);
            }
        }

        @Override // c.a.s0.e1.a.i
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // c.a.s0.e1.a.i
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param(TiebaStatic.Params.RESOURCE_ID, this.f45418c.getStatisticResourceId()).param("obj_type", this.f45418c.getObjType()).param("obj_locate", 1);
                b.a(param, this.a);
                b.D(1, FunAdRecordHttpMessage.SHOW_AD_RECORD, this.f45418c.getObjType(), this.a);
                TiebaStatic.log(param);
            }
        }

        @Override // c.a.s0.e1.a.i
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW);
                statisticItem.param("obj_source", 6).param(TiebaStatic.Params.RESOURCE_ID, this.f45418c.getStatisticResourceId()).param("obj_type", this.f45418c.getObjType()).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_TO, str2).param(TiebaStatic.Params.OBJ_PARAM2, str3);
                if ("a006".equals(this.f45418c.getObjType())) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, this.f45417b);
                }
                b.a(statisticItem, this.a);
                b.D(0, FunAdRecordHttpMessage.SHOW_AD_RECORD, this.f45418c.getObjType(), this.a);
                TiebaStatic.log(statisticItem);
            }
        }

        @Override // c.a.s0.e1.a.i
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
        this.a = bdUniqueId;
        this.f45413c = funAbsAdView;
        this.f45412b = activity;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f45413c : (FunAbsAdView) invokeV.objValue;
    }

    public String getObjType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "personalize".equals(this.f45416f) ? "a002" : this.a == AdvertAppInfo.J4 ? "a006" : "a005" : (String) invokeV.objValue;
    }

    public String getStatisticResourceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "pb".equals(this.f45416f) ? this.a == AdvertAppInfo.K4 ? "2" : "1" : "" : (String) invokeV.objValue;
    }

    public void setFeedBackListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) || this.f45413c.getFeedBackView() == null) {
            return;
        }
        this.f45413c.getFeedBackView().setOnClickListener(onClickListener);
        this.f45413c.setFeedBackListener(onClickListener);
    }

    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f45416f = str;
        }
    }

    public void setSceneKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f45415e = str;
        }
    }

    public void setSid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f45414d = str;
        }
    }

    public void showNativeAd(@NonNull o oVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, oVar, i2) == null) {
            this.funAdData = oVar;
            Object d2 = oVar.d();
            if (d2 == null) {
                d2 = c.a.s0.e1.a.i().j(this.f45412b, this.f45414d);
                oVar.l(d2);
                if (!TextUtils.isEmpty(this.f45415e) && d2 != null) {
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
                    c.a.s0.e1.e.a.f().a(this.f45415e, funAdHistoryData);
                }
            }
            Object obj = d2;
            if (obj == null) {
                this.f45413c.hideOrShowView(8);
                if ("a006".equals(getObjType())) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FRS_FLOOR_SHOW).param("obj_source", 6).param("obj_type", getObjType()).param("obj_locate", 1).param(TiebaStatic.Params.OBJ_PARAM3, i2));
                    return;
                }
                return;
            }
            if ("a006".equals(getObjType())) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FRS_FLOOR_SHOW).param("obj_source", 6).param("obj_type", getObjType()).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_PARAM3, i2));
            }
            this.f45413c.hideOrShowView(0);
            this.f45413c.inflateFunAd(oVar, this.f45412b);
            this.f45413c.hideShowByType(this.a);
            FunNativeAd funNativeAd2 = (FunNativeAd) obj;
            FrameLayout gdtAdContainer = this.f45413c.getGdtAdContainer(funNativeAd2);
            c.a.s0.e1.a.i().x(this.f45412b, obj, new a(this, oVar, i2), gdtAdContainer, this.f45413c.getClickViews(), this.f45413c.getCreativeViews(), this.f45413c.getLogItem());
            if (!a(funNativeAd2) || gdtAdContainer == null || gdtAdContainer.getChildCount() <= 1) {
                return;
            }
            gdtAdContainer.removeViewAt(gdtAdContainer.getChildCount() - 1);
        }
    }
}
