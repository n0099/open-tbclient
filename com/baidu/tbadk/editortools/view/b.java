package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.c;
/* loaded from: classes.dex */
public abstract class b implements com.baidu.tbadk.editortools.b {
    protected j Ll;
    private CommonTabContentView.c aBn;
    private C0041b aBs;
    private a aBt;
    private c.a aBw;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int aBu = 0;
    private int aBv = 0;
    private int aBx = 0;

    /* loaded from: classes.dex */
    public interface a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* renamed from: com.baidu.tbadk.editortools.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0041b {
        public int aBy;
        public int aBz;
    }

    public abstract void CZ();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(c.a aVar) {
        this.aBw = aVar;
    }

    public void setEditorTools(j jVar) {
        this.Ll = jVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Ll != null) {
            this.Ll.b(aVar);
        }
    }

    public C0041b DQ() {
        return this.aBs;
    }

    public void a(C0041b c0041b) {
        this.aBs = c0041b;
    }

    public a DR() {
        return this.aBt;
    }

    public void a(a aVar) {
        this.aBt = aVar;
    }

    public int DS() {
        return this.column;
    }

    public void eK(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eL(int i) {
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
        return this.aBu;
    }

    public int getPaddingRight() {
        return this.aBv;
    }

    public int DT() {
        return this.aBx;
    }

    public void eM(int i) {
        this.aBx = i;
    }

    public c.a DU() {
        return this.aBw;
    }

    public void a(CommonTabContentView.c cVar) {
        this.aBn = cVar;
    }

    public CommonTabContentView.c DV() {
        return this.aBn;
    }
}
