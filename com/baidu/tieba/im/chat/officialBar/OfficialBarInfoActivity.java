package com.baidu.tieba.im.chat.officialBar;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tieba.im.message.SettingChangeMessage;
/* loaded from: classes.dex */
public class OfficialBarInfoActivity extends BaseActivity implements View.OnClickListener, com.baidu.adp.widget.BdSwitchView.c {
    ak aRr;
    al aRs;
    private am aRt;
    private int mForumId = 0;
    private String mForumName = null;
    private boolean aRu = false;

    public static void startActivity(Context context, int i, String str) {
        Intent intent = new Intent(context, OfficialBarInfoActivity.class);
        intent.putExtra("forum_id", i);
        intent.putExtra("forum_name", str);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        HJ();
        initUI();
        initData();
    }

    private void initUI() {
        this.aRt = new am(this);
        this.aRt.setOnClickListener(this);
        this.aRt.a(this);
        showProgressBar();
    }

    private void initData() {
        this.mForumId = getIntent().getIntExtra("forum_id", 0);
        this.mForumName = getIntent().getStringExtra("forum_name");
        if (this.mForumName != null && com.baidu.tieba.im.util.j.fy(this.mForumName) > 16) {
            this.aRt.setName(String.valueOf(com.baidu.tieba.im.util.j.g(this.mForumName, 0, 16)) + "……");
        } else {
            this.aRt.setName(this.mForumName);
        }
        ax.KA().b(TbadkApplication.getCurrentAccount(), String.valueOf(this.mForumId), new ag(this));
        sendMessage(new RequestOfficialBarInfoMessage(this.mForumId, this.mForumName));
    }

    private void HJ() {
        this.aRr = new ak(this);
        this.aRs = new al(this);
        registerListener(this.aRr);
        registerListener(this.aRs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aRt.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.aRt.Ks()) {
            com.baidu.adp.lib.g.j.a(new AlertDialog.Builder(this).setTitle(com.baidu.tieba.y.alert_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.y.officical_bar_info_clean_alert).setPositiveButton(com.baidu.tieba.y.alert_yes_button, new ah(this)).setNegativeButton(com.baidu.tieba.y.alert_no_button, new ai(this)).create(), this);
        } else if (view == this.aRt.Kt()) {
            OfficialBarHistoryActivity.j(this, this.mForumId);
        } else if (view == this.aRt.Ku()) {
            FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this);
            frsActivityConfig.createNormalCfg(this.mForumName, "official_bar");
            sendMessage(new CustomMessage(2003000, frsActivityConfig));
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        new aj(this, switchState).execute(new Void[0]);
        if (switchState == BdSwitchView.SwitchState.OFF) {
            if (this.aRu) {
                MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
                this.aRu = false;
            }
        } else if (!this.aRu) {
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
            this.aRu = true;
        }
    }
}
