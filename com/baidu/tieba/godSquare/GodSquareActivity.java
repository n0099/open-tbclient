package com.baidu.tieba.godSquare;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.godSquare.model.b;
import java.util.List;
/* loaded from: classes6.dex */
public class GodSquareActivity extends BaseActivity<GodSquareActivity> implements BdListView.e, h.c {
    private a gaP;
    private b gaQ;
    private boolean mHasMore = true;
    private boolean gaR = false;
    private b.a gaS = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<m> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.gaP.getListView().completePullRefreshPostDelayed(0L);
            GodSquareActivity.this.gaP.hideLoadingView();
            if (v.aa(list)) {
                GodSquareActivity.this.gaP.buG();
                if (v.aa(GodSquareActivity.this.gaQ.fqJ)) {
                    GodSquareActivity.this.gaP.wP(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.kt()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.gaP.aJj();
            if (z) {
                GodSquareActivity.this.gaQ.fqJ = list;
                GodSquareActivity.this.gaP.cx(GodSquareActivity.this.gaQ.fqJ);
            } else {
                GodSquareActivity.this.gaQ.fqJ.addAll(list);
                GodSquareActivity.this.gaP.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.gaP.buF();
            } else {
                GodSquareActivity.this.gaP.buH();
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
                    if (GodSquareActivity.this.gaQ.m21do(com.baidu.adp.lib.g.b.c(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.gaR = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a eHo = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void ep(boolean z) {
            if (z) {
                if (v.aa(GodSquareActivity.this.gaQ.fqJ)) {
                    GodSquareActivity.this.buE();
                } else {
                    GodSquareActivity.this.gaP.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gaP = new a(this);
        this.gaP.g(this.eHo);
        this.gaQ = new b(this.gaS, this);
        registerListener(this.mAttentionListener);
        buE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gaP.notifyDataSetChanged();
        if (this.gaR) {
            this.gaP.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buE() {
        this.gaP.showLoadingView();
        this.gaQ.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.jQ()) {
            buE();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gaP.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void er(boolean z) {
        this.gaR = false;
        this.gaQ.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.gaQ.aIS();
            this.gaP.buF();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a009";
    }
}
