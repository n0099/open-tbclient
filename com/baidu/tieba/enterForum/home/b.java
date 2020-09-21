package com.baidu.tieba.enterForum.home;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.h;
import com.baidu.tieba.enterForum.view.a;
import com.baidu.tieba.enterForum.view.f;
import java.util.ArrayList;
/* loaded from: classes21.dex */
public class b {
    private f hAv;
    private com.baidu.tieba.enterForum.view.a hCL;
    private a hCM;
    private Context mContext;
    private int mSortType;
    private int mStatusBarHeight;
    private TextView mTitle;
    private boolean hCN = false;
    private a.InterfaceC0668a hCO = new a.InterfaceC0668a() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.view.a.InterfaceC0668a
        public void onItemClick(int i) {
            b.this.mSortType = i;
            TiebaStatic.log(new aq("c13369").ai("obj_type", i == 1 ? 2 : 1));
            b.this.ciZ();
            if (b.this.hCM != null) {
                b.this.hCM.ws(b.this.mSortType);
            }
        }
    };
    private View.OnClickListener etM = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.hAv.ckB()) {
                if (view == b.this.mTitle) {
                    if (b.this.hCL == null) {
                        b.this.hCL = new com.baidu.tieba.enterForum.view.a(b.this.mContext);
                        b.this.hCL.setOnDismissListener(b.this.mOnDismissListener);
                        b.this.hCL.a(b.this.hCO);
                        b.this.hCL.wL(b.this.mStatusBarHeight);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new h(b.this.mContext.getString(R.string.level_sort), 1));
                    arrayList.add(new h(b.this.mContext.getString(R.string.update_sort), 2));
                    b.this.hCL.setData(arrayList, b.this.mSortType);
                    b.this.hCL.O(b.this.mTitle);
                }
                b.this.hCN = true;
                b.this.nJ(b.this.hCN);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.hCN = false;
            b.this.nJ(b.this.hCN);
        }
    };

    /* loaded from: classes21.dex */
    public interface a {
        void ws(int i);
    }

    public b(Context context, int i, int i2, f fVar) {
        this.mContext = context;
        this.mSortType = i;
        this.mStatusBarHeight = i2;
        this.hAv = fVar;
    }

    public void g(TextView textView) {
        this.mTitle = textView;
    }

    public void PE() {
        if (this.hCL != null) {
            this.hCL.PE();
        }
    }

    public void ciZ() {
        if (cja() && this.mTitle != null) {
            switch (this.mSortType) {
                case 1:
                    this.mTitle.setText(R.string.level_sort);
                    break;
                case 2:
                    this.mTitle.setText(R.string.update_sort);
                    break;
            }
            this.mTitle.setOnClickListener(this.etM);
            nJ(this.hCN);
        }
    }

    public boolean cja() {
        return this.mSortType == 1 || this.mSortType == 2;
    }

    public void setSortType(int i) {
        if (cja()) {
            this.mSortType = i;
            ciZ();
        }
    }

    public void a(a aVar) {
        this.hCM = aVar;
    }

    public void onChangeSkinType(int i) {
        if (cja()) {
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_b, i);
            if (this.mTitle != null) {
                nJ(this.hCN);
            }
        }
        if (this.hCL != null && this.hCN) {
            this.hCL.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nJ(boolean z) {
        int i = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
        com.baidu.tieba.enterForum.data.c ckH = this.hAv != null ? this.hAv.ckH() : null;
        if (ckH != null && ckH.hBb) {
            if (this.hAv != null && this.hAv.isShow()) {
                ap.setViewTextColor(this.mTitle, R.color.cp_cont_j);
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bkl().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                return;
            }
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_j);
            this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bkl().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            return;
        }
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_j);
        this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bkl().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }
}
