package com.baidu.tieba.channel.data;

import com.baidu.tbadk.core.view.TbCheckBox;
/* loaded from: classes3.dex */
public class b extends h implements TbCheckBox.b {
    private boolean dej = false;

    public boolean ary() {
        return this.dej;
    }

    public void fD(boolean z) {
        this.dej = z;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.b
    public boolean isChecked() {
        return this.dej;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.b
    public void setChecked(boolean z) {
    }
}
