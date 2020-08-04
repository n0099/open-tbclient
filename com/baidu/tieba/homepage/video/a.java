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
    private b iHb;
    private com.baidu.tieba.homepage.video.d.a iHc;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener hoJ = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.video.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.g(customResponsedMessage);
            if (a.this.iHc != null) {
                a.this.iHc.cmF();
            }
        }
    };
    private NEGFeedBackView.a iwg = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.video.a.2
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
                if (a.this.iHc != null) {
                    a.this.iHc.DT();
                }
            }
        }
    };
    private f.c ftG = new f.c() { // from class: com.baidu.tieba.homepage.video.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                a.this.iHc.oZ(false);
                a.this.iHb.cot();
                TiebaStatic.log(new ap("c13582"));
                return;
            }
            a.this.iHc.b((f.e) null);
            a.this.mPageContext.showToast(R.string.neterror);
        }
    };
    private BdListView.e iwi = new BdListView.e() { // from class: com.baidu.tieba.homepage.video.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            a.this.iHc.bwT();
            a.this.iHb.cer();
        }
    };
    private b.a iHd = new b.a() { // from class: com.baidu.tieba.homepage.video.a.5
        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void m(int i, String str, boolean z) {
            a.this.iHc.b((f.e) null);
            a.this.iHc.hideLoadingView();
            a.this.iHc.bwX();
            if (x.isEmpty(a.this.iHc.getDataList())) {
                a.this.iHc.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                a.this.iHc.A(a.this.iwk);
            }
            if (StringUtils.isNull(str)) {
                a.this.mPageContext.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.mPageContext.showToast(str);
            }
        }

        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void f(int i, boolean z, boolean z2) {
            a.this.iHc.hideLoadingView();
            a.this.iHc.bwX();
            if (z || z2) {
                a.this.iHc.b((f.e) null);
            } else {
                a.this.iHc.b(a.this.xz(i));
            }
            if (i != 0) {
                a.this.iHc.aK(a.this.iHb.getDataList());
                a.this.iHc.A(a.this.iwk);
            } else if (x.isEmpty(a.this.iHc.getDataList())) {
                a.this.iHc.showNoDataView();
            } else if (z) {
                a.this.iHc.bwS();
            }
        }
    };
    private View.OnClickListener iwk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.iHc != null && a.this.iHb != null) {
                a.this.iHc.bwT();
                a.this.iHb.cer();
            }
        }
    };

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.iHc = new com.baidu.tieba.homepage.video.d.a(this.mPageContext, bdUniqueId, this.iwg);
        this.iHb = new b(this.mPageContext, this.iHd);
    }

    public void init() {
        this.iHb.registerListener();
        this.iHc.init();
        this.iHc.setListPullRefreshListener(this.ftG);
        this.iHc.a(this.iwi);
        MessageManager.getInstance().registerListener(this.hoJ);
    }

    public View getView() {
        if (this.iHc != null) {
            return this.iHc.getRootView();
        }
        return null;
    }

    public void loadData() {
        if (this.iHc != null) {
            this.iHc.cmI();
            this.iHc.showLoadingView();
        }
        if (this.iHb != null) {
            this.iHb.cot();
        }
    }

    public void IH() {
        if (this.iHc != null) {
            this.iHc.oZ(false);
            this.iHc.cmG();
            this.iHc.cmE();
            this.iHc.startPullRefresh();
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
        if (this.iHc != null) {
            this.iHc.bci();
        }
    }

    public void onPause() {
        if (this.iHc != null) {
            this.iHc.onPause();
            this.iHc.clx();
            this.iHc.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.iHc != null) {
            this.iHc.setListPullRefreshListener(null);
            this.iHc.a((BdListView.e) null);
            this.iHc.onDestroy();
        }
        if (this.iHb != null) {
            this.iHb.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.hoJ);
    }

    public void setPrimary(boolean z) {
        if (z) {
            this.iHc.cov();
        } else {
            this.iHc.clx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.iHb != null && !x.isEmpty(this.iHb.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.iHb.Gl(optString);
            this.iHb.GO(optString);
            if (this.iHc != null) {
                this.iHc.GQ(optString);
            }
        }
    }
}
