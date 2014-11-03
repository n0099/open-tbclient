package com.baidu.tieba.game.newgame;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.GameNewActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tieba.game.RequestMutilGameNetMessage;
import com.baidu.tieba.game.ResponseMutilGameHttpMessage;
import com.baidu.tieba.game.ResponseMutilGameSocketMessage;
import com.baidu.tieba.game.an;
import com.baidu.tieba.game.base.AbsGameClassifyActivity;
import com.baidu.tieba.y;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.GetMutilGameList.GetMutilGameListResIdl;
/* loaded from: classes.dex */
public class GameNewActivity extends AbsGameClassifyActivity implements aa {
    private boolean Ty;
    private d aKe;
    private com.baidu.tieba.game.a.b aKf;
    private boolean mHasMore;
    private BdListView vl;
    private int mPage = 1;
    private AdapterView.OnItemClickListener itemClickListener = new a(this);

    static {
        TbadkApplication.m251getInst().RegisterIntent(GameNewActivityConfig.class, GameNewActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity, com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aKf = new com.baidu.tieba.game.a.b();
        this.aKf.a(new b(this));
        registerListener(this.aKf.Io());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ii() {
        this.aKf.a(this, this.bhL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    public void e(Bundle bundle) {
        super.e(bundle);
        this.bhL.setTitleText(y.new_game_title);
        this.vl = Ij();
        setContentView(this.vl);
        Ik();
        fx("key_game_new");
    }

    private BdListView Ij() {
        BdListView bdListView = new BdListView(this);
        bdListView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        bdListView.setCacheColorHint(0);
        bdListView.setDividerHeight(0);
        return bdListView;
    }

    private void Ik() {
        this.aKe = new d(this);
        this.vl.setAdapter((ListAdapter) this.aKe);
        this.vl.setOnItemClickListener(this.itemClickListener);
        this.vl.setOnSrollToBottomListener(this);
        this.aKe.a(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void B(byte[] bArr) {
        an anVar;
        an anVar2;
        GetMutilGameListResIdl getMutilGameListResIdl;
        super.B(bArr);
        try {
            getMutilGameListResIdl = (GetMutilGameListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetMutilGameListResIdl.class);
        } catch (Exception e) {
            e = e;
            anVar = null;
        }
        if (getMutilGameListResIdl != null && getMutilGameListResIdl.data != null) {
            anVar = new an();
            try {
                anVar.a(getMutilGameListResIdl.data);
                anVar2 = anVar;
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                anVar2 = anVar;
                if (anVar2 != null) {
                }
                if (UtilHelper.isNetOk()) {
                }
                a(true, anVar2 != null ? null : anVar2.getGameList(), UtilHelper.isNetOk() ? false : this.mHasMore);
            }
            if (anVar2 != null) {
                this.mHasMore = anVar2.isHasMore();
            }
            a(true, anVar2 != null ? null : anVar2.getGameList(), UtilHelper.isNetOk() ? false : this.mHasMore);
        }
    }

    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    protected NetMessage HY() {
        return fh(1);
    }

    private RequestMutilGameNetMessage fh(int i) {
        RequestMutilGameNetMessage requestMutilGameNetMessage = new RequestMutilGameNetMessage();
        requestMutilGameNetMessage.setType(2);
        requestMutilGameNetMessage.setPageNum(i);
        return requestMutilGameNetMessage;
    }

    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    protected String HZ() {
        return "c/u/game/getMutilGameList";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    public Class<? extends HttpResponsedMessage> Ia() {
        return ResponseMutilGameHttpMessage.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    public Class<? extends SocketResponsedMessage> Ib() {
        return ResponseMutilGameSocketMessage.class;
    }

    private void a(boolean z, an anVar) {
        this.Ty = false;
        if (anVar == null) {
            a(z, (List<GameInfoData>) null, false);
            return;
        }
        this.mHasMore = anVar.isHasMore();
        a(z, anVar.getGameList(), anVar.isHasMore());
    }

    private void a(boolean z, List<GameInfoData> list, boolean z2) {
        List<GameInfoData> data = this.aKe.getData();
        if (z) {
            data.clear();
        }
        if (list != null) {
            for (GameInfoData gameInfoData : list) {
                if (gameInfoData != null) {
                    gameInfoData.setRefId("1000102");
                    data.add(gameInfoData);
                }
            }
        }
        if (data.isEmpty()) {
            this.aKe.co(false);
            a(r.a(NoDataViewFactory.ImgType.NODATA), s.bL(y.game_new_no_data_text), (q) null);
        } else {
            this.aKe.co(z2);
            abR();
        }
        this.aKe.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    public void EI() {
        a(false, (an) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    public void c(HttpResponsedMessage httpResponsedMessage) {
        ResponseMutilGameHttpMessage responseMutilGameHttpMessage = (ResponseMutilGameHttpMessage) httpResponsedMessage;
        if (responseMutilGameHttpMessage.getPage() == this.mPage) {
            this.mPage = responseMutilGameHttpMessage.getPage() + 1;
            a(responseMutilGameHttpMessage.getPage() <= 1, responseMutilGameHttpMessage.getData());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    public void e(SocketResponsedMessage socketResponsedMessage) {
        ResponseMutilGameSocketMessage responseMutilGameSocketMessage = (ResponseMutilGameSocketMessage) socketResponsedMessage;
        if (responseMutilGameSocketMessage.getPage() == this.mPage) {
            this.mPage = responseMutilGameSocketMessage.getPage() + 1;
            a(responseMutilGameSocketMessage.getPage() <= 1, responseMutilGameSocketMessage.getData());
        }
    }

    @Override // com.baidu.adp.widget.ListView.aa
    public void hQ() {
        if (this.mHasMore && UtilHelper.isNetOk() && !this.Ty) {
            this.aKe.Im();
            if (this.mPage == 1) {
                this.mPage++;
            }
            sendMessage(fh(this.mPage));
            this.Ty = true;
        }
    }
}
