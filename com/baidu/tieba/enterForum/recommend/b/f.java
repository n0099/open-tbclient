package com.baidu.tieba.enterForum.recommend.b;

import tbclient.Recommforum.TestInfo;
/* loaded from: classes22.dex */
public class f {
    public int createTime;
    public String imageUrl;
    public boolean inn;
    public String ino;
    public long testId;
    public String title;

    public void a(TestInfo testInfo) {
        if (testInfo != null) {
            this.testId = testInfo.test_id.longValue();
            this.title = testInfo.title == null ? "" : testInfo.title;
            this.imageUrl = testInfo.image_url;
            this.createTime = testInfo.create_time.intValue();
            this.inn = testInfo.answered.intValue() == 1;
            this.ino = testInfo.result_img;
        }
    }
}
