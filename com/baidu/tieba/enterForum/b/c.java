package com.baidu.tieba.enterForum.b;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrequentlyForumInfo;
/* loaded from: classes.dex */
public class c {
    private ArrayList<com.baidu.tbadk.data.e> bJq = new ArrayList<>();

    public List<com.baidu.tbadk.data.e> YB() {
        return this.bJq;
    }

    public void ah(List<FrequentlyForumInfo> list) {
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) != null) {
                    FrequentlyForumInfo frequentlyForumInfo = list.get(i);
                    com.baidu.tbadk.data.e eVar = new com.baidu.tbadk.data.e();
                    if (frequentlyForumInfo != null && frequentlyForumInfo.forum_id != null && frequentlyForumInfo.forum_id.longValue() != 0 && !StringUtils.isNull(frequentlyForumInfo.forum_name)) {
                        eVar.a(frequentlyForumInfo);
                        this.bJq.add(eVar);
                    }
                }
            }
        }
    }
}
