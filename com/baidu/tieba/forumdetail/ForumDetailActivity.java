package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.util.cb;
/* loaded from: classes.dex */
public class ForumDetailActivity extends com.baidu.tieba.f {
    private e a = null;
    private String b = SocialConstants.FALSE;
    private String c = SocialConstants.FALSE;
    private d d = new a(this);

    /* loaded from: classes.dex */
    public enum FromType {
        FRS,
        BAR_DIR,
        BAR_RANK;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
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
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
        b();
        cb.a(this, getIntent().getStringExtra("from_type").equals(FromType.FRS.toString()) ? "detail_from_frs" : "detail_from_bar_dir", "click", 1, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        this.a.a();
    }

    private void a() {
        this.a = new e(this);
    }

    private void b() {
        this.b = getIntent().getStringExtra("forum_id");
        this.c = getIntent().getStringExtra("from_type").equals(FromType.FRS.toString()) ? SocialConstants.FALSE : SocialConstants.TRUE;
        b.a(this.b, this.c, this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.a(i);
    }
}
