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
/* loaded from: classes7.dex */
public class a {
    private b hgR;
    private com.baidu.tieba.homepage.video.d.a hgS;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener gFy = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.video.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.h(customResponsedMessage);
            if (a.this.hgS != null) {
                a.this.hgS.bMK();
            }
        }
    };
    private NEGFeedBackView.a gYX = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.video.a.2
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
                if (a.this.hgS != null) {
                    a.this.hgS.vj();
                }
            }
        }
    };
    private g.c eib = new g.c() { // from class: com.baidu.tieba.homepage.video.a.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                a.this.hgS.mB(false);
                a.this.hgR.bOc();
                TiebaStatic.log(new an("c13582"));
                return;
            }
            a.this.hgS.b((g.e) null);
            a.this.mPageContext.showToast(R.string.neterror);
        }
    };
    private BdListView.e gYZ = new BdListView.e() { // from class: com.baidu.tieba.homepage.video.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            a.this.hgS.bac();
            a.this.hgR.bES();
        }
    };
    private b.a hgT = new b.a() { // from class: com.baidu.tieba.homepage.video.a.5
        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void l(int i, String str, boolean z) {
            a.this.hgS.b((g.e) null);
            a.this.hgS.hideLoadingView();
            a.this.hgS.baf();
            if (v.isEmpty(a.this.hgS.getDataList())) {
                a.this.hgS.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                a.this.hgS.y(a.this.gZb);
            }
            if (StringUtils.isNull(str)) {
                a.this.mPageContext.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.mPageContext.showToast(str);
            }
        }

        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void f(int i, boolean z, boolean z2) {
            a.this.hgS.hideLoadingView();
            a.this.hgS.baf();
            if (z || z2) {
                a.this.hgS.b((g.e) null);
            } else {
                a.this.hgS.b(a.this.vi(i));
            }
            if (i != 0) {
                a.this.hgS.av(a.this.hgR.getDataList());
                a.this.hgS.y(a.this.gZb);
            } else if (v.isEmpty(a.this.hgS.getDataList())) {
                a.this.hgS.showNoDataView();
            } else if (z) {
                a.this.hgS.bab();
            }
        }
    };
    private View.OnClickListener gZb = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hgS != null && a.this.hgR != null) {
                a.this.hgS.bac();
                a.this.hgR.bES();
            }
        }
    };

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.hgS = new com.baidu.tieba.homepage.video.d.a(this.mPageContext, bdUniqueId, this.gYX);
        this.hgR = new b(this.mPageContext, this.hgT);
    }

    public void init() {
        this.hgR.registerListener();
        this.hgS.init();
        this.hgS.setListPullRefreshListener(this.eib);
        this.hgS.a(this.gYZ);
        MessageManager.getInstance().registerListener(this.gFy);
    }

    public View getView() {
        if (this.hgS != null) {
            return this.hgS.getRootView();
        }
        return null;
    }

    public void loadData() {
        if (this.hgS != null) {
            this.hgS.bMN();
            this.hgS.showLoadingView();
        }
        if (this.hgR != null) {
            this.hgR.bOc();
        }
    }

    public void yj() {
        if (this.hgS != null) {
            this.hgS.mB(false);
            this.hgS.bML();
            this.hgS.bMJ();
            this.hgS.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g.e vi(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.video_tab_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.video_tab_count, Integer.valueOf(i));
        }
        return new g.e(string, 1000);
    }

    public void aFw() {
        if (this.hgS != null) {
            this.hgS.aFw();
        }
    }

    public void onPause() {
        if (this.hgS != null) {
            this.hgS.onPause();
            this.hgS.bLA();
            this.hgS.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.hgS != null) {
            this.hgS.setListPullRefreshListener(null);
            this.hgS.a((BdListView.e) null);
            this.hgS.onDestroy();
        }
        if (this.hgR != null) {
            this.hgR.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gFy);
    }

    public void setPrimary(boolean z) {
        if (z) {
            this.hgS.bOe();
        } else {
            this.hgS.bLA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.hgR != null && !v.isEmpty(this.hgR.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.hgR.Bl(optString);
            this.hgR.BQ(optString);
            if (this.hgS != null) {
                this.hgS.BS(optString);
            }
        }
    }
}
