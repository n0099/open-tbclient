package com.baidu.tieba.frs.forumRule.model;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.data.ForumRuleBaseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import com.baidu.tieba.frs.forumRule.message.ForumRuleDetailHttpResMsg;
import com.baidu.tieba.frs.forumRule.message.ForumRuleDetailReqMsg;
import com.baidu.tieba.frs.forumRule.message.ForumRuleDetailScoketResMsg;
import d.a.k0.q0.q1.c.b;
import d.a.k0.q0.q1.c.c;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import tbclient.BawuRoleInfoPub;
import tbclient.ForumInfo;
import tbclient.ForumRule;
import tbclient.PbContent;
/* loaded from: classes4.dex */
public class ForumRulesShowModel extends BdBaseModel<ForumRulesShowActivity> {

    /* renamed from: e  reason: collision with root package name */
    public ForumRulesShowActivity f15472e;

    /* renamed from: f  reason: collision with root package name */
    public String f15473f;

    /* renamed from: g  reason: collision with root package name */
    public String f15474g;

    /* renamed from: h  reason: collision with root package name */
    public int f15475h;

    /* renamed from: i  reason: collision with root package name */
    public String f15476i;
    public String j;
    public b k;
    public ForumRuleBaseData l;
    public d.a.k0.q0.q1.b.a m;
    public d.a.c.c.g.a n;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                if (ForumRulesShowModel.this.m != null) {
                    ForumRulesShowModel.this.m.b();
                }
            } else if (ForumRulesShowModel.this.getUniqueId() != responsedMessage.getOrginalMessage().getTag()) {
                if (ForumRulesShowModel.this.m != null) {
                    ForumRulesShowModel.this.m.b();
                }
            } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                if (ForumRulesShowModel.this.m != null) {
                    ForumRulesShowModel.this.m.b();
                }
            } else {
                if (responsedMessage instanceof ForumRuleDetailHttpResMsg) {
                    ForumRulesShowModel.this.k = ((ForumRuleDetailHttpResMsg) responsedMessage).getmForumRuleDetailData();
                } else if (responsedMessage instanceof ForumRuleDetailScoketResMsg) {
                    ForumRulesShowModel.this.k = ((ForumRuleDetailScoketResMsg) responsedMessage).getmForumRuleDetailData();
                }
                if (ForumRulesShowModel.this.k == null || ForumRulesShowModel.this.m == null) {
                    return;
                }
                ForumRulesShowModel.this.m.e(ForumRulesShowModel.this.k.e() == 2, ForumRulesShowModel.this.k.c());
                ForumRulesShowModel.this.m.g(ForumRulesShowModel.this.k.p());
                ForumRulesShowModel.this.m.f(ForumRulesShowModel.this.k);
                ForumRulesShowModel.this.F();
                ForumRulesShowModel.this.m.c(ForumRulesShowModel.this.k.q());
                ForumRulesShowModel.this.m.finish();
            }
        }
    }

    public ForumRulesShowModel(ForumRulesShowActivity forumRulesShowActivity) {
        super(forumRulesShowActivity.getPageContext());
        this.k = null;
        this.l = null;
        this.n = new a(CmdConfigHttp.CMD_FORUM_RULES_SHOW, 309690);
        this.f15472e = forumRulesShowActivity;
        C();
        initListener();
    }

    public final void A(List<PbContent> list, String str) {
        String[] split = str.split(",");
        PbContent.Builder builder = new PbContent.Builder();
        builder.type = 1;
        builder.link = URLDecoder.decode(split[2]);
        builder.text = URLDecoder.decode(split[3].substring(0, split[3].length() - 1));
        list.add(builder.build(true));
    }

    public final c B(ForumRuleBaseData.ForumRuleItemData forumRuleItemData) {
        if (forumRuleItemData != null) {
            c cVar = new c();
            cVar.l(forumRuleItemData.getTitle());
            cVar.k(z(forumRuleItemData.getContent()));
            cVar.i(false);
            return cVar;
        }
        return null;
    }

    public final void C() {
        d.a.k0.d3.d0.a.h(309690, ForumRuleDetailScoketResMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FORUM_RULES_SHOW, d.a.k0.d3.d0.a.a(TbConfig.FORUM_RULES_SHOW, 309690));
        tbHttpMessageTask.setResponsedClass(ForumRuleDetailHttpResMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void D() {
        super.sendMessage(w(this.f15473f));
    }

    public void E(d.a.k0.q0.q1.b.a aVar) {
        this.m = aVar;
    }

    public final void F() {
        ForumRuleBaseData forumRuleBaseData;
        ArrayList arrayList = new ArrayList();
        if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.j) && (forumRuleBaseData = this.l) != null) {
            List<ForumRuleBaseData.ForumRuleItemData> list = forumRuleBaseData.getList();
            if (list != null && list.size() > 0) {
                for (ForumRuleBaseData.ForumRuleItemData forumRuleItemData : list) {
                    arrayList.add(B(forumRuleItemData));
                }
            }
        } else {
            List<ForumRule> o = this.k.o();
            if (o != null && o.size() > 0) {
                for (ForumRule forumRule : o) {
                    c cVar = new c();
                    cVar.h(forumRule);
                    arrayList.add(cVar);
                }
            }
        }
        this.m.d(arrayList);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void destory() {
        this.f15472e = null;
        MessageManager.getInstance().unRegisterListener(this.n);
    }

    public final void initListener() {
        registerListener(this.n);
    }

    public void initWithBundle(Bundle bundle) {
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.f15473f = intent.getStringExtra("forum_id");
            this.j = intent.getStringExtra("from");
            this.f15474g = intent.getStringExtra("forum_name");
            this.f15476i = intent.getStringExtra("url");
            this.f15475h = intent.getIntExtra(IntentConfig.USER_LEVEL, 1);
            this.f15472e.setFrom(this.j);
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.j)) {
                this.l = (ForumRuleBaseData) intent.getSerializableExtra(IntentConfig.DATAS);
                x();
                return;
            }
            D();
        }
    }

    public final ForumRuleDetailReqMsg w(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        ForumRuleDetailReqMsg forumRuleDetailReqMsg = new ForumRuleDetailReqMsg();
        forumRuleDetailReqMsg.setForumRuleId(Long.valueOf(Long.parseLong(str)));
        return forumRuleDetailReqMsg;
    }

    public final void x() {
        if (this.l != null) {
            this.m.e(false, "");
            this.m.g(this.l.getTitle());
            b bVar = new b();
            BawuRoleInfoPub.Builder builder = new BawuRoleInfoPub.Builder();
            builder.portrait = TbadkCoreApplication.getCurrentPortrait();
            builder.name_show = TbadkCoreApplication.getCurrentAccountNameShow();
            builder.user_level = Integer.valueOf(this.f15475h);
            bVar.s(builder.build(true));
            ForumInfo.Builder builder2 = new ForumInfo.Builder();
            builder2.forum_name = this.f15474g;
            bVar.t(builder2.build(true));
            bVar.u(false);
            bVar.v(this.l.getPreface());
            this.m.f(bVar);
            F();
            d.a.k0.q0.q1.c.a aVar = new d.a.k0.q0.q1.c.a();
            aVar.m(this.f15474g);
            aVar.l(this.f15476i);
            aVar.o(TbadkCoreApplication.getCurrentAccountNameShow());
            aVar.p(TbadkCoreApplication.getCurrentPortrait());
            this.m.c(aVar);
            this.m.finish();
        }
    }

    public void y(Bundle bundle) {
        ForumRulesShowActivity forumRulesShowActivity;
        setUniqueId(getUniqueId());
        if (bundle == null && (forumRulesShowActivity = this.f15472e) != null) {
            initWithIntent(forumRulesShowActivity.getIntent());
        } else {
            initWithBundle(bundle);
        }
    }

    public final List<PbContent> z(String str) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            if ("".equals(str)) {
                break;
            }
            int indexOf = str.indexOf("#(url");
            if (indexOf == 0) {
                int indexOf2 = str.indexOf(SmallTailInfo.EMOTION_SUFFIX, indexOf) + 1;
                A(arrayList, str.substring(0, indexOf2));
                str = str.substring(indexOf2, str.length());
            } else if (indexOf == -1) {
                String substring = str.substring(0, str.length());
                PbContent.Builder builder = new PbContent.Builder();
                builder.text = substring;
                builder.type = 0;
                arrayList.add(builder.build(true));
                break;
            } else {
                String substring2 = str.substring(0, indexOf);
                PbContent.Builder builder2 = new PbContent.Builder();
                builder2.text = substring2;
                builder2.type = 0;
                arrayList.add(builder2.build(true));
                str = str.substring(indexOf, str.length());
            }
        }
        return arrayList;
    }
}
