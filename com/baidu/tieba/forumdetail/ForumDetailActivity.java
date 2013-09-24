package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class ForumDetailActivity extends com.baidu.tieba.j {

    /* renamed from: a  reason: collision with root package name */
    private e f1078a = null;
    private String b = "0";
    private String c = "0";
    private d d = new a(this);

    /* loaded from: classes.dex */
    public enum FromType {
        FRS,
        BAR_DIR;

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
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
        c();
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this, getIntent().getStringExtra("from_type").equals(FromType.FRS.toString()) ? "detail_from_frs" : "detail_from_bar_dir", "click", 1);
        }
    }

    private void b() {
        this.f1078a = new e(this);
    }

    private void c() {
        this.b = getIntent().getStringExtra("forum_id");
        this.c = getIntent().getStringExtra("from_type").equals(FromType.FRS.toString()) ? "0" : "1";
        b.a(this.b, this.c, this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void a(int i) {
        super.a(i);
        this.f1078a.a(i);
    }
}
