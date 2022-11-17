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
import com.baidu.tieba.oo6;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.wo6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ForumRulesEditActivity extends BaseActivity<ForumRulesEditActivity> implements oo6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public wo6 b;
    public ForumRuleEditModel c;
    public String d;
    public String e;
    public String f;
    public String g;
    public int h;
    public ForumRuleBaseData i;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tieba.de5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "a073" : (String) invokeV.objValue;
    }

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

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.closeAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            this.b.F();
        }
    }

    @Override // com.baidu.tieba.oo6
    public void Y0(ForumRuleBaseData forumRuleBaseData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, forumRuleBaseData, z) == null) {
            if (TextUtils.isEmpty(this.d)) {
                BdTopToast bdTopToast = new BdTopToast(this, 2000);
                bdTopToast.h(false);
                bdTopToast.g(getString(R.string.obfuscated_res_0x7f0f06b0));
                bdTopToast.i((ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f09142e));
                return;
            }
            this.c.C(this.d, forumRuleBaseData, z);
        }
    }

    @Override // com.baidu.tieba.oo6
    public void k1(int i, ForumRuleBaseData forumRuleBaseData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i, forumRuleBaseData, str) == null) {
            if (ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_FRS.equals(this.f) && forumRuleBaseData == null) {
                this.b.p();
            }
            if (i == 0) {
                if (forumRuleBaseData != null) {
                    this.b.O(forumRuleBaseData, true);
                    return;
                } else if (ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.f)) {
                    this.b.O(this.i, false);
                    return;
                } else {
                    return;
                }
            }
            if (ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.f)) {
                this.b.O(this.i, false);
            }
            BdTopToast bdTopToast = new BdTopToast(this, 2000);
            bdTopToast.h(false);
            bdTopToast.g(str);
            bdTopToast.i((ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f09142e));
        }
    }

    @Override // com.baidu.tieba.oo6
    public void s1(int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
            if (i == 0) {
                Intent intent = getIntent();
                if (z) {
                    this.b.B();
                    intent.putExtra("group_name", getString(R.string.obfuscated_res_0x7f0f10e0));
                    intent.putExtra("from", true);
                } else {
                    intent.putExtra("group_name", getString(R.string.obfuscated_res_0x7f0f06b3));
                    intent.putExtra("from", false);
                }
                setResult(-1, intent);
                finish();
                return;
            }
            BdTopToast bdTopToast = new BdTopToast(this, 2000);
            bdTopToast.h(false);
            bdTopToast.g(str);
            bdTopToast.i((ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f09142e));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            super.onChangeSkinType(i);
            wo6 wo6Var = this.b;
            if (wo6Var != null) {
                wo6Var.u(i);
            }
        }
    }

    public void y1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.c.D(str);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            x1(bundle);
            this.a = LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d02c0, (ViewGroup) null);
            this.b = new wo6(getPageContext(), this, this.a, this.d, this.e, this.f, this.g, this.h, this);
            this.c = new ForumRuleEditModel(getPageContext(), this, this.d);
            setContentView(this.a);
            setSwipeBackEnabled(false);
            y1(this.d);
            addGlobalLayoutListener();
            adjustResizeForSoftInput(R.color.CAM_X0201, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i, keyEvent)) == null) {
            if (i == 4) {
                this.b.G();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            super.overridePendingTransition(R.anim.obfuscated_res_0x7f01000d, R.anim.obfuscated_res_0x7f01000c);
        }
    }

    public final void x1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            Intent intent = getIntent();
            if (intent != null) {
                this.d = intent.getStringExtra("forum_id");
                this.e = intent.getStringExtra("forum_name");
                this.f = intent.getStringExtra("from");
                this.g = intent.getStringExtra("url");
                this.h = intent.getIntExtra(IntentConfig.USER_LEVEL, 0);
                this.i = (ForumRuleBaseData) intent.getSerializableExtra(IntentConfig.DATAS);
            } else if (bundle != null) {
                this.d = bundle.getString("forum_id");
                this.e = bundle.getString("forum_name");
                this.f = bundle.getString("from");
                this.g = bundle.getString("url");
                this.h = bundle.getInt(IntentConfig.USER_LEVEL);
                this.i = (ForumRuleBaseData) bundle.getSerializable(IntentConfig.DATAS);
            }
        }
    }
}
