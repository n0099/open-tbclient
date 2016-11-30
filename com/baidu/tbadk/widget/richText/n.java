package com.baidu.tbadk.widget.richText;

import java.util.List;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.lib.a.b.a.a.i {
    public int VA;
    public int VB;
    public List<String> VC;
    public int VD;
    public String Vx;
    public long Vy;
    public int Vz;
    public String location;
    public List<String> photoList;
    public int startTime;

    public void a(PbContent pbContent) {
        if (pbContent != null && pbContent.high_together != null) {
            this.Vx = pbContent.high_together.album_name;
            this.Vy = pbContent.high_together.album_id.longValue();
            this.startTime = pbContent.high_together.start_time.intValue();
            this.Vz = pbContent.high_together.end_time.intValue();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.startTime == 0) {
                this.VD = 8;
            } else if (this.startTime > currentTimeMillis) {
                this.VD = 1;
            } else if (this.Vz < currentTimeMillis) {
                this.VD = 4;
            } else {
                this.VD = 2;
            }
            this.location = pbContent.high_together.location;
            this.VA = pbContent.high_together.num_join.intValue();
            this.VB = pbContent.high_together.num_signup.intValue();
            this.VC = pbContent.high_together.potraits;
            this.photoList = pbContent.high_together.pic_urls;
        }
    }
}
