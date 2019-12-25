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
/* loaded from: classes5.dex */
public class c {
    private FloatingAnimationView fJT;
    private o fJU;
    private Runnable fJV = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.fJT != null && c.this.fJU != null) {
                c.this.fJT.setData(c.this.fJU.cII(), 100);
                c.this.fJT.playAnimation();
            }
        }
    };
    private Runnable fJW = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.fJT != null && c.this.fJU != null) {
                c.this.fJT.stopAnimation();
                c.this.fJT.setData(c.this.fJU.cIH());
            }
        }
    };
    private Runnable fJX = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.fJT != null && c.this.fJU != null) {
                c.this.fJT.tl(true);
                com.baidu.tbadk.core.sharedPref.b.aCY().putInt("key_collection_tag_state", 0);
            }
        }
    };
    private int mFrom;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.fJT = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.fJT.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void btC() {
                if (c.this.fJU != null && !aq.isEmpty(c.this.fJU.aVj())) {
                    TiebaStatic.log(new an("c12913").Z("obj_locate", 2).Z("obj_type", c.this.mFrom));
                    if (c.this.fJU.getType() == 2) {
                        c.this.fJT.tl(false);
                        com.baidu.tbadk.core.sharedPref.b.aCY().putInt("key_collection_tag_state", 1);
                    }
                    ba.aEa().b(c.this.mPageContext, new String[]{c.this.fJU.aVj()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void btD() {
                c.this.btB();
                c.this.onDestroy();
                c.this.fJT.setVisibility(8);
                TiebaStatic.log(new an("c12913").Z("obj_locate", 3).Z("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(o oVar) {
        if (this.fJT != null) {
            if (oVar == null || oVar.getType() == 0) {
                this.fJT.setVisibility(8);
                return;
            }
            this.fJU = oVar;
            if (this.fJU.getType() == 1) {
                btz();
            } else if (this.fJU.getType() == 2) {
                btA();
            }
            aXR();
        }
    }

    private void btz() {
        String lastId = getLastId();
        if (this.fJU == null || lastId.equals(this.fJU.cIJ()) || aq.isEmpty(this.fJU.aVj()) || aq.isEmpty(this.fJU.cIH())) {
            this.fJT.setVisibility(8);
            return;
        }
        if (this.fJT.getVisibility() != 0) {
            TiebaStatic.log(new an("c12912").Z("obj_locate", this.mFrom));
        }
        this.fJT.setVisibility(0);
        this.fJT.setData(this.fJU.cIH());
        if (this.fJU.getStartTime() > 0 && this.fJU.getEndTime() > 0 && this.fJU.getEndTime() > this.fJU.getStartTime() && !v.isEmpty(this.fJU.cII())) {
            com.baidu.adp.lib.f.e.gy().removeCallbacks(this.fJV);
            com.baidu.adp.lib.f.e.gy().removeCallbacks(this.fJW);
            com.baidu.adp.lib.f.e.gy().postDelayed(this.fJV, this.fJU.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.f.e.gy().postDelayed(this.fJW, this.fJU.getEndTime() - System.currentTimeMillis());
        }
    }

    private void btA() {
        String lastId = getLastId();
        if (this.fJU == null || lastId.equals(this.fJU.cIJ()) || aq.isEmpty(this.fJU.aVj()) || aq.isEmpty(this.fJU.cIH())) {
            this.fJT.setVisibility(8);
            return;
        }
        this.fJT.setVisibility(0);
        this.fJT.setData(this.fJU.cIH());
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.fJX);
        com.baidu.adp.lib.f.e.gy().postDelayed(this.fJX, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void aXR() {
        if (this.fJT != null && this.fJU != null) {
            if (getLastId().equals(this.fJU.cIJ())) {
                this.fJT.setVisibility(8);
            }
            if (this.fJU.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.aCY().getInt("key_collection_tag_state", 0) == 1) {
                    this.fJT.tl(false);
                } else {
                    this.fJT.tl(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.fJU == null) {
            return "";
        }
        int type = this.fJU.getType();
        if (this.mFrom == 1) {
            str = "key_redpacket_float_maintab_last_id_" + type;
        } else {
            str = "key_redpacket_float_frs_last_id_" + type;
        }
        return com.baidu.tbadk.core.sharedPref.b.aCY().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btB() {
        String str;
        if (this.fJU != null) {
            int type = this.fJU.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.aCY().putString(str, this.fJU.cIJ());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.fJV);
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.fJW);
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.fJX);
        if (this.fJT != null) {
            this.fJT.release();
        }
    }
}
