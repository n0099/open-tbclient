package com.baidu.tieba.homepage.gamevideo.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.be;
/* loaded from: classes16.dex */
public class a extends PopupWindow {
    private TbPageContext dVN;
    private InterfaceC0645a iwa;

    /* renamed from: com.baidu.tieba.homepage.gamevideo.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC0645a {
        void cmu();
    }

    public a(TbPageContext tbPageContext, View view, int i, int i2) {
        super(view, i, i2);
        this.dVN = tbPageContext;
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            setHeight(be.getScreenFullSize(this.dVN.getPageActivity())[1] - rect.bottom);
        }
        super.showAsDropDown(view);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            setHeight(be.getScreenFullSize(this.dVN.getPageActivity())[1] - rect.bottom);
        }
        super.showAsDropDown(view, i, i2);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (this.iwa != null) {
            this.iwa.cmu();
        } else {
            super.dismiss();
        }
    }

    public void byi() {
        super.dismiss();
    }

    public void a(InterfaceC0645a interfaceC0645a) {
        this.iwa = interfaceC0645a;
    }
}
