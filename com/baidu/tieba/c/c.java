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
/* loaded from: classes3.dex */
public class c {
    private FloatingAnimationView eNw;
    private o eNx;
    private int mFrom;
    private TbPageContext mPageContext;
    private Runnable eNy = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.eNw != null && c.this.eNx != null) {
                c.this.eNw.setData(c.this.eNx.cqO(), 100);
                c.this.eNw.br();
            }
        }
    };
    private Runnable eNz = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.eNw != null && c.this.eNx != null) {
                c.this.eNw.stopAnimation();
                c.this.eNw.setData(c.this.eNx.cqN());
            }
        }
    };
    private Runnable eNA = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.eNw != null && c.this.eNx != null) {
                c.this.eNw.rW(true);
                com.baidu.tbadk.core.sharedPref.b.ahU().putInt("key_collection_tag_state", 0);
            }
        }
    };

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.eNw = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.eNw.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void bcc() {
                if (c.this.eNx != null && !aq.isEmpty(c.this.eNx.aDj())) {
                    TiebaStatic.log(new an("c12913").P("obj_locate", 2).P("obj_type", c.this.mFrom));
                    if (c.this.eNx.getType() == 2) {
                        c.this.eNw.rW(false);
                        com.baidu.tbadk.core.sharedPref.b.ahU().putInt("key_collection_tag_state", 1);
                    }
                    ba.ajK().c(c.this.mPageContext, new String[]{c.this.eNx.aDj()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void bcd() {
                c.this.bcb();
                c.this.onDestroy();
                c.this.eNw.setVisibility(8);
                TiebaStatic.log(new an("c12913").P("obj_locate", 3).P("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(o oVar) {
        if (this.eNw != null) {
            if (oVar == null || oVar.getType() == 0) {
                this.eNw.setVisibility(8);
                return;
            }
            this.eNx = oVar;
            if (this.eNx.getType() == 1) {
                bbZ();
            } else if (this.eNx.getType() == 2) {
                bca();
            }
            aHw();
        }
    }

    private void bbZ() {
        String lastId = getLastId();
        if (this.eNx == null || lastId.equals(this.eNx.cqP()) || aq.isEmpty(this.eNx.aDj()) || aq.isEmpty(this.eNx.cqN())) {
            this.eNw.setVisibility(8);
            return;
        }
        if (this.eNw.getVisibility() != 0) {
            TiebaStatic.log(new an("c12912").P("obj_locate", this.mFrom));
        }
        this.eNw.setVisibility(0);
        this.eNw.setData(this.eNx.cqN());
        if (this.eNx.getStartTime() > 0 && this.eNx.getEndTime() > 0 && this.eNx.getEndTime() > this.eNx.getStartTime() && !v.aa(this.eNx.cqO())) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.eNy);
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.eNz);
            com.baidu.adp.lib.g.e.iK().postDelayed(this.eNy, this.eNx.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.g.e.iK().postDelayed(this.eNz, this.eNx.getEndTime() - System.currentTimeMillis());
        }
    }

    private void bca() {
        String lastId = getLastId();
        if (this.eNx == null || lastId.equals(this.eNx.cqP()) || aq.isEmpty(this.eNx.aDj()) || aq.isEmpty(this.eNx.cqN())) {
            this.eNw.setVisibility(8);
            return;
        }
        this.eNw.setVisibility(0);
        this.eNw.setData(this.eNx.cqN());
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.eNA);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.eNA, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void aHw() {
        if (this.eNw != null && this.eNx != null) {
            if (getLastId().equals(this.eNx.cqP())) {
                this.eNw.setVisibility(8);
            }
            if (this.eNx.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.ahU().getInt("key_collection_tag_state", 0) == 1) {
                    this.eNw.rW(false);
                } else {
                    this.eNw.rW(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.eNx == null) {
            return "";
        }
        int type = this.eNx.getType();
        if (this.mFrom == 1) {
            str = "key_redpacket_float_maintab_last_id_" + type;
        } else {
            str = "key_redpacket_float_frs_last_id_" + type;
        }
        return com.baidu.tbadk.core.sharedPref.b.ahU().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcb() {
        String str;
        if (this.eNx != null) {
            int type = this.eNx.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.ahU().putString(str, this.eNx.cqP());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.eNy);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.eNz);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.eNA);
        if (this.eNw != null) {
            this.eNw.release();
        }
    }
}
