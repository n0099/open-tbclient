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
    private f iHb;
    private com.baidu.tieba.enterForum.view.a iJr;
    private a iJs;
    private Context mContext;
    private int mSortType;
    private int mStatusBarHeight;
    private TextView mTitle;
    private boolean iJt = false;
    private a.InterfaceC0708a iJu = new a.InterfaceC0708a() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.view.a.InterfaceC0708a
        public void dV(int i) {
            b.this.mSortType = i;
            TiebaStatic.log(new ar("c13369").ap("obj_type", i == 1 ? 2 : 1));
            b.this.cwr();
            if (b.this.iJs != null) {
                b.this.iJs.xy(b.this.mSortType);
            }
        }
    };
    private View.OnClickListener fhT = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.iHb.cxT()) {
                if (view == b.this.mTitle) {
                    if (b.this.iJr == null) {
                        b.this.iJr = new com.baidu.tieba.enterForum.view.a(b.this.mContext);
                        b.this.iJr.setOnDismissListener(b.this.mOnDismissListener);
                        b.this.iJr.a(b.this.iJu);
                        b.this.iJr.xR(b.this.mStatusBarHeight);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new h(b.this.mContext.getString(R.string.level_sort), 1));
                    arrayList.add(new h(b.this.mContext.getString(R.string.update_sort), 2));
                    b.this.iJr.setData(arrayList, b.this.mSortType);
                    b.this.iJr.O(b.this.mTitle);
                }
                b.this.iJt = true;
                b.this.pR(b.this.iJt);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.iJt = false;
            b.this.pR(b.this.iJt);
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
        this.iHb = fVar;
    }

    public void m(TextView textView) {
        this.mTitle = textView;
    }

    public void UU() {
        if (this.iJr != null) {
            this.iJr.UU();
        }
    }

    public void cwr() {
        if (cws() && this.mTitle != null) {
            switch (this.mSortType) {
                case 1:
                    this.mTitle.setText(R.string.level_sort);
                    break;
                case 2:
                    this.mTitle.setText(R.string.update_sort);
                    break;
            }
            this.mTitle.setOnClickListener(this.fhT);
            pR(this.iJt);
        }
    }

    public boolean cws() {
        return this.mSortType == 1 || this.mSortType == 2;
    }

    public void setSortType(int i) {
        if (cws()) {
            this.mSortType = i;
            cwr();
        }
    }

    public void a(a aVar) {
        this.iJs = aVar;
    }

    public void onChangeSkinType(int i) {
        if (cws()) {
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105, i);
            if (this.mTitle != null) {
                pR(this.iJt);
            }
        }
        if (this.iJr != null && this.iJt) {
            this.iJr.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pR(boolean z) {
        int i = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
        com.baidu.tieba.enterForum.data.c cxZ = this.iHb != null ? this.iHb.cxZ() : null;
        if (cxZ != null && cxZ.iHH) {
            if (this.iHb != null && this.iHb.isShow()) {
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
