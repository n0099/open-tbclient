package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.c;
/* loaded from: classes.dex */
public abstract class b implements com.baidu.tbadk.editortools.b {
    protected j DX;
    private CommonTabContentView.c avS;
    private C0042b avX;
    private a avY;
    private c.a awb;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int avZ = 0;
    private int awa = 0;
    private int awc = 0;

    /* loaded from: classes.dex */
    public interface a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* renamed from: com.baidu.tbadk.editortools.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0042b {
        public int awd;
        public int awe;
    }

    public abstract void CG();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(c.a aVar) {
        this.awb = aVar;
    }

    public void setEditorTools(j jVar) {
        this.DX = jVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.DX != null) {
            this.DX.b(aVar);
        }
    }

    public C0042b Dx() {
        return this.avX;
    }

    public void a(C0042b c0042b) {
        this.avX = c0042b;
    }

    public a Dy() {
        return this.avY;
    }

    public void a(a aVar) {
        this.avY = aVar;
    }

    public int Dz() {
        return this.column;
    }

    public void eP(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eQ(int i) {
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
        return this.avZ;
    }

    public int getPaddingRight() {
        return this.awa;
    }

    public int DA() {
        return this.awc;
    }

    public void eR(int i) {
        this.awc = i;
    }

    public c.a DB() {
        return this.awb;
    }

    public void a(CommonTabContentView.c cVar) {
        this.avS = cVar;
    }

    public CommonTabContentView.c DC() {
        return this.avS;
    }
}
