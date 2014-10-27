package com.baidu.tbadk.editortool;

import android.graphics.Bitmap;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d extends ad {
    private ArrayList<String> Rm = new ArrayList<>();
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
        cK(2);
        cJ(4);
        Bitmap U = aa.rz().U(this.groupId, "panel.png");
        Bitmap U2 = aa.rz().U(this.groupId, "panel_momo.png");
        if (U != null) {
            b(new com.baidu.adp.widget.a.a(U, false));
        }
        if (U2 != null) {
            c(new com.baidu.adp.widget.a.a(U2, false));
        }
        this.Rm.clear();
        for (EmotionData emotionData : u.rw().dc(this.groupId)) {
            this.Rm.add(emotionData.getSharpText());
        }
    }

    @Override // com.baidu.tbadk.editortool.ad
    public String cG(int i) {
        if (i >= this.Rm.size()) {
            return null;
        }
        return this.Rm.get(i);
    }

    @Override // com.baidu.tbadk.editortool.ad
    public boolean cY(String str) {
        return this.Rm.contains(str);
    }

    @Override // com.baidu.tbadk.editortool.ad
    public EmotionGroupType rr() {
        return EmotionGroupType.BIG_EMOTION;
    }

    @Override // com.baidu.tbadk.editortool.ad
    public com.baidu.adp.widget.a.a cZ(String str) {
        Bitmap U = aa.rz().U(this.groupId, aa.rz().m(str, false));
        if (U == null) {
            return null;
        }
        return new com.baidu.adp.widget.a.a(U, false, str);
    }

    @Override // com.baidu.tbadk.editortool.ad
    public com.baidu.adp.widget.a.a da(String str) {
        return aa.rz().V(this.groupId, aa.rz().m(str, true));
    }

    @Override // com.baidu.tbadk.editortool.ad
    public int getEmotionsCount() {
        return this.Rm.size();
    }

    @Override // com.baidu.tbadk.editortool.ad
    public String getGroupId() {
        return this.groupId;
    }

    @Override // com.baidu.tbadk.editortool.ad
    public String getGroupName() {
        return this.groupName;
    }

    @Override // com.baidu.tbadk.editortool.ad
    public int getWidth() {
        return this.width;
    }

    @Override // com.baidu.tbadk.editortool.ad
    public int getHeight() {
        return this.height;
    }

    @Override // com.baidu.tbadk.editortool.ad
    public boolean rs() {
        return false;
    }
}
