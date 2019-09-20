package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes4.dex */
public class b {
    public int from;
    public a gpM;
    public a gpN;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.gpM = new a();
            this.gpM.gpO = pkModule.agree.pk_num.longValue();
            this.gpM.gpP = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.gpM.gpQ = pkModule.agree.last_username;
            this.gpM.gpR = pkModule.agree.pk_icon;
            this.gpM.gpS = pkModule.agree.has_clicked.longValue() == 1;
            this.gpM.gpT = pkModule.agree.pk_index.longValue();
            this.gpM.gpU = pkModule.agree.pk_icon_after;
            this.gpN = new a();
            this.gpN.gpO = pkModule.disagree.pk_num.longValue();
            this.gpN.gpP = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.gpN.gpQ = pkModule.disagree.last_username;
            this.gpN.gpR = pkModule.disagree.pk_icon;
            this.gpN.gpS = pkModule.disagree.has_clicked.longValue() == 1;
            this.gpN.gpT = pkModule.disagree.pk_index.longValue();
            this.gpN.gpU = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.gpM = new a();
            this.gpM.gpO = pkModule.agree.pk_num.longValue();
            this.gpM.gpP = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.gpM.gpQ = pkModule.agree.last_username;
            this.gpM.gpR = pkModule.agree.pk_icon;
            this.gpM.gpS = pkModule.agree.has_clicked.longValue() == 1;
            this.gpM.gpT = pkModule.agree.pk_index.longValue();
            this.gpM.gpU = pkModule.agree.pk_icon_after;
            this.gpN = new a();
            this.gpN.gpO = pkModule.disagree.pk_num.longValue();
            this.gpN.gpP = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.gpN.gpQ = pkModule.disagree.last_username;
            this.gpN.gpR = pkModule.disagree.pk_icon;
            this.gpN.gpS = pkModule.disagree.has_clicked.longValue() == 1;
            this.gpN.gpT = pkModule.disagree.pk_index.longValue();
            this.gpN.gpU = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.gpM = new a();
            this.gpM.gpO = pkModule.agree.pk_num.longValue();
            this.gpM.gpP = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.gpM.gpQ = pkModule.agree.last_username;
            this.gpM.gpR = pkModule.agree.pk_icon;
            this.gpM.gpS = pkModule.agree.has_clicked.longValue() == 1;
            this.gpM.gpT = pkModule.agree.pk_index.longValue();
            this.gpM.gpU = pkModule.agree.pk_icon_after;
            this.gpN = new a();
            this.gpN.gpO = pkModule.disagree.pk_num.longValue();
            this.gpN.gpP = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.gpN.gpQ = pkModule.disagree.last_username;
            this.gpN.gpR = pkModule.disagree.pk_icon;
            this.gpN.gpS = pkModule.disagree.has_clicked.longValue() == 1;
            this.gpN.gpT = pkModule.disagree.pk_index.longValue();
            this.gpN.gpU = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public long gpO;
        public String gpP;
        public String gpQ;
        public String gpR;
        public boolean gpS;
        public long gpT;
        public String gpU;

        public a() {
        }
    }
}
