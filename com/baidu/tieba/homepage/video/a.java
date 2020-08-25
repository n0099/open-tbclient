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
    private b iVZ;
    private com.baidu.tieba.homepage.video.d.a iWa;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener hBA = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.video.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.g(customResponsedMessage);
            if (a.this.iWa != null) {
                a.this.iWa.cxo();
            }
        }
    };
    private NEGFeedBackView.a iKv = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.video.a.2
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
                if (a.this.iWa != null) {
                    a.this.iWa.Jw();
                }
            }
        }
    };
    private f.c fEZ = new f.c() { // from class: com.baidu.tieba.homepage.video.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                a.this.iWa.pE(false);
                a.this.iVZ.czm();
                TiebaStatic.log(new aq("c13582"));
                return;
            }
            a.this.iWa.b((f.e) null);
            a.this.mPageContext.showToast(R.string.neterror);
        }
    };
    private BdListView.e iKx = new BdListView.e() { // from class: com.baidu.tieba.homepage.video.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            a.this.iWa.bFS();
            a.this.iVZ.coV();
        }
    };
    private b.a iWb = new b.a() { // from class: com.baidu.tieba.homepage.video.a.5
        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void l(int i, String str, boolean z) {
            a.this.iWa.b((f.e) null);
            a.this.iWa.hideLoadingView();
            a.this.iWa.bFW();
            if (y.isEmpty(a.this.iWa.getDataList())) {
                a.this.iWa.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                a.this.iWa.B(a.this.iKz);
            }
            if (StringUtils.isNull(str)) {
                a.this.mPageContext.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.mPageContext.showToast(str);
            }
        }

        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void g(int i, boolean z, boolean z2) {
            a.this.iWa.hideLoadingView();
            a.this.iWa.bFW();
            if (z || z2) {
                a.this.iWa.b((f.e) null);
            } else {
                a.this.iWa.b(a.this.zT(i));
            }
            if (i != 0) {
                a.this.iWa.aK(a.this.iVZ.getDataList());
                a.this.iWa.B(a.this.iKz);
            } else if (y.isEmpty(a.this.iWa.getDataList())) {
                a.this.iWa.showNoDataView();
            } else if (z) {
                a.this.iWa.bFR();
            }
        }
    };
    private View.OnClickListener iKz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.iWa != null && a.this.iVZ != null) {
                a.this.iWa.bFS();
                a.this.iVZ.coV();
            }
        }
    };

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.iWa = new com.baidu.tieba.homepage.video.d.a(this.mPageContext, bdUniqueId, this.iKv);
        this.iVZ = new b(this.mPageContext, this.iWb);
    }

    public void init() {
        this.iVZ.registerListener();
        this.iWa.init();
        this.iWa.setListPullRefreshListener(this.fEZ);
        this.iWa.a(this.iKx);
        MessageManager.getInstance().registerListener(this.hBA);
    }

    public View getView() {
        if (this.iWa != null) {
            return this.iWa.getRootView();
        }
        return null;
    }

    public void loadData() {
        if (this.iWa != null) {
            this.iWa.cxr();
            this.iWa.showLoadingView();
        }
        if (this.iVZ != null) {
            this.iVZ.czm();
        }
    }

    public void OA() {
        if (this.iWa != null) {
            this.iWa.pE(false);
            this.iWa.cxp();
            this.iWa.cxn();
            this.iWa.startPullRefresh();
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
        if (this.iWa != null) {
            this.iWa.bkF();
        }
    }

    public void onPause() {
        if (this.iWa != null) {
            this.iWa.onPause();
            this.iWa.cwg();
            this.iWa.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.iWa != null) {
            this.iWa.setListPullRefreshListener(null);
            this.iWa.a((BdListView.e) null);
            this.iWa.onDestroy();
        }
        if (this.iVZ != null) {
            this.iVZ.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.hBA);
    }

    public void setPrimary(boolean z) {
        if (z) {
            this.iWa.czo();
        } else {
            this.iWa.cwg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.iVZ != null && !y.isEmpty(this.iVZ.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.iVZ.IN(optString);
            this.iVZ.JE(optString);
            if (this.iWa != null) {
                this.iWa.JG(optString);
            }
        }
    }
}
