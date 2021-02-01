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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.video.b.b;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private b krk;
    private com.baidu.tieba.homepage.video.d.a krl;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener iOX = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.video.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.g(customResponsedMessage);
            if (a.this.krl != null) {
                a.this.krl.cQt();
            }
        }
    };
    private NEGFeedBackView.a kfk = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.video.a.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(av avVar) {
            if (avVar == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onCheckedChanged(av avVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, av avVar) {
            if (arrayList != null && avVar != null) {
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    sb.append(arrayList.get(i)).append(",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if (avVar.threadType != 0 && avVar.threadType != 40 && avVar.threadType == 49) {
                }
                if (a.this.krl != null) {
                    a.this.krl.Kx();
                }
            }
        }
    };
    private f.c gBn = new f.c() { // from class: com.baidu.tieba.homepage.video.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                a.this.krl.se(false);
                a.this.krk.cSv();
                TiebaStatic.log(new ar("c13582"));
                return;
            }
            a.this.krl.b((f.e) null);
            a.this.mPageContext.showToast(R.string.neterror);
        }
    };
    private BdListView.e kfm = new BdListView.e() { // from class: com.baidu.tieba.homepage.video.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            a.this.krl.bRr();
            a.this.krk.cFy();
        }
    };
    private b.a krm = new b.a() { // from class: com.baidu.tieba.homepage.video.a.5
        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void n(int i, String str, boolean z) {
            a.this.krl.b((f.e) null);
            a.this.krl.hideLoadingView();
            a.this.krl.WZ();
            if (y.isEmpty(a.this.krl.getDataList())) {
                a.this.krl.n(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                a.this.krl.E(a.this.kfo);
            }
            if (StringUtils.isNull(str)) {
                a.this.mPageContext.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.mPageContext.showToast(str);
            }
        }

        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void g(int i, boolean z, boolean z2) {
            a.this.krl.hideLoadingView();
            a.this.krl.WZ();
            if (z || z2) {
                a.this.krl.b((f.e) null);
            } else {
                a.this.krl.b(a.this.BQ(i));
            }
            if (i != 0) {
                a.this.krl.bn(a.this.krk.getDataList());
                a.this.krl.E(a.this.kfo);
            } else if (y.isEmpty(a.this.krl.getDataList())) {
                a.this.krl.showNoDataView();
            } else if (z) {
                a.this.krl.bRq();
            }
        }
    };
    private View.OnClickListener kfo = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.krl != null && a.this.krk != null) {
                a.this.krl.bRr();
                a.this.krk.cFy();
            }
        }
    };

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.krl = new com.baidu.tieba.homepage.video.d.a(this.mPageContext, bdUniqueId, this.kfk);
        this.krk = new b(this.mPageContext, this.krm);
    }

    public void init() {
        this.krk.registerListener();
        this.krl.init();
        this.krl.setListPullRefreshListener(this.gBn);
        this.krl.a(this.kfm);
        MessageManager.getInstance().registerListener(this.iOX);
    }

    public View getView() {
        if (this.krl != null) {
            return this.krl.getRootView();
        }
        return null;
    }

    public void loadData() {
        if (this.krl != null) {
            this.krl.cQw();
            this.krl.showLoadingView();
        }
        if (this.krk != null) {
            this.krk.cSv();
        }
    }

    public void Ut() {
        if (this.krl != null) {
            this.krl.se(false);
            this.krl.cQu();
            this.krl.cQs();
            this.krl.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f.e BQ(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.video_tab_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.video_tab_count, Integer.valueOf(i));
        }
        return new f.e(string, 1000);
    }

    public void bup() {
        if (this.krl != null) {
            this.krl.bup();
        }
    }

    public void onPause() {
        if (this.krl != null) {
            this.krl.onPause();
            this.krl.cON();
            this.krl.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.krl != null) {
            this.krl.setListPullRefreshListener(null);
            this.krl.a((BdListView.e) null);
            this.krl.onDestroy();
        }
        if (this.krk != null) {
            this.krk.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.iOX);
    }

    public void setPrimary(boolean z) {
        if (z) {
            this.krl.cSx();
        } else {
            this.krl.cON();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.krk != null && !y.isEmpty(this.krk.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.krk.KX(optString);
            this.krk.LV(optString);
            if (this.krl != null) {
                this.krl.LX(optString);
            }
        }
    }
}
