package com.baidu.tieba.enterForum.home;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.h;
import com.baidu.tieba.enterForum.view.a;
import com.baidu.tieba.enterForum.view.f;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class b {
    private f itv;
    private com.baidu.tieba.enterForum.view.a ivL;
    private a ivM;
    private Context mContext;
    private int mSortType;
    private int mStatusBarHeight;
    private TextView mTitle;
    private boolean ivN = false;
    private a.InterfaceC0733a ivO = new a.InterfaceC0733a() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.view.a.InterfaceC0733a
        public void onItemClick(int i) {
            b.this.mSortType = i;
            TiebaStatic.log(new ar("c13369").al("obj_type", i == 1 ? 2 : 1));
            b.this.cvV();
            if (b.this.ivM != null) {
                b.this.ivM.yH(b.this.mSortType);
            }
        }
    };
    private View.OnClickListener faK = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.itv.cxx()) {
                if (view == b.this.mTitle) {
                    if (b.this.ivL == null) {
                        b.this.ivL = new com.baidu.tieba.enterForum.view.a(b.this.mContext);
                        b.this.ivL.setOnDismissListener(b.this.mOnDismissListener);
                        b.this.ivL.a(b.this.ivO);
                        b.this.ivL.za(b.this.mStatusBarHeight);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new h(b.this.mContext.getString(R.string.level_sort), 1));
                    arrayList.add(new h(b.this.mContext.getString(R.string.update_sort), 2));
                    b.this.ivL.setData(arrayList, b.this.mSortType);
                    b.this.ivL.O(b.this.mTitle);
                }
                b.this.ivN = true;
                b.this.po(b.this.ivN);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.ivN = false;
            b.this.po(b.this.ivN);
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void yH(int i);
    }

    public b(Context context, int i, int i2, f fVar) {
        this.mContext = context;
        this.mSortType = i;
        this.mStatusBarHeight = i2;
        this.itv = fVar;
    }

    public void k(TextView textView) {
        this.mTitle = textView;
    }

    public void Wd() {
        if (this.ivL != null) {
            this.ivL.Wd();
        }
    }

    public void cvV() {
        if (cvW() && this.mTitle != null) {
            switch (this.mSortType) {
                case 1:
                    this.mTitle.setText(R.string.level_sort);
                    break;
                case 2:
                    this.mTitle.setText(R.string.update_sort);
                    break;
            }
            this.mTitle.setOnClickListener(this.faK);
            po(this.ivN);
        }
    }

    public boolean cvW() {
        return this.mSortType == 1 || this.mSortType == 2;
    }

    public void setSortType(int i) {
        if (cvW()) {
            this.mSortType = i;
            cvV();
        }
    }

    public void a(a aVar) {
        this.ivM = aVar;
    }

    public void onChangeSkinType(int i) {
        if (cvW()) {
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105, i);
            if (this.mTitle != null) {
                po(this.ivN);
            }
        }
        if (this.ivL != null && this.ivN) {
            this.ivL.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void po(boolean z) {
        int i = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
        com.baidu.tieba.enterForum.data.c cxD = this.itv != null ? this.itv.cxD() : null;
        if (cxD != null && cxD.iub) {
            if (this.itv != null && this.itv.isShow()) {
                ap.setViewTextColor(this.mTitle, R.color.CAM_X0107);
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.btW().a(i, R.color.CAM_X0108, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                return;
            }
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0107);
            this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.btW().a(i, R.color.CAM_X0108, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            return;
        }
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0107);
        this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.btW().a(i, R.color.CAM_X0108, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }
}
