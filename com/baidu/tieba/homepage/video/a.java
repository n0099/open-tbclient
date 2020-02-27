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
    private b hiS;
    private com.baidu.tieba.homepage.video.d.a hiT;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener gHx = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.video.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.h(customResponsedMessage);
            if (a.this.hiT != null) {
                a.this.hiT.bOm();
            }
        }
    };
    private NEGFeedBackView.a haX = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.video.a.2
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
                if (a.this.hiT != null) {
                    a.this.hiT.wN();
                }
            }
        }
    };
    private g.c emi = new g.c() { // from class: com.baidu.tieba.homepage.video.a.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                a.this.hiT.mD(false);
                a.this.hiS.bPE();
                TiebaStatic.log(new an("c13582"));
                return;
            }
            a.this.hiT.b((g.e) null);
            a.this.mPageContext.showToast(R.string.neterror);
        }
    };
    private BdListView.e haZ = new BdListView.e() { // from class: com.baidu.tieba.homepage.video.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            a.this.hiT.bcs();
            a.this.hiS.bGu();
        }
    };
    private b.a hiU = new b.a() { // from class: com.baidu.tieba.homepage.video.a.5
        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void l(int i, String str, boolean z) {
            a.this.hiT.b((g.e) null);
            a.this.hiT.hideLoadingView();
            a.this.hiT.bcv();
            if (v.isEmpty(a.this.hiT.getDataList())) {
                a.this.hiT.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                a.this.hiT.z(a.this.hbb);
            }
            if (StringUtils.isNull(str)) {
                a.this.mPageContext.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.mPageContext.showToast(str);
            }
        }

        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void f(int i, boolean z, boolean z2) {
            a.this.hiT.hideLoadingView();
            a.this.hiT.bcv();
            if (z || z2) {
                a.this.hiT.b((g.e) null);
            } else {
                a.this.hiT.b(a.this.vo(i));
            }
            if (i != 0) {
                a.this.hiT.av(a.this.hiS.getDataList());
                a.this.hiT.z(a.this.hbb);
            } else if (v.isEmpty(a.this.hiT.getDataList())) {
                a.this.hiT.showNoDataView();
            } else if (z) {
                a.this.hiT.bcr();
            }
        }
    };
    private View.OnClickListener hbb = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hiT != null && a.this.hiS != null) {
                a.this.hiT.bcs();
                a.this.hiS.bGu();
            }
        }
    };

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.hiT = new com.baidu.tieba.homepage.video.d.a(this.mPageContext, bdUniqueId, this.haX);
        this.hiS = new b(this.mPageContext, this.hiU);
    }

    public void init() {
        this.hiS.registerListener();
        this.hiT.init();
        this.hiT.setListPullRefreshListener(this.emi);
        this.hiT.a(this.haZ);
        MessageManager.getInstance().registerListener(this.gHx);
    }

    public View getView() {
        if (this.hiT != null) {
            return this.hiT.getRootView();
        }
        return null;
    }

    public void loadData() {
        if (this.hiT != null) {
            this.hiT.bOp();
            this.hiT.showLoadingView();
        }
        if (this.hiS != null) {
            this.hiS.bPE();
        }
    }

    public void AA() {
        if (this.hiT != null) {
            this.hiT.mD(false);
            this.hiT.bOn();
            this.hiT.bOl();
            this.hiT.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g.e vo(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.video_tab_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.video_tab_count, Integer.valueOf(i));
        }
        return new g.e(string, 1000);
    }

    public void aHL() {
        if (this.hiT != null) {
            this.hiT.aHL();
        }
    }

    public void onPause() {
        if (this.hiT != null) {
            this.hiT.onPause();
            this.hiT.bNd();
            this.hiT.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.hiT != null) {
            this.hiT.setListPullRefreshListener(null);
            this.hiT.a((BdListView.e) null);
            this.hiT.onDestroy();
        }
        if (this.hiS != null) {
            this.hiS.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gHx);
    }

    public void setPrimary(boolean z) {
        if (z) {
            this.hiT.bPG();
        } else {
            this.hiT.bNd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.hiS != null && !v.isEmpty(this.hiS.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.hiS.BB(optString);
            this.hiS.Cg(optString);
            if (this.hiT != null) {
                this.hiT.Ci(optString);
            }
        }
    }
}
