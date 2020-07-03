package com.baidu.tieba.frs.gamerecommend.data;

import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    public Integer floor;
    public List<bu> sub_nodes = new ArrayList();
    public String title;
    public Integer type;

    public boolean isValid() {
        return !w.isEmpty(this.sub_nodes);
    }
}
