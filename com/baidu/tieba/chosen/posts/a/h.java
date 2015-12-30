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
    private ArrayList<String> aRy;
    private String forumId;
    private String forumName;
    private int index;
    private String threadId;

    public h(int i, tinfo tinfoVar) {
        if (tinfoVar != null) {
            this.aRy = new ArrayList<>();
            this.index = i;
            this.forumId = String.valueOf(tinfoVar.forum_id);
            this.forumName = tinfoVar.forum_name;
            for (Pic pic : tinfoVar.pics) {
                if (pic != null && !StringUtils.isNull(pic.big_pic)) {
                    this.aRy.add(pic.big_pic);
                }
            }
        }
    }

    public CustomMessage<ImageViewerConfig> ar(Context context) {
        return new CustomMessage<>((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(context).createConfig(this.aRy, this.index, this.forumName, this.forumId, this.threadId, true, this.aRy.get(this.aRy.size() - 1), false));
    }
}
