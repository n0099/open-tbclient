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
    private f iFK;
    private com.baidu.tieba.enterForum.view.a iIa;
    private a iIb;
    private Context mContext;
    private int mSortType;
    private int mStatusBarHeight;
    private TextView mTitle;
    private boolean iIc = false;
    private a.InterfaceC0724a iId = new a.InterfaceC0724a() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.view.a.InterfaceC0724a
        public void fx(int i) {
            b.this.mSortType = i;
            TiebaStatic.log(new aq("c13369").an("obj_type", i == 1 ? 2 : 1));
            b.this.cyP();
            if (b.this.iIb != null) {
                b.this.iIb.yU(b.this.mSortType);
            }
        }
    };
    private View.OnClickListener fko = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.iFK.cAr()) {
                if (view == b.this.mTitle) {
                    if (b.this.iIa == null) {
                        b.this.iIa = new com.baidu.tieba.enterForum.view.a(b.this.mContext);
                        b.this.iIa.setOnDismissListener(b.this.mOnDismissListener);
                        b.this.iIa.a(b.this.iId);
                        b.this.iIa.zn(b.this.mStatusBarHeight);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new h(b.this.mContext.getString(R.string.level_sort), 1));
                    arrayList.add(new h(b.this.mContext.getString(R.string.update_sort), 2));
                    b.this.iIa.setData(arrayList, b.this.mSortType);
                    b.this.iIa.O(b.this.mTitle);
                }
                b.this.iIc = true;
                b.this.pL(b.this.iIc);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.iIc = false;
            b.this.pL(b.this.iIc);
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void yU(int i);
    }

    public b(Context context, int i, int i2, f fVar) {
        this.mContext = context;
        this.mSortType = i;
        this.mStatusBarHeight = i2;
        this.iFK = fVar;
    }

    public void m(TextView textView) {
        this.mTitle = textView;
    }

    public void Xf() {
        if (this.iIa != null) {
            this.iIa.Xf();
        }
    }

    public void cyP() {
        if (cyQ() && this.mTitle != null) {
            switch (this.mSortType) {
                case 1:
                    this.mTitle.setText(R.string.level_sort);
                    break;
                case 2:
                    this.mTitle.setText(R.string.update_sort);
                    break;
            }
            this.mTitle.setOnClickListener(this.fko);
            pL(this.iIc);
        }
    }

    public boolean cyQ() {
        return this.mSortType == 1 || this.mSortType == 2;
    }

    public void setSortType(int i) {
        if (cyQ()) {
            this.mSortType = i;
            cyP();
        }
    }

    public void a(a aVar) {
        this.iIb = aVar;
    }

    public void onChangeSkinType(int i) {
        if (cyQ()) {
            ao.setViewTextColor(this.mTitle, R.color.CAM_X0105, i);
            if (this.mTitle != null) {
                pL(this.iIc);
            }
        }
        if (this.iIa != null && this.iIc) {
            this.iIa.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pL(boolean z) {
        int i = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
        com.baidu.tieba.enterForum.data.c cAx = this.iFK != null ? this.iFK.cAx() : null;
        if (cAx != null && cAx.iGq) {
            if (this.iFK != null && this.iFK.isShow()) {
                ao.setViewTextColor(this.mTitle, R.color.CAM_X0107);
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bwq().a(i, R.color.CAM_X0108, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                return;
            }
            ao.setViewTextColor(this.mTitle, R.color.CAM_X0107);
            this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bwq().a(i, R.color.CAM_X0108, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            return;
        }
        ao.setViewTextColor(this.mTitle, R.color.CAM_X0107);
        this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bwq().a(i, R.color.CAM_X0108, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }
}
