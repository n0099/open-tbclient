package com.baidu.tieba.enterForum.c;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.e.j;
import com.baidu.tieba.enterForum.e.m;
import com.baidu.tieba.enterForum.e.u;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.w;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private TbPageContext<?> Gd;
    private ViewEventCenter aOw;
    private SoftReference<j> bHC;
    private com.baidu.tieba.enterForum.a.b bHD;
    private com.baidu.tieba.enterForum.a.a bHE;
    private int bHF;

    public f(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.Gd = tbPageContext;
        this.aOw = viewEventCenter;
    }

    public j XS() {
        if (this.bHC == null) {
            return null;
        }
        return this.bHC.get();
    }

    public void XT() {
        j jVar = new j(this.Gd.getPageActivity());
        jVar.setEventCenter(this.aOw);
        this.bHC = new SoftReference<>(jVar);
    }

    public int XU() {
        return this.bHF;
    }

    public List<w> Fu() {
        if (this.bHF == 2) {
            if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                return b(this.bHE.Fu(), false);
            }
            return this.bHE.Fu();
        }
        return this.bHD.Fu();
    }

    public void b(w wVar) {
        List<w> Fu = Fu();
        if (Fu != null) {
            Fu.remove(wVar);
            if (this.bHF == 2) {
                if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                    this.bHE.A(b(Fu, true));
                    return;
                } else {
                    this.bHE.A(Fu);
                    return;
                }
            }
            this.bHD.A(Fu);
        }
    }

    public void XV() {
        List<w> Fu = Fu();
        if (this.bHF == 2) {
            TiebaStatic.eventStat(this.Gd.getPageActivity(), "list_switch_btn", "is_single", 1, new Object[0]);
            this.bHF = 1;
        } else {
            TiebaStatic.eventStat(this.Gd.getPageActivity(), "list_switch_btn", "is_single", 0, new Object[0]);
            this.bHF = 2;
        }
        a(this.bHF, Fu);
    }

    public void a(int i, List<w> list) {
        j jVar;
        this.bHF = i;
        if (this.bHC != null && list != null && (jVar = this.bHC.get()) != null) {
            jVar.setColumnTypeAndRefeshView(i);
            al(list);
        }
    }

    private List<w> b(List<w> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            return null;
        }
        int size = list.size();
        int i = !z ? size - 2 : size;
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(list.get(i2));
        }
        if (z) {
            arrayList.add(null);
            arrayList.add(null);
        }
        return arrayList;
    }

    public void al(List<w> list) {
        j jVar = this.bHC.get();
        if (jVar != null) {
            if (this.bHF == 2) {
                if (this.bHE == null) {
                    XX();
                }
                jVar.setGridAdapterIfNeeded(this.bHE);
                if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                    this.bHE.A(b(list, true));
                } else {
                    this.bHE.A(list);
                }
                this.bHE.a(this.Gd, TbadkCoreApplication.m9getInst().getSkinType());
                return;
            }
            if (this.bHD == null) {
                XW();
            }
            jVar.setListAdapterIfNeeded(this.bHD);
            this.bHD.A(list);
            this.bHD.a(this.Gd, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void XW() {
        this.bHD = new com.baidu.tieba.enterForum.a.b(this.Gd, u.class, t.h.home_like_item_in_edit_list, this.aOw);
        this.bHD.bQ(false);
    }

    private void XX() {
        this.bHE = new com.baidu.tieba.enterForum.a.a(this.Gd, m.class, t.h.home_like_item_in_edit_grid, this.aOw);
        this.bHE.bQ(false);
    }

    public void n(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.bHC.get() != null) {
                this.bHC.get().n(tbPageContext);
            }
            if (this.bHF == 2) {
                if (this.bHE != null) {
                    this.bHE.a(tbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
                }
            } else if (this.bHD != null) {
                this.bHD.a(tbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
            }
        }
    }
}
