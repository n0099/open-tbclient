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
    public List<App> gea;
    public boolean hasMore;
    public ItemInfo itemInfo;
    public int jrB;
    public String jrC;
    public String jrD;
    public boolean jrE;
    public SportScheduleInfo jrF;
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
                        cbVar.eVG = true;
                        cbVar.a(threadInfo);
                        cbVar.boR();
                        cbVar.bnu();
                        this.threadList.add(cbVar);
                    }
                }
            }
            this.gea = dataRes.app_list;
            com.baidu.tbadk.a.a.a.bj(this.threadList);
            this.jrB = dataRes.new_thread_num.intValue();
            if (dataRes.sport_head_info != null) {
                this.jrC = dataRes.sport_head_info.head_url;
                this.jrD = dataRes.sport_head_info.jump_url;
                this.jrE = dataRes.sport_head_info.is_ad.intValue() == 1;
            }
            this.jrF = dataRes.sport_schedule_info;
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
