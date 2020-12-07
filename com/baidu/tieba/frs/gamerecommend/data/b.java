package com.baidu.tieba.frs.gamerecommend.data;

import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class b {
    public Integer floor;
    public List<by> sub_nodes = new ArrayList();
    public String title;
    public Integer type;

    public boolean isValid() {
        return !y.isEmpty(this.sub_nodes);
    }
}
