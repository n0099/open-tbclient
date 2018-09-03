package com.baidu.tieba.c;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.tbadkCore.data.m;
import com.baidu.tieba.view.FloatingAnimationView;
/* loaded from: classes.dex */
public class c {
    private FloatingAnimationView cHT;
    private m cHU;
    private Runnable cHV = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.cHT != null && c.this.cHU != null) {
                c.this.cHT.setData(c.this.cHU.bww(), 100);
                c.this.cHT.aX();
            }
        }
    };
    private Runnable cHW = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.cHT != null && c.this.cHU != null) {
                c.this.cHT.stopAnimation();
                c.this.cHT.setData(c.this.cHU.bwv());
            }
        }
    };
    private Runnable cHX = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.cHT != null && c.this.cHU != null) {
                c.this.cHT.ni(true);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_collection_tag_state", 0);
            }
        }
    };
    private int mFrom;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.cHT = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.cHT.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void akL() {
                if (c.this.cHU != null && !ap.isEmpty(c.this.cHU.Rb())) {
                    TiebaStatic.log(new an("c12913").r("obj_locate", 2).r("obj_type", c.this.mFrom));
                    if (c.this.cHU.getType() == 2) {
                        c.this.cHT.ni(false);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_collection_tag_state", 1);
                    }
                    az.zI().c(c.this.mPageContext, new String[]{c.this.cHU.Rb()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void akM() {
                c.this.akK();
                c.this.onDestroy();
                c.this.cHT.setVisibility(8);
                TiebaStatic.log(new an("c12913").r("obj_locate", 3).r("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(m mVar) {
        if (this.cHT != null) {
            if (mVar == null || mVar.getType() == 0) {
                this.cHT.setVisibility(8);
                return;
            }
            this.cHU = mVar;
            if (this.cHU.getType() == 1) {
                akH();
            } else if (this.cHU.getType() == 2) {
                akI();
            }
            akJ();
        }
    }

    private void akH() {
        String lastId = getLastId();
        if (this.cHU == null || lastId.equals(this.cHU.bwx()) || ap.isEmpty(this.cHU.Rb()) || ap.isEmpty(this.cHU.bwv())) {
            this.cHT.setVisibility(8);
            return;
        }
        if (this.cHT.getVisibility() != 0) {
            TiebaStatic.log(new an("c12912").r("obj_locate", this.mFrom));
        }
        this.cHT.setVisibility(0);
        this.cHT.setData(this.cHU.bwv());
        if (this.cHU.getStartTime() > 0 && this.cHU.getEndTime() > 0 && this.cHU.getEndTime() > this.cHU.getStartTime() && !w.z(this.cHU.bww())) {
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.cHV);
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.cHW);
            com.baidu.adp.lib.g.e.in().postDelayed(this.cHV, this.cHU.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.g.e.in().postDelayed(this.cHW, this.cHU.getEndTime() - System.currentTimeMillis());
        }
    }

    private void akI() {
        String lastId = getLastId();
        if (this.cHU == null || lastId.equals(this.cHU.bwx()) || ap.isEmpty(this.cHU.Rb()) || ap.isEmpty(this.cHU.bwv())) {
            this.cHT.setVisibility(8);
            return;
        }
        this.cHT.setVisibility(0);
        this.cHT.setData(this.cHU.bwv());
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.cHX);
        com.baidu.adp.lib.g.e.in().postDelayed(this.cHX, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void akJ() {
        if (this.cHT != null && this.cHU != null) {
            if (getLastId().equals(this.cHU.bwx())) {
                this.cHT.setVisibility(8);
            }
            if (this.cHU.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_collection_tag_state", 0) == 1) {
                    this.cHT.ni(false);
                } else {
                    this.cHT.ni(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.cHU == null) {
            return "";
        }
        int type = this.cHU.getType();
        if (this.mFrom == 1) {
            str = "key_redpacket_float_maintab_last_id_" + type;
        } else {
            str = "key_redpacket_float_frs_last_id_" + type;
        }
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akK() {
        String str;
        if (this.cHU != null) {
            int type = this.cHU.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString(str, this.cHU.bwx());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.cHV);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.cHW);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.cHX);
        if (this.cHT != null) {
            this.cHT.release();
        }
    }
}
