package com.baidu.tieba.game.classify;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.GameClassifyActivityConfig;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.core.view.s;
import com.baidu.tieba.game.base.AbsGameClassifyActivity;
import com.baidu.tieba.game.base.CachedHttpResponse;
import com.baidu.tieba.game.base.CachedSocketResponse;
import com.baidu.tieba.y;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.GameCategory;
import tbclient.GetGameCategory.GetGameCategoryResIdl;
/* loaded from: classes.dex */
public class GameClassifyActivity extends AbsGameClassifyActivity {
    private BdListView aJA;
    private b aJB;
    private AdapterView.OnItemClickListener itemClickListener = new a(this);

    static {
        TbadkApplication.m251getInst().RegisterIntent(GameClassifyActivityConfig.class, GameClassifyActivity.class);
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
        this.aJB = new b(this);
        this.aJA.setAdapter((ListAdapter) this.aJB);
        this.bhL.setTitleText(y.game_classify_text_title);
        this.aJA.setOnItemClickListener(this.itemClickListener);
        fx("key_game_classify");
    }

    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity
    protected boolean Ic() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    public void B(byte[] bArr) {
        super.B(bArr);
        try {
            GetGameCategoryResIdl getGameCategoryResIdl = (GetGameCategoryResIdl) new Wire(new Class[0]).parseFrom(bArr, GetGameCategoryResIdl.class);
            if (getGameCategoryResIdl != null && getGameCategoryResIdl.data != null && getGameCategoryResIdl.data.category_list != null) {
                this.aJB.setData(getGameCategoryResIdl.data.category_list);
            }
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    protected NetMessage HY() {
        return new GameClassifyMessage();
    }

    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    protected String HZ() {
        return TbConfig.GET_GAME_CATEGORY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    public Class<? extends CachedHttpResponse> Ia() {
        return GameClassifyHttpResponse.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    public Class<? extends CachedSocketResponse> Ib() {
        return GameClassifySocketResponse.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    public void c(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage instanceof GameClassifyHttpResponse) {
            H(((GameClassifyHttpResponse) httpResponsedMessage).getCategoryList());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    public void e(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage instanceof GameClassifySocketResponse) {
            H(((GameClassifySocketResponse) socketResponsedMessage).getCategoryList());
        }
    }

    private void H(List<GameCategory> list) {
        this.aJB.setData(list);
        if (this.aJB.getCount() <= 0) {
            a(r.a(NoDataViewFactory.ImgType.NODATA), s.bL(y.game_classify_no_data_text), (q) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aw.a(this.aJA, i);
    }
}
