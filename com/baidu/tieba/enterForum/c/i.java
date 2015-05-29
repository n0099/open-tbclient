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
    private ViewEventCenter aET;
    private SoftReference<com.baidu.tieba.enterForum.d.i> aFD;
    private com.baidu.tieba.enterForum.a.b aFE;
    private com.baidu.tieba.enterForum.a.a aFF;
    private int aFG;

    public i(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.LH = tbPageContext;
        this.aET = viewEventCenter;
    }

    public com.baidu.tieba.enterForum.d.i Ij() {
        if (this.aFD == null) {
            return null;
        }
        return this.aFD.get();
    }

    public void Ik() {
        com.baidu.tieba.enterForum.d.i iVar = new com.baidu.tieba.enterForum.d.i(this.LH.getPageActivity());
        iVar.setEventCenter(this.aET);
        this.aFD = new SoftReference<>(iVar);
    }

    public int Il() {
        return this.aFG;
    }

    public List<ae> CM() {
        return this.aFG == 2 ? this.aFF.CM() : this.aFE.CM();
    }

    public void b(ae aeVar) {
        List<ae> CM = CM();
        if (CM != null) {
            CM.remove(aeVar);
            if (this.aFG == 2) {
                this.aFF.s(CM);
            } else {
                this.aFE.s(CM);
            }
        }
    }

    public void Im() {
        List<ae> CM = CM();
        if (this.aFG == 2) {
            TiebaStatic.eventStat(this.LH.getPageActivity(), "list_switch_btn", "is_single", 1, new Object[0]);
            this.aFG = 1;
        } else {
            TiebaStatic.eventStat(this.LH.getPageActivity(), "list_switch_btn", "is_single", 0, new Object[0]);
            this.aFG = 2;
        }
        a(this.aFG, CM);
    }

    public void a(int i, List<ae> list) {
        this.aFG = i;
        if (this.aFD != null && this.aFD.get() != null) {
            this.aFD.get().setColumnTypeAndRefeshView(i);
            M(list);
        }
    }

    public void M(List<ae> list) {
        com.baidu.tieba.enterForum.d.i iVar = this.aFD.get();
        if (iVar != null) {
            if (this.aFG == 2) {
                if (this.aFF == null) {
                    Io();
                }
                iVar.setGridAdapterIfNeeded(this.aFF);
                this.aFF.s(list);
                this.aFF.a(this.LH, TbadkCoreApplication.m411getInst().getSkinType());
                return;
            }
            if (this.aFE == null) {
                In();
            }
            iVar.setListAdapterIfNeeded(this.aFE);
            this.aFE.s(list);
            this.aFE.a(this.LH, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    private void In() {
        this.aFE = new com.baidu.tieba.enterForum.a.b(this.LH, t.class, r.home_like_item_in_edit_list, this.aET);
        this.aFE.bi(false);
    }

    private void Io() {
        this.aFF = new com.baidu.tieba.enterForum.a.a(this.LH, l.class, r.home_like_item_in_edit_grid, this.aET);
        this.aFF.bi(false);
    }

    public void d(TbPageContext<?> tbPageContext) {
        if (this.aFD.get() != null) {
            this.aFD.get().d(tbPageContext);
        }
        if (this.aFG == 2) {
            if (this.aFF != null) {
                this.aFF.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
            }
        } else if (this.aFE != null) {
            this.aFE.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }
}
