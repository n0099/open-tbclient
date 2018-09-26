package com.baidu.tieba.c;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.tbadkCore.data.m;
import com.baidu.tieba.view.FloatingAnimationView;
/* loaded from: classes.dex */
public class c {
    private FloatingAnimationView cNK;
    private m cNL;
    private Runnable cNM = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.cNK != null && c.this.cNL != null) {
                c.this.cNK.setData(c.this.cNL.bza(), 100);
                c.this.cNK.ce();
            }
        }
    };
    private Runnable cNN = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.cNK != null && c.this.cNL != null) {
                c.this.cNK.stopAnimation();
                c.this.cNK.setData(c.this.cNL.byZ());
            }
        }
    };
    private Runnable cNO = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.cNK != null && c.this.cNL != null) {
                c.this.cNK.nF(true);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_collection_tag_state", 0);
            }
        }
    };
    private int mFrom;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.cNK = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.cNK.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void amw() {
                if (c.this.cNL != null && !ao.isEmpty(c.this.cNL.SP())) {
                    TiebaStatic.log(new am("c12913").w("obj_locate", 2).w("obj_type", c.this.mFrom));
                    if (c.this.cNL.getType() == 2) {
                        c.this.cNK.nF(false);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_collection_tag_state", 1);
                    }
                    ay.AN().c(c.this.mPageContext, new String[]{c.this.cNL.SP()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void amx() {
                c.this.amv();
                c.this.onDestroy();
                c.this.cNK.setVisibility(8);
                TiebaStatic.log(new am("c12913").w("obj_locate", 3).w("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(m mVar) {
        if (this.cNK != null) {
            if (mVar == null || mVar.getType() == 0) {
                this.cNK.setVisibility(8);
                return;
            }
            this.cNL = mVar;
            if (this.cNL.getType() == 1) {
                ams();
            } else if (this.cNL.getType() == 2) {
                amt();
            }
            amu();
        }
    }

    private void ams() {
        String lastId = getLastId();
        if (this.cNL == null || lastId.equals(this.cNL.bzb()) || ao.isEmpty(this.cNL.SP()) || ao.isEmpty(this.cNL.byZ())) {
            this.cNK.setVisibility(8);
            return;
        }
        if (this.cNK.getVisibility() != 0) {
            TiebaStatic.log(new am("c12912").w("obj_locate", this.mFrom));
        }
        this.cNK.setVisibility(0);
        this.cNK.setData(this.cNL.byZ());
        if (this.cNL.getStartTime() > 0 && this.cNL.getEndTime() > 0 && this.cNL.getEndTime() > this.cNL.getStartTime() && !v.z(this.cNL.bza())) {
            com.baidu.adp.lib.g.e.jt().removeCallbacks(this.cNM);
            com.baidu.adp.lib.g.e.jt().removeCallbacks(this.cNN);
            com.baidu.adp.lib.g.e.jt().postDelayed(this.cNM, this.cNL.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.g.e.jt().postDelayed(this.cNN, this.cNL.getEndTime() - System.currentTimeMillis());
        }
    }

    private void amt() {
        String lastId = getLastId();
        if (this.cNL == null || lastId.equals(this.cNL.bzb()) || ao.isEmpty(this.cNL.SP()) || ao.isEmpty(this.cNL.byZ())) {
            this.cNK.setVisibility(8);
            return;
        }
        this.cNK.setVisibility(0);
        this.cNK.setData(this.cNL.byZ());
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.cNO);
        com.baidu.adp.lib.g.e.jt().postDelayed(this.cNO, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void amu() {
        if (this.cNK != null && this.cNL != null) {
            if (getLastId().equals(this.cNL.bzb())) {
                this.cNK.setVisibility(8);
            }
            if (this.cNL.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_collection_tag_state", 0) == 1) {
                    this.cNK.nF(false);
                } else {
                    this.cNK.nF(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.cNL == null) {
            return "";
        }
        int type = this.cNL.getType();
        if (this.mFrom == 1) {
            str = "key_redpacket_float_maintab_last_id_" + type;
        } else {
            str = "key_redpacket_float_frs_last_id_" + type;
        }
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amv() {
        String str;
        if (this.cNL != null) {
            int type = this.cNL.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString(str, this.cNL.bzb());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.cNM);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.cNN);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.cNO);
        if (this.cNK != null) {
            this.cNK.release();
        }
    }
}
