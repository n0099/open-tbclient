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
    private b hUv;
    private com.baidu.tieba.homepage.video.d.a hUw;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener gHs = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.video.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.g(customResponsedMessage);
            if (a.this.hUw != null) {
                a.this.hUw.bZd();
            }
        }
    };
    private NEGFeedBackView.a hMp = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.video.a.2
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
                if (a.this.hUw != null) {
                    a.this.hUw.BC();
                }
            }
        }
    };
    private g.c eQs = new g.c() { // from class: com.baidu.tieba.homepage.video.a.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                a.this.hUw.nN(false);
                a.this.hUv.cay();
                TiebaStatic.log(new an("c13582"));
                return;
            }
            a.this.hUw.b((g.e) null);
            a.this.mPageContext.showToast(R.string.neterror);
        }
    };
    private BdListView.e hMr = new BdListView.e() { // from class: com.baidu.tieba.homepage.video.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            a.this.hUw.blo();
            a.this.hUv.bRj();
        }
    };
    private b.a hUx = new b.a() { // from class: com.baidu.tieba.homepage.video.a.5
        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void m(int i, String str, boolean z) {
            a.this.hUw.b((g.e) null);
            a.this.hUw.hideLoadingView();
            a.this.hUw.blr();
            if (v.isEmpty(a.this.hUw.getDataList())) {
                a.this.hUw.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                a.this.hUw.A(a.this.hMt);
            }
            if (StringUtils.isNull(str)) {
                a.this.mPageContext.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.mPageContext.showToast(str);
            }
        }

        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void f(int i, boolean z, boolean z2) {
            a.this.hUw.hideLoadingView();
            a.this.hUw.blr();
            if (z || z2) {
                a.this.hUw.b((g.e) null);
            } else {
                a.this.hUw.b(a.this.vT(i));
            }
            if (i != 0) {
                a.this.hUw.aE(a.this.hUv.getDataList());
                a.this.hUw.A(a.this.hMt);
            } else if (v.isEmpty(a.this.hUw.getDataList())) {
                a.this.hUw.showNoDataView();
            } else if (z) {
                a.this.hUw.bln();
            }
        }
    };
    private View.OnClickListener hMt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hUw != null && a.this.hUv != null) {
                a.this.hUw.blo();
                a.this.hUv.bRj();
            }
        }
    };

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.hUw = new com.baidu.tieba.homepage.video.d.a(this.mPageContext, bdUniqueId, this.hMp);
        this.hUv = new b(this.mPageContext, this.hUx);
    }

    public void init() {
        this.hUv.registerListener();
        this.hUw.init();
        this.hUw.setListPullRefreshListener(this.eQs);
        this.hUw.a(this.hMr);
        MessageManager.getInstance().registerListener(this.gHs);
    }

    public View getView() {
        if (this.hUw != null) {
            return this.hUw.getRootView();
        }
        return null;
    }

    public void loadData() {
        if (this.hUw != null) {
            this.hUw.bZg();
            this.hUw.showLoadingView();
        }
        if (this.hUv != null) {
            this.hUv.cay();
        }
    }

    public void FG() {
        if (this.hUw != null) {
            this.hUw.nN(false);
            this.hUw.bZe();
            this.hUw.bZc();
            this.hUw.startPullRefresh();
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

    public void aQm() {
        if (this.hUw != null) {
            this.hUw.aQm();
        }
    }

    public void onPause() {
        if (this.hUw != null) {
            this.hUw.onPause();
            this.hUw.bXU();
            this.hUw.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.hUw != null) {
            this.hUw.setListPullRefreshListener(null);
            this.hUw.a((BdListView.e) null);
            this.hUw.onDestroy();
        }
        if (this.hUv != null) {
            this.hUv.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gHs);
    }

    public void setPrimary(boolean z) {
        if (z) {
            this.hUw.caA();
        } else {
            this.hUw.bXU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.hUv != null && !v.isEmpty(this.hUv.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.hUv.Dp(optString);
            this.hUv.DS(optString);
            if (this.hUw != null) {
                this.hUw.DU(optString);
            }
        }
    }
}
