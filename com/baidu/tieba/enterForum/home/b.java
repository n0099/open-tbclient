package com.baidu.tieba.enterForum.home;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.h;
import com.baidu.tieba.enterForum.view.a;
import com.baidu.tieba.enterForum.view.f;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class b {
    private f ibN;
    private com.baidu.tieba.enterForum.view.a ieh;
    private a iei;
    private Context mContext;
    private int mSortType;
    private int mStatusBarHeight;
    private TextView mTitle;
    private boolean iej = false;
    private a.InterfaceC0702a iek = new a.InterfaceC0702a() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.view.a.InterfaceC0702a
        public void onItemClick(int i) {
            b.this.mSortType = i;
            TiebaStatic.log(new aq("c13369").aj("obj_type", i == 1 ? 2 : 1));
            b.this.cpC();
            if (b.this.iei != null) {
                b.this.iei.xr(b.this.mSortType);
            }
        }
    };
    private View.OnClickListener eOs = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.ibN.cre()) {
                if (view == b.this.mTitle) {
                    if (b.this.ieh == null) {
                        b.this.ieh = new com.baidu.tieba.enterForum.view.a(b.this.mContext);
                        b.this.ieh.setOnDismissListener(b.this.mOnDismissListener);
                        b.this.ieh.a(b.this.iek);
                        b.this.ieh.xK(b.this.mStatusBarHeight);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new h(b.this.mContext.getString(R.string.level_sort), 1));
                    arrayList.add(new h(b.this.mContext.getString(R.string.update_sort), 2));
                    b.this.ieh.setData(arrayList, b.this.mSortType);
                    b.this.ieh.O(b.this.mTitle);
                }
                b.this.iej = true;
                b.this.oG(b.this.iej);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.iej = false;
            b.this.oG(b.this.iej);
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void xr(int i);
    }

    public b(Context context, int i, int i2, f fVar) {
        this.mContext = context;
        this.mSortType = i;
        this.mStatusBarHeight = i2;
        this.ibN = fVar;
    }

    public void g(TextView textView) {
        this.mTitle = textView;
    }

    public void RE() {
        if (this.ieh != null) {
            this.ieh.RE();
        }
    }

    public void cpC() {
        if (cpD() && this.mTitle != null) {
            switch (this.mSortType) {
                case 1:
                    this.mTitle.setText(R.string.level_sort);
                    break;
                case 2:
                    this.mTitle.setText(R.string.update_sort);
                    break;
            }
            this.mTitle.setOnClickListener(this.eOs);
            oG(this.iej);
        }
    }

    public boolean cpD() {
        return this.mSortType == 1 || this.mSortType == 2;
    }

    public void setSortType(int i) {
        if (cpD()) {
            this.mSortType = i;
            cpC();
        }
    }

    public void a(a aVar) {
        this.iei = aVar;
    }

    public void onChangeSkinType(int i) {
        if (cpD()) {
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_b, i);
            if (this.mTitle != null) {
                oG(this.iej);
            }
        }
        if (this.ieh != null && this.iej) {
            this.ieh.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oG(boolean z) {
        int i = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
        com.baidu.tieba.enterForum.data.c crk = this.ibN != null ? this.ibN.crk() : null;
        if (crk != null && crk.ict) {
            if (this.ibN != null && this.ibN.isShow()) {
                ap.setViewTextColor(this.mTitle, R.color.cp_cont_j);
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.boN().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                return;
            }
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_j);
            this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.boN().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            return;
        }
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_j);
        this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.boN().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }
}
