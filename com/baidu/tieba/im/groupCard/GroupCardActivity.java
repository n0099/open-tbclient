package com.baidu.tieba.im.groupCard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.data.i;
import com.baidu.tieba.f;
import com.baidu.tieba.im.chat.LocalViewSize;
import com.baidu.tieba.im.g;
import com.baidu.tieba.util.af;
import com.baidu.tieba.util.cb;
import com.slidingmenu.lib.R;
import java.text.MessageFormat;
/* loaded from: classes.dex */
public class GroupCardActivity extends f implements View.OnClickListener {
    public static String a = "groupid";
    public static String b = "groupname";
    public static String c = "groupportrait";
    private static String j = String.valueOf(i.a) + "c/p/groupShareImg?group_id=";
    private d d = null;
    private b e = null;
    private long f = 0;
    private String g = "";
    private String h = "";
    private Bitmap i = null;

    public static void a(Activity activity, long j2, String str, String str2) {
        Intent intent = new Intent(activity, GroupCardActivity.class);
        if (j2 != 0) {
            intent.putExtra(a, j2);
            intent.putExtra(b, str);
            intent.putExtra(c, str2);
            activity.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e();
        f();
    }

    public boolean a() {
        if (af.a()) {
            return true;
        }
        this.d.a(0, getString(R.string.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.d.a(i);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.d.g()) {
            if (a() && this.i != null) {
                cb.a(this, "group_card_save", "click", 1, new Object[0]);
                this.e.a(this.i);
            }
        } else if (view == this.d.i()) {
            finish();
        } else if (view == this.d.h()) {
            cb.a(this, "group_card_share", "click", 1, new Object[0]);
            b();
        }
    }

    private void b() {
        com.baidu.tieba.widget.share.f fVar = new com.baidu.tieba.widget.share.f();
        fVar.a = MessageFormat.format(getString(R.string.im_share_title), this.g);
        fVar.b = MessageFormat.format(getString(R.string.im_share_content), this.g, String.valueOf(this.f));
        fVar.c = String.valueOf(g.h) + this.f;
        try {
            fVar.d = Uri.parse(String.valueOf(j) + this.f + "&w=" + LocalViewSize.a().b());
        } catch (Throwable th) {
        }
        com.baidu.tieba.widget.share.d dVar = new com.baidu.tieba.widget.share.d(this);
        dVar.a(fVar, true);
        dVar.a(3, c(), true);
        dVar.a(d());
        dVar.a();
    }

    private com.baidu.tieba.widget.share.f c() {
        com.baidu.tieba.widget.share.f fVar = new com.baidu.tieba.widget.share.f();
        fVar.a = MessageFormat.format(getString(R.string.im_share_title), this.g);
        fVar.b = MessageFormat.format(getString(R.string.im_share_content), this.g, String.valueOf(this.f));
        fVar.c = String.valueOf(g.h) + this.f;
        try {
            if (this.h == null || this.h.equals("")) {
                fVar.a(BitmapFactory.decodeResource(getResources(), R.drawable.icon));
            } else if (this.h.startsWith("http")) {
                fVar.d = Uri.parse(this.h);
            } else {
                fVar.a(af.c(null, "tieba_group_image"));
            }
        } catch (Throwable th) {
        }
        return fVar;
    }

    private SparseArray<String> d() {
        SparseArray<String> sparseArray = new SparseArray<>(7);
        sparseArray.put(2, "gc_wx_timeline");
        sparseArray.put(3, "gc_wx_friend");
        sparseArray.put(4, "gc_qq_zone");
        sparseArray.put(5, "gc_tencen_weibo");
        sparseArray.put(6, "gc_sina_weibo");
        sparseArray.put(7, "gc_renren");
        return sparseArray;
    }

    private void e() {
        this.d = new d(this, null);
    }

    private void f() {
        this.d.a();
        Intent intent = getIntent();
        this.f = intent.getLongExtra(a, 0L);
        this.g = intent.getStringExtra(b);
        this.h = intent.getStringExtra(c);
        this.e = new b(this.f, this);
        if (this.e != null) {
            com.baidu.adp.widget.ImageView.b a2 = this.e.a(this, BdUtilHelper.b(this) - BdUtilHelper.a((Context) this, 10.0f), (BdUtilHelper.c(this) - this.d.j().getHeight()) - this.d.k().getHeight(), new a(this));
            if (a2 != null) {
                this.d.e();
                this.i = a2.h();
                this.d.a(a2);
                this.d.f();
            }
        }
    }
}
