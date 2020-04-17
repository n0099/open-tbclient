package com.baidu.tieba.homepage.video;

import android.view.View;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.video.b.b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    private b hUp;
    private com.baidu.tieba.homepage.video.d.a hUq;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener gHm = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.video.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.g(customResponsedMessage);
            if (a.this.hUq != null) {
                a.this.hUq.bZe();
            }
        }
    };
    private NEGFeedBackView.a hMj = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.video.a.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(al alVar) {
            if (alVar == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(al alVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ArrayList<Integer> arrayList, String str, al alVar) {
            if (arrayList != null && alVar != null) {
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    sb.append(arrayList.get(i)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if (alVar.threadType != 0 && alVar.threadType != 40 && alVar.threadType == 49) {
                }
                if (a.this.hUq != null) {
                    a.this.hUq.BD();
                }
            }
        }
    };
    private g.c eQn = new g.c() { // from class: com.baidu.tieba.homepage.video.a.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                a.this.hUq.nN(false);
                a.this.hUp.caz();
                TiebaStatic.log(new an("c13582"));
                return;
            }
            a.this.hUq.b((g.e) null);
            a.this.mPageContext.showToast(R.string.neterror);
        }
    };
    private BdListView.e hMl = new BdListView.e() { // from class: com.baidu.tieba.homepage.video.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            a.this.hUq.blq();
            a.this.hUp.bRk();
        }
    };
    private b.a hUr = new b.a() { // from class: com.baidu.tieba.homepage.video.a.5
        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void m(int i, String str, boolean z) {
            a.this.hUq.b((g.e) null);
            a.this.hUq.hideLoadingView();
            a.this.hUq.blt();
            if (v.isEmpty(a.this.hUq.getDataList())) {
                a.this.hUq.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                a.this.hUq.A(a.this.hMn);
            }
            if (StringUtils.isNull(str)) {
                a.this.mPageContext.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.mPageContext.showToast(str);
            }
        }

        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void f(int i, boolean z, boolean z2) {
            a.this.hUq.hideLoadingView();
            a.this.hUq.blt();
            if (z || z2) {
                a.this.hUq.b((g.e) null);
            } else {
                a.this.hUq.b(a.this.vT(i));
            }
            if (i != 0) {
                a.this.hUq.aE(a.this.hUp.getDataList());
                a.this.hUq.A(a.this.hMn);
            } else if (v.isEmpty(a.this.hUq.getDataList())) {
                a.this.hUq.showNoDataView();
            } else if (z) {
                a.this.hUq.blp();
            }
        }
    };
    private View.OnClickListener hMn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hUq != null && a.this.hUp != null) {
                a.this.hUq.blq();
                a.this.hUp.bRk();
            }
        }
    };

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.hUq = new com.baidu.tieba.homepage.video.d.a(this.mPageContext, bdUniqueId, this.hMj);
        this.hUp = new b(this.mPageContext, this.hUr);
    }

    public void init() {
        this.hUp.registerListener();
        this.hUq.init();
        this.hUq.setListPullRefreshListener(this.eQn);
        this.hUq.a(this.hMl);
        MessageManager.getInstance().registerListener(this.gHm);
    }

    public View getView() {
        if (this.hUq != null) {
            return this.hUq.getRootView();
        }
        return null;
    }

    public void loadData() {
        if (this.hUq != null) {
            this.hUq.bZh();
            this.hUq.showLoadingView();
        }
        if (this.hUp != null) {
            this.hUp.caz();
        }
    }

    public void FH() {
        if (this.hUq != null) {
            this.hUq.nN(false);
            this.hUq.bZf();
            this.hUq.bZd();
            this.hUq.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g.e vT(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.video_tab_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.video_tab_count, Integer.valueOf(i));
        }
        return new g.e(string, 1000);
    }

    public void aQp() {
        if (this.hUq != null) {
            this.hUq.aQp();
        }
    }

    public void onPause() {
        if (this.hUq != null) {
            this.hUq.onPause();
            this.hUq.bXV();
            this.hUq.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.hUq != null) {
            this.hUq.setListPullRefreshListener(null);
            this.hUq.a((BdListView.e) null);
            this.hUq.onDestroy();
        }
        if (this.hUp != null) {
            this.hUp.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gHm);
    }

    public void setPrimary(boolean z) {
        if (z) {
            this.hUq.caB();
        } else {
            this.hUq.bXV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.hUp != null && !v.isEmpty(this.hUp.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.hUp.Dm(optString);
            this.hUp.DP(optString);
            if (this.hUq != null) {
                this.hUq.DR(optString);
            }
        }
    }
}
