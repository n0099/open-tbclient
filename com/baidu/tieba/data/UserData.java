package com.baidu.tieba.data;

import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.view.cs;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class UserData extends com.baidu.tbadk.data.UserData implements com.baidu.tieba.util.aw, cs {
    private static final long serialVersionUID = -2636990595209169859L;
    private boolean mIsChecked;

    public UserData() {
        this.mIsChecked = false;
    }

    public UserData(long j, String str, String str2, int i) {
        super(j, str, str2, i);
        this.mIsChecked = false;
    }

    @Override // com.baidu.tieba.util.aw
    public boolean isSupportImageSize() {
        return false;
    }

    @Override // com.baidu.tieba.util.aw
    public LinkedList<String> getImageUrl() {
        LinkedList<IconData> iconInfo = getIconInfo();
        LinkedList<IconData> tShowInfo = getTShowInfo();
        if (iconInfo == null || tShowInfo == null) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < iconInfo.size(); i++) {
            linkedList.add(iconInfo.get(i).getIcon());
        }
        for (int i2 = 0; i2 < iconInfo.size(); i2++) {
            linkedList.add(tShowInfo.get(i2).getIcon());
        }
        return linkedList;
    }

    @Override // com.baidu.tieba.util.aw
    public LinkedList<com.baidu.tieba.util.av> getImagesWithEmotions() {
        return null;
    }

    @Override // com.baidu.tieba.util.aw
    public LinkedList<String> getPhotoUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(getPortrait());
        return linkedList;
    }

    @Override // com.baidu.tieba.util.aw
    public LinkedList<String> getForumPhotoUrl() {
        return null;
    }

    @Override // com.baidu.tieba.view.cs
    public boolean isChecked() {
        return this.mIsChecked;
    }

    @Override // com.baidu.tieba.view.cs
    public void setChecked(boolean z) {
        this.mIsChecked = z;
    }
}
