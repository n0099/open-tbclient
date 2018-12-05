package com.baidu.tieba.frs.dynamic;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.v;
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
/* loaded from: classes6.dex */
public class a implements c {
    public static final Wire WIRE = new Wire(new Class[0]);
    public boolean hasMore;
    public ArrayList<h> threadList = new ArrayList<>();
    public HashMap<String, MetaData> userMap = new HashMap<>();
    public int dPc = 0;

    public StarTrendsResIdl J(byte[] bArr) {
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
            if (!v.I(dataRes.user_list)) {
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
            if (!v.I(dataRes.thread_list)) {
                for (ThreadInfo threadInfo : dataRes.thread_list) {
                    if (threadInfo != null) {
                        bb bbVar = new bb();
                        bbVar.setUserMap(this.userMap);
                        bbVar.a(threadInfo);
                        bbVar.setCurrentPage(3);
                        bbVar.Aq();
                        if (bbVar.getType() == bb.atg || bbVar.getType() == bb.ati || bbVar.getType() == bb.atn || bbVar.getType() == bb.atj || bbVar.getType() == bb.ato || bbVar.getType() == bb.atp) {
                            this.threadList.add(bbVar);
                        }
                    }
                }
            }
            this.hasMore = dataRes.has_more.intValue() == 1;
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] NX() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean F(byte[] bArr) {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void I(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }
}
