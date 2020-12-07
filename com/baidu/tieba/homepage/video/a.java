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
    private b kav;
    private com.baidu.tieba.homepage.video.d.a kaw;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener iBI = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.video.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.g(customResponsedMessage);
            if (a.this.kaw != null) {
                a.this.kaw.cPg();
            }
        }
    };
    private NEGFeedBackView.a jOX = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.video.a.2
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
                if (a.this.kaw != null) {
                    a.this.kaw.Nv();
                }
            }
        }
    };
    private f.c gsj = new f.c() { // from class: com.baidu.tieba.homepage.video.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                a.this.kaw.rz(false);
                a.this.kav.cRg();
                TiebaStatic.log(new ar("c13582"));
                return;
            }
            a.this.kaw.b((f.e) null);
            a.this.mPageContext.showToast(R.string.neterror);
        }
    };
    private BdListView.e jOZ = new BdListView.e() { // from class: com.baidu.tieba.homepage.video.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            a.this.kaw.bSb();
            a.this.kav.cFh();
        }
    };
    private b.a kax = new b.a() { // from class: com.baidu.tieba.homepage.video.a.5
        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void o(int i, String str, boolean z) {
            a.this.kaw.b((f.e) null);
            a.this.kaw.hideLoadingView();
            a.this.kaw.Yb();
            if (y.isEmpty(a.this.kaw.getDataList())) {
                a.this.kaw.m(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                a.this.kaw.C(a.this.jPb);
            }
            if (StringUtils.isNull(str)) {
                a.this.mPageContext.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.mPageContext.showToast(str);
            }
        }

        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void g(int i, boolean z, boolean z2) {
            a.this.kaw.hideLoadingView();
            a.this.kaw.Yb();
            if (z || z2) {
                a.this.kaw.b((f.e) null);
            } else {
                a.this.kaw.b(a.this.CT(i));
            }
            if (i != 0) {
                a.this.kaw.bl(a.this.kav.getDataList());
                a.this.kaw.C(a.this.jPb);
            } else if (y.isEmpty(a.this.kaw.getDataList())) {
                a.this.kaw.showNoDataView();
            } else if (z) {
                a.this.kaw.bSa();
            }
        }
    };
    private View.OnClickListener jPb = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.kaw != null && a.this.kav != null) {
                a.this.kaw.bSb();
                a.this.kav.cFh();
            }
        }
    };

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.kaw = new com.baidu.tieba.homepage.video.d.a(this.mPageContext, bdUniqueId, this.jOX);
        this.kav = new b(this.mPageContext, this.kax);
    }

    public void init() {
        this.kav.registerListener();
        this.kaw.init();
        this.kaw.setListPullRefreshListener(this.gsj);
        this.kaw.a(this.jOZ);
        MessageManager.getInstance().registerListener(this.iBI);
    }

    public View getView() {
        if (this.kaw != null) {
            return this.kaw.getRootView();
        }
        return null;
    }

    public void loadData() {
        if (this.kaw != null) {
            this.kaw.cPj();
            this.kaw.showLoadingView();
        }
        if (this.kav != null) {
            this.kav.cRg();
        }
    }

    public void VC() {
        if (this.kaw != null) {
            this.kaw.rz(false);
            this.kaw.cPh();
            this.kaw.cPf();
            this.kaw.startPullRefresh();
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
        if (this.kaw != null) {
            this.kaw.bvt();
        }
    }

    public void onPause() {
        if (this.kaw != null) {
            this.kaw.onPause();
            this.kaw.cNA();
            this.kaw.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.kaw != null) {
            this.kaw.setListPullRefreshListener(null);
            this.kaw.a((BdListView.e) null);
            this.kaw.onDestroy();
        }
        if (this.kav != null) {
            this.kav.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.iBI);
    }

    public void setPrimary(boolean z) {
        if (z) {
            this.kaw.cRi();
        } else {
            this.kaw.cNA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.kav != null && !y.isEmpty(this.kav.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.kav.Lx(optString);
            this.kav.Mt(optString);
            if (this.kaw != null) {
                this.kaw.Mv(optString);
            }
        }
    }
}
