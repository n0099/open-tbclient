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
    private RadioGroup Oh;
    private GameInfoData aGZ;
    private TextView aHA;
    private HeadImageView aHB;
    private GameDownloadView aHC;
    private RelativeLayout aHD;
    private RelativeLayout aHE;
    private com.baidu.adp.lib.guide.d aHF;
    private LinearLayout aHG;
    private Runnable aHH;
    private String[] aHw;
    private GameDetailActivity aHx;
    private TextView aHy;
    private TextView aHz;
    private NoNetworkView aoJ;
    private int currentPage;
    private Handler mHandler;
    private NavigationBar mNavigationBar;

    public y(GameDetailActivity gameDetailActivity) {
        super(gameDetailActivity);
        this.currentPage = 0;
        this.mHandler = new Handler();
        this.aHF = null;
        this.aHH = new z(this);
        this.aHx = gameDetailActivity;
        this.aHx.setContentView(com.baidu.tieba.w.game_detail_activity);
        this.aHG = (LinearLayout) this.aHx.findViewById(com.baidu.tieba.v.game_detail_view);
        this.mNavigationBar = (NavigationBar) this.aHx.findViewById(com.baidu.tieba.v.game_detail_navigation_bar);
        this.mNavigationBar.setTitleText(this.aHx.getString(com.baidu.tieba.y.emotion_image_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aoJ = (NoNetworkView) this.aHx.findViewById(com.baidu.tieba.v.game_detail_no_network);
        this.aHE = (RelativeLayout) this.aHx.findViewById(com.baidu.tieba.v.game_detail_content);
        this.aHD = (RelativeLayout) this.aHx.findViewById(com.baidu.tieba.v.game_detail_info_container);
        this.Oh = (RadioGroup) this.aHx.findViewById(com.baidu.tieba.v.raidos_change);
        this.aHw = new String[2];
        this.aHw[0] = "f1";
        this.aHw[1] = "f2";
        this.aHB = (HeadImageView) this.aHx.findViewById(com.baidu.tieba.v.game_detail_icon);
        this.aHy = (TextView) this.aHx.findViewById(com.baidu.tieba.v.game_detail_name_tv);
        this.aHz = (TextView) this.aHx.findViewById(com.baidu.tieba.v.game_detail_game_size_tv);
        this.aHA = (TextView) this.aHx.findViewById(com.baidu.tieba.v.game_detail_player_number_tv);
        this.aHC = (GameDownloadView) this.aHx.findViewById(com.baidu.tieba.v.game_detail_download_btn);
        this.aHD.setVisibility(8);
        this.Oh.setVisibility(8);
    }

    public RelativeLayout Hm() {
        return this.aHE;
    }

    public void Hn() {
        if (this.aGZ != null && ab.Hs().b(this.aGZ)) {
            Ho();
        }
    }

    public void Ho() {
        com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
        gVar.b(this.mNavigationBar).A(0).r(false);
        gVar.a(new aa(this));
        this.aHF = gVar.dA();
        this.aHF.c(this.aHx);
        this.mHandler.postDelayed(this.aHH, 3000L);
    }

    public String[] Hp() {
        return this.aHw;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void ek(int i) {
        this.currentPage = i;
    }

    public void Hq() {
        this.Oh.setOnCheckedChangeListener(this.aHx);
    }

    public RadioGroup Hr() {
        return this.Oh;
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(i);
        this.aoJ.onChangeSkinType(i);
        this.aHx.getLayoutMode().L(i == 1);
        this.aHx.getLayoutMode().h(this.aHG);
    }

    public void setData(GameInfoData gameInfoData) {
        if (gameInfoData == null || TextUtils.isEmpty(gameInfoData.getGameId())) {
            this.aHx.showToast(com.baidu.tieba.y.game_detail_no_data);
            this.aHx.finish();
            return;
        }
        this.aGZ = gameInfoData;
        this.aHD.setVisibility(0);
        this.aHB.c(gameInfoData.getIconUrl(), 10, false);
        String gameName = gameInfoData.getGameName();
        if (com.baidu.tieba.game.a.g.fy(gameName) > 14) {
            gameName = String.valueOf(com.baidu.tieba.game.a.g.g(gameName, 0, 14)) + "...";
        }
        this.aHy.setText(gameName);
        if (gameInfoData.getGameType() == 1) {
            this.aHz.setText(new StringBuilder().append(gameInfoData.getPackageSize()).append("M"));
        }
        int playerNum = gameInfoData.getPlayerNum();
        if (playerNum < 0) {
            playerNum = 0;
        }
        this.aHA.setText(this.aHx.getString(com.baidu.tieba.y.game_center_player_num, new Object[]{com.baidu.tieba.game.a.g.fj(playerNum)}));
        gameInfoData.setGamestatus(ab.Hs().n(gameInfoData));
        this.aHC.setData(gameInfoData);
    }
}
