package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.Personalized.TagStruct;
/* loaded from: classes.dex */
public class i {
    public String PW;
    public boolean cMQ;

    public static i a(TagStruct tagStruct) {
        if (tagStruct == null || StringUtils.isNull(tagStruct.tag_name)) {
            return null;
        }
        i iVar = new i();
        iVar.PW = tagStruct.tag_name;
        iVar.cMQ = tagStruct.selected.intValue() == 1;
        return iVar;
    }
}
