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
    private FloatingAnimationView eVm;
    private o eVn;
    private Runnable eVo = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.eVm != null && c.this.eVn != null) {
                c.this.eVm.setData(c.this.eVn.coC(), 100);
                c.this.eVm.playAnimation();
            }
        }
    };
    private Runnable eVp = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.eVm != null && c.this.eVn != null) {
                c.this.eVm.stopAnimation();
                c.this.eVm.setData(c.this.eVn.coB());
            }
        }
    };
    private Runnable eVq = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.eVm != null && c.this.eVn != null) {
                c.this.eVm.rF(true);
                com.baidu.tbadk.core.sharedPref.b.alP().putInt("key_collection_tag_state", 0);
            }
        }
    };
    private int mFrom;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.eVm = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.eVm.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void bcf() {
                if (c.this.eVn != null && !aq.isEmpty(c.this.eVn.aDq())) {
                    TiebaStatic.log(new an("c12913").O("obj_locate", 2).O("obj_type", c.this.mFrom));
                    if (c.this.eVn.getType() == 2) {
                        c.this.eVm.rF(false);
                        com.baidu.tbadk.core.sharedPref.b.alP().putInt("key_collection_tag_state", 1);
                    }
                    ba.amO().b(c.this.mPageContext, new String[]{c.this.eVn.aDq()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void bcg() {
                c.this.bce();
                c.this.onDestroy();
                c.this.eVm.setVisibility(8);
                TiebaStatic.log(new an("c12913").O("obj_locate", 3).O("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(o oVar) {
        if (this.eVm != null) {
            if (oVar == null || oVar.getType() == 0) {
                this.eVm.setVisibility(8);
                return;
            }
            this.eVn = oVar;
            if (this.eVn.getType() == 1) {
                bcc();
            } else if (this.eVn.getType() == 2) {
                bcd();
            }
            aHH();
        }
    }

    private void bcc() {
        String lastId = getLastId();
        if (this.eVn == null || lastId.equals(this.eVn.coD()) || aq.isEmpty(this.eVn.aDq()) || aq.isEmpty(this.eVn.coB())) {
            this.eVm.setVisibility(8);
            return;
        }
        if (this.eVm.getVisibility() != 0) {
            TiebaStatic.log(new an("c12912").O("obj_locate", this.mFrom));
        }
        this.eVm.setVisibility(0);
        this.eVm.setData(this.eVn.coB());
        if (this.eVn.getStartTime() > 0 && this.eVn.getEndTime() > 0 && this.eVn.getEndTime() > this.eVn.getStartTime() && !v.isEmpty(this.eVn.coC())) {
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.eVo);
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.eVp);
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.eVo, this.eVn.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.eVp, this.eVn.getEndTime() - System.currentTimeMillis());
        }
    }

    private void bcd() {
        String lastId = getLastId();
        if (this.eVn == null || lastId.equals(this.eVn.coD()) || aq.isEmpty(this.eVn.aDq()) || aq.isEmpty(this.eVn.coB())) {
            this.eVm.setVisibility(8);
            return;
        }
        this.eVm.setVisibility(0);
        this.eVm.setData(this.eVn.coB());
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.eVq);
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.eVq, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void aHH() {
        if (this.eVm != null && this.eVn != null) {
            if (getLastId().equals(this.eVn.coD())) {
                this.eVm.setVisibility(8);
            }
            if (this.eVn.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.alP().getInt("key_collection_tag_state", 0) == 1) {
                    this.eVm.rF(false);
                } else {
                    this.eVm.rF(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.eVn == null) {
            return "";
        }
        int type = this.eVn.getType();
        if (this.mFrom == 1) {
            str = "key_redpacket_float_maintab_last_id_" + type;
        } else {
            str = "key_redpacket_float_frs_last_id_" + type;
        }
        return com.baidu.tbadk.core.sharedPref.b.alP().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bce() {
        String str;
        if (this.eVn != null) {
            int type = this.eVn.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.alP().putString(str, this.eVn.coD());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.eVo);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.eVp);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.eVq);
        if (this.eVm != null) {
            this.eVm.release();
        }
    }
}
