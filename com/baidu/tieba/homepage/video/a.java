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
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.video.b.b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    private b ijf;
    private com.baidu.tieba.homepage.video.d.a ijg;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener gWb = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.video.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.g(customResponsedMessage);
            if (a.this.ijg != null) {
                a.this.ijg.cfy();
            }
        }
    };
    private NEGFeedBackView.a iaQ = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.video.a.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(ak akVar) {
            if (akVar == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ak akVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ArrayList<Integer> arrayList, String str, ak akVar) {
            if (arrayList != null && akVar != null) {
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    sb.append(arrayList.get(i)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if (akVar.threadType != 0 && akVar.threadType != 40 && akVar.threadType == 49) {
                }
                if (a.this.ijg != null) {
                    a.this.ijg.CZ();
                }
            }
        }
    };
    private f.c fda = new f.c() { // from class: com.baidu.tieba.homepage.video.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                a.this.ijg.oj(false);
                a.this.ijf.cgX();
                TiebaStatic.log(new an("c13582"));
                return;
            }
            a.this.ijg.b((f.e) null);
            a.this.mPageContext.showToast(R.string.neterror);
        }
    };
    private BdListView.e iaS = new BdListView.e() { // from class: com.baidu.tieba.homepage.video.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            a.this.ijg.bqK();
            a.this.ijf.bXF();
        }
    };
    private b.a ijh = new b.a() { // from class: com.baidu.tieba.homepage.video.a.5
        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void m(int i, String str, boolean z) {
            a.this.ijg.b((f.e) null);
            a.this.ijg.hideLoadingView();
            a.this.ijg.bqO();
            if (v.isEmpty(a.this.ijg.getDataList())) {
                a.this.ijg.k(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                a.this.ijg.z(a.this.iaU);
            }
            if (StringUtils.isNull(str)) {
                a.this.mPageContext.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.mPageContext.showToast(str);
            }
        }

        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void f(int i, boolean z, boolean z2) {
            a.this.ijg.hideLoadingView();
            a.this.ijg.bqO();
            if (z || z2) {
                a.this.ijg.b((f.e) null);
            } else {
                a.this.ijg.b(a.this.wz(i));
            }
            if (i != 0) {
                a.this.ijg.az(a.this.ijf.getDataList());
                a.this.ijg.z(a.this.iaU);
            } else if (v.isEmpty(a.this.ijg.getDataList())) {
                a.this.ijg.showNoDataView();
            } else if (z) {
                a.this.ijg.bqJ();
            }
        }
    };
    private View.OnClickListener iaU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.ijg != null && a.this.ijf != null) {
                a.this.ijg.bqK();
                a.this.ijf.bXF();
            }
        }
    };

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.ijg = new com.baidu.tieba.homepage.video.d.a(this.mPageContext, bdUniqueId, this.iaQ);
        this.ijf = new b(this.mPageContext, this.ijh);
    }

    public void init() {
        this.ijf.registerListener();
        this.ijg.init();
        this.ijg.setListPullRefreshListener(this.fda);
        this.ijg.a(this.iaS);
        MessageManager.getInstance().registerListener(this.gWb);
    }

    public View getView() {
        if (this.ijg != null) {
            return this.ijg.getRootView();
        }
        return null;
    }

    public void loadData() {
        if (this.ijg != null) {
            this.ijg.cfB();
            this.ijg.showLoadingView();
        }
        if (this.ijf != null) {
            this.ijf.cgX();
        }
    }

    public void Ho() {
        if (this.ijg != null) {
            this.ijg.oj(false);
            this.ijg.cfz();
            this.ijg.cfx();
            this.ijg.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f.e wz(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.video_tab_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.video_tab_count, Integer.valueOf(i));
        }
        return new f.e(string, 1000);
    }

    public void aWq() {
        if (this.ijg != null) {
            this.ijg.aWq();
        }
    }

    public void onPause() {
        if (this.ijg != null) {
            this.ijg.onPause();
            this.ijg.ces();
            this.ijg.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.ijg != null) {
            this.ijg.setListPullRefreshListener(null);
            this.ijg.a((BdListView.e) null);
            this.ijg.onDestroy();
        }
        if (this.ijf != null) {
            this.ijf.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gWb);
    }

    public void setPrimary(boolean z) {
        if (z) {
            this.ijg.cgZ();
        } else {
            this.ijg.ces();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.ijf != null && !v.isEmpty(this.ijf.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.ijf.EY(optString);
            this.ijf.FB(optString);
            if (this.ijg != null) {
                this.ijg.FD(optString);
            }
        }
    }
}
