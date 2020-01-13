package com.baidu.tieba.enterForum.recommend.b;

import tbclient.Recommforum.TestInfo;
/* loaded from: classes7.dex */
public class f {
    public int createTime;
    public boolean fVb;
    public String fVc;
    public String imageUrl;
    public long testId;
    public String title;

    public void a(TestInfo testInfo) {
        if (testInfo != null) {
            this.testId = testInfo.test_id.longValue();
            this.title = testInfo.title == null ? "" : testInfo.title;
            this.imageUrl = testInfo.image_url;
            this.createTime = testInfo.create_time.intValue();
            this.fVb = testInfo.answered.intValue() == 1;
            this.fVc = testInfo.result_img;
        }
    }
}
