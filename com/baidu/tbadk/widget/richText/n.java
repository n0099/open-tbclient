package com.baidu.tbadk.widget.richText;

import java.util.List;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.lib.a.b.a.a.i {
    public String UZ;
    public long Va;
    public int Vb;
    public int Vc;
    public int Vd;
    public List<String> Ve;
    public int Vf;
    public String location;
    public List<String> photoList;
    public int startTime;

    public void a(PbContent pbContent) {
        if (pbContent != null && pbContent.high_together != null) {
            this.UZ = pbContent.high_together.album_name;
            this.Va = pbContent.high_together.album_id.longValue();
            this.startTime = pbContent.high_together.start_time.intValue();
            this.Vb = pbContent.high_together.end_time.intValue();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.startTime == 0) {
                this.Vf = 8;
            } else if (this.startTime > currentTimeMillis) {
                this.Vf = 1;
            } else if (this.Vb < currentTimeMillis) {
                this.Vf = 4;
            } else {
                this.Vf = 2;
            }
            this.location = pbContent.high_together.location;
            this.Vc = pbContent.high_together.num_join.intValue();
            this.Vd = pbContent.high_together.num_signup.intValue();
            this.Ve = pbContent.high_together.potraits;
            this.photoList = pbContent.high_together.pic_urls;
        }
    }
}
