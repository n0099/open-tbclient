package com.baidu.tieba.hottopic.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    private final /* synthetic */ String aQP;
    final /* synthetic */ p bCP;
    private final /* synthetic */ String bCQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, String str, String str2) {
        this.bCP = pVar;
        this.bCQ = str;
        this.aQP = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HotTopicActivity hotTopicActivity;
        HotTopicActivity hotTopicActivity2;
        HotTopicActivity hotTopicActivity3;
        HotTopicActivity hotTopicActivity4;
        hotTopicActivity = this.bCP.bCN;
        if (hotTopicActivity != null) {
            hotTopicActivity2 = this.bCP.bCN;
            if (hotTopicActivity2.checkUpIsLogin()) {
                if (ax.aR(this.bCQ)) {
                    hotTopicActivity4 = this.bCP.bCN;
                    hotTopicActivity4.bDm.bg(this.bCQ, this.aQP);
                }
                av ab = new av("c10365").ab("obj_type", "2");
                hotTopicActivity3 = this.bCP.bCN;
                TiebaStatic.log(ab.ab("obj_id", hotTopicActivity3.Ul()));
            }
        }
    }
}
