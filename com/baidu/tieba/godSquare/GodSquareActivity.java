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
    private a dyG;
    private b dyH;
    private boolean mHasMore = true;
    private boolean dyI = false;
    private b.a dyJ = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<h> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.dyG.getListView().completePullRefreshPostDelayed(2000L);
            GodSquareActivity.this.dyG.Ou();
            if (v.w(list)) {
                GodSquareActivity.this.dyG.awH();
                if (v.w(GodSquareActivity.this.dyH.cTW)) {
                    GodSquareActivity.this.dyG.lE(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.hg()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.dyG.Qn();
            if (z) {
                GodSquareActivity.this.dyH.cTW = list;
                GodSquareActivity.this.dyG.bC(GodSquareActivity.this.dyH.cTW);
            } else {
                GodSquareActivity.this.dyH.cTW.addAll(list);
                GodSquareActivity.this.dyG.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.dyG.awG();
            } else {
                GodSquareActivity.this.dyG.awI();
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
                    if (GodSquareActivity.this.dyH.bI(com.baidu.adp.lib.g.b.c(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.dyI = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a ctg = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (z) {
                if (v.w(GodSquareActivity.this.dyH.cTW)) {
                    GodSquareActivity.this.awF();
                } else {
                    GodSquareActivity.this.dyG.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dyG = new a(this);
        this.dyG.g(this.ctg);
        this.dyH = new b(this.dyJ, this);
        registerListener(this.mAttentionListener);
        awF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dyG.notifyDataSetChanged();
        if (this.dyI) {
            this.dyG.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awF() {
        this.dyG.showLoadingView();
        this.dyH.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.gD()) {
            awF();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dyG.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.e.b
    public void aO(boolean z) {
        this.dyI = false;
        this.dyH.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.dyH.Po();
            this.dyG.awG();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a009";
    }
}
