package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes9.dex */
public class b {
    public int from;
    public a hhA;
    public a hhB;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.hhA = new a();
            this.hhA.hhC = pkModule.agree.pk_num.longValue();
            this.hhA.hhD = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.hhA.hhE = pkModule.agree.last_username;
            this.hhA.hhF = pkModule.agree.pk_icon;
            this.hhA.hhG = pkModule.agree.has_clicked.longValue() == 1;
            this.hhA.hhH = pkModule.agree.pk_index.longValue();
            this.hhA.hhI = pkModule.agree.pk_icon_after;
            this.hhB = new a();
            this.hhB.hhC = pkModule.disagree.pk_num.longValue();
            this.hhB.hhD = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.hhB.hhE = pkModule.disagree.last_username;
            this.hhB.hhF = pkModule.disagree.pk_icon;
            this.hhB.hhG = pkModule.disagree.has_clicked.longValue() == 1;
            this.hhB.hhH = pkModule.disagree.pk_index.longValue();
            this.hhB.hhI = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.hhA = new a();
            this.hhA.hhC = pkModule.agree.pk_num.longValue();
            this.hhA.hhD = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.hhA.hhE = pkModule.agree.last_username;
            this.hhA.hhF = pkModule.agree.pk_icon;
            this.hhA.hhG = pkModule.agree.has_clicked.longValue() == 1;
            this.hhA.hhH = pkModule.agree.pk_index.longValue();
            this.hhA.hhI = pkModule.agree.pk_icon_after;
            this.hhB = new a();
            this.hhB.hhC = pkModule.disagree.pk_num.longValue();
            this.hhB.hhD = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.hhB.hhE = pkModule.disagree.last_username;
            this.hhB.hhF = pkModule.disagree.pk_icon;
            this.hhB.hhG = pkModule.disagree.has_clicked.longValue() == 1;
            this.hhB.hhH = pkModule.disagree.pk_index.longValue();
            this.hhB.hhI = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.hhA = new a();
            this.hhA.hhC = pkModule.agree.pk_num.longValue();
            this.hhA.hhD = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.hhA.hhE = pkModule.agree.last_username;
            this.hhA.hhF = pkModule.agree.pk_icon;
            this.hhA.hhG = pkModule.agree.has_clicked.longValue() == 1;
            this.hhA.hhH = pkModule.agree.pk_index.longValue();
            this.hhA.hhI = pkModule.agree.pk_icon_after;
            this.hhB = new a();
            this.hhB.hhC = pkModule.disagree.pk_num.longValue();
            this.hhB.hhD = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.hhB.hhE = pkModule.disagree.last_username;
            this.hhB.hhF = pkModule.disagree.pk_icon;
            this.hhB.hhG = pkModule.disagree.has_clicked.longValue() == 1;
            this.hhB.hhH = pkModule.disagree.pk_index.longValue();
            this.hhB.hhI = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes9.dex */
    public class a {
        public long hhC;
        public String hhD;
        public String hhE;
        public String hhF;
        public boolean hhG;
        public long hhH;
        public String hhI;

        public a() {
        }
    }
}
