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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.video.b.b;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private b ktA;
    private com.baidu.tieba.homepage.video.d.a ktB;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener iQU = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.video.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.g(customResponsedMessage);
            if (a.this.ktB != null) {
                a.this.ktB.cQH();
            }
        }
    };
    private NEGFeedBackView.a khA = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.video.a.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(av avVar) {
            if (avVar == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onCheckedChanged(av avVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, av avVar) {
            if (arrayList != null && avVar != null) {
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    sb.append(arrayList.get(i)).append(",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if (avVar.threadType != 0 && avVar.threadType != 40 && avVar.threadType == 49) {
                }
                if (a.this.ktB != null) {
                    a.this.ktB.KA();
                }
            }
        }
    };
    private f.c gDk = new f.c() { // from class: com.baidu.tieba.homepage.video.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                a.this.ktB.se(false);
                a.this.ktA.cSJ();
                TiebaStatic.log(new ar("c13582"));
                return;
            }
            a.this.ktB.b((f.e) null);
            a.this.mPageContext.showToast(R.string.neterror);
        }
    };
    private BdListView.e khC = new BdListView.e() { // from class: com.baidu.tieba.homepage.video.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            a.this.ktB.bRE();
            a.this.ktA.cFL();
        }
    };
    private b.a ktC = new b.a() { // from class: com.baidu.tieba.homepage.video.a.5
        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void n(int i, String str, boolean z) {
            a.this.ktB.b((f.e) null);
            a.this.ktB.hideLoadingView();
            a.this.ktB.Xc();
            if (y.isEmpty(a.this.ktB.getDataList())) {
                a.this.ktB.n(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                a.this.ktB.F(a.this.khE);
            }
            if (StringUtils.isNull(str)) {
                a.this.mPageContext.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.mPageContext.showToast(str);
            }
        }

        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void g(int i, boolean z, boolean z2) {
            a.this.ktB.hideLoadingView();
            a.this.ktB.Xc();
            if (z || z2) {
                a.this.ktB.b((f.e) null);
            } else {
                a.this.ktB.b(a.this.BT(i));
            }
            if (i != 0) {
                a.this.ktB.bn(a.this.ktA.getDataList());
                a.this.ktB.F(a.this.khE);
            } else if (y.isEmpty(a.this.ktB.getDataList())) {
                a.this.ktB.showNoDataView();
            } else if (z) {
                a.this.ktB.bRD();
            }
        }
    };
    private View.OnClickListener khE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.ktB != null && a.this.ktA != null) {
                a.this.ktB.bRE();
                a.this.ktA.cFL();
            }
        }
    };

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.ktB = new com.baidu.tieba.homepage.video.d.a(this.mPageContext, bdUniqueId, this.khA);
        this.ktA = new b(this.mPageContext, this.ktC);
    }

    public void init() {
        this.ktA.registerListener();
        this.ktB.init();
        this.ktB.setListPullRefreshListener(this.gDk);
        this.ktB.a(this.khC);
        MessageManager.getInstance().registerListener(this.iQU);
    }

    public View getView() {
        if (this.ktB != null) {
            return this.ktB.getRootView();
        }
        return null;
    }

    public void loadData() {
        if (this.ktB != null) {
            this.ktB.cQK();
            this.ktB.showLoadingView();
        }
        if (this.ktA != null) {
            this.ktA.cSJ();
        }
    }

    public void Uw() {
        if (this.ktB != null) {
            this.ktB.se(false);
            this.ktB.cQI();
            this.ktB.cQG();
            this.ktB.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f.e BT(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.video_tab_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.video_tab_count, Integer.valueOf(i));
        }
        return new f.e(string, 1000);
    }

    public void bus() {
        if (this.ktB != null) {
            this.ktB.bus();
        }
    }

    public void onPause() {
        if (this.ktB != null) {
            this.ktB.onPause();
            this.ktB.cPb();
            this.ktB.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.ktB != null) {
            this.ktB.setListPullRefreshListener(null);
            this.ktB.a((BdListView.e) null);
            this.ktB.onDestroy();
        }
        if (this.ktA != null) {
            this.ktA.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.iQU);
    }

    public void setPrimary(boolean z) {
        if (z) {
            this.ktB.cSL();
        } else {
            this.ktB.cPb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.ktA != null && !y.isEmpty(this.ktA.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.ktA.Lh(optString);
            this.ktA.Mc(optString);
            if (this.ktB != null) {
                this.ktB.Me(optString);
            }
        }
    }
}
