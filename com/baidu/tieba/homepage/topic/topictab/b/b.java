package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes4.dex */
public class b {
    public int from;
    public a ggQ;
    public a ggR;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.ggQ = new a();
            this.ggQ.ggS = pkModule.agree.pk_num.longValue();
            this.ggQ.ggT = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.ggQ.ggU = pkModule.agree.last_username;
            this.ggQ.ggV = pkModule.agree.pk_icon;
            this.ggQ.ggW = pkModule.agree.has_clicked.longValue() == 1;
            this.ggQ.ggX = pkModule.agree.pk_index.longValue();
            this.ggQ.ggY = pkModule.agree.pk_icon_after;
            this.ggR = new a();
            this.ggR.ggS = pkModule.disagree.pk_num.longValue();
            this.ggR.ggT = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.ggR.ggU = pkModule.disagree.last_username;
            this.ggR.ggV = pkModule.disagree.pk_icon;
            this.ggR.ggW = pkModule.disagree.has_clicked.longValue() == 1;
            this.ggR.ggX = pkModule.disagree.pk_index.longValue();
            this.ggR.ggY = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.ggQ = new a();
            this.ggQ.ggS = pkModule.agree.pk_num.longValue();
            this.ggQ.ggT = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.ggQ.ggU = pkModule.agree.last_username;
            this.ggQ.ggV = pkModule.agree.pk_icon;
            this.ggQ.ggW = pkModule.agree.has_clicked.longValue() == 1;
            this.ggQ.ggX = pkModule.agree.pk_index.longValue();
            this.ggQ.ggY = pkModule.agree.pk_icon_after;
            this.ggR = new a();
            this.ggR.ggS = pkModule.disagree.pk_num.longValue();
            this.ggR.ggT = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.ggR.ggU = pkModule.disagree.last_username;
            this.ggR.ggV = pkModule.disagree.pk_icon;
            this.ggR.ggW = pkModule.disagree.has_clicked.longValue() == 1;
            this.ggR.ggX = pkModule.disagree.pk_index.longValue();
            this.ggR.ggY = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.ggQ = new a();
            this.ggQ.ggS = pkModule.agree.pk_num.longValue();
            this.ggQ.ggT = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.ggQ.ggU = pkModule.agree.last_username;
            this.ggQ.ggV = pkModule.agree.pk_icon;
            this.ggQ.ggW = pkModule.agree.has_clicked.longValue() == 1;
            this.ggQ.ggX = pkModule.agree.pk_index.longValue();
            this.ggQ.ggY = pkModule.agree.pk_icon_after;
            this.ggR = new a();
            this.ggR.ggS = pkModule.disagree.pk_num.longValue();
            this.ggR.ggT = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.ggR.ggU = pkModule.disagree.last_username;
            this.ggR.ggV = pkModule.disagree.pk_icon;
            this.ggR.ggW = pkModule.disagree.has_clicked.longValue() == 1;
            this.ggR.ggX = pkModule.disagree.pk_index.longValue();
            this.ggR.ggY = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public long ggS;
        public String ggT;
        public String ggU;
        public String ggV;
        public boolean ggW;
        public long ggX;
        public String ggY;

        public a() {
        }
    }
}
