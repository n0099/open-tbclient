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
    private com.baidu.tbadk.core.util.b.a buX;
    private a eKd = null;
    private GroupCardModel eKe = null;
    private long groupId = 0;
    private String groupName = "";
    private String eKf = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData();
    }

    public boolean aNd() {
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.buX == null) {
            this.buX = new com.baidu.tbadk.core.util.b.a();
        }
        this.buX.Di();
        this.buX.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.buX.z(pageActivity)) {
            return false;
        }
        if (l.hB()) {
            return true;
        }
        this.eKd.V(0, getPageContext().getString(e.j.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eKd.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eKd.aQK()) {
            if (aNd()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "group_card_save", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                this.eKe.saveImage();
            }
        } else if (view == this.eKd.aQM()) {
            finish();
        } else if (view == this.eKd.aQL()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "group_card_share", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
            Eb();
        }
    }

    private void Eb() {
        sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) getPageContext().getPageActivity(), aQG(), true, vP())));
    }

    private d aQG() {
        d dVar = new d();
        dVar.title = MessageFormat.format(getPageContext().getString(e.j.im_share_title), this.groupName);
        dVar.content = MessageFormat.format(getPageContext().getString(e.j.im_share_content), this.groupName, String.valueOf(this.groupId));
        dVar.linkUrl = TiebaIMConfig.IM_GROUP_SHARE_URL + this.groupId;
        try {
            if (this.eKf == null || this.eKf.equals("")) {
                dVar.g(BitmapFactory.decodeResource(getResources(), e.f.icon));
            } else if (this.eKf.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                dVar.imageUri = Uri.parse(this.eKf);
            } else {
                dVar.g(l.au(null, TbConfig.GROUP_HEAD_FILE));
            }
        } catch (Throwable th) {
        }
        return dVar;
    }

    private SparseArray<String> vP() {
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
        this.eKd = new a(this, null);
    }

    private void initData() {
        this.eKd.showProgress();
        Intent intent = getIntent();
        this.groupId = intent.getLongExtra("group_id", 0L);
        this.groupName = intent.getStringExtra("group_name");
        this.eKf = intent.getStringExtra(GroupCardActivityConfig.GROUP_PORTRAIT);
        this.eKe = new GroupCardModel(this.groupId, this);
        if (this.eKe != null) {
            int aO = com.baidu.adp.lib.util.l.aO(getPageContext().getPageActivity()) - com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 10.0f);
            int aQ = (com.baidu.adp.lib.util.l.aQ(getPageContext().getPageActivity()) - this.eKd.aQN().getHeight()) - this.eKd.aQO().getHeight();
            b<com.baidu.adp.widget.ImageView.a> bVar = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.im.groupCard.GroupCardActivity.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str, i);
                    GroupCardActivity.this.eKd.aFG();
                    if (aVar != null) {
                        GroupCardActivity.this.eKd.g(aVar);
                        GroupCardActivity.this.eKd.aQJ();
                        return;
                    }
                    GroupCardActivity.this.eKd.V(0, GroupCardActivity.this.getPageContext().getString(e.j.group_card_error));
                }
            };
            String bo = this.eKe.bo(aO, aQ);
            if (bo != null) {
                c.jC().a(bo, 10, bVar, aO, aQ, getUniqueId(), new Object[0]);
            }
        }
    }
}
