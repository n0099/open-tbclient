package com.baidu.tieba.im.data;

import com.baidu.tbadk.core.util.AbstractImageProvider;
import com.baidu.tbadk.core.view.TbCheckBox;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class InviteFriendData extends AbstractImageProvider implements TbCheckBox.b {
    private String ggE;
    private boolean mIsChecked = false;

    @Override // com.baidu.tbadk.core.util.AbstractImageProvider
    public ArrayList<String> getImageUrl() {
        return null;
    }

    @Override // com.baidu.tbadk.core.util.AbstractImageProvider
    public ArrayList<String> getPhotoUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.ggE);
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.b
    public boolean isChecked() {
        return this.mIsChecked;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.b
    public void setChecked(boolean z) {
        this.mIsChecked = z;
    }
}
