package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.tbadk.core.util.ListUtils;
import d.b.i0.p0.s1.a.a.a;
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
            if (next != null && next.f58518a == i) {
                return next.f58519b;
            }
        }
        return null;
    }

    public int getSelectedLabelId() {
        Iterator<a> it = iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.f58520c) {
                return next.f58518a;
            }
        }
        a aVar = (a) ListUtils.getItem(this, 0);
        if (aVar != null) {
            aVar.f58520c = true;
            return aVar.f58518a;
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
                aVar.f58518a = forumSubLabel.id.intValue();
                aVar.f58519b = forumSubLabel.sub_label_name;
                add(aVar);
            }
        }
        if (isEmpty()) {
            return;
        }
        get(0).f58520c = true;
    }

    public void setSelectedIndex(int i) {
        a aVar = (a) ListUtils.getItem(this, i);
        if (aVar != null) {
            aVar.f58520c = true;
            Iterator<a> it = iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next != aVar) {
                    next.f58520c = false;
                }
            }
        }
    }
}
