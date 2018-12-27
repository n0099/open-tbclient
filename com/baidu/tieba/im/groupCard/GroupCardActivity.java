package com.baidu.tieba.im.groupCard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.f.c;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.atomData.GroupCardActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tieba.e;
import java.text.MessageFormat;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public class GroupCardActivity extends BaseActivity<GroupCardActivity> implements View.OnClickListener {
    private static String imageUrl = TbConfig.SERVER_ADDRESS + "c/p/groupShareImg?group_id=";
    private com.baidu.tbadk.core.util.b.a bzi;
    private a eVb = null;
    private GroupCardModel eVc = null;
    private long groupId = 0;
    private String groupName = "";
    private String eVd = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData();
    }

    public boolean aPg() {
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.bzi == null) {
            this.bzi = new com.baidu.tbadk.core.util.b.a();
        }
        this.bzi.Et();
        this.bzi.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.bzi.A(pageActivity)) {
            return false;
        }
        if (l.hA()) {
            return true;
        }
        this.eVb.S(0, getPageContext().getString(e.j.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eVb.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eVb.aSM()) {
            if (aPg()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "group_card_save", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                this.eVc.saveImage();
            }
        } else if (view == this.eVb.aSO()) {
            finish();
        } else if (view == this.eVb.aSN()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "group_card_share", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
            Fq();
        }
    }

    private void Fq() {
        sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) getPageContext().getPageActivity(), aSI(), true, xb())));
    }

    private d aSI() {
        d dVar = new d();
        dVar.title = MessageFormat.format(getPageContext().getString(e.j.im_share_title), this.groupName);
        dVar.content = MessageFormat.format(getPageContext().getString(e.j.im_share_content), this.groupName, String.valueOf(this.groupId));
        dVar.linkUrl = TiebaIMConfig.IM_GROUP_SHARE_URL + this.groupId;
        try {
            if (this.eVd == null || this.eVd.equals("")) {
                dVar.g(BitmapFactory.decodeResource(getResources(), e.f.icon));
            } else if (this.eVd.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                dVar.imageUri = Uri.parse(this.eVd);
            } else {
                dVar.g(l.ax(null, TbConfig.GROUP_HEAD_FILE));
            }
        } catch (Throwable th) {
        }
        return dVar;
    }

    private SparseArray<String> xb() {
        SparseArray<String> sparseArray = new SparseArray<>(8);
        sparseArray.put(2, "gc_wx_timeline");
        sparseArray.put(3, "gc_wx_friend");
        sparseArray.put(4, "gc_qq_zone");
        sparseArray.put(5, "gc_tencen_weibo");
        sparseArray.put(6, "gc_sina_weibo");
        sparseArray.put(7, "gc_renren");
        return sparseArray;
    }

    private void initView() {
        this.eVb = new a(this, null);
    }

    private void initData() {
        this.eVb.showProgress();
        Intent intent = getIntent();
        this.groupId = intent.getLongExtra("group_id", 0L);
        this.groupName = intent.getStringExtra("group_name");
        this.eVd = intent.getStringExtra(GroupCardActivityConfig.GROUP_PORTRAIT);
        this.eVc = new GroupCardModel(this.groupId, this);
        if (this.eVc != null) {
            int aO = com.baidu.adp.lib.util.l.aO(getPageContext().getPageActivity()) - com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 10.0f);
            int aQ = (com.baidu.adp.lib.util.l.aQ(getPageContext().getPageActivity()) - this.eVb.aSP().getHeight()) - this.eVb.aSQ().getHeight();
            b<com.baidu.adp.widget.ImageView.a> bVar = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.im.groupCard.GroupCardActivity.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str, i);
                    GroupCardActivity.this.eVb.aHD();
                    if (aVar != null) {
                        GroupCardActivity.this.eVb.g(aVar);
                        GroupCardActivity.this.eVb.aSL();
                        return;
                    }
                    GroupCardActivity.this.eVb.S(0, GroupCardActivity.this.getPageContext().getString(e.j.group_card_error));
                }
            };
            String bp = this.eVc.bp(aO, aQ);
            if (bp != null) {
                c.jA().a(bp, 10, bVar, aO, aQ, getUniqueId(), new Object[0]);
            }
        }
    }
}
