package com.baidu.tieba.frs.commontab;

import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.mvc.b.j;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import tbclient.App;
import tbclient.GeneralTabList.DataRes;
import tbclient.ItemInfo;
import tbclient.SportScheduleInfo;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes2.dex */
public class d implements j {
    public List<App> gcA;
    public boolean hasMore;
    public ItemInfo itemInfo;
    public int jpS;
    public String jpT;
    public String jpU;
    public boolean jpV;
    public SportScheduleInfo jpW;
    public HashMap<String, MetaData> userMap = new HashMap<>();
    public ArrayList<n> threadList = new ArrayList<>();
    public int sortType = 1;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.hasMore = dataRes.has_more.intValue() == 1;
            if (!y.isEmpty(dataRes.user_list)) {
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
            if (!y.isEmpty(dataRes.general_list)) {
                for (ThreadInfo threadInfo : dataRes.general_list) {
                    if (threadInfo != null) {
                        cb cbVar = new cb();
                        cbVar.setUserMap(this.userMap);
                        cbVar.eUh = true;
                        cbVar.a(threadInfo);
                        cbVar.boP();
                        cbVar.bns();
                        this.threadList.add(cbVar);
                    }
                }
            }
            this.gcA = dataRes.app_list;
            com.baidu.tbadk.a.a.a.bj(this.threadList);
            this.jpS = dataRes.new_thread_num.intValue();
            if (dataRes.sport_head_info != null) {
                this.jpT = dataRes.sport_head_info.head_url;
                this.jpU = dataRes.sport_head_info.jump_url;
                this.jpV = dataRes.sport_head_info.is_ad.intValue() == 1;
            }
            this.jpW = dataRes.sport_schedule_info;
            this.sortType = dataRes.sort_type.intValue();
            this.itemInfo = dataRes.item_info;
        }
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void initByJson(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void initByProtobuf(Message message) {
    }
}
