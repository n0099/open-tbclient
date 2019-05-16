package com.baidu.tieba.frs.commontab;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.mvc.b.j;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
import tbclient.GeneralTabList.DataRes;
import tbclient.SportScheduleInfo;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes4.dex */
public class d implements j {
    public int fwB;
    public String fwC;
    public String fwD;
    public boolean fwE;
    public SportScheduleInfo fwF;
    public boolean hasMore;
    public HashMap<String, MetaData> userMap = new HashMap<>();
    public ArrayList<m> threadList = new ArrayList<>();

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.hasMore = dataRes.has_more.intValue() == 1;
            if (!v.aa(dataRes.user_list)) {
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
            if (!v.aa(dataRes.general_list)) {
                for (ThreadInfo threadInfo : dataRes.general_list) {
                    if (threadInfo != null) {
                        bg bgVar = new bg();
                        bgVar.setUserMap(this.userMap);
                        bgVar.a(threadInfo);
                        bgVar.setCurrentPage(3);
                        bgVar.ael();
                        this.threadList.add(bgVar);
                    }
                }
            }
            this.fwB = dataRes.new_thread_num.intValue();
            if (dataRes.sport_head_info != null) {
                this.fwC = dataRes.sport_head_info.head_url;
                this.fwD = dataRes.sport_head_info.jump_url;
                this.fwE = dataRes.sport_head_info.is_ad.intValue() == 1;
            }
            this.fwF = dataRes.sport_schedule_info;
        }
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void initByJson(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void initByProtobuf(Message message) {
    }
}
