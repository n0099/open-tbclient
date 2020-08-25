package com.baidu.tieba.frs.gamerecommend.data;

import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class b {
    public Integer floor;
    public List<bw> sub_nodes = new ArrayList();
    public String title;
    public Integer type;

    public boolean isValid() {
        return !y.isEmpty(this.sub_nodes);
    }
}
