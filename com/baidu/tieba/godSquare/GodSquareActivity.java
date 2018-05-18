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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.godSquare.model.b;
import java.util.List;
/* loaded from: classes3.dex */
public class GodSquareActivity extends BaseActivity<GodSquareActivity> implements BdListView.e, e.b {
    private a dzK;
    private b dzL;
    private boolean mHasMore = true;
    private boolean dzM = false;
    private b.a dzN = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<h> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.dzK.getListView().completePullRefreshPostDelayed(2000L);
            GodSquareActivity.this.dzK.Os();
            if (v.w(list)) {
                GodSquareActivity.this.dzK.awG();
                if (v.w(GodSquareActivity.this.dzL.cVa)) {
                    GodSquareActivity.this.dzK.lH(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.hg()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.dzK.Qk();
            if (z) {
                GodSquareActivity.this.dzL.cVa = list;
                GodSquareActivity.this.dzK.bF(GodSquareActivity.this.dzL.cVa);
            } else {
                GodSquareActivity.this.dzL.cVa.addAll(list);
                GodSquareActivity.this.dzK.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.dzK.awF();
            } else {
                GodSquareActivity.this.dzK.awH();
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
                    if (GodSquareActivity.this.dzL.bI(com.baidu.adp.lib.g.b.c(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.dzM = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a cun = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (z) {
                if (v.w(GodSquareActivity.this.dzL.cVa)) {
                    GodSquareActivity.this.awE();
                } else {
                    GodSquareActivity.this.dzK.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dzK = new a(this);
        this.dzK.g(this.cun);
        this.dzL = new b(this.dzN, this);
        registerListener(this.mAttentionListener);
        awE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dzK.notifyDataSetChanged();
        if (this.dzM) {
            this.dzK.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awE() {
        this.dzK.showLoadingView();
        this.dzL.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.gD()) {
            awE();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dzK.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.e.b
    public void aO(boolean z) {
        this.dzM = false;
        this.dzL.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.dzL.Pl();
            this.dzK.awF();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a009";
    }
}
