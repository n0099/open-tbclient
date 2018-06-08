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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.atomData.GroupCardActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.l;
import com.baidu.tieba.d;
import java.text.MessageFormat;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public class GroupCardActivity extends BaseActivity<GroupCardActivity> implements View.OnClickListener {
    private static String imageUrl = TbConfig.SERVER_ADDRESS + "c/p/groupShareImg?group_id=";
    private com.baidu.tbadk.core.util.b.a biP;
    private a enr = null;
    private GroupCardModel ens = null;
    private long groupId = 0;
    private String groupName = "";
    private String ent = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData();
    }

    public boolean aFS() {
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.biP == null) {
            this.biP = new com.baidu.tbadk.core.util.b.a();
        }
        this.biP.zU();
        this.biP.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.biP.u(pageActivity)) {
            return false;
        }
        if (l.ge()) {
            return true;
        }
        this.enr.W(0, getPageContext().getString(d.k.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.enr.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.enr.aJB()) {
            if (aFS()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "group_card_save", "click", 1, new Object[0]);
                this.ens.saveImage();
            }
        } else if (view == this.enr.aJD()) {
            finish();
        } else if (view == this.enr.aJC()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "group_card_share", "click", 1, new Object[0]);
            AD();
        }
    }

    private void AD() {
        sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) getPageContext().getPageActivity(), aJx(), true, sM())));
    }

    private com.baidu.tbadk.coreExtra.c.d aJx() {
        com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
        dVar.title = MessageFormat.format(getPageContext().getString(d.k.im_share_title), this.groupName);
        dVar.content = MessageFormat.format(getPageContext().getString(d.k.im_share_content), this.groupName, String.valueOf(this.groupId));
        dVar.linkUrl = TiebaIMConfig.IM_GROUP_SHARE_URL + this.groupId;
        try {
            if (this.ent == null || this.ent.equals("")) {
                dVar.f(BitmapFactory.decodeResource(getResources(), d.f.icon));
            } else if (this.ent.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                dVar.aFj = Uri.parse(this.ent);
            } else {
                dVar.f(l.ab(null, TbConfig.GROUP_HEAD_FILE));
            }
        } catch (Throwable th) {
        }
        return dVar;
    }

    private SparseArray<String> sM() {
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
        this.enr = new a(this, null);
    }

    private void initData() {
        this.enr.showProgress();
        Intent intent = getIntent();
        this.groupId = intent.getLongExtra("group_id", 0L);
        this.groupName = intent.getStringExtra("group_name");
        this.ent = intent.getStringExtra(GroupCardActivityConfig.GROUP_PORTRAIT);
        this.ens = new GroupCardModel(this.groupId, this);
        if (this.ens != null) {
            int ah = com.baidu.adp.lib.util.l.ah(getPageContext().getPageActivity()) - com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 10.0f);
            int aj = (com.baidu.adp.lib.util.l.aj(getPageContext().getPageActivity()) - this.enr.aJE().getHeight()) - this.enr.aJF().getHeight();
            b<com.baidu.adp.widget.ImageView.a> bVar = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.im.groupCard.GroupCardActivity.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str, i);
                    GroupCardActivity.this.enr.ayU();
                    if (aVar != null) {
                        GroupCardActivity.this.enr.g(aVar);
                        GroupCardActivity.this.enr.aJA();
                        return;
                    }
                    GroupCardActivity.this.enr.W(0, GroupCardActivity.this.getPageContext().getString(d.k.group_card_error));
                }
            };
            String bg = this.ens.bg(ah, aj);
            if (bg != null) {
                c.ig().a(bg, 10, bVar, ah, aj, getUniqueId(), new Object[0]);
            }
        }
    }
}
