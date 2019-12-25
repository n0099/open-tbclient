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
/* loaded from: classes6.dex */
public class a {
    private b hdo;
    private com.baidu.tieba.homepage.video.d.a hdp;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener gCj = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.video.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.h(customResponsedMessage);
            if (a.this.hdp != null) {
                a.this.hdp.bLC();
            }
        }
    };
    private NEGFeedBackView.a gVz = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.video.a.2
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
                if (a.this.hdp != null) {
                    a.this.hdp.uS();
                }
            }
        }
    };
    private g.c ehg = new g.c() { // from class: com.baidu.tieba.homepage.video.a.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                a.this.hdp.mq(false);
                a.this.hdo.bMU();
                TiebaStatic.log(new an("c13582"));
                return;
            }
            a.this.hdp.b((g.e) null);
            a.this.mPageContext.showToast(R.string.neterror);
        }
    };
    private BdListView.e gVB = new BdListView.e() { // from class: com.baidu.tieba.homepage.video.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            a.this.hdp.aZH();
            a.this.hdo.bDQ();
        }
    };
    private b.a hdq = new b.a() { // from class: com.baidu.tieba.homepage.video.a.5
        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void l(int i, String str, boolean z) {
            a.this.hdp.b((g.e) null);
            a.this.hdp.hideLoadingView();
            a.this.hdp.aZK();
            if (v.isEmpty(a.this.hdp.getDataList())) {
                a.this.hdp.m(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                a.this.hdp.z(a.this.gVD);
            }
            if (StringUtils.isNull(str)) {
                a.this.mPageContext.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.mPageContext.showToast(str);
            }
        }

        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void f(int i, boolean z, boolean z2) {
            a.this.hdp.hideLoadingView();
            a.this.hdp.aZK();
            if (z || z2) {
                a.this.hdp.b((g.e) null);
            } else {
                a.this.hdp.b(a.this.vd(i));
            }
            if (i != 0) {
                a.this.hdp.aw(a.this.hdo.getDataList());
                a.this.hdp.z(a.this.gVD);
            } else if (v.isEmpty(a.this.hdp.getDataList())) {
                a.this.hdp.showNoDataView();
            } else if (z) {
                a.this.hdp.aZG();
            }
        }
    };
    private View.OnClickListener gVD = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hdp != null && a.this.hdo != null) {
                a.this.hdp.aZH();
                a.this.hdo.bDQ();
            }
        }
    };

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.hdp = new com.baidu.tieba.homepage.video.d.a(this.mPageContext, bdUniqueId, this.gVz);
        this.hdo = new b(this.mPageContext, this.hdq);
    }

    public void init() {
        this.hdo.registerListener();
        this.hdp.init();
        this.hdp.setListPullRefreshListener(this.ehg);
        this.hdp.a(this.gVB);
        MessageManager.getInstance().registerListener(this.gCj);
    }

    public View getView() {
        if (this.hdp != null) {
            return this.hdp.getRootView();
        }
        return null;
    }

    public void loadData() {
        if (this.hdp != null) {
            this.hdp.bLF();
            this.hdp.showLoadingView();
        }
        if (this.hdo != null) {
            this.hdo.bMU();
        }
    }

    public void xT() {
        if (this.hdp != null) {
            this.hdp.mq(false);
            this.hdp.bLD();
            this.hdp.bLB();
            this.hdp.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g.e vd(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.video_tab_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.video_tab_count, Integer.valueOf(i));
        }
        return new g.e(string, 1000);
    }

    public void aFd() {
        if (this.hdp != null) {
            this.hdp.aFd();
        }
    }

    public void onPause() {
        if (this.hdp != null) {
            this.hdp.onPause();
            this.hdp.bKv();
            this.hdp.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.hdp != null) {
            this.hdp.setListPullRefreshListener(null);
            this.hdp.a((BdListView.e) null);
            this.hdp.onDestroy();
        }
        if (this.hdo != null) {
            this.hdo.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gCj);
    }

    public void setPrimary(boolean z) {
        if (z) {
            this.hdp.bMW();
        } else {
            this.hdp.bKv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.hdo != null && !v.isEmpty(this.hdo.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.hdo.Bb(optString);
            this.hdo.BG(optString);
            if (this.hdp != null) {
                this.hdp.BI(optString);
            }
        }
    }
}
