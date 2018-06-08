package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools Qh;
    private CommonTabContentView.b aNP;
    private b aNU;
    private InterfaceC0113a aNV;
    private CommonTabHost.a aNY;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int aNW = 0;
    private int aNX = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int aNZ = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0113a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int aOa;
        public int aOb;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.aNY = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Qh = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Qh != null) {
            this.Qh.b(aVar);
        }
    }

    public b Ih() {
        return this.aNU;
    }

    public void a(b bVar) {
        this.aNU = bVar;
    }

    public InterfaceC0113a Ii() {
        return this.aNV;
    }

    public void a(InterfaceC0113a interfaceC0113a) {
        this.aNV = interfaceC0113a;
    }

    public int Ij() {
        return this.column;
    }

    public void eV(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eW(int i) {
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
        return this.aNW;
    }

    public int getPaddingRight() {
        return this.aNX;
    }

    public int Ik() {
        return this.aNZ;
    }

    public CommonTabHost.a Il() {
        return this.aNY;
    }

    public void a(CommonTabContentView.b bVar) {
        this.aNP = bVar;
    }

    public CommonTabContentView.b Im() {
        return this.aNP;
    }
}
