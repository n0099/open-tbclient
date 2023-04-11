package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.BannerConfigResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.MyBalanceResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.SplitOrderConfigResult;
import java.util.Map;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.api.pay.params.PayFlowType;
/* loaded from: classes4.dex */
public interface f6b {
    void a(int[] iArr, IResult<BannerConfigResult> iResult);

    void b(@NonNull Activity activity, @NonNull PayFlowType payFlowType, @NonNull PayType payType, @NonNull ProductInfo productInfo, AppCustomExpand appCustomExpand, Map<String, String> map, IPayCallback<String> iPayCallback, String str, String str2, String str3);

    void c(IResult<MyBalanceResult> iResult);

    void d(int i, String str, long j, IResult<SplitOrderConfigResult> iResult);

    void e(Map<String, String> map, IResult<ProductListResult> iResult);
}
