package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.b;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected i axO;
    private b bsE;
    private InterfaceC0083a bsF;
    private b.a bsI;
    private CommonTabContentView.c bsz;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int bsG = 0;
    private int bsH = 0;
    private int kq = 0;
    private int kr = 0;
    private int bsJ = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0083a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int bsK;
        public int bsL;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(b.a aVar) {
        this.bsI = aVar;
    }

    public void setEditorTools(i iVar) {
        this.axO = iVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axO != null) {
            this.axO.b(aVar);
        }
    }

    public b LG() {
        return this.bsE;
    }

    public void a(b bVar) {
        this.bsE = bVar;
    }

    public InterfaceC0083a LH() {
        return this.bsF;
    }

    public void a(InterfaceC0083a interfaceC0083a) {
        this.bsF = interfaceC0083a;
    }

    public int LI() {
        return this.column;
    }

    public void hX(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void hY(int i) {
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
        return this.bsG;
    }

    public int getPaddingRight() {
        return this.bsH;
    }

    public int LJ() {
        return this.bsJ;
    }

    public b.a LK() {
        return this.bsI;
    }

    public void a(CommonTabContentView.c cVar) {
        this.bsz = cVar;
    }

    public CommonTabContentView.c LL() {
        return this.bsz;
    }
}
