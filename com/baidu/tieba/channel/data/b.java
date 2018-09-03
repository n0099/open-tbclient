package com.baidu.tieba.channel.data;

import com.baidu.tbadk.core.view.TbCheckBox;
/* loaded from: classes3.dex */
public class b extends h implements TbCheckBox.b {
    private boolean cEG = false;

    public boolean ajJ() {
        return this.cEG;
    }

    public void eD(boolean z) {
        this.cEG = z;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.b
    public boolean isChecked() {
        return this.cEG;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.b
    public void setChecked(boolean z) {
    }
}
