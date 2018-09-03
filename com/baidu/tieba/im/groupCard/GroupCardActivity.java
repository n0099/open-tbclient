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
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tieba.f;
import java.text.MessageFormat;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public class GroupCardActivity extends BaseActivity<GroupCardActivity> implements View.OnClickListener {
    private static String imageUrl = TbConfig.SERVER_ADDRESS + "c/p/groupShareImg?group_id=";
    private com.baidu.tbadk.core.util.b.a bkZ;
    private a eva = null;
    private GroupCardModel evb = null;
    private long groupId = 0;
    private String groupName = "";
    private String evc = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData();
    }

    public boolean aHx() {
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.bkZ == null) {
            this.bkZ = new com.baidu.tbadk.core.util.b.a();
        }
        this.bkZ.zW();
        this.bkZ.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.bkZ.u(pageActivity)) {
            return false;
        }
        if (l.gd()) {
            return true;
        }
        this.eva.V(0, getPageContext().getString(f.j.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eva.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eva.aLg()) {
            if (aHx()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "group_card_save", "click", 1, new Object[0]);
                this.evb.saveImage();
            }
        } else if (view == this.eva.aLi()) {
            finish();
        } else if (view == this.eva.aLh()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "group_card_share", "click", 1, new Object[0]);
            AJ();
        }
    }

    private void AJ() {
        sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) getPageContext().getPageActivity(), aLc(), true, sz())));
    }

    private d aLc() {
        d dVar = new d();
        dVar.title = MessageFormat.format(getPageContext().getString(f.j.im_share_title), this.groupName);
        dVar.content = MessageFormat.format(getPageContext().getString(f.j.im_share_content), this.groupName, String.valueOf(this.groupId));
        dVar.linkUrl = TiebaIMConfig.IM_GROUP_SHARE_URL + this.groupId;
        try {
            if (this.evc == null || this.evc.equals("")) {
                dVar.f(BitmapFactory.decodeResource(getResources(), f.C0146f.icon));
            } else if (this.evc.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                dVar.imageUri = Uri.parse(this.evc);
            } else {
                dVar.f(l.aa(null, TbConfig.GROUP_HEAD_FILE));
            }
        } catch (Throwable th) {
        }
        return dVar;
    }

    private SparseArray<String> sz() {
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
        this.eva = new a(this, null);
    }

    private void initData() {
        this.eva.showProgress();
        Intent intent = getIntent();
        this.groupId = intent.getLongExtra("group_id", 0L);
        this.groupName = intent.getStringExtra("group_name");
        this.evc = intent.getStringExtra(GroupCardActivityConfig.GROUP_PORTRAIT);
        this.evb = new GroupCardModel(this.groupId, this);
        if (this.evb != null) {
            int ah = com.baidu.adp.lib.util.l.ah(getPageContext().getPageActivity()) - com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 10.0f);
            int aj = (com.baidu.adp.lib.util.l.aj(getPageContext().getPageActivity()) - this.eva.aLj().getHeight()) - this.eva.aLk().getHeight();
            b<com.baidu.adp.widget.ImageView.a> bVar = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.im.groupCard.GroupCardActivity.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str, i);
                    GroupCardActivity.this.eva.aAe();
                    if (aVar != null) {
                        GroupCardActivity.this.eva.g(aVar);
                        GroupCardActivity.this.eva.aLf();
                        return;
                    }
                    GroupCardActivity.this.eva.V(0, GroupCardActivity.this.getPageContext().getString(f.j.group_card_error));
                }
            };
            String bh = this.evb.bh(ah, aj);
            if (bh != null) {
                c.ih().a(bh, 10, bVar, ah, aj, getUniqueId(), new Object[0]);
            }
        }
    }
}
