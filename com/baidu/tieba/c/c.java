package com.baidu.tieba.c;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.tbadkCore.data.m;
import com.baidu.tieba.view.FloatingAnimationView;
/* loaded from: classes.dex */
public class c {
    private FloatingAnimationView cFp;
    private m cFq;
    private Runnable cFr = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.cFp != null && c.this.cFq != null) {
                c.this.cFp.setData(c.this.cFq.bxS(), 100);
                c.this.cFp.ba();
            }
        }
    };
    private Runnable cFs = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.cFp != null && c.this.cFq != null) {
                c.this.cFp.stopAnimation();
                c.this.cFp.setData(c.this.cFq.bxR());
            }
        }
    };
    private Runnable cFt = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.cFp != null && c.this.cFq != null) {
                c.this.cFp.nu(true);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_collection_tag_state", 0);
            }
        }
    };
    private int mFrom;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.cFp = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.cFp.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void akk() {
                if (c.this.cFq != null && !ap.isEmpty(c.this.cFq.QP())) {
                    TiebaStatic.log(new an("c12913").r("obj_locate", 2).r("obj_type", c.this.mFrom));
                    if (c.this.cFq.getType() == 2) {
                        c.this.cFp.nu(false);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_collection_tag_state", 1);
                    }
                    az.zV().c(c.this.mPageContext, new String[]{c.this.cFq.QP()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void akl() {
                c.this.akj();
                c.this.onDestroy();
                c.this.cFp.setVisibility(8);
                TiebaStatic.log(new an("c12913").r("obj_locate", 3).r("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(m mVar) {
        if (this.cFp != null) {
            if (mVar == null || mVar.getType() == 0) {
                this.cFp.setVisibility(8);
                return;
            }
            this.cFq = mVar;
            if (this.cFq.getType() == 1) {
                akg();
            } else if (this.cFq.getType() == 2) {
                akh();
            }
            aki();
        }
    }

    private void akg() {
        String lastId = getLastId();
        if (this.cFq == null || lastId.equals(this.cFq.bxT()) || ap.isEmpty(this.cFq.QP()) || ap.isEmpty(this.cFq.bxR())) {
            this.cFp.setVisibility(8);
            return;
        }
        if (this.cFp.getVisibility() != 0) {
            TiebaStatic.log(new an("c12912").r("obj_locate", this.mFrom));
        }
        this.cFp.setVisibility(0);
        this.cFp.setData(this.cFq.bxR());
        if (this.cFq.getStartTime() > 0 && this.cFq.getEndTime() > 0 && this.cFq.getEndTime() > this.cFq.getStartTime() && !w.A(this.cFq.bxS())) {
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.cFr);
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.cFs);
            com.baidu.adp.lib.g.e.im().postDelayed(this.cFr, this.cFq.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.g.e.im().postDelayed(this.cFs, this.cFq.getEndTime() - System.currentTimeMillis());
        }
    }

    private void akh() {
        String lastId = getLastId();
        if (this.cFq == null || lastId.equals(this.cFq.bxT()) || ap.isEmpty(this.cFq.QP()) || ap.isEmpty(this.cFq.bxR())) {
            this.cFp.setVisibility(8);
            return;
        }
        this.cFp.setVisibility(0);
        this.cFp.setData(this.cFq.bxR());
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.cFt);
        com.baidu.adp.lib.g.e.im().postDelayed(this.cFt, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void aki() {
        if (this.cFp != null && this.cFq != null) {
            if (getLastId().equals(this.cFq.bxT())) {
                this.cFp.setVisibility(8);
            }
            if (this.cFq.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_collection_tag_state", 0) == 1) {
                    this.cFp.nu(false);
                } else {
                    this.cFp.nu(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.cFq == null) {
            return "";
        }
        int type = this.cFq.getType();
        if (this.mFrom == 1) {
            str = "key_redpacket_float_maintab_last_id_" + type;
        } else {
            str = "key_redpacket_float_frs_last_id_" + type;
        }
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akj() {
        String str;
        if (this.cFq != null) {
            int type = this.cFq.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString(str, this.cFq.bxT());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.cFr);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.cFs);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.cFt);
        if (this.cFp != null) {
            this.cFp.release();
        }
    }
}
