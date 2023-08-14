package com.baidu.tieba.funad.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.dv7;
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
import com.baidu.tieba.funAd.strategy.FunAdHistoryData;
import com.baidu.tieba.funad.view.FunAbsAdView;
import com.baidu.tieba.fv7;
import com.baidu.tieba.hv7;
import com.baidu.tieba.lv7;
import com.baidu.tieba.pba;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunNativeAd2;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static class a implements dv7.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<FunAdNativeViewHolder> a;
        public final int b;
        public final pba c;

        @Override // com.baidu.tieba.dv7.h
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.dv7.h
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }

        public a(FunAdNativeViewHolder funAdNativeViewHolder, int i, pba pbaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {funAdNativeViewHolder, Integer.valueOf(i), pbaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(funAdNativeViewHolder);
            this.b = i;
            this.c = pbaVar;
        }

        @Override // com.baidu.tieba.dv7.h
        public void onAdClicked(String str, String str2, String str3) {
            FunAdNativeViewHolder funAdNativeViewHolder;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3) != null) || (funAdNativeViewHolder = this.a.get()) == null) {
                return;
            }
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param(TiebaStatic.Params.AD_BEAR_PLACE, funAdNativeViewHolder.g()).param("obj_type", funAdNativeViewHolder.f()).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_TO, str2).param(TiebaStatic.Params.OBJ_PARAM2, str3);
            if ("a006".equals(funAdNativeViewHolder.f())) {
                param.param(TiebaStatic.Params.OBJ_PARAM3, this.b);
                param.param("obj_param1", fv7.a);
            }
            lv7.a(param, this.c);
            lv7.N(0, FunAdRecordHttpMessage.CLICK_AD_RECORD, funAdNativeViewHolder.f(), this.c);
            TiebaStatic.log(param);
        }

        @Override // com.baidu.tieba.dv7.h
        public void onAdShow(String str, String str2, String str3) {
            FunAdNativeViewHolder funAdNativeViewHolder;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLLL(1048580, this, str, str2, str3) != null) || (funAdNativeViewHolder = this.a.get()) == null) {
                return;
            }
            funAdNativeViewHolder.i(str2);
            funAdNativeViewHolder.h(str3);
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW);
            statisticItem.param("obj_source", 6).param(TiebaStatic.Params.AD_BEAR_PLACE, funAdNativeViewHolder.g()).param("obj_type", funAdNativeViewHolder.f()).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_TO, str2).param(TiebaStatic.Params.OBJ_PARAM2, str3);
            if ("a006".equals(funAdNativeViewHolder.f())) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, this.b);
                statisticItem.param("obj_param1", fv7.a);
            }
            lv7.a(statisticItem, this.c);
            lv7.N(0, FunAdRecordHttpMessage.SHOW_AD_RECORD, funAdNativeViewHolder.f(), this.c);
            TiebaStatic.log(statisticItem);
        }

        @Override // com.baidu.tieba.dv7.h
        public void onAdError(String str) {
            FunAdNativeViewHolder funAdNativeViewHolder;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048579, this, str) != null) || (funAdNativeViewHolder = this.a.get()) == null) {
                return;
            }
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param(TiebaStatic.Params.AD_BEAR_PLACE, funAdNativeViewHolder.g()).param("obj_type", funAdNativeViewHolder.f()).param("obj_locate", 1);
            if ("a006".equals(funAdNativeViewHolder.f())) {
                param.param("obj_param1", fv7.a);
            }
            lv7.a(param, this.c);
            lv7.N(1, FunAdRecordHttpMessage.SHOW_AD_RECORD, funAdNativeViewHolder.f(), this.c);
            TiebaStatic.log(param);
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

    public final boolean b(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, funNativeAd2)) == null) {
            if (lv7.f(funNativeAd2) == null && lv7.e(funNativeAd2) == null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f = str;
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.e = str;
        }
    }

    public void j(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) && this.c.getFeedBackView() != null) {
            this.c.getFeedBackView().setOnClickListener(onClickListener);
            this.c.setFeedBackListener(onClickListener);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.h = str;
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.g = str;
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.d = str;
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public FunAbsAdView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (FunAbsAdView) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if ("personalize".equals(this.h)) {
                return "a002";
            }
            if (this.a == AdvertAppInfo.I) {
                return "a006";
            }
            return "a005";
        }
        return (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if ("pb".equals(this.h)) {
                if (this.a == AdvertAppInfo.J) {
                    return "2";
                }
                return "1";
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void n(@NonNull pba pbaVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, pbaVar, i) == null) {
            Object e = pbaVar.e();
            if (e == null) {
                e = dv7.m().n(this.b, this.d);
                pbaVar.o(e);
                if (!TextUtils.isEmpty(this.g) && e != null) {
                    FunAdHistoryData funAdHistoryData = new FunAdHistoryData();
                    FunNativeAd2 funNativeAd2 = (FunNativeAd2) e;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(lv7.s(funNativeAd2));
                    stringBuffer.append("_");
                    stringBuffer.append(lv7.l(funNativeAd2));
                    stringBuffer.append("_");
                    stringBuffer.append(lv7.i(funNativeAd2));
                    funAdHistoryData.setFunAdKey(stringBuffer.toString());
                    funAdHistoryData.setShowTime(System.currentTimeMillis() / 1000);
                    hv7.f().a(this.g, funAdHistoryData);
                }
            }
            Object obj = e;
            if (obj == null) {
                this.c.d(8);
                if ("a006".equals(f())) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FRS_FLOOR_SHOW).param("obj_source", 6).param("obj_type", f()).param("obj_locate", 1).param(TiebaStatic.Params.OBJ_PARAM3, i).param("obj_param1", fv7.a));
                    return;
                }
                return;
            }
            if ("a006".equals(f())) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FRS_FLOOR_SHOW).param("obj_source", 6).param("obj_type", f()).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_PARAM3, i).param("obj_param1", fv7.a));
            }
            this.c.d(0);
            this.c.f(pbaVar, this.b);
            this.c.e(this.a);
            FunNativeAd2 funNativeAd22 = (FunNativeAd2) obj;
            ViewGroup c = this.c.c(funNativeAd22);
            dv7.m().E(this.b, obj, new a(this, i, pbaVar), c, this.c.getClickViews(), this.c.getCreativeViews(), this.c.getLogItem(), this.d);
            if (b(funNativeAd22) && c != null && (c.getParent() instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) c.getParent();
                if (viewGroup.getChildCount() > 1) {
                    int childCount = viewGroup.getChildCount() - 1;
                    if (viewGroup.getChildAt(childCount) instanceof ImageView) {
                        viewGroup.removeViewAt(childCount);
                    }
                }
            }
        }
    }
}
