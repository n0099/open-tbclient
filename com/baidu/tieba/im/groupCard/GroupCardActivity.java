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
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.d.x;
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tieba.im.g;
import com.baidu.tieba.im.j;
import java.text.MessageFormat;
/* loaded from: classes.dex */
public class GroupCardActivity extends com.baidu.tbadk.a implements View.OnClickListener {
    public static String a = "groupid";
    public static String b = "groupname";
    public static String c = "groupportrait";
    private static String j = String.valueOf(n.a) + "c/p/groupShareImg?group_id=";
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
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = new d(this);
        this.d.a();
        Intent intent = getIntent();
        this.f = intent.getLongExtra(a, 0L);
        this.g = intent.getStringExtra(b);
        this.h = intent.getStringExtra(c);
        this.e = new b(this.f, this);
        if (this.e != null) {
            com.baidu.adp.widget.ImageView.b a2 = this.e.a(this, i.b(this) - i.a((Context) this, 10.0f), (i.c(this) - this.d.i().getHeight()) - this.d.j().getHeight(), new a(this));
            if (a2 != null) {
                this.d.d();
                this.i = a2.h();
                this.d.a(a2);
                this.d.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.d.a(i);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        super.onClick(view);
        if (view == this.d.f()) {
            if (w.a()) {
                z = true;
            } else {
                this.d.a(0, getString(j.voice_error_sdcard));
                z = false;
            }
            if (z && this.i != null) {
                TiebaStatic.a(this, "group_card_save", "click", 1, new Object[0]);
                this.e.a(this.i);
            }
        } else if (view == this.d.h()) {
            finish();
        } else if (view == this.d.g()) {
            TiebaStatic.a(this, "group_card_share", "click", 1, new Object[0]);
            f fVar = new f();
            fVar.a = MessageFormat.format(getString(j.im_share_title), this.g);
            fVar.b = MessageFormat.format(getString(j.im_share_content), this.g, String.valueOf(this.f));
            fVar.c = String.valueOf(x.g) + this.f;
            try {
                fVar.d = Uri.parse(String.valueOf(j) + this.f + "&w=" + LocalViewSize.a().b());
            } catch (Throwable th) {
            }
            com.baidu.tbadk.coreExtra.share.d dVar = new com.baidu.tbadk.coreExtra.share.d(this);
            dVar.a(fVar, true);
            dVar.a(3, a(), true);
            SparseArray<String> sparseArray = new SparseArray<>(7);
            sparseArray.put(2, "gc_wx_timeline");
            sparseArray.put(3, "gc_wx_friend");
            sparseArray.put(4, "gc_qq_zone");
            sparseArray.put(5, "gc_tencen_weibo");
            sparseArray.put(6, "gc_sina_weibo");
            sparseArray.put(7, "gc_renren");
            dVar.a(sparseArray);
            dVar.a();
        }
    }

    private f a() {
        f fVar = new f();
        fVar.a = MessageFormat.format(getString(j.im_share_title), this.g);
        fVar.b = MessageFormat.format(getString(j.im_share_content), this.g, String.valueOf(this.f));
        fVar.c = String.valueOf(x.g) + this.f;
        try {
            if (this.h == null || this.h.equals("")) {
                fVar.a(BitmapFactory.decodeResource(getResources(), g.icon));
            } else if (this.h.startsWith("http")) {
                fVar.d = Uri.parse(this.h);
            } else {
                fVar.a(w.c(null, "tieba_group_image"));
            }
        } catch (Throwable th) {
        }
        return fVar;
    }
}
