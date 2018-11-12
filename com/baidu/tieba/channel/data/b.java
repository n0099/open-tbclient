package com.baidu.tieba.channel.data;

import com.baidu.tbadk.core.view.TbCheckBox;
/* loaded from: classes3.dex */
public class b extends h implements TbCheckBox.b {
    private boolean cTW = false;

    public boolean aoy() {
        return this.cTW;
    }

    public void fx(boolean z) {
        this.cTW = z;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.b
    public boolean isChecked() {
        return this.cTW;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.b
    public void setChecked(boolean z) {
    }
}
