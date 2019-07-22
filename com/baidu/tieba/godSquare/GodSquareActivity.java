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
    private a fZZ;
    private b gaa;
    private boolean mHasMore = true;
    private boolean gab = false;
    private b.a gac = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<m> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.fZZ.getListView().completePullRefreshPostDelayed(0L);
            GodSquareActivity.this.fZZ.hideLoadingView();
            if (v.aa(list)) {
                GodSquareActivity.this.fZZ.but();
                if (v.aa(GodSquareActivity.this.gaa.fqk)) {
                    GodSquareActivity.this.fZZ.wO(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.kt()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.fZZ.aJh();
            if (z) {
                GodSquareActivity.this.gaa.fqk = list;
                GodSquareActivity.this.fZZ.cy(GodSquareActivity.this.gaa.fqk);
            } else {
                GodSquareActivity.this.gaa.fqk.addAll(list);
                GodSquareActivity.this.fZZ.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.fZZ.bus();
            } else {
                GodSquareActivity.this.fZZ.buu();
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
                    if (GodSquareActivity.this.gaa.m21do(com.baidu.adp.lib.g.b.c(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.gab = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a eHh = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void ep(boolean z) {
            if (z) {
                if (v.aa(GodSquareActivity.this.gaa.fqk)) {
                    GodSquareActivity.this.bur();
                } else {
                    GodSquareActivity.this.fZZ.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fZZ = new a(this);
        this.fZZ.g(this.eHh);
        this.gaa = new b(this.gac, this);
        registerListener(this.mAttentionListener);
        bur();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.fZZ.notifyDataSetChanged();
        if (this.gab) {
            this.fZZ.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bur() {
        this.fZZ.showLoadingView();
        this.gaa.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.jQ()) {
            bur();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fZZ.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void er(boolean z) {
        this.gab = false;
        this.gaa.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.gaa.aIQ();
            this.fZZ.bus();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a009";
    }
}
