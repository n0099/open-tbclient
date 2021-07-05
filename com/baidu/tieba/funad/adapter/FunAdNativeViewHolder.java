package com.baidu.tieba.funad.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
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
import d.a.s0.h3.h0.n;
import d.a.s0.v0.a;
import d.a.s0.w0.b;
/* loaded from: classes5.dex */
public class FunAdNativeViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final BdUniqueId f16216a;

    /* renamed from: b  reason: collision with root package name */
    public final Activity f16217b;

    /* renamed from: c  reason: collision with root package name */
    public final FunAbsAdView f16218c;

    /* renamed from: d  reason: collision with root package name */
    public String f16219d;

    /* renamed from: e  reason: collision with root package name */
    public String f16220e;

    /* renamed from: f  reason: collision with root package name */
    public String f16221f;

    /* loaded from: classes5.dex */
    public class a implements a.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f16222a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunAdNativeViewHolder f16223b;

        public a(FunAdNativeViewHolder funAdNativeViewHolder, n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {funAdNativeViewHolder, nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16223b = funAdNativeViewHolder;
            this.f16222a = nVar;
        }

        @Override // d.a.s0.v0.a.g
        public void onAdClicked(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param("obj_type", this.f16223b.d()).param("obj_locate", 0);
                b.a(param, this.f16222a);
                b.r(0, FunAdRecordHttpMessage.CLICK_AD_RECORD, this.f16223b.d(), this.f16222a);
                TiebaStatic.log(param);
            }
        }

        @Override // d.a.s0.v0.a.g
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // d.a.s0.v0.a.g
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", this.f16223b.d()).param("obj_locate", 1);
                b.a(param, this.f16222a);
                b.r(1, FunAdRecordHttpMessage.SHOW_AD_RECORD, this.f16223b.d(), this.f16222a);
                TiebaStatic.log(param);
            }
        }

        @Override // d.a.s0.v0.a.g
        public void onAdShow(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", this.f16223b.d()).param("obj_locate", 0);
                b.a(param, this.f16222a);
                b.r(0, FunAdRecordHttpMessage.SHOW_AD_RECORD, this.f16223b.d(), this.f16222a);
                TiebaStatic.log(param);
            }
        }

        @Override // d.a.s0.v0.a.g
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
        this.f16216a = bdUniqueId;
        this.f16218c = funAbsAdView;
        this.f16217b = activity;
    }

    public final boolean b(FunNativeAd funNativeAd) {
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

    public FunAbsAdView c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16218c : (FunAbsAdView) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "personalize".equals(this.f16221f) ? "a002" : this.f16216a == AdvertAppInfo.q4 ? "a006" : "a005" : (String) invokeV.objValue;
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) || this.f16218c.getFeedBackView() == null) {
            return;
        }
        this.f16218c.getFeedBackView().setOnClickListener(onClickListener);
        this.f16218c.setFeedBackListener(onClickListener);
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f16221f = str;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f16220e = str;
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f16219d = str;
        }
    }

    public void i(@NonNull n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, nVar) == null) {
            Object d2 = nVar.d();
            if (d2 == null) {
                d2 = d.a.s0.v0.a.h().i(this.f16217b, this.f16219d);
                nVar.l(d2);
                if (!TextUtils.isEmpty(this.f16220e) && d2 != null) {
                    FunAdHistoryData funAdHistoryData = new FunAdHistoryData();
                    StringBuilder sb = new StringBuilder();
                    FunNativeAd funNativeAd = (FunNativeAd) d2;
                    sb.append(b.e(funNativeAd));
                    sb.append("_");
                    sb.append(funNativeAd.getTitle());
                    sb.append("_");
                    sb.append(funNativeAd.getDescription());
                    funAdHistoryData.setFunAdKey(sb.toString());
                    funAdHistoryData.setShowTime(System.currentTimeMillis() / 1000);
                    d.a.s0.v0.d.a.f().a(this.f16220e, funAdHistoryData);
                }
            }
            Object obj = d2;
            if (obj == null) {
                this.f16218c.d(8);
                return;
            }
            this.f16218c.d(0);
            this.f16218c.f(nVar, this.f16217b);
            this.f16218c.e(this.f16216a);
            FunAbsAdView funAbsAdView = this.f16218c;
            FunNativeAd funNativeAd2 = (FunNativeAd) obj;
            funAbsAdView.c(funNativeAd2);
            d.a.s0.v0.a.h().p(this.f16217b, obj, new a(this, nVar), funAbsAdView, this.f16218c.getClickViews(), this.f16218c.getCreativeViews(), this.f16218c.getLogItem());
            if (!b(funNativeAd2) || funAbsAdView == null || funAbsAdView.getChildCount() <= 1) {
                return;
            }
            funAbsAdView.removeViewAt(funAbsAdView.getChildCount() - 1);
        }
    }
}
