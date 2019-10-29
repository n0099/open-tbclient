package com.baidu.tieba.ala.alasquare.live.b;

import java.util.ArrayList;
import java.util.List;
import tbclient.LiveSquare.HotLiveWithCategory;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class a {
    public String bitmap_wh_ratio;
    public int dvF;
    public int dvG;
    public List<String> dvH;
    public String entry_name;
    public String label_name;
    public List<ThreadInfo> live;

    public a(HotLiveWithCategory hotLiveWithCategory) {
        this.dvF = hotLiveWithCategory.tab_id.intValue();
        this.entry_name = hotLiveWithCategory.entry_name;
        this.label_name = hotLiveWithCategory.label_name;
        this.bitmap_wh_ratio = hotLiveWithCategory.bitmap_wh_ratio;
        this.live = new ArrayList(hotLiveWithCategory.live);
        this.dvG = hotLiveWithCategory.live_tab_type.intValue();
        this.dvH = hotLiveWithCategory.sub_type_list;
    }
}
