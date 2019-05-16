package com.baidu.tieba.c;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.tbadkCore.data.o;
import com.baidu.tieba.view.FloatingAnimationView;
/* loaded from: classes3.dex */
public class c {
    private FloatingAnimationView eGL;
    private o eGM;
    private Runnable eGN = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.eGL != null && c.this.eGM != null) {
                c.this.eGL.setData(c.this.eGM.cmJ(), 100);
                c.this.eGL.bo();
            }
        }
    };
    private Runnable eGO = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.eGL != null && c.this.eGM != null) {
                c.this.eGL.stopAnimation();
                c.this.eGL.setData(c.this.eGM.cmI());
            }
        }
    };
    private Runnable eGP = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.eGL != null && c.this.eGM != null) {
                c.this.eGL.rE(true);
                com.baidu.tbadk.core.sharedPref.b.agM().putInt("key_collection_tag_state", 0);
            }
        }
    };
    private int mFrom;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.eGL = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.eGL.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void aZu() {
                if (c.this.eGM != null && !ap.isEmpty(c.this.eGM.aBB())) {
                    TiebaStatic.log(new am("c12913").P("obj_locate", 2).P("obj_type", c.this.mFrom));
                    if (c.this.eGM.getType() == 2) {
                        c.this.eGL.rE(false);
                        com.baidu.tbadk.core.sharedPref.b.agM().putInt("key_collection_tag_state", 1);
                    }
                    ba.aiz().c(c.this.mPageContext, new String[]{c.this.eGM.aBB()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void aZv() {
                c.this.aZt();
                c.this.onDestroy();
                c.this.eGL.setVisibility(8);
                TiebaStatic.log(new am("c12913").P("obj_locate", 3).P("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(o oVar) {
        if (this.eGL != null) {
            if (oVar == null || oVar.getType() == 0) {
                this.eGL.setVisibility(8);
                return;
            }
            this.eGM = oVar;
            if (this.eGM.getType() == 1) {
                aZr();
            } else if (this.eGM.getType() == 2) {
                aZs();
            }
            aFr();
        }
    }

    private void aZr() {
        String lastId = getLastId();
        if (this.eGM == null || lastId.equals(this.eGM.cmK()) || ap.isEmpty(this.eGM.aBB()) || ap.isEmpty(this.eGM.cmI())) {
            this.eGL.setVisibility(8);
            return;
        }
        if (this.eGL.getVisibility() != 0) {
            TiebaStatic.log(new am("c12912").P("obj_locate", this.mFrom));
        }
        this.eGL.setVisibility(0);
        this.eGL.setData(this.eGM.cmI());
        if (this.eGM.getStartTime() > 0 && this.eGM.getEndTime() > 0 && this.eGM.getEndTime() > this.eGM.getStartTime() && !v.aa(this.eGM.cmJ())) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.eGN);
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.eGO);
            com.baidu.adp.lib.g.e.iB().postDelayed(this.eGN, this.eGM.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.g.e.iB().postDelayed(this.eGO, this.eGM.getEndTime() - System.currentTimeMillis());
        }
    }

    private void aZs() {
        String lastId = getLastId();
        if (this.eGM == null || lastId.equals(this.eGM.cmK()) || ap.isEmpty(this.eGM.aBB()) || ap.isEmpty(this.eGM.cmI())) {
            this.eGL.setVisibility(8);
            return;
        }
        this.eGL.setVisibility(0);
        this.eGL.setData(this.eGM.cmI());
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.eGP);
        com.baidu.adp.lib.g.e.iB().postDelayed(this.eGP, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void aFr() {
        if (this.eGL != null && this.eGM != null) {
            if (getLastId().equals(this.eGM.cmK())) {
                this.eGL.setVisibility(8);
            }
            if (this.eGM.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_collection_tag_state", 0) == 1) {
                    this.eGL.rE(false);
                } else {
                    this.eGL.rE(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.eGM == null) {
            return "";
        }
        int type = this.eGM.getType();
        if (this.mFrom == 1) {
            str = "key_redpacket_float_maintab_last_id_" + type;
        } else {
            str = "key_redpacket_float_frs_last_id_" + type;
        }
        return com.baidu.tbadk.core.sharedPref.b.agM().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZt() {
        String str;
        if (this.eGM != null) {
            int type = this.eGM.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.agM().putString(str, this.eGM.cmK());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.eGN);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.eGO);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.eGP);
        if (this.eGL != null) {
            this.eGL.release();
        }
    }
}
