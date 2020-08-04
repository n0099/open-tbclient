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
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import java.text.MessageFormat;
import org.apache.http.HttpHost;
/* loaded from: classes17.dex */
public class GroupCardActivity extends BaseActivity<GroupCardActivity> implements View.OnClickListener {
    private static String imageUrl = TbConfig.SERVER_ADDRESS + "c/p/groupShareImg?group_id=";
    private PermissionJudgePolicy mPermissionJudgement;
    private a jdb = null;
    private GroupCardModel jdc = null;
    private long groupId = 0;
    private String groupName = "";
    private String jdd = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData();
    }

    public boolean cre() {
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.mPermissionJudgement.startRequestPermission(pageActivity)) {
            return false;
        }
        if (n.checkSD()) {
            return true;
        }
        this.jdb.bj(0, getPageContext().getString(R.string.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jdb.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jdb.cvi()) {
            if (cre()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "group_card_save", "click", 1, new Object[0]);
                this.jdc.saveImage();
            }
        } else if (view == this.jdb.cvk()) {
            finish();
        } else if (view == this.jdb.cvj()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "group_card_share", "click", 1, new Object[0]);
            bcy();
        }
    }

    private void bcy() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) getPageContext().getPageActivity(), cve(), true, aTh())));
    }

    private ShareItem cve() {
        ShareItem shareItem = new ShareItem();
        shareItem.title = MessageFormat.format(getPageContext().getString(R.string.im_share_title), this.groupName);
        shareItem.content = MessageFormat.format(getPageContext().getString(R.string.im_share_content), this.groupName, String.valueOf(this.groupId));
        shareItem.linkUrl = TiebaIMConfig.IM_GROUP_SHARE_URL + this.groupId;
        try {
            if (this.jdd == null || this.jdd.equals("")) {
                shareItem.w(BitmapFactory.decodeResource(getResources(), R.drawable.tb_launcher_icon));
            } else if (this.jdd.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                shareItem.imageUri = Uri.parse(this.jdd);
            } else {
                shareItem.w(n.getImage(null, TbConfig.GROUP_HEAD_FILE));
            }
        } catch (Throwable th) {
        }
        return shareItem;
    }

    private SparseArray<String> aTh() {
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
        this.jdb = new a(this, null);
    }

    private void initData() {
        this.jdb.showProgress();
        Intent intent = getIntent();
        this.groupId = intent.getLongExtra("group_id", 0L);
        this.groupName = intent.getStringExtra("group_name");
        this.jdd = intent.getStringExtra(GroupCardActivityConfig.GROUP_PORTRAIT);
        this.jdc = new GroupCardModel(this.groupId, this);
        if (this.jdc != null) {
            int equipmentWidth = l.getEquipmentWidth(getPageContext().getPageActivity()) - l.dip2px(getPageContext().getPageActivity(), 10.0f);
            int equipmentHeight = (l.getEquipmentHeight(getPageContext().getPageActivity()) - this.jdb.cvl().getHeight()) - this.jdb.cvm().getHeight();
            b<com.baidu.adp.widget.ImageView.a> bVar = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.im.groupCard.GroupCardActivity.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str, i);
                    GroupCardActivity.this.jdb.chU();
                    if (aVar != null) {
                        GroupCardActivity.this.jdb.i(aVar);
                        GroupCardActivity.this.jdb.cvh();
                        return;
                    }
                    GroupCardActivity.this.jdb.bj(0, GroupCardActivity.this.getPageContext().getString(R.string.group_card_error));
                }
            };
            String cD = this.jdc.cD(equipmentWidth, equipmentHeight);
            if (cD != null) {
                c.ln().a(cD, 10, bVar, equipmentWidth, equipmentHeight, getUniqueId(), new Object[0]);
            }
        }
    }
}
