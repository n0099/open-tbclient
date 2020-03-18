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
    private b hkG;
    private com.baidu.tieba.homepage.video.d.a hkH;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener gIJ = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.video.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.h(customResponsedMessage);
            if (a.this.hkH != null) {
                a.this.hkH.bOD();
            }
        }
    };
    private NEGFeedBackView.a hct = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.video.a.2
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
                if (a.this.hkH != null) {
                    a.this.hkH.wS();
                }
            }
        }
    };
    private g.c emN = new g.c() { // from class: com.baidu.tieba.homepage.video.a.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                a.this.hkH.mJ(false);
                a.this.hkG.bPZ();
                TiebaStatic.log(new an("c13582"));
                return;
            }
            a.this.hkH.b((g.e) null);
            a.this.mPageContext.showToast(R.string.neterror);
        }
    };
    private BdListView.e hcv = new BdListView.e() { // from class: com.baidu.tieba.homepage.video.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            a.this.hkH.bcz();
            a.this.hkG.bGJ();
        }
    };
    private b.a hkI = new b.a() { // from class: com.baidu.tieba.homepage.video.a.5
        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void l(int i, String str, boolean z) {
            a.this.hkH.b((g.e) null);
            a.this.hkH.hideLoadingView();
            a.this.hkH.bcC();
            if (v.isEmpty(a.this.hkH.getDataList())) {
                a.this.hkH.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                a.this.hkH.z(a.this.hcx);
            }
            if (StringUtils.isNull(str)) {
                a.this.mPageContext.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.mPageContext.showToast(str);
            }
        }

        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void f(int i, boolean z, boolean z2) {
            a.this.hkH.hideLoadingView();
            a.this.hkH.bcC();
            if (z || z2) {
                a.this.hkH.b((g.e) null);
            } else {
                a.this.hkH.b(a.this.vv(i));
            }
            if (i != 0) {
                a.this.hkH.av(a.this.hkG.getDataList());
                a.this.hkH.z(a.this.hcx);
            } else if (v.isEmpty(a.this.hkH.getDataList())) {
                a.this.hkH.showNoDataView();
            } else if (z) {
                a.this.hkH.bcy();
            }
        }
    };
    private View.OnClickListener hcx = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hkH != null && a.this.hkG != null) {
                a.this.hkH.bcz();
                a.this.hkG.bGJ();
            }
        }
    };

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.hkH = new com.baidu.tieba.homepage.video.d.a(this.mPageContext, bdUniqueId, this.hct);
        this.hkG = new b(this.mPageContext, this.hkI);
    }

    public void init() {
        this.hkG.registerListener();
        this.hkH.init();
        this.hkH.setListPullRefreshListener(this.emN);
        this.hkH.a(this.hcv);
        MessageManager.getInstance().registerListener(this.gIJ);
    }

    public View getView() {
        if (this.hkH != null) {
            return this.hkH.getRootView();
        }
        return null;
    }

    public void loadData() {
        if (this.hkH != null) {
            this.hkH.bOG();
            this.hkH.showLoadingView();
        }
        if (this.hkG != null) {
            this.hkG.bPZ();
        }
    }

    public void AJ() {
        if (this.hkH != null) {
            this.hkH.mJ(false);
            this.hkH.bOE();
            this.hkH.bOC();
            this.hkH.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g.e vv(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.video_tab_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.video_tab_count, Integer.valueOf(i));
        }
        return new g.e(string, 1000);
    }

    public void aHS() {
        if (this.hkH != null) {
            this.hkH.aHS();
        }
    }

    public void onPause() {
        if (this.hkH != null) {
            this.hkH.onPause();
            this.hkH.bNu();
            this.hkH.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.hkH != null) {
            this.hkH.setListPullRefreshListener(null);
            this.hkH.a((BdListView.e) null);
            this.hkH.onDestroy();
        }
        if (this.hkG != null) {
            this.hkG.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gIJ);
    }

    public void setPrimary(boolean z) {
        if (z) {
            this.hkH.bQb();
        } else {
            this.hkH.bNu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.hkG != null && !v.isEmpty(this.hkG.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.hkG.BB(optString);
            this.hkG.Cg(optString);
            if (this.hkH != null) {
                this.hkH.Ci(optString);
            }
        }
    }
}
