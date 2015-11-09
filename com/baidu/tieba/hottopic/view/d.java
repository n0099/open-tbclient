package com.baidu.tieba.hottopic.view;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    private final /* synthetic */ String aMg;
    private final /* synthetic */ String axO;
    final /* synthetic */ b bqV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, String str, String str2) {
        this.bqV = bVar;
        this.axO = str;
        this.aMg = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelateForumItemData relateForumItemData;
        HotTopicActivity hotTopicActivity;
        HotTopicActivity hotTopicActivity2;
        HotTopicActivity hotTopicActivity3;
        HotTopicActivity hotTopicActivity4;
        relateForumItemData = this.bqV.bqO;
        if (relateForumItemData != null) {
            hotTopicActivity = this.bqV.boH;
            if (hotTopicActivity != null) {
                hotTopicActivity2 = this.bqV.boH;
                if (hotTopicActivity2.checkUpIsLogin()) {
                    if (as.aN(this.axO)) {
                        hotTopicActivity4 = this.bqV.boH;
                        hotTopicActivity4.bpm.bd(this.axO, this.aMg);
                    }
                    aq ae = new aq("c10365").ae("obj_type", "2");
                    hotTopicActivity3 = this.bqV.boH;
                    TiebaStatic.log(ae.ae("obj_id", hotTopicActivity3.Rh()));
                }
            }
        }
    }
}
