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
    private CommonTabContentView.b cuG;
    private b cuL;
    private InterfaceC0254a cuM;
    private CommonTabHost.a cuQ;
    private int KX = 0;
    private int cuN = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int cuO = 0;
    private int cuP = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int cuR = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0254a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int cuS;
        public int cuT;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.cuQ = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.TU = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TU != null) {
            this.TU.b(aVar);
        }
    }

    public b ata() {
        return this.cuL;
    }

    public void a(b bVar) {
        this.cuL = bVar;
    }

    public InterfaceC0254a atb() {
        return this.cuM;
    }

    public void a(InterfaceC0254a interfaceC0254a) {
        this.cuM = interfaceC0254a;
    }

    public int atc() {
        return this.KX;
    }

    public void ky(int i) {
        this.KX = i;
    }

    public int atd() {
        return this.cuN;
    }

    public void kz(int i) {
        this.cuN = i;
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
        return this.cuO;
    }

    public int getPaddingRight() {
        return this.cuP;
    }

    public int ate() {
        return this.cuR;
    }

    public CommonTabHost.a atf() {
        return this.cuQ;
    }

    public void a(CommonTabContentView.b bVar) {
        this.cuG = bVar;
    }

    public CommonTabContentView.b atg() {
        return this.cuG;
    }
}
