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
    private ViewEventCenter aLU;
    private SoftReference<i> aME;
    private com.baidu.tieba.enterForum.a.b aMF;
    private com.baidu.tieba.enterForum.a.a aMG;
    private int aMH;
    private TbPageContext<?> mContext;

    public g(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.mContext = tbPageContext;
        this.aLU = viewEventCenter;
    }

    public i IT() {
        if (this.aME == null) {
            return null;
        }
        return this.aME.get();
    }

    public void IU() {
        i iVar = new i(this.mContext.getPageActivity());
        iVar.setEventCenter(this.aLU);
        this.aME = new SoftReference<>(iVar);
    }

    public int IV() {
        return this.aMH;
    }

    public List<v> Dc() {
        return this.aMH == 2 ? this.aMG.Dc() : this.aMF.Dc();
    }

    public void b(v vVar) {
        List<v> Dc = Dc();
        if (Dc != null) {
            Dc.remove(vVar);
            if (this.aMH == 2) {
                this.aMG.s(Dc);
            } else {
                this.aMF.s(Dc);
            }
        }
    }

    public void IW() {
        List<v> Dc = Dc();
        if (this.aMH == 2) {
            TiebaStatic.eventStat(this.mContext.getPageActivity(), "list_switch_btn", "is_single", 1, new Object[0]);
            this.aMH = 1;
        } else {
            TiebaStatic.eventStat(this.mContext.getPageActivity(), "list_switch_btn", "is_single", 0, new Object[0]);
            this.aMH = 2;
        }
        a(this.aMH, Dc);
    }

    public void a(int i, List<v> list) {
        i iVar;
        this.aMH = i;
        if (this.aME != null && list != null && (iVar = this.aME.get()) != null) {
            iVar.setColumnTypeAndRefeshView(i);
            P(list);
        }
    }

    public void P(List<v> list) {
        i iVar = this.aME.get();
        if (iVar != null) {
            if (this.aMH == 2) {
                if (this.aMG == null) {
                    IY();
                }
                iVar.setGridAdapterIfNeeded(this.aMG);
                this.aMG.s(list);
                this.aMG.a(this.mContext, TbadkCoreApplication.m411getInst().getSkinType());
                return;
            }
            if (this.aMF == null) {
                IX();
            }
            iVar.setListAdapterIfNeeded(this.aMF);
            this.aMF.s(list);
            this.aMF.a(this.mContext, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    private void IX() {
        this.aMF = new com.baidu.tieba.enterForum.a.b(this.mContext, u.class, i.g.home_like_item_in_edit_list, this.aLU);
        this.aMF.br(false);
    }

    private void IY() {
        this.aMG = new com.baidu.tieba.enterForum.a.a(this.mContext, m.class, i.g.home_like_item_in_edit_grid, this.aLU);
        this.aMG.br(false);
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.aME.get() != null) {
                this.aME.get().e(tbPageContext);
            }
            if (this.aMH == 2) {
                if (this.aMG != null) {
                    this.aMG.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
                }
            } else if (this.aMF != null) {
                this.aMF.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
            }
        }
    }
}
