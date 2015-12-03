package com.baidu.tieba.homepage.fragment.data;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.tbadk.core.util.y;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.HomePage.ModuleItem;
import tbclient.HomePage.UserModule;
/* loaded from: classes.dex */
public class UserModuleData extends i implements Serializable {
    private static final long serialVersionUID = -6093236055331291800L;
    public List<ModuleItemData> moduleDataList = null;

    public void parserProtobuf(UserModule userModule) {
        if (userModule != null && userModule.items != null) {
            this.moduleDataList = new ArrayList();
            for (ModuleItem moduleItem : userModule.items) {
                if (moduleItem != null) {
                    ModuleItemData moduleItemData = new ModuleItemData();
                    moduleItemData.parserProtobuf(moduleItem);
                    this.moduleDataList.add(moduleItemData);
                }
            }
        }
    }

    public void moveModuleItemDataToPosition(long j, int i) {
        if (this.moduleDataList != null && y.k(this.moduleDataList) > i) {
            for (ModuleItemData moduleItemData : this.moduleDataList) {
                if (moduleItemData != null && moduleItemData.mid == j) {
                    this.moduleDataList.remove(moduleItemData);
                    this.moduleDataList.add(i, moduleItemData);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ModuleItemData extends i implements Serializable {
        private static final long serialVersionUID = -3805426474184984403L;
        public long mid = 0;

        public void parserProtobuf(ModuleItem moduleItem) {
            if (moduleItem != null) {
                this.mid = moduleItem.mid.longValue();
            }
        }
    }
}
