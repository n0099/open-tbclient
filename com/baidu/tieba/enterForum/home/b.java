package com.baidu.tieba.enterForum.home;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.h;
import com.baidu.tieba.enterForum.view.a;
import com.baidu.tieba.enterForum.view.f;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b {
    private f iBd;
    private com.baidu.tieba.enterForum.view.a iDt;
    private a iDu;
    private Context mContext;
    private int mSortType;
    private int mStatusBarHeight;
    private TextView mTitle;
    private boolean iDv = false;
    private a.InterfaceC0707a iDw = new a.InterfaceC0707a() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.view.a.InterfaceC0707a
        public void dR(int i) {
            b.this.mSortType = i;
            TiebaStatic.log(new aq("c13369").an("obj_type", i == 1 ? 2 : 1));
            b.this.cuY();
            if (b.this.iDu != null) {
                b.this.iDu.xo(b.this.mSortType);
            }
        }
    };
    private View.OnClickListener ffD = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.iBd.cwA()) {
                if (view == b.this.mTitle) {
                    if (b.this.iDt == null) {
                        b.this.iDt = new com.baidu.tieba.enterForum.view.a(b.this.mContext);
                        b.this.iDt.setOnDismissListener(b.this.mOnDismissListener);
                        b.this.iDt.a(b.this.iDw);
                        b.this.iDt.xH(b.this.mStatusBarHeight);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new h(b.this.mContext.getString(R.string.level_sort), 1));
                    arrayList.add(new h(b.this.mContext.getString(R.string.update_sort), 2));
                    b.this.iDt.setData(arrayList, b.this.mSortType);
                    b.this.iDt.O(b.this.mTitle);
                }
                b.this.iDv = true;
                b.this.pH(b.this.iDv);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.iDv = false;
            b.this.pH(b.this.iDv);
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void xo(int i);
    }

    public b(Context context, int i, int i2, f fVar) {
        this.mContext = context;
        this.mSortType = i;
        this.mStatusBarHeight = i2;
        this.iBd = fVar;
    }

    public void m(TextView textView) {
        this.mTitle = textView;
    }

    public void Tn() {
        if (this.iDt != null) {
            this.iDt.Tn();
        }
    }

    public void cuY() {
        if (cuZ() && this.mTitle != null) {
            switch (this.mSortType) {
                case 1:
                    this.mTitle.setText(R.string.level_sort);
                    break;
                case 2:
                    this.mTitle.setText(R.string.update_sort);
                    break;
            }
            this.mTitle.setOnClickListener(this.ffD);
            pH(this.iDv);
        }
    }

    public boolean cuZ() {
        return this.mSortType == 1 || this.mSortType == 2;
    }

    public void setSortType(int i) {
        if (cuZ()) {
            this.mSortType = i;
            cuY();
        }
    }

    public void a(a aVar) {
        this.iDu = aVar;
    }

    public void onChangeSkinType(int i) {
        if (cuZ()) {
            ao.setViewTextColor(this.mTitle, R.color.CAM_X0105, i);
            if (this.mTitle != null) {
                pH(this.iDv);
            }
        }
        if (this.iDt != null && this.iDv) {
            this.iDt.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pH(boolean z) {
        int i = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
        com.baidu.tieba.enterForum.data.c cwG = this.iBd != null ? this.iBd.cwG() : null;
        if (cwG != null && cwG.iBJ) {
            if (this.iBd != null && this.iBd.isShow()) {
                ao.setViewTextColor(this.mTitle, R.color.CAM_X0107);
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bsx().a(i, R.color.CAM_X0108, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                return;
            }
            ao.setViewTextColor(this.mTitle, R.color.CAM_X0107);
            this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bsx().a(i, R.color.CAM_X0108, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            return;
        }
        ao.setViewTextColor(this.mTitle, R.color.CAM_X0107);
        this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bsx().a(i, R.color.CAM_X0108, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }
}
