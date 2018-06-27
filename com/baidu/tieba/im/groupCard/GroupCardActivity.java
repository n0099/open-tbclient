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
    private com.baidu.tbadk.core.util.b.a bkp;
    private a erl = null;
    private GroupCardModel erm = null;
    private long groupId = 0;
    private String groupName = "";
    private String ern = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData();
    }

    public boolean aGA() {
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.bkp == null) {
            this.bkp = new com.baidu.tbadk.core.util.b.a();
        }
        this.bkp.Aj();
        this.bkp.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.bkp.u(pageActivity)) {
            return false;
        }
        if (l.ge()) {
            return true;
        }
        this.erl.T(0, getPageContext().getString(d.k.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.erl.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.erl.aKi()) {
            if (aGA()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "group_card_save", "click", 1, new Object[0]);
                this.erm.saveImage();
            }
        } else if (view == this.erl.aKk()) {
            finish();
        } else if (view == this.erl.aKj()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "group_card_share", "click", 1, new Object[0]);
            AV();
        }
    }

    private void AV() {
        sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) getPageContext().getPageActivity(), aKe(), true, sO())));
    }

    private com.baidu.tbadk.coreExtra.c.d aKe() {
        com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
        dVar.title = MessageFormat.format(getPageContext().getString(d.k.im_share_title), this.groupName);
        dVar.content = MessageFormat.format(getPageContext().getString(d.k.im_share_content), this.groupName, String.valueOf(this.groupId));
        dVar.linkUrl = TiebaIMConfig.IM_GROUP_SHARE_URL + this.groupId;
        try {
            if (this.ern == null || this.ern.equals("")) {
                dVar.f(BitmapFactory.decodeResource(getResources(), d.f.icon));
            } else if (this.ern.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                dVar.imageUri = Uri.parse(this.ern);
            } else {
                dVar.f(l.ab(null, TbConfig.GROUP_HEAD_FILE));
            }
        } catch (Throwable th) {
        }
        return dVar;
    }

    private SparseArray<String> sO() {
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
        this.erl = new a(this, null);
    }

    private void initData() {
        this.erl.showProgress();
        Intent intent = getIntent();
        this.groupId = intent.getLongExtra("group_id", 0L);
        this.groupName = intent.getStringExtra("group_name");
        this.ern = intent.getStringExtra(GroupCardActivityConfig.GROUP_PORTRAIT);
        this.erm = new GroupCardModel(this.groupId, this);
        if (this.erm != null) {
            int ah = com.baidu.adp.lib.util.l.ah(getPageContext().getPageActivity()) - com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 10.0f);
            int aj = (com.baidu.adp.lib.util.l.aj(getPageContext().getPageActivity()) - this.erl.aKl().getHeight()) - this.erl.aKm().getHeight();
            b<com.baidu.adp.widget.ImageView.a> bVar = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.im.groupCard.GroupCardActivity.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str, i);
                    GroupCardActivity.this.erl.azA();
                    if (aVar != null) {
                        GroupCardActivity.this.erl.g(aVar);
                        GroupCardActivity.this.erl.aKh();
                        return;
                    }
                    GroupCardActivity.this.erl.T(0, GroupCardActivity.this.getPageContext().getString(d.k.group_card_error));
                }
            };
            String bf = this.erm.bf(ah, aj);
            if (bf != null) {
                c.ig().a(bf, 10, bVar, ah, aj, getUniqueId(), new Object[0]);
            }
        }
    }
}
