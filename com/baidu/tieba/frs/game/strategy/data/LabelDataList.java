package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ForumSubLabel;
/* loaded from: classes22.dex */
public class LabelDataList extends ArrayList<a> {
    public void parseProtu(List<ForumSubLabel> list) {
        clear();
        if (!y.isEmpty(list)) {
            for (ForumSubLabel forumSubLabel : list) {
                if (forumSubLabel != null) {
                    a aVar = new a();
                    aVar.labelId = forumSubLabel.id.intValue();
                    aVar.labelName = forumSubLabel.sub_label_name;
                    add(aVar);
                }
            }
            if (!isEmpty()) {
                get(0).isSelect = true;
            }
        }
    }

    public void setSelectedIndex(int i) {
        a aVar = (a) y.getItem(this, i);
        if (aVar != null) {
            aVar.isSelect = true;
            Iterator<a> it = iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next != aVar) {
                    next.isSelect = false;
                }
            }
        }
    }

    public int getSelectedLabelId() {
        Iterator<a> it = iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.isSelect) {
                return next.labelId;
            }
        }
        a aVar = (a) y.getItem(this, 0);
        if (aVar != null) {
            aVar.isSelect = true;
            return aVar.labelId;
        }
        return 0;
    }

    public String getLabelName(int i) {
        Iterator<a> it = iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.labelId == i) {
                return next.labelName;
            }
        }
        return null;
    }
}
