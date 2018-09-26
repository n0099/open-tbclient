package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools SG;
    private CommonTabContentView.b aRZ;
    private b aSe;
    private InterfaceC0111a aSf;
    private CommonTabHost.a aSi;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int aSg = 0;
    private int aSh = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int aSj = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0111a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int aSk;
        public int aSl;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.aSi = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.SG = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.SG != null) {
            this.SG.b(aVar);
        }
    }

    public b JK() {
        return this.aSe;
    }

    public void a(b bVar) {
        this.aSe = bVar;
    }

    public InterfaceC0111a JL() {
        return this.aSf;
    }

    public void a(InterfaceC0111a interfaceC0111a) {
        this.aSf = interfaceC0111a;
    }

    public int JM() {
        return this.column;
    }

    public void fi(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void fj(int i) {
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
        return this.aSg;
    }

    public int getPaddingRight() {
        return this.aSh;
    }

    public int JN() {
        return this.aSj;
    }

    public CommonTabHost.a JO() {
        return this.aSi;
    }

    public void a(CommonTabContentView.b bVar) {
        this.aRZ = bVar;
    }

    public CommonTabContentView.b JP() {
        return this.aRZ;
    }
}
