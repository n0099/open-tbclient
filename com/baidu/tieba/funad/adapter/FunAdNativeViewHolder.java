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
import d.a.q0.h3.h0.n;
import d.a.q0.v0.a;
import d.a.q0.w0.b;
/* loaded from: classes4.dex */
public class FunAdNativeViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final BdUniqueId f16310a;

    /* renamed from: b  reason: collision with root package name */
    public final Activity f16311b;

    /* renamed from: c  reason: collision with root package name */
    public final FunAbsAdView f16312c;

    /* renamed from: d  reason: collision with root package name */
    public String f16313d;

    /* renamed from: e  reason: collision with root package name */
    public String f16314e;

    /* renamed from: f  reason: collision with root package name */
    public String f16315f;

    /* loaded from: classes4.dex */
    public class a implements a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f16316a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f16317b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdNativeViewHolder f16318c;

        public a(FunAdNativeViewHolder funAdNativeViewHolder, n nVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {funAdNativeViewHolder, nVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16318c = funAdNativeViewHolder;
            this.f16316a = nVar;
            this.f16317b = i2;
        }

        @Override // d.a.q0.v0.a.h
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param("obj_type", this.f16318c.d()).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_TO, str2).param(TiebaStatic.Params.OBJ_PARAM2, str3);
                b.a(param, this.f16316a);
                b.A(0, FunAdRecordHttpMessage.CLICK_AD_RECORD, this.f16318c.d(), this.f16316a);
                TiebaStatic.log(param);
            }
        }

        @Override // d.a.q0.v0.a.h
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // d.a.q0.v0.a.h
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", this.f16318c.d()).param("obj_locate", 1);
                b.a(param, this.f16316a);
                b.A(1, FunAdRecordHttpMessage.SHOW_AD_RECORD, this.f16318c.d(), this.f16316a);
                TiebaStatic.log(param);
            }
        }

        @Override // d.a.q0.v0.a.h
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW);
                statisticItem.param("obj_source", 6).param("obj_type", this.f16318c.d()).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_TO, str2).param(TiebaStatic.Params.OBJ_PARAM2, str3);
                if ("a006".equals(this.f16318c.d())) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, this.f16317b);
                }
                b.a(statisticItem, this.f16316a);
                b.A(0, FunAdRecordHttpMessage.SHOW_AD_RECORD, this.f16318c.d(), this.f16316a);
                TiebaStatic.log(statisticItem);
            }
        }

        @Override // d.a.q0.v0.a.h
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
        this.f16310a = bdUniqueId;
        this.f16312c = funAbsAdView;
        this.f16311b = activity;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16312c : (FunAbsAdView) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "personalize".equals(this.f16315f) ? "a002" : this.f16310a == AdvertAppInfo.w4 ? "a006" : "a005" : (String) invokeV.objValue;
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) || this.f16312c.getFeedBackView() == null) {
            return;
        }
        this.f16312c.getFeedBackView().setOnClickListener(onClickListener);
        this.f16312c.setFeedBackListener(onClickListener);
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f16315f = str;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f16314e = str;
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f16313d = str;
        }
    }

    public void i(@NonNull n nVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, nVar, i2) == null) {
            Object d2 = nVar.d();
            if (d2 == null) {
                d2 = d.a.q0.v0.a.i().j(this.f16311b, this.f16313d);
                nVar.l(d2);
                if (!TextUtils.isEmpty(this.f16314e) && d2 != null) {
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
                    d.a.q0.v0.d.a.f().a(this.f16314e, funAdHistoryData);
                }
            }
            Object obj = d2;
            if (obj == null) {
                this.f16312c.d(8);
                if ("a006".equals(d())) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FRS_FLOOR_SHOW).param("obj_source", 6).param("obj_type", d()).param("obj_locate", 1).param(TiebaStatic.Params.OBJ_PARAM3, i2));
                    return;
                }
                return;
            }
            if ("a006".equals(d())) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FRS_FLOOR_SHOW).param("obj_source", 6).param("obj_type", d()).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_PARAM3, i2));
            }
            this.f16312c.d(0);
            this.f16312c.f(nVar, this.f16311b);
            this.f16312c.e(this.f16310a);
            FunAbsAdView funAbsAdView = this.f16312c;
            FunNativeAd funNativeAd2 = (FunNativeAd) obj;
            funAbsAdView.c(funNativeAd2);
            d.a.q0.v0.a.i().v(this.f16311b, obj, new a(this, nVar, i2), funAbsAdView, this.f16312c.getClickViews(), this.f16312c.getCreativeViews(), this.f16312c.getLogItem());
            if (!b(funNativeAd2) || funAbsAdView == null || funAbsAdView.getChildCount() <= 1) {
                return;
            }
            funAbsAdView.removeViewAt(funAbsAdView.getChildCount() - 1);
        }
    }
}
