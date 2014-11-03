package com.baidu.tieba.data;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class t {
    private int akO = 0;
    private int akP = 0;
    private String akQ = null;
    private String akR = null;
    private int akS = 0;
    private int fan_num = 0;
    private int akT = 0;
    private int akU = 0;
    private int akV = 0;
    private int akW = 0;
    private long akX = 0;
    private long akY = 0;
    private boolean akZ = false;
    private long ala = 0;
    private String alb = null;

    public int zi() {
        return this.akO;
    }

    public String zj() {
        return this.akQ;
    }

    public String zk() {
        return this.akR;
    }

    public int zl() {
        return this.akT;
    }

    public int zm() {
        return this.akU;
    }

    public boolean zn() {
        return this.akZ;
    }

    public long zo() {
        return this.ala;
    }

    public String zp() {
        return this.alb;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.akO = starInfo.has_frs_star.intValue();
            if (this.akO == 1) {
                this.akQ = starInfo.top;
                this.akR = starInfo.head;
                Fans fans = starInfo.fans;
                this.akS = fans.is_get.intValue();
                this.fan_num = fans.num.intValue();
                this.akP = fans.open.intValue();
                this.akX = fans.left_time.intValue();
                this.akY = this.akX;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.akT = size.width.intValue();
                    this.akU = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.akV = size2.width.intValue();
                    this.akW = size2.height.intValue();
                }
            }
            this.akZ = starInfo.trade != null;
            if (this.akZ) {
                if (starInfo.trade.time != null) {
                    this.ala = starInfo.trade.time.intValue();
                }
                this.alb = starInfo.trade.url;
            }
        }
    }
}
