package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import tbclient.Hottopic.CommonInteraction;
/* loaded from: classes8.dex */
public class a implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId kqp = BdUniqueId.gen();
    public String kqq;
    public String kqr;
    public int kqs;
    public String kqt;
    public String kqu;
    public int kqv;
    public long pkId;
    public long totalNum;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return kqp;
    }

    public void a(CommonInteraction commonInteraction) {
        if (commonInteraction != null) {
            this.kqq = commonInteraction.module_name;
            this.kqr = commonInteraction.ques_desc;
            this.totalNum = commonInteraction.total_num.longValue();
            this.kqs = commonInteraction.has_clicked.intValue();
            this.kqt = commonInteraction.before_click_pic;
            this.kqu = commonInteraction.after_click_pic;
            this.pkId = commonInteraction.pk_id.longValue();
            this.userPkId = commonInteraction.user_pk_id.longValue();
        }
    }
}
