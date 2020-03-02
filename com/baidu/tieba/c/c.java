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
    private o fPA;
    private Runnable fPB = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.fPz != null && c.this.fPA != null) {
                c.this.fPz.setData(c.this.fPA.cLp(), 100);
                c.this.fPz.playAnimation();
            }
        }
    };
    private Runnable fPC = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.fPz != null && c.this.fPA != null) {
                c.this.fPz.stopAnimation();
                c.this.fPz.setData(c.this.fPA.cLo());
            }
        }
    };
    private Runnable fPD = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.fPz != null && c.this.fPA != null) {
                c.this.fPz.tB(true);
                com.baidu.tbadk.core.sharedPref.b.aFD().putInt("key_collection_tag_state", 0);
            }
        }
    };
    private FloatingAnimationView fPz;
    private int mFrom;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.fPz = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.fPz.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void bwk() {
                if (c.this.fPA != null && !aq.isEmpty(c.this.fPA.aXT())) {
                    TiebaStatic.log(new an("c12913").X("obj_locate", 2).X("obj_type", c.this.mFrom));
                    if (c.this.fPA.getType() == 2) {
                        c.this.fPz.tB(false);
                        com.baidu.tbadk.core.sharedPref.b.aFD().putInt("key_collection_tag_state", 1);
                    }
                    ba.aGG().b(c.this.mPageContext, new String[]{c.this.fPA.aXT()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void bwl() {
                c.this.bwj();
                c.this.onDestroy();
                c.this.fPz.setVisibility(8);
                TiebaStatic.log(new an("c12913").X("obj_locate", 3).X("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(o oVar) {
        if (this.fPz != null) {
            if (oVar == null || oVar.getType() == 0) {
                this.fPz.setVisibility(8);
                return;
            }
            this.fPA = oVar;
            if (this.fPA.getType() == 1) {
                bwh();
            } else if (this.fPA.getType() == 2) {
                bwi();
            }
            baC();
        }
    }

    private void bwh() {
        String lastId = getLastId();
        if (this.fPA == null || lastId.equals(this.fPA.gL()) || aq.isEmpty(this.fPA.aXT()) || aq.isEmpty(this.fPA.cLo())) {
            this.fPz.setVisibility(8);
            return;
        }
        if (this.fPz.getVisibility() != 0) {
            TiebaStatic.log(new an("c12912").X("obj_locate", this.mFrom));
        }
        this.fPz.setVisibility(0);
        this.fPz.setData(this.fPA.cLo());
        if (this.fPA.getStartTime() > 0 && this.fPA.getEndTime() > 0 && this.fPA.getEndTime() > this.fPA.getStartTime() && !v.isEmpty(this.fPA.cLp())) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fPB);
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fPC);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.fPB, this.fPA.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.f.e.gx().postDelayed(this.fPC, this.fPA.getEndTime() - System.currentTimeMillis());
        }
    }

    private void bwi() {
        String lastId = getLastId();
        if (this.fPA == null || lastId.equals(this.fPA.gL()) || aq.isEmpty(this.fPA.aXT()) || aq.isEmpty(this.fPA.cLo())) {
            this.fPz.setVisibility(8);
            return;
        }
        this.fPz.setVisibility(0);
        this.fPz.setData(this.fPA.cLo());
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fPD);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.fPD, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void baC() {
        if (this.fPz != null && this.fPA != null) {
            if (getLastId().equals(this.fPA.gL())) {
                this.fPz.setVisibility(8);
            }
            if (this.fPA.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.aFD().getInt("key_collection_tag_state", 0) == 1) {
                    this.fPz.tB(false);
                } else {
                    this.fPz.tB(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.fPA == null) {
            return "";
        }
        int type = this.fPA.getType();
        if (this.mFrom == 1) {
            str = "key_redpacket_float_maintab_last_id_" + type;
        } else {
            str = "key_redpacket_float_frs_last_id_" + type;
        }
        return com.baidu.tbadk.core.sharedPref.b.aFD().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwj() {
        String str;
        if (this.fPA != null) {
            int type = this.fPA.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.aFD().putString(str, this.fPA.gL());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fPB);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fPC);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fPD);
        if (this.fPz != null) {
            this.fPz.release();
        }
    }
}
