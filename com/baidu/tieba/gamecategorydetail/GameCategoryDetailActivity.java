package com.baidu.tieba.gamecategorydetail;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.GameCategoryDetailActivityConfig;
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tieba.game.base.AbsGameClassifyActivity;
import com.baidu.tieba.y;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.GameInfo;
import tbclient.GetGameCategoryDetail.GetGameCategoryDetailResIdl;
/* loaded from: classes.dex */
public class GameCategoryDetailActivity extends AbsGameClassifyActivity implements aa {
    private boolean aJD;
    private List<GameInfoData> aJE;
    private BdListView aJn;
    private int aKA;
    private a aKy;
    private boolean aKz;
    private String mTitle;
    private int aJC = 0;
    private int rn = 20;
    private int aKB = 2;

    static {
        TbadkApplication.m251getInst().RegisterIntent(GameCategoryDetailActivityConfig.class, GameCategoryDetailActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    public void e(Bundle bundle) {
        super.e(bundle);
        this.aJn = new BdListView(this);
        this.aJn.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.aJn.setCacheColorHint(0);
        this.aJn.setDividerHeight(0);
        setContentView(this.aJn);
        this.aKy = new a(this);
        this.aJn.setAdapter((ListAdapter) this.aKy);
        this.aJn.setOnItemClickListener(this);
        this.aJn.setOnSrollToBottomListener(this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            this.mTitle = getIntent().getExtras().getString(GameCategoryDetailActivityConfig.CATEGORY_TITLE);
            this.aKA = getIntent().getExtras().getInt(GameCategoryDetailActivityConfig.CATEGORY_ID);
        } else {
            this.mTitle = bundle.getString(GameCategoryDetailActivityConfig.CATEGORY_TITLE);
            this.aKA = bundle.getInt(GameCategoryDetailActivityConfig.CATEGORY_ID);
        }
        if (StringUtils.isNull(this.mTitle)) {
            this.mTitle = getString(y.game_classify_text_default);
        }
        this.bhx.setTitleText(this.mTitle);
        fx("key_prefix_categorydetail" + this.aKA);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(GameCategoryDetailActivityConfig.CATEGORY_TITLE, this.mTitle);
        bundle.putInt(GameCategoryDetailActivityConfig.CATEGORY_ID, this.aKA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    public void B(byte[] bArr) {
        super.B(bArr);
        try {
            GetGameCategoryDetailResIdl getGameCategoryDetailResIdl = (GetGameCategoryDetailResIdl) new Wire(new Class[0]).parseFrom(bArr, GetGameCategoryDetailResIdl.class);
            if (getGameCategoryDetailResIdl != null && getGameCategoryDetailResIdl.data != null) {
                if (getGameCategoryDetailResIdl.data.has_more != null) {
                    if (1 == getGameCategoryDetailResIdl.data.has_more.intValue()) {
                        this.aKz = true;
                    } else {
                        this.aKz = false;
                    }
                }
                this.aJC = 0;
                this.aJD = false;
                if (getGameCategoryDetailResIdl.data.game_list != null) {
                    List<GameInfoData> N = N(getGameCategoryDetailResIdl.data.game_list);
                    com.baidu.tieba.game.a.a.Ij().M(N);
                    O(N);
                }
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    public void d(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage instanceof GameCategoryDetailHttpMessage) {
            GameCategoryDetailHttpMessage gameCategoryDetailHttpMessage = (GameCategoryDetailHttpMessage) httpResponsedMessage;
            if (gameCategoryDetailHttpMessage == null || gameCategoryDetailHttpMessage.getGameInfoList() == null) {
                a(r.a(NoDataViewFactory.ImgType.NODATA), s.bL(y.game_classify_no_data_text), (q) null);
                return;
            }
            this.aJC++;
            this.aJD = false;
            if (gameCategoryDetailHttpMessage.getHasMore() == 1) {
                this.aKz = true;
            } else {
                this.aKz = false;
            }
            List<GameInfoData> N = N(gameCategoryDetailHttpMessage.getGameInfoList());
            com.baidu.tieba.game.a.a.Ij().M(N);
            O(N);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    public void e(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage instanceof GameCategoryDetailSocketMessage) {
            GameCategoryDetailSocketMessage gameCategoryDetailSocketMessage = (GameCategoryDetailSocketMessage) socketResponsedMessage;
            if (gameCategoryDetailSocketMessage == null || gameCategoryDetailSocketMessage.getGameInfoList() == null) {
                a(r.a(NoDataViewFactory.ImgType.NODATA), s.bL(y.game_classify_no_data_text), (q) null);
                return;
            }
            this.aJC++;
            this.aJD = false;
            if (gameCategoryDetailSocketMessage.getHasMore() == 1) {
                this.aKz = true;
            } else {
                this.aKz = false;
            }
            List<GameInfoData> N = N(gameCategoryDetailSocketMessage.getGameInfoList());
            com.baidu.tieba.game.a.a.Ij().M(N);
            O(N);
        }
    }

    private List<GameInfoData> N(List<GameInfo> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (GameInfo gameInfo : list) {
            GameInfoData fromGameInfo = GameInfoData.fromGameInfo(gameInfo);
            fromGameInfo.setRefId("5000901");
            arrayList.add(fromGameInfo);
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    protected NetMessage HU() {
        GameCategoryDetailMessage gameCategoryDetailMessage = new GameCategoryDetailMessage();
        gameCategoryDetailMessage.setCategoryId(this.aKA);
        gameCategoryDetailMessage.setPageNum(this.aJC + 1);
        gameCategoryDetailMessage.setRn(this.rn);
        gameCategoryDetailMessage.setPlatform(this.aKB);
        return gameCategoryDetailMessage;
    }

    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    protected String HV() {
        return TbConfig.GET_GAME_GATEGORY_DETAIL;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    public Class<? extends HttpResponsedMessage> HW() {
        return GameCategoryDetailHttpMessage.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    public Class<? extends SocketResponsedMessage> HX() {
        return GameCategoryDetailSocketMessage.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean getHasMore() {
        return this.aKz;
    }

    @Override // com.baidu.adp.widget.ListView.aa
    public void hQ() {
        Is();
    }

    public void Is() {
        if (!this.aJD && this.aKz) {
            this.aJD = true;
            GameCategoryDetailMessage gameCategoryDetailMessage = new GameCategoryDetailMessage();
            gameCategoryDetailMessage.setCategoryId(this.aKA);
            gameCategoryDetailMessage.setRn(this.rn);
            gameCategoryDetailMessage.setPageNum(this.aJC + 1);
            gameCategoryDetailMessage.setPlatform(this.aKB);
            sendMessage(gameCategoryDetailMessage);
        }
    }

    public void O(List<GameInfoData> list) {
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
                abO();
                this.aKy.setData(this.aJE);
                this.aKy.notifyDataSetChanged();
                return;
            }
            this.aJn.setVisibility(8);
            a(r.a(NoDataViewFactory.ImgType.NODATA), s.bL(y.game_classify_no_data_text), (q) null);
        }
    }

    private void Id() {
        if (this.aJE != null) {
            this.aJE.clear();
        } else {
            this.aJE = new ArrayList();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GameInfoData item = this.aKy.getItem(i);
        if (item != null) {
            if (!UtilHelper.isNetOk()) {
                showToast(y.neterror);
                return;
            }
            sendMessage(new CustomMessage(2002001, new GameDetailActivityConfig(this, item.getGameId(), "5000901")));
            com.baidu.tieba.game.a.a.Ij().a(view, item);
        }
    }
}
