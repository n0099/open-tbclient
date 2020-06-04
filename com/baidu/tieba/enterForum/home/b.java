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
    private f gNQ;
    private com.baidu.tieba.enterForum.view.a gQi;
    private a gQj;
    private Context mContext;
    private int mSortType;
    private int mStatusBarHeight;
    private TextView mTitle;
    private boolean gQk = false;
    private a.InterfaceC0603a gQl = new a.InterfaceC0603a() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.view.a.InterfaceC0603a
        public void onItemClick(int i) {
            b.this.mSortType = i;
            TiebaStatic.log(new an("c13369").ag("obj_type", i == 1 ? 2 : 1));
            b.this.bOV();
            if (b.this.gQj != null) {
                b.this.gQj.sL(b.this.mSortType);
            }
        }
    };
    private View.OnClickListener dUl = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.gNQ.bQB()) {
                if (view == b.this.mTitle) {
                    if (b.this.gQi == null) {
                        b.this.gQi = new com.baidu.tieba.enterForum.view.a(b.this.mContext);
                        b.this.gQi.setOnDismissListener(b.this.mOnDismissListener);
                        b.this.gQi.a(b.this.gQl);
                        b.this.gQi.te(b.this.mStatusBarHeight);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new n(b.this.mContext.getString(R.string.level_sort), 1));
                    arrayList.add(new n(b.this.mContext.getString(R.string.update_sort), 2));
                    b.this.gQi.setData(arrayList, b.this.mSortType);
                    b.this.gQi.S(b.this.mTitle);
                }
                b.this.gQk = true;
                b.this.mh(b.this.gQk);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.gQk = false;
            b.this.mh(b.this.gQk);
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void sL(int i);
    }

    public b(Context context, int i, int i2, f fVar) {
        this.mContext = context;
        this.mSortType = i;
        this.mStatusBarHeight = i2;
        this.gNQ = fVar;
    }

    public void f(TextView textView) {
        this.mTitle = textView;
    }

    public void HQ() {
        if (this.gQi != null) {
            this.gQi.HQ();
        }
    }

    public void bOV() {
        if (bOW() && this.mTitle != null) {
            switch (this.mSortType) {
                case 1:
                    this.mTitle.setText(R.string.level_sort);
                    break;
                case 2:
                    this.mTitle.setText(R.string.update_sort);
                    break;
            }
            this.mTitle.setOnClickListener(this.dUl);
            mh(this.gQk);
        }
    }

    public boolean bOW() {
        return this.mSortType == 1 || this.mSortType == 2;
    }

    public void setSortType(int i) {
        if (bOW()) {
            this.mSortType = i;
            bOV();
        }
    }

    public void a(a aVar) {
        this.gQj = aVar;
    }

    public void onChangeSkinType(int i) {
        if (bOW()) {
            am.setViewTextColor(this.mTitle, R.color.cp_cont_b, i);
            if (this.mTitle != null) {
                mh(this.gQk);
            }
        }
        if (this.gQi != null && this.gQk) {
            this.gQi.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mh(boolean z) {
        int i = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
        com.baidu.tieba.enterForum.data.d bQH = this.gNQ != null ? this.gNQ.bQH() : null;
        if (bQH != null && bQH.gOF) {
            if (this.gNQ != null && this.gNQ.isShow()) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aUW().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                return;
            }
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
            this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aUW().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            return;
        }
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
        this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aUW().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }
}
