package com.baidu.tieba.frs.game.strategy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes2.dex */
public class FrsGameStrategyActivity extends BaseFragmentActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FrsGameStrategyMainFragment frsGameStrategyMainFragment = new FrsGameStrategyMainFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("fid", getIntent().getStringExtra("fid"));
        bundle2.putString("name", getIntent().getStringExtra("name"));
        bundle2.putString("key_from", "from_single_act");
        frsGameStrategyMainFragment.setArguments(bundle2);
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        beginTransaction.add(16908290, frsGameStrategyMainFragment);
        beginTransaction.commit();
    }

    public static void w(Context context, String str, String str2) {
        Intent intent = new Intent(context, FrsGameStrategyActivity.class);
        intent.putExtra("fid", str);
        intent.putExtra("name", str2);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }
}
