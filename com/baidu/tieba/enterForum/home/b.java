package com.baidu.tieba.enterForum.home;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.k;
import com.baidu.tieba.enterForum.view.a;
import com.baidu.tieba.enterForum.view.f;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class b {
    private f fTj;
    private com.baidu.tieba.enterForum.view.a fVr;
    private a fVs;
    private Context mContext;
    private int mSortType;
    private int mStatusBarHeight;
    private TextView mTitle;
    private boolean fVt = false;
    private a.InterfaceC0496a fVu = new a.InterfaceC0496a() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.view.a.InterfaceC0496a
        public void onItemClick(int i) {
            b.this.mSortType = i;
            TiebaStatic.log(new an("c13369").X("obj_type", i == 1 ? 2 : 1));
            b.this.byt();
            if (b.this.fVs != null) {
                b.this.fVs.rL(b.this.mSortType);
            }
        }
    };
    private View.OnClickListener dfX = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.fTj.bzG()) {
                if (view == b.this.mTitle) {
                    if (b.this.fVr == null) {
                        b.this.fVr = new com.baidu.tieba.enterForum.view.a(b.this.mContext);
                        b.this.fVr.setOnDismissListener(b.this.mOnDismissListener);
                        b.this.fVr.a(b.this.fVu);
                        b.this.fVr.rY(b.this.mStatusBarHeight);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new k(b.this.mContext.getString(R.string.level_sort), 1));
                    arrayList.add(new k(b.this.mContext.getString(R.string.update_sort), 2));
                    b.this.fVr.setData(arrayList, b.this.mSortType);
                    b.this.fVr.R(b.this.mTitle);
                }
                b.this.fVt = true;
                b.this.kE(b.this.fVt);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.fVt = false;
            b.this.kE(b.this.fVt);
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void rL(int i);
    }

    public b(Context context, int i, int i2, f fVar) {
        this.mContext = context;
        this.mSortType = i;
        this.mStatusBarHeight = i2;
        this.fTj = fVar;
    }

    public void e(TextView textView) {
        this.mTitle = textView;
    }

    public void AR() {
        if (this.fVr != null) {
            this.fVr.AR();
        }
    }

    public void byt() {
        if (byu() && this.mTitle != null) {
            switch (this.mSortType) {
                case 1:
                    this.mTitle.setText(R.string.level_sort);
                    break;
                case 2:
                    this.mTitle.setText(R.string.update_sort);
                    break;
            }
            this.mTitle.setOnClickListener(this.dfX);
            kE(this.fVt);
        }
    }

    public boolean byu() {
        return this.mSortType == 1 || this.mSortType == 2;
    }

    public void setSortType(int i) {
        if (byu()) {
            this.mSortType = i;
            byt();
        }
    }

    public void a(a aVar) {
        this.fVs = aVar;
    }

    public void onChangeSkinType(int i) {
        if (byu()) {
            am.setViewTextColor(this.mTitle, R.color.cp_cont_b, i);
            if (this.mTitle != null) {
                kE(this.fVt);
            }
        }
        if (this.fVr != null && this.fVt) {
            this.fVr.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kE(boolean z) {
        int i = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
        com.baidu.tieba.enterForum.data.b bzM = this.fTj != null ? this.fTj.bzM() : null;
        if (bzM != null && bzM.fTR) {
            if (this.fTj != null && this.fTj.isShow()) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGA().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                return;
            }
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
            this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGA().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            return;
        }
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
        this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGA().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }
}
