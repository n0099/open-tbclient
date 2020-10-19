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
/* loaded from: classes22.dex */
public class b {
    private f hPq;
    private com.baidu.tieba.enterForum.view.a hRG;
    private a hRH;
    private Context mContext;
    private int mSortType;
    private int mStatusBarHeight;
    private TextView mTitle;
    private boolean hRI = false;
    private a.InterfaceC0686a hRJ = new a.InterfaceC0686a() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.view.a.InterfaceC0686a
        public void onItemClick(int i) {
            b.this.mSortType = i;
            TiebaStatic.log(new aq("c13369").aj("obj_type", i == 1 ? 2 : 1));
            b.this.cmv();
            if (b.this.hRH != null) {
                b.this.hRH.wY(b.this.mSortType);
            }
        }
    };
    private View.OnClickListener eFW = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.hPq.cnX()) {
                if (view == b.this.mTitle) {
                    if (b.this.hRG == null) {
                        b.this.hRG = new com.baidu.tieba.enterForum.view.a(b.this.mContext);
                        b.this.hRG.setOnDismissListener(b.this.mOnDismissListener);
                        b.this.hRG.a(b.this.hRJ);
                        b.this.hRG.xr(b.this.mStatusBarHeight);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new h(b.this.mContext.getString(R.string.level_sort), 1));
                    arrayList.add(new h(b.this.mContext.getString(R.string.update_sort), 2));
                    b.this.hRG.setData(arrayList, b.this.mSortType);
                    b.this.hRG.O(b.this.mTitle);
                }
                b.this.hRI = true;
                b.this.oo(b.this.hRI);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.hRI = false;
            b.this.oo(b.this.hRI);
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void wY(int i);
    }

    public b(Context context, int i, int i2, f fVar) {
        this.mContext = context;
        this.mSortType = i;
        this.mStatusBarHeight = i2;
        this.hPq = fVar;
    }

    public void g(TextView textView) {
        this.mTitle = textView;
    }

    public void QJ() {
        if (this.hRG != null) {
            this.hRG.QJ();
        }
    }

    public void cmv() {
        if (cmw() && this.mTitle != null) {
            switch (this.mSortType) {
                case 1:
                    this.mTitle.setText(R.string.level_sort);
                    break;
                case 2:
                    this.mTitle.setText(R.string.update_sort);
                    break;
            }
            this.mTitle.setOnClickListener(this.eFW);
            oo(this.hRI);
        }
    }

    public boolean cmw() {
        return this.mSortType == 1 || this.mSortType == 2;
    }

    public void setSortType(int i) {
        if (cmw()) {
            this.mSortType = i;
            cmv();
        }
    }

    public void a(a aVar) {
        this.hRH = aVar;
    }

    public void onChangeSkinType(int i) {
        if (cmw()) {
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_b, i);
            if (this.mTitle != null) {
                oo(this.hRI);
            }
        }
        if (this.hRG != null && this.hRI) {
            this.hRG.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oo(boolean z) {
        int i = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
        com.baidu.tieba.enterForum.data.c cod = this.hPq != null ? this.hPq.cod() : null;
        if (cod != null && cod.hPW) {
            if (this.hPq != null && this.hPq.isShow()) {
                ap.setViewTextColor(this.mTitle, R.color.cp_cont_j);
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bmU().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                return;
            }
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_j);
            this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bmU().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            return;
        }
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_j);
        this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bmU().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }
}
