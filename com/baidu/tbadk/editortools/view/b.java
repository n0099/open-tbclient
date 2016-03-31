package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.c;
/* loaded from: classes.dex */
public abstract class b implements com.baidu.tbadk.editortools.b {
    protected l LE;
    private CommonTabContentView.c awk;
    private C0050b awp;
    private a awq;
    private c.a awt;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int awr = 0;
    private int aws = 0;
    private int awu = 0;

    /* loaded from: classes.dex */
    public interface a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* renamed from: com.baidu.tbadk.editortools.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0050b {
        public int awv;
        public int aww;
    }

    public abstract void Dv();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(c.a aVar) {
        this.awt = aVar;
    }

    public void setEditorTools(l lVar) {
        this.LE = lVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.LE != null) {
            this.LE.b(aVar);
        }
    }

    public C0050b Et() {
        return this.awp;
    }

    public void a(C0050b c0050b) {
        this.awp = c0050b;
    }

    public a Eu() {
        return this.awq;
    }

    public void a(a aVar) {
        this.awq = aVar;
    }

    public int Ev() {
        return this.column;
    }

    public void eN(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eO(int i) {
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
        return this.awr;
    }

    public int getPaddingRight() {
        return this.aws;
    }

    public int Ew() {
        return this.awu;
    }

    public void eP(int i) {
        this.awu = i;
    }

    public c.a Ex() {
        return this.awt;
    }

    public void a(CommonTabContentView.c cVar) {
        this.awk = cVar;
    }

    public CommonTabContentView.c Ey() {
        return this.awk;
    }
}
