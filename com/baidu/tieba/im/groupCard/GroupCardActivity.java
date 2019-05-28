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
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tieba.R;
import java.text.MessageFormat;
import org.apache.http.HttpHost;
/* loaded from: classes5.dex */
public class GroupCardActivity extends BaseActivity<GroupCardActivity> implements View.OnClickListener {
    private static String imageUrl = TbConfig.SERVER_ADDRESS + "c/p/groupShareImg?group_id=";
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private a gCY = null;
    private GroupCardModel gCZ = null;
    private long groupId = 0;
    private String groupName = "";
    private String gDa = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData();
    }

    public boolean bxX() {
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
        }
        this.mPermissionJudgement.aiM();
        this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.mPermissionJudgement.aa(pageActivity)) {
            return false;
        }
        if (m.gs()) {
            return true;
        }
        this.gCY.ap(0, getPageContext().getString(R.string.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gCY.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gCY.bBD()) {
            if (bxX()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "group_card_save", "click", 1, new Object[0]);
                this.gCZ.saveImage();
            }
        } else if (view == this.gCY.bBF()) {
            finish();
        } else if (view == this.gCY.bBE()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "group_card_share", "click", 1, new Object[0]);
            ajT();
        }
    }

    private void ajT() {
        sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) getPageContext().getPageActivity(), bBz(), true, aay())));
    }

    private e bBz() {
        e eVar = new e();
        eVar.title = MessageFormat.format(getPageContext().getString(R.string.im_share_title), this.groupName);
        eVar.content = MessageFormat.format(getPageContext().getString(R.string.im_share_content), this.groupName, String.valueOf(this.groupId));
        eVar.linkUrl = TiebaIMConfig.IM_GROUP_SHARE_URL + this.groupId;
        try {
            if (this.gDa == null || this.gDa.equals("")) {
                eVar.n(BitmapFactory.decodeResource(getResources(), R.drawable.icon));
            } else if (this.gDa.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                eVar.imageUri = Uri.parse(this.gDa);
            } else {
                eVar.n(m.bP(null, TbConfig.GROUP_HEAD_FILE));
            }
        } catch (Throwable th) {
        }
        return eVar;
    }

    private SparseArray<String> aay() {
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
        this.gCY = new a(this, null);
    }

    private void initData() {
        this.gCY.showProgress();
        Intent intent = getIntent();
        this.groupId = intent.getLongExtra("group_id", 0L);
        this.groupName = intent.getStringExtra("group_name");
        this.gDa = intent.getStringExtra(GroupCardActivityConfig.GROUP_PORTRAIT);
        this.gCZ = new GroupCardModel(this.groupId, this);
        if (this.gCZ != null) {
            int af = l.af(getPageContext().getPageActivity()) - l.dip2px(getPageContext().getPageActivity(), 10.0f);
            int ah = (l.ah(getPageContext().getPageActivity()) - this.gCY.bBG().getHeight()) - this.gCY.bBH().getHeight();
            b<com.baidu.adp.widget.ImageView.a> bVar = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.im.groupCard.GroupCardActivity.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str, i);
                    GroupCardActivity.this.gCY.bpG();
                    if (aVar != null) {
                        GroupCardActivity.this.gCY.g(aVar);
                        GroupCardActivity.this.gCY.bBC();
                        return;
                    }
                    GroupCardActivity.this.gCY.ap(0, GroupCardActivity.this.getPageContext().getString(R.string.group_card_error));
                }
            };
            String bS = this.gCZ.bS(af, ah);
            if (bS != null) {
                c.iv().a(bS, 10, bVar, af, ah, getUniqueId(), new Object[0]);
            }
        }
    }
}
