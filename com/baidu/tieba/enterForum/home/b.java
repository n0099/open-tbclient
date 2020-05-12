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
    private com.baidu.tieba.enterForum.view.a gBo;
    private a gBp;
    private f gyV;
    private Context mContext;
    private int mSortType;
    private int mStatusBarHeight;
    private TextView mTitle;
    private boolean gBq = false;
    private a.InterfaceC0553a gBr = new a.InterfaceC0553a() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.view.a.InterfaceC0553a
        public void onItemClick(int i) {
            b.this.mSortType = i;
            TiebaStatic.log(new an("c13369").af("obj_type", i == 1 ? 2 : 1));
            b.this.bIA();
            if (b.this.gBp != null) {
                b.this.gBp.se(b.this.mSortType);
            }
        }
    };
    private View.OnClickListener dFZ = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.gyV.bKe()) {
                if (view == b.this.mTitle) {
                    if (b.this.gBo == null) {
                        b.this.gBo = new com.baidu.tieba.enterForum.view.a(b.this.mContext);
                        b.this.gBo.setOnDismissListener(b.this.mOnDismissListener);
                        b.this.gBo.a(b.this.gBr);
                        b.this.gBo.sx(b.this.mStatusBarHeight);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new n(b.this.mContext.getString(R.string.level_sort), 1));
                    arrayList.add(new n(b.this.mContext.getString(R.string.update_sort), 2));
                    b.this.gBo.setData(arrayList, b.this.mSortType);
                    b.this.gBo.T(b.this.mTitle);
                }
                b.this.gBq = true;
                b.this.lM(b.this.gBq);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.gBq = false;
            b.this.lM(b.this.gBq);
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
        this.gyV = fVar;
    }

    public void f(TextView textView) {
        this.mTitle = textView;
    }

    public void FX() {
        if (this.gBo != null) {
            this.gBo.FX();
        }
    }

    public void bIA() {
        if (bIB() && this.mTitle != null) {
            switch (this.mSortType) {
                case 1:
                    this.mTitle.setText(R.string.level_sort);
                    break;
                case 2:
                    this.mTitle.setText(R.string.update_sort);
                    break;
            }
            this.mTitle.setOnClickListener(this.dFZ);
            lM(this.gBq);
        }
    }

    public boolean bIB() {
        return this.mSortType == 1 || this.mSortType == 2;
    }

    public void setSortType(int i) {
        if (bIB()) {
            this.mSortType = i;
            bIA();
        }
    }

    public void a(a aVar) {
        this.gBp = aVar;
    }

    public void onChangeSkinType(int i) {
        if (bIB()) {
            am.setViewTextColor(this.mTitle, R.color.cp_cont_b, i);
            if (this.mTitle != null) {
                lM(this.gBq);
            }
        }
        if (this.gBo != null && this.gBq) {
            this.gBo.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lM(boolean z) {
        int i = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
        com.baidu.tieba.enterForum.data.d bKk = this.gyV != null ? this.gyV.bKk() : null;
        if (bKk != null && bKk.gzK) {
            if (this.gyV != null && this.gyV.isShow()) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aOR().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                return;
            }
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
            this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aOR().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            return;
        }
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
        this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aOR().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }
}
