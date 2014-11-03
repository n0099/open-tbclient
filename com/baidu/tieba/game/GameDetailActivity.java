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
    private String aAG;
    private y aHi;
    private GameInfoData aHj;
    private GameRankInfoData aHk;
    private com.baidu.tbadk.c.f aHl;
    private final CustomMessageListener aHm = new p(this, 2001121);
    private final com.baidu.adp.framework.listener.e Tf = new q(this, 303009);

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
        this.aHi = new y(this);
        registerListener(this.Tf);
        registerListener(this.aHm);
        Intent intent = getIntent();
        String stringExtra = intent == null ? "" : intent.getStringExtra(GameDetailActivityConfig.GAME_ID_KEY);
        if (!TextUtils.isEmpty(stringExtra)) {
            this.aHl = new com.baidu.tbadk.c.f(this);
            this.aHl.b(this.aHi.Ho(), true);
            this.aAG = intent == null ? "" : intent.getStringExtra(GameDetailActivityConfig.SOURCE);
            if (TextUtils.isEmpty(this.aAG)) {
                this.aAG = "3000301";
            }
            RequestGameDetailMessage requestGameDetailMessage = new RequestGameDetailMessage();
            requestGameDetailMessage.setGameId(stringExtra);
            sendMessage(requestGameDetailMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.aHi.onChangeSkinType(i);
        if (this.aHl != null) {
            this.aHl.sD();
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        Hm();
        if (i == com.baidu.tieba.v.radio_intro) {
            this.aHi.ek(0);
        } else if (i == com.baidu.tieba.v.radio_rank) {
            TiebaStatic.eventStat(this, "game_detail_rank", "visit", 1, new Object[0]);
            this.aHi.ek(1);
        }
        Hn();
    }

    private void Hm() {
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.aHi.Hr()[this.aHi.getCurrentPage()]);
        if (findFragmentByTag != null) {
            getSupportFragmentManager().beginTransaction().hide(findFragmentByTag).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hn() {
        Fragment sVar;
        int currentPage = this.aHi.getCurrentPage();
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.aHi.Hr()[currentPage]);
        if (findFragmentByTag == null) {
            String str = this.aHi.Hr()[currentPage];
            if (currentPage == 0) {
                sVar = new r();
                Bundle bundle = new Bundle();
                bundle.putSerializable("gameInfo", this.aHj);
                sVar.setArguments(bundle);
            } else {
                sVar = new s();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("gameRank", this.aHk);
                sVar.setArguments(bundle2);
            }
            getSupportFragmentManager().beginTransaction().add(com.baidu.tieba.v.fragment, sVar, str).commit();
            return;
        }
        getSupportFragmentManager().beginTransaction().show(findFragmentByTag).commit();
    }
}
