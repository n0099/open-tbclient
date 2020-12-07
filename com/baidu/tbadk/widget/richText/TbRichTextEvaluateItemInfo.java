package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.List;
import tbclient.Item;
/* loaded from: classes.dex */
public class TbRichTextEvaluateItemInfo extends OrmObject {
    private String fPU;
    private double mIconSize;
    private String mIconUrl;
    private double mScore;
    private int mStar;
    private List<String> mTags;
    private String mTitle;

    public TbRichTextEvaluateItemInfo() {
    }

    public TbRichTextEvaluateItemInfo(Item item) {
        this.fPU = String.valueOf(item.item_id.intValue());
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

    public void setIconUrl(String str) {
        this.mIconUrl = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public List<String> getTags() {
        return this.mTags;
    }

    public void setTags(List<String> list) {
        this.mTags = list;
    }

    public double bIS() {
        return this.mScore;
    }

    public void y(double d) {
        this.mScore = d;
    }

    public int getStar() {
        return this.mStar;
    }

    public void setStar(int i) {
        this.mStar = i;
    }

    public double getIconSize() {
        return this.mIconSize;
    }

    public void setIconSize(double d) {
        this.mIconSize = d;
    }

    public String bIT() {
        return this.fPU;
    }

    public void ET(String str) {
        this.fPU = str;
    }
}
