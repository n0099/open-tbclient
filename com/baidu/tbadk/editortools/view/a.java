package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools Qg;
    private CommonTabContentView.b aOH;
    private b aOM;
    private InterfaceC0111a aON;
    private CommonTabHost.a aOQ;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int aOO = 0;
    private int aOP = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int aOR = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0111a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int aOS;
        public int aOT;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.aOQ = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Qg = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Qg != null) {
            this.Qg.b(aVar);
        }
    }

    public b Iu() {
        return this.aOM;
    }

    public void a(b bVar) {
        this.aOM = bVar;
    }

    public InterfaceC0111a Iv() {
        return this.aON;
    }

    public void a(InterfaceC0111a interfaceC0111a) {
        this.aON = interfaceC0111a;
    }

    public int Iw() {
        return this.column;
    }

    public void eW(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void eX(int i) {
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
        return this.aOO;
    }

    public int getPaddingRight() {
        return this.aOP;
    }

    public int Ix() {
        return this.aOR;
    }

    public CommonTabHost.a Iy() {
        return this.aOQ;
    }

    public void a(CommonTabContentView.b bVar) {
        this.aOH = bVar;
    }

    public CommonTabContentView.b Iz() {
        return this.aOH;
    }
}
