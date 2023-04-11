package com.baidu.tieba;

import com.yy.mobile.framework.revenuesdk.IRevenue;
import com.yy.mobile.framework.revenuesdk.baseapi.log.IRLogDelegate;
import java.util.List;
import tv.athena.revenue.api.IMiddleRevenue;
import tv.athena.revenue.api.MiddleRevenueConfig;
/* loaded from: classes4.dex */
public interface e6b {
    void addLogDelegate(IRLogDelegate iRLogDelegate);

    void addRevenueConfig(MiddleRevenueConfig middleRevenueConfig);

    List<IRevenue> getAllRevenue();

    IMiddleRevenue getMiddleRevenue(int i, int i2);

    IRevenue getRevenue(int i, int i2);

    f6b getYYPayMiddleService(int i, int i2);

    void removeRevenueConfig(int i, int i2);

    void updateMiddleRevenueConfig(int i, int i2, Long l, String str);
}
