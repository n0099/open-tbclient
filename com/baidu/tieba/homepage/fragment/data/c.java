package com.baidu.tieba.homepage.fragment.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.m;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.util.i;
import java.util.HashMap;
import tbclient.HomePage.DataReq;
import tbclient.HomePage.HomePageReqIdl;
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.mvc.b.e, h {
    private String key;

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> pe() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object aa(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            int K = k.K(TbadkCoreApplication.m411getInst().getApp());
            int L = k.L(TbadkCoreApplication.m411getInst().getApp());
            builder.src_w = Integer.valueOf(K);
            builder.src_h = Integer.valueOf(L);
            builder.src_dip = Double.valueOf(TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density);
            builder.q_type = Integer.valueOf(m.rh().getViewImageQuality());
            if (z) {
                i.a(builder, true);
            }
            HomePageReqIdl.Builder builder2 = new HomePageReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            BdLog.e("data convert error");
            return null;
        }
    }

    public void setCacheKey(String str) {
        this.key = str;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return this.key;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public String Dr() {
        return "HomePageCache";
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean Ds() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return false;
    }
}
