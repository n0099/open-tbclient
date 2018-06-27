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
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.godSquare.model.b;
import java.util.List;
/* loaded from: classes3.dex */
public class GodSquareActivity extends BaseActivity<GodSquareActivity> implements BdListView.e, g.b {
    private a dOl;
    private b dOm;
    private boolean mHasMore = true;
    private boolean dOn = false;
    private b.a dOo = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<h> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.dOl.getListView().completePullRefreshPostDelayed(2000L);
            GodSquareActivity.this.dOl.hideLoadingView();
            if (w.A(list)) {
                GodSquareActivity.this.dOl.aCe();
                if (w.A(GodSquareActivity.this.dOm.dgd)) {
                    GodSquareActivity.this.dOl.mo(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.jU()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.dOl.Uc();
            if (z) {
                GodSquareActivity.this.dOm.dgd = list;
                GodSquareActivity.this.dOl.bO(GodSquareActivity.this.dOm.dgd);
            } else {
                GodSquareActivity.this.dOm.dgd.addAll(list);
                GodSquareActivity.this.dOl.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.dOl.aCd();
            } else {
                GodSquareActivity.this.dOl.aCf();
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
                    if (GodSquareActivity.this.dOm.bK(com.baidu.adp.lib.g.b.c(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.dOn = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a cAL = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aS(boolean z) {
            if (z) {
                if (w.A(GodSquareActivity.this.dOm.dgd)) {
                    GodSquareActivity.this.aCc();
                } else {
                    GodSquareActivity.this.dOl.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dOl = new a(this);
        this.dOl.g(this.cAL);
        this.dOm = new b(this.dOo, this);
        registerListener(this.mAttentionListener);
        aCc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dOl.notifyDataSetChanged();
        if (this.dOn) {
            this.dOl.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCc() {
        this.dOl.showLoadingView();
        this.dOm.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.jr()) {
            aCc();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dOl.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.g.b
    public void aU(boolean z) {
        this.dOn = false;
        this.dOm.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.dOm.Tf();
            this.dOl.aCd();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a009";
    }
}
