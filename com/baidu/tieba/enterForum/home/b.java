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
    private f iGN;
    private com.baidu.tieba.enterForum.view.a iJd;
    private a iJe;
    private Context mContext;
    private int mSortType;
    private int mStatusBarHeight;
    private TextView mTitle;
    private boolean iJf = false;
    private a.InterfaceC0707a iJg = new a.InterfaceC0707a() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.view.a.InterfaceC0707a
        public void dV(int i) {
            b.this.mSortType = i;
            TiebaStatic.log(new ar("c13369").ap("obj_type", i == 1 ? 2 : 1));
            b.this.cwk();
            if (b.this.iJe != null) {
                b.this.iJe.xy(b.this.mSortType);
            }
        }
    };
    private View.OnClickListener fhT = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.iGN.cxM()) {
                if (view == b.this.mTitle) {
                    if (b.this.iJd == null) {
                        b.this.iJd = new com.baidu.tieba.enterForum.view.a(b.this.mContext);
                        b.this.iJd.setOnDismissListener(b.this.mOnDismissListener);
                        b.this.iJd.a(b.this.iJg);
                        b.this.iJd.xR(b.this.mStatusBarHeight);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new h(b.this.mContext.getString(R.string.level_sort), 1));
                    arrayList.add(new h(b.this.mContext.getString(R.string.update_sort), 2));
                    b.this.iJd.setData(arrayList, b.this.mSortType);
                    b.this.iJd.O(b.this.mTitle);
                }
                b.this.iJf = true;
                b.this.pR(b.this.iJf);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.iJf = false;
            b.this.pR(b.this.iJf);
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void xy(int i);
    }

    public b(Context context, int i, int i2, f fVar) {
        this.mContext = context;
        this.mSortType = i;
        this.mStatusBarHeight = i2;
        this.iGN = fVar;
    }

    public void m(TextView textView) {
        this.mTitle = textView;
    }

    public void UU() {
        if (this.iJd != null) {
            this.iJd.UU();
        }
    }

    public void cwk() {
        if (cwl() && this.mTitle != null) {
            switch (this.mSortType) {
                case 1:
                    this.mTitle.setText(R.string.level_sort);
                    break;
                case 2:
                    this.mTitle.setText(R.string.update_sort);
                    break;
            }
            this.mTitle.setOnClickListener(this.fhT);
            pR(this.iJf);
        }
    }

    public boolean cwl() {
        return this.mSortType == 1 || this.mSortType == 2;
    }

    public void setSortType(int i) {
        if (cwl()) {
            this.mSortType = i;
            cwk();
        }
    }

    public void a(a aVar) {
        this.iJe = aVar;
    }

    public void onChangeSkinType(int i) {
        if (cwl()) {
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105, i);
            if (this.mTitle != null) {
                pR(this.iJf);
            }
        }
        if (this.iJd != null && this.iJf) {
            this.iJd.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pR(boolean z) {
        int i = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
        com.baidu.tieba.enterForum.data.c cxS = this.iGN != null ? this.iGN.cxS() : null;
        if (cxS != null && cxS.iHt) {
            if (this.iGN != null && this.iGN.isShow()) {
                ap.setViewTextColor(this.mTitle, R.color.CAM_X0107);
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bsR().a(i, R.color.CAM_X0108, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                return;
            }
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0107);
            this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bsR().a(i, R.color.CAM_X0108, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            return;
        }
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0107);
        this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bsR().a(i, R.color.CAM_X0108, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }
}
