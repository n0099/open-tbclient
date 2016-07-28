package com.baidu.tieba.enterForum.c;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.view.j;
import com.baidu.tieba.enterForum.view.m;
import com.baidu.tieba.enterForum.view.u;
import com.baidu.tieba.tbadkCore.x;
import com.baidu.tieba.u;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private TbPageContext<?> DQ;
    private ViewEventCenter bgJ;
    private SoftReference<j> bwo;
    private com.baidu.tieba.enterForum.a.b bwp;
    private com.baidu.tieba.enterForum.a.a bwq;
    private int bwr;

    public f(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.DQ = tbPageContext;
        this.bgJ = viewEventCenter;
    }

    public j Th() {
        if (this.bwo == null) {
            return null;
        }
        return this.bwo.get();
    }

    public void Ti() {
        j jVar = new j(this.DQ.getPageActivity());
        jVar.setEventCenter(this.bgJ);
        this.bwo = new SoftReference<>(jVar);
    }

    public int Tj() {
        return this.bwr;
    }

    public List<x> Ea() {
        if (this.bwr == 2) {
            if (TbadkCoreApplication.m10getInst().getSkinType() != 2) {
                return b(this.bwq.Ea(), false);
            }
            return this.bwq.Ea();
        }
        return this.bwp.Ea();
    }

    public void b(x xVar) {
        List<x> Ea = Ea();
        if (Ea != null) {
            Ea.remove(xVar);
            if (this.bwr == 2) {
                if (TbadkCoreApplication.m10getInst().getSkinType() != 2) {
                    this.bwq.A(b(Ea, true));
                    return;
                } else {
                    this.bwq.A(Ea);
                    return;
                }
            }
            this.bwp.A(Ea);
        }
    }

    public void Tk() {
        List<x> Ea = Ea();
        if (this.bwr == 2) {
            TiebaStatic.eventStat(this.DQ.getPageActivity(), "list_switch_btn", "is_single", 1, new Object[0]);
            this.bwr = 1;
        } else {
            TiebaStatic.eventStat(this.DQ.getPageActivity(), "list_switch_btn", "is_single", 0, new Object[0]);
            this.bwr = 2;
        }
        a(this.bwr, Ea);
    }

    public void a(int i, List<x> list) {
        j jVar;
        this.bwr = i;
        if (this.bwo != null && list != null && (jVar = this.bwo.get()) != null) {
            jVar.setColumnTypeAndRefeshView(i);
            aj(list);
        }
    }

    private List<x> b(List<x> list, boolean z) {
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

    public void aj(List<x> list) {
        j jVar = this.bwo.get();
        if (jVar != null) {
            if (this.bwr == 2) {
                if (this.bwq == null) {
                    Tm();
                }
                jVar.setGridAdapterIfNeeded(this.bwq);
                if (TbadkCoreApplication.m10getInst().getSkinType() != 2) {
                    this.bwq.A(b(list, true));
                } else {
                    this.bwq.A(list);
                }
                this.bwq.a(this.DQ, TbadkCoreApplication.m10getInst().getSkinType());
                return;
            }
            if (this.bwp == null) {
                Tl();
            }
            jVar.setListAdapterIfNeeded(this.bwp);
            this.bwp.A(list);
            this.bwp.a(this.DQ, TbadkCoreApplication.m10getInst().getSkinType());
        }
    }

    private void Tl() {
        this.bwp = new com.baidu.tieba.enterForum.a.b(this.DQ, u.class, u.h.home_like_item_in_edit_list, this.bgJ);
        this.bwp.bO(false);
    }

    private void Tm() {
        this.bwq = new com.baidu.tieba.enterForum.a.a(this.DQ, m.class, u.h.home_like_item_in_edit_grid, this.bgJ);
        this.bwq.bO(false);
    }

    public void n(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.bwo.get() != null) {
                this.bwo.get().n(tbPageContext);
            }
            if (this.bwr == 2) {
                if (this.bwq != null) {
                    this.bwq.a(tbPageContext, TbadkCoreApplication.m10getInst().getSkinType());
                }
            } else if (this.bwp != null) {
                this.bwp.a(tbPageContext, TbadkCoreApplication.m10getInst().getSkinType());
            }
        }
    }
}
