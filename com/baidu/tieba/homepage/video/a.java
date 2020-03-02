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
    private b hiU;
    private com.baidu.tieba.homepage.video.d.a hiV;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener gHz = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.video.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.h(customResponsedMessage);
            if (a.this.hiV != null) {
                a.this.hiV.bOo();
            }
        }
    };
    private NEGFeedBackView.a haZ = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.video.a.2
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
                if (a.this.hiV != null) {
                    a.this.hiV.wN();
                }
            }
        }
    };
    private g.c emj = new g.c() { // from class: com.baidu.tieba.homepage.video.a.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                a.this.hiV.mD(false);
                a.this.hiU.bPG();
                TiebaStatic.log(new an("c13582"));
                return;
            }
            a.this.hiV.b((g.e) null);
            a.this.mPageContext.showToast(R.string.neterror);
        }
    };
    private BdListView.e hbb = new BdListView.e() { // from class: com.baidu.tieba.homepage.video.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            a.this.hiV.bcu();
            a.this.hiU.bGw();
        }
    };
    private b.a hiW = new b.a() { // from class: com.baidu.tieba.homepage.video.a.5
        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void l(int i, String str, boolean z) {
            a.this.hiV.b((g.e) null);
            a.this.hiV.hideLoadingView();
            a.this.hiV.bcx();
            if (v.isEmpty(a.this.hiV.getDataList())) {
                a.this.hiV.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                a.this.hiV.z(a.this.hbd);
            }
            if (StringUtils.isNull(str)) {
                a.this.mPageContext.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.mPageContext.showToast(str);
            }
        }

        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void f(int i, boolean z, boolean z2) {
            a.this.hiV.hideLoadingView();
            a.this.hiV.bcx();
            if (z || z2) {
                a.this.hiV.b((g.e) null);
            } else {
                a.this.hiV.b(a.this.vo(i));
            }
            if (i != 0) {
                a.this.hiV.av(a.this.hiU.getDataList());
                a.this.hiV.z(a.this.hbd);
            } else if (v.isEmpty(a.this.hiV.getDataList())) {
                a.this.hiV.showNoDataView();
            } else if (z) {
                a.this.hiV.bct();
            }
        }
    };
    private View.OnClickListener hbd = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hiV != null && a.this.hiU != null) {
                a.this.hiV.bcu();
                a.this.hiU.bGw();
            }
        }
    };

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.hiV = new com.baidu.tieba.homepage.video.d.a(this.mPageContext, bdUniqueId, this.haZ);
        this.hiU = new b(this.mPageContext, this.hiW);
    }

    public void init() {
        this.hiU.registerListener();
        this.hiV.init();
        this.hiV.setListPullRefreshListener(this.emj);
        this.hiV.a(this.hbb);
        MessageManager.getInstance().registerListener(this.gHz);
    }

    public View getView() {
        if (this.hiV != null) {
            return this.hiV.getRootView();
        }
        return null;
    }

    public void loadData() {
        if (this.hiV != null) {
            this.hiV.bOr();
            this.hiV.showLoadingView();
        }
        if (this.hiU != null) {
            this.hiU.bPG();
        }
    }

    public void AC() {
        if (this.hiV != null) {
            this.hiV.mD(false);
            this.hiV.bOp();
            this.hiV.bOn();
            this.hiV.startPullRefresh();
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

    public void aHN() {
        if (this.hiV != null) {
            this.hiV.aHN();
        }
    }

    public void onPause() {
        if (this.hiV != null) {
            this.hiV.onPause();
            this.hiV.bNf();
            this.hiV.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.hiV != null) {
            this.hiV.setListPullRefreshListener(null);
            this.hiV.a((BdListView.e) null);
            this.hiV.onDestroy();
        }
        if (this.hiU != null) {
            this.hiU.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gHz);
    }

    public void setPrimary(boolean z) {
        if (z) {
            this.hiV.bPI();
        } else {
            this.hiV.bNf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.hiU != null && !v.isEmpty(this.hiU.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.hiU.BB(optString);
            this.hiU.Cg(optString);
            if (this.hiV != null) {
                this.hiV.Ci(optString);
            }
        }
    }
}
