package com.baidu.tieba.enterForum.home;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.k;
import com.baidu.tieba.enterForum.view.a;
import com.baidu.tieba.enterForum.view.f;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b {
    private f eQp;
    private com.baidu.tieba.enterForum.view.a eSB;
    private a eSC;
    private Context mContext;
    private int mSortType;
    private int mStatusBarHeight;
    private TextView mTitle;
    private boolean eSD = false;
    private a.InterfaceC0301a eSE = new a.InterfaceC0301a() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.view.a.InterfaceC0301a
        public void mu(int i) {
            b.this.mSortType = i;
            TiebaStatic.log(new am("c13369").P("obj_type", i == 1 ? 2 : 1));
            b.this.bdR();
            if (b.this.eSC != null) {
                b.this.eSC.qc(b.this.mSortType);
            }
        }
    };
    private View.OnClickListener bYF = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.eQp.beW()) {
                if (view == b.this.mTitle) {
                    if (b.this.eSB == null) {
                        b.this.eSB = new com.baidu.tieba.enterForum.view.a(b.this.mContext);
                        b.this.eSB.setOnDismissListener(b.this.mOnDismissListener);
                        b.this.eSB.a(b.this.eSE);
                        b.this.eSB.qp(b.this.mStatusBarHeight);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new k(b.this.mContext.getString(R.string.level_sort), 1));
                    arrayList.add(new k(b.this.mContext.getString(R.string.update_sort), 2));
                    b.this.eSB.setData(arrayList, b.this.mSortType);
                    b.this.eSB.bm(b.this.mTitle);
                }
                b.this.eSD = true;
                b.this.jd(b.this.eSD);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.eSD = false;
            b.this.jd(b.this.eSD);
            if (b.this.mTitle != null) {
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void qc(int i);
    }

    public b(Context context, int i, int i2, f fVar) {
        this.mContext = context;
        this.mSortType = i;
        this.mStatusBarHeight = i2;
        this.eQp = fVar;
    }

    public void h(TextView textView) {
        this.mTitle = textView;
    }

    public void bdR() {
        if (bdS() && this.mTitle != null) {
            switch (this.mSortType) {
                case 1:
                    this.mTitle.setText(R.string.level_sort);
                    break;
                case 2:
                    this.mTitle.setText(R.string.update_sort);
                    break;
            }
            this.mTitle.setOnClickListener(this.bYF);
            jd(this.eSD);
        }
    }

    public boolean bdS() {
        return this.mSortType == 1 || this.mSortType == 2;
    }

    public void setSortType(int i) {
        if (bdS()) {
            this.mSortType = i;
            bdR();
        }
    }

    public void a(a aVar) {
        this.eSC = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jd(boolean z) {
        int i = z ? R.drawable.icon_common_arrow_up_white_n : R.drawable.icon_common_arrow_down_white_n;
        int i2 = z ? R.drawable.icon_common_arrow_up_n : R.drawable.icon_common_arrow_down_n;
        com.baidu.tieba.enterForum.data.b bfc = this.eQp != null ? this.eQp.bfc() : null;
        if (bfc != null && bfc.eQV) {
            if (this.eQp.isShow()) {
                if (this.eQp.beY()) {
                    al.j(this.mTitle, R.color.cp_cont_j);
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(i2), (Drawable) null);
                    return;
                }
                al.j(this.mTitle, R.color.cp_btn_a);
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(i), (Drawable) null);
                return;
            }
            al.j(this.mTitle, R.color.cp_btn_a);
            this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(i), (Drawable) null);
            return;
        }
        al.j(this.mTitle, R.color.cp_cont_j);
        this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(i2), (Drawable) null);
    }
}
