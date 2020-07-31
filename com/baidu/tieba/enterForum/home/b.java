package com.baidu.tieba.enterForum.home;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.h;
import com.baidu.tieba.enterForum.view.a;
import com.baidu.tieba.enterForum.view.f;
import java.util.ArrayList;
/* loaded from: classes16.dex */
public class b {
    private f hgr;
    private com.baidu.tieba.enterForum.view.a hiB;
    private a hiC;
    private Context mContext;
    private int mSortType;
    private int mStatusBarHeight;
    private TextView mTitle;
    private boolean hiD = false;
    private a.InterfaceC0620a hiE = new a.InterfaceC0620a() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.view.a.InterfaceC0620a
        public void onItemClick(int i) {
            b.this.mSortType = i;
            TiebaStatic.log(new ap("c13369").ah("obj_type", i == 1 ? 2 : 1));
            b.this.bVq();
            if (b.this.hiC != null) {
                b.this.hiC.tE(b.this.mSortType);
            }
        }
    };
    private View.OnClickListener ehM = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.hgr.bWY()) {
                if (view == b.this.mTitle) {
                    if (b.this.hiB == null) {
                        b.this.hiB = new com.baidu.tieba.enterForum.view.a(b.this.mContext);
                        b.this.hiB.setOnDismissListener(b.this.mOnDismissListener);
                        b.this.hiB.a(b.this.hiE);
                        b.this.hiB.tX(b.this.mStatusBarHeight);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new h(b.this.mContext.getString(R.string.level_sort), 1));
                    arrayList.add(new h(b.this.mContext.getString(R.string.update_sort), 2));
                    b.this.hiB.setData(arrayList, b.this.mSortType);
                    b.this.hiB.O(b.this.mTitle);
                }
                b.this.hiD = true;
                b.this.mX(b.this.hiD);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.hiD = false;
            b.this.mX(b.this.hiD);
        }
    };

    /* loaded from: classes16.dex */
    public interface a {
        void tE(int i);
    }

    public b(Context context, int i, int i2, f fVar) {
        this.mContext = context;
        this.mSortType = i;
        this.mStatusBarHeight = i2;
        this.hgr = fVar;
    }

    public void h(TextView textView) {
        this.mTitle = textView;
    }

    public void Jj() {
        if (this.hiB != null) {
            this.hiB.Jj();
        }
    }

    public void bVq() {
        if (bVr() && this.mTitle != null) {
            switch (this.mSortType) {
                case 1:
                    this.mTitle.setText(R.string.level_sort);
                    break;
                case 2:
                    this.mTitle.setText(R.string.update_sort);
                    break;
            }
            this.mTitle.setOnClickListener(this.ehM);
            mX(this.hiD);
        }
    }

    public boolean bVr() {
        return this.mSortType == 1 || this.mSortType == 2;
    }

    public void setSortType(int i) {
        if (bVr()) {
            this.mSortType = i;
            bVq();
        }
    }

    public void a(a aVar) {
        this.hiC = aVar;
    }

    public void onChangeSkinType(int i) {
        if (bVr()) {
            ao.setViewTextColor(this.mTitle, R.color.cp_cont_b, i);
            if (this.mTitle != null) {
                mX(this.hiD);
            }
        }
        if (this.hiB != null && this.hiD) {
            this.hiB.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mX(boolean z) {
        int i = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
        com.baidu.tieba.enterForum.data.c bXe = this.hgr != null ? this.hgr.bXe() : null;
        if (bXe != null && bXe.hgX) {
            if (this.hgr != null && this.hgr.isShow()) {
                ao.setViewTextColor(this.mTitle, R.color.cp_cont_j);
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.baR().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                return;
            }
            ao.setViewTextColor(this.mTitle, R.color.cp_cont_j);
            this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.baR().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            return;
        }
        ao.setViewTextColor(this.mTitle, R.color.cp_cont_j);
        this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.baR().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }
}
