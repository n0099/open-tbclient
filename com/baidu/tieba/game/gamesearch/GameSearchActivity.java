package com.baidu.tieba.game.gamesearch;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.m;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.atomData.GameSearchActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ai;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class GameSearchActivity extends BaseActivity implements aa {
    private BdListView aJA;
    private View aJI;
    private NavigationBar aJJ;
    private EditText aJK;
    private TextView aJL;
    private j aJM;
    private o aJN;
    private String aJO;
    private boolean aJQ;
    private List<GameInfoData> aJR;
    private NoNetworkView ant;
    private boolean mHasMore;
    private int aJP = 0;
    private int rn = 20;
    private com.baidu.adp.framework.listener.a aJS = new a(this, CmdConfigHttp.MSG_GAME_SEARCH_CMD, 303019);
    View.OnClickListener aJT = new b(this);

    static {
        TbadkApplication.m251getInst().RegisterIntent(GameSearchActivityConfig.class, GameSearchActivity.class);
        Ie();
        ai.b(303019, GameSearchSocketResponse.class, false);
    }

    private static void Ie() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MSG_GAME_SEARCH_CMD, ai.s(TbConfig.GAME_SEARCH_RESULT, 303019));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(GameSearchHttpResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.game_search_activity);
        sa();
        If();
        this.mHandler.postDelayed(new c(this), 300L);
    }

    private void sa() {
        this.aJI = findViewById(v.game_search_parent);
        Hh();
        this.ant = (NoNetworkView) findViewById(v.view_no_network);
        this.aJA = (BdListView) findViewById(v.list_game_search);
        this.aJM = new j(this);
        this.aJM.p(this.aJT);
        this.aJA.setAdapter((ListAdapter) this.aJM);
        this.aJA.setOnSrollToBottomListener(this);
        this.aJA.setOnItemClickListener(this);
        this.aJA.setOnTouchListener(new d(this));
        this.aJN = NoDataViewFactory.a(this, this.aJI, r.a(NoDataViewFactory.ImgType.NODATA), s.bL(y.text_no_search_result), null);
        this.aJN.setVisibility(0);
        this.aJN.setOnTouchListener(new e(this));
    }

    private void Hh() {
        this.aJJ = (NavigationBar) findViewById(v.view_navigation_bar);
        this.aJJ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new f(this));
        View addCustomView = this.aJJ.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.game_search_navigation, (View.OnClickListener) null);
        this.aJK = (EditText) addCustomView.findViewById(v.game_search_input);
        this.aJK.addTextChangedListener(new i(this, null));
        this.aJK.setOnFocusChangeListener(new g(this));
        this.aJL = (TextView) addCustomView.findViewById(v.game_search_delete_button);
        m.a(this, this.aJL, 10, 10, 10, 10);
        this.aJL.setOnClickListener(new h(this));
    }

    private void If() {
        registerListener(this.aJS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean getHasMore() {
        return this.mHasMore;
    }

    @Override // com.baidu.adp.widget.ListView.aa
    public void hQ() {
        Ig();
    }

    public void Ig() {
        if (!this.aJQ && this.mHasMore) {
            this.aJQ = true;
            GameSearchNetMessage gameSearchNetMessage = new GameSearchNetMessage();
            gameSearchNetMessage.setQuery(this.aJO);
            gameSearchNetMessage.setRn(Integer.valueOf(this.rn));
            gameSearchNetMessage.setPageNum(Integer.valueOf(this.aJP + 1));
            sendMessage(gameSearchNetMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.aJM.getItemViewType(i) != 1) {
            if (!UtilHelper.isNetOk()) {
                showToast(y.neterror);
                return;
            }
            GameInfoData item = this.aJM.getItem(i);
            if (item != null) {
                sendMessage(new CustomMessage(2002001, new GameDetailActivityConfig(this, item.getGameId(), "3000901")));
                com.baidu.tieba.game.a.a.In().a(getUniqueId(), view, item);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(List<GameInfoData> list) {
        if (list != null) {
            if (this.aJR == null) {
                this.aJR = new ArrayList();
            }
            if (this.aJP == 1) {
                Ih();
            }
            this.aJR.addAll(list);
            if (this.aJR.size() > 0) {
                this.aJA.setVisibility(0);
                this.aJN.setVisibility(8);
                this.aJM.setData(this.aJR);
                this.aJM.notifyDataSetChanged();
                return;
            }
            this.aJA.setVisibility(8);
            this.aJN.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(List<GameInfoData> list) {
        if (list != null && !list.isEmpty()) {
            for (GameInfoData gameInfoData : list) {
                if (gameInfoData != null) {
                    gameInfoData.setRefId("3000901");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ih() {
        if (this.aJR != null) {
            this.aJR.clear();
        } else {
            this.aJR = new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().L(i == 1);
        getLayoutMode().h(this.aJI);
        this.aJJ.onChangeSkinType(i);
        this.ant.onChangeSkinType(i);
        if (this.aJN != null) {
            this.aJN.onChangeSkinType(i);
        }
    }
}
