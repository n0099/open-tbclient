package com.baidu.tieba.channel.data;

import com.baidu.tbadk.core.view.TbCheckBox;
/* loaded from: classes6.dex */
public class b extends h implements TbCheckBox.b {
    private boolean eDD = false;

    public boolean aYz() {
        return this.eDD;
    }

    public void iA(boolean z) {
        this.eDD = z;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.b
    public boolean isChecked() {
        return this.eDD;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.b
    public void setChecked(boolean z) {
    }
}
