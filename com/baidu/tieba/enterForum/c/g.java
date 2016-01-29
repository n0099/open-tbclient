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
    private TbPageContext<?> MR;
    private ViewEventCenter aWA;
    private SoftReference<i> aXq;
    private com.baidu.tieba.enterForum.a.b aXr;
    private com.baidu.tieba.enterForum.a.a aXs;
    private int aXt;

    public g(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.MR = tbPageContext;
        this.aWA = viewEventCenter;
    }

    public i Mv() {
        if (this.aXq == null) {
            return null;
        }
        return this.aXq.get();
    }

    public void Mw() {
        i iVar = new i(this.MR.getPageActivity());
        iVar.setEventCenter(this.aWA);
        this.aXq = new SoftReference<>(iVar);
    }

    public int Mx() {
        return this.aXt;
    }

    public List<v> Fm() {
        return this.aXt == 2 ? this.aXs.Fm() : this.aXr.Fm();
    }

    public void b(v vVar) {
        List<v> Fm = Fm();
        if (Fm != null) {
            Fm.remove(vVar);
            if (this.aXt == 2) {
                this.aXs.w(Fm);
            } else {
                this.aXr.w(Fm);
            }
        }
    }

    public void My() {
        List<v> Fm = Fm();
        if (this.aXt == 2) {
            TiebaStatic.eventStat(this.MR.getPageActivity(), "list_switch_btn", "is_single", 1, new Object[0]);
            this.aXt = 1;
        } else {
            TiebaStatic.eventStat(this.MR.getPageActivity(), "list_switch_btn", "is_single", 0, new Object[0]);
            this.aXt = 2;
        }
        a(this.aXt, Fm);
    }

    public void a(int i, List<v> list) {
        i iVar;
        this.aXt = i;
        if (this.aXq != null && list != null && (iVar = this.aXq.get()) != null) {
            iVar.setColumnTypeAndRefeshView(i);
            N(list);
        }
    }

    public void N(List<v> list) {
        i iVar = this.aXq.get();
        if (iVar != null) {
            if (this.aXt == 2) {
                if (this.aXs == null) {
                    MA();
                }
                iVar.setGridAdapterIfNeeded(this.aXs);
                this.aXs.w(list);
                this.aXs.a(this.MR, TbadkCoreApplication.m411getInst().getSkinType());
                return;
            }
            if (this.aXr == null) {
                Mz();
            }
            iVar.setListAdapterIfNeeded(this.aXr);
            this.aXr.w(list);
            this.aXr.a(this.MR, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    private void Mz() {
        this.aXr = new com.baidu.tieba.enterForum.a.b(this.MR, u.class, t.h.home_like_item_in_edit_list, this.aWA);
        this.aXr.bB(false);
    }

    private void MA() {
        this.aXs = new com.baidu.tieba.enterForum.a.a(this.MR, m.class, t.h.home_like_item_in_edit_grid, this.aWA);
        this.aXs.bB(false);
    }

    public void f(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.aXq.get() != null) {
                this.aXq.get().f(tbPageContext);
            }
            if (this.aXt == 2) {
                if (this.aXs != null) {
                    this.aXs.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
                }
            } else if (this.aXr != null) {
                this.aXr.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
            }
        }
    }
}
