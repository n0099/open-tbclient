package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes16.dex */
public class b {
    public int from;
    public a iFH;
    public a iFI;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.iFH = new a();
            this.iFH.iFJ = pkModule.agree.pk_num.longValue();
            this.iFH.iFK = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.iFH.iFL = pkModule.agree.last_username;
            this.iFH.iFM = pkModule.agree.pk_icon;
            this.iFH.iFN = pkModule.agree.has_clicked.longValue() == 1;
            this.iFH.iFO = pkModule.agree.pk_index.longValue();
            this.iFH.iFP = pkModule.agree.pk_icon_after;
            this.iFI = new a();
            this.iFI.iFJ = pkModule.disagree.pk_num.longValue();
            this.iFI.iFK = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.iFI.iFL = pkModule.disagree.last_username;
            this.iFI.iFM = pkModule.disagree.pk_icon;
            this.iFI.iFN = pkModule.disagree.has_clicked.longValue() == 1;
            this.iFI.iFO = pkModule.disagree.pk_index.longValue();
            this.iFI.iFP = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.iFH = new a();
            this.iFH.iFJ = pkModule.agree.pk_num.longValue();
            this.iFH.iFK = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.iFH.iFL = pkModule.agree.last_username;
            this.iFH.iFM = pkModule.agree.pk_icon;
            this.iFH.iFN = pkModule.agree.has_clicked.longValue() == 1;
            this.iFH.iFO = pkModule.agree.pk_index.longValue();
            this.iFH.iFP = pkModule.agree.pk_icon_after;
            this.iFI = new a();
            this.iFI.iFJ = pkModule.disagree.pk_num.longValue();
            this.iFI.iFK = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.iFI.iFL = pkModule.disagree.last_username;
            this.iFI.iFM = pkModule.disagree.pk_icon;
            this.iFI.iFN = pkModule.disagree.has_clicked.longValue() == 1;
            this.iFI.iFO = pkModule.disagree.pk_index.longValue();
            this.iFI.iFP = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.iFH = new a();
            this.iFH.iFJ = pkModule.agree.pk_num.longValue();
            this.iFH.iFK = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.iFH.iFL = pkModule.agree.last_username;
            this.iFH.iFM = pkModule.agree.pk_icon;
            this.iFH.iFN = pkModule.agree.has_clicked.longValue() == 1;
            this.iFH.iFO = pkModule.agree.pk_index.longValue();
            this.iFH.iFP = pkModule.agree.pk_icon_after;
            this.iFI = new a();
            this.iFI.iFJ = pkModule.disagree.pk_num.longValue();
            this.iFI.iFK = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.iFI.iFL = pkModule.disagree.last_username;
            this.iFI.iFM = pkModule.disagree.pk_icon;
            this.iFI.iFN = pkModule.disagree.has_clicked.longValue() == 1;
            this.iFI.iFO = pkModule.disagree.pk_index.longValue();
            this.iFI.iFP = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes16.dex */
    public class a {
        public long iFJ;
        public String iFK;
        public String iFL;
        public String iFM;
        public boolean iFN;
        public long iFO;
        public String iFP;

        public a() {
        }
    }
}
