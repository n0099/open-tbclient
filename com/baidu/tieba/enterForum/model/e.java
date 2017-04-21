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
    private TbPageContext<?> aaY;
    private SoftReference<j> bHK;
    private com.baidu.tieba.enterForum.a.b bHL;
    private com.baidu.tieba.enterForum.a.a bHM;
    private int bHN;
    private ViewEventCenter bHa;

    public e(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aaY = tbPageContext;
        this.bHa = viewEventCenter;
    }

    public j Xq() {
        if (this.bHK == null) {
            return null;
        }
        return this.bHK.get();
    }

    public void Xr() {
        j jVar = new j(this.aaY.getPageActivity());
        jVar.setEventCenter(this.bHa);
        this.bHK = new SoftReference<>(jVar);
    }

    public int Xs() {
        return this.bHN;
    }

    public List<u> getDataList() {
        if (this.bHN == 2) {
            if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                return d(this.bHM.getDataList(), false);
            }
            return this.bHM.getDataList();
        }
        return this.bHL.getDataList();
    }

    public void b(u uVar) {
        List<u> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(uVar);
            if (this.bHN == 2) {
                if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                    this.bHM.w(d(dataList, true));
                    return;
                } else {
                    this.bHM.w(dataList);
                    return;
                }
            }
            this.bHL.w(dataList);
        }
    }

    public void Xt() {
        List<u> dataList = getDataList();
        if (this.bHN == 2) {
            TiebaStatic.eventStat(this.aaY.getPageActivity(), "list_switch_btn", "is_single", 1, new Object[0]);
            this.bHN = 1;
        } else {
            TiebaStatic.eventStat(this.aaY.getPageActivity(), "list_switch_btn", "is_single", 0, new Object[0]);
            this.bHN = 2;
        }
        a(this.bHN, dataList);
    }

    public void a(int i, List<u> list) {
        j jVar;
        this.bHN = i;
        if (this.bHK != null && list != null && (jVar = this.bHK.get()) != null) {
            jVar.setColumnTypeAndRefeshView(i);
            ag(list);
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

    public void ag(List<u> list) {
        j jVar = this.bHK.get();
        if (jVar != null) {
            if (this.bHN == 2) {
                if (this.bHM == null) {
                    Xv();
                }
                jVar.setGridAdapterIfNeeded(this.bHM);
                if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                    this.bHM.w(d(list, true));
                } else {
                    this.bHM.w(list);
                }
                this.bHM.b(this.aaY, TbadkCoreApplication.m9getInst().getSkinType());
                return;
            }
            if (this.bHL == null) {
                Xu();
            }
            jVar.setListAdapterIfNeeded(this.bHL);
            this.bHL.w(list);
            this.bHL.b(this.aaY, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void Xu() {
        this.bHL = new com.baidu.tieba.enterForum.a.b(this.aaY, com.baidu.tieba.enterForum.c.u.class, w.j.home_like_item_in_edit_list, this.bHa);
        this.bHL.bU(false);
    }

    private void Xv() {
        this.bHM = new com.baidu.tieba.enterForum.a.a(this.aaY, m.class, w.j.home_like_item_in_edit_grid, this.bHa);
        this.bHM.bU(false);
    }

    public void n(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.bHK.get() != null) {
                this.bHK.get().n(tbPageContext);
            }
            if (this.bHN == 2) {
                if (this.bHM != null) {
                    this.bHM.b(tbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
                }
            } else if (this.bHL != null) {
                this.bHL.b(tbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
            }
        }
    }
}
