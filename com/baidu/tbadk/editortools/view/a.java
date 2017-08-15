package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.b;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected i Lt;
    private CommonTabContentView.c aEM;
    private b aER;
    private InterfaceC0055a aES;
    private b.a aET;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int alQ = 0;
    private int alR = 0;
    private int aEU = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0055a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int aEV;
        public int aEW;
    }

    public abstract void Dl();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(b.a aVar) {
        this.aET = aVar;
    }

    public void setEditorTools(i iVar) {
        this.Lt = iVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Lt != null) {
            this.Lt.b(aVar);
        }
    }

    public b Ea() {
        return this.aER;
    }

    public void a(b bVar) {
        this.aER = bVar;
    }

    public InterfaceC0055a Eb() {
        return this.aES;
    }

    public void a(InterfaceC0055a interfaceC0055a) {
        this.aES = interfaceC0055a;
    }

    public int Ec() {
        return this.column;
    }

    public void eQ(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eR(int i) {
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

    public int getPaddingLeft() {
        return this.alQ;
    }

    public int getPaddingRight() {
        return this.alR;
    }

    public int Ed() {
        return this.aEU;
    }

    public void eS(int i) {
        this.aEU = i;
    }

    public b.a Ee() {
        return this.aET;
    }

    public void a(CommonTabContentView.c cVar) {
        this.aEM = cVar;
    }

    public CommonTabContentView.c Ef() {
        return this.aEM;
    }
}
