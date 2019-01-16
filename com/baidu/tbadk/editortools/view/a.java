package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools Tj;
    private CommonTabContentView.b bbB;
    private b bbG;
    private InterfaceC0169a bbH;
    private CommonTabHost.a bbK;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int bbI = 0;
    private int bbJ = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int bbL = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0169a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int bbM;
        public int bbN;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.bbK = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Tj = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Tj != null) {
            this.Tj.b(aVar);
        }
    }

    public b Nq() {
        return this.bbG;
    }

    public void a(b bVar) {
        this.bbG = bVar;
    }

    public InterfaceC0169a Nr() {
        return this.bbH;
    }

    public void a(InterfaceC0169a interfaceC0169a) {
        this.bbH = interfaceC0169a;
    }

    public int Ns() {
        return this.column;
    }

    public void fU(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void fV(int i) {
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
        return this.bbI;
    }

    public int getPaddingRight() {
        return this.bbJ;
    }

    public int Nt() {
        return this.bbL;
    }

    public CommonTabHost.a Nu() {
        return this.bbK;
    }

    public void a(CommonTabContentView.b bVar) {
        this.bbB = bVar;
    }

    public CommonTabContentView.b Nv() {
        return this.bbB;
    }
}
