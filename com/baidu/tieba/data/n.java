package com.baidu.tieba.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class n {
    ArrayList<m> aty = new ArrayList<>();

    public List<m> CR() {
        return this.aty;
    }

    public void H(List<RecommendForumInfo> list) {
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof RecommendForumInfo) {
                    RecommendForumInfo recommendForumInfo = list.get(i);
                    m mVar = new m();
                    if (recommendForumInfo != null && recommendForumInfo.forum_id != null && recommendForumInfo.forum_id.longValue() != 0 && !StringUtils.isNull(recommendForumInfo.forum_name) && recommendForumInfo.is_like != null && recommendForumInfo.is_like.intValue() != 1) {
                        mVar.b(recommendForumInfo);
                        this.aty.add(mVar);
                    }
                }
            }
        }
    }
}
