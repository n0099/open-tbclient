package com.baidu.tieba.attention;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.data.i;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.b.b;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class AttentionView extends FrameLayout implements d<String> {
    private LinearLayoutManager Xf;
    private int gQL;
    private g gso;
    private b hQd;
    private List<i> hQe;
    private HttpMessageListener hQf;
    private boolean mHasMore;
    private RecyclerView mRecyclerView;
    private h mRefreshView;
    private int mSkinType;

    static /* synthetic */ int b(AttentionView attentionView) {
        int i = attentionView.gQL;
        attentionView.gQL = i + 1;
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
        this.hQe = new ArrayList();
        this.gQL = 1;
        this.hQf = new HttpMessageListener(CmdConfigHttp.CMD_SELECT_FORUM_ATTENTION) { // from class: com.baidu.tieba.attention.AttentionView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                AttentionView.this.hideLoadingView();
                if (httpResponsedMessage.getError() != 0) {
                    if (y.isEmpty(AttentionView.this.hQe)) {
                        AttentionView.this.U(false, true);
                    }
                } else if (!(httpResponsedMessage instanceof AttentionResMsg)) {
                    if (y.isEmpty(AttentionView.this.hQe)) {
                        AttentionView.this.U(false, true);
                    }
                } else {
                    List<i> selectForumDataList = ((AttentionResMsg) httpResponsedMessage).getSelectForumDataList();
                    if (y.isEmpty(selectForumDataList)) {
                        if (y.isEmpty(AttentionView.this.hQe)) {
                            AttentionView.this.U(false, false);
                            return;
                        }
                        return;
                    }
                    AttentionView.this.mHasMore = ((AttentionResMsg) httpResponsedMessage).getHasMore();
                    AttentionView.b(AttentionView.this);
                    AttentionView.this.hQe.addAll(selectForumDataList);
                    AttentionView.this.hQd.bi(AttentionView.this.hQe);
                    AttentionView.this.hQd.notifyDataSetChanged();
                }
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.select_forum_lately_layout, (ViewGroup) this, true);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.select_forum_list);
        this.hQd = new b(this);
        this.hQd.setType(2);
        this.Xf = new LinearLayoutManager(getContext());
        this.mRecyclerView.setLayoutManager(this.Xf);
        this.mRecyclerView.setAdapter(this.hQd);
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.attention.AttentionView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 0 && AttentionView.this.mHasMore && AttentionView.this.Xf.findLastVisibleItemPosition() == AttentionView.this.hQd.getItemCount() - 1) {
                    AttentionView.this.az(null);
                }
            }
        });
        MessageManager.getInstance().registerListener(this.hQf);
    }

    @Override // com.baidu.tieba.d
    public String getTitle() {
        return getContext().getString(R.string.activity_select_forum_tab_attention);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.d
    /* renamed from: request */
    public void az(String str) {
        if (y.isEmpty(this.hQe)) {
            if (!j.isNetworkAvailableForImmediately()) {
                U(false, true);
                return;
            } else {
                Wk();
                hJ(false);
            }
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SELECT_FORUM_ATTENTION);
        httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
        httpMessage.addParam("from_index", 1);
        httpMessage.addParam("page_size", 50);
        httpMessage.addParam("page_no", this.gQL);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.tieba.d
    public void EQ(String str) {
    }

    public void hJ(boolean z) {
        if (!cmJ()) {
            if (this.gso == null) {
                this.gso = new g(getContext());
                this.gso.onChangeSkinType();
            }
            this.gso.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gso != null) {
            this.gso.dettachView(this);
            this.gso = null;
        }
    }

    public boolean cmJ() {
        if (this.gso != null) {
            return this.gso.isViewAttached();
        }
        return false;
    }

    public void U(boolean z, boolean z2) {
        if (!cmK()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.attention.AttentionView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            AttentionView.this.az(null);
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(getResources().getDimensionPixelSize(R.dimen.tbds380));
            this.mRefreshView.attachView(this, z);
            if (z2) {
                this.mRefreshView.showRefreshButton();
            } else {
                this.mRefreshView.rE(R.drawable.new_pic_emotion_01);
                this.mRefreshView.hideRefreshButton();
            }
            this.mRefreshView.Ed(getContext().getString(R.string.activity_select_forum_attention_empty));
            this.mRecyclerView.setVisibility(8);
        }
    }

    public void Wk() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.mRecyclerView.setVisibility(0);
    }

    public boolean cmK() {
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
            if (this.gso != null) {
                this.gso.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            this.hQd.notifyDataSetChanged();
        }
    }
}
