package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes9.dex */
public class b {
    public int from;
    public a hTc;
    public a hTd;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.hTc = new a();
            this.hTc.hTe = pkModule.agree.pk_num.longValue();
            this.hTc.hTf = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.hTc.hTg = pkModule.agree.last_username;
            this.hTc.hTh = pkModule.agree.pk_icon;
            this.hTc.hTi = pkModule.agree.has_clicked.longValue() == 1;
            this.hTc.hTj = pkModule.agree.pk_index.longValue();
            this.hTc.hTk = pkModule.agree.pk_icon_after;
            this.hTd = new a();
            this.hTd.hTe = pkModule.disagree.pk_num.longValue();
            this.hTd.hTf = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.hTd.hTg = pkModule.disagree.last_username;
            this.hTd.hTh = pkModule.disagree.pk_icon;
            this.hTd.hTi = pkModule.disagree.has_clicked.longValue() == 1;
            this.hTd.hTj = pkModule.disagree.pk_index.longValue();
            this.hTd.hTk = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.hTc = new a();
            this.hTc.hTe = pkModule.agree.pk_num.longValue();
            this.hTc.hTf = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.hTc.hTg = pkModule.agree.last_username;
            this.hTc.hTh = pkModule.agree.pk_icon;
            this.hTc.hTi = pkModule.agree.has_clicked.longValue() == 1;
            this.hTc.hTj = pkModule.agree.pk_index.longValue();
            this.hTc.hTk = pkModule.agree.pk_icon_after;
            this.hTd = new a();
            this.hTd.hTe = pkModule.disagree.pk_num.longValue();
            this.hTd.hTf = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.hTd.hTg = pkModule.disagree.last_username;
            this.hTd.hTh = pkModule.disagree.pk_icon;
            this.hTd.hTi = pkModule.disagree.has_clicked.longValue() == 1;
            this.hTd.hTj = pkModule.disagree.pk_index.longValue();
            this.hTd.hTk = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.hTc = new a();
            this.hTc.hTe = pkModule.agree.pk_num.longValue();
            this.hTc.hTf = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.hTc.hTg = pkModule.agree.last_username;
            this.hTc.hTh = pkModule.agree.pk_icon;
            this.hTc.hTi = pkModule.agree.has_clicked.longValue() == 1;
            this.hTc.hTj = pkModule.agree.pk_index.longValue();
            this.hTc.hTk = pkModule.agree.pk_icon_after;
            this.hTd = new a();
            this.hTd.hTe = pkModule.disagree.pk_num.longValue();
            this.hTd.hTf = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.hTd.hTg = pkModule.disagree.last_username;
            this.hTd.hTh = pkModule.disagree.pk_icon;
            this.hTd.hTi = pkModule.disagree.has_clicked.longValue() == 1;
            this.hTd.hTj = pkModule.disagree.pk_index.longValue();
            this.hTd.hTk = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes9.dex */
    public class a {
        public long hTe;
        public String hTf;
        public String hTg;
        public String hTh;
        public boolean hTi;
        public long hTj;
        public String hTk;

        public a() {
        }
    }
}
