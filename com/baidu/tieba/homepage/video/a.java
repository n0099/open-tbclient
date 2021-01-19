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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.video.b.b;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private b kjd;
    private com.baidu.tieba.homepage.video.d.a kje;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener iJp = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.video.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.g(customResponsedMessage);
            if (a.this.kje != null) {
                a.this.kje.cOw();
            }
        }
    };
    private NEGFeedBackView.a jXI = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.video.a.2
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
                if (a.this.kje != null) {
                    a.this.kje.IZ();
                }
            }
        }
    };
    private f.c gyD = new f.c() { // from class: com.baidu.tieba.homepage.video.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                a.this.kje.rS(false);
                a.this.kjd.cQw();
                TiebaStatic.log(new aq("c13582"));
                return;
            }
            a.this.kje.b((f.e) null);
            a.this.mPageContext.showToast(R.string.neterror);
        }
    };
    private BdListView.e jXK = new BdListView.e() { // from class: com.baidu.tieba.homepage.video.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            a.this.kje.bQN();
            a.this.kjd.cEl();
        }
    };
    private b.a kjf = new b.a() { // from class: com.baidu.tieba.homepage.video.a.5
        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void o(int i, String str, boolean z) {
            a.this.kje.b((f.e) null);
            a.this.kje.hideLoadingView();
            a.this.kje.Vq();
            if (x.isEmpty(a.this.kje.getDataList())) {
                a.this.kje.n(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                a.this.kje.E(a.this.jXM);
            }
            if (StringUtils.isNull(str)) {
                a.this.mPageContext.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.mPageContext.showToast(str);
            }
        }

        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void g(int i, boolean z, boolean z2) {
            a.this.kje.hideLoadingView();
            a.this.kje.Vq();
            if (z || z2) {
                a.this.kje.b((f.e) null);
            } else {
                a.this.kje.b(a.this.BA(i));
            }
            if (i != 0) {
                a.this.kje.bs(a.this.kjd.getDataList());
                a.this.kje.E(a.this.jXM);
            } else if (x.isEmpty(a.this.kje.getDataList())) {
                a.this.kje.showNoDataView();
            } else if (z) {
                a.this.kje.bQM();
            }
        }
    };
    private View.OnClickListener jXM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.kje != null && a.this.kjd != null) {
                a.this.kje.bQN();
                a.this.kjd.cEl();
            }
        }
    };

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.kje = new com.baidu.tieba.homepage.video.d.a(this.mPageContext, bdUniqueId, this.jXI);
        this.kjd = new b(this.mPageContext, this.kjf);
    }

    public void init() {
        this.kjd.registerListener();
        this.kje.init();
        this.kje.setListPullRefreshListener(this.gyD);
        this.kje.a(this.jXK);
        MessageManager.getInstance().registerListener(this.iJp);
    }

    public View getView() {
        if (this.kje != null) {
            return this.kje.getRootView();
        }
        return null;
    }

    public void loadData() {
        if (this.kje != null) {
            this.kje.cOz();
            this.kje.showLoadingView();
        }
        if (this.kjd != null) {
            this.kjd.cQw();
        }
    }

    public void SM() {
        if (this.kje != null) {
            this.kje.rS(false);
            this.kje.cOx();
            this.kje.cOv();
            this.kje.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f.e BA(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.video_tab_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.video_tab_count, Integer.valueOf(i));
        }
        return new f.e(string, 1000);
    }

    public void btV() {
        if (this.kje != null) {
            this.kje.btV();
        }
    }

    public void onPause() {
        if (this.kje != null) {
            this.kje.onPause();
            this.kje.cMQ();
            this.kje.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.kje != null) {
            this.kje.setListPullRefreshListener(null);
            this.kje.a((BdListView.e) null);
            this.kje.onDestroy();
        }
        if (this.kjd != null) {
            this.kjd.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.iJp);
    }

    public void setPrimary(boolean z) {
        if (z) {
            this.kje.cQy();
        } else {
            this.kje.cMQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.kjd != null && !x.isEmpty(this.kjd.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.kjd.Km(optString);
            this.kjd.Ll(optString);
            if (this.kje != null) {
                this.kje.Ln(optString);
            }
        }
    }
}
