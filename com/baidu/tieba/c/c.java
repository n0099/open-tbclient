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
/* loaded from: classes6.dex */
public class c {
    private FloatingAnimationView fNc;
    private o fNd;
    private Runnable fNe = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.fNc != null && c.this.fNd != null) {
                c.this.fNc.setData(c.this.fNd.cJM(), 100);
                c.this.fNc.playAnimation();
            }
        }
    };
    private Runnable fNf = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.fNc != null && c.this.fNd != null) {
                c.this.fNc.stopAnimation();
                c.this.fNc.setData(c.this.fNd.cJL());
            }
        }
    };
    private Runnable fNg = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.fNc != null && c.this.fNd != null) {
                c.this.fNc.tx(true);
                com.baidu.tbadk.core.sharedPref.b.aDr().putInt("key_collection_tag_state", 0);
            }
        }
    };
    private int mFrom;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.fNc = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.fNc.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void buE() {
                if (c.this.fNd != null && !aq.isEmpty(c.this.fNd.aVC())) {
                    TiebaStatic.log(new an("c12913").Z("obj_locate", 2).Z("obj_type", c.this.mFrom));
                    if (c.this.fNd.getType() == 2) {
                        c.this.fNc.tx(false);
                        com.baidu.tbadk.core.sharedPref.b.aDr().putInt("key_collection_tag_state", 1);
                    }
                    ba.aEt().b(c.this.mPageContext, new String[]{c.this.fNd.aVC()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void buF() {
                c.this.buD();
                c.this.onDestroy();
                c.this.fNc.setVisibility(8);
                TiebaStatic.log(new an("c12913").Z("obj_locate", 3).Z("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(o oVar) {
        if (this.fNc != null) {
            if (oVar == null || oVar.getType() == 0) {
                this.fNc.setVisibility(8);
                return;
            }
            this.fNd = oVar;
            if (this.fNd.getType() == 1) {
                buB();
            } else if (this.fNd.getType() == 2) {
                buC();
            }
            aYl();
        }
    }

    private void buB() {
        String lastId = getLastId();
        if (this.fNd == null || lastId.equals(this.fNd.cJN()) || aq.isEmpty(this.fNd.aVC()) || aq.isEmpty(this.fNd.cJL())) {
            this.fNc.setVisibility(8);
            return;
        }
        if (this.fNc.getVisibility() != 0) {
            TiebaStatic.log(new an("c12912").Z("obj_locate", this.mFrom));
        }
        this.fNc.setVisibility(0);
        this.fNc.setData(this.fNd.cJL());
        if (this.fNd.getStartTime() > 0 && this.fNd.getEndTime() > 0 && this.fNd.getEndTime() > this.fNd.getStartTime() && !v.isEmpty(this.fNd.cJM())) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fNe);
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fNf);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.fNe, this.fNd.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.f.e.gx().postDelayed(this.fNf, this.fNd.getEndTime() - System.currentTimeMillis());
        }
    }

    private void buC() {
        String lastId = getLastId();
        if (this.fNd == null || lastId.equals(this.fNd.cJN()) || aq.isEmpty(this.fNd.aVC()) || aq.isEmpty(this.fNd.cJL())) {
            this.fNc.setVisibility(8);
            return;
        }
        this.fNc.setVisibility(0);
        this.fNc.setData(this.fNd.cJL());
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fNg);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.fNg, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void aYl() {
        if (this.fNc != null && this.fNd != null) {
            if (getLastId().equals(this.fNd.cJN())) {
                this.fNc.setVisibility(8);
            }
            if (this.fNd.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.aDr().getInt("key_collection_tag_state", 0) == 1) {
                    this.fNc.tx(false);
                } else {
                    this.fNc.tx(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.fNd == null) {
            return "";
        }
        int type = this.fNd.getType();
        if (this.mFrom == 1) {
            str = "key_redpacket_float_maintab_last_id_" + type;
        } else {
            str = "key_redpacket_float_frs_last_id_" + type;
        }
        return com.baidu.tbadk.core.sharedPref.b.aDr().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buD() {
        String str;
        if (this.fNd != null) {
            int type = this.fNd.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.aDr().putString(str, this.fNd.cJN());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fNe);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fNf);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fNg);
        if (this.fNc != null) {
            this.fNc.release();
        }
    }
}
