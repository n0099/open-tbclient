package com.baidu.tieba.enterForum.c;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.d.i;
import com.baidu.tieba.enterForum.d.l;
import com.baidu.tieba.enterForum.d.t;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.u;
import java.lang.ref.SoftReference;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private TbPageContext<?> LS;
    private ViewEventCenter aMt;
    private SoftReference<i> aNd;
    private com.baidu.tieba.enterForum.a.b aNe;
    private com.baidu.tieba.enterForum.a.a aNf;
    private int aNg;

    public g(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.LS = tbPageContext;
        this.aMt = viewEventCenter;
    }

    public i IX() {
        if (this.aNd == null) {
            return null;
        }
        return this.aNd.get();
    }

    public void IY() {
        i iVar = new i(this.LS.getPageActivity());
        iVar.setEventCenter(this.aMt);
        this.aNd = new SoftReference<>(iVar);
    }

    public int IZ() {
        return this.aNg;
    }

    public List<u> Dp() {
        return this.aNg == 2 ? this.aNf.Dp() : this.aNe.Dp();
    }

    public void b(u uVar) {
        List<u> Dp = Dp();
        if (Dp != null) {
            Dp.remove(uVar);
            if (this.aNg == 2) {
                this.aNf.r(Dp);
            } else {
                this.aNe.r(Dp);
            }
        }
    }

    public void Ja() {
        List<u> Dp = Dp();
        if (this.aNg == 2) {
            TiebaStatic.eventStat(this.LS.getPageActivity(), "list_switch_btn", "is_single", 1, new Object[0]);
            this.aNg = 1;
        } else {
            TiebaStatic.eventStat(this.LS.getPageActivity(), "list_switch_btn", "is_single", 0, new Object[0]);
            this.aNg = 2;
        }
        a(this.aNg, Dp);
    }

    public void a(int i, List<u> list) {
        i iVar;
        this.aNg = i;
        if (this.aNd != null && list != null && (iVar = this.aNd.get()) != null) {
            iVar.setColumnTypeAndRefeshView(i);
            L(list);
        }
    }

    public void L(List<u> list) {
        i iVar = this.aNd.get();
        if (iVar != null) {
            if (this.aNg == 2) {
                if (this.aNf == null) {
                    Jc();
                }
                iVar.setGridAdapterIfNeeded(this.aNf);
                this.aNf.r(list);
                this.aNf.a(this.LS, TbadkCoreApplication.m411getInst().getSkinType());
                return;
            }
            if (this.aNe == null) {
                Jb();
            }
            iVar.setListAdapterIfNeeded(this.aNe);
            this.aNe.r(list);
            this.aNe.a(this.LS, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    private void Jb() {
        this.aNe = new com.baidu.tieba.enterForum.a.b(this.LS, t.class, i.g.home_like_item_in_edit_list, this.aMt);
        this.aNe.bj(false);
    }

    private void Jc() {
        this.aNf = new com.baidu.tieba.enterForum.a.a(this.LS, l.class, i.g.home_like_item_in_edit_grid, this.aMt);
        this.aNf.bj(false);
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.aNd.get() != null) {
                this.aNd.get().e(tbPageContext);
            }
            if (this.aNg == 2) {
                if (this.aNf != null) {
                    this.aNf.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
                }
            } else if (this.aNe != null) {
                this.aNe.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
            }
        }
    }
}
