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
    private FloatingAnimationView eGM;
    private o eGN;
    private Runnable eGO = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.eGM != null && c.this.eGN != null) {
                c.this.eGM.setData(c.this.eGN.cmM(), 100);
                c.this.eGM.bo();
            }
        }
    };
    private Runnable eGP = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.eGM != null && c.this.eGN != null) {
                c.this.eGM.stopAnimation();
                c.this.eGM.setData(c.this.eGN.cmL());
            }
        }
    };
    private Runnable eGQ = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.eGM != null && c.this.eGN != null) {
                c.this.eGM.rF(true);
                com.baidu.tbadk.core.sharedPref.b.agM().putInt("key_collection_tag_state", 0);
            }
        }
    };
    private int mFrom;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.eGM = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.eGM.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void aZx() {
                if (c.this.eGN != null && !ap.isEmpty(c.this.eGN.aBE())) {
                    TiebaStatic.log(new am("c12913").P("obj_locate", 2).P("obj_type", c.this.mFrom));
                    if (c.this.eGN.getType() == 2) {
                        c.this.eGM.rF(false);
                        com.baidu.tbadk.core.sharedPref.b.agM().putInt("key_collection_tag_state", 1);
                    }
                    ba.aiz().c(c.this.mPageContext, new String[]{c.this.eGN.aBE()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void aZy() {
                c.this.aZw();
                c.this.onDestroy();
                c.this.eGM.setVisibility(8);
                TiebaStatic.log(new am("c12913").P("obj_locate", 3).P("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(o oVar) {
        if (this.eGM != null) {
            if (oVar == null || oVar.getType() == 0) {
                this.eGM.setVisibility(8);
                return;
            }
            this.eGN = oVar;
            if (this.eGN.getType() == 1) {
                aZu();
            } else if (this.eGN.getType() == 2) {
                aZv();
            }
            aFu();
        }
    }

    private void aZu() {
        String lastId = getLastId();
        if (this.eGN == null || lastId.equals(this.eGN.cmN()) || ap.isEmpty(this.eGN.aBE()) || ap.isEmpty(this.eGN.cmL())) {
            this.eGM.setVisibility(8);
            return;
        }
        if (this.eGM.getVisibility() != 0) {
            TiebaStatic.log(new am("c12912").P("obj_locate", this.mFrom));
        }
        this.eGM.setVisibility(0);
        this.eGM.setData(this.eGN.cmL());
        if (this.eGN.getStartTime() > 0 && this.eGN.getEndTime() > 0 && this.eGN.getEndTime() > this.eGN.getStartTime() && !v.aa(this.eGN.cmM())) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.eGO);
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.eGP);
            com.baidu.adp.lib.g.e.iB().postDelayed(this.eGO, this.eGN.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.g.e.iB().postDelayed(this.eGP, this.eGN.getEndTime() - System.currentTimeMillis());
        }
    }

    private void aZv() {
        String lastId = getLastId();
        if (this.eGN == null || lastId.equals(this.eGN.cmN()) || ap.isEmpty(this.eGN.aBE()) || ap.isEmpty(this.eGN.cmL())) {
            this.eGM.setVisibility(8);
            return;
        }
        this.eGM.setVisibility(0);
        this.eGM.setData(this.eGN.cmL());
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.eGQ);
        com.baidu.adp.lib.g.e.iB().postDelayed(this.eGQ, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void aFu() {
        if (this.eGM != null && this.eGN != null) {
            if (getLastId().equals(this.eGN.cmN())) {
                this.eGM.setVisibility(8);
            }
            if (this.eGN.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_collection_tag_state", 0) == 1) {
                    this.eGM.rF(false);
                } else {
                    this.eGM.rF(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.eGN == null) {
            return "";
        }
        int type = this.eGN.getType();
        if (this.mFrom == 1) {
            str = "key_redpacket_float_maintab_last_id_" + type;
        } else {
            str = "key_redpacket_float_frs_last_id_" + type;
        }
        return com.baidu.tbadk.core.sharedPref.b.agM().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZw() {
        String str;
        if (this.eGN != null) {
            int type = this.eGN.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.agM().putString(str, this.eGN.cmN());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.eGO);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.eGP);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.eGQ);
        if (this.eGM != null) {
            this.eGM.release();
        }
    }
}
