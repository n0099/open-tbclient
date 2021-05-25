package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tbadk.editortools.EditorTools;
import d.a.m0.w.n;
/* loaded from: classes3.dex */
public abstract class ICommonTabHost extends LinearLayout implements n {
    public ICommonTabHost(Context context) {
        super(context);
    }

    public abstract /* synthetic */ int getToolId();

    public abstract /* synthetic */ void setEditorTools(EditorTools editorTools);

    public abstract /* synthetic */ void setToolId(int i2);

    public ICommonTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
