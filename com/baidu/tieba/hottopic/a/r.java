package com.baidu.tieba.hottopic.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    private final /* synthetic */ String aUG;
    final /* synthetic */ p bGt;
    private final /* synthetic */ String bGu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, String str, String str2) {
        this.bGt = pVar;
        this.bGu = str;
        this.aUG = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HotTopicActivity hotTopicActivity;
        HotTopicActivity hotTopicActivity2;
        HotTopicActivity hotTopicActivity3;
        HotTopicActivity hotTopicActivity4;
        hotTopicActivity = this.bGt.bGr;
        if (hotTopicActivity != null) {
            hotTopicActivity2 = this.bGt.bGr;
            if (hotTopicActivity2.checkUpIsLogin()) {
                if (ax.aR(this.bGu)) {
                    hotTopicActivity4 = this.bGt.bGr;
                    hotTopicActivity4.bGQ.bc(this.bGu, this.aUG);
                }
                av aa = new av("c10365").aa("obj_type", "2");
                hotTopicActivity3 = this.bGt.bGr;
                TiebaStatic.log(aa.aa("obj_id", hotTopicActivity3.Vo()));
            }
        }
    }
}
