package com.baidu.tieba.c;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.tbadkCore.data.m;
import com.baidu.tieba.view.FloatingAnimationView;
/* loaded from: classes.dex */
public class c {
    private FloatingAnimationView cWb;
    private m cWc;
    private Runnable cWd = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.cWb != null && c.this.cWc != null) {
                c.this.cWb.setData(c.this.cWc.bCp(), 100);
                c.this.cWb.cv();
            }
        }
    };
    private Runnable cWe = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.cWb != null && c.this.cWc != null) {
                c.this.cWb.stopAnimation();
                c.this.cWb.setData(c.this.cWc.bCo());
            }
        }
    };
    private Runnable cWf = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.cWb != null && c.this.cWc != null) {
                c.this.cWb.nV(true);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_collection_tag_state", 0);
            }
        }
    };
    private int mFrom;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.cWb = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.cWb.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void apV() {
                if (c.this.cWc != null && !ao.isEmpty(c.this.cWc.UL())) {
                    TiebaStatic.log(new am("c12913").x("obj_locate", 2).x("obj_type", c.this.mFrom));
                    if (c.this.cWc.getType() == 2) {
                        c.this.cWb.nV(false);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_collection_tag_state", 1);
                    }
                    ay.CU().c(c.this.mPageContext, new String[]{c.this.cWc.UL()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void apW() {
                c.this.apU();
                c.this.onDestroy();
                c.this.cWb.setVisibility(8);
                TiebaStatic.log(new am("c12913").x("obj_locate", 3).x("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(m mVar) {
        if (this.cWb != null) {
            if (mVar == null || mVar.getType() == 0) {
                this.cWb.setVisibility(8);
                return;
            }
            this.cWc = mVar;
            if (this.cWc.getType() == 1) {
                apR();
            } else if (this.cWc.getType() == 2) {
                apS();
            }
            apT();
        }
    }

    private void apR() {
        String lastId = getLastId();
        if (this.cWc == null || lastId.equals(this.cWc.bCq()) || ao.isEmpty(this.cWc.UL()) || ao.isEmpty(this.cWc.bCo())) {
            this.cWb.setVisibility(8);
            return;
        }
        if (this.cWb.getVisibility() != 0) {
            TiebaStatic.log(new am("c12912").x("obj_locate", this.mFrom));
        }
        this.cWb.setVisibility(0);
        this.cWb.setData(this.cWc.bCo());
        if (this.cWc.getStartTime() > 0 && this.cWc.getEndTime() > 0 && this.cWc.getEndTime() > this.cWc.getStartTime() && !v.J(this.cWc.bCp())) {
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.cWd);
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.cWe);
            com.baidu.adp.lib.g.e.jI().postDelayed(this.cWd, this.cWc.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.g.e.jI().postDelayed(this.cWe, this.cWc.getEndTime() - System.currentTimeMillis());
        }
    }

    private void apS() {
        String lastId = getLastId();
        if (this.cWc == null || lastId.equals(this.cWc.bCq()) || ao.isEmpty(this.cWc.UL()) || ao.isEmpty(this.cWc.bCo())) {
            this.cWb.setVisibility(8);
            return;
        }
        this.cWb.setVisibility(0);
        this.cWb.setData(this.cWc.bCo());
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.cWf);
        com.baidu.adp.lib.g.e.jI().postDelayed(this.cWf, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void apT() {
        if (this.cWb != null && this.cWc != null) {
            if (getLastId().equals(this.cWc.bCq())) {
                this.cWb.setVisibility(8);
            }
            if (this.cWc.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_collection_tag_state", 0) == 1) {
                    this.cWb.nV(false);
                } else {
                    this.cWb.nV(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.cWc == null) {
            return "";
        }
        int type = this.cWc.getType();
        if (this.mFrom == 1) {
            str = "key_redpacket_float_maintab_last_id_" + type;
        } else {
            str = "key_redpacket_float_frs_last_id_" + type;
        }
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apU() {
        String str;
        if (this.cWc != null) {
            int type = this.cWc.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString(str, this.cWc.bCq());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.cWd);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.cWe);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.cWf);
        if (this.cWb != null) {
            this.cWb.release();
        }
    }
}
