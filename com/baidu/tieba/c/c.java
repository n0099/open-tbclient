package com.baidu.tieba.c;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.tbadkCore.data.o;
import com.baidu.tieba.view.FloatingAnimationView;
/* loaded from: classes3.dex */
public class c {
    private FloatingAnimationView eLI;
    private o eLJ;
    private Runnable eLK = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.eLI != null && c.this.eLJ != null) {
                c.this.eLI.setData(c.this.eLJ.cpE(), 100);
                c.this.eLI.br();
            }
        }
    };
    private Runnable eLL = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.eLI != null && c.this.eLJ != null) {
                c.this.eLI.stopAnimation();
                c.this.eLI.setData(c.this.eLJ.cpD());
            }
        }
    };
    private Runnable eLM = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.eLI != null && c.this.eLJ != null) {
                c.this.eLI.rS(true);
                com.baidu.tbadk.core.sharedPref.b.ahO().putInt("key_collection_tag_state", 0);
            }
        }
    };
    private int mFrom;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.eLI = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.eLI.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void bbw() {
                if (c.this.eLJ != null && !aq.isEmpty(c.this.eLJ.aCT())) {
                    TiebaStatic.log(new an("c12913").P("obj_locate", 2).P("obj_type", c.this.mFrom));
                    if (c.this.eLJ.getType() == 2) {
                        c.this.eLI.rS(false);
                        com.baidu.tbadk.core.sharedPref.b.ahO().putInt("key_collection_tag_state", 1);
                    }
                    bb.ajC().c(c.this.mPageContext, new String[]{c.this.eLJ.aCT()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void bbx() {
                c.this.bbv();
                c.this.onDestroy();
                c.this.eLI.setVisibility(8);
                TiebaStatic.log(new an("c12913").P("obj_locate", 3).P("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(o oVar) {
        if (this.eLI != null) {
            if (oVar == null || oVar.getType() == 0) {
                this.eLI.setVisibility(8);
                return;
            }
            this.eLJ = oVar;
            if (this.eLJ.getType() == 1) {
                bbt();
            } else if (this.eLJ.getType() == 2) {
                bbu();
            }
            aGQ();
        }
    }

    private void bbt() {
        String lastId = getLastId();
        if (this.eLJ == null || lastId.equals(this.eLJ.cpF()) || aq.isEmpty(this.eLJ.aCT()) || aq.isEmpty(this.eLJ.cpD())) {
            this.eLI.setVisibility(8);
            return;
        }
        if (this.eLI.getVisibility() != 0) {
            TiebaStatic.log(new an("c12912").P("obj_locate", this.mFrom));
        }
        this.eLI.setVisibility(0);
        this.eLI.setData(this.eLJ.cpD());
        if (this.eLJ.getStartTime() > 0 && this.eLJ.getEndTime() > 0 && this.eLJ.getEndTime() > this.eLJ.getStartTime() && !v.aa(this.eLJ.cpE())) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.eLK);
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.eLL);
            com.baidu.adp.lib.g.e.iK().postDelayed(this.eLK, this.eLJ.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.g.e.iK().postDelayed(this.eLL, this.eLJ.getEndTime() - System.currentTimeMillis());
        }
    }

    private void bbu() {
        String lastId = getLastId();
        if (this.eLJ == null || lastId.equals(this.eLJ.cpF()) || aq.isEmpty(this.eLJ.aCT()) || aq.isEmpty(this.eLJ.cpD())) {
            this.eLI.setVisibility(8);
            return;
        }
        this.eLI.setVisibility(0);
        this.eLI.setData(this.eLJ.cpD());
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.eLM);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.eLM, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void aGQ() {
        if (this.eLI != null && this.eLJ != null) {
            if (getLastId().equals(this.eLJ.cpF())) {
                this.eLI.setVisibility(8);
            }
            if (this.eLJ.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.ahO().getInt("key_collection_tag_state", 0) == 1) {
                    this.eLI.rS(false);
                } else {
                    this.eLI.rS(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.eLJ == null) {
            return "";
        }
        int type = this.eLJ.getType();
        if (this.mFrom == 1) {
            str = "key_redpacket_float_maintab_last_id_" + type;
        } else {
            str = "key_redpacket_float_frs_last_id_" + type;
        }
        return com.baidu.tbadk.core.sharedPref.b.ahO().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbv() {
        String str;
        if (this.eLJ != null) {
            int type = this.eLJ.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.ahO().putString(str, this.eLJ.cpF());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.eLK);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.eLL);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.eLM);
        if (this.eLI != null) {
            this.eLI.release();
        }
    }
}
