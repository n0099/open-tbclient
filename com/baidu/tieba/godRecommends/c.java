package com.baidu.tieba.godRecommends;

import com.baidu.tbadk.data.MetaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetRecommendGod.DataRes;
import tbclient.User;
/* loaded from: classes3.dex */
public class c {
    private List<MetaData> dOa;

    public void a(DataRes dataRes) {
        List<User> list;
        if (dataRes != null && (list = dataRes.user_list) != null && list.size() > 0) {
            this.dOa = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.dOa.add(metaData);
            }
        }
    }

    public List<MetaData> aBY() {
        return this.dOa;
    }
}
