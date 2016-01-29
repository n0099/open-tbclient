package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.k;
import com.baidu.tbadk.editortools.view.b;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    private k Lx;
    private b avL;
    private InterfaceC0050a avM;
    private b.a avN;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0050a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int avO;
        public int avP;
    }

    public abstract void CM();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(b.a aVar) {
        this.avN = aVar;
    }

    public void setEditorTools(k kVar) {
        this.Lx = kVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Lx != null) {
            this.Lx.b(aVar);
        }
    }

    public b DJ() {
        return this.avL;
    }

    public void a(b bVar) {
        this.avL = bVar;
    }

    public InterfaceC0050a DK() {
        return this.avM;
    }

    public void a(InterfaceC0050a interfaceC0050a) {
        this.avM = interfaceC0050a;
    }

    public int DL() {
        return this.column;
    }

    public void eI(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eJ(int i) {
        this.row = i;
    }

    public int getVerticalSpacing() {
        return this.verticalSpacing;
    }

    public void setVerticalSpacing(int i) {
        this.verticalSpacing = i;
    }

    public int getHorizontalSpacing() {
        return this.horizontalSpacing;
    }

    public void setHorizontalSpacing(int i) {
        this.horizontalSpacing = i;
    }

    public b.a DM() {
        return this.avN;
    }
}
