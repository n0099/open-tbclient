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
    private FloatingAnimationView fQu;
    private o fQv;
    private Runnable fQw = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.fQu != null && c.this.fQv != null) {
                c.this.fQu.setData(c.this.fQv.cLK(), 100);
                c.this.fQu.playAnimation();
            }
        }
    };
    private Runnable fQx = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.fQu != null && c.this.fQv != null) {
                c.this.fQu.stopAnimation();
                c.this.fQu.setData(c.this.fQv.cLJ());
            }
        }
    };
    private Runnable fQy = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.fQu != null && c.this.fQv != null) {
                c.this.fQu.tH(true);
                com.baidu.tbadk.core.sharedPref.b.aFH().putInt("key_collection_tag_state", 0);
            }
        }
    };
    private int mFrom;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.fQu = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.fQu.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void bwq() {
                if (c.this.fQv != null && !aq.isEmpty(c.this.fQv.aXY())) {
                    TiebaStatic.log(new an("c12913").X("obj_locate", 2).X("obj_type", c.this.mFrom));
                    if (c.this.fQv.getType() == 2) {
                        c.this.fQu.tH(false);
                        com.baidu.tbadk.core.sharedPref.b.aFH().putInt("key_collection_tag_state", 1);
                    }
                    ba.aGK().b(c.this.mPageContext, new String[]{c.this.fQv.aXY()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void bwr() {
                c.this.bwp();
                c.this.onDestroy();
                c.this.fQu.setVisibility(8);
                TiebaStatic.log(new an("c12913").X("obj_locate", 3).X("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(o oVar) {
        if (this.fQu != null) {
            if (oVar == null || oVar.getType() == 0) {
                this.fQu.setVisibility(8);
                return;
            }
            this.fQv = oVar;
            if (this.fQv.getType() == 1) {
                bwn();
            } else if (this.fQv.getType() == 2) {
                bwo();
            }
            baH();
        }
    }

    private void bwn() {
        String lastId = getLastId();
        if (this.fQv == null || lastId.equals(this.fQv.gL()) || aq.isEmpty(this.fQv.aXY()) || aq.isEmpty(this.fQv.cLJ())) {
            this.fQu.setVisibility(8);
            return;
        }
        if (this.fQu.getVisibility() != 0) {
            TiebaStatic.log(new an("c12912").X("obj_locate", this.mFrom));
        }
        this.fQu.setVisibility(0);
        this.fQu.setData(this.fQv.cLJ());
        if (this.fQv.getStartTime() > 0 && this.fQv.getEndTime() > 0 && this.fQv.getEndTime() > this.fQv.getStartTime() && !v.isEmpty(this.fQv.cLK())) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fQw);
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fQx);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.fQw, this.fQv.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.f.e.gx().postDelayed(this.fQx, this.fQv.getEndTime() - System.currentTimeMillis());
        }
    }

    private void bwo() {
        String lastId = getLastId();
        if (this.fQv == null || lastId.equals(this.fQv.gL()) || aq.isEmpty(this.fQv.aXY()) || aq.isEmpty(this.fQv.cLJ())) {
            this.fQu.setVisibility(8);
            return;
        }
        this.fQu.setVisibility(0);
        this.fQu.setData(this.fQv.cLJ());
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fQy);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.fQy, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void baH() {
        if (this.fQu != null && this.fQv != null) {
            if (getLastId().equals(this.fQv.gL())) {
                this.fQu.setVisibility(8);
            }
            if (this.fQv.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.aFH().getInt("key_collection_tag_state", 0) == 1) {
                    this.fQu.tH(false);
                } else {
                    this.fQu.tH(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.fQv == null) {
            return "";
        }
        int type = this.fQv.getType();
        if (this.mFrom == 1) {
            str = "key_redpacket_float_maintab_last_id_" + type;
        } else {
            str = "key_redpacket_float_frs_last_id_" + type;
        }
        return com.baidu.tbadk.core.sharedPref.b.aFH().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwp() {
        String str;
        if (this.fQv != null) {
            int type = this.fQv.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.aFH().putString(str, this.fQv.gL());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fQw);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fQx);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fQy);
        if (this.fQu != null) {
            this.fQu.release();
        }
    }
}
