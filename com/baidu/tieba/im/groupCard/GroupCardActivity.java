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
    private com.baidu.tbadk.core.util.b.a bQQ;
    private a eGq = null;
    private GroupCardModel eGr = null;
    private long groupId = 0;
    private String groupName = "";
    private String eGs = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData();
    }

    public boolean aFZ() {
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.bQQ == null) {
            this.bQQ = new com.baidu.tbadk.core.util.b.a();
        }
        this.bQQ.DI();
        this.bQQ.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.bQQ.v(pageActivity)) {
            return false;
        }
        if (k.lk()) {
            return true;
        }
        this.eGq.N(0, getPageContext().getString(d.j.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eGq.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eGq.aJL()) {
            if (aFZ()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "group_card_save", "click", 1, new Object[0]);
                this.eGr.saveImage();
            }
        } else if (view == this.eGq.aJN()) {
            finish();
        } else if (view == this.eGq.aJM()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "group_card_share", "click", 1, new Object[0]);
            Es();
        }
    }

    private void Es() {
        sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) getPageContext().getPageActivity(), aJH(), true, wI())));
    }

    private com.baidu.tbadk.coreExtra.c.d aJH() {
        com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
        dVar.title = MessageFormat.format(getPageContext().getString(d.j.im_share_title), this.groupName);
        dVar.content = MessageFormat.format(getPageContext().getString(d.j.im_share_content), this.groupName, String.valueOf(this.groupId));
        dVar.linkUrl = TiebaIMConfig.IM_GROUP_SHARE_URL + this.groupId;
        try {
            if (this.eGs == null || this.eGs.equals("")) {
                dVar.j(BitmapFactory.decodeResource(getResources(), d.f.icon));
            } else if (this.eGs.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                dVar.blB = Uri.parse(this.eGs);
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
        this.eGq = new a(this, null);
    }

    private void initData() {
        this.eGq.showProgress();
        Intent intent = getIntent();
        this.groupId = intent.getLongExtra("group_id", 0L);
        this.groupName = intent.getStringExtra("group_name");
        this.eGs = intent.getStringExtra(GroupCardActivityConfig.GROUP_PORTRAIT);
        this.eGr = new GroupCardModel(this.groupId, this);
        if (this.eGr != null) {
            int ao = l.ao(getPageContext().getPageActivity()) - l.dip2px(getPageContext().getPageActivity(), 10.0f);
            int aq = (l.aq(getPageContext().getPageActivity()) - this.eGq.aJO().getHeight()) - this.eGq.aJP().getHeight();
            b<com.baidu.adp.widget.a.a> bVar = new b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.im.groupCard.GroupCardActivity.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str, i);
                    GroupCardActivity.this.eGq.azT();
                    if (aVar != null) {
                        GroupCardActivity.this.eGq.g(aVar);
                        GroupCardActivity.this.eGq.aJK();
                        return;
                    }
                    GroupCardActivity.this.eGq.N(0, GroupCardActivity.this.getPageContext().getString(d.j.group_card_error));
                }
            };
            String cd = this.eGr.cd(ao, aq);
            if (cd != null) {
                c.nm().a(cd, 10, bVar, ao, aq, getUniqueId(), new Object[0]);
            }
        }
    }
}
