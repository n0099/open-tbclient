package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools JS;
    private CommonTabHost.a aFB;
    private CommonTabContentView.b aFs;
    private b aFx;
    private InterfaceC0096a aFy;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int aFz = 0;
    private int aFA = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int aFC = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0096a {
        View getView(int i, View view2, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int aFD;
        public int aFE;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.aFB = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.JS = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JS != null) {
            this.JS.b(aVar);
        }
    }

    public b EF() {
        return this.aFx;
    }

    public void a(b bVar) {
        this.aFx = bVar;
    }

    public InterfaceC0096a EG() {
        return this.aFy;
    }

    public void a(InterfaceC0096a interfaceC0096a) {
        this.aFy = interfaceC0096a;
    }

    public int EH() {
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
        return this.aFz;
    }

    public int getPaddingRight() {
        return this.aFA;
    }

    public int EI() {
        return this.aFC;
    }

    public CommonTabHost.a EJ() {
        return this.aFB;
    }

    public void a(CommonTabContentView.b bVar) {
        this.aFs = bVar;
    }

    public CommonTabContentView.b EK() {
        return this.aFs;
    }
}
