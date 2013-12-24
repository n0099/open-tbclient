package com.baidu.tieba.flist;

import com.baidu.tieba.util.al;
import java.util.LinkedList;
/* loaded from: classes.dex */
class af implements al {
    final /* synthetic */ ForumRankActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ForumRankActivity forumRankActivity) {
        this.a = forumRankActivity;
    }

    @Override // com.baidu.tieba.util.al
    public LinkedList<String> getPhotoUrl() {
        return null;
    }

    @Override // com.baidu.tieba.util.al
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

    @Override // com.baidu.tieba.util.al
    public LinkedList<String> getForumPhotoUrl() {
        return null;
    }
}
