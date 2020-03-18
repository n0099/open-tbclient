package com.baidu.tieba.frs.commontab;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bj;
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
/* loaded from: classes9.dex */
public class d implements j {
    public int gwR;
    public String gwS;
    public String gwT;
    public boolean gwU;
    public SportScheduleInfo gwV;
    public boolean hasMore;
    public HashMap<String, MetaData> userMap = new HashMap<>();
    public ArrayList<m> threadList = new ArrayList<>();
    public int sortType = 1;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.hasMore = dataRes.has_more.intValue() == 1;
            if (!v.isEmpty(dataRes.user_list)) {
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
            if (!v.isEmpty(dataRes.general_list)) {
                for (ThreadInfo threadInfo : dataRes.general_list) {
                    if (threadInfo != null) {
                        bj bjVar = new bj();
                        bjVar.setUserMap(this.userMap);
                        bjVar.a(threadInfo);
                        bjVar.aDm();
                        this.threadList.add(bjVar);
                    }
                }
            }
            this.gwR = dataRes.new_thread_num.intValue();
            if (dataRes.sport_head_info != null) {
                this.gwS = dataRes.sport_head_info.head_url;
                this.gwT = dataRes.sport_head_info.jump_url;
                this.gwU = dataRes.sport_head_info.is_ad.intValue() == 1;
            }
            this.gwV = dataRes.sport_schedule_info;
            this.sortType = dataRes.sort_type.intValue();
        }
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void initByJson(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void initByProtobuf(Message message) {
    }
}
