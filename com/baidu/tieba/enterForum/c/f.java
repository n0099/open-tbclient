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
    private TbPageContext<?> Gd;
    private ViewEventCenter aPL;
    private SoftReference<j> bHJ;
    private com.baidu.tieba.enterForum.a.b bHK;
    private com.baidu.tieba.enterForum.a.a bHL;
    private int bHM;

    public f(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.Gd = tbPageContext;
        this.aPL = viewEventCenter;
    }

    public j Yl() {
        if (this.bHJ == null) {
            return null;
        }
        return this.bHJ.get();
    }

    public void Ym() {
        j jVar = new j(this.Gd.getPageActivity());
        jVar.setEventCenter(this.aPL);
        this.bHJ = new SoftReference<>(jVar);
    }

    public int Yn() {
        return this.bHM;
    }

    public List<w> Ft() {
        if (this.bHM == 2) {
            if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                return b(this.bHL.Ft(), false);
            }
            return this.bHL.Ft();
        }
        return this.bHK.Ft();
    }

    public void b(w wVar) {
        List<w> Ft = Ft();
        if (Ft != null) {
            Ft.remove(wVar);
            if (this.bHM == 2) {
                if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                    this.bHL.A(b(Ft, true));
                    return;
                } else {
                    this.bHL.A(Ft);
                    return;
                }
            }
            this.bHK.A(Ft);
        }
    }

    public void Yo() {
        List<w> Ft = Ft();
        if (this.bHM == 2) {
            TiebaStatic.eventStat(this.Gd.getPageActivity(), "list_switch_btn", "is_single", 1, new Object[0]);
            this.bHM = 1;
        } else {
            TiebaStatic.eventStat(this.Gd.getPageActivity(), "list_switch_btn", "is_single", 0, new Object[0]);
            this.bHM = 2;
        }
        a(this.bHM, Ft);
    }

    public void a(int i, List<w> list) {
        j jVar;
        this.bHM = i;
        if (this.bHJ != null && list != null && (jVar = this.bHJ.get()) != null) {
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
        j jVar = this.bHJ.get();
        if (jVar != null) {
            if (this.bHM == 2) {
                if (this.bHL == null) {
                    Yq();
                }
                jVar.setGridAdapterIfNeeded(this.bHL);
                if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                    this.bHL.A(b(list, true));
                } else {
                    this.bHL.A(list);
                }
                this.bHL.a(this.Gd, TbadkCoreApplication.m9getInst().getSkinType());
                return;
            }
            if (this.bHK == null) {
                Yp();
            }
            jVar.setListAdapterIfNeeded(this.bHK);
            this.bHK.A(list);
            this.bHK.a(this.Gd, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void Yp() {
        this.bHK = new com.baidu.tieba.enterForum.a.b(this.Gd, u.class, r.h.home_like_item_in_edit_list, this.aPL);
        this.bHK.bP(false);
    }

    private void Yq() {
        this.bHL = new com.baidu.tieba.enterForum.a.a(this.Gd, m.class, r.h.home_like_item_in_edit_grid, this.aPL);
        this.bHL.bP(false);
    }

    public void q(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.bHJ.get() != null) {
                this.bHJ.get().q(tbPageContext);
            }
            if (this.bHM == 2) {
                if (this.bHL != null) {
                    this.bHL.a(tbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
                }
            } else if (this.bHK != null) {
                this.bHK.a(tbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
            }
        }
    }
}
