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
    private b jMi;
    private com.baidu.tieba.homepage.video.d.a jMj;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener iqc = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.video.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.g(customResponsedMessage);
            if (a.this.jMj != null) {
                a.this.jMj.cKm();
            }
        }
    };
    private NEGFeedBackView.a jAz = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.video.a.2
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
                if (a.this.jMj != null) {
                    a.this.jMj.LZ();
                }
            }
        }
    };
    private f.c gkt = new f.c() { // from class: com.baidu.tieba.homepage.video.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                a.this.jMj.qV(false);
                a.this.jMi.cMl();
                TiebaStatic.log(new aq("c13582"));
                return;
            }
            a.this.jMj.b((f.e) null);
            a.this.mPageContext.showToast(R.string.neterror);
        }
    };
    private BdListView.e jAB = new BdListView.e() { // from class: com.baidu.tieba.homepage.video.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            a.this.jMj.bOX();
            a.this.jMi.cBo();
        }
    };
    private b.a jMk = new b.a() { // from class: com.baidu.tieba.homepage.video.a.5
        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void n(int i, String str, boolean z) {
            a.this.jMj.b((f.e) null);
            a.this.jMj.hideLoadingView();
            a.this.jMj.Wk();
            if (y.isEmpty(a.this.jMj.getDataList())) {
                a.this.jMj.m(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                a.this.jMj.C(a.this.jAD);
            }
            if (StringUtils.isNull(str)) {
                a.this.mPageContext.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.mPageContext.showToast(str);
            }
        }

        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void g(int i, boolean z, boolean z2) {
            a.this.jMj.hideLoadingView();
            a.this.jMj.Wk();
            if (z || z2) {
                a.this.jMj.b((f.e) null);
            } else {
                a.this.jMj.b(a.this.BG(i));
            }
            if (i != 0) {
                a.this.jMj.bi(a.this.jMi.getDataList());
                a.this.jMj.C(a.this.jAD);
            } else if (y.isEmpty(a.this.jMj.getDataList())) {
                a.this.jMj.showNoDataView();
            } else if (z) {
                a.this.jMj.bOW();
            }
        }
    };
    private View.OnClickListener jAD = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.jMj != null && a.this.jMi != null) {
                a.this.jMj.bOX();
                a.this.jMi.cBo();
            }
        }
    };

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.jMj = new com.baidu.tieba.homepage.video.d.a(this.mPageContext, bdUniqueId, this.jAz);
        this.jMi = new b(this.mPageContext, this.jMk);
    }

    public void init() {
        this.jMi.registerListener();
        this.jMj.init();
        this.jMj.setListPullRefreshListener(this.gkt);
        this.jMj.a(this.jAB);
        MessageManager.getInstance().registerListener(this.iqc);
    }

    public View getView() {
        if (this.jMj != null) {
            return this.jMj.getRootView();
        }
        return null;
    }

    public void loadData() {
        if (this.jMj != null) {
            this.jMj.cKp();
            this.jMj.showLoadingView();
        }
        if (this.jMi != null) {
            this.jMi.cMl();
        }
    }

    public void TL() {
        if (this.jMj != null) {
            this.jMj.qV(false);
            this.jMj.cKn();
            this.jMj.cKl();
            this.jMj.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f.e BG(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.video_tab_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.video_tab_count, Integer.valueOf(i));
        }
        return new f.e(string, 1000);
    }

    public void bsD() {
        if (this.jMj != null) {
            this.jMj.bsD();
        }
    }

    public void onPause() {
        if (this.jMj != null) {
            this.jMj.onPause();
            this.jMj.cIG();
            this.jMj.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.jMj != null) {
            this.jMj.setListPullRefreshListener(null);
            this.jMj.a((BdListView.e) null);
            this.jMj.onDestroy();
        }
        if (this.jMi != null) {
            this.jMi.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.iqc);
    }

    public void setPrimary(boolean z) {
        if (z) {
            this.jMj.cMn();
        } else {
            this.jMj.cIG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.jMi != null && !y.isEmpty(this.jMi.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.jMi.KP(optString);
            this.jMi.LL(optString);
            if (this.jMj != null) {
                this.jMj.LN(optString);
            }
        }
    }
}
