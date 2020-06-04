package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes9.dex */
public class b {
    public int from;
    public a iiA;
    public a iiz;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.iiz = new a();
            this.iiz.iiB = pkModule.agree.pk_num.longValue();
            this.iiz.iiC = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.iiz.iiD = pkModule.agree.last_username;
            this.iiz.iiE = pkModule.agree.pk_icon;
            this.iiz.iiF = pkModule.agree.has_clicked.longValue() == 1;
            this.iiz.iiG = pkModule.agree.pk_index.longValue();
            this.iiz.iiH = pkModule.agree.pk_icon_after;
            this.iiA = new a();
            this.iiA.iiB = pkModule.disagree.pk_num.longValue();
            this.iiA.iiC = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.iiA.iiD = pkModule.disagree.last_username;
            this.iiA.iiE = pkModule.disagree.pk_icon;
            this.iiA.iiF = pkModule.disagree.has_clicked.longValue() == 1;
            this.iiA.iiG = pkModule.disagree.pk_index.longValue();
            this.iiA.iiH = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.iiz = new a();
            this.iiz.iiB = pkModule.agree.pk_num.longValue();
            this.iiz.iiC = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.iiz.iiD = pkModule.agree.last_username;
            this.iiz.iiE = pkModule.agree.pk_icon;
            this.iiz.iiF = pkModule.agree.has_clicked.longValue() == 1;
            this.iiz.iiG = pkModule.agree.pk_index.longValue();
            this.iiz.iiH = pkModule.agree.pk_icon_after;
            this.iiA = new a();
            this.iiA.iiB = pkModule.disagree.pk_num.longValue();
            this.iiA.iiC = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.iiA.iiD = pkModule.disagree.last_username;
            this.iiA.iiE = pkModule.disagree.pk_icon;
            this.iiA.iiF = pkModule.disagree.has_clicked.longValue() == 1;
            this.iiA.iiG = pkModule.disagree.pk_index.longValue();
            this.iiA.iiH = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.iiz = new a();
            this.iiz.iiB = pkModule.agree.pk_num.longValue();
            this.iiz.iiC = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.iiz.iiD = pkModule.agree.last_username;
            this.iiz.iiE = pkModule.agree.pk_icon;
            this.iiz.iiF = pkModule.agree.has_clicked.longValue() == 1;
            this.iiz.iiG = pkModule.agree.pk_index.longValue();
            this.iiz.iiH = pkModule.agree.pk_icon_after;
            this.iiA = new a();
            this.iiA.iiB = pkModule.disagree.pk_num.longValue();
            this.iiA.iiC = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.iiA.iiD = pkModule.disagree.last_username;
            this.iiA.iiE = pkModule.disagree.pk_icon;
            this.iiA.iiF = pkModule.disagree.has_clicked.longValue() == 1;
            this.iiA.iiG = pkModule.disagree.pk_index.longValue();
            this.iiA.iiH = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes9.dex */
    public class a {
        public long iiB;
        public String iiC;
        public String iiD;
        public String iiE;
        public boolean iiF;
        public long iiG;
        public String iiH;

        public a() {
        }
    }
}
