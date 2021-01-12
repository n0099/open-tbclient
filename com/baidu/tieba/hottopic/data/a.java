package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import tbclient.Hottopic.CommonInteraction;
/* loaded from: classes7.dex */
public class a implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId klK = BdUniqueId.gen();
    public String klL;
    public String klM;
    public int klN;
    public String klO;
    public String klP;
    public int klQ;
    public long pkId;
    public long totalNum;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return klK;
    }

    public void a(CommonInteraction commonInteraction) {
        if (commonInteraction != null) {
            this.klL = commonInteraction.module_name;
            this.klM = commonInteraction.ques_desc;
            this.totalNum = commonInteraction.total_num.longValue();
            this.klN = commonInteraction.has_clicked.intValue();
            this.klO = commonInteraction.before_click_pic;
            this.klP = commonInteraction.after_click_pic;
            this.pkId = commonInteraction.pk_id.longValue();
            this.userPkId = commonInteraction.user_pk_id.longValue();
        }
    }
}
