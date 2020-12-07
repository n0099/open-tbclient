package com.baidu.tieba.enterForum.recommend.b;

import tbclient.Recommforum.TestInfo;
/* loaded from: classes22.dex */
public class f {
    public int createTime;
    public String imageUrl;
    public boolean iyU;
    public String iyV;
    public long testId;
    public String title;

    public void a(TestInfo testInfo) {
        if (testInfo != null) {
            this.testId = testInfo.test_id.longValue();
            this.title = testInfo.title == null ? "" : testInfo.title;
            this.imageUrl = testInfo.image_url;
            this.createTime = testInfo.create_time.intValue();
            this.iyU = testInfo.answered.intValue() == 1;
            this.iyV = testInfo.result_img;
        }
    }
}
