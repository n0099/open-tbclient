package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.CommonInteraction;
/* loaded from: classes20.dex */
public class a implements q {
    public static final BdUniqueId jPy = BdUniqueId.gen();
    public String jPA;
    public int jPB;
    public String jPC;
    public String jPD;
    public int jPE;
    public String jPz;
    public long pkId;
    public long totalNum;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jPy;
    }

    public void a(CommonInteraction commonInteraction) {
        if (commonInteraction != null) {
            this.jPz = commonInteraction.module_name;
            this.jPA = commonInteraction.ques_desc;
            this.totalNum = commonInteraction.total_num.longValue();
            this.jPB = commonInteraction.has_clicked.intValue();
            this.jPC = commonInteraction.before_click_pic;
            this.jPD = commonInteraction.after_click_pic;
            this.pkId = commonInteraction.pk_id.longValue();
            this.userPkId = commonInteraction.user_pk_id.longValue();
        }
    }
}
