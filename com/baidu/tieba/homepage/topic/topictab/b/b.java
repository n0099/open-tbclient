package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes2.dex */
public class b {
    public int from;
    public a kmr;
    public a kms;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.kmr = new a();
            this.kmr.kmt = pkModule.agree.pk_num.longValue();
            this.kmr.kmu = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.kmr.kmv = pkModule.agree.last_username;
            this.kmr.kmw = pkModule.agree.pk_icon;
            this.kmr.kmx = pkModule.agree.has_clicked.longValue() == 1;
            this.kmr.kmy = pkModule.agree.pk_index.longValue();
            this.kmr.kmz = pkModule.agree.pk_icon_after;
            this.kms = new a();
            this.kms.kmt = pkModule.disagree.pk_num.longValue();
            this.kms.kmu = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.kms.kmv = pkModule.disagree.last_username;
            this.kms.kmw = pkModule.disagree.pk_icon;
            this.kms.kmx = pkModule.disagree.has_clicked.longValue() == 1;
            this.kms.kmy = pkModule.disagree.pk_index.longValue();
            this.kms.kmz = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.kmr = new a();
            this.kmr.kmt = pkModule.agree.pk_num.longValue();
            this.kmr.kmu = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.kmr.kmv = pkModule.agree.last_username;
            this.kmr.kmw = pkModule.agree.pk_icon;
            this.kmr.kmx = pkModule.agree.has_clicked.longValue() == 1;
            this.kmr.kmy = pkModule.agree.pk_index.longValue();
            this.kmr.kmz = pkModule.agree.pk_icon_after;
            this.kms = new a();
            this.kms.kmt = pkModule.disagree.pk_num.longValue();
            this.kms.kmu = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.kms.kmv = pkModule.disagree.last_username;
            this.kms.kmw = pkModule.disagree.pk_icon;
            this.kms.kmx = pkModule.disagree.has_clicked.longValue() == 1;
            this.kms.kmy = pkModule.disagree.pk_index.longValue();
            this.kms.kmz = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.kmr = new a();
            this.kmr.kmt = pkModule.agree.pk_num.longValue();
            this.kmr.kmu = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.kmr.kmv = pkModule.agree.last_username;
            this.kmr.kmw = pkModule.agree.pk_icon;
            this.kmr.kmx = pkModule.agree.has_clicked.longValue() == 1;
            this.kmr.kmy = pkModule.agree.pk_index.longValue();
            this.kmr.kmz = pkModule.agree.pk_icon_after;
            this.kms = new a();
            this.kms.kmt = pkModule.disagree.pk_num.longValue();
            this.kms.kmu = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.kms.kmv = pkModule.disagree.last_username;
            this.kms.kmw = pkModule.disagree.pk_icon;
            this.kms.kmx = pkModule.disagree.has_clicked.longValue() == 1;
            this.kms.kmy = pkModule.disagree.pk_index.longValue();
            this.kms.kmz = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public long kmt;
        public String kmu;
        public String kmv;
        public String kmw;
        public boolean kmx;
        public long kmy;
        public String kmz;

        public a() {
        }
    }
}
