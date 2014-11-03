package com.baidu.tieba.game.hot;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.HotGameActivityConfig;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tieba.game.base.AbsGameClassifyActivity;
import com.baidu.tieba.game.base.CachedHttpResponse;
import com.baidu.tieba.game.base.CachedSocketResponse;
import com.baidu.tieba.y;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.GameInfo;
import tbclient.GetHotGameList.GetHotGameListResIdl;
/* loaded from: classes.dex */
public class HotGameActivity extends AbsGameClassifyActivity {
    private int Ui = 1;
    BdListView aJA;
    b aJZ;
    private List<GameInfoData> aKa;

    static {
        TbadkApplication.m251getInst().RegisterIntent(HotGameActivityConfig.class, HotGameActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<GameInfoData> fg(int i) {
        ArrayList arrayList = new ArrayList();
        if (this.aKa != null && this.aKa.size() > 0) {
            if (i > this.aKa.size()) {
                i = this.aKa.size();
            }
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(this.aKa.get(i2));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(List<GameInfoData> list) {
        if (list == null || list.isEmpty()) {
            if (this.aJZ.getCount() <= 0) {
                a(r.a(NoDataViewFactory.ImgType.NODATA), s.bL(y.hot_game_no_data_text), (q) null);
                return;
            }
            return;
        }
        abR();
        this.aJZ.setData(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    public void e(Bundle bundle) {
        super.e(bundle);
        this.aJA = new BdListView(this);
        this.aJA.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.aJA.setCacheColorHint(0);
        this.aJA.setDividerHeight(0);
        setContentView(this.aJA);
        this.aJZ = new b(this);
        this.aJA.setAdapter((ListAdapter) this.aJZ);
        this.aJA.setOnSrollToBottomListener(new a(this));
        this.bhL.setTitleText(y.hot_game_title);
        fx("key_hot_game");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    public void B(byte[] bArr) {
        super.B(bArr);
        try {
            GetHotGameListResIdl getHotGameListResIdl = (GetHotGameListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetHotGameListResIdl.class);
            if (getHotGameListResIdl != null && getHotGameListResIdl.data != null && getHotGameListResIdl.data.game_list != null) {
                List<GameInfo> list = getHotGameListResIdl.data.game_list;
                ArrayList arrayList = new ArrayList();
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    GameInfoData fromGameInfo = GameInfoData.fromGameInfo(list.get(i));
                    fromGameInfo.setRefId("1000103");
                    arrayList.add(fromGameInfo);
                }
                com.baidu.tieba.game.a.a.In().M(arrayList);
                this.aKa = arrayList;
                H(fg(20));
            }
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    protected NetMessage HY() {
        return new HotGameMessage();
    }

    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    protected String HZ() {
        return TbConfig.GET_HOT_GAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    public Class<? extends CachedHttpResponse> Ia() {
        return HotGameHttpResponse.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    public Class<? extends CachedSocketResponse> Ib() {
        return HotGameSocketResponse.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    public void c(HttpResponsedMessage httpResponsedMessage) {
        List<GameInfo> gameList;
        if ((httpResponsedMessage instanceof HotGameHttpResponse) && (gameList = ((HotGameHttpResponse) httpResponsedMessage).getGameList()) != null && !gameList.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            int size = gameList.size();
            for (int i = 0; i < size; i++) {
                GameInfoData fromGameInfo = GameInfoData.fromGameInfo(gameList.get(i));
                fromGameInfo.setRefId("1000103");
                arrayList.add(fromGameInfo);
            }
            com.baidu.tieba.game.a.a.In().M(arrayList);
            this.aKa = arrayList;
            H(fg(20));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    public void e(SocketResponsedMessage socketResponsedMessage) {
        List<GameInfo> gameList;
        if ((socketResponsedMessage instanceof HotGameSocketResponse) && (gameList = ((HotGameSocketResponse) socketResponsedMessage).getGameList()) != null && !gameList.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            int size = gameList.size();
            for (int i = 0; i < size; i++) {
                GameInfoData fromGameInfo = GameInfoData.fromGameInfo(gameList.get(i));
                fromGameInfo.setRefId("1000103");
                arrayList.add(fromGameInfo);
            }
            com.baidu.tieba.game.a.a.In().M(arrayList);
            this.aKa = arrayList;
            H(fg(20));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aw.a(this.aJA, i);
    }
}
