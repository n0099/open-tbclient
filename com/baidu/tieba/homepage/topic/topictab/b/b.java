package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes2.dex */
public class b {
    public int from;
    public a khL;
    public a khM;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.khL = new a();
            this.khL.khN = pkModule.agree.pk_num.longValue();
            this.khL.khO = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.khL.khP = pkModule.agree.last_username;
            this.khL.khQ = pkModule.agree.pk_icon;
            this.khL.khR = pkModule.agree.has_clicked.longValue() == 1;
            this.khL.khS = pkModule.agree.pk_index.longValue();
            this.khL.khT = pkModule.agree.pk_icon_after;
            this.khM = new a();
            this.khM.khN = pkModule.disagree.pk_num.longValue();
            this.khM.khO = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.khM.khP = pkModule.disagree.last_username;
            this.khM.khQ = pkModule.disagree.pk_icon;
            this.khM.khR = pkModule.disagree.has_clicked.longValue() == 1;
            this.khM.khS = pkModule.disagree.pk_index.longValue();
            this.khM.khT = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.khL = new a();
            this.khL.khN = pkModule.agree.pk_num.longValue();
            this.khL.khO = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.khL.khP = pkModule.agree.last_username;
            this.khL.khQ = pkModule.agree.pk_icon;
            this.khL.khR = pkModule.agree.has_clicked.longValue() == 1;
            this.khL.khS = pkModule.agree.pk_index.longValue();
            this.khL.khT = pkModule.agree.pk_icon_after;
            this.khM = new a();
            this.khM.khN = pkModule.disagree.pk_num.longValue();
            this.khM.khO = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.khM.khP = pkModule.disagree.last_username;
            this.khM.khQ = pkModule.disagree.pk_icon;
            this.khM.khR = pkModule.disagree.has_clicked.longValue() == 1;
            this.khM.khS = pkModule.disagree.pk_index.longValue();
            this.khM.khT = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.khL = new a();
            this.khL.khN = pkModule.agree.pk_num.longValue();
            this.khL.khO = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.khL.khP = pkModule.agree.last_username;
            this.khL.khQ = pkModule.agree.pk_icon;
            this.khL.khR = pkModule.agree.has_clicked.longValue() == 1;
            this.khL.khS = pkModule.agree.pk_index.longValue();
            this.khL.khT = pkModule.agree.pk_icon_after;
            this.khM = new a();
            this.khM.khN = pkModule.disagree.pk_num.longValue();
            this.khM.khO = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.khM.khP = pkModule.disagree.last_username;
            this.khM.khQ = pkModule.disagree.pk_icon;
            this.khM.khR = pkModule.disagree.has_clicked.longValue() == 1;
            this.khM.khS = pkModule.disagree.pk_index.longValue();
            this.khM.khT = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public long khN;
        public String khO;
        public String khP;
        public String khQ;
        public boolean khR;
        public long khS;
        public String khT;

        public a() {
        }
    }
}
