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
    private f eZO;
    private com.baidu.tieba.enterForum.view.a fcc;
    private a fcd;
    private Context mContext;
    private int mSortType;
    private int mStatusBarHeight;
    private TextView mTitle;
    private boolean fce = false;
    private a.InterfaceC0402a fcf = new a.InterfaceC0402a() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.view.a.InterfaceC0402a
        public void lL(int i) {
            b.this.mSortType = i;
            TiebaStatic.log(new an("c13369").O("obj_type", i == 1 ? 2 : 1));
            b.this.bet();
            if (b.this.fcd != null) {
                b.this.fcd.pu(b.this.mSortType);
            }
        }
    };
    private View.OnClickListener cpk = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.eZO.bfJ()) {
                if (view == b.this.mTitle) {
                    if (b.this.fcc == null) {
                        b.this.fcc = new com.baidu.tieba.enterForum.view.a(b.this.mContext);
                        b.this.fcc.setOnDismissListener(b.this.mOnDismissListener);
                        b.this.fcc.a(b.this.fcf);
                        b.this.fcc.pI(b.this.mStatusBarHeight);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new k(b.this.mContext.getString(R.string.level_sort), 1));
                    arrayList.add(new k(b.this.mContext.getString(R.string.update_sort), 2));
                    b.this.fcc.setData(arrayList, b.this.mSortType);
                    b.this.fcc.O(b.this.mTitle);
                }
                b.this.fce = true;
                b.this.jf(b.this.fce);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.fce = false;
            b.this.jf(b.this.fce);
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void pu(int i);
    }

    public b(Context context, int i, int i2, f fVar) {
        this.mContext = context;
        this.mSortType = i;
        this.mStatusBarHeight = i2;
        this.eZO = fVar;
    }

    public void f(TextView textView) {
        this.mTitle = textView;
    }

    public void bet() {
        if (beu() && this.mTitle != null) {
            switch (this.mSortType) {
                case 1:
                    this.mTitle.setText(R.string.level_sort);
                    break;
                case 2:
                    this.mTitle.setText(R.string.update_sort);
                    break;
            }
            this.mTitle.setOnClickListener(this.cpk);
            jf(this.fce);
        }
    }

    public boolean beu() {
        return this.mSortType == 1 || this.mSortType == 2;
    }

    public void setSortType(int i) {
        if (beu()) {
            this.mSortType = i;
            bet();
        }
    }

    public void a(a aVar) {
        this.fcd = aVar;
    }

    public void onChangeSkinType(int i) {
        if (beu()) {
            am.setViewTextColor(this.mTitle, R.color.cp_cont_b, i);
            if (this.mTitle != null) {
                jf(this.fce);
            }
        }
        if (this.fcc != null && this.fce) {
            this.fcc.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jf(boolean z) {
        int i = z ? R.drawable.icon_pure_list_arrow12_up_n_svg : R.drawable.icon_pure_list_arrow12_down_n_svg;
        com.baidu.tieba.enterForum.data.b bfP = this.eZO != null ? this.eZO.bfP() : null;
        if (bfP != null && bfP.fax) {
            if (this.eZO != null && this.eZO.isShow()) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.amN().a(i, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                return;
            }
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
            this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.amN().a(i, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            return;
        }
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
        this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.amN().a(i, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }
}
