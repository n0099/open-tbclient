package com.baidu.tieba.game;

import android.os.Handler;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tieba.game.view.GameDownloadView;
/* loaded from: classes.dex */
public class y extends com.baidu.adp.base.f {
    private RadioGroup Ol;
    private String[] aHG;
    private GameDetailActivity aHH;
    private TextView aHI;
    private TextView aHJ;
    private TextView aHK;
    private HeadImageView aHL;
    private GameDownloadView aHM;
    private RelativeLayout aHN;
    private RelativeLayout aHO;
    private com.baidu.adp.lib.guide.d aHP;
    private LinearLayout aHQ;
    private Runnable aHR;
    private GameInfoData aHj;
    private NoNetworkView aoS;
    private int currentPage;
    private Handler mHandler;
    private NavigationBar mNavigationBar;

    public y(GameDetailActivity gameDetailActivity) {
        super(gameDetailActivity);
        this.currentPage = 0;
        this.mHandler = new Handler();
        this.aHP = null;
        this.aHR = new z(this);
        this.aHH = gameDetailActivity;
        this.aHH.setContentView(com.baidu.tieba.w.game_detail_activity);
        this.aHQ = (LinearLayout) this.aHH.findViewById(com.baidu.tieba.v.game_detail_view);
        this.mNavigationBar = (NavigationBar) this.aHH.findViewById(com.baidu.tieba.v.game_detail_navigation_bar);
        this.mNavigationBar.setTitleText(this.aHH.getString(com.baidu.tieba.y.emotion_image_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aoS = (NoNetworkView) this.aHH.findViewById(com.baidu.tieba.v.game_detail_no_network);
        this.aHO = (RelativeLayout) this.aHH.findViewById(com.baidu.tieba.v.game_detail_content);
        this.aHN = (RelativeLayout) this.aHH.findViewById(com.baidu.tieba.v.game_detail_info_container);
        this.Ol = (RadioGroup) this.aHH.findViewById(com.baidu.tieba.v.raidos_change);
        this.aHG = new String[2];
        this.aHG[0] = "f1";
        this.aHG[1] = "f2";
        this.aHL = (HeadImageView) this.aHH.findViewById(com.baidu.tieba.v.game_detail_icon);
        this.aHI = (TextView) this.aHH.findViewById(com.baidu.tieba.v.game_detail_name_tv);
        this.aHJ = (TextView) this.aHH.findViewById(com.baidu.tieba.v.game_detail_game_size_tv);
        this.aHK = (TextView) this.aHH.findViewById(com.baidu.tieba.v.game_detail_player_number_tv);
        this.aHM = (GameDownloadView) this.aHH.findViewById(com.baidu.tieba.v.game_detail_download_btn);
        this.aHN.setVisibility(8);
        this.Ol.setVisibility(8);
    }

    public RelativeLayout Ho() {
        return this.aHO;
    }

    public void Hp() {
        if (this.aHj != null && ab.Hu().c(this.aHj)) {
            Hq();
        }
    }

    public void Hq() {
        com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
        gVar.b(this.mNavigationBar).A(0).r(false);
        gVar.a(new aa(this));
        this.aHP = gVar.dA();
        this.aHP.c(this.aHH);
        this.mHandler.postDelayed(this.aHR, 3000L);
    }

    public String[] Hr() {
        return this.aHG;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void ek(int i) {
        this.currentPage = i;
    }

    public void Hs() {
        this.Ol.setOnCheckedChangeListener(this.aHH);
    }

    public RadioGroup Ht() {
        return this.Ol;
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(i);
        this.aoS.onChangeSkinType(i);
        this.aHH.getLayoutMode().L(i == 1);
        this.aHH.getLayoutMode().h(this.aHQ);
    }

    public void a(GameInfoData gameInfoData) {
        if (gameInfoData == null || TextUtils.isEmpty(gameInfoData.getGameId())) {
            this.aHH.showToast(com.baidu.tieba.y.game_detail_no_data);
            this.aHH.finish();
            return;
        }
        this.aHj = gameInfoData;
        this.aHN.setVisibility(0);
        this.aHL.c(gameInfoData.getIconUrl(), 10, false);
        String gameName = gameInfoData.getGameName();
        if (com.baidu.tieba.game.a.g.fy(gameName) > 14) {
            gameName = String.valueOf(com.baidu.tieba.game.a.g.g(gameName, 0, 14)) + "...";
        }
        this.aHI.setText(gameName);
        if (gameInfoData.getGameType() == 1) {
            this.aHJ.setText(new StringBuilder().append(gameInfoData.getPackageSize()).append("M"));
        }
        int playerNum = gameInfoData.getPlayerNum();
        if (playerNum < 0) {
            playerNum = 0;
        }
        this.aHK.setText(this.aHH.getString(com.baidu.tieba.y.game_center_player_num, new Object[]{com.baidu.tieba.game.a.g.fj(playerNum)}));
        gameInfoData.setGamestatus(ab.Hu().o(gameInfoData));
        this.aHM.a(this.aHH.getUniqueId(), gameInfoData);
    }
}
