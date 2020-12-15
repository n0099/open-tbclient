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
import com.baidu.tieba.frs.forumRule.b.b;
import com.baidu.tieba.frs.forumRule.model.ForumRuleEditModel;
import com.baidu.tieba.frs.forumRule.view.a;
import com.baidu.tieba.view.BdTopToast;
/* loaded from: classes22.dex */
public class ForumRulesEditActivity extends BaseActivity<ForumRulesEditActivity> implements b {
    private a jgV;
    private ForumRuleEditModel jgW;
    private String jgX;
    private String jgY;
    private ForumRuleBaseData jgZ;
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
        this.jgV = new a(getPageContext(), this, this.rootView, this.mForumId, this.mForumName, this.jgX, this.jgY, this.userLevel, this);
        this.jgW = new ForumRuleEditModel(getPageContext(), this, this.mForumId);
        setContentView(this.rootView);
        setSwipeBackEnabled(false);
        KS(this.mForumId);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.CAM_X0201, true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jgV != null) {
            this.jgV.changeSkinType(i);
        }
    }

    private void an(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumId = intent.getStringExtra("forum_id");
            this.mForumName = intent.getStringExtra("forum_name");
            this.jgX = intent.getStringExtra("from");
            this.jgY = intent.getStringExtra("url");
            this.userLevel = intent.getIntExtra(IntentConfig.USER_LEVEL, 0);
            this.jgZ = (ForumRuleBaseData) intent.getSerializableExtra("datas");
        } else if (bundle != null) {
            this.mForumId = bundle.getString("forum_id");
            this.mForumName = bundle.getString("forum_name");
            this.jgX = bundle.getString("from");
            this.jgY = bundle.getString("url");
            this.userLevel = bundle.getInt(IntentConfig.USER_LEVEL);
            this.jgZ = (ForumRuleBaseData) bundle.getSerializable("datas");
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.jgV.cHa();
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
        this.jgW.KS(str);
    }

    @Override // com.baidu.tieba.frs.forumRule.b.b
    public void a(int i, ForumRuleBaseData forumRuleBaseData, String str) {
        if (i == 0) {
            if (forumRuleBaseData != null) {
                this.jgV.b(forumRuleBaseData, true);
                return;
            } else if (ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.jgX)) {
                this.jgV.b(this.jgZ, false);
                return;
            } else {
                return;
            }
        }
        if (ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.jgX)) {
            this.jgV.b(this.jgZ, false);
        }
        new BdTopToast(this, 2000).yW(false).Vt(str).aF((ViewGroup) this.rootView.findViewById(R.id.ll_forum_rule_all));
    }

    @Override // com.baidu.tieba.frs.forumRule.b.b
    public void a(ForumRuleBaseData forumRuleBaseData, boolean z) {
        if (TextUtils.isEmpty(this.mForumId)) {
            new BdTopToast(this, 2000).yW(false).Vt(getString(R.string.forum_rule_defalt_commit_fail_no_forum)).aF((ViewGroup) this.rootView.findViewById(R.id.ll_forum_rule_all));
        } else {
            this.jgW.a(this.mForumId, forumRuleBaseData, z);
        }
    }

    @Override // com.baidu.tieba.frs.forumRule.b.b
    public void m(int i, String str, boolean z) {
        if (i == 0) {
            Intent intent = getIntent();
            if (z) {
                this.jgV.cHb();
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
        new BdTopToast(this, 2000).yW(false).Vt(str).aF((ViewGroup) this.rootView.findViewById(R.id.ll_forum_rule_all));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jgV.onDestory();
    }
}
