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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.atomData.GroupCardActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.d;
import java.text.MessageFormat;
import org.apache.http.HttpHost;
/* loaded from: classes5.dex */
public class GroupCardActivity extends BaseActivity<GroupCardActivity> implements View.OnClickListener {
    private static String imageUrl = TbConfig.SERVER_ADDRESS + "c/p/groupShareImg?group_id=";
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private a glW = null;
    private GroupCardModel glX = null;
    private long groupId = 0;
    private String groupName = "";
    private String glY = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData();
    }

    public boolean bql() {
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
        }
        this.mPermissionJudgement.adQ();
        this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.mPermissionJudgement.Y(pageActivity)) {
            return false;
        }
        if (m.hy()) {
            return true;
        }
        this.glW.ak(0, getPageContext().getString(d.j.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.glW.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.glW.btR()) {
            if (bql()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "group_card_save", "click", 1, new Object[0]);
                this.glX.saveImage();
            }
        } else if (view == this.glW.btT()) {
            finish();
        } else if (view == this.glW.btS()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "group_card_share", "click", 1, new Object[0]);
            aeX();
        }
    }

    private void aeX() {
        sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) getPageContext().getPageActivity(), btN(), true, VV())));
    }

    private com.baidu.tbadk.coreExtra.c.d btN() {
        com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
        dVar.title = MessageFormat.format(getPageContext().getString(d.j.im_share_title), this.groupName);
        dVar.content = MessageFormat.format(getPageContext().getString(d.j.im_share_content), this.groupName, String.valueOf(this.groupId));
        dVar.linkUrl = TiebaIMConfig.IM_GROUP_SHARE_URL + this.groupId;
        try {
            if (this.glY == null || this.glY.equals("")) {
                dVar.n(BitmapFactory.decodeResource(getResources(), d.f.icon));
            } else if (this.glY.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                dVar.imageUri = Uri.parse(this.glY);
            } else {
                dVar.n(m.bF(null, TbConfig.GROUP_HEAD_FILE));
            }
        } catch (Throwable th) {
        }
        return dVar;
    }

    private SparseArray<String> VV() {
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
        this.glW = new a(this, null);
    }

    private void initData() {
        this.glW.showProgress();
        Intent intent = getIntent();
        this.groupId = intent.getLongExtra("group_id", 0L);
        this.groupName = intent.getStringExtra("group_name");
        this.glY = intent.getStringExtra(GroupCardActivityConfig.GROUP_PORTRAIT);
        this.glX = new GroupCardModel(this.groupId, this);
        if (this.glX != null) {
            int aO = l.aO(getPageContext().getPageActivity()) - l.dip2px(getPageContext().getPageActivity(), 10.0f);
            int aQ = (l.aQ(getPageContext().getPageActivity()) - this.glW.btU().getHeight()) - this.glW.btV().getHeight();
            b<com.baidu.adp.widget.ImageView.a> bVar = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.im.groupCard.GroupCardActivity.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str, i);
                    GroupCardActivity.this.glW.bip();
                    if (aVar != null) {
                        GroupCardActivity.this.glW.g(aVar);
                        GroupCardActivity.this.glW.btQ();
                        return;
                    }
                    GroupCardActivity.this.glW.ak(0, GroupCardActivity.this.getPageContext().getString(d.j.group_card_error));
                }
            };
            String bL = this.glX.bL(aO, aQ);
            if (bL != null) {
                c.jB().a(bL, 10, bVar, aO, aQ, getUniqueId(), new Object[0]);
            }
        }
    }
}
