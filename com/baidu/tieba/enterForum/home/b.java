package com.baidu.tieba.enterForum.home;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
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
    private f eVw;
    private com.baidu.tieba.enterForum.view.a eXL;
    private a eXM;
    private Context mContext;
    private int mSortType;
    private int mStatusBarHeight;
    private TextView mTitle;
    private boolean eXN = false;
    private a.InterfaceC0304a eXO = new a.InterfaceC0304a() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.view.a.InterfaceC0304a
        public void mC(int i) {
            b.this.mSortType = i;
            TiebaStatic.log(new an("c13369").P("obj_type", i == 1 ? 2 : 1));
            b.this.bfV();
            if (b.this.eXM != null) {
                b.this.eXM.qv(b.this.mSortType);
            }
        }
    };
    private View.OnClickListener bZN = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.eVw.bhg()) {
                if (view == b.this.mTitle) {
                    if (b.this.eXL == null) {
                        b.this.eXL = new com.baidu.tieba.enterForum.view.a(b.this.mContext);
                        b.this.eXL.setOnDismissListener(b.this.mOnDismissListener);
                        b.this.eXL.a(b.this.eXO);
                        b.this.eXL.qJ(b.this.mStatusBarHeight);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new k(b.this.mContext.getString(R.string.level_sort), 1));
                    arrayList.add(new k(b.this.mContext.getString(R.string.update_sort), 2));
                    b.this.eXL.setData(arrayList, b.this.mSortType);
                    b.this.eXL.bo(b.this.mTitle);
                }
                b.this.eXN = true;
                b.this.jn(b.this.eXN);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.eXN = false;
            b.this.jn(b.this.eXN);
            if (b.this.mTitle != null) {
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void qv(int i);
    }

    public b(Context context, int i, int i2, f fVar) {
        this.mContext = context;
        this.mSortType = i;
        this.mStatusBarHeight = i2;
        this.eVw = fVar;
    }

    public void h(TextView textView) {
        this.mTitle = textView;
    }

    public void bfV() {
        if (bfW() && this.mTitle != null) {
            switch (this.mSortType) {
                case 1:
                    this.mTitle.setText(R.string.level_sort);
                    break;
                case 2:
                    this.mTitle.setText(R.string.update_sort);
                    break;
            }
            this.mTitle.setOnClickListener(this.bZN);
            jn(this.eXN);
        }
    }

    public boolean bfW() {
        return this.mSortType == 1 || this.mSortType == 2;
    }

    public void setSortType(int i) {
        if (bfW()) {
            this.mSortType = i;
            bfV();
        }
    }

    public void a(a aVar) {
        this.eXM = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jn(boolean z) {
        int i = z ? R.drawable.icon_common_arrow_up_white_n : R.drawable.icon_common_arrow_down_white_n;
        int i2 = z ? R.drawable.icon_common_arrow_up_n : R.drawable.icon_common_arrow_down_n;
        com.baidu.tieba.enterForum.data.b bhm = this.eVw != null ? this.eVw.bhm() : null;
        if (bhm != null && bhm.eWf) {
            if (this.eVw != null && this.eVw.isShow()) {
                am.j(this.mTitle, R.color.cp_cont_j);
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(i2), (Drawable) null);
                return;
            }
            am.j(this.mTitle, R.color.cp_btn_a);
            this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(i), (Drawable) null);
            return;
        }
        am.j(this.mTitle, R.color.cp_cont_j);
        this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(i2), (Drawable) null);
    }
}
