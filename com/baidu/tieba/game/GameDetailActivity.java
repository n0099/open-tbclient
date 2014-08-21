package com.baidu.tieba.game;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.game.RequestGameDetailMessage;
import com.baidu.tbadk.game.ResponseGameDetailMessage;
/* loaded from: classes.dex */
public class GameDetailActivity extends BaseActivity {
    private aa a;
    private com.baidu.tbadk.game.b b;
    private final CustomMessageListener c = new v(this, 2001121);
    private final com.baidu.adp.framework.listener.d d = new w(this, 303009);
    private final CustomMessageListener e = new x(this, 2001122);

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.w.class, GameDetailActivity.class);
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(303009);
        bVar.a(ResponseGameDetailMessage.class);
        bVar.b(false);
        bVar.setParallel(com.baidu.tbadk.k.b());
        MessageManager.getInstance().registerTask(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new aa(this);
        registerListener(this.d);
        registerListener(this.c);
        Intent intent = getIntent();
        String stringExtra = intent == null ? "" : intent.getStringExtra("game_id_key");
        if (!TextUtils.isEmpty(stringExtra)) {
            RequestGameDetailMessage requestGameDetailMessage = new RequestGameDetailMessage();
            requestGameDetailMessage.setGameId(stringExtra);
            sendMessage(requestGameDetailMessage);
            showLoadingDialog(getString(com.baidu.tieba.x.downloading2), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.a.a(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.b != null) {
            this.b.c(ae.a().j(this.b));
            this.a.a(this.b);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.u.game_detail_download_btn && this.b != null) {
            int c = this.b.c();
            if (c == 2) {
                com.baidu.tbadk.game.a.a(getApplicationContext(), this.b.b(), this.b.h(), this.b.a());
                ae.a().i(this.b);
            } else if (c == 1) {
                switch (ae.a().j(this.b)) {
                    case 1:
                        ae.a().d(this.b);
                        com.baidu.adp.lib.network.willdelete.h.a();
                        return;
                    case 2:
                        ae.a().c(this.b);
                        return;
                    case 3:
                        ae.a().d(this.b);
                        com.baidu.adp.lib.network.willdelete.h.a();
                        return;
                    case 4:
                        ae.a().f(this.b);
                        return;
                    case 5:
                        ae.a().e(this.b);
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
