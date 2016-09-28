package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.Personalized.TagStruct;
/* loaded from: classes.dex */
public class i {
    public String PC;
    public boolean cHD;

    public static i a(TagStruct tagStruct) {
        if (tagStruct == null || StringUtils.isNull(tagStruct.tag_name)) {
            return null;
        }
        i iVar = new i();
        iVar.PC = tagStruct.tag_name;
        iVar.cHD = tagStruct.selected.intValue() == 1;
        return iVar;
    }
}
