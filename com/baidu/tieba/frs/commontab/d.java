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
/* loaded from: classes6.dex */
public class d implements j {
    public boolean hasMore;
    public HashMap<String, MetaData> userMap = new HashMap<>();
    public ArrayList<h> threadList = new ArrayList<>();

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.hasMore = dataRes.has_more.intValue() == 1;
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
            if (!v.I(dataRes.general_list)) {
                for (ThreadInfo threadInfo : dataRes.general_list) {
                    if (threadInfo != null) {
                        bb bbVar = new bb();
                        bbVar.setUserMap(this.userMap);
                        bbVar.a(threadInfo);
                        bbVar.setCurrentPage(3);
                        bbVar.AD();
                        if (bbVar.getType() == bb.atL || bbVar.getType() == bb.atQ) {
                            this.threadList.add(bbVar);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void I(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }
}
