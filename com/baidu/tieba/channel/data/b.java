package com.baidu.tieba.channel.data;

import com.baidu.tbadk.core.view.TbCheckBox;
/* loaded from: classes6.dex */
public class b extends h implements TbCheckBox.b {
    private boolean eIz = false;

    public boolean bay() {
        return this.eIz;
    }

    public void iJ(boolean z) {
        this.eIz = z;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.b
    public boolean isChecked() {
        return this.eIz;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.b
    public void setChecked(boolean z) {
    }
}
