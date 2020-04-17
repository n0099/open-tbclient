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
import com.baidu.tieba.enterForum.data.n;
import com.baidu.tieba.enterForum.view.a;
import com.baidu.tieba.enterForum.view.f;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class b {
    private com.baidu.tieba.enterForum.view.a gBi;
    private a gBj;
    private f gyP;
    private Context mContext;
    private int mSortType;
    private int mStatusBarHeight;
    private TextView mTitle;
    private boolean gBk = false;
    private a.InterfaceC0532a gBl = new a.InterfaceC0532a() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.view.a.InterfaceC0532a
        public void onItemClick(int i) {
            b.this.mSortType = i;
            TiebaStatic.log(new an("c13369").af("obj_type", i == 1 ? 2 : 1));
            b.this.bIB();
            if (b.this.gBj != null) {
                b.this.gBj.se(b.this.mSortType);
            }
        }
    };
    private View.OnClickListener dFV = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.gyP.bKf()) {
                if (view == b.this.mTitle) {
                    if (b.this.gBi == null) {
                        b.this.gBi = new com.baidu.tieba.enterForum.view.a(b.this.mContext);
                        b.this.gBi.setOnDismissListener(b.this.mOnDismissListener);
                        b.this.gBi.a(b.this.gBl);
                        b.this.gBi.sx(b.this.mStatusBarHeight);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new n(b.this.mContext.getString(R.string.level_sort), 1));
                    arrayList.add(new n(b.this.mContext.getString(R.string.update_sort), 2));
                    b.this.gBi.setData(arrayList, b.this.mSortType);
                    b.this.gBi.T(b.this.mTitle);
                }
                b.this.gBk = true;
                b.this.lM(b.this.gBk);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.gBk = false;
            b.this.lM(b.this.gBk);
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void se(int i);
    }

    public b(Context context, int i, int i2, f fVar) {
        this.mContext = context;
        this.mSortType = i;
        this.mStatusBarHeight = i2;
        this.gyP = fVar;
    }

    public void f(TextView textView) {
        this.mTitle = textView;
    }

    public void FY() {
        if (this.gBi != null) {
            this.gBi.FY();
        }
    }

    public void bIB() {
        if (bIC() && this.mTitle != null) {
            switch (this.mSortType) {
                case 1:
                    this.mTitle.setText(R.string.level_sort);
                    break;
                case 2:
                    this.mTitle.setText(R.string.update_sort);
                    break;
            }
            this.mTitle.setOnClickListener(this.dFV);
            lM(this.gBk);
        }
    }

    public boolean bIC() {
        return this.mSortType == 1 || this.mSortType == 2;
    }

    public void setSortType(int i) {
        if (bIC()) {
            this.mSortType = i;
            bIB();
        }
    }

    public void a(a aVar) {
        this.gBj = aVar;
    }

    public void onChangeSkinType(int i) {
        if (bIC()) {
            am.setViewTextColor(this.mTitle, R.color.cp_cont_b, i);
            if (this.mTitle != null) {
                lM(this.gBk);
            }
        }
        if (this.gBi != null && this.gBk) {
            this.gBi.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lM(boolean z) {
        int i = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
        com.baidu.tieba.enterForum.data.d bKl = this.gyP != null ? this.gyP.bKl() : null;
        if (bKl != null && bKl.gzE) {
            if (this.gyP != null && this.gyP.isShow()) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aOU().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                return;
            }
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
            this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aOU().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            return;
        }
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
        this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aOU().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }
}
