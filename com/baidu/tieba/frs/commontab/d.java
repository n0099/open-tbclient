package com.baidu.tieba.frs.commontab;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.mvc.b.j;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
import tbclient.GeneralTabList.DataRes;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes2.dex */
public class d implements j {
    public boolean hasMore;
    public HashMap<String, MetaData> userMap = new HashMap<>();
    public ArrayList<h> threadList = new ArrayList<>();

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.hasMore = dataRes.has_more.intValue() == 1;
            if (!v.z(dataRes.user_list)) {
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
            if (!v.z(dataRes.general_list)) {
                for (ThreadInfo threadInfo : dataRes.general_list) {
                    if (threadInfo != null) {
                        bb bbVar = new bb();
                        bbVar.setUserMap(this.userMap);
                        bbVar.a(threadInfo);
                        bbVar.cj(3);
                        bbVar.wW();
                        if (bbVar.getType() == bb.aka || bbVar.getType() == bb.akf) {
                            this.threadList.add(bbVar);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void E(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }
}
