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
    private f ihO;
    private com.baidu.tieba.enterForum.view.a ike;
    private a ikf;
    private Context mContext;
    private int mSortType;
    private int mStatusBarHeight;
    private TextView mTitle;
    private boolean ikg = false;
    private a.InterfaceC0716a ikh = new a.InterfaceC0716a() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.view.a.InterfaceC0716a
        public void onItemClick(int i) {
            b.this.mSortType = i;
            TiebaStatic.log(new aq("c13369").al("obj_type", i == 1 ? 2 : 1));
            b.this.csd();
            if (b.this.ikf != null) {
                b.this.ikf.xE(b.this.mSortType);
            }
        }
    };
    private View.OnClickListener eUh = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.ihO.ctF()) {
                if (view == b.this.mTitle) {
                    if (b.this.ike == null) {
                        b.this.ike = new com.baidu.tieba.enterForum.view.a(b.this.mContext);
                        b.this.ike.setOnDismissListener(b.this.mOnDismissListener);
                        b.this.ike.a(b.this.ikh);
                        b.this.ike.xX(b.this.mStatusBarHeight);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new h(b.this.mContext.getString(R.string.level_sort), 1));
                    arrayList.add(new h(b.this.mContext.getString(R.string.update_sort), 2));
                    b.this.ike.setData(arrayList, b.this.mSortType);
                    b.this.ike.O(b.this.mTitle);
                }
                b.this.ikg = true;
                b.this.oP(b.this.ikg);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.ikg = false;
            b.this.oP(b.this.ikg);
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void xE(int i);
    }

    public b(Context context, int i, int i2, f fVar) {
        this.mContext = context;
        this.mSortType = i;
        this.mStatusBarHeight = i2;
        this.ihO = fVar;
    }

    public void k(TextView textView) {
        this.mTitle = textView;
    }

    public void Um() {
        if (this.ike != null) {
            this.ike.Um();
        }
    }

    public void csd() {
        if (cse() && this.mTitle != null) {
            switch (this.mSortType) {
                case 1:
                    this.mTitle.setText(R.string.level_sort);
                    break;
                case 2:
                    this.mTitle.setText(R.string.update_sort);
                    break;
            }
            this.mTitle.setOnClickListener(this.eUh);
            oP(this.ikg);
        }
    }

    public boolean cse() {
        return this.mSortType == 1 || this.mSortType == 2;
    }

    public void setSortType(int i) {
        if (cse()) {
            this.mSortType = i;
            csd();
        }
    }

    public void a(a aVar) {
        this.ikf = aVar;
    }

    public void onChangeSkinType(int i) {
        if (cse()) {
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_b, i);
            if (this.mTitle != null) {
                oP(this.ikg);
            }
        }
        if (this.ike != null && this.ikg) {
            this.ike.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oP(boolean z) {
        int i = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
        com.baidu.tieba.enterForum.data.c ctL = this.ihO != null ? this.ihO.ctL() : null;
        if (ctL != null && ctL.iiu) {
            if (this.ihO != null && this.ihO.isShow()) {
                ap.setViewTextColor(this.mTitle, R.color.cp_cont_j);
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.brn().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                return;
            }
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_j);
            this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.brn().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            return;
        }
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_j);
        this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.brn().a(i, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }
}
