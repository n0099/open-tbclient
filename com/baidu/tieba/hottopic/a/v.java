package com.baidu.tieba.hottopic.a;

import android.view.View;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.hottopic.controller.RelateTopicForumActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ u bGC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.bGC = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelateTopicForumActivity relateTopicForumActivity;
        RelateTopicForumActivity relateTopicForumActivity2;
        int intValue;
        ArrayList arrayList;
        RelateTopicForumActivity relateTopicForumActivity3;
        relateTopicForumActivity = this.bGC.bGz;
        if (relateTopicForumActivity != null) {
            relateTopicForumActivity2 = this.bGC.bGz;
            if (relateTopicForumActivity2.checkUpIsLogin() && view.getId() == n.g.forum_add_love && (intValue = ((Integer) view.getTag()).intValue()) >= 0) {
                arrayList = this.bGC.YJ;
                RelateForumItemData relateForumItemData = (RelateForumItemData) arrayList.get(intValue);
                if (relateForumItemData.forumId != 0) {
                    TiebaStatic.log(new av("c10371").aa(ImageViewerConfig.FORUM_ID, String.valueOf(relateForumItemData.forumId)).r("obj_type", com.baidu.tieba.hottopic.data.f.bHG));
                }
                if (ax.aR(relateForumItemData.forumName)) {
                    relateTopicForumActivity3 = this.bGC.bGz;
                    relateTopicForumActivity3.bGQ.bc(relateForumItemData.forumName, String.valueOf(relateForumItemData.forumId));
                }
            }
        }
    }
}
