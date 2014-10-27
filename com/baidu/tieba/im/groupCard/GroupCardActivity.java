package com.baidu.tieba.im.groupCard;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.coreExtra.share.h;
import com.baidu.tieba.u;
import com.baidu.tieba.y;
import java.text.MessageFormat;
/* loaded from: classes.dex */
public class GroupCardActivity extends BaseActivity implements View.OnClickListener {
    public static String GROUP_ID = "groupid";
    public static String GROUP_NAME = "groupname";
    public static String aZC = "groupportrait";
    private static String imageUrl = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/p/groupShareImg?group_id=";
    private d aZz = null;
    private b aZA = null;
    private long groupId = 0;
    private String groupName = "";
    private String aZB = "";

    public static void a(Activity activity, long j, String str, String str2) {
        Intent intent = new Intent(activity, GroupCardActivity.class);
        if (j != 0) {
            intent.putExtra(GROUP_ID, j);
            intent.putExtra(GROUP_NAME, str);
            intent.putExtra(aZC, str2);
            activity.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        nu();
        initData();
    }

    public boolean Kf() {
        if (s.bm()) {
            return true;
        }
        this.aZz.showErr(0, getString(y.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aZz.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.aZz.Ot()) {
            if (Kf()) {
                TiebaStatic.eventStat(this, "group_card_save", "click", 1, new Object[0]);
                this.aZA.Oq();
            }
        } else if (view == this.aZz.Ov()) {
            finish();
        } else if (view == this.aZz.Ou()) {
            TiebaStatic.eventStat(this, "group_card_share", "click", 1, new Object[0]);
            Hv();
        }
    }

    private void Hv() {
        h hVar = new h();
        hVar.title = MessageFormat.format(getString(y.im_share_title), this.groupName);
        hVar.content = MessageFormat.format(getString(y.im_share_content), this.groupName, String.valueOf(this.groupId));
        hVar.MW = String.valueOf(TiebaIMConfig.IM_GROUP_SHARE_URL) + this.groupId;
        try {
            hVar.MX = Uri.parse(String.valueOf(imageUrl) + this.groupId + "&w=" + LocalViewSize.lV().lW());
        } catch (Throwable th) {
        }
        com.baidu.tbadk.coreExtra.share.d dVar = new com.baidu.tbadk.coreExtra.share.d(this);
        dVar.a(hVar, true);
        dVar.a(3, Oo(), true);
        dVar.a(getShareMtjStatInfo());
        dVar.show();
    }

    private h Oo() {
        h hVar = new h();
        hVar.title = MessageFormat.format(getString(y.im_share_title), this.groupName);
        hVar.content = MessageFormat.format(getString(y.im_share_content), this.groupName, String.valueOf(this.groupId));
        hVar.MW = String.valueOf(TiebaIMConfig.IM_GROUP_SHARE_URL) + this.groupId;
        try {
            if (this.aZB == null || this.aZB.equals("")) {
                hVar.f(BitmapFactory.decodeResource(getResources(), u.icon));
            } else if (this.aZB.startsWith("http")) {
                hVar.MX = Uri.parse(this.aZB);
            } else {
                hVar.f(s.K(null, TbConfig.GROUP_HEAD_FILE));
            }
        } catch (Throwable th) {
        }
        return hVar;
    }

    private SparseArray<String> getShareMtjStatInfo() {
        SparseArray<String> sparseArray = new SparseArray<>(7);
        sparseArray.put(2, "gc_wx_timeline");
        sparseArray.put(3, "gc_wx_friend");
        sparseArray.put(4, "gc_qq_zone");
        sparseArray.put(5, "gc_tencen_weibo");
        sparseArray.put(6, "gc_sina_weibo");
        sparseArray.put(7, "gc_renren");
        return sparseArray;
    }

    private void nu() {
        this.aZz = new d(this, null);
    }

    private void initData() {
        this.aZz.showProgress();
        Intent intent = getIntent();
        this.groupId = intent.getLongExtra(GROUP_ID, 0L);
        this.groupName = intent.getStringExtra(GROUP_NAME);
        this.aZB = intent.getStringExtra(aZC);
        this.aZA = new b(this.groupId, this);
        if (this.aZA != null) {
            int n = m.n(this) - m.dip2px(this, 10.0f);
            int o = (m.o(this) - this.aZz.Ow().getHeight()) - this.aZz.Ox().getHeight();
            a aVar = new a(this);
            String O = this.aZA.O(n, o);
            if (O != null) {
                com.baidu.adp.lib.f.d.ef().a(O, 10, aVar, n, o, getUniqueId(), new Object[0]);
            }
        }
    }
}
