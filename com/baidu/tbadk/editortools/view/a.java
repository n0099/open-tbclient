package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.b;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected i axP;
    private CommonTabContentView.c bve;
    private b bvj;
    private InterfaceC0106a bvk;
    private b.a bvn;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int bvl = 0;
    private int bvm = 0;
    private int kq = 0;
    private int kr = 0;
    private int bvo = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0106a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int bvp;
        public int bvq;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(b.a aVar) {
        this.bvn = aVar;
    }

    public void setEditorTools(i iVar) {
        this.axP = iVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axP != null) {
            this.axP.b(aVar);
        }
    }

    public b Mc() {
        return this.bvj;
    }

    public void a(b bVar) {
        this.bvj = bVar;
    }

    public InterfaceC0106a Md() {
        return this.bvk;
    }

    public void a(InterfaceC0106a interfaceC0106a) {
        this.bvk = interfaceC0106a;
    }

    public int Me() {
        return this.column;
    }

    public void hR(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void hS(int i) {
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
        return this.bvl;
    }

    public int getPaddingRight() {
        return this.bvm;
    }

    public int Mf() {
        return this.bvo;
    }

    public b.a Mg() {
        return this.bvn;
    }

    public void a(CommonTabContentView.c cVar) {
        this.bve = cVar;
    }

    public CommonTabContentView.c Mh() {
        return this.bve;
    }
}
