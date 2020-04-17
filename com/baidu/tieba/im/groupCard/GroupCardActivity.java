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
    private a iom = null;
    private GroupCardModel ion = null;
    private long groupId = 0;
    private String groupName = "";
    private String ioo = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData();
    }

    public boolean cdi() {
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
        this.iom.aY(0, getPageContext().getString(R.string.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iom.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iom.cgP()) {
            if (cdi()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "group_card_save", "click", 1, new Object[0]);
                this.ion.saveImage();
            }
        } else if (view == this.iom.cgR()) {
            finish();
        } else if (view == this.iom.cgQ()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "group_card_share", "click", 1, new Object[0]);
            aQD();
        }
    }

    private void aQD() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) getPageContext().getPageActivity(), cgL(), true, aHW())));
    }

    private ShareItem cgL() {
        ShareItem shareItem = new ShareItem();
        shareItem.title = MessageFormat.format(getPageContext().getString(R.string.im_share_title), this.groupName);
        shareItem.content = MessageFormat.format(getPageContext().getString(R.string.im_share_content), this.groupName, String.valueOf(this.groupId));
        shareItem.linkUrl = TiebaIMConfig.IM_GROUP_SHARE_URL + this.groupId;
        try {
            if (this.ioo == null || this.ioo.equals("")) {
                shareItem.r(BitmapFactory.decodeResource(getResources(), R.drawable.tb_launcher_icon));
            } else if (this.ioo.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                shareItem.imageUri = Uri.parse(this.ioo);
            } else {
                shareItem.r(m.getImage(null, TbConfig.GROUP_HEAD_FILE));
            }
        } catch (Throwable th) {
        }
        return shareItem;
    }

    private SparseArray<String> aHW() {
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
        this.iom = new a(this, null);
    }

    private void initData() {
        this.iom.showProgress();
        Intent intent = getIntent();
        this.groupId = intent.getLongExtra("group_id", 0L);
        this.groupName = intent.getStringExtra("group_name");
        this.ioo = intent.getStringExtra(GroupCardActivityConfig.GROUP_PORTRAIT);
        this.ion = new GroupCardModel(this.groupId, this);
        if (this.ion != null) {
            int equipmentWidth = l.getEquipmentWidth(getPageContext().getPageActivity()) - l.dip2px(getPageContext().getPageActivity(), 10.0f);
            int equipmentHeight = (l.getEquipmentHeight(getPageContext().getPageActivity()) - this.iom.cgS().getHeight()) - this.iom.cgT().getHeight();
            b<com.baidu.adp.widget.ImageView.a> bVar = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.im.groupCard.GroupCardActivity.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str, i);
                    GroupCardActivity.this.iom.bUy();
                    if (aVar != null) {
                        GroupCardActivity.this.iom.i(aVar);
                        GroupCardActivity.this.iom.cgO();
                        return;
                    }
                    GroupCardActivity.this.iom.aY(0, GroupCardActivity.this.getPageContext().getString(R.string.group_card_error));
                }
            };
            String cp = this.ion.cp(equipmentWidth, equipmentHeight);
            if (cp != null) {
                c.kV().a(cp, 10, bVar, equipmentWidth, equipmentHeight, getUniqueId(), new Object[0]);
            }
        }
    }
}
