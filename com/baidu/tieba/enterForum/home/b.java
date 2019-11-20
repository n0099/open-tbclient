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
/* loaded from: classes4.dex */
public class b {
    private f eYX;
    private com.baidu.tieba.enterForum.view.a fbl;
    private a fbm;
    private Context mContext;
    private int mSortType;
    private int mStatusBarHeight;
    private TextView mTitle;
    private boolean fbn = false;
    private a.InterfaceC0402a fbo = new a.InterfaceC0402a() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.view.a.InterfaceC0402a
        public void lK(int i) {
            b.this.mSortType = i;
            TiebaStatic.log(new an("c13369").O("obj_type", i == 1 ? 2 : 1));
            b.this.ber();
            if (b.this.fbm != null) {
                b.this.fbm.pt(b.this.mSortType);
            }
        }
    };
    private View.OnClickListener cot = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.eYX.bfH()) {
                if (view == b.this.mTitle) {
                    if (b.this.fbl == null) {
                        b.this.fbl = new com.baidu.tieba.enterForum.view.a(b.this.mContext);
                        b.this.fbl.setOnDismissListener(b.this.mOnDismissListener);
                        b.this.fbl.a(b.this.fbo);
                        b.this.fbl.pH(b.this.mStatusBarHeight);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new k(b.this.mContext.getString(R.string.level_sort), 1));
                    arrayList.add(new k(b.this.mContext.getString(R.string.update_sort), 2));
                    b.this.fbl.setData(arrayList, b.this.mSortType);
                    b.this.fbl.O(b.this.mTitle);
                }
                b.this.fbn = true;
                b.this.jf(b.this.fbn);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.fbn = false;
            b.this.jf(b.this.fbn);
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void pt(int i);
    }

    public b(Context context, int i, int i2, f fVar) {
        this.mContext = context;
        this.mSortType = i;
        this.mStatusBarHeight = i2;
        this.eYX = fVar;
    }

    public void f(TextView textView) {
        this.mTitle = textView;
    }

    public void ber() {
        if (bes() && this.mTitle != null) {
            switch (this.mSortType) {
                case 1:
                    this.mTitle.setText(R.string.level_sort);
                    break;
                case 2:
                    this.mTitle.setText(R.string.update_sort);
                    break;
            }
            this.mTitle.setOnClickListener(this.cot);
            jf(this.fbn);
        }
    }

    public boolean bes() {
        return this.mSortType == 1 || this.mSortType == 2;
    }

    public void setSortType(int i) {
        if (bes()) {
            this.mSortType = i;
            ber();
        }
    }

    public void a(a aVar) {
        this.fbm = aVar;
    }

    public void onChangeSkinType(int i) {
        if (bes()) {
            am.setViewTextColor(this.mTitle, R.color.cp_cont_b, i);
            if (this.mTitle != null) {
                jf(this.fbn);
            }
        }
        if (this.fbl != null && this.fbn) {
            this.fbl.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jf(boolean z) {
        int i = z ? R.drawable.icon_pure_list_arrow12_up_n_svg : R.drawable.icon_pure_list_arrow12_down_n_svg;
        com.baidu.tieba.enterForum.data.b bfN = this.eYX != null ? this.eYX.bfN() : null;
        if (bfN != null && bfN.eZG) {
            if (this.eYX != null && this.eYX.isShow()) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.amL().a(i, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                return;
            }
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
            this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.amL().a(i, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            return;
        }
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
        this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.amL().a(i, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }
}
