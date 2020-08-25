package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.CommonInteraction;
/* loaded from: classes15.dex */
public class a implements q {
    public static final BdUniqueId iYH = BdUniqueId.gen();
    public String iYI;
    public String iYJ;
    public int iYK;
    public String iYL;
    public String iYM;
    public int iYN;
    public long pkId;
    public long totalNum;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iYH;
    }

    public void a(CommonInteraction commonInteraction) {
        if (commonInteraction != null) {
            this.iYI = commonInteraction.module_name;
            this.iYJ = commonInteraction.ques_desc;
            this.totalNum = commonInteraction.total_num.longValue();
            this.iYK = commonInteraction.has_clicked.intValue();
            this.iYL = commonInteraction.before_click_pic;
            this.iYM = commonInteraction.after_click_pic;
            this.pkId = commonInteraction.pk_id.longValue();
            this.userPkId = commonInteraction.user_pk_id.longValue();
        }
    }
}
