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
    private FloatingAnimationView gvi;
    private o gvj;
    private Runnable gvk = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gvi != null && c.this.gvj != null) {
                c.this.gvi.setData(c.this.gvj.cWE(), 100);
                c.this.gvi.playAnimation();
            }
        }
    };
    private Runnable gvl = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gvi != null && c.this.gvj != null) {
                c.this.gvi.stopAnimation();
                c.this.gvi.setData(c.this.gvj.cWD());
            }
        }
    };
    private Runnable gvm = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gvi != null && c.this.gvj != null) {
                c.this.gvi.uJ(true);
                com.baidu.tbadk.core.sharedPref.b.aNT().putInt("key_collection_tag_state", 0);
            }
        }
    };
    private int mFrom;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.gvi = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.gvi.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void bGb() {
                if (c.this.gvj != null && !aq.isEmpty(c.this.gvj.bgb())) {
                    TiebaStatic.log(new an("c12913").af("obj_locate", 2).af("obj_type", c.this.mFrom));
                    if (c.this.gvj.getType() == 2) {
                        c.this.gvi.uJ(false);
                        com.baidu.tbadk.core.sharedPref.b.aNT().putInt("key_collection_tag_state", 1);
                    }
                    ba.aOV().b(c.this.mPageContext, new String[]{c.this.gvj.bgb()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void bGc() {
                c.this.bGa();
                c.this.onDestroy();
                c.this.gvi.setVisibility(8);
                TiebaStatic.log(new an("c12913").af("obj_locate", 3).af("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(o oVar) {
        if (this.gvi != null) {
            if (oVar == null || oVar.getType() == 0) {
                this.gvi.setVisibility(8);
                return;
            }
            this.gvj = oVar;
            if (this.gvj.getType() == 1) {
                bFY();
            } else if (this.gvj.getType() == 2) {
                bFZ();
            }
            biI();
        }
    }

    private void bFY() {
        String lastId = getLastId();
        if (this.gvj == null || lastId.equals(this.gvj.lp()) || aq.isEmpty(this.gvj.bgb()) || aq.isEmpty(this.gvj.cWD())) {
            this.gvi.setVisibility(8);
            return;
        }
        if (this.gvi.getVisibility() != 0) {
            TiebaStatic.log(new an("c12912").af("obj_locate", this.mFrom));
        }
        this.gvi.setVisibility(0);
        this.gvi.setData(this.gvj.cWD());
        if (this.gvj.getStartTime() > 0 && this.gvj.getEndTime() > 0 && this.gvj.getEndTime() > this.gvj.getStartTime() && !v.isEmpty(this.gvj.cWE())) {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.gvk);
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.gvl);
            com.baidu.adp.lib.f.e.lb().postDelayed(this.gvk, this.gvj.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.f.e.lb().postDelayed(this.gvl, this.gvj.getEndTime() - System.currentTimeMillis());
        }
    }

    private void bFZ() {
        String lastId = getLastId();
        if (this.gvj == null || lastId.equals(this.gvj.lp()) || aq.isEmpty(this.gvj.bgb()) || aq.isEmpty(this.gvj.cWD())) {
            this.gvi.setVisibility(8);
            return;
        }
        this.gvi.setVisibility(0);
        this.gvi.setData(this.gvj.cWD());
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.gvm);
        com.baidu.adp.lib.f.e.lb().postDelayed(this.gvm, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void biI() {
        if (this.gvi != null && this.gvj != null) {
            if (getLastId().equals(this.gvj.lp())) {
                this.gvi.setVisibility(8);
            }
            if (this.gvj.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.aNT().getInt("key_collection_tag_state", 0) == 1) {
                    this.gvi.uJ(false);
                } else {
                    this.gvi.uJ(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.gvj == null) {
            return "";
        }
        int type = this.gvj.getType();
        if (this.mFrom == 1) {
            str = "key_redpacket_float_maintab_last_id_" + type;
        } else {
            str = "key_redpacket_float_frs_last_id_" + type;
        }
        return com.baidu.tbadk.core.sharedPref.b.aNT().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGa() {
        String str;
        if (this.gvj != null) {
            int type = this.gvj.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.aNT().putString(str, this.gvj.lp());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.gvk);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.gvl);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.gvm);
        if (this.gvi != null) {
            this.gvi.release();
        }
    }
}
