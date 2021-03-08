package com.baidu.tieba.enterForum.home;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.h;
import com.baidu.tieba.enterForum.view.a;
import com.baidu.tieba.enterForum.view.f;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b {
    private f iIK;
    private com.baidu.tieba.enterForum.view.a iLa;
    private a iLb;
    private Context mContext;
    private int mSortType;
    private int mStatusBarHeight;
    private TextView mTitle;
    private boolean iLc = false;
    private a.InterfaceC0714a iLd = new a.InterfaceC0714a() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.view.a.InterfaceC0714a
        public void dW(int i) {
            b.this.mSortType = i;
            TiebaStatic.log(new ar("c13369").aq("obj_type", i == 1 ? 2 : 1));
            b.this.cwx();
            if (b.this.iLb != null) {
                b.this.iLb.xz(b.this.mSortType);
            }
        }
    };
    private View.OnClickListener fjv = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.iIK.cxZ()) {
                if (view == b.this.mTitle) {
                    if (b.this.iLa == null) {
                        b.this.iLa = new com.baidu.tieba.enterForum.view.a(b.this.mContext);
                        b.this.iLa.setOnDismissListener(b.this.mOnDismissListener);
                        b.this.iLa.a(b.this.iLd);
                        b.this.iLa.xS(b.this.mStatusBarHeight);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new h(b.this.mContext.getString(R.string.level_sort), 1));
                    arrayList.add(new h(b.this.mContext.getString(R.string.update_sort), 2));
                    b.this.iLa.setData(arrayList, b.this.mSortType);
                    b.this.iLa.O(b.this.mTitle);
                }
                b.this.iLc = true;
                b.this.pR(b.this.iLc);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.iLc = false;
            b.this.pR(b.this.iLc);
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void xz(int i);
    }

    public b(Context context, int i, int i2, f fVar) {
        this.mContext = context;
        this.mSortType = i;
        this.mStatusBarHeight = i2;
        this.iIK = fVar;
    }

    public void m(TextView textView) {
        this.mTitle = textView;
    }

    public void UX() {
        if (this.iLa != null) {
            this.iLa.UX();
        }
    }

    public void cwx() {
        if (cwy() && this.mTitle != null) {
            switch (this.mSortType) {
                case 1:
                    this.mTitle.setText(R.string.level_sort);
                    break;
                case 2:
                    this.mTitle.setText(R.string.update_sort);
                    break;
            }
            this.mTitle.setOnClickListener(this.fjv);
            pR(this.iLc);
        }
    }

    public boolean cwy() {
        return this.mSortType == 1 || this.mSortType == 2;
    }

    public void setSortType(int i) {
        if (cwy()) {
            this.mSortType = i;
            cwx();
        }
    }

    public void a(a aVar) {
        this.iLb = aVar;
    }

    public void onChangeSkinType(int i) {
        if (cwy()) {
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105, i);
            if (this.mTitle != null) {
                pR(this.iLc);
            }
        }
        if (this.iLa != null && this.iLc) {
            this.iLa.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pR(boolean z) {
        int i = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
        com.baidu.tieba.enterForum.data.c cyf = this.iIK != null ? this.iIK.cyf() : null;
        if (cyf != null && cyf.iJq) {
            if (this.iIK != null && this.iIK.isShow()) {
                ap.setViewTextColor(this.mTitle, R.color.CAM_X0107);
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bsU().a(i, R.color.CAM_X0108, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                return;
            }
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0107);
            this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bsU().a(i, R.color.CAM_X0108, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            return;
        }
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0107);
        this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bsU().a(i, R.color.CAM_X0108, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }
}
