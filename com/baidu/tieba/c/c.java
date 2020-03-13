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
    private FloatingAnimationView fPM;
    private o fPN;
    private Runnable fPO = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.fPM != null && c.this.fPN != null) {
                c.this.fPM.setData(c.this.fPN.cLq(), 100);
                c.this.fPM.playAnimation();
            }
        }
    };
    private Runnable fPP = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.fPM != null && c.this.fPN != null) {
                c.this.fPM.stopAnimation();
                c.this.fPM.setData(c.this.fPN.cLp());
            }
        }
    };
    private Runnable fPQ = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.fPM != null && c.this.fPN != null) {
                c.this.fPM.tB(true);
                com.baidu.tbadk.core.sharedPref.b.aFD().putInt("key_collection_tag_state", 0);
            }
        }
    };
    private int mFrom;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.fPM = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.fPM.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void bwl() {
                if (c.this.fPN != null && !aq.isEmpty(c.this.fPN.aXU())) {
                    TiebaStatic.log(new an("c12913").X("obj_locate", 2).X("obj_type", c.this.mFrom));
                    if (c.this.fPN.getType() == 2) {
                        c.this.fPM.tB(false);
                        com.baidu.tbadk.core.sharedPref.b.aFD().putInt("key_collection_tag_state", 1);
                    }
                    ba.aGG().b(c.this.mPageContext, new String[]{c.this.fPN.aXU()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void bwm() {
                c.this.bwk();
                c.this.onDestroy();
                c.this.fPM.setVisibility(8);
                TiebaStatic.log(new an("c12913").X("obj_locate", 3).X("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(o oVar) {
        if (this.fPM != null) {
            if (oVar == null || oVar.getType() == 0) {
                this.fPM.setVisibility(8);
                return;
            }
            this.fPN = oVar;
            if (this.fPN.getType() == 1) {
                bwi();
            } else if (this.fPN.getType() == 2) {
                bwj();
            }
            baD();
        }
    }

    private void bwi() {
        String lastId = getLastId();
        if (this.fPN == null || lastId.equals(this.fPN.gL()) || aq.isEmpty(this.fPN.aXU()) || aq.isEmpty(this.fPN.cLp())) {
            this.fPM.setVisibility(8);
            return;
        }
        if (this.fPM.getVisibility() != 0) {
            TiebaStatic.log(new an("c12912").X("obj_locate", this.mFrom));
        }
        this.fPM.setVisibility(0);
        this.fPM.setData(this.fPN.cLp());
        if (this.fPN.getStartTime() > 0 && this.fPN.getEndTime() > 0 && this.fPN.getEndTime() > this.fPN.getStartTime() && !v.isEmpty(this.fPN.cLq())) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fPO);
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fPP);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.fPO, this.fPN.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.f.e.gx().postDelayed(this.fPP, this.fPN.getEndTime() - System.currentTimeMillis());
        }
    }

    private void bwj() {
        String lastId = getLastId();
        if (this.fPN == null || lastId.equals(this.fPN.gL()) || aq.isEmpty(this.fPN.aXU()) || aq.isEmpty(this.fPN.cLp())) {
            this.fPM.setVisibility(8);
            return;
        }
        this.fPM.setVisibility(0);
        this.fPM.setData(this.fPN.cLp());
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fPQ);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.fPQ, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void baD() {
        if (this.fPM != null && this.fPN != null) {
            if (getLastId().equals(this.fPN.gL())) {
                this.fPM.setVisibility(8);
            }
            if (this.fPN.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.aFD().getInt("key_collection_tag_state", 0) == 1) {
                    this.fPM.tB(false);
                } else {
                    this.fPM.tB(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.fPN == null) {
            return "";
        }
        int type = this.fPN.getType();
        if (this.mFrom == 1) {
            str = "key_redpacket_float_maintab_last_id_" + type;
        } else {
            str = "key_redpacket_float_frs_last_id_" + type;
        }
        return com.baidu.tbadk.core.sharedPref.b.aFD().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwk() {
        String str;
        if (this.fPN != null) {
            int type = this.fPN.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.aFD().putString(str, this.fPN.gL());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fPO);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fPP);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fPQ);
        if (this.fPM != null) {
            this.fPM.release();
        }
    }
}
