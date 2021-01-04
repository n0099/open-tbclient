package com.baidu.tieba.frs.forumRule;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ForumRuleEditActivityConfig;
import com.baidu.tbadk.core.data.ForumRuleBaseData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.forumRule.a.b;
import com.baidu.tieba.frs.forumRule.model.ForumRuleEditModel;
import com.baidu.tieba.frs.forumRule.view.a;
import com.baidu.tieba.view.BdTopToast;
/* loaded from: classes2.dex */
public class ForumRulesEditActivity extends BaseActivity<ForumRulesEditActivity> implements b {
    private a jtv;
    private ForumRuleEditModel jtw;
    private String jtx;
    private String jty;
    private ForumRuleBaseData jtz;
    private String mForumId;
    private String mForumName;
    private View rootView;
    private int userLevel;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        an(bundle);
        this.rootView = LayoutInflater.from(this).inflate(R.layout.forum_rule_edit_activity, (ViewGroup) null);
        this.jtv = new a(getPageContext(), this, this.rootView, this.mForumId, this.mForumName, this.jtx, this.jty, this.userLevel, this);
        this.jtw = new ForumRuleEditModel(getPageContext(), this, this.mForumId);
        setContentView(this.rootView);
        setSwipeBackEnabled(false);
        KS(this.mForumId);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.CAM_X0201, true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jtv != null) {
            this.jtv.changeSkinType(i);
        }
    }

    private void an(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumId = intent.getStringExtra("forum_id");
            this.mForumName = intent.getStringExtra("forum_name");
            this.jtx = intent.getStringExtra("from");
            this.jty = intent.getStringExtra("url");
            this.userLevel = intent.getIntExtra(IntentConfig.USER_LEVEL, 0);
            this.jtz = (ForumRuleBaseData) intent.getSerializableExtra("datas");
        } else if (bundle != null) {
            this.mForumId = bundle.getString("forum_id");
            this.mForumName = bundle.getString("forum_name");
            this.jtx = bundle.getString("from");
            this.jty = bundle.getString("url");
            this.userLevel = bundle.getInt(IntentConfig.USER_LEVEL);
            this.jtz = (ForumRuleBaseData) bundle.getSerializable("datas");
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.jtv.cJZ();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        super.closeAnimation();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a073";
    }

    public void KS(String str) {
        this.jtw.KS(str);
    }

    @Override // com.baidu.tieba.frs.forumRule.a.b
    public void a(int i, ForumRuleBaseData forumRuleBaseData, String str) {
        if (i == 0) {
            if (forumRuleBaseData != null) {
                this.jtv.b(forumRuleBaseData, true);
                return;
            } else if (ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.jtx)) {
                this.jtv.b(this.jtz, false);
                return;
            } else {
                return;
            }
        }
        if (ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.jtx)) {
            this.jtv.b(this.jtz, false);
        }
        new BdTopToast(this, 2000).yW(false).UY(str).aR((ViewGroup) this.rootView.findViewById(R.id.ll_forum_rule_all));
    }

    @Override // com.baidu.tieba.frs.forumRule.a.b
    public void a(ForumRuleBaseData forumRuleBaseData, boolean z) {
        if (TextUtils.isEmpty(this.mForumId)) {
            new BdTopToast(this, 2000).yW(false).UY(getString(R.string.forum_rule_defalt_commit_fail_no_forum)).aR((ViewGroup) this.rootView.findViewById(R.id.ll_forum_rule_all));
        } else {
            this.jtw.a(this.mForumId, forumRuleBaseData, z);
        }
    }

    @Override // com.baidu.tieba.frs.forumRule.a.b
    public void m(int i, String str, boolean z) {
        if (i == 0) {
            Intent intent = getIntent();
            if (z) {
                this.jtv.cKa();
                intent.putExtra("group_name", getString(R.string.save_success));
                intent.putExtra("from", true);
            } else {
                intent.putExtra("group_name", getString(R.string.forum_rule_defalt_has_commit_toast));
                intent.putExtra("from", false);
            }
            setResult(-1, intent);
            finish();
            return;
        }
        new BdTopToast(this, 2000).yW(false).UY(str).aR((ViewGroup) this.rootView.findViewById(R.id.ll_forum_rule_all));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jtv.onDestory();
    }
}
