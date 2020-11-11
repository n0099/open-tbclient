package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes22.dex */
public class b {
    public int from;
    public a jKQ;
    public a jKR;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.jKQ = new a();
            this.jKQ.jKS = pkModule.agree.pk_num.longValue();
            this.jKQ.jKT = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.jKQ.jKU = pkModule.agree.last_username;
            this.jKQ.jKV = pkModule.agree.pk_icon;
            this.jKQ.jKW = pkModule.agree.has_clicked.longValue() == 1;
            this.jKQ.jKX = pkModule.agree.pk_index.longValue();
            this.jKQ.jKY = pkModule.agree.pk_icon_after;
            this.jKR = new a();
            this.jKR.jKS = pkModule.disagree.pk_num.longValue();
            this.jKR.jKT = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.jKR.jKU = pkModule.disagree.last_username;
            this.jKR.jKV = pkModule.disagree.pk_icon;
            this.jKR.jKW = pkModule.disagree.has_clicked.longValue() == 1;
            this.jKR.jKX = pkModule.disagree.pk_index.longValue();
            this.jKR.jKY = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.jKQ = new a();
            this.jKQ.jKS = pkModule.agree.pk_num.longValue();
            this.jKQ.jKT = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.jKQ.jKU = pkModule.agree.last_username;
            this.jKQ.jKV = pkModule.agree.pk_icon;
            this.jKQ.jKW = pkModule.agree.has_clicked.longValue() == 1;
            this.jKQ.jKX = pkModule.agree.pk_index.longValue();
            this.jKQ.jKY = pkModule.agree.pk_icon_after;
            this.jKR = new a();
            this.jKR.jKS = pkModule.disagree.pk_num.longValue();
            this.jKR.jKT = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.jKR.jKU = pkModule.disagree.last_username;
            this.jKR.jKV = pkModule.disagree.pk_icon;
            this.jKR.jKW = pkModule.disagree.has_clicked.longValue() == 1;
            this.jKR.jKX = pkModule.disagree.pk_index.longValue();
            this.jKR.jKY = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.jKQ = new a();
            this.jKQ.jKS = pkModule.agree.pk_num.longValue();
            this.jKQ.jKT = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.jKQ.jKU = pkModule.agree.last_username;
            this.jKQ.jKV = pkModule.agree.pk_icon;
            this.jKQ.jKW = pkModule.agree.has_clicked.longValue() == 1;
            this.jKQ.jKX = pkModule.agree.pk_index.longValue();
            this.jKQ.jKY = pkModule.agree.pk_icon_after;
            this.jKR = new a();
            this.jKR.jKS = pkModule.disagree.pk_num.longValue();
            this.jKR.jKT = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.jKR.jKU = pkModule.disagree.last_username;
            this.jKR.jKV = pkModule.disagree.pk_icon;
            this.jKR.jKW = pkModule.disagree.has_clicked.longValue() == 1;
            this.jKR.jKX = pkModule.disagree.pk_index.longValue();
            this.jKR.jKY = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes22.dex */
    public class a {
        public long jKS;
        public String jKT;
        public String jKU;
        public String jKV;
        public boolean jKW;
        public long jKX;
        public String jKY;

        public a() {
        }
    }
}
