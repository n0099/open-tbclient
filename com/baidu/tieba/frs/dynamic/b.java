package com.baidu.tieba.frs.dynamic;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.w;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
import tbclient.StarTrends.DataRes;
import tbclient.StarTrends.StarTrendsResIdl;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes2.dex */
public class b implements com.baidu.tbadk.mvc.b.c {
    public static final Wire WIRE = new Wire(new Class[0]);
    public boolean hasMore;
    public ArrayList<h> threadList = new ArrayList<>();
    public HashMap<String, MetaData> userMap = new HashMap<>();
    public int dsU = 0;

    public StarTrendsResIdl B(byte[] bArr) {
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
            if (!w.z(dataRes.user_list)) {
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
            if (!w.z(dataRes.thread_list)) {
                for (ThreadInfo threadInfo : dataRes.thread_list) {
                    if (threadInfo != null) {
                        bb bbVar = new bb();
                        bbVar.setUserMap(this.userMap);
                        bbVar.a(threadInfo);
                        bbVar.ca(3);
                        bbVar.vS();
                        if (bbVar.getType() == bb.ahx || bbVar.getType() == bb.ahz || bbVar.getType() == bb.ahE || bbVar.getType() == bb.ahA || bbVar.getType() == bb.ahF || bbVar.getType() == bb.ahG) {
                            this.threadList.add(bbVar);
                        }
                    }
                }
            }
            this.hasMore = dataRes.has_more.intValue() == 1;
        }
    }

    public bb mC(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<h> it = this.threadList.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (next != null && (next instanceof bb) && TextUtils.equals(str, ((bb) next).getId())) {
                return (bb) next;
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Js() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean y(byte[] bArr) {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void u(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }
}
