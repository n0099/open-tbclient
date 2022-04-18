package com.baidu.tieba.funad.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
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
import com.repackage.bl8;
import com.repackage.es6;
import com.repackage.gs6;
import com.repackage.is6;
import com.repackage.ms6;
/* loaded from: classes3.dex */
public class FunAdNativeViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public final Activity b;
    public final FunAbsAdView c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;

    /* loaded from: classes3.dex */
    public class a implements es6.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ bl8 b;
        public final /* synthetic */ FunAdNativeViewHolder c;

        public a(FunAdNativeViewHolder funAdNativeViewHolder, int i, bl8 bl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {funAdNativeViewHolder, Integer.valueOf(i), bl8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = funAdNativeViewHolder;
            this.a = i;
            this.b = bl8Var;
        }

        @Override // com.repackage.es6.i
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param(TiebaStatic.Params.RESOURCE_ID, this.c.h()).param("obj_type", this.c.g()).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_TO, str2).param(TiebaStatic.Params.OBJ_PARAM2, str3);
                if ("a006".equals(this.c.g())) {
                    param.param(TiebaStatic.Params.OBJ_PARAM3, this.a);
                    param.param("obj_param1", gs6.a);
                }
                ms6.a(param, this.b);
                ms6.D(0, FunAdRecordHttpMessage.CLICK_AD_RECORD, this.c.g(), this.b);
                TiebaStatic.log(param);
            }
        }

        @Override // com.repackage.es6.i
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // com.repackage.es6.i
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param(TiebaStatic.Params.RESOURCE_ID, this.c.h()).param("obj_type", this.c.g()).param("obj_locate", 1);
                if ("a006".equals(this.c.g())) {
                    param.param("obj_param1", gs6.a);
                }
                ms6.a(param, this.b);
                ms6.D(1, FunAdRecordHttpMessage.SHOW_AD_RECORD, this.c.g(), this.b);
                TiebaStatic.log(param);
            }
        }

        @Override // com.repackage.es6.i
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                this.c.j(str2);
                this.c.i(str3);
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW);
                statisticItem.param("obj_source", 6).param(TiebaStatic.Params.RESOURCE_ID, this.c.h()).param("obj_type", this.c.g()).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_TO, str2).param(TiebaStatic.Params.OBJ_PARAM2, str3);
                if ("a006".equals(this.c.g())) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, this.a);
                    statisticItem.param("obj_param1", gs6.a);
                }
                ms6.a(statisticItem, this.b);
                ms6.D(0, FunAdRecordHttpMessage.SHOW_AD_RECORD, this.c.g(), this.b);
                TiebaStatic.log(statisticItem);
            }
        }

        @Override // com.repackage.es6.i
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
        this.c = funAbsAdView;
        this.b = activity;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    public FunAbsAdView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : (FunAbsAdView) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "personalize".equals(this.h) ? "a002" : this.a == AdvertAppInfo.H ? "a006" : "a005" : (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "pb".equals(this.h) ? this.a == AdvertAppInfo.I ? "2" : "1" : "" : (String) invokeV.objValue;
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f = str;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.e = str;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) || this.c.getFeedBackView() == null) {
            return;
        }
        this.c.getFeedBackView().setOnClickListener(onClickListener);
        this.c.setFeedBackListener(onClickListener);
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.h = str;
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.g = str;
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.d = str;
        }
    }

    public void o(@NonNull bl8 bl8Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, bl8Var, i) == null) {
            Object d = bl8Var.d();
            if (d == null) {
                d = es6.j().k(this.b, this.d);
                bl8Var.l(d);
                if (!TextUtils.isEmpty(this.g) && d != null) {
                    FunAdHistoryData funAdHistoryData = new FunAdHistoryData();
                    StringBuilder sb = new StringBuilder();
                    FunNativeAd funNativeAd = (FunNativeAd) d;
                    sb.append(ms6.i(funNativeAd));
                    sb.append("_");
                    sb.append(funNativeAd.getTitle());
                    sb.append("_");
                    sb.append(funNativeAd.getDescription());
                    funAdHistoryData.setFunAdKey(sb.toString());
                    funAdHistoryData.setShowTime(System.currentTimeMillis() / 1000);
                    is6.f().a(this.g, funAdHistoryData);
                }
            }
            Object obj = d;
            if (obj == null) {
                this.c.d(8);
                if ("a006".equals(g())) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FRS_FLOOR_SHOW).param("obj_source", 6).param("obj_type", g()).param("obj_locate", 1).param(TiebaStatic.Params.OBJ_PARAM3, i).param("obj_param1", gs6.a));
                    return;
                }
                return;
            }
            if ("a006".equals(g())) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FRS_FLOOR_SHOW).param("obj_source", 6).param("obj_type", g()).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_PARAM3, i).param("obj_param1", gs6.a));
            }
            this.c.d(0);
            this.c.f(bl8Var, this.b);
            this.c.e(this.a);
            FunAbsAdView funAbsAdView = this.c;
            FunNativeAd funNativeAd2 = (FunNativeAd) obj;
            funAbsAdView.c(funNativeAd2);
            es6.j().z(this.b, obj, new a(this, i, bl8Var), funAbsAdView, this.c.getClickViews(), this.c.getCreativeViews(), this.c.getLogItem());
            if (!c(funNativeAd2) || funAbsAdView == null || funAbsAdView.getChildCount() <= 1) {
                return;
            }
            funAbsAdView.removeViewAt(funAbsAdView.getChildCount() - 1);
        }
    }
}
