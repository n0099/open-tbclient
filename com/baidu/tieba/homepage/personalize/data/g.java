package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.Personalized.TagStruct;
/* loaded from: classes.dex */
public class g {
    public String TP;
    public boolean cwv;

    public static g a(TagStruct tagStruct) {
        if (tagStruct == null || StringUtils.isNull(tagStruct.tag_name)) {
            return null;
        }
        g gVar = new g();
        gVar.TP = tagStruct.tag_name;
        gVar.cwv = tagStruct.selected.intValue() == 1;
        return gVar;
    }
}
