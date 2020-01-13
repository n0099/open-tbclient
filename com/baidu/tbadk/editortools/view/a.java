package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools Fv;
    private CommonTabContentView.b dvd;
    private b dvi;
    private InterfaceC0380a dvj;
    private CommonTabHost.a dvk;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int mPaddingLeft = 0;
    private int mPaddingRight = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int dvl = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0380a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int dvm;
        public int dvn;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.dvk = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Fv = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Fv != null) {
            this.Fv.b(aVar);
        }
    }

    public b aNa() {
        return this.dvi;
    }

    public void a(b bVar) {
        this.dvi = bVar;
    }

    public InterfaceC0380a aNb() {
        return this.dvj;
    }

    public void a(InterfaceC0380a interfaceC0380a) {
        this.dvj = interfaceC0380a;
    }

    public int getColumn() {
        return this.column;
    }

    public void mg(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void mh(int i) {
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
        return this.mPaddingLeft;
    }

    public int getPaddingRight() {
        return this.mPaddingRight;
    }

    public int aNc() {
        return this.dvl;
    }

    public CommonTabHost.a aNd() {
        return this.dvk;
    }

    public void a(CommonTabContentView.b bVar) {
        this.dvd = bVar;
    }

    public CommonTabContentView.b aNe() {
        return this.dvd;
    }
}
