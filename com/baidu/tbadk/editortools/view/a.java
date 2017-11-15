package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.b;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected i Jb;
    private CommonTabContentView.c aDY;
    private b aEd;
    private InterfaceC0056a aEe;
    private b.a aEh;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int aEf = 0;
    private int aEg = 0;
    private int aEi = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0056a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int aEj;
        public int aEk;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(b.a aVar) {
        this.aEh = aVar;
    }

    public void setEditorTools(i iVar) {
        this.Jb = iVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Jb != null) {
            this.Jb.b(aVar);
        }
    }

    public b DW() {
        return this.aEd;
    }

    public void a(b bVar) {
        this.aEd = bVar;
    }

    public InterfaceC0056a DX() {
        return this.aEe;
    }

    public void a(InterfaceC0056a interfaceC0056a) {
        this.aEe = interfaceC0056a;
    }

    public int DY() {
        return this.column;
    }

    public void fa(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void fb(int i) {
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
        return this.aEf;
    }

    public int getPaddingRight() {
        return this.aEg;
    }

    public int DZ() {
        return this.aEi;
    }

    public b.a Ea() {
        return this.aEh;
    }

    public void a(CommonTabContentView.c cVar) {
        this.aDY = cVar;
    }

    public CommonTabContentView.c Eb() {
        return this.aDY;
    }
}
