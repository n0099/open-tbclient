package com.baidu.tieba.frs.forumRule;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.v0.p1.b.b;
import c.a.q0.v0.p1.f.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ForumRuleEditActivityConfig;
import com.baidu.tbadk.core.data.ForumRuleBaseData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.forumRule.model.ForumRuleEditModel;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ForumRulesEditActivity extends BaseActivity<ForumRulesEditActivity> implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String bawuHead;
    public ForumRuleBaseData mBaseData;
    public String mForumId;
    public String mForumName;
    public ForumRuleEditModel mModel;
    public a mView;
    public String mfrom;
    public View rootView;
    public int userLevel;

    public ForumRulesEditActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void initParamsFromIntent(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, bundle) == null) {
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
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.closeAnimation();
        }
    }

    @Override // c.a.q0.v0.p1.b.b
    public void commitCallback(int i2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
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
            new BdTopToast(this, 2000).setIcon(false).setContent(str).show((ViewGroup) this.rootView.findViewById(R.id.ll_forum_rule_all));
        }
    }

    @Override // c.a.q0.v0.p1.b.b
    public void commitData(ForumRuleBaseData forumRuleBaseData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, forumRuleBaseData, z) == null) {
            if (TextUtils.isEmpty(this.mForumId)) {
                new BdTopToast(this, 2000).setIcon(false).setContent(getString(R.string.forum_rule_defalt_commit_fail_no_forum)).show((ViewGroup) this.rootView.findViewById(R.id.ll_forum_rule_all));
            } else {
                this.mModel.z(this.mForumId, forumRuleBaseData, z);
            }
        }
    }

    @Override // c.a.q0.v0.p1.b.b
    public void draftCallback(int i2, ForumRuleBaseData forumRuleBaseData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, forumRuleBaseData, str) == null) {
            if (ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_FRS.equals(this.mfrom) && forumRuleBaseData == null) {
                this.mView.p();
            }
            if (i2 != 0) {
                if (ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mfrom)) {
                    this.mView.U(this.mBaseData, false);
                }
                new BdTopToast(this, 2000).setIcon(false).setContent(str).show((ViewGroup) this.rootView.findViewById(R.id.ll_forum_rule_all));
            } else if (forumRuleBaseData != null) {
                this.mView.U(forumRuleBaseData, true);
            } else if (ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mfrom)) {
                this.mView.U(this.mBaseData, false);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, c.a.p0.m0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "a073" : (String) invokeV.objValue;
    }

    public void loadDraftData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.mModel.A(str);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            super.onChangeSkinType(i2);
            a aVar = this.mView;
            if (aVar != null) {
                aVar.u(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
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
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            this.mView.L();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                this.mView.N();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) {
            super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
        }
    }
}
