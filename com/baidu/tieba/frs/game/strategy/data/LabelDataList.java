package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.tbadk.core.util.ListUtils;
import d.b.i0.q0.s1.a.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ForumSubLabel;
/* loaded from: classes4.dex */
public class LabelDataList extends ArrayList<a> {
    public String getLabelName(int i) {
        Iterator<a> it = iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.f60187a == i) {
                return next.f60188b;
            }
        }
        return null;
    }

    public int getSelectedLabelId() {
        Iterator<a> it = iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.f60189c) {
                return next.f60187a;
            }
        }
        a aVar = (a) ListUtils.getItem(this, 0);
        if (aVar != null) {
            aVar.f60189c = true;
            return aVar.f60187a;
        }
        return 0;
    }

    public void parseProtu(List<ForumSubLabel> list) {
        clear();
        if (ListUtils.isEmpty(list)) {
            return;
        }
        for (ForumSubLabel forumSubLabel : list) {
            if (forumSubLabel != null) {
                a aVar = new a();
                aVar.f60187a = forumSubLabel.id.intValue();
                aVar.f60188b = forumSubLabel.sub_label_name;
                add(aVar);
            }
        }
        if (isEmpty()) {
            return;
        }
        get(0).f60189c = true;
    }

    public void setSelectedIndex(int i) {
        a aVar = (a) ListUtils.getItem(this, i);
        if (aVar != null) {
            aVar.f60189c = true;
            Iterator<a> it = iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next != aVar) {
                    next.f60189c = false;
                }
            }
        }
    }
}
