package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tbadk.editortools.view.CommonTabHost;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.tbadk.editortools.b {
    protected EditorTools Dl;
    private CommonTabContentView.b cHT;
    private b cHY;
    private InterfaceC0295a cHZ;
    private CommonTabHost.a cIc;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;
    private int cIa = 0;
    private int cIb = 0;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int cId = 0;

    /* renamed from: com.baidu.tbadk.editortools.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0295a {
        View getView(int i, View view, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class b {
        public int cIe;
        public int cIf;
    }

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public void a(CommonTabHost.a aVar) {
        this.cIc = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Dl = editorTools;
    }

    protected void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Dl != null) {
            this.Dl.b(aVar);
        }
    }

    public b ava() {
        return this.cHY;
    }

    public void a(b bVar) {
        this.cHY = bVar;
    }

    public InterfaceC0295a avb() {
        return this.cHZ;
    }

    public void a(InterfaceC0295a interfaceC0295a) {
        this.cHZ = interfaceC0295a;
    }

    public int getColumn() {
        return this.column;
    }

    public void jU(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void jV(int i) {
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
        return this.cIa;
    }

    public int getPaddingRight() {
        return this.cIb;
    }

    public int avc() {
        return this.cId;
    }

    public CommonTabHost.a avd() {
        return this.cIc;
    }

    public void a(CommonTabContentView.b bVar) {
        this.cHT = bVar;
    }

    public CommonTabContentView.b ave() {
        return this.cHT;
    }
}
