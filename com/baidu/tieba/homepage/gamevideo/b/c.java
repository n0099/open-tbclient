package com.baidu.tieba.homepage.gamevideo.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.b.a;
import com.baidu.tieba.homepage.gamevideo.b.b;
import com.baidu.tieba.homepage.gamevideo.d.b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    private int dYs;
    private com.baidu.tieba.homepage.gamevideo.view.b ipW;
    private com.baidu.tieba.homepage.gamevideo.d.b ipX;
    private a ipY;
    private b ipZ;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener hjb = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.g(customResponsedMessage);
            if (c.this.ipW != null) {
                c.this.ipW.cje();
            }
        }
    };
    private NEGFeedBackView.a iqa = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(ap apVar) {
            if (apVar != null) {
                TiebaStatic.log(new ao("c13500").dk("obj_locate", "1").dk("fid", apVar.getFid()).dk("tid", apVar.getTid()).dk("uid", TbadkCoreApplication.getCurrentAccount()));
                TiebaStatic.log(new ao("c13499").dk("fid", apVar.getFid()).dk("tid", apVar.getTid()).ag("obj_type", c.this.dYs).dk("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ap apVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ArrayList<Integer> arrayList, String str, ap apVar) {
            int i = 0;
            if (arrayList != null && apVar != null) {
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    sb.append(arrayList.get(i2)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if (apVar.threadType == 0) {
                    i = 1;
                } else if (apVar.threadType == 40) {
                    i = 2;
                } else if (apVar.threadType == 49) {
                    i = 3;
                }
                if (c.this.ipW != null) {
                    c.this.ipW.DA();
                }
                TiebaStatic.log(new ao("c13500").dk("tid", apVar.getTid()).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("fid", apVar.getFid()).dk("obj_param1", apVar.weight).dk("obj_source", apVar.source).dk("obj_id", apVar.extra).dk("obj_type", sb.toString()).dk("obj_name", str).ag(TiebaInitialize.Params.OBJ_PARAM2, i));
            }
        }
    };
    private final View.OnClickListener iqb = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.ipW.cjm()) {
                c.this.ipW.ov(true);
                if (c.this.ipZ.isShowing()) {
                    c.this.ipZ.ciR();
                    c.this.ipW.cjl();
                    an.setBackgroundResource(c.this.ipW.cjj(), R.color.cp_bg_line_h);
                    return;
                }
                c.this.ipZ.ch(c.this.ipW.cjj());
                c.this.ipW.cjk();
                an.setBackgroundResource(c.this.ipW.cjj(), R.color.cp_bg_line_d);
                if (c.this.ipX != null && !w.isEmpty(c.this.ipX.ciY())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private f.c fov = new f.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                c.this.ipX.xi(c.this.dYs);
                c.this.ciW();
                c.this.ipW.ou(false);
                return;
            }
            c.this.ipW.b((f.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e iqc = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.ipW.btK();
            c.this.ipX.xj(c.this.dYs);
            c.this.ciW();
        }
    };
    private b.a iqd = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void e(int i, boolean z, boolean z2) {
            c.this.ipW.hideLoadingView();
            c.this.ipW.btO();
            if (z || z2) {
                c.this.ipW.b((f.e) null);
            } else {
                c.this.ipW.b(c.this.xh(i));
            }
            if (!c.this.ciX()) {
                if (!w.isEmpty(c.this.ipX.ciY()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.aVP().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.ipW.ow(c.this.ipZ.isShowing());
                    c.this.ipW.cjn();
                    c.this.ipZ.setData(c.this.ipX.ciY());
                }
                if (i != 0) {
                    c.this.ipW.aD(c.this.ipX.getDataList());
                    c.this.ipW.A(c.this.iqe);
                } else if (w.isEmpty(c.this.ipW.getDataList())) {
                    c.this.ipW.showNoDataView();
                } else if (z) {
                    c.this.ipW.btJ();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void l(int i, String str, boolean z) {
            c.this.ipW.b((f.e) null);
            c.this.ipW.hideLoadingView();
            c.this.ipW.btO();
            if (w.isEmpty(c.this.ipW.getDataList())) {
                c.this.ipW.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.ipW.A(c.this.iqe);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener iqe = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.ipW != null && c.this.ipX != null) {
                c.this.ipW.btK();
                c.this.ipX.xj(c.this.dYs);
            }
        }
    };
    private b.a iqf = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void ciU() {
            c.this.ipW.ni(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.dYs = aVar.sub_class_id;
                c.this.xg(aVar.sub_class_id);
                if (c.this.ipW != null) {
                    c.this.ipW.xe(aVar.sub_class_id);
                    c.this.ipW.ow(false);
                    c.this.ipW.Gd(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void ciV() {
            if (c.this.ipW != null) {
                c.this.ipW.ow(false);
                c.this.ipW.ni(false);
            }
        }
    };
    private a.InterfaceC0634a ipL = new a.InterfaceC0634a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0634a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.dYs = aVar.sub_class_id;
                c.this.xg(aVar.sub_class_id);
                if (c.this.ipW != null) {
                    c.this.ipW.xe(aVar.sub_class_id);
                    c.this.ipW.ow(false);
                    c.this.ipW.Gd(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.ipW = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.iqa);
        this.ipX = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.iqd);
        this.ipZ = new b(tbPageContext, this.mBdUniqueId);
        this.ipZ.a(this.iqf);
        this.ipY = new a(tbPageContext, this.mBdUniqueId);
        this.ipY.a(this.ipL);
        this.ipW.B(this.iqb);
        this.dYs = com.baidu.tbadk.core.sharedPref.b.aVP().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.ipW.xe(this.dYs);
    }

    public void init() {
        this.ipX.registerListener();
        this.ipW.init();
        this.ipW.setListPullRefreshListener(this.fov);
        this.ipW.a(this.iqc);
        MessageManager.getInstance().registerListener(this.hjb);
    }

    public View getView() {
        if (this.ipW != null) {
            return this.ipW.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciW() {
        TiebaStatic.log(new ao("c13493").ag("obj_type", this.dYs));
    }

    public void loadData() {
        if (this.ipW != null) {
            this.ipW.cjh();
            this.ipW.showLoadingView();
        }
        if (this.ipX != null) {
            this.ipX.xi(this.dYs);
        }
    }

    public void IB() {
        if (this.ipW != null) {
            this.ipW.cjd();
            this.ipW.startPullRefresh();
            this.ipW.ou(false);
            this.ipW.cjf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xg(int i) {
        if (this.ipZ != null) {
            this.ipZ.xf(i);
        }
        if (this.ipX != null) {
            this.ipX.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ciX() {
        if (this.ipX == null || w.isEmpty(this.ipX.ciY()) || (!(this.ipX.ciZ() || this.dYs == 0) || this.ipY == null)) {
            return false;
        }
        this.ipY.setData(this.ipX.ciY());
        this.ipY.bA((ViewGroup) this.ipW.getRootView());
        com.baidu.tbadk.core.sharedPref.b.aVP().remove("key_game_video_tab_has_choosed_sub_class_id");
        com.baidu.tbadk.core.sharedPref.b.aVP().remove("key_game_video_tab_has_choosed_sub_class_name");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f.e xh(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i));
        }
        return new f.e(string, 1000);
    }

    public void aYj() {
        if (this.ipW != null) {
            this.ipW.aYj();
        }
        if (this.ipZ != null) {
            this.ipZ.onChangeSkinType();
        }
        if (this.ipY != null) {
            this.ipY.onChangeSkinType();
        }
        if (this.ipZ.isShowing()) {
            an.setBackgroundResource(this.ipW.cjj(), R.color.cp_bg_line_d);
        } else {
            an.setBackgroundResource(this.ipW.cjj(), R.color.cp_bg_line_h);
        }
    }

    public void onPause() {
        if (this.ipW != null) {
            this.ipW.onPause();
            this.ipW.chY();
            this.ipW.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.ipW != null) {
            this.ipW.setListPullRefreshListener(null);
            this.ipW.a((BdListView.e) null);
            this.ipW.onDestroy();
        }
        if (this.ipZ != null) {
            this.ipZ.onDestroy();
        }
        if (this.ipY != null) {
            this.ipY.onDestroy();
        }
        if (this.ipX != null) {
            this.ipX.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.hjb);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new ao("c13486").ag("obj_type", this.dYs));
            if (!this.ipZ.isShowing()) {
                this.ipW.setViewForeground();
                return;
            }
            return;
        }
        if (this.ipZ != null) {
            this.ipZ.ciS();
        }
        this.ipW.chY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.ipX != null && !w.isEmpty(this.ipX.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.ipX.Fz(optString);
            this.ipX.Gc(optString);
            if (this.ipW != null) {
                this.ipW.Ge(optString);
            }
        }
    }
}
