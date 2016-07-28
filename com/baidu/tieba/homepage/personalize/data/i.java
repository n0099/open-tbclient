package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.Personalized.TagStruct;
/* loaded from: classes.dex */
public class i {
    public String cvj;
    public boolean cvk;

    public static i a(TagStruct tagStruct) {
        if (tagStruct == null || StringUtils.isNull(tagStruct.tag_name)) {
            return null;
        }
        i iVar = new i();
        iVar.cvj = tagStruct.tag_name;
        iVar.cvk = tagStruct.selected.intValue() == 1;
        return iVar;
    }
}
