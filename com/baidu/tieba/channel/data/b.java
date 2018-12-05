package com.baidu.tieba.channel.data;

import com.baidu.tbadk.core.view.TbCheckBox;
/* loaded from: classes3.dex */
public class b extends h implements TbCheckBox.b {
    private boolean daF = false;

    public boolean aql() {
        return this.daF;
    }

    public void fy(boolean z) {
        this.daF = z;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.b
    public boolean isChecked() {
        return this.daF;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.b
    public void setChecked(boolean z) {
    }
}
