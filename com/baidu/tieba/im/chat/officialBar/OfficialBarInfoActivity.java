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
    ak aRF;
    al aRG;
    private am aRH;
    private int mForumId = 0;
    private String mForumName = null;
    private boolean aRI = false;

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
        HN();
        initUI();
        initData();
    }

    private void initUI() {
        this.aRH = new am(this);
        this.aRH.setOnClickListener(this);
        this.aRH.a(this);
        showProgressBar();
    }

    private void initData() {
        this.mForumId = getIntent().getIntExtra("forum_id", 0);
        this.mForumName = getIntent().getStringExtra("forum_name");
        if (this.mForumName != null && com.baidu.tieba.im.util.j.fy(this.mForumName) > 16) {
            this.aRH.setName(String.valueOf(com.baidu.tieba.im.util.j.g(this.mForumName, 0, 16)) + "……");
        } else {
            this.aRH.setName(this.mForumName);
        }
        ax.KE().b(TbadkApplication.getCurrentAccount(), String.valueOf(this.mForumId), new ag(this));
        sendMessage(new RequestOfficialBarInfoMessage(this.mForumId, this.mForumName));
    }

    private void HN() {
        this.aRF = new ak(this);
        this.aRG = new al(this);
        registerListener(this.aRF);
        registerListener(this.aRG);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aRH.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.aRH.Kw()) {
            com.baidu.adp.lib.g.j.a(new AlertDialog.Builder(this).setTitle(com.baidu.tieba.y.alert_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.y.officical_bar_info_clean_alert).setPositiveButton(com.baidu.tieba.y.alert_yes_button, new ah(this)).setNegativeButton(com.baidu.tieba.y.alert_no_button, new ai(this)).create(), this);
        } else if (view == this.aRH.Kx()) {
            OfficialBarHistoryActivity.j(this, this.mForumId);
        } else if (view == this.aRH.Ky()) {
            FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this);
            frsActivityConfig.createNormalCfg(this.mForumName, "official_bar");
            sendMessage(new CustomMessage(2003000, frsActivityConfig));
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        new aj(this, switchState).execute(new Void[0]);
        if (switchState == BdSwitchView.SwitchState.OFF) {
            if (this.aRI) {
                MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
                this.aRI = false;
            }
        } else if (!this.aRI) {
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
            this.aRI = true;
        }
    }
}
