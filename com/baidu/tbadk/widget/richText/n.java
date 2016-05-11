package com.baidu.tbadk.widget.richText;

import java.util.List;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.lib.a.b.a.a.i {
    public String QX;
    public long QY;
    public int QZ;
    public int Ra;
    public int Rb;
    public List<String> Rc;
    public int Rd;
    public String location;
    public List<String> photoList;
    public int startTime;

    public void a(PbContent pbContent) {
        if (pbContent != null && pbContent.high_together != null) {
            this.QX = pbContent.high_together.album_name;
            this.QY = pbContent.high_together.album_id.longValue();
            this.startTime = pbContent.high_together.start_time.intValue();
            this.QZ = pbContent.high_together.end_time.intValue();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.startTime == 0) {
                this.Rd = 8;
            } else if (this.startTime > currentTimeMillis) {
                this.Rd = 1;
            } else if (this.QZ < currentTimeMillis) {
                this.Rd = 4;
            } else {
                this.Rd = 2;
            }
            this.location = pbContent.high_together.location;
            this.Ra = pbContent.high_together.num_join.intValue();
            this.Rb = pbContent.high_together.num_signup.intValue();
            this.Rc = pbContent.high_together.potraits;
            this.photoList = pbContent.high_together.pic_urls;
        }
    }
}
