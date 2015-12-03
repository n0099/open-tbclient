package com.baidu.tieba.enterForum.c;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.d.i;
import com.baidu.tieba.enterForum.d.m;
import com.baidu.tieba.enterForum.d.u;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.w;
import java.lang.ref.SoftReference;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private ViewEventCenter aQB;
    private SoftReference<i> aRn;
    private com.baidu.tieba.enterForum.a.b aRo;
    private com.baidu.tieba.enterForum.a.a aRp;
    private int aRq;
    private TbPageContext<?> mContext;

    public g(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.mContext = tbPageContext;
        this.aQB = viewEventCenter;
    }

    public i Kl() {
        if (this.aRn == null) {
            return null;
        }
        return this.aRn.get();
    }

    public void Km() {
        i iVar = new i(this.mContext.getPageActivity());
        iVar.setEventCenter(this.aQB);
        this.aRn = new SoftReference<>(iVar);
    }

    public int Kn() {
        return this.aRq;
    }

    public List<w> Ed() {
        return this.aRq == 2 ? this.aRp.Ed() : this.aRo.Ed();
    }

    public void b(w wVar) {
        List<w> Ed = Ed();
        if (Ed != null) {
            Ed.remove(wVar);
            if (this.aRq == 2) {
                this.aRp.r(Ed);
            } else {
                this.aRo.r(Ed);
            }
        }
    }

    public void Ko() {
        List<w> Ed = Ed();
        if (this.aRq == 2) {
            TiebaStatic.eventStat(this.mContext.getPageActivity(), "list_switch_btn", "is_single", 1, new Object[0]);
            this.aRq = 1;
        } else {
            TiebaStatic.eventStat(this.mContext.getPageActivity(), "list_switch_btn", "is_single", 0, new Object[0]);
            this.aRq = 2;
        }
        a(this.aRq, Ed);
    }

    public void a(int i, List<w> list) {
        i iVar;
        this.aRq = i;
        if (this.aRn != null && list != null && (iVar = this.aRn.get()) != null) {
            iVar.setColumnTypeAndRefeshView(i);
            P(list);
        }
    }

    public void P(List<w> list) {
        i iVar = this.aRn.get();
        if (iVar != null) {
            if (this.aRq == 2) {
                if (this.aRp == null) {
                    Kq();
                }
                iVar.setGridAdapterIfNeeded(this.aRp);
                this.aRp.r(list);
                this.aRp.a(this.mContext, TbadkCoreApplication.m411getInst().getSkinType());
                return;
            }
            if (this.aRo == null) {
                Kp();
            }
            iVar.setListAdapterIfNeeded(this.aRo);
            this.aRo.r(list);
            this.aRo.a(this.mContext, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    private void Kp() {
        this.aRo = new com.baidu.tieba.enterForum.a.b(this.mContext, u.class, n.g.home_like_item_in_edit_list, this.aQB);
        this.aRo.bz(false);
    }

    private void Kq() {
        this.aRp = new com.baidu.tieba.enterForum.a.a(this.mContext, m.class, n.g.home_like_item_in_edit_grid, this.aQB);
        this.aRp.bz(false);
    }

    public void f(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.aRn.get() != null) {
                this.aRn.get().f(tbPageContext);
            }
            if (this.aRq == 2) {
                if (this.aRp != null) {
                    this.aRp.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
                }
            } else if (this.aRo != null) {
                this.aRo.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
            }
        }
    }
}
