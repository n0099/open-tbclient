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
    private b jGk;
    private com.baidu.tieba.homepage.video.d.a jGl;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener ikd = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.video.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.g(customResponsedMessage);
            if (a.this.jGl != null) {
                a.this.jGl.cHL();
            }
        }
    };
    private NEGFeedBackView.a juC = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.video.a.2
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
                if (a.this.jGl != null) {
                    a.this.jGl.Lz();
                }
            }
        }
    };
    private f.c geE = new f.c() { // from class: com.baidu.tieba.homepage.video.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                a.this.jGl.qM(false);
                a.this.jGk.cJK();
                TiebaStatic.log(new aq("c13582"));
                return;
            }
            a.this.jGl.b((f.e) null);
            a.this.mPageContext.showToast(R.string.neterror);
        }
    };
    private BdListView.e juE = new BdListView.e() { // from class: com.baidu.tieba.homepage.video.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            a.this.jGl.bMx();
            a.this.jGk.cyN();
        }
    };
    private b.a jGm = new b.a() { // from class: com.baidu.tieba.homepage.video.a.5
        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void n(int i, String str, boolean z) {
            a.this.jGl.b((f.e) null);
            a.this.jGl.hideLoadingView();
            a.this.jGl.TK();
            if (y.isEmpty(a.this.jGl.getDataList())) {
                a.this.jGl.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                a.this.jGl.B(a.this.juG);
            }
            if (StringUtils.isNull(str)) {
                a.this.mPageContext.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.mPageContext.showToast(str);
            }
        }

        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void g(int i, boolean z, boolean z2) {
            a.this.jGl.hideLoadingView();
            a.this.jGl.TK();
            if (z || z2) {
                a.this.jGl.b((f.e) null);
            } else {
                a.this.jGl.b(a.this.Bt(i));
            }
            if (i != 0) {
                a.this.jGl.bb(a.this.jGk.getDataList());
                a.this.jGl.B(a.this.juG);
            } else if (y.isEmpty(a.this.jGl.getDataList())) {
                a.this.jGl.showNoDataView();
            } else if (z) {
                a.this.jGl.bMw();
            }
        }
    };
    private View.OnClickListener juG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.jGl != null && a.this.jGk != null) {
                a.this.jGl.bMx();
                a.this.jGk.cyN();
            }
        }
    };

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.jGl = new com.baidu.tieba.homepage.video.d.a(this.mPageContext, bdUniqueId, this.juC);
        this.jGk = new b(this.mPageContext, this.jGm);
    }

    public void init() {
        this.jGk.registerListener();
        this.jGl.init();
        this.jGl.setListPullRefreshListener(this.geE);
        this.jGl.a(this.juE);
        MessageManager.getInstance().registerListener(this.ikd);
    }

    public View getView() {
        if (this.jGl != null) {
            return this.jGl.getRootView();
        }
        return null;
    }

    public void loadData() {
        if (this.jGl != null) {
            this.jGl.cHO();
            this.jGl.showLoadingView();
        }
        if (this.jGk != null) {
            this.jGk.cJK();
        }
    }

    public void Rd() {
        if (this.jGl != null) {
            this.jGl.qM(false);
            this.jGl.cHM();
            this.jGl.cHK();
            this.jGl.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f.e Bt(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.video_tab_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.video_tab_count, Integer.valueOf(i));
        }
        return new f.e(string, 1000);
    }

    public void bqd() {
        if (this.jGl != null) {
            this.jGl.bqd();
        }
    }

    public void onPause() {
        if (this.jGl != null) {
            this.jGl.onPause();
            this.jGl.cGf();
            this.jGl.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.jGl != null) {
            this.jGl.setListPullRefreshListener(null);
            this.jGl.a((BdListView.e) null);
            this.jGl.onDestroy();
        }
        if (this.jGk != null) {
            this.jGk.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.ikd);
    }

    public void setPrimary(boolean z) {
        if (z) {
            this.jGl.cJM();
        } else {
            this.jGl.cGf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.jGk != null && !y.isEmpty(this.jGk.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.jGk.Ky(optString);
            this.jGk.Lu(optString);
            if (this.jGl != null) {
                this.jGl.Lw(optString);
            }
        }
    }
}
