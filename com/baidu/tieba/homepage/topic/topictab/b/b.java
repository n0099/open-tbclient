package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes9.dex */
public class b {
    public int from;
    public a ihM;
    public a ihN;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.ihM = new a();
            this.ihM.ihO = pkModule.agree.pk_num.longValue();
            this.ihM.ihP = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.ihM.ihQ = pkModule.agree.last_username;
            this.ihM.ihR = pkModule.agree.pk_icon;
            this.ihM.ihS = pkModule.agree.has_clicked.longValue() == 1;
            this.ihM.ihT = pkModule.agree.pk_index.longValue();
            this.ihM.ihU = pkModule.agree.pk_icon_after;
            this.ihN = new a();
            this.ihN.ihO = pkModule.disagree.pk_num.longValue();
            this.ihN.ihP = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.ihN.ihQ = pkModule.disagree.last_username;
            this.ihN.ihR = pkModule.disagree.pk_icon;
            this.ihN.ihS = pkModule.disagree.has_clicked.longValue() == 1;
            this.ihN.ihT = pkModule.disagree.pk_index.longValue();
            this.ihN.ihU = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.ihM = new a();
            this.ihM.ihO = pkModule.agree.pk_num.longValue();
            this.ihM.ihP = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.ihM.ihQ = pkModule.agree.last_username;
            this.ihM.ihR = pkModule.agree.pk_icon;
            this.ihM.ihS = pkModule.agree.has_clicked.longValue() == 1;
            this.ihM.ihT = pkModule.agree.pk_index.longValue();
            this.ihM.ihU = pkModule.agree.pk_icon_after;
            this.ihN = new a();
            this.ihN.ihO = pkModule.disagree.pk_num.longValue();
            this.ihN.ihP = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.ihN.ihQ = pkModule.disagree.last_username;
            this.ihN.ihR = pkModule.disagree.pk_icon;
            this.ihN.ihS = pkModule.disagree.has_clicked.longValue() == 1;
            this.ihN.ihT = pkModule.disagree.pk_index.longValue();
            this.ihN.ihU = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.ihM = new a();
            this.ihM.ihO = pkModule.agree.pk_num.longValue();
            this.ihM.ihP = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.ihM.ihQ = pkModule.agree.last_username;
            this.ihM.ihR = pkModule.agree.pk_icon;
            this.ihM.ihS = pkModule.agree.has_clicked.longValue() == 1;
            this.ihM.ihT = pkModule.agree.pk_index.longValue();
            this.ihM.ihU = pkModule.agree.pk_icon_after;
            this.ihN = new a();
            this.ihN.ihO = pkModule.disagree.pk_num.longValue();
            this.ihN.ihP = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.ihN.ihQ = pkModule.disagree.last_username;
            this.ihN.ihR = pkModule.disagree.pk_icon;
            this.ihN.ihS = pkModule.disagree.has_clicked.longValue() == 1;
            this.ihN.ihT = pkModule.disagree.pk_index.longValue();
            this.ihN.ihU = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes9.dex */
    public class a {
        public long ihO;
        public String ihP;
        public String ihQ;
        public String ihR;
        public boolean ihS;
        public long ihT;
        public String ihU;

        public a() {
        }
    }
}
