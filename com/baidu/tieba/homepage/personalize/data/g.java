package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.Personalized.TagStruct;
/* loaded from: classes.dex */
public class g {
    public String Vn;
    public boolean isSelect;

    public static g a(TagStruct tagStruct) {
        if (tagStruct == null || StringUtils.isNull(tagStruct.tag_name)) {
            return null;
        }
        g gVar = new g();
        gVar.Vn = tagStruct.tag_name;
        gVar.isSelect = tagStruct.selected.intValue() == 1;
        return gVar;
    }
}
