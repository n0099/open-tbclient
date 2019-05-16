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
    private f eQo;
    private com.baidu.tieba.enterForum.view.a eSA;
    private a eSB;
    private Context mContext;
    private int mSortType;
    private int mStatusBarHeight;
    private TextView mTitle;
    private boolean eSC = false;
    private a.InterfaceC0301a eSD = new a.InterfaceC0301a() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.view.a.InterfaceC0301a
        public void mu(int i) {
            b.this.mSortType = i;
            TiebaStatic.log(new am("c13369").P("obj_type", i == 1 ? 2 : 1));
            b.this.bdO();
            if (b.this.eSB != null) {
                b.this.eSB.qc(b.this.mSortType);
            }
        }
    };
    private View.OnClickListener bYE = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.eQo.beT()) {
                if (view == b.this.mTitle) {
                    if (b.this.eSA == null) {
                        b.this.eSA = new com.baidu.tieba.enterForum.view.a(b.this.mContext);
                        b.this.eSA.setOnDismissListener(b.this.mOnDismissListener);
                        b.this.eSA.a(b.this.eSD);
                        b.this.eSA.qp(b.this.mStatusBarHeight);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new k(b.this.mContext.getString(R.string.level_sort), 1));
                    arrayList.add(new k(b.this.mContext.getString(R.string.update_sort), 2));
                    b.this.eSA.setData(arrayList, b.this.mSortType);
                    b.this.eSA.bm(b.this.mTitle);
                }
                b.this.eSC = true;
                b.this.jd(b.this.eSC);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.eSC = false;
            b.this.jd(b.this.eSC);
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
        this.eQo = fVar;
    }

    public void h(TextView textView) {
        this.mTitle = textView;
    }

    public void bdO() {
        if (bdP() && this.mTitle != null) {
            switch (this.mSortType) {
                case 1:
                    this.mTitle.setText(R.string.level_sort);
                    break;
                case 2:
                    this.mTitle.setText(R.string.update_sort);
                    break;
            }
            this.mTitle.setOnClickListener(this.bYE);
            jd(this.eSC);
        }
    }

    public boolean bdP() {
        return this.mSortType == 1 || this.mSortType == 2;
    }

    public void setSortType(int i) {
        if (bdP()) {
            this.mSortType = i;
            bdO();
        }
    }

    public void a(a aVar) {
        this.eSB = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jd(boolean z) {
        int i = z ? R.drawable.icon_common_arrow_up_white_n : R.drawable.icon_common_arrow_down_white_n;
        int i2 = z ? R.drawable.icon_common_arrow_up_n : R.drawable.icon_common_arrow_down_n;
        com.baidu.tieba.enterForum.data.b beZ = this.eQo != null ? this.eQo.beZ() : null;
        if (beZ != null && beZ.eQU) {
            if (this.eQo.isShow()) {
                if (this.eQo.beV()) {
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
