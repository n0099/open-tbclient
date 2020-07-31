package com.baidu.tieba.frs.commontab;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.mvc.b.j;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
import tbclient.GeneralTabList.DataRes;
import tbclient.ItemInfo;
import tbclient.SportScheduleInfo;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes16.dex */
public class d implements j {
    public int hNY;
    public String hNZ;
    public String hOa;
    public boolean hOb;
    public SportScheduleInfo hOc;
    public boolean hasMore;
    public ItemInfo itemInfo;
    public HashMap<String, MetaData> userMap = new HashMap<>();
    public ArrayList<q> threadList = new ArrayList<>();
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
                        bv bvVar = new bv();
                        bvVar.setUserMap(this.userMap);
                        bvVar.a(threadInfo);
                        bvVar.aXj();
                        bvVar.aVN();
                        this.threadList.add(bvVar);
                    }
                }
            }
            com.baidu.tbadk.a.a.a.aG(this.threadList);
            this.hNY = dataRes.new_thread_num.intValue();
            if (dataRes.sport_head_info != null) {
                this.hNZ = dataRes.sport_head_info.head_url;
                this.hOa = dataRes.sport_head_info.jump_url;
                this.hOb = dataRes.sport_head_info.is_ad.intValue() == 1;
            }
            this.hOc = dataRes.sport_schedule_info;
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
