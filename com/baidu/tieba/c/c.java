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
    private FloatingAnimationView eLP;
    private o eLQ;
    private Runnable eLR = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.eLP != null && c.this.eLQ != null) {
                c.this.eLP.setData(c.this.eLQ.cqa(), 100);
                c.this.eLP.br();
            }
        }
    };
    private Runnable eLS = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.eLP != null && c.this.eLQ != null) {
                c.this.eLP.stopAnimation();
                c.this.eLP.setData(c.this.eLQ.cpZ());
            }
        }
    };
    private Runnable eLT = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.eLP != null && c.this.eLQ != null) {
                c.this.eLP.rT(true);
                com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("key_collection_tag_state", 0);
            }
        }
    };
    private int mFrom;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.eLP = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.eLP.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void bby() {
                if (c.this.eLQ != null && !aq.isEmpty(c.this.eLQ.aCV())) {
                    TiebaStatic.log(new an("c12913").P("obj_locate", 2).P("obj_type", c.this.mFrom));
                    if (c.this.eLQ.getType() == 2) {
                        c.this.eLP.rT(false);
                        com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("key_collection_tag_state", 1);
                    }
                    bb.ajE().c(c.this.mPageContext, new String[]{c.this.eLQ.aCV()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void bbz() {
                c.this.bbx();
                c.this.onDestroy();
                c.this.eLP.setVisibility(8);
                TiebaStatic.log(new an("c12913").P("obj_locate", 3).P("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(o oVar) {
        if (this.eLP != null) {
            if (oVar == null || oVar.getType() == 0) {
                this.eLP.setVisibility(8);
                return;
            }
            this.eLQ = oVar;
            if (this.eLQ.getType() == 1) {
                bbv();
            } else if (this.eLQ.getType() == 2) {
                bbw();
            }
            aGS();
        }
    }

    private void bbv() {
        String lastId = getLastId();
        if (this.eLQ == null || lastId.equals(this.eLQ.cqb()) || aq.isEmpty(this.eLQ.aCV()) || aq.isEmpty(this.eLQ.cpZ())) {
            this.eLP.setVisibility(8);
            return;
        }
        if (this.eLP.getVisibility() != 0) {
            TiebaStatic.log(new an("c12912").P("obj_locate", this.mFrom));
        }
        this.eLP.setVisibility(0);
        this.eLP.setData(this.eLQ.cpZ());
        if (this.eLQ.getStartTime() > 0 && this.eLQ.getEndTime() > 0 && this.eLQ.getEndTime() > this.eLQ.getStartTime() && !v.aa(this.eLQ.cqa())) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.eLR);
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.eLS);
            com.baidu.adp.lib.g.e.iK().postDelayed(this.eLR, this.eLQ.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.g.e.iK().postDelayed(this.eLS, this.eLQ.getEndTime() - System.currentTimeMillis());
        }
    }

    private void bbw() {
        String lastId = getLastId();
        if (this.eLQ == null || lastId.equals(this.eLQ.cqb()) || aq.isEmpty(this.eLQ.aCV()) || aq.isEmpty(this.eLQ.cpZ())) {
            this.eLP.setVisibility(8);
            return;
        }
        this.eLP.setVisibility(0);
        this.eLP.setData(this.eLQ.cpZ());
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.eLT);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.eLT, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void aGS() {
        if (this.eLP != null && this.eLQ != null) {
            if (getLastId().equals(this.eLQ.cqb())) {
                this.eLP.setVisibility(8);
            }
            if (this.eLQ.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("key_collection_tag_state", 0) == 1) {
                    this.eLP.rT(false);
                } else {
                    this.eLP.rT(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.eLQ == null) {
            return "";
        }
        int type = this.eLQ.getType();
        if (this.mFrom == 1) {
            str = "key_redpacket_float_maintab_last_id_" + type;
        } else {
            str = "key_redpacket_float_frs_last_id_" + type;
        }
        return com.baidu.tbadk.core.sharedPref.b.ahQ().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbx() {
        String str;
        if (this.eLQ != null) {
            int type = this.eLQ.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.ahQ().putString(str, this.eLQ.cqb());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.eLR);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.eLS);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.eLT);
        if (this.eLP != null) {
            this.eLP.release();
        }
    }
}
