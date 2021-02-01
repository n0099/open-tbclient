package com.baidu.tbadk.editortools.c;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends m {
    private boolean fCZ;
    private boolean fiV;

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_link), 31, i);
        this.fCZ = true;
        this.fiV = true;
        this.fCb = R.drawable.icon_pure_post_link24;
        this.fCe = false;
        this.fCf = true;
        this.fCg = false;
        this.fCk = new int[]{21};
    }

    @Override // com.baidu.tbadk.editortools.m
    public boolean sg() {
        return this.fCZ;
    }

    @Override // com.baidu.tbadk.editortools.m
    public boolean isEnable() {
        return this.fiV;
    }

    public void kS(boolean z) {
        this.fCZ = z;
    }

    public void setEnable(boolean z) {
        this.fiV = z;
    }
}
