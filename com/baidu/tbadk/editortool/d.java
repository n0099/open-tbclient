package com.baidu.tbadk.editortool;

import android.graphics.Bitmap;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d extends ae {
    private ArrayList<String> XQ = new ArrayList<>();
    private String groupId;
    private String groupName;
    private int height;
    private int width;

    public d(EmotionGroupData emotionGroupData) {
        this.groupId = emotionGroupData.getGroupId();
        this.groupName = emotionGroupData.getGroupName();
        this.width = emotionGroupData.getWidth();
        this.height = emotionGroupData.getHeight();
        init();
    }

    private void init() {
        dq(2);
        dp(4);
        Bitmap ai = ab.vn().ai(this.groupId, "panel.png");
        Bitmap ai2 = ab.vn().ai(this.groupId, "panel_momo.png");
        if (ai != null) {
            b(new com.baidu.adp.widget.a.a(ai, false));
        }
        if (ai2 != null) {
            c(new com.baidu.adp.widget.a.a(ai2, false));
        }
        this.XQ.clear();
        for (EmotionData emotionData : u.vk().dV(this.groupId)) {
            this.XQ.add(emotionData.getSharpText());
        }
    }

    @Override // com.baidu.tbadk.editortool.ae
    public String dl(int i) {
        if (i >= this.XQ.size()) {
            return null;
        }
        return this.XQ.get(i);
    }

    @Override // com.baidu.tbadk.editortool.ae
    public boolean dR(String str) {
        return this.XQ.contains(str);
    }

    @Override // com.baidu.tbadk.editortool.ae
    public EmotionGroupType vf() {
        return EmotionGroupType.BIG_EMOTION;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public com.baidu.adp.widget.a.a dS(String str) {
        Bitmap ai = ab.vn().ai(this.groupId, ab.vn().p(str, false));
        if (ai == null) {
            return null;
        }
        return new com.baidu.adp.widget.a.a(ai, false, str);
    }

    @Override // com.baidu.tbadk.editortool.ae
    public com.baidu.adp.widget.a.a dT(String str) {
        return ab.vn().aj(this.groupId, ab.vn().p(str, true));
    }

    @Override // com.baidu.tbadk.editortool.ae
    public int getEmotionsCount() {
        return this.XQ.size();
    }

    @Override // com.baidu.tbadk.editortool.ae
    public String getGroupId() {
        return this.groupId;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public String getGroupName() {
        return this.groupName;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public int getWidth() {
        return this.width;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public int getHeight() {
        return this.height;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public boolean vg() {
        return false;
    }
}
