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
    private com.baidu.tbadk.core.util.b.a bvI;
    private a eLv = null;
    private GroupCardModel eLw = null;
    private long groupId = 0;
    private String groupName = "";
    private String eLx = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData();
    }

    public boolean aMB() {
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.bvI == null) {
            this.bvI = new com.baidu.tbadk.core.util.b.a();
        }
        this.bvI.Dp();
        this.bvI.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.bvI.A(pageActivity)) {
            return false;
        }
        if (l.hA()) {
            return true;
        }
        this.eLv.R(0, getPageContext().getString(e.j.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eLv.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eLv.aQh()) {
            if (aMB()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "group_card_save", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                this.eLw.saveImage();
            }
        } else if (view == this.eLv.aQj()) {
            finish();
        } else if (view == this.eLv.aQi()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "group_card_share", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
            El();
        }
    }

    private void El() {
        sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) getPageContext().getPageActivity(), aQd(), true, vX())));
    }

    private d aQd() {
        d dVar = new d();
        dVar.title = MessageFormat.format(getPageContext().getString(e.j.im_share_title), this.groupName);
        dVar.content = MessageFormat.format(getPageContext().getString(e.j.im_share_content), this.groupName, String.valueOf(this.groupId));
        dVar.linkUrl = TiebaIMConfig.IM_GROUP_SHARE_URL + this.groupId;
        try {
            if (this.eLx == null || this.eLx.equals("")) {
                dVar.g(BitmapFactory.decodeResource(getResources(), e.f.icon));
            } else if (this.eLx.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                dVar.imageUri = Uri.parse(this.eLx);
            } else {
                dVar.g(l.au(null, TbConfig.GROUP_HEAD_FILE));
            }
        } catch (Throwable th) {
        }
        return dVar;
    }

    private SparseArray<String> vX() {
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
        this.eLv = new a(this, null);
    }

    private void initData() {
        this.eLv.showProgress();
        Intent intent = getIntent();
        this.groupId = intent.getLongExtra("group_id", 0L);
        this.groupName = intent.getStringExtra("group_name");
        this.eLx = intent.getStringExtra(GroupCardActivityConfig.GROUP_PORTRAIT);
        this.eLw = new GroupCardModel(this.groupId, this);
        if (this.eLw != null) {
            int aO = com.baidu.adp.lib.util.l.aO(getPageContext().getPageActivity()) - com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 10.0f);
            int aQ = (com.baidu.adp.lib.util.l.aQ(getPageContext().getPageActivity()) - this.eLv.aQk().getHeight()) - this.eLv.aQl().getHeight();
            b<com.baidu.adp.widget.ImageView.a> bVar = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.im.groupCard.GroupCardActivity.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str, i);
                    GroupCardActivity.this.eLv.aFc();
                    if (aVar != null) {
                        GroupCardActivity.this.eLv.g(aVar);
                        GroupCardActivity.this.eLv.aQg();
                        return;
                    }
                    GroupCardActivity.this.eLv.R(0, GroupCardActivity.this.getPageContext().getString(e.j.group_card_error));
                }
            };
            String bq = this.eLw.bq(aO, aQ);
            if (bq != null) {
                c.jA().a(bq, 10, bVar, aO, aQ, getUniqueId(), new Object[0]);
            }
        }
    }
}
