package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes9.dex */
public class b {
    public int from;
    public a hhM;
    public a hhN;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.hhM = new a();
            this.hhM.hhO = pkModule.agree.pk_num.longValue();
            this.hhM.hhP = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.hhM.hhQ = pkModule.agree.last_username;
            this.hhM.hhR = pkModule.agree.pk_icon;
            this.hhM.hhS = pkModule.agree.has_clicked.longValue() == 1;
            this.hhM.hhT = pkModule.agree.pk_index.longValue();
            this.hhM.hhU = pkModule.agree.pk_icon_after;
            this.hhN = new a();
            this.hhN.hhO = pkModule.disagree.pk_num.longValue();
            this.hhN.hhP = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.hhN.hhQ = pkModule.disagree.last_username;
            this.hhN.hhR = pkModule.disagree.pk_icon;
            this.hhN.hhS = pkModule.disagree.has_clicked.longValue() == 1;
            this.hhN.hhT = pkModule.disagree.pk_index.longValue();
            this.hhN.hhU = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.hhM = new a();
            this.hhM.hhO = pkModule.agree.pk_num.longValue();
            this.hhM.hhP = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.hhM.hhQ = pkModule.agree.last_username;
            this.hhM.hhR = pkModule.agree.pk_icon;
            this.hhM.hhS = pkModule.agree.has_clicked.longValue() == 1;
            this.hhM.hhT = pkModule.agree.pk_index.longValue();
            this.hhM.hhU = pkModule.agree.pk_icon_after;
            this.hhN = new a();
            this.hhN.hhO = pkModule.disagree.pk_num.longValue();
            this.hhN.hhP = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.hhN.hhQ = pkModule.disagree.last_username;
            this.hhN.hhR = pkModule.disagree.pk_icon;
            this.hhN.hhS = pkModule.disagree.has_clicked.longValue() == 1;
            this.hhN.hhT = pkModule.disagree.pk_index.longValue();
            this.hhN.hhU = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.hhM = new a();
            this.hhM.hhO = pkModule.agree.pk_num.longValue();
            this.hhM.hhP = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.hhM.hhQ = pkModule.agree.last_username;
            this.hhM.hhR = pkModule.agree.pk_icon;
            this.hhM.hhS = pkModule.agree.has_clicked.longValue() == 1;
            this.hhM.hhT = pkModule.agree.pk_index.longValue();
            this.hhM.hhU = pkModule.agree.pk_icon_after;
            this.hhN = new a();
            this.hhN.hhO = pkModule.disagree.pk_num.longValue();
            this.hhN.hhP = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.hhN.hhQ = pkModule.disagree.last_username;
            this.hhN.hhR = pkModule.disagree.pk_icon;
            this.hhN.hhS = pkModule.disagree.has_clicked.longValue() == 1;
            this.hhN.hhT = pkModule.disagree.pk_index.longValue();
            this.hhN.hhU = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes9.dex */
    public class a {
        public long hhO;
        public String hhP;
        public String hhQ;
        public String hhR;
        public boolean hhS;
        public long hhT;
        public String hhU;

        public a() {
        }
    }
}
