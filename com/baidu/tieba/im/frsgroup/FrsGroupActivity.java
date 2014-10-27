package com.baidu.tieba.im.frsgroup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.FrsGroupActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.mvc.core.MvcActivity;
import com.baidu.tieba.im.creategroup.CreateGroupMainActivity;
import com.baidu.tieba.im.creategroup.CreateGroupStepActivity;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.message.RequestUserPermissionMessage;
/* loaded from: classes.dex */
public class FrsGroupActivity extends MvcActivity<l, com.baidu.tbadk.mvc.core.b> implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, com.baidu.tbadk.mvc.c.a {
    private l aWj;
    private com.baidu.tbadk.mvc.core.b aWk;
    private BdUniqueId[] aWl;
    private final com.baidu.adp.framework.listener.e aWm = new a(this, 103008);
    private String forumId;

    static {
        TbadkApplication.m251getInst().RegisterIntent(FrsGroupActivityConfig.class, FrsGroupActivity.class);
    }

    private BdUniqueId fE(int i) {
        if (this.aWl == null) {
            this.aWl = new BdUniqueId[3];
            this.aWl[0] = BdUniqueId.gen();
            this.aWl[1] = BdUniqueId.gen();
            this.aWl[2] = BdUniqueId.gen();
        }
        if (i < 0 || i >= this.aWl.length) {
            return null;
        }
        return this.aWl[i];
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.MvcActivity
    /* renamed from: Nl */
    public com.baidu.tbadk.mvc.core.b tj() {
        if (this.aWk == null) {
            this.aWk = new com.baidu.tbadk.mvc.core.b(this);
            this.aWk.a(new d(this, 0, fE(0)));
            this.aWk.a(new d(this, 1, fE(1)));
            this.aWk.a(new d(this, 2, fE(2)));
        }
        return this.aWk;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.MvcActivity
    /* renamed from: Nm */
    public l tk() {
        if (this.aWj == null) {
            this.aWj = new l(this);
            this.aWj.a(new e(this, 0, fE(0)));
            this.aWj.a(new e(this, 1, fE(1)));
            this.aWj.a(new e(this, 2, fE(2)));
        }
        return this.aWj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null && getIntent().getExtras() != null) {
            this.forumId = getIntent().getExtras().getString("forum_id");
        }
        if (bundle != null) {
            this.forumId = bundle.getString("forum_id");
        }
        sY().addEventDelegate(this);
        registerListener(this.aWm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.MvcActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null && intent.getExtras() != null) {
            this.forumId = intent.getExtras().getString("forum_id");
            tj().b(intent.getExtras());
            tk().c(intent.getExtras());
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aWj.Nv()) {
            TiebaStatic.eventStat(this, "create_g_in_frsgroup", "click", 1, new Object[0]);
            No();
        }
    }

    private void Nn() {
        this.aWj.cX(true);
        RequestUserPermissionMessage requestUserPermissionMessage = new RequestUserPermissionMessage();
        requestUserPermissionMessage.setForumId(com.baidu.adp.lib.g.c.a(this.forumId, 0L));
        sendMessage(requestUserPermissionMessage);
    }

    private void No() {
        if (TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
            LoginActivity.a((Activity) this, "", true, 0);
        } else {
            Nn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GroupPermData groupPermData) {
        if (!groupPermData.isManager()) {
            if (!groupPermData.isCreateNormal()) {
                showToast(groupPermData.getCreateNormalTip());
                return;
            } else {
                CreateGroupStepActivity.a(this, 3, com.baidu.adp.lib.g.c.f(this.forumId, 0), 1013, groupPermData.getCanCreateNormalNum(), groupPermData.getCanCreateOfficialNum(), groupPermData.getCanCreatePersonalNum());
                return;
            }
        }
        CreateGroupMainActivity.a(this, groupPermData.isCreateOfficial(), groupPermData.isCreateNormal(), groupPermData.getCreateOfficialTip(), groupPermData.getCreateNormalTip(), com.baidu.adp.lib.g.c.f(this.forumId, 0), groupPermData.getCanCreateNormalNum(), groupPermData.getCanCreateOfficialNum(), groupPermData.getCanCreatePersonalNum());
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (super.a(bVar)) {
            return true;
        }
        if (bVar.tp() == 987) {
            No();
            return true;
        }
        return false;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        int i2 = 1;
        if (i != com.baidu.tieba.v.radio_recommend) {
            if (i == com.baidu.tieba.v.radio_hot) {
                i2 = 2;
            } else if (i == com.baidu.tieba.v.radio_official) {
                i2 = 3;
            }
        }
        this.aWj.fH(i2 - 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.MvcActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0) {
            Nn();
        }
    }
}
