package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.b;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected i Jp;
    private CommonTabContentView.c aEe;
    private b aEj;
    private InterfaceC0058a aEk;
    private b.a aEl;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int alj = 0;
    private int alk = 0;
    private int aEm = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0058a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int aEn;
        public int aEo;
    }

    public abstract void Dg();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(b.a aVar) {
        this.aEl = aVar;
    }

    public void setEditorTools(i iVar) {
        this.Jp = iVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Jp != null) {
            this.Jp.b(aVar);
        }
    }

    public b DX() {
        return this.aEj;
    }

    public void a(b bVar) {
        this.aEj = bVar;
    }

    public InterfaceC0058a DY() {
        return this.aEk;
    }

    public void a(InterfaceC0058a interfaceC0058a) {
        this.aEk = interfaceC0058a;
    }

    public int DZ() {
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
        return this.alj;
    }

    public int getPaddingRight() {
        return this.alk;
    }

    public int Ea() {
        return this.aEm;
    }

    public void eS(int i) {
        this.aEm = i;
    }

    public b.a Eb() {
        return this.aEl;
    }

    public void a(CommonTabContentView.c cVar) {
        this.aEe = cVar;
    }

    public CommonTabContentView.c Ec() {
        return this.aEe;
    }
}
