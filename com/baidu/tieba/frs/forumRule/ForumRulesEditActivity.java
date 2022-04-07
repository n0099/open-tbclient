package com.baidu.tieba.frs.forumRule;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
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
import com.repackage.bj6;
import com.repackage.jj6;
/* loaded from: classes3.dex */
public class ForumRulesEditActivity extends BaseActivity<ForumRulesEditActivity> implements bj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String bawuHead;
    public ForumRuleBaseData mBaseData;
    public String mForumId;
    public String mForumName;
    public ForumRuleEditModel mModel;
    public jj6 mView;
    public String mfrom;
    public View rootView;
    public int userLevel;

    public ForumRulesEditActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    @Override // com.repackage.bj6
    public void commitCallback(int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
            if (i == 0) {
                Intent intent = getIntent();
                if (z) {
                    this.mView.C();
                    intent.putExtra("group_name", getString(R.string.obfuscated_res_0x7f0f106d));
                    intent.putExtra("from", true);
                } else {
                    intent.putExtra("group_name", getString(R.string.obfuscated_res_0x7f0f067a));
                    intent.putExtra("from", false);
                }
                setResult(-1, intent);
                finish();
                return;
            }
            BdTopToast bdTopToast = new BdTopToast(this, 2000);
            bdTopToast.i(false);
            bdTopToast.h(str);
            bdTopToast.j((ViewGroup) this.rootView.findViewById(R.id.obfuscated_res_0x7f0912e6));
        }
    }

    @Override // com.repackage.bj6
    public void commitData(ForumRuleBaseData forumRuleBaseData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, forumRuleBaseData, z) == null) {
            if (TextUtils.isEmpty(this.mForumId)) {
                BdTopToast bdTopToast = new BdTopToast(this, 2000);
                bdTopToast.i(false);
                bdTopToast.h(getString(R.string.obfuscated_res_0x7f0f0677));
                bdTopToast.j((ViewGroup) this.rootView.findViewById(R.id.obfuscated_res_0x7f0912e6));
                return;
            }
            this.mModel.B(this.mForumId, forumRuleBaseData, z);
        }
    }

    @Override // com.repackage.bj6
    public void draftCallback(int i, ForumRuleBaseData forumRuleBaseData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i, forumRuleBaseData, str) == null) {
            if (ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_FRS.equals(this.mfrom) && forumRuleBaseData == null) {
                this.mView.p();
            }
            if (i == 0) {
                if (forumRuleBaseData != null) {
                    this.mView.O(forumRuleBaseData, true);
                    return;
                } else if (ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mfrom)) {
                    this.mView.O(this.mBaseData, false);
                    return;
                } else {
                    return;
                }
            }
            if (ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mfrom)) {
                this.mView.O(this.mBaseData, false);
            }
            BdTopToast bdTopToast = new BdTopToast(this, 2000);
            bdTopToast.i(false);
            bdTopToast.h(str);
            bdTopToast.j((ViewGroup) this.rootView.findViewById(R.id.obfuscated_res_0x7f0912e6));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.v75
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "a073" : (String) invokeV.objValue;
    }

    public void loadDraftData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.mModel.C(str);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            super.onChangeSkinType(i);
            jj6 jj6Var = this.mView;
            if (jj6Var != null) {
                jj6Var.v(i);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            initParamsFromIntent(bundle);
            this.rootView = LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d02c4, (ViewGroup) null);
            this.mView = new jj6(getPageContext(), this, this.rootView, this.mForumId, this.mForumName, this.mfrom, this.bawuHead, this.userLevel, this);
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
            this.mView.G();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, keyEvent)) == null) {
            if (i == 4) {
                this.mView.H();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            super.overridePendingTransition(R.anim.obfuscated_res_0x7f01000d, R.anim.obfuscated_res_0x7f01000c);
        }
    }
}
