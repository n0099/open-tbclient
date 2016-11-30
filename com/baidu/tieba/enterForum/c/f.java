package com.baidu.tieba.enterForum.c;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.d.j;
import com.baidu.tieba.enterForum.d.m;
import com.baidu.tieba.enterForum.d.u;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.w;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private TbPageContext<?> Gf;
    private ViewEventCenter aRS;
    private SoftReference<j> bKD;
    private com.baidu.tieba.enterForum.a.b bKE;
    private com.baidu.tieba.enterForum.a.a bKF;
    private int bKG;

    public f(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.Gf = tbPageContext;
        this.aRS = viewEventCenter;
    }

    public j Zn() {
        if (this.bKD == null) {
            return null;
        }
        return this.bKD.get();
    }

    public void Zo() {
        j jVar = new j(this.Gf.getPageActivity());
        jVar.setEventCenter(this.aRS);
        this.bKD = new SoftReference<>(jVar);
    }

    public int Zp() {
        return this.bKG;
    }

    public List<w> Fy() {
        if (this.bKG == 2) {
            if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                return b(this.bKF.Fy(), false);
            }
            return this.bKF.Fy();
        }
        return this.bKE.Fy();
    }

    public void b(w wVar) {
        List<w> Fy = Fy();
        if (Fy != null) {
            Fy.remove(wVar);
            if (this.bKG == 2) {
                if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                    this.bKF.A(b(Fy, true));
                    return;
                } else {
                    this.bKF.A(Fy);
                    return;
                }
            }
            this.bKE.A(Fy);
        }
    }

    public void Zq() {
        List<w> Fy = Fy();
        if (this.bKG == 2) {
            TiebaStatic.eventStat(this.Gf.getPageActivity(), "list_switch_btn", "is_single", 1, new Object[0]);
            this.bKG = 1;
        } else {
            TiebaStatic.eventStat(this.Gf.getPageActivity(), "list_switch_btn", "is_single", 0, new Object[0]);
            this.bKG = 2;
        }
        a(this.bKG, Fy);
    }

    public void a(int i, List<w> list) {
        j jVar;
        this.bKG = i;
        if (this.bKD != null && list != null && (jVar = this.bKD.get()) != null) {
            jVar.setColumnTypeAndRefeshView(i);
            am(list);
        }
    }

    private List<w> b(List<w> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return null;
        }
        if (list.size() > 0) {
            int size = list.size();
            int i = !z ? size - 2 : size;
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(list.get(i2));
            }
            if (z) {
                arrayList.add(null);
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public void am(List<w> list) {
        j jVar = this.bKD.get();
        if (jVar != null) {
            if (this.bKG == 2) {
                if (this.bKF == null) {
                    Zs();
                }
                jVar.setGridAdapterIfNeeded(this.bKF);
                if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                    this.bKF.A(b(list, true));
                } else {
                    this.bKF.A(list);
                }
                this.bKF.a(this.Gf, TbadkCoreApplication.m9getInst().getSkinType());
                return;
            }
            if (this.bKE == null) {
                Zr();
            }
            jVar.setListAdapterIfNeeded(this.bKE);
            this.bKE.A(list);
            this.bKE.a(this.Gf, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void Zr() {
        this.bKE = new com.baidu.tieba.enterForum.a.b(this.Gf, u.class, r.h.home_like_item_in_edit_list, this.aRS);
        this.bKE.bT(false);
    }

    private void Zs() {
        this.bKF = new com.baidu.tieba.enterForum.a.a(this.Gf, m.class, r.h.home_like_item_in_edit_grid, this.aRS);
        this.bKF.bT(false);
    }

    public void r(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.bKD.get() != null) {
                this.bKD.get().r(tbPageContext);
            }
            if (this.bKG == 2) {
                if (this.bKF != null) {
                    this.bKF.a(tbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
                }
            } else if (this.bKE != null) {
                this.bKE.a(tbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
            }
        }
    }
}
