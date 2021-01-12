package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools acX;
    private InterfaceC0578a fCA;
    private CommonTabHost.a fCC;
    private CommonTabContentView.b fCu;
    private b fCz;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int VU = 0;
    private int VT = 0;
    private int adE = 0;
    private int fCB = 0;
    private int fCD = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0578a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int fCE;
        public int fCF;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.fCC = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.acX = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acX != null) {
            this.acX.b(aVar);
        }
    }

    public b bCe() {
        return this.fCz;
    }

    public void a(b bVar) {
        this.fCz = bVar;
    }

    public InterfaceC0578a bCf() {
        return this.fCA;
    }

    public void a(InterfaceC0578a interfaceC0578a) {
        this.fCA = interfaceC0578a;
    }

    public int getColumn() {
        return this.column;
    }

    public void setColumn(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void rc(int i) {
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
        return this.VU;
    }

    public void setPaddingLeft(int i) {
        this.VU = i;
    }

    public int getPaddingRight() {
        return this.VT;
    }

    public void setPaddingRight(int i) {
        this.VT = i;
    }

    public int bCg() {
        return this.fCD;
    }

    public CommonTabHost.a bCh() {
        return this.fCC;
    }

    public void a(CommonTabContentView.b bVar) {
        this.fCu = bVar;
    }

    public CommonTabContentView.b bCi() {
        return this.fCu;
    }
}
