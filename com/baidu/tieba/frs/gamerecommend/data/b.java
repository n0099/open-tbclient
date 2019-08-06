package com.baidu.tieba.frs.gamerecommend.data;

import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    public Integer floor;
    public List<bh> sub_nodes = new ArrayList();
    public String title;
    public Integer type;

    public boolean isValid() {
        return !v.aa(this.sub_nodes);
    }
}
