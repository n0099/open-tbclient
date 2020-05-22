package com.baidu.tieba.frs.gamerecommend.data;

import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    public Integer floor;
    public List<bk> sub_nodes = new ArrayList();
    public String title;
    public Integer type;

    public boolean isValid() {
        return !v.isEmpty(this.sub_nodes);
    }
}
