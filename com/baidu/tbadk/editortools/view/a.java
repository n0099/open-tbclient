package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.view.b;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    private j KA;
    private b asH;
    private InterfaceC0047a asI;
    private b.a asJ;
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
        public int asK;
        public int asL;
    }

    public abstract void AG();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(b.a aVar) {
        this.asJ = aVar;
    }

    public void setEditorTools(j jVar) {
        this.KA = jVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.KA != null) {
            this.KA.b(aVar);
        }
    }

    public b BN() {
        return this.asH;
    }

    public void a(b bVar) {
        this.asH = bVar;
    }

    public InterfaceC0047a BO() {
        return this.asI;
    }

    public void a(InterfaceC0047a interfaceC0047a) {
        this.asI = interfaceC0047a;
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
        return this.asJ;
    }
}
