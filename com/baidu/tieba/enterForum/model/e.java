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
    private TbPageContext<?> aaX;
    private ViewEventCenter bEJ;
    private SoftReference<j> bFt;
    private com.baidu.tieba.enterForum.a.b bFu;
    private com.baidu.tieba.enterForum.a.a bFv;
    private int bFw;

    public e(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aaX = tbPageContext;
        this.bEJ = viewEventCenter;
    }

    public j Wp() {
        if (this.bFt == null) {
            return null;
        }
        return this.bFt.get();
    }

    public void Wq() {
        j jVar = new j(this.aaX.getPageActivity());
        jVar.setEventCenter(this.bEJ);
        this.bFt = new SoftReference<>(jVar);
    }

    public int Wr() {
        return this.bFw;
    }

    public List<u> getDataList() {
        if (this.bFw == 2) {
            if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                return d(this.bFv.getDataList(), false);
            }
            return this.bFv.getDataList();
        }
        return this.bFu.getDataList();
    }

    public void b(u uVar) {
        List<u> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(uVar);
            if (this.bFw == 2) {
                if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                    this.bFv.w(d(dataList, true));
                    return;
                } else {
                    this.bFv.w(dataList);
                    return;
                }
            }
            this.bFu.w(dataList);
        }
    }

    public void Ws() {
        List<u> dataList = getDataList();
        if (this.bFw == 2) {
            TiebaStatic.eventStat(this.aaX.getPageActivity(), "list_switch_btn", "is_single", 1, new Object[0]);
            this.bFw = 1;
        } else {
            TiebaStatic.eventStat(this.aaX.getPageActivity(), "list_switch_btn", "is_single", 0, new Object[0]);
            this.bFw = 2;
        }
        a(this.bFw, dataList);
    }

    public void a(int i, List<u> list) {
        j jVar;
        this.bFw = i;
        if (this.bFt != null && list != null && (jVar = this.bFt.get()) != null) {
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
        j jVar = this.bFt.get();
        if (jVar != null) {
            if (this.bFw == 2) {
                if (this.bFv == null) {
                    Wu();
                }
                jVar.setGridAdapterIfNeeded(this.bFv);
                if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                    this.bFv.w(d(list, true));
                } else {
                    this.bFv.w(list);
                }
                this.bFv.b(this.aaX, TbadkCoreApplication.m9getInst().getSkinType());
                return;
            }
            if (this.bFu == null) {
                Wt();
            }
            jVar.setListAdapterIfNeeded(this.bFu);
            this.bFu.w(list);
            this.bFu.b(this.aaX, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void Wt() {
        this.bFu = new com.baidu.tieba.enterForum.a.b(this.aaX, com.baidu.tieba.enterForum.c.u.class, w.j.home_like_item_in_edit_list, this.bEJ);
        this.bFu.bU(false);
    }

    private void Wu() {
        this.bFv = new com.baidu.tieba.enterForum.a.a(this.aaX, m.class, w.j.home_like_item_in_edit_grid, this.bEJ);
        this.bFv.bU(false);
    }

    public void n(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.bFt.get() != null) {
                this.bFt.get().n(tbPageContext);
            }
            if (this.bFw == 2) {
                if (this.bFv != null) {
                    this.bFv.b(tbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
                }
            } else if (this.bFu != null) {
                this.bFu.b(tbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
            }
        }
    }
}
