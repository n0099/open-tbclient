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
import com.repackage.lk6;
import com.repackage.tk6;
/* loaded from: classes3.dex */
public class ForumRulesEditActivity extends BaseActivity<ForumRulesEditActivity> implements lk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public tk6 b;
    public ForumRuleEditModel c;
    public String d;
    public String e;
    public String f;
    public String g;
    public int h;
    public ForumRuleBaseData i;

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

    public void A1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.c.D(str);
        }
    }

    @Override // com.repackage.lk6
    public void a1(ForumRuleBaseData forumRuleBaseData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumRuleBaseData, z) == null) {
            if (TextUtils.isEmpty(this.d)) {
                BdTopToast bdTopToast = new BdTopToast(this, 2000);
                bdTopToast.h(false);
                bdTopToast.g(getString(R.string.obfuscated_res_0x7f0f068e));
                bdTopToast.i((ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f0913d4));
                return;
            }
            this.c.C(this.d, forumRuleBaseData, z);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.closeAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.u95
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "a073" : (String) invokeV.objValue;
    }

    @Override // com.repackage.lk6
    public void m1(int i, ForumRuleBaseData forumRuleBaseData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i, forumRuleBaseData, str) == null) {
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
            bdTopToast.i((ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f0913d4));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.onChangeSkinType(i);
            tk6 tk6Var = this.b;
            if (tk6Var != null) {
                tk6Var.u(i);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            z1(bundle);
            this.a = LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d02b8, (ViewGroup) null);
            this.b = new tk6(getPageContext(), this, this.a, this.d, this.e, this.f, this.g, this.h, this);
            this.c = new ForumRuleEditModel(getPageContext(), this, this.d);
            setContentView(this.a);
            setSwipeBackEnabled(false);
            A1(this.d);
            addGlobalLayoutListener();
            adjustResizeForSoftInput(R.color.CAM_X0201, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            this.b.F();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, keyEvent)) == null) {
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
        if (interceptable == null || interceptable.invokeII(1048585, this, i, i2) == null) {
            super.overridePendingTransition(R.anim.obfuscated_res_0x7f01000d, R.anim.obfuscated_res_0x7f01000c);
        }
    }

    @Override // com.repackage.lk6
    public void u1(int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
            if (i == 0) {
                Intent intent = getIntent();
                if (z) {
                    this.b.B();
                    intent.putExtra("group_name", getString(R.string.obfuscated_res_0x7f0f108c));
                    intent.putExtra("from", true);
                } else {
                    intent.putExtra("group_name", getString(R.string.obfuscated_res_0x7f0f0691));
                    intent.putExtra("from", false);
                }
                setResult(-1, intent);
                finish();
                return;
            }
            BdTopToast bdTopToast = new BdTopToast(this, 2000);
            bdTopToast.h(false);
            bdTopToast.g(str);
            bdTopToast.i((ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f0913d4));
        }
    }

    public final void z1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
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
