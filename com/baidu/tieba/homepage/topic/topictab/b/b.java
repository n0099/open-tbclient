package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes16.dex */
public class b {
    public int from;
    public a iFJ;
    public a iFK;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.iFJ = new a();
            this.iFJ.iFL = pkModule.agree.pk_num.longValue();
            this.iFJ.iFM = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.iFJ.iFN = pkModule.agree.last_username;
            this.iFJ.iFO = pkModule.agree.pk_icon;
            this.iFJ.iFP = pkModule.agree.has_clicked.longValue() == 1;
            this.iFJ.iFQ = pkModule.agree.pk_index.longValue();
            this.iFJ.iFR = pkModule.agree.pk_icon_after;
            this.iFK = new a();
            this.iFK.iFL = pkModule.disagree.pk_num.longValue();
            this.iFK.iFM = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.iFK.iFN = pkModule.disagree.last_username;
            this.iFK.iFO = pkModule.disagree.pk_icon;
            this.iFK.iFP = pkModule.disagree.has_clicked.longValue() == 1;
            this.iFK.iFQ = pkModule.disagree.pk_index.longValue();
            this.iFK.iFR = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.iFJ = new a();
            this.iFJ.iFL = pkModule.agree.pk_num.longValue();
            this.iFJ.iFM = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.iFJ.iFN = pkModule.agree.last_username;
            this.iFJ.iFO = pkModule.agree.pk_icon;
            this.iFJ.iFP = pkModule.agree.has_clicked.longValue() == 1;
            this.iFJ.iFQ = pkModule.agree.pk_index.longValue();
            this.iFJ.iFR = pkModule.agree.pk_icon_after;
            this.iFK = new a();
            this.iFK.iFL = pkModule.disagree.pk_num.longValue();
            this.iFK.iFM = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.iFK.iFN = pkModule.disagree.last_username;
            this.iFK.iFO = pkModule.disagree.pk_icon;
            this.iFK.iFP = pkModule.disagree.has_clicked.longValue() == 1;
            this.iFK.iFQ = pkModule.disagree.pk_index.longValue();
            this.iFK.iFR = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.iFJ = new a();
            this.iFJ.iFL = pkModule.agree.pk_num.longValue();
            this.iFJ.iFM = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.iFJ.iFN = pkModule.agree.last_username;
            this.iFJ.iFO = pkModule.agree.pk_icon;
            this.iFJ.iFP = pkModule.agree.has_clicked.longValue() == 1;
            this.iFJ.iFQ = pkModule.agree.pk_index.longValue();
            this.iFJ.iFR = pkModule.agree.pk_icon_after;
            this.iFK = new a();
            this.iFK.iFL = pkModule.disagree.pk_num.longValue();
            this.iFK.iFM = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.iFK.iFN = pkModule.disagree.last_username;
            this.iFK.iFO = pkModule.disagree.pk_icon;
            this.iFK.iFP = pkModule.disagree.has_clicked.longValue() == 1;
            this.iFK.iFQ = pkModule.disagree.pk_index.longValue();
            this.iFK.iFR = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes16.dex */
    public class a {
        public long iFL;
        public String iFM;
        public String iFN;
        public String iFO;
        public boolean iFP;
        public long iFQ;
        public String iFR;

        public a() {
        }
    }
}
