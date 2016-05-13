package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.c;
/* loaded from: classes.dex */
public abstract class b implements com.baidu.tbadk.editortools.b {
    protected l BV;
    private CommonTabContentView.c asl;
    private C0041b asq;
    private a asr;
    private c.a asu;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int ass = 0;
    private int ast = 0;
    private int asv = 0;

    /* loaded from: classes.dex */
    public interface a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* renamed from: com.baidu.tbadk.editortools.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0041b {
        public int asw;
        public int asx;
    }

    public abstract void Bq();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(c.a aVar) {
        this.asu = aVar;
    }

    public void setEditorTools(l lVar) {
        this.BV = lVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.BV != null) {
            this.BV.b(aVar);
        }
    }

    public C0041b Cn() {
        return this.asq;
    }

    public void a(C0041b c0041b) {
        this.asq = c0041b;
    }

    public a Co() {
        return this.asr;
    }

    public void a(a aVar) {
        this.asr = aVar;
    }

    public int Cp() {
        return this.column;
    }

    public void es(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void et(int i) {
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
        return this.ass;
    }

    public int getPaddingRight() {
        return this.ast;
    }

    public int Cq() {
        return this.asv;
    }

    public void eu(int i) {
        this.asv = i;
    }

    public c.a Cr() {
        return this.asu;
    }

    public void a(CommonTabContentView.c cVar) {
        this.asl = cVar;
    }

    public CommonTabContentView.c Cs() {
        return this.asl;
    }
}
