package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class TbRichTextLinkButtonInfo extends OrmObject {
    public int btn_type;
    public String link;

    public TbRichTextLinkButtonInfo(PbContent pbContent) {
        if (pbContent == null) {
            return;
        }
        this.btn_type = pbContent.btn_type.intValue();
        this.link = pbContent.link;
    }
}
