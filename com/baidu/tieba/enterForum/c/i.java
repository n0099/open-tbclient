package com.baidu.tieba.enterForum.c;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.d.l;
import com.baidu.tieba.enterForum.d.t;
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.w;
import java.lang.ref.SoftReference;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private TbPageContext<?> LP;
    private ViewEventCenter aCS;
    private SoftReference<com.baidu.tieba.enterForum.d.i> aDB;
    private com.baidu.tieba.enterForum.a.b aDC;
    private com.baidu.tieba.enterForum.a.a aDD;
    private int aDE;

    public i(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.LP = tbPageContext;
        this.aCS = viewEventCenter;
    }

    public com.baidu.tieba.enterForum.d.i Hj() {
        if (this.aDB == null) {
            return null;
        }
        return this.aDB.get();
    }

    public void Hk() {
        com.baidu.tieba.enterForum.d.i iVar = new com.baidu.tieba.enterForum.d.i(this.LP.getPageActivity());
        iVar.setEventCenter(this.aCS);
        this.aDB = new SoftReference<>(iVar);
    }

    public int Hl() {
        return this.aDE;
    }

    public List<ae> Ca() {
        return this.aDE == 2 ? this.aDD.Ca() : this.aDC.Ca();
    }

    public void b(ae aeVar) {
        List<ae> Ca = Ca();
        if (Ca != null) {
            Ca.remove(aeVar);
            if (this.aDE == 2) {
                this.aDD.r(Ca);
            } else {
                this.aDC.r(Ca);
            }
        }
    }

    public void Hm() {
        List<ae> Ca = Ca();
        if (this.aDE == 2) {
            TiebaStatic.eventStat(this.LP.getPageActivity(), "list_switch_btn", "is_single", 1, new Object[0]);
            this.aDE = 1;
        } else {
            TiebaStatic.eventStat(this.LP.getPageActivity(), "list_switch_btn", "is_single", 0, new Object[0]);
            this.aDE = 2;
        }
        a(this.aDE, Ca);
    }

    public void a(int i, List<ae> list) {
        this.aDE = i;
        if (this.aDB != null && this.aDB.get() != null) {
            this.aDB.get().setColumnTypeAndRefeshView(i);
            J(list);
        }
    }

    public void J(List<ae> list) {
        com.baidu.tieba.enterForum.d.i iVar = this.aDB.get();
        if (iVar != null) {
            if (this.aDE == 2) {
                if (this.aDD == null) {
                    Ho();
                }
                iVar.setGridAdapterIfNeeded(this.aDD);
                this.aDD.r(list);
                this.aDD.a(this.LP, TbadkCoreApplication.m411getInst().getSkinType());
                return;
            }
            if (this.aDC == null) {
                Hn();
            }
            iVar.setListAdapterIfNeeded(this.aDC);
            this.aDC.r(list);
            this.aDC.a(this.LP, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    private void Hn() {
        this.aDC = new com.baidu.tieba.enterForum.a.b(this.LP, t.class, w.home_like_item_in_edit_list, this.aCS);
        this.aDC.bb(false);
    }

    private void Ho() {
        this.aDD = new com.baidu.tieba.enterForum.a.a(this.LP, l.class, w.home_like_item_in_edit_grid, this.aCS);
        this.aDD.bb(false);
    }

    public void f(TbPageContext<?> tbPageContext) {
        if (this.aDB.get() != null) {
            this.aDB.get().f(tbPageContext);
        }
        if (this.aDE == 2) {
            if (this.aDD != null) {
                this.aDD.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
            }
        } else if (this.aDC != null) {
            this.aDC.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }
}
