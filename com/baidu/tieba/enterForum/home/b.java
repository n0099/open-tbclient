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
    private f itx;
    private com.baidu.tieba.enterForum.view.a ivN;
    private a ivO;
    private Context mContext;
    private int mSortType;
    private int mStatusBarHeight;
    private TextView mTitle;
    private boolean ivP = false;
    private a.InterfaceC0733a ivQ = new a.InterfaceC0733a() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.view.a.InterfaceC0733a
        public void onItemClick(int i) {
            b.this.mSortType = i;
            TiebaStatic.log(new ar("c13369").al("obj_type", i == 1 ? 2 : 1));
            b.this.cvW();
            if (b.this.ivO != null) {
                b.this.ivO.yH(b.this.mSortType);
            }
        }
    };
    private View.OnClickListener faK = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.itx.cxy()) {
                if (view == b.this.mTitle) {
                    if (b.this.ivN == null) {
                        b.this.ivN = new com.baidu.tieba.enterForum.view.a(b.this.mContext);
                        b.this.ivN.setOnDismissListener(b.this.mOnDismissListener);
                        b.this.ivN.a(b.this.ivQ);
                        b.this.ivN.za(b.this.mStatusBarHeight);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new h(b.this.mContext.getString(R.string.level_sort), 1));
                    arrayList.add(new h(b.this.mContext.getString(R.string.update_sort), 2));
                    b.this.ivN.setData(arrayList, b.this.mSortType);
                    b.this.ivN.O(b.this.mTitle);
                }
                b.this.ivP = true;
                b.this.po(b.this.ivP);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.ivP = false;
            b.this.po(b.this.ivP);
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
        this.itx = fVar;
    }

    public void k(TextView textView) {
        this.mTitle = textView;
    }

    public void Wd() {
        if (this.ivN != null) {
            this.ivN.Wd();
        }
    }

    public void cvW() {
        if (cvX() && this.mTitle != null) {
            switch (this.mSortType) {
                case 1:
                    this.mTitle.setText(R.string.level_sort);
                    break;
                case 2:
                    this.mTitle.setText(R.string.update_sort);
                    break;
            }
            this.mTitle.setOnClickListener(this.faK);
            po(this.ivP);
        }
    }

    public boolean cvX() {
        return this.mSortType == 1 || this.mSortType == 2;
    }

    public void setSortType(int i) {
        if (cvX()) {
            this.mSortType = i;
            cvW();
        }
    }

    public void a(a aVar) {
        this.ivO = aVar;
    }

    public void onChangeSkinType(int i) {
        if (cvX()) {
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105, i);
            if (this.mTitle != null) {
                po(this.ivP);
            }
        }
        if (this.ivN != null && this.ivP) {
            this.ivN.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void po(boolean z) {
        int i = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
        com.baidu.tieba.enterForum.data.c cxE = this.itx != null ? this.itx.cxE() : null;
        if (cxE != null && cxE.iud) {
            if (this.itx != null && this.itx.isShow()) {
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
