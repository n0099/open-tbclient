package com.baidu.tieba.homepage.gamevideo.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bf;
/* loaded from: classes2.dex */
public class a extends PopupWindow {
    private TbPageContext eXu;
    private InterfaceC0752a kch;

    /* renamed from: com.baidu.tieba.homepage.gamevideo.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0752a {
        void cSc();
    }

    public a(TbPageContext tbPageContext, View view, int i, int i2) {
        super(view, i, i2);
        this.eXu = tbPageContext;
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            setHeight(bf.getScreenFullSize(this.eXu.getPageActivity())[1] - rect.bottom);
        }
        super.showAsDropDown(view);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            setHeight(bf.getScreenFullSize(this.eXu.getPageActivity())[1] - rect.bottom);
        }
        super.showAsDropDown(view, i, i2);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (this.kch != null) {
            this.kch.cSc();
        } else {
            super.dismiss();
        }
    }

    public void aag() {
        super.dismiss();
    }

    public void a(InterfaceC0752a interfaceC0752a) {
        this.kch = interfaceC0752a;
    }
}
