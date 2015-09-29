package com.baidu.tieba.enterForum.c;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.d.i;
import com.baidu.tieba.enterForum.d.m;
import com.baidu.tieba.enterForum.d.u;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.v;
import java.lang.ref.SoftReference;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private ViewEventCenter aLB;
    private SoftReference<i> aMl;
    private com.baidu.tieba.enterForum.a.b aMm;
    private com.baidu.tieba.enterForum.a.a aMn;
    private int aMo;
    private TbPageContext<?> mContext;

    public g(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.mContext = tbPageContext;
        this.aLB = viewEventCenter;
    }

    public i IH() {
        if (this.aMl == null) {
            return null;
        }
        return this.aMl.get();
    }

    public void II() {
        i iVar = new i(this.mContext.getPageActivity());
        iVar.setEventCenter(this.aLB);
        this.aMl = new SoftReference<>(iVar);
    }

    public int IJ() {
        return this.aMo;
    }

    public List<v> Dm() {
        return this.aMo == 2 ? this.aMn.Dm() : this.aMm.Dm();
    }

    public void b(v vVar) {
        List<v> Dm = Dm();
        if (Dm != null) {
            Dm.remove(vVar);
            if (this.aMo == 2) {
                this.aMn.r(Dm);
            } else {
                this.aMm.r(Dm);
            }
        }
    }

    public void IK() {
        List<v> Dm = Dm();
        if (this.aMo == 2) {
            TiebaStatic.eventStat(this.mContext.getPageActivity(), "list_switch_btn", "is_single", 1, new Object[0]);
            this.aMo = 1;
        } else {
            TiebaStatic.eventStat(this.mContext.getPageActivity(), "list_switch_btn", "is_single", 0, new Object[0]);
            this.aMo = 2;
        }
        a(this.aMo, Dm);
    }

    public void a(int i, List<v> list) {
        i iVar;
        this.aMo = i;
        if (this.aMl != null && list != null && (iVar = this.aMl.get()) != null) {
            iVar.setColumnTypeAndRefeshView(i);
            N(list);
        }
    }

    public void N(List<v> list) {
        i iVar = this.aMl.get();
        if (iVar != null) {
            if (this.aMo == 2) {
                if (this.aMn == null) {
                    IM();
                }
                iVar.setGridAdapterIfNeeded(this.aMn);
                this.aMn.r(list);
                this.aMn.a(this.mContext, TbadkCoreApplication.m411getInst().getSkinType());
                return;
            }
            if (this.aMm == null) {
                IL();
            }
            iVar.setListAdapterIfNeeded(this.aMm);
            this.aMm.r(list);
            this.aMm.a(this.mContext, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    private void IL() {
        this.aMm = new com.baidu.tieba.enterForum.a.b(this.mContext, u.class, i.g.home_like_item_in_edit_list, this.aLB);
        this.aMm.bo(false);
    }

    private void IM() {
        this.aMn = new com.baidu.tieba.enterForum.a.a(this.mContext, m.class, i.g.home_like_item_in_edit_grid, this.aLB);
        this.aMn.bo(false);
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.aMl.get() != null) {
                this.aMl.get().e(tbPageContext);
            }
            if (this.aMo == 2) {
                if (this.aMn != null) {
                    this.aMn.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
                }
            } else if (this.aMm != null) {
                this.aMm.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
            }
        }
    }
}
