package com.baidu.tbadk.editortools.c;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends m {
    private boolean fAK;
    private boolean fgC;

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_link), 31, i);
        this.fAK = true;
        this.fgC = true;
        this.fzM = R.drawable.icon_pure_post_link24;
        this.fzP = false;
        this.fzQ = true;
        this.fzR = false;
        this.fzV = new int[]{21};
    }

    @Override // com.baidu.tbadk.editortools.m
    public boolean sj() {
        return this.fAK;
    }

    @Override // com.baidu.tbadk.editortools.m
    public boolean isEnable() {
        return this.fgC;
    }

    public void kP(boolean z) {
        this.fAK = z;
    }

    public void setEnable(boolean z) {
        this.fgC = z;
    }
}
