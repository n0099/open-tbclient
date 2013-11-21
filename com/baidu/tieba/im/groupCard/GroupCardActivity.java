package com.baidu.tieba.im.groupCard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.ImageView.e;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.h;
import com.baidu.tieba.im.chat.LocalViewSize;
import com.baidu.tieba.j;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.af;
import com.slidingmenu.lib.R;
import java.text.MessageFormat;
import java.util.HashMap;
/* loaded from: classes.dex */
public class GroupCardActivity extends j implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static String f1661a = "groupid";
    public static String b = "groupname";
    public static String c = "groupportrait";
    private static String j = h.f1201a + "c/p/groupShareImg?group_id=";
    private d d = null;
    private b e = null;
    private long f = 0;
    private String g = "";
    private String h = "";
    private Bitmap i = null;

    public static void a(Activity activity, long j2, String str, String str2) {
        Intent intent = new Intent(activity, GroupCardActivity.class);
        if (j2 != 0) {
            intent.putExtra(f1661a, j2);
            intent.putExtra(b, str);
            intent.putExtra(c, str2);
            activity.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e();
        f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.d.a(i);
    }

    public boolean a() {
        if (af.a()) {
            return true;
        }
        this.d.a(0, getString(R.string.voice_error_sdcard));
        return false;
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.d.g()) {
            if (a() && this.i != null) {
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this, "group_card_save", "click", 1);
                }
                this.e.a(this.i);
            }
        } else if (view == this.d.i()) {
            finish();
        } else if (view == this.d.h()) {
            if (TiebaApplication.g().s()) {
                StatService.onEvent(this, "group_card_share", "click", 1);
            }
            b();
        }
    }

    private void b() {
        ShareContent shareContent = new ShareContent();
        shareContent.setTitle(MessageFormat.format(getString(R.string.im_share_title), this.g));
        shareContent.setContent(MessageFormat.format(getString(R.string.im_share_content), this.g, String.valueOf(this.f)));
        shareContent.setLinkUrl(com.baidu.tieba.im.j.j + this.f);
        try {
            shareContent.setImageUri(Uri.parse(j + this.f + "&w=" + LocalViewSize.a().b()));
        } catch (Throwable th) {
        }
        com.baidu.tieba.widget.share.b bVar = new com.baidu.tieba.widget.share.b(this);
        bVar.a(shareContent, true);
        bVar.a(MediaType.WEIXIN_FRIEND, c(), true);
        bVar.a(d());
        bVar.a();
    }

    private ShareContent c() {
        ShareContent shareContent = new ShareContent();
        shareContent.setTitle(MessageFormat.format(getString(R.string.im_share_title), this.g));
        shareContent.setContent(MessageFormat.format(getString(R.string.im_share_content), this.g, String.valueOf(this.f)));
        shareContent.setLinkUrl(com.baidu.tieba.im.j.j + this.f);
        try {
            if (this.h == null || this.h.equals("")) {
                shareContent.setImageData(BitmapFactory.decodeResource(getResources(), R.drawable.icon));
            } else if (this.h.startsWith("http")) {
                shareContent.setImageUri(Uri.parse(this.h));
            } else {
                shareContent.setImageData(af.d(null, "tieba_group_image"));
            }
        } catch (Throwable th) {
        }
        return shareContent;
    }

    private HashMap<MediaType, String> d() {
        HashMap<MediaType, String> hashMap = new HashMap<>(6);
        hashMap.put(MediaType.WEIXIN_TIMELINE, "gc_wx_timeline");
        hashMap.put(MediaType.WEIXIN_FRIEND, "gc_wx_friend");
        hashMap.put(MediaType.QZONE, "gc_qq_zone");
        hashMap.put(MediaType.QQWEIBO, "gc_tencen_weibo");
        hashMap.put(MediaType.SINAWEIBO, "gc_sina_weibo");
        hashMap.put(MediaType.RENREN, "gc_renren");
        return hashMap;
    }

    private void e() {
        this.d = new d(this, null);
    }

    private void f() {
        this.d.a();
        Intent intent = getIntent();
        this.f = intent.getLongExtra(f1661a, 0L);
        this.g = intent.getStringExtra(b);
        this.h = intent.getStringExtra(c);
        this.e = new b(this.f, this);
        if (this.e != null) {
            e a2 = this.e.a(this, UtilHelper.a((Context) this) - UtilHelper.a((Context) this, 10.0f), (UtilHelper.b((Context) this) - this.d.j().getHeight()) - this.d.k().getHeight(), new a(this));
            if (a2 != null) {
                this.d.e();
                this.i = a2.f();
                this.d.a(a2);
                this.d.f();
            }
        }
    }
}
