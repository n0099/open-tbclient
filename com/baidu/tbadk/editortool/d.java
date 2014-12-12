package com.baidu.tbadk.editortool;

import android.graphics.Bitmap;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d extends ae {
    private ArrayList<String> Xn = new ArrayList<>();
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
        di(2);
        dh(4);
        Bitmap af = ab.vc().af(this.groupId, "panel.png");
        Bitmap af2 = ab.vc().af(this.groupId, "panel_momo.png");
        if (af != null) {
            b(new com.baidu.adp.widget.a.a(af, false));
        }
        if (af2 != null) {
            c(new com.baidu.adp.widget.a.a(af2, false));
        }
        this.Xn.clear();
        for (EmotionData emotionData : u.uZ().dY(this.groupId)) {
            this.Xn.add(emotionData.getSharpText());
        }
    }

    @Override // com.baidu.tbadk.editortool.ae
    public String de(int i) {
        if (i >= this.Xn.size()) {
            return null;
        }
        return this.Xn.get(i);
    }

    @Override // com.baidu.tbadk.editortool.ae
    public boolean dU(String str) {
        return this.Xn.contains(str);
    }

    @Override // com.baidu.tbadk.editortool.ae
    public EmotionGroupType uU() {
        return EmotionGroupType.BIG_EMOTION;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public com.baidu.adp.widget.a.a dV(String str) {
        Bitmap af = ab.vc().af(this.groupId, ab.vc().p(str, false));
        if (af == null) {
            return null;
        }
        return new com.baidu.adp.widget.a.a(af, false, str);
    }

    @Override // com.baidu.tbadk.editortool.ae
    public com.baidu.adp.widget.a.a dW(String str) {
        return ab.vc().ag(this.groupId, ab.vc().p(str, true));
    }

    @Override // com.baidu.tbadk.editortool.ae
    public int getEmotionsCount() {
        return this.Xn.size();
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
    public boolean uV() {
        return false;
    }
}
