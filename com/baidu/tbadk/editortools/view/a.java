package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools Ta;
    private CommonTabContentView.b aXq;
    private b aXv;
    private InterfaceC0159a aXw;
    private CommonTabHost.a aXz;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int aXx = 0;
    private int aXy = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int aXA = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0159a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int aXB;
        public int aXC;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.aXz = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Ta = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Ta != null) {
            this.Ta.b(aVar);
        }
    }

    public b LU() {
        return this.aXv;
    }

    public void a(b bVar) {
        this.aXv = bVar;
    }

    public InterfaceC0159a LV() {
        return this.aXw;
    }

    public void a(InterfaceC0159a interfaceC0159a) {
        this.aXw = interfaceC0159a;
    }

    public int LW() {
        return this.column;
    }

    public void fF(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void fG(int i) {
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
        return this.aXx;
    }

    public int getPaddingRight() {
        return this.aXy;
    }

    public int LX() {
        return this.aXA;
    }

    public CommonTabHost.a LY() {
        return this.aXz;
    }

    public void a(CommonTabContentView.b bVar) {
        this.aXq = bVar;
    }

    public CommonTabContentView.b LZ() {
        return this.aXq;
    }
}
