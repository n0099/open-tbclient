package com.baidu.tieba.channel.data;

import com.baidu.tbadk.core.view.TbCheckBox;
/* loaded from: classes3.dex */
public class b extends h implements TbCheckBox.b {
    private boolean cEl = false;

    public boolean ajO() {
        return this.cEl;
    }

    public void eC(boolean z) {
        this.cEl = z;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.b
    public boolean isChecked() {
        return this.cEl;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.b
    public void setChecked(boolean z) {
    }
}
