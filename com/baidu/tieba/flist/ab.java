package com.baidu.tieba.flist;

import com.baidu.tieba.util.au;
import java.util.LinkedList;
/* loaded from: classes.dex */
class ab extends au {
    final /* synthetic */ ForumRankActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(ForumRankActivity forumRankActivity) {
        this.a = forumRankActivity;
    }

    @Override // com.baidu.tieba.util.au, com.baidu.tieba.util.aw
    public LinkedList<String> getImageUrl() {
        String str;
        String str2;
        str = this.a.m;
        if (str == null) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        str2 = this.a.m;
        linkedList.add(str2);
        return linkedList;
    }
}
