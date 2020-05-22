package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecommendForumInfo;
/* loaded from: classes9.dex */
public class l extends f {
    private ArrayList<k> gOV;

    public l() {
        setType(9);
        this.gOV = new ArrayList<>();
    }

    public void bR(List<RecommendForumInfo> list) {
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof RecommendForumInfo) {
                    RecommendForumInfo recommendForumInfo = list.get(i);
                    k kVar = new k();
                    if (recommendForumInfo != null && recommendForumInfo.forum_id != null && recommendForumInfo.forum_id.longValue() != 0 && !StringUtils.isNull(recommendForumInfo.forum_name) && recommendForumInfo.is_like != null && recommendForumInfo.is_like.intValue() != 1) {
                        kVar.a(recommendForumInfo);
                        this.gOV.add(kVar);
                    }
                }
            }
        }
    }

    public ArrayList<k> bOq() {
        return this.gOV;
    }
}
