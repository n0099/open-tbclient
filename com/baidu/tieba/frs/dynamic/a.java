package com.baidu.tieba.frs.dynamic;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bz;
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
/* loaded from: classes2.dex */
public class a implements c {
    public static final Wire WIRE = new Wire(new Class[0]);
    public boolean hasMore;
    public ArrayList<n> threadList = new ArrayList<>();
    public HashMap<String, MetaData> userMap = new HashMap<>();
    public int mErrorNo = 0;

    public StarTrendsResIdl ad(byte[] bArr) {
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
                        bz bzVar = new bz();
                        bzVar.setUserMap(this.userMap);
                        bzVar.a(threadInfo);
                        bzVar.box();
                        bzVar.bmZ();
                        if (bzVar.getType() == bz.eOa || bzVar.getType() == bz.eOx || bzVar.getType() == bz.eOD || bzVar.getType() == bz.eOy || bzVar.getType() == bz.eOH || bzVar.getType() == bz.eOI) {
                            this.threadList.add(bzVar);
                        }
                    }
                }
            }
            com.baidu.tbadk.a.a.a.bo(this.threadList);
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
