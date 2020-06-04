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
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.video.b.b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    private b ijT;
    private com.baidu.tieba.homepage.video.d.a ijU;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener gWm = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.video.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.g(customResponsedMessage);
            if (a.this.ijU != null) {
                a.this.ijU.cfH();
            }
        }
    };
    private NEGFeedBackView.a ibD = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.video.a.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(ak akVar) {
            if (akVar == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ak akVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ArrayList<Integer> arrayList, String str, ak akVar) {
            if (arrayList != null && akVar != null) {
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    sb.append(arrayList.get(i)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if (akVar.threadType != 0 && akVar.threadType != 40 && akVar.threadType == 49) {
                }
                if (a.this.ijU != null) {
                    a.this.ijU.CZ();
                }
            }
        }
    };
    private f.c fdl = new f.c() { // from class: com.baidu.tieba.homepage.video.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                a.this.ijU.oj(false);
                a.this.ijT.chg();
                TiebaStatic.log(new an("c13582"));
                return;
            }
            a.this.ijU.b((f.e) null);
            a.this.mPageContext.showToast(R.string.neterror);
        }
    };
    private BdListView.e ibF = new BdListView.e() { // from class: com.baidu.tieba.homepage.video.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            a.this.ijU.bqM();
            a.this.ijT.bXH();
        }
    };
    private b.a ijV = new b.a() { // from class: com.baidu.tieba.homepage.video.a.5
        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void m(int i, String str, boolean z) {
            a.this.ijU.b((f.e) null);
            a.this.ijU.hideLoadingView();
            a.this.ijU.bqQ();
            if (v.isEmpty(a.this.ijU.getDataList())) {
                a.this.ijU.k(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                a.this.ijU.z(a.this.ibH);
            }
            if (StringUtils.isNull(str)) {
                a.this.mPageContext.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.mPageContext.showToast(str);
            }
        }

        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void f(int i, boolean z, boolean z2) {
            a.this.ijU.hideLoadingView();
            a.this.ijU.bqQ();
            if (z || z2) {
                a.this.ijU.b((f.e) null);
            } else {
                a.this.ijU.b(a.this.wB(i));
            }
            if (i != 0) {
                a.this.ijU.az(a.this.ijT.getDataList());
                a.this.ijU.z(a.this.ibH);
            } else if (v.isEmpty(a.this.ijU.getDataList())) {
                a.this.ijU.showNoDataView();
            } else if (z) {
                a.this.ijU.bqL();
            }
        }
    };
    private View.OnClickListener ibH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.ijU != null && a.this.ijT != null) {
                a.this.ijU.bqM();
                a.this.ijT.bXH();
            }
        }
    };

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.ijU = new com.baidu.tieba.homepage.video.d.a(this.mPageContext, bdUniqueId, this.ibD);
        this.ijT = new b(this.mPageContext, this.ijV);
    }

    public void init() {
        this.ijT.registerListener();
        this.ijU.init();
        this.ijU.setListPullRefreshListener(this.fdl);
        this.ijU.a(this.ibF);
        MessageManager.getInstance().registerListener(this.gWm);
    }

    public View getView() {
        if (this.ijU != null) {
            return this.ijU.getRootView();
        }
        return null;
    }

    public void loadData() {
        if (this.ijU != null) {
            this.ijU.cfK();
            this.ijU.showLoadingView();
        }
        if (this.ijT != null) {
            this.ijT.chg();
        }
    }

    public void Ho() {
        if (this.ijU != null) {
            this.ijU.oj(false);
            this.ijU.cfI();
            this.ijU.cfG();
            this.ijU.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f.e wB(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.video_tab_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.video_tab_count, Integer.valueOf(i));
        }
        return new f.e(string, 1000);
    }

    public void aWr() {
        if (this.ijU != null) {
            this.ijU.aWr();
        }
    }

    public void onPause() {
        if (this.ijU != null) {
            this.ijU.onPause();
            this.ijU.ceA();
            this.ijU.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.ijU != null) {
            this.ijU.setListPullRefreshListener(null);
            this.ijU.a((BdListView.e) null);
            this.ijU.onDestroy();
        }
        if (this.ijT != null) {
            this.ijT.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gWm);
    }

    public void setPrimary(boolean z) {
        if (z) {
            this.ijU.chi();
        } else {
            this.ijU.ceA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.ijT != null && !v.isEmpty(this.ijT.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.ijT.EY(optString);
            this.ijT.FB(optString);
            if (this.ijU != null) {
                this.ijU.FD(optString);
            }
        }
    }
}
