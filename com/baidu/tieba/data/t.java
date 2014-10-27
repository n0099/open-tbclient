package com.baidu.tieba.data;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class t {
    private int akF = 0;
    private int akG = 0;
    private String akH = null;
    private String akI = null;
    private int akJ = 0;
    private int fan_num = 0;
    private int akK = 0;
    private int akL = 0;
    private int akM = 0;
    private int akN = 0;
    private long akO = 0;
    private long akP = 0;
    private boolean akQ = false;
    private long akR = 0;
    private String akS = null;

    public int zg() {
        return this.akF;
    }

    public String zh() {
        return this.akH;
    }

    public String zi() {
        return this.akI;
    }

    public int zj() {
        return this.akK;
    }

    public int zk() {
        return this.akL;
    }

    public boolean zl() {
        return this.akQ;
    }

    public long zm() {
        return this.akR;
    }

    public String zn() {
        return this.akS;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.akF = starInfo.has_frs_star.intValue();
            if (this.akF == 1) {
                this.akH = starInfo.top;
                this.akI = starInfo.head;
                Fans fans = starInfo.fans;
                this.akJ = fans.is_get.intValue();
                this.fan_num = fans.num.intValue();
                this.akG = fans.open.intValue();
                this.akO = fans.left_time.intValue();
                this.akP = this.akO;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.akK = size.width.intValue();
                    this.akL = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.akM = size2.width.intValue();
                    this.akN = size2.height.intValue();
                }
            }
            this.akQ = starInfo.trade != null;
            if (this.akQ) {
                if (starInfo.trade.time != null) {
                    this.akR = starInfo.trade.time.intValue();
                }
                this.akS = starInfo.trade.url;
            }
        }
    }
}
