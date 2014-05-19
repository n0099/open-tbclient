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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.h;
import com.baidu.tieba.q;
import com.baidu.tieba.u;
import java.text.MessageFormat;
/* loaded from: classes.dex */
public class GroupCardActivity extends BaseActivity implements View.OnClickListener {
    public static String a = "groupid";
    public static String b = "groupname";
    public static String c = "groupportrait";
    private static String j = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/p/groupShareImg?group_id=";
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
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e();
        f();
    }

    public boolean a() {
        if (x.a()) {
            return true;
        }
        this.d.a(0, getString(u.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.d.a(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.d.d()) {
            if (a() && this.i != null) {
                TiebaStatic.eventStat(this, "group_card_save", "click", 1, new Object[0]);
                this.e.a(this.i);
            }
        } else if (view == this.d.f()) {
            finish();
        } else if (view == this.d.e()) {
            TiebaStatic.eventStat(this, "group_card_share", "click", 1, new Object[0]);
            b();
        }
    }

    private void b() {
        f fVar = new f();
        fVar.a = MessageFormat.format(getString(u.im_share_title), this.g);
        fVar.b = MessageFormat.format(getString(u.im_share_content), this.g, String.valueOf(this.f));
        fVar.c = String.valueOf(h.g) + this.f;
        try {
            fVar.d = Uri.parse(String.valueOf(j) + this.f + "&w=" + LocalViewSize.a().b());
        } catch (Throwable th) {
        }
        com.baidu.tbadk.coreExtra.share.d dVar = new com.baidu.tbadk.coreExtra.share.d(this);
        dVar.a(fVar, true);
        dVar.a(3, c(), true);
        dVar.a(d());
        dVar.a();
    }

    private f c() {
        f fVar = new f();
        fVar.a = MessageFormat.format(getString(u.im_share_title), this.g);
        fVar.b = MessageFormat.format(getString(u.im_share_content), this.g, String.valueOf(this.f));
        fVar.c = String.valueOf(h.g) + this.f;
        try {
            if (this.h == null || this.h.equals("")) {
                fVar.a(BitmapFactory.decodeResource(getResources(), q.icon));
            } else if (this.h.startsWith("http")) {
                fVar.d = Uri.parse(this.h);
            } else {
                fVar.a(x.c(null, TbConfig.GROUP_HEAD_FILE));
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
            com.baidu.adp.widget.a.a a2 = this.e.a(this, com.baidu.adp.lib.util.h.b(this) - com.baidu.adp.lib.util.h.a((Context) this, 10.0f), (com.baidu.adp.lib.util.h.c(this) - this.d.g().getHeight()) - this.d.h().getHeight(), new a(this));
            if (a2 != null) {
                this.d.b();
                this.i = a2.h();
                this.d.a(a2);
                this.d.c();
            }
        }
    }
}
