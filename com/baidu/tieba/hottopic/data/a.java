package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.CommonInteraction;
/* loaded from: classes21.dex */
public class a implements q {
    public static final BdUniqueId jwr = BdUniqueId.gen();
    public String jws;
    public String jwt;
    public int jwu;
    public String jwv;
    public String jww;
    public int jwx;
    public long pkId;
    public long totalNum;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jwr;
    }

    public void a(CommonInteraction commonInteraction) {
        if (commonInteraction != null) {
            this.jws = commonInteraction.module_name;
            this.jwt = commonInteraction.ques_desc;
            this.totalNum = commonInteraction.total_num.longValue();
            this.jwu = commonInteraction.has_clicked.intValue();
            this.jwv = commonInteraction.before_click_pic;
            this.jww = commonInteraction.after_click_pic;
            this.pkId = commonInteraction.pk_id.longValue();
            this.userPkId = commonInteraction.user_pk_id.longValue();
        }
    }
}
