package com.baidu.tieba.flist;

import java.util.LinkedList;
/* loaded from: classes.dex */
class z extends com.baidu.tbadk.core.util.a {
    final /* synthetic */ ForumRankActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(ForumRankActivity forumRankActivity) {
        this.a = forumRankActivity;
    }

    @Override // com.baidu.tbadk.core.util.a
    public LinkedList<String> getImageUrl() {
        String str;
        String str2;
        str = this.a.j;
        if (str == null) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        str2 = this.a.j;
        linkedList.add(str2);
        return linkedList;
    }
}
