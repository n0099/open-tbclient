package com.baidu.tbadk.editortools.c;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends m {
    private boolean fEy;
    private boolean fku;

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_link), 31, i);
        this.fEy = true;
        this.fku = true;
        this.fDA = R.drawable.icon_pure_post_link24;
        this.fDD = false;
        this.fDE = true;
        this.fDF = false;
        this.fDJ = new int[]{21};
    }

    @Override // com.baidu.tbadk.editortools.m
    public boolean sg() {
        return this.fEy;
    }

    @Override // com.baidu.tbadk.editortools.m
    public boolean isEnable() {
        return this.fku;
    }

    public void kS(boolean z) {
        this.fEy = z;
    }

    public void setEnable(boolean z) {
        this.fku = z;
    }
}
