package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.List;
import tbclient.Item;
/* loaded from: classes.dex */
public class TbRichTextEvaluateItemInfo extends OrmObject {
    private String fIi;
    private double mIconSize;
    private String mIconUrl;
    private double mScore;
    private int mStar;
    private List<String> mTags;
    private String mTitle;

    public TbRichTextEvaluateItemInfo() {
    }

    public TbRichTextEvaluateItemInfo(Item item) {
        this.fIi = String.valueOf(item.item_id.intValue());
        this.mIconUrl = item.icon_url;
        this.mTitle = item.item_name;
        this.mTags = item.tags;
        this.mScore = item.score.doubleValue();
        this.mStar = item.star.intValue();
        this.mIconSize = item.icon_size.doubleValue();
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public List<String> getTags() {
        return this.mTags;
    }

    public double bFs() {
        return this.mScore;
    }

    public int getStar() {
        return this.mStar;
    }

    public double getIconSize() {
        return this.mIconSize;
    }

    public String bFt() {
        return this.fIi;
    }
}
