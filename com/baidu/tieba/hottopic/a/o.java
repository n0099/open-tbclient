package com.baidu.tieba.hottopic.a;

import android.view.View;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.hottopic.controller.RelateTopicForumActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ n bov;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.bov = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelateTopicForumActivity relateTopicForumActivity;
        RelateTopicForumActivity relateTopicForumActivity2;
        int intValue;
        ArrayList arrayList;
        RelateTopicForumActivity relateTopicForumActivity3;
        relateTopicForumActivity = this.bov.bos;
        if (relateTopicForumActivity != null) {
            relateTopicForumActivity2 = this.bov.bos;
            if (relateTopicForumActivity2.checkUpIsLogin() && view.getId() == i.f.forum_add_love && (intValue = ((Integer) view.getTag()).intValue()) >= 0) {
                arrayList = this.bov.Xq;
                RelateForumItemData relateForumItemData = (RelateForumItemData) arrayList.get(intValue);
                if (relateForumItemData.forumId != 0) {
                    TiebaStatic.log(new aq("c10371").ae(ImageViewerConfig.FORUM_ID, String.valueOf(relateForumItemData.forumId)).r("obj_type", com.baidu.tieba.hottopic.data.d.bpa));
                }
                if (as.aP(relateForumItemData.forumName)) {
                    relateTopicForumActivity3 = this.bov.bos;
                    relateTopicForumActivity3.boI.be(relateForumItemData.forumName, String.valueOf(relateForumItemData.forumId));
                }
            }
        }
    }
}
