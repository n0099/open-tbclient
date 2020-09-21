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
/* loaded from: classes21.dex */
public class a {
    private b jeL;
    private com.baidu.tieba.homepage.video.d.a jeM;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener hII = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.video.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.g(customResponsedMessage);
            if (a.this.jeM != null) {
                a.this.jeM.cAX();
            }
        }
    };
    private NEGFeedBackView.a iTh = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.video.a.2
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
                if (a.this.jeM != null) {
                    a.this.jeM.Ka();
                }
            }
        }
    };
    private f.c fIp = new f.c() { // from class: com.baidu.tieba.homepage.video.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                a.this.jeM.pO(false);
                a.this.jeL.cCU();
                TiebaStatic.log(new aq("c13582"));
                return;
            }
            a.this.jeM.b((f.e) null);
            a.this.mPageContext.showToast(R.string.neterror);
        }
    };
    private BdListView.e iTj = new BdListView.e() { // from class: com.baidu.tieba.homepage.video.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            a.this.jeM.bHj();
            a.this.jeL.csj();
        }
    };
    private b.a jeN = new b.a() { // from class: com.baidu.tieba.homepage.video.a.5
        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void l(int i, String str, boolean z) {
            a.this.jeM.b((f.e) null);
            a.this.jeM.hideLoadingView();
            a.this.jeM.bHn();
            if (y.isEmpty(a.this.jeM.getDataList())) {
                a.this.jeM.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                a.this.jeM.B(a.this.iTl);
            }
            if (StringUtils.isNull(str)) {
                a.this.mPageContext.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.mPageContext.showToast(str);
            }
        }

        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void g(int i, boolean z, boolean z2) {
            a.this.jeM.hideLoadingView();
            a.this.jeM.bHn();
            if (z || z2) {
                a.this.jeM.b((f.e) null);
            } else {
                a.this.jeM.b(a.this.Au(i));
            }
            if (i != 0) {
                a.this.jeM.aO(a.this.jeL.getDataList());
                a.this.jeM.B(a.this.iTl);
            } else if (y.isEmpty(a.this.jeM.getDataList())) {
                a.this.jeM.showNoDataView();
            } else if (z) {
                a.this.jeM.bHi();
            }
        }
    };
    private View.OnClickListener iTl = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.jeM != null && a.this.jeL != null) {
                a.this.jeM.bHj();
                a.this.jeL.csj();
            }
        }
    };

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.jeM = new com.baidu.tieba.homepage.video.d.a(this.mPageContext, bdUniqueId, this.iTh);
        this.jeL = new b(this.mPageContext, this.jeN);
    }

    public void init() {
        this.jeL.registerListener();
        this.jeM.init();
        this.jeM.setListPullRefreshListener(this.fIp);
        this.jeM.a(this.iTj);
        MessageManager.getInstance().registerListener(this.hII);
    }

    public View getView() {
        if (this.jeM != null) {
            return this.jeM.getRootView();
        }
        return null;
    }

    public void loadData() {
        if (this.jeM != null) {
            this.jeM.cBa();
            this.jeM.showLoadingView();
        }
        if (this.jeL != null) {
            this.jeL.cCU();
        }
    }

    public void Pd() {
        if (this.jeM != null) {
            this.jeM.pO(false);
            this.jeM.cAY();
            this.jeM.cAW();
            this.jeM.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f.e Au(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.video_tab_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.video_tab_count, Integer.valueOf(i));
        }
        return new f.e(string, 1000);
    }

    public void blA() {
        if (this.jeM != null) {
            this.jeM.blA();
        }
    }

    public void onPause() {
        if (this.jeM != null) {
            this.jeM.onPause();
            this.jeM.czB();
            this.jeM.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.jeM != null) {
            this.jeM.setListPullRefreshListener(null);
            this.jeM.a((BdListView.e) null);
            this.jeM.onDestroy();
        }
        if (this.jeL != null) {
            this.jeL.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.hII);
    }

    public void setPrimary(boolean z) {
        if (z) {
            this.jeM.cCW();
        } else {
            this.jeM.czB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.jeL != null && !y.isEmpty(this.jeL.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.jeL.Jm(optString);
            this.jeL.Kh(optString);
            if (this.jeM != null) {
                this.jeM.Kj(optString);
            }
        }
    }
}
