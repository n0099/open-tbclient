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
    private ViewEventCenter aLM;
    private SoftReference<i> aMw;
    private com.baidu.tieba.enterForum.a.b aMx;
    private com.baidu.tieba.enterForum.a.a aMy;
    private int aMz;
    private TbPageContext<?> mContext;

    public g(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.mContext = tbPageContext;
        this.aLM = viewEventCenter;
    }

    public i ID() {
        if (this.aMw == null) {
            return null;
        }
        return this.aMw.get();
    }

    public void IE() {
        i iVar = new i(this.mContext.getPageActivity());
        iVar.setEventCenter(this.aLM);
        this.aMw = new SoftReference<>(iVar);
    }

    public int IF() {
        return this.aMz;
    }

    public List<v> Dj() {
        return this.aMz == 2 ? this.aMy.Dj() : this.aMx.Dj();
    }

    public void b(v vVar) {
        List<v> Dj = Dj();
        if (Dj != null) {
            Dj.remove(vVar);
            if (this.aMz == 2) {
                this.aMy.r(Dj);
            } else {
                this.aMx.r(Dj);
            }
        }
    }

    public void IG() {
        List<v> Dj = Dj();
        if (this.aMz == 2) {
            TiebaStatic.eventStat(this.mContext.getPageActivity(), "list_switch_btn", "is_single", 1, new Object[0]);
            this.aMz = 1;
        } else {
            TiebaStatic.eventStat(this.mContext.getPageActivity(), "list_switch_btn", "is_single", 0, new Object[0]);
            this.aMz = 2;
        }
        a(this.aMz, Dj);
    }

    public void a(int i, List<v> list) {
        i iVar;
        this.aMz = i;
        if (this.aMw != null && list != null && (iVar = this.aMw.get()) != null) {
            iVar.setColumnTypeAndRefeshView(i);
            N(list);
        }
    }

    public void N(List<v> list) {
        i iVar = this.aMw.get();
        if (iVar != null) {
            if (this.aMz == 2) {
                if (this.aMy == null) {
                    II();
                }
                iVar.setGridAdapterIfNeeded(this.aMy);
                this.aMy.r(list);
                this.aMy.a(this.mContext, TbadkCoreApplication.m411getInst().getSkinType());
                return;
            }
            if (this.aMx == null) {
                IH();
            }
            iVar.setListAdapterIfNeeded(this.aMx);
            this.aMx.r(list);
            this.aMx.a(this.mContext, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    private void IH() {
        this.aMx = new com.baidu.tieba.enterForum.a.b(this.mContext, u.class, i.g.home_like_item_in_edit_list, this.aLM);
        this.aMx.bo(false);
    }

    private void II() {
        this.aMy = new com.baidu.tieba.enterForum.a.a(this.mContext, m.class, i.g.home_like_item_in_edit_grid, this.aLM);
        this.aMy.bo(false);
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.aMw.get() != null) {
                this.aMw.get().e(tbPageContext);
            }
            if (this.aMz == 2) {
                if (this.aMy != null) {
                    this.aMy.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
                }
            } else if (this.aMx != null) {
                this.aMx.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
            }
        }
    }
}
