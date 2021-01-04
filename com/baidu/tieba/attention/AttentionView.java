package com.baidu.tieba.attention;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.data.j;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.adapter.SelectForumItemAdapter;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class AttentionView extends FrameLayout implements d<String> {
    private LinearLayoutManager Ye;
    private int cea;
    private g gLj;
    private SelectForumItemAdapter inZ;
    private List<j> ioa;
    private HttpMessageListener iob;
    private boolean mHasMore;
    private RecyclerView mRecyclerView;
    private h mRefreshView;
    private int mSkinType;

    static /* synthetic */ int b(AttentionView attentionView) {
        int i = attentionView.cea;
        attentionView.cea = i + 1;
        return i;
    }

    public AttentionView(Context context) {
        this(context, null);
    }

    public AttentionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.ioa = new ArrayList();
        this.cea = 1;
        this.iob = new HttpMessageListener(CmdConfigHttp.CMD_SELECT_FORUM_ATTENTION) { // from class: com.baidu.tieba.attention.AttentionView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                AttentionView.this.hideLoadingView();
                if (httpResponsedMessage.getError() != 0) {
                    if (x.isEmpty(AttentionView.this.ioa)) {
                        AttentionView.this.W(false, true);
                    }
                } else if (!(httpResponsedMessage instanceof AttentionResMsg)) {
                    if (x.isEmpty(AttentionView.this.ioa)) {
                        AttentionView.this.W(false, true);
                    }
                } else {
                    List<j> selectForumDataList = ((AttentionResMsg) httpResponsedMessage).getSelectForumDataList();
                    if (x.isEmpty(selectForumDataList)) {
                        if (x.isEmpty(AttentionView.this.ioa)) {
                            AttentionView.this.W(false, false);
                            return;
                        }
                        return;
                    }
                    AttentionView.this.mHasMore = ((AttentionResMsg) httpResponsedMessage).getHasMore();
                    AttentionView.b(AttentionView.this);
                    AttentionView.this.ioa.addAll(selectForumDataList);
                    AttentionView.this.inZ.bs(AttentionView.this.ioa);
                    AttentionView.this.inZ.notifyDataSetChanged();
                }
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.select_forum_lately_layout, (ViewGroup) this, true);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.select_forum_list);
        this.inZ = new SelectForumItemAdapter(this);
        this.inZ.setType(2);
        this.Ye = new LinearLayoutManager(getContext());
        this.mRecyclerView.setLayoutManager(this.Ye);
        this.mRecyclerView.setAdapter(this.inZ);
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.attention.AttentionView.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 0 && AttentionView.this.mHasMore && AttentionView.this.Ye.findLastVisibleItemPosition() == AttentionView.this.inZ.getItemCount() - 1) {
                    AttentionView.this.aB(null);
                }
            }
        });
        MessageManager.getInstance().registerListener(this.iob);
    }

    @Override // com.baidu.tieba.d
    public String getTitle() {
        return getContext().getString(R.string.activity_select_forum_tab_attention);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.d
    /* renamed from: request */
    public void aB(String str) {
        if (x.isEmpty(this.ioa)) {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                W(false, true);
                return;
            } else {
                Zi();
                it(false);
            }
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SELECT_FORUM_ATTENTION);
        httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
        httpMessage.addParam("from_index", 1);
        httpMessage.addParam("page_size", 50);
        httpMessage.addParam("page_no", this.cea);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.tieba.d
    public void Fd(String str) {
    }

    public void it(boolean z) {
        if (!cts()) {
            if (this.gLj == null) {
                this.gLj = new g(getContext());
                this.gLj.onChangeSkinType();
            }
            this.gLj.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gLj != null) {
            this.gLj.dettachView(this);
            this.gLj = null;
        }
    }

    public boolean cts() {
        if (this.gLj != null) {
            return this.gLj.isViewAttached();
        }
        return false;
    }

    public void W(boolean z, boolean z2) {
        if (!ctt()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.attention.AttentionView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            AttentionView.this.aB(null);
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(getResources().getDimensionPixelSize(R.dimen.tbds380));
            this.mRefreshView.attachView(this, z);
            if (z2) {
                this.mRefreshView.showRefreshButton();
            } else {
                this.mRefreshView.sP(R.drawable.new_pic_emotion_01);
                this.mRefreshView.hideRefreshButton();
            }
            this.mRefreshView.Eh(getContext().getString(R.string.activity_select_forum_empty));
            this.mRecyclerView.setVisibility(8);
        }
    }

    public void Zi() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.mRecyclerView.setVisibility(0);
    }

    public boolean ctt() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    @Override // com.baidu.tieba.d
    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.gLj != null) {
                this.gLj.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            this.inZ.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.d
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iob);
    }
}
