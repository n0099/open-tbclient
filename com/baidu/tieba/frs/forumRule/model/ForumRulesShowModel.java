package com.baidu.tieba.frs.forumRule.model;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.data.ForumRuleBaseData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import com.baidu.tieba.frs.forumRule.a.a;
import com.baidu.tieba.frs.forumRule.b.b;
import com.baidu.tieba.frs.forumRule.b.c;
import com.baidu.tieba.frs.forumRule.message.ForumRuleDetailHttpResMsg;
import com.baidu.tieba.frs.forumRule.message.ForumRuleDetailReqMsg;
import com.baidu.tieba.frs.forumRule.message.ForumRuleDetailScoketResMsg;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import tbclient.BawuRoleInfoPub;
import tbclient.ForumInfo;
import tbclient.ForumRule;
import tbclient.PbContent;
/* loaded from: classes2.dex */
public class ForumRulesShowModel extends BdBaseModel<ForumRulesShowActivity> {
    private int aWx;
    private a.InterfaceC0725a joW;
    private String jpV;
    private b jpW;
    private ForumRuleBaseData jpX;
    private com.baidu.adp.framework.listener.a jpY;
    private ForumRulesShowActivity jpo;
    private String mForumId;
    private String mForumName;
    private String mFrom;

    public ForumRulesShowModel(ForumRulesShowActivity forumRulesShowActivity) {
        super(forumRulesShowActivity.getPageContext());
        this.jpW = null;
        this.jpX = null;
        this.jpY = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FORUM_RULES_SHOW, 309690) { // from class: com.baidu.tieba.frs.forumRule.model.ForumRulesShowModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                    if (ForumRulesShowModel.this.joW != null) {
                        ForumRulesShowModel.this.joW.bBP();
                    }
                } else if (ForumRulesShowModel.this.getUniqueId() != responsedMessage.getOrginalMessage().getTag()) {
                    if (ForumRulesShowModel.this.joW != null) {
                        ForumRulesShowModel.this.joW.bBP();
                    }
                } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (ForumRulesShowModel.this.joW != null) {
                        ForumRulesShowModel.this.joW.bBP();
                    }
                } else {
                    if (responsedMessage instanceof ForumRuleDetailHttpResMsg) {
                        ForumRulesShowModel.this.jpW = ((ForumRuleDetailHttpResMsg) responsedMessage).getmForumRuleDetailData();
                    } else if (responsedMessage instanceof ForumRuleDetailScoketResMsg) {
                        ForumRulesShowModel.this.jpW = ((ForumRuleDetailScoketResMsg) responsedMessage).getmForumRuleDetailData();
                    }
                    if (ForumRulesShowModel.this.jpW != null && ForumRulesShowModel.this.joW != null) {
                        ForumRulesShowModel.this.joW.t(ForumRulesShowModel.this.jpW.cFN() == 2, ForumRulesShowModel.this.jpW.cFO());
                        ForumRulesShowModel.this.joW.JI(ForumRulesShowModel.this.jpW.getTitle());
                        ForumRulesShowModel.this.joW.a(ForumRulesShowModel.this.jpW);
                        ForumRulesShowModel.this.cFZ();
                        ForumRulesShowModel.this.joW.a(ForumRulesShowModel.this.jpW.cFS());
                        ForumRulesShowModel.this.joW.finish();
                    }
                }
            }
        };
        this.jpo = forumRulesShowActivity;
        bim();
        initListener();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void ao(Bundle bundle) {
        setUniqueId(getUniqueId());
        if (bundle == null && this.jpo != null) {
            initWithIntent(this.jpo.getIntent());
        } else {
            initWithBundle(bundle);
        }
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFrom = intent.getStringExtra("from");
            this.mForumName = intent.getStringExtra("forum_name");
            this.jpV = intent.getStringExtra("url");
            this.aWx = intent.getIntExtra(IntentConfig.USER_LEVEL, 1);
            this.jpo.setFrom(this.mFrom);
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mFrom)) {
                this.jpX = (ForumRuleBaseData) intent.getSerializableExtra("datas");
                cFX();
                return;
            }
            cFY();
        }
    }

    private void cFX() {
        if (this.jpX != null) {
            this.joW.t(false, "");
            this.joW.JI(this.jpX.getTitle());
            b bVar = new b();
            BawuRoleInfoPub.Builder builder = new BawuRoleInfoPub.Builder();
            builder.portrait = TbadkCoreApplication.getCurrentPortrait();
            builder.name_show = TbadkApplication.getCurrentAccountNameShow();
            builder.user_level = Integer.valueOf(this.aWx);
            bVar.b(builder.build(true));
            ForumInfo.Builder builder2 = new ForumInfo.Builder();
            builder2.forum_name = this.mForumName;
            bVar.a(builder2.build(true));
            bVar.qY(false);
            bVar.setPreface(this.jpX.getPreface());
            this.joW.a(bVar);
            cFZ();
            com.baidu.tieba.frs.forumRule.b.a aVar = new com.baidu.tieba.frs.forumRule.b.a();
            aVar.zR(this.mForumName);
            aVar.setAvatar(this.jpV);
            aVar.setName_show(TbadkApplication.getCurrentAccountNameShow());
            aVar.setPortrait(TbadkApplication.getCurrentPortrait());
            this.joW.a(aVar);
            this.joW.finish();
        }
    }

    public void initWithBundle(Bundle bundle) {
    }

    public void cFY() {
        super.sendMessage(JQ(this.mForumId));
    }

    private ForumRuleDetailReqMsg JQ(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        ForumRuleDetailReqMsg forumRuleDetailReqMsg = new ForumRuleDetailReqMsg();
        forumRuleDetailReqMsg.setForumRuleId(Long.valueOf(Long.parseLong(str)));
        return forumRuleDetailReqMsg;
    }

    private void initListener() {
        registerListener(this.jpY);
    }

    private void bim() {
        com.baidu.tieba.tbadkCore.a.a.a(309690, ForumRuleDetailScoketResMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FORUM_RULES_SHOW, com.baidu.tieba.tbadkCore.a.a.bU(TbConfig.FORUM_RULES_SHOW, 309690));
        tbHttpMessageTask.setResponsedClass(ForumRuleDetailHttpResMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFZ() {
        ArrayList arrayList = new ArrayList();
        dx(arrayList);
        if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mFrom) && this.jpX != null) {
            List<ForumRuleBaseData.ForumRuleItemData> list = this.jpX.getList();
            if (list != null && list.size() > 0) {
                for (ForumRuleBaseData.ForumRuleItemData forumRuleItemData : list) {
                    arrayList.add(a(forumRuleItemData));
                }
            }
        } else {
            List<ForumRule> cFM = this.jpW.cFM();
            if (cFM != null && cFM.size() > 0) {
                for (ForumRule forumRule : cFM) {
                    c cVar = new c();
                    cVar.a(forumRule);
                    arrayList.add(cVar);
                }
            }
        }
        this.joW.du(arrayList);
    }

    private c a(ForumRuleBaseData.ForumRuleItemData forumRuleItemData) {
        if (forumRuleItemData != null) {
            c cVar = new c();
            cVar.JO(forumRuleItemData.getTitle());
            cVar.dv(JR(forumRuleItemData.getContent()));
            cVar.qZ(false);
            return cVar;
        }
        return null;
    }

    private List<PbContent> JR(String str) {
        String substring;
        ArrayList arrayList = new ArrayList();
        while (true) {
            if ("".equals(str)) {
                break;
            }
            int indexOf = str.indexOf("#(url");
            if (indexOf == 0) {
                int indexOf2 = str.indexOf(")", indexOf);
                l(arrayList, str.substring(0, indexOf2 + 1));
                substring = str.substring(indexOf2 + 1, str.length());
            } else if (indexOf == -1) {
                String substring2 = str.substring(0, str.length());
                PbContent.Builder builder = new PbContent.Builder();
                builder.text = substring2;
                builder.type = 0;
                arrayList.add(builder.build(true));
                break;
            } else {
                String substring3 = str.substring(0, indexOf);
                PbContent.Builder builder2 = new PbContent.Builder();
                builder2.text = substring3;
                builder2.type = 0;
                arrayList.add(builder2.build(true));
                substring = str.substring(indexOf, str.length());
            }
            str = substring;
        }
        return arrayList;
    }

    private void l(List<PbContent> list, String str) {
        String[] split = str.split(",");
        PbContent.Builder builder = new PbContent.Builder();
        builder.type = 1;
        builder.link = URLDecoder.decode(split[2]);
        builder.text = URLDecoder.decode(split[3].substring(0, split[3].length() - 1));
        list.add(builder.build(true));
    }

    private void dx(List<c> list) {
        c cVar = new c();
        cVar.JO(zn(R.string.forum_rule_defalt_one_title));
        cVar.dv(zm(R.string.forum_rule_defalt_one_content));
        cVar.qZ(false);
        list.add(cVar);
        c cVar2 = new c();
        cVar2.JO(zn(R.string.forum_rule_defalt_two_title));
        cVar2.dv(zm(R.string.forum_rule_defalt_two_content));
        cVar2.qZ(false);
        list.add(cVar2);
        c cVar3 = new c();
        cVar3.JO(zn(R.string.forum_rule_defalt_three_title));
        cVar3.dv(zm(R.string.forum_rule_defalt_three_content));
        cVar3.qZ(false);
        list.add(cVar3);
        c cVar4 = new c();
        cVar4.JO(zn(R.string.forum_rule_defalt_four_title));
        cVar4.dv(zm(R.string.forum_rule_defalt_four_content));
        cVar4.qZ(false);
        list.add(cVar4);
    }

    private List<PbContent> zm(int i) {
        ArrayList arrayList = new ArrayList();
        PbContent.Builder builder = new PbContent.Builder();
        builder.text = zn(i);
        arrayList.add(builder.build(true));
        return arrayList;
    }

    private String zn(int i) {
        return TbadkApplication.getInst().getResources().getString(i);
    }

    public void a(a.InterfaceC0725a interfaceC0725a) {
        this.joW = interfaceC0725a;
    }

    public void destory() {
        this.jpo = null;
        MessageManager.getInstance().unRegisterListener(this.jpY);
    }
}
