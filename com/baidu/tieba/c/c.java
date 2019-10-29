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
/* loaded from: classes3.dex */
public class c {
    private FloatingAnimationView eWd;
    private o eWe;
    private Runnable eWf = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.eWd != null && c.this.eWe != null) {
                c.this.eWd.setData(c.this.eWe.coE(), 100);
                c.this.eWd.playAnimation();
            }
        }
    };
    private Runnable eWg = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.eWd != null && c.this.eWe != null) {
                c.this.eWd.stopAnimation();
                c.this.eWd.setData(c.this.eWe.coD());
            }
        }
    };
    private Runnable eWh = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.eWd != null && c.this.eWe != null) {
                c.this.eWd.rF(true);
                com.baidu.tbadk.core.sharedPref.b.alR().putInt("key_collection_tag_state", 0);
            }
        }
    };
    private int mFrom;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.eWd = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.eWd.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void bch() {
                if (c.this.eWe != null && !aq.isEmpty(c.this.eWe.aDs())) {
                    TiebaStatic.log(new an("c12913").O("obj_locate", 2).O("obj_type", c.this.mFrom));
                    if (c.this.eWe.getType() == 2) {
                        c.this.eWd.rF(false);
                        com.baidu.tbadk.core.sharedPref.b.alR().putInt("key_collection_tag_state", 1);
                    }
                    ba.amQ().b(c.this.mPageContext, new String[]{c.this.eWe.aDs()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void bci() {
                c.this.bcg();
                c.this.onDestroy();
                c.this.eWd.setVisibility(8);
                TiebaStatic.log(new an("c12913").O("obj_locate", 3).O("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(o oVar) {
        if (this.eWd != null) {
            if (oVar == null || oVar.getType() == 0) {
                this.eWd.setVisibility(8);
                return;
            }
            this.eWe = oVar;
            if (this.eWe.getType() == 1) {
                bce();
            } else if (this.eWe.getType() == 2) {
                bcf();
            }
            aHJ();
        }
    }

    private void bce() {
        String lastId = getLastId();
        if (this.eWe == null || lastId.equals(this.eWe.coF()) || aq.isEmpty(this.eWe.aDs()) || aq.isEmpty(this.eWe.coD())) {
            this.eWd.setVisibility(8);
            return;
        }
        if (this.eWd.getVisibility() != 0) {
            TiebaStatic.log(new an("c12912").O("obj_locate", this.mFrom));
        }
        this.eWd.setVisibility(0);
        this.eWd.setData(this.eWe.coD());
        if (this.eWe.getStartTime() > 0 && this.eWe.getEndTime() > 0 && this.eWe.getEndTime() > this.eWe.getStartTime() && !v.isEmpty(this.eWe.coE())) {
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.eWf);
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.eWg);
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.eWf, this.eWe.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.eWg, this.eWe.getEndTime() - System.currentTimeMillis());
        }
    }

    private void bcf() {
        String lastId = getLastId();
        if (this.eWe == null || lastId.equals(this.eWe.coF()) || aq.isEmpty(this.eWe.aDs()) || aq.isEmpty(this.eWe.coD())) {
            this.eWd.setVisibility(8);
            return;
        }
        this.eWd.setVisibility(0);
        this.eWd.setData(this.eWe.coD());
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.eWh);
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.eWh, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void aHJ() {
        if (this.eWd != null && this.eWe != null) {
            if (getLastId().equals(this.eWe.coF())) {
                this.eWd.setVisibility(8);
            }
            if (this.eWe.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.alR().getInt("key_collection_tag_state", 0) == 1) {
                    this.eWd.rF(false);
                } else {
                    this.eWd.rF(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.eWe == null) {
            return "";
        }
        int type = this.eWe.getType();
        if (this.mFrom == 1) {
            str = "key_redpacket_float_maintab_last_id_" + type;
        } else {
            str = "key_redpacket_float_frs_last_id_" + type;
        }
        return com.baidu.tbadk.core.sharedPref.b.alR().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcg() {
        String str;
        if (this.eWe != null) {
            int type = this.eWe.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.alR().putString(str, this.eWe.coF());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.eWf);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.eWg);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.eWh);
        if (this.eWd != null) {
            this.eWd.release();
        }
    }
}
