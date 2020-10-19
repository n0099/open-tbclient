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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.video.b.b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public class a {
    private b jtK;
    private com.baidu.tieba.homepage.video.d.a jtL;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener hXD = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.video.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.g(customResponsedMessage);
            if (a.this.jtL != null) {
                a.this.jtL.cEE();
            }
        }
    };
    private NEGFeedBackView.a jif = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.video.a.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(ar arVar) {
            if (arVar == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onCheckedChanged(ar arVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, ar arVar) {
            if (arrayList != null && arVar != null) {
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    sb.append(arrayList.get(i)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if (arVar.threadType != 0 && arVar.threadType != 40 && arVar.threadType == 49) {
                }
                if (a.this.jtL != null) {
                    a.this.jtL.Lf();
                }
            }
        }
    };
    private f.c fUA = new f.c() { // from class: com.baidu.tieba.homepage.video.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                a.this.jtL.qu(false);
                a.this.jtK.cGD();
                TiebaStatic.log(new aq("c13582"));
                return;
            }
            a.this.jtL.b((f.e) null);
            a.this.mPageContext.showToast(R.string.neterror);
        }
    };
    private BdListView.e jih = new BdListView.e() { // from class: com.baidu.tieba.homepage.video.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            a.this.jtL.bJV();
            a.this.jtK.cvG();
        }
    };
    private b.a jtM = new b.a() { // from class: com.baidu.tieba.homepage.video.a.5
        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void n(int i, String str, boolean z) {
            a.this.jtL.b((f.e) null);
            a.this.jtL.hideLoadingView();
            a.this.jtL.SK();
            if (y.isEmpty(a.this.jtL.getDataList())) {
                a.this.jtL.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                a.this.jtL.B(a.this.jij);
            }
            if (StringUtils.isNull(str)) {
                a.this.mPageContext.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.mPageContext.showToast(str);
            }
        }

        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void g(int i, boolean z, boolean z2) {
            a.this.jtL.hideLoadingView();
            a.this.jtL.SK();
            if (z || z2) {
                a.this.jtL.b((f.e) null);
            } else {
                a.this.jtL.b(a.this.Ba(i));
            }
            if (i != 0) {
                a.this.jtL.aR(a.this.jtK.getDataList());
                a.this.jtL.B(a.this.jij);
            } else if (y.isEmpty(a.this.jtL.getDataList())) {
                a.this.jtL.showNoDataView();
            } else if (z) {
                a.this.jtL.bJU();
            }
        }
    };
    private View.OnClickListener jij = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.jtL != null && a.this.jtK != null) {
                a.this.jtL.bJV();
                a.this.jtK.cvG();
            }
        }
    };

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.jtL = new com.baidu.tieba.homepage.video.d.a(this.mPageContext, bdUniqueId, this.jif);
        this.jtK = new b(this.mPageContext, this.jtM);
    }

    public void init() {
        this.jtK.registerListener();
        this.jtL.init();
        this.jtL.setListPullRefreshListener(this.fUA);
        this.jtL.a(this.jih);
        MessageManager.getInstance().registerListener(this.hXD);
    }

    public View getView() {
        if (this.jtL != null) {
            return this.jtL.getRootView();
        }
        return null;
    }

    public void loadData() {
        if (this.jtL != null) {
            this.jtL.cEH();
            this.jtL.showLoadingView();
        }
        if (this.jtK != null) {
            this.jtK.cGD();
        }
    }

    public void Qi() {
        if (this.jtL != null) {
            this.jtL.qu(false);
            this.jtL.cEF();
            this.jtL.cED();
            this.jtL.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f.e Ba(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.video_tab_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.video_tab_count, Integer.valueOf(i));
        }
        return new f.e(string, 1000);
    }

    public void bok() {
        if (this.jtL != null) {
            this.jtL.bok();
        }
    }

    public void onPause() {
        if (this.jtL != null) {
            this.jtL.onPause();
            this.jtL.cCY();
            this.jtL.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.jtL != null) {
            this.jtL.setListPullRefreshListener(null);
            this.jtL.a((BdListView.e) null);
            this.jtL.onDestroy();
        }
        if (this.jtK != null) {
            this.jtK.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.hXD);
    }

    public void setPrimary(boolean z) {
        if (z) {
            this.jtL.cGF();
        } else {
            this.jtL.cCY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.jtK != null && !y.isEmpty(this.jtK.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.jtK.JZ(optString);
            this.jtK.KW(optString);
            if (this.jtL != null) {
                this.jtL.KY(optString);
            }
        }
    }
}
