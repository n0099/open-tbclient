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
/* loaded from: classes16.dex */
public class a {
    private b iWf;
    private com.baidu.tieba.homepage.video.d.a iWg;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener hBG = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.video.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.g(customResponsedMessage);
            if (a.this.iWg != null) {
                a.this.iWg.cxp();
            }
        }
    };
    private NEGFeedBackView.a iKB = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.video.a.2
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
                if (a.this.iWg != null) {
                    a.this.iWg.Jw();
                }
            }
        }
    };
    private f.c fFd = new f.c() { // from class: com.baidu.tieba.homepage.video.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                a.this.iWg.pG(false);
                a.this.iWf.czn();
                TiebaStatic.log(new aq("c13582"));
                return;
            }
            a.this.iWg.b((f.e) null);
            a.this.mPageContext.showToast(R.string.neterror);
        }
    };
    private BdListView.e iKD = new BdListView.e() { // from class: com.baidu.tieba.homepage.video.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            a.this.iWg.bFT();
            a.this.iWf.coW();
        }
    };
    private b.a iWh = new b.a() { // from class: com.baidu.tieba.homepage.video.a.5
        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void l(int i, String str, boolean z) {
            a.this.iWg.b((f.e) null);
            a.this.iWg.hideLoadingView();
            a.this.iWg.bFX();
            if (y.isEmpty(a.this.iWg.getDataList())) {
                a.this.iWg.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                a.this.iWg.B(a.this.iKF);
            }
            if (StringUtils.isNull(str)) {
                a.this.mPageContext.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.mPageContext.showToast(str);
            }
        }

        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void g(int i, boolean z, boolean z2) {
            a.this.iWg.hideLoadingView();
            a.this.iWg.bFX();
            if (z || z2) {
                a.this.iWg.b((f.e) null);
            } else {
                a.this.iWg.b(a.this.zT(i));
            }
            if (i != 0) {
                a.this.iWg.aK(a.this.iWf.getDataList());
                a.this.iWg.B(a.this.iKF);
            } else if (y.isEmpty(a.this.iWg.getDataList())) {
                a.this.iWg.showNoDataView();
            } else if (z) {
                a.this.iWg.bFS();
            }
        }
    };
    private View.OnClickListener iKF = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.iWg != null && a.this.iWf != null) {
                a.this.iWg.bFT();
                a.this.iWf.coW();
            }
        }
    };

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.iWg = new com.baidu.tieba.homepage.video.d.a(this.mPageContext, bdUniqueId, this.iKB);
        this.iWf = new b(this.mPageContext, this.iWh);
    }

    public void init() {
        this.iWf.registerListener();
        this.iWg.init();
        this.iWg.setListPullRefreshListener(this.fFd);
        this.iWg.a(this.iKD);
        MessageManager.getInstance().registerListener(this.hBG);
    }

    public View getView() {
        if (this.iWg != null) {
            return this.iWg.getRootView();
        }
        return null;
    }

    public void loadData() {
        if (this.iWg != null) {
            this.iWg.cxs();
            this.iWg.showLoadingView();
        }
        if (this.iWf != null) {
            this.iWf.czn();
        }
    }

    public void OA() {
        if (this.iWg != null) {
            this.iWg.pG(false);
            this.iWg.cxq();
            this.iWg.cxo();
            this.iWg.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f.e zT(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.video_tab_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.video_tab_count, Integer.valueOf(i));
        }
        return new f.e(string, 1000);
    }

    public void bkF() {
        if (this.iWg != null) {
            this.iWg.bkF();
        }
    }

    public void onPause() {
        if (this.iWg != null) {
            this.iWg.onPause();
            this.iWg.cwh();
            this.iWg.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.iWg != null) {
            this.iWg.setListPullRefreshListener(null);
            this.iWg.a((BdListView.e) null);
            this.iWg.onDestroy();
        }
        if (this.iWf != null) {
            this.iWf.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.hBG);
    }

    public void setPrimary(boolean z) {
        if (z) {
            this.iWg.czp();
        } else {
            this.iWg.cwh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.iWf != null && !y.isEmpty(this.iWf.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.iWf.IO(optString);
            this.iWf.JF(optString);
            if (this.iWg != null) {
                this.iWg.JH(optString);
            }
        }
    }
}
