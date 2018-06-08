package com.baidu.tieba.chosen.posts.a;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import tbclient.HotThread.Pic;
import tbclient.HotThread.tinfo;
/* loaded from: classes3.dex */
public class d implements com.baidu.tbadk.mvc.b.a {
    private ArrayList<String> cGM;
    private String forumId;
    private String forumName;
    private int index;
    private String threadId;

    public d(int i, tinfo tinfoVar) {
        if (tinfoVar != null) {
            this.cGM = new ArrayList<>();
            this.index = i;
            this.forumId = String.valueOf(tinfoVar.forum_id);
            this.forumName = tinfoVar.forum_name;
            this.threadId = String.valueOf(tinfoVar.thread_id);
            for (Pic pic : tinfoVar.pics) {
                if (pic != null && !StringUtils.isNull(pic.big_pic)) {
                    this.cGM.add(pic.big_pic);
                }
            }
        }
    }

    public CustomMessage<ImageViewerConfig> bw(Context context) {
        return new CustomMessage<>(2010000, new ImageViewerConfig(context).createConfig(this.cGM, this.index, this.forumName, this.forumId, this.threadId, true, this.cGM.get(this.cGM.size() - 1), false));
    }
}
