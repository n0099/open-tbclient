package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes2.dex */
public class b {
    public int from;
    public a kpT;
    public a kpU;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.kpT = new a();
            this.kpT.kpV = pkModule.agree.pk_num.longValue();
            this.kpT.kpW = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.kpT.kpX = pkModule.agree.last_username;
            this.kpT.kpY = pkModule.agree.pk_icon;
            this.kpT.kpZ = pkModule.agree.has_clicked.longValue() == 1;
            this.kpT.kqa = pkModule.agree.pk_index.longValue();
            this.kpT.kqb = pkModule.agree.pk_icon_after;
            this.kpU = new a();
            this.kpU.kpV = pkModule.disagree.pk_num.longValue();
            this.kpU.kpW = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.kpU.kpX = pkModule.disagree.last_username;
            this.kpU.kpY = pkModule.disagree.pk_icon;
            this.kpU.kpZ = pkModule.disagree.has_clicked.longValue() == 1;
            this.kpU.kqa = pkModule.disagree.pk_index.longValue();
            this.kpU.kqb = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.kpT = new a();
            this.kpT.kpV = pkModule.agree.pk_num.longValue();
            this.kpT.kpW = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.kpT.kpX = pkModule.agree.last_username;
            this.kpT.kpY = pkModule.agree.pk_icon;
            this.kpT.kpZ = pkModule.agree.has_clicked.longValue() == 1;
            this.kpT.kqa = pkModule.agree.pk_index.longValue();
            this.kpT.kqb = pkModule.agree.pk_icon_after;
            this.kpU = new a();
            this.kpU.kpV = pkModule.disagree.pk_num.longValue();
            this.kpU.kpW = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.kpU.kpX = pkModule.disagree.last_username;
            this.kpU.kpY = pkModule.disagree.pk_icon;
            this.kpU.kpZ = pkModule.disagree.has_clicked.longValue() == 1;
            this.kpU.kqa = pkModule.disagree.pk_index.longValue();
            this.kpU.kqb = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.kpT = new a();
            this.kpT.kpV = pkModule.agree.pk_num.longValue();
            this.kpT.kpW = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.kpT.kpX = pkModule.agree.last_username;
            this.kpT.kpY = pkModule.agree.pk_icon;
            this.kpT.kpZ = pkModule.agree.has_clicked.longValue() == 1;
            this.kpT.kqa = pkModule.agree.pk_index.longValue();
            this.kpT.kqb = pkModule.agree.pk_icon_after;
            this.kpU = new a();
            this.kpU.kpV = pkModule.disagree.pk_num.longValue();
            this.kpU.kpW = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.kpU.kpX = pkModule.disagree.last_username;
            this.kpU.kpY = pkModule.disagree.pk_icon;
            this.kpU.kpZ = pkModule.disagree.has_clicked.longValue() == 1;
            this.kpU.kqa = pkModule.disagree.pk_index.longValue();
            this.kpU.kqb = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public long kpV;
        public String kpW;
        public String kpX;
        public String kpY;
        public boolean kpZ;
        public long kqa;
        public String kqb;

        public a() {
        }
    }
}
