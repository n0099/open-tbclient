package com.baidu.tieba.chosen.posts.a;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import tbclient.HotThread.Pic;
import tbclient.HotThread.tinfo;
/* loaded from: classes7.dex */
public class d implements com.baidu.tbadk.mvc.b.a {
    private String forumId;
    private String forumName;
    private int index;
    private ArrayList<String> iwQ;
    private String threadId;

    public d(int i, tinfo tinfoVar) {
        if (tinfoVar != null) {
            this.iwQ = new ArrayList<>();
            this.index = i;
            this.forumId = String.valueOf(tinfoVar.forum_id);
            this.forumName = tinfoVar.forum_name;
            this.threadId = String.valueOf(tinfoVar.thread_id);
            for (Pic pic : tinfoVar.pics) {
                if (pic != null && !StringUtils.isNull(pic.big_pic)) {
                    this.iwQ.add(pic.big_pic);
                }
            }
        }
    }

    public CustomMessage<ImageViewerConfig> gc(Context context) {
        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
        aVar.s(this.iwQ).mN(this.index).zs(this.forumName).zt(this.forumId).zu(this.threadId).je(true).jf(false).zv(this.iwQ.get(this.iwQ.size() - 1));
        return new CustomMessage<>((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, aVar.eQ(context));
    }
}
