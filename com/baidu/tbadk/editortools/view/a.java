package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools acZ;
    private CommonTabContentView.b fHb;
    private b fHg;
    private InterfaceC0595a fHh;
    private CommonTabHost.a fHj;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int VW = 0;
    private int VV = 0;
    private int adG = 0;
    private int fHi = 0;
    private int fHk = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0595a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int fHl;
        public int fHm;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.fHj = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.acZ = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acZ != null) {
            this.acZ.b(aVar);
        }
    }

    public b bFX() {
        return this.fHg;
    }

    public void a(b bVar) {
        this.fHg = bVar;
    }

    public InterfaceC0595a bFY() {
        return this.fHh;
    }

    public void a(InterfaceC0595a interfaceC0595a) {
        this.fHh = interfaceC0595a;
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

    public void sI(int i) {
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
        return this.VW;
    }

    public void setPaddingLeft(int i) {
        this.VW = i;
    }

    public int getPaddingRight() {
        return this.VV;
    }

    public void setPaddingRight(int i) {
        this.VV = i;
    }

    public int bFZ() {
        return this.fHk;
    }

    public CommonTabHost.a bGa() {
        return this.fHj;
    }

    public void a(CommonTabContentView.b bVar) {
        this.fHb = bVar;
    }

    public CommonTabContentView.b bGb() {
        return this.fHb;
    }
}
