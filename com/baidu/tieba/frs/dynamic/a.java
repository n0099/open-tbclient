package com.baidu.tieba.frs.dynamic;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.mvc.b.c;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
import tbclient.StarTrends.DataRes;
import tbclient.StarTrends.StarTrendsResIdl;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes16.dex */
public class a implements c {
    public static final Wire WIRE = new Wire(new Class[0]);
    public boolean hasMore;
    public ArrayList<q> threadList = new ArrayList<>();
    public HashMap<String, MetaData> userMap = new HashMap<>();
    public int mErrorNo = 0;

    public StarTrendsResIdl ae(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            StarTrendsResIdl starTrendsResIdl = (StarTrendsResIdl) WIRE.parseFrom(bArr, StarTrendsResIdl.class);
            if (starTrendsResIdl != null && starTrendsResIdl.data != null) {
                a(starTrendsResIdl.data);
                return starTrendsResIdl;
            }
            return starTrendsResIdl;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    private void a(DataRes dataRes) {
        if (dataRes != null) {
            if (!x.isEmpty(dataRes.user_list)) {
                for (User user : dataRes.user_list) {
                    if (user != null) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(user);
                        String userId = metaData.getUserId();
                        if (userId != null && !"0".equals(userId)) {
                            this.userMap.put(userId, metaData);
                        }
                    }
                }
            }
            if (!x.isEmpty(dataRes.thread_list)) {
                for (ThreadInfo threadInfo : dataRes.thread_list) {
                    if (threadInfo != null) {
                        bv bvVar = new bv();
                        bvVar.setUserMap(this.userMap);
                        bvVar.a(threadInfo);
                        bvVar.aXj();
                        if (bvVar.getType() == bv.dRx || bvVar.getType() == bv.dRR || bvVar.getType() == bv.dRW || bvVar.getType() == bv.dRS || bvVar.getType() == bv.dSa || bvVar.getType() == bv.dSb) {
                            this.threadList.add(bvVar);
                        }
                    }
                }
            }
            com.baidu.tbadk.a.a.a.aG(this.threadList);
            this.hasMore = dataRes.has_more.intValue() == 1;
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] toCacheByteArray() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean initByByteArray(byte[] bArr) {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void initByJson(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void initByProtobuf(Message message) {
    }
}
