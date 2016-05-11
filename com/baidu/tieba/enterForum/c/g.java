package com.baidu.tieba.enterForum.c;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.e.i;
import com.baidu.tieba.enterForum.e.m;
import com.baidu.tieba.enterForum.e.u;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.w;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private TbPageContext<?> Do;
    private ViewEventCenter aXs;
    private SoftReference<i> aYi;
    private com.baidu.tieba.enterForum.a.b aYj;
    private com.baidu.tieba.enterForum.a.a aYk;
    private int aYl;

    public g(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.Do = tbPageContext;
        this.aXs = viewEventCenter;
    }

    public i MW() {
        if (this.aYi == null) {
            return null;
        }
        return this.aYi.get();
    }

    public void MX() {
        i iVar = new i(this.Do.getPageActivity());
        iVar.setEventCenter(this.aXs);
        this.aYi = new SoftReference<>(iVar);
    }

    public int MY() {
        return this.aYl;
    }

    public List<w> DR() {
        if (this.aYl == 2) {
            if (TbadkCoreApplication.m11getInst().getSkinType() != 2) {
                return b(this.aYk.DR(), false);
            }
            return this.aYk.DR();
        }
        return this.aYj.DR();
    }

    public void b(w wVar) {
        List<w> DR = DR();
        if (DR != null) {
            DR.remove(wVar);
            if (this.aYl == 2) {
                if (TbadkCoreApplication.m11getInst().getSkinType() != 2) {
                    this.aYk.z((List) b(DR, true));
                    return;
                } else {
                    this.aYk.z((List) DR);
                    return;
                }
            }
            this.aYj.z((List) DR);
        }
    }

    public void MZ() {
        List<w> DR = DR();
        if (this.aYl == 2) {
            TiebaStatic.eventStat(this.Do.getPageActivity(), "list_switch_btn", "is_single", 1, new Object[0]);
            this.aYl = 1;
        } else {
            TiebaStatic.eventStat(this.Do.getPageActivity(), "list_switch_btn", "is_single", 0, new Object[0]);
            this.aYl = 2;
        }
        a(this.aYl, DR);
    }

    public void a(int i, List<w> list) {
        i iVar;
        this.aYl = i;
        if (this.aYi != null && list != null && (iVar = this.aYi.get()) != null) {
            iVar.setColumnTypeAndRefeshView(i);
            S(list);
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

    public void S(List<w> list) {
        i iVar = this.aYi.get();
        if (iVar != null) {
            if (this.aYl == 2) {
                if (this.aYk == null) {
                    Nb();
                }
                iVar.setGridAdapterIfNeeded(this.aYk);
                if (TbadkCoreApplication.m11getInst().getSkinType() != 2) {
                    this.aYk.z((List) b(list, true));
                } else {
                    this.aYk.z((List) list);
                }
                this.aYk.a(this.Do, TbadkCoreApplication.m11getInst().getSkinType());
                return;
            }
            if (this.aYj == null) {
                Na();
            }
            iVar.setListAdapterIfNeeded(this.aYj);
            this.aYj.z((List) list);
            this.aYj.a(this.Do, TbadkCoreApplication.m11getInst().getSkinType());
        }
    }

    private void Na() {
        this.aYj = new com.baidu.tieba.enterForum.a.b(this.Do, u.class, t.h.home_like_item_in_edit_list, this.aXs);
        this.aYj.bM(false);
    }

    private void Nb() {
        this.aYk = new com.baidu.tieba.enterForum.a.a(this.Do, m.class, t.h.home_like_item_in_edit_grid, this.aXs);
        this.aYk.bM(false);
    }

    public void g(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.aYi.get() != null) {
                this.aYi.get().g(tbPageContext);
            }
            if (this.aYl == 2) {
                if (this.aYk != null) {
                    this.aYk.a(tbPageContext, TbadkCoreApplication.m11getInst().getSkinType());
                }
            } else if (this.aYj != null) {
                this.aYj.a(tbPageContext, TbadkCoreApplication.m11getInst().getSkinType());
            }
        }
    }
}
