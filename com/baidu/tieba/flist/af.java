package com.baidu.tieba.flist;

import java.util.LinkedList;
/* loaded from: classes.dex */
class af implements com.baidu.tieba.util.ak {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumRankActivity f1293a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ForumRankActivity forumRankActivity) {
        this.f1293a = forumRankActivity;
    }

    @Override // com.baidu.tieba.util.ak
    public LinkedList<String> getPhotoUrl() {
        return null;
    }

    @Override // com.baidu.tieba.util.ak
    public LinkedList<String> getImageUrl() {
        String str;
        String str2;
        str = this.f1293a.m;
        if (str == null) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        str2 = this.f1293a.m;
        linkedList.add(str2);
        return linkedList;
    }

    @Override // com.baidu.tieba.util.ak
    public LinkedList<String> getForumPhotoUrl() {
        return null;
    }
}
