package com.baidu.tieba.enterForum.c;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.d.l;
import com.baidu.tieba.enterForum.d.t;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.ae;
import java.lang.ref.SoftReference;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private TbPageContext<?> LH;
    private ViewEventCenter aEU;
    private SoftReference<com.baidu.tieba.enterForum.d.i> aFE;
    private com.baidu.tieba.enterForum.a.b aFF;
    private com.baidu.tieba.enterForum.a.a aFG;
    private int aFH;

    public i(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.LH = tbPageContext;
        this.aEU = viewEventCenter;
    }

    public com.baidu.tieba.enterForum.d.i Ik() {
        if (this.aFE == null) {
            return null;
        }
        return this.aFE.get();
    }

    public void Il() {
        com.baidu.tieba.enterForum.d.i iVar = new com.baidu.tieba.enterForum.d.i(this.LH.getPageActivity());
        iVar.setEventCenter(this.aEU);
        this.aFE = new SoftReference<>(iVar);
    }

    public int Im() {
        return this.aFH;
    }

    public List<ae> CN() {
        return this.aFH == 2 ? this.aFG.CN() : this.aFF.CN();
    }

    public void b(ae aeVar) {
        List<ae> CN = CN();
        if (CN != null) {
            CN.remove(aeVar);
            if (this.aFH == 2) {
                this.aFG.s(CN);
            } else {
                this.aFF.s(CN);
            }
        }
    }

    public void In() {
        List<ae> CN = CN();
        if (this.aFH == 2) {
            TiebaStatic.eventStat(this.LH.getPageActivity(), "list_switch_btn", "is_single", 1, new Object[0]);
            this.aFH = 1;
        } else {
            TiebaStatic.eventStat(this.LH.getPageActivity(), "list_switch_btn", "is_single", 0, new Object[0]);
            this.aFH = 2;
        }
        a(this.aFH, CN);
    }

    public void a(int i, List<ae> list) {
        this.aFH = i;
        if (this.aFE != null && this.aFE.get() != null) {
            this.aFE.get().setColumnTypeAndRefeshView(i);
            M(list);
        }
    }

    public void M(List<ae> list) {
        com.baidu.tieba.enterForum.d.i iVar = this.aFE.get();
        if (iVar != null) {
            if (this.aFH == 2) {
                if (this.aFG == null) {
                    Ip();
                }
                iVar.setGridAdapterIfNeeded(this.aFG);
                this.aFG.s(list);
                this.aFG.a(this.LH, TbadkCoreApplication.m411getInst().getSkinType());
                return;
            }
            if (this.aFF == null) {
                Io();
            }
            iVar.setListAdapterIfNeeded(this.aFF);
            this.aFF.s(list);
            this.aFF.a(this.LH, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    private void Io() {
        this.aFF = new com.baidu.tieba.enterForum.a.b(this.LH, t.class, r.home_like_item_in_edit_list, this.aEU);
        this.aFF.bi(false);
    }

    private void Ip() {
        this.aFG = new com.baidu.tieba.enterForum.a.a(this.LH, l.class, r.home_like_item_in_edit_grid, this.aEU);
        this.aFG.bi(false);
    }

    public void d(TbPageContext<?> tbPageContext) {
        if (this.aFE.get() != null) {
            this.aFE.get().d(tbPageContext);
        }
        if (this.aFH == 2) {
            if (this.aFG != null) {
                this.aFG.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
            }
        } else if (this.aFF != null) {
            this.aFF.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }
}
