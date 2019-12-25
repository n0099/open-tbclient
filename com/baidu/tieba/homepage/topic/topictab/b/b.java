package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes6.dex */
public class b {
    public int from;
    public a hbV;
    public a hbW;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.hbV = new a();
            this.hbV.hbX = pkModule.agree.pk_num.longValue();
            this.hbV.hbY = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.hbV.hbZ = pkModule.agree.last_username;
            this.hbV.hca = pkModule.agree.pk_icon;
            this.hbV.hcb = pkModule.agree.has_clicked.longValue() == 1;
            this.hbV.hcc = pkModule.agree.pk_index.longValue();
            this.hbV.hcd = pkModule.agree.pk_icon_after;
            this.hbW = new a();
            this.hbW.hbX = pkModule.disagree.pk_num.longValue();
            this.hbW.hbY = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.hbW.hbZ = pkModule.disagree.last_username;
            this.hbW.hca = pkModule.disagree.pk_icon;
            this.hbW.hcb = pkModule.disagree.has_clicked.longValue() == 1;
            this.hbW.hcc = pkModule.disagree.pk_index.longValue();
            this.hbW.hcd = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.hbV = new a();
            this.hbV.hbX = pkModule.agree.pk_num.longValue();
            this.hbV.hbY = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.hbV.hbZ = pkModule.agree.last_username;
            this.hbV.hca = pkModule.agree.pk_icon;
            this.hbV.hcb = pkModule.agree.has_clicked.longValue() == 1;
            this.hbV.hcc = pkModule.agree.pk_index.longValue();
            this.hbV.hcd = pkModule.agree.pk_icon_after;
            this.hbW = new a();
            this.hbW.hbX = pkModule.disagree.pk_num.longValue();
            this.hbW.hbY = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.hbW.hbZ = pkModule.disagree.last_username;
            this.hbW.hca = pkModule.disagree.pk_icon;
            this.hbW.hcb = pkModule.disagree.has_clicked.longValue() == 1;
            this.hbW.hcc = pkModule.disagree.pk_index.longValue();
            this.hbW.hcd = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.hbV = new a();
            this.hbV.hbX = pkModule.agree.pk_num.longValue();
            this.hbV.hbY = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.hbV.hbZ = pkModule.agree.last_username;
            this.hbV.hca = pkModule.agree.pk_icon;
            this.hbV.hcb = pkModule.agree.has_clicked.longValue() == 1;
            this.hbV.hcc = pkModule.agree.pk_index.longValue();
            this.hbV.hcd = pkModule.agree.pk_icon_after;
            this.hbW = new a();
            this.hbW.hbX = pkModule.disagree.pk_num.longValue();
            this.hbW.hbY = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.hbW.hbZ = pkModule.disagree.last_username;
            this.hbW.hca = pkModule.disagree.pk_icon;
            this.hbW.hcb = pkModule.disagree.has_clicked.longValue() == 1;
            this.hbW.hcc = pkModule.disagree.pk_index.longValue();
            this.hbW.hcd = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes6.dex */
    public class a {
        public long hbX;
        public String hbY;
        public String hbZ;
        public String hca;
        public boolean hcb;
        public long hcc;
        public String hcd;

        public a() {
        }
    }
}
