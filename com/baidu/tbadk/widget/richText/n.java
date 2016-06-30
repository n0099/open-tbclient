package com.baidu.tbadk.widget.richText;

import java.util.List;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.lib.a.b.a.a.i {
    public String Rp;
    public long Rq;
    public int Rr;
    public int Rs;
    public int Rt;
    public List<String> Ru;
    public int Rv;
    public String location;
    public List<String> photoList;
    public int startTime;

    public void a(PbContent pbContent) {
        if (pbContent != null && pbContent.high_together != null) {
            this.Rp = pbContent.high_together.album_name;
            this.Rq = pbContent.high_together.album_id.longValue();
            this.startTime = pbContent.high_together.start_time.intValue();
            this.Rr = pbContent.high_together.end_time.intValue();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.startTime == 0) {
                this.Rv = 8;
            } else if (this.startTime > currentTimeMillis) {
                this.Rv = 1;
            } else if (this.Rr < currentTimeMillis) {
                this.Rv = 4;
            } else {
                this.Rv = 2;
            }
            this.location = pbContent.high_together.location;
            this.Rs = pbContent.high_together.num_join.intValue();
            this.Rt = pbContent.high_together.num_signup.intValue();
            this.Ru = pbContent.high_together.potraits;
            this.photoList = pbContent.high_together.pic_urls;
        }
    }
}
