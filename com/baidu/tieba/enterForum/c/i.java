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
    private TbPageContext<?> LN;
    private ViewEventCenter aCK;
    private SoftReference<com.baidu.tieba.enterForum.d.i> aDt;
    private com.baidu.tieba.enterForum.a.b aDu;
    private com.baidu.tieba.enterForum.a.a aDv;
    private int aDw;

    public i(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.LN = tbPageContext;
        this.aCK = viewEventCenter;
    }

    public com.baidu.tieba.enterForum.d.i Hd() {
        if (this.aDt == null) {
            return null;
        }
        return this.aDt.get();
    }

    public void He() {
        com.baidu.tieba.enterForum.d.i iVar = new com.baidu.tieba.enterForum.d.i(this.LN.getPageActivity());
        iVar.setEventCenter(this.aCK);
        this.aDt = new SoftReference<>(iVar);
    }

    public int Hf() {
        return this.aDw;
    }

    public List<ae> BU() {
        return this.aDw == 2 ? this.aDv.BU() : this.aDu.BU();
    }

    public void b(ae aeVar) {
        List<ae> BU = BU();
        if (BU != null) {
            BU.remove(aeVar);
            if (this.aDw == 2) {
                this.aDv.r(BU);
            } else {
                this.aDu.r(BU);
            }
        }
    }

    public void Hg() {
        List<ae> BU = BU();
        if (this.aDw == 2) {
            TiebaStatic.eventStat(this.LN.getPageActivity(), "list_switch_btn", "is_single", 1, new Object[0]);
            this.aDw = 1;
        } else {
            TiebaStatic.eventStat(this.LN.getPageActivity(), "list_switch_btn", "is_single", 0, new Object[0]);
            this.aDw = 2;
        }
        a(this.aDw, BU);
    }

    public void a(int i, List<ae> list) {
        this.aDw = i;
        if (this.aDt != null && this.aDt.get() != null) {
            this.aDt.get().setColumnTypeAndRefeshView(i);
            J(list);
        }
    }

    public void J(List<ae> list) {
        com.baidu.tieba.enterForum.d.i iVar = this.aDt.get();
        if (iVar != null) {
            if (this.aDw == 2) {
                if (this.aDv == null) {
                    Hi();
                }
                iVar.setGridAdapterIfNeeded(this.aDv);
                this.aDv.r(list);
                this.aDv.a(this.LN, TbadkCoreApplication.m411getInst().getSkinType());
                return;
            }
            if (this.aDu == null) {
                Hh();
            }
            iVar.setListAdapterIfNeeded(this.aDu);
            this.aDu.r(list);
            this.aDu.a(this.LN, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    private void Hh() {
        this.aDu = new com.baidu.tieba.enterForum.a.b(this.LN, t.class, w.home_like_item_in_edit_list, this.aCK);
        this.aDu.bb(false);
    }

    private void Hi() {
        this.aDv = new com.baidu.tieba.enterForum.a.a(this.LN, l.class, w.home_like_item_in_edit_grid, this.aCK);
        this.aDv.bb(false);
    }

    public void f(TbPageContext<?> tbPageContext) {
        if (this.aDt.get() != null) {
            this.aDt.get().f(tbPageContext);
        }
        if (this.aDw == 2) {
            if (this.aDv != null) {
                this.aDv.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
            }
        } else if (this.aDu != null) {
            this.aDu.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }
}
