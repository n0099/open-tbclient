package com.baidu.tieba.flist;

import java.util.LinkedList;
/* loaded from: classes.dex */
class ab extends com.baidu.tbadk.core.util.a {
    final /* synthetic */ ForumRankActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(ForumRankActivity forumRankActivity) {
        this.a = forumRankActivity;
    }

    @Override // com.baidu.tbadk.core.util.a, com.baidu.tbadk.core.util.af
    public LinkedList<String> getImageUrl() {
        String str;
        String str2;
        str = this.a.l;
        if (str == null) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        str2 = this.a.l;
        linkedList.add(str2);
        return linkedList;
    }
}
