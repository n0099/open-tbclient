package com.baidu.tieba.enterForum.recommend.b;

import tbclient.Recommforum.TestInfo;
/* loaded from: classes9.dex */
public class f {
    public int createTime;
    public boolean hgl;
    public String hgm;
    public String imageUrl;
    public long testId;
    public String title;

    public void a(TestInfo testInfo) {
        if (testInfo != null) {
            this.testId = testInfo.test_id.longValue();
            this.title = testInfo.title == null ? "" : testInfo.title;
            this.imageUrl = testInfo.image_url;
            this.createTime = testInfo.create_time.intValue();
            this.hgl = testInfo.answered.intValue() == 1;
            this.hgm = testInfo.result_img;
        }
    }
}
