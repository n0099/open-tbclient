package com.baidu.tieba.homepage.gamevideo.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bb;
/* loaded from: classes7.dex */
public class a extends PopupWindow {
    private TbPageContext cRe;
    private InterfaceC0511a gYR;

    /* renamed from: com.baidu.tieba.homepage.gamevideo.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0511a {
        void bMz();
    }

    public a(TbPageContext tbPageContext, View view, int i, int i2) {
        super(view, i, i2);
        this.cRe = tbPageContext;
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            setHeight(bb.getScreenFullSize(this.cRe.getPageActivity())[1] - rect.bottom);
        }
        super.showAsDropDown(view);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            setHeight(bb.getScreenFullSize(this.cRe.getPageActivity())[1] - rect.bottom);
        }
        super.showAsDropDown(view, i, i2);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (this.gYR != null) {
            this.gYR.bMz();
        } else {
            super.dismiss();
        }
    }

    public void bbr() {
        super.dismiss();
    }

    public void a(InterfaceC0511a interfaceC0511a) {
        this.gYR = interfaceC0511a;
    }
}
