package com.baidu.tieba.chosen.posts.a;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.ArrayList;
import tbclient.HotThread.Pic;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.mvc.b.a {
    private ArrayList<String> aKV;
    private String forumId;
    private String forumName;
    private int index;
    private String threadId;

    public h(int i, tinfo tinfoVar) {
        if (tinfoVar != null) {
            this.aKV = new ArrayList<>();
            this.index = i;
            this.forumId = String.valueOf(tinfoVar.forum_id);
            this.forumName = tinfoVar.forum_name;
            for (Pic pic : tinfoVar.pics) {
                if (pic != null && !StringUtils.isNull(pic.big_pic)) {
                    this.aKV.add(pic.big_pic);
                }
            }
        }
    }

    public CustomMessage<ImageViewerConfig> at(Context context) {
        return new CustomMessage<>((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(context).createConfig(this.aKV, this.index, this.forumName, this.forumId, this.threadId, true, this.aKV.get(this.aKV.size() - 1), false));
    }
}
