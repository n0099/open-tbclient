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
    private FloatingAnimationView erd;
    private n ere;
    private Runnable erf = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.erd != null && c.this.ere != null) {
                c.this.erd.setData(c.this.ere.ceE(), 100);
                c.this.erd.cu();
            }
        }
    };
    private Runnable erg = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.erd != null && c.this.ere != null) {
                c.this.erd.stopAnimation();
                c.this.erd.setData(c.this.ere.ceD());
            }
        }
    };
    private Runnable erh = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.erd != null && c.this.ere != null) {
                c.this.erd.qP(true);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_collection_tag_state", 0);
            }
        }
    };
    private int mFrom;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.erd = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.erd.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void aSm() {
                if (c.this.ere != null && !ap.isEmpty(c.this.ere.awv())) {
                    TiebaStatic.log(new am("c12913").T("obj_locate", 2).T("obj_type", c.this.mFrom));
                    if (c.this.ere.getType() == 2) {
                        c.this.erd.qP(false);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_collection_tag_state", 1);
                    }
                    ba.adA().c(c.this.mPageContext, new String[]{c.this.ere.awv()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void aSn() {
                c.this.aSl();
                c.this.onDestroy();
                c.this.erd.setVisibility(8);
                TiebaStatic.log(new am("c12913").T("obj_locate", 3).T("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(n nVar) {
        if (this.erd != null) {
            if (nVar == null || nVar.getType() == 0) {
                this.erd.setVisibility(8);
                return;
            }
            this.ere = nVar;
            if (this.ere.getType() == 1) {
                aSi();
            } else if (this.ere.getType() == 2) {
                aSj();
            }
            aSk();
        }
    }

    private void aSi() {
        String lastId = getLastId();
        if (this.ere == null || lastId.equals(this.ere.ceF()) || ap.isEmpty(this.ere.awv()) || ap.isEmpty(this.ere.ceD())) {
            this.erd.setVisibility(8);
            return;
        }
        if (this.erd.getVisibility() != 0) {
            TiebaStatic.log(new am("c12912").T("obj_locate", this.mFrom));
        }
        this.erd.setVisibility(0);
        this.erd.setData(this.ere.ceD());
        if (this.ere.getStartTime() > 0 && this.ere.getEndTime() > 0 && this.ere.getEndTime() > this.ere.getStartTime() && !v.T(this.ere.ceE())) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.erf);
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.erg);
            com.baidu.adp.lib.g.e.jH().postDelayed(this.erf, this.ere.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.g.e.jH().postDelayed(this.erg, this.ere.getEndTime() - System.currentTimeMillis());
        }
    }

    private void aSj() {
        String lastId = getLastId();
        if (this.ere == null || lastId.equals(this.ere.ceF()) || ap.isEmpty(this.ere.awv()) || ap.isEmpty(this.ere.ceD())) {
            this.erd.setVisibility(8);
            return;
        }
        this.erd.setVisibility(0);
        this.erd.setData(this.ere.ceD());
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.erh);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.erh, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void aSk() {
        if (this.erd != null && this.ere != null) {
            if (getLastId().equals(this.ere.ceF())) {
                this.erd.setVisibility(8);
            }
            if (this.ere.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_collection_tag_state", 0) == 1) {
                    this.erd.qP(false);
                } else {
                    this.erd.qP(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.ere == null) {
            return "";
        }
        int type = this.ere.getType();
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
        if (this.ere != null) {
            int type = this.ere.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString(str, this.ere.ceF());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.erf);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.erg);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.erh);
        if (this.erd != null) {
            this.erd.release();
        }
    }
}
