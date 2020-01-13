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
/* loaded from: classes7.dex */
public class b {
    private f fQO;
    private com.baidu.tieba.enterForum.view.a fSY;
    private a fSZ;
    private Context mContext;
    private int mSortType;
    private int mStatusBarHeight;
    private TextView mTitle;
    private boolean fTa = false;
    private a.InterfaceC0489a fTb = new a.InterfaceC0489a() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.view.a.InterfaceC0489a
        public void onItemClick(int i) {
            b.this.mSortType = i;
            TiebaStatic.log(new an("c13369").Z("obj_type", i == 1 ? 2 : 1));
            b.this.bwO();
            if (b.this.fSZ != null) {
                b.this.fSZ.rE(b.this.mSortType);
            }
        }
    };
    private View.OnClickListener dbS = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.fQO.bye()) {
                if (view == b.this.mTitle) {
                    if (b.this.fSY == null) {
                        b.this.fSY = new com.baidu.tieba.enterForum.view.a(b.this.mContext);
                        b.this.fSY.setOnDismissListener(b.this.mOnDismissListener);
                        b.this.fSY.a(b.this.fTb);
                        b.this.fSY.rS(b.this.mStatusBarHeight);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new k(b.this.mContext.getString(R.string.level_sort), 1));
                    arrayList.add(new k(b.this.mContext.getString(R.string.update_sort), 2));
                    b.this.fSY.setData(arrayList, b.this.mSortType);
                    b.this.fSY.R(b.this.mTitle);
                }
                b.this.fTa = true;
                b.this.kC(b.this.fTa);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.fTa = false;
            b.this.kC(b.this.fTa);
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
        void rE(int i);
    }

    public b(Context context, int i, int i2, f fVar) {
        this.mContext = context;
        this.mSortType = i;
        this.mStatusBarHeight = i2;
        this.fQO = fVar;
    }

    public void e(TextView textView) {
        this.mTitle = textView;
    }

    public void yA() {
        if (this.fSY != null) {
            this.fSY.yA();
        }
    }

    public void bwO() {
        if (bwP() && this.mTitle != null) {
            switch (this.mSortType) {
                case 1:
                    this.mTitle.setText(R.string.level_sort);
                    break;
                case 2:
                    this.mTitle.setText(R.string.update_sort);
                    break;
            }
            this.mTitle.setOnClickListener(this.dbS);
            kC(this.fTa);
        }
    }

    public boolean bwP() {
        return this.mSortType == 1 || this.mSortType == 2;
    }

    public void setSortType(int i) {
        if (bwP()) {
            this.mSortType = i;
            bwO();
        }
    }

    public void a(a aVar) {
        this.fSZ = aVar;
    }

    public void onChangeSkinType(int i) {
        if (bwP()) {
            am.setViewTextColor(this.mTitle, R.color.cp_cont_b, i);
            if (this.mTitle != null) {
                kC(this.fTa);
            }
        }
        if (this.fSY != null && this.fTa) {
            this.fSY.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kC(boolean z) {
        int i = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
        com.baidu.tieba.enterForum.data.b byk = this.fQO != null ? this.fQO.byk() : null;
        if (byk != null && byk.fRw) {
            if (this.fQO != null && this.fQO.isShow()) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aEp().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                return;
            }
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
            this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aEp().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            return;
        }
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
        this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aEp().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }
}
