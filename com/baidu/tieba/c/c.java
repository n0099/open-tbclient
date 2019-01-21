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
    private FloatingAnimationView dhw;
    private m dhx;
    private int mFrom;
    private TbPageContext mPageContext;
    private Runnable dhy = new Runnable() { // from class: com.baidu.tieba.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dhw != null && c.this.dhx != null) {
                c.this.dhw.setData(c.this.dhx.bFg(), 100);
                c.this.dhw.cv();
            }
        }
    };
    private Runnable dhz = new Runnable() { // from class: com.baidu.tieba.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dhw != null && c.this.dhx != null) {
                c.this.dhw.stopAnimation();
                c.this.dhw.setData(c.this.dhx.bFf());
            }
        }
    };
    private Runnable dhA = new Runnable() { // from class: com.baidu.tieba.c.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dhw != null && c.this.dhx != null) {
                c.this.dhw.op(true);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_collection_tag_state", 0);
            }
        }
    };

    public c(TbPageContext tbPageContext, FloatingAnimationView floatingAnimationView, int i) {
        this.dhw = floatingAnimationView;
        this.mPageContext = tbPageContext;
        this.mFrom = i;
        this.dhw.setCallback(new FloatingAnimationView.a() { // from class: com.baidu.tieba.c.c.4
            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void asw() {
                if (c.this.dhx != null && !ao.isEmpty(c.this.dhx.Wy())) {
                    TiebaStatic.log(new am("c12913").y("obj_locate", 2).y("obj_type", c.this.mFrom));
                    if (c.this.dhx.getType() == 2) {
                        c.this.dhw.op(false);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_collection_tag_state", 1);
                    }
                    ay.Es().c(c.this.mPageContext, new String[]{c.this.dhx.Wy()});
                }
            }

            @Override // com.baidu.tieba.view.FloatingAnimationView.a
            public void asx() {
                c.this.asv();
                c.this.onDestroy();
                c.this.dhw.setVisibility(8);
                TiebaStatic.log(new am("c12913").y("obj_locate", 3).y("obj_type", c.this.mFrom));
            }
        });
    }

    public void a(m mVar) {
        if (this.dhw != null) {
            if (mVar == null || mVar.getType() == 0) {
                this.dhw.setVisibility(8);
                return;
            }
            this.dhx = mVar;
            if (this.dhx.getType() == 1) {
                ass();
            } else if (this.dhx.getType() == 2) {
                ast();
            }
            asu();
        }
    }

    private void ass() {
        String lastId = getLastId();
        if (this.dhx == null || lastId.equals(this.dhx.bFh()) || ao.isEmpty(this.dhx.Wy()) || ao.isEmpty(this.dhx.bFf())) {
            this.dhw.setVisibility(8);
            return;
        }
        if (this.dhw.getVisibility() != 0) {
            TiebaStatic.log(new am("c12912").y("obj_locate", this.mFrom));
        }
        this.dhw.setVisibility(0);
        this.dhw.setData(this.dhx.bFf());
        if (this.dhx.getStartTime() > 0 && this.dhx.getEndTime() > 0 && this.dhx.getEndTime() > this.dhx.getStartTime() && !v.I(this.dhx.bFg())) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dhy);
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dhz);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.dhy, this.dhx.getStartTime() - System.currentTimeMillis());
            com.baidu.adp.lib.g.e.jG().postDelayed(this.dhz, this.dhx.getEndTime() - System.currentTimeMillis());
        }
    }

    private void ast() {
        String lastId = getLastId();
        if (this.dhx == null || lastId.equals(this.dhx.bFh()) || ao.isEmpty(this.dhx.Wy()) || ao.isEmpty(this.dhx.bFf())) {
            this.dhw.setVisibility(8);
            return;
        }
        this.dhw.setVisibility(0);
        this.dhw.setData(this.dhx.bFf());
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dhA);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.dhA, UtilHelper.getNextDayMorning() - System.currentTimeMillis());
    }

    public void asu() {
        if (this.dhw != null && this.dhx != null) {
            if (getLastId().equals(this.dhx.bFh())) {
                this.dhw.setVisibility(8);
            }
            if (this.dhx.getType() == 2) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_collection_tag_state", 0) == 1) {
                    this.dhw.op(false);
                } else {
                    this.dhw.op(true);
                }
            }
        }
    }

    private String getLastId() {
        String str;
        if (this.dhx == null) {
            return "";
        }
        int type = this.dhx.getType();
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
        if (this.dhx != null) {
            int type = this.dhx.getType();
            if (this.mFrom == 1) {
                str = "key_redpacket_float_maintab_last_id_" + type;
            } else {
                str = "key_redpacket_float_frs_last_id_" + type;
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString(str, this.dhx.bFh());
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dhy);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dhz);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dhA);
        if (this.dhw != null) {
            this.dhw.release();
        }
    }
}
