package com.baidu.tieba.game;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.widget.RadioGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tbadk.game.GameRankInfoData;
import com.baidu.tbadk.game.RequestGameDetailMessage;
import com.baidu.tbadk.game.ResponseGameDetailMessage;
/* loaded from: classes.dex */
public class GameDetailActivity extends BaseFragmentActivity implements RadioGroup.OnCheckedChangeListener {
    private String aAw;
    private y aGY;
    private GameInfoData aGZ;
    private GameRankInfoData aHa;
    private com.baidu.tbadk.c.f aHb;
    private final CustomMessageListener aHc = new p(this, 2001121);
    private final com.baidu.adp.framework.listener.e Tb = new q(this, 303009);

    static {
        TbadkApplication.m251getInst().RegisterIntent(GameDetailActivityConfig.class, GameDetailActivity.class);
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(303009);
        bVar.setResponsedClass(ResponseGameDetailMessage.class);
        bVar.f(false);
        bVar.setParallel(TiebaIMConfig.getParallel());
        MessageManager.getInstance().registerTask(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aGY = new y(this);
        registerListener(this.Tb);
        registerListener(this.aHc);
        Intent intent = getIntent();
        String stringExtra = intent == null ? "" : intent.getStringExtra(GameDetailActivityConfig.GAME_ID_KEY);
        if (!TextUtils.isEmpty(stringExtra)) {
            this.aHb = new com.baidu.tbadk.c.f(this);
            this.aHb.b(this.aGY.Hm(), true);
            this.aAw = intent == null ? "" : intent.getStringExtra(GameDetailActivityConfig.SOURCE);
            if (TextUtils.isEmpty(this.aAw)) {
                this.aAw = "3000301";
            }
            RequestGameDetailMessage requestGameDetailMessage = new RequestGameDetailMessage();
            requestGameDetailMessage.setGameId(stringExtra);
            sendMessage(requestGameDetailMessage);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.aGY.onChangeSkinType(i);
        if (this.aHb != null) {
            this.aHb.sB();
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        Hk();
        if (i == com.baidu.tieba.v.radio_intro) {
            this.aGY.ek(0);
        } else if (i == com.baidu.tieba.v.radio_rank) {
            TiebaStatic.eventStat(this, "game_detail_rank", "visit", 1, new Object[0]);
            this.aGY.ek(1);
        }
        Hl();
    }

    private void Hk() {
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.aGY.Hp()[this.aGY.getCurrentPage()]);
        if (findFragmentByTag != null) {
            getSupportFragmentManager().beginTransaction().hide(findFragmentByTag).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hl() {
        Fragment sVar;
        int currentPage = this.aGY.getCurrentPage();
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.aGY.Hp()[currentPage]);
        if (findFragmentByTag == null) {
            String str = this.aGY.Hp()[currentPage];
            if (currentPage == 0) {
                sVar = new r();
                Bundle bundle = new Bundle();
                bundle.putSerializable("gameInfo", this.aGZ);
                sVar.setArguments(bundle);
            } else {
                sVar = new s();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("gameRank", this.aHa);
                sVar.setArguments(bundle2);
            }
            getSupportFragmentManager().beginTransaction().add(com.baidu.tieba.v.fragment, sVar, str).commit();
            return;
        }
        getSupportFragmentManager().beginTransaction().show(findFragmentByTag).commit();
    }
}
