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
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.g;
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
    private int ddD;
    private com.baidu.tieba.homepage.gamevideo.view.b hbh;
    private com.baidu.tieba.homepage.gamevideo.d.b hbi;
    private a hbj;
    private b hbk;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener gHL = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.h(customResponsedMessage);
            if (c.this.hbh != null) {
                c.this.hbh.bOp();
            }
        }
    };
    private NEGFeedBackView.a hbl = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(al alVar) {
            if (alVar != null) {
                TiebaStatic.log(new an("c13500").cy("obj_locate", "1").cy("fid", alVar.getFid()).cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()));
                TiebaStatic.log(new an("c13499").cy("fid", alVar.getFid()).cy("tid", alVar.getTid()).X("obj_type", c.this.ddD).cy("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(al alVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ArrayList<Integer> arrayList, String str, al alVar) {
            int i = 0;
            if (arrayList != null && alVar != null) {
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    sb.append(arrayList.get(i2)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if (alVar.threadType == 0) {
                    i = 1;
                } else if (alVar.threadType == 40) {
                    i = 2;
                } else if (alVar.threadType == 49) {
                    i = 3;
                }
                if (c.this.hbh != null) {
                    c.this.hbh.wN();
                }
                TiebaStatic.log(new an("c13500").cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("fid", alVar.getFid()).cy("obj_param1", alVar.weight).cy("obj_source", alVar.source).cy("obj_id", alVar.extra).cy("obj_type", sb.toString()).cy("obj_name", str).X(TiebaInitialize.Params.OBJ_PARAM2, i));
            }
        }
    };
    private final View.OnClickListener hbm = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.hbh.bOx()) {
                c.this.hbh.mE(true);
                if (c.this.hbk.isShowing()) {
                    c.this.hbk.bOc();
                    c.this.hbh.bOw();
                    am.setBackgroundResource(c.this.hbh.bOu(), R.color.cp_bg_line_h);
                    return;
                }
                c.this.hbk.bY(c.this.hbh.bOu());
                c.this.hbh.bOv();
                am.setBackgroundResource(c.this.hbh.bOu(), R.color.cp_bg_line_d);
                if (c.this.hbi != null && !v.isEmpty(c.this.hbi.bOj())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private g.c emw = new g.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                c.this.hbi.vp(c.this.ddD);
                c.this.bOh();
                c.this.hbh.mD(false);
                return;
            }
            c.this.hbh.b((g.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e hbn = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.hbh.bcv();
            c.this.hbi.vq(c.this.ddD);
            c.this.bOh();
        }
    };
    private b.a hbo = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void e(int i, boolean z, boolean z2) {
            c.this.hbh.hideLoadingView();
            c.this.hbh.bcy();
            if (z || z2) {
                c.this.hbh.b((g.e) null);
            } else {
                c.this.hbh.b(c.this.vo(i));
            }
            if (!c.this.bOi()) {
                if (!v.isEmpty(c.this.hbi.bOj()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.aFD().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.hbh.mF(c.this.hbk.isShowing());
                    c.this.hbh.bOy();
                    c.this.hbk.setData(c.this.hbi.bOj());
                }
                if (i != 0) {
                    c.this.hbh.av(c.this.hbi.getDataList());
                    c.this.hbh.z(c.this.hbp);
                } else if (v.isEmpty(c.this.hbh.getDataList())) {
                    c.this.hbh.showNoDataView();
                } else if (z) {
                    c.this.hbh.bcu();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void k(int i, String str, boolean z) {
            c.this.hbh.b((g.e) null);
            c.this.hbh.hideLoadingView();
            c.this.hbh.bcy();
            if (v.isEmpty(c.this.hbh.getDataList())) {
                c.this.hbh.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.hbh.z(c.this.hbp);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener hbp = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.hbh != null && c.this.hbi != null) {
                c.this.hbh.bcv();
                c.this.hbi.vq(c.this.ddD);
            }
        }
    };
    private b.a hbq = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void bOf() {
            c.this.hbh.lt(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.ddD = aVar.sub_class_id;
                c.this.vn(aVar.sub_class_id);
                if (c.this.hbh != null) {
                    c.this.hbh.vl(aVar.sub_class_id);
                    c.this.hbh.mF(false);
                    c.this.hbh.Ci(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void bOg() {
            if (c.this.hbh != null) {
                c.this.hbh.mF(false);
                c.this.hbh.lt(false);
            }
        }
    };
    private a.InterfaceC0517a haW = new a.InterfaceC0517a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0517a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.ddD = aVar.sub_class_id;
                c.this.vn(aVar.sub_class_id);
                if (c.this.hbh != null) {
                    c.this.hbh.vl(aVar.sub_class_id);
                    c.this.hbh.mF(false);
                    c.this.hbh.Ci(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.hbh = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.hbl);
        this.hbi = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.hbo);
        this.hbk = new b(tbPageContext, this.mBdUniqueId);
        this.hbk.a(this.hbq);
        this.hbj = new a(tbPageContext, this.mBdUniqueId);
        this.hbj.a(this.haW);
        this.hbh.A(this.hbm);
        this.ddD = com.baidu.tbadk.core.sharedPref.b.aFD().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.hbh.vl(this.ddD);
    }

    public void init() {
        this.hbi.registerListener();
        this.hbh.init();
        this.hbh.setListPullRefreshListener(this.emw);
        this.hbh.a(this.hbn);
        MessageManager.getInstance().registerListener(this.gHL);
    }

    public View getView() {
        if (this.hbh != null) {
            return this.hbh.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOh() {
        TiebaStatic.log(new an("c13493").X("obj_type", this.ddD));
    }

    public void loadData() {
        if (this.hbh != null) {
            this.hbh.bOs();
            this.hbh.showLoadingView();
        }
        if (this.hbi != null) {
            this.hbi.vp(this.ddD);
        }
    }

    public void AC() {
        if (this.hbh != null) {
            this.hbh.bOo();
            this.hbh.startPullRefresh();
            this.hbh.mD(false);
            this.hbh.bOq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vn(int i) {
        if (this.hbk != null) {
            this.hbk.vm(i);
        }
        if (this.hbi != null) {
            this.hbi.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bOi() {
        if (this.hbi == null || v.isEmpty(this.hbi.bOj()) || (!(this.hbi.bOk() || this.ddD == 0) || this.hbj == null)) {
            return false;
        }
        this.hbj.setData(this.hbi.bOj());
        this.hbj.bj((ViewGroup) this.hbh.getRootView());
        com.baidu.tbadk.core.sharedPref.b.aFD().remove("key_game_video_tab_has_choosed_sub_class_id");
        com.baidu.tbadk.core.sharedPref.b.aFD().remove("key_game_video_tab_has_choosed_sub_class_name");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g.e vo(int i) {
        String string;
        if (i <= 0) {
            string = this.mPageContext.getResources().getString(R.string.game_video_no_more);
        } else {
            string = this.mPageContext.getResources().getString(R.string.game_video_recommend_count, Integer.valueOf(i));
        }
        return new g.e(string, 1000);
    }

    public void aHO() {
        if (this.hbh != null) {
            this.hbh.aHO();
        }
        if (this.hbk != null) {
            this.hbk.onChangeSkinType();
        }
        if (this.hbj != null) {
            this.hbj.onChangeSkinType();
        }
        if (this.hbk.isShowing()) {
            am.setBackgroundResource(this.hbh.bOu(), R.color.cp_bg_line_d);
        } else {
            am.setBackgroundResource(this.hbh.bOu(), R.color.cp_bg_line_h);
        }
    }

    public void onPause() {
        if (this.hbh != null) {
            this.hbh.onPause();
            this.hbh.bNg();
            this.hbh.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.hbh != null) {
            this.hbh.setListPullRefreshListener(null);
            this.hbh.a((BdListView.e) null);
            this.hbh.onDestroy();
        }
        if (this.hbk != null) {
            this.hbk.onDestroy();
        }
        if (this.hbj != null) {
            this.hbj.onDestroy();
        }
        if (this.hbi != null) {
            this.hbi.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gHL);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new an("c13486").X("obj_type", this.ddD));
            if (!this.hbk.isShowing()) {
                this.hbh.setViewForeground();
                return;
            }
            return;
        }
        if (this.hbk != null) {
            this.hbk.bOd();
        }
        this.hbh.bNg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.hbi != null && !v.isEmpty(this.hbi.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.hbi.BC(optString);
            this.hbi.Ch(optString);
            if (this.hbh != null) {
                this.hbh.Cj(optString);
            }
        }
    }
}
