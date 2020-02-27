package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes9.dex */
public class b {
    public int from;
    public a hhy;
    public a hhz;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.hhy = new a();
            this.hhy.hhA = pkModule.agree.pk_num.longValue();
            this.hhy.hhB = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.hhy.hhC = pkModule.agree.last_username;
            this.hhy.hhD = pkModule.agree.pk_icon;
            this.hhy.hhE = pkModule.agree.has_clicked.longValue() == 1;
            this.hhy.hhF = pkModule.agree.pk_index.longValue();
            this.hhy.hhG = pkModule.agree.pk_icon_after;
            this.hhz = new a();
            this.hhz.hhA = pkModule.disagree.pk_num.longValue();
            this.hhz.hhB = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.hhz.hhC = pkModule.disagree.last_username;
            this.hhz.hhD = pkModule.disagree.pk_icon;
            this.hhz.hhE = pkModule.disagree.has_clicked.longValue() == 1;
            this.hhz.hhF = pkModule.disagree.pk_index.longValue();
            this.hhz.hhG = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.hhy = new a();
            this.hhy.hhA = pkModule.agree.pk_num.longValue();
            this.hhy.hhB = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.hhy.hhC = pkModule.agree.last_username;
            this.hhy.hhD = pkModule.agree.pk_icon;
            this.hhy.hhE = pkModule.agree.has_clicked.longValue() == 1;
            this.hhy.hhF = pkModule.agree.pk_index.longValue();
            this.hhy.hhG = pkModule.agree.pk_icon_after;
            this.hhz = new a();
            this.hhz.hhA = pkModule.disagree.pk_num.longValue();
            this.hhz.hhB = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.hhz.hhC = pkModule.disagree.last_username;
            this.hhz.hhD = pkModule.disagree.pk_icon;
            this.hhz.hhE = pkModule.disagree.has_clicked.longValue() == 1;
            this.hhz.hhF = pkModule.disagree.pk_index.longValue();
            this.hhz.hhG = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.hhy = new a();
            this.hhy.hhA = pkModule.agree.pk_num.longValue();
            this.hhy.hhB = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.hhy.hhC = pkModule.agree.last_username;
            this.hhy.hhD = pkModule.agree.pk_icon;
            this.hhy.hhE = pkModule.agree.has_clicked.longValue() == 1;
            this.hhy.hhF = pkModule.agree.pk_index.longValue();
            this.hhy.hhG = pkModule.agree.pk_icon_after;
            this.hhz = new a();
            this.hhz.hhA = pkModule.disagree.pk_num.longValue();
            this.hhz.hhB = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.hhz.hhC = pkModule.disagree.last_username;
            this.hhz.hhD = pkModule.disagree.pk_icon;
            this.hhz.hhE = pkModule.disagree.has_clicked.longValue() == 1;
            this.hhz.hhF = pkModule.disagree.pk_index.longValue();
            this.hhz.hhG = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes9.dex */
    public class a {
        public long hhA;
        public String hhB;
        public String hhC;
        public String hhD;
        public boolean hhE;
        public long hhF;
        public String hhG;

        public a() {
        }
    }
}
