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
    private a gcG;
    private b gcH;
    private boolean mHasMore = true;
    private boolean gcI = false;
    private b.a gcJ = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<m> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.gcG.getListView().completePullRefreshPostDelayed(0L);
            GodSquareActivity.this.gcG.hideLoadingView();
            if (v.aa(list)) {
                GodSquareActivity.this.gcG.bvu();
                if (v.aa(GodSquareActivity.this.gcH.fsx)) {
                    GodSquareActivity.this.gcG.xo(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.kt()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.gcG.aJN();
            if (z) {
                GodSquareActivity.this.gcH.fsx = list;
                GodSquareActivity.this.gcG.cx(GodSquareActivity.this.gcH.fsx);
            } else {
                GodSquareActivity.this.gcH.fsx.addAll(list);
                GodSquareActivity.this.gcG.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.gcG.bvt();
            } else {
                GodSquareActivity.this.gcG.bvv();
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
                    if (GodSquareActivity.this.gcH.dr(com.baidu.adp.lib.g.b.e(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.gcI = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a eIX = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void es(boolean z) {
            if (z) {
                if (v.aa(GodSquareActivity.this.gcH.fsx)) {
                    GodSquareActivity.this.bvs();
                } else {
                    GodSquareActivity.this.gcG.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gcG = new a(this);
        this.gcG.g(this.eIX);
        this.gcH = new b(this.gcJ, this);
        registerListener(this.mAttentionListener);
        bvs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gcG.notifyDataSetChanged();
        if (this.gcI) {
            this.gcG.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvs() {
        this.gcG.showLoadingView();
        this.gcH.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.jQ()) {
            bvs();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gcG.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void eu(boolean z) {
        this.gcI = false;
        this.gcH.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.gcH.aJw();
            this.gcG.bvt();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a009";
    }
}
