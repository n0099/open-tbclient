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
    private TbPageContext<?> Dp;
    private ViewEventCenter bfx;
    private SoftReference<j> bua;
    private com.baidu.tieba.enterForum.a.b bub;
    private com.baidu.tieba.enterForum.a.a buc;
    private int bud;

    public f(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.Dp = tbPageContext;
        this.bfx = viewEventCenter;
    }

    public j Sz() {
        if (this.bua == null) {
            return null;
        }
        return this.bua.get();
    }

    public void SA() {
        j jVar = new j(this.Dp.getPageActivity());
        jVar.setEventCenter(this.bfx);
        this.bua = new SoftReference<>(jVar);
    }

    public int SB() {
        return this.bud;
    }

    public List<x> Eb() {
        if (this.bud == 2) {
            if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                return b(this.buc.Eb(), false);
            }
            return this.buc.Eb();
        }
        return this.bub.Eb();
    }

    public void b(x xVar) {
        List<x> Eb = Eb();
        if (Eb != null) {
            Eb.remove(xVar);
            if (this.bud == 2) {
                if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                    this.buc.A((List) b(Eb, true));
                    return;
                } else {
                    this.buc.A((List) Eb);
                    return;
                }
            }
            this.bub.A((List) Eb);
        }
    }

    public void SC() {
        List<x> Eb = Eb();
        if (this.bud == 2) {
            TiebaStatic.eventStat(this.Dp.getPageActivity(), "list_switch_btn", "is_single", 1, new Object[0]);
            this.bud = 1;
        } else {
            TiebaStatic.eventStat(this.Dp.getPageActivity(), "list_switch_btn", "is_single", 0, new Object[0]);
            this.bud = 2;
        }
        a(this.bud, Eb);
    }

    public void a(int i, List<x> list) {
        j jVar;
        this.bud = i;
        if (this.bua != null && list != null && (jVar = this.bua.get()) != null) {
            jVar.setColumnTypeAndRefeshView(i);
            ae(list);
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

    public void ae(List<x> list) {
        j jVar = this.bua.get();
        if (jVar != null) {
            if (this.bud == 2) {
                if (this.buc == null) {
                    SE();
                }
                jVar.setGridAdapterIfNeeded(this.buc);
                if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                    this.buc.A((List) b(list, true));
                } else {
                    this.buc.A((List) list);
                }
                this.buc.a(this.Dp, TbadkCoreApplication.m9getInst().getSkinType());
                return;
            }
            if (this.bub == null) {
                SD();
            }
            jVar.setListAdapterIfNeeded(this.bub);
            this.bub.A((List) list);
            this.bub.a(this.Dp, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void SD() {
        this.bub = new com.baidu.tieba.enterForum.a.b(this.Dp, u.class, u.h.home_like_item_in_edit_list, this.bfx);
        this.bub.bL(false);
    }

    private void SE() {
        this.buc = new com.baidu.tieba.enterForum.a.a(this.Dp, m.class, u.h.home_like_item_in_edit_grid, this.bfx);
        this.buc.bL(false);
    }

    public void n(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.bua.get() != null) {
                this.bua.get().n(tbPageContext);
            }
            if (this.bud == 2) {
                if (this.buc != null) {
                    this.buc.a(tbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
                }
            } else if (this.bub != null) {
                this.bub.a(tbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
            }
        }
    }
}
