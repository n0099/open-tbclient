package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.k;
import com.baidu.tbadk.editortools.view.b;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    private k Li;
    private b auT;
    private InterfaceC0049a auU;
    private b.a auV;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0049a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int auW;
        public int auX;
    }

    public abstract void Bw();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(b.a aVar) {
        this.auV = aVar;
    }

    public void setEditorTools(k kVar) {
        this.Li = kVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Li != null) {
            this.Li.b(aVar);
        }
    }

    public b Ct() {
        return this.auT;
    }

    public void a(b bVar) {
        this.auT = bVar;
    }

    public InterfaceC0049a Cu() {
        return this.auU;
    }

    public void a(InterfaceC0049a interfaceC0049a) {
        this.auU = interfaceC0049a;
    }

    public int Cv() {
        return this.column;
    }

    public void eo(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void ep(int i) {
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

    public b.a Cw() {
        return this.auV;
    }
}
