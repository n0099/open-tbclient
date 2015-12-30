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
    private ViewEventCenter aUs;
    private SoftReference<i> aVe;
    private com.baidu.tieba.enterForum.a.b aVf;
    private com.baidu.tieba.enterForum.a.a aVg;
    private int aVh;
    private TbPageContext<?> mContext;

    public g(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.mContext = tbPageContext;
        this.aUs = viewEventCenter;
    }

    public i KE() {
        if (this.aVe == null) {
            return null;
        }
        return this.aVe.get();
    }

    public void KF() {
        i iVar = new i(this.mContext.getPageActivity());
        iVar.setEventCenter(this.aUs);
        this.aVe = new SoftReference<>(iVar);
    }

    public int KG() {
        return this.aVh;
    }

    public List<w> DS() {
        return this.aVh == 2 ? this.aVg.DS() : this.aVf.DS();
    }

    public void b(w wVar) {
        List<w> DS = DS();
        if (DS != null) {
            DS.remove(wVar);
            if (this.aVh == 2) {
                this.aVg.s(DS);
            } else {
                this.aVf.s(DS);
            }
        }
    }

    public void KH() {
        List<w> DS = DS();
        if (this.aVh == 2) {
            TiebaStatic.eventStat(this.mContext.getPageActivity(), "list_switch_btn", "is_single", 1, new Object[0]);
            this.aVh = 1;
        } else {
            TiebaStatic.eventStat(this.mContext.getPageActivity(), "list_switch_btn", "is_single", 0, new Object[0]);
            this.aVh = 2;
        }
        a(this.aVh, DS);
    }

    public void a(int i, List<w> list) {
        i iVar;
        this.aVh = i;
        if (this.aVe != null && list != null && (iVar = this.aVe.get()) != null) {
            iVar.setColumnTypeAndRefeshView(i);
            Q(list);
        }
    }

    public void Q(List<w> list) {
        i iVar = this.aVe.get();
        if (iVar != null) {
            if (this.aVh == 2) {
                if (this.aVg == null) {
                    KJ();
                }
                iVar.setGridAdapterIfNeeded(this.aVg);
                this.aVg.s(list);
                this.aVg.a(this.mContext, TbadkCoreApplication.m411getInst().getSkinType());
                return;
            }
            if (this.aVf == null) {
                KI();
            }
            iVar.setListAdapterIfNeeded(this.aVf);
            this.aVf.s(list);
            this.aVf.a(this.mContext, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    private void KI() {
        this.aVf = new com.baidu.tieba.enterForum.a.b(this.mContext, u.class, n.h.home_like_item_in_edit_list, this.aUs);
        this.aVf.bz(false);
    }

    private void KJ() {
        this.aVg = new com.baidu.tieba.enterForum.a.a(this.mContext, m.class, n.h.home_like_item_in_edit_grid, this.aUs);
        this.aVg.bz(false);
    }

    public void f(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.aVe.get() != null) {
                this.aVe.get().f(tbPageContext);
            }
            if (this.aVh == 2) {
                if (this.aVg != null) {
                    this.aVg.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
                }
            } else if (this.aVf != null) {
                this.aVf.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
            }
        }
    }
}
