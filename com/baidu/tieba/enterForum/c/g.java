package com.baidu.tieba.enterForum.c;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.d.i;
import com.baidu.tieba.enterForum.d.m;
import com.baidu.tieba.enterForum.d.u;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.v;
import java.lang.ref.SoftReference;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private TbPageContext<?> MX;
    private SoftReference<i> bbZ;
    private ViewEventCenter bbj;
    private com.baidu.tieba.enterForum.a.b bca;
    private com.baidu.tieba.enterForum.a.a bcb;
    private int bcc;

    public g(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.MX = tbPageContext;
        this.bbj = viewEventCenter;
    }

    public i Oj() {
        if (this.bbZ == null) {
            return null;
        }
        return this.bbZ.get();
    }

    public void Ok() {
        i iVar = new i(this.MX.getPageActivity());
        iVar.setEventCenter(this.bbj);
        this.bbZ = new SoftReference<>(iVar);
    }

    public int Ol() {
        return this.bcc;
    }

    public List<v> FZ() {
        return this.bcc == 2 ? this.bcb.FZ() : this.bca.FZ();
    }

    public void b(v vVar) {
        List<v> FZ = FZ();
        if (FZ != null) {
            FZ.remove(vVar);
            if (this.bcc == 2) {
                this.bcb.x(FZ);
            } else {
                this.bca.x(FZ);
            }
        }
    }

    public void Om() {
        List<v> FZ = FZ();
        if (this.bcc == 2) {
            TiebaStatic.eventStat(this.MX.getPageActivity(), "list_switch_btn", "is_single", 1, new Object[0]);
            this.bcc = 1;
        } else {
            TiebaStatic.eventStat(this.MX.getPageActivity(), "list_switch_btn", "is_single", 0, new Object[0]);
            this.bcc = 2;
        }
        a(this.bcc, FZ);
    }

    public void a(int i, List<v> list) {
        i iVar;
        this.bcc = i;
        if (this.bbZ != null && list != null && (iVar = this.bbZ.get()) != null) {
            iVar.setColumnTypeAndRefeshView(i);
            R(list);
        }
    }

    public void R(List<v> list) {
        i iVar = this.bbZ.get();
        if (iVar != null) {
            if (this.bcc == 2) {
                if (this.bcb == null) {
                    Oo();
                }
                iVar.setGridAdapterIfNeeded(this.bcb);
                this.bcb.x(list);
                this.bcb.a(this.MX, TbadkCoreApplication.m411getInst().getSkinType());
                return;
            }
            if (this.bca == null) {
                On();
            }
            iVar.setListAdapterIfNeeded(this.bca);
            this.bca.x(list);
            this.bca.a(this.MX, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    private void On() {
        this.bca = new com.baidu.tieba.enterForum.a.b(this.MX, u.class, t.h.home_like_item_in_edit_list, this.bbj);
        this.bca.bG(false);
    }

    private void Oo() {
        this.bcb = new com.baidu.tieba.enterForum.a.a(this.MX, m.class, t.h.home_like_item_in_edit_grid, this.bbj);
        this.bcb.bG(false);
    }

    public void f(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.bbZ.get() != null) {
                this.bbZ.get().f(tbPageContext);
            }
            if (this.bcc == 2) {
                if (this.bcb != null) {
                    this.bcb.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
                }
            } else if (this.bca != null) {
                this.bca.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
            }
        }
    }
}
