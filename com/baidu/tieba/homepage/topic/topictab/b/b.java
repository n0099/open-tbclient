package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes4.dex */
public class b {
    public int from;
    public a ggO;
    public a ggP;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.ggO = new a();
            this.ggO.ggQ = pkModule.agree.pk_num.longValue();
            this.ggO.ggR = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.ggO.ggS = pkModule.agree.last_username;
            this.ggO.ggT = pkModule.agree.pk_icon;
            this.ggO.ggU = pkModule.agree.has_clicked.longValue() == 1;
            this.ggO.ggV = pkModule.agree.pk_index.longValue();
            this.ggO.ggW = pkModule.agree.pk_icon_after;
            this.ggP = new a();
            this.ggP.ggQ = pkModule.disagree.pk_num.longValue();
            this.ggP.ggR = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.ggP.ggS = pkModule.disagree.last_username;
            this.ggP.ggT = pkModule.disagree.pk_icon;
            this.ggP.ggU = pkModule.disagree.has_clicked.longValue() == 1;
            this.ggP.ggV = pkModule.disagree.pk_index.longValue();
            this.ggP.ggW = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.ggO = new a();
            this.ggO.ggQ = pkModule.agree.pk_num.longValue();
            this.ggO.ggR = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.ggO.ggS = pkModule.agree.last_username;
            this.ggO.ggT = pkModule.agree.pk_icon;
            this.ggO.ggU = pkModule.agree.has_clicked.longValue() == 1;
            this.ggO.ggV = pkModule.agree.pk_index.longValue();
            this.ggO.ggW = pkModule.agree.pk_icon_after;
            this.ggP = new a();
            this.ggP.ggQ = pkModule.disagree.pk_num.longValue();
            this.ggP.ggR = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.ggP.ggS = pkModule.disagree.last_username;
            this.ggP.ggT = pkModule.disagree.pk_icon;
            this.ggP.ggU = pkModule.disagree.has_clicked.longValue() == 1;
            this.ggP.ggV = pkModule.disagree.pk_index.longValue();
            this.ggP.ggW = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.ggO = new a();
            this.ggO.ggQ = pkModule.agree.pk_num.longValue();
            this.ggO.ggR = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.ggO.ggS = pkModule.agree.last_username;
            this.ggO.ggT = pkModule.agree.pk_icon;
            this.ggO.ggU = pkModule.agree.has_clicked.longValue() == 1;
            this.ggO.ggV = pkModule.agree.pk_index.longValue();
            this.ggO.ggW = pkModule.agree.pk_icon_after;
            this.ggP = new a();
            this.ggP.ggQ = pkModule.disagree.pk_num.longValue();
            this.ggP.ggR = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.ggP.ggS = pkModule.disagree.last_username;
            this.ggP.ggT = pkModule.disagree.pk_icon;
            this.ggP.ggU = pkModule.disagree.has_clicked.longValue() == 1;
            this.ggP.ggV = pkModule.disagree.pk_index.longValue();
            this.ggP.ggW = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public long ggQ;
        public String ggR;
        public String ggS;
        public String ggT;
        public boolean ggU;
        public long ggV;
        public String ggW;

        public a() {
        }
    }
}
