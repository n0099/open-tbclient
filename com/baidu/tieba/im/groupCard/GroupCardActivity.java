package com.baidu.tieba.im.groupCard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.coreExtra.share.h;
import com.baidu.tbadk.k;
import com.baidu.tieba.t;
import com.baidu.tieba.x;
import java.text.MessageFormat;
/* loaded from: classes.dex */
public class GroupCardActivity extends BaseActivity implements View.OnClickListener {
    public static String a = "groupid";
    public static String b = "groupname";
    public static String c = "groupportrait";
    private static String i = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/p/groupShareImg?group_id=";
    private d d = null;
    private b e = null;
    private long f = 0;
    private String g = "";
    private String h = "";

    public static void a(Activity activity, long j, String str, String str2) {
        Intent intent = new Intent(activity, GroupCardActivity.class);
        if (j != 0) {
            intent.putExtra(a, j);
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
        if (s.a()) {
            return true;
        }
        this.d.a(0, getString(x.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.d.a(i2);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.d.d()) {
            if (a()) {
                TiebaStatic.eventStat(this, "group_card_save", "click", 1, new Object[0]);
                this.e.b();
            }
        } else if (view == this.d.f()) {
            finish();
        } else if (view == this.d.e()) {
            TiebaStatic.eventStat(this, "group_card_share", "click", 1, new Object[0]);
            b();
        }
    }

    private void b() {
        h hVar = new h();
        hVar.a = MessageFormat.format(getString(x.im_share_title), this.g);
        hVar.b = MessageFormat.format(getString(x.im_share_content), this.g, String.valueOf(this.f));
        hVar.c = String.valueOf(k.h) + this.f;
        try {
            hVar.d = Uri.parse(String.valueOf(i) + this.f + "&w=" + LocalViewSize.a().b());
        } catch (Throwable th) {
        }
        com.baidu.tbadk.coreExtra.share.d dVar = new com.baidu.tbadk.coreExtra.share.d(this);
        dVar.b(false);
        dVar.a(false);
        dVar.a(hVar, true);
        dVar.a(3, c(), true);
        dVar.a(d());
        dVar.a();
    }

    private h c() {
        h hVar = new h();
        hVar.a = MessageFormat.format(getString(x.im_share_title), this.g);
        hVar.b = MessageFormat.format(getString(x.im_share_content), this.g, String.valueOf(this.f));
        hVar.c = String.valueOf(k.h) + this.f;
        try {
            if (this.h == null || this.h.equals("")) {
                hVar.a(BitmapFactory.decodeResource(getResources(), t.icon));
            } else if (this.h.startsWith("http")) {
                hVar.d = Uri.parse(this.h);
            } else {
                hVar.a(s.c(null, TbConfig.GROUP_HEAD_FILE));
            }
        } catch (Throwable th) {
        }
        return hVar;
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
            int b2 = j.b(this) - j.a((Context) this, 10.0f);
            int c2 = (j.c(this) - this.d.g().getHeight()) - this.d.h().getHeight();
            a aVar = new a(this);
            String a2 = this.e.a(b2, c2);
            if (a2 != null) {
                com.baidu.adp.lib.resourceLoader.d.a().a(a2, 10, aVar, b2, c2, getUniqueId(), new Object[0]);
            }
        }
    }
}
