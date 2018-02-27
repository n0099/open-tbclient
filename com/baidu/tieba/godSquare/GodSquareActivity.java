package com.baidu.tieba.godSquare;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.godSquare.model.b;
import java.util.List;
/* loaded from: classes3.dex */
public class GodSquareActivity extends BaseActivity<GodSquareActivity> implements BdListView.e, j.b {
    private a edK;
    private b edL;
    private boolean mHasMore = true;
    private boolean edM = false;
    private b.a edN = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<i> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.edK.getListView().completePullRefreshPostDelayed(2000L);
            GodSquareActivity.this.edK.VU();
            if (v.E(list)) {
                GodSquareActivity.this.edK.aBK();
                if (v.E(GodSquareActivity.this.edL.dBh)) {
                    GodSquareActivity.this.edK.lB(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.pa()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.edK.XM();
            if (z) {
                GodSquareActivity.this.edL.dBh = list;
                GodSquareActivity.this.edK.bI(GodSquareActivity.this.edL.dBh);
            } else {
                GodSquareActivity.this.edL.dBh.addAll(list);
                GodSquareActivity.this.edK.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.edK.aBJ();
            } else {
                GodSquareActivity.this.edK.aBL();
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
                    if (GodSquareActivity.this.edL.bK(com.baidu.adp.lib.g.b.c(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.edM = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a dbl = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bu(boolean z) {
            if (z) {
                if (v.E(GodSquareActivity.this.edL.dBh)) {
                    GodSquareActivity.this.aBI();
                } else {
                    GodSquareActivity.this.edK.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.edK = new a(this);
        this.edK.g(this.dbl);
        this.edL = new b(this.edN, this);
        registerListener(this.mAttentionListener);
        aBI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.edK.notifyDataSetChanged();
        if (this.edM) {
            this.edK.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBI() {
        this.edK.VT();
        this.edL.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.ox()) {
            aBI();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.edK.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bw(boolean z) {
        this.edM = false;
        this.edL.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.edL.WN();
            this.edK.aBJ();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a009";
    }
}
