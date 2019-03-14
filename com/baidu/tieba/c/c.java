package com.baidu.tieba.c;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.tbadkCore.data.n;
import com.baidu.tieba.view.FloatingAnimationView;
/* loaded from: classes3.dex */
public class c {
    private FloatingAnimationView ers;
    private n ert;
    private Runnable eru = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.ers != null && c.this.ert != null) {
                c.this.ers.setData(c.this.ert.ceI(), 100);
                c.this.ers.cu();
            }
        }
    };
    private Runnable erv = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.ers != null && c.this.ert != null) {
                c.this.ers.stopAnimation();
                c.this.ers.setData(c.this.ert.ceH());
            }
        }
    };
    private Runnable erw = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.ers != null && c.this.ert != null) {
                c.this.ers.qP(true);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_collection_tag_state", 0);
            }
        }
    };
    private int mFrom;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.ers = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.ers.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void aSo() {
                if (c.this.ert != null && !ap.isEmpty(c.this.ert.awy())) {
                    TiebaStatic.log(new am("c12913").T("obj_locate", 2).T("obj_type", c.this.mFrom));
                    if (c.this.ert.getType() == 2) {
                        c.this.ers.qP(false);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_collection_tag_state", 1);
                    }
                    ba.adD().c(c.this.mPageContext, new String[]{c.this.ert.awy()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void aSp() {
                c.this.aSn();
                c.this.onDestroy();
                c.this.ers.setVisibility(8);
                TiebaStatic.log(new am("c12913").T("obj_locate", 3).T("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(n nVar) {
        if (this.ers != null) {
            if (nVar == null || nVar.getType() == 0) {
                this.ers.setVisibility(8);
                return;
            }
            this.ert = nVar;
            if (this.ert.getType() == 1) {
                aSk();
            } else if (this.ert.getType() == 2) {
                aSl();
            }
            aSm();
        }
    }

    private void aSk() {
        String lastId = getLastId();
        if (this.ert == null || lastId.equals(this.ert.ceJ()) || ap.isEmpty(this.ert.awy()) || ap.isEmpty(this.ert.ceH())) {
            this.ers.setVisibility(8);
            return;
        }
        if (this.ers.getVisibility() != 0) {
            TiebaStatic.log(new am("c12912").T("obj_locate", this.mFrom));
        }
        this.ers.setVisibility(0);
        this.ers.setData(this.ert.ceH());
        if (this.ert.getStartTime() > 0 && this.ert.getEndTime() > 0 && this.ert.getEndTime() > this.ert.getStartTime() && !v.T(this.ert.ceI())) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.eru);
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.erv);
            com.baidu.adp.lib.g.e.jH().postDelayed(this.eru, this.ert.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.g.e.jH().postDelayed(this.erv, this.ert.getEndTime() - System.currentTimeMillis());
        }
    }

    private void aSl() {
        String lastId = getLastId();
        if (this.ert == null || lastId.equals(this.ert.ceJ()) || ap.isEmpty(this.ert.awy()) || ap.isEmpty(this.ert.ceH())) {
            this.ers.setVisibility(8);
            return;
        }
        this.ers.setVisibility(0);
        this.ers.setData(this.ert.ceH());
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.erw);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.erw, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void aSm() {
        if (this.ers != null && this.ert != null) {
            if (getLastId().equals(this.ert.ceJ())) {
                this.ers.setVisibility(8);
            }
            if (this.ert.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_collection_tag_state", 0) == 1) {
                    this.ers.qP(false);
                } else {
                    this.ers.qP(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.ert == null) {
            return "";
        }
        int type = this.ert.getType();
        if (this.mFrom == 1) {
            str = "key_redpacket_float_maintab_last_id_" + type;
        } else {
            str = "key_redpacket_float_frs_last_id_" + type;
        }
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSn() {
        String str;
        if (this.ert != null) {
            int type = this.ert.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString(str, this.ert.ceJ());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.eru);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.erv);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.erw);
        if (this.ers != null) {
            this.ers.release();
        }
    }
}
