package com.baidu.tbadk.editortools.c;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends m {
    private boolean fbE;
    private boolean fvM;

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_link), 31, i);
        this.fvM = true;
        this.fbE = true;
        this.fuO = R.drawable.icon_pure_post_link24;
        this.fuR = false;
        this.fuS = true;
        this.fuT = false;
        this.fuX = new int[]{21};
    }

    @Override // com.baidu.tbadk.editortools.m
    public boolean sH() {
        return this.fvM;
    }

    @Override // com.baidu.tbadk.editortools.m
    public boolean isEnable() {
        return this.fbE;
    }

    public void kx(boolean z) {
        this.fvM = z;
    }

    public void setEnable(boolean z) {
        this.fbE = z;
    }
}
