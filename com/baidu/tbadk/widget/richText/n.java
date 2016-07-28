package com.baidu.tbadk.widget.richText;

import java.util.List;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.lib.a.b.a.a.i {
    public String RZ;
    public long Sa;
    public int Sb;
    public int Sc;
    public int Sd;
    public List<String> Se;
    public int Sf;
    public String location;
    public List<String> photoList;
    public int startTime;

    public void a(PbContent pbContent) {
        if (pbContent != null && pbContent.high_together != null) {
            this.RZ = pbContent.high_together.album_name;
            this.Sa = pbContent.high_together.album_id.longValue();
            this.startTime = pbContent.high_together.start_time.intValue();
            this.Sb = pbContent.high_together.end_time.intValue();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.startTime == 0) {
                this.Sf = 8;
            } else if (this.startTime > currentTimeMillis) {
                this.Sf = 1;
            } else if (this.Sb < currentTimeMillis) {
                this.Sf = 4;
            } else {
                this.Sf = 2;
            }
            this.location = pbContent.high_together.location;
            this.Sc = pbContent.high_together.num_join.intValue();
            this.Sd = pbContent.high_together.num_signup.intValue();
            this.Se = pbContent.high_together.potraits;
            this.photoList = pbContent.high_together.pic_urls;
        }
    }
}
