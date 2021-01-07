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
    private int bbl;
    private a.InterfaceC0742a jtC;
    private ForumRulesShowActivity jtU;
    private String juB;
    private b juC;
    private ForumRuleBaseData juD;
    private com.baidu.adp.framework.listener.a juE;
    private String mForumId;
    private String mForumName;
    private String mFrom;

    public ForumRulesShowModel(ForumRulesShowActivity forumRulesShowActivity) {
        super(forumRulesShowActivity.getPageContext());
        this.juC = null;
        this.juD = null;
        this.juE = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FORUM_RULES_SHOW, 309690) { // from class: com.baidu.tieba.frs.forumRule.model.ForumRulesShowModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                    if (ForumRulesShowModel.this.jtC != null) {
                        ForumRulesShowModel.this.jtC.bFI();
                    }
                } else if (ForumRulesShowModel.this.getUniqueId() != responsedMessage.getOrginalMessage().getTag()) {
                    if (ForumRulesShowModel.this.jtC != null) {
                        ForumRulesShowModel.this.jtC.bFI();
                    }
                } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (ForumRulesShowModel.this.jtC != null) {
                        ForumRulesShowModel.this.jtC.bFI();
                    }
                } else {
                    if (responsedMessage instanceof ForumRuleDetailHttpResMsg) {
                        ForumRulesShowModel.this.juC = ((ForumRuleDetailHttpResMsg) responsedMessage).getmForumRuleDetailData();
                    } else if (responsedMessage instanceof ForumRuleDetailScoketResMsg) {
                        ForumRulesShowModel.this.juC = ((ForumRuleDetailScoketResMsg) responsedMessage).getmForumRuleDetailData();
                    }
                    if (ForumRulesShowModel.this.juC != null && ForumRulesShowModel.this.jtC != null) {
                        ForumRulesShowModel.this.jtC.t(ForumRulesShowModel.this.juC.cJF() == 2, ForumRulesShowModel.this.juC.cJG());
                        ForumRulesShowModel.this.jtC.KS(ForumRulesShowModel.this.juC.getTitle());
                        ForumRulesShowModel.this.jtC.a(ForumRulesShowModel.this.juC);
                        ForumRulesShowModel.this.cJR();
                        ForumRulesShowModel.this.jtC.a(ForumRulesShowModel.this.juC.cJK());
                        ForumRulesShowModel.this.jtC.finish();
                    }
                }
            }
        };
        this.jtU = forumRulesShowActivity;
        bmg();
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
        if (bundle == null && this.jtU != null) {
            initWithIntent(this.jtU.getIntent());
        } else {
            initWithBundle(bundle);
        }
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFrom = intent.getStringExtra("from");
            this.mForumName = intent.getStringExtra("forum_name");
            this.juB = intent.getStringExtra("url");
            this.bbl = intent.getIntExtra(IntentConfig.USER_LEVEL, 1);
            this.jtU.setFrom(this.mFrom);
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mFrom)) {
                this.juD = (ForumRuleBaseData) intent.getSerializableExtra("datas");
                cJP();
                return;
            }
            cJQ();
        }
    }

    private void cJP() {
        if (this.juD != null) {
            this.jtC.t(false, "");
            this.jtC.KS(this.juD.getTitle());
            b bVar = new b();
            BawuRoleInfoPub.Builder builder = new BawuRoleInfoPub.Builder();
            builder.portrait = TbadkCoreApplication.getCurrentPortrait();
            builder.name_show = TbadkApplication.getCurrentAccountNameShow();
            builder.user_level = Integer.valueOf(this.bbl);
            bVar.b(builder.build(true));
            ForumInfo.Builder builder2 = new ForumInfo.Builder();
            builder2.forum_name = this.mForumName;
            bVar.a(builder2.build(true));
            bVar.rc(false);
            bVar.setPreface(this.juD.getPreface());
            this.jtC.a(bVar);
            cJR();
            com.baidu.tieba.frs.forumRule.b.a aVar = new com.baidu.tieba.frs.forumRule.b.a();
            aVar.Bc(this.mForumName);
            aVar.setAvatar(this.juB);
            aVar.setName_show(TbadkApplication.getCurrentAccountNameShow());
            aVar.setPortrait(TbadkApplication.getCurrentPortrait());
            this.jtC.a(aVar);
            this.jtC.finish();
        }
    }

    public void initWithBundle(Bundle bundle) {
    }

    public void cJQ() {
        super.sendMessage(La(this.mForumId));
    }

    private ForumRuleDetailReqMsg La(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        ForumRuleDetailReqMsg forumRuleDetailReqMsg = new ForumRuleDetailReqMsg();
        forumRuleDetailReqMsg.setForumRuleId(Long.valueOf(Long.parseLong(str)));
        return forumRuleDetailReqMsg;
    }

    private void initListener() {
        registerListener(this.juE);
    }

    private void bmg() {
        com.baidu.tieba.tbadkCore.a.a.a(309690, ForumRuleDetailScoketResMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FORUM_RULES_SHOW, com.baidu.tieba.tbadkCore.a.a.bU(TbConfig.FORUM_RULES_SHOW, 309690));
        tbHttpMessageTask.setResponsedClass(ForumRuleDetailHttpResMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJR() {
        ArrayList arrayList = new ArrayList();
        dx(arrayList);
        if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mFrom) && this.juD != null) {
            List<ForumRuleBaseData.ForumRuleItemData> list = this.juD.getList();
            if (list != null && list.size() > 0) {
                for (ForumRuleBaseData.ForumRuleItemData forumRuleItemData : list) {
                    arrayList.add(a(forumRuleItemData));
                }
            }
        } else {
            List<ForumRule> cJE = this.juC.cJE();
            if (cJE != null && cJE.size() > 0) {
                for (ForumRule forumRule : cJE) {
                    c cVar = new c();
                    cVar.a(forumRule);
                    arrayList.add(cVar);
                }
            }
        }
        this.jtC.du(arrayList);
    }

    private c a(ForumRuleBaseData.ForumRuleItemData forumRuleItemData) {
        if (forumRuleItemData != null) {
            c cVar = new c();
            cVar.KY(forumRuleItemData.getTitle());
            cVar.dv(Lb(forumRuleItemData.getContent()));
            cVar.rd(false);
            return cVar;
        }
        return null;
    }

    private List<PbContent> Lb(String str) {
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
        cVar.KY(AT(R.string.forum_rule_defalt_one_title));
        cVar.dv(AS(R.string.forum_rule_defalt_one_content));
        cVar.rd(false);
        list.add(cVar);
        c cVar2 = new c();
        cVar2.KY(AT(R.string.forum_rule_defalt_two_title));
        cVar2.dv(AS(R.string.forum_rule_defalt_two_content));
        cVar2.rd(false);
        list.add(cVar2);
        c cVar3 = new c();
        cVar3.KY(AT(R.string.forum_rule_defalt_three_title));
        cVar3.dv(AS(R.string.forum_rule_defalt_three_content));
        cVar3.rd(false);
        list.add(cVar3);
        c cVar4 = new c();
        cVar4.KY(AT(R.string.forum_rule_defalt_four_title));
        cVar4.dv(AS(R.string.forum_rule_defalt_four_content));
        cVar4.rd(false);
        list.add(cVar4);
    }

    private List<PbContent> AS(int i) {
        ArrayList arrayList = new ArrayList();
        PbContent.Builder builder = new PbContent.Builder();
        builder.text = AT(i);
        arrayList.add(builder.build(true));
        return arrayList;
    }

    private String AT(int i) {
        return TbadkApplication.getInst().getResources().getString(i);
    }

    public void a(a.InterfaceC0742a interfaceC0742a) {
        this.jtC = interfaceC0742a;
    }

    public void destory() {
        this.jtU = null;
        MessageManager.getInstance().unRegisterListener(this.juE);
    }
}
