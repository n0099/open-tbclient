package com.baidu.tieba.enterForum.model;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.c.j;
import com.baidu.tieba.enterForum.c.m;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.u;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private TbPageContext<?> Fp;
    private ViewEventCenter bxK;
    private SoftReference<j> byu;
    private com.baidu.tieba.enterForum.a.b byv;
    private com.baidu.tieba.enterForum.a.a byw;
    private int byx;

    public e(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.Fp = tbPageContext;
        this.bxK = viewEventCenter;
    }

    public j UT() {
        if (this.byu == null) {
            return null;
        }
        return this.byu.get();
    }

    public void UU() {
        j jVar = new j(this.Fp.getPageActivity());
        jVar.setEventCenter(this.bxK);
        this.byu = new SoftReference<>(jVar);
    }

    public int UV() {
        return this.byx;
    }

    public List<u> getDataList() {
        if (this.byx == 2) {
            if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                return d(this.byw.getDataList(), false);
            }
            return this.byw.getDataList();
        }
        return this.byv.getDataList();
    }

    public void b(u uVar) {
        List<u> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(uVar);
            if (this.byx == 2) {
                if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                    this.byw.y(d(dataList, true));
                    return;
                } else {
                    this.byw.y(dataList);
                    return;
                }
            }
            this.byv.y(dataList);
        }
    }

    public void UW() {
        List<u> dataList = getDataList();
        if (this.byx == 2) {
            TiebaStatic.eventStat(this.Fp.getPageActivity(), "list_switch_btn", "is_single", 1, new Object[0]);
            this.byx = 1;
        } else {
            TiebaStatic.eventStat(this.Fp.getPageActivity(), "list_switch_btn", "is_single", 0, new Object[0]);
            this.byx = 2;
        }
        a(this.byx, dataList);
    }

    public void a(int i, List<u> list) {
        j jVar;
        this.byx = i;
        if (this.byu != null && list != null && (jVar = this.byu.get()) != null) {
            jVar.setColumnTypeAndRefeshView(i);
            ai(list);
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

    public void ai(List<u> list) {
        j jVar = this.byu.get();
        if (jVar != null) {
            if (this.byx == 2) {
                if (this.byw == null) {
                    UY();
                }
                jVar.setGridAdapterIfNeeded(this.byw);
                if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                    this.byw.y(d(list, true));
                } else {
                    this.byw.y(list);
                }
                this.byw.a(this.Fp, TbadkCoreApplication.m9getInst().getSkinType());
                return;
            }
            if (this.byv == null) {
                UX();
            }
            jVar.setListAdapterIfNeeded(this.byv);
            this.byv.y(list);
            this.byv.a(this.Fp, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void UX() {
        this.byv = new com.baidu.tieba.enterForum.a.b(this.Fp, com.baidu.tieba.enterForum.c.u.class, r.j.home_like_item_in_edit_list, this.bxK);
        this.byv.bS(false);
    }

    private void UY() {
        this.byw = new com.baidu.tieba.enterForum.a.a(this.Fp, m.class, r.j.home_like_item_in_edit_grid, this.bxK);
        this.byw.bS(false);
    }

    public void n(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.byu.get() != null) {
                this.byu.get().n(tbPageContext);
            }
            if (this.byx == 2) {
                if (this.byw != null) {
                    this.byw.a(tbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
                }
            } else if (this.byv != null) {
                this.byv.a(tbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
            }
        }
    }
}
