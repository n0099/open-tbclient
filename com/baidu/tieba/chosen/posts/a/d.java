package com.baidu.tieba.chosen.posts.a;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import tbclient.HotThread.Pic;
import tbclient.HotThread.tinfo;
/* loaded from: classes22.dex */
public class d implements com.baidu.tbadk.mvc.b.a {
    private String forumId;
    private String forumName;
    private ArrayList<String> hwa;
    private int index;
    private String threadId;

    public d(int i, tinfo tinfoVar) {
        if (tinfoVar != null) {
            this.hwa = new ArrayList<>();
            this.index = i;
            this.forumId = String.valueOf(tinfoVar.forum_id);
            this.forumName = tinfoVar.forum_name;
            this.threadId = String.valueOf(tinfoVar.thread_id);
            for (Pic pic : tinfoVar.pics) {
                if (pic != null && !StringUtils.isNull(pic.big_pic)) {
                    this.hwa.add(pic.big_pic);
                }
            }
        }
    }

    public CustomMessage<ImageViewerConfig> eY(Context context) {
        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
        aVar.x(this.hwa).mX(this.index).zl(this.forumName).zm(this.forumId).zn(this.threadId).hF(true).hG(false).zo(this.hwa.get(this.hwa.size() - 1));
        return new CustomMessage<>((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, aVar.dO(context));
    }
}
