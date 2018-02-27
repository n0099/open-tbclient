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
import com.baidu.tbadk.core.util.k;
import com.baidu.tieba.d;
import java.text.MessageFormat;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public class GroupCardActivity extends BaseActivity<GroupCardActivity> implements View.OnClickListener {
    private static String imageUrl = TbConfig.SERVER_ADDRESS + "c/p/groupShareImg?group_id=";
    private com.baidu.tbadk.core.util.b.a bQD;
    private a eGe = null;
    private GroupCardModel eGf = null;
    private long groupId = 0;
    private String groupName = "";
    private String eGg = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData();
    }

    public boolean aFY() {
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.bQD == null) {
            this.bQD = new com.baidu.tbadk.core.util.b.a();
        }
        this.bQD.DH();
        this.bQD.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.bQD.v(pageActivity)) {
            return false;
        }
        if (k.lk()) {
            return true;
        }
        this.eGe.N(0, getPageContext().getString(d.j.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eGe.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eGe.aJK()) {
            if (aFY()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "group_card_save", "click", 1, new Object[0]);
                this.eGf.saveImage();
            }
        } else if (view == this.eGe.aJM()) {
            finish();
        } else if (view == this.eGe.aJL()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "group_card_share", "click", 1, new Object[0]);
            Er();
        }
    }

    private void Er() {
        sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) getPageContext().getPageActivity(), aJG(), true, wI())));
    }

    private com.baidu.tbadk.coreExtra.c.d aJG() {
        com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
        dVar.title = MessageFormat.format(getPageContext().getString(d.j.im_share_title), this.groupName);
        dVar.content = MessageFormat.format(getPageContext().getString(d.j.im_share_content), this.groupName, String.valueOf(this.groupId));
        dVar.linkUrl = TiebaIMConfig.IM_GROUP_SHARE_URL + this.groupId;
        try {
            if (this.eGg == null || this.eGg.equals("")) {
                dVar.j(BitmapFactory.decodeResource(getResources(), d.f.icon));
            } else if (this.eGg.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                dVar.blo = Uri.parse(this.eGg);
            } else {
                dVar.j(k.X(null, TbConfig.GROUP_HEAD_FILE));
            }
        } catch (Throwable th) {
        }
        return dVar;
    }

    private SparseArray<String> wI() {
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
        this.eGe = new a(this, null);
    }

    private void initData() {
        this.eGe.showProgress();
        Intent intent = getIntent();
        this.groupId = intent.getLongExtra("group_id", 0L);
        this.groupName = intent.getStringExtra("group_name");
        this.eGg = intent.getStringExtra(GroupCardActivityConfig.GROUP_PORTRAIT);
        this.eGf = new GroupCardModel(this.groupId, this);
        if (this.eGf != null) {
            int ao = l.ao(getPageContext().getPageActivity()) - l.dip2px(getPageContext().getPageActivity(), 10.0f);
            int aq = (l.aq(getPageContext().getPageActivity()) - this.eGe.aJN().getHeight()) - this.eGe.aJO().getHeight();
            b<com.baidu.adp.widget.a.a> bVar = new b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.im.groupCard.GroupCardActivity.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str, i);
                    GroupCardActivity.this.eGe.azS();
                    if (aVar != null) {
                        GroupCardActivity.this.eGe.g(aVar);
                        GroupCardActivity.this.eGe.aJJ();
                        return;
                    }
                    GroupCardActivity.this.eGe.N(0, GroupCardActivity.this.getPageContext().getString(d.j.group_card_error));
                }
            };
            String cd = this.eGf.cd(ao, aq);
            if (cd != null) {
                c.nm().a(cd, 10, bVar, ao, aq, getUniqueId(), new Object[0]);
            }
        }
    }
}
