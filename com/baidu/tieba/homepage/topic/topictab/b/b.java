package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes9.dex */
public class b {
    public int from;
    public a izD;
    public a izE;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.izD = new a();
            this.izD.izF = pkModule.agree.pk_num.longValue();
            this.izD.izG = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.izD.izH = pkModule.agree.last_username;
            this.izD.izI = pkModule.agree.pk_icon;
            this.izD.izJ = pkModule.agree.has_clicked.longValue() == 1;
            this.izD.izK = pkModule.agree.pk_index.longValue();
            this.izD.izL = pkModule.agree.pk_icon_after;
            this.izE = new a();
            this.izE.izF = pkModule.disagree.pk_num.longValue();
            this.izE.izG = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.izE.izH = pkModule.disagree.last_username;
            this.izE.izI = pkModule.disagree.pk_icon;
            this.izE.izJ = pkModule.disagree.has_clicked.longValue() == 1;
            this.izE.izK = pkModule.disagree.pk_index.longValue();
            this.izE.izL = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.izD = new a();
            this.izD.izF = pkModule.agree.pk_num.longValue();
            this.izD.izG = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.izD.izH = pkModule.agree.last_username;
            this.izD.izI = pkModule.agree.pk_icon;
            this.izD.izJ = pkModule.agree.has_clicked.longValue() == 1;
            this.izD.izK = pkModule.agree.pk_index.longValue();
            this.izD.izL = pkModule.agree.pk_icon_after;
            this.izE = new a();
            this.izE.izF = pkModule.disagree.pk_num.longValue();
            this.izE.izG = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.izE.izH = pkModule.disagree.last_username;
            this.izE.izI = pkModule.disagree.pk_icon;
            this.izE.izJ = pkModule.disagree.has_clicked.longValue() == 1;
            this.izE.izK = pkModule.disagree.pk_index.longValue();
            this.izE.izL = pkModule.disagree.pk_icon_after;
        }
    }

    public void a(tbclient.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.izD = new a();
            this.izD.izF = pkModule.agree.pk_num.longValue();
            this.izD.izG = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.izD.izH = pkModule.agree.last_username;
            this.izD.izI = pkModule.agree.pk_icon;
            this.izD.izJ = pkModule.agree.has_clicked.longValue() == 1;
            this.izD.izK = pkModule.agree.pk_index.longValue();
            this.izD.izL = pkModule.agree.pk_icon_after;
            this.izE = new a();
            this.izE.izF = pkModule.disagree.pk_num.longValue();
            this.izE.izG = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(R.string.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.izE.izH = pkModule.disagree.last_username;
            this.izE.izI = pkModule.disagree.pk_icon;
            this.izE.izJ = pkModule.disagree.has_clicked.longValue() == 1;
            this.izE.izK = pkModule.disagree.pk_index.longValue();
            this.izE.izL = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes9.dex */
    public class a {
        public long izF;
        public String izG;
        public String izH;
        public String izI;
        public boolean izJ;
        public long izK;
        public String izL;

        public a() {
        }
    }
}
