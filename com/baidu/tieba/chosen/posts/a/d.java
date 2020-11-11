package com.baidu.tieba.chosen.posts.a;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import tbclient.HotThread.Pic;
import tbclient.HotThread.tinfo;
/* loaded from: classes23.dex */
public class d implements com.baidu.tbadk.mvc.b.a {
    private String forumId;
    private String forumName;
    private ArrayList<String> idq;
    private int index;
    private String threadId;

    public d(int i, tinfo tinfoVar) {
        if (tinfoVar != null) {
            this.idq = new ArrayList<>();
            this.index = i;
            this.forumId = String.valueOf(tinfoVar.forum_id);
            this.forumName = tinfoVar.forum_name;
            this.threadId = String.valueOf(tinfoVar.thread_id);
            for (Pic pic : tinfoVar.pics) {
                if (pic != null && !StringUtils.isNull(pic.big_pic)) {
                    this.idq.add(pic.big_pic);
                }
            }
        }
    }

    public CustomMessage<ImageViewerConfig> fg(Context context) {
        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
        aVar.x(this.idq).nP(this.index).AE(this.forumName).AF(this.forumId).AG(this.threadId).ix(true).iy(false).AH(this.idq.get(this.idq.size() - 1));
        return new CustomMessage<>((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, aVar.dU(context));
    }
}
