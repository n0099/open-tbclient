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
    private FloatingAnimationView cXh;
    private m cXi;
    private Runnable cXj = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.cXh != null && c.this.cXi != null) {
                c.this.cXh.setData(c.this.cXi.bBL(), 100);
                c.this.cXh.cv();
            }
        }
    };
    private Runnable cXk = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.cXh != null && c.this.cXi != null) {
                c.this.cXh.stopAnimation();
                c.this.cXh.setData(c.this.cXi.bBK());
            }
        }
    };
    private Runnable cXl = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.cXh != null && c.this.cXi != null) {
                c.this.cXh.oj(true);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_collection_tag_state", 0);
            }
        }
    };
    private int mFrom;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.cXh = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.cXh.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void apx() {
                if (c.this.cXi != null && !ao.isEmpty(c.this.cXi.UU())) {
                    TiebaStatic.log(new am("c12913").x("obj_locate", 2).x("obj_type", c.this.mFrom));
                    if (c.this.cXi.getType() == 2) {
                        c.this.cXh.oj(false);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_collection_tag_state", 1);
                    }
                    ay.Db().c(c.this.mPageContext, new String[]{c.this.cXi.UU()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void apy() {
                c.this.apw();
                c.this.onDestroy();
                c.this.cXh.setVisibility(8);
                TiebaStatic.log(new am("c12913").x("obj_locate", 3).x("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(m mVar) {
        if (this.cXh != null) {
            if (mVar == null || mVar.getType() == 0) {
                this.cXh.setVisibility(8);
                return;
            }
            this.cXi = mVar;
            if (this.cXi.getType() == 1) {
                apt();
            } else if (this.cXi.getType() == 2) {
                apu();
            }
            apv();
        }
    }

    private void apt() {
        String lastId = getLastId();
        if (this.cXi == null || lastId.equals(this.cXi.bBM()) || ao.isEmpty(this.cXi.UU()) || ao.isEmpty(this.cXi.bBK())) {
            this.cXh.setVisibility(8);
            return;
        }
        if (this.cXh.getVisibility() != 0) {
            TiebaStatic.log(new am("c12912").x("obj_locate", this.mFrom));
        }
        this.cXh.setVisibility(0);
        this.cXh.setData(this.cXi.bBK());
        if (this.cXi.getStartTime() > 0 && this.cXi.getEndTime() > 0 && this.cXi.getEndTime() > this.cXi.getStartTime() && !v.I(this.cXi.bBL())) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.cXj);
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.cXk);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.cXj, this.cXi.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.g.e.jG().postDelayed(this.cXk, this.cXi.getEndTime() - System.currentTimeMillis());
        }
    }

    private void apu() {
        String lastId = getLastId();
        if (this.cXi == null || lastId.equals(this.cXi.bBM()) || ao.isEmpty(this.cXi.UU()) || ao.isEmpty(this.cXi.bBK())) {
            this.cXh.setVisibility(8);
            return;
        }
        this.cXh.setVisibility(0);
        this.cXh.setData(this.cXi.bBK());
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.cXl);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.cXl, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void apv() {
        if (this.cXh != null && this.cXi != null) {
            if (getLastId().equals(this.cXi.bBM())) {
                this.cXh.setVisibility(8);
            }
            if (this.cXi.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_collection_tag_state", 0) == 1) {
                    this.cXh.oj(false);
                } else {
                    this.cXh.oj(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.cXi == null) {
            return "";
        }
        int type = this.cXi.getType();
        if (this.mFrom == 1) {
            str = "key_redpacket_float_maintab_last_id_" + type;
        } else {
            str = "key_redpacket_float_frs_last_id_" + type;
        }
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apw() {
        String str;
        if (this.cXi != null) {
            int type = this.cXi.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString(str, this.cXi.bBM());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.cXj);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.cXk);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.cXl);
        if (this.cXh != null) {
            this.cXh.release();
        }
    }
}
