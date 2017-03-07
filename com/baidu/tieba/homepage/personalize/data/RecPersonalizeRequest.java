package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.n;
import java.util.List;
import tbclient.Personalized.DataReq;
import tbclient.Personalized.PersonalizedReqIdl;
/* loaded from: classes.dex */
public class RecPersonalizeRequest extends NetMessage {
    private static final int DEFAULT_RECOMMEND_PERSONAL_TAG_CODE = 0;
    public static final int LOAD_TYPE_MORE = 2;
    public static final int LOAD_TYPE_UPDATE = 1;
    private static final int SUGGREST_COUNT = 0;
    private String ageTag;
    private List<String> interestGuideTag;
    private int loadType;
    private boolean needTag;
    private int pn;
    private int requestTagCode;
    private String sexTag;
    private int suggestCount;
    private int tagCode;
    private int tagType;
    private int threadCount;

    public RecPersonalizeRequest() {
        super(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
    }

    public void setNeedTag(boolean z) {
        this.needTag = z;
    }

    public void setRequestTagCode(int i) {
        this.requestTagCode = i;
    }

    public int getRequestTagCode() {
        return this.requestTagCode;
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

    public void setTagCode(int i) {
        this.tagCode = i;
    }

    public void setSexTag(String str) {
        this.sexTag = str;
    }

    public void seAgeTag(String str) {
        this.ageTag = str;
    }

    public void setInterestGuideTag(List<String> list) {
        this.interestGuideTag = list;
    }

    public void setTagType(int i) {
        this.tagType = i;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        int i = 1;
        DataReq.Builder builder = new DataReq.Builder();
        n.bindCommonParamsToProtobufData(builder, true, false, true);
        builder.need_tags = Integer.valueOf(this.needTag ? 1 : 0);
        builder.load_type = Integer.valueOf(this.loadType);
        builder.page_thread_count = Integer.valueOf(this.threadCount);
        builder.pn = Integer.valueOf(this.pn);
        builder.sug_count = Integer.valueOf(this.suggestCount);
        builder.tag_code = Integer.valueOf(this.tagCode);
        builder.scr_w = Integer.valueOf(k.ag(TbadkCoreApplication.m9getInst()));
        builder.scr_h = Integer.valueOf(k.ah(TbadkCoreApplication.m9getInst()));
        builder.scr_dip = Double.valueOf(k.ai(TbadkCoreApplication.m9getInst()));
        builder.q_type = 1;
        if (TbadkCoreApplication.getCurrentAccount() != null || com.baidu.tbadk.core.sharedPref.b.uo().getBoolean("has_requested_new_user_guide", false)) {
            i = 0;
        }
        builder.need_age_module = Integer.valueOf(i);
        builder.tag_changed = Integer.valueOf(this.tagType);
        builder.sex_tag = this.sexTag;
        builder.age_tag = this.ageTag;
        builder.interest_tag = this.interestGuideTag;
        PersonalizedReqIdl.Builder builder2 = new PersonalizedReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
