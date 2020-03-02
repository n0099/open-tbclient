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
    private int ddp;
    private com.baidu.tieba.homepage.gamevideo.view.b haV;
    private com.baidu.tieba.homepage.gamevideo.d.b haW;
    private a haX;
    private b haY;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;
    private CustomMessageListener gHz = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.gamevideo.b.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.h(customResponsedMessage);
            if (c.this.haV != null) {
                c.this.haV.bOo();
            }
        }
    };
    private NEGFeedBackView.a haZ = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.2
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(al alVar) {
            if (alVar != null) {
                TiebaStatic.log(new an("c13500").cy("obj_locate", "1").cy("fid", alVar.getFid()).cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()));
                TiebaStatic.log(new an("c13499").cy("fid", alVar.getFid()).cy("tid", alVar.getTid()).X("obj_type", c.this.ddp).cy("uid", TbadkCoreApplication.getCurrentAccount()));
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
                if (c.this.haV != null) {
                    c.this.haV.wN();
                }
                TiebaStatic.log(new an("c13500").cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("fid", alVar.getFid()).cy("obj_param1", alVar.weight).cy("obj_source", alVar.source).cy("obj_id", alVar.extra).cy("obj_type", sb.toString()).cy("obj_name", str).X(TiebaInitialize.Params.OBJ_PARAM2, i));
            }
        }
    };
    private final View.OnClickListener hba = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.haV.bOw()) {
                c.this.haV.mE(true);
                if (c.this.haY.isShowing()) {
                    c.this.haY.bOb();
                    c.this.haV.bOv();
                    am.setBackgroundResource(c.this.haV.bOt(), R.color.cp_bg_line_h);
                    return;
                }
                c.this.haY.bY(c.this.haV.bOt());
                c.this.haV.bOu();
                am.setBackgroundResource(c.this.haV.bOt(), R.color.cp_bg_line_d);
                if (c.this.haW != null && !v.isEmpty(c.this.haW.bOi())) {
                    TiebaStatic.log("c13490");
                }
            }
        }
    };
    private g.c emj = new g.c() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                c.this.haW.vp(c.this.ddp);
                c.this.bOg();
                c.this.haV.mD(false);
                return;
            }
            c.this.haV.b((g.e) null);
            c.this.mPageContext.showToast(R.string.im_error_default);
        }
    };
    private BdListView.e hbb = new BdListView.e() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            c.this.haV.bcu();
            c.this.haW.vq(c.this.ddp);
            c.this.bOg();
        }
    };
    private b.a hbc = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6
        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void e(int i, boolean z, boolean z2) {
            c.this.haV.hideLoadingView();
            c.this.haV.bcx();
            if (z || z2) {
                c.this.haV.b((g.e) null);
            } else {
                c.this.haV.b(c.this.vo(i));
            }
            if (!c.this.bOh()) {
                if (!v.isEmpty(c.this.haW.bOi()) && !StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.aFD().getString("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    c.this.haV.mF(c.this.haY.isShowing());
                    c.this.haV.bOx();
                    c.this.haY.setData(c.this.haW.bOi());
                }
                if (i != 0) {
                    c.this.haV.av(c.this.haW.getDataList());
                    c.this.haV.z(c.this.hbd);
                } else if (v.isEmpty(c.this.haV.getDataList())) {
                    c.this.haV.showNoDataView();
                } else if (z) {
                    c.this.haV.bct();
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.d.b.a
        public void k(int i, String str, boolean z) {
            c.this.haV.b((g.e) null);
            c.this.haV.hideLoadingView();
            c.this.haV.bcx();
            if (v.isEmpty(c.this.haV.getDataList())) {
                c.this.haV.l(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.loadData();
                    }
                });
                return;
            }
            if (z) {
                c.this.haV.z(c.this.hbd);
            }
            if (StringUtils.isNull(str)) {
                c.this.mPageContext.showToast(R.string.game_video_recommend_load_more_fail);
            } else {
                c.this.mPageContext.showToast(str);
            }
        }
    };
    private View.OnClickListener hbd = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.haV != null && c.this.haW != null) {
                c.this.haV.bcu();
                c.this.haW.vq(c.this.ddp);
            }
        }
    };
    private b.a hbe = new b.a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.8
        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void bOe() {
            c.this.haV.lt(true);
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void b(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.ddp = aVar.sub_class_id;
                c.this.vn(aVar.sub_class_id);
                if (c.this.haV != null) {
                    c.this.haV.vl(aVar.sub_class_id);
                    c.this.haV.mF(false);
                    c.this.haV.Ch(aVar.sub_class_name);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.gamevideo.b.b.a
        public void bOf() {
            if (c.this.haV != null) {
                c.this.haV.mF(false);
                c.this.haV.lt(false);
            }
        }
    };
    private a.InterfaceC0517a haK = new a.InterfaceC0517a() { // from class: com.baidu.tieba.homepage.gamevideo.b.c.9
        @Override // com.baidu.tieba.homepage.gamevideo.b.a.InterfaceC0517a
        public void a(com.baidu.tieba.homepage.gamevideo.c.a aVar) {
            if (aVar != null) {
                c.this.ddp = aVar.sub_class_id;
                c.this.vn(aVar.sub_class_id);
                if (c.this.haV != null) {
                    c.this.haV.vl(aVar.sub_class_id);
                    c.this.haV.mF(false);
                    c.this.haV.Ch(aVar.sub_class_name);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.haV = new com.baidu.tieba.homepage.gamevideo.view.b(this.mPageContext, bdUniqueId, this.haZ);
        this.haW = new com.baidu.tieba.homepage.gamevideo.d.b(this.mPageContext, this.hbc);
        this.haY = new b(tbPageContext, this.mBdUniqueId);
        this.haY.a(this.hbe);
        this.haX = new a(tbPageContext, this.mBdUniqueId);
        this.haX.a(this.haK);
        this.haV.A(this.hba);
        this.ddp = com.baidu.tbadk.core.sharedPref.b.aFD().getInt("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.haV.vl(this.ddp);
    }

    public void init() {
        this.haW.registerListener();
        this.haV.init();
        this.haV.setListPullRefreshListener(this.emj);
        this.haV.a(this.hbb);
        MessageManager.getInstance().registerListener(this.gHz);
    }

    public View getView() {
        if (this.haV != null) {
            return this.haV.getRootView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOg() {
        TiebaStatic.log(new an("c13493").X("obj_type", this.ddp));
    }

    public void loadData() {
        if (this.haV != null) {
            this.haV.bOr();
            this.haV.showLoadingView();
        }
        if (this.haW != null) {
            this.haW.vp(this.ddp);
        }
    }

    public void AC() {
        if (this.haV != null) {
            this.haV.bOn();
            this.haV.startPullRefresh();
            this.haV.mD(false);
            this.haV.bOp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vn(int i) {
        if (this.haY != null) {
            this.haY.vm(i);
        }
        if (this.haW != null) {
            this.haW.reset();
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bOh() {
        if (this.haW == null || v.isEmpty(this.haW.bOi()) || (!(this.haW.bOj() || this.ddp == 0) || this.haX == null)) {
            return false;
        }
        this.haX.setData(this.haW.bOi());
        this.haX.bj((ViewGroup) this.haV.getRootView());
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

    public void aHN() {
        if (this.haV != null) {
            this.haV.aHN();
        }
        if (this.haY != null) {
            this.haY.onChangeSkinType();
        }
        if (this.haX != null) {
            this.haX.onChangeSkinType();
        }
        if (this.haY.isShowing()) {
            am.setBackgroundResource(this.haV.bOt(), R.color.cp_bg_line_d);
        } else {
            am.setBackgroundResource(this.haV.bOt(), R.color.cp_bg_line_h);
        }
    }

    public void onPause() {
        if (this.haV != null) {
            this.haV.onPause();
            this.haV.bNf();
            this.haV.setTabInForeBackgroundState(true);
        }
    }

    public void onDestroy() {
        if (this.haV != null) {
            this.haV.setListPullRefreshListener(null);
            this.haV.a((BdListView.e) null);
            this.haV.onDestroy();
        }
        if (this.haY != null) {
            this.haY.onDestroy();
        }
        if (this.haX != null) {
            this.haX.onDestroy();
        }
        if (this.haW != null) {
            this.haW.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gHz);
    }

    public void setPrimary(boolean z) {
        if (z) {
            TiebaStatic.log(new an("c13486").X("obj_type", this.ddp));
            if (!this.haY.isShowing()) {
                this.haV.setViewForeground();
                return;
            }
            return;
        }
        if (this.haY != null) {
            this.haY.bOc();
        }
        this.haV.bNf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.haW != null && !v.isEmpty(this.haW.getDataList())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.haW.BB(optString);
            this.haW.Cg(optString);
            if (this.haV != null) {
                this.haV.Ci(optString);
            }
        }
    }
}
