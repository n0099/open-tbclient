package com.baidu.tieba.c;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.tbadkCore.data.m;
import com.baidu.tieba.view.FloatingAnimationView;
/* loaded from: classes.dex */
public class c {
    private FloatingAnimationView cHW;
    private m cHX;
    private Runnable cHY = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.cHW != null && c.this.cHX != null) {
                c.this.cHW.setData(c.this.cHX.bwv(), 100);
                c.this.cHW.aX();
            }
        }
    };
    private Runnable cHZ = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.cHW != null && c.this.cHX != null) {
                c.this.cHW.stopAnimation();
                c.this.cHW.setData(c.this.cHX.bwu());
            }
        }
    };
    private Runnable cIa = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.cHW != null && c.this.cHX != null) {
                c.this.cHW.ni(true);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_collection_tag_state", 0);
            }
        }
    };
    private int mFrom;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.cHW = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.cHW.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void akJ() {
                if (c.this.cHX != null && !ap.isEmpty(c.this.cHX.QW())) {
                    TiebaStatic.log(new an("c12913").r("obj_locate", 2).r("obj_type", c.this.mFrom));
                    if (c.this.cHX.getType() == 2) {
                        c.this.cHW.ni(false);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_collection_tag_state", 1);
                    }
                    ay.zK().c(c.this.mPageContext, new String[]{c.this.cHX.QW()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void akK() {
                c.this.akI();
                c.this.onDestroy();
                c.this.cHW.setVisibility(8);
                TiebaStatic.log(new an("c12913").r("obj_locate", 3).r("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(m mVar) {
        if (this.cHW != null) {
            if (mVar == null || mVar.getType() == 0) {
                this.cHW.setVisibility(8);
                return;
            }
            this.cHX = mVar;
            if (this.cHX.getType() == 1) {
                akF();
            } else if (this.cHX.getType() == 2) {
                akG();
            }
            akH();
        }
    }

    private void akF() {
        String lastId = getLastId();
        if (this.cHX == null || lastId.equals(this.cHX.bww()) || ap.isEmpty(this.cHX.QW()) || ap.isEmpty(this.cHX.bwu())) {
            this.cHW.setVisibility(8);
            return;
        }
        if (this.cHW.getVisibility() != 0) {
            TiebaStatic.log(new an("c12912").r("obj_locate", this.mFrom));
        }
        this.cHW.setVisibility(0);
        this.cHW.setData(this.cHX.bwu());
        if (this.cHX.getStartTime() > 0 && this.cHX.getEndTime() > 0 && this.cHX.getEndTime() > this.cHX.getStartTime() && !w.z(this.cHX.bwv())) {
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.cHY);
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.cHZ);
            com.baidu.adp.lib.g.e.in().postDelayed(this.cHY, this.cHX.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.g.e.in().postDelayed(this.cHZ, this.cHX.getEndTime() - System.currentTimeMillis());
        }
    }

    private void akG() {
        String lastId = getLastId();
        if (this.cHX == null || lastId.equals(this.cHX.bww()) || ap.isEmpty(this.cHX.QW()) || ap.isEmpty(this.cHX.bwu())) {
            this.cHW.setVisibility(8);
            return;
        }
        this.cHW.setVisibility(0);
        this.cHW.setData(this.cHX.bwu());
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.cIa);
        com.baidu.adp.lib.g.e.in().postDelayed(this.cIa, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void akH() {
        if (this.cHW != null && this.cHX != null) {
            if (getLastId().equals(this.cHX.bww())) {
                this.cHW.setVisibility(8);
            }
            if (this.cHX.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_collection_tag_state", 0) == 1) {
                    this.cHW.ni(false);
                } else {
                    this.cHW.ni(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.cHX == null) {
            return "";
        }
        int type = this.cHX.getType();
        if (this.mFrom == 1) {
            str = "key_redpacket_float_maintab_last_id_" + type;
        } else {
            str = "key_redpacket_float_frs_last_id_" + type;
        }
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akI() {
        String str;
        if (this.cHX != null) {
            int type = this.cHX.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString(str, this.cHX.bww());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.cHY);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.cHZ);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.cIa);
        if (this.cHW != null) {
            this.cHW.release();
        }
    }
}
