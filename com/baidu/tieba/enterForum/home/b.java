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
/* loaded from: classes6.dex */
public class b {
    private f fNF;
    private com.baidu.tieba.enterForum.view.a fPP;
    private a fPQ;
    private Context mContext;
    private int mSortType;
    private int mStatusBarHeight;
    private TextView mTitle;
    private boolean fPR = false;
    private a.InterfaceC0485a fPS = new a.InterfaceC0485a() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.view.a.InterfaceC0485a
        public void onItemClick(int i) {
            b.this.mSortType = i;
            TiebaStatic.log(new an("c13369").Z("obj_type", i == 1 ? 2 : 1));
            b.this.bvM();
            if (b.this.fPQ != null) {
                b.this.fPQ.rz(b.this.mSortType);
            }
        }
    };
    private View.OnClickListener dbH = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.fNF.bxc()) {
                if (view == b.this.mTitle) {
                    if (b.this.fPP == null) {
                        b.this.fPP = new com.baidu.tieba.enterForum.view.a(b.this.mContext);
                        b.this.fPP.setOnDismissListener(b.this.mOnDismissListener);
                        b.this.fPP.a(b.this.fPS);
                        b.this.fPP.rN(b.this.mStatusBarHeight);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new k(b.this.mContext.getString(R.string.level_sort), 1));
                    arrayList.add(new k(b.this.mContext.getString(R.string.update_sort), 2));
                    b.this.fPP.setData(arrayList, b.this.mSortType);
                    b.this.fPP.P(b.this.mTitle);
                }
                b.this.fPR = true;
                b.this.kr(b.this.fPR);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.fPR = false;
            b.this.kr(b.this.fPR);
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void rz(int i);
    }

    public b(Context context, int i, int i2, f fVar) {
        this.mContext = context;
        this.mSortType = i;
        this.mStatusBarHeight = i2;
        this.fNF = fVar;
    }

    public void e(TextView textView) {
        this.mTitle = textView;
    }

    public void yk() {
        if (this.fPP != null) {
            this.fPP.yk();
        }
    }

    public void bvM() {
        if (bvN() && this.mTitle != null) {
            switch (this.mSortType) {
                case 1:
                    this.mTitle.setText(R.string.level_sort);
                    break;
                case 2:
                    this.mTitle.setText(R.string.update_sort);
                    break;
            }
            this.mTitle.setOnClickListener(this.dbH);
            kr(this.fPR);
        }
    }

    public boolean bvN() {
        return this.mSortType == 1 || this.mSortType == 2;
    }

    public void setSortType(int i) {
        if (bvN()) {
            this.mSortType = i;
            bvM();
        }
    }

    public void a(a aVar) {
        this.fPQ = aVar;
    }

    public void onChangeSkinType(int i) {
        if (bvN()) {
            am.setViewTextColor(this.mTitle, R.color.cp_cont_b, i);
            if (this.mTitle != null) {
                kr(this.fPR);
            }
        }
        if (this.fPP != null && this.fPR) {
            this.fPP.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kr(boolean z) {
        int i = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
        com.baidu.tieba.enterForum.data.b bxi = this.fNF != null ? this.fNF.bxi() : null;
        if (bxi != null && bxi.fOn) {
            if (this.fNF != null && this.fNF.isShow()) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aDW().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                return;
            }
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
            this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aDW().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            return;
        }
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
        this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aDW().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }
}
