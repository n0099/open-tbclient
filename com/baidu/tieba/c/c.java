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
    private FloatingAnimationView ere;
    private n erf;
    private Runnable erg = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.ere != null && c.this.erf != null) {
                c.this.ere.setData(c.this.erf.ceE(), 100);
                c.this.ere.cu();
            }
        }
    };
    private Runnable erh = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.ere != null && c.this.erf != null) {
                c.this.ere.stopAnimation();
                c.this.ere.setData(c.this.erf.ceD());
            }
        }
    };
    private Runnable eri = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.ere != null && c.this.erf != null) {
                c.this.ere.qP(true);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_collection_tag_state", 0);
            }
        }
    };
    private int mFrom;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.ere = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.ere.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void aSm() {
                if (c.this.erf != null && !ap.isEmpty(c.this.erf.awv())) {
                    TiebaStatic.log(new am("c12913").T("obj_locate", 2).T("obj_type", c.this.mFrom));
                    if (c.this.erf.getType() == 2) {
                        c.this.ere.qP(false);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_collection_tag_state", 1);
                    }
                    ba.adA().c(c.this.mPageContext, new String[]{c.this.erf.awv()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void aSn() {
                c.this.aSl();
                c.this.onDestroy();
                c.this.ere.setVisibility(8);
                TiebaStatic.log(new am("c12913").T("obj_locate", 3).T("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(n nVar) {
        if (this.ere != null) {
            if (nVar == null || nVar.getType() == 0) {
                this.ere.setVisibility(8);
                return;
            }
            this.erf = nVar;
            if (this.erf.getType() == 1) {
                aSi();
            } else if (this.erf.getType() == 2) {
                aSj();
            }
            aSk();
        }
    }

    private void aSi() {
        String lastId = getLastId();
        if (this.erf == null || lastId.equals(this.erf.ceF()) || ap.isEmpty(this.erf.awv()) || ap.isEmpty(this.erf.ceD())) {
            this.ere.setVisibility(8);
            return;
        }
        if (this.ere.getVisibility() != 0) {
            TiebaStatic.log(new am("c12912").T("obj_locate", this.mFrom));
        }
        this.ere.setVisibility(0);
        this.ere.setData(this.erf.ceD());
        if (this.erf.getStartTime() > 0 && this.erf.getEndTime() > 0 && this.erf.getEndTime() > this.erf.getStartTime() && !v.T(this.erf.ceE())) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.erg);
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.erh);
            com.baidu.adp.lib.g.e.jH().postDelayed(this.erg, this.erf.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.g.e.jH().postDelayed(this.erh, this.erf.getEndTime() - System.currentTimeMillis());
        }
    }

    private void aSj() {
        String lastId = getLastId();
        if (this.erf == null || lastId.equals(this.erf.ceF()) || ap.isEmpty(this.erf.awv()) || ap.isEmpty(this.erf.ceD())) {
            this.ere.setVisibility(8);
            return;
        }
        this.ere.setVisibility(0);
        this.ere.setData(this.erf.ceD());
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.eri);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.eri, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void aSk() {
        if (this.ere != null && this.erf != null) {
            if (getLastId().equals(this.erf.ceF())) {
                this.ere.setVisibility(8);
            }
            if (this.erf.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_collection_tag_state", 0) == 1) {
                    this.ere.qP(false);
                } else {
                    this.ere.qP(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.erf == null) {
            return "";
        }
        int type = this.erf.getType();
        if (this.mFrom == 1) {
            str = "key_redpacket_float_maintab_last_id_" + type;
        } else {
            str = "key_redpacket_float_frs_last_id_" + type;
        }
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSl() {
        String str;
        if (this.erf != null) {
            int type = this.erf.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString(str, this.erf.ceF());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.erg);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.erh);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.eri);
        if (this.ere != null) {
            this.ere.release();
        }
    }
}
