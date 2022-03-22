package com.baidu.tieba.funad.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a4.k0.n;
import c.a.p0.g1.b;
import c.a.p0.g1.d;
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
/* loaded from: classes5.dex */
public class FunAdNativeViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;

    /* renamed from: b  reason: collision with root package name */
    public final Activity f33064b;

    /* renamed from: c  reason: collision with root package name */
    public final FunAbsAdView f33065c;

    /* renamed from: d  reason: collision with root package name */
    public String f33066d;

    /* renamed from: e  reason: collision with root package name */
    public String f33067e;

    /* renamed from: f  reason: collision with root package name */
    public String f33068f;

    /* renamed from: g  reason: collision with root package name */
    public String f33069g;

    /* renamed from: h  reason: collision with root package name */
    public String f33070h;

    /* loaded from: classes5.dex */
    public class a implements b.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ n f33071b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdNativeViewHolder f33072c;

        public a(FunAdNativeViewHolder funAdNativeViewHolder, int i, n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {funAdNativeViewHolder, Integer.valueOf(i), nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33072c = funAdNativeViewHolder;
            this.a = i;
            this.f33071b = nVar;
        }

        @Override // c.a.p0.g1.b.i
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param(TiebaStatic.Params.RESOURCE_ID, this.f33072c.h()).param("obj_type", this.f33072c.g()).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_TO, str2).param(TiebaStatic.Params.OBJ_PARAM2, str3);
                if ("a006".equals(this.f33072c.g())) {
                    param.param(TiebaStatic.Params.OBJ_PARAM3, this.a);
                    param.param("obj_param1", d.a);
                }
                c.a.p0.h1.b.a(param, this.f33071b);
                c.a.p0.h1.b.D(0, FunAdRecordHttpMessage.CLICK_AD_RECORD, this.f33072c.g(), this.f33071b);
                TiebaStatic.log(param);
            }
        }

        @Override // c.a.p0.g1.b.i
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // c.a.p0.g1.b.i
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param(TiebaStatic.Params.RESOURCE_ID, this.f33072c.h()).param("obj_type", this.f33072c.g()).param("obj_locate", 1);
                if ("a006".equals(this.f33072c.g())) {
                    param.param("obj_param1", d.a);
                }
                c.a.p0.h1.b.a(param, this.f33071b);
                c.a.p0.h1.b.D(1, FunAdRecordHttpMessage.SHOW_AD_RECORD, this.f33072c.g(), this.f33071b);
                TiebaStatic.log(param);
            }
        }

        @Override // c.a.p0.g1.b.i
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                this.f33072c.j(str2);
                this.f33072c.i(str3);
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW);
                statisticItem.param("obj_source", 6).param(TiebaStatic.Params.RESOURCE_ID, this.f33072c.h()).param("obj_type", this.f33072c.g()).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_TO, str2).param(TiebaStatic.Params.OBJ_PARAM2, str3);
                if ("a006".equals(this.f33072c.g())) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, this.a);
                    statisticItem.param("obj_param1", d.a);
                }
                c.a.p0.h1.b.a(statisticItem, this.f33071b);
                c.a.p0.h1.b.D(0, FunAdRecordHttpMessage.SHOW_AD_RECORD, this.f33072c.g(), this.f33071b);
                TiebaStatic.log(statisticItem);
            }
        }

        @Override // c.a.p0.g1.b.i
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bdUniqueId;
        this.f33065c = funAbsAdView;
        this.f33064b = activity;
    }

    public final boolean c(FunNativeAd funNativeAd) {
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

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33068f : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33067e : (String) invokeV.objValue;
    }

    public FunAbsAdView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33065c : (FunAbsAdView) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "personalize".equals(this.f33070h) ? "a002" : this.a == AdvertAppInfo.H ? "a006" : "a005" : (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "pb".equals(this.f33070h) ? this.a == AdvertAppInfo.I ? "2" : "1" : "" : (String) invokeV.objValue;
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f33068f = str;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f33067e = str;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) || this.f33065c.getFeedBackView() == null) {
            return;
        }
        this.f33065c.getFeedBackView().setOnClickListener(onClickListener);
        this.f33065c.setFeedBackListener(onClickListener);
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f33070h = str;
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f33069g = str;
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f33066d = str;
        }
    }

    public void o(@NonNull n nVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, nVar, i) == null) {
            Object d2 = nVar.d();
            if (d2 == null) {
                d2 = b.j().k(this.f33064b, this.f33066d);
                nVar.l(d2);
                if (!TextUtils.isEmpty(this.f33069g) && d2 != null) {
                    FunAdHistoryData funAdHistoryData = new FunAdHistoryData();
                    StringBuilder sb = new StringBuilder();
                    FunNativeAd funNativeAd = (FunNativeAd) d2;
                    sb.append(c.a.p0.h1.b.i(funNativeAd));
                    sb.append("_");
                    sb.append(funNativeAd.getTitle());
                    sb.append("_");
                    sb.append(funNativeAd.getDescription());
                    funAdHistoryData.setFunAdKey(sb.toString());
                    funAdHistoryData.setShowTime(System.currentTimeMillis() / 1000);
                    c.a.p0.g1.f.a.f().a(this.f33069g, funAdHistoryData);
                }
            }
            Object obj = d2;
            if (obj == null) {
                this.f33065c.d(8);
                if ("a006".equals(g())) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FRS_FLOOR_SHOW).param("obj_source", 6).param("obj_type", g()).param("obj_locate", 1).param(TiebaStatic.Params.OBJ_PARAM3, i).param("obj_param1", d.a));
                    return;
                }
                return;
            }
            if ("a006".equals(g())) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FRS_FLOOR_SHOW).param("obj_source", 6).param("obj_type", g()).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_PARAM3, i).param("obj_param1", d.a));
            }
            this.f33065c.d(0);
            this.f33065c.f(nVar, this.f33064b);
            this.f33065c.e(this.a);
            FunAbsAdView funAbsAdView = this.f33065c;
            FunNativeAd funNativeAd2 = (FunNativeAd) obj;
            funAbsAdView.c(funNativeAd2);
            b.j().z(this.f33064b, obj, new a(this, i, nVar), funAbsAdView, this.f33065c.getClickViews(), this.f33065c.getCreativeViews(), this.f33065c.getLogItem());
            if (!c(funNativeAd2) || funAbsAdView == null || funAbsAdView.getChildCount() <= 1) {
                return;
            }
            funAbsAdView.removeViewAt(funAbsAdView.getChildCount() - 1);
        }
    }
}
