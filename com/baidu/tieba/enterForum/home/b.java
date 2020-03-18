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
    private f fUh;
    private com.baidu.tieba.enterForum.view.a fWo;
    private a fWp;
    private Context mContext;
    private int mSortType;
    private int mStatusBarHeight;
    private TextView mTitle;
    private boolean fWq = false;
    private a.InterfaceC0496a fWr = new a.InterfaceC0496a() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.view.a.InterfaceC0496a
        public void onItemClick(int i) {
            b.this.mSortType = i;
            TiebaStatic.log(new an("c13369").X("obj_type", i == 1 ? 2 : 1));
            b.this.byC();
            if (b.this.fWp != null) {
                b.this.fWp.rN(b.this.mSortType);
            }
        }
    };
    private View.OnClickListener dgy = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.fUh.bzP()) {
                if (view == b.this.mTitle) {
                    if (b.this.fWo == null) {
                        b.this.fWo = new com.baidu.tieba.enterForum.view.a(b.this.mContext);
                        b.this.fWo.setOnDismissListener(b.this.mOnDismissListener);
                        b.this.fWo.a(b.this.fWr);
                        b.this.fWo.sa(b.this.mStatusBarHeight);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new k(b.this.mContext.getString(R.string.level_sort), 1));
                    arrayList.add(new k(b.this.mContext.getString(R.string.update_sort), 2));
                    b.this.fWo.setData(arrayList, b.this.mSortType);
                    b.this.fWo.R(b.this.mTitle);
                }
                b.this.fWq = true;
                b.this.kJ(b.this.fWq);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.fWq = false;
            b.this.kJ(b.this.fWq);
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void rN(int i);
    }

    public b(Context context, int i, int i2, f fVar) {
        this.mContext = context;
        this.mSortType = i;
        this.mStatusBarHeight = i2;
        this.fUh = fVar;
    }

    public void e(TextView textView) {
        this.mTitle = textView;
    }

    public void Ba() {
        if (this.fWo != null) {
            this.fWo.Ba();
        }
    }

    public void byC() {
        if (byD() && this.mTitle != null) {
            switch (this.mSortType) {
                case 1:
                    this.mTitle.setText(R.string.level_sort);
                    break;
                case 2:
                    this.mTitle.setText(R.string.update_sort);
                    break;
            }
            this.mTitle.setOnClickListener(this.dgy);
            kJ(this.fWq);
        }
    }

    public boolean byD() {
        return this.mSortType == 1 || this.mSortType == 2;
    }

    public void setSortType(int i) {
        if (byD()) {
            this.mSortType = i;
            byC();
        }
    }

    public void a(a aVar) {
        this.fWp = aVar;
    }

    public void onChangeSkinType(int i) {
        if (byD()) {
            am.setViewTextColor(this.mTitle, R.color.cp_cont_b, i);
            if (this.mTitle != null) {
                kJ(this.fWq);
            }
        }
        if (this.fWo != null && this.fWq) {
            this.fWo.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kJ(boolean z) {
        int i = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
        com.baidu.tieba.enterForum.data.b bzV = this.fUh != null ? this.fUh.bzV() : null;
        if (bzV != null && bzV.fUP) {
            if (this.fUh != null && this.fUh.isShow()) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGG().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                return;
            }
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
            this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGG().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            return;
        }
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
        this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGG().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }
}
