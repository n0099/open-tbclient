package com.baidu.tieba.channel.data;

import com.baidu.tbadk.core.view.TbCheckBox;
/* loaded from: classes6.dex */
public class b extends h implements TbCheckBox.b {
    private boolean eDC = false;

    public boolean aYw() {
        return this.eDC;
    }

    public void iA(boolean z) {
        this.eDC = z;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.b
    public boolean isChecked() {
        return this.eDC;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.b
    public void setChecked(boolean z) {
    }
}
