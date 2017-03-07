package com.baidu.tieba.enterForum.model;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.c.j;
import com.baidu.tieba.enterForum.c.m;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.w;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private TbPageContext<?> aaI;
    private ViewEventCenter bEQ;
    private SoftReference<j> bFA;
    private com.baidu.tieba.enterForum.a.b bFB;
    private com.baidu.tieba.enterForum.a.a bFC;
    private int bFD;

    public e(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aaI = tbPageContext;
        this.bEQ = viewEventCenter;
    }

    public j VR() {
        if (this.bFA == null) {
            return null;
        }
        return this.bFA.get();
    }

    public void VS() {
        j jVar = new j(this.aaI.getPageActivity());
        jVar.setEventCenter(this.bEQ);
        this.bFA = new SoftReference<>(jVar);
    }

    public int VT() {
        return this.bFD;
    }

    public List<u> getDataList() {
        if (this.bFD == 2) {
            if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                return d(this.bFC.getDataList(), false);
            }
            return this.bFC.getDataList();
        }
        return this.bFB.getDataList();
    }

    public void b(u uVar) {
        List<u> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(uVar);
            if (this.bFD == 2) {
                if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                    this.bFC.w(d(dataList, true));
                    return;
                } else {
                    this.bFC.w(dataList);
                    return;
                }
            }
            this.bFB.w(dataList);
        }
    }

    public void VU() {
        List<u> dataList = getDataList();
        if (this.bFD == 2) {
            TiebaStatic.eventStat(this.aaI.getPageActivity(), "list_switch_btn", "is_single", 1, new Object[0]);
            this.bFD = 1;
        } else {
            TiebaStatic.eventStat(this.aaI.getPageActivity(), "list_switch_btn", "is_single", 0, new Object[0]);
            this.bFD = 2;
        }
        a(this.bFD, dataList);
    }

    public void a(int i, List<u> list) {
        j jVar;
        this.bFD = i;
        if (this.bFA != null && list != null && (jVar = this.bFA.get()) != null) {
            jVar.setColumnTypeAndRefeshView(i);
            af(list);
        }
    }

    private List<u> d(List<u> list, boolean z) {
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

    public void af(List<u> list) {
        j jVar = this.bFA.get();
        if (jVar != null) {
            if (this.bFD == 2) {
                if (this.bFC == null) {
                    VW();
                }
                jVar.setGridAdapterIfNeeded(this.bFC);
                if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                    this.bFC.w(d(list, true));
                } else {
                    this.bFC.w(list);
                }
                this.bFC.b(this.aaI, TbadkCoreApplication.m9getInst().getSkinType());
                return;
            }
            if (this.bFB == null) {
                VV();
            }
            jVar.setListAdapterIfNeeded(this.bFB);
            this.bFB.w(list);
            this.bFB.b(this.aaI, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void VV() {
        this.bFB = new com.baidu.tieba.enterForum.a.b(this.aaI, com.baidu.tieba.enterForum.c.u.class, w.j.home_like_item_in_edit_list, this.bEQ);
        this.bFB.bS(false);
    }

    private void VW() {
        this.bFC = new com.baidu.tieba.enterForum.a.a(this.aaI, m.class, w.j.home_like_item_in_edit_grid, this.bEQ);
        this.bFC.bS(false);
    }

    public void n(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.bFA.get() != null) {
                this.bFA.get().n(tbPageContext);
            }
            if (this.bFD == 2) {
                if (this.bFC != null) {
                    this.bFC.b(tbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
                }
            } else if (this.bFB != null) {
                this.bFB.b(tbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
            }
        }
    }
}
