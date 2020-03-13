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
    private b hjg;
    private com.baidu.tieba.homepage.video.d.a hjh;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener gHL = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.video.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.h(customResponsedMessage);
            if (a.this.hjh != null) {
                a.this.hjh.bOp();
            }
        }
    };
    private NEGFeedBackView.a hbl = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.video.a.2
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
                if (a.this.hjh != null) {
                    a.this.hjh.wN();
                }
            }
        }
    };
    private g.c emw = new g.c() { // from class: com.baidu.tieba.homepage.video.a.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                a.this.hjh.mD(false);
                a.this.hjg.bPH();
                TiebaStatic.log(new an("c13582"));
                return;
            }
            a.this.hjh.b((g.e) null);
            a.this.mPageContext.showToast(R.string.neterror);
        }
    };
    private BdListView.e hbn = new BdListView.e() { // from class: com.baidu.tieba.homepage.video.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            a.this.hjh.bcv();
            a.this.hjg.bGx();
        }
    };
    private b.a hji = new b.a() { // from class: com.baidu.tieba.homepage.video.a.5
        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void l(int i, String str, boolean z) {
            a.this.hjh.b((g.e) null);
            a.this.hjh.hideLoadingView();
            a.this.hjh.bcy();
            if (v.isEmpty(a.this.hjh.getDataList())) {
                a.this.hjh.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                a.this.hjh.z(a.this.hbp);
            }
            if (StringUtils.isNull(str)) {
                a.this.mPageContext.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.mPageContext.showToast(str);
            }
        }

        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void f(int i, boolean z, boolean z2) {
            a.this.hjh.hideLoadingView();
            a.this.hjh.bcy();
            if (z || z2) {
                a.this.hjh.b((g.e) null);
            } else {
                a.this.hjh.b(a.this.vo(i));
            }
            if (i != 0) {
                a.this.hjh.av(a.this.hjg.getDataList());
                a.this.hjh.z(a.this.hbp);
            } else if (v.isEmpty(a.this.hjh.getDataList())) {
                a.this.hjh.showNoDataView();
            } else if (z) {
                a.this.hjh.bcu();
            }
        }
    };
    private View.OnClickListener hbp = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hjh != null && a.this.hjg != null) {
                a.this.hjh.bcv();
                a.this.hjg.bGx();
            }
        }
    };

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.hjh = new com.baidu.tieba.homepage.video.d.a(this.mPageContext, bdUniqueId, this.hbl);
        this.hjg = new b(this.mPageContext, this.hji);
    }

    public void init() {
        this.hjg.registerListener();
        this.hjh.init();
        this.hjh.setListPullRefreshListener(this.emw);
        this.hjh.a(this.hbn);
        MessageManager.getInstance().registerListener(this.gHL);
    }

    public View getView() {
        if (this.hjh != null) {
            return this.hjh.getRootView();
        }
        return null;
    }

    public void loadData() {
        if (this.hjh != null) {
            this.hjh.bOs();
            this.hjh.showLoadingView();
        }
        if (this.hjg != null) {
            this.hjg.bPH();
        }
    }

    public void AC() {
        if (this.hjh != null) {
            this.hjh.mD(false);
            this.hjh.bOq();
            this.hjh.bOo();
            this.hjh.startPullRefresh();
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

    public void aHO() {
        if (this.hjh != null) {
            this.hjh.aHO();
        }
    }

    public void onPause() {
        if (this.hjh != null) {
            this.hjh.onPause();
            this.hjh.bNg();
            this.hjh.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.hjh != null) {
            this.hjh.setListPullRefreshListener(null);
            this.hjh.a((BdListView.e) null);
            this.hjh.onDestroy();
        }
        if (this.hjg != null) {
            this.hjg.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gHL);
    }

    public void setPrimary(boolean z) {
        if (z) {
            this.hjh.bPJ();
        } else {
            this.hjh.bNg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.hjg != null && !v.isEmpty(this.hjg.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.hjg.BC(optString);
            this.hjg.Ch(optString);
            if (this.hjh != null) {
                this.hjh.Cj(optString);
            }
        }
    }
}
