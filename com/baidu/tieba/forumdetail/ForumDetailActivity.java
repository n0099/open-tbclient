package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class ForumDetailActivity extends BaseActivity {
    private e awS = null;
    private String afQ = "0";
    private String awT = "0";
    private d awU = new a(this);

    /* loaded from: classes.dex */
    public enum FromType {
        FRS,
        BAR_DIR,
        BAR_RANK;

        /* JADX DEBUG: Replace access to removed values field (awW) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static FromType[] valuesCustom() {
            FromType[] valuesCustom = values();
            int length = valuesCustom.length;
            FromType[] fromTypeArr = new FromType[length];
            System.arraycopy(valuesCustom, 0, fromTypeArr, 0, length);
            return fromTypeArr;
        }
    }

    public static void a(Context context, String str, FromType fromType) {
        Intent intent = new Intent(context, ForumDetailActivity.class);
        intent.putExtra("forum_id", str);
        intent.putExtra("from_type", fromType.toString());
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        initData();
        TiebaStatic.eventStat(this, getIntent().getStringExtra("from_type").equals(FromType.FRS.toString()) ? "detail_from_frs" : "detail_from_bar_dir", "click", 1, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.awS.onResume();
    }

    private void initUI() {
        this.awS = new e(this);
    }

    private void initData() {
        this.afQ = getIntent().getStringExtra("forum_id");
        this.awT = getIntent().getStringExtra("from_type").equals(FromType.FRS.toString()) ? "0" : "1";
        b.a(this.afQ, this.awT, this.awU);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.awS.onChangeSkinType(i);
    }
}
