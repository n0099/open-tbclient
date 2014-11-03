package com.baidu.tieba.flist;

import java.util.ArrayList;
/* loaded from: classes.dex */
class z extends com.baidu.tbadk.core.util.a {
    final /* synthetic */ ForumRankActivity awY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(ForumRankActivity forumRankActivity) {
        this.awY = forumRankActivity;
    }

    @Override // com.baidu.tbadk.core.util.a
    public ArrayList<String> getImageUrl() {
        String str;
        String str2;
        str = this.awY.awU;
        if (str == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        str2 = this.awY.awU;
        arrayList.add(str2);
        return arrayList;
    }
}
