package com.baidu.tieba.godSquare;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.godSquare.model.b;
import java.util.List;
/* loaded from: classes3.dex */
public class GodSquareActivity extends BaseActivity<GodSquareActivity> implements BdListView.e, f.b {
    private a dKU;
    private b dKV;
    private boolean mHasMore = true;
    private boolean dKW = false;
    private b.a dKX = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<h> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.dKU.getListView().completePullRefreshPostDelayed(2000L);
            GodSquareActivity.this.dKU.hideLoadingView();
            if (w.z(list)) {
                GodSquareActivity.this.dKU.aBy();
                if (w.z(GodSquareActivity.this.dKV.del)) {
                    GodSquareActivity.this.dKU.mo(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.jU()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.dKU.TI();
            if (z) {
                GodSquareActivity.this.dKV.del = list;
                GodSquareActivity.this.dKU.bK(GodSquareActivity.this.dKV.del);
            } else {
                GodSquareActivity.this.dKV.del.addAll(list);
                GodSquareActivity.this.dKU.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.dKU.aBx();
            } else {
                GodSquareActivity.this.dKU.aBz();
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.godSquare.GodSquareActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (GodSquareActivity.this.dKV.bO(com.baidu.adp.lib.g.b.c(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.dKW = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a cCR = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aQ(boolean z) {
            if (z) {
                if (w.z(GodSquareActivity.this.dKV.del)) {
                    GodSquareActivity.this.aBw();
                } else {
                    GodSquareActivity.this.dKU.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dKU = new a(this);
        this.dKU.g(this.cCR);
        this.dKV = new b(this.dKX, this);
        registerListener(this.mAttentionListener);
        aBw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dKU.notifyDataSetChanged();
        if (this.dKW) {
            this.dKU.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBw() {
        this.dKU.showLoadingView();
        this.dKV.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.jr()) {
            aBw();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dKU.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.f.b
    public void aS(boolean z) {
        this.dKW = false;
        this.dKV.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.dKV.SJ();
            this.dKU.aBx();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a009";
    }
}
