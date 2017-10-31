package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.b;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected i Jb;
    private CommonTabContentView.c aDQ;
    private b aDV;
    private InterfaceC0056a aDW;
    private b.a aDZ;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int aDX = 0;
    private int aDY = 0;
    private int aEa = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0056a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int aEb;
        public int aEc;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(b.a aVar) {
        this.aDZ = aVar;
    }

    public void setEditorTools(i iVar) {
        this.Jb = iVar;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Jb != null) {
            this.Jb.b(aVar);
        }
    }

    public b DK() {
        return this.aDV;
    }

    public void a(b bVar) {
        this.aDV = bVar;
    }

    public InterfaceC0056a DL() {
        return this.aDW;
    }

    public void a(InterfaceC0056a interfaceC0056a) {
        this.aDW = interfaceC0056a;
    }

    public int DM() {
        return this.column;
    }

    public void fb(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void fc(int i) {
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
        return this.aDX;
    }

    public int getPaddingRight() {
        return this.aDY;
    }

    public int DN() {
        return this.aEa;
    }

    public b.a DO() {
        return this.aDZ;
    }

    public void a(CommonTabContentView.c cVar) {
        this.aDQ = cVar;
    }

    public CommonTabContentView.c DP() {
        return this.aDQ;
    }
}
