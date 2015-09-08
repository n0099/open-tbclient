package com.baidu.tbadk.mvc.b.a;

import com.baidu.tbadk.mvc.b.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a<T> implements l {
    private List<T> mList;

    public List<T> getList() {
        if (this.mList == null) {
            return null;
        }
        return new ArrayList(this.mList);
    }

    public void q(List<T> list) {
        if (list != null) {
            if (this.mList == null) {
                this.mList = new ArrayList();
            }
            this.mList.clear();
            this.mList.addAll(list);
        }
    }
}
