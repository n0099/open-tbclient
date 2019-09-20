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
    private f eXc;
    private com.baidu.tieba.enterForum.view.a eZr;
    private a eZs;
    private Context mContext;
    private int mSortType;
    private int mStatusBarHeight;
    private TextView mTitle;
    private boolean eZt = false;
    private a.InterfaceC0313a eZu = new a.InterfaceC0313a() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.view.a.InterfaceC0313a
        public void mG(int i) {
            b.this.mSortType = i;
            TiebaStatic.log(new an("c13369").P("obj_type", i == 1 ? 2 : 1));
            b.this.bgA();
            if (b.this.eZs != null) {
                b.this.eZs.qy(b.this.mSortType);
            }
        }
    };
    private View.OnClickListener caG = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.eXc.bhR()) {
                if (view == b.this.mTitle) {
                    if (b.this.eZr == null) {
                        b.this.eZr = new com.baidu.tieba.enterForum.view.a(b.this.mContext);
                        b.this.eZr.setOnDismissListener(b.this.mOnDismissListener);
                        b.this.eZr.a(b.this.eZu);
                        b.this.eZr.qM(b.this.mStatusBarHeight);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new k(b.this.mContext.getString(R.string.level_sort), 1));
                    arrayList.add(new k(b.this.mContext.getString(R.string.update_sort), 2));
                    b.this.eZr.setData(arrayList, b.this.mSortType);
                    b.this.eZr.bo(b.this.mTitle);
                }
                b.this.eZt = true;
                b.this.jq(b.this.eZt);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.eZt = false;
            b.this.jq(b.this.eZt);
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void qy(int i);
    }

    public b(Context context, int i, int i2, f fVar) {
        this.mContext = context;
        this.mSortType = i;
        this.mStatusBarHeight = i2;
        this.eXc = fVar;
    }

    public void h(TextView textView) {
        this.mTitle = textView;
    }

    public void bgA() {
        if (bgB() && this.mTitle != null) {
            switch (this.mSortType) {
                case 1:
                    this.mTitle.setText(R.string.level_sort);
                    break;
                case 2:
                    this.mTitle.setText(R.string.update_sort);
                    break;
            }
            this.mTitle.setOnClickListener(this.caG);
            jq(this.eZt);
        }
    }

    public boolean bgB() {
        return this.mSortType == 1 || this.mSortType == 2;
    }

    public void setSortType(int i) {
        if (bgB()) {
            this.mSortType = i;
            bgA();
        }
    }

    public void a(a aVar) {
        this.eZs = aVar;
    }

    public void onChangeSkinType(int i) {
        if (bgB()) {
            am.f(this.mTitle, R.color.cp_cont_b, i);
            if (this.mTitle != null) {
                jq(this.eZt);
            }
        }
        if (this.eZr != null && this.eZt) {
            this.eZr.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jq(boolean z) {
        int i = z ? R.drawable.icon_pure_list_arrow12_up_n_svg : R.drawable.icon_pure_list_arrow12_down_n_svg;
        com.baidu.tieba.enterForum.data.b bhX = this.eXc != null ? this.eXc.bhX() : null;
        if (bhX != null && bhX.eXL) {
            if (this.eXc != null && this.eXc.isShow()) {
                am.j(this.mTitle, R.color.cp_cont_j);
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.ajv().a(i, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                return;
            }
            am.j(this.mTitle, R.color.cp_cont_j);
            this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.ajv().a(i, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            return;
        }
        am.j(this.mTitle, R.color.cp_cont_j);
        this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.ajv().a(i, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }
}
