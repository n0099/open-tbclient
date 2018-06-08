package com.baidu.tieba.c;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.tbadkCore.data.m;
import com.baidu.tieba.view.FloatingAnimationView;
/* loaded from: classes.dex */
public class c {
    private FloatingAnimationView cHv;
    private m cHw;
    private Runnable cHx = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.cHv != null && c.this.cHw != null) {
                c.this.cHv.setData(c.this.cHw.bxp(), 100);
                c.this.cHv.ba();
            }
        }
    };
    private Runnable cHy = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.cHv != null && c.this.cHw != null) {
                c.this.cHv.stopAnimation();
                c.this.cHv.setData(c.this.cHw.bxo());
            }
        }
    };
    private Runnable cHz = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.cHv != null && c.this.cHw != null) {
                c.this.cHv.nm(true);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_collection_tag_state", 0);
            }
        }
    };
    private int mFrom;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.cHv = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.cHv.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void akQ() {
                if (c.this.cHw != null && !ao.isEmpty(c.this.cHw.Qs())) {
                    TiebaStatic.log(new am("c12913").r("obj_locate", 2).r("obj_type", c.this.mFrom));
                    if (c.this.cHw.getType() == 2) {
                        c.this.cHv.nm(false);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_collection_tag_state", 1);
                    }
                    ay.zG().c(c.this.mPageContext, new String[]{c.this.cHw.Qs()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void akR() {
                c.this.akP();
                c.this.onDestroy();
                c.this.cHv.setVisibility(8);
                TiebaStatic.log(new am("c12913").r("obj_locate", 3).r("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(m mVar) {
        if (this.cHv != null) {
            if (mVar == null || mVar.getType() == 0) {
                this.cHv.setVisibility(8);
                return;
            }
            this.cHw = mVar;
            if (this.cHw.getType() == 1) {
                akM();
            } else if (this.cHw.getType() == 2) {
                akN();
            }
            akO();
        }
    }

    private void akM() {
        String lastId = getLastId();
        if (this.cHw == null || lastId.equals(this.cHw.bxq()) || ao.isEmpty(this.cHw.Qs()) || ao.isEmpty(this.cHw.bxo())) {
            this.cHv.setVisibility(8);
            return;
        }
        if (this.cHv.getVisibility() != 0) {
            TiebaStatic.log(new am("c12912").r("obj_locate", this.mFrom));
        }
        this.cHv.setVisibility(0);
        this.cHv.setData(this.cHw.bxo());
        if (this.cHw.getStartTime() > 0 && this.cHw.getEndTime() > 0 && this.cHw.getEndTime() > this.cHw.getStartTime() && !w.z(this.cHw.bxp())) {
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.cHx);
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.cHy);
            com.baidu.adp.lib.g.e.im().postDelayed(this.cHx, this.cHw.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.g.e.im().postDelayed(this.cHy, this.cHw.getEndTime() - System.currentTimeMillis());
        }
    }

    private void akN() {
        String lastId = getLastId();
        if (this.cHw == null || lastId.equals(this.cHw.bxq()) || ao.isEmpty(this.cHw.Qs()) || ao.isEmpty(this.cHw.bxo())) {
            this.cHv.setVisibility(8);
            return;
        }
        this.cHv.setVisibility(0);
        this.cHv.setData(this.cHw.bxo());
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.cHz);
        com.baidu.adp.lib.g.e.im().postDelayed(this.cHz, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void akO() {
        if (this.cHv != null && this.cHw != null) {
            if (getLastId().equals(this.cHw.bxq())) {
                this.cHv.setVisibility(8);
            }
            if (this.cHw.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_collection_tag_state", 0) == 1) {
                    this.cHv.nm(false);
                } else {
                    this.cHv.nm(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.cHw == null) {
            return "";
        }
        int type = this.cHw.getType();
        if (this.mFrom == 1) {
            str = "key_redpacket_float_maintab_last_id_" + type;
        } else {
            str = "key_redpacket_float_frs_last_id_" + type;
        }
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akP() {
        String str;
        if (this.cHw != null) {
            int type = this.cHw.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString(str, this.cHw.bxq());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.cHx);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.cHy);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.cHz);
        if (this.cHv != null) {
            this.cHv.release();
        }
    }
}
