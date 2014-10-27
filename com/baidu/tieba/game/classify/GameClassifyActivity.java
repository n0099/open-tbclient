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
    private BdListView aJn;
    private b aJo;
    private AdapterView.OnItemClickListener itemClickListener = new a(this);

    static {
        TbadkApplication.m251getInst().RegisterIntent(GameClassifyActivityConfig.class, GameClassifyActivity.class);
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
        this.aJo = new b(this);
        this.aJn.setAdapter((ListAdapter) this.aJo);
        this.bhx.setTitleText(y.game_classify_text_title);
        this.aJn.setOnItemClickListener(this.itemClickListener);
        fx("key_game_classify");
    }

    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity
    protected boolean HY() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    public void B(byte[] bArr) {
        super.B(bArr);
        try {
            GetGameCategoryResIdl getGameCategoryResIdl = (GetGameCategoryResIdl) new Wire(new Class[0]).parseFrom(bArr, GetGameCategoryResIdl.class);
            if (getGameCategoryResIdl != null && getGameCategoryResIdl.data != null && getGameCategoryResIdl.data.category_list != null) {
                this.aJo.setData(getGameCategoryResIdl.data.category_list);
            }
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    protected NetMessage HU() {
        return new GameClassifyMessage();
    }

    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    protected String HV() {
        return TbConfig.GET_GAME_CATEGORY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    public Class<? extends CachedHttpResponse> HW() {
        return GameClassifyHttpResponse.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    public Class<? extends CachedSocketResponse> HX() {
        return GameClassifySocketResponse.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.game.base.AbsGameClassifyActivity
    public void d(HttpResponsedMessage httpResponsedMessage) {
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
        this.aJo.setData(list);
        if (this.aJo.getCount() <= 0) {
            a(r.a(NoDataViewFactory.ImgType.NODATA), s.bL(y.game_classify_no_data_text), (q) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aw.a(this.aJn, i);
    }
}
