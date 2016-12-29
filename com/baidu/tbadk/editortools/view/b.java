package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.c;
/* loaded from: classes.dex */
public abstract class b implements com.baidu.tbadk.editortools.b {
    protected j EM;
    private CommonTabContentView.c awO;
    private C0042b awT;
    private a awU;
    private c.a awX;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int awV = 0;
    private int awW = 0;
    private int awY = 0;

    /* loaded from: classes.dex */
    public interface a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* renamed from: com.baidu.tbadk.editortools.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0042b {
        public int awZ;
        public int axa;
    }

    public abstract void CL();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(c.a aVar) {
        this.awX = aVar;
    }

    public void setEditorTools(j jVar) {
        this.EM = jVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.EM != null) {
            this.EM.b(aVar);
        }
    }

    public C0042b DC() {
        return this.awT;
    }

    public void a(C0042b c0042b) {
        this.awT = c0042b;
    }

    public a DD() {
        return this.awU;
    }

    public void a(a aVar) {
        this.awU = aVar;
    }

    public int DE() {
        return this.column;
    }

    public void eO(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eP(int i) {
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
        return this.awV;
    }

    public int getPaddingRight() {
        return this.awW;
    }

    public int DF() {
        return this.awY;
    }

    public void eQ(int i) {
        this.awY = i;
    }

    public c.a DG() {
        return this.awX;
    }

    public void a(CommonTabContentView.c cVar) {
        this.awO = cVar;
    }

    public CommonTabContentView.c DH() {
        return this.awO;
    }
}
