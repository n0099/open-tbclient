package com.baidu.tieba.homepage.gamevideo.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bg;
/* loaded from: classes2.dex */
public class a extends PopupWindow {
    private TbPageContext eUY;
    private InterfaceC0746a kfs;

    /* renamed from: com.baidu.tieba.homepage.gamevideo.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0746a {
        void cQp();
    }

    public a(TbPageContext tbPageContext, View view, int i, int i2) {
        super(view, i, i2);
        this.eUY = tbPageContext;
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            setHeight(bg.getScreenFullSize(this.eUY.getPageActivity())[1] - rect.bottom);
        }
        super.showAsDropDown(view);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            setHeight(bg.getScreenFullSize(this.eUY.getPageActivity())[1] - rect.bottom);
        }
        super.showAsDropDown(view, i, i2);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (this.kfs != null) {
            this.kfs.cQp();
        } else {
            super.dismiss();
        }
    }

    public void Yc() {
        super.dismiss();
    }

    public void a(InterfaceC0746a interfaceC0746a) {
        this.kfs = interfaceC0746a;
    }
}
