package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools CJ;
    private CommonTabContentView.b cHc;
    private b cHh;
    private InterfaceC0290a cHi;
    private CommonTabHost.a cHl;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int cHj = 0;
    private int cHk = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int cHm = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0290a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int cHn;
        public int cHo;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.cHl = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.CJ = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.CJ != null) {
            this.CJ.b(aVar);
        }
    }

    public b auY() {
        return this.cHh;
    }

    public void a(b bVar) {
        this.cHh = bVar;
    }

    public InterfaceC0290a auZ() {
        return this.cHi;
    }

    public void a(InterfaceC0290a interfaceC0290a) {
        this.cHi = interfaceC0290a;
    }

    public int getColumn() {
        return this.column;
    }

    public void jT(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void jU(int i) {
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
        return this.cHj;
    }

    public int getPaddingRight() {
        return this.cHk;
    }

    public int ava() {
        return this.cHm;
    }

    public CommonTabHost.a avb() {
        return this.cHl;
    }

    public void a(CommonTabContentView.b bVar) {
        this.cHc = bVar;
    }

    public CommonTabContentView.b avc() {
        return this.cHc;
    }
}
