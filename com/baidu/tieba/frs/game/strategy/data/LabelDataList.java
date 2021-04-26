package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.tbadk.core.util.ListUtils;
import d.a.j0.q0.s1.a.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ForumSubLabel;
/* loaded from: classes4.dex */
public class LabelDataList extends ArrayList<a> {
    public String getLabelName(int i2) {
        Iterator<a> it = iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.f58713a == i2) {
                return next.f58714b;
            }
        }
        return null;
    }

    public int getSelectedLabelId() {
        Iterator<a> it = iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.f58715c) {
                return next.f58713a;
            }
        }
        a aVar = (a) ListUtils.getItem(this, 0);
        if (aVar != null) {
            aVar.f58715c = true;
            return aVar.f58713a;
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
                aVar.f58713a = forumSubLabel.id.intValue();
                aVar.f58714b = forumSubLabel.sub_label_name;
                add(aVar);
            }
        }
        if (isEmpty()) {
            return;
        }
        get(0).f58715c = true;
    }

    public void setSelectedIndex(int i2) {
        a aVar = (a) ListUtils.getItem(this, i2);
        if (aVar != null) {
            aVar.f58715c = true;
            Iterator<a> it = iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next != aVar) {
                    next.f58715c = false;
                }
            }
        }
    }
}
