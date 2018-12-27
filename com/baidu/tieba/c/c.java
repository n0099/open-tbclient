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
    private FloatingAnimationView dgJ;
    private m dgK;
    private Runnable dgL = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dgJ != null && c.this.dgK != null) {
                c.this.dgJ.setData(c.this.dgK.bEx(), 100);
                c.this.dgJ.cv();
            }
        }
    };
    private Runnable dgM = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dgJ != null && c.this.dgK != null) {
                c.this.dgJ.stopAnimation();
                c.this.dgJ.setData(c.this.dgK.bEw());
            }
        }
    };
    private Runnable dgN = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dgJ != null && c.this.dgK != null) {
                c.this.dgJ.oo(true);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_collection_tag_state", 0);
            }
        }
    };
    private int mFrom;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.dgJ = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.dgJ.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void arY() {
                if (c.this.dgK != null && !ao.isEmpty(c.this.dgK.Wc())) {
                    TiebaStatic.log(new am("c12913").x("obj_locate", 2).x("obj_type", c.this.mFrom));
                    if (c.this.dgK.getType() == 2) {
                        c.this.dgJ.oo(false);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_collection_tag_state", 1);
                    }
                    ay.Ef().c(c.this.mPageContext, new String[]{c.this.dgK.Wc()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void arZ() {
                c.this.arX();
                c.this.onDestroy();
                c.this.dgJ.setVisibility(8);
                TiebaStatic.log(new am("c12913").x("obj_locate", 3).x("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(m mVar) {
        if (this.dgJ != null) {
            if (mVar == null || mVar.getType() == 0) {
                this.dgJ.setVisibility(8);
                return;
            }
            this.dgK = mVar;
            if (this.dgK.getType() == 1) {
                arU();
            } else if (this.dgK.getType() == 2) {
                arV();
            }
            arW();
        }
    }

    private void arU() {
        String lastId = getLastId();
        if (this.dgK == null || lastId.equals(this.dgK.bEy()) || ao.isEmpty(this.dgK.Wc()) || ao.isEmpty(this.dgK.bEw())) {
            this.dgJ.setVisibility(8);
            return;
        }
        if (this.dgJ.getVisibility() != 0) {
            TiebaStatic.log(new am("c12912").x("obj_locate", this.mFrom));
        }
        this.dgJ.setVisibility(0);
        this.dgJ.setData(this.dgK.bEw());
        if (this.dgK.getStartTime() > 0 && this.dgK.getEndTime() > 0 && this.dgK.getEndTime() > this.dgK.getStartTime() && !v.I(this.dgK.bEx())) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dgL);
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dgM);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.dgL, this.dgK.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.g.e.jG().postDelayed(this.dgM, this.dgK.getEndTime() - System.currentTimeMillis());
        }
    }

    private void arV() {
        String lastId = getLastId();
        if (this.dgK == null || lastId.equals(this.dgK.bEy()) || ao.isEmpty(this.dgK.Wc()) || ao.isEmpty(this.dgK.bEw())) {
            this.dgJ.setVisibility(8);
            return;
        }
        this.dgJ.setVisibility(0);
        this.dgJ.setData(this.dgK.bEw());
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dgN);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.dgN, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void arW() {
        if (this.dgJ != null && this.dgK != null) {
            if (getLastId().equals(this.dgK.bEy())) {
                this.dgJ.setVisibility(8);
            }
            if (this.dgK.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_collection_tag_state", 0) == 1) {
                    this.dgJ.oo(false);
                } else {
                    this.dgJ.oo(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.dgK == null) {
            return "";
        }
        int type = this.dgK.getType();
        if (this.mFrom == 1) {
            str = "key_redpacket_float_maintab_last_id_" + type;
        } else {
            str = "key_redpacket_float_frs_last_id_" + type;
        }
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arX() {
        String str;
        if (this.dgK != null) {
            int type = this.dgK.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString(str, this.dgK.bEy());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dgL);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dgM);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dgN);
        if (this.dgJ != null) {
            this.dgJ.release();
        }
    }
}
