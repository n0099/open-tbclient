package com.baidu.tieba.faceshop;

import android.graphics.Bitmap;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class c extends com.baidu.tbadk.editortools.emotiontool.c {
    private String groupId;
    private String groupName;
    private int height;
    private ArrayList<String> iST = new ArrayList<>();
    private int width;

    public c(EmotionGroupData emotionGroupData) {
        this.groupId = emotionGroupData.getGroupId();
        this.groupName = emotionGroupData.getGroupName();
        this.width = emotionGroupData.getWidth();
        this.height = emotionGroupData.getHeight();
        init();
    }

    private void init() {
        qZ(2);
        qY(4);
        Bitmap eQ = b.eQ(this.groupId, "panel.png");
        Bitmap eQ2 = b.eQ(this.groupId, "panel_momo.png");
        if (eQ != null) {
            c(new com.baidu.adp.widget.ImageView.a(eQ, false));
        }
        if (eQ2 != null) {
            d(new com.baidu.adp.widget.ImageView.a(eQ2, false));
        }
        this.iST.clear();
        for (EmotionData emotionData : i.cyE().JE(this.groupId)) {
            this.iST.add(emotionData.getSharpText());
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public String qX(int i) {
        if (i >= this.iST.size()) {
            return null;
        }
        return this.iST.get(i);
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public boolean CP(String str) {
        return this.iST.contains(str);
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public EmotionGroupType bBB() {
        return EmotionGroupType.BIG_EMOTION;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public com.baidu.adp.widget.ImageView.a CQ(String str) {
        String aM;
        if (Jg(str)) {
            aM = b.j(str, true, false);
        } else {
            aM = b.aM(str, false);
        }
        Bitmap eQ = b.eQ(this.groupId, aM);
        if (eQ == null) {
            return null;
        }
        return new com.baidu.adp.widget.ImageView.a(eQ, false, str);
    }

    public boolean Jg(String str) {
        if (str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(","));
            return substring.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) && !substring.contains("collect_");
        }
        return false;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public com.baidu.adp.widget.ImageView.a CR(String str) {
        return null;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public int getEmotionsCount() {
        return this.iST.size();
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public String getGroupId() {
        return this.groupId;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public String getGroupName() {
        return this.groupName;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public int getWidth() {
        return this.width;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public int getHeight() {
        return this.height;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public boolean bBA() {
        return false;
    }
}
