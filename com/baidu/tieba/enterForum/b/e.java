package com.baidu.tieba.enterForum.b;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class e {
    ArrayList<d> aCA = new ArrayList<>();

    public List<d> GA() {
        return this.aCA;
    }

    public void F(List<RecommendForumInfo> list) {
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof RecommendForumInfo) {
                    RecommendForumInfo recommendForumInfo = list.get(i);
                    d dVar = new d();
                    if (recommendForumInfo != null && recommendForumInfo.forum_id != null && recommendForumInfo.forum_id.longValue() != 0 && !StringUtils.isNull(recommendForumInfo.forum_name) && recommendForumInfo.is_like != null && recommendForumInfo.is_like.intValue() != 1) {
                        dVar.b(recommendForumInfo);
                        this.aCA.add(dVar);
                    }
                }
            }
        }
    }
}
