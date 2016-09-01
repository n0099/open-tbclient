package com.baidu.tbadk.widget.richText;

import java.util.List;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.lib.a.b.a.a.i {
    public String UO;
    public long UQ;
    public int UR;
    public int US;
    public int UT;
    public List<String> UU;
    public int UV;
    public String location;
    public List<String> photoList;
    public int startTime;

    public void a(PbContent pbContent) {
        if (pbContent != null && pbContent.high_together != null) {
            this.UO = pbContent.high_together.album_name;
            this.UQ = pbContent.high_together.album_id.longValue();
            this.startTime = pbContent.high_together.start_time.intValue();
            this.UR = pbContent.high_together.end_time.intValue();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.startTime == 0) {
                this.UV = 8;
            } else if (this.startTime > currentTimeMillis) {
                this.UV = 1;
            } else if (this.UR < currentTimeMillis) {
                this.UV = 4;
            } else {
                this.UV = 2;
            }
            this.location = pbContent.high_together.location;
            this.US = pbContent.high_together.num_join.intValue();
            this.UT = pbContent.high_together.num_signup.intValue();
            this.UU = pbContent.high_together.potraits;
            this.photoList = pbContent.high_together.pic_urls;
        }
    }
}
