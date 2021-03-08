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
    private int bbe;
    private ForumRulesShowActivity jwR;
    private a.InterfaceC0732a jwz;
    private ForumRuleBaseData jxA;
    private com.baidu.adp.framework.listener.a jxB;
    private String jxy;
    private b jxz;
    private String mForumId;
    private String mForumName;
    private String mFrom;

    public ForumRulesShowModel(ForumRulesShowActivity forumRulesShowActivity) {
        super(forumRulesShowActivity.getPageContext());
        this.jxz = null;
        this.jxA = null;
        this.jxB = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FORUM_RULES_SHOW, 309690) { // from class: com.baidu.tieba.frs.forumRule.model.ForumRulesShowModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                    if (ForumRulesShowModel.this.jwz != null) {
                        ForumRulesShowModel.this.jwz.bCk();
                    }
                } else if (ForumRulesShowModel.this.getUniqueId() != responsedMessage.getOrginalMessage().getTag()) {
                    if (ForumRulesShowModel.this.jwz != null) {
                        ForumRulesShowModel.this.jwz.bCk();
                    }
                } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (ForumRulesShowModel.this.jwz != null) {
                        ForumRulesShowModel.this.jwz.bCk();
                    }
                } else {
                    if (responsedMessage instanceof ForumRuleDetailHttpResMsg) {
                        ForumRulesShowModel.this.jxz = ((ForumRuleDetailHttpResMsg) responsedMessage).getmForumRuleDetailData();
                    } else if (responsedMessage instanceof ForumRuleDetailScoketResMsg) {
                        ForumRulesShowModel.this.jxz = ((ForumRuleDetailScoketResMsg) responsedMessage).getmForumRuleDetailData();
                    }
                    if (ForumRulesShowModel.this.jxz != null && ForumRulesShowModel.this.jwz != null) {
                        ForumRulesShowModel.this.jwz.A(ForumRulesShowModel.this.jxz.cHn() == 2, ForumRulesShowModel.this.jxz.cHo());
                        ForumRulesShowModel.this.jwz.KD(ForumRulesShowModel.this.jxz.getTitle());
                        ForumRulesShowModel.this.jwz.a(ForumRulesShowModel.this.jxz);
                        ForumRulesShowModel.this.cHz();
                        ForumRulesShowModel.this.jwz.a(ForumRulesShowModel.this.jxz.cHs());
                        ForumRulesShowModel.this.jwz.finish();
                    }
                }
            }
        };
        this.jwR = forumRulesShowActivity;
        zK();
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
        if (bundle == null && this.jwR != null) {
            initWithIntent(this.jwR.getIntent());
        } else {
            initWithBundle(bundle);
        }
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFrom = intent.getStringExtra("from");
            this.mForumName = intent.getStringExtra("forum_name");
            this.jxy = intent.getStringExtra("url");
            this.bbe = intent.getIntExtra(IntentConfig.USER_LEVEL, 1);
            this.jwR.setFrom(this.mFrom);
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mFrom)) {
                this.jxA = (ForumRuleBaseData) intent.getSerializableExtra("datas");
                cHx();
                return;
            }
            cHy();
        }
    }

    private void cHx() {
        if (this.jxA != null) {
            this.jwz.A(false, "");
            this.jwz.KD(this.jxA.getTitle());
            b bVar = new b();
            BawuRoleInfoPub.Builder builder = new BawuRoleInfoPub.Builder();
            builder.portrait = TbadkCoreApplication.getCurrentPortrait();
            builder.name_show = TbadkApplication.getCurrentAccountNameShow();
            builder.user_level = Integer.valueOf(this.bbe);
            bVar.b(builder.build(true));
            ForumInfo.Builder builder2 = new ForumInfo.Builder();
            builder2.forum_name = this.mForumName;
            bVar.a(builder2.build(true));
            bVar.ri(false);
            bVar.setPreface(this.jxA.getPreface());
            this.jwz.a(bVar);
            cHz();
            com.baidu.tieba.frs.forumRule.b.a aVar = new com.baidu.tieba.frs.forumRule.b.a();
            aVar.Ap(this.mForumName);
            aVar.setAvatar(this.jxy);
            aVar.setName_show(TbadkApplication.getCurrentAccountNameShow());
            aVar.setPortrait(TbadkApplication.getCurrentPortrait());
            this.jwz.a(aVar);
            this.jwz.finish();
        }
    }

    public void initWithBundle(Bundle bundle) {
    }

    public void cHy() {
        super.sendMessage(KL(this.mForumId));
    }

    private ForumRuleDetailReqMsg KL(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        ForumRuleDetailReqMsg forumRuleDetailReqMsg = new ForumRuleDetailReqMsg();
        forumRuleDetailReqMsg.setForumRuleId(Long.valueOf(Long.parseLong(str)));
        return forumRuleDetailReqMsg;
    }

    private void initListener() {
        registerListener(this.jxB);
    }

    private void zK() {
        com.baidu.tieba.tbadkCore.a.a.a(309690, ForumRuleDetailScoketResMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FORUM_RULES_SHOW, com.baidu.tieba.tbadkCore.a.a.bV(TbConfig.FORUM_RULES_SHOW, 309690));
        tbHttpMessageTask.setResponsedClass(ForumRuleDetailHttpResMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHz() {
        ArrayList arrayList = new ArrayList();
        ds(arrayList);
        if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mFrom) && this.jxA != null) {
            List<ForumRuleBaseData.ForumRuleItemData> list = this.jxA.getList();
            if (list != null && list.size() > 0) {
                for (ForumRuleBaseData.ForumRuleItemData forumRuleItemData : list) {
                    arrayList.add(a(forumRuleItemData));
                }
            }
        } else {
            List<ForumRule> cHm = this.jxz.cHm();
            if (cHm != null && cHm.size() > 0) {
                for (ForumRule forumRule : cHm) {
                    c cVar = new c();
                    cVar.a(forumRule);
                    arrayList.add(cVar);
                }
            }
        }
        this.jwz.dp(arrayList);
    }

    private c a(ForumRuleBaseData.ForumRuleItemData forumRuleItemData) {
        if (forumRuleItemData != null) {
            c cVar = new c();
            cVar.KJ(forumRuleItemData.getTitle());
            cVar.dq(KM(forumRuleItemData.getContent()));
            cVar.rj(false);
            return cVar;
        }
        return null;
    }

    private List<PbContent> KM(String str) {
        String substring;
        ArrayList arrayList = new ArrayList();
        while (true) {
            if ("".equals(str)) {
                break;
            }
            int indexOf = str.indexOf("#(url");
            if (indexOf == 0) {
                int indexOf2 = str.indexOf(")", indexOf);
                j(arrayList, str.substring(0, indexOf2 + 1));
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

    private void j(List<PbContent> list, String str) {
        String[] split = str.split(",");
        PbContent.Builder builder = new PbContent.Builder();
        builder.type = 1;
        builder.link = URLDecoder.decode(split[2]);
        builder.text = URLDecoder.decode(split[3].substring(0, split[3].length() - 1));
        list.add(builder.build(true));
    }

    private void ds(List<c> list) {
        c cVar = new c();
        cVar.KJ(zy(R.string.forum_rule_defalt_one_title));
        cVar.dq(zx(R.string.forum_rule_defalt_one_content));
        cVar.rj(false);
        list.add(cVar);
        c cVar2 = new c();
        cVar2.KJ(zy(R.string.forum_rule_defalt_two_title));
        cVar2.dq(zx(R.string.forum_rule_defalt_two_content));
        cVar2.rj(false);
        list.add(cVar2);
        c cVar3 = new c();
        cVar3.KJ(zy(R.string.forum_rule_defalt_three_title));
        cVar3.dq(zx(R.string.forum_rule_defalt_three_content));
        cVar3.rj(false);
        list.add(cVar3);
        c cVar4 = new c();
        cVar4.KJ(zy(R.string.forum_rule_defalt_four_title));
        cVar4.dq(zx(R.string.forum_rule_defalt_four_content));
        cVar4.rj(false);
        list.add(cVar4);
    }

    private List<PbContent> zx(int i) {
        ArrayList arrayList = new ArrayList();
        PbContent.Builder builder = new PbContent.Builder();
        builder.text = zy(i);
        arrayList.add(builder.build(true));
        return arrayList;
    }

    private String zy(int i) {
        return TbadkApplication.getInst().getResources().getString(i);
    }

    public void a(a.InterfaceC0732a interfaceC0732a) {
        this.jwz = interfaceC0732a;
    }

    public void destory() {
        this.jwR = null;
        MessageManager.getInstance().unRegisterListener(this.jxB);
    }
}
