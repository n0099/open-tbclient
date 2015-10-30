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
    private final /* synthetic */ String aLY;
    private final /* synthetic */ String ayZ;
    final /* synthetic */ b bqr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, String str, String str2) {
        this.bqr = bVar;
        this.ayZ = str;
        this.aLY = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelateForumItemData relateForumItemData;
        HotTopicActivity hotTopicActivity;
        HotTopicActivity hotTopicActivity2;
        HotTopicActivity hotTopicActivity3;
        HotTopicActivity hotTopicActivity4;
        relateForumItemData = this.bqr.bqk;
        if (relateForumItemData != null) {
            hotTopicActivity = this.bqr.bod;
            if (hotTopicActivity != null) {
                hotTopicActivity2 = this.bqr.bod;
                if (hotTopicActivity2.checkUpIsLogin()) {
                    if (as.aP(this.ayZ)) {
                        hotTopicActivity4 = this.bqr.bod;
                        hotTopicActivity4.boI.be(this.ayZ, this.aLY);
                    }
                    aq ae = new aq("c10365").ae("obj_type", "2");
                    hotTopicActivity3 = this.bqr.bod;
                    TiebaStatic.log(ae.ae("obj_id", hotTopicActivity3.QL()));
                }
            }
        }
    }
}
