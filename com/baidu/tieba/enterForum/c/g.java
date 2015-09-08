package com.baidu.tieba.enterForum.c;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.d.i;
import com.baidu.tieba.enterForum.d.l;
import com.baidu.tieba.enterForum.d.t;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.v;
import java.lang.ref.SoftReference;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private ViewEventCenter aMG;
    private SoftReference<i> aNq;
    private com.baidu.tieba.enterForum.a.b aNr;
    private com.baidu.tieba.enterForum.a.a aNs;
    private int aNt;
    private TbPageContext<?> mContext;

    public g(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.mContext = tbPageContext;
        this.aMG = viewEventCenter;
    }

    public i IL() {
        if (this.aNq == null) {
            return null;
        }
        return this.aNq.get();
    }

    public void IM() {
        i iVar = new i(this.mContext.getPageActivity());
        iVar.setEventCenter(this.aMG);
        this.aNq = new SoftReference<>(iVar);
    }

    public int IN() {
        return this.aNt;
    }

    public List<v> Dz() {
        return this.aNt == 2 ? this.aNs.Dz() : this.aNr.Dz();
    }

    public void b(v vVar) {
        List<v> Dz = Dz();
        if (Dz != null) {
            Dz.remove(vVar);
            if (this.aNt == 2) {
                this.aNs.s(Dz);
            } else {
                this.aNr.s(Dz);
            }
        }
    }

    public void IO() {
        List<v> Dz = Dz();
        if (this.aNt == 2) {
            TiebaStatic.eventStat(this.mContext.getPageActivity(), "list_switch_btn", "is_single", 1, new Object[0]);
            this.aNt = 1;
        } else {
            TiebaStatic.eventStat(this.mContext.getPageActivity(), "list_switch_btn", "is_single", 0, new Object[0]);
            this.aNt = 2;
        }
        a(this.aNt, Dz);
    }

    public void a(int i, List<v> list) {
        i iVar;
        this.aNt = i;
        if (this.aNq != null && list != null && (iVar = this.aNq.get()) != null) {
            iVar.setColumnTypeAndRefeshView(i);
            M(list);
        }
    }

    public void M(List<v> list) {
        i iVar = this.aNq.get();
        if (iVar != null) {
            if (this.aNt == 2) {
                if (this.aNs == null) {
                    IQ();
                }
                iVar.setGridAdapterIfNeeded(this.aNs);
                this.aNs.s(list);
                this.aNs.a(this.mContext, TbadkCoreApplication.m411getInst().getSkinType());
                return;
            }
            if (this.aNr == null) {
                IP();
            }
            iVar.setListAdapterIfNeeded(this.aNr);
            this.aNr.s(list);
            this.aNr.a(this.mContext, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    private void IP() {
        this.aNr = new com.baidu.tieba.enterForum.a.b(this.mContext, t.class, i.g.home_like_item_in_edit_list, this.aMG);
        this.aNr.bq(false);
    }

    private void IQ() {
        this.aNs = new com.baidu.tieba.enterForum.a.a(this.mContext, l.class, i.g.home_like_item_in_edit_grid, this.aMG);
        this.aNs.bq(false);
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.aNq.get() != null) {
                this.aNq.get().e(tbPageContext);
            }
            if (this.aNt == 2) {
                if (this.aNs != null) {
                    this.aNs.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
                }
            } else if (this.aNr != null) {
                this.aNr.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
            }
        }
    }
}
