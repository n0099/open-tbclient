package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.o;
import tbclient.Personalized.DataReq;
import tbclient.Personalized.PersonalizedReqIdl;
/* loaded from: classes.dex */
public class RecPersonalizeRequest extends NetMessage {
    private int loadType;
    private int needForumlist;
    private int pn;
    private int suggestCount;
    private int threadCount;

    public RecPersonalizeRequest() {
        super(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
    }

    public void setLoadType(int i) {
        this.loadType = i;
    }

    public int getLoadType() {
        return this.loadType;
    }

    public void setThreadCount(int i) {
        if (i > 0) {
            this.threadCount = i;
        } else {
            this.threadCount = 0;
        }
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public void setSuggestCount(int i) {
        this.suggestCount = i;
    }

    public void setNeedForumlist(int i) {
        if (i != 1) {
            this.needForumlist = 0;
        } else {
            this.needForumlist = i;
        }
    }

    public int getNeedForumlist() {
        return this.needForumlist;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        int i = 1;
        DataReq.Builder builder = new DataReq.Builder();
        o.bindCommonParamsToProtobufData(builder, true, false, true);
        builder.need_tags = 0;
        builder.load_type = Integer.valueOf(this.loadType);
        builder.page_thread_count = Integer.valueOf(this.threadCount);
        builder.pn = Integer.valueOf(this.pn);
        builder.sug_count = Integer.valueOf(this.suggestCount);
        builder.tag_code = 0;
        builder.scr_w = Integer.valueOf(l.ac(TbadkCoreApplication.getInst()));
        builder.scr_h = Integer.valueOf(l.ae(TbadkCoreApplication.getInst()));
        builder.scr_dip = Double.valueOf(l.af(TbadkCoreApplication.getInst()));
        builder.q_type = 1;
        if (TbadkCoreApplication.getCurrentAccount() != null || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_requested_new_user_guide", false)) {
            i = 0;
        }
        builder.need_age_module = Integer.valueOf(i);
        builder.tag_changed = 0;
        builder.sex_tag = "";
        builder.age_tag = "";
        builder.need_forumlist = Integer.valueOf(this.needForumlist);
        setNetType(NetMessage.NetType.HTTP);
        PersonalizedReqIdl.Builder builder2 = new PersonalizedReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
