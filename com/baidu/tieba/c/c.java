package com.baidu.tieba.c;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.tbadkCore.data.o;
import com.baidu.tieba.view.FloatingAnimationView;
/* loaded from: classes8.dex */
public class c {
    private FloatingAnimationView gvc;
    private o gvd;
    private Runnable gve = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gvc != null && c.this.gvd != null) {
                c.this.gvc.setData(c.this.gvd.cWG(), 100);
                c.this.gvc.playAnimation();
            }
        }
    };
    private Runnable gvf = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gvc != null && c.this.gvd != null) {
                c.this.gvc.stopAnimation();
                c.this.gvc.setData(c.this.gvd.cWF());
            }
        }
    };
    private Runnable gvg = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gvc != null && c.this.gvd != null) {
                c.this.gvc.uJ(true);
                com.baidu.tbadk.core.sharedPref.b.aNV().putInt("key_collection_tag_state", 0);
            }
        }
    };
    private int mFrom;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.gvc = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.gvc.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void bGc() {
                if (c.this.gvd != null && !aq.isEmpty(c.this.gvd.bgd())) {
                    TiebaStatic.log(new an("c12913").af("obj_locate", 2).af("obj_type", c.this.mFrom));
                    if (c.this.gvd.getType() == 2) {
                        c.this.gvc.uJ(false);
                        com.baidu.tbadk.core.sharedPref.b.aNV().putInt("key_collection_tag_state", 1);
                    }
                    ba.aOY().b(c.this.mPageContext, new String[]{c.this.gvd.bgd()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void bGd() {
                c.this.bGb();
                c.this.onDestroy();
                c.this.gvc.setVisibility(8);
                TiebaStatic.log(new an("c12913").af("obj_locate", 3).af("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(o oVar) {
        if (this.gvc != null) {
            if (oVar == null || oVar.getType() == 0) {
                this.gvc.setVisibility(8);
                return;
            }
            this.gvd = oVar;
            if (this.gvd.getType() == 1) {
                bFZ();
            } else if (this.gvd.getType() == 2) {
                bGa();
            }
            biK();
        }
    }

    private void bFZ() {
        String lastId = getLastId();
        if (this.gvd == null || lastId.equals(this.gvd.lp()) || aq.isEmpty(this.gvd.bgd()) || aq.isEmpty(this.gvd.cWF())) {
            this.gvc.setVisibility(8);
            return;
        }
        if (this.gvc.getVisibility() != 0) {
            TiebaStatic.log(new an("c12912").af("obj_locate", this.mFrom));
        }
        this.gvc.setVisibility(0);
        this.gvc.setData(this.gvd.cWF());
        if (this.gvd.getStartTime() > 0 && this.gvd.getEndTime() > 0 && this.gvd.getEndTime() > this.gvd.getStartTime() && !v.isEmpty(this.gvd.cWG())) {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.gve);
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.gvf);
            com.baidu.adp.lib.f.e.lb().postDelayed(this.gve, this.gvd.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.f.e.lb().postDelayed(this.gvf, this.gvd.getEndTime() - System.currentTimeMillis());
        }
    }

    private void bGa() {
        String lastId = getLastId();
        if (this.gvd == null || lastId.equals(this.gvd.lp()) || aq.isEmpty(this.gvd.bgd()) || aq.isEmpty(this.gvd.cWF())) {
            this.gvc.setVisibility(8);
            return;
        }
        this.gvc.setVisibility(0);
        this.gvc.setData(this.gvd.cWF());
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.gvg);
        com.baidu.adp.lib.f.e.lb().postDelayed(this.gvg, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void biK() {
        if (this.gvc != null && this.gvd != null) {
            if (getLastId().equals(this.gvd.lp())) {
                this.gvc.setVisibility(8);
            }
            if (this.gvd.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.aNV().getInt("key_collection_tag_state", 0) == 1) {
                    this.gvc.uJ(false);
                } else {
                    this.gvc.uJ(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.gvd == null) {
            return "";
        }
        int type = this.gvd.getType();
        if (this.mFrom == 1) {
            str = "key_redpacket_float_maintab_last_id_" + type;
        } else {
            str = "key_redpacket_float_frs_last_id_" + type;
        }
        return com.baidu.tbadk.core.sharedPref.b.aNV().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGb() {
        String str;
        if (this.gvd != null) {
            int type = this.gvd.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.aNV().putString(str, this.gvd.lp());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.gve);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.gvf);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.gvg);
        if (this.gvc != null) {
            this.gvc.release();
        }
    }
}
