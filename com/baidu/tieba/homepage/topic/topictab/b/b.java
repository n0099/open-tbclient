package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes4.dex */
public class b {
    public int from;
    public a ggN;
    public a ggO;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.ggN = new a();
            this.ggN.ggP = pkModule.agree.pk_num.longValue();
            this.ggN.ggQ = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.ggN.ggR = pkModule.agree.last_username;
            this.ggN.ggS = pkModule.agree.pk_icon;
            this.ggN.ggT = pkModule.agree.has_clicked.longValue() == 1;
            this.ggN.ggU = pkModule.agree.pk_index.longValue();
            this.ggN.ggV = pkModule.agree.pk_icon_after;
            this.ggO = new a();
            this.ggO.ggP = pkModule.disagree.pk_num.longValue();
            this.ggO.ggQ = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.ggO.ggR = pkModule.disagree.last_username;
            this.ggO.ggS = pkModule.disagree.pk_icon;
            this.ggO.ggT = pkModule.disagree.has_clicked.longValue() == 1;
            this.ggO.ggU = pkModule.disagree.pk_index.longValue();
            this.ggO.ggV = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.ggN = new a();
            this.ggN.ggP = pkModule.agree.pk_num.longValue();
            this.ggN.ggQ = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.ggN.ggR = pkModule.agree.last_username;
            this.ggN.ggS = pkModule.agree.pk_icon;
            this.ggN.ggT = pkModule.agree.has_clicked.longValue() == 1;
            this.ggN.ggU = pkModule.agree.pk_index.longValue();
            this.ggN.ggV = pkModule.agree.pk_icon_after;
            this.ggO = new a();
            this.ggO.ggP = pkModule.disagree.pk_num.longValue();
            this.ggO.ggQ = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.ggO.ggR = pkModule.disagree.last_username;
            this.ggO.ggS = pkModule.disagree.pk_icon;
            this.ggO.ggT = pkModule.disagree.has_clicked.longValue() == 1;
            this.ggO.ggU = pkModule.disagree.pk_index.longValue();
            this.ggO.ggV = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.ggN = new a();
            this.ggN.ggP = pkModule.agree.pk_num.longValue();
            this.ggN.ggQ = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.ggN.ggR = pkModule.agree.last_username;
            this.ggN.ggS = pkModule.agree.pk_icon;
            this.ggN.ggT = pkModule.agree.has_clicked.longValue() == 1;
            this.ggN.ggU = pkModule.agree.pk_index.longValue();
            this.ggN.ggV = pkModule.agree.pk_icon_after;
            this.ggO = new a();
            this.ggO.ggP = pkModule.disagree.pk_num.longValue();
            this.ggO.ggQ = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.ggO.ggR = pkModule.disagree.last_username;
            this.ggO.ggS = pkModule.disagree.pk_icon;
            this.ggO.ggT = pkModule.disagree.has_clicked.longValue() == 1;
            this.ggO.ggU = pkModule.disagree.pk_index.longValue();
            this.ggO.ggV = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public long ggP;
        public String ggQ;
        public String ggR;
        public String ggS;
        public boolean ggT;
        public long ggU;
        public String ggV;

        public a() {
        }
    }
}
