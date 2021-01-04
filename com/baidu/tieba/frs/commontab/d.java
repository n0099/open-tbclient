package com.baidu.tieba.frs.commontab;

import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
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
    public List<App> geM;
    public boolean hasMore;
    public ItemInfo itemInfo;
    public int joE;
    public String joF;
    public String joG;
    public boolean joH;
    public SportScheduleInfo joI;
    public HashMap<String, MetaData> userMap = new HashMap<>();
    public ArrayList<n> threadList = new ArrayList<>();
    public int sortType = 1;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.hasMore = dataRes.has_more.intValue() == 1;
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
            if (!x.isEmpty(dataRes.general_list)) {
                for (ThreadInfo threadInfo : dataRes.general_list) {
                    if (threadInfo != null) {
                        bz bzVar = new bz();
                        bzVar.setUserMap(this.userMap);
                        bzVar.eWE = true;
                        bzVar.a(threadInfo);
                        bzVar.bsq();
                        bzVar.bqS();
                        this.threadList.add(bzVar);
                    }
                }
            }
            this.geM = dataRes.app_list;
            com.baidu.tbadk.a.a.a.bo(this.threadList);
            this.joE = dataRes.new_thread_num.intValue();
            if (dataRes.sport_head_info != null) {
                this.joF = dataRes.sport_head_info.head_url;
                this.joG = dataRes.sport_head_info.jump_url;
                this.joH = dataRes.sport_head_info.is_ad.intValue() == 1;
            }
            this.joI = dataRes.sport_schedule_info;
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
