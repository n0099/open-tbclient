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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.video.b.b;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public class a {
    private b kax;
    private com.baidu.tieba.homepage.video.d.a kay;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener iBK = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.video.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.g(customResponsedMessage);
            if (a.this.kay != null) {
                a.this.kay.cPh();
            }
        }
    };
    private NEGFeedBackView.a jOZ = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.video.a.2
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
                if (a.this.kay != null) {
                    a.this.kay.Nv();
                }
            }
        }
    };
    private f.c gsl = new f.c() { // from class: com.baidu.tieba.homepage.video.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                a.this.kay.rz(false);
                a.this.kax.cRh();
                TiebaStatic.log(new ar("c13582"));
                return;
            }
            a.this.kay.b((f.e) null);
            a.this.mPageContext.showToast(R.string.neterror);
        }
    };
    private BdListView.e jPb = new BdListView.e() { // from class: com.baidu.tieba.homepage.video.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            a.this.kay.bSc();
            a.this.kax.cFi();
        }
    };
    private b.a kaz = new b.a() { // from class: com.baidu.tieba.homepage.video.a.5
        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void o(int i, String str, boolean z) {
            a.this.kay.b((f.e) null);
            a.this.kay.hideLoadingView();
            a.this.kay.Yb();
            if (y.isEmpty(a.this.kay.getDataList())) {
                a.this.kay.m(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                a.this.kay.C(a.this.jPd);
            }
            if (StringUtils.isNull(str)) {
                a.this.mPageContext.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.mPageContext.showToast(str);
            }
        }

        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void g(int i, boolean z, boolean z2) {
            a.this.kay.hideLoadingView();
            a.this.kay.Yb();
            if (z || z2) {
                a.this.kay.b((f.e) null);
            } else {
                a.this.kay.b(a.this.CT(i));
            }
            if (i != 0) {
                a.this.kay.bl(a.this.kax.getDataList());
                a.this.kay.C(a.this.jPd);
            } else if (y.isEmpty(a.this.kay.getDataList())) {
                a.this.kay.showNoDataView();
            } else if (z) {
                a.this.kay.bSb();
            }
        }
    };
    private View.OnClickListener jPd = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.kay != null && a.this.kax != null) {
                a.this.kay.bSc();
                a.this.kax.cFi();
            }
        }
    };

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.kay = new com.baidu.tieba.homepage.video.d.a(this.mPageContext, bdUniqueId, this.jOZ);
        this.kax = new b(this.mPageContext, this.kaz);
    }

    public void init() {
        this.kax.registerListener();
        this.kay.init();
        this.kay.setListPullRefreshListener(this.gsl);
        this.kay.a(this.jPb);
        MessageManager.getInstance().registerListener(this.iBK);
    }

    public View getView() {
        if (this.kay != null) {
            return this.kay.getRootView();
        }
        return null;
    }

    public void loadData() {
        if (this.kay != null) {
            this.kay.cPk();
            this.kay.showLoadingView();
        }
        if (this.kax != null) {
            this.kax.cRh();
        }
    }

    public void VC() {
        if (this.kay != null) {
            this.kay.rz(false);
            this.kay.cPi();
            this.kay.cPg();
            this.kay.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f.e CT(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.video_tab_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.video_tab_count, Integer.valueOf(i));
        }
        return new f.e(string, 1000);
    }

    public void bvt() {
        if (this.kay != null) {
            this.kay.bvt();
        }
    }

    public void onPause() {
        if (this.kay != null) {
            this.kay.onPause();
            this.kay.cNB();
            this.kay.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.kay != null) {
            this.kay.setListPullRefreshListener(null);
            this.kay.a((BdListView.e) null);
            this.kay.onDestroy();
        }
        if (this.kax != null) {
            this.kax.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.iBK);
    }

    public void setPrimary(boolean z) {
        if (z) {
            this.kay.cRj();
        } else {
            this.kay.cNB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.kax != null && !y.isEmpty(this.kax.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.kax.Lx(optString);
            this.kax.Mt(optString);
            if (this.kay != null) {
                this.kay.Mv(optString);
            }
        }
    }
}
