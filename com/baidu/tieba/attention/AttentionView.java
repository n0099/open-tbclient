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
/* loaded from: classes21.dex */
public class AttentionView extends FrameLayout implements d<String> {
    private LinearLayoutManager WN;
    private g fQf;
    private int gkS;
    private b hiP;
    private List<i> hiQ;
    private HttpMessageListener hiR;
    private boolean mHasMore;
    private RecyclerView mRecyclerView;
    private h mRefreshView;
    private int mSkinType;

    static /* synthetic */ int b(AttentionView attentionView) {
        int i = attentionView.gkS;
        attentionView.gkS = i + 1;
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
        this.hiQ = new ArrayList();
        this.gkS = 1;
        this.hiR = new HttpMessageListener(CmdConfigHttp.CMD_SELECT_FORUM_ATTENTION) { // from class: com.baidu.tieba.attention.AttentionView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                AttentionView.this.hideLoadingView();
                if (httpResponsedMessage.getError() != 0) {
                    if (y.isEmpty(AttentionView.this.hiQ)) {
                        AttentionView.this.R(false, true);
                    }
                } else if (!(httpResponsedMessage instanceof AttentionResMsg)) {
                    if (y.isEmpty(AttentionView.this.hiQ)) {
                        AttentionView.this.R(false, true);
                    }
                } else {
                    List<i> selectForumDataList = ((AttentionResMsg) httpResponsedMessage).getSelectForumDataList();
                    if (y.isEmpty(selectForumDataList)) {
                        if (y.isEmpty(AttentionView.this.hiQ)) {
                            AttentionView.this.R(false, false);
                            return;
                        }
                        return;
                    }
                    AttentionView.this.mHasMore = ((AttentionResMsg) httpResponsedMessage).getHasMore();
                    AttentionView.b(AttentionView.this);
                    AttentionView.this.hiQ.addAll(selectForumDataList);
                    AttentionView.this.hiP.aO(AttentionView.this.hiQ);
                    AttentionView.this.hiP.notifyDataSetChanged();
                }
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.select_forum_lately_layout, (ViewGroup) this, true);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.select_forum_list);
        this.hiP = new b(this);
        this.hiP.setType(2);
        this.WN = new LinearLayoutManager(getContext());
        this.mRecyclerView.setLayoutManager(this.WN);
        this.mRecyclerView.setAdapter(this.hiP);
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.attention.AttentionView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 0 && AttentionView.this.mHasMore && AttentionView.this.WN.findLastVisibleItemPosition() == AttentionView.this.hiP.getItemCount() - 1) {
                    AttentionView.this.aw(null);
                }
            }
        });
        MessageManager.getInstance().registerListener(this.hiR);
    }

    @Override // com.baidu.tieba.d
    public String getTitle() {
        return getContext().getString(R.string.activity_select_forum_tab_attention);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.d
    /* renamed from: request */
    public void aw(String str) {
        if (y.isEmpty(this.hiQ)) {
            if (!j.isNetworkAvailableForImmediately()) {
                R(false, true);
                return;
            } else {
                bHn();
                gR(false);
            }
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SELECT_FORUM_ATTENTION);
        httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
        httpMessage.addParam("from_index", 1);
        httpMessage.addParam("page_size", 50);
        httpMessage.addParam("page_no", this.gkS);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.tieba.d
    public void Dy(String str) {
    }

    public void gR(boolean z) {
        if (!cdE()) {
            if (this.fQf == null) {
                this.fQf = new g(getContext());
                this.fQf.onChangeSkinType();
            }
            this.fQf.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.fQf != null) {
            this.fQf.dettachView(this);
            this.fQf = null;
        }
    }

    public boolean cdE() {
        if (this.fQf != null) {
            return this.fQf.isViewAttached();
        }
        return false;
    }

    public void R(boolean z, boolean z2) {
        if (!cdF()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.attention.AttentionView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            AttentionView.this.aw(null);
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(getResources().getDimensionPixelSize(R.dimen.tbds380));
            this.mRefreshView.attachView(this, z);
            if (z2) {
                this.mRefreshView.showRefreshButton();
            } else {
                this.mRefreshView.qL(R.drawable.new_pic_emotion_01);
                this.mRefreshView.hideRefreshButton();
            }
            this.mRefreshView.CK(getContext().getString(R.string.activity_select_forum_attention_empty));
            this.mRecyclerView.setVisibility(8);
        }
    }

    public void bHn() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.mRecyclerView.setVisibility(0);
    }

    public boolean cdF() {
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
            if (this.fQf != null) {
                this.fQf.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            this.hiP.notifyDataSetChanged();
        }
    }
}
