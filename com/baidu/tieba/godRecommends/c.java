package com.baidu.tieba.godRecommends;

import com.baidu.tbadk.data.MetaData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetRecommendGod.DataRes;
import tbclient.User;
/* loaded from: classes6.dex */
public class c {
    private List<MetaData> gbc;

    public void a(DataRes dataRes) {
        List<User> list;
        if (dataRes != null && (list = dataRes.user_list) != null && list.size() > 0) {
            this.gbc = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.gbc.add(metaData);
            }
        }
    }

    public List<MetaData> bsr() {
        return this.gbc;
    }
}
