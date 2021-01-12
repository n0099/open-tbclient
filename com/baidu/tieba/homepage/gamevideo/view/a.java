package com.baidu.tieba.homepage.gamevideo.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bf;
/* loaded from: classes2.dex */
public class a extends PopupWindow {
    private TbPageContext eSJ;
    private InterfaceC0744a jXC;

    /* renamed from: com.baidu.tieba.homepage.gamevideo.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0744a {
        void cOl();
    }

    public a(TbPageContext tbPageContext, View view, int i, int i2) {
        super(view, i, i2);
        this.eSJ = tbPageContext;
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            setHeight(bf.getScreenFullSize(this.eSJ.getPageActivity())[1] - rect.bottom);
        }
        super.showAsDropDown(view);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            setHeight(bf.getScreenFullSize(this.eSJ.getPageActivity())[1] - rect.bottom);
        }
        super.showAsDropDown(view, i, i2);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (this.jXC != null) {
            this.jXC.cOl();
        } else {
            super.dismiss();
        }
    }

    public void Wo() {
        super.dismiss();
    }

    public void a(InterfaceC0744a interfaceC0744a) {
        this.jXC = interfaceC0744a;
    }
}
