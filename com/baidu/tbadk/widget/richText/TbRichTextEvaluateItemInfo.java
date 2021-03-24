package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import java.util.List;
import tbclient.Item;
/* loaded from: classes3.dex */
public class TbRichTextEvaluateItemInfo extends OrmObject implements Serializable {
    public double mIconSize;
    public String mIconUrl;
    public String mItemID;
    public double mScore;
    public int mStar;
    public List<String> mTags;
    public String mTitle;

    public TbRichTextEvaluateItemInfo() {
    }

    public double getIconSize() {
        return this.mIconSize;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public String getItemID() {
        return this.mItemID;
    }

    public double getScore() {
        return this.mScore;
    }

    public int getStar() {
        return this.mStar;
    }

    public List<String> getTags() {
        return this.mTags;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setIconSize(double d2) {
        this.mIconSize = d2;
    }

    public void setIconUrl(String str) {
        this.mIconUrl = str;
    }

    public void setItemID(String str) {
        this.mItemID = str;
    }

    public void setScore(double d2) {
        this.mScore = d2;
    }

    public void setStar(int i) {
        this.mStar = i;
    }

    public void setTags(List<String> list) {
        this.mTags = list;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public TbRichTextEvaluateItemInfo(Item item) {
        this.mItemID = String.valueOf(item.item_id.intValue());
        this.mIconUrl = item.icon_url;
        this.mTitle = item.item_name;
        this.mTags = item.tags;
        this.mScore = item.score.doubleValue();
        this.mStar = item.star.intValue();
        this.mIconSize = item.icon_size.doubleValue();
    }
}
