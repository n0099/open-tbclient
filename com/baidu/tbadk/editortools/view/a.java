package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools abk;
    private CommonTabContentView.b fqI;
    private b fqN;
    private InterfaceC0592a fqO;
    private CommonTabHost.a fqP;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int mPaddingLeft = 0;
    private int mPaddingRight = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int fqQ = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0592a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int fqR;
        public int fqS;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.fqP = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.abk = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.abk != null) {
            this.abk.b(aVar);
        }
    }

    public b bAL() {
        return this.fqN;
    }

    public void a(b bVar) {
        this.fqN = bVar;
    }

    public InterfaceC0592a bAM() {
        return this.fqO;
    }

    public void a(InterfaceC0592a interfaceC0592a) {
        this.fqO = interfaceC0592a;
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

    public void rx(int i) {
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
        return this.mPaddingLeft;
    }

    public int getPaddingRight() {
        return this.mPaddingRight;
    }

    public int bAN() {
        return this.fqQ;
    }

    public CommonTabHost.a bAO() {
        return this.fqP;
    }

    public void a(CommonTabContentView.b bVar) {
        this.fqI = bVar;
    }

    public CommonTabContentView.b bAP() {
        return this.fqI;
    }
}
