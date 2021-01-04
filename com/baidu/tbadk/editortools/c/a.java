package com.baidu.tbadk.editortools.c;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends m {
    private boolean fFs;
    private boolean fln;

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_link), 31, i);
        this.fFs = true;
        this.fln = true;
        this.fEu = R.drawable.icon_pure_post_link24;
        this.fEx = false;
        this.fEy = true;
        this.fEz = false;
        this.fED = new int[]{21};
    }

    @Override // com.baidu.tbadk.editortools.m
    public boolean sj() {
        return this.fFs;
    }

    @Override // com.baidu.tbadk.editortools.m
    public boolean isEnable() {
        return this.fln;
    }

    public void kT(boolean z) {
        this.fFs = z;
    }

    public void setEnable(boolean z) {
        this.fln = z;
    }
}
