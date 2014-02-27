package com.baidu.tieba.data;

import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.view.cr;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MetaData extends com.baidu.tbadk.data.MetaData implements com.baidu.tieba.util.aw, cr {
    private static final long serialVersionUID = -5772546803814127750L;
    private boolean mIsChecked = false;

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
    public LinkedList<String> getPhotoUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(getPortrait());
        return linkedList;
    }

    @Override // com.baidu.tieba.view.cr
    public boolean isChecked() {
        return this.mIsChecked;
    }

    @Override // com.baidu.tieba.view.cr
    public void setChecked(boolean z) {
        this.mIsChecked = z;
    }

    @Override // com.baidu.tieba.util.aw
    public boolean isSupportImageSize() {
        return false;
    }

    @Override // com.baidu.tieba.util.aw
    public LinkedList<com.baidu.tieba.util.av> getImagesWithEmotions() {
        return null;
    }

    @Override // com.baidu.tieba.util.aw
    public LinkedList<String> getForumPhotoUrl() {
        return null;
    }
}
