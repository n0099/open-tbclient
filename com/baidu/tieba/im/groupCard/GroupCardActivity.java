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
    private com.baidu.tbadk.core.util.b.a baE;
    private a ecd = null;
    private GroupCardModel ece = null;
    private long groupId = 0;
    private String groupName = "";
    private String ecf = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData();
    }

    public boolean aAX() {
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.baE == null) {
            this.baE = new com.baidu.tbadk.core.util.b.a();
        }
        this.baE.wt();
        this.baE.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.baE.v(pageActivity)) {
            return false;
        }
        if (k.m15do()) {
            return true;
        }
        this.ecd.W(0, getPageContext().getString(d.k.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ecd.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        super.onClick(view2);
        if (view2 == this.ecd.aEG()) {
            if (aAX()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "group_card_save", "click", 1, new Object[0]);
                this.ece.saveImage();
            }
        } else if (view2 == this.ecd.aEI()) {
            finish();
        } else if (view2 == this.ecd.aEH()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "group_card_share", "click", 1, new Object[0]);
            xc();
        }
    }

    private void xc() {
        sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) getPageContext().getPageActivity(), aEC(), true, pr())));
    }

    private com.baidu.tbadk.coreExtra.c.d aEC() {
        com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
        dVar.title = MessageFormat.format(getPageContext().getString(d.k.im_share_title), this.groupName);
        dVar.content = MessageFormat.format(getPageContext().getString(d.k.im_share_content), this.groupName, String.valueOf(this.groupId));
        dVar.linkUrl = TiebaIMConfig.IM_GROUP_SHARE_URL + this.groupId;
        try {
            if (this.ecf == null || this.ecf.equals("")) {
                dVar.g(BitmapFactory.decodeResource(getResources(), d.f.icon));
            } else if (this.ecf.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                dVar.awW = Uri.parse(this.ecf);
            } else {
                dVar.g(k.Y(null, TbConfig.GROUP_HEAD_FILE));
            }
        } catch (Throwable th) {
        }
        return dVar;
    }

    private SparseArray<String> pr() {
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
        this.ecd = new a(this, null);
    }

    private void initData() {
        this.ecd.showProgress();
        Intent intent = getIntent();
        this.groupId = intent.getLongExtra("group_id", 0L);
        this.groupName = intent.getStringExtra("group_name");
        this.ecf = intent.getStringExtra(GroupCardActivityConfig.GROUP_PORTRAIT);
        this.ece = new GroupCardModel(this.groupId, this);
        if (this.ece != null) {
            int af = l.af(getPageContext().getPageActivity()) - l.dip2px(getPageContext().getPageActivity(), 10.0f);
            int ah = (l.ah(getPageContext().getPageActivity()) - this.ecd.aEJ().getHeight()) - this.ecd.aEK().getHeight();
            b<com.baidu.adp.widget.ImageView.a> bVar = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.im.groupCard.GroupCardActivity.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str, i);
                    GroupCardActivity.this.ecd.auK();
                    if (aVar != null) {
                        GroupCardActivity.this.ecd.g(aVar);
                        GroupCardActivity.this.ecd.aEF();
                        return;
                    }
                    GroupCardActivity.this.ecd.W(0, GroupCardActivity.this.getPageContext().getString(d.k.group_card_error));
                }
            };
            String be = this.ece.be(af, ah);
            if (be != null) {
                c.fp().a(be, 10, bVar, af, ah, getUniqueId(), new Object[0]);
            }
        }
    }
}
