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
    private FloatingAnimationView gJT;
    private p gJU;
    private Runnable gJV = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gJT != null && c.this.gJU != null) {
                c.this.gJT.setData(c.this.gJU.ddJ(), 100);
                c.this.gJT.playAnimation();
            }
        }
    };
    private Runnable gJW = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gJT != null && c.this.gJU != null) {
                c.this.gJT.stopAnimation();
                c.this.gJT.setData(c.this.gJU.ddI());
            }
        }
    };
    private Runnable gJX = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gJT != null && c.this.gJU != null) {
                c.this.gJT.vh(true);
                com.baidu.tbadk.core.sharedPref.b.aTX().putInt("key_collection_tag_state", 0);
            }
        }
    };
    private int mFrom;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.gJT = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.gJT.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void bMu() {
                if (c.this.gJU != null && !aq.isEmpty(c.this.gJU.vX())) {
                    TiebaStatic.log(new an("c12913").ag("obj_locate", 2).ag("obj_type", c.this.mFrom));
                    if (c.this.gJU.getType() == 2) {
                        c.this.gJT.vh(false);
                        com.baidu.tbadk.core.sharedPref.b.aTX().putInt("key_collection_tag_state", 1);
                    }
                    ba.aUZ().b(c.this.mPageContext, new String[]{c.this.gJU.vX()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void bMv() {
                c.this.bMt();
                c.this.onDestroy();
                c.this.gJT.setVisibility(8);
                TiebaStatic.log(new an("c12913").ag("obj_locate", 3).ag("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(p pVar) {
        if (this.gJT != null) {
            if (pVar == null || pVar.getType() == 0) {
                this.gJT.setVisibility(8);
                return;
            }
            this.gJU = pVar;
            if (this.gJU.getType() == 1) {
                bMr();
            } else if (this.gJU.getType() == 2) {
                bMs();
            }
            aJZ();
        }
    }

    private void bMr() {
        String lastId = getLastId();
        if (this.gJU == null || lastId.equals(this.gJU.lr()) || aq.isEmpty(this.gJU.vX()) || aq.isEmpty(this.gJU.ddI())) {
            this.gJT.setVisibility(8);
            return;
        }
        if (this.gJT.getVisibility() != 0) {
            TiebaStatic.log(new an("c12912").ag("obj_locate", this.mFrom));
        }
        this.gJT.setVisibility(0);
        this.gJT.setData(this.gJU.ddI());
        if (this.gJU.getStartTime() > 0 && this.gJU.getEndTime() > 0 && this.gJU.getEndTime() > this.gJU.getStartTime() && !v.isEmpty(this.gJU.ddJ())) {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.gJV);
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.gJW);
            com.baidu.adp.lib.f.e.ld().postDelayed(this.gJV, this.gJU.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.f.e.ld().postDelayed(this.gJW, this.gJU.getEndTime() - System.currentTimeMillis());
        }
    }

    private void bMs() {
        String lastId = getLastId();
        if (this.gJU == null || lastId.equals(this.gJU.lr()) || aq.isEmpty(this.gJU.vX()) || aq.isEmpty(this.gJU.ddI())) {
            this.gJT.setVisibility(8);
            return;
        }
        this.gJT.setVisibility(0);
        this.gJT.setData(this.gJU.ddI());
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.gJX);
        com.baidu.adp.lib.f.e.ld().postDelayed(this.gJX, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void aJZ() {
        if (this.gJT != null && this.gJU != null) {
            if (getLastId().equals(this.gJU.lr())) {
                this.gJT.setVisibility(8);
            }
            if (this.gJU.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.aTX().getInt("key_collection_tag_state", 0) == 1) {
                    this.gJT.vh(false);
                } else {
                    this.gJT.vh(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.gJU == null) {
            return "";
        }
        int type = this.gJU.getType();
        if (this.mFrom == 1) {
            str = "key_redpacket_float_maintab_last_id_" + type;
        } else {
            str = "key_redpacket_float_frs_last_id_" + type;
        }
        return com.baidu.tbadk.core.sharedPref.b.aTX().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMt() {
        String str;
        if (this.gJU != null) {
            int type = this.gJU.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.aTX().putString(str, this.gJU.lr());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.gJV);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.gJW);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.gJX);
        if (this.gJT != null) {
            this.gJT.release();
        }
    }
}
