package com.baidu.tieba.enterForum.b;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class h {
    ArrayList<g> bsR = new ArrayList<>();

    public List<g> RT() {
        return this.bsR;
    }

    public void Z(List<RecommendForumInfo> list) {
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof RecommendForumInfo) {
                    RecommendForumInfo recommendForumInfo = list.get(i);
                    g gVar = new g();
                    if (recommendForumInfo != null && recommendForumInfo.forum_id != null && recommendForumInfo.forum_id.longValue() != 0 && !StringUtils.isNull(recommendForumInfo.forum_name) && recommendForumInfo.is_like != null && recommendForumInfo.is_like.intValue() != 1) {
                        gVar.b(recommendForumInfo);
                        this.bsR.add(gVar);
                    }
                }
            }
        }
    }
}
