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
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.video.b.b;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private b knI;
    private com.baidu.tieba.homepage.video.d.a knJ;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener iNW = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.video.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.g(customResponsedMessage);
            if (a.this.knJ != null) {
                a.this.knJ.cSo();
            }
        }
    };
    private NEGFeedBackView.a kcn = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.video.a.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(at atVar) {
            if (atVar == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onCheckedChanged(at atVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, at atVar) {
            if (arrayList != null && atVar != null) {
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    sb.append(arrayList.get(i)).append(",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if (atVar.threadType != 0 && atVar.threadType != 40 && atVar.threadType == 49) {
                }
                if (a.this.knJ != null) {
                    a.this.knJ.MU();
                }
            }
        }
    };
    private f.c gDk = new f.c() { // from class: com.baidu.tieba.homepage.video.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                a.this.knJ.rW(false);
                a.this.knI.cUo();
                TiebaStatic.log(new aq("c13582"));
                return;
            }
            a.this.knJ.b((f.e) null);
            a.this.mPageContext.showToast(R.string.neterror);
        }
    };
    private BdListView.e kcp = new BdListView.e() { // from class: com.baidu.tieba.homepage.video.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            a.this.knJ.bUF();
            a.this.knI.cId();
        }
    };
    private b.a knK = new b.a() { // from class: com.baidu.tieba.homepage.video.a.5
        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void o(int i, String str, boolean z) {
            a.this.knJ.b((f.e) null);
            a.this.knJ.hideLoadingView();
            a.this.knJ.Zj();
            if (x.isEmpty(a.this.knJ.getDataList())) {
                a.this.knJ.n(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                a.this.knJ.E(a.this.kcr);
            }
            if (StringUtils.isNull(str)) {
                a.this.mPageContext.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.mPageContext.showToast(str);
            }
        }

        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void g(int i, boolean z, boolean z2) {
            a.this.knJ.hideLoadingView();
            a.this.knJ.Zj();
            if (z || z2) {
                a.this.knJ.b((f.e) null);
            } else {
                a.this.knJ.b(a.this.Dh(i));
            }
            if (i != 0) {
                a.this.knJ.bs(a.this.knI.getDataList());
                a.this.knJ.E(a.this.kcr);
            } else if (x.isEmpty(a.this.knJ.getDataList())) {
                a.this.knJ.showNoDataView();
            } else if (z) {
                a.this.knJ.bUE();
            }
        }
    };
    private View.OnClickListener kcr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.knJ != null && a.this.knI != null) {
                a.this.knJ.bUF();
                a.this.knI.cId();
            }
        }
    };

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.knJ = new com.baidu.tieba.homepage.video.d.a(this.mPageContext, bdUniqueId, this.kcn);
        this.knI = new b(this.mPageContext, this.knK);
    }

    public void init() {
        this.knI.registerListener();
        this.knJ.init();
        this.knJ.setListPullRefreshListener(this.gDk);
        this.knJ.a(this.kcp);
        MessageManager.getInstance().registerListener(this.iNW);
    }

    public View getView() {
        if (this.knJ != null) {
            return this.knJ.getRootView();
        }
        return null;
    }

    public void loadData() {
        if (this.knJ != null) {
            this.knJ.cSr();
            this.knJ.showLoadingView();
        }
        if (this.knI != null) {
            this.knI.cUo();
        }
    }

    public void WF() {
        if (this.knJ != null) {
            this.knJ.rW(false);
            this.knJ.cSp();
            this.knJ.cSn();
            this.knJ.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f.e Dh(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.video_tab_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.video_tab_count, Integer.valueOf(i));
        }
        return new f.e(string, 1000);
    }

    public void bxP() {
        if (this.knJ != null) {
            this.knJ.bxP();
        }
    }

    public void onPause() {
        if (this.knJ != null) {
            this.knJ.onPause();
            this.knJ.cQI();
            this.knJ.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.knJ != null) {
            this.knJ.setListPullRefreshListener(null);
            this.knJ.a((BdListView.e) null);
            this.knJ.onDestroy();
        }
        if (this.knI != null) {
            this.knI.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.iNW);
    }

    public void setPrimary(boolean z) {
        if (z) {
            this.knJ.cUq();
        } else {
            this.knJ.cQI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.knI != null && !x.isEmpty(this.knI.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.knI.Lw(optString);
            this.knI.Ms(optString);
            if (this.knJ != null) {
                this.knJ.Mu(optString);
            }
        }
    }
}
