package com.baidu.tieba.frs.gamerecommend.data;

import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    public Integer floor;
    public List<bd> sub_nodes = new ArrayList();
    public String title;
    public Integer type;

    public boolean isValid() {
        return !w.z(this.sub_nodes);
    }
}
