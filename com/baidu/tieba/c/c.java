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
    private FloatingAnimationView erw;
    private n erx;
    private int mFrom;
    private TbPageContext mPageContext;
    private Runnable ery = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.erw != null && c.this.erx != null) {
                c.this.erw.setData(c.this.erx.ceG(), 100);
                c.this.erw.cu();
            }
        }
    };
    private Runnable erz = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.erw != null && c.this.erx != null) {
                c.this.erw.stopAnimation();
                c.this.erw.setData(c.this.erx.ceF());
            }
        }
    };
    private Runnable erA = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.erw != null && c.this.erx != null) {
                c.this.erw.qP(true);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_collection_tag_state", 0);
            }
        }
    };

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.erw = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.erw.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void aSp() {
                if (c.this.erx != null && !ap.isEmpty(c.this.erx.awz())) {
                    TiebaStatic.log(new am("c12913").T("obj_locate", 2).T("obj_type", c.this.mFrom));
                    if (c.this.erx.getType() == 2) {
                        c.this.erw.qP(false);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_collection_tag_state", 1);
                    }
                    ba.adD().c(c.this.mPageContext, new String[]{c.this.erx.awz()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void aSq() {
                c.this.aSo();
                c.this.onDestroy();
                c.this.erw.setVisibility(8);
                TiebaStatic.log(new am("c12913").T("obj_locate", 3).T("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(n nVar) {
        if (this.erw != null) {
            if (nVar == null || nVar.getType() == 0) {
                this.erw.setVisibility(8);
                return;
            }
            this.erx = nVar;
            if (this.erx.getType() == 1) {
                aSl();
            } else if (this.erx.getType() == 2) {
                aSm();
            }
            aSn();
        }
    }

    private void aSl() {
        String lastId = getLastId();
        if (this.erx == null || lastId.equals(this.erx.ceH()) || ap.isEmpty(this.erx.awz()) || ap.isEmpty(this.erx.ceF())) {
            this.erw.setVisibility(8);
            return;
        }
        if (this.erw.getVisibility() != 0) {
            TiebaStatic.log(new am("c12912").T("obj_locate", this.mFrom));
        }
        this.erw.setVisibility(0);
        this.erw.setData(this.erx.ceF());
        if (this.erx.getStartTime() > 0 && this.erx.getEndTime() > 0 && this.erx.getEndTime() > this.erx.getStartTime() && !v.T(this.erx.ceG())) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.ery);
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.erz);
            com.baidu.adp.lib.g.e.jH().postDelayed(this.ery, this.erx.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.g.e.jH().postDelayed(this.erz, this.erx.getEndTime() - System.currentTimeMillis());
        }
    }

    private void aSm() {
        String lastId = getLastId();
        if (this.erx == null || lastId.equals(this.erx.ceH()) || ap.isEmpty(this.erx.awz()) || ap.isEmpty(this.erx.ceF())) {
            this.erw.setVisibility(8);
            return;
        }
        this.erw.setVisibility(0);
        this.erw.setData(this.erx.ceF());
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.erA);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.erA, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void aSn() {
        if (this.erw != null && this.erx != null) {
            if (getLastId().equals(this.erx.ceH())) {
                this.erw.setVisibility(8);
            }
            if (this.erx.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_collection_tag_state", 0) == 1) {
                    this.erw.qP(false);
                } else {
                    this.erw.qP(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.erx == null) {
            return "";
        }
        int type = this.erx.getType();
        if (this.mFrom == 1) {
            str = "key_redpacket_float_maintab_last_id_" + type;
        } else {
            str = "key_redpacket_float_frs_last_id_" + type;
        }
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSo() {
        String str;
        if (this.erx != null) {
            int type = this.erx.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString(str, this.erx.ceH());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.ery);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.erz);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.erA);
        if (this.erw != null) {
            this.erw.release();
        }
    }
}
