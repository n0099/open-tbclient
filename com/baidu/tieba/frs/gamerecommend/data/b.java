package com.baidu.tieba.frs.gamerecommend.data;

import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    public Integer floor;
    public List<bg> sub_nodes = new ArrayList();
    public String title;
    public Integer type;

    public boolean isValid() {
        return !v.T(this.sub_nodes);
    }
}
