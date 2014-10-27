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
    private o aJA;
    private String aJB;
    private boolean aJD;
    private List<GameInfoData> aJE;
    private BdListView aJn;
    private View aJv;
    private NavigationBar aJw;
    private EditText aJx;
    private TextView aJy;
    private j aJz;
    private NoNetworkView ank;
    private boolean mHasMore;
    private int aJC = 0;
    private int rn = 20;
    private com.baidu.adp.framework.listener.a aJF = new a(this, CmdConfigHttp.MSG_GAME_SEARCH_CMD, 303019);
    View.OnClickListener aJG = new b(this);

    static {
        TbadkApplication.m251getInst().RegisterIntent(GameSearchActivityConfig.class, GameSearchActivity.class);
        Ia();
        ai.b(303019, GameSearchSocketResponse.class, false);
    }

    private static void Ia() {
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
        rY();
        Ib();
        this.mHandler.postDelayed(new c(this), 300L);
    }

    private void rY() {
        this.aJv = findViewById(v.game_search_parent);
        Hf();
        this.ank = (NoNetworkView) findViewById(v.view_no_network);
        this.aJn = (BdListView) findViewById(v.list_game_search);
        this.aJz = new j(this);
        this.aJz.p(this.aJG);
        this.aJn.setAdapter((ListAdapter) this.aJz);
        this.aJn.setOnSrollToBottomListener(this);
        this.aJn.setOnItemClickListener(this);
        this.aJn.setOnTouchListener(new d(this));
        this.aJA = NoDataViewFactory.a(this, this.aJv, r.a(NoDataViewFactory.ImgType.NODATA), s.bL(y.text_no_search_result), null);
        this.aJA.setVisibility(0);
        this.aJA.setOnTouchListener(new e(this));
    }

    private void Hf() {
        this.aJw = (NavigationBar) findViewById(v.view_navigation_bar);
        this.aJw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new f(this));
        View addCustomView = this.aJw.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.game_search_navigation, (View.OnClickListener) null);
        this.aJx = (EditText) addCustomView.findViewById(v.game_search_input);
        this.aJx.addTextChangedListener(new i(this, null));
        this.aJx.setOnFocusChangeListener(new g(this));
        this.aJy = (TextView) addCustomView.findViewById(v.game_search_delete_button);
        m.a(this, this.aJy, 10, 10, 10, 10);
        this.aJy.setOnClickListener(new h(this));
    }

    private void Ib() {
        registerListener(this.aJF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean getHasMore() {
        return this.mHasMore;
    }

    @Override // com.baidu.adp.widget.ListView.aa
    public void hQ() {
        Ic();
    }

    public void Ic() {
        if (!this.aJD && this.mHasMore) {
            this.aJD = true;
            GameSearchNetMessage gameSearchNetMessage = new GameSearchNetMessage();
            gameSearchNetMessage.setQuery(this.aJB);
            gameSearchNetMessage.setRn(Integer.valueOf(this.rn));
            gameSearchNetMessage.setPageNum(Integer.valueOf(this.aJC + 1));
            sendMessage(gameSearchNetMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.aJz.getItemViewType(i) != 1) {
            if (!UtilHelper.isNetOk()) {
                showToast(y.neterror);
                return;
            }
            GameInfoData item = this.aJz.getItem(i);
            if (item != null) {
                sendMessage(new CustomMessage(2002001, new GameDetailActivityConfig(this, item.getGameId(), "3000901")));
                com.baidu.tieba.game.a.a.Ij().a(view, item);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(List<GameInfoData> list) {
        if (list != null) {
            if (this.aJE == null) {
                this.aJE = new ArrayList();
            }
            if (this.aJC == 1) {
                Id();
            }
            this.aJE.addAll(list);
            if (this.aJE.size() > 0) {
                this.aJn.setVisibility(0);
                this.aJA.setVisibility(8);
                this.aJz.setData(this.aJE);
                this.aJz.notifyDataSetChanged();
                return;
            }
            this.aJn.setVisibility(8);
            this.aJA.setVisibility(0);
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
    public void Id() {
        if (this.aJE != null) {
            this.aJE.clear();
        } else {
            this.aJE = new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().L(i == 1);
        getLayoutMode().h(this.aJv);
        this.aJw.onChangeSkinType(i);
        this.ank.onChangeSkinType(i);
        if (this.aJA != null) {
            this.aJA.onChangeSkinType(i);
        }
    }
}
