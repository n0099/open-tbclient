package com.baidu.tieba.c;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.tbadkCore.data.p;
import com.baidu.tieba.view.FloatingAnimationView;
/* loaded from: classes8.dex */
public class c {
    private FloatingAnimationView gKe;
    private p gKf;
    private Runnable gKg = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gKe != null && c.this.gKf != null) {
                c.this.gKe.setData(c.this.gKf.ddY(), 100);
                c.this.gKe.playAnimation();
            }
        }
    };
    private Runnable gKh = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gKe != null && c.this.gKf != null) {
                c.this.gKe.stopAnimation();
                c.this.gKe.setData(c.this.gKf.ddX());
            }
        }
    };
    private Runnable gKi = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gKe != null && c.this.gKf != null) {
                c.this.gKe.vh(true);
                com.baidu.tbadk.core.sharedPref.b.aTX().putInt("key_collection_tag_state", 0);
            }
        }
    };
    private int mFrom;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.gKe = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.gKe.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void bMw() {
                if (c.this.gKf != null && !aq.isEmpty(c.this.gKf.vX())) {
                    TiebaStatic.log(new an("c12913").ag("obj_locate", 2).ag("obj_type", c.this.mFrom));
                    if (c.this.gKf.getType() == 2) {
                        c.this.gKe.vh(false);
                        com.baidu.tbadk.core.sharedPref.b.aTX().putInt("key_collection_tag_state", 1);
                    }
                    ba.aVa().b(c.this.mPageContext, new String[]{c.this.gKf.vX()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void bMx() {
                c.this.bMv();
                c.this.onDestroy();
                c.this.gKe.setVisibility(8);
                TiebaStatic.log(new an("c12913").ag("obj_locate", 3).ag("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(p pVar) {
        if (this.gKe != null) {
            if (pVar == null || pVar.getType() == 0) {
                this.gKe.setVisibility(8);
                return;
            }
            this.gKf = pVar;
            if (this.gKf.getType() == 1) {
                bMt();
            } else if (this.gKf.getType() == 2) {
                bMu();
            }
            aJZ();
        }
    }

    private void bMt() {
        String lastId = getLastId();
        if (this.gKf == null || lastId.equals(this.gKf.lr()) || aq.isEmpty(this.gKf.vX()) || aq.isEmpty(this.gKf.ddX())) {
            this.gKe.setVisibility(8);
            return;
        }
        if (this.gKe.getVisibility() != 0) {
            TiebaStatic.log(new an("c12912").ag("obj_locate", this.mFrom));
        }
        this.gKe.setVisibility(0);
        this.gKe.setData(this.gKf.ddX());
        if (this.gKf.getStartTime() > 0 && this.gKf.getEndTime() > 0 && this.gKf.getEndTime() > this.gKf.getStartTime() && !v.isEmpty(this.gKf.ddY())) {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.gKg);
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.gKh);
            com.baidu.adp.lib.f.e.ld().postDelayed(this.gKg, this.gKf.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.f.e.ld().postDelayed(this.gKh, this.gKf.getEndTime() - System.currentTimeMillis());
        }
    }

    private void bMu() {
        String lastId = getLastId();
        if (this.gKf == null || lastId.equals(this.gKf.lr()) || aq.isEmpty(this.gKf.vX()) || aq.isEmpty(this.gKf.ddX())) {
            this.gKe.setVisibility(8);
            return;
        }
        this.gKe.setVisibility(0);
        this.gKe.setData(this.gKf.ddX());
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.gKi);
        com.baidu.adp.lib.f.e.ld().postDelayed(this.gKi, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void aJZ() {
        if (this.gKe != null && this.gKf != null) {
            if (getLastId().equals(this.gKf.lr())) {
                this.gKe.setVisibility(8);
            }
            if (this.gKf.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.aTX().getInt("key_collection_tag_state", 0) == 1) {
                    this.gKe.vh(false);
                } else {
                    this.gKe.vh(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.gKf == null) {
            return "";
        }
        int type = this.gKf.getType();
        if (this.mFrom == 1) {
            str = "key_redpacket_float_maintab_last_id_" + type;
        } else {
            str = "key_redpacket_float_frs_last_id_" + type;
        }
        return com.baidu.tbadk.core.sharedPref.b.aTX().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMv() {
        String str;
        if (this.gKf != null) {
            int type = this.gKf.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.aTX().putString(str, this.gKf.lr());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.gKg);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.gKh);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.gKi);
        if (this.gKe != null) {
            this.gKe.release();
        }
    }
}
