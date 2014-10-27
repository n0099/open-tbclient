package com.baidu.tieba.im.frsgroup;

import com.baidu.tieba.im.data.GroupInfoData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class m extends k implements com.baidu.tbadk.mvc.b.k {
    private Set<Integer> aXh = new HashSet();
    private int index;

    public m(int i) {
        this.index = i;
    }

    public void a(k kVar) {
        if (kVar != null) {
            this.groupPerm = kVar.getGroupPerm();
            if (this.groups == null) {
                this.groups = new ArrayList();
            }
            if (kVar.getGroups() != null) {
                int size = kVar.getGroups().size();
                for (int i = 0; i < size; i++) {
                    GroupInfoData groupInfoData = kVar.getGroups().get(i);
                    if (groupInfoData != null && this.aXh.add(Integer.valueOf(groupInfoData.getGroupId()))) {
                        this.groups.add(groupInfoData);
                    }
                }
            }
        }
    }

    public void clear() {
        this.groupPerm = null;
        this.groups = null;
        this.aXh.clear();
    }
}
