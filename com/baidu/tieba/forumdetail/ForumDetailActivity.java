package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class ForumDetailActivity extends com.baidu.tieba.j {

    /* renamed from: a  reason: collision with root package name */
    private e f1267a = null;
    private String b = SocialConstants.FALSE;
    private String c = SocialConstants.FALSE;
    private d d = new a(this);

    /* loaded from: classes.dex */
    public enum FromType {
        FRS,
        BAR_DIR,
        BAR_RANK
    }

    public static void a(Context context, String str, FromType fromType) {
        Intent intent = new Intent(context, ForumDetailActivity.class);
        intent.putExtra("forum_id", str);
        intent.putExtra("from_type", fromType.toString());
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
        b();
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this, getIntent().getStringExtra("from_type").equals(FromType.FRS.toString()) ? "detail_from_frs" : "detail_from_bar_dir", "click", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f1267a.a();
    }

    private void a() {
        this.f1267a = new e(this);
    }

    private void b() {
        this.b = getIntent().getStringExtra("forum_id");
        this.c = getIntent().getStringExtra("from_type").equals(FromType.FRS.toString()) ? SocialConstants.FALSE : SocialConstants.TRUE;
        b.a(this.b, this.c, this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.f1267a.a(i);
    }
}
