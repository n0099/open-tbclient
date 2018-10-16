package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools SY;
    private CommonTabContentView.b aWA;
    private b aWF;
    private InterfaceC0135a aWG;
    private CommonTabHost.a aWJ;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int aWH = 0;
    private int aWI = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int aWK = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0135a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int aWL;
        public int aWM;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.aWJ = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.SY = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.SY != null) {
            this.SY.b(aVar);
        }
    }

    public b LI() {
        return this.aWF;
    }

    public void a(b bVar) {
        this.aWF = bVar;
    }

    public InterfaceC0135a LJ() {
        return this.aWG;
    }

    public void a(InterfaceC0135a interfaceC0135a) {
        this.aWG = interfaceC0135a;
    }

    public int LK() {
        return this.column;
    }

    public void fr(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void fs(int i) {
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
        return this.aWH;
    }

    public int getPaddingRight() {
        return this.aWI;
    }

    public int LL() {
        return this.aWK;
    }

    public CommonTabHost.a LM() {
        return this.aWJ;
    }

    public void a(CommonTabContentView.b bVar) {
        this.aWA = bVar;
    }

    public CommonTabContentView.b LN() {
        return this.aWA;
    }
}
