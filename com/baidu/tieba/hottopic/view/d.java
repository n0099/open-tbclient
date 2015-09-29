package com.baidu.tieba.hottopic.view;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    private final /* synthetic */ String aLN;
    private final /* synthetic */ String ayO;
    final /* synthetic */ b bqg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, String str, String str2) {
        this.bqg = bVar;
        this.ayO = str;
        this.aLN = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelateForumItemData relateForumItemData;
        HotTopicActivity hotTopicActivity;
        HotTopicActivity hotTopicActivity2;
        HotTopicActivity hotTopicActivity3;
        HotTopicActivity hotTopicActivity4;
        relateForumItemData = this.bqg.bpZ;
        if (relateForumItemData != null) {
            hotTopicActivity = this.bqg.bnS;
            if (hotTopicActivity != null) {
                hotTopicActivity2 = this.bqg.bnS;
                if (hotTopicActivity2.checkUpIsLogin()) {
                    if (ar.aP(this.ayO)) {
                        hotTopicActivity4 = this.bqg.bnS;
                        hotTopicActivity4.box.be(this.ayO, this.aLN);
                    }
                    ap ae = new ap("c10365").ae("obj_type", "2");
                    hotTopicActivity3 = this.bqg.bnS;
                    TiebaStatic.log(ae.ae("obj_id", hotTopicActivity3.QP()));
                }
            }
        }
    }
}
