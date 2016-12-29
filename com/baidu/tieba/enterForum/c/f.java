package com.baidu.tieba.enterForum.c;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.d.j;
import com.baidu.tieba.enterForum.d.m;
import com.baidu.tieba.enterForum.d.u;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.v;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private TbPageContext<?> Gf;
    private ViewEventCenter aRj;
    private SoftReference<j> bqH;
    private com.baidu.tieba.enterForum.a.b bqI;
    private com.baidu.tieba.enterForum.a.a bqJ;
    private int bqK;

    public f(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.Gf = tbPageContext;
        this.aRj = viewEventCenter;
    }

    public j TA() {
        if (this.bqH == null) {
            return null;
        }
        return this.bqH.get();
    }

    public void TB() {
        j jVar = new j(this.Gf.getPageActivity());
        jVar.setEventCenter(this.aRj);
        this.bqH = new SoftReference<>(jVar);
    }

    public int TC() {
        return this.bqK;
    }

    public List<v> getDataList() {
        if (this.bqK == 2) {
            if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                return b(this.bqJ.getDataList(), false);
            }
            return this.bqJ.getDataList();
        }
        return this.bqI.getDataList();
    }

    public void b(v vVar) {
        List<v> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(vVar);
            if (this.bqK == 2) {
                if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                    this.bqJ.A(b(dataList, true));
                    return;
                } else {
                    this.bqJ.A(dataList);
                    return;
                }
            }
            this.bqI.A(dataList);
        }
    }

    public void TD() {
        List<v> dataList = getDataList();
        if (this.bqK == 2) {
            TiebaStatic.eventStat(this.Gf.getPageActivity(), "list_switch_btn", "is_single", 1, new Object[0]);
            this.bqK = 1;
        } else {
            TiebaStatic.eventStat(this.Gf.getPageActivity(), "list_switch_btn", "is_single", 0, new Object[0]);
            this.bqK = 2;
        }
        a(this.bqK, dataList);
    }

    public void a(int i, List<v> list) {
        j jVar;
        this.bqK = i;
        if (this.bqH != null && list != null && (jVar = this.bqH.get()) != null) {
            jVar.setColumnTypeAndRefeshView(i);
            ae(list);
        }
    }

    private List<v> b(List<v> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return null;
        }
        if (list.size() > 0) {
            int size = list.size();
            int i = !z ? size - 2 : size;
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(list.get(i2));
            }
            if (z) {
                arrayList.add(null);
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public void ae(List<v> list) {
        j jVar = this.bqH.get();
        if (jVar != null) {
            if (this.bqK == 2) {
                if (this.bqJ == null) {
                    TF();
                }
                jVar.setGridAdapterIfNeeded(this.bqJ);
                if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                    this.bqJ.A(b(list, true));
                } else {
                    this.bqJ.A(list);
                }
                this.bqJ.a(this.Gf, TbadkCoreApplication.m9getInst().getSkinType());
                return;
            }
            if (this.bqI == null) {
                TE();
            }
            jVar.setListAdapterIfNeeded(this.bqI);
            this.bqI.A(list);
            this.bqI.a(this.Gf, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void TE() {
        this.bqI = new com.baidu.tieba.enterForum.a.b(this.Gf, u.class, r.h.home_like_item_in_edit_list, this.aRj);
        this.bqI.bS(false);
    }

    private void TF() {
        this.bqJ = new com.baidu.tieba.enterForum.a.a(this.Gf, m.class, r.h.home_like_item_in_edit_grid, this.aRj);
        this.bqJ.bS(false);
    }

    public void s(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.bqH.get() != null) {
                this.bqH.get().s(tbPageContext);
            }
            if (this.bqK == 2) {
                if (this.bqJ != null) {
                    this.bqJ.a(tbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
                }
            } else if (this.bqI != null) {
                this.bqI.a(tbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
            }
        }
    }
}
