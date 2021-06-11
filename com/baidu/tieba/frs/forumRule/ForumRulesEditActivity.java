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
import com.baidu.tieba.frs.forumRule.model.ForumRuleEditModel;
import com.baidu.tieba.view.BdTopToast;
import d.a.n0.r0.q1.b.b;
import d.a.n0.r0.q1.f.a;
/* loaded from: classes4.dex */
public class ForumRulesEditActivity extends BaseActivity<ForumRulesEditActivity> implements b {
    public String bawuHead;
    public ForumRuleBaseData mBaseData;
    public String mForumId;
    public String mForumName;
    public ForumRuleEditModel mModel;
    public a mView;
    public String mfrom;
    public View rootView;
    public int userLevel;

    private void initParamsFromIntent(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumId = intent.getStringExtra("forum_id");
            this.mForumName = intent.getStringExtra("forum_name");
            this.mfrom = intent.getStringExtra("from");
            this.bawuHead = intent.getStringExtra("url");
            this.userLevel = intent.getIntExtra(IntentConfig.USER_LEVEL, 0);
            this.mBaseData = (ForumRuleBaseData) intent.getSerializableExtra(IntentConfig.DATAS);
        } else if (bundle != null) {
            this.mForumId = bundle.getString("forum_id");
            this.mForumName = bundle.getString("forum_name");
            this.mfrom = bundle.getString("from");
            this.bawuHead = bundle.getString("url");
            this.userLevel = bundle.getInt(IntentConfig.USER_LEVEL);
            this.mBaseData = (ForumRuleBaseData) bundle.getSerializable(IntentConfig.DATAS);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        super.closeAnimation();
    }

    @Override // d.a.n0.r0.q1.b.b
    public void commitCallback(int i2, String str, boolean z) {
        if (i2 == 0) {
            Intent intent = getIntent();
            if (z) {
                this.mView.B();
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
        BdTopToast bdTopToast = new BdTopToast(this, 2000);
        bdTopToast.i(false);
        bdTopToast.h(str);
        bdTopToast.j((ViewGroup) this.rootView.findViewById(R.id.ll_forum_rule_all));
    }

    @Override // d.a.n0.r0.q1.b.b
    public void commitData(ForumRuleBaseData forumRuleBaseData, boolean z) {
        if (TextUtils.isEmpty(this.mForumId)) {
            BdTopToast bdTopToast = new BdTopToast(this, 2000);
            bdTopToast.i(false);
            bdTopToast.h(getString(R.string.forum_rule_defalt_commit_fail_no_forum));
            bdTopToast.j((ViewGroup) this.rootView.findViewById(R.id.ll_forum_rule_all));
            return;
        }
        this.mModel.z(this.mForumId, forumRuleBaseData, z);
    }

    @Override // d.a.n0.r0.q1.b.b
    public void draftCallback(int i2, ForumRuleBaseData forumRuleBaseData, String str) {
        if (ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_FRS.equals(this.mfrom) && forumRuleBaseData == null) {
            this.mView.p();
        }
        if (i2 == 0) {
            if (forumRuleBaseData != null) {
                this.mView.Q(forumRuleBaseData, true);
                return;
            } else if (ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mfrom)) {
                this.mView.Q(this.mBaseData, false);
                return;
            } else {
                return;
            }
        }
        if (ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mfrom)) {
            this.mView.Q(this.mBaseData, false);
        }
        BdTopToast bdTopToast = new BdTopToast(this, 2000);
        bdTopToast.i(false);
        bdTopToast.h(str);
        bdTopToast.j((ViewGroup) this.rootView.findViewById(R.id.ll_forum_rule_all));
    }

    @Override // com.baidu.tbadk.BaseActivity, d.a.m0.k0.a
    public String getCurrentPageKey() {
        return "a073";
    }

    public void loadDraftData(String str) {
        this.mModel.A(str);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        a aVar = this.mView;
        if (aVar != null) {
            aVar.u(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initParamsFromIntent(bundle);
        this.rootView = LayoutInflater.from(this).inflate(R.layout.forum_rule_edit_activity, (ViewGroup) null);
        this.mView = new a(getPageContext(), this, this.rootView, this.mForumId, this.mForumName, this.mfrom, this.bawuHead, this.userLevel, this);
        this.mModel = new ForumRuleEditModel(getPageContext(), this, this.mForumId);
        setContentView(this.rootView);
        setSwipeBackEnabled(false);
        loadDraftData(this.mForumId);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.CAM_X0201, true);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mView.I();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            this.mView.J();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i2, int i3) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }
}
