package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import tbclient.NewTopicList.PkModule;
/* loaded from: classes4.dex */
public class b {
    public a fPF;
    public a fPG;
    public int from;
    public long pkId;
    public long topicId;
    public long userPkId;

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.fPF = new a();
            this.fPF.fPH = pkModule.agree.pk_num.longValue();
            this.fPF.fPI = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(d.j.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.fPF.fPJ = pkModule.agree.last_username;
            this.fPF.fPK = pkModule.agree.pk_icon;
            this.fPF.fPL = pkModule.agree.has_clicked.longValue() == 1;
            this.fPF.fPM = pkModule.agree.pk_index.longValue();
            this.fPF.fPN = pkModule.agree.pk_icon_after;
            this.fPG = new a();
            this.fPG.fPH = pkModule.disagree.pk_num.longValue();
            this.fPG.fPI = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(d.j.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.fPG.fPJ = pkModule.disagree.last_username;
            this.fPG.fPK = pkModule.disagree.pk_icon;
            this.fPG.fPL = pkModule.disagree.has_clicked.longValue() == 1;
            this.fPG.fPM = pkModule.disagree.pk_index.longValue();
            this.fPG.fPN = pkModule.disagree.pk_icon_after;
        }
    }

    public void b(tbclient.NewHottopic.PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.pkId = pkModule.pk_id.longValue();
            this.userPkId = pkModule.user_pk_id.longValue();
            this.fPF = new a();
            this.fPF.fPH = pkModule.agree.pk_num.longValue();
            this.fPF.fPI = StringUtils.isNull(pkModule.agree.pk_desc) ? TbadkCoreApplication.getInst().getString(d.j.topic_detail_pk_support) : pkModule.agree.pk_desc;
            this.fPF.fPJ = pkModule.agree.last_username;
            this.fPF.fPK = pkModule.agree.pk_icon;
            this.fPF.fPL = pkModule.agree.has_clicked.longValue() == 1;
            this.fPF.fPM = pkModule.agree.pk_index.longValue();
            this.fPF.fPN = pkModule.agree.pk_icon_after;
            this.fPG = new a();
            this.fPG.fPH = pkModule.disagree.pk_num.longValue();
            this.fPG.fPI = StringUtils.isNull(pkModule.disagree.pk_desc) ? TbadkCoreApplication.getInst().getString(d.j.topic_detail_pk_oppose) : pkModule.disagree.pk_desc;
            this.fPG.fPJ = pkModule.disagree.last_username;
            this.fPG.fPK = pkModule.disagree.pk_icon;
            this.fPG.fPL = pkModule.disagree.has_clicked.longValue() == 1;
            this.fPG.fPM = pkModule.disagree.pk_index.longValue();
            this.fPG.fPN = pkModule.disagree.pk_icon_after;
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public long fPH;
        public String fPI;
        public String fPJ;
        public String fPK;
        public boolean fPL;
        public long fPM;
        public String fPN;

        public a() {
        }
    }
}
