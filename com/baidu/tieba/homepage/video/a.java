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
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.video.b.b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes21.dex */
public class a {
    private b jMS;
    private com.baidu.tieba.homepage.video.d.a jMT;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener iqQ = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.video.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.g(customResponsedMessage);
            if (a.this.jMT != null) {
                a.this.jMT.cJR();
            }
        }
    };
    private NEGFeedBackView.a jBv = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.video.a.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(as asVar) {
            if (asVar == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onCheckedChanged(as asVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, as asVar) {
            if (arrayList != null && asVar != null) {
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    sb.append(arrayList.get(i)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if (asVar.threadType != 0 && asVar.threadType != 40 && asVar.threadType == 49) {
                }
                if (a.this.jMT != null) {
                    a.this.jMT.Lq();
                }
            }
        }
    };
    private f.c gka = new f.c() { // from class: com.baidu.tieba.homepage.video.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                a.this.jMT.qY(false);
                a.this.jMS.cLS();
                TiebaStatic.log(new ar("c13582"));
                return;
            }
            a.this.jMT.b((f.e) null);
            a.this.mPageContext.showToast(R.string.neterror);
        }
    };
    private BdListView.e jBx = new BdListView.e() { // from class: com.baidu.tieba.homepage.video.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            a.this.jMT.bOq();
            a.this.jMS.cAR();
        }
    };
    private b.a jMU = new b.a() { // from class: com.baidu.tieba.homepage.video.a.5
        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void n(int i, String str, boolean z) {
            a.this.jMT.b((f.e) null);
            a.this.jMT.hideLoadingView();
            a.this.jMT.VB();
            if (y.isEmpty(a.this.jMT.getDataList())) {
                a.this.jMT.m(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                a.this.jMT.C(a.this.jBz);
            }
            if (StringUtils.isNull(str)) {
                a.this.mPageContext.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.mPageContext.showToast(str);
            }
        }

        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void g(int i, boolean z, boolean z2) {
            a.this.jMT.hideLoadingView();
            a.this.jMT.VB();
            if (z || z2) {
                a.this.jMT.b((f.e) null);
            } else {
                a.this.jMT.b(a.this.Ce(i));
            }
            if (i != 0) {
                a.this.jMT.bi(a.this.jMS.getDataList());
                a.this.jMT.C(a.this.jBz);
            } else if (y.isEmpty(a.this.jMT.getDataList())) {
                a.this.jMT.showNoDataView();
            } else if (z) {
                a.this.jMT.bOp();
            }
        }
    };
    private View.OnClickListener jBz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.jMT != null && a.this.jMS != null) {
                a.this.jMT.bOq();
                a.this.jMS.cAR();
            }
        }
    };

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.jMT = new com.baidu.tieba.homepage.video.d.a(this.mPageContext, bdUniqueId, this.jBv);
        this.jMS = new b(this.mPageContext, this.jMU);
    }

    public void init() {
        this.jMS.registerListener();
        this.jMT.init();
        this.jMT.setListPullRefreshListener(this.gka);
        this.jMT.a(this.jBx);
        MessageManager.getInstance().registerListener(this.iqQ);
    }

    public View getView() {
        if (this.jMT != null) {
            return this.jMT.getRootView();
        }
        return null;
    }

    public void loadData() {
        if (this.jMT != null) {
            this.jMT.cJU();
            this.jMT.showLoadingView();
        }
        if (this.jMS != null) {
            this.jMS.cLS();
        }
    }

    public void Tc() {
        if (this.jMT != null) {
            this.jMT.qY(false);
            this.jMT.cJS();
            this.jMT.cJQ();
            this.jMT.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f.e Ce(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.video_tab_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.video_tab_count, Integer.valueOf(i));
        }
        return new f.e(string, 1000);
    }

    public void brT() {
        if (this.jMT != null) {
            this.jMT.brT();
        }
    }

    public void onPause() {
        if (this.jMT != null) {
            this.jMT.onPause();
            this.jMT.cIl();
            this.jMT.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.jMT != null) {
            this.jMT.setListPullRefreshListener(null);
            this.jMT.a((BdListView.e) null);
            this.jMT.onDestroy();
        }
        if (this.jMS != null) {
            this.jMS.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.iqQ);
    }

    public void setPrimary(boolean z) {
        if (z) {
            this.jMT.cLU();
        } else {
            this.jMT.cIl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.jMS != null && !y.isEmpty(this.jMS.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.jMS.Kq(optString);
            this.jMS.Lm(optString);
            if (this.jMT != null) {
                this.jMT.Lo(optString);
            }
        }
    }
}
