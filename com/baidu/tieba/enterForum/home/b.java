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
    private f gNF;
    private com.baidu.tieba.enterForum.view.a gPX;
    private a gPY;
    private Context mContext;
    private int mSortType;
    private int mStatusBarHeight;
    private TextView mTitle;
    private boolean gPZ = false;
    private a.InterfaceC0603a gQa = new a.InterfaceC0603a() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.view.a.InterfaceC0603a
        public void onItemClick(int i) {
            b.this.mSortType = i;
            TiebaStatic.log(new an("c13369").ag("obj_type", i == 1 ? 2 : 1));
            b.this.bOT();
            if (b.this.gPY != null) {
                b.this.gPY.sJ(b.this.mSortType);
            }
        }
    };
    private View.OnClickListener dUl = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.gNF.bQz()) {
                if (view == b.this.mTitle) {
                    if (b.this.gPX == null) {
                        b.this.gPX = new com.baidu.tieba.enterForum.view.a(b.this.mContext);
                        b.this.gPX.setOnDismissListener(b.this.mOnDismissListener);
                        b.this.gPX.a(b.this.gQa);
                        b.this.gPX.tc(b.this.mStatusBarHeight);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new n(b.this.mContext.getString(R.string.level_sort), 1));
                    arrayList.add(new n(b.this.mContext.getString(R.string.update_sort), 2));
                    b.this.gPX.setData(arrayList, b.this.mSortType);
                    b.this.gPX.S(b.this.mTitle);
                }
                b.this.gPZ = true;
                b.this.mh(b.this.gPZ);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.gPZ = false;
            b.this.mh(b.this.gPZ);
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void sJ(int i);
    }

    public b(Context context, int i, int i2, f fVar) {
        this.mContext = context;
        this.mSortType = i;
        this.mStatusBarHeight = i2;
        this.gNF = fVar;
    }

    public void f(TextView textView) {
        this.mTitle = textView;
    }

    public void HQ() {
        if (this.gPX != null) {
            this.gPX.HQ();
        }
    }

    public void bOT() {
        if (bOU() && this.mTitle != null) {
            switch (this.mSortType) {
                case 1:
                    this.mTitle.setText(R.string.level_sort);
                    break;
                case 2:
                    this.mTitle.setText(R.string.update_sort);
                    break;
            }
            this.mTitle.setOnClickListener(this.dUl);
            mh(this.gPZ);
        }
    }

    public boolean bOU() {
        return this.mSortType == 1 || this.mSortType == 2;
    }

    public void setSortType(int i) {
        if (bOU()) {
            this.mSortType = i;
            bOT();
        }
    }

    public void a(a aVar) {
        this.gPY = aVar;
    }

    public void onChangeSkinType(int i) {
        if (bOU()) {
            am.setViewTextColor(this.mTitle, R.color.cp_cont_b, i);
            if (this.mTitle != null) {
                mh(this.gPZ);
            }
        }
        if (this.gPX != null && this.gPZ) {
            this.gPX.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mh(boolean z) {
        int i = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
        com.baidu.tieba.enterForum.data.d bQF = this.gNF != null ? this.gNF.bQF() : null;
        if (bQF != null && bQF.gOu) {
            if (this.gNF != null && this.gNF.isShow()) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aUV().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                return;
            }
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
            this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aUV().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            return;
        }
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_j);
        this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aUV().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }
}
