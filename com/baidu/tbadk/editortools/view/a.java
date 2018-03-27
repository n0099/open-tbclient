package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.b;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected i axH;
    private CommonTabContentView.c buU;
    private b buZ;
    private InterfaceC0107a bva;
    private b.a bvd;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int bvb = 0;
    private int bvc = 0;
    private int kq = 0;
    private int kr = 0;
    private int bve = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0107a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int bvf;
        public int bvg;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(b.a aVar) {
        this.bvd = aVar;
    }

    public void setEditorTools(i iVar) {
        this.axH = iVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axH != null) {
            this.axH.b(aVar);
        }
    }

    public b Mc() {
        return this.buZ;
    }

    public void a(b bVar) {
        this.buZ = bVar;
    }

    public InterfaceC0107a Md() {
        return this.bva;
    }

    public void a(InterfaceC0107a interfaceC0107a) {
        this.bva = interfaceC0107a;
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
        return this.bvb;
    }

    public int getPaddingRight() {
        return this.bvc;
    }

    public int Mf() {
        return this.bve;
    }

    public b.a Mg() {
        return this.bvd;
    }

    public void a(CommonTabContentView.c cVar) {
        this.buU = cVar;
    }

    public CommonTabContentView.c Mh() {
        return this.buU;
    }
}
