package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.view.b;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    private j Kz;
    private b asG;
    private InterfaceC0047a asH;
    private b.a asI;
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
        public int asJ;
        public int asK;
    }

    public abstract void AG();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(b.a aVar) {
        this.asI = aVar;
    }

    public void setEditorTools(j jVar) {
        this.Kz = jVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Kz != null) {
            this.Kz.b(aVar);
        }
    }

    public b BN() {
        return this.asG;
    }

    public void a(b bVar) {
        this.asG = bVar;
    }

    public InterfaceC0047a BO() {
        return this.asH;
    }

    public void a(InterfaceC0047a interfaceC0047a) {
        this.asH = interfaceC0047a;
    }

    public int BP() {
        return this.column;
    }

    public void ec(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eb(int i) {
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

    public b.a BQ() {
        return this.asI;
    }
}
