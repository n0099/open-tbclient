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
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.video.b.b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    private b iAV;
    private com.baidu.tieba.homepage.video.d.a iAW;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener hjb = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.video.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.g(customResponsedMessage);
            if (a.this.iAW != null) {
                a.this.iAW.cje();
            }
        }
    };
    private NEGFeedBackView.a iqa = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.video.a.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(ap apVar) {
            if (apVar == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ap apVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ArrayList<Integer> arrayList, String str, ap apVar) {
            if (arrayList != null && apVar != null) {
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    sb.append(arrayList.get(i)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if (apVar.threadType != 0 && apVar.threadType != 40 && apVar.threadType == 49) {
                }
                if (a.this.iAW != null) {
                    a.this.iAW.DA();
                }
            }
        }
    };
    private f.c fov = new f.c() { // from class: com.baidu.tieba.homepage.video.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                a.this.iAW.ou(false);
                a.this.iAV.ckT();
                TiebaStatic.log(new ao("c13582"));
                return;
            }
            a.this.iAW.b((f.e) null);
            a.this.mPageContext.showToast(R.string.neterror);
        }
    };
    private BdListView.e iqc = new BdListView.e() { // from class: com.baidu.tieba.homepage.video.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            a.this.iAW.btK();
            a.this.iAV.caT();
        }
    };
    private b.a iAX = new b.a() { // from class: com.baidu.tieba.homepage.video.a.5
        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void m(int i, String str, boolean z) {
            a.this.iAW.b((f.e) null);
            a.this.iAW.hideLoadingView();
            a.this.iAW.btO();
            if (w.isEmpty(a.this.iAW.getDataList())) {
                a.this.iAW.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                a.this.iAW.A(a.this.iqe);
            }
            if (StringUtils.isNull(str)) {
                a.this.mPageContext.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.mPageContext.showToast(str);
            }
        }

        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void f(int i, boolean z, boolean z2) {
            a.this.iAW.hideLoadingView();
            a.this.iAW.btO();
            if (z || z2) {
                a.this.iAW.b((f.e) null);
            } else {
                a.this.iAW.b(a.this.xh(i));
            }
            if (i != 0) {
                a.this.iAW.aD(a.this.iAV.getDataList());
                a.this.iAW.A(a.this.iqe);
            } else if (w.isEmpty(a.this.iAW.getDataList())) {
                a.this.iAW.showNoDataView();
            } else if (z) {
                a.this.iAW.btJ();
            }
        }
    };
    private View.OnClickListener iqe = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.iAW != null && a.this.iAV != null) {
                a.this.iAW.btK();
                a.this.iAV.caT();
            }
        }
    };

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.iAW = new com.baidu.tieba.homepage.video.d.a(this.mPageContext, bdUniqueId, this.iqa);
        this.iAV = new b(this.mPageContext, this.iAX);
    }

    public void init() {
        this.iAV.registerListener();
        this.iAW.init();
        this.iAW.setListPullRefreshListener(this.fov);
        this.iAW.a(this.iqc);
        MessageManager.getInstance().registerListener(this.hjb);
    }

    public View getView() {
        if (this.iAW != null) {
            return this.iAW.getRootView();
        }
        return null;
    }

    public void loadData() {
        if (this.iAW != null) {
            this.iAW.cjh();
            this.iAW.showLoadingView();
        }
        if (this.iAV != null) {
            this.iAV.ckT();
        }
    }

    public void IB() {
        if (this.iAW != null) {
            this.iAW.ou(false);
            this.iAW.cjf();
            this.iAW.cjd();
            this.iAW.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f.e xh(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.video_tab_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.video_tab_count, Integer.valueOf(i));
        }
        return new f.e(string, 1000);
    }

    public void aYj() {
        if (this.iAW != null) {
            this.iAW.aYj();
        }
    }

    public void onPause() {
        if (this.iAW != null) {
            this.iAW.onPause();
            this.iAW.chY();
            this.iAW.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.iAW != null) {
            this.iAW.setListPullRefreshListener(null);
            this.iAW.a((BdListView.e) null);
            this.iAW.onDestroy();
        }
        if (this.iAV != null) {
            this.iAV.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.hjb);
    }

    public void setPrimary(boolean z) {
        if (z) {
            this.iAW.ckV();
        } else {
            this.iAW.chY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.iAV != null && !w.isEmpty(this.iAV.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.iAV.Fz(optString);
            this.iAV.Gc(optString);
            if (this.iAW != null) {
                this.iAW.Ge(optString);
            }
        }
    }
}
