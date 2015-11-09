package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.view.b;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    private j KB;
    private b aro;
    private InterfaceC0047a arp;
    private b.a arq;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0047a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int arr;
        public int ars;
    }

    public abstract void AJ();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(b.a aVar) {
        this.arq = aVar;
    }

    public void setEditorTools(j jVar) {
        this.KB = jVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.KB != null) {
            this.KB.b(aVar);
        }
    }

    public b BD() {
        return this.aro;
    }

    public void a(b bVar) {
        this.aro = bVar;
    }

    public InterfaceC0047a BE() {
        return this.arp;
    }

    public void a(InterfaceC0047a interfaceC0047a) {
        this.arp = interfaceC0047a;
    }

    public int BF() {
        return this.column;
    }

    public void eg(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eh(int i) {
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

    public b.a BG() {
        return this.arq;
    }
}
