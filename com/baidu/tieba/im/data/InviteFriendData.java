package com.baidu.tieba.im.data;

import com.baidu.tbadk.core.util.AbstractImageProvider;
import com.baidu.tbadk.core.view.TbCheckBox;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class InviteFriendData extends AbstractImageProvider implements TbCheckBox.c {

    /* renamed from: e  reason: collision with root package name */
    public String f17226e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f17227f = false;

    @Override // com.baidu.tbadk.core.util.AbstractImageProvider, com.baidu.tbadk.core.util.ImageProvider
    public ArrayList<String> getImageUrl() {
        return null;
    }

    @Override // com.baidu.tbadk.core.util.AbstractImageProvider, com.baidu.tbadk.core.util.ImageProvider
    public ArrayList<String> getPhotoUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.f17226e);
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.c
    public boolean isChecked() {
        return this.f17227f;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.c
    public void setChecked(boolean z) {
        this.f17227f = z;
    }
}
