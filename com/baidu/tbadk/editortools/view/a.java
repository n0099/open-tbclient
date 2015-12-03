package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.k;
import com.baidu.tbadk.editortools.view.b;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    private k KS;
    private b atp;
    private InterfaceC0049a atq;
    private b.a atr;
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
        public int ats;
        public int att;
    }

    public abstract void BH();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(b.a aVar) {
        this.atr = aVar;
    }

    public void setEditorTools(k kVar) {
        this.KS = kVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.KS != null) {
            this.KS.b(aVar);
        }
    }

    public b CE() {
        return this.atp;
    }

    public void a(b bVar) {
        this.atp = bVar;
    }

    public InterfaceC0049a CF() {
        return this.atq;
    }

    public void a(InterfaceC0049a interfaceC0049a) {
        this.atq = interfaceC0049a;
    }

    public int CG() {
        return this.column;
    }

    public void eu(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void ev(int i) {
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

    public b.a CH() {
        return this.atr;
    }
}
