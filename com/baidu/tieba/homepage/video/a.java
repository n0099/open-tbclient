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
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.video.b.b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class a {
    private b iGZ;
    private com.baidu.tieba.homepage.video.d.a iHa;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener hoJ = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.video.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.g(customResponsedMessage);
            if (a.this.iHa != null) {
                a.this.iHa.cmF();
            }
        }
    };
    private NEGFeedBackView.a iwe = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.video.a.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(aq aqVar) {
            if (aqVar == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(aq aqVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ArrayList<Integer> arrayList, String str, aq aqVar) {
            if (arrayList != null && aqVar != null) {
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    sb.append(arrayList.get(i)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if (aqVar.threadType != 0 && aqVar.threadType != 40 && aqVar.threadType == 49) {
                }
                if (a.this.iHa != null) {
                    a.this.iHa.DT();
                }
            }
        }
    };
    private f.c ftG = new f.c() { // from class: com.baidu.tieba.homepage.video.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                a.this.iHa.oZ(false);
                a.this.iGZ.cot();
                TiebaStatic.log(new ap("c13582"));
                return;
            }
            a.this.iHa.b((f.e) null);
            a.this.mPageContext.showToast(R.string.neterror);
        }
    };
    private BdListView.e iwg = new BdListView.e() { // from class: com.baidu.tieba.homepage.video.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            a.this.iHa.bwT();
            a.this.iGZ.cer();
        }
    };
    private b.a iHb = new b.a() { // from class: com.baidu.tieba.homepage.video.a.5
        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void m(int i, String str, boolean z) {
            a.this.iHa.b((f.e) null);
            a.this.iHa.hideLoadingView();
            a.this.iHa.bwX();
            if (x.isEmpty(a.this.iHa.getDataList())) {
                a.this.iHa.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                a.this.iHa.A(a.this.iwi);
            }
            if (StringUtils.isNull(str)) {
                a.this.mPageContext.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.mPageContext.showToast(str);
            }
        }

        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void f(int i, boolean z, boolean z2) {
            a.this.iHa.hideLoadingView();
            a.this.iHa.bwX();
            if (z || z2) {
                a.this.iHa.b((f.e) null);
            } else {
                a.this.iHa.b(a.this.xz(i));
            }
            if (i != 0) {
                a.this.iHa.aK(a.this.iGZ.getDataList());
                a.this.iHa.A(a.this.iwi);
            } else if (x.isEmpty(a.this.iHa.getDataList())) {
                a.this.iHa.showNoDataView();
            } else if (z) {
                a.this.iHa.bwS();
            }
        }
    };
    private View.OnClickListener iwi = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.iHa != null && a.this.iGZ != null) {
                a.this.iHa.bwT();
                a.this.iGZ.cer();
            }
        }
    };

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.iHa = new com.baidu.tieba.homepage.video.d.a(this.mPageContext, bdUniqueId, this.iwe);
        this.iGZ = new b(this.mPageContext, this.iHb);
    }

    public void init() {
        this.iGZ.registerListener();
        this.iHa.init();
        this.iHa.setListPullRefreshListener(this.ftG);
        this.iHa.a(this.iwg);
        MessageManager.getInstance().registerListener(this.hoJ);
    }

    public View getView() {
        if (this.iHa != null) {
            return this.iHa.getRootView();
        }
        return null;
    }

    public void loadData() {
        if (this.iHa != null) {
            this.iHa.cmI();
            this.iHa.showLoadingView();
        }
        if (this.iGZ != null) {
            this.iGZ.cot();
        }
    }

    public void IH() {
        if (this.iHa != null) {
            this.iHa.oZ(false);
            this.iHa.cmG();
            this.iHa.cmE();
            this.iHa.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f.e xz(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.video_tab_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.video_tab_count, Integer.valueOf(i));
        }
        return new f.e(string, 1000);
    }

    public void bci() {
        if (this.iHa != null) {
            this.iHa.bci();
        }
    }

    public void onPause() {
        if (this.iHa != null) {
            this.iHa.onPause();
            this.iHa.clx();
            this.iHa.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.iHa != null) {
            this.iHa.setListPullRefreshListener(null);
            this.iHa.a((BdListView.e) null);
            this.iHa.onDestroy();
        }
        if (this.iGZ != null) {
            this.iGZ.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.hoJ);
    }

    public void setPrimary(boolean z) {
        if (z) {
            this.iHa.cov();
        } else {
            this.iHa.clx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.iGZ != null && !x.isEmpty(this.iGZ.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.iGZ.Gl(optString);
            this.iGZ.GO(optString);
            if (this.iHa != null) {
                this.iHa.GQ(optString);
            }
        }
    }
}
