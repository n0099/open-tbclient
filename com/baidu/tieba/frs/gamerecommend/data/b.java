package com.baidu.tieba.frs.gamerecommend.data;

import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    public Integer floor;
    public List<bb> sub_nodes = new ArrayList();
    public String title;
    public Integer type;

    public boolean isValid() {
        return !v.I(this.sub_nodes);
    }
}
