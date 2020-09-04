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
/* loaded from: classes16.dex */
public class b {
    private f htq;
    private com.baidu.tieba.enterForum.view.a hvG;
    private a hvH;
    private Context mContext;
    private int mSortType;
    private int mStatusBarHeight;
    private TextView mTitle;
    private boolean hvI = false;
    private a.InterfaceC0671a hvJ = new a.InterfaceC0671a() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.view.a.InterfaceC0671a
        public void onItemClick(int i) {
            b.this.mSortType = i;
            TiebaStatic.log(new aq("c13369").ai("obj_type", i == 1 ? 2 : 1));
            b.this.cfI();
            if (b.this.hvH != null) {
                b.this.hvH.vT(b.this.mSortType);
            }
        }
    };
    private View.OnClickListener erH = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.htq.chm()) {
                if (view == b.this.mTitle) {
                    if (b.this.hvG == null) {
                        b.this.hvG = new com.baidu.tieba.enterForum.view.a(b.this.mContext);
                        b.this.hvG.setOnDismissListener(b.this.mOnDismissListener);
                        b.this.hvG.a(b.this.hvJ);
                        b.this.hvG.wm(b.this.mStatusBarHeight);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new h(b.this.mContext.getString(R.string.level_sort), 1));
                    arrayList.add(new h(b.this.mContext.getString(R.string.update_sort), 2));
                    b.this.hvG.setData(arrayList, b.this.mSortType);
                    b.this.hvG.O(b.this.mTitle);
                }
                b.this.hvI = true;
                b.this.nD(b.this.hvI);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.hvI = false;
            b.this.nD(b.this.hvI);
        }
    };

    /* loaded from: classes16.dex */
    public interface a {
        void vT(int i);
    }

    public b(Context context, int i, int i2, f fVar) {
        this.mContext = context;
        this.mSortType = i;
        this.mStatusBarHeight = i2;
        this.htq = fVar;
    }

    public void g(TextView textView) {
        this.mTitle = textView;
    }

    public void Pb() {
        if (this.hvG != null) {
            this.hvG.Pb();
        }
    }

    public void cfI() {
        if (cfJ() && this.mTitle != null) {
            switch (this.mSortType) {
                case 1:
                    this.mTitle.setText(R.string.level_sort);
                    break;
                case 2:
                    this.mTitle.setText(R.string.update_sort);
                    break;
            }
            this.mTitle.setOnClickListener(this.erH);
            nD(this.hvI);
        }
    }

    public boolean cfJ() {
        return this.mSortType == 1 || this.mSortType == 2;
    }

    public void setSortType(int i) {
        if (cfJ()) {
            this.mSortType = i;
            cfI();
        }
    }

    public void a(a aVar) {
        this.hvH = aVar;
    }

    public void onChangeSkinType(int i) {
        if (cfJ()) {
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_b, i);
            if (this.mTitle != null) {
                nD(this.hvI);
            }
        }
        if (this.hvG != null && this.hvI) {
            this.hvG.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nD(boolean z) {
        int i = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
        com.baidu.tieba.enterForum.data.c chs = this.htq != null ? this.htq.chs() : null;
        if (chs != null && chs.htW) {
            if (this.htq != null && this.htq.isShow()) {
                ap.setViewTextColor(this.mTitle, R.color.cp_cont_j);
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bjq().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                return;
            }
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_j);
            this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bjq().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            return;
        }
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_j);
        this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bjq().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }
}
