package com.baidu.tieba.faceshop;

import android.graphics.Bitmap;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class c extends com.baidu.tbadk.editortools.emotiontool.c {
    private String groupId;
    private String groupName;
    private int height;
    private ArrayList<String> iNm = new ArrayList<>();
    private int width;

    public c(EmotionGroupData emotionGroupData) {
        this.groupId = emotionGroupData.getGroupId();
        this.groupName = emotionGroupData.getGroupName();
        this.width = emotionGroupData.getWidth();
        this.height = emotionGroupData.getHeight();
        init();
    }

    private void init() {
        qU(2);
        qT(4);
        Bitmap eQ = b.eQ(this.groupId, "panel.png");
        Bitmap eQ2 = b.eQ(this.groupId, "panel_momo.png");
        if (eQ != null) {
            c(new com.baidu.adp.widget.ImageView.a(eQ, false));
        }
        if (eQ2 != null) {
            d(new com.baidu.adp.widget.ImageView.a(eQ2, false));
        }
        this.iNm.clear();
        for (EmotionData emotionData : i.cxt().IT(this.groupId)) {
            this.iNm.add(emotionData.getSharpText());
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public String qS(int i) {
        if (i >= this.iNm.size()) {
            return null;
        }
        return this.iNm.get(i);
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public boolean Cy(String str) {
        return this.iNm.contains(str);
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public EmotionGroupType bBj() {
        return EmotionGroupType.BIG_EMOTION;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public com.baidu.adp.widget.ImageView.a Cz(String str) {
        String aN;
        if (Iv(str)) {
            aN = b.j(str, true, false);
        } else {
            aN = b.aN(str, false);
        }
        Bitmap eQ = b.eQ(this.groupId, aN);
        if (eQ == null) {
            return null;
        }
        return new com.baidu.adp.widget.ImageView.a(eQ, false, str);
    }

    public boolean Iv(String str) {
        if (str.startsWith("#(meme,")) {
            String replace = str.replace("#(meme,", "");
            String substring = replace.substring(0, replace.indexOf(","));
            return substring.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) && !substring.contains("collect_");
        }
        return false;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public com.baidu.adp.widget.ImageView.a CA(String str) {
        return null;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public int getEmotionsCount() {
        return this.iNm.size();
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
    public boolean bBi() {
        return false;
    }
}
