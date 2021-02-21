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
    private b kry;
    private com.baidu.tieba.homepage.video.d.a krz;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener iPl = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.video.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.g(customResponsedMessage);
            if (a.this.krz != null) {
                a.this.krz.cQA();
            }
        }
    };
    private NEGFeedBackView.a kfy = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.video.a.2
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
                if (a.this.krz != null) {
                    a.this.krz.Kx();
                }
            }
        }
    };
    private f.c gBB = new f.c() { // from class: com.baidu.tieba.homepage.video.a.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                a.this.krz.se(false);
                a.this.kry.cSC();
                TiebaStatic.log(new ar("c13582"));
                return;
            }
            a.this.krz.b((f.e) null);
            a.this.mPageContext.showToast(R.string.neterror);
        }
    };
    private BdListView.e kfA = new BdListView.e() { // from class: com.baidu.tieba.homepage.video.a.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            a.this.krz.bRy();
            a.this.kry.cFF();
        }
    };
    private b.a krA = new b.a() { // from class: com.baidu.tieba.homepage.video.a.5
        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void n(int i, String str, boolean z) {
            a.this.krz.b((f.e) null);
            a.this.krz.hideLoadingView();
            a.this.krz.WZ();
            if (y.isEmpty(a.this.krz.getDataList())) {
                a.this.krz.n(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                a.this.krz.E(a.this.kfC);
            }
            if (StringUtils.isNull(str)) {
                a.this.mPageContext.showToast(R.string.video_tab_load_more_fail);
            } else {
                a.this.mPageContext.showToast(str);
            }
        }

        @Override // com.baidu.tieba.homepage.video.b.b.a
        public void g(int i, boolean z, boolean z2) {
            a.this.krz.hideLoadingView();
            a.this.krz.WZ();
            if (z || z2) {
                a.this.krz.b((f.e) null);
            } else {
                a.this.krz.b(a.this.BQ(i));
            }
            if (i != 0) {
                a.this.krz.bn(a.this.kry.getDataList());
                a.this.krz.E(a.this.kfC);
            } else if (y.isEmpty(a.this.krz.getDataList())) {
                a.this.krz.showNoDataView();
            } else if (z) {
                a.this.krz.bRx();
            }
        }
    };
    private View.OnClickListener kfC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.video.a.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.krz != null && a.this.kry != null) {
                a.this.krz.bRy();
                a.this.kry.cFF();
            }
        }
    };

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.krz = new com.baidu.tieba.homepage.video.d.a(this.mPageContext, bdUniqueId, this.kfy);
        this.kry = new b(this.mPageContext, this.krA);
    }

    public void init() {
        this.kry.registerListener();
        this.krz.init();
        this.krz.setListPullRefreshListener(this.gBB);
        this.krz.a(this.kfA);
        MessageManager.getInstance().registerListener(this.iPl);
    }

    public View getView() {
        if (this.krz != null) {
            return this.krz.getRootView();
        }
        return null;
    }

    public void loadData() {
        if (this.krz != null) {
            this.krz.cQD();
            this.krz.showLoadingView();
        }
        if (this.kry != null) {
            this.kry.cSC();
        }
    }

    public void Ut() {
        if (this.krz != null) {
            this.krz.se(false);
            this.krz.cQB();
            this.krz.cQz();
            this.krz.startPullRefresh();
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
        if (this.krz != null) {
            this.krz.bup();
        }
    }

    public void onPause() {
        if (this.krz != null) {
            this.krz.onPause();
            this.krz.cOU();
            this.krz.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.krz != null) {
            this.krz.setListPullRefreshListener(null);
            this.krz.a((BdListView.e) null);
            this.krz.onDestroy();
        }
        if (this.kry != null) {
            this.kry.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.iPl);
    }

    public void setPrimary(boolean z) {
        if (z) {
            this.krz.cSE();
        } else {
            this.krz.cOU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.kry != null && !y.isEmpty(this.kry.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.kry.KY(optString);
            this.kry.LW(optString);
            if (this.krz != null) {
                this.krz.LY(optString);
            }
        }
    }
}
