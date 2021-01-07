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
    private ArrayList<String> iRT = new ArrayList<>();
    private int width;

    public c(EmotionGroupData emotionGroupData) {
        this.groupId = emotionGroupData.getGroupId();
        this.groupName = emotionGroupData.getGroupName();
        this.width = emotionGroupData.getWidth();
        this.height = emotionGroupData.getHeight();
        init();
    }

    private void init() {
        sA(2);
        sz(4);
        Bitmap eR = b.eR(this.groupId, "panel.png");
        Bitmap eR2 = b.eR(this.groupId, "panel_momo.png");
        if (eR != null) {
            c(new com.baidu.adp.widget.ImageView.a(eR, false));
        }
        if (eR2 != null) {
            d(new com.baidu.adp.widget.ImageView.a(eR2, false));
        }
        this.iRT.clear();
        for (EmotionData emotionData : i.cBl().Ke(this.groupId)) {
            this.iRT.add(emotionData.getSharpText());
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public String sy(int i) {
        if (i >= this.iRT.size()) {
            return null;
        }
        return this.iRT.get(i);
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public boolean DJ(String str) {
        return this.iRT.contains(str);
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public EmotionGroupType bFd() {
        return EmotionGroupType.BIG_EMOTION;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public com.baidu.adp.widget.ImageView.a DK(String str) {
        String aN;
        if (JG(str)) {
            aN = b.j(str, true, false);
        } else {
            aN = b.aN(str, false);
        }
        Bitmap eR = b.eR(this.groupId, aN);
        if (eR == null) {
            return null;
        }
        return new com.baidu.adp.widget.ImageView.a(eR, false, str);
    }

    public boolean JG(String str) {
        if (str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(","));
            return substring.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) && !substring.contains("collect_");
        }
        return false;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public com.baidu.adp.widget.ImageView.a DL(String str) {
        return null;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public int getEmotionsCount() {
        return this.iRT.size();
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
    public boolean bFc() {
        return false;
    }
}
