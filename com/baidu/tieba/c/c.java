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
/* loaded from: classes8.dex */
public class c {
    private FloatingAnimationView fPx;
    private o fPy;
    private int mFrom;
    private TbPageContext mPageContext;
    private Runnable fPz = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.fPx != null && c.this.fPy != null) {
                c.this.fPx.setData(c.this.fPy.cLn(), 100);
                c.this.fPx.playAnimation();
            }
        }
    };
    private Runnable fPA = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.fPx != null && c.this.fPy != null) {
                c.this.fPx.stopAnimation();
                c.this.fPx.setData(c.this.fPy.cLm());
            }
        }
    };
    private Runnable fPB = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.fPx != null && c.this.fPy != null) {
                c.this.fPx.tB(true);
                com.baidu.tbadk.core.sharedPref.b.aFB().putInt("key_collection_tag_state", 0);
            }
        }
    };

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.fPx = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.fPx.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void bwi() {
                if (c.this.fPy != null && !aq.isEmpty(c.this.fPy.aXR())) {
                    TiebaStatic.log(new an("c12913").X("obj_locate", 2).X("obj_type", c.this.mFrom));
                    if (c.this.fPy.getType() == 2) {
                        c.this.fPx.tB(false);
                        com.baidu.tbadk.core.sharedPref.b.aFB().putInt("key_collection_tag_state", 1);
                    }
                    ba.aGE().b(c.this.mPageContext, new String[]{c.this.fPy.aXR()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void bwj() {
                c.this.bwh();
                c.this.onDestroy();
                c.this.fPx.setVisibility(8);
                TiebaStatic.log(new an("c12913").X("obj_locate", 3).X("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(o oVar) {
        if (this.fPx != null) {
            if (oVar == null || oVar.getType() == 0) {
                this.fPx.setVisibility(8);
                return;
            }
            this.fPy = oVar;
            if (this.fPy.getType() == 1) {
                bwf();
            } else if (this.fPy.getType() == 2) {
                bwg();
            }
            baA();
        }
    }

    private void bwf() {
        String lastId = getLastId();
        if (this.fPy == null || lastId.equals(this.fPy.gL()) || aq.isEmpty(this.fPy.aXR()) || aq.isEmpty(this.fPy.cLm())) {
            this.fPx.setVisibility(8);
            return;
        }
        if (this.fPx.getVisibility() != 0) {
            TiebaStatic.log(new an("c12912").X("obj_locate", this.mFrom));
        }
        this.fPx.setVisibility(0);
        this.fPx.setData(this.fPy.cLm());
        if (this.fPy.getStartTime() > 0 && this.fPy.getEndTime() > 0 && this.fPy.getEndTime() > this.fPy.getStartTime() && !v.isEmpty(this.fPy.cLn())) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fPz);
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fPA);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.fPz, this.fPy.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.f.e.gx().postDelayed(this.fPA, this.fPy.getEndTime() - System.currentTimeMillis());
        }
    }

    private void bwg() {
        String lastId = getLastId();
        if (this.fPy == null || lastId.equals(this.fPy.gL()) || aq.isEmpty(this.fPy.aXR()) || aq.isEmpty(this.fPy.cLm())) {
            this.fPx.setVisibility(8);
            return;
        }
        this.fPx.setVisibility(0);
        this.fPx.setData(this.fPy.cLm());
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fPB);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.fPB, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void baA() {
        if (this.fPx != null && this.fPy != null) {
            if (getLastId().equals(this.fPy.gL())) {
                this.fPx.setVisibility(8);
            }
            if (this.fPy.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.aFB().getInt("key_collection_tag_state", 0) == 1) {
                    this.fPx.tB(false);
                } else {
                    this.fPx.tB(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.fPy == null) {
            return "";
        }
        int type = this.fPy.getType();
        if (this.mFrom == 1) {
            str = "key_redpacket_float_maintab_last_id_" + type;
        } else {
            str = "key_redpacket_float_frs_last_id_" + type;
        }
        return com.baidu.tbadk.core.sharedPref.b.aFB().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwh() {
        String str;
        if (this.fPy != null) {
            int type = this.fPy.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.aFB().putString(str, this.fPy.gL());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fPz);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fPA);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fPB);
        if (this.fPx != null) {
            this.fPx.release();
        }
    }
}
