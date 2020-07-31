package com.baidu.tieba.frs.gamerecommend.data;

import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class b {
    public Integer floor;
    public List<bv> sub_nodes = new ArrayList();
    public String title;
    public Integer type;

    public boolean isValid() {
        return !x.isEmpty(this.sub_nodes);
    }
}
