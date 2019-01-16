package com.baidu.tieba.c;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.tbadkCore.data.m;
import com.baidu.tieba.view.FloatingAnimationView;
/* loaded from: classes.dex */
public class c {
    private FloatingAnimationView dhv;
    private m dhw;
    private Runnable dhx = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dhv != null && c.this.dhw != null) {
                c.this.dhv.setData(c.this.dhw.bFg(), 100);
                c.this.dhv.cv();
            }
        }
    };
    private Runnable dhy = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dhv != null && c.this.dhw != null) {
                c.this.dhv.stopAnimation();
                c.this.dhv.setData(c.this.dhw.bFf());
            }
        }
    };
    private Runnable dhz = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dhv != null && c.this.dhw != null) {
                c.this.dhv.op(true);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_collection_tag_state", 0);
            }
        }
    };
    private int mFrom;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.dhv = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.dhv.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void asw() {
                if (c.this.dhw != null && !ao.isEmpty(c.this.dhw.Wy())) {
                    TiebaStatic.log(new am("c12913").y("obj_locate", 2).y("obj_type", c.this.mFrom));
                    if (c.this.dhw.getType() == 2) {
                        c.this.dhv.op(false);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_collection_tag_state", 1);
                    }
                    ay.Es().c(c.this.mPageContext, new String[]{c.this.dhw.Wy()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void asx() {
                c.this.asv();
                c.this.onDestroy();
                c.this.dhv.setVisibility(8);
                TiebaStatic.log(new am("c12913").y("obj_locate", 3).y("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(m mVar) {
        if (this.dhv != null) {
            if (mVar == null || mVar.getType() == 0) {
                this.dhv.setVisibility(8);
                return;
            }
            this.dhw = mVar;
            if (this.dhw.getType() == 1) {
                ass();
            } else if (this.dhw.getType() == 2) {
                ast();
            }
            asu();
        }
    }

    private void ass() {
        String lastId = getLastId();
        if (this.dhw == null || lastId.equals(this.dhw.bFh()) || ao.isEmpty(this.dhw.Wy()) || ao.isEmpty(this.dhw.bFf())) {
            this.dhv.setVisibility(8);
            return;
        }
        if (this.dhv.getVisibility() != 0) {
            TiebaStatic.log(new am("c12912").y("obj_locate", this.mFrom));
        }
        this.dhv.setVisibility(0);
        this.dhv.setData(this.dhw.bFf());
        if (this.dhw.getStartTime() > 0 && this.dhw.getEndTime() > 0 && this.dhw.getEndTime() > this.dhw.getStartTime() && !v.I(this.dhw.bFg())) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dhx);
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dhy);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.dhx, this.dhw.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.g.e.jG().postDelayed(this.dhy, this.dhw.getEndTime() - System.currentTimeMillis());
        }
    }

    private void ast() {
        String lastId = getLastId();
        if (this.dhw == null || lastId.equals(this.dhw.bFh()) || ao.isEmpty(this.dhw.Wy()) || ao.isEmpty(this.dhw.bFf())) {
            this.dhv.setVisibility(8);
            return;
        }
        this.dhv.setVisibility(0);
        this.dhv.setData(this.dhw.bFf());
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dhz);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.dhz, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void asu() {
        if (this.dhv != null && this.dhw != null) {
            if (getLastId().equals(this.dhw.bFh())) {
                this.dhv.setVisibility(8);
            }
            if (this.dhw.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_collection_tag_state", 0) == 1) {
                    this.dhv.op(false);
                } else {
                    this.dhv.op(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.dhw == null) {
            return "";
        }
        int type = this.dhw.getType();
        if (this.mFrom == 1) {
            str = "key_redpacket_float_maintab_last_id_" + type;
        } else {
            str = "key_redpacket_float_frs_last_id_" + type;
        }
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asv() {
        String str;
        if (this.dhw != null) {
            int type = this.dhw.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString(str, this.dhw.bFh());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dhx);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dhy);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dhz);
        if (this.dhv != null) {
            this.dhv.release();
        }
    }
}
