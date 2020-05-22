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
import com.baidu.adp.lib.e.b;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.atomData.GroupCardActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import java.text.MessageFormat;
import org.apache.http.HttpHost;
/* loaded from: classes10.dex */
public class GroupCardActivity extends BaseActivity<GroupCardActivity> implements View.OnClickListener {
    private static String imageUrl = TbConfig.SERVER_ADDRESS + "c/p/groupShareImg?group_id=";
    private PermissionJudgePolicy mPermissionJudgement;
    private a iCY = null;
    private GroupCardModel iCZ = null;
    private long groupId = 0;
    private String groupName = "";
    private String iDa = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData();
    }

    public boolean cjF() {
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.mPermissionJudgement.startRequestPermission(pageActivity)) {
            return false;
        }
        if (m.checkSD()) {
            return true;
        }
        this.iCY.bd(0, getPageContext().getString(R.string.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iCY.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iCY.cnl()) {
            if (cjF()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "group_card_save", "click", 1, new Object[0]);
                this.iCZ.saveImage();
            }
        } else if (view == this.iCY.cnn()) {
            finish();
        } else if (view == this.iCY.cnm()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "group_card_share", "click", 1, new Object[0]);
            aWI();
        }
    }

    private void aWI() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) getPageContext().getPageActivity(), cnh(), true, aNI())));
    }

    private ShareItem cnh() {
        ShareItem shareItem = new ShareItem();
        shareItem.title = MessageFormat.format(getPageContext().getString(R.string.im_share_title), this.groupName);
        shareItem.content = MessageFormat.format(getPageContext().getString(R.string.im_share_content), this.groupName, String.valueOf(this.groupId));
        shareItem.linkUrl = TiebaIMConfig.IM_GROUP_SHARE_URL + this.groupId;
        try {
            if (this.iDa == null || this.iDa.equals("")) {
                shareItem.s(BitmapFactory.decodeResource(getResources(), R.drawable.tb_launcher_icon));
            } else if (this.iDa.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                shareItem.imageUri = Uri.parse(this.iDa);
            } else {
                shareItem.s(m.getImage(null, TbConfig.GROUP_HEAD_FILE));
            }
        } catch (Throwable th) {
        }
        return shareItem;
    }

    private SparseArray<String> aNI() {
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
        this.iCY = new a(this, null);
    }

    private void initData() {
        this.iCY.showProgress();
        Intent intent = getIntent();
        this.groupId = intent.getLongExtra("group_id", 0L);
        this.groupName = intent.getStringExtra("group_name");
        this.iDa = intent.getStringExtra(GroupCardActivityConfig.GROUP_PORTRAIT);
        this.iCZ = new GroupCardModel(this.groupId, this);
        if (this.iCZ != null) {
            int equipmentWidth = l.getEquipmentWidth(getPageContext().getPageActivity()) - l.dip2px(getPageContext().getPageActivity(), 10.0f);
            int equipmentHeight = (l.getEquipmentHeight(getPageContext().getPageActivity()) - this.iCY.cno().getHeight()) - this.iCY.cnp().getHeight();
            b<com.baidu.adp.widget.ImageView.a> bVar = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.im.groupCard.GroupCardActivity.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str, i);
                    GroupCardActivity.this.iCY.caU();
                    if (aVar != null) {
                        GroupCardActivity.this.iCY.i(aVar);
                        GroupCardActivity.this.iCY.cnk();
                        return;
                    }
                    GroupCardActivity.this.iCY.bd(0, GroupCardActivity.this.getPageContext().getString(R.string.group_card_error));
                }
            };
            String cu = this.iCZ.cu(equipmentWidth, equipmentHeight);
            if (cu != null) {
                c.kX().a(cu, 10, bVar, equipmentWidth, equipmentHeight, getUniqueId(), new Object[0]);
            }
        }
    }
}
