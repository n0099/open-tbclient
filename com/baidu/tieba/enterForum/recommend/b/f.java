package com.baidu.tieba.enterForum.recommend.b;

import tbclient.Recommforum.TestInfo;
/* loaded from: classes21.dex */
public class f {
    public int createTime;
    public boolean hFU;
    public String hFV;
    public String imageUrl;
    public long testId;
    public String title;

    public void a(TestInfo testInfo) {
        if (testInfo != null) {
            this.testId = testInfo.test_id.longValue();
            this.title = testInfo.title == null ? "" : testInfo.title;
            this.imageUrl = testInfo.image_url;
            this.createTime = testInfo.create_time.intValue();
            this.hFU = testInfo.answered.intValue() == 1;
            this.hFV = testInfo.result_img;
        }
    }
}
