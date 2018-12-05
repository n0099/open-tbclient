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
    private FloatingAnimationView ddS;
    private m ddT;
    private Runnable ddU = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.ddS != null && c.this.ddT != null) {
                c.this.ddS.setData(c.this.ddT.bDG(), 100);
                c.this.ddS.cv();
            }
        }
    };
    private Runnable ddV = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.ddS != null && c.this.ddT != null) {
                c.this.ddS.stopAnimation();
                c.this.ddS.setData(c.this.ddT.bDF());
            }
        }
    };
    private Runnable ddW = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.ddS != null && c.this.ddT != null) {
                c.this.ddS.ol(true);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_collection_tag_state", 0);
            }
        }
    };
    private int mFrom;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.ddS = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.ddS.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void arj() {
                if (c.this.ddT != null && !ao.isEmpty(c.this.ddT.Wa())) {
                    TiebaStatic.log(new am("c12913").x("obj_locate", 2).x("obj_type", c.this.mFrom));
                    if (c.this.ddT.getType() == 2) {
                        c.this.ddS.ol(false);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_collection_tag_state", 1);
                    }
                    ay.Ef().c(c.this.mPageContext, new String[]{c.this.ddT.Wa()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void ark() {
                c.this.ari();
                c.this.onDestroy();
                c.this.ddS.setVisibility(8);
                TiebaStatic.log(new am("c12913").x("obj_locate", 3).x("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(m mVar) {
        if (this.ddS != null) {
            if (mVar == null || mVar.getType() == 0) {
                this.ddS.setVisibility(8);
                return;
            }
            this.ddT = mVar;
            if (this.ddT.getType() == 1) {
                arf();
            } else if (this.ddT.getType() == 2) {
                arg();
            }
            arh();
        }
    }

    private void arf() {
        String lastId = getLastId();
        if (this.ddT == null || lastId.equals(this.ddT.bDH()) || ao.isEmpty(this.ddT.Wa()) || ao.isEmpty(this.ddT.bDF())) {
            this.ddS.setVisibility(8);
            return;
        }
        if (this.ddS.getVisibility() != 0) {
            TiebaStatic.log(new am("c12912").x("obj_locate", this.mFrom));
        }
        this.ddS.setVisibility(0);
        this.ddS.setData(this.ddT.bDF());
        if (this.ddT.getStartTime() > 0 && this.ddT.getEndTime() > 0 && this.ddT.getEndTime() > this.ddT.getStartTime() && !v.I(this.ddT.bDG())) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ddU);
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ddV);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.ddU, this.ddT.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.g.e.jG().postDelayed(this.ddV, this.ddT.getEndTime() - System.currentTimeMillis());
        }
    }

    private void arg() {
        String lastId = getLastId();
        if (this.ddT == null || lastId.equals(this.ddT.bDH()) || ao.isEmpty(this.ddT.Wa()) || ao.isEmpty(this.ddT.bDF())) {
            this.ddS.setVisibility(8);
            return;
        }
        this.ddS.setVisibility(0);
        this.ddS.setData(this.ddT.bDF());
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ddW);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.ddW, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void arh() {
        if (this.ddS != null && this.ddT != null) {
            if (getLastId().equals(this.ddT.bDH())) {
                this.ddS.setVisibility(8);
            }
            if (this.ddT.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_collection_tag_state", 0) == 1) {
                    this.ddS.ol(false);
                } else {
                    this.ddS.ol(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.ddT == null) {
            return "";
        }
        int type = this.ddT.getType();
        if (this.mFrom == 1) {
            str = "key_redpacket_float_maintab_last_id_" + type;
        } else {
            str = "key_redpacket_float_frs_last_id_" + type;
        }
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ari() {
        String str;
        if (this.ddT != null) {
            int type = this.ddT.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString(str, this.ddT.bDH());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ddU);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ddV);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ddW);
        if (this.ddS != null) {
            this.ddS.release();
        }
    }
}
