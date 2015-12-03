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
    final /* synthetic */ u bCY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.bCY = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelateTopicForumActivity relateTopicForumActivity;
        RelateTopicForumActivity relateTopicForumActivity2;
        int intValue;
        ArrayList arrayList;
        RelateTopicForumActivity relateTopicForumActivity3;
        relateTopicForumActivity = this.bCY.bCV;
        if (relateTopicForumActivity != null) {
            relateTopicForumActivity2 = this.bCY.bCV;
            if (relateTopicForumActivity2.checkUpIsLogin() && view.getId() == n.f.forum_add_love && (intValue = ((Integer) view.getTag()).intValue()) >= 0) {
                arrayList = this.bCY.Yg;
                RelateForumItemData relateForumItemData = (RelateForumItemData) arrayList.get(intValue);
                if (relateForumItemData.forumId != 0) {
                    TiebaStatic.log(new av("c10371").ab(ImageViewerConfig.FORUM_ID, String.valueOf(relateForumItemData.forumId)).r("obj_type", com.baidu.tieba.hottopic.data.f.bEd));
                }
                if (ax.aR(relateForumItemData.forumName)) {
                    relateTopicForumActivity3 = this.bCY.bCV;
                    relateTopicForumActivity3.bDm.bg(relateForumItemData.forumName, String.valueOf(relateForumItemData.forumId));
                }
            }
        }
    }
}
