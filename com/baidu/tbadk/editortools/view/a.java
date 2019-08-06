package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools TU;
    private CommonTabContentView.b cuN;
    private b cuS;
    private InterfaceC0254a cuT;
    private CommonTabHost.a cuX;
    private int KX = 0;
    private int cuU = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int cuV = 0;
    private int cuW = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int cuY = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0254a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int cuZ;
        public int cva;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.cuX = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.TU = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TU != null) {
            this.TU.b(aVar);
        }
    }

    public b atc() {
        return this.cuS;
    }

    public void a(b bVar) {
        this.cuS = bVar;
    }

    public InterfaceC0254a atd() {
        return this.cuT;
    }

    public void a(InterfaceC0254a interfaceC0254a) {
        this.cuT = interfaceC0254a;
    }

    public int ate() {
        return this.KX;
    }

    public void kz(int i) {
        this.KX = i;
    }

    public int atf() {
        return this.cuU;
    }

    public void kA(int i) {
        this.cuU = i;
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
        return this.cuV;
    }

    public int getPaddingRight() {
        return this.cuW;
    }

    public int atg() {
        return this.cuY;
    }

    public CommonTabHost.a ath() {
        return this.cuX;
    }

    public void a(CommonTabContentView.b bVar) {
        this.cuN = bVar;
    }

    public CommonTabContentView.b ati() {
        return this.cuN;
    }
}
