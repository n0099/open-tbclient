package com.baidu.tieba.channel.data;

import com.baidu.tbadk.core.view.TbCheckBox;
/* loaded from: classes6.dex */
public class b extends h implements TbCheckBox.b {
    private boolean enT = false;

    public boolean aRn() {
        return this.enT;
    }

    public void hV(boolean z) {
        this.enT = z;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.b
    public boolean isChecked() {
        return this.enT;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.b
    public void setChecked(boolean z) {
    }
}
