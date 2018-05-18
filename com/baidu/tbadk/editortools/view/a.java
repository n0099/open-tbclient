package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools JO;
    private CommonTabHost.a aFC;
    private CommonTabContentView.b aFt;
    private b aFy;
    private InterfaceC0096a aFz;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int aFA = 0;
    private int aFB = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int aFD = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0096a {
        View getView(int i, View view2, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int aFE;
        public int aFF;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.aFC = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.JO = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JO != null) {
            this.JO.b(aVar);
        }
    }

    public b ED() {
        return this.aFy;
    }

    public void a(b bVar) {
        this.aFy = bVar;
    }

    public InterfaceC0096a EE() {
        return this.aFz;
    }

    public void a(InterfaceC0096a interfaceC0096a) {
        this.aFz = interfaceC0096a;
    }

    public int EF() {
        return this.column;
    }

    public void eR(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eS(int i) {
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
        return this.aFA;
    }

    public int getPaddingRight() {
        return this.aFB;
    }

    public int EG() {
        return this.aFD;
    }

    public CommonTabHost.a EH() {
        return this.aFC;
    }

    public void a(CommonTabContentView.b bVar) {
        this.aFt = bVar;
    }

    public CommonTabContentView.b EI() {
        return this.aFt;
    }
}
