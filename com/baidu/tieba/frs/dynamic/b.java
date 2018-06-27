package com.baidu.tieba.frs.dynamic;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bc;
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
    public int dqh = 0;

    public StarTrendsResIdl D(byte[] bArr) {
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
            if (!w.A(dataRes.user_list)) {
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
            if (!w.A(dataRes.thread_list)) {
                for (ThreadInfo threadInfo : dataRes.thread_list) {
                    if (threadInfo != null) {
                        bc bcVar = new bc();
                        bcVar.setUserMap(this.userMap);
                        bcVar.a(threadInfo);
                        bcVar.bY(3);
                        bcVar.wd();
                        if (bcVar.getType() == bc.aib || bcVar.getType() == bc.aid || bcVar.getType() == bc.aii || bcVar.getType() == bc.aie || bcVar.getType() == bc.aij || bcVar.getType() == bc.aik) {
                            this.threadList.add(bcVar);
                        }
                    }
                }
            }
            this.hasMore = dataRes.has_more.intValue() == 1;
        }
    }

    public bc mD(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<h> it = this.threadList.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (next != null && (next instanceof bc) && TextUtils.equals(str, ((bc) next).getId())) {
                return (bc) next;
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Jx() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean A(byte[] bArr) {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void v(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }
}
