package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.Personalized.TagStruct;
/* loaded from: classes.dex */
public class i {
    public boolean csA;
    public String csz;

    public static i a(TagStruct tagStruct) {
        if (tagStruct == null || StringUtils.isNull(tagStruct.tag_name)) {
            return null;
        }
        i iVar = new i();
        iVar.csz = tagStruct.tag_name;
        iVar.csA = tagStruct.selected.intValue() == 1;
        return iVar;
    }
}
